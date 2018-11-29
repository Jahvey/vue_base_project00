cb.views.register('AreaViewController', function (controllerName) {
    var view = function (widgets) {
        cb.views.BaseView.call(this, widgets);
    };
    view.prototype = new cb.views.BaseView();
    view.prototype.controllerName = controllerName;
    view.prototype.style1activeUrl = '';
    view.prototype.proxy = cb.rest.DynamicProxy.create({
        getArea: {
            url: 'client/Areas/getArea',
            method: 'GET',
            options: {
                token: true
            }
        },
        getAreaCategory: {
            url: 'client/Areas/getAreaCategory',
            method: 'GET'
        },
        getHotArea: {
            url: 'client/Areas/getHotArea',
            method: 'GET'
        },
        getDefaultArea: {
            url: 'client/Areas/getDefaultArea',
            method: 'POST',
            options: {
                token: true
            }
        }
    });
    view.prototype.init = function (callback, isShare, viewParams) {
        var self = this;
        var needLocation = true;
        var isDefaut = true;
        var newconfig = $$('.popup-districtStyle').data('config');
        if (cb.util.localStorage.getItem('areaid')) {
            cb.util.localStorage.removeItem('areaid');
        }
        if (cb.util.localStorage.getItem('areaname')) {
            cb.util.localStorage.removeItem('areaname');
        }
        if (cb.util.localStorage.getItem('Areatag')) {
            cb.util.localStorage.removeItem('Areatag');
        }
        if (cb.util.localStorage.getItem('templatePage')) {
            cb.util.localStorage.removeItem('templatePage');
        }
        if (cb.util.localStorage.getItem('superiors')) {
            cb.util.localStorage.removeItem('superiors');
        }
        if ((!newconfig && viewParams) || (viewParams && viewParams.url && viewParams.url.indexOf('tag') > -1)) {
            needLocation = false;
            isDefaut =false;
            var UrlString = new cb.util.getUrlparams(location.hash.substr(2));
            var tagNameUrl = UrlString.query.tag;
            var tagId = UrlString.query.areaId;
            cb.util.localStorage.setItem('Areatag', tagNameUrl);
            cb.util.localStorage.setItem('areaid', tagId);
            callback(viewParams.url, true);
        }
        var newconfigObj = JSON.parse(newconfig);
        if (needLocation) {
            self.getlocationArea(newconfigObj,isDefaut,isShare, callback, viewParams);
        }
        if (newconfigObj.styleType == '3') {
            this.proxy.getAreaCategory({}, function (err, result) {
                if (err) {
                    return
                } else {
                    var addressObj = {};
                    addressObj.data = result;
                    var provinceCmpProxy = cb.rest.DynamicProxy.create({
                        provinceCmp: { url: 'client/Areas/getAreaByCategoryId', method: 'POST', options: { token: true } }
                    });
                    // 判断是不是数据
                    if (result instanceof Array) {
                        if (cb.util.localStorage.getItem('categoryId')) {
                            var categoryId = cb.util.localStorage.getItem('categoryId');
                        } else {
                            var categoryId = result[0].id;
                        }
                        provinceCmpProxy.provinceCmp({ categoryId: categoryId }, function (err, result) {
                            var catoryData = {};
                            catoryData.dataArea = result;
                            var defaultProvinName = newconfigObj.customdefined[2].provinceCmp;
                            var defaultCityName = newconfigObj.customdefined[2].cityCmp;
                            var channelUrl = result[0].templatePage;
                            var styleHtml = self.render($$('#districtStyle3').html(), addressObj);
                            var styleHtmlArea = self.render($$('#districtStyle4').html(), catoryData);
                            $$('.catoryCity').html(styleHtml);
                            $('.provinceSelect').after(styleHtmlArea);
                            $$('.citySelect').on('click', function (e) {
                                $(e.target).parent().find('ul').show();
                                if (e.target.nodeName == 'LI') {
                                    $('#selectCity').val($(e.target).data('tag'));
                                    $('#selectCity').attr('data-id', $(e.target).data('id'));
                                    $('#selectCity').attr('data-url', $(e.target).data('url'));
                                    $('#selectCity').attr('data-name', $(e.target).data('name'));
                                    $('#selectCity').attr('data-tag', $(e.target).data('tag'));
                                    $(e.target).parent().hide();
                                }

                            });
                            if (!isShare && newconfigObj.firststartup !== null) {
                                myApp.popup('.popup-districtStyle');
                            }
                            var PopHtml = $$('.popup-districtStyle');
                            // self.getlocationArea(newconfigObj);
                            var bgpictutre = newconfigObj.customdefined[2].imgurl;
                            var currentTips = newconfigObj.customdefined[2].districttip;
                            if (bgpictutre) {
                                $('.ui-content').css('background', 'url(' + bgpictutre + ') no-repeat center');
                            };
                            if (currentTips) {
                                $$('#currentCity').html('热门' + currentTips);
                                $$('#currentCityTip').html('请选择您当前的所在' + currentTips + '进入下单购买');
                            }
                            if (cb.util.localStorage.getItem('superiors')) {
                                $$('#selectprovince').val(cb.util.localStorage.getItem('superiors'));
                            }
                            if (cb.util.localStorage.getItem('Areatag')) {
                                $('#selectCity').val(cb.util.localStorage.getItem('Areatag'));
                                $('#selectCity').attr('data-id', cb.util.localStorage.getItem('areaid'));
                                $('#selectCity').attr('data-url', cb.util.localStorage.getItem('templatePage'));
                                $('#selectCity').attr('data-tag', cb.util.localStorage.getItem('Areatag'));
                            }
                            $(PopHtml).find('.ui-locationCity').on('click', function () {
                                var channelUrl = $('.ui-locationCity').data('url');
                                var areaTag = $$('.ui-locationCity').data('tag');
                                var areaId = $$('.ui-locationCity').data('id');
                                var areaName = $$('.ui-locationCity').data('name');
                                if (channelUrl.indexOf('channel') > -1) {
                                    var activeUrl = self.dealChannel(channelUrl);
                                } else {
                                    var activeUrl = channelUrl.substring(0, channelUrl.length - 7);
                                }
                                if (cb.util.localStorage.getItem('Areatag')) {
                                    cb.util.localStorage.removeItem('Areatag');
                                }
                                if (cb.util.localStorage.getItem('areaid')) {
                                    cb.util.localStorage.removeItem('areaid');
                                }
                                if (cb.util.localStorage.getItem('areaname')) {
                                    cb.util.localStorage.removeItem('areaname');
                                }
                                cb.util.localStorage.setItem('Areatag', areaTag);
                                cb.util.localStorage.setItem('areaid', areaId);
                                cb.util.localStorage.setItem('areaname', areaName);
                                // 更新底部菜单购物车数量
                                if (cb.rest.AppContext.token) {
                                    self.updateCart();
                                } else {
                                    $$('.shoppingCartCount').hide();
                                }
                                callback(activeUrl);
                            });
                            $(PopHtml).find('.provinceSelect').on('click', function (e) {
                                $('.citySelect').hide();
                                if (e.target.nodeName == 'LI') {
                                    var categoryId = $(e.target).data('id');
                                    $('#selectprovince').val($(e.target).data('name'));
                                    $(e.target).parent().addClass('hide');
                                    var provinceCmpProxy = cb.rest.DynamicProxy.create({
                                        provinceCmp: { url: 'client/Areas/getAreaByCategoryId', method: 'POST', options: { token: true } }
                                    });
                                    provinceCmpProxy.provinceCmp({ categoryId: categoryId }, function (err, result) {
                                        var catoryData = {};
                                        catoryData.dataArea = result;
                                        var channelUrl = '';
                                        var styleHtmlArea = self.render($$('#districtStyle4').html(), catoryData);
                                        $('.provinceSelect').after(styleHtmlArea);
                                        $$('.citySelect').on('click', function (e) {
                                            if (e.target.nodeName == 'LI') {
                                                $('#selectCity').val($(e.target).data('tag'));
                                                $('#selectCity').attr('data-id', $(e.target).data('id'));
                                                $('#selectCity').attr('data-url', $(e.target).data('url'));
                                                $('#selectCity').attr('data-name', $(e.target).data('name'));
                                                $('#selectCity').attr('data-tag', $(e.target).data('tag'));
                                                $(e.target).parent().addClass('hide');
                                            } else {
                                                if ($(this).children("ul").hasClass('hide')) {
                                                    $(this).children("ul").removeClass('hide');
                                                } else {
                                                    $(this).children("ul").addClass('hide');
                                                    $(this).children("ul").show();
                                                }
                                            }
                                        })
                                    });

                                } else {
                                    if ($(this).children("ul").hasClass('hide')) {
                                        $(this).children("ul").removeClass('hide');
                                    } else {
                                        // $(this).children("ul").addClass('hide');
                                        $(this).children("ul").show();
                                    }
                                }
                            });
                        });
                    }
                }

                $$('.ui-confirmBtn').on('click', function () {
                    var channelUrl = $$('#selectCity').data('url');
                    var channelId = $$('#selectCity').data('id');
                    var areaName = $$('#selectCity').data('name');
                    var areaTag = $$('#selectCity').data('tag');
                    if (!channelId) {
                        myApp.toast('请先选择分类区域', 'tips').show(true);
                        return;
                    }
                    if (channelUrl.indexOf('channel') > -1) {
                        var activeUrl = self.dealChannel(channelUrl);
                    } else {
                        var activeUrl = channelUrl.substring(0, channelUrl.length - 7);
                    }
                    if (cb.util.localStorage.getItem('areaid')) {
                        cb.util.localStorage.removeItem('areaid');
                    }
                    if (cb.util.localStorage.getItem('areaname')) {
                        cb.util.localStorage.removeItem('areaname');
                    }
                    if (cb.util.localStorage.getItem('Areatag')) {
                        cb.util.localStorage.removeItem('Areatag');
                    }
                    cb.util.localStorage.setItem('areaid', channelId);
                    cb.util.localStorage.setItem('areaname', areaName);
                    cb.util.localStorage.setItem('Areatag', areaTag);
                    // 更新底部菜单购物车数量
                    if (cb.rest.AppContext.token) {
                        self.updateCart();
                    } else {
                        $$('.shoppingCartCount').hide();
                    }
                    if (callback)
                        callback(activeUrl);
                });

            });
            this.proxy.getHotArea({}, function (err, result) {
                if (err)
                    return
                var dataObj = {};
                if (result && result.length > 6) {
                    result.splice(6);
                }
                dataObj.data = result;
                var hotcityHtml = self.render($$('#hotcity').html(), dataObj);
                $$('.city-list-1 p').html(hotcityHtml);
                $$('.hotcity').on('click', function () {
                    if ($(this).data('url').indexOf('channel') > -1) {
                        var activeUrl = self.dealChannel($(this).data('url'));
                    } else {
                        var activeUrl = $(this).data('url').substring(0, $(this).data('url').length - 7);
                    }
                    if (cb.util.localStorage.getItem('areaid')) {
                        cb.util.localStorage.removeItem('areaid');
                    }
                    if (cb.util.localStorage.getItem('areaname')) {
                        cb.util.localStorage.removeItem('areaname');
                    }
                    if (cb.util.localStorage.getItem('Areatag')) {
                        cb.util.localStorage.removeItem('Areatag');
                    }
                    cb.util.localStorage.setItem('areaid', $(this).data('id'));
                    cb.util.localStorage.setItem('areaname', $(this).data('name'));
                    cb.util.localStorage.setItem('Areatag', $(this).data('tag'));
                    // 更新底部菜单购物车数量
                    if (cb.rest.AppContext.token) {
                        self.updateCart();
                    } else {
                        $$('.shoppingCartCount').hide();
                    }
                    if (newconfigObj.styleType == '3') {
                        callback(activeUrl);
                    }
                });
            });
        } else {
            this.getAreaData('', callback, isShare);
        }

    };
    /**
     * 获取区域地址列表的方法
     */
    view.prototype.getAreaData = function (keyword, callback, isShare) {
        var activeUrl = '';
        var self = this;
        var newconfig = $$('.popup-districtStyle').data('config');
        var newconfigObj = JSON.parse(newconfig);
        this.proxy.getArea({ word: keyword }, function (err, result) {
            if (err) {
                return;
            } else {
                if (newconfigObj.styleType == '2') {
                    var newAdressArray = [];
                    var newAdressData = {};
                    for (var key in result) {
                        var newadressObj = {};
                        newadressObj.id = key;
                        newadressObj.nameArray = result[key];
                        newAdressArray.push(newadressObj);
                    }
                    newAdressData.data = newAdressArray;
                    var styleHtml1 = self.render($$('#districtStyle2').html(), newAdressData);
                    $$('.picker-box').html(styleHtml1);
                    var currentTitle = newconfigObj.customdefined[1].districttitle;
                    if (currentTitle) {
                        $$('#GPSCityId').html('当前定位' + currentTitle);
                        $$('.hd').html('热门' + currentTitle);
                    } else {
                        $$('#GPSCityId').html('当前定位城市');
                        $$('.hd').html('热门城市');
                    }
                    self.initEnvent();
                    self.getHotcity(newconfigObj, callback);
                    if (isIos) {
                        $$('.navbarPinyin').css({
                            'position': 'fixed'
                        })
                    }
                    $$('.searchArea').once('click', function () {
                        var keyword = $$('.searchInput').val();
                        self.getAreaData(keyword, callback, isShare);
                    });
                } else if (newconfigObj.styleType == '1') {
                    var addressArray = [];
                    var areaTitle = newconfigObj.customdefined[0].areatitle;
                    var cols = parseInt(JSON.parse(newconfig).customdefined[0].displayNum) || 4;
                    var colspan = Math.round(100 / cols);
                    for (var key in result) {
                        for (var i = 0; i < result[key].length; i++) {
                            var addressObj = {};
                            var addressData = {};
                            result[key][i].colspan = colspan;
                            addressArray.push(result[key][i]);
                            addressData.data = addressArray;
                        }
                    };
                    var styleHtml1 = self.render($$('#districtStyle1').html(), addressData);
                    $$('#districtStyle1UL').html(styleHtml1);
                    if (areaTitle) {
                        $('.home-select-title').html('选择' + areaTitle);
                    } else {
                        $('.home-select-title').html('选择城市');
                    }
                }
                if (!isShare && newconfigObj.firststartup !== null) {
                    myApp.popup('.popup-districtStyle');
                }
                var PopHtml = $$('.popup-districtStyle');
                $$(PopHtml).find('li,dd').on('click', function () {
                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');
                    if ($(this).data('url').indexOf('channel') > -1) {
                        activeUrl = self.dealChannel($(this).data('url'));
                        self.style1activeUrl = activeUrl;
                    } else {
                        activeUrl = $(this).data('url').substring(0, $(this).data('url').length - 7);
                        self.style1activeUrl = activeUrl;
                    }
                    if (cb.util.localStorage.getItem('areaid')) {
                        cb.util.localStorage.removeItem('areaid');
                    }
                    if (cb.util.localStorage.getItem('areaname')) {
                        cb.util.localStorage.removeItem('areaname');
                    }
                    if (cb.util.localStorage.getItem('Areatag')) {
                        cb.util.localStorage.removeItem('Areatag');
                    }
                    cb.util.localStorage.setItem('areaid', $(this).data('id'));
                    cb.util.localStorage.setItem('areaname', $(this).data('name'));
                    cb.util.localStorage.setItem('Areatag', $(this).data('tag'));
                    // 更新底部菜单购物车数量
                    if (cb.rest.AppContext.token) {
                        self.updateCart();
                    } else {
                        $$('.shoppingCartCount').hide();
                    }
                    if (newconfigObj.styleType == '2') {
                        if (callback)
                            callback(activeUrl);
                    }
                });
                $$(PopHtml).find('.currentCityButton').on('click', function () {
                    var channelUrl = $$('.currentCityButton').data('url');
                    var areaTag = $$('.currentCityButton').data('tag');
                    var areaName = $$('.currentCityButton').data('name');
                    var areaId = $$('.currentCityButton').data('id');
                    if (channelUrl.indexOf('channel') > -1) {
                        var activeUrl = self.dealChannel(channelUrl);
                    } else {
                        var activeUrl = channelUrl.substring(0, channelUrl.length - 7);
                    }
                    if (cb.util.localStorage.getItem('Areatag')) {
                        cb.util.localStorage.removeItem('Areatag');
                    }
                    if (cb.util.localStorage.getItem('areaname')) {
                        cb.util.localStorage.removeItem('areaname');
                    }
                    if (cb.util.localStorage.getItem('areaid')) {
                        cb.util.localStorage.removeItem('areaid');
                    }
                    cb.util.localStorage.setItem('Areatag', areaTag);
                    cb.util.localStorage.setItem('areaname', areaName);
                    cb.util.localStorage.setItem('areaid', areaId);
                    // 更新底部菜单购物车数量
                    if (cb.rest.AppContext.token) {
                        self.updateCart();
                    } else {
                        $$('.shoppingCartCount').hide();
                    }
                    if (newconfigObj.styleType == '2') {
                        if (callback)
                            callback(activeUrl);
                    }
                });
            }
            $$('.city-select-button,.s-bg2,#icon-back-gray').on('click', function () {
                if (callback)
                    callback(self.style1activeUrl);
            });
        });
    }
    /**
     * 处理频道页的路径问题
     */
    view.prototype.dealChannel = function (channelUrl) {
        if (channelUrl) {
            channelUrl = 'channel/' + channelUrl.substring(0, channelUrl.length - 7);
        } else {
            channelUrl = '';
        }
        return channelUrl
    }
    /**
     * 按照拼音搜索初始事件
     */
    view.prototype.initEnvent = function () {
        var self = this;
        var navbar = $('.navbarPinyin');
        var width = navbar.find("a").width();
        var height = navbar.find("a").height();
        navbar.on('touchstart', function (e) {
            $(this).addClass('active');
            self.createLetterPrompt($(e.target).html());
        });
        navbar.on('touchmove', function (e) {
            e.preventDefault();
            var touch = e.originalEvent.touches[0];
            var pos = { "x": touch.pageX, "y": touch.pageY };
            var x = pos.x, y = pos.y;
            $(this).find("a").each(function (i, item) {
                var offset = $(item).offset();
                var left = offset.left, top = offset.top;
                if (x > left && x < (left + width) && y > top && y < (top + height)) {
                    location.href = item.href;
                    self.changeLetter($(item).html());
                }
            });
        });
        navbar.on("touchend", function (e) {
            $(this).removeClass("active");
            $(".prompt").hide();
        });
        navbar.on('click', function (e) {
            self.createLetterPrompt($(e.target).html());
            var pageContent = $(this).closest('.page-content');
            if (document.getElementById(e.target.dataset.id) !== null) {
                var scrollDom = document.getElementById(e.target.dataset.id);
                // document.getElementById(e.target.dataset.id).scrollIntoView();
                self.scrollContent(pageContent, scrollDom);
            }
        });
        //选中之后触发事件
        $(".pro-picker").on("click", function (e) {
            var target = e.target;
            if ($(target).is("dd")) {
                var pro = $(target).html();
                var letter = $(target).data("letter");
                $$('#currentCity').html(pro);
                if ($$('.popup-districtStyle').hasClass('modal-in'))
                    myApp.closeModal('.popup-districtStyle');
                $$('.popup-overlay').removeClass('modal-overlay-visible');
            }
        });
    };
    /**
     * 创建拼音弹出提示
     */
    view.prototype.createLetterPrompt = function (letter) {
        var span = "<span class='prompt'>" + letter + "</span>";
        $(".picker-box").append(span);
    }
    /**
     * 获取地址列表距离顶部的距离
     */
    view.prototype.scrollContent = function (pageContent, scrollDom) {
        var paddingTop = parseInt(pageContent.css('padding-top'), 10),
            paddingBottom = parseInt(pageContent.css('padding-bottom'), 10),
            pageHeight = pageContent[0].offsetHeight - paddingTop,
            pageScrollHeight = pageContent[0].scrollHeight - paddingTop
        var inputTop = $(scrollDom).offset().top - paddingTop;
        var scrollTop = pageContent.scrollTop() + inputTop;
        $$(pageContent).scrollTop(scrollTop, 300);
        $(".prompt").hide();
    }
    /**
     * 定位当前的位置
     */
    view.prototype.getlocationArea = function (newconfigObj, isDefaut,isShare, callback, viewParams) {
        var self = this;
        if (cb.config && cb.config.fromWechat) {
            wx.getLocation({
                type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
                success: function (res) {
                    var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                    var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                    var realparam = {
                        lng: longitude,
                        lat: latitude
                    };
                    self.proxy.getDefaultArea(realparam, function (err, result) {
                        if (err) {
                            myApp.toast(err.message, 'error').show(true);
                            return;
                        }
                        if (result) {
                            if (newconfigObj.styleType == '2') {
                                $$('.currentCityButton').html(result.tag);
                                $$('.currentCityButton').attr('data-name', result.name);
                            } else if (newconfigObj.styleType == '3') {
                                $$('.ui-locationCity').html(result.tag);
                                $('#selectCity').attr('data-name', result.name);
                                $('.ui-locationCity').attr('data-id', result.id);
                                $('.ui-locationCity').attr('data-name', result.name);
                                $('.ui-locationCity').attr('data-tag', result.tag);
                            }
                            if (cb.util.localStorage.getItem('areaid')) {
                                cb.util.localStorage.removeItem('areaid');
                            }
                            if (cb.util.localStorage.getItem('Areatag')) {
                                cb.util.localStorage.removeItem('Areatag');
                            }
                            if (cb.util.localStorage.getItem('templatePage')) {
                                cb.util.localStorage.removeItem('templatePage');
                            }
                            if (cb.util.localStorage.getItem('superiors')) {
                                cb.util.localStorage.removeItem('superiors');
                            }
                            if (cb.util.localStorage.getItem('categoryId')) {
                                cb.util.localStorage.removeItem('categoryId');
                            }
                            if (cb.util.localStorage.getItem('areaname')) {
                                cb.util.localStorage.removeItem('areaname');
                            }
                            cb.util.localStorage.setItem('areaid', result.id);
                            cb.util.localStorage.setItem('Areatag', result.tag);
                            cb.util.localStorage.setItem('templatePage', result.templatePage);
                            if (result.category && result.category.name) {
                                cb.util.localStorage.setItem('superiors', result.category.name);
                                cb.util.localStorage.setItem('categoryId', result.categoryId);
                                $('#selectprovince').val(result.category.name);
                            } else {
                                cb.util.localStorage.setItem('superiors', '');

                            }
                            $('#selectCity').val(result.tag);
                            $('#selectCity').attr('data-id', result.id);
                            $('#selectCity').attr('data-url', result.templatePage);
                            $('#selectCity').attr('data-tag', result.tag);
                            $('#selectCity').attr('data-name', result.name);
                            // 更新底部菜单购物车数量
                            if (cb.rest.AppContext.token) {
                                self.updateCart();
                            } else {
                                $$('.shoppingCartCount').hide();
                            }
                            $$('.currentCityButton').attr('data-url', result.templatePage);
                            $$('.currentCityButton').attr('data-tag', result.tag);
                            $$('.currentCityButton').attr('data-name', result.name);
                            $$('.currentCityButton').attr('data-id', result.id);
                            $$('.ui-locationCity').attr('data-url', result.templatePage);
                            if(newconfigObj.firststartup == null || isShare){
                                if (result && result.templatePage) {
                                    var activeUrlcurrent = result.templatePage;
                                    if (activeUrlcurrent.indexOf('channel') > -1) {
                                        var activeUrl = self.dealChannel(activeUrlcurrent);
                                    } else {
                                        var activeUrl = activeUrlcurrent.substring(0, activeUrlcurrent.length - 7);
                                    }
                                } else {
                                    var activeUrl = '';
                                }
                                if (cb.util.localStorage.getItem('currentpage')) {
                                    cb.util.localStorage.removeItem('currentpage');
                                }
                                cb.util.localStorage.setItem('currentpage', activeUrl);
                                if(isShare){
                                    if(!isDefaut){
                                        callback(viewParams.url,true);
                                    }else{
                                        if(viewParams.url.indexOf('/detail')>-1){
                                            callback(viewParams.url,true);
                                        }else{
                                            callback(activeUrl,true); 
                                        } 
                                    }
                                }else{
                                    callback(activeUrl);
                                }
                            } 
                        }
                    });
                },
                cancel: function (res) {
                    myApp.toast('请开启微信授权,或者回到首页重新选择区域', 'tips', 2500).show(true);
                },
                fail: function (res) {
                    myApp.toast('请开启微信授权,或者回到首页重新选择区域', 'tips', 2500).show(true);
                }
            });
        } else if (window.plus) { //移动App
            plus.geolocation.getCurrentPosition(function (res) {
                var latitude = res.coords.latitude; // 纬度，浮点数，范围为90 ~ -90
                var longitude = res.coords.longitude; // 经度，浮点数，范围为180 ~ -180。
                var realparam = {
                    lng: longitude,
                    lat: latitude
                };
                self.proxy.getDefaultArea(realparam, function (err, result) {
                    if (err) {
                        myApp.toast(err.message, 'error').show(true);
                        return;
                    }
                    if (result) {
                        if (newconfigObj.styleType == '2') {
                            $$('.currentCityButton').html(result.tag);
                        } else if (newconfigObj.styleType == '3') {
                            $$('.ui-locationCity').html(result.tag);
                        }
                        if (cb.util.localStorage.getItem('areaid')) {
                            cb.util.localStorage.removeItem('areaid');
                        }
                        if (cb.util.localStorage.getItem('Areatag')) {
                            cb.util.localStorage.removeItem('Areatag');
                        }
                        if (cb.util.localStorage.getItem('templatePage')) {
                            cb.util.localStorage.removeItem('templatePage');
                        }
                        if (cb.util.localStorage.getItem('superiors')) {
                            cb.util.localStorage.removeItem('superiors');
                        }
                        if (cb.util.localStorage.getItem('categoryId')) {
                            cb.util.localStorage.removeItem('categoryId');
                        }
                        if (cb.util.localStorage.getItem('areaname')) {
                            cb.util.localStorage.removeItem('areaname');
                        }
                        cb.util.localStorage.setItem('areaid', result.id);
                        cb.util.localStorage.setItem('Areatag', result.tag);
                        cb.util.localStorage.setItem('templatePage', result.templatePage);
                        cb.util.localStorage.setItem('areaname', result.name);
                        if (result.category && result.category.name) {
                            cb.util.localStorage.setItem('superiors', result.category.name);
                            cb.util.localStorage.setItem('categoryId', result.categoryId);
                            $('#selectprovince').val(result.category.name);
                        } else {
                            cb.util.localStorage.setItem('superiors', '');

                        }
                        $('#selectCity').val(result.tag);
                        $('#selectCity').attr('data-id', result.id);
                        $('#selectCity').attr('data-url', result.templatePage);
                        $('#selectCity').attr('data-tag', result.tag);
                        $('#selectCity').attr('data-name', result.name);
                        // 更新底部菜单购物车数量
                        if (cb.rest.AppContext.token) {
                            self.updateCart();
                        } else {
                            $$('.shoppingCartCount').hide();
                        }
                        $('.currentCityButton').attr('data-url', result.templatePage);
                        $('.currentCityButton').attr('data-tag', result.tag);
                        $('.currentCityButton').attr('data-name', result.name);
                        $('.currentCityButton').attr('data-id', result.id);
                        $('.ui-locationCity').attr('data-url', result.templatePage);
                        $('.ui-locationCity').attr('data-tag', result.tag);
                        $('.ui-locationCity').attr('data-id', result.id);
                        $('.ui-locationCity').attr('data-name', result.name);
                        if (newconfigObj.firststartup == null || isShare) {
                            if (result && result.templatePage) {
                                var activeUrlcurrent = result.templatePage;
                                if (activeUrlcurrent.indexOf('channel') > -1) {
                                    var activeUrl = self.dealChannel(activeUrlcurrent);
                                } else {
                                    var activeUrl = activeUrlcurrent.substring(0, activeUrlcurrent.length - 7);
                                }
                            } else {
                                var activeUrl = '';
                            }
                            if (cb.util.localStorage.getItem('currentpage')) {
                                cb.util.localStorage.removeItem('currentpage');
                            }
                            cb.util.localStorage.setItem('currentpage', activeUrl);
                            callback(activeUrl);
                        }
                    }
                });
            }, function (e) {
                alert("Geolocation error: " + e.message);
            });
        } else {
            callback('');
        }
    }
    /**
     * 获取热门城市
     */
    view.prototype.getHotcity = function (newconfigObj, callback) {
        var self = this;
        var dataObj = {};
        this.proxy.getHotArea({}, function (err, result) {
            if (err)
                return
            dataObj.data = result;
            var hotcityHtml = self.render($$('#hotcity').html(), dataObj);
            $$('.home-place-list ul').html(hotcityHtml);
            $$('.hotcity').on('click', function () {
                if ($(this).data('url').indexOf('channel') > -1) {
                    var activeUrl = self.dealChannel($(this).data('url'));
                } else {
                    var activeUrl = $(this).data('url').substring(0, $(this).data('url').length - 7);
                }
                if (cb.util.localStorage.getItem('areaid')) {
                    cb.util.localStorage.removeItem('areaid');
                }
                if (cb.util.localStorage.getItem('areaname')) {
                    cb.util.localStorage.removeItem('areaname');
                }
                if (cb.util.localStorage.getItem('Areatag')) {
                    cb.util.localStorage.removeItem('Areatag');
                }
                cb.util.localStorage.setItem('areaid', $(this).data('id'));
                cb.util.localStorage.setItem('areaname', $(this).data('name'));
                cb.util.localStorage.setItem('Areatag', $(this).data('tag'));
                // 更新底部菜单购物车数量
                if (cb.rest.AppContext.token) {
                    self.updateCart();
                } else {
                    $$('.shoppingCartCount').hide();
                }
                if (newconfigObj.styleType == '2') {
                    callback(activeUrl);
                }
            });
        });
    };
    // 更新购物车数量
    view.prototype.updateCart = function () {
        // 加载购物车列表 获得购物车数量
        var proxy = cb.rest.DynamicProxy.create({
            getCartLists: {
                url: 'client/ShoppingCarts/getCartList',
                method: 'GET',
                options: {
                    token: true,
                    autoLogin: false
                }
            }
        });
        proxy.getCartLists(function (err, result) {
            if (err) {
                $$('.shoppingCartCount').hide();
                return;
            }
            // 去掉扫码购的商品
            result.lsCart = result.lsCart.filter(function (item) {
                return item.onLineOffLine != 1;
            });
            // 底部导航栏目购物车的数量图标
            if (result.lsCart.length > 0) {
                $$('.shoppingCartCount').text(result.lsCart.length);
                $$('.shoppingCartCount').show().removeClass('hide');
            } else {
                $$('.shoppingCartCount').hide();
            }

        });
    };
    return view;
});
