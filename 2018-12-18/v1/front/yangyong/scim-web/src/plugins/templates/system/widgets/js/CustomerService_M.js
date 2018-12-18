cb.widgets.register('CustomerService', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    var newConfig = null;
    widget.prototype.getProxy = function () {
        var isSupplier = this.isSupplier();
        if (isSupplier.isSupplier) {
            return { url: 'client/Shops/getShopById', method: 'GET' };
        } else {
            return { url: 'client/Corprations/getContactWays', method: 'GET' };
        }
    };
    widget.prototype.getProxyData = function () {
        var isSupplier = this.isSupplier();
        if (isSupplier.isSupplier) {
            return { id: isSupplier.shop_id };
        }
    };
    /**
     * 运行模板
     */
    widget.prototype.runTemplate = function (error, result) {
        var self = this;
        newConfig = this.getConfig();
        var isSupplier = this.isSupplier();
        if (isSupplier.isSupplier) {
            // 供应商电话
            newConfig.cTelephone = result.cServiceContact;
        } else {
            // 平台电话
            for (var i = 0; i < result.length; i++) {
                if (result[i].cType == "phone") {
                    newConfig.cTelephone = result[i].cContactNum;
                    break;
                }
            }
        }
        if (window.plus) {
            newConfig.app = true;
        } else {
            newConfig.app = false;
        }
        var accountInfo = JSON.parse(cb.util.localStorage.getItem('accountInfo'));
        self.ICCUrlFunc(newConfig, accountInfo, function (ICCUrl) {
           if (ICCUrl) {
               newConfig.ICCUrl = ICCUrl;
           }
           var html = self.render(newConfig);
           self.getElement().find('.floating_ck').html(html);
           if (newConfig.designer) {
               $$(".floating_ck").css("top", "50%");
           }
           if (newConfig.floatPosition == 'left') {
               self.getElement().find('.floating_ck').css('right', '');
               self.getElement().find('.floating_ck').css('left', '0px');
               self.getElement().find('.floating_ck dl dd').css('border-radius', '0 10px 10px 0');
           } else if (newConfig.floatPosition == 'right') {
               self.getElement().find('.floating_ck').css('left', '');
               self.getElement().find('.floating_ck').css('right', '0px');
               self.getElement().find('.floating_ck dl dd').css('border-radius', '10px 0 0 10px');
           }
           if (window.plus) {
               self.getElement().find('.plusPhoneBtn').on("click", function () {
                   var Phone = newConfig.cTelephone;
                   plus.nativeUI.confirm("您确定要拨打电话吗？",
                       function (event) {
                           if (event.index == 1) {
                               plus.device.dial(Phone, false);
                           } else {
                               return false;
                           }
                       }
                       , '客服消息', ['取消', '确定']
                   )
               });
           }
        });
       
    };
    // 判断是平台还是供应商
    widget.prototype.isSupplier = function () {
        var queryString = new cb.util.queryString();
        var pageString = new cb.util.getUrlparams(location.hash.substr(2));
        var isSupplierResult = {
            isSupplier: false
        }
        if (location.pathname == '/templatedesigner') {
            if (queryString.query.templatePage == 'home') {
                isSupplierResult.isSupplier = false;
            }else if(queryString.query.templatePage == 'supplier_'){
                 isSupplierResult.isSupplier = true;
            }
        } else {
            if (pageString.query.router !== 'home') {
                isSupplierResult.isSupplier = true;
                isSupplierResult.shop_id = pageString.query.shop_id;
            } else {
                isSupplierResult.isSupplier = false;
            }
        }

        return isSupplierResult;
    };
    // 友联Url
    widget.prototype.ICCUrlFunc = function (newConfig, accountInfo,callback) {
        var ICCUrl = "";
        if (newConfig.serviceICC) {
            var proxy = cb.rest.DynamicProxy.create({ getContactWayUseInfo: { url: 'client/Corprations/getContactWayUseInfo', method: 'GET' } });
            proxy.getContactWayUseInfo(function (serviceErr, serviceResult) {
                if (serviceErr) {
                    myApp.toast("获取客服配置信息失败" + err.message, "提示").show(true)
                    return;
                };
                if (serviceResult.contacyType === "3" && serviceResult.youlianUrl) {
                    // 友联客服参数
                    ICCUrl = serviceResult.youlianUrl;
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
                        if (userData) {
                            ICCUrl = ICCUrl + "&userData=" + encodeURIComponent(userData);
                        }

                    }
                } else {
                    ICCUrl = "";
                }
                callback(ICCUrl);
            });
        } else {
            callback(ICCUrl);
        }
        
    };
    return widget;
});