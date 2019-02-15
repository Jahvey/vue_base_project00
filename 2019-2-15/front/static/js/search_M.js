cb.widgets.register('platform_search', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.runTemplate = function (err, result) {
        newConfig = this.getConfig();
        var pageConfig = {};
        var paramsQuery = new cb.util.getUrlparams(location.hash.substr(2));
        var whichPage = this.isWhichPage(new cb.util.getUrlparams(location.hash.substr(2)));
        if (whichPage == 'supplierHomePage') {
            pagerouter = paramsQuery.query.router;
        } else if (whichPage == 'supplierChannelPage') {
            pagerouter = paramsQuery.query.router;
        } else if (whichPage == 'homeChannelPage') {
            pagerouter = 'home';
        } else if( whichPage=='homePage'){
            pagerouter = 'home';
        }
        if (location.pathname == '/templatedesigner') {
            pagerouter = new cb.util.queryString().get('templatePage');
        }
        for (var key in newConfig) {
            if (key == pagerouter) {
                pageConfig.allContent = newConfig[key][0].allContent;
                pageConfig.bgcolorObj = newConfig[key][0].bgcolorObj;
            }
            if (!newConfig[pagerouter]) {
                pageConfig.allContent = "输入商品名称/关键字";
            }
        }
        var html = this.render(pageConfig);
        this.getElement().find('.searchDiv').html(html);
    }
    widget.prototype.isWhichPage = function (pathUrl) {
        pathUrl = pathUrl.pathname;
        if (pathUrl.indexOf('/channel/supplier') > -1) {
            return 'supplierHomePage'
        } else if (pathUrl.indexOf('/channel/channel') > -1 && pathUrl.indexOf('_supplier_') > -1) {
            return 'supplierChannelPage'
        } else if (pathUrl.indexOf('/channel/channel') > -1 && pathUrl.indexOf('_supplier_') == -1) {
            return 'homeChannelPage'
        } else {
            return 'homePage'
        }
    }
    return widget;
});