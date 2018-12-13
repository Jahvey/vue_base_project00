designer.settings.register('toolbar', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    var isPreview = true;
    var listViewUrl = '';
    widget.prototype.proxy = cb.rest.DynamicProxy.create({
        getFooterWidgetconfig: { url: 'client/Template/getFooterWidgetconfig', method: 'GET' },
        getClassesByClassType: { url: '/corp/ProductClasses/getClassesByClassType', method: 'POST', options: { async: false } },
        getBrand: { url: '/corp/ProductBrand/loadAll', method: 'GET', options: { async: false } },
    });
    widget.prototype.preprocess = function ($node, config) {
        this.$node = $node;
        if (config.icons) {
            if (config.icons.constructor == Array) {
                this.config = config;
                $node.find('.toolbar-style option.' + config.style[0].style + '').attr("selected", "selected");
                $node.find('.toolbarList').html(this.render($node.find('#addToolbarTpl'), {
                    config: config.icons
                }));
            };

        };

    };
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        widgetname = instance.getId();
        NewConfig = instance.getConfig();
        this.initData = {
            toolbar_url: {
                home: "homeView",
                classify: "categoryView",
                cart: "cartView",
                user: "memberView",
                list: "listView",
                shoplist: "shopView",
                share: "",
                freebuy: "freebuyView",
            },
            toolbar_icon: {
                home: "/img/footer-1.png",
                classify: "/img/footer-2.png",
                cart: "/img/footer-3.png",
                user: "/img/footer-4.png",
                list: "/img/footer-6.png",
                shoplist: "/img/footer-7.png",
                share: "/img/footer-5.png",
                freebuy:"/img/footer-8.png"
            },
            toolbar_icon_active: {
                home: "/img/footer-1-a.png",
                classify: "/img/footer-2-a.png",
                cart: "/img/footer-3-a.png",
                user: "/img/footer-4-a.png",
                list: "/img/footer-6-a.png",
                shoplist: "/img/footer-7-a.png",
                share: "/img/footer-5-a.png",
                freebuy: "/img/footer-8-a.png",
            },
            toolbar_name: {
                home: "首页",
                classify: "分类",
                cart: "购物车",
                user: "我的",
                list: "列表",
                shoplist: "供应商",
                share: "易分销",
                freebuy:"自助购"
            },
            toolbar_type: ["home", "classify", "cart", "user", "list", "shoplist", "share","freebuy"]
        };
        callback(NewConfig);
        //商城个人中心图片悬浮
        $('.item-title.userType label').on('mouseover',function(e){
            var imgPreview;
            var topItem=$('.item-title.userType input').eq(0).offset().top+16;
            var leftItem=$('.item-title.userType input').eq(0).offset().left;
            if($(this).attr('data-style')==='oldStore'){
                imgPreview='<div class="imgPreview"><img src="templatedesigner/img/oldStore.png"/></div>'
            }else if($(this).attr('data-style')==='personalCenter'){
                imgPreview='<div class="imgPreview"><img src="templatedesigner/img/personalCenter.png"/></div>'
            }
            $('.widgetconfig .imgPreview').remove();
            $('.widgetconfig').append(imgPreview);
            $('.widgetconfig .imgPreview').offset({top:topItem,left:leftItem});
        })
        $('.item-title.userType label').on('mouseout',function(e){
            $('.widgetconfig .imgPreview').remove();
        })
    };

    widget.prototype.getAvailableType = function () {
        var tempArray = [];
        var toolbar = $('.widgetconfig .toolbar');
        var aItem = toolbar.find('.toolbarList .toolbar_item');
        for (var i = 0, len = aItem.length; i < len; i++) {
            var toolbar_type = $(aItem[i]).find('.toolbar_type option:selected').data('type');
            tempArray.push(toolbar_type);
        };
        return this.initData.toolbar_type.diff(tempArray);
    };
    widget.prototype.afterInit = function () {
        var self = this;
        if (this.config) {
            for (var i = 0; i < this.config.icons.length; i++) {
                this.UploadPhoto(this.config.icons[i], true);
                var product_scope = this.config.icons[i].product_scope;
                var product_filter = this.config.icons[i].product_filter;
                if (product_scope == "class") {
                    if (!self.classTypeData) {
                        self.proxy.getClassesByClassType({ classType: "general" }, function (err, result) {
                            if (result) {
                                self.classTypeData = result;
                                $('.product_filter').html(self.getClassTypeTpl(self.classTypeData));
                                $('.toolbarList .product_select .product_filter option[data-id=' + product_filter + ']').attr('selected', 'selected');
                            }
                        });
                    } else {
                        $('.product_filter').html(self.getClassTypeTpl(self.classTypeData));
                        $('.toolbarList .product_select .product_filter option[data-id=' + product_filter + ']').attr('selected', 'selected');
                    }
                    $('.toolbarList .product_select .product_scope option[data-type=' + product_scope + ']').attr('selected', 'selected');
                } else if (product_scope == "brand") {
                    if (!self.brandData) {
                        self.proxy.getBrand(function (err, result) {
                            self.brandData = result.brands;
                            $('.product_filter').html(self.getBrandTpl(result.brands));
                            $('.toolbarList .product_select .product_filter option[data-id=' + product_filter + ']').attr('selected', 'selected');
                        });
                    } else {
                        $('.product_filter').html(self.getBrandTpl(self.brandData));
                        $('.toolbarList .product_select .product_filter option[data-id=' + product_filter + ']').attr('selected', 'selected');
                    }
                    $('.toolbarList .product_select .product_scope option[data-type=' + product_scope + ']').attr('selected', 'selected');
                }

            }
            for (var j = 0; j < $('.toolbarList').children().length; j++) {
                var _this = $($('.toolbarList').children()[j]).find('div[data-type="list"]');
                var isSystemMenu = $($('.toolbarList').children()[j]).find('input[data-style="systemToolbar"]').prop('checked');
                if (_this.length > 0 && isSystemMenu) {
                    $($(_this)[0].closest('.row')).find('.product_select').css({ 'display': 'block' });
                }
            }
            for (var i = 0, len = this.config.icons.length; i < len; i++) {
                var toolbar_url = this.config.icons[i].toolbar_url;
                if (toolbar_url.indexOf("channel/") > -1) {
                    $($('.toolbarList').children()[i]).find('input[data-style="systemToolbar"]').removeAttr('checked');
                    $($('.toolbarList').children()[i]).find('input[data-style="customToolbar"]').prop("checked", true);
                    $($('.toolbarList').children()[i]).find(".toolbar_type_li").addClass("hide");
                    $($('.toolbarList').children()[i]).find(".toolbar_url_li").removeClass("hide");
                }
            }
        }
        this.initEvent();
        $('#addToolbar').on('click', function () {
            var _this = this;
            self.addToolbar(_this);
        });
        $('#confirm').on('click', function (e) {
            self.collectData(e)
        });
    };
    //排序图标
    widget.prototype.moveUpClick = function (e, type) {
        var targetContent = $(e.currentTarget).closest('.content-block');
        if (type == 'up' && targetContent.prev().hasClass('content-block')) {
            targetContent.insertBefore($(targetContent.prev()));
        } else if (type == 'down' && targetContent.next().hasClass('content-block')) {
            targetContent.insertAfter($(targetContent.next()));
        }
    };
    //删除图标
    widget.prototype.delInitPhoto = function (e, _this) {
        var id = $(_this).parent().data("id");
        $(e.currentTarget).closest('.content-block').remove();
    };
    //添加图标
    widget.prototype.addToolbar = function (_this) {
        this.availableType = this.getAvailableType()[0];
        var self = this;
        var id = $(_this).closest('.row').prev().find('.toolbar_item').length + 1;
        var maxId;
        var idArr = [];
        for (var i = 0; i < this.config.icons.length; i++) {
            idArr.push(this.config.icons[i].id);
        }
        maxId = Math.max.apply(null, idArr);
        if (id > 7) {
            alert("最多只能有7个了")
            return;
        };
        var config = this.availableType ? {
            isSystemToolbar: true,
            toolbar_type: this.availableType,
            toolbar_name: this.initData.toolbar_name[this.availableType],
            toolbar_icon: this.initData.toolbar_icon[this.availableType],
            toolbar_url: this.initData.toolbar_url[this.availableType],
            isPersonalCenter:this.initData.toolbar_url[this.availableType],
            id: maxId + 1,
        } : {
            isSystemToolbar: false,
            toolbar_type: "",
            toolbar_name: "自定义名称",
            toolbar_icon: "",
            toolbar_url: "",
            id: maxId + 1,
        };
        this.config.icons.push(config);
        var html = this.render(this.$node.find('#addToolbarTpl'), { config: [config] });

        var container = $(_this).closest('.row').prev();
        container.append(html);
        if (config.toolbar_type == 'list') {
            $(_this).closest('.row').prev().find('.toolbar_item:last-child').find('.product_select').css({ 'display': 'block' });
        }
        this.UploadPhoto(config, true);
        this.initEvent();
    };
    widget.prototype.initEvent = function () {
        var self = this;
        $(".toolbar_type_control input").click(function (e) {
            if ($(this).data("style") == "customToolbar") {
                $(this).closest("ul").find(".toolbar_type_li").addClass("hide");
                $(this).closest("ul").find(".toolbar_url_li").removeClass("hide");
                $(this).closest("ul").find(".product_select").css({ 'display': 'none' });
            } else {
                $(this).closest("ul").find(".toolbar_type_li").removeClass("hide");
                $(this).closest("ul").find(".toolbar_url_li").addClass("hide");
                if ($(this).closest('.row').find("option:selected").data("type") == 'list') {
                    $(this).closest("ul").find(".product_select").css({ 'display': 'block' });
                }
            }
        })
        $('.delete_photo').on('click', function (e) {
            self.delInitPhoto(e, this);
        });
        $(".moveup_photo").on("click", function (e) {
            self.moveUpClick(e, 'up');
        });
        $(".movedown_photo").on("click", function (e) {
            self.moveUpClick(e, 'down');
        });
        $('#addPhotoConfirm').on('click', function (e) {
            if ($(e.currentTarget).closest('.widgetconfig').find('.diyButton').length > 0) {
                alert("请先上传图片");
            }
            self.collectData(e);
        });
        $('.toolbar_type').on('change', function (e) {
            self.selectToolType($(this).find("option:selected").data("type"), $(this).parent().data("type"), this)
        })
        $('.toolbar_name').on('change', function (e) {
            var val = $.trim($(this).val())
            if (val.length > 10) {
                alert("名称最多不能超过10个字符,请重新输入");
                $(this).val($.trim(val).substring(0, 10));
            }
        });
        $('select.product_scope').on('change', function (e) {
            var type = $(this).find("option:selected").data("type");
            if (!type) return;
            self.selectedType = type;
            if (type == "class") {
                if (!self.classTypeData) {
                    self.proxy.getClassesByClassType({ classType: "general" }, function (err, result) {
                        if (result) {
                            self.classTypeData = result;
                            $('.product_filter').html(self.getClassTypeTpl(self.classTypeData));
                            //var typeData = self.classTypeData[0].id;
                            //listViewUrl = 'list?categoryid=' + typeData;
                            //if (cb.util.localStorage.getItem('listViewUrl')) {
                            //    cb.util.localStorage.removeItem('listViewUrl');
                            //}
                            //cb.util.localStorage.setItem('listViewUrl', listViewUrl);
                        }
                    });
                } else {
                    $('.product_filter').html(self.getClassTypeTpl(self.classTypeData));
                    //var typeData = self.classTypeData[0].id;
                    //listViewUrl = 'list?categoryid=' + typeData;
                    //if (cb.util.localStorage.getItem('listViewUrl')) {
                    //    cb.util.localStorage.removeItem('listViewUrl');
                    //}
                    //cb.util.localStorage.setItem('listViewUrl', listViewUrl);
                };
                //$('select.product_filter').on('change',function(e){
                //	var typeData = $(this).find("option:selected").data("id");
                //	listViewUrl = 'list?categoryid=' + typeData;
                //	if (cb.util.localStorage.getItem('listViewUrl')) {
                //	    cb.util.localStorage.removeItem('listViewUrl');
                //	}
                //	cb.util.localStorage.setItem('listViewUrl', listViewUrl);
                //});

            } else if (type == "brand") {
                if (!self.brandData) {
                    self.proxy.getBrand(function (err, result) {
                        self.brandData = result.brands;
                        $('.product_filter').html(self.getBrandTpl(result.brands));
                        //var typeData = result.brands[0].id;
                        //listViewUrl = 'list?brand_id=' + typeData;
                        //if (cb.util.localStorage.getItem('listViewUrl')) {
                        //    cb.util.localStorage.removeItem('listViewUrl');
                        //}
                        //cb.util.localStorage.setItem('listViewUrl', listViewUrl);
                    });
                } else {
                    $('.product_filter').html(self.getBrandTpl(self.brandData));
                    //var typeData = self.brandData[0].id;
                    //listViewUrl = 'list?brand_id=' + typeData;
                    //if (cb.util.localStorage.getItem('listViewUrl')) {
                    //    cb.util.localStorage.removeItem('listViewUrl');
                    //}
                    //cb.util.localStorage.setItem('listViewUrl', listViewUrl);
                }
                //$('select.product_filter').on('change',function(e){
                //	var typeData = $(this).find("option:selected").data("id");  
                //	listViewUrl = 'list?brand_id=' + typeData;
                //	if (cb.util.localStorage.getItem('listViewUrl')) {
                //	    cb.util.localStorage.removeItem('listViewUrl');
                //	}
                //	cb.util.localStorage.setItem('listViewUrl', listViewUrl);
                //});

            }

            //阻止事件冒泡
            var evt = e ? e : window.event;
            if (evt.stopPropagation) {
                //W3C 
                evt.stopPropagation();
            }
            else {
                //IE 
                evt.cancelBubble = true;
            }
        });

    };
    widget.prototype.getClassTypeTpl = function (data) {
        var html = "";
        for (var i = 0; i < data.length; i++) {
            html += '<option data-id="' + data[i].id + '">' + data[i].cName + '</option>';
        };
        return html;
    };
    widget.prototype.getBrandTpl = function (data) {
        var html = "";
        for (var i = 0; i < data.length; i++) {
            html += '<option data-id="' + data[i].id + '">' + data[i].brand_name + '</option>';
        };
        return html;
    };
    widget.prototype.UploadPhoto = function (file, isDefault) {
        var self = this;
        this.uploader = $('#uploadpic_' + file.id).diyUpload({
            url: cb.rest._getUrl('/client/FileUpload/upload'),
            oneThumb: true,
            cancelButtonText: "取消",
            buttonText: "添加图标",
            success: function (data) {
                $(this).data('url', data.data.imgurl);
                $(this).parent().find('div.viewThumb img').prop('src', data.data.imgurl);
            },
            error: function (err) {
                alert("添加图标失败！" + err);
                console.info(err);
            }
        });
        this.uploader.reset();
        file.isNotFile = true;
        this.picInfo = file;
        file.url = file.toolbar_icon;
        this.uploader.createBox($('#uploadpic_' + file.id), file);
    };
    widget.prototype.selectToolType = function (key, data, _this) {
        $(_this).closest("ul").find(".toolbar_url").val(this.initData.toolbar_url[key]);
        $(_this).closest("ul").find(".toolbar_name").val(this.initData.toolbar_name[key]);
        var selectId = $(_this).closest("ul").find('.uploadpic')[0].id.substring(10);
        if (this.config) {
            for (var i = 0; i < this.config.icons.length; i++) {
                if (this.config.icons[i].toolbar_type == data) {
                    this.config.icons[i].toolbar_icon = this.initData.toolbar_icon[key];
                    this.UploadPhoto(this.config.icons[i], true)
                }
            }
            if (key == 'list') {
                $(_this).closest('.row').find('.product_select').css({ 'display': 'block' });
            } else {
                $(_this).closest('.row').find('.product_select').css({ 'display': 'none' });
            }
        }
        this.initEvent();
    }
    widget.prototype.collectData = function () {
        var self = this;
        var toolbar = $('.widgetconfig .toolbar');
        var aItem = toolbar.find('.toolbarList .toolbar_item');
        /****toolbar.find('.toolbar-style option:selected').attr('class')***/
        var newConfig = [
            {
                "$": {
                    "key": "icons"
                },
                "item": []
            },
            {
                "$": {
                    "key": "style"
                },
                "item": [{ "$": { "style": 'line' } }]
            }
        ];
        for (var i = 0, len = aItem.length; i < len; i++) {
            var item = aItem[i];
            var isPersonalCenter = false;
            var isSystemToolbar = $(item).find('.toolbar_type_control input:checked').data('style') == "systemToolbar" ? true : false;
            var toolbar_type = $(item).find('.toolbar_type option:selected').data('type');
            var toolbar_name = $.trim($(item).find('input.toolbar_name').val());
            var product_scope;
            var product_filter;
            if (!toolbar_name) {
                alert("菜单名称不能为空!");
                return;
            }
            if ($(item).find('.product_select').is(':visible')) {
                product_scope = $(item).find('.product_scope option:selected').attr('data-type');
                product_filter = $(item).find('.product_filter option:selected').attr('data-id');
            }
            var toolbar_icon = $(item).find('div.viewThumb img').prop("src");
            if (toolbar_icon.indexOf("footer") > -1) {
                var toolbar_icon_active = this.initData.toolbar_icon_active[toolbar_type];
                if (toolbar_icon.indexOf("http") > -1) {
                    var toolbar_icon = '/img' + toolbar_icon.split('img')[1];
                }
            } else {
                toolbar_icon = '/photo' + toolbar_icon.split('photo')[1];
                var toolbar_icon_active = toolbar_icon;
            }
            var toolbar_url = $(item).find('input.toolbar_url').val();
            //如果有我的默认菜单
            if (toolbar_type=='user') {
                debugger;
                if($(item).find('.userType input:checked').parent().data('style') == "personalCenter" ){
                    var isPersonalCenter=true;
                };

            }
            newConfig[0].item.push({
                    "$": {
                        isSystemToolbar: isSystemToolbar,
                        toolbar_type: toolbar_type,
                        toolbar_name: toolbar_name,
                        toolbar_icon: toolbar_icon,
                        toolbar_icon_active: toolbar_icon_active,
                        toolbar_url: toolbar_url,
                        isPersonalCenter:isPersonalCenter,
                        id: i + 1
                    }
                });
        }
        if (!len) {
            alert("请至少添加一个菜单!");
            return;
        }
        var len = newConfig[0].item.length;
        if (len % 2 && newConfig[1].item[0].$.style == "streamline") {
            newConfig[0].item[(len - 1) / 2].$.oddcenter = true;
        } else {
            newConfig[0].item.forEach(function (item) {
                item.$.oddcenter = false;
            })
        }
        //遍历配置文件,给每个对象赋值是否是奇数
        for (var i = 0; i < newConfig[0].item.length; i++) {
            if (newConfig[0].item[i].$.isSystemToolbar) {
                switch (newConfig[0].item[i].$.toolbar_type) {
                    case 'home':
                        newConfig[0].item[i].$.toolbar_url = 'homeView';
                        break;
                    case 'classify':
                        newConfig[0].item[i].$.toolbar_url = 'categoryView';
                        break;
                    case 'cart':
                        newConfig[0].item[i].$.toolbar_url = 'cartView';
                        break;
                    case 'user':
                        newConfig[0].item[i].$.toolbar_url = 'memberView';
                        break;
                    case 'list':
                        newConfig[0].item[i].$.toolbar_url = 'listView';
                        break;
                    default:
                        break;
                }
            }
            if (newConfig[0].item[i].$.toolbar_type == 'list') {
                var type = $('select.product_scope').find("option:selected").data("type");
                if (!type || typeof (type) == "undefined") {
                    type = self.selectedType || "class";
                }
                var product_filter_container = $('select.product_filter').find("option:selected");
                var typeData = $($('select.product_filter').find("option:selected")[product_filter_container.length - 1]).data("id");
                product_filter_container.each(function () {
                    var displayContent = $(this).parents(".product_select").css("display");
                    if (displayContent == "block") {
                        typeData = $(this).data("id");
                    }
                });
                //var typeData = $('select.product_filter').find("option:contains('" + f_company_addr[1] + "')").data("id");
                if (type == "brand") {
                    listViewUrl = 'list?brand_id=' + typeData;
                } else {
                    listViewUrl = 'list?categoryid=' + typeData;
                }
                newConfig[0].item[i].$.listViewUrl = listViewUrl;
                newConfig[0].item[i].$.product_scope = product_scope;
                newConfig[0].item[i].$.product_filter = product_filter;
            };
            if (newConfig[0].item[i].$.toolbar_url.indexOf('channel/') > -1) {
                newConfig[0].item[i].$.isSystemToolbar = true;
                newConfig[0].item[i].$.toolbar_type = 'channel';
                newConfig[0].item[i].$.toolbar_url = 'channel/' + newConfig[0].item[i].$.toolbar_url.split('/')[newConfig[0].item[i].$.toolbar_url.split('/').length - 1];
            };
            if (newConfig[0].item[i].$.oddcenter == undefined) {
                newConfig[0].item[i].$.oddcenter = false;
            };
            if (newConfig[0].item[i].$.toolbar_icon == undefined) {
                alert('上传图片已经取消,请重新上传新的图片');
                isPreview = false;
                return;
            } else {
                isPreview = true;
            };
        }
        if (isPreview) {
            if (len % 2 == 0 && newConfig[1].item[0].$.style == "streamline") {
                alert('自定义菜单个数是偶数,不能选择流线型布局');
                return;
            }
            this.runTemplate(newConfig);
        }

    };

    Array.prototype.diff = function (a) {
        return this.filter(function (i, index, arr) {
            return a.indexOf(i) < 0;
        })
    }
    return widget;
});