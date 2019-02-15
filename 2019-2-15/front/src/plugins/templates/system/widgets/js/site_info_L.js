cb.widgets.register('SiteInfo', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.getProxy = function () {
        return { url: 'client/SiteMessages/getBasicMessage', method: 'GET' };
    }
    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var html = this.render(result, false);
        this.getElement().html(html);
    };
    return widget;
});