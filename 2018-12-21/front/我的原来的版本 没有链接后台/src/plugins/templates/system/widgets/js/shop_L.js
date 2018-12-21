cb.widgets.register('shop', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return {
            url: 'client/Products/index',
            method: 'GET',
            options: {
                token: true
            }
        };
    };
    widget.prototype.getProxyData = function () {
        var queryString = new cb.util.queryString();
        var goods_id = queryString.get("goods_id");
        return { id: goods_id };

    };
    widget.prototype.runTemplate = function (error, result) {
        var self = this;
        if (error) return;
        if (result && result.shop && result.shop.iEnable && result.shop.id) {
            var html = this.render({ data: result }, false);
            $('.widgetShop').html(html);
            self.getAttentionShopFunc(result.shop.id);
            $('.atentionShopBtn').on('click', function () {
                var isAttention = self.isAttentionShopFunc(result.shop.id);
                if (isAttention) {
                    return;
                } else {
                    var proxy = cb.rest.DynamicProxy.create({
                        //获取商品信息
                        addShopFavorite: {
                            url: 'client/ShopFavorites/addShopFavorite',
                            method: 'POST',
                            options: {
                                token: true
                            }
                        },

                    });
                    proxy.addShopFavorite({ ids: [result.shop.id] }, function (err, result) {
                        if (err) {
                            myApp.toast(err.message, 'error').show(true);
                        } else {
                            $(".icon-enter-shop-2").addClass("active");
                            $('.atentionShopBtn').css("cursor", "not-allowed");
                            $(".atentionShopText").text("已关注");
                        }
                    });
                }


            })
        }
     
        
    };
    widget.prototype.getAttentionShopFunc = function (shopId) {
        var self = this;
        var myCollectioShopParams = { currentPage: 1, pagesize: 1000000 };
        var proxy = cb.rest.DynamicProxy.create({
            //获取商品信息
            getShopFavorites: {
                url: 'client/ShopFavorites/getShopFavorites',
                method: 'POST',
                options: {
                    token: true,
                    autoLogin: false
                }
            },

        });
        proxy.getShopFavorites(myCollectioShopParams, function (err, result) {
            if (err) {
                return;
            } else {
                self.attentionShop = result.pager.data;
                var isAttentionShop = self.isAttentionShopFunc(shopId);
                if (isAttentionShop) {
                    $(".icon-enter-shop-2").addClass("active");
                    $('.atentionShopBtn').css("cursor", "not-allowed");
                    $(".atentionShopText").text("已关注");
                }
            }
        });


    };
    widget.prototype.isAttentionShopFunc = function (shopId) {
        var self = this
        var isAttentionShop = false;
        if (self.attentionShop && self.attentionShop.length) {
            for (var i = 0; i < self.attentionShop.length; i++) {
                if (shopId == self.attentionShop[i].shopid) {
                    isAttentionShop = true;
                    break;
                }
            }
        }
        return isAttentionShop;

    };
    return widget;
});