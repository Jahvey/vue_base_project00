cb.widgets.register('MainSlide', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
        if (options && options.height)
            this.getElement().height(options.height);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return { url: 'client/Corprations/getCorpAdImages', method: 'GET' };
    };

    widget.prototype.runTemplate = function (err, result) {
    	var config = this.getConfig();
    	var data={};
    	if(config.source==1){
    		data = { list: config.configData };
    	}else{
    		data = { list: result };
    	}
        var html = this.render(data);
        var $ul = this.getElement().find('ul');
        $ul.html(html);
        if (config && config.height)
            $ul.children().height(config.height);
        unsliderInit(this);
        if(config.height == 'auto'){
    		$('.banner ').css({'min-height':''});
    	}
    };

    var unsliderInit = function (widget) {
        var $elem = widget.getElement();
        var loaded = checkImageHasLoaded($elem);
        if (!loaded) {
            setTimeout(unsliderInit, 100, widget);
            return;
        }
        $elem.show();
        $elem.unslider({
            speed: 500,               //  The speed to animate each slide (in milliseconds)
            delay: 3000,              //  The delay between slide animations (in milliseconds)
            complete: function () { },  //  A function that gets called after every slide animation
            keys: true,               //  Enable keyboard (left, right) arrow shortcuts
            dots: true,               //  Display dot navigation
            fluid: false              //  Support responsive design. May break non-responsive designs
        });
        //widget.execute('afterInit', $elem.height());
    };

    var checkImageHasLoaded = function ($elem) {
        return true;
        var imgs = $elem.find('img');
        if (!imgs.length) return true;
        var hasLoaded = true;
        imgs.each(function (index, img) {
            hasLoaded &= img.complete;
        });
        return hasLoaded;
    };

    return widget;
});