cb.widgets.register('Path_mapping', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.getProxy = function () {
        var queryString = new cb.util.queryString();
        if (queryString.has('goods_id')) {
            this._set_data('proxyData', queryString.get('goods_id'));
            return { url: 'client/Products/getPPClassByProductId', method: 'GET' };
        } else {
            this._set_data('proxyData', queryString.get('categoryid'));
            return { url: 'client/ProductClasses/getPPClasses', method: 'GET' };
        }
    };
    widget.prototype.getProxyData = function () {
        return { id: this._get_data('proxyData') };
    };
    widget.prototype.runTemplate = function (error, result) {
        var data = [{ menuurl: '/', menutitle: '首页' }];
        if (result && result.length > 0) {
            if ($.isArray(result)) {
                result.forEach(function (item) {
                    if (!item) return;
                    if (!item.cName) return;
                    var dataItem = { menutitle: item.cName };
                    if (item.id)
                        dataItem.menuurl = '/list?categoryid=' + item.id;
                    data.push(dataItem);
                });
            }
            var html = this.render({ list: data });
            this.getElement().find('.menu-path').html(html);
        }
       
    };
    return widget;
});