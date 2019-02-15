cb.widgets.register('Cart_box', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
        this.initProxy();
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.returnTranserData = {};
    widget.prototype.initProxy = function () {
        var proxyConfig = {
            addCart: { url: 'client/ShoppingCarts/addCarts', method: 'POST', options: { token: true } },
            clearCart: { url: 'client/ShoppingCarts/clear', method: 'POST', options: { token: true } },
            getCartLists: { url: 'client/ShoppingCarts/getCartList', method: 'GET', options: { token: true } },
            generateOrderByShoppingCart: { url: 'client/Orders/GenerateOrderByShoppingCart', method: 'POST', options: { token: true } },
            checkiQuantity: { url: 'client/ShoppingCarts/checkiQuantity', method: 'POST', options: { token: true } },
            getContactWays: { url: 'client/Corprations/getContactWays', method: 'POST', options: { token: true } },
            deleteCart: { url: 'client/ShoppingCarts/del', method: 'POST', options: { token: true } },
            deletePackage: { url: 'client/ShoppingCarts/deletePackage', method: 'POST', options: { token: true } }
        };
        var proxy = cb.rest.DynamicProxy.create(proxyConfig);
        this._set_data('proxy', proxy);
    };

    widget.prototype.getProxy = function () {
        return { url: 'client/ShoppingCarts/getCartList', method: 'GET', options: { token: true } };
    };

    widget.prototype.getProxyData = function () {
        var inviteCode = cb.rest.AppContext.inviteCode;
        //return { isMini: true};
        if (inviteCode) {
            return { isMini: true, promoteCode: inviteCode };
        } else {
            return { isMini: true};
        }
        
    };

    widget.prototype.addCart = function (cacheData) {
        var items = [];
        cacheData.list.forEach(function (item) {
            if (item.length > 1) {
                var subItems = [];
                item.forEach(function (subItem) {
                    subItems.push({
                        iSKUId: subItem.iSKUId,
                        iQuantity: subItem.iQuantity,
                        iProductId: subItem.iProductId,
                        lPackageId: subItem.lPackageId,
                        iPackageNum: subItem.iQuantity,
                        bIsMain: subItem.bIsMain
                    });
                });
                items.push(subItems);;
            } else {
                items.push({
                    "iSKUId": item[0].iSKUId,
                    "iQuantity": item[0].iQuantity,
                    "iProductId": item[0].iProductId
                });
            }
        });
        var proxy = this._get_data('proxy');
        proxy.addCart({ items: cb.data.JsonSerializer.serialize(items) }, function (err, result) {
            if (err) {
                alert(err.message);
                this.register(cacheData);
                return;
            }
            proxy.getCartLists({}, function (err1, result1) {
                if (err1) {
                    alert(err1.message);
                    this.register(cacheData);
                    return;
                }
                cb.util.localStorage.removeItem('cartlist');
                this.register(this.transferServerData(result1));
            }, this);
        }, this);
    };

    widget.prototype.runTemplate = function (error, result) {
        if (error) {
            this.register({ list: [],allProductGiftPreferDetail:[], amount: 0, obj: { map: {}, sku: {}, product: {} } });
            return;
        }
        this.register(this.transferServerData(result));
  
    };

    widget.prototype.refresh = function (data, giftPromotion) {
        var token = cb.rest.AppContext.token;
        if (!token) {
            this.register(this.transferCacheData(), false);
        } else {
            // 是满赠的时候
            if (giftPromotion) {
                this.register(data, false);
            } else {
                var proxy = this._get_data('proxy');
                proxy.getCartLists({}, function (err, result) {
                    if (err) {
                        alert('获取失败：' + err.message);
                        this.register(this.transferCacheData(), false);
                        return;
                    }
                    this.register(this.transferServerData(result), false);
                }, this);
            }

        }
    };
    widget.prototype.refreshReplace = function () {
        var token = cb.rest.AppContext.token;
        if (!token) {
            this.register(this.transferCacheData(), false);
        } else {
            var proxy = this._get_data('proxy');
            proxy.getCartLists({}, function (err, result) {
                if (err) {
                    alert('获取失败：' + err.message);
                    this.register(this.transferCacheData(), false);
                    return;
                }
                this.register(this.transferServerData(result), false);
            }, this);

        }
    };
    widget.prototype.register = function (data, notify) {
        var self = this;
        if (notify !== false) this.execute('afterCartBoxInint', data);
        var $container = this.getElement().children('.cart_box');
        var html = this.render(data);
        $container.html(html);
        // 过滤下架和活动失效的组合商品的数量
        var minCartCount = 0;
        for (var i = 0; i < data.list.length; i++) {
            if (data.list[i][0].oSKU.iStatus == 0 || !data.list[i][0].packageValid) {

            }
            else {
                for (var j = 0; j < data.list[i].length; j++) {
                    if (data.list[i][j].oSKU.iStatus == 0 || !data.list[i][j].packageValid) {
                        if (data.list[i][j].isGiftProduct) {
                            minCartCount++;
                        }
                    } else {
                        minCartCount++;
                    }
                }
            }
        }
        if (minCartCount > 0) {
            $('.cart_number').text(minCartCount);
        } else {
            $('.cart_number').hide();
        }
       
        $('#bottomTotalCount').text(minCartCount);
        // 我的积分
        var token = cb.rest.AppContext.token;
        if (token) {
            var proxy = cb.rest.DynamicProxy.create({ getMemberPoints: { url: 'member/Members/getMemberByToken', method: 'POST', options: { token: true } } });
            // 加载个人信息
            proxy.getMemberPoints({}, function (getMemberPointsErr, getMemberPointsResult) {
                if (getMemberPointsErr) {
                    //alert("获取个人信息失败" + getMemberPointsErr.message);
                } else {
                    // 我的积分
                    if (!getMemberPointsResult.iPoints) {
                        cb.rest.AppContext.iPoints = 0;
                    } else {
                        cb.rest.AppContext.iPoints = getMemberPointsResult.iPoints;
                    }
                    var iPoints = cb.rest.AppContext.iPoints;
                    $(".cartBoxPoints").html('<span style="font-size: 12px;">我的积分 <span style="color:red;">' + iPoints + '</span>分</span>')
                }
            });
            
        }
        $container.children('div').click(function (e) {
            location.href = '/cart';
        });
        $container.find('.settleMent').click(this, function (e) {
            if (!data.list.length) {
                location.href = '/cart';
                return;
            }
            // 积分商品的处理
            var productAble = self.integralProductDeal();
            if (productAble) {
                alert("虚拟商品与实物商品不能同时结算,积分换购和现金购买的商品不能同时结算");
                return;
            }
            // 是否礼品卡或计次卡
            var isGiftOrCountCard = false;
            // 是否普通商品
            var isRealProduct = false;
            // 是否虚拟商品
            var isVirtualProduct = false;
            // 现金购买
            var cashPay = false;
            // 积分购买
            var pointsPay = false;
            // 虚拟商品属性
            // 储值卡
            var isVirtualStorageCard = false;
            // 礼品卡
            var isVirtualGiftCard = false;
            // 计次卡
            var isVirtualCountCard = false;
            // 其它虚拟商品
            var isOtherVirtualProduct = false;
            var sku = {};
            var product = {};
            var items = [];
            var itemsGiftProduct = [];
            for (var attr in data.obj.map) {
                var item = data.obj.map[attr];
                // 商品属性
                if (item.realProductAttribute == "1") {
                    isRealProduct = true;
                    isGiftOrCountCard = false;
                } else if (item.realProductAttribute == "2") {
                    isVirtualProduct = true;
                    isGiftOrCountCard = true;
                    // 虚拟商品属性
                    if (item.virtualProductAttribute == "1") {
                        isVirtualStorageCard = true;
                    } else if (item.virtualProductAttribute == "2") {
                        isVirtualGiftCard = true;
                    } else if (item.virtualProductAttribute == "3") {
                        isVirtualCountCard = true;
                    } else if (item.virtualProductAttribute == "4") {
                        isOtherVirtualProduct = true;
                    }
                }
                // 销售方式
                if (item.productAttribute == "1") {
                    cashPay = true;
                } else if (item.productAttribute == "2") {
                    pointsPay = true;
                }
                var cName = item.oSKU.oProduct.cName;
                if (!item.isGiftProduct) {
                    if (item.bIsMain == "0" && item.lPackageId) {
                        if (sku[item.iSKUId] == null) sku[item.iSKUId] = 0;
                        sku[item.iSKUId] += item.iQuantity;
                        if (sku[item.iSKUId] > data.obj.sku[item.iSKUId]) {
                            alert(cName + '该商品库存不足，请修改购买数量');
                            return;
                        }
                        if (data.obj.product[item.iProductId] != null) {
                            if (product[item.iProductId] == null) product[item.iProductId] = 0;
                            product[item.iProductId] = item.iQuantity;
                            if (product[item.iProductId] > item.canPurchaseCount) {
                                alert(cName + '不满足商品限购，请修改购买数量');
                                return;
                            }
                        }
                    } else {
                        if (sku[item.iSKUId] == null) sku[item.iSKUId] = 0;
                        sku[item.iSKUId] += item.iQuantity;
                        if (sku[item.iSKUId] > data.obj.sku[item.iSKUId]) {
                            alert(cName + '该商品库存不足，请修改购买数量');
                            return;
                        }
                        if (data.obj.product[item.iSKUId] != null) {
                            if (product[item.iSKUId] == null) product[item.iSKUId] = 0;
                            product[item.iSKUId] += item.iQuantity;
                            if (product[item.iSKUId] > data.obj.product[item.iSKUId]) {
                                alert(cName + '不满足商品限购，请修改购买数量');
                                return;
                            }
                        }
                    }
                }
               
                // 普通商品
                if ((item.packageValid == "1" && item.oSKU.iStatus == "1") && !item.isGiftProduct) {
                    items.push({
                        iSKUId: item.iSKUId,
                        iCorpId: item.iCorpId,
                        iQuantity: item.iQuantity,
                        fSalePrice: item.fSalePrice,
                        fNewSalePrice: item.fNewSalePrice,
                        iProductId: item.iProductId,
                        productAttribute:item.productAttribute,
                        id: item.id
                    });
                }
                // 赠品
                if (item.isGiftProduct) {
                    itemsGiftProduct.push({
                        iSKUId: item.iSKUId,
                        iCorpId: item.iCorpId,
                        iQuantity: item.iQuantity,
                        fSalePrice: item.fSalePrice,
                        fNewSalePrice: item.fNewSalePrice,
                        iProductId: item.iProductId,
                        productAttribute: item.productAttribute,
                        id: item.id
                    });
                }
                

            }
            // 结算时，获得全部商品满赠活动或推广码满赠活动选取的赠品
            var miniAllGiftActivedContainer = $(".miniAllGiftActivedProductList");
            var childActiveIdsArray = [];
            miniAllGiftActivedContainer.each(function () {
                itemsGiftProduct.push({
                    iSKUId: $(this).data("iskuid"),
                    iCorpId: $(this).data("icorpid"),
                    iQuantity: $(this).data("iquantity"),
                    fSalePrice: 0.00,
                    fNewSalePrice: 0.00,
                    iProductId: $(this).data("iproductid"),
                    id: $(this).data("id")
                });
               
            });
            
            if (isRealProduct && isVirtualProduct) {
                alert("虚拟商品与实物商品不能同时结算,积分换购和现金购买的商品不能同时结算");
                return;
            } else if (isRealProduct && !isVirtualProduct) {
                if (cashPay && pointsPay) {
                    alert("虚拟商品与实物商品不能同时结算,积分换购和现金购买的商品不能同时结算");
                    return;
                }
            } else if (!isRealProduct && isVirtualProduct) {
                if (cashPay && pointsPay) {
                    alert("虚拟商品与实物商品不能同时结算,积分换购和现金购买的商品不能同时结算");
                    return;
                }
            }
            var proxy = e.data._get_data('proxy');
            // 下架校验
            proxy.checkiQuantity({ items: items }, function (err1, data1) {
                if (err1) {
                    alert(err1.message);
                    return;
                }
                // 结算时加上赠品
                for (var i = 0; i < itemsGiftProduct.length; i++) {
                    items.push(itemsGiftProduct[i])
                }
                var validateResult = true;
                if (!validateResult) {
                    return;
                } else {
                    proxy.generateOrderByShoppingCart({ items: items }, function (err, data) {
                        if (err) {
                            alert(err.message);
                            return;
                        }
                        // 是普通商品
                        location.href = '/order';

                    });
                }
               
            });
        });
        var token = cb.rest.AppContext.token;
        $container.find('.clear_cart').click(this, function (e) {
            var proxy = e.data._get_data('proxy');
            if (!window.confirm('你确定要清空吗？')) {
                return;
            }
            if (!token) {
                cb.util.localStorage.removeItem('cartlist');
                e.data.register(e.data.transferCacheData());
            } else {
                proxy.clearCart(function (err, result) {
                    if (err) {
                        alert('清空购物车失败：' + err.message);
                        return;
                    }
                    e.data.register(e.data.transferServerData({lsCart:[],allProductGiftPreferDetail:[]}));
                });
            }
        });
        $container.find('.deleteBtn').click(this, function (e) {
            var $productContainer = $(this).closest('li');
            if (!$productContainer.length) return;
            var dataKey = $productContainer.attr('data-key');
            var productData = data.obj.map[dataKey];
            if (!token) {
                var cartList = cb.data.JsonSerializer.deserialize(cb.util.localStorage.getItem('cartlist')) || [];
                for (var i = 0, len = cartList.length; i < len; i++) {
                    var cart = cartList[i];
                    if (cart.length) {
                        for (var j = 0, len1 = cart.length; j < len1; j++) {
                            if (cart[j].guid + '|' + cart[j].iSKUId == dataKey) {
                                cartList[i].splice(j, 1);
                                if (cartList[i].length === 0) {
                                    cartList.splice(i, 1);
                                } else if (cartList[i].length === 1) {
                                    cartList[i] = cartList[i][0];
                                    delete cartList[i].bIsMain;
                                }
                                cb.util.localStorage.setItem('cartlist', cb.data.JsonSerializer.serialize(cartList));
                                e.data.register(e.data.transferCacheData());
                                return;
                            }
                        }
                    } else {
                        if (cart.iSKUId == dataKey) {
                            cartList.splice(i, 1);
                            cb.util.localStorage.setItem('cartlist', cb.data.JsonSerializer.serialize(cartList));
                            e.data.register(e.data.transferCacheData());
                            return;
                        }
                    }
                }
            } else {
                var delData = $(this).data();
                var items = [{
                    id: delData.id,
                    bIsMain: false
                }];
                var proxy = e.data._get_data('proxy');
                proxy.deleteCart({ items: items }, function (err, result) {
                    if (err) {
                        alert('删除失败：' + err.message);
                        return;
                    }
                    proxy.getCartLists({ isMini: true }, function (err1, result1) {
                        if (err1) {
                            alert('获取失败：' + err1.message);
                            return;
                        }
                        e.data.register(e.data.transferServerData(result1));
                    });
                });
            }
        });
        // 删除固定套餐
        $container.find('.delete-common-btn').click(this, function (e) {
            var delData = $(this).data();
            var sPackageUUID = delData.packageuuid;
            var proxy = e.data._get_data('proxy');
            proxy.deletePackage({ 'sPackageUUID': sPackageUUID }, function (err, result) {
                if (err) {
                    alert('删除失败：' + err.message);
                    return;
                }
                proxy.getCartLists({ isMini: true }, function (err1, result1) {
                    if (err1) {
                        alert('获取失败：' + err1.message);
                        return;
                    }
                    e.data.register(e.data.transferServerData(result1));
                });
            });
        });
        $('.cart_div').hover(function (e) {
            if (e.target.className == "cart_div") {
                $(".cart_box_list").show();
            } 
            
        });
        $('[data-type="Cart_box"]').mouseleave(function (e) {
            $(".cart_box_list").hide();

        });
        $('.cartBoxPointsDiv').hover(function (e) {
            $(".cart_box_list").hide();

        });
        $('.cartBoxPoints').hover(function (e) {
            $(".cart_box_list").hide();
        });
    };

    widget.prototype.transferCacheData = function () {
        var amount = 0;
        var obj = { map: {}, sku: {}, product: {} };
        var list = [];
        var cartList = cb.data.JsonSerializer.deserialize(cb.util.localStorage.getItem('cartlist')) || [];
        cartList.forEach(function (cart) {
            cart = cart.length ? cart : [cart];
            amount += cart.length;
            var items = [];
            var singleTotalPrice = 0;
            cart.forEach(function (item) {
                var content = {
                    iSKUId: item.iSKUId,
                    iQuantity: item.iQuantity,
                    bIsMain: item.bIsMain,
                    guid: item.guid,
                    canPurchaseCount: item.canPurchaseCount,
                    promotion: item.promotion,
                    packageValid: true,
                    lPackageId: item.lPackageId,
                    isLogin: 0,
                    oSKU: {
                        iProductId: item.Osku[0].iProductId,
                        iCorpId: item.Osku[0].iCorpId,
                        fSalePrice: item.Osku[0].fSalePrice,
                        fMarkPrice: item.Osku[0].fMarkPrice,
                        lInventoryCount: item.Osku[0].lInventoryCount,
                        iStatus: item.Osku[0].iStatus,
                        iMinOrderQuantity: item.Osku[0].iMinOrderQuantity,
                        oProduct: {
                            cName: item.cName,
                            id: item.Osku[0].iProductId,
                            fMarkPrice: item.Osku[0].fMarkPrice,
                            fSalePrice: item.Osku[0].fSalePrice,
                            iProductId: item.Osku[0].iProductId,
                            iStatus: item.Osku[0].iStatus
                        },
                        lsSkuSpecItems: []
                    },
                    iProductId: item.Osku[0].iProductId,
                    iCorpId: item.Osku[0].iCorpId,
                    fSalePrice: item.Osku[0].fMarkPrice,
                    fNewSalePrice: item.Osku[0].fSalePrice
                };

                content.singleProductTotalPrice = content.fNewSalePrice * content.iQuantity;
                singleTotalPrice += parseFloat(content.singleProductTotalPrice);
                content.singleTotalPrice = singleTotalPrice;
                if (item.isSpecs && item.isSpecs.length) {
                    var specObj = {};
                    item.isSpecs.forEach(function (spec) {
                        spec.lsSpecItem.forEach(function (specItem) {
                            specObj[specItem.id] = { oSpec: { cName: spec.cName }, cSpecItemName: specItem.cSpecItemName };
                        })
                    });
                    var ids = item.Osku[0].cSpecIds.split(';')
                    ids.forEach(function (id) {
                        if (specObj[id])
                            content.oSKU.lsSkuSpecItems.push(specObj[id]);
                    })
                }
                if (item.oDefaultAlbum) {
                    content.id = item.oDefaultAlbum.id;
                    // content.oSKU.oProduct.DefaultImage = item.oDefaultAlbum.cFolder + 'lm_' + item.oDefaultAlbum.cImgName;
                }
                if (content.guid) {
                    obj.map[content.guid + '|' + content.iSKUId] = content;
                } else {
                    obj.map[content.iSKUId] = content;
                }
                obj.sku[content.iSKUId] = content.oSKU.lInventoryCount;
                if (content.bIsMain !== false && content.canPurchaseCount != null)
                    obj.product[content.iProductId] = content.canPurchaseCount;
                items.push(content);
            });
            list.push(items);
        });
        return { list: list, amount: amount, obj: obj };
    };

    widget.prototype.transferServerData = function (serverData) {
        var _self = this;
        serverData = _self.getOnLineOrOffLineData(serverData);
        var map = {};
        var obj = { map: {}, sku: {}, product: {} };
        var allProductGiftPreferTemp = [];
        var allProductGiftInviteCode = [];
        // 所有商品的满赠活动以及推广码满赠活动开始
        // 截获所有满赠活动类型为全部商品及推广码的赠品开始
        for (var allGiftTitleIndex = 0; allGiftTitleIndex < serverData.allProductGiftPreferDetail.length; allGiftTitleIndex++) {
            // 判断子活动中是否有送赠品活动
            serverData.allProductGiftPreferDetail[allGiftTitleIndex].item.isShowGiftBtn = 0;
            for (var itemsIndex = 0; itemsIndex < serverData.allProductGiftPreferDetail[allGiftTitleIndex].items.length; itemsIndex++) {
                
                if (serverData.allProductGiftPreferDetail[allGiftTitleIndex].items[itemsIndex].iGiftItemType == 1) {
                    serverData.allProductGiftPreferDetail[allGiftTitleIndex].item.isShowGiftBtn = 1;
                    serverData.allProductGiftPreferDetail[allGiftTitleIndex].item.ids = serverData.allProductGiftPreferDetail[allGiftTitleIndex].items[itemsIndex].id;
                }
            }
            var allGiftProjectList = [];
            for (var allGiftListIndex = 0; allGiftListIndex < serverData.lsCart.length; allGiftListIndex++) {
                if (serverData.lsCart[allGiftListIndex].isGiftProduct&&serverData.allProductGiftPreferDetail[allGiftTitleIndex].item.iGiftPreId == serverData.lsCart[allGiftListIndex].activityId) {
                    allGiftProjectList.push(serverData.lsCart[allGiftListIndex]);
                    serverData.lsCart.splice(allGiftListIndex, 1);
                    allGiftListIndex--;
                }
            }
            serverData.allProductGiftPreferDetail[allGiftTitleIndex].allGiftProjectList = allGiftProjectList;
            // 排序，将推广码满赠放到上面
            if (serverData.allProductGiftPreferDetail[allGiftTitleIndex].prefer.isSpreadCode != 0) {
                allProductGiftPreferTemp.push(serverData.allProductGiftPreferDetail[allGiftTitleIndex]);
            } else {
                allProductGiftInviteCode.push(serverData.allProductGiftPreferDetail[allGiftTitleIndex]);
            }
          
        }
        // 排序，将推广码满赠放到上面
        for (var giftInviteCodeIndex = 0; giftInviteCodeIndex < allProductGiftInviteCode.length; giftInviteCodeIndex++) {
            allProductGiftPreferTemp.push(allProductGiftInviteCode[giftInviteCodeIndex]);
        }
        serverData.allProductGiftPreferDetail = allProductGiftPreferTemp;
        // 所有商品的满赠活动以及推广码满赠活动结束
        // 截获所有满赠活动类型为全部商品及推广码的赠品结束
        serverData.lsCart.forEach(function (item) {
            var skuid = item.iSKUId;
            if (!skuid) return;
            var uuid = item.sPackageUUID;
            if (uuid) {
                var key = 'key' + uuid;
                // 判断是固定套餐还是搭配套餐
                if (item.fixedSale == 1) {
                    item.isFixedSale = true;
                } else {
                    item.isFixedSale = false;
                }
                if (map[key]) {
                    map[key].push(item);
                    if (item.canPurchaseCount != null) {
                        if (item.canPurchaseCount < 0) {
                            item.canPurchaseCount = 0;
                        }
                        item.canPerPurchaseCount = item.canPurchaseCount;
                        if (item.isFixedSale) {
                            // 固定套餐
                            var quantityPerPackage = item.iQuantity / item.iPackageNum;
                            item.canPurchaseCount = item.canPerPurchaseCount * quantityPerPackage;
                        } else {
                            // 搭配套餐
                            item.canPurchaseCount = item.canPerPurchaseCount * map[key][0].iQuantity;
                        }
                        
                    }
                } else {
                    map[key] = [item];
                    if (item.isFixedSale) {
                        // 固定套餐
                        item.canPerPurchaseCount = item.canPurchaseCount;
                        var quantityPerPackage = item.iQuantity / item.iPackageNum;
                        item.canPurchaseCount = item.canPerPurchaseCount * quantityPerPackage;
                    }
                }
                obj.map[uuid + '|' + skuid] = item;
            } else {
               
                var skuGuid = _self.guidFunc();
                map['key' + skuGuid] = [item];
                obj.map['key' + skuGuid] = item;
            }
            obj.sku[skuid] = item.oSKU.lInventoryCount;
            if (item.bIsMain !== false && item.canPurchaseCount != null)
                obj.product[skuid] = item.canPurchaseCount;
        });
        var list = [];
        for (var key in map) {
            var val = map[key];
            if (val.length) {
                var singleTotalPrice = 0;
                var index = 0;
                val.forEach(function (item) {
                    // 如果限购小于0的处理
                    if (item.canPurchaseCount != null) {
                        if (item.canPurchaseCount < 0) {
                            item.canPurchaseCount = 0;
                            val[index].canPurchaseCount = item.canPurchaseCount;
                        }
                    }
                    index++;
                    if (item.productAttribute == 1) {
                        singleTotalPrice += item.fNewSalePrice * item.iQuantity;
                    } else if (item.productAttribute == 2) {
                        singleTotalPrice += item.oSKU.salePoints * item.iQuantity;
                    }
                   
                    // 满赠活动领取活动礼品的ID
                    item.giftActiveId = "";
                    // 满赠活动id
                    item.giftPromotionId = "";
                });
                val[0].singleTotalPrice = singleTotalPrice;
                list.push(val);
            } else {
                if (val.canPurchaseCount != null) {
                    if (val.canPurchaseCount < 0) {
                        val.canPurchaseCount = 0;
                    }
                }
                if (val.productAttribute == 1) {
                    val.singleTotalPrice = val.fNewSalePrice * val.iQuantity;
                } else if (val.productAttribute == 2) {
                    val.singleTotalPrice = val.oSKU.salePoints * val.iQuantity;
                }
                
                // 满赠活动领取活动礼品的ID
                val.giftActiveId = "";
                // 满赠活动id
                item.giftPromotionId = "";
                list.push([val]);
            }
        }
        // 固定套餐处理
        list = _self.fixedPackageFunc(list);
        list = _self.handleGiftData(list);
        return {
            list: list, allProductGiftPreferDetail: serverData.allProductGiftPreferDetail, amount: serverData.lsCart.length, obj: obj
        };
    };
    // 对购物车数据赠品进行处理
    widget.prototype.handleGiftData = function (serverData) {
        _self = this;
        var list = [];
        // 买A送A赠品临时数组
        var tempA = [];
        var map = {};
        for (var i = 0; i < serverData.length; i++) {
            if (serverData[i].length > 1) {
                list.push(serverData[i]);
            } else {
                var key = serverData[i][0].activityId;
                if (key) {
                    if (serverData[i][0].giftPreferDetail) {
                        // 判断子活动中是否有送赠品活动
                        serverData[i][0].giftPreferDetail.item.isShowGiftBtn = 0;
                        for (var itemsIndex = 0; itemsIndex < serverData[i][0].giftPreferDetail.items.length; itemsIndex++) {
                            if (serverData[i][0].giftPreferDetail.items[itemsIndex].iGiftItemType == 1) {
                                serverData[i][0].giftPreferDetail.item.isShowGiftBtn = 1;
                                serverData[i][0].giftPreferDetail.item.ids = serverData[i][0].giftPreferDetail.items[itemsIndex].id;
                            }
                        }
                        // 满A送A的特殊处理
                        if (serverData[i][0].giftPreferDetail.prefer.iGiftType == 4) {
                            if (!serverData[i][0].isGiftProduct) {
                                var keys = serverData[i][0].iProductId + "_" + key;
                                if (map[keys]) {
                                    map[keys].push(serverData[i][0]);
                                } else {
                                    map[keys] = [serverData[i][0]];
                                }

                            } else {
                                tempA.push(serverData[i][0]);
                            }
                        } else {
                            // 不是满A送A
                            if (map[key]) {
                                map[key].push(serverData[i][0]);

                            } else {
                                map[key] = [serverData[i][0]];
                            }
                        }
                    } else {
                        // 买A送A赠品
                        var keys = serverData[i][0].iProductId + "_" + key;
                        if (map[keys]) {
                            map[keys].push(serverData[i][0]);
                        } else {
                            // 不是满A送A
                            if (map[key]) {
                                map[key].push(serverData[i][0]);

                            } else {
                                map[key] = [serverData[i][0]];
                            }
                        }
                       
                    }

                } else {
                    var keys = _self.guidFunc();
                    map[keys] = [serverData[i][0]];
                }
            }
        }
        // 买A送A时将赠品和商品组合
        if (tempA.length > 0) {
            for (var key in map) {
                var value = map[key];
                if (value[0].giftPreferDetail) {
                    if (value[0].giftPreferDetail.prefer.iGiftType == 4) {
                        for (var i = 0; i < tempA.length; i++) {
                            if (tempA[i].activityId == value[0].activityId) {
                                map[key].push(tempA[i]);
                            }
                        }
                    }
                }

            }
        }
        // 买A送A时将赠品和商品组合结束
        var temp = [];
        for (var key in map) {
            var val = map[key];
            if (val.length) {
                temp.push(val);
            } else {
                temp.push([val]);
            }
        }
        for (var i = 0; i < temp.length; i++) {
            list.push(temp[i]);
        }
        widget.prototype.firstCount = false;
        return list;
    };
    // 生成唯一的key（guid）
    widget.prototype.guidFunc = function () {
        function S4() {
            return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
        }
        return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
    };
    // 积分商品的处理
    widget.prototype.integralProductDeal = function () {
        var _this = this;
        _this.integralProduct = false;
        _this.otherProduct = false;
        var productAble = false;
        var selectChks = $(".catBoxProductItems");
        // 检查是积分商品
        selectChks.each(function () {
            var isGiftCardContainer = $(this).attr('data-productAttribute');
            if (isGiftCardContainer == "1") {
                // 其它商品
                _this.otherProduct = true;
            } else if (isGiftCardContainer == "2") {
                // 积分商品
                _this.integralProduct = true;
            }
            if (_this.otherProduct && _this.integralProduct) {
                productAble = true;
            } else {
                productAble = false;
            }

        });
        return productAble;
    };
    // 根据onLineOffLine的值获得扫码购（线下购物车数据）和线上购物车数据
    widget.prototype.getOnLineOrOffLineData = function (cartList) {
        cartList.lsCart = cartList.lsCart.filter(function (item) {
            return item.onLineOffLine != 1;
        });
        return cartList
    };
    // 对固定套餐数据处理
    widget.prototype.fixedPackageFunc = function (list) {
        for (var m = 0; m < list.length; m++) {
            var fixedPackageUnable = false;
            if (list[m].length > 1 || list[m][0].lPackageId) {
                for (var n = 0; n < list[m].length; n++) {
                    // 组合套餐和固定套单位套餐餐商品数量
                    if (list[m][0].lPackageId) {
                        list[m][n].iQuantityPerPackage = list[m][n].iQuantity / list[m][n].iPackageNum;
                    }
                    // 固定套餐有一个下架就失效
                    //if (list[m][n].isFixedSale) {
                    //    if (list[m][n].fNewSalePrice) {
                    //        list[m][n].fNewSalePrice = list[m][n].fNewSalePrice / list[m][n].iQuantity;
                    //        list[m][n].fNewSalePrice = parseFloat(list[m][n].fNewSalePrice).toFixed(2);
                    //    }
                    //    if (list[m][n].fSalePrice) {
                    //        list[m][n].fSalePrice = list[m][n].fSalePrice / list[m][n].iQuantity;
                    //        list[m][n].fSalePrice = parseFloat(list[m][n].fSalePrice).toFixed(2);
                    //    }  
                    //}
                    if ((list[m][n].isFixedSale && list[m][n].oSKU.iStatus == 0) || (list[m][n].isFixedSale && !list[m][n].packageValid) || (list[m][n].isFixedSale && list[m][n].oSKU.lInventoryCount == 0) || (list[m][n].isFixedSale && list[m][n].oSKU.lInventoryCount < 0)) {
                        // 固定套餐失效
                        fixedPackageUnable = true;
                    }
                }
                if (list[m][0].isFixedSale && fixedPackageUnable) {
                    for (var fixedPackageItemIndex = 0; fixedPackageItemIndex < list[m].length; fixedPackageItemIndex++) {
                        list[m][fixedPackageItemIndex].fixedPackageUnable = true;
                    }
                }
            } else {
                list[m][0].fixedPackageUnable = false;
            }
        }
        return list;
    };
    return widget;
});