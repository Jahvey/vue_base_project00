cb.widgets.register('Coupon', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.runTemplate = function (err, result) {
    	var config = this.getConfig();
    	var configNum = Math.round((1/config.data.length)*100);
    	for(var i=0;i<config.data.length;i++){
    		config.data[i].configNum = configNum;
    		config.data[i].expireEndDate = cb.util.formatDate(config.data[i].expireEndDate);
    		config.data[i].expireStartDate = cb.util.formatDate(config.data[i].expireStartDate);
    		
    		if(config.data[i].backtype==1){
    			config.data[i].itype=true;//自定义
    			config.data[i].height = config.height;  
    		}else{
    			config.data[i].itype=false;//背景图
    			config.data[i].height = config.height;    			
    		}
    	};    	
        var html = this.render(config);
       	this.getElement().find('ul').html(html);
       	//领取优惠券
       	if(!this.getConfig().designer){
       		this.getElement().find('.sendCoupon').on('click', function () {
       			var  param = {};
       			param.couponId = this.id;
   				sendcoupon(param);
            });
       	} 
       	var sendcoupon = function(param){
	        var couponProxy = cb.rest.DynamicProxy.create({
            	senderCoupon: { url: 'coupon/MemberCouponServer/sendCoupon', method: 'POST', options: { token: true } }
            });      
            couponProxy.senderCoupon({param:param}, function (err, result) {
            	var addContent = "";
            	if (!err) {
            		myApp.alert('优惠券领取成功！',' ');
            	} else {
            		if(err.code == '999'){
            			myApp.alert('发放卡券[优惠券]，已达到限领上限！',' ');
            		}else{
            			alert(err.message);
            		}
            	}            	
            });
       	};
    };
    return widget;
});