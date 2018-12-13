cb.widgets.register('IndexGoods', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return { url: 'client/Orders/getProductMainTopList', method: 'POST', options: { token: true} };
    };

    widget.prototype.getProxyData = function () {
        var config = this.getConfig();
        var supplier = {"fieldname": "","valuefrom": ""};
        var cols = parseInt(config.cols) || 3;
        config.colspan = Math.round(12 / cols);
        var rows = parseInt(config.rows) || 2;
        config.limit = cols * rows;
        var params = {};
        params.pagesize = config.limit;
        params.pageindex = 1;
        params.where = config.filter || [];
        var productAttribute = { 'fieldname': 'productAttribute', 'valuefrom': '1' };
        if (config.goodClass && config.goodClass !== 'general')
            productAttribute.valuefrom = '2';
        params.where.push(productAttribute);
        if (config.isCurrentClass === 'true') {
            var productId = new cb.util.queryString().get('goods_id');
            if (productId)
                params.where.push({ 'fieldname': 'productId', 'valuefrom': productId });
        }
        if(location.href.indexOf('supplier_') > 0){
        	var index = location.href.indexOf('supplier');
        	var supplierId = parseInt(location.href.substring(index+9));
        	supplier.fieldname = "shop_id";
        	supplier.valuefrom = supplierId;
        }
        params.order = config.order;
        params.where.push(supplier);
        return { queryCondition: params };
    };

    widget.prototype.getTemplate = function () {
        var config = this.getConfig();
        if(config.goodsStyle == 1){
        	return this.getElement().find('#group_product').html();
        }else if(config.goodsStyle == 2){
        	return this.getElement().find('#secKill_product').html();
        } else{
        	if (config.displayMode !== 'rank') {
            	return this.getElement().find('#landscape').html();
	        } else{
	            return this.getElement().find('#portrait').html();
	        }
        }        
    };

    widget.prototype.runTemplate = function (error, result) {
        if (error) return;
        var self = this;
        var intervalFlag = 0;
        var config = this.getConfig();
        if(!result.data)
          result.data = [];
        for (var i = 0; i < result.data.length; i++) {
            //if (config.goodClass != undefined && config.goodClass != "") {
            //	if(config.goodClass=="general"){
            //		result.data[i].productAttribute = "1";
            //	}else{
            //		result.data[i].productAttribute = "2";
            //	}	
            //} else {
            //	result.data[i].productAttribute = "1";
            //}
            if (!result.data[i].isDisplayPrice || result.data[i].isDisplayPrice == "false") {
                result.data[i].isDisplayPrice = false;
            } else {
                result.data[i].isDisplayPrice = true;
            }
            if (result.data[i].fSalePrice) {
                result.data[i].fSalePrice = parseFloat(result.data[i].fSalePrice).toFixed(2);
            }
        };
        // 普通商品获取店铺信息设置
        //if (config.goodsStyle != 1 && config.goodsStyle != 2) {
        //    self.getShopsSeting(result.data);
        //}
        result.colspan = config.colspan;
        var html = this.render(result);
        this.getElement().find('ul').html(html);
        //商品楼层匹配不同样式
        if(result.colspan === 2 && this.getElement().parent().parent('.row').children().length == 1){
            this.getElement().parent().parent().addClass('column-6');
        }
        if(result.colspan === 3 && this.getElement().parent().parent('.row').children().length == 1){
            this.getElement().parent().parent().addClass('column-4');
        }
        if(result.colspan === 6 && this.getElement().parent().parent('.row').children().length == 2 && this.getElement().parent().hasClass('col-xs-6')){
            this.getElement().parent().parent().addClass('column-half-2');
        }
        if(result.colspan === 4 && this.getElement().parent().parent('.row').children().length == 2 && this.getElement().parent().hasClass('col-xs-6')){
            this.getElement().parent().parent().addClass('column-half-3');
        }if(result.colspan === 4 && this.getElement().parent().parent('.row').children().length == 2 && this.getElement().parent().hasClass('col-xs-9')){
            this.getElement().parent().parent().addClass('column-quarter');
        }if(result.colspan === 3 && this.getElement().parent().parent('.row').children().length == 2 && this.getElement().parent().hasClass('col-xs-9')){
            this.getElement().parent().parent().addClass('column-fifth');
        }
         //如果设置了销售排行需要去设置销售排行图片的高度
         if(config.displayMode == 'rank'){
             if(this.getElement().parent().parent('.row').find('.col-xs-9 .index_goods').attr('data-config')){
                var sideRows=parseInt(JSON.parse(this.getElement().parent().parent('.row').find('.col-xs-9 .index_goods').attr('data-config')).rows);
                var rankHeight=(266*sideRows+8*(sideRows-1));
                this.getElement().find('.hot-list').height(rankHeight);
             }
        }
        //秒杀倒计时
        if(config.goodsStyle == 2){
            window.setInterval(function () {
            var backTime;
            intervalFlag++;
            for(var i = 0; i < result.data.length; i++){
            	if(result.data[i].repeatSpike){ //开启重复秒杀模式
	                var date = new Date(result.data[i].beginTime);
	            	if(result.data[i].iActivityStatus == '0'){ //未开始  
                        if(result.data[i].pStartDate > result.data[i].endTime){ //大范围的开始时间 在endTime区间之外
	            			date = new Date((date/1000+86400)*1000); //加一天操作
	            			result.data[i].pStartDate = date.format("yyyy-MM-dd hh:mm:ss");
	            		}else if(result.data[i].pStartDate < result.data[i].beginTime){ //大范围的开始时间 在beginTime区间之外
    	            		result.data[i].pStartDate = date.format("yyyy-MM-dd hh:mm:ss");
	            		}
	            		backTime = cb.util.countDownFunc(result.data[i].now,result.data[i].pStartDate,intervalFlag);
	            	}else if(result.data[i].iActivityStatus == '1'){ //进行中
	            		result.data[i].pEndDate = result.data[i].endTime;
	            		backTime = cb.util.countDownFunc(result.data[i].now,result.data[i].pEndDate,intervalFlag);
	            	}else{ //已结束  第二天重新开始
	            		date = new Date((date/1000+86400)*1000); //加一天操作
	            		result.data[i].pStartDate = date.format("yyyy-MM-dd hh:mm:ss");
	            		if(result.data[i].pStartDate > result.data[i].pEndDate){ //如果明天开始的时间已经超过 整个活动的结束时间
							$('#endtimeLine'+result.data[i].id).parent().text('秒杀已结束');
	            		}else{
    	            		backTime = cb.util.countDownFunc(result.data[i].now,result.data[i].pStartDate,intervalFlag);
	            		}
	            	}
            	}else{
            		if(result.data[i].iActivityStatus == '0'){
	            		backTime = cb.util.countDownFunc(result.data[i].now,result.data[i].pStartDate,intervalFlag);
	            	}else if(result.data[i].iActivityStatus == '1'){
	            		backTime = cb.util.countDownFunc(result.data[i].now,result.data[i].pEndDate,intervalFlag);
	            	}
            	}
                result.data[i].backTime = backTime;
                $('#endtimeLine'+result.data[i].id).text(backTime);
            }                        
            }, 1000);
        }; 
        if(config.goodtag == '1'){
        	$('.groupBuyingLabel').css({'display':'none'});
        }
    };
    // 获取店铺配置信息
    widget.prototype.getShopsSeting = function (dataArray) {
        var self = this;
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
    return widget;
});