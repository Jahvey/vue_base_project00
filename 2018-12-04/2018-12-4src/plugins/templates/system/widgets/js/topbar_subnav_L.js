cb.widgets.register('TopbarSubnav', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return { url: 'client/Bulletins/getDifBulletinsCount', method: 'GET', options: { token: true} };
    };

    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var $bulletin = this.getElement().children('span').first().children('a');
        if (result==0||result) {
            $bulletin.addClass('active');
            $bulletin.find('.quanTips').text('(' + result + ')');
        }
    };

    return widget;
});