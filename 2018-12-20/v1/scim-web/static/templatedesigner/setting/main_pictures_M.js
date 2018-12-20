designer.settings.register('main_pictures', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    var NewConfig;
    var widgetname;
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        widgetname = instance.getId().substr(0,instance.getId().indexOf('*'));
        this.config = instance.getConfig();
        var initSelectNum = this.config.photos[0].selectedNum;       
        callback(this.config);
        if(initSelectNum != undefined){
        	$($('#photoSelected')[0].options[parseInt(initSelectNum)-1]).attr('select','selected')
        	$('#photoSelected').val(parseInt(initSelectNum));
        	if (initSelectNum == "1") {
        	    $('.reminderMsg').text("320");
        	} else if (initSelectNum == "2") {
        	    $('.reminderMsg').text("160");
        	} else if (initSelectNum == "3") {
        	    $('.reminderMsg').text("106");
        	} else if (initSelectNum == "4") {
        	    $('.reminderMsg').text("80");
        	} else if (initSelectNum == "5") {
        	    $('.reminderMsg').text("64");
        	} else if (initSelectNum == "6") {
        	    $('.reminderMsg').text("53");
        	}
        	self._set_data('displayNum',initSelectNum);
        }else{
        	$($('#photoSelected')[0].options[3]).attr('select','selected');
        	$('#photoSelected').val('4');
        	$('.reminderMsg').text("80");
        	self._set_data('displayNum','4');
        }
        $('.widgetconfig')[0].style.overflowY = 'auto';
        this.addEventHandler($('#photoSelected')[0], 'change', function () {
            var displayNum = this.options[this.selectedIndex].text;
            if (displayNum == "1") {
                $('.reminderMsg').text("320");
            } else if (displayNum == "2") {
                $('.reminderMsg').text("160");
            } else if (displayNum == "3") {
                $('.reminderMsg').text("106");
            } else if (displayNum == "4") {
                $('.reminderMsg').text("80");
            } else if (displayNum == "5") {
                $('.reminderMsg').text("64");
            } else if (displayNum == "6") {
                $('.reminderMsg').text("53");
            }
        	self._set_data('displayNum',displayNum);
        })
    };
    widget.prototype.afterInit = function () {
        var self = this;
        self.photoObj = {};
        self.photoNum = 0;
        self.picInfo = null;
        var num = [];
        for (var i = 0; i < this.config.photos.length; i++) {
            self.photoObj[this.config.photos[i].id] = this.config.photos[i];
            num.push(this.config.photos[i].id);
            this.UploadPhoto(this.config.photos[i], false);
            if(this.config.photos[i].porder){
            	this.isPictureWidget = true;
            }
        };

        num.sort((function (a, b) { return a > b ? 1 : -1 }));
        self.photoNum = num[this.config.photos.length - 1];
        $('#addNewPhoto').on('click', function () {
            var _this = this;
            self.addNewPhoto(self.config, _this);
        });
        $('.delete_photo').on('click', function (e) {
            self.delInitPhoto(e);
        });
        $('#addPhotoConfirm').on('click', function (e) {
        	var widgetconfig = $(e.currentTarget).closest('.widgetconfig');
        	var contentBlockLength = widgetconfig.find('.content-block').length;
        	var diyUploadHoverLength = widgetconfig.find('.diyUploadHover').length;
            if (widgetconfig.find('.diyButton').length > 0) { //当有未上传的图片时   提示
                alert("请先上传图片");
                return;
            }
            if(widgetconfig.find('.content-block').length == '0' || (widgetconfig.find('.diyUploadHover').length > 0 && self.isPictureWidget && (contentBlockLength == diyUploadHoverLength))){   //当设计态中 清除所有的图片后   关闭当前的图片挂件编辑
            	self.collectData(e);
            	widgetconfig.find('div.page').hide();
            	return;
            }
            self.collectData(e);
        });
        $(".moveup_photo").on("click", function (e) {
            self.moveUpClick(e, 'up');
        });
        $(".movedown_photo").on("click", function (e) {
            self.moveUpClick(e, 'down');
        });
    };
    /***图片移动事件**/
    widget.prototype.moveUpClick = function (e, type) {
        var targetContent = $(e.currentTarget).closest('.content-block');
        if (type == 'up' && targetContent.prev().hasClass('content-block')) {
            targetContent.insertBefore($(targetContent.prev()));
        } else if (type == 'down' && targetContent.next().hasClass('content-block')) {
            targetContent.insertAfter($(targetContent.next()));
        }

    };
    /****删除图片的方法*****/
    widget.prototype.delInitPhoto = function (e) {
        var targetObj = $(e.currentTarget).closest('.content-block').find('.webuploader-container').attr('id');
        delete this.photoObj[targetObj];
        $(e.currentTarget).closest('.content-block').remove();

    };
    /*添加新的图片*/
    widget.prototype.addNewPhoto = function (config, _this) {
        var self = this;
        this.photoNum++;
        this.picInfo = null;
        /*if ($('.webuploader-container').length > 4) {
            alert('最多只能添加5张图片');
        } else {
            var addContent = "";
            addContent += '<div class="content-block">';
            addContent += '<div class="row">';
            addContent += '<div class="edit_button">';
            addContent += '<ul>';
            addContent += '<li class="delete_photo"><a>删除</a></li>';
            addContent += '<li class="moveup_photo"><a>上移</a></li>';
            addContent += '<li class="movedown_photo"><a>下移</a></li>';
            addContent += '</ul>';
            addContent += '</div>';
            addContent += '<div id=' + this.photoNum + ' style="margin-right: 20%;">';
            addContent += '</div>';
            addContent += '<div>';
            addContent += '<div class="item-title label">跳转地址</div>';
            addContent += '<input type="text" value="" id="goAddress' + this.photoNum + '" class="address">';
            addContent += '</div>';
            addContent += '</div>';
            $(_this).closest('.row').prev().after(addContent);
            self.UploadPhoto({ "id": this.photoNum }, false);
        }*/
       var addContent = "";
        addContent += '<div class="content-block">';
        addContent += '<div class="row">';
        addContent += '<div class="edit_button">';
        addContent += '<ul>';
        addContent += '<li class="delete_photo"><a>删除</a></li>';
        addContent += '<li class="moveup_photo"><a>上移</a></li>';
        addContent += '<li class="movedown_photo"><a>下移</a></li>';
        addContent += '</ul>';
        addContent += '</div>';
        addContent += '<div id=' + this.photoNum + ' style="margin-right: 20%;">';
        addContent += '</div>';
        addContent += '<div>';
        addContent += '<div class="item-title label">跳转地址</div>';
        addContent += '<input type="text" value="" id="goAddress' + this.photoNum + '" class="address">';
        addContent += '</div>';
        addContent += '<div>';
        addContent += '<div class="item-title label">跳转地址Id</div>';
        addContent += '<input type="text" value="" id="goAddress' + this.photoNum + '" class="linkId">';
        addContent += '</div>';
        addContent += '</div>';
        $(_this).closest('.row').prev().after(addContent);
        self.UploadPhoto({ "id": this.photoNum }, false);
        $('.delete_photo').on('click', function (e) {
            self.delInitPhoto(e);
        });
        $(".moveup_photo").on("click", function (e) {
            self.moveUpClick(e, 'up');
        });
        $(".movedown_photo").on("click", function (e) {
            self.moveUpClick(e, 'down');
        });
    };
    /***由设计态转化为运行态**/
    widget.prototype.desinerToRun = function (ConfigData) {
        var objectOrder = {};
        var newConfig = [{
            "$": {
                "key": "photos"
            },
            "item": [],          
        }];
        if (!newConfig[0].item.length) {
            for (var i = 0; i < ConfigData.length; i++) {
                newConfig[0].item.push({
                    "$": ConfigData[i]
                });
            }

        };
        if (!this.picInfo) {
            alert("请先上传图片！");
            return;
        };
        this.runTemplate(newConfig);

    };
    /**收集除了图片之外的其他的属性值,比如高度，图片的链接地址，图片的顺序等等**/
    widget.prototype.collectData = function (e) {
        var arrayData = [];
        var selectedNum = this._get_data('displayNum');
        if(selectedNum ==undefined){
        	selectedNum = 4;
        };
        var HtmlContent = $(e.currentTarget).closest('.row').prevAll('.content-block');
        for (var i = 0; i < HtmlContent.length; i++) {
            this._set_data("objValue", {
                "id": $(HtmlContent[i]).find('.webuploader-container').attr('id')
            });
            arrayData.push(this.photoObj[this._get_data('objValue').id]);
        }
        arrayData = arrayData.reverse();
        for (var i = 0; i < arrayData.length; i++) {
            if (typeof (arrayData[i]) == "undefined" || arrayData[i].porder) {  // arrayData[i].porder 代表点击图片挂件新增  并且没有图片上传
            	arrayData.splice(i,1);
            	i = i - 1;
                continue;
            };
            var addressValue = $('#' + arrayData[i].id).closest('.row').find('.address').val();
            arrayData[i].link = addressValue;
            var linkIdValue = $('#' + arrayData[i].id).closest('.row').find('.linkId').val();
            arrayData[i].linkId = linkIdValue;
            arrayData[i].selectedNum = selectedNum;
            if (arrayData[i].link.indexOf('http') > -1 || arrayData[i].link.indexOf('https') > -1) {
                arrayData[i].isExternal = true;
            } else {
                arrayData[i].isExternal = false;
            }
        };
        this.desinerToRun(arrayData);
    };
    /*上传图片方法**/
    widget.prototype.UploadPhoto = function (photoId, isDefault) {
        var self = this;
        this.uploader = $('#' + photoId.id).data('index', { "photoIndex": photoId.id }).diyUpload({
            url: cb.rest._getUrl('remote/FileUpload/upload'),
            oneThumb: true,
            cancelButtonText: "取消",
            buttonText: "添加图片",
            success: function (data) {
                var index = this.data('index');
                self.picInfo = {
                    //"cFileName": data.data.cImgName,
                    //"cOriginalName": data.data.cOriginalName,
                    "imgurl": data.data.imgurl
                };
                if (isDefault) {
                    self.photoObj[index.photoIndex] = {
                        "id": self.photoNum,
                        "url": self.picInfo.imgurl//cFolder + "lm_" + self.picInfo.cFileName
                    };
                } else {
                    self.photoObj[index.photoIndex] = {
                        "id": index.photoIndex,
                        "url": self.picInfo.imgurl//cFolder + "lm_" + self.picInfo.cFileName
                    };
                }

            },
            error: function (err) {
                alert("添加图片失败！" + err);
                console.info(err);
            }
        });
        this.uploader.reset();
        photoId.isNotFile = true;
        this.picInfo = photoId;
        this.uploader.createBox($('#' + photoId.id), photoId);
    };
    /* 
	 * addEventListener:监听Dom元素的事件 
	 *  
	 * target：监听对象 
	 * type：监听函数类型，如click,mouseover 
 	*/
   widget.prototype.addEventHandler = function(target, type, func){
       if(target.addEventListener){
           target.addEventListener(type, func, false);
       }else if(target.attachEvent){
       	   target.attachEvent("on" + type, func); 
       }else{
       	   target["on" + type] = func;
       }
   }
    return widget;
});