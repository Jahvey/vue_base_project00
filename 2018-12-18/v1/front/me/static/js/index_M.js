// Determine theme depending on device
var isAndroid = Framework7.prototype.device.android === true;
var isIos = Framework7.prototype.device.ios === true;
var isFromeYL = false;
// Set Template7 global devices flags
Template7.global = {
    android: isAndroid,
    ios: isIos
};
Template7.registerHelper('adjustImgSrc', function (src) {
    return cb.util.adjustImgSrc(src);
});
Template7.registerHelper('formatDate', function (strDate, fmt) {
    return cb.util.formatDate(strDate, fmt);
});
// Define Dom7
var $$ = Dom7;

// Change Through navbar layout to Fixed
if (isAndroid) {
    // Change class
    $$('.view.navbar-through').removeClass('navbar-through').addClass('navbar-fixed');
    // And move Navbar into Page
    //$$('.view .navbar').prependTo('.view .page');
}

// Init App
var params = {
    pushStateSeparator: '#!',
    cacheIgnoreGetParameters: true,
    modalButtonOk: '确认',
    modalButtonCancel: '取消',
    preloadPreviousPage: false
};
if (!cb.config || cb.config.fromWechat){
    if(location.href.indexOf('linksource')>-1){
        params.pushState = false;
    }else{
        params.pushState = true;
    }
}
var myApp = new Framework7(params);

cb.util.loadingControl = {
    start: function () {
        myApp.showIndicator();
    },
    end: function () {
        myApp.hideIndicator();
    }
};

var init = function () {
	var viaScanQr = true; //通过扫一扫 进来默认是开启的
    var _loginViewControllerName = 'LoginViewController';
    var $view = $$('.login-screen.login').find('[data-controller=' + _loginViewControllerName + ']');
    // 微信登录页面
    if (cb.config && cb.config.fromWechat) {
        _loginViewControllerName = 'LoginWechatViewController';
    }
    // 微信登录页面
    if (cb.config && cb.config.fromWechat) {
        $view = $$('.login-screen.loginWechat').find('[data-controller=' + _loginViewControllerName + ']');
    }
    if (!$view.length) return;

    var welcomeScreenFunc = function () {
        var options = {
            'bgcolor': '#6fe1dc',
            'fontcolor': '#fff',
            closeButtonText: '跳过',
            'onClosed': function () {

            }
        },
            welcomescreen_slides,
            welcomescreen;

        welcomescreen_slides = [
            {
                picture: 'welcomescreen-picture1'
            },
            {
                picture: 'welcomescreen-picture2',
                text: '<span></span>'
            }
        ];
        welcomescreen = myApp.welcomescreen(welcomescreen_slides, options);
        window.localStorage.setItem("systemUsed", true);

        $$('.welcomescreen-container .welcomescreen-text').find('span').on('click', function () {
            welcomescreen.close();
        });
    };


    var processOtherPage = function (controller) {
        // var proxy= cb.rest.DynamicProxy.create({getHomePageSEOInfo : {url:'client/Products/getHomePageSEOInfo', method: 'POST' }});    	
        var $view = $$(myApp.mainView.pagesContainer).find('[data-controller=' + controller.controllerName + ']');
        if (!$view.length) return;
        var index = $view.length - 1;
        $view[index].controller = controller;
        controller._set_data('view', $$($view[index]));
        controller._set_data('viewData', $view[index].f7PageData);
        var viewData = controller.getViewData();
        controller._set_data('query', viewData.query);
        if (cb.config) {
            if (cb.config.webDomain) {
                controller.on('afterBatchSubmit', function () {
                    this.getView().find('a.external').click(function (e) {
                        e.preventDefault();
                        e.stopImmediatePropagation();
                        if (isAndroid)
                            window.outerWebView = clicked($$(this).attr('href'));
                    });
                });
            } else if (cb.config.fromWechat) {

            }
        }
        if (controller.controllerName === 'DetailViewController' || controller.controllerName === 'MyCollectionViewController' || controller.controllerName === 'ShopListController' || controller.controllerName === 'aftersaleViewController') {
            if (myApp.mainView.container.id != "homeView") {
                controller.on('enterShop', function (homeUrl) {
                    _viewIds = {};
                    $$('#homeView').trigger('show', homeUrl);
                });
            }

        }
    };

    var _viewIds = {};

    var addView = function (viewId, url, isToolbarChannel) {
        var viewSelector = '#' + viewId;
        var defaultOptions = {
            // Don't worry about that Material doesn't support it
            // F7 will just ignore it for Material theme
            //dynamicNavbar: true,
            preroute: function (view, options) {
                if (options && options.url && options.url.indexOf('channel/supplier_') > -1 && options.url.indexOf('?') == -1) {
                    cb.rest.AppContext.router = options.url.split('/')[1];
                }
                if (options && options.url === '#' && view.url.indexOf('channel/supplier_') > -1) {
                    cb.rest.AppContext.router = 'home';
                }
                if (!options || !options.url) return;
                var queryString = new cb.util.queryString(options.url);
                var pathName = queryString.pathname;
                // shop_id处理开始 如果进入店铺，将店铺shop_id放到url中
                if (pathName.indexOf("supplier") > -1) {
                    if (pathName.indexOf("_") > -1) {
                        var pathNameIndex = pathName.lastIndexOf("_");
                        var pathNameShopId = pathName.substr(pathNameIndex + 1);
                        if (pathNameShopId && !isNaN(pathNameShopId)) {
                            queryString.set('shop_id', parseInt(pathNameShopId));
                            cb.rest.AppContext.shop_id = parseInt(pathNameShopId);
                        }
                    }

                }
                // shop_id处理结束

                //处理频道页分享问题 ， 包括首页频道页的分享，供应商主页以及供应商的频道页的分享   start
                if (pathName.indexOf("channel") > -1) {
                    pathName = pathName.trim();
                    if (pathName.indexOf('/') == 0) {
                        pathName = pathName.substr(1);
                    }
                    queryString.set('channelPage', pathName);
                }
                if (pathName == 'home') {
                    cb.rest.AppContext.shop_id = '';
                    cb.rest.AppContext.router = 'home';
                }
                //处理频道页分享问题 ， 包括首页频道页的分享，供应商主页以及供应商的频道页的分享   end
                // 移动web非微信端，非app端免密登录处理
                if (cb.config && cb.config.fromWechat) {
                    var token = cb.data.CookieParser.getCookie('token');
                    if (token && typeof (token) != "undefined") {
                        cb.rest.AppContext.token = token;
                    }
                }
                // 移动web非微信端，非app端免密登录处理结束
                var context = cb.rest.AppContext;
                if (!context.router) {
                    context.router = 'home';
                }
                if (!context.shop_id) {
                    var shopid = "";
                } else {
                    var shopid = context.shop_id;
                }
                queryString.set('shop_id', shopid);
                queryString.set('size', context.size);
                queryString.set('device', context.device);
                queryString.set('token', context.token);
                //liw增加请求PageId
                queryString.set('orgPageId',context.orgPageId);
                queryString.set('token', context.token);

                if (!context.router) {
                    context.router = 'home';
                }
                queryString.set('router', context.router);
                if (context.preview)
                    queryString.set('preview', context.preview);
                queryString.set('view', view.container.id);
                var index = options.url.indexOf('?');
                options.url = index < 0 ? options.url : options.url.substr(0, index);
                if (cb.config) {
                    if (cb.config.webDomain) {
                        options.url = options.url.replace(cb.config.webDomain + '/', '');
                        if (options.url.substr(options.url.length - 5, 5) === '.html') {

                        } else if (cb.config.dynamicRoute.indexOf(options.url) === -1 && options.url.indexOf('channel') === -1) {
                            options.url = cb.config.filePath + '/' + options.url + '.html';
                        } else if (cb.config.dynamicRoute.indexOf('channel') === -1) {
                            options.url = cb.config.filePath + '/' + options.url + '.html';
                        } else {
                            options.url = cb.config.webDomain + '/' + options.url;
                            queryString.set('package', true);
                        }
                    } else if (cb.config.fromWechat) {
                        queryString.set('wid', context.wid);
                    }
                }
                if (!(cb.config && cb.config.webDomain)) {
                    if (options.url.indexOf('/') !== 0){
                        options.url = '/' + options.url;
                    }
                }
                options.url += queryString.toStr();
            },
            preprocess: function (content, url, next) {
                cb.init(content, function (controller, pageHTML) {
                    if (controller.controllerName === "LoginViewController" || controller.controllerName === "LoginFromWechatViewController") {
                        next('');
                        myApp.removeFromCache(url.split('?')[0]);
                        cb.route.redirectLoginPage();
                        return false;
                    }
                    if (controller.controllerName === "FansRegisterPageControoller") {
                        next('');
                        myApp.removeFromCache(url.split('?')[0]);
                        cb.route.redirectFansePage();
                        return false;
                    }
                    if ((controller.controllerName === "HomeViewController" || controller.controllerName === "ChannelViewController") && !viaScanQr) {  //通过扫一扫区域站点 && 区域未开启 进入 区域页面的处理
                        next('');
                        myApp.mainView.router.reloadPage('areaNotFound');
                        $$('.homeNavBar').addClass('toolbar-hidden');
                        return false;
                    }
                    next(pageHTML);
                    if (url.indexOf('list?') > -1) {
                        $$('.homeNavBar').addClass('toolbar-hidden');
                    }
                    processOtherPage(controller);
                });
            }
        };
        // Init View
        var view = myApp.addView(viewSelector, defaultOptions);
        _viewIds[viewId] = view;
        setMainView(viewSelector, view);
        if (url) {
            if (url.indexOf('channel/') > -1) {
                view.router.loadPage({
                    url: url,
                    reload: true
                });
            } else if (url.indexOf('payment?') > -1 || url.indexOf('order?') > -1) {
                view.router.loadPage({
                    url: url,
                    reload: true
                });
                myApp.hideToolbar('.homeNavBar');
            } else {
                view.router.loadPage(url);
            }
        } else {
            view.router.reloadPage(view.url);
        }
    };

    var setMainView = function (viewSelector, view) {
        $$(viewSelector).parent().children().removeClass('view-main active');
        $$(viewSelector).addClass('view-main active');
        var toolbarItem = $$(viewSelector).parent().find('a[href="' + viewSelector + '"]');
        if (viewSelector == '#listView') {
            var listUrl = toolbarItem.find('.tabbar-label').data('list');
            view.url = listUrl;
        }
        if (viewSelector == '#channelView') {
            var channelUrl = $$(viewSelector).parent().children('.toolbar').find('a[href="#channelView"]').attr('data-url');
            $$(viewSelector).attr('data-url', channelUrl);
            view.url = channelUrl;
        }

        if (cb.config && !cb.config.fromWechat) {
            loadMenuFunc(viewSelector);
        } else {
            toolbarItem.parent().children().removeClass('active');
            toolbarItem.addClass('active');
        }
        view.main = true;
        myApp.mainView = view;
    };

    //检测设备网络状态
    $$(document).on('pageBeforeInit pageInit', function () {
        if (cb.config && !cb.config.fromWechat) {
            var netWork = plus.networkinfo.getCurrentType();
            if (netWork == plus.networkinfo.CONNECTION_UNKNOW || netWork == plus.networkinfo.CONNECTION_NONE)
                myApp.popup('.popup.popup-network');
        }
    });

    if (cb.config && !cb.config.fromWechat) {
        $$('.popup.popup-network').find('a.button').on('click', function () {
            var netWork = plus.networkinfo.getCurrentType();
            if (netWork != plus.networkinfo.CONNECTION_UNKNOW && netWork != plus.networkinfo.CONNECTION_NONE)
                myApp.closeModal('.popup.popup-network');
        });
    }

    var defaultViewId = 'homeView';
    var viewIdObj = { homeview: 'homeView', categoryview: 'categoryView', cartview: 'cartView', memberview: 'memberView' };
    var viewIdObjYL = { home: 'homeView', goodclass: 'categoryView', mycar: 'cartView', mycenter: 'memberView' };

    var formatViewId = function (viewId) {
        if (!viewId) return;
        return viewIdObj[viewId.toLocaleLowerCase()];
    };

    var formatPageName = function (pageName) {
        if (pageName && pageName.substr(0, 1) === '/')
            return pageName.substr(1);
        return pageName;
    };

    var formatViewIdYL = function (viewId) {
        if (!viewId) return;
        return viewIdObjYL[viewId.toLocaleLowerCase()];
    };

    var getViewParams = function () {
        var pushStateSeparator = myApp.params.pushStateSeparator;
        if (location.href.indexOf(pushStateSeparator) >= 0 && location.href.indexOf(pushStateSeparator + '#') < 0) {
            var viewLink = location.href.split(pushStateSeparator)[1];
            var queryString = new cb.util.queryString(viewLink);
            var viewId = formatViewId(queryString.get('view')) || defaultViewId;
            var params = { viewId: viewId };
            if (formatPageName(queryString.pathname) !== formatPageName($$('#' + viewId).attr('data-url')))
                params.url = queryString.pathname + queryString.toStr();
            return params;
        } else {
            if ((cb.config && !cb.config.fromWechat) || location.pathname === '/') return { viewId: defaultViewId };
            //location.href = '/' + pushStateSeparator + location.pathname + location.search;
            var route = formatPageName(location.pathname);
            var viewId = formatViewIdYL(route);
            if (viewId) {
                var queryString = new cb.util.queryString();
                if (queryString.has('url')) {
                    var url = queryString.get('url');
                    queryString.del('url');
                    return { viewId: viewId, url: url + queryString.toStr(), isFromeYL: true };
                }
                return { viewId: viewId };
            }
            return { viewId: defaultViewId, url: '/' + route + location.search };
        }
    };

    $$('div.views.tabs').children('div.view.tab').on('show', function (e) {
        var viewId = e.target.id;
        if (this.id !== viewId) return;
        if ($$('.popup-districtStyle').hasClass('modal-in'))
            myApp.closeModal('.popup-districtStyle');
        $$('.popup-overlay').removeClass('modal-overlay-visible');
        if (_viewIds[viewId]) {
            setMainView('#' + viewId, _viewIds[viewId]);
            if (e.detail && (e.detail.indexOf('channel/') > -1 || e.detail.indexOf('home') > -1)) {
                myApp.mainView.router.reloadPage(e.detail);
                if (cb.util.localStorage.getItem('currentpage')) {
                    cb.util.localStorage.removeItem('currentpage');
                }
                cb.util.localStorage.setItem('currentpage', e.detail);
            } else {
                myApp.mainView.router.reloadPage(myApp.mainView.url);
            }
        } else {
            addView(viewId, e.detail, true);
        }
    });
    var viewParams = getViewParams();
    //不管开不开区域 刚开始的时候都把areaid清除
    if (cb.util.localStorage.getItem('areaid')) {
        cb.util.localStorage.setItem('areaid', '');
    }
    if (cb.util.localStorage.getItem('areaname')) {
        cb.util.localStorage.setItem('areaname', '');
    }
    if (cb.util.localStorage.getItem('Areatag')) {
        cb.util.localStorage.setItem('Areatag', '');
    }
    if (cb.util.localStorage.getItem('currentpage')) {
        cb.util.localStorage.setItem('currentpage', '');
    }
    //只有设置区域的时候才弹出区域层
    if (cb.views['AreaViewController']) {
        var _areaController = new cb.views['AreaViewController']();
    }
    cb.route = {
        redirectLoginPage: function () {
            var options;
            if (arguments.length === 1) {
                if (arguments[0] instanceof cb.views.BaseView) {
                    options = { controller: arguments[0] };
                } else if (typeof arguments[0] === 'function') {
                    options = { callback: arguments[0] };
                } else {
                    options = arguments[0];
                }
            }
            if (location.host == 'dev-fuli2.xinfushe.com') {
                location.href = "https://dev.xinfushe.com/fuli/empLogin/needKey?type=login";
            } else {
                _loginController.login(options);
            }
        },
        redirectFansePage: function () {
            var options;
            if (arguments.length === 1) {
                if (arguments[0] instanceof cb.views.BaseView) {
                    options = { controller: arguments[0] };
                } else if (typeof arguments[0] === 'function') {
                    options = { callback: arguments[0] };
                } else {
                    options = arguments[0];
                }
            }
            _fanseRegisterController.init();
        },
        popupArea: function (callback, isShare, viewParams) {
            _areaController.init(callback, isShare, viewParams);
        }
    };
    function plusReady() {
        var onNetChange = function () {
            var netWork = plus.networkinfo.getCurrentType();
            if (netWork == plus.networkinfo.CONNECTION_UNKNOW || netWork == plus.networkinfo.CONNECTION_NONE)
                myApp.popup('.popup.popup-network');
            if (netWork != plus.networkinfo.CONNECTION_UNKNOW && netWork != plus.networkinfo.CONNECTION_NONE)
                myApp.closeModal('.popup.popup-network');
        };
        document.addEventListener("netchange", onNetChange, false);

        //检查更新
        var proxy = cb.rest.DynamicProxy.create({
            getVersion: {
                url: 'client/checkPackageUpdate',
                method: 'GET',
                options: {
                    mask: true
                }
            }
        });
        var netWork = plus.networkinfo.getCurrentType();
        if (netWork == plus.networkinfo.CONNECTION_WIFI) {
            proxy.getVersion({ osName: plus.os.name, version: cb.config && cb.config.version || plus.runtime.version }, function (err, result) {
                if (err) {
                    myApp.toast('检查更新失败', 'error').show(true);
                    return;
                }
                if (result.isUpdate) {
                    myApp.confirm('检测到有新版本，是否继续更新?', '提示信息', function () {
                        if (isAndroid) {
                            plus.nativeUI.toast("文件开始下载，请稍后...", { duration: "long" });
                            var wgtOption = { filename: "_downloads/update/", retry: 1 };

                            var installWgt = function (wgtpath) {
                                plus.runtime.install(wgtpath, {}, function (wgtinfo) {
                                    myApp.alert('App更新完成，请立即重启应用！', '提示信息', function () {
                                        plus.runtime.quit();
                                    });
                                }, function (error) {
                                    myApp.toast("应用更新失败：" + error.message, 'error').show(true);
                                });
                            };

                            var task = plus.downloader.createDownload(result.updateUrl, wgtOption, function (download, status) {
                                if (status == 200) {
                                    plus.nativeUI.toast("文件下载完成，开始安装...", { duration: "long" });
                                    installWgt(download.filename);
                                } else {
                                    myApp.toast("文件下载失败！", 'error').show(true);
                                }
                            });
                            task.start();
                        }
                        if (isIos) {
                        	//这是买石商城的app的apple store的链接地址 ，如果后续有别的需要样做，那么需要更改id
                            location.href = 'https://itunes.apple.com/cn/app/%E4%B9%B0%E7%9F%B3%E5%95%86%E5%9F%8E/id1241216031?mt=8';
                        }
                    });
                }
            });
        }
        if (cb.views['AreaViewController'] && location.href.indexOf('payment') == -1 && location.href.indexOf('&from=') == -1 && location.href.indexOf('#!/order') == -1) {
            cb.route.popupArea(function (activeUrl) {
                if (activeUrl == '') {
                    activeUrl = viewParams.url
                }
                $$('#' + viewParams.viewId).trigger('show', activeUrl);
            }, false, viewParams);
        } else {
            $$('#' + viewParams.viewId).trigger('show', viewParams.url);
        }
    };
    if (window.plus) {
        plusReady();
    } else {
        document.addEventListener("plusready", plusReady, false);
    }
    function loadMenuFunc(isActiveMenu) {
        var proxyApp = cb.rest.DynamicProxy.create({
            getToolbarConfig: {
                url: 'fromtoobal/getToolbarData'
            }
        });
        proxyApp.getToolbarConfig({ url: url }, function (err, result) {
            if (err) {
                alert(err.message);
                return;
            } else {
                var addContent = "";
                if (cb.config) {
                    if (cb.config.webDomain) {
                        for (var i = 0; i < result.toolbarData[0].item.length; i++) {
                            if (result.toolbarData[0].item[i].$.toolbar_type != 'share') {
                                if (i == 0 && (isActiveMenu == false)) {
                                    addContent += '<a href="#' + result.toolbarData[0].item[i].$.toolbar_url + '" class="tab-link ' + result.toolbarData[0].item[i].$.oddcenter + ' active">';
                                    addContent += '<i class="icon" style="background:url(' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_icon_active + ') no-repeat;background-size: 24px 24px;">';
                                    $$(addContent).parent().children().removeClass('active');
                                } else {
                                    if ('#' + result.toolbarData[0].item[i].$.toolbar_url == isActiveMenu && isActiveMenu != '#channelView') {
                                        addContent += '<a href="#' + result.toolbarData[0].item[i].$.toolbar_url + '" class="tab-link ' + result.toolbarData[0].item[i].$.oddcenter + ' active">';
                                        addContent += '<i class="icon" style="background:url(' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_icon_active + ') no-repeat;background-size: 24px 24px;">';
                                        $$(addContent).parent().children().removeClass('active');
                                    } else if (result.toolbarData[0].item[i].$.toolbar_url.indexOf("channel") > -1 && isActiveMenu == "#channelView") {
                                        addContent += '<a href="#channelView" class="tab-link ' + result.toolbarData[0].item[i].$.oddcenter + ' active" data-url=' + result.toolbarData[0].item[i].$.toolbar_url + '>';
                                        addContent += '<i class="icon" style="background:url(' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_icon_active + ') no-repeat;background-size: 24px 24px;">';
                                        $$(addContent).parent().children().removeClass('active');
                                    } else {
                                        if (result.toolbarData[0].item[i].$.isSystemToolbar == false && result.toolbarData[0].item[i].$.toolbar_type != "channel") {
                                            if (result.toolbarData[0].item[i].$.toolbar_url.indexOf('http') > -1) {
                                                addContent += '<a href="' + result.toolbarData[0].item[i].$.toolbar_url + '" class="tab-link ' + result.toolbarData[0].item[i].$.oddcenter + '" target="_system">';
                                                addContent += '<i class="icon" style="background:url(' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_icon + ') no-repeat;background-size: 24px 24px;">';
                                            } else {
                                                addContent += '<a href="' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_url + '" class="tab-link ' + result.toolbarData[0].item[i].$.oddcenter + '">';
                                                addContent += '<i class="icon" style="background:url(' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_icon + ') no-repeat;background-size: 24px 24px;">';
                                            }
                                        } else if (result.toolbarData[0].item[i].$.toolbar_type == "channel") {
                                            addContent += '<a href="#channelView" class="tab-link ' + result.toolbarData[0].item[i].$.oddcenter + '" data-url=' + result.toolbarData[0].item[i].$.toolbar_url + '>';
                                            addContent += '<i class="icon" style="background:url(' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_icon + ') no-repeat;background-size: 24px 24px;">';
                                        } else {
                                            addContent += '<a href="#' + result.toolbarData[0].item[i].$.toolbar_url + '" class="tab-link ' + result.toolbarData[0].item[i].$.oddcenter + '">';
                                            addContent += '<i class="icon" style="background:url(' + cb.config.webDomain + result.toolbarData[0].item[i].$.toolbar_icon + ') no-repeat;background-size: 24px 24px;">';
                                        }
                                    }
                                }
                                if (result.toolbarData[0].item[i].$.toolbar_type == "cart") {
                                    addContent += '<span class="badge bg-red shoppingCartCount" style="display: block;"></span></i>';
                                } else {
                                    addContent += '</i>';
                                }
                                addContent += '<span class="tabbar-label" data-list="' + result.toolbarData[0].item[i].$.listViewUrl + '">';
                                addContent += result.toolbarData[0].item[i].$.toolbar_name;
                                addContent += '</span>';
                                addContent += '</a>'
                            }
                        }
                        if (!isActiveMenu) {
                            $$('.toolbar-inner').html(addContent);
                            $$($$('.toolbar-inner').children('a')[0]).addClass('active');
                        } else {
                            $$('.toolbar-inner').html(addContent);
                        }
                    }
                }
            }
        });
    };
    $$('#' + viewParams.viewId).trigger('show', viewParams.url);
    if (cb.config && !cb.config.fromWechat) {
        loadMenuFunc(false);
    }
    if (cb.config && cb.config.fromWechat) {
        var views = $$('#' + viewParams.viewId).parent().children('.view.tab');
        if (views.length) {
            var context = cb.rest.AppContext;
            views.each(function (index, view) {
                var viewContainer = $$(view);
                var items = [];
                items.push(viewContainer.attr('data-url'));
                items.push('?wid=' + context.wid);
                if (context.shareparentid)
                    items.push('&shareparentid=' + context.shareparentid);
                viewContainer.attr('data-url', items.join(''));
            });
        }
        var wechatToolbarItem = $$('#' + viewParams.viewId).parent().children('.toolbar').find('a[href].external');
        if (wechatToolbarItem.length === 1) {
            var context = cb.rest.AppContext;
            var items = [];
            items.push(wechatToolbarItem.attr('href'));
            items.push('?wid=' + context.wid);
            items.push('&oid=' + context.oid);
            if (context.shareparentid)
                items.push('&shareparentid=' + context.shareparentid);
            items.push('&source=umall');
            items.push('&returnurl=' + context.serviceUrl);
            wechatToolbarItem.attr('href', items.join(''));
        }
        var isDebug = false;
        if (location.href.indexOf('wxdebug=true') > 0)
            isDebug = true;

        var url = location.href.indexOf('#') ? location.href.split('#')[0] : location.href;
        if (cb.views['AreaViewController']) {
            /**通过扫未开启的区域站点二维码 进来的处理  **/
            if (location.search.indexOf('areaId=') > -1) {
        		var areaId = parseInt(location.search.substr(location.search.indexOf('areaId=')+7));
		        var proxy = cb.rest.DynamicProxy.create({
		            getAreaById: {
		                url: 'client/Areas/getAreaById',
		                method: 'GET',
		                options: {
		                    mask: true,
		                }
		            }
		        });
		        proxy.getAreaById({ areaId: areaId }, function (error, result) {
		        	if(error){
		        		myApp.toast(JSON.stringify(error), 'error').show(true);
		        	}else{
		        		if(!result.iStart){ //iStart， 0：未开启， 1： 开启
		        			viaScanQr = false;
		        		} else {
		        		    getWechatConfig(result.name);
		        		}
		        	}
		        	   
		        })
            } else {
        		getWechatConfig();
        	}
        } else {
        	if(location.search.indexOf('areaId=') > -1){
        		viaScanQr = false; //不开启区域  扫描区域二维码也不进入对应页面
        	}
            setTimeout(function () {
                getWechatConfig();
            }, 100);
        }
    }
    $$(document).on('pageAfterAnimation', function (e) {
        if (e.detail.page.name === 'home') {
            $$('.homeNavBar').removeClass('toolbar-hidden');
            if (e.detail.page.container.controller && !cb.util.localStorage.getItem('currentpage')) {
                e.detail.page.container.controller.run(true);
            } else {
                e.detail.page.view.allowPageChange = true;
                if (cb.util.localStorage.getItem('currentpage')) {
                    e.detail.page.view.router.reloadPage(cb.util.localStorage.getItem('currentpage'));
                } else {
                    e.detail.page.view.router.reloadPage("home");
                }
            }
        } else if (e.detail.page.name === 'category') {
            if (!e.detail.page.container.controller) {
                e.detail.page.view.allowPageChange = true;
                e.detail.page.view.router.reloadPage('category');
                //reloadPage(e.detail.page.view, 'category');
            }
            $('a[href=#categoryView]').addClass('active').siblings().removeClass('active');
        } else if (e.detail.page.name === 'cart') {
            // 底部菜单的隐藏和显示
            if (myApp.mainView.container.id !== "cartView") {
                myApp.hideToolbar('.homeNavBar');
            } else {
                myApp.showToolbar('.homeNavBar');
            }
            if (!e.detail.page.container.controller) {
                e.detail.page.view.allowPageChange = true;
                e.detail.page.view.router.reloadPage('member/cart');
                //reloadPage(e.detail.page.view, 'member/cart');
            }
            $('a[href=#cartView]').addClass('active').siblings().removeClass('active');
        } else if (e.detail.page.name === 'user') {
            var viewParams = getViewParams();
            if (!e.detail.page.container.controller) {
                if (viewParams.isFromeYL) {
                    e.detail.page.view.router.back();
                    history.back();
                } else {
                    e.detail.page.view.allowPageChange = true;
                    e.detail.page.view.router.reloadPage('member/index');
                    //reloadPage(e.detail.page.view, 'member');
                }
            }
            $('a[href=#memberView]').addClass('active').siblings().removeClass('active');
        } else if (e.detail.page.name === 'shopchannel') {
            if (e.detail.page.from == 'right') {
                if ($$($$('#homeView').find('div[data-display="shopchannel"]')[$$('#homeView').find('div[data-display="shopchannel"]').length - 1]).data('tag') == 'Toolbarfalse') {
                    $$('.homeNavBar').addClass('toolbar-hidden');
                } else {
                    $$('.homeNavBar').removeClass('toolbar-hidden');
                }
            } else if (e.detail.page.from == 'left') {
                if ($$('#homeView').find('div[data-display="shopchannel"]').length > 1) {
                    if ($$($$('#homeView').find('div[data-display="shopchannel"]')[$$('#homeView').find('div[data-display="shopchannel"]').length - 2]).data('tag') == 'Toolbarfalse') {
                        $$('.homeNavBar').addClass('toolbar-hidden');
                    } else {
                        $$('.homeNavBar').removeClass('toolbar-hidden');
                    }
                } else if ($$('#homeView').find('div[data-display="shopchannel"]').length == 1) {
                    if ($$($$('#homeView').find('div[data-display="shopchannel"]')[$$('#homeView').find('div[data-display="shopchannel"]').length - 1]).data('tag') == 'Toolbarfalse') {
                        $$('.homeNavBar').addClass('toolbar-hidden');
                    } else {
                        $$('.homeNavBar').removeClass('toolbar-hidden');
                    }
                }
            }

        } else if (e.detail.page.name === 'shophome') {
            if (e.detail.page.from == 'right') {
                if ($$($$('#homeView').find('div[data-display="shophome"]')[$$('#homeView').find('div[data-display="shophome"]').length - 1]).data('tag') == 'Toolbarfalse') {
                    $$('.homeNavBar').addClass('toolbar-hidden');
                } else {
                    $$('.homeNavBar').removeClass('toolbar-hidden');
                }
            } else if (e.detail.page.from == 'left') {
                if ($$('#homeView').find('div[data-display="shophome"]').length > 1) {
                    if ($$($$('#homeView').find('div[data-display="shophome"]')[$$('#homeView').find('div[data-display="shophome"]').length - 2]).data('tag') == 'Toolbarfalse') {
                        $$('.homeNavBar').addClass('toolbar-hidden');
                    } else {
                        $$('.homeNavBar').removeClass('toolbar-hidden');
                    }
                } else if ($$('#homeView').find('div[data-display="shophome"]').length == 1) {
                    if ($$($$('#homeView').find('div[data-display="shophome"]')[$$('#homeView').find('div[data-display="shophome"]').length - 1]).data('tag') == 'Toolbarfalse') {
                        $$('.homeNavBar').addClass('toolbar-hidden');
                    } else {
                        $$('.homeNavBar').removeClass('toolbar-hidden');
                    }
                }

                // 解决店铺进入频道页点击商品进入详情回退问题
                setTimeout(function () {
                    myApp.mainView.router.refreshPage();
                }, 1000);
            }
        } else if (e.detail.page.name === 'channel') {
            if (e.detail.page.from == 'right') {
                if ($$($$('#homeView').find('div[data-display="channel"]')[$$('#homeView').find('div[data-display="channel"]').length - 1]).data('tag') == 'Toolbarfalse') {
                    $$('.homeNavBar').addClass('toolbar-hidden');
                } else {
                    $$('.homeNavBar').removeClass('toolbar-hidden');
                }
            } else if (e.detail.page.from == 'left') {
                if ($$($$('#homeView').find('div[data-display="channel"]')[$$('#homeView').find('div[data-display="channel"]').length - 2]).data('tag') == 'Toolbarfalse') {
                    $$('.homeNavBar').addClass('toolbar-hidden');
                } else {
                    $$('.homeNavBar').removeClass('toolbar-hidden');
                }
                setTimeout(function () {
                    myApp.mainView.router.refreshPage();
                }, 1000);
            }
        } else if (e.detail.page.name == 'searchPage' && myApp.mainView.container.id == "homeView") {
            // 首页点击搜索底部菜单不隐藏问题
            $$('.homeNavBar').addClass('toolbar-hidden');
        } else if (e.detail.page.name == 'productDetail' || e.detail.page.name == 'notice') {
            $$('.homeNavBar').addClass('toolbar-hidden');
        } else if (e.detail.page.name == 'freebuy') {
            if (myApp.mainView.container.id === "freebuyView") {
                $$('.homeNavBar').removeClass('toolbar-hidden');
                $$('#freebuyView').trigger('show');
            } else {
                $('.homeNavBar').addClass('toolbar-hidden');
            }
           
        } else if (e.detail.page.name == 'productList' && myApp.mainView.container.id != "listView") {
            if (window.plus) {
                $$('.homeNavBar').addClass('toolbar-hidden');
            }
        }
    });

    $$(document).on('pageBeforeAnimation', function (e) {
        if (e.detail.page.container.controller && e.detail.page.container.controller.afterFromPageBack)
            e.detail.page.container.controller.afterFromPageBack(e.detail.page);
    });
    /**
    * 扫码打开新窗口
    * @param {URIString} id : 要打开页面url
    * @param {boolean} wa : 是否显示等待框
    * @param {boolean} ns : 是否不自动显示
    */
    var openw = null, waiting = null;
    window.clicked = function (url, isOuter) {
        if (cb.config && !cb.config.fromWechat) {
            openw = plus.webview.create(url, url, { scrollIndicator: 'none', scalable: false });
            openw.addEventListener('loaded', function () {//页面加载完成后才显示
                openw.show("pop-in");
            }, false);
            openw.addEventListener('close', function () {//页面关闭后可再次打开
                openw = null;
            }, false);
            return openw;
        } else {
            window.location.href = url;
            //myApp.toast('本功能只能在APP中使用!', 'error').show(true);
        }
        return null;
    };

    //扫码完成,供公共调用
    window.scaned = function (type, result, file) {
        plus.nativeUI.toast("扫码成功!", {
            duration: "short"
        });
        if (result.indexOf('http://') > -1) {
            myApp.mainView.router.loadPage({
                url: 'detail?' + result.split('#')[0].split('?')[1]
            });
        } else {
            var bcproxy = cb.rest.DynamicProxy.create({
                getProudctId: {
                    url: 'client/products/getProductIdByBarCode?cBarCode=' + result,
                    method: 'GET',
                    options: {
                        token: false
                    }
                }
            });
            bcproxy.getProudctId(function (err, data) {
                if (err) {
                    myApp.toast('获取商品信息失败', 'tips').show(true);
                    return;
                }
                if (data)
                    myApp.mainView.router.loadPage({
                        url: 'detail?goods_id=' + data
                    });
                else
                    myApp.toast('暂无该商品信息', 'tips').show(true);
            });
        }
    }
    /**
     * 获取微信位置以便能够调用他们的api
     */
    function getWechatConfig(areaNameScan) {
        //获取WX config
        var proxyWX = cb.rest.DynamicProxy.create({
            getWeChatConfig: {
                url: 'client/Pay/getWeChatConfig',
                method: 'POST',
                options: {
                    mask: true
                }
            }
        });
        proxyWX.getWeChatConfig({ url: url }, function (err, result) {
            if (err) {
                if (isDebug)
                    myApp.toast('初始化微信JSSDK出错', 'error').show(true);
                return;
            }
            wx.config({
                debug: isDebug,
                appId: result.appId,
                timestamp: result.timestamp,
                nonceStr: result.nonceStr,
                signature: result.signature,
                jsApiList: ["checkJsApi", "onMenuShareTimeline", "onMenuShareAppMessage", "onMenuShareQQ", "onMenuShareWeibo", "hideMenuItems", "showMenuItems", "hideAllNonBaseMenuItem", "showAllNonBaseMenuItem", "translateVoice", "startRecord", "stopRecord", "onRecordEnd", "playVoice", "pauseVoice", "stopVoice", "uploadVoice", "downloadVoice", "chooseImage", "previewImage", "uploadImage", "downloadImage", "getNetworkType", "openLocation", "getLocation", "hideOptionMenu", "showOptionMenu", "closeWindow", "scanQRCode", "chooseWXPay", "openProductSpecificView", "addCard", "chooseCard", "openCard", "onMenuShareWeibo", "hideMenuItems", "showMenuItems", "hideAllNonBaseMenuItem", "showAllNonBaseMenuItem"]
            });
            wx.ready(function (res) {
                if (cb.views['AreaViewController'] && location.href.indexOf('payment') == -1 && location.href.indexOf('&from=') == -1 && location.href.indexOf('&linksource') == -1 && location.href.indexOf('#!/order') == -1 && location.href.indexOf('&tag') == -1) {
                    cb.route.popupArea(function (activeUrl) {
                        if (activeUrl == '') {
                            activeUrl = viewParams.url
                        }
                        if (cb.util.localStorage.getItem('areaname') && cb.util.localStorage.getItem('areaname') !== "undefined" && typeof (cb.util.localStorage.getItem('areaname')) !== "undefined" && cb.util.localStorage.getItem('areaname') !== null) {
                            cb.util.changeTitle(cb.util.localStorage.getItem('areaname'));
                        }
                        $$('#' + viewParams.viewId).trigger('show', activeUrl);
                    }, false, viewParams);
                } else if (cb.views['AreaViewController'] && (location.href.indexOf('&from=') > -1 || location.href.indexOf('&linksource') > -1 ||location.href.indexOf('&tag') > -1)) {
                    cb.route.popupArea(function (activeUrl, fromScan) {// fromScan通过扫一扫第一次跳过来的
                        if (activeUrl == '') {
                            activeUrl = viewParams.url
                        }
                        if (fromScan && fromScan !== "null" && typeof (fromScan) !== "undefined") {
                            if (areaNameScan && areaNameScan !== "undefined" && typeof (areaNameScan) !== "undefined" && areaNameScan !== null) {
                                cb.util.changeTitle(areaNameScan,false);
                            } else {
                                cb.util.changeTitle(cb.util.localStorage.getItem('areaid'), true);
                            }
                           
                        } else {
                            if (cb.util.localStorage.getItem('areaname') && typeof (cb.util.localStorage.getItem('areaname')) !== "undefined" && cb.util.localStorage.getItem('areaname') !== "undefined") {
                                cb.util.changeTitle(cb.util.localStorage.getItem('areaname'));
                            } else {
                                if (cb.util.localStorage.getItem('Areatag') && typeof (cb.util.localStorage.getItem('Areatag')) !== "undefined" && cb.util.localStorage.getItem('Areatag') !== "undefined") {
                                    cb.util.changeTitle(cb.util.localStorage.getItem('Areatag'));
                                }
                            }
                        }
                        
                        $$('#' + viewParams.viewId).trigger('show', activeUrl);

                    }, true, viewParams);
                }
            });
            wx.error(function (res) {
                if (isDebug)
                    myApp.toast(JSON.stringify(res), 'error').show(true);
            });
        });
    }
    /**
     * 首页面的顶部的两个按钮注册关闭窗口的事件
     */
    $$(".popover-top-links").on('click', function () {
        myApp.closeModal('.popover.popover-top-links');
    })
};

