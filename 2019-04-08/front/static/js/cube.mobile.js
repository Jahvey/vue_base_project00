var cb = {};

cb.events = {};
cb.events.on = function (name, callback, context) {
    if (!name || !callback) return;
    this._events || (this._events = {});
    var events = this._events[name] || (this._events[name] = []);
    events.push({ callback: callback, context: context });
};
cb.events.un = function (name, callback) {
    if (!name || !this._events || !this._events[name]) return;
    if (!callback) {
        delete this._events[name];
    } else {
        var index = this._events[name].findIndex(function (value) {
            if (value.callback === callback)
                return true;
        });
        if (index !== -1)
            this._events[name].removeData(this._events[name][index]);
    }
};
cb.events.hasEvent = function (name) {
    if (!name) return;
    return this._events && this._events[name] && this._events[name].length;
};
cb.events.execute = function (name) {
    if (!name) return;
    var events = this._events ? this._events[name] : null;
    if (!events) return true;
    var result = true;
    var args = Array.prototype.slice.call(arguments, 1);
    events.forEach(function (event) {
        result = event.callback.apply(event.context || this, args) === false ? false : result;
    }, this);
    return result;
};
// 专为自定义API
cb.events.executes = function (name) {
    debugger
    if (!name) return;
    var events = this._events ? this._events[name] : null;
    if (!events) return true;
    var result = true;
    var args = Array.prototype.slice.call(arguments, 1);
    events.forEach(function (event) {
        result = event.callback.apply(event.context || this, args) === false ? false : result;
    }, this);
    return result;
};
cb.widgets = {};
cb.widgets.register = function (widgetType, func) {
    if (cb.widgets[widgetType]) {
        console.error('widgetType ' + widgetType + '已注册');
        return;
    }
    cb.widgets[widgetType] = func(widgetType);
};
cb.widgets.register('BaseWidget', function (widgetType) {
    var widget = function (id, options) {
        var _data = { id: id, elem: Dom7('#' + id), options: options };

        this._get_data = function (attr) {
            return _data[attr];
        };

        this._set_data = function (attr, val) {
            _data[attr] = val;
        };
    };
    widget.prototype.widgetType = widgetType;

    widget.prototype.getId = function () {
        return this._get_data('id');
    };

    widget.prototype.getElement = function () {
        return this._get_data('elem');
    };

    widget.prototype.getConfig = function () {
        return this._get_data('options');
    };

    widget.prototype.getParent = function () {
        return this._get_data('parent');
    };

    widget.prototype.getLazyLoadThreshold = function () {
        return 0;
    };

    widget.prototype.getProxyData = function () {
        return this.getConfig();
    };

    widget.prototype.getTemplate = function () {
        return this.getElement().find('script').html();
    };

    widget.prototype.render = function (data, escape) {
        var tpl = this.getTemplate();
        if (!tpl) return "";
        var tplStr = typeof tpl === 'string' ? tpl : tpl.html();
        if (escape === false)
            template.config('escape', false);
        var func = Template7.compile(tplStr);
        if (escape === false)
            template.config('escape', true);
        return func(data);
    };

    widget.prototype.rebuild = function (config) {
        if (config)
            this._set_data('options', config);
        if (!this.getProxy) {
            if (this.runTemplate)
                this.runTemplate();
            return;
        }
        var proxyConfig = this.getProxy();
        if (!proxyConfig) return;
        var data = this.getProxyData();
        var callback = null;
        if (this.runTemplate)
            callback = this.runTemplate;
        var proxy = cb.rest.DynamicProxy.create({ AutoRun: proxyConfig });
        proxy.AutoRun(data, callback, this);
    };

    return widget;
});

cb.views = {};
cb.views.register = function (controllerName, func) {
    cb.views[controllerName] = func(controllerName);
};
cb.views.register('BaseView', function (controllerName) {
    var view = function (widgets) {
        var _data = { widgets: widgets };

        this._get_data = function (attr) {
            return _data[attr];
        };

        this._set_data = function (attr, val) {
            _data[attr] = val;
        };
    };
    view.prototype.controllerName = controllerName;

    view.prototype.getView = function () {
        return this._get_data('view');
    };

    view.prototype.getWidgets = function () {
        return this._get_data('widgets');
    };

    view.prototype.getWidget = function (widgetName) {
        return this.getWidgets()[widgetName];
    };

    view.prototype.getViewData = function () {
        return this._get_data('viewData');
    };

    view.prototype.getQuery = function () {
        return this._get_data('query');
    };

    view.prototype.run = function (auto) {
        var widgets = this.getWidgets();
        var widget;
        var $elem;
        var getProxyDataFunc = this.getProxyData;
        var mergeProxy = cb.rest.MergeProxy.create();
        for (var widgetName in widgets) {
            widget = widgets[widgetName];
            $elem = widget.getElement();
            // if ($elem.hasClass('widgetHasLoaded') || (!cb.rest.AppContext.preview && !auto && !cb.util.isElementInViewport($elem[0], widget.getLazyLoadThreshold()))) continue;
            // $elem.addClass('widgetHasLoaded');
            if (!widget.getProxy) {
                if (widget.runTemplate)
                    widget.runTemplate();
                continue;
            }
            var proxy = widget.getProxy();
            if (!proxy) continue;
            var data = widget.getProxyData();
            if (getProxyDataFunc) {
                var viewProxyData = getProxyDataFunc.call(this, widgetName);
                if (viewProxyData) data = viewProxyData;
            }
            var callback = null;
            if (widget.runTemplate)
                callback = widget.runTemplate;
            mergeProxy.add(proxy, data, callback, widget);
        }
        var self = this;
        mergeProxy.submit(function () {
            self.execute('afterBatchSubmit');
        });
    };

    view.prototype.render = function (tpl, data, escape) {
        var tplStr = typeof tpl === 'string' ? tpl : tpl.html();
        if (escape === false)
            template.config('escape', false);
        var func = Template7.compile(tplStr);
        if (escape === false)
            template.config('escape', true);
        return func(data);
    };

    return view;
});

cb.init = function (content, callback) {
    //cb.util.getCacheVersion();
    if (!content) return;
    var node = document.createElement("div");
    node.innerHTML = content;
    var $page = Dom7(node).find('.page');
    if (!$page.length) return;
    var viewControllerTag = 'data-controller';
    var controllerName = $page.attr(viewControllerTag);
    if (!controllerName) return;
    cb.loader.processNode(node, function () {
        var controllerConstructor = cb.views[controllerName];
        if (!controllerConstructor) return;
        var widgets = {};
        var controller = new controllerConstructor(widgets);
        if (!callback || callback(controller, $page[0].outerHTML) === false) return;
        var idTag = 'id';
        var widgetNameTag = 'data-name';
        var widgetTypeTag = 'data-type';
        var widgetOptionsTag = 'data-config';
        if(controller.getView()){
            var elements = controller.getView().find('[' + widgetTypeTag + ']');
        if (Dom7("#toolbar")[0]) {
            elements = Array.prototype.slice.call(elements);
            elements.push(Dom7("#toolbar")[0])
        }
        var element, id, widgetName, widgetType, options, widget;
        for (var i = 0, len = elements.length; i < len; i++) {
            element = elements[i];
            id = element.getAttribute(idTag);
            widgetName = element.getAttribute(widgetNameTag);
            widgetType = element.getAttribute(widgetTypeTag);
            options = cb.data.JsonSerializer.deserialize(element.getAttribute(widgetOptionsTag));
            if(!options){
                options =element.getAttribute(widgetOptionsTag);
            }
            if (!id) {
                id = cb.util.getNewId(widgetName);
                element.setAttribute(idTag, id);
            }
            var widgetConstructor = cb.widgets[widgetType];
            if (!widgetConstructor) continue;
            widget = new widgetConstructor(id, options, controller);
            widget._set_data('parent', controller);
            widgets[widgetName] = widget;
        }
        if (controller.once)
            controller.once();
        cb.executeController(controller);
        }
        
    });
};

cb.executeController = function (controller) {
    controller.run();
    if (controller.init)
        controller.init();
};

cb.rest = {};
cb.rest.loadImage = function (el, src) {
    el = Dom7(el);
    src = cb.util.adjustImgSrc(src);
    var ts = new Date().valueOf();
    if (src.indexOf('?') < 0) {
        src += '?_=' + ts;
    } else {
        src += '&_=' + ts;
    }
    function onLoad() {
        el.attr('src', src);
    }
    var image = new Image();
    image.onload = onLoad;
    image.onerror = onLoad;
    image.src = src;
};
cb.rest.ContextBuilder = {
    construct: function (callback, isAndroid, isIos) {
        var queryString = new cb.util.queryString();
        var serviceUrl = cb.config && cb.config.webDomain ? cb.config.webDomain : location.protocol + '//' + location.host;
        cb.rest.AppContext = {
            serviceUrl: serviceUrl,
            size: 'M',
            device: isAndroid ? 'android' : (isIos ? 'ios' : ''),
            //liw 增加pageId
            orgPageId:queryString.query.orgPageId
        };
        if (cb.config) {
            if (cb.config.webDomain) {
                cb.rest.AppContext.ImageServer = cb.config.webDomain;
            } else if (cb.config.fromWechat) {
                cb.rest.AppContext.wid = queryString.get('wid');
                cb.rest.AppContext.oid = cb.data.CookieParser.getCookie('oid') || '';
                cb.rest.AppContext.shareparentid = queryString.get('shareparentid');
            }
        } else {
            if (queryString.get('preview') === 'true')
                cb.rest.AppContext.preview = true;
            if (queryString.has('corpalias'))
                cb.rest.AppContext.corpAlias = queryString.get('corpalias');
            var inviteCode = queryString.get('invitecode');
            var promotCode = queryString.get('promotcode');
            if (!inviteCode && !promotCode) {
                inviteCode = cb.util.localStorage.getItem('inviteCode');
                if (inviteCode)
                    cb.rest.AppContext.inviteCode = inviteCode;
                promotCode = cb.util.localStorage.getItem('promotCode');
                if (promotCode)
                    cb.rest.AppContext.promotCode = promotCode;
            } else {
                cb.util.localStorage.removeItem('inviteCode');
                cb.util.localStorage.removeItem('promotCode');
                if (inviteCode) {
                    cb.util.localStorage.setItem('inviteCode', inviteCode);
                    cb.rest.AppContext.inviteCode = inviteCode;
                }
                if (promotCode) {
                    cb.util.localStorage.setItem('promotCode', promotCode);
                    cb.rest.AppContext.promotCode = promotCode;
                }
            }
        }
        cb.rest.AppContext.token = this.getToken();
        callback();
        return;
        var proxy = cb.rest.DynamicProxy.create({ getConfig: { url: 'client/getWebServerConfig', method: 'GET' } });
        proxy.getConfig(function (err, result) {
            if (result) {
                for (var attr in result) {
                    cb.rest.AppContext[attr] = result[attr];
                }
            }
            if (cb.config && cb.config.webDomain && !cb.rest.AppContext.ImageServer)
                cb.rest.AppContext.ImageServer = cb.config.webDomain;
            callback();
        });
    },
    setToken: function (value) {
        if (cb.config && cb.config.fromWechat) {
            cb.data.CookieParser.setCookie('token', value);
            return;
        }
        localStorage.setItem('token', value);
    },
    getToken: function () {
        if (cb.config && cb.config.fromWechat)
            return cb.data.CookieParser.getCookie('token') ? cb.data.CookieParser.getCookie('token') : cb.data.CookieParser.getCookie('fanstoken') ? cb.data.CookieParser.getCookie('fanstoken') : '';
        return localStorage.getItem('token') || '';
    },
    removeToken: function () {
        if (cb.config && cb.config.fromWechat) {
            cb.data.CookieParser.delCookie('token');
            return;
        }
        localStorage.removeItem('token');
    }
};
cb.rest._getUrl = function (restUrl, params) {
    var context = cb.rest.AppContext;
    var token = cb.rest.ContextBuilder.getToken();
    var queryString = new cb.util.queryString(restUrl);
    queryString.set('size', context.size);
    if (cb.config && cb.config.fromWechat) {
        queryString.set('terminaltype', 'WeChat');
        queryString.set('wid', context.wid);
        queryString.set('oid', context.oid);
        if (context.shareparentid)
            queryString.set('shareparentid', context.shareparentid);
    } else {
        queryString.set('terminaltype', 'Mobile');
    }
    if (params && params.refresh)
        queryString.set('_', new Date().valueOf());
    // if (params && params.token)
    queryString.set('token', token);
    if (context.preview)
        queryString.set('preview', context.preview);
    if (context.corpAlias)
        queryString.set('corpalias', context.corpAlias);
    // 区域AREAID处理
    var areaid = cb.util.localStorage.getItem("areaid");
    if (areaid && areaid !== "undefined" && typeof (areaid) != "undefined" && areaid !== null && areaid !== "null") {
        queryString.set('AREAID', areaid);
    }
    restUrl = queryString.pathname + queryString.toStr();
    if (restUrl.indexOf('http://') < 0) {
        if (restUrl.substr(0, 1) !== '/')
            restUrl = '/' + restUrl;
        restUrl = context.serviceUrl + restUrl;
    }
    return restUrl;
};
cb.rest._appendUrl = function (restUrl, params) {
    if (!params) return restUrl;
    var queryStr = [];
    for (var attr in params) {
        queryStr.push(attr + '=' + params[attr]);
    }
    if (!queryStr.length) return restUrl;
    var queryString = queryStr.join('&');
    return restUrl.indexOf('?') >= 0 ? (restUrl + '&' + queryString) : (restUrl + '?' + queryString);
};
cb.rest.DynamicProxy = function (config) {
    if (this.init)
        this.init(config);
};
cb.rest.DynamicProxy.create = function (config) {
    return new cb.rest.DynamicProxy(config);
};
cb.rest.DynamicProxy.prototype.init = function (config) {
    if (!config) return;
    this.config = config;
    for (var attr in this.config) {
        this[attr] = (function (attr) {
            return function (data, callback, context) {
                return this.Do(attr, data, callback, null, context);
            }
        })(attr);
        this[attr + 'Sync'] = (function (attr) {
            return function (data) {
                return this.Do(attr, data, null, false);
            }
        })(attr);
    }
};
cb.rest.DynamicProxy.prototype.Do = function (op, data, callback, async, context) {
    if (!this.config || !this.config[op] || !this.config[op].url) return;
    var config = this.config[op];
    var restUrl = config.url;
    var options = cb.util.extend({}, config.options);
    options.method = config.method || 'GET';
    if (typeof data === 'function') {
        options.callback = data;
        options.context = context || options.context || this;
    } else {
        options.params = data;
    }
    if (callback) {
        options.callback = callback;
        options.context = context || options.context || this;
    }
    if (async === false)
        options.async = false;
    return this.ajax(restUrl, options);
};
cb.rest.DynamicProxy.prototype.ajax = function (url, options) {
    return cb.rest.ajax(url, options);
};
cb.rest.MergeProxy = function () {
    var _request = { datas: [], events: [] };

    this.add = function (proxy, data, callback, context) {
        if (cb.util.isArray(proxy)) {
            var len = proxy.length;
            if (cb.util.isArray(data)) {
                if (data.length === len) {
                    for (var i = 0; i < len; i++) {
                        this.addInner(proxy[i], data[i], callback, context);
                    }
                }
            } else {
                for (var i = 0; i < len; i++) {
                    this.addInner(proxy[i], data, callback, context);
                };
            }
        } else {
            this.addInner(proxy, data, callback, context);
        }
    };

    this.addInner = function (proxy, data, callback, context) {
        var requestMethod = proxy.method.toLocaleUpperCase()
        var requestUrl = cb.rest._getUrl(proxy.url, proxy.options);
        var requestData;
        if (requestMethod === 'GET' || requestMethod === 'DELETE') {
            requestUrl = cb.rest._appendUrl(requestUrl, data);
            requestData = null;
        } else {
            requestData = data;
        }
        _request.datas.push({ requestUrl: requestUrl, requestMethod: requestMethod, requestData: requestData });
        _request.events.push({ callback: callback, context: context });
    };

    this.submit = function (callback) {
        if (!_request.datas.length) {
            if (callback) callback();
            return;
        }
        var proxy = cb.rest.DynamicProxy.create({ BatchSubmit: { url: '/csc-designer/client/batchSubmit', method: 'POST' } });
        proxy.BatchSubmit(_request.datas, function (err, result) {
            if (err) {
                alert('合并请求提交失败: ' + err);
                return;
            }
            var len = result && result.length;
            if (!len) return;
            for (var i = 0; i < len; i++) {
                var event = _request.events[i];
                if (!event) continue;
                cb.rest.AjaxRequestManager.processAjaxResult(result[i], event.callback, event.context);
            }
            if (callback) callback();
        });
    };
};
cb.rest.MergeProxy.create = function () {
    return new cb.rest.MergeProxy();
};
cb.rest.ajax = function (url, options) {
    options.url = url;
    return cb.rest.AjaxRequestManager.doRequest(options);
};
cb.rest.AjaxRequestManager = {
    _xhrs: [],
    doRequest: function (options) {
        var xhr = this.getXMLHttpRequest();
        if (!xhr) return;
        var method = options.method || 'GET';
        var url = cb.rest._getUrl(options.url, options);
        var queryJson = null;
        if (method.equalsIgnoreCase('get') || method.equalsIgnoreCase('delete'))
            url = cb.rest._appendUrl(url, options.params);
        else if (method.equalsIgnoreCase('post') || method.equalsIgnoreCase('put'))
            queryJson = cb.data.JsonSerializer.serialize(options.params);
        xhr.open(method, url, options.async === false ? false : true);
        xhr.setRequestHeader('Content-Type', 'application/json;charset=utf-8');
        xhr.send(queryJson);
        if (options.async === false) {
            return this.onreadystatechange(xhr, options);
        } else {
            xhr.onreadystatechange = function () {
                cb.rest.AjaxRequestManager.onreadystatechange(this, options);
            };
        }
        if (options.mask === true)
            cb.util.loadingControl.start();
    },
    onreadystatechange: function (xhr, options) {
        if (xhr.readyState !== 4) return;
        if (options.mask === true)
            cb.util.loadingControl.end();
        if (xhr.status === 200) {
            var ajaxResult = cb.data.JsonSerializer.deserialize(xhr.responseText);
            cb.rest.AjaxRequestManager.processAjaxResult(ajaxResult, options.callback, options.context, options);
        }
        xhr.isBusy = false;
    },
    getXMLHttpRequest: function () {
        var xhr;
        for (var i = 0, len = this._xhrs.length; i < len; i++) {
            if (!this._xhrs[i].isBusy) {
                xhr = this._xhrs[i];
                break;
            }
        }
        if (!xhr) {
            xhr = this.createXMLHttpRequest();
            this._xhrs.push(xhr);
        }
        xhr.isBusy = true;
        return xhr;
    },
    createXMLHttpRequest: function () {
        var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : (window.ActiveXObject ? new ActiveXObject('Microsoft.XMLHTTP') : null);
        return xhr;
    },
    processAjaxResult: function (ajaxResult, callback, context, options) {
        if (!ajaxResult || (!ajaxResult.code && !ajaxResult.msgEntity)) return;
        if (ajaxResult.code == 200) {
            if (callback)
                callback.call(context, null, ajaxResult.data);
        }else if(ajaxResult.msgEntity && ajaxResult.msgEntity.code && ajaxResult.msgEntity.code == 200){
            if (callback)
                callback.call(context, null, ajaxResult.msgEntity.data);
        } else {
            if (ajaxResult.code === 900 && options && options.token && options.autoLogin !== false) {
                cb.route.redirectLoginPage();
                return;
            }
            if (callback)
                callback.call(context, ajaxResult);
        }
    }
};

cb.data = {};
cb.data.JsonSerializer = {
    serialize: function (data) {
        if (!data) return null;
        if (window.JSON && JSON.stringify) {
            return JSON.stringify(data);
        } else {
            var type = typeof data;
            if (type === 'string' || type === 'number' || type === 'boolean') {
                return data;
            } else if (data.constructor === Array) {
                return this._innerSerialize(data);
            } else {
                return this._innerSerializeObj(data);
            }
        }
    },
    _innerSerializeObj: function (data) {
        var builder = [];
        for (var attr in data) {
            if (typeof data[attr] === 'function') continue;
            builder.push('"' + attr + '":' + this._innerSerialize(data[attr]));
        }
        return '{' + builder.join(',') + '}';
    },
    _innerSerialize: function (data) {
        if (cb.util.isEmpty(data)) return null;
        var type = typeof data;
        if (type === 'number' || type === 'boolean') {
            return data;
        } else if (data.constructor === Array) {
            var builder = [];
            data.forEach(function (item) {
                builder.push(this._innerSerialize(item));
            }, this);
            return '[' + builder.join(',') + ']';
        } else if (type === 'object') {
            return this._innerSerializeObj(data);
        } else {
            return '"' + data + '"';
        }
    },
    deserialize: function (data) {
        if (!data) return null;
        if (window.JSON && JSON.parse) {
            try{
                JSON.parse(data)
            }catch(e){
                return null;
            }
            return JSON.parse(data);
        } else {
            return eval('(' + data.replace(/\r\n/g, '') + ')');
        }

    }
};

cb.data.CookieParser = {
    setCookie: function (name, value, expireDays) {
        if (cb.config && cb.config.fromWechat) name = cb.rest.AppContext.wid + '_' + name;
        if (expireDays == null) expireDays = 30;
        var exp = new Date();
        exp.setTime(exp.getTime() + expireDays * 24 * 60 * 60 * 1000);
        document.cookie = name + '=' + escape(value) + ';expires=' + exp.toGMTString();
    },
    getCookie: function (name) {
        if (cb.config && cb.config.fromWechat) name = cb.rest.AppContext.wid + '_' + name;
        var arr, reg = new RegExp('(^|)' + name + '=([^;]*)(;|$)');
        if (arr = document.cookie.match(reg)) {
            return unescape(arr[2]);
        } else {
            return null;
        }
    },
    delCookie: function (name) {
        if (cb.config && cb.config.fromWechat) name = cb.rest.AppContext.wid + '_' + name;
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var val = this.getCookie(name);
        if (val != null) {
            document.cookie = name + '=' + val + ';expires=' + exp.toGMTString();
        }
    },
    delAllCookie: function () {
        var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
        if (keys) {
            for (var i = keys.length; i--;)
                document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString();
        }
    }
};

cb.util = {
    html2Escape: function (html) {
        return html.replace(/[<>&"]/g, function (c) { return { '<': '&lt;', '>': '&gt;', '&': '&amp;', '"': '&quot;' }[c]; });
    },
    isElementInViewport: function (el, threshold) {
        var width = window.innerWidth;
        var height = window.innerHeight;
        if (typeof width !== 'number') {
            if (document.compatMode === 'CSS1Compat') {
                width = document.documentElement.clientWidth;
                height = document.documentElement.clientHeight;
            } else {
                width = document.body.clientWidth;
                height = document.body.clientHeight;
            }
        }
        var rect = el.getBoundingClientRect();
        return (
            rect.top >= (0 - threshold) &&
            rect.left >= (0 - threshold) &&
            rect.top <= (height + threshold) &&
            rect.left <= (width + threshold)
        );
    },
    adjustImgSrc: function (src) {
        if (!src) return src;
        var newSrc = src.replace(/\\/g, '/');
        if (cb.rest.AppContext.ImageServer && newSrc.indexOf('http://') < 0) {
            if (newSrc.substr(0, 1) === '/') {
                newSrc = cb.rest.AppContext.ImageServer + newSrc;
            } else {
                newSrc = cb.rest.AppContext.ImageServer + '/' + newSrc;
            }
        }
        return newSrc;
    },
    formatDate: function (strDate, fmt) {
        if (!strDate) return strDate;
        if (!fmt) fmt = 'yyyy-MM-dd';
        strDate = strDate.split(" ");
        /*strDate = strDate[0].replace(/-/g, '/');*/
        var date = new Date(strDate);
        var o = {
            "M+": date.getMonth() + 1,
            "d+": date.getDate(),
            "h+": date.getHours(),
            "m+": date.getMinutes(),
            "s+": date.getSeconds(),
            "q+": Math.floor((date.getMonth() + 3) / 3),
            "S": date.getMilliseconds()
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    },
    queryString: function (url) {
        this.pathname = '';
        this.query = {};

        this.init = function () {
            if (!url) url = location.search;
            var index1 = url.indexOf('?');
            var index2 = url.indexOf('#');
            if (index1 >= 0) {
                this.pathname = url.substr(0, index1);
                url = index2 < 0 ? url.substr(index1 + 1) : url.substring(index1 + 1, index2);
                if (url.length > 0) {
                    url = url.replace(/\+/g, ' ');
                    var params = url.split('&');
                    for (var i = 0, len = params.length; i < len; i++) {
                        var param = params[i].split('=');
                        var key = decodeURIComponent(param[0]);
                        var value = (param.length == 2) ? decodeURIComponent(param[1]) : key;
                        this.query[key] = value;
                    }
                }
            } else {
                this.pathname = url;
            }
        };

        this.set = function (key, value) {
            this.query[key] = value;
        };

        this.get = function (key) {
            return this.query[key];
        };

        this.has = function (key) {
            return this.query[key] != null;
        };

        this.del = function (key) {
            delete this.query[key];
        };

        this.toStr = function () {
            var items = ['?'];
            for (var key in this.query) {
                items.push(encodeURIComponent(key));
                items.push('=');
                items.push(encodeURIComponent(this.query[key]));
                items.push('&');
            }
            if (items.length === 1) {
                return '';
            } else {
                items.removeAt(items.length - 1);
                return items.join('');
            }
        };

        this.init();
    },
    getUrlparams: function (url) {
        this.pathname = '';
        this.query = {};
        var index1 = url.indexOf('?');
        var index2 = url.indexOf('#');
        if (index1 >= 0) {
            this.pathname = url.substr(0, index1);
            url = index2 < 0 ? url.substr(index1 + 1) : url.substring(index1 + 1, index2);
            if (url.length > 0) {
                url = url.replace(/\+/g, ' ');
                var params = url.split('&');
                for (var i = 0, len = params.length; i < len; i++) {
                    var param = params[i].split('=');
                    var key = decodeURIComponent(param[0]);
                    var value = (param.length == 2) ? decodeURIComponent(param[1]) : key;
                    this.query[key] = value;
                }
            }
        } else {
            this.pathname = url;
        }
    },
    localStorage: {
        setItem: function (key, value) {
            if (cb.config && cb.config.fromWechat) {
                localStorage.setItem(cb.rest.AppContext.wid + '_' + key, value);
                return;
            }
            localStorage.setItem(key, value);
        },
        getItem: function (key) {
            if (cb.config && cb.config.fromWechat)
                return localStorage.getItem(cb.rest.AppContext.wid + '_' + key);
            return localStorage.getItem(key);
        },
        removeItem: function (key) {
            if (cb.config && cb.config.fromWechat) {
                localStorage.removeItem(cb.rest.AppContext.wid + '_' + key);
                return;
            }
            localStorage.removeItem(key);
        }
    },
    //extend(dest,src1,src2,src3...)
    //extend(boolean,dest,src1,src2,src3...)
    extend: function () {
        var src, copyIsArray, copy, name, options, clone,
            target = arguments[0] || {},
            i = 1,
            length = arguments.length,
            deep = false;

        // Handle a deep copy situation
        if (typeof target === "boolean") {
            deep = target;

            // skip the boolean and the target
            target = arguments[i] || {};
            i++;
        }

        // Handle case when target is a string or something (possible in deep copy)
        if (typeof target !== "object" && !cb.util.isFunction(target)) {
            target = {};
        }

        // extend cb.util itself if only one argument is passed
        if (i === length) {
            target = this;
            i--;
        }

        for (; i < length; i++) {
            // Only deal with non-null/undefined values
            if ((options = arguments[i]) != null) {
                // Extend the base object
                for (name in options) {
                    src = target[name];
                    copy = options[name];

                    // Prevent never-ending loop
                    if (target === copy) {
                        continue;
                    }

                    // Recurse if we're merging plain objects or arrays
                    if (deep && copy && (cb.util.isPlainObject(copy) || (copyIsArray = cb.util.isArray(copy)))) {
                        if (copyIsArray) {
                            copyIsArray = false;
                            clone = src && cb.util.isArray(src) ? src : [];

                        } else {
                            clone = src && cb.util.isPlainObject(src) ? src : {};
                        }

                        // Never move original objects, clone them
                        target[name] = cb.util.extend(deep, clone, copy);

                        // Don't bring in undefined values
                    } else if (copy !== undefined) {
                        target[name] = copy;
                    }
                }
            }
        }

        // Return the modified object
        return target;
    },

    // See test/unit/core.js for details concerning isFunction.
    // Since version 1.3, DOM methods and functions like alert
    // aren't supported. They return false on IE (#2968).
    isFunction: function (obj) {
        return cb.util.type(obj) === "function";
    },

    isArray: Array.isArray || function (obj) {
        return cb.util.type(obj) === "array";
    },

    isWindow: function (obj) {
        /* jshint eqeqeq: false */
        return obj != null && obj == obj.window;
    },

    isPlainObject: function (obj) {
        var key;

        // Must be an Object.
        // Because of IE, we also have to check the presence of the constructor property.
        // Make sure that DOM nodes and window objects don't pass through, as well
        if (!obj || cb.util.type(obj) !== "object" || obj.nodeType || cb.util.isWindow(obj)) {
            return false;
        }

        try {
            // Not own constructor property must be Object
            if (obj.constructor &&
                !hasOwn.call(obj, "constructor") &&
                !hasOwn.call(obj.constructor.prototype, "isPrototypeOf")) {
                return false;
            }
        } catch (e) {
            // IE8,9 Will throw exceptions on certain host objects #9897
            return false;
        }

        // Support: IE<9
        // Handle iteration over inherited properties before own properties.
        if (support.ownLast) {
            for (key in obj) {
                return hasOwn.call(obj, key);
            }
        }

        // Own properties are enumerated firstly, so to speed up,
        // if last one is own, then all properties are own.
        for (key in obj) { }

        return key === undefined || hasOwn.call(obj, key);
    },

    type: function (obj) {
        if (obj == null) {
            return obj + "";
        }
        return typeof obj === "object" || typeof obj === "function" ?
            class2type[toString.call(obj)] || "object" :
            typeof obj;
    },

    // args is for internal usage only
    each: function (obj, callback, args) {
        var value,
            i = 0,
            length = obj.length,
            isArray = isArraylike(obj);

        if (args) {
            if (isArray) {
                for (; i < length; i++) {
                    value = callback.apply(obj[i], args);

                    if (value === false) {
                        break;
                    }
                }
            } else {
                for (i in obj) {
                    value = callback.apply(obj[i], args);

                    if (value === false) {
                        break;
                    }
                }
            }

            // A special, fast, case for the most common use of each
        } else {
            if (isArray) {
                for (; i < length; i++) {
                    value = callback.call(obj[i], i, obj[i]);

                    if (value === false) {
                        break;
                    }
                }
            } else {
                for (i in obj) {
                    value = callback.call(obj[i], i, obj[i]);

                    if (value === false) {
                        break;
                    }
                }
            }
        }

        return obj;
    },
    // 时间倒计时 实现方法要根据时间格式而定，现在时间格式为 2016-08-31 16:32:34,intervalFlag是个全局变量，初始值为0，在定时器中每隔一秒加1
    countDownFunc: function (now, end, intervalFlag) {
        // 服务器当前时间处理
        var nowDateArr = now.split("-");
        var nowYear = nowDateArr[0];
        var nowMonth = nowDateArr[1];
        var nowDay = nowDateArr[2].substr(0, 2);
        var nowTimeArr = nowDateArr[2].substr(3).split(":");
        var nowHour = nowTimeArr[0];
        var nowMinute = nowTimeArr[1];
        var nowSecond = nowTimeArr[2].substr(0, 2);
        // 结束时间处理
        var endDateArr = end.split("-");
        var endYear = endDateArr[0];
        var endMonth = endDateArr[1];
        var endDay = endDateArr[2].substr(0, 2);
        var endTimeArr = endDateArr[2].substr(3).split(":");
        var endHour = endTimeArr[0];
        var endMinute = endTimeArr[1];
        var endSecond = endTimeArr[2].substr(0, 2);
        var nowDate = new Date(nowYear, nowMonth - 1, nowDay, nowHour, nowMinute, nowSecond);
        var endDate = new Date(endYear, endMonth - 1, endDay, endHour, endMinute, endSecond);
        var leftTime = endDate.getTime() - nowDate.getTime();
        var leftsecond = parseInt(leftTime / 1000) - intervalFlag;

        var day1 = Math.floor(leftsecond / (60 * 60 * 24));
        var hour = Math.floor((leftsecond - day1 * 24 * 60 * 60) / 3600);
        var minute = Math.floor((leftsecond - day1 * 24 * 60 * 60 - hour * 3600) / 60);
        var second = Math.floor(leftsecond - day1 * 24 * 60 * 60 - hour * 3600 - minute * 60);
        var resultBack = day1 + "天" + hour + "小时" + minute + "分" + second + "秒";
        return resultBack;
    },
    getNewId: function (prefix) {
        prefix = prefix || "newId";
        if (cb.cache.newIds) {
            var number = (cb.cache.newIds.get(prefix) || 0) + 1;
            cb.cache.newIds.set(prefix, number);
        }
        return prefix + "*" + number;
    },
    inputKeyboard: function (view, obj) {
        if (!view && !obj) return;
        var localScreenHeight = document.body.clientHeight;
        if (arguments.length == 1) {
            view.find('input').each(function () {
                var item = $$(this);
                $$(this).focus(function () {
                    var inputsetInterval = setInterval(function () {
                        var elementTop = item.offset().top;
                        if (elementTop >= document.body.clientHeight - 88) {
                            var moveHeight = elementTop - document.body.clientHeight + item.height();
                            if (view.hasClass('no-tabbar') || view.hasClass('no-toolbar'))
                                moveHeight += 120;

                            if (view.find('.page-content').children('.page-content-inner'))
                                view.find('.page-content').children('.page-content-inner').css({
                                    'transform': 'translateY(-' + moveHeight + 'px)',
                                    '-webkit-transform': 'translateY(-' + moveHeight + 'px)'
                                });
                        }

                        if (localScreenHeight == document.body.clientHeight) {
                            clearInterval(inputsetInterval);
                            $$(this).blur();
                        }
                    }, 500);
                }).blur(function () {
                    if (view.find('.page-content').children('.page-content-inner'))
                        setTimeout(function () {
                            view.find('.page-content').children('.page-content-inner').css({
                                'transform': 'translateY(0px)',
                                '-webkit-transform': 'translateY(0px)'
                            });
                        }, 500);
                });
            });
        }
        else {
            obj.focus(function () {
                var inputsetInterval = setInterval(function () {
                    var elementTop = obj.offset().top;
                    if (elementTop >= document.body.clientHeight) {
                        var moveHeight = elementTop - document.body.clientHeight + obj.height();
                        if (view.hasClass('no-tabbar') || view.hasClass('no-toolbar'))
                            moveHeight += 44;

                        if (view.find('.page-content').children('.page-content-inner'))
                            view.find('.page-content').children('.page-content-inner').css('transform', 'translateY(-' + moveHeight + 'px)');
                    }

                    if (localScreenHeight == document.body.clientHeight) {
                        clearInterval(inputsetInterval);
                        if (view.find('.page-content').children('.page-content-inner'))
                            view.find('.page-content').children('.page-content-inner').css('transform', 'translateY(0px)');
                    }
                }, 500);
            }).blur(function () {
                if (view.find('.page-content').children('.page-content-inner'))
                    view.find('.page-content').children('.page-content-inner').css('transform', 'translateY(0px)');
            });
        }
    },
    getCacheVersion: function () {
        if (cb.config && cb.config.umallVersion) {
            var serverVersion = cb.config.umallVersion;
            if (cb.data.CookieParser.getCookie('cacheVersion') !== serverVersion) {
                cb.data.CookieParser.setCookie('cacheVersion', serverVersion);
            }
            // if(cb.data.CookieParser.getCookie('cacheVersion') !==serverVersion){
            //     localStorage.clear();
            //     cb.data.CookieParser.delAllCookie();
            //     cb.util.localStorage.setItem('cacheVersion',serverVersion);
            // }
        }
    },
    // 更新浏览器title
    changeTitle: function (title, isGetAreaName) {
        if (isGetAreaName) {
            var proxy = cb.rest.DynamicProxy.create({ getAreaNameById: { url: 'client/Areas/getAreaById', method: 'GET' } });
            proxy.getAreaNameById({ areaId: title }, function (err, result) {
                if (result && result.name) {
                    var $body = $('body');
                    document.title = result.name;
                    var $iframe = $('<iframe src="/favicon.ico"></iframe>');
                    $iframe.on('load', function () {
                        setTimeout(function () {
                            $iframe.off('load').remove();
                        }, 0);
                    }).appendTo($body);
                }
            });
        } else {
            var $body = $('body');
            document.title = title;
            var $iframe = $('<iframe src="/favicon.ico"></iframe>');
            $iframe.on('load', function () {
                setTimeout(function () {
                    $iframe.off('load').remove();
                }, 0);
            }).appendTo($body);
        }
    }
};

var class2type = {};

// Populate the class2type map
cb.util.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function (i, name) {
    class2type["[object " + name + "]"] = name.toLowerCase();
});

function isArraylike(obj) {

    // Support: iOS 8.2 (not reproducible in simulator)
    // `in` check used to prevent JIT error (gh-2145)
    // hasOwn isn't used here due to false negatives
    // regarding Nodelist length in IE
    var length = "length" in obj && obj.length,
        type = cb.util.type(obj);

    if (type === "function" || cb.util.isWindow(obj)) {
        return false;
    }

    if (obj.nodeType === 1 && length) {
        return true;
    }

    return type === "array" || length === 0 ||
        typeof length === "number" && length > 0 && (length - 1) in obj;
}

String.prototype.equalsIgnoreCase = function (str) {
    if (str == null) return false;
    return this.toLowerCase() === str.toLowerCase();
};

Array.prototype.removeAt = function (index) {
    if (index >= 0)
        return this.splice(index, 1);
};
Array.prototype.unique = function (arr) {
    arr.sort();
    var re = [arr[0]];
    for (var i = 1; i < arr.length; i++) {
        if (arr[i] !== re[re.length - 1]) {
            re.push(arr[i]);
        }
    }
    return re;
};
Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};

cb.util.extend(cb.widgets.BaseWidget.prototype, cb.events);
cb.util.extend(cb.views.BaseView.prototype, cb.events);

cb.cache = {
    get: function (cacheName) { return this[cacheName]; },
    set: function (cacheName, value) { this[cacheName] = value; },
    clear: function () {
        for (var attr in this)
            if (attr != "get" && attr != "set" && attr != "clear")
                delete this[attr];
    }
};
cb.cache.newIds = { get: cb.cache.get, set: cb.cache.set, clear: cb.cache.clear };

cb.loader = {};
cb.loader.init = function () {
    this.loadedStyles = {};
    var links = document.getElementsByTagName("link");
    for (var i = 0, len = links.length; i < len; i++) {
        var lowerLinkHref = links[i].href.trim().toLocaleLowerCase();
        if (lowerLinkHref)
            this.loadedStyles[lowerLinkHref] = true;
    }
    this.loadedScripts = {};
    var scripts = document.getElementsByTagName("script");
    for (var i = 0, len = scripts.length; i < len; i++) {
        var lowerScriptSrc = scripts[i].src.trim().toLocaleLowerCase();
        if (lowerScriptSrc)
            this.loadedScripts[lowerScriptSrc] = true;
    }
};
cb.loader.init();
cb.loader.processNode = function (node, callback) {
    var links = node.getElementsByTagName('link');
    if (links.length) {
        var head = document.head || document.getElementsByTagName('head')[0];
        for (var i = 0, len = links.length; i < len; i++) {
            var href = links[i].href.trim();
            if (!href || this.loadedStyles[href.toLocaleLowerCase()]) continue;
            head.appendChild(links[i].cloneNode());
            this.loadedStyles[href.toLocaleLowerCase()] = true;
        }
    }
    var scripts = node.getElementsByTagName('script');
    var scriptUrls = [];
    for (var i = 0, len = scripts.length; i < len; i++) {
        var src = scripts[i].src.trim();
        if (!src || this.loadedScripts[src.toLocaleLowerCase()]) continue;
        scriptUrls.push(src);
    }
    if (scriptUrls.length) {
        var self = this;
        $script(scriptUrls, function () {
            scriptUrls.forEach(function (src) {
                self.loadedScripts[src.toLocaleLowerCase()] = true;
            });
            callback();
        });
    } else {
        callback();
    }
};

window.cb=cb
