cb.widgets.register('Logo', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return { url: '/client/Corprations/getCorpBaseMsg', method: 'GET' };
    };

    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var html = this.render(result);
        this.getElement().children('div').html(html);
    };

    return widget;
});