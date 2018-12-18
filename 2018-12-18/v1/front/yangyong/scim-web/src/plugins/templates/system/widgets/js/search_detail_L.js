cb.widgets.register('Search_detail', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.getProxy = function () {
        return { url: 'client/Products/getProductFiltersByClassOrKeyword', method: 'GET' };
    }
    widget.prototype.runTemplate = function (error, result) {
        var queryString = new cb.util.queryString();
        var searchType = queryString.query.searchtype;
        if (searchType != "shop") {
            var self = this;
            // if (error) return;

            var html = this.render({ list: result, queryString: queryString.toStr() });

            this.getElement().children('.search-detail').html(html);
            this.getElement().children(".search-detail").find("a").on("click", function (e) {
                var type = $(this).attr("data-type");
                var value = $(this).attr("data-value");
                queryString.set(type, value);
                location.href = "list" + queryString.toStr();
            });
            // 品牌行数控制
            var brandListHeight = $('.brandListLess').height();
            var tagListHeight = $('.tagListLess').height();
            if (brandListHeight > 60) {
                this.getElement().children(".search-detail").find('.brandListLess').css("max-height", "60px");
                this.getElement().children(".search-detail").find(".moreBrandListBtn").show();
                this.getElement().children(".search-detail").find(".unMoreBrandListBtn").hide();
            } else {
                this.getElement().children(".search-detail").find('.brandListLess').css("max-height", "60px");
                this.getElement().children(".search-detail").find(".moreBrandListBtn").hide();
                this.getElement().children(".search-detail").find(".unMoreBrandListBtn").hide();
            }
            if (tagListHeight > 60) {
                this.getElement().children(".search-detail").find('.tagListLess').css("max-height", "60px");
                this.getElement().children(".search-detail").find(".moreTagListBtn").show();
                this.getElement().children(".search-detail").find(".unMoreTagListBtn").hide();
            } else {
                this.getElement().children(".search-detail").find('.tagListLess').css("max-height", "60px");
                this.getElement().children(".search-detail").find(".moreTagListBtn").hide();
                this.getElement().children(".search-detail").find(".unMoreTagListBtn").hide();
            }
            this.getElement().children(".search-detail").find(".moreBrandListBtn").on('click', function (e) {
                self.getElement().children(".search-detail").find(".moreBrandListBtn").hide();
                self.getElement().children(".search-detail").find(".unMoreBrandListBtn").show();
                self.getElement().children(".search-detail").find('.brandListLess').css("max-height", "none");
            });
            this.getElement().children(".search-detail").find(".unMoreBrandListBtn").on('click', function (e) {
                self.getElement().children(".search-detail").find(".moreBrandListBtn").show();
                self.getElement().children(".search-detail").find(".unMoreBrandListBtn").hide();
                self.getElement().children(".search-detail").find('.brandListLess').css("max-height", "60px");

            });
            this.getElement().children(".search-detail").find(".moreBrandListBtn").on('click', function (e) {
                self.getElement().children(".search-detail").find(".moreTagListBtn").hide();
                self.getElement().children(".search-detail").find(".unMoreTagListBtn").show();
                self.getElement().children(".search-detail").find('.tagListLess').css("max-height", "none");
            });
            this.getElement().children(".search-detail").find(".unMoreTagListBtn").on('click', function (e) {
                self.getElement().children(".search-detail").find(".moreTagListBtn").show();
                self.getElement().children(".search-detail").find(".unMoreTagListBtn").hide();
                self.getElement().children(".search-detail").find('.tagListLess').css("max-height", "60px");

            });
        }
    };
    return widget;
});