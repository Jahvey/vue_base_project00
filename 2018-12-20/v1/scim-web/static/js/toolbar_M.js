cb.widgets.register('Toolbar', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.runTemplate = function (err, result) {
    	var config = this.getConfig();
        var toolbarChildren = $('.toolbar-inner').children();
        for(var i=0;i<toolbarChildren.length;i++){
            if(toolbarChildren[i].href && toolbarChildren[i].href.indexOf('app/mm.php/MM/') >-1){
                toolbarChildren[i].href = toolbarChildren[i].href +'&wid='+cb.rest.AppContext.wid;
            }
        }
        if(config.icons){
            var html = this.render(config);
            if(!html) return;
            this.getElement().children('.toolbar-inner').html(html);
        };
        
    };
    return widget;
});