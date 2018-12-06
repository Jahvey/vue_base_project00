cb.widgets.register('MainSlide', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.runTemplate = function (err, result) {
    	var config = this.getConfig();
        var html = this.render(config);
        this.getElement().children('.swiper-wrapper').html(html);
        var $list = $$(this.getElement().find('.swiper-slide'));
        for(var i=0;i<$list.length;i++){
        	if($$($list[i]).attr('data-link') == 'true'){
        		$$($list[i]).children('a').addClass('external');
        		$$($list[i]).children('a').attr('target','_system');
        	}
        };
        var mySwiper = new Swiper('.swiper-container', {
            pagination: this.getElement().children('.swiper-pagination'),
            speed: 600,
            autoplay: 2000,
            autoplayDisableOnInteraction: false,
            loop: true,
            grabCursor: true,
            paginationClickable: true
        });
    };

    return widget;
});