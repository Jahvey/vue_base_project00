cb.widgets.register('Coupon', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.runTemplate = function (err, result) {
    	var config = this.getConfig(); 
    	var _this = this;
    	for(var i=0,len=config.configData.length;i<len;i++){
    		if(len==5){
    			config.configData[i].colSpan = 2;
    		}else{
    			config.configData[i].colSpan = 12/len;
    		}
    		config.configData[0].expireEndDate = cb.util.formatDate(config.configData[0].expireEndDate);
    		config.configData[0].expireStartDate = cb.util.formatDate(config.configData[0].expireStartDate);
    	} 	
        var html = this.render(config);
       	this.getElement().find('ul').html(html);
   		$('.sendCoupon').click(function(){
   			var config = JSON.parse($(this).parents('.coupon').attr("data-config"));
   			var length = config.configData.length;
   			var thisConfig;
   			for(var i=0;i<length;i++){
   				if(config.configData[i].couponid==this.id){
   					thisConfig = config.configData[i];
   				}
   			}
   			var  param = {};
   			param.couponId = thisConfig.couponid;
            cb.util.clickTimeout.set(function () {
               sendcoupon(param,thisConfig);
            });   			
   		});		
   	    var sendcoupon = function(param,thisConfig){
   	        var couponProxy = cb.rest.DynamicProxy.create({
   	        	senderCoupon: { url: 'coupon/MemberCouponServer/sendCoupon', method: 'POST', options: { token: true } }
   	        });
   	        couponProxy.senderCoupon({param:param}, function (err, result) {
   	        	var addContent = "";
   	        	if (!err) {
   	        		addContent += '<div class="closeMOodal"></div><p class="title">恭喜您获得</p>';
   	        		addContent += '<p>'+thisConfig.reduceAmount+'元优惠券，满'+thisConfig.startAmount+'元可用</p><li class="col-xs-12">';
   	        		addContent += '<div class="stamp01 stamp" style="height:150px;background-color:red;">';
   	        		addContent += '<div class="par"><div class="pirce"><sub class="sign">￥</sub><span>'+thisConfig.reduceAmount+'</span></div>';
   	        		addContent += '<div class="info"><a>优惠券</a><p>订单满'+thisConfig.startAmount+'元可用</p></div></div></div></li>';
   	        		$('#SendCouponModal').html(addContent);
   	        	} else {
   	        		if(err.code == '999'){
   	        			addContent += '<div class="closeMOodal">';
   	        			addContent += '<li class="col-xs-12">';
   	        			addContent += '<div class="no-conpon"><i class="icon icon-no-conpon"></i><p>啊噢，优惠券已被抢光，下次记得早点来噢～～</p></div></li>';
   	        			$('#SendCouponModal').html(addContent)
   	        		}else{
   	        			alert(err.message);
   	        		}
   	        	}
   	   			$('#SendCouponModal')[0].style.display="block";	
   	   	   		$('.closeMOodal').click(function(){
   	   	   			$('#SendCouponModal')[0].style.display="none";
   	   	   		});             	
   	        });  
   	    };   		
    };
    return widget;
});