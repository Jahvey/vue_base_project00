cb.widgets.register('Search', function(widgetType) {
	var widget = function(id, options) {
		cb.widgets.BaseWidget.call(this, id, options);
	};
	widget.prototype = new cb.widgets.BaseWidget();
	widget.prototype.widgetType = widgetType;
	widget.prototype.getProxy = function() {
		return {
			url: 'client/PopularKeywords/getList',
			method: 'GET'
		};
	}
	widget.prototype.getTemplate = function() {
		return $("#keylist").html()
	}
	widget.prototype.runTemplate = function (err, result) {
	    var self = this;
	    self.search_fixed_flag = false;
	    var query = new cb.util.queryString().query;
	    var searchType = query.searchtype;
	    // 对页签进行处理
	    var searchSriggers = $(".search-triggers").find("li");
	    if (searchType == "product") {
	        if (searchSriggers && searchSriggers.length) {
	            searchSriggers.each(function () {
	                if ($(this).attr("data-searchtype") == "product") {
	                    $(this).addClass("active");
	                } else {
	                    $(this).removeClass("active");
	                }
	            })
	        }
	    } else if (searchType == "shop") {
	        if (searchSriggers && searchSriggers.length) {
	            searchSriggers.each(function () {
	                if ($(this).attr("data-searchtype") == "shop") {
	                    $(this).addClass("active");
	                } else {
	                    $(this).removeClass("active");
	                }
	            })
	        }
	    }
	    var keyword=query.keyword;
	    var $input=this.getElement().find('.search_box_t input');
	    if(keyword){
	        $input.val(keyword)	
	    }
	    if (err) {
	        alert(err.message);
	        return;
	    }
	    var data = result.pkword;
	    var keyWord = {
	        list: []
	    };
	    for (var i = 0; i < data.length; i++) {
	        if (data[i].isDefault) {
	            keyWord.isDefault = data.slice(i, i+1)[0];
	        } else {
	            keyWord.list.push(data[i]);
	        }
	    }
	    //处理热门关键词展示
	    var html = this.render({
	        hotKey: keyWord.list
	    });
	    $('.key-list').html(html);
	    //处理搜索框默认关键词
	    if (keyWord.isDefault) {
	        $input.attr('placeHolder', keyWord.isDefault.name)
	    }
	    // 选项卡切换
	    this.getElement().find('.search_box ul li').on("click", function (e) {
	        $(this).parents(".search-triggers").find("li").removeClass("active");
	        $(this).addClass("active");
	    });
	    this.getElement().find('.search_box_t button').click(this, function (e) {
	        var searchType = $(this).parents(".search_box").find(".search-triggers").find("li.active").attr("data-searchtype");
	        if (searchType == "shop") {
	            self.redirectSearchShopPage(keyWord.isDefault);
	        } else {
	            e.data.redirectSearchPage(keyWord.isDefault);
	        }
			
	    });
        // 悬浮固定搜索框处理开始
	    // 固定搜索框渲染
	    var search_fixed_top_html = $('#search_fixed_top').html();
	    $(".search_top_fixed").find("div.col-xs-12").empty().append(search_fixed_top_html);
        // 商城logo
	    var proxy = cb.rest.DynamicProxy.create({
	        getCorpBaseMsg: { url: 'client/Corprations/getCorpBaseMsg', method: 'GET' }
	    });
	    proxy.getCorpBaseMsg({}, function (err3, result3) {
	        if (err3) {

	        } else {
	            $(".search-fixed-logo").find("img").attr("src", result3.logoImg);
	        }
	    });
	    this.scrollShowSearch();
	    // 悬浮固定搜索框对页签进行处理
	    if (searchType == "product") {
	        var searchItems = ' <li class="active" data-searchtype="product">宝贝</li><li data-searchtype="shop">店铺</li>';
	        $('.search-triggers-top').find("ul").html(searchItems);
	    } else if (searchType == "shop") {
	        var searchItems = '<li class="active" data-searchtype="shop">店铺</li><li data-searchtype="product">宝贝</li>';
	        $('.search-triggers-top').find("ul").html(searchItems);
	    }
	    var $inputFixed = $('#search-fixed-input');
	    if (keyword) {
	        $inputFixed.val(keyword)
	    }
	    //处理搜索框默认关键词
	    if (keyWord.isDefault) {
	        $inputFixed.attr('placeHolder', keyWord.isDefault.name)
	    }
	    // 选项卡切换
	    $('.search-triggers-top').find("ul").on("click", "li", function (e) {
	        if (!$(this).hasClass("active")) {
	            var intoText = $(this).text();
	            $(this).remove();
	            var insertHtml = "";
	            if (intoText === "宝贝") {
	                insertHtml = '<li class="active" data-searchtype="product">' + intoText + '</li>';
	            } else {
	                insertHtml = '<li class="active" data-searchtype="shop">' + intoText + '</li>';
	            }
	            $(".search-triggers-top").find("li").removeClass("active");
	            $(".search-triggers-top").find("li").before(insertHtml);

	        }
	    });
	    $('.search-button-fixed button').click(this, function (e) {
	        var searchType = $(this).parents(".search-bd").find(".search-triggers-top").find("li.active").attr("data-searchtype");
	        if (searchType == "shop") {
	            self.redirectSearchShopFixedPage(keyWord.isDefault);
	        } else {
	            e.data.redirectSearchFixedPage(keyWord.isDefault);
	        }

	    });
	    // 悬浮固定搜索框处理结束
	    this.getElement().keydown(this, function (e) {
	        if (e.keyCode !== 13) return;
            // 悬浮搜索固定框enter
	        if (self.search_fixed_flag) {
	            var searchType = $(".search-bd").find(".search-triggers-top").find("li.active").attr("data-searchtype");
	            if (searchType == "shop") {
	                self.redirectSearchShopFixedPage(keyWord.isDefault);
	            } else {
	                e.data.redirectSearchFixedPage(keyWord.isDefault);
	            }
	        } else {
	            var searchType = $(".search_box").find(".search-triggers").find("li.active").attr("data-searchtype");
	            if (searchType == "shop") {
	                self.redirectSearchShopPage(keyWord.isDefault);
	            } else {
	                e.data.redirectSearchPage(keyWord.isDefault);
	            }
	        }

	    });
	};

	widget.prototype.redirectSearchPage = function(isDefault) {
		var queryString = new cb.util.queryString();
		if(location.href.indexOf('supplier_') > -1 || queryString.get('shop_id')){
			var index = location.href.indexOf('supplier_');
			var shop_id = queryString.get('shop_id') || location.href.substring(index+9);
		}
		var $input = this.getElement().find('.search_box_t input');
		value = $input.val();
		if(shop_id){
			if (value == '' && isDefault) {
				if (isDefault.targetUrl) {
				    location.href = isDefault.targetUrl + '&shop_id=' + shop_id + "&searchtype=product";
				} else {
				    location.href = '/list?keyword=' + encodeURIComponent(isDefault.name) + '&shop_id=' + shop_id + "&searchtype=product";
				}
			} else {
			    location.href = '/list?keyword=' + encodeURIComponent($input.val()) + '&shop_id=' + shop_id + "&searchtype=product";
			}
		}else{
			if (value == '' && isDefault) {
				if (isDefault.targetUrl) {
				    location.href = isDefault.targetUrl + "&searchtype=product";
				} else {
				    location.href = '/list?keyword=' + encodeURIComponent(isDefault.name) + "&searchtype=product";
				}
			} else {
			    location.href = '/list?keyword=' + encodeURIComponent($input.val()) + "&searchtype=product";
			}
		}
	};
	widget.prototype.redirectSearchShopPage = function (isDefault) {
	   
	    var $input = this.getElement().find('.search_box_t input');
	    value = $input.val();
	    if (value == '' && isDefault) {
	        if (isDefault.targetUrl) {
	            location.href = isDefault.targetUrl + "&searchtype=shop";
	        } else {
	            location.href = '/list?keyword=' + encodeURIComponent(isDefault.name) + "&searchtype=shop";
	        }
	    } else {
	        location.href = '/list?keyword=' + encodeURIComponent($input.val()) + "&searchtype=shop";
	    }
	};
    // 固定顶部的搜索框
    //屏幕向下滑动一屏距离出现搜索固定到顶部
	widget.prototype.scrollShowSearch = function () {
	    var self = this;
	    $(window).scroll(function () {
	        if ($(window).scrollTop() > $(window).height()) {
	            self.search_fixed_flag = true;
	            $(".search_top_fixed").show();
	        } else {
	            self.search_fixed_flag = false;
	            $(".search_top_fixed").hide();
	        }
	    });
	};
    // 固定搜索宝贝跳转
	widget.prototype.redirectSearchFixedPage = function (isDefault) {
	    var queryString = new cb.util.queryString();
	    if (location.href.indexOf('supplier_') > -1 || queryString.get('shop_id')) {
	        var index = location.href.indexOf('supplier_');
	        var shop_id = queryString.get('shop_id') || location.href.substring(index + 9);
	    }
	    var $input = $('#search-fixed-input');
	    value = $input.val();
	    if (shop_id) {
	        if (value == '' && isDefault) {
	            if (isDefault.targetUrl) {
	                location.href = isDefault.targetUrl + '&shop_id=' + shop_id + "&searchtype=product";
	            } else {
	                location.href = '/list?keyword=' + encodeURIComponent(isDefault.name) + '&shop_id=' + shop_id + "&searchtype=product";
	            }
	        } else {
	            location.href = '/list?keyword=' + encodeURIComponent($input.val()) + '&shop_id=' + shop_id + "&searchtype=product";
	        }
	    } else {
	        if (value == '' && isDefault) {
	            if (isDefault.targetUrl) {
	                location.href = isDefault.targetUrl + "&searchtype=product";
	            } else {
	                location.href = '/list?keyword=' + encodeURIComponent(isDefault.name) + "&searchtype=product";
	            }
	        } else {
	            location.href = '/list?keyword=' + encodeURIComponent($input.val()) + "&searchtype=product";
	        }
	    }
	};
    // 固定搜索店铺跳转
	widget.prototype.redirectSearchShopFixedPage = function (isDefault) {
	    var $input = $('#search-fixed-input');
	    value = $input.val();
	    if (value == '' && isDefault) {
	        if (isDefault.targetUrl) {
	            location.href = isDefault.targetUrl + "&searchtype=shop";
	        } else {
	            location.href = '/list?keyword=' + encodeURIComponent(isDefault.name) + "&searchtype=shop";
	        }
	    } else {
	        location.href = '/list?keyword=' + encodeURIComponent($input.val()) + "&searchtype=shop";
	    }
	};
	return widget;
});