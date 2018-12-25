cb.widgets.register('ImageText', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.runTemplate = function () {
        var config = this.getConfig();
        if (!config) return;
        this.getElement().html(config.content);
    };

    return widget;
});