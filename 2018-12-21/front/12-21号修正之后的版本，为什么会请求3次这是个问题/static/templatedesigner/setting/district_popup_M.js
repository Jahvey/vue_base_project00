designer.settings.register('district_popup', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    var districtPic = '';
    var districtName = '';
    widget.prototype.init = function (callback) {
        var self = this;
        callback();
    };
    widget.prototype.afterInit = function () {
        var self = this;
        var configs = designer.settings.configs['district'];
        var proxy = cb.rest.DynamicProxy.create({
            getMyAreaSetting: { url: 'client/Areas/getMyAreaSetting', method: 'GET' }
        });
        proxy.getMyAreaSetting(function (err, result) {
            if (err) {
                return
            } else {
                districtName = result;
                if (configs) {
                    var newConfig = self.transfer(configs.config);
                    self.initpageCongfig(newConfig,result);
                }
            }
        })

        var objStyle1 = {};
        $$('.closed').on('click', function () {
            $$('.page').removeClass('modal-overlay-visible').addClass('modal-overlay-closed');
            $$('.widgetconfig').css('position', '');
        });

        $('#uploadBackground').diyUpload({
            fileNumLimit: 5,
            cancelButtonText: "取消",
            url: '/client/FileUpload/upload',
            success: function (data) {
                $$('.ui-header').css('background', 'url(' + data.data.imgurl + ') no-repeat center');
                $('.parentFileBox').remove();
                districtPic = data.data.imgurl;
            },
            error: function (err) {
                console.info(err);
            }
        });
        $$('.confirm').on('click', function () {
            self.collectData();
        });
        $('#styleInput1').on('mousedown', function () {
            var checkedStyle = $('input[name="areaRadio"]:checked').val();
            if (checkedStyle !== '1') {
                alert('请先选择相对应的样式');
            }
        });
        $('#fn-provinceCmp,#fn-cityCmp').on('mousedown', function () {
            var checkedStyle = $('input[name="areaRadio"]:checked').val();
            if (checkedStyle !== '3') {
                alert('请先选择相对应的样式');
            }
        });

    };
    widget.prototype.runTemplate = function (config) {
        designer.settings.configs['district'] = {
            $: { name: "district", type: "district" },
            config: config
        };
        var newConfig = this.transfer(config);
    };
    /**
     * 初始化界面数据
     */
    widget.prototype.initpageCongfig = function (AreaConfig,result) {
        if (AreaConfig.enbaleFunction == null) {
            $$('.switchArea').removeAttr('checked');
        } else {
            $$('.switchArea').attr('checked', AreaConfig.enbaleFunction);
        }
        if (AreaConfig.firststartup == null) {
            $$('.firstStart').removeAttr('checked');
        } else {
            $$('.firstStart').attr('checked', AreaConfig.firststartup);
        }
        var radioArray = $$('input[name="areaRadio"]');
        for (var i = 0; i < radioArray.length; i++) {
            if ($(radioArray[i]).val() == AreaConfig.styleType) {
                radioArray[i].checked = true;
            }
        }
        if (AreaConfig.styleType == '1') {
            $$('#shownumber').val(AreaConfig.customdefined[0].displayNum);
        } else if (AreaConfig.styleType == '3') {
            $$('.ui-header').css('background', 'url(' + AreaConfig.customdefined[2].imgurl + ') no-repeat center');
            $$('#fn-provinceCmp').val(AreaConfig.customdefined[2].provinceCmp);
            $$('#fn-cityCmp').val(AreaConfig.customdefined[2].cityCmp);
        }
        $$('.areaInput').html('选择'+result);
        $$('.position-city p').html('当前定位'+result);
        $$('.hd').html('热门'+result);
        $$('#currentCitydesigner').html('热门'+result);
        $$('#currentCityTip').html('请选择'+result+'并进入下单购买');
    }
    widget.prototype.preprocess = function ($node, config) {
        //$node.children('div').children('div').html(this.render($node.find('#pageDataTpl1'), {configs: config}));
    };
    /**
     * 收集页面数据,包括三种样式下不同的参数信息
     */
    widget.prototype.collectData = function () {
        var self = this;
        var config = [
            { "$": { "key": "styleType", "value": "" } },
            { "$": { "key": "enbaleFunction", "value": true } },
            { "$": { "key": "firststartup", "value": true } },
            {
                "$": { "key": "customdefined" }, "item": [
                    {
                        "$": { "areatitle": "", "displayNum": "" }
                    },
                    {
                        "$": { "districttitle": "" }
                    },
                    {
                        "$": { "imgurl": "", "provinceCmp": "", "cityCmp": "","districttip":""}
                    }
                ]
            }
        ];
        config[0].$.value = $('input[name="areaRadio"]:checked').val();
        config[1].$.value = $('.switchArea').is(':checked');
        config[2].$.value = $('.firstStart').is(':checked');
        config[3].item[0].$['areatitle'] = districtName;
        config[3].item[0].$['displayNum'] = $('#shownumber').val();
        config[3].item[1].$['districttitle'] = districtName;
        config[3].item[2].$['imgurl'] = districtPic;
        config[3].item[2].$['provinceCmp'] = $('#fn-provinceCmp').val();
        config[3].item[2].$['cityCmp'] = $('#fn-cityCmp').val();
        config[3].item[2].$['districttip'] = districtName;
        this.runTemplate(config);
        $$('.page').removeClass('modal-overlay-visible').addClass('modal-overlay-closed');
        $$('.widgetconfig').css('position', '');
    }
    return widget;
});