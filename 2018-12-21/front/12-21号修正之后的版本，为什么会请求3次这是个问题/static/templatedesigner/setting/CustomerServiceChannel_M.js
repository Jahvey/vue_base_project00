designer.settings.register('CustomerServiceChannel', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    var fontcolor = '';
    var bgcolor = '';
    var newConfig = null;
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        newConfig = instance.getConfig();
        callback(newConfig);
        // 获取友联客服配置信息显示和隐藏友联客服
        self.getICCInfoFunc();
        // 信息初始化
        $('.customerServiceInput').val(newConfig.customerServiceName);
        $('.customerServiceICCInput').val(newConfig.customerServiceICCName);
        if (newConfig.servicePhone) {
            $("input[type='checkbox'][name='servicePhone']").attr("checked", true);
        } else {
            $("input[type='checkbox'][name='servicePhone']").removeAttr("checked");
        }
        if (newConfig.serviceICC) {
            $("input[type='checkbox'][name='serviceICC']").attr("checked", true);
        } else {
            $("input[type='checkbox'][name='serviceICC']").removeAttr("checked");
        }
        $('#customerServicefontSize').val(newConfig.customerServicefontsize);
        $("input[name=positionButton][value=" + newConfig.floatPosition + "]").attr("checked", true);
        $("#customerServicefontcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color", newConfig.customerServicefontcolor);
        $("#customerServicebgcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color", newConfig.customerServicebgcolor);
        
    };
    widget.prototype.afterInit = function () {
        var self = this;
        $('#customerServicefontcolor').spectrum({
            showPalette: true,
            preferredFormat: "hex",
            chooseText: "选择",
            cancelText: "取消",
            palette: [
                 ["#000", "#444", "#666", "#999", "#ccc", "#eee", "#f3f3f3", "#fff"],
                 ["#f00", "#f90", "#ff0", "#0f0", "#0ff", "#00f", "#90f", "#f0f"],
                 ["#f4cccc", "#fce5cd", "#fff2cc", "#d9ead3", "#d0e0e3", "#cfe2f3", "#d9d2e9", "#ead1dc"],
                 ["#ea9999", "#f9cb9c", "#ffe599", "#b6d7a8", "#a2c4c9", "#9fc5e8", "#b4a7d6", "#d5a6bd"],
                 ["#e06666", "#f6b26b", "#ffd966", "#93c47d", "#76a5af", "#6fa8dc", "#8e7cc3", "#c27ba0"],
                 ["#c00", "#e69138", "#f1c232", "#6aa84f", "#45818e", "#3d85c6", "#674ea7", "#a64d79"],
                 ["#900", "#b45f06", "#bf9000", "#38761d", "#134f5c", "#0b5394", "#351c75", "#741b47"],
                 ["#600", "#783f04", "#7f6000", "#274e13", "#0c343d", "#073763", "#20124d", "#4c1130"]
            ],
            change: function (color) {
                // callback && callback(color.toHexString());
                if($(this).attr('id')=='customerServicefontcolor'){
                    fontcolor = color.toHexString();
                }
            }
        });
        $("#customerServicefontcolor").spectrum("set",newConfig.customerServicefontcolor);
        $('#customerServicebgcolor').spectrum({
            showPalette: true,
            preferredFormat: "hex",
            chooseText: "选择",
            cancelText: "取消",
            palette: [
                 ["#000", "#444", "#666", "#999", "#ccc", "#eee", "#f3f3f3", "#fff"],
                 ["#f00", "#f90", "#ff0", "#0f0", "#0ff", "#00f", "#90f", "#f0f"],
                 ["#f4cccc", "#fce5cd", "#fff2cc", "#d9ead3", "#d0e0e3", "#cfe2f3", "#d9d2e9", "#ead1dc"],
                 ["#ea9999", "#f9cb9c", "#ffe599", "#b6d7a8", "#a2c4c9", "#9fc5e8", "#b4a7d6", "#d5a6bd"],
                 ["#e06666", "#f6b26b", "#ffd966", "#93c47d", "#76a5af", "#6fa8dc", "#8e7cc3", "#c27ba0"],
                 ["#c00", "#e69138", "#f1c232", "#6aa84f", "#45818e", "#3d85c6", "#674ea7", "#a64d79"],
                 ["#900", "#b45f06", "#bf9000", "#38761d", "#134f5c", "#0b5394", "#351c75", "#741b47"],
                 ["#600", "#783f04", "#7f6000", "#274e13", "#0c343d", "#073763", "#20124d", "#4c1130"]
            ],
            change: function (color) {
                if ($(this).attr('id') == 'customerServicebgcolor') {
                    bgcolor = color.toHexString();
                }
            }
        });
        $("#customerServicebgcolor").spectrum("set", newConfig.customerServicebgcolor);
        $('#customerServiceSubmit').on('click', function () {
            self.collectData();
        });
        $('.title-checkbox').find('.icheckbox_square-green input').on('click', function (e) {
            if ($(this).hasClass('checked')) {
                $('.announcement-title').parent('.announcement-inner').show();
            } else {
                $('.announcement-title').parent('.announcement-inner').hide();
            }
        })
    }
    widget.prototype.collectData = function () {
        var titleContent = $('.customerServiceInput').val();
        var titleICCContent = $('.customerServiceICCInput').val();
        var fontSize = $('#customerServicefontSize').val();
        var floatPosition = $('input[name="positionButton"]:checked').val();
        if (!fontcolor) {
            fontcolor = $("#customerServicefontcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color");
            fontcolor = this.rgbToHex(fontcolor).hex;
        }
        if (!bgcolor) {
            bgcolor = $("#customerServicebgcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color");
            bgcolor = this.rgbToHex(bgcolor).hex;
        }
        var config = [
            { "$": { "key": "customerServiceName", "value": titleContent } },
            { "$": { "key": "customerServiceICCName", "value": titleICCContent } },
            { "$": { "key": "floatPosition", "value": floatPosition } },
            { "$": { "key": "customerServicefontsize", "value": fontSize } },
            { "$": { "key": "customerServicefontcolor", "value": fontcolor } },
            { "$": { "key": "customerServicebgcolor", "value": bgcolor } },
            { "$": { "key": "servicePhone", "value": $("input[type='checkbox'][name='servicePhone']").is(':checked') } },
            { "$": { "key": "serviceICC", "value": $("input[type='checkbox'][name='serviceICC']").is(':checked') } },
        ];
        this.runTemplate(config);
    };
    // 颜色rgb转为16进制
    widget.prototype.rgbToHex = function (rgb) {
        var rRgba = /rgba?\((\d{1,3}),(\d{1,3}),(\d{1,3})(,([.\d]+))?\)/,
        r, g, b, a,
        rsa = rgb.replace(/\s+/g, "").match(rRgba);
        if (rsa) {
            r = (+rsa[1]).toString(16);
            r = r.length == 1 ? "0" + r : r;
            g = (+rsa[2]).toString(16);
            g = g.length == 1 ? "0" + g : g;
            b = (+rsa[3]).toString(16);
            b = b.length == 1 ? "0" + b : b;
            a = (+(rsa[5] ? rsa[5] : 1)) * 100
            return { hex: "#" + r + g + b, alpha: Math.ceil(a) };
        } else {
            return { hex: rgb, alpha: 100 };
        }
    };
    // 获取客服配置信息
    widget.prototype.getICCInfoFunc = function () {
        var proxy = cb.rest.DynamicProxy.create({ getContactWayUseInfo: { url: 'client/Corprations/getContactWayUseInfo', method: 'GET' } });
        proxy.getContactWayUseInfo(function (serviceErr, serviceResult) {
            if (serviceErr) {
                myApp.toast("获取客服配置信息失败" + err.message, "提示").show(true)
                return;
            };
            if (serviceResult.contacyType === "3" && serviceResult.youlianUrl) {
                // 友联客服启用
                $$(".customerServiceICCInput").parents(".announcement-inner").removeClass("hide");
                $("input[type='checkbox'][name='serviceICC']").parent("span").removeClass("hide");
            } else {
                $$(".customerServiceICCInput").parents(".announcement-inner").addClass("hide");
                $("input[type='checkbox'][name='serviceICC']").parent("span").addClass("hide");
            }
        });
    };
    return widget;
});