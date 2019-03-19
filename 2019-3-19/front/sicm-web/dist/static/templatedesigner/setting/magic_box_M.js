designer.settings.register('magic_box', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    widget.prototype.eventRegister = function () {
        var self = this;
        self.picInfo = {};
        if(self.getInstance().getId().indexOf('*') > -1){
        	var widgetName = self.getInstance().getId().substr(0,self.getInstance().getId().indexOf('*'));
        }else{
        	var widgetName = self.getInstance().getId();
        }        
        var serverConfigData = designer.settings.configs[widgetName];
        var newConfig = serverConfigData && serverConfigData.config || [{
            "$": {
                "key": "imagedata"
            },
            "item": []
        }];
        $(".tipClose").click(function (e) {
            $("#useTip").hide();
        });
        $("#designerConfirm").find(".ok").click(function (e) {
            if (!self.curruentData.url && !self.picInfo.imgurl) {
                alert("请先上传图片！");
                return;
            };
            var picUrl = self.picInfo.imgurl;
            var picHerf = $("#uploadImage").find(".webherf").val();
            self.curruentData.url = picUrl || self.curruentData.url;
            self.curruentData.href = picHerf;
            var index = -1;
            if (!newConfig[0].item.length) {
                newConfig[0].item.push({ "$": self.curruentData });
            } else {
                var imagedata = newConfig[0].item;
                for (var i = 0, len = imagedata.length; i < len; i++) {
                    if (imagedata[i].$.id === self.curruentData.id) {
                        index = i;
                        break;
                    }
                }
                if (index === -1) {
                    newConfig[0].item.push({ "$": self.curruentData });
                } else {
                    newConfig[0].item[index] = { "$": self.curruentData };
                };
            };
            self.runTemplate(newConfig);
        });
        this.initUpload();
    };
    widget.prototype.initUpload = function () {
        var self = this;
        this.uploader = $("#uploadpic").diyUpload({
            url: cb.rest._getUrl('remote/FileUpload/upload'),
            oneThumb: true,
            cancelButtonText: "取消",
            buttonText: "添加图片",
            success: function (data) {
                self.picInfo = { "imgname": data.data.imgname, "imgurl": data.data.imgurl };
            },
            error: function (err) {
                alert("添加图片失败！" + err);
                console.info(err);
            }
        });
    };
    widget.prototype.afterInit = function () {
        var self = this;
        this.getInstance().on('dblClick', function (data) {
            if(data){
                self.curruentData = data;
                $("#useTip").hide();
                $("#uploadImage").show();
                self.uploader.reset();
                data.isNotFile = true;
                $("#uploadImage").find(".webherf").val(data.href || null);
                self.uploader.createBox($("#uploadpic"), data);
            }; 
        });
        this.getInstance().on("delImage", function (data, widgetName) {
            if(widgetName.indexOf('*')>-1){
               widgetName = widgetName.substr(0, widgetName.indexOf('*'));
            }
            var newConfig = designer.settings.configs[widgetName] && designer.settings.configs[widgetName].config;
            if (!newConfig) return;
            var imagedata = newConfig[0].item;
            for (var i = 0, len = imagedata.length; i < len; i++) {
                if (imagedata[i].$.id === data.id) {
                    imagedata.splice(i, 1);
                    break;
                }
            }
            self.runTemplate(newConfig);
        });
        self.eventRegister();
    };
    widget.prototype.init = function (callback) {
        this.getInstance()._set_data('isDesingerStatus', true);
        var self = this;
        var classs = [];
        var instance = self.getInstance();
        var widgetname = instance.getId();
        if(widgetname.indexOf('*') > -1){
        	widgetname = widgetname.substr(0,widgetname.indexOf('*'));
        }      
        var config = instance.getConfig();
        var proxyConfig = {
            getPendantInfo: { url: '/remote', method: 'POST' },
            getwidgetconfig: { url: '/remote', method: 'POST' }
        };
        var mergeProxy = cb.rest.MergeProxy.create();
        mergeProxy.add(proxyConfig['getPendantInfo'], 
            {serviceId:'restService',
             serviceParam:JSON.stringify({url:'csc-plat/client/Products/getPendantInfo'}),
             jsonData:JSON.stringify({msgEntity:{}})
            }, function (err, result) {
        });
        mergeProxy.add(proxyConfig['getwidgetconfig'], {
            serviceId:'restService',
            serviceParam:JSON.stringify({url:'csc-plat/client/Template/getwidgetconfig'}),
            jsonData:JSON.stringify({msgEntity:{orgPageId:config.orgPageId}})
        }, function (err, result) {
            var widgetconfig = JSON.parse(decodeURIComponent(result)).view.widget;
            for (i = 0; i < widgetconfig.length; i++) {
                if (widgetconfig[i].$.name == widgetname) {
                    NewConfig = widgetconfig[i].config;
                }
            }
        });
        mergeProxy.submit(function () {
            callback(config);
        });
        $('.widgetconfig')[0].style.overflowY = 'auto';
    };
    return widget;
});