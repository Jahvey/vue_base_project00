
cb.widgets.register('IndexGoods', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
	widget.prototype.isGeneralProduct = true;
    widget.prototype.getProxy = function () {
        return { url: 'client/Orders/batchGetProductMainToplist', method: 'POST', options: { token: true} };
    };

    widget.prototype.getProxyData = function () {
        var self = this;
 		var config = this.getConfig();
 		if(!Array.isArray(config)){   //兼容之前的商品列表设置
        	config.id = 0;
        	config = [{'configs':config}]
        }
        if(Array.isArray(config)){
        	var queryConditionList = [];
        	var supplier = {"fieldname": "","valuefrom": ""};
        	var queryString = new cb.util.queryString();
        	config.forEach(function(conf){
	        	var cols = parseInt(conf.configs.cols) || 3;
		        conf.configs.pixels = Math.round(100 / cols);
		        var rows = parseInt(conf.configs.rows) || 2;
		        conf.configs.limit = cols * rows;
		        var params = {};
		        params.pagesize = conf.configs.limit;
		        params.pageindex = 1;
		        params.where = conf.configs.filter || [];
		        var productAttribute = { 'fieldname': 'productAttribute', 'valuefrom': '1' };
		        if (conf.configs.goodclass && conf.configs.goodclass !== 'general')
		            productAttribute.valuefrom = '2';
		        params.where.push(productAttribute);
		        if (window.plus) {
		            supplier.fieldname = "shop_id";
		            supplier.valuefrom = cb.rest.AppContext.shop_id;
		        } else {
		            if (queryString.query && queryString.query.templatePage && queryString.query.templatePage.indexOf('supplier_') > -1) {
		                var supplierId = queryString.query.templatePage.substring(queryString.query.templatePage.indexOf('supplier_') + 9);
		                supplier.fieldname = "shop_id";
		                supplier.valuefrom = supplierId;
		            } else {
		                var paramsQuery = new cb.util.getUrlparams(location.hash.substr(2));
		                supplier.fieldname = "shop_id";
		                supplier.valuefrom = paramsQuery.query.shop_id;
		            }
		        }
				params.where.push(supplier);
		        params.order = conf.configs.order;
		        queryConditionList.push(params);
        	});
        	 return {queryConditionList: queryConditionList};
        }
    };
    widget.prototype.getTemplate = function () {
        var config = this.getConfig();
        if(!Array.isArray(config)){   //兼容之前的商品列表设置
        	config.id = 0;
        	config = [{'configs':config}]
        }
        if (config[0].configs.goodStyle == 1) {
            return this.getElement().find('#groupProduct').html();
        } else if (config[0].configs.goodStyle == 2) {
            return this.getElement().find('#secKillProduct').html();
        } else {
        	return this.getElement().find('#generalProduct').html();
        }
    };
    widget.prototype.runTemplate = function (error, result) {
        var self = this;
        var _self = this;
        this.validateParams = {};
        var query = $$.parseUrlQuery(location.href);
        var backTime;
        if (error) return;
        var percent = 0;
        var intervalFlag = 0;
        var config = this.getConfig();
        if(!Array.isArray(config)){   //兼容之前的商品列表设置
        	config.id = 0;
        	config = [{'configs':config}]
        }
        for (var j = 0; j < config.length; j++) {
            // 普通商品获得店铺配置信息
            //self.getShopsSeting(result[j].data.data);
	        result[j].data.pixels = config[j].configs.pixels;
	        result[j].tabName = config[j].configs.tabPageName;
	        result[j].data.preview = cb.rest.AppContext.preview;
	        if(config[j].configs.filter[15]){
	          result[j].data.moreLink = config[j].configs.filter[15].valuefrom;
	        }else if(config[j].configs.filter[1].fieldname == "secKillbuyingdetails_id"){
	          result[j].data.moreLink = config[j].configs.filter[4].valuefrom;
	        }
	        for (var i = 0; i < result[j].data.data.length; i++) {
	            result[j].data.data[i].displayMode = config[j].configs.displayMode ? config[j].configs.displayMode : 'smallphoto';
	            result[j].data.data[i].showname = config[j].configs.showname ? config[j].configs.showname : "initial";
	            result[j].data.data[i].showsale = config[j].configs.showsale ? config[j].configs.showsale : "hidden";
	            result[j].data.data[i].showprice = config[j].configs.showprice ? config[j].configs.showprice : "initial";
	            if (config[j].configs.goodclass != undefined && config[j].configs.goodclass != "") {
	                if (config[j].configs.goodclass == "general") {
	                    result[j].data.data[i].productAttribute = false;
	                    result[j].data.data[i].fSalePrice = parseFloat(result[j].data.data[i].fSalePrice).toFixed(2);
	                } else {
	                    result[j].data.data[i].productAttribute = true;                  
	                }
	            } else {
	                result[j].data.data[i].productAttribute = false;
	            };
	            if(config[j].configs.goodStyle == 1){
	                if(result[j].data.data[i].groupBuying){
	                    if(result[j].data.data[i].groupBuying.groupBuyingRate >100){
	                        percent = 1;
	                    }else if(result[j].data.data[i].groupBuying.groupBuyingRate == 0){
	                        percent = 0;
	                    }else{
	                    percent = result[j].data.data[i].groupBuying.groupBuyingRate/100;
	                    };
	                    var perimeter = Math.PI * 2 * 21;
	                    var achievingRate = perimeter * percent + " " + perimeter;
	                    result[j].data.data[i].groupBuying.achievingRate = achievingRate;
	                    var isShowSalePrice = result[j].data.data[i].groupBuying.price < result[j].data.data[i].pfMarkPrice;//当团购价小于原价的时候   显示原价  否则  只显示团购价
	                    result[j].data.data[i].groupBuying.isShowSalePrice = isShowSalePrice;
	                    result[j].data.data[i].groupBuying.groupbuyingdetailid = self.guidFunc();
	                }                  
	                
	            } 
	        };
	        if (config[j].configs.goodStyle == 2) {
	            if (config[j].configs.filter.length > 15) {
	                if (config[j].configs.filter[14].valuefrom == "1") {
	                    if (result[j].data.data && result[j].data.data.length > 3) {
	                        result[j].data.data = result[j].data.data.slice(0, 3);
	                    }
	                }
	                for (var z = 0; z < result[j].data.data.length; z++) {
	                    result[j].data.data[z].secondKillId = self.guidFunc();
	                    if (config[j].configs.filter[15].valuefrom == "home") {
	                        result[j].data.data[z].channelUrl = config[j].configs.filter[15].valuefrom + "?flag=1";
	                    } else {
	                        result[j].data.data[z].channelUrl = "channel/" + config[j].configs.filter[15].valuefrom + "?flag=1";
	                    }
	                    
	                }
	            } else {
	                if (config[j].configs.filter.length > 5) {
	                    if (config[j].configs.filter[3].valuefrom == "1") {
	                        if (result[j].data.data && result[j].data.data.length > 3) {
	                            result[j].data.data = result[j].data.data.slice(0, 3);
	                        }
	                    }
	                    for (var z = 0; z < result[j].data.data.length; z++) {
	                        result[j].data.data[z].secondKillId = self.guidFunc();
	                        if (config[j].configs.filter[4].valuefrom == "home") {
	                            result[j].data.data[z].channelUrl = config[j].configs.filter[4].valuefrom + "?flag=1";
	                        } else {
	                            result[j].data.data[z].channelUrl = "channel/" + config[j].configs.filter[4].valuefrom + "?flag=1";
	                        }
	                        
	                    }
	                }
	            }
	        }
        }
        if (result.length > 0) {
            var widthPercent = 100 / result.length + "%";
            for (var m = 0; m < result.length; m++) {
                result[m].widthPercent = widthPercent;
            }
        }
        var html = this.render({ result: result });
        this.getElement().find('div.moreTabContainer').html(html);
        // 跳转到商品详情
        this.getElement().find('.index-to-detail').on("click", function () {
            var id = $$(this).data("id");
            myApp.mainView.router.loadPage({
                url: 'detail',
                query: {
                    goods_id: id
                }
            });
        });
        // 多页签触发事件，切换页签
        $$('.moreTabBtn').find("li").on('click', function (e) {
            var tabIndex = $$(this).attr("data-index");
            var tabContainer = $$(this).parents(".moreTabContainer").find("ul.tuanList");
            $(this).siblings().removeClass('active');
            $(this).addClass('active');
            tabContainer.each(function (index) {
                if (parseInt(index) == parseInt(tabIndex)) {
                    $$(this).css('display', 'block');
                } else {
                    $$(this).css('display', 'none');
                }
            });
        });             	
        window.setInterval(function () {
        	var backTime;
        	intervalFlag++;
            for(var j = 0; j < config.length; j++){
            	if(j == config.length)
	    	      j--;
	            for(var i = 0; i < result[j].data.data.length; i++){
	            	if(config[j].configs.goodStyle == '1'){  //团购
	            		if(result[j].data.data[i].groupBuying.iActivityStatus == '0'){
	            			backTime = cb.util.countDownFunc(result[j].data.data[i].groupBuying.now,result[j].data.data[i].groupBuying.startTime,intervalFlag);
	            		}else if(result[j].data.data[i].groupBuying.iActivityStatus == '1'){
	            			backTime = cb.util.countDownFunc(result[j].data.data[i].groupBuying.now,result[j].data.data[i].groupBuying.endTime,intervalFlag);
	            		}              
	                	result[j].data.data[i].groupBuying.backTime = backTime;
	                	$$('#endtimeLine_' + result[j].data.data[i].groupBuying.groupbuyingdetailid).text(backTime);
	            	}else if(config[j].configs.goodStyle == '2'){  //秒杀
	            		if(result[j].data.data[i].repeatSpike){
			            	var date = self.formartDate(result[j].data.data[i].beginTime);
			            	if(result[j].data.data[i].iActivityStatus == '0'){ //未开始  
			            		if(result[j].data.data[i].pStartDate > result[j].data.data[i].endTime){ //大范围的开始时间 在endTime区间之外
			            			date = new Date((date/1000+86400)*1000); //加一天操作
			            			result[j].data.data[i].pStartDate = date.format("yyyy-MM-dd hh:mm:ss");
			            		}else if(result[j].data.data[i].pStartDate < result[j].data.data[i].beginTime){
		    	            		result[j].data.data[i].pStartDate = date.format("yyyy-MM-dd hh:mm:ss");
			            		}
			            		backTime = cb.util.countDownFunc(result[j].data.data[i].now,result[j].data.data[i].pStartDate,intervalFlag);
			            	}else if(result[j].data.data[i].iActivityStatus == '1'){ //进行中
			            		result[j].data.data[i].pEndDate = result[j].data.data[i].endTime;
			            		backTime = cb.util.countDownFunc(result[j].data.data[i].now,result[j].data.data[i].pEndDate,intervalFlag);
			            	}else{ //已结束  第二天重新开始
			            		date = new Date((date/1000+86400)*1000); //加一天操作
			            		result[j].data.data[i].pStartDate = date.format("yyyy-MM-dd hh:mm:ss");
			            		if(result[j].data.data[i].pStartDate > result[j].data.data[i].pEndDate){ //如果明天开始的时间已经超过 整个活动的结束时间
									$('#seckEndtimeLine_'+result[j].data.data[i].secondKillId).parent().text('秒杀已结束');
			            		}else{
		    	            		backTime = cb.util.countDownFunc(result[j].data.data[i].now,result[j].data.data[i].pStartDate,intervalFlag);
			            		}
			            	}
	            		}else{
		            		if(result[j].data.data[i].iActivityStatus == '0'){ 
		            			backTime = cb.util.countDownFunc(result[j].data.data[i].now, result[j].data.data[i].pStartDate, intervalFlag);
		            		}else if(result[j].data.data[i].iActivityStatus == '1'){
		            			backTime = cb.util.countDownFunc(result[j].data.data[i].now, result[j].data.data[i].pEndDate, intervalFlag);
		            		}	            		
	            		}
	                	result[j].data.data[i].backTime = backTime;
	                	$$('#seckEndtimeLine_'+result[j].data.data[i].secondKillId).text(backTime);
	            	}
	            	
	            }
            }	            
        }, 1000);
        for(var j = 0; j < config.length; j++){
        		if(config[j].configs.goodStyle == 1){
		            self.getElement().find('ul li').addClass('col-100');
		        }else{
		           switch (config[j].configs.displayMode) {
		            case "bigphotolist":
		                self.getElement().find('ul li').addClass('col-100 bigphotolist');
		                break;
		            case "smallphotolist":
		                self.getElement().find('ul li').addClass('col-100 smallphotolist');
		                break;
		            case "smallphoto":
		                self.getElement().find('ul li').addClass('col-50');
		                break;
		            case "bigphoto":
		                self.getElement().find('ul li').addClass('col-100');
		                break;
		            default:
		                self.getElement().find('ul li').addClass('col-50');
		                break;
		            } 
		       }
        }
        myApp.initImagesLazyLoad(this.getParent().getView());
        
        //加入购物车
        $('.listAddCart').off('click');
        $('.listAddCart').on('click',function(e){
        	e.preventDefault();
        	e.stopPropagation();
        	_self._set_data('choseItems',{});
        	var pid = $(this).data('id');
        	_self.proxy = cb.rest.DynamicProxy.create({ getData: { url: 'client/Products/index', method: 'GET', options: { token: true, mask: false, async: true } } });
        	_self.proxy.getData({id: pid},function(err,result){
        		if(err){
        			return;
        		}
        		if(result.enableDeposit){  //定金商品，不能加入购物车
        			myApp.toast('定金商品无法加入购物车', 'tips').show(true);
        			return;
        		}
        		
        		if(result.groupBuying){  //团购商品无法加入购物车
        			myApp.toast('团购商品无法加入购物车', 'tips').show(true);
        			return;
        		}
        		var data = _self._get_data('choseItems');
        		if (result.productAttribute == 1) {
                    result.isProductAttribute = true;
                    _self.isGeneralProduct = true;
                } else if (result.productAttribute == 2) {
                    result.isProductAttribute = false;
                    _self.isGeneralProduct = false;
                }
	            var product = result;
	            result = _self.deliverTypeListFunc(result);
	            _self.productInfo = result;
	            var sku = product.lsProductSkus[0];
	            var deliveryType = "EMS";
	            if (product.lsSpecs.length == 0) {
	                // 新增功能 选择配送方式为门店自提不限购
	                if ($.find('.deliverType') && $.find('.deliverType').length) {
	                    deliveryType = $.find('.deliverType').attr("data-deliverytype");
	                    if (!deliveryType) {
	                        deliveryType = "EMS";
	                    }
	                }
	                if ((deliveryType === "PICKUP" && _self.isStoreInventory) || (_self.isEmsDispatchPlan && deliveryType === "EMS")) { // 在线物流仓库启用不限购
	                    _self._set_data('choseItems', {
	                        skuid: sku.id,
	                        quantity: $$('.noSKUQuantityManager #txtProSpecsCount').val() || 1
	                    });
	                    _self.dealAddCart(null, $$(this), product);
	                } else {
	                    if (sku && sku.lInventoryCount > 0) {
	                        //加入购物车
	                        if (product.canPurchaseCount != 0) {
	                            _self._set_data('choseItems', {
	                                skuid: sku.id,
	                                quantity: $$('.noSKUQuantityManager #txtProSpecsCount').val() || 1
	                            });
	                            _self.dealAddCart(null, $$(this), product);
	                        }
	                        else {
	                            myApp.toast('限购数量为0 无法购买', 'tips').show(true);
	                        }
	                    } else {
	                        myApp.toast('库存为0 无法购买', 'tips').show(true);
	                    }
	                }
            	} else {
	                // 新增功能 选择配送方式为门店自提不限购
	                if ($$(".deliveryItem.active") && $$(".deliveryItem.active").length) {
	                    deliveryType = $$(".deliveryItem.active").attr("data-id");
	                    if (!deliveryType) {
	                        deliveryType = "EMS";
	                    }
	                }
	                _self.dealAddCart(null, $$(this), product);
            	}
        	});
        });
    };
    widget.prototype.guidFunc = function () {
        function S4() {
            return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
        }
        return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
    };
    
    //new Date()需要的参数需要自己手动整理
    widget.prototype.formartDate = function (date) {
        var dateArr = date.substr(0, 10).split('-');
        var timeArr = date.substr(11).split(':');
        var newDate = new Date(dateArr[0], dateArr[1] - 1, dateArr[2], timeArr[0], timeArr[1], timeArr[2]);
        return newDate;
    };
    // 获取店铺配置信息
    widget.prototype.getShopsSeting = function (dataArray) {
        var self = this;
        var _self = this;
        if (dataArray && dataArray.length) {
            for (var m = 0; m < dataArray.length; m++) {
                if (dataArray[m].shop) {
                    var shopSetting = cb.rest.DynamicProxy.create({ getShopSettings: { url: 'client/Products/index', method: 'GET', options: { token: true, mask: false, async: false } } });
                    shopSetting.getShopSettings({ id: dataArray[m].pid }, function (dataErr, dataResult) {
                        if (dataErr) {
                            return;
                        } else {
                            if (dataResult && dataResult.shop && dataResult.shop.shopsetting) {
                                dataArray[m].shop.shopsetting = dataResult.shop.shopsetting;
                            }
                        }
                    });
                }
            }
        }
    };
    
    widget.prototype.dealAddCart = function (thisView, target, product) {
        var self = this;
        var data = this._get_data('choseItems');
        self.validateParams.items = data;
        var validateResult = self.execute('beforeClickCart', self.validateParams);
        if (!validateResult) {
            return;
        } else {
            if (data.skuid) { //加入购物车
                var item = {
                    iSKUId: data.skuid,
                    iProductId: product.id,
                    onLineOffLine: 0
                };
                if (product.lsSpecs.length > 0) {
                    item.iQuantity = data.quantity || 1;
                    if ($$(".deliveryItem.active") && $$(".deliveryItem.active").length) {
                        if (!$$(".SKUDeliveryList").hasClass("hide")) {
                            if ($$(".deliveryItem.active").attr("data-id")) {
                                item.dlyType = $$(".deliveryItem.active").attr("data-id");
                            }
                        }
                    } else {
                        if (self.pickupAndStoreInventory) {
                            item.dlyType = "PICKUP";
                        }
                    }
                } else {
                    item.iQuantity = 1;
                    var deliverList = [];
                    deliverList = self.noSKUdeliverTypeDeal(product);
                    if (deliverList.length) {
                        item.dlyType = deliverList[0].id;
                    }
                }
                // 加入购物车区添加区域的信息
                var areaId = cb.util.localStorage.getItem("areaid");
                var areaName = cb.util.localStorage.getItem("Areatag");
                if (areaId && areaName) {
                    item.iRegionArchiveId = areaId;
                    item.iRegionArchiveName = areaName;
                }
                if (product.enableDeposit) {
                    item.enableDeposit = true;
                }
                this.proxy = cb.rest.DynamicProxy.create({ addcart: { url: 'client/ShoppingCarts/addCarts', method: 'post', options: { token: true, mask: true, autoLogin: false } } });
                this.proxy.addcart({
                    items: cb.data.JsonSerializer.serialize([item])
                }, function (err, result) {
                    if (err && err.code === 900) {
                        cb.route.redirectLoginPage(function () {
                            if ($$('.popup-prodSUK').hasClass('modal-in'))
                                myApp.closeModal('.popup-prodSUK');
                            $$('.popup-overlay').removeClass('modal-overlay-visible');
                            myApp.mainView.router.refreshPage();
                            $$('.popup-prodSUK .content-block').remove();
                        });
                        return;
                    }
                    if (result) {
                        update.cartIcon();
                        if(!data.skuid){
                        	return;
                        }
                        if ($$('.popup-prodSUK').hasClass('modal-in'))
                            myApp.closeModal('.popup-prodSUK');
                        if(data.skuid){  //不知什么原因  成功调用后  再次点击加入购物车  会继续提示
                	        myApp.toast('加入购物车成功', 'success').show(true);
	                        $$('.popup-overlay').removeClass('modal-overlay-visible');
	                        $$('.popup-prodSUK .content-block').remove();
	                    }
                        delete data.skuid;
                        var skuResul = self._get_data('skuResult');
                        var maxCount = self._get_data('maxCount');
                        if (self.productInfo.canPurchaseCount) {
                            self.productInfo.canPurchaseCount = self.productInfo.canPurchaseCount - item.iQuantity;
                        }
                    } else {
                        myApp.toast(err.message, 'error').show(true);
                    }
                });
            } else {
                this.showSku(thisView, target);
            }
        }
    };
    
    widget.prototype.showSku = function (thisView, target) {
        var popupSku = $$('.popup-prodSUK');
        if (this.productInfo.lsProductSkus) {
            this.productInfo.lsProductSkus.forEach(function (item) {
                if (item.lInventoryCount < 0) {
                    item.lInventoryCount = 0;
                }
            });
        }
        if (this.productInfo && this.productInfo.lsSpecs && this.productInfo.lsSpecs.length && this.productInfo.lsProductSkus && this.productInfo.lsProductSkus.length) {
            this.skuPriceAreaFunc(this.productInfo, false, false);
        }
        var lsSpaces = '';
        var oDeliverTypeList = '';
        if(this.productInfo && this.productInfo.lsSpecs){
	        for(var i = 0; i<this.productInfo.lsSpecs.length; i++){
	        	lsSpaces += '<p>'+ this.productInfo.lsSpecs[i].cName +'</p><div class="col-100 lsSpecItem">';
	        	for(var j = 0; j < this.productInfo.lsSpecs[i].lsSpecItem.length; j++){
	        		lsSpaces += '<div class="attrItem" data-id=' + this.productInfo.lsSpecs[i].lsSpecItem[j].id + ' style="overflow: hidden;text-overflow: ellipsis; white-space: nowrap;max-width:100%;">'+ this.productInfo.lsSpecs[i].lsSpecItem[j].cSpecItemName + '</div>';
	        	}
	        	lsSpaces += '</div>';
	        }
        }
        if(this.productInfo && this.productInfo.oDeliverTypeList){
	        for(var i = 0; i<this.productInfo.oDeliverTypeList.length; i++){
	        	if(i == 0){
		        	oDeliverTypeList += '<div class="deliveryItem active" data-id='+this.productInfo.oDeliverTypeList[i].id +'>'+ this.productInfo.oDeliverTypeList[i].name +'</div>';
	        	}else{
	        		oDeliverTypeList += '<div class="deliveryItem" data-id='+this.productInfo.oDeliverTypeList[i].id +'>'+ this.productInfo.oDeliverTypeList[i].name +'</div>';
	        	}
	        }
        }
        var html = '<div class="content-block" style="padding:0px;">' +
        	'<p class="p-close" style="height:5%;">'+
                '<a href="#" class="close-popup"> <i class="icon icon-colse-popup"></i></a>'+
            '</p>'+
            '<div class="popup-top" style="height:15%;">'+
            	'<div class="popup-img">'+
            	   '<img src="./img/nopic.jpg" alt="" />'+
            	'</div>'+
            	'<div class="title-row">'+
            		'<div class="price priceArea">'+
            			'<span><em>￥</em><span id="priceArea">0.00</span></span>'+
            			'<del id="salePrice">￥0.00</del>'+
            		'</div>'+
            		'<div class="kucun">库存:'+this.productInfo.lInventoryCount+'</div>'+
            		'<div class="tip-chose"></div>'+
            	'</div>'+
            '</div>'+
            '<div class="popup-content" style="position: absolute; height: 60%; overflow: auto;">'+
            	'<div class="row popup-attrs">'+
            	   lsSpaces +
                   '<div class="SKUDeliveryList hide">'+
                   		'<p>配送方式</p>'+
                   		'<div class="col-100 delivery">'+
                   		  oDeliverTypeList +
                   		'</div>'+
                   	'</div>'+
                   	'<div class="col-100 list-block media-list detailSkuPropertys hide" style="margin:0px !important;"><ul></ul></div>'+
            		'<div class="productNumberManage">'+
            			'<p>购买数量<span id="InventoryCount"></span></p>'+
            			'<div class="numberManage col-100">'+
	            			'<i class="icon icon-cart-less disabled" style="right:0"></i>'+
	            			'<input type="text" id="txtProSpecsCount" class="editControl" value=1 />'+
	            			'<i class="icon icon-cart-add" style="left:0"></i>' +
                            '<span style="font-size:12px;margin-left:5px;" class="unit_name">' + this.productInfo.unit_name + '</span>' +
	            			'<span id="promotion" style="color:red;font-size:12px;"></span>'+
	            			'<span id="canPurchaseCount" style="color:red;font-size:12px;"></span>'+
            			'</div>'+
            			'<p style="color: red; font-size: 12px; padding: 15px 0px;" class="skuLimitTip"></p>'+
            		'</div>'+
            	'</div>'+
            '</div>'+
            '<div style="height:20%;width:100%;margin-top:100%;" class="btn-groups-sku"><div class="popup-bottom  btn-update-sku updateDetailSku">确  定</div></div>' +
        '</div>';
        $$('.popup-prodSUK').html(html);
        if (window.plus) {
            popupSku.find('.updateDetailSku').css('position', 'relative !important');
            if (isIos) {
                popupSku.find('.btn-groups-sku').css('margin-top', '95%');
            } else {
                popupSku.find('.btn-groups-sku').css('margin-top', '90%');
            }
        }
        if(this.productInfo.oDefaultAlbum && this.productInfo.oDefaultAlbum.imgUrl){
        	$$('.popup-prodSUK .popup-img img').attr('src',this.productInfo.oDefaultAlbum.imgUrl);
        }
        
        if(this.productInfo.promotion){
        	if(this.productInfo.promotion.lTypeName){
	        	$('#promotion').text(this.productInfo.promotion.lTypeName);
        	}
        }else{
        	if(this.productInfo.canPurchaseCount){
        		$('#promotion').text('还可购买'+this.productInfo.canPurchaseCount+'件');
        	}
        }
        
        if(this.productInfo.canPurchaseCount == 0){
        	if(this.productInfo.promotion && this.productInfo.promotion.cPurchaseLimitHint){
        		$('.skuLimitTip').text(this.productInfo.promotion.cPurchaseLimitHint);
        	}
        }
        if (this.productInfo.canPurchaseCount == 0 || this.productInfo.canPurchaseCount < 0) {
            $$(".skuLimitTip").removeClass("hide");
        } else {
            $$(".skuLimitTip").addClass("hide");
        }
        if(this.productInfo.priceArea){
        	if(this.productInfo.isProductAttribute){
        		if(this.productInfo.groupBuying){
        			$('#priceArea').text(this.productInfo.priceArea);
        			if(this.productInfo.groupBuying.salePrice){
	        			$('#salePrice').text(this.productInfo.groupBuying.salePrice);
        			}
        		}else{
        			$('#priceArea').text(this.productInfo.priceArea);
        			if(this.productInfo.fMarkPrice){
        				
        			}
        		}
        	}else{
        		$('#priceArea').text('0积分');
        	}
        }else{
        	if(this.productInfo.isProductAttribute){
        		if(this.productInfo.groupBuying){
        			$('#priceArea').text(this.productInfo.groupBuying.salePrice);
        			if(this.productInfo.groupBuying.salePrice){
	        			$('#salePrice').text(this.productInfo.groupBuying.salePrice);
        			}
        		}else{
        			$('#priceArea').text(this.productInfo.fSalePrice);
        			if(this.productInfo.fMarkPrice){
        				$('#salePrice').text(this.productInfo.fMarkPrice);
        			}
        		}
        	}else{
        		if(this.productInfo.salePoints){
        			$('#priceArea').text(this.productInfo.salePoints+'积分');
        		}else{
	        		$('#priceArea').text('0积分');
        		}
        	}
        }
        if (this.productInfo.deposits) {
            $('.join-cart').addClass('hide');
            $('.now-order').css({ width: '66%' });
        }
        this.setPopupContentHeight(popupSku)
        var skus = this.productInfo.lsProductSkus;
        var skuResult = this.initSKU(skus);
        this._set_data('skuResult', skuResult);
        this.initializeHasSku(skuResult, $$('.popup-prodSUK'));
        this.registerPopupBtn(this.productInfo);
        if (isIos)
            $$('.popup-prodSUK').find('#txtProSpecsCount').addClass('ios-editControl');
    };
    // 配送方式数据处理
    widget.prototype.deliverTypeListFunc = function (result) {
        var self = this;
        // 是否启用库存计划
        self.isStoreInventory = result.isStoreInventory;
        // 是否启用在线物流仓库
        self.isEmsDispatchPlan = result.isEmsDispatchPlan;
        // 启用了店存计划并且只有门店自提
        self.pickupAndStoreInventory = false;
        var oDeliverTypeList = [];
        // 处理门店自提数据
        if (result.cOptionDlyType) {
            if (result.cOptionDlyType.indexOf("EMS") > -1) {
                if (result.emsShowName) {
                    oDeliverTypeList.push({name: result.emsShowName, id: "EMS"})
                } else {
                    oDeliverTypeList.push({name: "快递物流", id: "EMS"})
                };
            }
            if (result.cOptionDlyType.indexOf("PICKUP") > -1 && !result.iShopId) {
                if(result.pickupShowName){
                    oDeliverTypeList.push({ name:result.pickupShowName, id: "PICKUP" })
                }else{
                    oDeliverTypeList.push({name:"门店自提",id:"PICKUP"})
                }
            }
            if (result.cOptionDlyType.indexOf("STOREDELIVERY") > -1) {
                if(result.deliveryShowName){
                    oDeliverTypeList.push({ name:result.deliveryShowName, id: "STOREDELIVERY" })
                }else{
                    oDeliverTypeList.push({name:"门店配送",id:"STOREDELIVERY"})
                }
            }
        } else {
            oDeliverTypeList = [];
        }
        result.oDeliverTypeList = oDeliverTypeList;
        self.deliverTypeOfSKUFunc(result);
        return result;
    };
    // 没有SKU的商品配送方式处理
    widget.prototype.noSKUdeliverTypeDeal = function (result) {
        var self = this;
        var oDeliverTypeList3 = [];
        // 处理商城配置中的配送方式
        var oDeliverTypeList1 = [];
        if (result.cOptionDlyType) {
            if (result.cOptionDlyType.indexOf("EMS") > -1) {
                if (result.emsShowName) {
                    oDeliverTypeList1.push({name: result.emsShowName, id: "EMS"})
                } else {
                    oDeliverTypeList1.push({name: "快递物流", id: "EMS"})
                };
            }
            if (result.cOptionDlyType.indexOf("PICKUP") > -1 && !result.iShopId) {
                if(result.pickupShowName){
                    oDeliverTypeList1.push({ name:result.pickupShowName, id: "PICKUP" })
                }else{
                    oDeliverTypeList1.push({name:"门店自提",id:"PICKUP"})
                }
            }
            if (result.cOptionDlyType.indexOf("STOREDELIVERY") > -1) {
                if(result.deliveryShowName){
                    oDeliverTypeList1.push({ name:result.deliveryShowName, id: "STOREDELIVERY" })
                }else{
                    oDeliverTypeList1.push({name:"门店配送",id:"STOREDELIVERY"})
                }
            }
        } else {
            oDeliverTypeList1 = [];
        }
        // 处理商品订单属性中的配送方式
        var oDeliverTypeList2 = [];
        if (!result.lsSpecs.length && result.lsProductSkus.length) {
            if (result.lsProductSkus[0].skuPropertys && result.lsProductSkus[0].skuPropertys.length) {
                for (var j = 0; j < result.lsProductSkus[0].skuPropertys.length; j++) {
                    if (result.lsProductSkus[0].skuPropertys[j].propertyTypeName === "配送方式") {
                        if (result.lsProductSkus[0].skuPropertys[j].promptMessage) {
                            result.lsProductSkus[0].skuPropertys[j].promptMessageArray = result.lsProductSkus[0].skuPropertys[j].promptMessage.split("|");
                        }
                        // 处理SKU上的配送方式
                        var deliverTypeList = result.lsProductSkus[0].skuPropertys[j].promptMessageArray;
                        if (deliverTypeList && deliverTypeList.length) {
                            for (var m = 0; m < deliverTypeList.length; m++) {
                                if (deliverTypeList[m] === "快递物流" || deliverTypeList[m] === "快递") {
                                    oDeliverTypeList2.push({ name: "快递物流", id: "EMS" });
                                }
                                if (deliverTypeList[m] === "门店自提") {
                                    oDeliverTypeList2.push({ name: "门店自提", id: "PICKUP" });
                                }
                                if (deliverTypeList[m] === "门店配送") {
                                    oDeliverTypeList2.push({ name: "门店配送", id: "STOREDELIVERY" });
                                }
                            }
                        }

                    }
                }
            }
        }
        if (!oDeliverTypeList2.length) {
            oDeliverTypeList3 = oDeliverTypeList1;
        } else {
            for (var index1 = 0; index1 < oDeliverTypeList1.length; index1++) {
                for (var index2 = 0; index2 < oDeliverTypeList2.length; index2++) {
                    if (oDeliverTypeList1[index1].id === oDeliverTypeList2[index2].id) {
                        oDeliverTypeList3.push(oDeliverTypeList1[index1]);
                    }
                }
            }
        }
        return oDeliverTypeList3;
    };
    // SKU配送方式初始化处理
    widget.prototype.deliverTypeOfSKUFunc = function (result) {
        var self = this;
        if (result.lsProductSkus && result.lsProductSkus.length) {
            // 商城配置中只有一种或没有配送方式不处理SKU的配送方式
            if (result.oDeliverTypeList && result.oDeliverTypeList.length) {
                for (var i = 0; i < result.lsProductSkus.length; i++) {
                    if (result.lsProductSkus[i].skuPropertys && result.lsProductSkus[i].skuPropertys.length) {
                        for (var j = 0; j < result.lsProductSkus[i].skuPropertys.length; j++) {
                            if (result.lsProductSkus[i].skuPropertys[j].propertyTypeName === "配送方式") {
                                if (result.lsProductSkus[i].skuPropertys[j].promptMessage) {
                                    result.lsProductSkus[i].skuPropertys[j].promptMessageArray = result.lsProductSkus[i].skuPropertys[j].promptMessage.split("|");
                                }
                                // 处理每个SKU上的配送方式
                                var skuDeliveryArr = [];
                                var deliverTypeList = result.lsProductSkus[i].skuPropertys[j].promptMessageArray;
                                if (deliverTypeList && deliverTypeList.length) {
                                    for (var m = 0; m < deliverTypeList.length; m++) {
                                        if (deliverTypeList[m] === "快递物流" || deliverTypeList[m] === "快递") {
                                            skuDeliveryArr.push('EMS');
                                        }
                                        if (deliverTypeList[m] === "门店自提") {
                                            skuDeliveryArr.push('PICKUP');
                                        }
                                        if (deliverTypeList[m] === "门店配送") {
                                            skuDeliveryArr.push('STOREDELIVERY');
                                        }
                                    }
                                }
                                result.lsProductSkus[i].SKUDeliverList = skuDeliveryArr;
                            }
                        }
                    }
                }
                self.deliverTypeOutSKUFunc(result);
            } else {
                // 商城配种中只有一种或没有配送方式不处理SKU配送方式条件下，处理商城配置中的配送方式
                self.deliverTypeOutSKUFunc(result);
            }
        }
    };
    // SKU的配送方式不符合商城配置中的配送方式或商城配置中只有一种配送方式处理
    widget.prototype.deliverTypeOutSKUFunc = function (result) {
        var self = this;
        // 只启用店存计划，不启用其它配送方式，则商品上不显示配送方式
        if (result.isStoreInventory && !self.isEmsDispatchPlan) {
            if (result.cOptionDlyType) {
                if (result.cOptionDlyType.indexOf("PICKUP") > -1 && result.cOptionDlyType.indexOf("EMS") == -1 && result.cOptionDlyType.indexOf("SelfTake") == -1) {
                    self.pickupAndStoreInventory = true;
                    result.oDeliverTypeList = [];
                }
            } else {
                result.oDeliverTypeList = [];
            }
            
        } else if (!result.isStoreInventory && !self.isEmsDispatchPlan) {
            // 不启用店存计划，不显示配送方式 此功能失效
            result.oDeliverTypeList = [];
        }
    }
    // 选择规格确定SKU后SKU处理
    widget.prototype.SKUConfirmFunc = function (result, selectedidsArr, _self) {
        var self = this;
        var selectSpecsIds = selectedidsArr.join(';');
        for (var i = 0; i < result.lsProductSkus.length; i++) {
            if (self.isSelectSKU(selectedidsArr, result.lsProductSkus[i].cSpecIds)) {
                  // SKU上没有配送方式。按原来方式处理，使用商城配置中的配送方式
                if (!result.lsProductSkus[i].SKUDeliverList || result.lsProductSkus[i].SKUDeliverList.length==0){
                    if (result.oDeliverTypeList && result.oDeliverTypeList.length) {
                        var SKUDeliveryHtml0 = "";
                        for (var k = 0; k < result.oDeliverTypeList.length; k++) {
                            if (k === 0) {
                                SKUDeliveryHtml0 = '<div class="deliveryItem active" data-id="' + result.oDeliverTypeList[k].id + '">' + result.oDeliverTypeList[k].name + '</div>';
                            } else {
                                SKUDeliveryHtml0 = SKUDeliveryHtml0 + '<div class="deliveryItem" data-id="' + result.oDeliverTypeList[k].id + '">' + result.oDeliverTypeList[k].name + '</div>';
                            }
                        }
                        if (SKUDeliveryHtml0) {
                            SKUDeliveryHtml0 = '<p>配送方式</p><div class="col-100 delivery">' + SKUDeliveryHtml0 + '</div>';
                            $$(_self).parents(".popup-attrs").find(".SKUDeliveryList").html(SKUDeliveryHtml0);
                            $$(_self).parents(".popup-attrs").find(".SKUDeliveryList").removeClass("hide");
                            $$('.popup-prodSUK').find('.updateDetailSku').removeClass("disabled");
                            $$('.detailAddCart').removeClass('disabled');
                        }
                        self.deliveryClickFunc();
                    } else {
                        // 隐藏
                        $$(_self).parents(".popup-attrs").find(".SKUDeliveryList").addClass("hide");
                    }
                }
                // SKU上有配送方式,与商城配置取交集
                if (result.lsProductSkus[i].SKUDeliverList && result.lsProductSkus[i].SKUDeliverList.length) {
                    var tempData = result.lsProductSkus[i].SKUDeliverList;
                    var SKUDeliveryHtml = "";
                    if (tempData && tempData.length > 0) {
                        var skuDeliveryStr = tempData.join("");
                        var newDeliverTypeList = [];
                        for (var deliveryIndex = 0; deliveryIndex < result.oDeliverTypeList.length; deliveryIndex++) {
                            if (skuDeliveryStr.indexOf('EMS') > -1 && result.oDeliverTypeList[deliveryIndex].id == 'SelfTake') {
                                newDeliverTypeList.push(result.oDeliverTypeList[deliveryIndex]);
                            }
                            if (skuDeliveryStr.indexOf(result.oDeliverTypeList[deliveryIndex].id) > -1) {
                                newDeliverTypeList.push(result.oDeliverTypeList[deliveryIndex]);
                            }
                        }
                        self.commonDeliveryList=newDeliverTypeList;
                        if(newDeliverTypeList.length==0){
                            $$(_self).parents(".popup-attrs").find(".SKUDeliveryList").addClass("hide");
                            $$('.popup-prodSUK').find('.updateDetailSku').addClass("disabled");
                            $$('.detailAddCart').addClass('disabled');
                            myApp.toast('所选配送方式有误，请与商家联系','tips').show(true);
                        }else{
                            for (var j = 0; j < newDeliverTypeList.length; j++) {
                                if (j === 0) {
                                    SKUDeliveryHtml = '<div class="deliveryItem active" data-id="' + newDeliverTypeList[j].id + '">' + newDeliverTypeList[j].name + '</div>';
                                } else {
                                    SKUDeliveryHtml = SKUDeliveryHtml + '<div class="deliveryItem" data-id="' + newDeliverTypeList[j].id + '">' + newDeliverTypeList[j].name + '</div>';
                                }
                            }
                            if (SKUDeliveryHtml) {
                                SKUDeliveryHtml = '<p>配送方式</p><div class="col-100 delivery">' + SKUDeliveryHtml + '</div>';
                                $$(_self).parents(".popup-attrs").find(".SKUDeliveryList").html(SKUDeliveryHtml);
                                $$(_self).parents(".popup-attrs").find(".SKUDeliveryList").removeClass("hide");
                                $$('.popup-prodSUK').find('.updateDetailSku').removeClass("disabled");
                                $$('.detailAddCart').removeClass('disabled');
                            }
                            self.deliveryClickFunc();
                        }
                    }    
                }
                // 选择SKU确定后扩展属性提示语处理
                var skuPropertysOfDealData = self.propertyTipFunc(result.lsProductSkus[i].skuPropertys);
                if (skuPropertysOfDealData && skuPropertysOfDealData.length) {
                    var skuPropertysHtml = "";
                    for (var m = 0; m < skuPropertysOfDealData.length; m++) {
                        skuPropertysHtml = skuPropertysHtml + ' <li class="label-checkbox item-content">'
                            + '<div class="item-inner no-border">'
                            + '<div class="item-title-row">'
                            + '<div class="item-title">' + skuPropertysOfDealData[m].propertyName + '</div>'
                            + '<div class="item-after">'
                            + '<textarea readonly="readonly">' + skuPropertysOfDealData[m].promptMessage + '</textarea>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
                            + '</li>';
                    }
                    if (skuPropertysHtml) {
                        $$(_self).parents(".popup-attrs").find(".detailSkuPropertys").find("ul").html(skuPropertysHtml);
                        $$(_self).parents(".popup-attrs").find(".detailSkuPropertys").removeClass("hide");
                    }
                } else {
                    $$(_self).parents(".popup-attrs").find(".detailSkuPropertys").addClass("hide");
                }
            }
        }

    };
    
    // 有sku情况下，弹出sku没有选中时显示价格区间
    widget.prototype.skuPriceAreaFunc = function (result, selectSpecsIdArr, isClicked) {
        // 团购的普通商品取团购价
        if (result.groupBuying && result.productAttribute == 1) {
            result.priceArea = result.fSalePrice
        } else {
            var priceArea = "";
            if (selectSpecsIdArr && selectSpecsIdArr.length) {
                var priceAreaArray = [];
                for (var j = 0; j < result.lsProductSkus.length; j++) {
                    if (result.lsProductSkus[j].cSpecIds) {
                        var isFromSpecsId = true;
                        for (var i = 0; i < selectSpecsIdArr.length; i++) {
                            if (result.lsProductSkus[j].cSpecIds.indexOf(selectSpecsIdArr[i]) > -1) {

                            } else {
                                isFromSpecsId = false;
                            }
                        }
                        if (isFromSpecsId) {
                            priceAreaArray.push(result.lsProductSkus[j].fSalePrice);
                        }
                    }
                }
                if (priceAreaArray.length > 0) {
                    var minMprice = Math.min.apply(null, priceAreaArray);
                    var maxMprice = Math.max.apply(null, priceAreaArray);
                    if (result.productAttribute == 1) {
                        if (minMprice == maxMprice) {
                            priceArea = minMprice;
                        } else if (result.groupBuying) {
                            priceArea = result.fSalePrice;
                        }
                        else {
                            priceArea = minMprice + "-￥" + maxMprice;
                        }

                    } else {
                        if (minMprice == maxMprice) {
                            priceArea = minMprice + "积分";
                        } else if (result.groupBuying) {
                            priceArea = result.salePoints;
                        }
                        else {
                            priceArea = minMprice + "积分-" + maxMprice + "积分";
                        }
                    }
                }
                if (priceArea) {
                    var priceAreaContent = "<span><em>￥</em>" + priceArea + "</span><del></del>";
                    $$(".priceArea").html(priceAreaContent);
                }

            } else {
                if (result && result.lsSpecs && result.lsSpecs.length && result.lsProductSkus && result.lsProductSkus.length) {
                    if (result.productAttribute == 1) {
                        var minMprice = result.lsProductSkus[0].fSalePrice;
                        var maxMprice = result.lsProductSkus[0].fSalePrice;
                        for (var i = 0; i < result.lsProductSkus.length; i++) {
                            if (i > 0) {
                                if (minMprice > result.lsProductSkus[i].fSalePrice) {
                                    minMprice = result.lsProductSkus[i].fSalePrice;
                                }
                                if (maxMprice < result.lsProductSkus[i].fSalePrice) {
                                    maxMprice = result.lsProductSkus[i].fSalePrice;
                                }
                            }
                        }

                        if (minMprice == maxMprice) {
                            priceArea = minMprice;
                        } else if (result.groupBuying) {
                            priceArea = result.fSalePrice;
                        } else {
                            priceArea = minMprice + "-￥" + maxMprice;
                        }
                    } else {
                        var minMprice = result.lsProductSkus[0].salePoints;
                        var maxMprice = result.lsProductSkus[0].salePoints;
                        for (var i = 0; i < result.lsProductSkus.length; i++) {
                            if (i > 0) {
                                if (minMprice > result.lsProductSkus[i].salePoints) {
                                    minMprice = result.lsProductSkus[i].salePoints;
                                }
                                if (maxMprice < result.lsProductSkus[i].salePoints) {
                                    maxMprice = result.lsProductSkus[i].salePoints;
                                }
                            }
                        }

                        if (minMprice == maxMprice) {
                            priceArea = minMprice + "积分";
                        } else if (result.groupBuying) {
                            priceArea = result.salePoints;
                        }
                        else {
                            priceArea = minMprice + "积分-" + maxMprice + "积分";
                        }
                    }
                    if (isClicked && priceArea) {
                        var priceAreaContent = "<span><em>￥</em>" + priceArea + "</span><del></del>";
                        $$(".priceArea").html(priceAreaContent);
                    }
                    result.priceArea = priceArea;
                }
            }
        }
        return result;
    };
    
     // 选择规格确定SKU后选择配送方式事件处理
    widget.prototype.deliveryClickFunc = function () {
        var self = this;
        // 配送方式选择事件
        $$('.popup-prodSUK').find('.deliveryItem').on('click', function () {
            var deliveryItems = $$('.popup-prodSUK').find('.deliveryItem');
            deliveryItems.each(function () {
                if ($$(this).hasClass("active")) {
                    $$(this).removeClass("active");
                }
            });
            $$(this).addClass("active");
            if (($$(".deliveryItem.active").attr("data-id") == "PICKUP" && self.isStoreInventory) || (self.isEmsDispatchPlan && $$(".deliveryItem.active").attr("data-id") == "EMS")) { // 启用在线物流仓库并且快递物流不限购
                $$('.popup-prodSUK .numberManage').children().removeClass('disabled');
                $$('.icon-cart-add').removeClass('disabled');
                $$('.popup-prodSUK .btn-update-sku').removeClass('disabled');
                $$('.popup-prodSUK .popup-bottom.btn-groups div').removeClass('disabled');
            } else {
                var maxCount = self._get_data('maxCount');
                var quantity = $$('.popup-prodSUK .numberManage input').val();
                if (parseInt(quantity) > maxCount) {
                    if (maxCount > 0) {
                        $$('.popup-prodSUK .numberManage input').val(maxCount);
                    } else {
                        $$('.popup-prodSUK .numberManage input').val("1");
                    }

                }
                if (maxCount <= 0) {
                    $$('.popup-prodSUK .btn-update-sku').addClass('disabled');
                    $$('.popup-prodSUK .popup-bottom.btn-groups div').addClass('disabled');
                    $$('.popup-prodSUK .numberManage input').addClass('disabled');
                    $$('.popup-prodSUK .numberManage i').addClass('disabled');
                } else {
                    $$('.popup-prodSUK .btn-update-sku').removeClass('disabled');
                    $$('.popup-prodSUK .popup-bottom.btn-groups div').removeClass('disabled');
                    $$('.popup-prodSUK .numberManage input').removeClass('disabled');
                    $$('.popup-prodSUK .numberManage i').removeClass('disabled');
                }
            }
        });
    };
    
    widget.prototype.initializeHasSku = function (skuResult, popup) {
        var self = this;
        $$('.popup-prodSUK .numberManage').children().addClass('disabled');
        $$('.popup-prodSUK .btn-update-sku,.btn-groups div').addClass('disabled');
        this.clickItems(skuResult);
        var data = this._get_data('choseItems');
        if (!data.choseItem || (data.choseItem && data.choseItem.length == 0)) {
            this.setTipsAboutChose(popup);
        }
        // 启用在线物流仓库并且快递物流不限购
        if (($$(".deliveryItem.active") && $$(".deliveryItem.active").attr("data-id") == "PICKUP" && self.isStoreInventory) || self.pickupAndStoreInventory || (self.isEmsDispatchPlan && $$(".deliveryItem.active") && $$(".deliveryItem.active").attr("data-id") == "EMS")) {
            $$('.popup-prodSUK .numberManage').children().removeClass('disabled');
            $$(this).nextAll('.icon-cart-add').removeClass('disabled');
        }
        myApp.popup('.popup-prodSUK');
    }
    
    widget.prototype.setPopupContentHeight = function (popupSku) {
        //使用脚本控制sku popup 中内容去的高度 
        //49是最后btn高度  25是距离上面的padding值
        var others = popupSku.find('.p-close').outerHeight() +
            popupSku.find('.popup-top').outerHeight() +
            popupSku.find('.popup-bottom').outerHeight() + 49 + 20
        var popupHeight = popupSku.outerHeight();
        popupSku.find('.popup-content').css('height', popupHeight - others + 'px');
    };
    
    widget.prototype.clickItems = function (skuResult) {
        var that = this;
        var data = this._get_data('choseItems');
        var popup = $$('.popup-prodSUK');
        var items = popup.find('.popup-attrs div.attrItem');
        items.each(function () {
            var self = $$(this);
            var specid = self.attr('data-id');
            if (!skuResult[specid])
                self.attr('disabled', 'disabled');
        }).click(function (e) {
            var self = $$(this);
            if (self.attr('disabled') == 'disabled') return;
            self.nextAll().removeClass('active');
            self.prevAll().removeClass('active');
            self.toggleClass('active');
            var selectedspecs = popup.find('.popup-attrs div.attrItem.active');
            var specsArray = popup.find('.popup-attrs div.lsSpecItem');
            var selectedids = [];
            selectedspecs.each(function () {
                selectedids.push($$(this).attr('data-id'));
            });
            selectedids.sort(function (val1, val2) {
                return parseInt(val1) - parseInt(val2);
            });
            // 算价格区间
            if (selectedids.length < specsArray.length) {
                that._set_data('choseItems', {});
                if (selectedids.length === 0) {
                    that.skuPriceAreaFunc(that.productInfo, selectedids, true);
                } else {
                    that.skuPriceAreaFunc(that.productInfo, selectedids, true);
                }

            }
            // 商品每个SKU的配送方式
            if (selectedids.length === specsArray.length) {
                // SKU确定之后处理配送方式
                that.SKUConfirmFunc(that.productInfo, selectedids, this);
            } else {
                // SKU没有确定隐藏配送方式
                $$(this).parents(".popup-attrs").find(".SKUDeliveryList").addClass("hide");
                //  SKU没有确定隐藏订单属性提示语
                $$(this).parents(".popup-attrs").find(".detailSkuPropertys").addClass("hide");
            }
            //sku配送方式交集是否为零;
            if (!(that.commonDeliveryList && that.commonDeliveryList.length == 0)) {
                var len = selectedids.length;
                var sku = skuResult[selectedids.join(';')];
                if (sku && sku.length) {
                    that.productInfo.skuid = sku.ids[0];
                }
                that.resetProp(sku, popup, len, that);
                //处理当前选中项无法匹配的其他规格项
                otherNopick = items.filter(function (index, el) {
                    return !($$(this).hasClass('active'));
                });
                otherNopick.each(function () {
                    $$(this).addClass('special-attrItem');
                    var siblingsselectedspec = $$(this).parent().children('div.attrItem').filter(function (idnex, el) {
                        return !($$(this).hasClass('special-attrItem')) && $$(this).hasClass('active');
                    });
                    $$(this).removeClass('special-attrItem');
                    var testspecids = [];
                    if (siblingsselectedspec.length) {
                        var siblingsselectedid = siblingsselectedspec.attr('data-id');
                        for (var i = 0; i < len; i++) {
                            (selectedids[i] != siblingsselectedid) && testspecids.push(selectedids[i]);
                        }
                    } else {
                        testspecids = selectedids.concat();
                    }
                    testspecids = testspecids.concat($$(this).attr('data-id'));
                    testspecids.sort(function (val1, val2) {
                        return parseInt(val1) - parseInt(val2);
                    });
                    if (!skuResult[testspecids.join(';')]) {
                        $$(this).attr('disabled', 'disabled').removeClass('active');
                    } else {
                        $$(this).removeAttr('disabled');
                    }
                });
            }
            });
    };
    
    widget.prototype.resetProp = function (sku, popup, len, that) {
        var self = this;
        var product = this.productInfo;
        var data = this._get_data('choseItems');
        popup.find('.numberManage input').val(1);
        var disabledDom = popup.find('.btn-update-sku,.numberManage i,.numberManage input,.popup-bottom.btn-groups div');
        var showPriceBox = popup.find('.popup-top .price');
        var salePrice = showPriceBox.find('span');
        var markPrice = showPriceBox.find('del');
        var kucun = popup.find('.popup-top .kucun');
        if (sku) {
            if (len == that.productInfo.lsSpecs.length) {
                disabledDom.removeClass('disabled');
                if (!this.isGeneralProduct) {
                    salePrice.html(sku.prices[0] + '积分');
                } else {
                    // 不是团购活动的商品
                    if (!product.groupBuying) {
                        salePrice.html('￥' + sku.prices[0]);
                    }
                }
                // 不是团购活动的商品
                if (sku.markPrices && sku.markPrices.length && sku.markPrices[0]) {
                    if (!product.groupBuying) {
                        markPrice.removeClass("hide");
                        markPrice.html('￥' + sku.markPrices[0]);
                    }
                } else {
                    markPrice.addClass("hide");
                }
                kucun.html('库存：' + sku.count);
                // 库存为0加入购物车和立即购买按钮不可用
                if (sku.count > 0) {
                    disabledDom.removeClass('disabled');
                } else {
                    popup.find('.btn-update-sku').removeClass('disabled');
                    popup.find('.popup-bottom.btn-groups div').removeClass('disabled');
                    popup.find('.numberManage input').removeClass('disabled');
                    popup.find('.numberManage i').removeClass('disabled');
                    // disabledDom.addClass('disabled');
                }
                data.skuid = sku.ids[0];
                this._set_data('sku', sku);
                //var xiangou = this.productInfo.canPurchaseCount;
                // SKU促销限购和商品促销限购处理
                var xiangou = self.promotionLimitFunc(data.skuid, this.productInfo);
                if (xiangou || xiangou === 0) {
                    var maxCount = xiangou < sku.count ? xiangou : sku.count
                } else {
                    var maxCount = sku.count;
                }
                if (maxCount <= 0) {
                    disabledDom.addClass('disabled');
                } else {
                    popup.find('.btn-update-sku').removeClass('disabled');
                    popup.find('.popup-bottom.btn-groups div').removeClass('disabled');
                    popup.find('.numberManage input').removeClass('disabled');
                    popup.find('.numberManage i').removeClass('disabled');
                    $$(".unit_name").removeClass("disabled");
                    //disabledDom.removeClass('disabled');
                }
                if (maxCount == 1) {
                    popup.find('.numberManage i').addClass('disabled');
                }
                if (popup.find('.numberManage input').val() == 1) {
                    popup.find('.numberManage .icon-cart-less').addClass('disabled');
                }
                this._set_data('maxCount', maxCount);
            } else {
                $$("#promotion").text("");
                disabledDom.addClass('disabled');

            }
            if (popup.find(".deliveryItem.active") && popup.find(".deliveryItem.active").length) {
                var deliveryType = popup.find(".deliveryItem.active").attr("data-id");
                // 如果门店自提并且店存计划启用，不限购
                if ((deliveryType && deliveryType == "PICKUP" && self.isStoreInventory) || (self.isEmsDispatchPlan && deliveryType == "EMS")) {// 启用在线物流仓库并且快递物流不限购
                    popup.find('.btn-update-sku').removeClass('disabled');
                    popup.find('.popup-bottom.btn-groups div').removeClass('disabled');
                    popup.find('.numberManage input').removeClass('disabled');
                    popup.find('.numberManage i').removeClass('disabled');
                }
            }
            if (self.pickupAndStoreInventory) {
                popup.find('.btn-update-sku').removeClass('disabled');
                popup.find('.popup-bottom.btn-groups div').removeClass('disabled');
                popup.find('.numberManage input').removeClass('disabled');
                popup.find('.numberManage i').removeClass('disabled');
            }
        } else { //这种情况就是规格一个都没选中 数量无法加减 确认失效 价格显示商品价格
            that._set_data('choseItems', {});
            disabledDom.addClass('disabled');
        }
        this.setTipsAboutChose(popup);
    }
    
    widget.prototype.setTipsAboutChose = function (popup) {
        var data = this._get_data('choseItems');
        data.noChoseItem = [];
        data.choseItem = [];
        var itemsAlbum = [];
        var self = this;
        var items = popup.find('.popup-content .popup-attrs div.lsSpecItem');
        for (var i = 0; i < items.length; i++) {
            if (items.eq(i).find('.attrItem.active').length == 0) {
                data.noChoseItem.push(items.eq(i).prev('p').html());
            } else {
                var json = {
                    id: items.eq(i).find('.attrItem.active').attr('data-id'),
                    name: items.eq(i).find('.attrItem.active').html()
                };
                itemsAlbum.push(items.eq(i).find('.attrItem.active').attr('data-id'));
                data.choseItem.push(json);
            }
        }
        if (data.noChoseItem.length > 0) {
            popup.find('.tip-chose').html('请选择 ' + data.noChoseItem.join(' '));
            $('li[data-property="property"] .item-title').html('请选择 ' + data.noChoseItem.join(' '));
        } else {
            var tips = '';
            data.choseItem.forEach(function (item, arr, index) {
                tips += item.name
            })
            popup.find('.tip-chose').html('已选择 ' + tips);
            $('li[data-property="property"] .item-title').html('已选择 ' + tips);
            self.productInfo.skuidsName = tips;
        }
        ;
        var showPic = [];
        itemsAlbum.forEach(function (item, arr, index) {
            self.productInfo.lsSpecItemAlbums.forEach(function (item1, arr1, idnex1) {
                if (item == item1.iSpecItemId) {
                    var json = {
                        imgUrl: item1.imgUrl
                    }
                    showPic.push(json);
                    return;
                }
            })
        });
        if (showPic.length == 0) {
            var src = self.productInfo.oDefaultAlbum ? self.productInfo.oDefaultAlbum.imgUrl : './img/nopic.jpg';
            popup.find('.popup-top .popup-img img').attr('src', src);
        } else {
            var src = showPic[0].imgUrl ? showPic[0].imgUrl : "./img/nopic.jpg";
            popup.find('.popup-top .popup-img img').attr('src', src);
        }
    }
    
    widget.prototype.initSKU = function (data) {
        var SKUResult = {};
        if (data.length === 1 && data[0].cSpecIds === '') {
            this.constructSKU(SKUResult, "", data[0]);
            return SKUResult;
        }
        var skuLength = 0;
        data.forEach(function (sku) {
            var skuKey = sku.cSpecIds;
            var skuKeyAttrs = skuKey.split(';');
            skuLength = skuKeyAttrs.length;
            skuKeyAttrs.sort(function (val1, val2) {
                return parseInt(val1) - parseInt(val2);
            });
            // 对每个SKU信息key属性值进行拆分组合
            var combArr = this.arrayCombine(skuKeyAttrs);
            combArr.forEach(function (item) {
                var key = item.join(';');
                this.constructSKU(SKUResult, key, sku);
            }, this);
            this.constructSKU(SKUResult, skuKeyAttrs.join(';'), sku);
        }, this);
        // 只有不启用库存计划和在线物流仓库才会进行处理
        if (!this.isStoreInventory && !this.isEmsDispatchPlan) {
            // 对每个规格匹配成sku是否有库存进行处理，如果与其它规格匹配都没有库存的话，进行删掉
            SKUResult = this.skuNoInventoryDealFunc(SKUResult, skuLength);
        }
        return SKUResult;
    };
    
    widget.prototype.constructSKU = function (SKUResult, key, sku) {
        if (!this.isGeneralProduct) {
            sku.fSalePrice = sku.salePoints;
        }
        if (SKUResult[key]) {
            SKUResult[key].count += sku.lInventoryCount;
            SKUResult[key].prices.push(sku.fSalePrice);
            SKUResult[key].codes.push(sku.cCode);
            SKUResult[key].ids.push(sku.id);
            SKUResult[key].markPrices.push(sku.fMarkPrice);
            SKUResult[key].promptMsgs.push(sku.promptMsg);
        } else {
            SKUResult[key] = {
                count: sku.lInventoryCount,
                prices: [sku.fSalePrice],
                codes: [sku.cCode],
                ids: [sku.id],
                markPrices: [sku.fMarkPrice],
                promptMsgs: [sku.promptMsg]
            };
        }
    };
    
    widget.prototype.arrayCombine = function (targetArr) {
        if (!targetArr || !targetArr.length) return [];
        var len = targetArr.length;
        var resultArrs = [];
        for (var n = 1; n < len; n++) {
            var flagArrs = this.getFlagArrs(len, n);
            while (flagArrs.length) {
                var flagArr = flagArrs.shift();
                var combArr = [];
                for (var i = 0; i < len; i++) {
                    flagArr[i] && combArr.push(targetArr[i]);
                }
                resultArrs.push(combArr);
            }
        }
        return resultArrs;
    };
    
    widget.prototype.getFlagArrs = function (m, n) { // 获得从m中取n的所有组合
        if (!n || n < 1) return [];
        var resultArrs = [],
            flagArr = [],
            isEnd = false,
            i, j, leftCnt;
        for (i = 0; i < m; i++) {
            flagArr[i] = i < n ? 1 : 0;
        }
        resultArrs.push(flagArr.concat());
        while (!isEnd) {
            leftCnt = 0;
            for (i = 0; i < m - 1; i++) {
                if (flagArr[i] == 1 && flagArr[i + 1] == 0) {
                    for (j = 0; j < i; j++) {
                        flagArr[j] = j < leftCnt ? 1 : 0;
                    }
                    flagArr[i] = 0;
                    flagArr[i + 1] = 1;
                    var aTmp = flagArr.concat();
                    resultArrs.push(aTmp);
                    if (aTmp.slice(-n).join('').indexOf('0') == -1) {
                        isEnd = true;
                    }
                    break;
                }
                flagArr[i] == 1 && leftCnt++;
            }
        }
        return resultArrs;
    };
    
    widget.prototype.isSelectSKU = function (selectedids, cSpecIds) {
        var isSelectSKUFlag = true;
        for (var i = 0; i < selectedids.length; i++) {
            if (cSpecIds.indexOf(selectedids[i]) == -1) {
                isSelectSKUFlag = false;
            }
        }
        return isSelectSKUFlag;
    };
    // 订单属性提示语处理
    widget.prototype.propertyTipFunc = function (skuPropertys) {
        var skuPropertysOfDeal = [];
        if (skuPropertys && skuPropertys.length) {
            for (var m = 0; m < skuPropertys.length; m++) {
                if (skuPropertys[m].performanceType == 3 && skuPropertys[m].propertyTypeName !== "配送方式" && skuPropertys[m].isShow) {
                    skuPropertysOfDeal.push(skuPropertys[m]);
                }
            }
        }
        return skuPropertysOfDeal;
    };
        
    widget.prototype.registerPopupBtn = function (productInfo) {
        var self = this;
        $$('.popup-prodSUK').find('.btn-update-sku,.btn-groups div').on('click', function () {
            if ($$(this).hasClass('clickSelectSku')) {
                myApp.closeModal('.popup-prodSUK');
            } else {
                self.dealAddCart(null, $$(this), productInfo);
            }

        });
        $$('.popup-prodSUK .numberManage i').on('click', function () {
            var quantity = parseInt($$('.popup #txtProSpecsCount').val());
            var sku = self._get_data('sku');
            var maxCount = self._get_data('maxCount');
            var deliveryType = "EMS";
            if ($$(".deliveryItem.active") && $$(".deliveryItem.active").length) {
                deliveryType = $$(".deliveryItem.active").attr("data-id");
                if (!deliveryType) {
                    deliveryType = "EMS";
                }
            }
            if (self.pickupAndStoreInventory) {
                deliveryType = "PICKUP";
            }
            // 团购限制开始
            if (productInfo.groupBuying) {
                // 总的还可以购买数量
                var totalCanPurchaseQuantity = 0;
                if (productInfo.groupBuying.stockQuantity && productInfo.groupBuying.limitPeopleNumber) {
                    totalCanPurchaseQuantity = parseInt(productInfo.groupBuying.stockQuantity) > parseInt(productInfo.groupBuying.limitPeopleNumber) ? parseInt(productInfo.groupBuying.limitPeopleNumber) : parseInt(productInfo.groupBuying.stockQuantity);
                    maxCount = totalCanPurchaseQuantity > maxCount ? maxCount : totalCanPurchaseQuantity;
                } else if (productInfo.groupBuying.stockQuantity && !productInfo.groupBuying.limitPeopleNumber) {
                    totalCanPurchaseQuantity = parseInt(productInfo.groupBuying.stockQuantity);
                    maxCount = totalCanPurchaseQuantity > maxCount ? maxCount : totalCanPurchaseQuantity;
                } else if (!productInfo.groupBuying.stockQuantity && productInfo.groupBuying.limitPeopleNumber) {
                    totalCanPurchaseQuantity = parseInt(productInfo.groupBuying.limitPeopleNumber);
                    maxCount = totalCanPurchaseQuantity > maxCount ? maxCount : totalCanPurchaseQuantity;
                } else {
                }

            }
            if (sku) {
                if ($$(this).hasClass('icon-cart-add')) { //数量加
                    $$(this).prevAll('.icon-cart-less').removeClass('disabled');
                    // 新增功能 选择配送方式为门店自提不限购
                    if ((deliveryType == "PICKUP" && self.isStoreInventory) || (self.isEmsDispatchPlan && deliveryType === "EMS")) { // 启用在线物流仓不限购
                        var nowQunatity = quantity + 1;
                        $$('.popup #txtProSpecsCount').val(nowQunatity);
                    } else {
                        if (maxCount > 1) {
                            if (quantity >= maxCount) {
                                $$(this).addClass('disabled');
                            } else {
                                if (quantity == maxCount - 1) {
                                    $$(this).addClass('disabled');
                                }
                                var nowQunatity = quantity + 1;
                                $$('.popup #txtProSpecsCount').val(nowQunatity);
                            }
                        } else {
                            $$(this).addClass('disabled');
                        }
                    }
                } else { //数量减
                    $$(this).nextAll('.icon-cart-add').removeClass('disabled');
                    if (quantity == 2 || quantity < 2) {
                        $$(this).addClass('disabled');
                    }
                    if (quantity > 1) {
                        var nowQunatity = quantity - 1;
                        $$('.popup #txtProSpecsCount').val(nowQunatity)
                    }

                }
                var data = self._get_data('choseItems');
                data.quantity = nowQunatity;
                if ($$('.popup-prodSUK .popup-attrs .lsSpecItem').length == 0) {
                    $$('li[data-property="property"] .item-title').html('已选择' + data.quantity + '件');
                    $$('.popup-prodSUK').find('.tip-chose').html('已选择' + data.quantity + '件');
                }
            }
        });
        $$('.popup-prodSUK .numberManage input').on('change', function () {
            var nowValue = $$(this).val();
            var sku = self._get_data('sku');
            var deliveryType = "EMS";
            if ($$(".deliveryItem.active") && $$(".deliveryItem.active").length) {
                deliveryType = $$(".deliveryItem.active").attr("data-id");
                if (!deliveryType) {
                    deliveryType = "EMS";
                }
            }
            if (self.pickupAndStoreInventory) {
                deliveryType = "PICKUP";
            }
            var maxCount = self._get_data('maxCount');
            var reg = new RegExp('^[0-9]*[1-9][0-9]*$'); //正则表达式  用来判断正整数。。。
            // 团购限制开始
            if (productInfo.groupBuying) {
                // 总的还可以购买数量
                var totalCanPurchaseQuantity = 0;
                if (productInfo.groupBuying.stockQuantity && productInfo.groupBuying.limitPeopleNumber) {
                    totalCanPurchaseQuantity = parseInt(productInfo.groupBuying.stockQuantity) > parseInt(productInfo.groupBuying.limitPeopleNumber) ? parseInt(productInfo.groupBuying.limitPeopleNumber) : parseInt(productInfo.groupBuying.stockQuantity);
                    maxCount = totalCanPurchaseQuantity > maxCount ? maxCount : totalCanPurchaseQuantity;
                } else if (productInfo.groupBuying.stockQuantity && !productInfo.groupBuying.limitPeopleNumber) {
                    totalCanPurchaseQuantity = parseInt(productInfo.groupBuying.stockQuantity);
                    maxCount = totalCanPurchaseQuantity > maxCount ? maxCount : totalCanPurchaseQuantity;
                } else if (!productInfo.groupBuying.stockQuantity && productInfo.groupBuying.limitPeopleNumber) {
                    totalCanPurchaseQuantity = parseInt(productInfo.groupBuying.limitPeopleNumber);
                    maxCount = totalCanPurchaseQuantity > maxCount ? maxCount : totalCanPurchaseQuantity;
                } else {
                }

            }
            if (reg.test(nowValue)) {
                // 新增功能 选择配送方式为门店自提不限购
                if ((deliveryType == "PICKUP" && self.isStoreInventory) || (self.isEmsDispatchPlan && deliveryType === "EMS")) { // 启用在线物流仓库并且快递物流不限购
                    if (nowValue > 0) {
                        $$(this).prev('i').removeClass('disabled');
                    }
                } else {
                    if (parseInt(nowValue) > maxCount) {
                        myApp.toast('数量大于可购数量', 'tips').show(true);
                        if (maxCount > 0) {
                            $$(this).val(maxCount);
                        }
                        if (maxCount > 1) {
                            $$(this).prev('i').removeClass('disabled');
                        }
                        $$(this).next('i').addClass('disabled');
                    } else if (parseInt(nowValue) == maxCount) {
                        $$(this).next('i').addClass('disabled');
                        $$(this).prev('i').removeClass('disabled');
                    }
                }

            } else {
                myApp.toast('输入值不符合要求 ', 'tips').show(true);
                $$(this).val(1);
                $$(this).prev('i').addClass('disabled');
                if (maxCount > 1) {
                    $$(this).next('i').removeClass('disabled');
                }
            }
            var data = self._get_data('choseItems');
            data.quantity = $$(this).val();
        });
        // 配送方式选择事件
        $$('.popup-prodSUK').find('.deliveryItem').on('click', function () {
            var deliveryItems = $$('.popup-prodSUK').find('.deliveryItem');
            deliveryItems.each(function () {
                if ($$(this).hasClass("active")) {
                    $$(this).removeClass("active");
                }
            });
            $$(this).addClass("active");
            // 快递物流并启用在线物流仓比限购
            if (($$(".deliveryItem.active").attr("data-id") == "PICKUP" && self.isStoreInventory) || (self.isEmsDispatchPlan && $$(".deliveryItem.active").attr("data-id") == "EMS")) {
                $$('.popup-prodSUK .numberManage').children().removeClass('disabled');
                $$('.icon-cart-add').removeClass('disabled');
                $$('.popup-prodSUK .btn-update-sku').removeClass('disabled');
                $$('.popup-prodSUK .popup-bottom.btn-groups div').removeClass('disabled');
            } else {
                var maxCount = self._get_data('maxCount');
                var quantity = $$('.popup-prodSUK .numberManage input').val();
                if (parseInt(quantity) > maxCount) {
                    if (maxCount > 0) {
                        $$('.popup-prodSUK .numberManage input').val(maxCount);
                    } else {
                        $$('.popup-prodSUK .numberManage input').val("1");
                    }

                }
                if (maxCount <= 0) {
                    $$('.popup-prodSUK .btn-update-sku').addClass('disabled');
                    $$('.popup-prodSUK .popup-bottom.btn-groups div').addClass('disabled');
                    $$('.popup-prodSUK .numberManage input').addClass('disabled');
                    $$('.popup-prodSUK .numberManage i').addClass('disabled');
                } else {
                    $$('.popup-prodSUK .btn-update-sku').removeClass('disabled');
                    $$('.popup-prodSUK .popup-bottom.btn-groups div').removeClass('disabled');
                    $$('.popup-prodSUK .numberManage input').removeClass('disabled');
                    $$('.popup-prodSUK .numberManage i').removeClass('disabled');
                }
            }
        });
    };
    // 规格没有库存置灰逻辑处理 对每个规格匹配成sku是否有库存进行处理，如果与其它规格匹配都没有库存的话，进行删掉
    widget.prototype.skuNoInventoryDealFunc = function (skuResult, skuLength) {
        var self = this;
        var SKUResultNew = {};
        var product = this.productInfo;
        var sku = product.lsProductSkus;
        $$.each(skuResult, function (key, value) {
            var skuKeyAttrs = key.split(';');
            if (skuKeyAttrs && skuKeyAttrs.length != skuLength) {
                var isHasInventory = false;
                for (var i = 0; i < sku.length; i++) {
                    if (sku[i].lInventoryCount) {
                        var skuKeyAttrs1 = key.split(';');
                        var skuSpecIdsArr = sku[i].cSpecIds.split(';');
                        var mergeArrayResult = self.mergeArray(skuKeyAttrs1, skuSpecIdsArr);
                        if (mergeArrayResult.length == skuLength) {
                            isHasInventory = true;
                            break;
                        }
                    }
                }
                if (isHasInventory) {
                    SKUResultNew[key] = value;
                }
            } else {
                if (value.count) {
                    SKUResultNew[key] = value;
                }
            }
        })
        return SKUResultNew;
    };
    // 数组合并去重
    widget.prototype.mergeArray = function (arr1, arr2) {
        for (var m = 0 ; m < arr1.length ; m++) {
            for (var n = 0 ; n < arr2.length ; n++) {
                if (arr1[m] === arr2[n]) {
                    arr1.splice(m, 1); //利用splice函数删除元素，从第i个位置，截取长度为1的元素
                }
            }
        }
        for (var k = 0; k < arr2.length; k++) {
            arr1.push(arr2[k]);
        }
        return arr1;
    };
    // SKU促销限购和商品促销限购
    widget.prototype.promotionLimitFunc = function (skuid, production) {
        var canPurchaseCount = false;
        for (var i = 0; i < production.lsProductSkus.length; i++) {
            if (skuid == production.lsProductSkus[i].id) {
                if (production.lsProductSkus[i].canPurchaseCount || production.lsProductSkus[i].canPurchaseCount === 0) {
                    if (production.lsProductSkus[i].canPurchaseCount < 0) {
                        production.lsProductSkus[i].canPurchaseCount = 0;
                    }
                    $$("#promotion").removeClass("disabled");
                    canPurchaseCount = production.lsProductSkus[i].canPurchaseCount;
                    $$("#promotion").text(production.lsProductSkus[i].tipMessage + "还可购买" + production.lsProductSkus[i].canPurchaseCount + "件");
                } else {
                    $$("#promotion").text("");
                }
                break;
            }
        }
        return canPurchaseCount;
    };
    return widget;
});