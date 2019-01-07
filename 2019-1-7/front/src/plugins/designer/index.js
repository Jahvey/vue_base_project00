var isAndroid = Framework7.prototype.device.android === true;
var isIos = Framework7.prototype.device.ios === true;
Template7.registerHelper('adjustImgSrc', function (src) {
    return cb.util.adjustImgSrc(src);
});
var $$ = Dom7;
var myApp = new Framework7({
    precompileTemplates: true,
    template7Pages: true
});

export default function(orgPageId,systemPageId){
    if(location.hash.indexOf('decoration/index')>-1){
        var init = function () {
            designer.init();
            var self = this;
            var proxy = cb.rest.DynamicProxy.create({
                getTemplate: {
                    url: '/csc-designer/client/getTemplate',
                    method: 'GET'
                },
                getReferenceTemplate: {
                    url: 'corp/Template/templatepagelist',
                    method: 'POST'
                },
                getSupplierReferenceTemplate: {
                    url: 'corp/Template/getReferenceTemplate',
                    method: 'POST'
                }

            });
            var config;
            proxy.getTemplate({
                route: 'home',
                version: new cb.util.queryString().get('version') || '',
                orgPageId:systemPageId
            }, function (err, data) {
                cb.init(data, function (controller) {
                    var queryString = new cb.util.queryString();
                    var pagelistid = queryString.get("pagelistid");
                    var node = document.createElement('div');
                    node.innerHTML = data;
                    $$('.Phone').html($$(node).children('div').html());
                    var $view = $$('[data-controller=' + controller.controllerName + ']');
                    if (!$view.length) return;
                    controller._set_data('view', $view);
                    $$('.layout').scroll(function (e) {
                        myApp.initImagesLazyLoad(controller.getView()[0]);
                    });
                    var widgets = controller.getWidgets();
                    var widgetType;
                    var clickwidgetname;
                    var offsetTop;
                    var clickCallback = function (widget) {
                        widget.preventDefault();
                        var dataType = $$(this).attr('data-type') == null ? $$(this).children().attr('data-type') : $$(this).attr('data-type');
                        switch (dataType) {
                            case "platform_search":
                                widgetType = 'platform_search';
                                break;
                            case "ImageText":
                                widgetType = 'image_text';
                                break;
                            case "IndexGoods":
                                widgetType = 'index_goods';
                                break;
                            case 'MainPhoto':
                                widgetType = 'main_pictures';
                                break;
                            case "MainSlide":
                                widgetType = 'main_slide';
                                break;
                            case "MagicBox":
                                widgetType = 'magic_box';
                                break;
                            case "Coupon":
                                widgetType = 'coupon';
                                break;
                            case "bulletin":
                                widgetType = 'bulletin';
                                break;
                            case "CustomerService":
                                widgetType = 'CustomerService';
                                break;
                            case "CustomerServiceChannel":
                                widgetType = 'CustomerServiceChannel';
                                break;
                            case "Toolbar":
                                widgetType = 'toolbar';
                                break;
                        }
                        if (widgetType == 'CustomerService') {
                            var widget = widgets['CustomerService'];
                            clickwidgetname = 'CustomerService';
                        } else if (widgetType == 'CustomerServiceChannel') {
                            var widget = widgets['CustomerServiceChannel'];
                            clickwidgetname = 'CustomerServiceChannel';
                        } else {
                            var widget = widgets[$$(this).attr('id')];
                            if (!widget) {
                                var widget = widgets[$$(this).attr('id').substr(0, $$(this).attr('id').indexOf('*'))];
                            }
                            clickwidgetname = $$(this).attr('data-name');
                        }
                        config = widget;
                        if (widgetType == 'CustomerService' || widgetType == 'CustomerServiceChannel') {
                            $$("#action").show();
                            $$("#action")[0].style.top = widget.getElement()[0].offsetTop / 2 + 100 + 'px';
                            $$("#action")[0].style.left = $$(".layout")[0].offsetWidth * 0.2 + 270 + 'px';
                        } else {
                            suspension(widget);
                        }
                        for (var attr in widgets) {
                            if (widgets[attr].getId().indexOf('*') > -1) {
                                var widgetId = widgets[attr].getId().substr(0, widgets[attr].getId().indexOf('*'));
                            } else {
                                var widgetId = widgets[attr].getId();
                            }
                            if (widgets[attr].widgetType === 'MagicBox' && widgetId !== clickwidgetname)
                                widgets[attr]._set_data('hasClicked', false);
                        }
                        widget.orgPageId=orgPageId;
                        controller.insertSetting(widgetType, widget);
                    };
                    controller.on('afterBatchSubmit', function () {
                        for (var attr in widgets) {
                            widgets[attr].getElement().click(clickCallback);
                            widgets[attr].getElement().on("mousedown", function (e) {
                                e.stopImmediatePropagation();
                            });
                        }
                    });
                    /**
                     * 区域设置
                     */

                    $$('.btn-resetDistrict').on('click', function () {
                        var widgetType = this.id;
                        var x = new Date().valueOf();
                        var widgetName = widgetType + '_' + x;
                        var widget = controller.getWidgets()['district'];
                        controller.insertSetting(widgetType, widget);
                    });
                    //保存布局

                    $$(".btn-submit").on("click", function () {
                    	var pagelayout = JSON.stringify(PageLayout());
                    	if(pagelayout.length<=30){
                                alert("布局不能为空！");
                                return;
                         }
                        // 弹出层
                        $$(".Mask-layer").show();
                        $$(".Mask-layer>.Popup-s").css("opacity", "0").transform("translate(0,-50px)").transition(300);
                        $$(".Mask-layer>.Popup-w").css("opacity", "1").transform("translate(0,50px)").transition(300);


                        
                        var newConfig = { view: { $: "", widget: [] } };
                        var footerConfig = {
                            view: {
                                $: {
                                    controller: "HomeViewController",
                                    name: "homeView"
                                }, widget: []
                            }
                        };
                        for (var attr in designer.settings.configs) {
                            if (attr == "toolbar") {
                                footerConfig.view.widget.push(designer.settings.configs[attr]);
                            } else if (attr == "platform_search") {
                                headerConfig.view.widget.forEach(function (indexTtem) {
                                    if (indexTtem.$.type == 'platform_search') {
                                        var mark = 0;
                                        for (var i = 0; i < indexTtem.config.length; i++) {
                                            if (indexTtem.config[i].$.key == designer.settings.configs[attr].config[0].$.key) {
                                                indexTtem.config[i].item = designer.settings.configs[attr].config[0].item;
                                                mark = 1;
                                                break;
                                            }
                                            if (i + 1 == indexTtem.config.length && mark == 0) {
                                                indexTtem.config.push(designer.settings.configs[attr].config[0]);
                                            }
                                        }
                                    }

                                })
                            } else {
                                newConfig.view.widget.push(designer.settings.configs[attr]);
                            }
                        }

                        var widgetconfig = encodeURIComponent(JSON.stringify(newConfig));
                        var versionMemo = decodeURIComponent(queryString.get("versionMemo"));
                        if (queryString.has('version')) {
                            var proxy = cb.rest.DynamicProxy.create({
                                editVersion: { url: '/client/saveConfig', method: 'POST' }
                            });
                            proxy.editVersion({ footerConfig: JSON.stringify(footerConfig), wigetconig: widgetconfig, layoutdata: pagelayout, versionMemo: versionMemo, type: "M", id: pagelistid }, function (err, result) {
                                if (!err) { alert("保存版本成功！"); } else { alert("保存版本失败！"); }
                                queryString.del('version');
                                queryString.del('versionMemo');
                                location.href = '/templatedesigner' + queryString.toStr();
                            });
                        } else {
                            //alert(org_info_id+'liwlwiwlwi')
                            var proxy = cb.rest.DynamicProxy.create({
                                save: { url: '/remote', method: 'POST' }
                            });
                            proxy.save({
                                serviceId:'restService',
                                serviceParam:JSON.stringify({url:'csc-plat/client/saveConfig'}),
                                jsonData:JSON.stringify({msgEntity:{orgPageId:orgPageId, 
                                    headerConfig: JSON.stringify(headerConfig), 
                                    footerConfig: JSON.stringify(footerConfig), 
                                    wigetconig: widgetconfig,
                                    layoutdata: pagelayout,
                                    wiget: JSON.stringify(newConfig),
                                    type: "M", id: pagelistid}})
                                },function (err, result) {
                                if (!err) {
                                    // $$(".Mask-layer").show();
                                    $$(".Mask-layer>.Popup-w").css("opacity", "0").transform("translate(0,-50px)").transition(300);
                                    $$(".Mask-layer>.Popup-s").css("opacity", "1").transform("translate(0,50px)").transition(300);
                                    setTimeout(function () {
                                        $$(".Mask-layer").hide();
                                    }, 1000);
                                    // alert("保存布局成功！");
                                } else {
                                    // alert("保存布局失败！"+err.message);
                                    // $$(".Mask-layer").show();
                                    $$(".Mask-layer>.Popup-w").css("opacity", "0").transform("translate(0,-50px)").transition(300);
                                    $$(".Mask-layer>.Popup-s").css("opacity", "1").transform("translate(0,50px)").transition(300);
                                    $$(".Mask-layer>.Popup-s>span").html("错误："+err.msgEntity.err);
                                    setTimeout(function () {
                                        $$(".Mask-layer").hide();
                                    }, 1000);
                                }
                            });
                        }
                    });
                    //恢复默认
                    $$(".btn-reset").on("click", function () {
                        myApp.confirm('您的操作将导致之前的辛苦将白费,确定继续么？', 'U商城', function () {
                            var proxy = cb.rest.DynamicProxy.create({
                                resetPage: {
                                    url: 'corp/Template/reset',
                                    method: 'POST'
                                }
                            });
                            proxy.resetPage({ type: "M", id: pagelistid }, function (err, result) {
                                if (!err) {
                                    queryString.del('version');
                                    queryString.del('versionMemo');
                                    location.href = '/templatedesigner' + queryString.toStr();
                                }
                            });
                        });
                    });
                    //版本
                    $$(".btn-version").on("click", function () {
                        $$('#masks')[0].style.display = "block";
                        $$('#VersionList')[0].style.display = "block";
                        var proxy = cb.rest.DynamicProxy.create({
                            save: { url: 'corp/Template/getversion', method: 'POST' }
                        });
                        proxy.save({ type: "M", id: pagelistid }, function (err, result) {
                            var tplStr = $$('#VersionDataTpl').html();
                            var func = Template7.compile(tplStr);
                            var html = func({ 'version': result });
                            $$('#VersionList').html(html);
                            $$(".cancel").on("click", function () {
                                $$('#masks')[0].style.display = "none";
                                $$('#VersionList')[0].style.display = "none";
                            });
                            $$(".modifyVersion").on("click", function () {
                                queryString.set('version', this.dataset["id"]);
                                queryString.set('versionMemo', encodeURIComponent(this.name));
                                location.href = '/templatedesigner' + queryString.toStr();
                            });
                            $$(".delVersion").on("click", function () {
                                var VersionId = this.dataset["id"];
                                myApp.confirm('确定删除该模板么？', 'U商城', function () {
                                    var proxy = cb.rest.DynamicProxy.create({
                                        delVersion: { url: 'corp/Template/delVersion', method: 'POST' }
                                    });
                                    proxy.delVersion({ version: VersionId }, function (err, result) {
                                        $$('#masks')[0].style.display = "none";
                                        $$('#VersionList')[0].style.display = "none";
                                    });
                                });
                            });
                            $$(".switchVersion").on("click", function () {
                                var VersionId = this.dataset["id"];
                                var versionMemo = this.name;
                                var proxy = cb.rest.DynamicProxy.create({
                                    SwitchVersion: { url: 'corp/Template/SwitchVersion', method: 'POST' }
                                });
                                proxy.SwitchVersion({ version: VersionId, versionMemo: versionMemo, type: "M", id: pagelistid }, function (err, result) {
                                    $$('#masks')[0].style.display = "none";
                                    $$('#VersionList')[0].style.display = "none";
                                    var queryString = new cb.util.queryString();
                                    queryString.del('version');
                                    queryString.del('versionMemo');
                                    location.href = '/templatedesigner' + queryString.toStr();
                                });
                            });
                        });
                    });
                    //保存为新版本
                    $$(".btn-saveversion").on("click", function () {
                        myApp.prompt('请输入版本名称!', '保存版本', function (value) {
                            var pagelayout = JSON.stringify(PageLayout());
                            var newConfig = { view: { $: "", widget: [] } };
                            var footerConfig = {
                                view: {
                                    $: {
                                        controller: "HomeViewController",
                                        name: "homeView"
                                    }, widget: []
                                }
                            };
                            for (var attr in designer.settings.configs) {
                                if (attr == "toolbar") {
                                    footerConfig.view.widget.push(designer.settings.configs[attr]);
                                } else {
                                    newConfig.view.widget.push(designer.settings.configs[attr]);
                                }
                            }
                            var widgetconfig = encodeURIComponent(JSON.stringify(newConfig));
                            var proxy = cb.rest.DynamicProxy.create({
                                save: {
                                    url: 'corp/Template/saveversion',
                                    method: 'POST'
                                }
                            });
                            proxy.save({ footerConfig: JSON.stringify(footerConfig), wigetconig: widgetconfig, layoutdata: pagelayout, versionMemo: value, type: "M", id: pagelistid }, function (err, result) {
                                if (!err) { alert("保存版本成功！"); } else { alert(err.message); promptRecursion(); }
                            });
                        });
                    });
                    function PageLayout() {
                        var ishasCustomerserver = false;
                        //var pagelayout = { "page": { "header": [], "body": [{ "row": [] }], "footer": [] } };
                        var pagelayout = { "page": { "body": [{ "row": [] }]} };
                        //pagelayout.page.footer.push({ "col": [{ "$": { "widgetname": $$('.Phone').find('.toolbar')[0].getAttribute('data-name'), "datatype": "toolbar", "colspan": "12" } }] });
                        //pagelayout.page.header.push({ "col": [{ "$": { "widgetname": "platform_search", "datatype": "platform_search" } }] });
                        var templatePage = new cb.util.queryString().get('templatePage');

                        var datatype = "";
                        var $widgets = $$('.page-content').find('[data-type]')
                        $widgets.each(function () {
                            var widget = this;
                            var col = { "col": [{ "$": { "widgetname": widget.getAttribute('data-name'), "datatype": "toolbar", "colspan": "" } }] }
                            switch (widget.getAttribute('data-type')) {
                                case "MainSlide":
                                    datatype = "main_slide";
                                    break;
                                case "ImageText":
                                    datatype = "image_text";
                                    break;
                                case "IndexGoods":
                                    datatype = "index_goods";
                                    break;
                                case "MainPhoto":
                                    datatype = "main_pictures";
                                    break;
                                case "MagicBox":
                                    datatype = "magic_box";
                                    break;
                                case "Coupon":
                                    datatype = "coupon";
                                    break;
                                case "CustomerService":
                                    datatype = "CustomerService";
                                    break;
                                case "CustomerServiceChannel":
                                    datatype = "CustomerServiceChannel";
                                    break;
                                case "Toolbar":
                                    datatype = "toolbar";
                                    break;
                            }
                            col.col[0].$.datatype = datatype;
                            col.col[0].$.colspan = "12";
                            pagelayout.page.body[0].row.push(col);
                        });
                        return pagelayout;
                    }
                    $$(".listbutton").on("click", function () {
                        var widgetType = this.id;
                        var insertTo = "";
                        if (widgetType == 'platform_searchlist') {
                            widgetType = 'platform_search';
                        }
                        var x = new Date().valueOf();
                        var widgetName = widgetType + '_' + x;
                        var widgetConfig = GetNewWidgetconfig(widgetType, widgetName);
                        $$.each($$('.page-content').find('.row'), function (index, value) {
                            if (value.className == "row click-border") {
                                insertTo = $$(value.children).children().attr('data-name');
                            }
                        });
                        switch (widgetType) {
                            case "platform_search":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                    widget.getElement().trigger('click');
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetType];
                                break;
                            case "index_goods":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                            case "image_text":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                            case "main_pictures":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                            case "main_slide":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                            case "magic_box":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                    widget.getElement().trigger('click');
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                            case "coupon":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                    widget.getElement().trigger('click');
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                            case "bulletin":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                    widget.getElement().trigger('click');
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                            case "CustomerService":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                    widget.getElement().trigger('click');
                                }, null, widgetConfig);
                                var widget = widgets[widgetType];
                                break;
                            case "CustomerServiceChannel":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                    widget.getElement().trigger('click');
                                }, null, widgetConfig);
                                var widget = widgets[widgetType];
                                break;
                            case "toolbar":
                                controller.insertWidget(widgetType, widgetName, function (widget) {
                                    widget.getElement().click(clickCallback);
                                    widget.getElement().trigger('click');
                                }, insertTo, widgetConfig);
                                var widget = widgets[widgetName];
                                break;
                        }
                        if (widgetType !== "CustomerService" && widgetType !== "CustomerServiceChannel" && widgetType !== "platform_search") {
                            suspension(widget);
                        }
                        config = widget;
                        for (var attr in widgets) {
                            if (widgets[attr].getId().indexOf('*') > -1) {
                                var widgetId = widgets[attr].getId().substr(0, widgets[attr].getId().indexOf('*'));
                            } else {
                                var widgetId = widgets[attr].getId();
                            }
                            if (widgets[attr].widgetType === 'MagicBox' && widgetId !== clickwidgetname)
                                widgets[attr]._set_data('hasClicked', false);
                        }
                        controller.insertSetting(widgetType, widget);
                    });
                    $(".move-up").on("click", function () {
                        var widget = widgets[clickwidgetname];
                        //var prevWidgetName = widget.getElement().parents('.row').prev().find('.widgetHasLoaded').attr('data-name');
                        //liw
                        var prevWidgetName = widget.getElement().parents('.row').prev().find('.col-100').find('div').attr('data-name');
                        controller.updownWidget(clickwidgetname, prevWidgetName, "up");
                        suspension(widget);
                    });
                    $(".move-down").on("click", function () {
                        var widget = widgets[clickwidgetname];
                        //var nextWidgetName = widget.getElement().parents('.row').next().find('.widgetHasLoaded').attr('data-name');
                        //liw
                        var nextWidgetName = widget.getElement().parents('.row').next().find('.col-100').find('div').attr('data-name');
                        controller.updownWidget(clickwidgetname, nextWidgetName, "down");
                        suspension(widget);
                    });
                    $(".layout-del").on("click", function () {
                        delete designer.settings.configs[clickwidgetname];
                        controller.deleteWidget(clickwidgetname);
                        $$("#action").hide();
                        $$(".widgetconfig").find('div.page').hide();
                        if (clickwidgetname == 'platform_search') {
                            isneedSearch = false;   //隐藏编辑页面
                        }
                    });
                    function suspension(widget) {
                        var $widgetContainer = widget.getElement().parents('.row');
                        $widgetContainer.prevAll().removeClass('click-border');
                        $widgetContainer.nextAll().removeClass('click-border');
                        $widgetContainer.addClass('click-border');
                        $("#action").show();
                        $("#action")[0].style.top = widget.getElement()[0].offsetTop + 2 + 'px';
                        $("#action")[0].style.left = $(".layout")[0].offsetWidth * 0.2 + 270 + 'px';
                    };
                });
            });
        };
        cb.rest.ContextBuilder.construct(init);
        var headerConfig ;
        var homeConfig;
        var viewData;
        var proxy = cb.rest.DynamicProxy.create({
            getwidget: {
                url: 'client/Template/getwidget',
                method: 'GET'
            },
            getwidgetconfig: {
                url: '/remote',
                method: 'POST'
            },
            getFooterWidgetconfig: {
                url: 'client/Template/getFooterWidgetconfig',
                method: 'GET'
            },
            getHeaderConfig: {
                url: 'fromheader/getHeaderConfig',
                method: 'GET'
            },
            getHomepageConfig: {
                url: 'fromhome/getHomeConfig',
                method: 'Get'
            }
        });
        proxy.getwidget(function (err, result) {
            WriteWigetHTML(JSON.parse(result));
        });
        proxy.getwidgetconfig({
            serviceId:'restService',
            serviceParam:JSON.stringify({url:'csc-plat/client/Template/getwidgetconfig'}),
            jsonData:JSON.stringify({msgEntity:{orgPageId:systemPageId}})
        }, function (err, result) {
            if (err) {
                alert(err.message);
                return;
            }
            var configs = JSON.parse(decodeURIComponent(result));
            viewData = configs.view.$;
            var tags = viewData.isneedToolbar == '0' ? '否' : '是';
            $(".isneedToolbar option:contains('" + tags + "')").prop('selected', 'selected');
            $('#margin_top').val(viewData.layoutSpacing);
            configs.view.widget.forEach(function (item) {
                if (item.$.type == 'index_goods' && !item.config[0].type) {  //兼容之前的商品列表
                    designer.settings.configs[item.$.name] = { $: { name: item.$.name, type: "index_goods" }, 'config': [{ '.tab_page:eq(0)': item.config, 'type': "index_goods" }] };
                } else {
                    designer.settings.configs[item.$.name] = item;
                }
            });
        });

        function WriteWigetHTML(json) {

        }

        function GetNewWidgetconfig(type, name) {
            switch (type) {
                case "platform_search":
                    var search_config = [{
                        "$": {
                            "key": 'home'
                        },
                        "item": [
                            { "$": { "allContent": '输入商品名称/关键字', "bgcolorObj": {} } }
                        ]
                    }]
                    return search_config;
                case "index_goods":
                    var goods_config = [{ 'configs': { "id": 0, "advertisement": null, "choosegoods": null, "colspan": null, "rows": "1", "cols": "4", "texttag": "", "show_market": null, "show_star": null, "isCurrentClass": null, "displayMode": "smallphoto", "showname": "initial", "showprice": "initial", "showsale": "initial", "filter": [{ "fieldname": "type_id", "valuefrom": "" }, { "fieldname": "saleprice", "valuefrom": "", "valueto": "" }, { "fieldname": "keyword", "valuefrom": "" }, { "fieldname": "categoryid", "valuefrom": "" }, { "fieldname": "brand_id", "valuefrom": "" }, { "fieldname": "tag_id", "valuefrom": "" }, { "fieldname": "salepoints", "valuefrom": "", "valueto": "" },], "order": [{}] } }]
                    return goods_config;
                case "image_text":
                    var text_config = { content: "<p>请添加文字或图片!</p>",orgPageId:orgPageId};
                    return text_config;
                case "main_slide":
                    var slide_config = { "data": [{ "id": "slide1", "cMemo": "", "iOrder": "", "cRedirectUrl": "","cRedirectId": "", "cAdImageUrl": "", "iHeight": "" }] };
                    return slide_config;
                case 'magic_box':
                    var magicBox_config = {orgPageId:orgPageId, "imagedata": [{ "url": null, "href": null, "startX": null, "startY": null, "nX": null, "nY": null, }] }
                    return magicBox_config;
                case 'main_pictures':
                    var photo_config = { "photos": [{ "id": '0', "porder": "5", "link": "", "height": "", "url": "", "linkId": "" }] }
                    return photo_config;
                case 'coupon':
                    var photo_config = { "data": [{ "id": 'coupon1', "couponid": '', "title": "", "backtype": "0", "startAmount": "", "reduceAmount": "", "expireStartDate": "", "expireEndDate": "", "background": "", "iorder": "", "itype": "false" }] }
                    return photo_config;
                case 'bulletin':
                    var text_config = { content: "<p>请添加文字或图片!</p>" };
                    return text_config;
                case 'CustomerService':
                    var CustomerService_config = { customerServiceName: '客服电话', floatPosition: 'right', customerServicefontsize: '12px', customerServicefontcolor: '#0000ff', customerServicebgcolor: '#f5f5f5' };
                    return CustomerService_config;
                case 'CustomerServiceChannel':
                    var CustomerServicechannel_config = { customerServiceName: '客服电话', floatPosition: 'right', customerServicefontsize: '12px', customerServicefontcolor: '#0000ff', customerServicebgcolor: '#f5f5f5' };
                    return CustomerServicechannel_config;
                case 'toolbar':
                    var toolbar = {
                        "data": [
                            { "home": ["../img/icon/footer-1.png", "../img/icon/footer-1-a.png", "首页"] },
                            { "category": ["../img/icon/footer-2.png", "../img/icon/footer-2-a.png", "分类"] },
                            { "cart": ["../img/icon/footer-3.png", "../img/icon/footer-3-a.png", "购物车"] },
                            { "member": ["../img/icon/footer-4.png", "../img/icon/footer-4-a.png", "我的"] },
                            { "custom": ["../img/icon/footer-4.png", "../img/icon/footer-4-a.png", "小易"] },
                        ]
                    }
                    return toolbar;
            }
        }
    }
}
