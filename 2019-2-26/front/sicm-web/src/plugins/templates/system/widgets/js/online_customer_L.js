cb.widgets.register('online_customer', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.widgetType = widgetType;
    widget.prototype.getProxy = function () {
        return { url: 'client/Corprations/getContactWayUseInfo', method: 'GET' };
    }

    widget.prototype.runTemplate = function (error, result) {
        var self = this;
        if (error) return;
        var onlineList = {};
        onlineList.list = [];
        onlineList.phoneList = [];
        onlineList.marketingQQ = [];
        var queryString = new cb.util.queryString();
        self.getContactWaysFunc(function (err1, result1) {
            // 购物车数量
            self.getCartCountFunc();
            if (err1) {
                $('.onlineCustomerContent').hide();
                return;
            }
            // 获取qq客服列表
            onlineList.contacyType = result.contacyType;
            for (var i = 0; i < result1.length; i++) {
                if (result1[i].cType == "qq") {
                    if (result1[i].cClientID === "marking") {
                        onlineList.marketingQQ.push(result1[i]);
                    } else {
                        onlineList.list.push(result1[i]);
                    }

                } else if (result1[i].cType == "phone") {
                    onlineList.phoneList.push(result1[i]);
                }
            }
            // 友联客服处理
            if (result.contacyType == "3") {
                var productInfo = "";
                var type = 1;
                var locationUrl = location.pathname;
                
                if (queryString.get("goods_id")&&locationUrl.indexOf("detail") > -1) {
                    // 商品详情
                    type = 2;
                } else if (queryString.get("orderId")&&locationUrl.indexOf("orderdetail") > -1) {
                    // 订单详情
                    type = 3;
                } else {
                    // 其它
                    type = 1;
                }
                self.ICCUrlFunc(result.youlianUrl, type, function (ICCUrl, userParams) {
                    debugger;
                    if (ICCUrl) {
                        //onlineList.ICCUrl = ICCUrl;
                        onlineList.ICCUrl = "http://58.16.69.244/web/code/code.jsp?c=1&s=1";
                    }
                    // 渲染客服列表
                    var html = self.render(onlineList);
                    self.getElement().find('.onlineCustomerContent').html(html);
                    $("ul.customerList li").on("click", function () {
                        self.liClickBtnFunc(this);
                    });
                    if (!ICCUrl && !onlineList.phoneList.length) {
                        $('.customerContent').hide();
                    } else {
                        $('.customerContent').show();
                    }
                    ulink.init({
                        chatUrl: "http://58.16.69.244/web/icc/chat/chat!wapIndex.action?c=1&s=1",//聊天对应的服务地址配置，必须 
                        iframeId: "customer-iframe",//iframeId
                        eventTargetId: "customer-pop",//点击触发显示客服窗口的对象id
                        showNewMsgFlagId: "customer-new",//显示新消息提醒的那个对象id，当聊天窗口最小化时候显示
                        showNewMsgNumId: "customer-new-number",//显示新消息数量的对象id
                        popWinHeight: "510", //高度    非必须
                        popWinWidth: "320", //高度    非必须
                        showFrom: "right",//从哪儿来，默认从底部来，还可以设置“right”，标识从右侧来
                        userParam: userParams //用户传递的特殊参数都放到这儿，如：“userData=姓名|性别 &goodsData=XXX”
                    });
                });
            } else {
                // 渲染客服列表
                var html = self.render(onlineList);
                self.getElement().find('.onlineCustomerContent').html(html);
                // 营销QQ
                if (onlineList.marketingQQ && onlineList.marketingQQ.length > 0) {
                    $(".BizQQWPA").show();
                    for (var j = 0; j < onlineList.marketingQQ.length; j++) {
                        var selectorId = "BizQQWPA" + onlineList.marketingQQ[j].id;
                        BizQQWPA.addCustom({ aty: '0', a: '0', type: '1', nameAccount: onlineList.marketingQQ[j].cContactNum, selector: selectorId })
                    }

                } else {
                    $(".BizQQWPA").hide();
                }
                $("ul.customerList li").on("click", function () {
                    self.liClickBtnFunc(this);
                });
                if (onlineList.list.length > 0 || onlineList.phoneList.length > 0 || onlineList.marketingQQ.length > 0) {
                    $('.customerContent').show();
                } else {
                    $('.customerContent').hide();
                }
            }
            
        })
    };



    // 购物车，优惠券，足记，收藏点击
    widget.prototype.liClickBtnFunc = function (_this) {
        if ($(_this).hasClass("cartBtn") || $(_this).parent("li").hasClass("cartBtn")) {
            location.href = '/cart';
        } else if ($(_this).hasClass("couponBtn") || $(_this).parent("li").hasClass("couponBtn")) {
            location.href = '/member/mycoupon';
        } else if ($(_this).hasClass("collectBtn") || $(_this).parent("li").hasClass("collectBtn")) {
            location.href = '/member/my_collection';
        } else if ($(_this).hasClass("footprintBtn") || $(_this).parent("li").hasClass("footprintBtn")) {
            location.href = '/member/myhistory';
        }
    };

    widget.prototype.getContactWaysFunc = function (callback) {
        var proxy = cb.rest.DynamicProxy.create({
            getContactWays: { url: 'client/Corprations/getContactWays', method: 'GET' }
        });
        proxy.getContactWays(function (err, result) {
            callback(err, result);
        });
    };
    // 获取购物车数量
    widget.prototype.getCartCountFunc = function () {
        if (cb.rest.AppContext.token) {
            var proxy = cb.rest.DynamicProxy.create({
                getCartCount: { url: 'client/ShoppingCarts/getCartList', method: 'GET', options: { token: true } }
            });
            proxy.getCartCount(function (cartErr, cartResult) {
                if (cartErr) {
                    $('.customerCartCount').hide();
                } else {
                    $('.customerCartCount').text(cartResult.lsCart.length);
                }
            });
        } else {
            $('.customerCartCount').hide();
        }
    };
    // 友联Url
    widget.prototype.ICCUrlFunc = function (youlianUrl, type, callback) {
        // 友联客服参数
        var ICCUrl = "";
        var userParams = "";
        var self = this;
        if (youlianUrl) {
            ICCUrl = youlianUrl;
            var accountInfo = cb.data.JsonSerializer.deserialize(cb.data.CookieParser.getCookie('userInformation'));
            var userData = "";
            if (accountInfo) {
                if (accountInfo.cUserName) {
                    userData = userData + encodeURIComponent(accountInfo.cUserName) + "|" + encodeURIComponent("0") + "|" + encodeURIComponent(" ") + "|";
                } else {
                    userData = userData + encodeURIComponent(" ") + "|" + encodeURIComponent("0") + "|" + encodeURIComponent(" ") + "|";
                }
                if (accountInfo.cPhone) {
                    userData = userData + encodeURIComponent(accountInfo.cPhone) + "|";

                } else {
                    userData = userData + encodeURIComponent(" ") + "|";

                }
                if (accountInfo.cEmail) {
                    userData = userData + encodeURIComponent(accountInfo.cEmail) + "|" + encodeURIComponent(" ") + "|" + encodeURIComponent(" ") + "|" + encodeURIComponent(" ") + "|"

                } else {
                    userData = userData + encodeURIComponent(" ") + "|" + encodeURIComponent(" ") + "|" + encodeURIComponent(" ") + "|" + encodeURIComponent(" ") + "|";

                }
                if (accountInfo.cQQ) {
                    userData = userData + encodeURIComponent(accountInfo.cQQ) + "|";

                } else {
                    userData = userData + encodeURIComponent(" ") + "|";

                }
                if (accountInfo.id) {
                    userData = userData + encodeURIComponent(accountInfo.id) + "|";

                } else {
                    userData = userData + encodeURIComponent(" ") + "|";

                }
                if (accountInfo.cMemberLevelName) {
                    userData = userData + encodeURIComponent(accountInfo.cMemberLevelName) + "|" + encodeURIComponent(" ") + "|";

                } else {
                    userData = userData + encodeURIComponent(" ") + "|" + encodeURIComponent(" ") + "|";
                }
                if (accountInfo.cRealName) {
                    userData = userData + encodeURIComponent(accountInfo.cRealName);

                } else {
                    userData = userData + encodeURIComponent(" ");
                }
                //if (userData) {
                //    ICCUrl = ICCUrl + "&userData=" + encodeURIComponent(userData);  
                //}
            }
            userParams = "userData=" + encodeURIComponent(userData);
            var queryString = new cb.util.queryString();
            if (type == 1) {
                callback(ICCUrl, userParams);
            } else if (type === 2) {
                // 商品信息
                var goods_id = queryString.get("goods_id");
                self.getProductInfoFunc(goods_id,function (productInfo) {
                    var goodsData = encodeURIComponent(productInfo.cName) + "|" + encodeURIComponent(productInfo.fSalePrice) + "|" + encodeURIComponent(productInfo.id);
                    if (productInfo.oDefaultAlbum && productInfo.oDefaultAlbum.imgUrl) {
                        goodsData = goodsData + "|" + encodeURIComponent(productInfo.oDefaultAlbum.imgUrl);
                    } else {
                        goodsData = goodsData + "|" + encodeURIComponent(" ");
                    }
                    //ICCUrl = ICCUrl + "&goodsData=" + encodeURIComponent(goodsData);
                    userParams = userParams + "&goodsData=" + encodeURIComponent(goodsData);
                    // 商品信息链接
                    // 获取公司域名信息
                    self.getWebDomainFunc(function (webDomain) {
                        var icc_cartinfo = "http://" + webDomain + "/detail?goods_id=" + productInfo.id;
                        //ICCUrl = ICCUrl + "&icc_cartinfo=" + encodeURIComponent(icc_cartinfo);
                        userParams = userParams + "&icc_cartinfo=" + encodeURIComponent(icc_cartinfo);
                        callback(ICCUrl, userParams);
                    });
                });
            } else {
                var cOrderNo = queryString.get("orderId");
                self.getOrderDetailFunc(cOrderNo, function (orderInfo) {
                    self.getVerifyTokenInfoFunc(accountInfo.id, function (verifyTokenResult) {
                        var orderUrl = "";
                        orderUrl = "http://" + verifyTokenResult.webDomain + "/member/customerServiceOrderDetail?orderId=" + orderInfo.cOrderNo + "&preview=true&corpalias=" + verifyTokenResult.alias + "&ICC=true&pcVerifyTokenICC=" + verifyTokenResult.pcVerifyToken;
                        // 订单信息webDomain
                        var orderData = encodeURIComponent(orderInfo.cOrderNo) + "|" + encodeURIComponent(orderInfo.dConfirmDate) + "|" + encodeURIComponent(orderInfo.oOrderDetails[0].DefaultImage) + "|" + encodeURIComponent(orderUrl);
                        //ICCUrl = ICCUrl + "&orderData=" + encodeURIComponent(orderData);
                        userParams = userParams + "&orderData=" + encodeURIComponent(orderData);
                        callback(ICCUrl, userParams);
                    });
                });
              
               
            }


        } else {
            callback(ICCUrl, userParams);
        }

    };
    // 获取公司的域名和别名
    widget.prototype.getWebDomainFunc = function (callback) {
        var proxy = cb.rest.DynamicProxy.create({
            getCorpration: {
                url: 'client/getCorpration',
                method: 'GET',
                options: {
                    mask: true
                }
            }
        });
        proxy.getCorpration(function (getVerifyTokenInfoErr, getVerifyTokenInfoResult) {
            if (getVerifyTokenInfoErr) {
                return;
            }
            var webDomain = getVerifyTokenInfoResult.webDomain;
            callback(webDomain);
        });
    };
    // 获取商品信息
    widget.prototype.getProductInfoFunc = function (goods_id,callback) {
        var proxy = cb.rest.DynamicProxy.create({
            getData: {
                url: 'client/Products/index',
                method: 'GET',
                options: {
                    token: true
                }
            },
        });
        proxy.getData({ id: goods_id }, function (productInfoErr, productInfoResult) {
            if (productInfoErr) {
                callback("");
                return;
            }
            callback(productInfoResult);
        });
    };
    // 获取校验token
    widget.prototype.getVerifyTokenInfoFunc = function (memberId, callback) {
        var proxy = cb.rest.DynamicProxy.create({ getVerifyTokenInfo: { url: 'client/StoreSettingController/getVerifyTokenInfo', method: 'GET', options: { token: true } } });
        proxy.getVerifyTokenInfo({ memberId: memberId }, function (verifyTokenErr, verifyTokenResult) {
            if (verifyTokenErr) {
                callback("");
                return;
            }
            callback(verifyTokenResult);
        });
    };
    // 获取订单信息
    widget.prototype.getOrderDetailFunc = function (orderId, callback) {
        var proxy = cb.rest.DynamicProxy.create({ getOrderDetail: { url: 'client/orders/getDetail', method: 'POST', options: { token: true,} }});
        proxy.getOrderDetail({ cOrderNo: orderId }, function (orderDetailErr, orderDetailResult) {
            if (orderDetailErr) {
                callback("");
                return;
            }
            callback(orderDetailResult);
        });
    };
    return widget;
});