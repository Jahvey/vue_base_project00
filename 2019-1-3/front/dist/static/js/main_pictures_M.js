cb.widgets.register('MainPhoto', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.runTemplate = function (err, result) {
    	var config = this.getConfig();
    	if(config.photos.length == 0){
    		$(this.getElement()[0].closest('.row')).remove();
    	}else{
    		var configNum = Math.round((1/config.photos.length)*100);
    		var selectedNum = config.photos[0].selectedNum; 
    	}   	 	
    	if(config.photos.length > parseInt(selectedNum)){
    		var configNum = 100;  
    	}else{
    		var configNum = Math.round((1/config.photos.length)*100);
    	}
    	for(var i=0;i<config.photos.length;i++){
    		config.photos[i].configNum = configNum;
    	};    	
        var html = this.render(config);
       	this.getElement().find('ul').html(html);
        // var $list = $(this.getElement().find('.mainPhotoLi'));
        // for(var i=0;i<$list.length;i++){
        // 	if($$($list[i].children).attr('data-link') == 'true'){
        // 		$$($list[i].children).children('a').addClass('external');
        // 		$$($list[i].children).children('a').attr('target','_system');
        // 	}
        // };
        // if(config.photos.length > parseInt(selectedNum)){
    	// 	$(this.getElement().find('ul')).owlCarousel({
	    //     	items : parseInt(selectedNum)+0.1
	    //   	});
	      	      	
    	// }else{
    	// 	if($(this.getElement().find('ul')).hasClass('owl-carousel')){
    	// 		$(this.getElement().find('ul')).css({'display':''});
    	// 	}
    	// };
        // this.designer = this.getConfig().designer;
        // if(this.designer){
        // 	this.removeHref();
        // };
    };
    widget.prototype.removeHref = function(){
    	var aDom = this.getElement().find(".MainPhoto").find("a");
        for(var i = 0 ;i<aDom.length; i++){
            $$(aDom[i]).removeAttr("href");
        }
    }
    return widget;
});