cb.widgets.register('HelpCenterNav', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.getProxy = function () {
        return { url: 'client/ArticleTypes/getTypesForTree', method: 'GET' };
    };

    widget.prototype.getProxyData = function () {
        var queryString = new cb.util.queryString();
        var wigetType = queryString.get("wigetType");
        return { typeName: encodeURIComponent(wigetType) };
    };
    widget.prototype.runTemplate = function (error, result) {
        var queryString = new cb.util.queryString();
        var typeId = queryString.get("typeId");
        var wigetType = queryString.get("wigetType");
        if (error) return;
            var html = this.render({ data: result });
            $('.helpcenter_navs').html(html);
            $li = $('#helpcenter_nav').find('.nav_list li a');
            for (var i = 0; i < $li.length; i++) {
                if ($li[i].id == typeId) {
                    var $li = $('#helpcenter_nav').find('.nav_list li:eq(' + i + ')');
                    $li.addClass('active');
                    if ($li.find('ul').length>0) {
                        //现在没事  应该使用循环将所有的二级分类全部移除；
                        var html = $li.find('ul').html();
                        $li.find('ul').remove();
                        var this_li = '<li class="col-md-12 nobefore"><ul>' + html + '</ul></li>';
                        $(this_li).insertAfter($li);
                    }
                }
            }
            $('#helpcenter_nav').find('.nav_list li a').on('click', function (e) {
                var typeId = $(this).attr('id');
                window.location.href = "/helpcenter/classification?wigetType="+wigetType+"&&typeId="+typeId;
            });
        } 
    return widget;
});