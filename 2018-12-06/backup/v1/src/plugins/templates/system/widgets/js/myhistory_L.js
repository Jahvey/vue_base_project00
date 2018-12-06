cb.widgets.register('MyHistory', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return {
            url: 'client/ProductViewHistorys/getHistories',
            method: 'GET',
            options: {
                token: true,
                autoLogin: false
            }
        };
    };

    widget.prototype.getProxyData = function () {
        return { count: 10 };
    };

    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var isSalePointsProduct = false;
        var index = $('.goodsprice').text().indexOf("积分");;
        if (index > 0) {
            isSalePointsProduct = true;
        } else {
            isSalePointsProduct = false;
        }
        for (var i = 0; i < result.pager.data.length; i++) {
            result.pager.data[i].isShowSalePointsProduct = isSalePointsProduct;
            if (result.pager.data[i].fSalePrice) {
                result.pager.data[i].fSalePrice = parseFloat(result.pager.data[i].fSalePrice).toFixed(2);
            }
        }
        var html = this.render({
            data: result.pager.data
        }, false);
        $('#foot_history').html(html);
        $('.isShowFooter').removeClass('hide');
    };

    return widget;
});