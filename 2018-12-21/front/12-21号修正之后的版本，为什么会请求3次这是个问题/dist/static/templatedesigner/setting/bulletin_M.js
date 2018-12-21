designer.settings.register('bulletin', function (widgetType) {
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
        // 信息初始化
        if (newConfig.allContent && newConfig.pageindexcount) {
            $('#contentCount').val(newConfig.allContent);
            $('#pageIndexCount').val(newConfig.pageindexcount);
            $('#fontSize').val(newConfig.fontsize);
            if (newConfig.isscroll) {
                $('.scroll-checkbox').find('.icheckbox_square-green').addClass('checked');
            } else {
                $('.scroll-checkbox').find('.icheckbox_square-green').removeClass('checked');
            }
            if (newConfig.showTitle) {
                $('.title-checkbox').find('.icheckbox_square-green').addClass('checked');
                if (newConfig.titleContent) {
                    $('#titleContent').val(newConfig.titleContent)
                }
            } else {
                $('.title-checkbox').find('.icheckbox_square-green').removeClass('checked');
            }
            fontcolor = newConfig.fontcolor;
            bgcolor = newConfig.bgcolor;
            $("#fontcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color", newConfig.fontcolor);
            $("#bgcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color", newConfig.bgcolor);
        }
        
    };
    widget.prototype.afterInit = function () {
        var self = this;
        $('.announcement-3 input').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
            increaseArea: '20%' // optional
        });
        $('#fontcolor').spectrum({
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
                if($(this).attr('id')=='fontcolor'){
                    fontcolor = color.toHexString();
                }
            }
        });
        $("#fontcolor").spectrum("set", newConfig.fontcolor);
        $('#bgcolor').spectrum({
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
                if ($(this).attr('id') == 'bgcolor') {
                    bgcolor = color.toHexString();
                }
            }
        });
        $("#bgcolor").spectrum("set", newConfig.bgcolor);
        $('#bulletinSubmit').on('click', function () {
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
        if ($('.scroll-checkbox').find('.icheckbox_square-green').hasClass('checked')) {
            var isscroll = true;
        } else {
            var isscroll = false;
        }
        var showTitle = true;
        if ($('.title-checkbox').find('.icheckbox_square-green').hasClass('checked')) {
            showTitle = true;
        } else {
            showTitle = false;
        }
        var titleContent = $('#titleContent').val();
        var contentCount = $('#contentCount').val();
        var pageIndexCount = $('#pageIndexCount').val();
        var fontSize = $('#fontSize').val();
        if (!fontcolor) {
            fontcolor = $("#fontcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color");
            fontcolor = this.rgbToHex(fontcolor).hex;
        }
        if (!bgcolor) {
            bgcolor = $("#bgcolor").parents(".announcement-inner").find(".sp-preview-inner").css("background-color");
            bgcolor = this.rgbToHex(bgcolor).hex;
        }
        var config = [
            { "$": { "key": "allContent", "value": contentCount } },
            { "$": { "key": "pageindexcount", "value": pageIndexCount } },
            { "$": { "key": "isscroll", "value": isscroll } },
            { "$": { "key": "fontsize", "value": fontSize } },
            { "$": { "key": "fontcolor", "value": fontcolor } },
            { "$": { "key": "bgcolor", "value": bgcolor } },
            { "$": { "key": "showTitle", "value": showTitle } }
        ];
        if (showTitle) {
            config.push({ "$": { "key": "titleContent", "value": titleContent } })
        }
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
    return widget;
});