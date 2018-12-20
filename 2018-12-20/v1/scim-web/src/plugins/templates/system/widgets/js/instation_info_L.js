cb.widgets.register('Instation_info', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.getProxy = function () {
        return { url: 'client/Bulletins/getBulletinsForCommon', method: 'GET' };
    }
    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var html = this.render(result, false);
        this.getElement().find('ul').html(html);
        var bulletins = result.bulletins;
        this.getElement().click(function (e, args) {
            var $target = $(e.target);
            if ($target.is('a')) {
                var index = $target.attr('data-index');
                if (index) {
                    var bull = bulletins[index];
                    clickBulletinDetail(bull);
                }
            }
        });
    };
    function clickBulletinDetail(bull) {
        var list = [];
        list.push(bull.id);
        $.post('client/Bulletins/modifyBulletinStatus', {
            bIdList: list
        }, function (json) {
            debugger;
            if (bull.cVoucherType == "ORDER") //跳转订单详情
                window.location.href = "client/Orders/detail?cOrderNo=" + bull.cVoucherNo + "#/detailOrder";
            if (bull.cVoucherType == "PAYMENT") //跳转支付详情
                window.location.href = "client/pays/detail?cPayNo=" + bull.cVoucherNo;
        });
    }
    return widget;
});
