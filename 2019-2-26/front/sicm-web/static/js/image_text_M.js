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
        var pageTag = this.getElement().find('a');
        for (var i = 0; i < pageTag.length; i++) {
            if (pageTag[i].href.indexOf('http') > -1 || pageTag[i].href.indexOf('https') > -1) {
                pageTag.removeAttr('target');
                pageTag.addClass('external');
                if (pageTag[i].href.indexOf('tel') > -1) {
                    var telHref = $(pageTag[i]).attr("href");
                    telHref = telHref.replace(/http:\/\/|https:\/\//g, '');
                    $(pageTag[i]).attr('href', telHref);
                }
            }
            if(pageTag[i].href.indexOf('channel/') > -1){
                var channelUrl = 'channel/'+pageTag[i].href.split('/')[pageTag[i].href.split('/').length-1];
                $(pageTag[i]).attr('href', channelUrl);
                pageTag.removeClass('external');
            }
        }

    };

    return widget;
});