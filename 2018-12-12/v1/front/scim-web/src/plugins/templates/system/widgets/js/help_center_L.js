cb.widgets.register('HelpCenter', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        var typeName = encodeURIComponent('帮助中心');
        return [
        { url: '/client/Corprations/getCorpBaseMsg', method: 'GET' },
        { url: 'client/Articles/getArticleByTypeName?typeName=' + typeName, method: 'GET' }
        ];
    };
    widget.prototype.getTemplate = function () {
        var iterator = this._get_data('iterator')
        switch (iterator) {
            case 1:
                return this.getCorporation();
                break;
            case 2:
                return this.getArticle();
                break;
        }
    };

    widget.prototype.runTemplate = function (error, result) {
        var iterator = this._get_data('iterator') || 0;
        iterator++;
        this._set_data('iterator', iterator);
        switch (iterator) {
            case 1:
                this.runCorporation(error, result);
                break;
            case 2:
                this.runArticle(error, result);
                break;
        }
    };

    widget.prototype.getCorporation = function () {
        return this.getElement().children().first().find('script').html();
    };

    widget.prototype.runCorporation = function (error, result) {
        if (error) return;
        var html = this.render(result);
        this.getElement().children().first().find('ul').html(html);
    };

    widget.prototype.getArticle = function () {
        return this.getElement().children().last().find('script').html();
    };

    widget.prototype.runArticle = function (error, result) {
        if (error) return;
        var html = this.render({ data: result.slice(0,5)});
        this.getElement().children().last().find('ul').html(html);
    };

    return widget;
});