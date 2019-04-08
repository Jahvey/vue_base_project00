var designer = { view: {} };

designer.view.insertSetting = function (type, widget) {
    if (!designer.widgetSetting) return;
    var widgetHtml = designer.widgetSetting[type];
    if (!widgetHtml) return;
    var self = this;
    var node = document.createElement('div');
    node.innerHTML = widgetHtml;
    cb.loader.processNode(node, function () {
        var widgetConstructor = designer.settings[type];
        if (!widgetConstructor) return;
        if (type == 'district_popup') {
            var setting = new widgetConstructor('district_popup');
        } else {
            var setting = new widgetConstructor(widget);
        }
        setting.init(function (config) {
            if (setting.preprocess) {
                setting.preprocess($(node), config);
                $('.widgetconfig').html($(node).children('div')[0].outerHTML);
                if (type == 'district_popup') {
                    $('.widgetconfig').css({ 'position': 'inherit' });
                } else {
                    $('.widgetconfig').css({ 'position': 'absolute' });
                }
            } else {
                var html = self.render($(node).children('div')[0].outerHTML, config);
                $('.widgetconfig').html(html);
            }
            setting.afterInit();
        });
    });
};

designer.view.insertWidget = function (type, name, callback, toWidgetName, config) {
    if (!designer.widgetTpl) return;
    var widgetHtml = designer.widgetTpl[type];
    if (!widgetHtml) return;
    var $widget = $(widgetHtml);
    if($widget.attr('data-type')){
        var widgetType = $widget.attr('data-type');
    }else{
        var widgetType =$widget.children().attr('data-type');
    }
    if (!widgetType) return;
    var widgetConstructor = cb.widgets[widgetType];
    if (!widgetConstructor) return;
    if (type == 'CustomerService' || type == 'CustomerServiceChannel') {
        $widget.attr('data-name', type);
        $widget.attr('data-config', '');
        $widget.attr('id', name);
        this.getView().find('.page-content').append($widget);
    } else {
        var $row = $('<div class="row"></div>');
        var $col = $('<div class="col-100"></div>').appendTo($row);
        $widget.attr('data-name', name);
        $widget.attr('data-config', '');
        $widget.attr('id', name);
        $widget.appendTo($col);
        if (toWidgetName) {
            var toWidget = this.getWidget(toWidgetName);
            if (!toWidget) return;
            var $toWidgetContainer = toWidget.getElement().parents('.row');
            if(type=="platform_search"){
                if(this.getView().find('div[data-type="platform_search"]').length>0){
                    alert('已经有搜索挂件了，请不要重复添加');
                    return
                }
                $widget.insertAfter(this.getView().find('.left'));
            }else{
                $row.insertAfter($toWidgetContainer);
            }

        } else {
            this.getView().find('.page-content').append($row);
        }
    }
    config = config || {};
    config.designer = true;
    var widget = new widgetConstructor(name, config);
    widget._set_data('parent', this);
    widget.getElement().addClass('widgetHasLoaded');
    if (type == 'CustomerService') {
        this.getWidgets()['CustomerService'] = widget;
    } else if (type == 'CustomerServiceChannel') {
        this.getWidgets()['CustomerServiceChannel'] = widget;
    } else {
        this.getWidgets()[name] = widget;
    }
    if (config) {
        if (type == 'CustomerService'||type == 'CustomerServiceChannel') {
            this.updateWidget(type, config);
        }else {
            this.updateWidget(name, config);
        }
    }
    callback(widget);
};
designer.view.deleteWidget = function (name) {
    var widget = this.getWidget(name);
    if (!widget) return;
    if (name.indexOf('CustomerService_' > -1)) {
        widget.getElement().remove();
    } else {
        widget.getElement().parents('.row').remove();
    }
    delete this.getWidgets()[name];
};

designer.view.updateWidget = function (name, config) {
    var widget = this.getWidget(name);
    if (!widget) return;
    widget.rebuild(config);
};

designer.view.updownWidget = function (name, toWidgetName, type) {
    var widget = this.getWidget(name);
    var toWidget = this.getWidget(toWidgetName);
    if (!widget || !toWidget) return;
    var $widgetContainer = widget.getElement().parents('.row');
    var $toWidgetContainer = toWidget.getElement().parents('.row');
    if (type == "up") {
        $widgetContainer.insertBefore($toWidgetContainer);
    } else {
        $widgetContainer.insertAfter($toWidgetContainer);
    }

};


cb.util.extend(cb.views.BaseView.prototype, designer.view);

designer.settings = { configs: {} };
designer.settings.register = function (widgetType, func) {
    designer.settings[widgetType] = func(widgetType);
};
designer.settings.register('BaseSetting', function (widgetType) {
    var widget = function (instance) {
        var _data = { instance: instance };

        this._get_data = function (attr) {
            return _data[attr];
        };

        this._set_data = function (attr, val) {
            _data[attr] = val;
        };
    };
    widget.prototype.widgetType = widgetType;

    widget.prototype.getInstance = function () {
        return this._get_data('instance');
    };

    widget.prototype.runTemplate = function (config) {
        var instance = this.getInstance();
        if (instance.getId().indexOf('*') > -1) {
            var intanceId = instance.getId().substring(0, instance.getId().indexOf('*'));
        } else {
            var intanceId = instance.getId();
        }
        if (intanceId.indexOf('CustomerServiceChannel') > -1) {
            designer.settings.configs['CustomerServiceChannel'] = {
                $: { name: this.widgetType, type: this.widgetType },
                config: config
            };
        } else if (intanceId.indexOf('CustomerService') > -1) {
            designer.settings.configs['CustomerService'] = {
                $: { name: this.widgetType, type: this.widgetType },
                config: config
            };
        } else {
            designer.settings.configs[intanceId] = {
                $: { name: intanceId, type: this.widgetType },
                config: config
            };
        }

        var newConfig = this.transfer(config);
        instance.rebuild(newConfig);
    };

    widget.prototype.transfer = function (configs) {
        if (configs[0] && configs[0]['type'] == 'index_goods') { //商品列表
            var widgetDatas = [];
            configs.forEach(function (config) {
                var widgetData = { configs: {} };
                for (var i in config) {
                    if (Array.isArray(config[i])) {
                        config[i].forEach(function (conf) {
                            this.processConfig(conf, widgetData);
                        }, this);
                        widgetDatas.push(widgetData);
                    }
                }
            }, this);
            return widgetDatas;
        } else {  //未添加多页签之前的处理
            var widgetData = { configs: {} };
            configs.forEach(function (config) {
                this.processConfig(config, widgetData);
            }, this);
            return widgetData.configs;
        }
    };

    widget.prototype.processConfig = function (config, widgetData) {
        var configData = config.$;
        if (!configData || !configData.key) return;
        if (configData.value) {
            widgetData.configs[configData.key] = configData.value;
        } else {
            var text = config._;
            if (text) {
                widgetData.configs[configData.key] = text;
                return;
            }
            if (!config.item) {
                widgetData.configs[configData.key] = null;
            } else {
                widgetData.configs[configData.key] = [];
                config.item.forEach(function (item) {
                    this.processItem(item, widgetData.configs[configData.key]);
                }, this);
            }
        }
    };

    widget.prototype.processItem = function (item, configData) {
        var itemData = item.$;
        configData.push(itemData);
    };

    widget.prototype.render = function (tpl, data) {
        var tplStr = typeof tpl === 'string' ? tpl : tpl.html();
        var func = Template7.compile(tplStr);
        return func(data);
    };

    return widget;
});

designer.init = function () {
    var proxy = cb.rest.DynamicProxy.create({ getWidgetHtml: { url: '/csc-designer/client/getWidgetHtml', method: 'GET' } });
    proxy.getWidgetHtml(function (err, result) {
        designer.widgetTpl = result.widgetTpl;
        designer.widgetSetting = result.widgetSetting;
    });
}

window.designer = designer
