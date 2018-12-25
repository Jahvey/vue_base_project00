designer.settings.register('main_slide', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    var NewConfig;
    var widgetname;
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    widget.prototype.picInfo = null;
    widget.prototype.getPictureData = [];
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        widgetname = instance.getId().substr(0,instance.getId().indexOf('*'));
        NewConfig = instance.getConfig();
        callback(NewConfig);
        $('.widgetconfig')[0].style.overflowY = 'auto';
    };
    widget.prototype.afterInit = function () {
        var self = this;
        for (var i = 0; i < NewConfig.data.length; i++) {
            var uploader = $('#' + NewConfig.data[i].id).diyUpload({
                url: cb.rest._getUrl('remote/FileUpload/upload'),
                oneThumb: true,
                cancelButtonText: "取消",
                buttonText: "添加图片",
                success: function (data) {
                    self.picInfo = { "imgname": data.data.imgname, "imgurl": data.data.imgurl }; //{ "cFileName": data.data.cImgName, "cOriginalName": data.data.cOriginalName, "cFolder": data.data.cFolder };
                    self.getPictureData.push(self.picInfo);
                    for (j = 0; j < NewConfig.data.length; j++) {
                        if ($(this)[0].id == NewConfig.data[j].id) {
                            NewConfig.data[j].cAdImageUrl = self.picInfo.imgurl; //cFolder + "lm_" + self.picInfo.cFileName;		
                        }
                    }
                },
                error: function (err) {
                    alert("添加图片失败！" + err);
                    console.info(err);
                }
            });
            uploader.reset();
            NewConfig.data[i].isNotFile = true;
            NewConfig.data[i].url = NewConfig.data[i].cAdImageUrl;
            uploader.createBox($('#' + NewConfig.data[i].id), NewConfig.data[i]);
            //          $$('#fileBox_'+NewConfig.data[i].id)[0].style.width = '100%';
            //          $$('.viewThumb')[i].style.width = '100%';
        };
        $('.delete_slide').on('click', function (e) {
            self.delInitPhoto(e, NewConfig);
        });
        $('#addNewSlide').on('click', function () {
            var _this = this;
            self.addNewPhoto(NewConfig, _this);
        });
        $('#saveconfig').on('click', function () {
            self.collectData();
        });
        $(".iOrder").change(function () {
            if ($(".iOrder").val() > 6 || $(".iOrder").val() < 0) {
                alert('请输入1到6以内的数字!');
                $$(".iOrder")[0].value = "";
            }
        });
    };
    /****删除图片的方法*****/
    widget.prototype.delInitPhoto = function (e, delData) {
        var targetObj = $(e.currentTarget).closest('.content-block').find('.webuploader-container').attr('id');
        if (delData.data.length > 0) {
            for (var i = 0; i < delData.data.length; i++) {
                if (delData.data[i].id == targetObj) {
                    delData.data.removeAt(i);
                }
            }
        }
        $(e.currentTarget).closest('.upload_slide').remove();

    };
    /*添加新的图片*/
    widget.prototype.addNewPhoto = function (config, _this) {
        var self = this;
        if ($('.upload_slide').length > 5) {
            alert('最多只能添加6张广告图片');
        } else {
            var addContent = "";
            var slideId = {};
            slideId.id = new Date().valueOf();
            addContent += '<div class="upload_slide"><div class="content-block"><div class="row"><div class="edit_button">';
            addContent += '<ul><li class="delete_slide"><a>删除</a></li></ul></div>';
            addContent += '<div id="' + slideId.id + '" style="margin-right: 190px;"></div>';
            addContent += '<div class="content-block list-block" style="width: 100%;"><div class="item-content">';
            addContent += '<div class="item-inner"><div class="item-title label">显示顺序</div><div class="item-input">';
            addContent += '<input value="" type="number" class="iOrder" ></div></div></div></div>';
            addContent += '<div class="content-block list-block" style="width: 100%;"><div class="item-content">';
            addContent += '<div class="item-inner"><div class="item-title label">跳转地址</div><div class="item-input">';
            addContent += '<input value="" type="text" class="cRedirectUrl" placeholder="点击图片时会跳转到相应地址">';
            addContent += '</div></div></div></div>';
            addContent += '<div class="content-block list-block" style="width: 100%;"><div class="item-content">';
            addContent += '<div class="item-inner"><div class="item-title label">跳转Id</div><div class="item-input">';
            addContent += '<input value="" type="text" class="cRedirecId" placeholder="点击图片时会跳转到Id">';
            addContent += '</div></div></div></div></div></div></div>';

            $(_this).closest('.content-block').prev().after(addContent);

            var uploader = $('#' + slideId.id).data('index', slideId.id).diyUpload({
                url: cb.rest._getUrl('remote/FileUpload/upload'),
                oneThumb: true,
                cancelButtonText: "取消",
                buttonText: "添加图片",
                success: function (data) {
                    var index = this.data('index');
                    self.picInfo = { "imgname": data.data.imgname, "imgurl": data.data.imgurl }; //{"cFileName": data.data.cImgName, "cOriginalName": data.data.cOriginalName, "cFolder": data.data.cFolder };
                    self.getPictureData.push(self.picInfo);
                    for (i = 0; i < NewConfig.data.length; i++) {
                        if (index == NewConfig.data[i].id) {
                            NewConfig.data.removeAt(i);
                        }
                    }
                    NewConfig.data.push({
                        "id": index,
                        "cAdImageUrl": self.picInfo.imgurl//cFolder + "lm_" + self.picInfo.cFileName
                    });
                },
                error: function (err) {
                    alert("添加广告图片失败！" + err);
                    console.info(err);
                }
            });
            uploader.reset();
            slideId.isNotFile = true;
            uploader.createBox($('#' + slideId.id), slideId);
        }
        $('.delete_slide').on('click', function (e) {
            self.delInitPhoto(e, NewConfig);
        });
    };
    /**收集属性值,构建config**/
    widget.prototype.collectData = function () {
        var self = this;
        var config = [{ "$": { "key": "data" }, "item": []}];
        var tempconfig;
        for (i = 0; i < NewConfig.data.length; i++) {
            NewConfig.data[i].iOrder = $('#' + NewConfig.data[i].id).closest('.row').find('.iOrder').val();
            NewConfig.data[i].cRedirectUrl = $('#' + NewConfig.data[i].id).closest('.row').find('.cRedirectUrl').val();
            NewConfig.data[i].cRedirectId = $('#' + NewConfig.data[i].id).closest('.row').find('.cRedirectId').val();
        }
        //根据iorder进行排序
        for (var i = 0; i < NewConfig.data.length; i++) {
            for (var j = 0; j < NewConfig.data.length - i; j++) {
                if (typeof (NewConfig.data[j + 1]) != "undefined") {
                    if (NewConfig.data[j].iOrder > NewConfig.data[j + 1].iOrder) {
                        tempconfig = NewConfig.data[j + 1];
                        NewConfig.data[j + 1] = NewConfig.data[j];
                        NewConfig.data[j] = tempconfig;
                    }
                }
            }
        }
        if (!config[0].item.length) {
            for (var i = 0; i < NewConfig.data.length; i++) {
                config[0].item.push({ "$": NewConfig.data[i] });
            }

        };
        //判断链接是外部链接还是内部链接
        for (var i = 0; i < NewConfig.data.length; i++) {
            if (NewConfig.data[i].cRedirectUrl.indexOf('http') > -1 || NewConfig.data[i].cRedirectUrl.indexOf('https') > -1) {
                NewConfig.data[i].isExternal = true;
            } else {
                NewConfig.data[i].isExternal = false;
            }
        };
        this.runTemplate(config);
    }
    return widget;
});