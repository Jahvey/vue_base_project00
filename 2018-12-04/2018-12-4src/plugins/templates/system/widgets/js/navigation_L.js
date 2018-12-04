cb.widgets.register('Navigation', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.getProxy = function () {
        return { url: 'client/SiteMenus/getList', method: 'GET' };
    }
    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var html = this.render(result);
        this.getElement().find('ul').html(html);
        //一个布局两个挂件，商品分类挂件和网页导航挂件，前端显示不应该有间距
        this.getElement().closest("div[class^=col-xs]").css("padding-left", 0);
        // 导航栏背景颜色
        //$("div[data-type='Navigation']").parents(".up-nav-box").css("background", "#31708f");
        //$("div[data-type='Navigation']").css("background", "#31708f");
        //$("div[data-type='Navigation']").find("ul").css("background", "#31708f");
        //// 导航栏字体颜色
        //$("div[data-type='Navigation']").find("ul").find("a").css("color", "#494848");
    };
    return widget;
});