cb.views.register('HomeViewController',function(){
    var view = function(widgets){
        cb.view.BaseView.call(this,widgets);
    }
    view.prototype = new cb.views.BaseView();
    view.prototype.controllerName =controllerName;
    return view
})