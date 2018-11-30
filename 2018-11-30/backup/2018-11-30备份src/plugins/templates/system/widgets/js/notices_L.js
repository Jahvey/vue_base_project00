cb.widgets.register('Notices', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
        if (options && options.height)
            this.getElement().css('height', options.height);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return { url: 'client/Notices/getIndexNotices', method: 'GET' };
    };

    widget.prototype.getProxyData = function () {
        return { pagesize: 9 };
    };

    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var html = this.render({ list: result.notices });
        this.getElement().find('ul').html(html);
    };

    return widget;
});