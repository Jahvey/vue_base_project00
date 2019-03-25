designer.settings.register('platform_search', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    var fontcolor = '';
    var bgcolorObj = {};
    var bgcolor1 = '';
    var newConfig = null;
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        if(instance){
            newConfig = instance.getConfig();
            callback(newConfig);
        }
        // 信息初始化

    };
    widget.prototype.afterInit = function () {
        var self = this;
        var templatePage = new cb.util.queryString().get('templatePage');
        if(!newConfig[templatePage]){
            $('#searchContent').val('输入商品名称/关键字');
        }else{
            $('#searchContent').val(newConfig[templatePage][0].allContent);
        }
        
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
                    bgcolorObj.bgcolor = color.toHexString();
                    bgcolorObj._r = Math.round(color._r);
                    bgcolorObj._g = Math.round(color._g);
                    bgcolorObj._b = Math.round(color._b);
                }
            }
        });
        if (newConfig[templatePage] && newConfig[templatePage][0].bgcolorObj.bgcolor) {
            $("#bgcolor").spectrum("set", newConfig[templatePage][0].bgcolorObj.bgcolor);
        } else {
            $("#bgcolor").spectrum("set", '#EF524D');
        }

        $('#searchSubmit').on('click', function () {
            self.collectData();
        });
    }
    widget.prototype.collectData = function () {
        var templatePage = new cb.util.queryString().get('templatePage');
        var contentCount = $('#searchContent').val();
        var config = [
            {
                "$": {
                    "key": templatePage
                },
                "item": [
                    { "$": { "allContent": contentCount,"bgcolorObj":bgcolorObj} }
                ]
            }
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
    return widget;
});