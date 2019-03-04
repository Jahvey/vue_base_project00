designer.settings.register('coupon', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    var Config;
    var widgetname;
    var CouponId;
    var CouponData = {};
    var configId;
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        widgetname = instance.getId().substr(0,instance.getId().indexOf('*'));
        Config = instance.getConfig();
        callback(Config);
        $('.widgetconfig')[0].style.overflowY = 'auto';
    };
    widget.prototype.afterInit = function () {   	
        var self = this;
        for (var i = 0; i < Config.data.length; i++) {
        	this.UploadPhoto(Config.data[i], true);
        	if(Config.data[i].itype){//自定义图片
        		$('#background'+Config.data[i].id).val(1);
        		$$('#couponBackground'+Config.data[i].id)[0].style.display='block';
        		$$('#couponBackcolor'+Config.data[i].id)[0].style.display='none';
        	}else{//默认背景图
        		$$('#couponBackground'+Config.data[i].id)[0].style.display='none';
        		$$('#couponBackcolor'+Config.data[i].id)[0].style.display='block';
        		$('#couponBackcolor'+Config.data[i].id).find('img')[0].style.backgroundColor = Config.data[i].background;
        	}
            //背景来源切换
        	var couponid = Config.data[i].id;
            $$('#background'+couponid).change(function (e) {
            	var id = this.id.substring(10);
            	var i = self.getIndex(id);
            	if($$('#background'+id).val()==1){
            		Config.data[i].backtype=1;
            		$$('#couponBackground'+id)[0].style.display='block';
            		$$('#couponBackcolor'+id)[0].style.display='none';
            	}else{
            		Config.data[i].backtype=0;
            		$$('#couponBackground'+id)[0].style.display='none';
            		$$('#couponBackcolor'+id)[0].style.display='block';       		
            	}
            });
        };
        //添加新优惠券
        $('#addNewCoupon').on('click', function () {
            var _this = this;
            self.addNewCoupon(self.config, _this);
        });        
        //优惠券列表
        $('.CoupinList').on('click', function (e) {
        	self.openCouponList(e);
        });         
        //保存布局
        $('#saveconfig').on('click', function () {
            self.collectData();
        });  
        //排序校验
        $(".iOrder").change(function(){
			if(this.value>5 || this.value<1){
			alert('请输入1到5以内的数字!');
			$$(".iOrder")[0].value="";
			}
		});
        //删除优惠券 
        $('.delete_coupon').on('click', function (e) {
            self.delInitPhoto(e, Config);
        });        
    };  
    widget.prototype.openCouponList = function (e) {
        var self = this;
        configId = e.currentTarget.name;
        var proxy = cb.rest.DynamicProxy.create({
            getCouponList: { url: 'coupon/CouponServer/getAllCoupon', method: 'POST' }
        });
        var tempparams={};
        tempparams.currentPage=1;
        proxy.getCouponList({ param: tempparams }, function (error, result) {
        	var pagecount = Math.ceil(result.totalCount/5);
        	var params={};
        	params.currentPage=1;
        	params.pageSize=5;
            proxy.getCouponList({ param: params }, function (error, result) {
                if (error) {
                    console.log("获取优惠券列表失败！");
                    return;
                };
               	$$('#masks')[0].style.display = "block";
            	$$('#CouponList')[0].style.display = "block";            
    			var tplStr = $$('#CoupomDataTpl').html();
    	        var func = Template7.compile(tplStr);
    	        var html =  func({'couponlist':result.data}); 
    	        $$('#CouponList').find('.list-block').html(html);  
                $$(".cancel").on("click", function () {
                	$$('#masks')[0].style.display = "none";
                	$$('#CouponList')[0].style.display = "none";
                });	        
                $$(".selectCoupon").on("click", function () {
                	CouponId = this.dataset["id"];
                	for(var i =0;i<result.data.length;i++){
                		if(result.data[i].id==CouponId){
                			CouponData=result.data[i];
                			var j = self.getIndex(configId);
    	        			$$('.title')[j].value = result.data[i].title;
    	        			$$('.backcolor')[j].style.backgroundColor = result.data[i].backColor;
    	        			Config.data[j].title = result.data[i].title;
    	        			Config.data[j].couponid = result.data[i].id;
    	        			Config.data[j].expireEndDate = result.data[i].expireEndDate;
    	        			Config.data[j].expireStartDate = result.data[i].expireStartDate;
    	        			Config.data[j].reduceAmount = result.data[i].reduceAmount;
    	        			Config.data[j].startAmount = result.data[i].startAmount;
    	        			Config.data[j].background = result.data[i].backColor;;
                		}
                	}
                	$$('#masks')[0].style.display = "none";
                	$$('#CouponList')[0].style.display = "none";
                });                 
		        $("#pagenation").createPage({
		            pageCount: pagecount,
		            current: 1,
		            unbind: true,
		            backFn: function (p) {
		        		params.currentPage=p;
		        		proxy.getCouponList({ param: params }, function (error, result) {         
		        			var tplStr = $$('#CoupomDataTpl').html();
		        	        var func = Template7.compile(tplStr);
		        	        var html =  func({'couponlist':result.data}); 
		        	        $$('#CouponList').find('.list-block').html(html);  
		                    $$(".cancel").on("click", function () {
		                    	$$('#masks')[0].style.display = "none";
		                    	$$('#CouponList')[0].style.display = "none";
		                    });	        
		                    $$(".selectCoupon").on("click", function () {
		                    	CouponId = this.dataset["id"];
		                    	for(var i =0;i<result.data.length;i++){
		                    		if(result.data[i].id==CouponId){
		                    			CouponData=result.data[i];
		                    			var j = self.getIndex(configId);
		        	        			$$('.title')[j].value = result.data[i].title;
		        	        			$$('.backcolor')[j].style.backgroundColor = result.data[i].backColor;
		        	        			Config.data[j].title = result.data[i].title;
		        	        			Config.data[j].couponid = result.data[i].id;
		        	        			Config.data[j].expireEndDate = result.data[i].expireEndDate;
		        	        			Config.data[j].expireStartDate = result.data[i].expireStartDate;
		        	        			Config.data[j].reduceAmount = result.data[i].reduceAmount;
		        	        			Config.data[j].startAmount = result.data[i].startAmount;
		        	        			Config.data[j].background = result.data[i].backColor;;
		                    		}
		                    	}
		                    	$$('#masks')[0].style.display = "none";
		                    	$$('#CouponList')[0].style.display = "none";
		                    }); 		        			
		        		});	
		            }
		        });            	          
            });        	
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
        $(e.currentTarget).closest('.coupon').remove();

    };
    /*添加新的图片*/
    widget.prototype.addNewCoupon = function (config, _this) {
        var self = this;
        if ($$('.coupon').length > 4) {
            alert('最多只能添加5张优惠券！');
        } else {
            var addContent = "";
            var coupon = {};
            coupon.id = new Date().valueOf();
            addContent += '<div class="coupon"><div class="content-block "><div class="row"><div class="col-50">';
            addContent += '<a href="#" class="button  button-fill color-blue CoupinList" name="'+coupon.id+'">选取优惠券</a></div>';
            addContent += '<div class="col-50"><div class="edit_button"><ul><li class="delete_coupon"><a>删除</a></li></ul></div></div></div>';
            addContent += '<div class="row" id="couponBackground'+coupon.id+'" style="display:none;"><div id="'+coupon.id+'" style="margin-right: 190px;"></div></div></div>';
            addContent += '<div class="content-block "><div class="row" id="couponBackcolor'+coupon.id+'" style="display:block;"><div class="col-100">';
            addContent += '<img class="backcolor" src="" width="100%" height="150px""></div></div></div><div class="list-block">';
            addContent += '<ul><li><div class="item-content"><div class="item-media"></div><div class="item-inner"><div class="item-title label">优惠券标题</div>';
            addContent += '<div class="item-input"><input value="" type="text" class="title" readonly></div></div></div></li><li><div class="item-content">';
            addContent += '<div class="item-media"></div><div class="item-inner"><div class="item-title label">背景来源</div><div class="item-input">';
            addContent += '<select id="background'+coupon.id+'"><option value="0" >默认背景色</option><option value="1" >自定义图片上传</option></select></div></div></div></li>';
            addContent += '<li><div class="item-content"><div class="item-media"></div><div class="item-inner"><div class="item-title label">显示顺序</div>';
            addContent += '<div class="item-input"><input value="" type="number" class="iOrder" min="1" max="6" ></</div></div></li></ul></div></div>';
            
            $(_this).closest('.content-block').prev().after(addContent);
            var newConfig = {"id":coupon.id,"couponid": '',"title": "","backtype": "0","startAmount": "","reduceAmount": "","expireStartDate": "","expireEndDate": "","background":"","iorder":"","itype":"false"};
            Config.data.push(newConfig);
            this.UploadPhoto(coupon, false);
            //背景来源切换
            $$('#background'+coupon.id).change(function (e) {
            	var i = self.getIndex(coupon.id);
            	if($$('#background'+coupon.id).val()==1){
            		Config.data[i].backtype=1;
            		$$('#couponBackground'+coupon.id)[0].style.display='block';
            		$$('#couponBackcolor'+coupon.id)[0].style.display='none';
            	}else{
            		$$('#couponBackground'+coupon.id)[0].style.display='none';
            		$$('#couponBackcolor'+coupon.id)[0].style.display='block';       		
            	}
            }); 
            //优惠券列表
            $('.CoupinList').on('click', function (e) {
            	self.openCouponList(e);
            });             
            //删除优惠券 
            $('.delete_coupon').on('click', function (e) {
                self.delInitPhoto(e, Config);
            });             
            //排序校验
            $(".iOrder").change(function(){
				if(this.value>5 || this.value<1){
				alert('请输入1到5以内的数字!');
				$$(".iOrder")[0].value="";
				}
    		});            
        }        
    };
    /**收集属性值,构建config**/
    widget.prototype.collectData = function () {
        var self = this;
        var config = [{"$": { "key": "height","value":"" }},{ "$": { "key": "data" }, "item": []}];
        var tempconfig;
        for (i = 0; i < Config.data.length; i++) {
        	if(Config.data[i].couponid==""){
        		alert("请选择优惠券后重试！");
        		return;
        	}
            Config.data[i].iOrder = $('#' + Config.data[i].id).closest('.coupon').find('.iOrder').val()
        }
		//根据iorder进行排序
		for (var i = 0; i < Config.data.length; i++){
			for (var j = 0; j < Config.data.length - i; j++){
				if(typeof(Config.data[j + 1]) != "undefined"){
					if (Config.data[j].iOrder > Config.data[j + 1].iOrder){
						tempconfig = Config.data[j + 1];
						Config.data[j + 1] = Config.data[j];
						Config.data[j] = tempconfig;
					}
				}
			}
		}        
        if (!config[1].item.length) {
            for (var i = 0; i < Config.data.length; i++) {
                config[1].item.push({ "$": Config.data[i] });
            }

        };
        var height = $('#' + Config.data[0].id).closest('.page').find('.height').val();
        if(height==""){
        	alert("高度为必输项目，请填写高度！");
        	return;
        }else{
        	config[0].$.value = height;
        }
        this.runTemplate(config);
    }
    /*上传图片方法**/
    widget.prototype.UploadPhoto = function (photoId, isDefault) {
        var self = this;
        this.uploader = $('#' + photoId.id).data('index', { "photoIndex": photoId.id }).diyUpload({
            url: cb.rest._getUrl('/client/FileUpload/upload'),
            oneThumb: true,
            cancelButtonText: "取消",
            buttonText: "添加图片",
            success: function (data) {
            	var i = self.getIndex(this[0].id);
            	Config.data[i].background = data.data.imgurl;
            },
            error: function (err) {
                alert("添加图片失败！" + err);
                console.info(err);
            }
        });
        this.uploader.reset();
        photoId.isNotFile = true;
        var i = self.getIndex(photoId.id);
        if(Config.data[i].backtype==1){
        	photoId.url = Config.data[i].background;
        }
        this.uploader.createBox($('#' + photoId.id), photoId);        
    }    
    /*获取顺序的方法*/
    widget.prototype.getIndex = function (id) {
        var self = this;
    	for(var i=0;i<Config.data.length;i++){
    		if(Config.data[i].id == id){
    			return i;
    		}
    	}        
    }     
    return widget;
});