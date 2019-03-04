cb.widgets.register('bulletin', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    var newConfig = null;
    var the_timeout;
    widget.prototype.getProxy = function () {
        return { url: 'client/Notices/getIndexNotices', method: 'GET' };
    };
    widget.prototype.getProxyData = function () {
        newConfig = this.getConfig();
        return { pagesize: parseInt(newConfig.allContent) };
    };
    /**
     * 运行模板
     */
    widget.prototype.runTemplate = function (error, result) {
        newConfig = this.getConfig();
        var newObj = {};
        if (newConfig.isscroll) {
            if (parseInt(newConfig.allContent) < result.notices.length) {
                newObj.notices = result.notices.slice(0, parseInt(newConfig.allContent));
            } else {
                newObj.notices = result.notices;
            }
        } else {
            if (parseInt(newConfig.pageindexcount) < result.notices.length) {
                newObj.notices = result.notices.slice(0, parseInt(newConfig.pageindexcount));
            } else {
                newObj.notices = result.notices;
            }
        }
        for (var i = 0; i < newObj.notices.length; i++) {
            if (newObj.notices[i].dCreated) {
                var formatDateArray=newObj.notices[i].dCreated.split(" ");
                if (formatDateArray && formatDateArray.length) {
                    newObj.notices[i].dCreated = formatDateArray[0];
                }
            }  
        }
        var html = this.render(newObj);
        this.getElement().find('ul').html(html);
        // 从新设置id
       
        var bulletinIdCode = this.getElement().find('.announce-1').parent("div").attr("id");
        var lastCode = "";
        if (bulletinIdCode) {
            lastCode = bulletinIdCode.substr(bulletinIdCode.length - 1, 1);
        }
        var bulletinId = this.getElement().find('.announce-1').parent("div").attr("data-name") + lastCode;
        var bulletinId1 = "a1" + bulletinId;
        var bulletinId2 = "a2" + bulletinId;
        this.getElement().find('.announce-1').find("div").attr("id", bulletinId1);
        this.getElement().find('.announce-1').find("ul").attr("id", bulletinId2);
        // 设置字体颜色和大小
        this.getElement().find('ul li a,em').css({
            "color": newConfig.fontcolor,
            "font-size": newConfig.fontsize + 'px'
        });
        // 设置背景颜色
        this.getElement().find('ul').css({
            "background": newConfig.bgcolor
        });
        // 设置区域高度
        var announceHieght = 256;
        var liHeight = $("#" + bulletinId1).parent(".announce-1").find('li:first').height();
        if (isNaN(liHeight)) {
            liHeight = 32;
        }
        if (newConfig.pageindexcount) {
            if (result.notices > parseInt(newConfig.pageindexcount)) {
                announceHieght = liHeight * parseInt(newConfig.pageindexcount) + 32;
            } else {
                announceHieght = liHeight * result.notices.length + 32;
            }
        } else {
            announceHieght = liHeight * result.notices.length + 32;
        }
        if (newConfig.showTitle) {
            this.getElement().find("#" + bulletinId1).parent(".announce-1").find(".announce-title").show();
            if (!newConfig.titleContent) {
                newConfig.titleContent = "公告";
            }
            this.getElement().find("#" + bulletinId1).parent(".announce-1").find(".announce-title i").text(newConfig.titleContent);
        } else {
            this.getElement().find("#" + bulletinId1).parent(".announce-1").find(".announce-title").hide();
            announceHieght - 32;
        }
        this.getElement().find("#" + bulletinId1).parent(".announce-1").css({
            "height": announceHieght + "px" 
        });
        // 滚动
        if (newConfig.isscroll) {
            this.initScroll(bulletinId1, bulletinId2, announceHieght, 1000);
        } else {
            $("#" + bulletinId1).css({
                "width": "100%",
                "height": announceHieght + "px",
                "overflow": "hidden",
                "noWrap": true
            });
            clearInterval(the_timeout);
        }
        this.getElement().find("#" + bulletinId1).find("a").removeClass("active-state");
        var rowContainer = $("div.row");
        //hasChildNodes
        rowContainer.each(function () {
            if ($(this).find("div.col-100") && $(this).find("div.col-100").length) {
                if (!$(this).find("div.col-100").children().length) {
                    $(this).css("margin-top", "0px");
                    $(this).css("height", "0px");
                    $(this).css("min-height", "0px");
                }
            }
        })
        // 点击列表
        $$('.noticeItemBtn').on('click', function () {
            if (location.href.indexOf("templatedesigner") > -1) {
                return;
            } else {
                var type = $$(this).attr("data-type");
                if (type == "url") {
                    var url = $$(this).attr("data-url");
                    if (url) {
                        location.href = url;
                    }
                } else {
                    var id = $$(this).attr("data-id");
                    myApp.mainView.router.loadPage({
                        url: 'notice',
                        query: {
                            id: id,
                            showTitle: newConfig.showTitle,
                            titleContent: newConfig.titleContent
                        }
                    });
                }

            }
        });
        //160*60
    };
    
    //_H为滚动内容的高度,_T为滚动后每次停留言时间
    widget.prototype.initScroll = function (A1,A2,_H, _T) {
        var marqueesHeightS1 = _H;
        var stopscrollS1 = false;
        var scrollElemS1 = document.getElementById(A1);
        this.getElement().find("#" + A1).css({
            "width": "100%",
            "height": marqueesHeightS1 + "px",
            "overflow": "hidden",
            "noWrap": true
        });
        scrollElemS1.onmouseover = new Function('stopscrollS1=true');
        scrollElemS1.onmouseout = new Function('stopscrollS1=false');
        var preTopS1 = 0;
        var currentTopS1 = 0;
        var stoptimeS1 = 0;
        var leftElemS2 = document.getElementById(A2);
        scrollElemS1.appendChild(leftElemS2.cloneNode(true));
        setTimeout(init_srolltextS1, _T);
        function init_srolltextS1() {
            scrollElemS1.scrollTop = 0;
            the_timeout = setInterval(scrollUpS1, 100);
        }
        function scrollUpS1() {
            if (stopscrollS1) {
                return;
            }
            currentTopS1 += 1;
            if (currentTopS1 == (marqueesHeightS1 + 1)) {
                stoptimeS1 += 1;
                currentTopS1 -= 1;
                if (stoptimeS1 == _T / 50) {
                    currentTopS1 = 0;
                    stoptimeS1 = 0;
                }
            } else {
                preTopS1 = scrollElemS1.scrollTop;
                scrollElemS1.scrollTop += 1;
                if (preTopS1 == scrollElemS1.scrollTop) {
                    scrollElemS1.scrollTop = 0;
                    scrollElemS1.scrollTop += 1;
                }
            }
        };
    };
    return widget;
});