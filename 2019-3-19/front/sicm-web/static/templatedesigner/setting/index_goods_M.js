designer.settings.register('index_goods', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    var NewConfig, widgetname, filter, order, isAccurate = [], moreLink = [], isEnter = false, productlist, pageindex = 1, pagesize = 5;
    var goodClass;
    var groupId;
    var timeCondition,timeUnit1,time1,timeUnit2,time2,groupSuccType;
    var PointForStoreSetting;
    var tabPageGeneralData = {};   //存放不同页签的已选择普通商品
    var tabPageGroupBuyingData = {};     // 存放不同页签的已选择团购商品
    var tabPageSecKillData = {};   //存放不同页签的已选择秒杀商品
    var tabCount = 1; //多页签计数
    var configTabCount = []; // 用来获取最大的id
    var generalProSelectCon = {};  //存放普通商品精确选择商品的过滤条件
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    widget.prototype.proxy = cb.rest.DynamicProxy.create({
        getProductList: { url: 'client/Products/getProductList', method: 'POST' }
    });
    widget.prototype.preprocess = function ($node, config) {
        $node.children('div').children('div').html(this.render($node.find('#pageDataTpl1'), {configs: config}));
    };
    widget.prototype.afterInit = function () {
        var self = this;
        var queryString = new cb.util.queryString();
        if(queryString.query.templatePage == 'home'){
        	$('.area').closest('li').hide();
        }
        var proxy = cb.rest.DynamicProxy.create({
            getbrand: { url: 'corp/Template/getEnabledPointForStoreSetting', method: 'GET' }
        });
        proxy.getbrand(function (err, result) {
        	if(result){
        		PointForStoreSetting = true;
                if(NewConfig.goodStyle == '1' || NewConfig.goodStyle == '2' || NewConfig[0].configs.goodStyle == '1' || NewConfig[0].configs.goodStyle == '2'){
                    $$('.bShowGoodClass').css({'display':'none'});
                }else{
                    $$('.bShowGoodClass').css({'display':'block'});
                }
        		$$('.goodClass')[0].options.length=0;
        		$$('.goodClass')[0].options.add(new Option("现金购买","general"));
        		$$('.goodClass')[0].options.add(new Option("积分换购","points"));
        		$$(".goodClass").val(NewConfig[0].configs.goodclass);
        	}else{
        		PointForStoreSetting = false;
        		$$('.bShowGoodClass')[0].style.display="none";
    			$('.points')[0].style.display="none";
    			$('.general')[0].style.display="block";
    			$('.points0')[0].style.display="none";
    			$('.general0')[0].style.display="block";
        		if(NewConfig.goodclass=="points"){
        			alert("商城配置中【启用积分兑换商品】参数为否,无法选择积分商品属性！");
        		}
                var proxy = cb.rest.DynamicProxy.create({
                    editVersion: {url: 'corp/ProductClasses/getClassesByClassType',method: 'POST'}
                });
                proxy.editVersion({ classType: 'general'}, function (err, result) {
                    var html = self.render($$('#categoryDataTpl').html(), { category: result });
                    $$('.category').html(html);
                });
        	}
        });
        for(var i =0; i< $('.goodsnum').length; i++){  //普通商品回显选择商品个数
        	if(NewConfig[i].configs.filter[0].fieldname == 'goods_id'){
        	  $$(".goodsnum")[i].textContent = NewConfig[i].configs.filter[0].valuefrom.split(',').length;//选择商品个数
        	}else{
        	  $$(".goodsnum")[i].textContent = 0;
        	}
        	  
        }
        $$('#type').change(function (e) {
            var value = this.options[this.options.selectedIndex].value;
            var proxy = cb.rest.DynamicProxy.create({
                getbrand: { url: 'client/ProductBrands/findByTypeId?tid=' + value, method: 'GET' }
            });
            proxy.getbrand(function (err, result) {
                var html = self.render($$('#brandDataTpl').html(), { brand: result });
                $$('.brand').html(html);
            });
        });
        $$('.goodClass').change(function (e) {
        	goodClass = this.options[this.options.selectedIndex].value;
            self.switchPointerStyle(goodClass);
            var proxy = cb.rest.DynamicProxy.create({
                editVersion: {url: 'corp/ProductClasses/getClassesByClassType',method: 'POST'}
            });
            proxy.editVersion({ classType: goodClass}, function (err, result) {
                var html = self.render($$('#categoryDataTpl').html(), { category: result });
                $$('.category').html(html);
            });
        });
        /********初始化 根据不同的展现方式显示不同的排序规则**************/
        if (NewConfig.goodStyle == '1' || NewConfig.goodStyle == '2') {
          $$('.iorder option[value=iSales7]').css({'display':'none'});
          $$('.iorder option[value=iSales30]').css({'display':'none'});
        }else{
          $$('.iorder option[value=iSales7]').css({'display':'block'});
          $$('.iorder option[value=iSales30]').css({'display':'block'});
        }
       /********切换商品展现样式**********begin**************/
        $$('#productStyle').change(function () {
            NewConfig.goodStyle = this.options[this.options.selectedIndex].value;
            if (NewConfig.goodStyle == '1') {
                $$("#shownumber").val("4");
                PointForStoreSetting = false;
                NewConfig.goodclass ='general';
                NewConfig.groupselect = '0';
                $$('#displayPhoto').css({'display':'none'});
                $$('.bShowGoodClass').css({'display':'none'});
                $$('.goodSelect [data-type="range"]').trigger('click');
                $$('.goodSelect [data-type="accurate"]').css({'display':'none'});
                $$('.iorder option[value=iSales7]').css({'display':'none'});//根据不同的展现方式显示不同的排序规则
                $$('.iorder option[value=iSales30]').css({'display':'none'});
                //秒杀商品添加后的一些变化
                $$('.peoplecondition').show();
                //隐藏展现样式和更多链接
                $('.showStyle_list').closest('li').hide();
                $('.moreLink').closest('li').hide();
                //处理时间条件和成团条件
                $('input[name^=timecondition]:checked').removeAttr('checked');
                $('.inputstart, .inputend').val('');
                $('.starttimeselect, .endtimeselect').val('1');
                $('input[name^=peoplecondition]:checked').removeAttr('checked');
            } else if (NewConfig.goodStyle == '2') {  //秒杀商品
                $$("#shownumber").val("3");
            	PointForStoreSetting = false; 
                NewConfig.goodclass ='general';
                NewConfig.groupselect = '0';
                $$('#displayPhoto').css({'display':'none'});
                $$('.bShowGoodClass').css({'display':'none'});
                $$('.goodSelect [data-type="range"]').trigger('click');
                $$('.goodSelect [data-type="accurate"]').css({'display':'none'});
                $$('.iorder option[value=iSales7]').css({'display':'none'});//根据不同的展现方式显示不同的排序规则
                $$('.iorder option[value=iSales30]').css({'display':'none'});
                //秒杀商品应该隐藏一些属性
                $$('.peoplecondition').hide();
                $('.showStyle_list').closest('li').show();
                //处理时间条件
                $('input[name^=timecondition]:checked').removeAttr('checked');
                $('.inputstart, .inputend').val('');
                $('.starttimeselect, .endtimeselect').val('1');
            } else {
                $$("#shownumber").val("4");
                $$('.bShowGoodClass').css({'display':'block'});
            	$$('#displayPhoto').css({'display':'block'});
                $$('.iorder option[value=iSales7]').css({'display':'block'});
                $$('.iorder option[value=iSales30]').css({'display':'block'});
                $('.showStyle_list').closest('li').hide();
                $('.moreLink').closest('li').hide();
            }
            $$(".saleprice_from").val(""); //价格区间起始
            $$(".saleprice_to").val(""); //价格区间结束
            $$(".keyword").val(""); //关键词
            $$(".category").val(""); //分类
            $$(".brand").val(""); //品牌
            $$(".tag").val(""); //标签
            $$(".area").val(""); //区域
            $$('.iorder').val("iOrder"); //排序规则
            $$('.adesc').val("asc");  //升序降序
          	self.initWebStyle(NewConfig,'.tab_page');//true代表设计态

        });
      /********选择活动的的筛选条件*********************/
        $('body').delegate('.selectCondition','click',function(e){
	        	var index = $(this).closest('.tab_page').index()-2;
	        	var goodStyle = $$('#productStyle').val()
	            var _this = '.tab_page:eq('+index+')';
	            NewConfig.groupselect = '0';
	            NewConfig.goodStyle = goodStyle;
	            self.initWebStyle(NewConfig,_this);
	            isAccurate[index] =false;
	            $(_this+' .showStyle_list').trigger('click');
        })
      /********指定活动的的筛选条件*********************/
        $('body').delegate('.selectPrecise','click',function(e,flag){
        	if(flag)
        	  return; 
    	  	//定义全局变量 scrollHeight  选中商品后   回滚到当前的位置
        	var height = 136;
        	var index = $(this).closest('.tab_page').index()-2;
        	var goodStyle = $$('#productStyle').val()
        	var _this = '.tab_page:eq('+index+')';
        	//定义全局变量 传递给查询商品
            _thisForQuery = _this;
        	for(var i=0; i<=index; i++){
        		height+=$('.tab_page:eq('+i+')').height();
        	}
        	scrollHeight = height - e.clientY;
        	NewConfig.groupselect = '1';
        	NewConfig.goodStyle = goodStyle;
            self.initWebStyle(NewConfig,_this);           
            isAccurate[index] =true;
            if(goodStyle == '1'){
              $$("#group_popupsection").show();
              self.dealWithPagenation('group',_this);
            }else if(goodStyle == '2'){
               $$("#secKill_popupsection").show();
               self.dealWithPagenation('secKill',_this);              
            }
            $('.widgetconfig').eq(0).scrollTop(0);  //回滚到顶部
        })
      /********展示样式的选择************/
       $('body').delegate('.showStyle_list','click',function(e){ //列表不用显示更多链接
       	var index = $(this).closest('.tab_page').index()-2;
       	 var _this = '.tab_page:eq('+index+')';
       	 $(_this+' .moreLink').closest('li').hide();
       })
       
       $('body').delegate('.showStyle_enter','click',function () {
       	var index = $(this).closest('.tab_page').index()-2;
       	var _this = '.tab_page:eq('+index+')';
           if (parseInt($$("#shownumber").val()) > 3) {
               $$("#shownumber").val("3");
           }
           var proxy = cb.rest.DynamicProxy.create({
               chanelList: { url: 'client/Template/templatepagelist', method: 'GET' }
           });
           var itemplateid = queryString.query.itemplateid;
           proxy.chanelList({ "id": itemplateid }, function (err, result) {
               var html = self.render($$('#chanelDataTpl').html(), { chanelListData: result });
               $(_this+' .moreLink').html(html);
               $(_this+' .moreLink').closest('li').show();
               if(isEnter){
               	 $(_this+' .chanelValue').val(moreLink[index]);
               }
           });
       });
       $$('#shownumber').on("change", function () {
           if (NewConfig.goodStyle == '2') {
               if ($$('.showStyle:checked').val() == "1") {
                   if (parseInt($$(this).val()) > 3) {
                       $$(this).val("3");
                   }
               }   
           }
           if (parseInt($$(this).val()) <= 0) {
               $$(this).val("1");
           }
       });
      /********开始时间的选择***/
       $$('.timecondition').on('click',function(e){
       	var index = $(this).closest('.tab_page').index()-2;
       	var _this = '.tab_page:eq('+index+')';
            switch(e.target['className']){
                case 'startTimecondition':
                    timeCondition = 1;
                    $(_this+' .starttimeselect').change(function(){
                        timeUnit1 = this.options[this.options.selectedIndex].value;
                    });
                break;
                case 'endTimecondition':
                    timeCondition = 2;
                    $(_this+' .endtimeselect').change(function(){
                        timeUnit2 = this.options[this.options.selectedIndex].value;
                    });
                break;
                case 'ending':
                    timeCondition = 3;
                break;
                case 'allgroup':
                    timeCondition = 4;
                break;
            }
       });
       $$('.timecondition').on('keyup',function(e){
       	var _this = '.tab_page:eq('+$(this).index()+')';
            switch(e.target['className']){
                case 'inputstart':
                    time1 = $(_this+' .inputstart').val();
                break;
                case 'inputend':
                    time2 = $(_this+' .inputend').val();
                break;
            }
       });
    /********成团条件选择***/
       $$('.peoplecondition').on('click',function(e){
            switch(e.target['value']){
                case '0':
                    groupSuccType = '0';
                break;
                case '1':
                    groupSuccType = '1';
                break;
                case '2':
                    groupSuccType = '2';
                break;
            }
       })


        $$(".submit").click(function (e) {
            self.UpdateNewConfig($$("#productStyle").val());
            self.runTemplate(tabPagesTemp);
        });
        //点击添加页签
        $$(".addNewTab").click(function(e){
        	self.addNewTab();
        	if($('.tab_page').length>1){
    		  $('.tabName').closest('li').show();
    	    }else{
    	      $('.tabName').closest('li').hide();
    	    }
        });
        
        //点击添加按钮
        $("body").delegate('.addNext','click',function(e){
        	if(e.handle != true){
        		e.handle = true;
	        	var pos = $(this).closest('.tab_page');
	        	self.addNewTab(pos);
	        	if($('.tab_page').length>1){
        		  $('.tabName').closest('li').show();
        	    }else{
        	      $('.tabName').closest('li').hide();
        	    }
        	}
        });
        
        //点击删除按钮
        $("body").delegate(".deleteTabPage",'click',function(e){
        	if(e.handle != true){
        	   e.handle = true;
	           if($('.tab_page').length == 1){
	           	 alert('请至少保留一个页签');
	           }else{
	           	var id = $(this).closest('.tab_page').attr('id');
	           	var goodStyle = $('#productStyle').val();
	           	var index = $(this).closest('.tab_page').index() - 2;
	           	if(goodStyle == '0'){
	           		 delete generalProSelectCon[id];
	           	}else if(goodStyle == '1'){
	           		delete tabPageGroupBuyingData[id];
	           	}else if(goodStyle == '2'){
	           		delete tabPageSecKillData[id];
	           	}
	           	 isAccurate.removeAt(index);
	             $(this).closest('.tab_page').remove();
	             
	           }
	        	if($('.tab_page').length>1){
        		  $('.tabName').closest('li').show();
        	    }else{
        	      $('.tabName').closest('li').hide();
        	    }
        	}
        });
        
        
        $$("#selectBy").change(function (e) {
            var proxy = cb.rest.DynamicProxy.create({
                PendantInfo: { url: 'client/Products/getPendantInfo', method: 'GET' }
            });
            proxy.PendantInfo(function (err, result) {
                if ($$("#selectBy").val() == "type") {
                    var html = self.render($$('#typeDataTpl').html(), { type: result.typeList });
                    $$('#flitertype').html(html);
                } else if ($$("#selectBy").val() == "category") {
                    var html = self.render($$('#categoryDataTpl').html(), { category: result.classList });
                    $$('#flitertype').html(html);
                } else if($$("#selectBy").val() == "area"){
                    var html = self.render($$('#areaDataTpl').html(), { arealist: result.arealist });
                    $$('#flitertype').html(html);
                }else{
                	var html = self.render($$('#brandDataTpl1').html(), { brand: result.brandList });
                    $$('#flitertype').html(html);
                }
            });
        });
        $$("#searchProList").click(function(r){
        	cb.util.localStorage.removeItem("areaid");
	        self.dealWithPagenation('product',_thisForQuery,true);
        });
        $$("#searchGroupList").click(function(r){
            self.dealWithPagenation('group',_thisForQuery);
        });
         /*秒杀搜索*/
         $$("#searchSecKillList").click(function(r){
            self.dealWithPagenation('secKill',_thisForQuery);
        });
        
        $('body').delegate('.goodSelect a','click',function(){
          	var index = $(this).closest('.tab_page').index()-2;
          	isAccurate[index] = $$(this).attr("data-type") == "accurate" ? true : false;
        });
        
        $('body').delegate(".selectproducts",'click',function (e) {
        	if(!e.handle){
        		if(queryString.query.templatePage == 'home'){
        	        $('#selectBy option[value=area]').hide();
                }else{
                	$('#selectBy option[value=area]').show();
                }
        		e.handle = true;
	        	//定义全局变量 scrollHeight  选中商品后   回滚到当前的位置
	        	var height = 224;
	        	var index = $(this).closest('.tab_page').index()-2;
	        	var _this = '.tab_page:eq('+index+')';
	        	//定义全局变量 传递给查询商品
                _thisForQuery = _this;
	        	for(var i=0; i<=index; i++){
	        		height+=$('.tab_page:eq('+i+')').height();
	        	}
	        	scrollHeight = height - e.clientY;
	            $$("#popupsection").show();
	            self.dealWithPagenation('product',_this);
	            $('.widgetconfig').eq(0).scrollTop(0);  //回滚到顶部
        	}
        });
        $$("#confirmproduct").click(function (e) {
        	if(!e.handle){
        		e.handle = true;
        		var index = $(_thisForQuery).attr('id');
	            for(var i =0; i<$$(".goodsnum").length; i++){
	            	var id = $('.tab_page:eq('+i+')').attr('id');
	            	if(tabPageGeneralData[id])
	            	  $$(".goodsnum")[i].textContent = tabPageGeneralData[id].length;//选择商品个数
	            }
	            generalProSelectCon[index] = {"selectBy":$("#selectBy").val(),"filterValue":$("#filterValue").val(),"productkeyword":$("#productkeyword").val()};
	            $$("#popupsection").hide();
	            $('.widgetconfig').eq(0).scrollTop(scrollHeight);  //回滚到之前的位置
        	}
        });
        $$('#group_confirmproduct').click(function(){
            $$("#group_popupsection").hide();
            $('.widgetconfig').eq(0).scrollTop(scrollHeight);  //回滚到之前的位置
        });
        $$('#secKill_confirmproduct').click(function(){
            $$("#secKill_popupsection").hide();
            $('.widgetconfig').eq(0).scrollTop(scrollHeight);  //回滚到之前的位置
        });
    };
    widget.prototype.UpdateNewConfig = function (goodstyles) {
        var self = this;
        var tabPages = $('.tab_page');
        tabPagesTemp = [];
        for(var i=0; i<tabPages.length; i++){
        	        var tabId = '.'+'tab_page:eq('+i+')';    //第几个页签，通过className选择
        	        var id = $(tabId).attr('id');   //每个页签都有一个id 
        	        var tabName = $(tabId+' .tabName:visible').val();
        	        var timeCondition = 'timecondition'+id;
        	        var peopleCondition = 'peoplecondition'+id;
        	        /*if(tabName == undefined || tabName.trim() == ''){    //页签名称不能为空
        	        	alert('页名称不能为空');
                        return;
        	        }*/
        	        tabPagesTemp[i] = {};
        	        tabPagesTemp[i]['type'] = 'index_goods';
        	        tabPagesTemp[i][tabId] = [ { "$": { "key": "advertisement"} },
		              { "$": { "key": "choosegoods", "value": ""} },
		              { "$": { "key": "colspan"} },
		              { "$": { "key": "rows", "value": ""} },
		              { "$": { "key": "cols", "value": ""} },
		              { "$": { "key": "texttag", "value": ""} },
		              { "$": { "key": "show_market", "value": ""} },
		              { "$": { "key": "show_star", "value": ""} },
		              { "$": { "key": "isCurrentClass"} },
		              { "$": { "key": "displayMode", "value": ""} },
		              { "$": { "key": "showname", "value": "initial"} },
		              { "$": { "key": "showprice", "value": "initial"} },
		              { "$": { "key": "showsale", "value": "initial"} },
		              { "$": { "key": "goodclass", "value": "general"} },
		              { "$": { "key": "filter" },
                               "item": [
                                        { "$":
                                            { "fieldname": "type_id", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "saleprice", "valuefrom": "0", "valueto": "50"}
                                        },
                                        { "$":
                                            { "fieldname": "keyword", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "categoryid", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "brand_id", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "tag_id", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "timeCondition", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "timeUnit1", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "timeUnit2", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "groupSuccType", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "time1", "valuefrom": ""}
                                        },
                                        { "$":
                                            { "fieldname": "time2", "valuefrom": ""}
                                        }
                                        ]},
		              { "$": { "key": "order" }, "item": [{ "$": { "fieldname": "iOrder", "direction": "desc"}}] },
                      { "$": { "key": "goodStyle", "value": goodstyles } },
                      { "$": { "key": "groupselect", "value": ""} },
                      { "$": { "key": "tabPageName", "value": ""} },
                      { "$": { "key": "id", "value": id} }  //通过id 控制每个页签的包含name的input等
        ];
        tabPagesTemp[i][tabId][16].$.value = $$("#productStyle").val();//展现样式
        if(goodstyles == '1' || goodstyles == '2'){
        	var groupselect = 'groupselect'+id;
        	tabPagesTemp[i][tabId][17].$.value = $(tabId+" input[name="+groupselect+"]:checked").val();//筛选活动样式
        }  
        tabPagesTemp[i][tabId][18].$.value = $(tabId+" .tabName:visible").val();
        tabPagesTemp[i][tabId][9].$.value = $$("#showstyle").val(); //显示样式
        tabPagesTemp[i][tabId][3].$.value = "1"; //rows
        tabPagesTemp[i][tabId][4].$.value = $$("#shownumber").val(); //cols显示个数
        var showParameterInput = $(tabId+" .showParameter input"); //显示参数
        tabPagesTemp[i][tabId][10].$.value = showParameterInput[1].checked ? "initial" : "hidden"; //显示商品名称
        tabPagesTemp[i][tabId][11].$.value = showParameterInput[2].checked ? "initial" : "hidden"; //显示商品价格
        tabPagesTemp[i][tabId][12].$.value = showParameterInput[3].checked ? "initial" : "hidden"; //显示商品销量
        //是否启用积分商品
        if(PointForStoreSetting){
        	tabPagesTemp[i][tabId][13].$.value = $(".goodClass").val(); //商品属性
        }else{
        	tabPagesTemp[i][tabId][13].$.value = "general"; //商品属性
        }
        if (isAccurate[i]) {//True为精确选择，False为范围选择
            if(tabPagesTemp[i][tabId][16].$.value == '0'){
               var productidlist = "";
               if(tabPageGeneralData[id]){
	               for (j = 0; j < tabPageGeneralData[id].length; j++) {
	                    if (j + 1 < tabPageGeneralData[id].length) {
	                        productidlist = productidlist + tabPageGeneralData[id][j] + ",";
	                    } else {
	                        productidlist = productidlist + tabPageGeneralData[id][j];
	                    }
	                }
               }
                filter = [{ "$": { "fieldname": "goods_id", "valuefrom": productidlist}},
                          { "$": { "fieldname": "selectBy", "valuefrom": generalProSelectCon[id].selectBy}},
                          { "$": { "fieldname": "filterValue", "valuefrom": generalProSelectCon[id].filterValue}},
                          { "$": { "fieldname": "productkeyword", "valuefrom": generalProSelectCon[id].productkeyword}}
                         ];
            };
            if(tabPagesTemp[i][tabId][16].$.value == '1'){  //团购商品
               var groupidlist = "";
               if(tabPageGroupBuyingData[id]){
	               for (j = 0; j < tabPageGroupBuyingData[id].length; j++) {
	                    if (j + 1 < tabPageGroupBuyingData[id].length) {
	                        groupidlist = groupidlist + tabPageGroupBuyingData[id][j] + ",";
	                    } else {
	                        groupidlist = groupidlist + tabPageGroupBuyingData[id][j];
	                    }
	                }
               }
                filter = [
                            { "$":

                                { "fieldname": "goodStyle", "valuefrom": tabPagesTemp[i][tabId][16].$.value}
                            },
                            { "$":

                                { "fieldname": "groupbuyingdetails_id", "valuefrom": groupidlist}
                            },
                            { "$":

                                { "fieldname": "timeCondition", "valuefrom": 4}
                           },
                           { "$":

                                { "fieldname": "screeningConditions", "valuefrom": 2 }  //指定活动商品
                            }
                         ];
            } else if (tabPagesTemp[i][tabId][16].$.value == '2') { //秒杀商品
                if ($(tabId+' .showStyle:checked').val() == "1") {
                    if (parseInt($$("#shownumber").val()) > 3) {
                        $$("#shownumber").val("3");
                    }
                }
                
               var secKillidlist = "";
               if(tabPageSecKillData[id]){
               	  for (j = 0; j < tabPageSecKillData[id].length; j++) {
                    if (j + 1 < tabPageSecKillData[id].length) {
                        secKillidlist = secKillidlist + tabPageSecKillData[id][j] + ",";
                    } else {
                        secKillidlist = secKillidlist + tabPageSecKillData[id][j];
                    }
                  }
               }
               var chanelHtml = "";
               if ($(tabId+' .showStyle:checked').val() == "1") {
                   chanelHtml = $(tabId+" .chanelValue option:selected").val();
                   if (chanelHtml) {
                       var indexPosition = chanelHtml.indexOf("_M.html");
                       if (indexPosition > 0) {
                           chanelHtml = chanelHtml.substring(0, indexPosition);
                       }
                   }
               }
                filter = [
                            { "$":

                                { "fieldname": "goodStyle", "valuefrom": tabPagesTemp[i][tabId][16].$.value}
                            },
                            { "$":

                                { "fieldname": "secKillbuyingdetails_id", "valuefrom": secKillidlist}
                            },
                            { "$":

                                { "fieldname": "timeCondition", "valuefrom": 4}
                            },
                            { "$":

                                { "fieldname": "showStyle", "valuefrom": $(tabId+' .showStyle:checked').val()}
                            },
                            { "$":

                                { "fieldname": "moreLink", "valuefrom": chanelHtml }
                            },
                            { "$":

                                { "fieldname": "screeningConditions", "valuefrom": 2 }  //指定活动商品
                            }
                         ];
            }
            tabPagesTemp[i][tabId][14].item = filter;
        } else {
            filter = [
                        { "$":
                            { "fieldname": "type_id", "valuefrom": ""}
                        },
                        { "$":
                            { "fieldname": "saleprice", "valuefrom": "0", "valueto": "1000"}
                        },
                        { "$":
                            { "fieldname": "keyword", "valuefrom": ""}
                        },
                        { "$":
                            { "fieldname": "categoryid", "valuefrom": ""}
                        },
                        { "$":
                            { "fieldname": "brand_id", "valuefrom": ""}
                        },
                        { "$":
                            { "fieldname": "tag_id", "valuefrom": ""}
                        },
                        { "$":
                            { "fieldname": "salepoints", "valuefrom": "0", "valueto": "1000"}
                        },
                        {
                           "$":
                            { "fieldname": "timeCondition", "valuefrom": ""}
                        },
                        {
                           "$":
                            { "fieldname": "timeUnit1", "valuefrom": ""}
                        },
                        {
                           "$":
                            { "fieldname": "timeUnit2", "valuefrom": ""}
                        },
                        {
                           "$":
                            { "fieldname": "groupSuccType", "valuefrom": ""}
                        },
                        {
                           "$":
                            { "fieldname": "time1", "valuefrom": ""}
                        },
                        {
                           "$":
                            { "fieldname": "time2", "valuefrom": ""}
                        },
                        {
                           "$":
                            { "fieldname": "goodStyle", "valuefrom": ""}
                        },
                        {
                            "$":

                            { "fieldname": "showStyle", "valuefrom": "" }
                        },
                        {
                            "$":

                              { "fieldname": "moreLink", "valuefrom": "" }
                        },
                        {
                            "$":

                            { "fieldname": "area_id", "valuefrom": "" }
                        }
            ];
            order = { "$": { "key": "order" }, "item": [{ "$": { "fieldname": "iOrder", "direction": "desc"}}] };
            filter[0].$.valuefrom = $(tabId+" .type").val(); //按类型筛选
            filter[3].$.valuefrom = $(tabId+" .category").val(); //分类
            filter[5].$.valuefrom = $(tabId+" .tag").val(); //标签
            filter[4].$.valuefrom = $(tabId+" .brand").val(); //品牌
            filter[1].$.valuefrom = $(tabId+" .saleprice_from").val(); //价格区间起始
            filter[1].$.valueto = $(tabId+" .saleprice_to").val(); //价格区间结束
            filter[2].$.valuefrom = $(tabId+" .keyword").val(); //关键词
           
            filter[7].$.valuefrom = $(tabId+" input[name="+timeCondition+"]:checked").val() || "4"; //输入的时间条件, 默认不为选中，默认值为4（全部）
            filter[8].$.valuefrom = $(tabId+" .starttimeselect").val();//开始的时间单位
            filter[9].$.valuefrom = $(tabId+" .endtimeselect").val();//结束的时间单位
            filter[10].$.valuefrom = $(tabId+" input[name="+peopleCondition+"]:checked").val();//团购满人数
            filter[11].$.valuefrom = $(tabId+" .inputstart").val();//开始时间输入内容
            filter[12].$.valuefrom = $(tabId+" .inputend").val();//结束时间输入内容
            filter[13].$.valuefrom = $("#productStyle").val();
            filter[14].$.valuefrom = $(tabId+' .showStyle:checked').val();
            filter[16].$.valuefrom = $(tabId+' .area').val();
            var chanelHtml = "";
            if ($(tabId+' .showStyle:checked').val() == "1") {
                chanelHtml = $(tabId+" .chanelValue option:selected").val();
                if (chanelHtml) {
                    var indexPosition = chanelHtml.indexOf("_M.html");
                    if (indexPosition > 0) {
                        chanelHtml = chanelHtml.substring(0, indexPosition);
                    }
                }
            }
            filter[15].$.valuefrom = chanelHtml;
            //是否启用积分商品
            if(PointForStoreSetting){
            	if($(".goodClass").val()=="points"){
                    filter[6].$.valuefrom = $(tabId+" .salepoints_from").val(); //积分区间起始
                    filter[6].$.valueto = $(tabId+" .salepoints_to").val(); //积分区间结束
            	}
            }
            order.item[0].$.fieldname = $(tabId+" .iorder").val(); //排序规则
            order.item[0].$.direction = $(tabId+" .adesc").val(); //升序降序
            tabPagesTemp[i][tabId][14].item = filter;
            tabPagesTemp[i][tabId][15] = order;
        };
       } 
    }

    widget.prototype.dealWithPagenation = function (options,_this,flag) {
        var self = this;
        if(options == 'product'){
            this.loadPageData(1, function (result) {
                $("#pagenation").createPage({
                    pageCount: result.totalPage,
                    current: 1,
                    unbind: true,
                    backFn: function (p) {
                        self.loadPageData(p,null,_this,flag);
                    }
                });
            },_this,flag);
        }else if(options == 'group'){
            this.loadGroupPageData(1, function (result) {
                $("#group_pagenation").createPage({
                    pageCount: result.totalPage,
                    current: 1,
                    unbind: true,
                    backFn: function (p) {
                        self.loadGroupPageData(p,null,_this);
                    }
                });
            },_this);
        }else if(options == 'secKill'){
        	this.loadSecKillPageData(1,function(result){
        		    $("#secKill_pagenation").createPage({
                    pageCount: result.totalPage,
                    current: 1,
                    unbind: true,
                    backFn: function (p) {
                        self.loadSecKillPageData(p,null,_this);
                    }
                });
        	},_this);
        }

    };
    
    /****************处理点击添加页签*******************/
   widget.prototype.addNewTab = function(pos){
   	    var self = this;
   	    var html = document.getElementsByClassName('tab_page')[0].innerHTML;
   	    var id = $('.tab_page').eq(0).attr('id');
   	    var val =  $('input[name=groupselect'+id+']:checked').val();
    	var timeCondition = $('input[name=timecondition'+id+']:checked').val();
    	var peopleCondition = $('input[name=peoplecondition'+id+']:checked').val();
    	var showStyle = $('input[name=showStyle'+id+']:checked').val();
    	var moreLink = $('.chanelValue').eq(0).val();
   	    html = '<div class="tab_page" id='+tabCount+'>'+html+'</div>';
   	    //插入到指定位置
   	    if(pos){
   	    	var index = $(pos).index() - 1;
   	    	isAccurate.splice(index,0,false);
   	    	$(pos).after(html);
   	    	$(pos).next().find('a[data-type="range"]').attr('href','#tab1'+tabCount);
	    	$(pos).next().find('a[data-type="accurate"]').attr('href','#tab2'+tabCount);
	    	$(pos).next().find('.range1').attr('id','tab1'+tabCount);
	    	$(pos).next().find('.accurate1').attr('id','tab2'+tabCount);
	    	$(pos).next().find('input[name=groupselect'+id+']').attr('name','groupselect'+tabCount);  //不能有同名的name 所以更改
   	        $(pos).next().find('input[name=timecondition'+id+']').attr('name','timecondition'+tabCount); 
   	        $(pos).next().find('input[name=peoplecondition'+id+']').attr('name','peoplecondition'+tabCount);
   	        $(pos).next().find('input[name=showStyle'+id+']').attr('name','showStyle'+tabCount);  //不能有同名的name 所以更改
   	    }else{ //插入到最后
     	    $('.tab_page:last').after(html);
	     	$('a[data-type="range"]:last').attr('href','#tab1'+tabCount);
	    	$('a[data-type="accurate"]:last').attr('href','#tab2'+tabCount);
	    	$('.range1:last').attr('id','tab1'+tabCount);
	    	$('.accurate1:last').attr('id','tab2'+tabCount);
	    	$('input[name=groupselect'+id+']:eq(-1),input[name=groupselect'+id+']:eq(-2)').attr('name','groupselect'+tabCount);  //不能有同名的name 所以更改
	        $('input[name=timecondition'+id+']:eq(-1),input[name=timecondition'+id+']:eq(-2),input[name=timecondition'+id+']:eq(-3),input[name=timecondition'+id+']:eq(-4)').attr('name','timecondition'+tabCount);
   	        $('input[name=peoplecondition'+id+']:eq(-1),input[name=peoplecondition'+id+']:eq(-2)').attr('name','peoplecondition'+tabCount);
   	        $('input[name=showStyle'+id+']:eq(-1),input[name=showStyle'+id+']:eq(-2)').attr('name','showStyle'+tabCount);
   	    }
	    /************新增页签后   还原第一个页签的内容  start******************/
        if(val == 0){
        	$('input.selectCondition:first').trigger('click');
        }else{
        	$('input.selectPrecise:first').trigger('click',true);  // true 代表不弹出选择框
        }
        //处理时间筛选条件
        switch(timeCondition){
        	case '1':
        	  $('input[name=timecondition'+id+']').eq(0).trigger('click');
        	  break; 
        	case '2':
        	  $('input[name=timecondition'+id+']').eq(1).trigger('click');
        	  break; 
        	case '3':
        	  $('input[name=timecondition'+id+']').eq(2).trigger('click');
        	  break; 
        	case '4':
        	  $('input[name=timecondition'+id+']').eq(3).trigger('click');
        	  break; 
        }
        //处理成团条件筛选条件
        switch(peopleCondition){
        	case '0':
	          $('input[name=peoplecondition'+id+']').eq(0).trigger('click');
	          break;
	        case '1':
	          $('input[name=peoplecondition'+id+']').eq(1).trigger('click');
	          break;
	        case '2':
	          $('input[name=peoplecondition'+id+']').eq(2).trigger('click');
	          break;
        }
    	$('#'+tabCount+' input.selectCondition').trigger('click');  // 新增的页签默认安范围选择
        $$("#"+tabCount).find('a[data-type=range]').trigger('click') // 新增的页签默认安范围选择  * 不能有$  只能用$$
        if(showStyle == 0){
        	$('.showStyle_list:first').trigger('click');
        }else{
        	$('.showStyle_enter:first').trigger('click');  //callback  不能立即执行
        	setTimeout(function(){$('.chanelValue').eq(0).val(moreLink)},1000);
        }
        //新增页签的goodsnum为0
        $('#'+tabCount+' .goodsnum')[0].textContent = 0;
        /************新增页签后   还原第一个页签的内容  end******************/
       
        /************新增的页签不应该带有上一个页签的选择条件   手动清空 start******************/
        $('input[name=timecondition'+tabCount+']:checked').removeAttr('checked');
        $('input[name=peoplecondition'+tabCount+']:checked').removeAttr('checked');
        $('#'+tabCount+' .saleprice_from').val('');
        $('#'+tabCount+' .saleprice_to').val('');
        $('#'+tabCount+' .type').val('');
        $('#'+tabCount+' .keyword').val('');
        $('#'+tabCount+' .category').val('');
        $('#'+tabCount+' .brand').val('');
        $('#'+tabCount+' .tag').val('');
        /************新增的页签不应该带有上一个页签的选择条件   手动清空  end******************/
   	    tabCount++;
   };
    /*****************加载活动列表**********/
    widget.prototype.loadGroupPageData = function(pageindex, callback,_this){
        var self = this;
        var id = $(_this).attr("id");
        var proxy =cb.rest.DynamicProxy.create({
            getGrouplist:{url:'groupbuying/ManagementService/getGroupBuyingProductList',method:'post'}
        });
        var param ={
            name:$$("#groupkeyword").val(),
            startTime:"",
            endTime:"",
            pageSize: pagesize,
            pageIndex: pageindex
        };
        proxy.getGrouplist({search:param},function(err,result){
            if(err){
                alert(err.message);
                return;
            }
            var html = self.render($$('#group_pageDataTpl').html(), { grouplist: result.GroupBuying});
            $$('#group_pageData').html(html);
            if(tabPageGroupBuyingData[id]){
            	for (i = 0; i < tabPageGroupBuyingData[id].length; i++) {
	                groupId = tabPageGroupBuyingData[id][i];
	                for (j = 0; j < $$('.grouplistData').length; j++) {
	                    if (groupId == $$($$('.grouplistData')[j]).attr("id")) {
	                        $$('.grouplistData')[j].checked = "true";
	                    }
                }
            };
            }else{
            	tabPageGroupBuyingData[id] = [];
            }
            $$('.grouplistData').change(function (e) {
                if (e.target.checked) {
                    tabPageGroupBuyingData[id].push(e.target.id);
                } else {
                    for (i = 0; i < tabPageGroupBuyingData[id].length; i++) {
                        if (tabPageGroupBuyingData[id][i] == e.target.id) {
                            tabPageGroupBuyingData[id].removeAt(i);
                        }
                    }
                }
                
            });
            if (callback)
                callback(result);
        });

    };
    /*****************加载秒杀商品列表**********/
       widget.prototype.loadSecKillPageData = function(pageindex, callback,_this){
        var self = this;
        var id = $(_this).attr("id");
        var proxy =cb.rest.DynamicProxy.create({
            getSecKlllist: { url: 'corp/Products/getSpikeProductList', method: 'post' }
        });
		var param ={
			keyword:$$("#secKillkeyword").val(),
			startTime:"",
			currentPage:pageindex,
			pageSize:5,
			endTime:"",
			terminalType:"Mobile"
		};
        proxy.getSecKlllist({param:param},function(err,result){
            if(err){
                alert(err.message);
                return;
            }
            var html = self.render($$('#secKill_pageDataTpl').html(), { secKilllist: result.data});
            $$('#secKill_pageData').html(html);
            if(tabPageSecKillData[id]){
	            for (i = 0; i < tabPageSecKillData[id].length; i++) {
	                secKillId = tabPageSecKillData[id][i];
	                for (j = 0; j < $$('.secKilllistData').length; j++) {
	                    if (secKillId == $$($$('.secKilllistData')[j]).attr("id")) {
	                        $$('.secKilllistData')[j].checked = "true";
	                    }
	                }
	            };
            }else{
            	tabPageSecKillData[id] = [];
            }
            $$('.secKilllistData').change(function (e) {
                if (e.target.checked) {
                    tabPageSecKillData[id].push(e.target.id);
                } else {
                    for (i = 0; i < tabPageSecKillData[id].length; i++) {
                        if (tabPageSecKillData[id][i] == e.target.id) {
                            tabPageSecKillData[id].removeAt(i);
                        }
                    }
                }
            });
            if (callback)
                callback(result);
        });

    };
    /*********加载商品数据****************/
    widget.prototype.loadPageData = function (pageindex, callback,_this,flag) {
        var self = this;
        var productAttr;
        var supplier = {"fieldname": "","valuefrom": ""};
        var queryString = new cb.util.queryString();
        if(queryString.query && queryString.query.templatePage && queryString.query.templatePage.indexOf('supplier_') > -1){
        	var supplierId = queryString.query.templatePage.substring(queryString.query.templatePage.indexOf('supplier_') + 9);
        	supplier.fieldname = "shop_id";
        	supplier.valuefrom = supplierId;
        }
        var i = parseInt(_this.substr(13));
        var id = $(_this).attr('id');
        var obj = {"fieldname": "","valuefrom": ""};
        if(generalProSelectCon[id] && !flag){//回显的数据
          $$("#selectBy").val(generalProSelectCon[id].selectBy);
          var proxy = cb.rest.DynamicProxy.create({
              PendantInfo: { url: 'client/Products/getPendantInfo', method: 'GET' }
          });
          proxy.PendantInfo(function (err, result) {
              if ($$("#selectBy").val() == "type") {
                  var html = self.render($$('#typeDataTpl').html(), { type: result.typeList });
                  $$('#flitertype').html(html);
              } else if ($$("#selectBy").val() == "category") {
                  var html = self.render($$('#categoryDataTpl').html(), { category: result.classList });
                  $$('#flitertype').html(html);
              } else if ($$("#selectBy").val() == "area"){
                  var html = self.render($$('#areaDataTpl').html(), { arealist: result.arealist });
                  $$('#flitertype').html(html);
              }else{
              	  var html = self.render($$('#brandDataTpl1').html(), { brand: result.brandList });
                  $$('#flitertype').html(html);
              }
          $$("#filterValue").val(generalProSelectCon[id].filterValue);
          $$("#productkeyword").val(generalProSelectCon[id].productkeyword);
          switch ($$("#selectBy").val()) {
            case "type":
                obj.fieldname = "type_id";
                obj.valuefrom=$$("#filterValue").val();
                break;
            case "brand":
                obj.fieldname = "brand_id";
                obj.valuefrom=$$("#filterValue").val();
                break;
            case 'category':
                obj.fieldname = "categoryid";
                obj.valuefrom=$$("#filterValue").val();
                break;
            case 'area':
                obj.fieldname = "area_id";
                obj.valuefrom=$$("#filterValue").val();
                break;
            
        }
    	var keyword = {"fieldname": "keyword","valuefrom": $$("#productkeyword").val()};
    	if($$('.goodClass').val()=="general"){
    		productAttr = "1";
    	}else{
    		productAttr = "2";
    	}
    	var proattr = {"fieldname": "productAttribute","valuefrom": productAttr};
    	var postData = { pagesize: pagesize, pageindex: pageindex, where: []};
    	postData.where.push(obj);
    	postData.where.push(proattr);
    	postData.where.push(keyword);
    	postData.where.push(supplier);
    	var proxy = cb.rest.DynamicProxy.create({
            getProductList: { url: 'client/Products/getProductList', method: 'POST' }
        });
        proxy.getProductList({ queryCondition: postData }, function (error, result) {
            if (error) {
                console.log("获取商品列表失败！");
                return;
            };
            var html = self.render($$('#pageDataTpl').html(), { productlist: result.data });
            $$('#pageData').html(html);
            if(tabPageGeneralData[id]){
            	for (i = 0; i < tabPageGeneralData[id].length; i++) {
                    productId = tabPageGeneralData[id][i];
                    for (j = 0; j < $$('.listData').length; j++) {
                        if (productId == $$($$('.listData')[j]).attr("id")) {
                          $$('.listData')[j].checked = "true";
                    	}
               		 }
           		}
            }else{
            	tabPageGeneralData[id] = [];
            }
            $$('.listData').change(function (e) {
            	if(!tabPageGeneralData.hasOwnProperty(id)){
                tabPageGeneralData[id] = [];
                }
                if (e.target.checked) {
                    tabPageGeneralData[id].push(e.target.id);
                } else {
                    for (i = 0; i < tabPageGeneralData[id].length; i++) {
                        if (tabPageGeneralData[id][i] == e.target.id) {
                            tabPageGeneralData[id].removeAt(i);
                        }
                    }
                }
            });
            if (callback)
                callback(result);
        });
          });
        }else{
    	switch ($$("#selectBy").val()) {
            case "type":
                obj.fieldname = "type_id";
                obj.valuefrom=$$("#filterValue").val();
                break;
            case "brand":
                obj.fieldname = "brand_id";
                obj.valuefrom=$$("#filterValue").val();
                break;
            case 'category':
                obj.fieldname = "categoryid";
                obj.valuefrom=$$("#filterValue").val();
                break;
            case 'area':
                obj.fieldname = "area_id";
                obj.valuefrom=$$("#filterValue").val();
                break;
            
        }
    	var keyword = {"fieldname": "keyword","valuefrom": $$("#productkeyword").val()};
    	if($$('.goodClass').val()=="general"){
    		productAttr = "1";
    	}else{
    		productAttr = "2";
    	}
    	var proattr = {"fieldname": "productAttribute","valuefrom": productAttr};
    	var postData = { pagesize: pagesize, pageindex: pageindex, where: []};
    	postData.where.push(obj);
    	postData.where.push(proattr);
    	postData.where.push(keyword);
    	postData.where.push(supplier);
    	var proxy = cb.rest.DynamicProxy.create({
            getProductList: { url: 'client/Products/getProductList', method: 'POST' }
        });
        proxy.getProductList({ queryCondition: postData }, function (error, result) {
            if (error) {
                console.log("获取商品列表失败！");
                return;
            };
            var html = self.render($$('#pageDataTpl').html(), { productlist: result.data });
            $$('#pageData').html(html);
            if(tabPageGeneralData[id]){
            	for (i = 0; i < tabPageGeneralData[id].length; i++) {
                    productId = tabPageGeneralData[id][i];
                    for (j = 0; j < $$('.listData').length; j++) {
                        if (productId == $$($$('.listData')[j]).attr("id")) {
                          $$('.listData')[j].checked = "true";
                    	}
               		 }
           		}
            }else{
            	tabPageGeneralData[id] = [];
            }
            $$('.listData').change(function (e) {
            	if(!tabPageGeneralData.hasOwnProperty(id)){
                tabPageGeneralData[id] = [];
                }
                if (e.target.checked) {
                    tabPageGeneralData[id].push(e.target.id);
                } else {
                    for (i = 0; i < tabPageGeneralData[id].length; i++) {
                        if (tabPageGeneralData[id][i] == e.target.id) {
                            tabPageGeneralData[id].removeAt(i);
                        }
                    }
                }
            });
            if (callback)
                callback(result);
        });
        }
    };
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        if(instance.getId().indexOf('*' )> -1){
        	widgetname = instance.getId().substr(0,instance.getId().indexOf('*'));
        }else{
        	widgetname = instance.getId();
        }
        
        NewConfig = instance.getConfig();  //兼容用户之前设置的商品
        if(!Array.isArray(NewConfig)){
        	NewConfig.id = 0;
        	NewConfig = [{'configs':NewConfig}];
        }
        //此处NewConfig为一个数组  格式[{configs:{}}]
		    NewConfig.forEach(function(item,index){
		    	configTabCount.push(item.configs.id);
		    	var tabPageIndex = '.tab_page:eq('+index+')';
		        if ((item.configs.filter.length == 2 || item.configs.filter.length == 5) && item.configs.goodStyle == '0') {  //普通商品, 新增filter 变为5  兼容之前  不能改变
		            tabPageGeneralData[item.configs.id] = item.configs.filter[0].valuefrom.split(",");
		            if(item.configs.filter[2]) //兼容之前设置
		              generalProSelectCon[item.configs.id] = {"selectBy":item.configs.filter[1].valuefrom,"filterValue":item.configs.filter[2].valuefrom,"productkeyword":item.configs.filter[3].valuefrom};
		        } else {
		            tabPageGeneralData[item.configs.id] = [];
		        }
		        //选择的团购商品
		        if(item.configs.filter.length == 5 && item.configs.goodStyle == '1'){
		        	tabPageGroupBuyingData[item.configs.id] = item.configs.filter[1].valuefrom.split(",");
		        }else{
		        	tabPageGroupBuyingData[item.configs.id] = [];
		        }
		        //选择的秒杀商品
		        
		        if(item.configs.filter.length == 7){
		          tabPageSecKillData[item.configs.id] = item.configs.filter[1].valuefrom.split(",");        	
		        }else{
		          tabPageSecKillData[item.configs.id] = [];
		        }
		        this.proxyData = {
		            pagesize: 5,
		            pageindex: 1
		        }
		        if (item.configs.filter.length) {
		            for (var i = 0, len = item.configs.filter.length; i < len; i++) {
		                if (item.configs.filter[i].fieldname === 'goods_id' || item.configs.filter[i].fieldname === 'groupbuyingdetails_id' || item.configs.filter[i].fieldname === 'secKillbuyingdetails_id') {
		                    item.configs.isAccurate = true;
		                    isAccurate[index] = true;
		                    break;
		                } else {
		                    item.configs.isAccurate = false;
		                    isAccurate[index] = false;
		                }
		            }
		            
		            for (var i = 0, len = item.configs.filter.length; i < len; i++) {
		                //判断是否是入口
		                if(item.configs.filter[i].fieldname === 'moreLink' && item.configs.filter[i].valuefrom){
		                	isEnter = true;
		                	item.configs.isEnter = true;
		                	moreLink[index] = item.configs.filter[i].valuefrom + '_M.html';
		                	break;
		                }else{
		                	item.configs.isEnter = false;
		                }
		            }
		        }
		        var proxyConfig = {
		            getPendantInfo: { url: 'client/Products/getPendantInfo', method: 'GET' }
		        };
		        mergeProxy = cb.rest.MergeProxy.create();
		        mergeProxy.add(proxyConfig['getPendantInfo'], {}, function (err, result) {
		            item.configs.tag = result.taglist;
		            item.configs.brand = result.brandList;
		            item.configs.type = result.typeList;
		            item.configs.category = result.classList;
		            item.configs.arealist = result.arealist;
		            //item.configs.arealist = [{name:'北京',id:1},{name:'重庆',id:2},{ name:'西安',id:11}]  //模拟数据
		        });
				mergeProxy.submit(function () {
		            callback(NewConfig);
		            self.initconfig();
		        });
		        $('.widgetconfig')[0].style.overflowY = 'auto';
		    });
		    tabCount = Math.max.apply(null,configTabCount) + 1;
    };
    widget.prototype.initconfig = function () {
    	var self = this;
    	var _goodClass = NewConfig[0].configs.goodclass || 'general';
        var proxy = cb.rest.DynamicProxy.create({ //初始化的时候  应该重新调用新的API
            editVersion: {url: 'corp/ProductClasses/getClassesByClassType',method: 'POST'}
        });
        proxy.editVersion({ classType: _goodClass}, function (err, result) {
            var html = self.render($$('#categoryDataTpl').html(), { category: result });
            $$('.category').html(html);
	          NewConfig.forEach(function(item,index){
		       if (item.configs.filter && item.configs.filter.length == 18) {
		            $(".type option[value='" + item.configs.filter[0].valuefrom + "']").eq(index).attr("selected", true);
		            $(".category option[value='" + item.configs.filter[3].valuefrom + "']").eq(index).attr("selected", true);
		            $(".tag option[value='" + item.configs.filter[5].valuefrom + "']").eq(index).attr("selected", true);
		            $(".brand option[value='" + item.configs.filter[4].valuefrom + "']").eq(index).attr("selected", true);
		            $(".area option[value='" + item.configs.filter[16].valuefrom + "']").eq(index).attr("selected", true);
		        }
		        if (item.configs.displayMode != null) {
		            $$("#showstyle").val(item.configs.displayMode);
		        }
		        if (item.configs.goodStyle != null) {
		            $$("#productStyle").val(item.configs.goodStyle);
		        }else{
		            item.configs.goodStyle = '0';
		        }
		        if (item.configs.groupselect != null) {
		        }else{
		            item.configs.groupselect = '0';
		        }
		        if (item.configs.showname != "initial") {
		            $('input[name=name]').eq(index).attr("checked", false);
		        }
		        if (item.configs.showprice != "initial") {
		            $('input[name=price]').eq(index).attr("checked", false);
		        }
		        if (item.configs.showsale != "initial") {
		            $('input[name=sale]').eq(index).attr("checked", false);
		        }
		        if (item.configs.order != null) {
		            $$(".iorder").eq(index).val(item.configs.order[0].fieldname);
		            $$(".adesc").eq(index).val(item.configs.order[0].direction);
		        }
		        if (NewConfig.displayMode != null) {
		            $$(".adesc").eq(index).val(item.configs.order[0].direction);
		        }
		        $$(".goodClass").val(item.configs.goodclass);
		        self.switchPointerStyle(item.configs.goodclass);
		        for(var i in item.configs.filter){
		            switch(item.configs.filter[i].fieldname){
		                case 'timeCondition':
		                   timeCondition = item.configs.filter[i].valuefrom;
		                break;
		                case 'timeUnit1':
		                   timeUnit1 = item.configs.filter[i].valuefrom;
		                break;
		                case 'timeUnit2':
		                   timeUnit2 = item.configs.filter[i].valuefrom;
		                break;
		                case 'groupSuccType':
		                   groupSuccType = item.configs.filter[i].valuefrom;
		                break;
		                case 'time1':
		                   time1 = item.configs.filter[i].valuefrom;
		                break;
		                case 'time2':
		                   time2 = item.configs.filter[i].valuefrom;
		                break;
		            }
		        }
		        self.initWebStyle(item.configs,'.tab_page:eq('+index+')');
	            self.initGroupStyle(timeCondition,timeUnit1,timeUnit2,groupSuccType,time1,time2,'.tab_page:eq('+index+')');
			});
        });
		if(NewConfig.length == 1){
			$('.tabName').closest('li').hide();
		}else{
			$('.tabName').closest('li').show();
		}
    };
    /********初始化的时候通过判断是团购还是普通商品进行一些功能的显示和隐藏****/
    widget.prototype.initWebStyle = function (param,_this) {
    	var id = $(_this).attr('id');
    	if(param.tabPageName)
    	  $(_this+' .tabName').val(param.tabPageName);
        if (param.goodStyle == '0') {
    		$(_this+' .selectGroup').css({'display':'none'});
    		$('.bShowGoodClass').css({ 'display': 'block' });
    		$(_this+" .secondKillShowStyle").css({ 'display': 'none' });
			$('#displayPhoto').css({'display':'block'});
      		$(_this+' .classifyProduct').css({'display':'block'});
            $(_this+' .showParameter').css({'display':'block'});
            $(_this+' .goodSelect [data-type="accurate"]').css({'display':'block'});
    	}
    	if (param.goodStyle == '1') {
    		$(_this+' .classifyProduct').css({'display':'none'});
    		$(_this+' .selectGroup').css({ 'display': 'block' });
    		$(_this+" .secondKillShowStyle").css({ 'display': 'none' });
            $('.bShowGoodClass').css({'display':'none'});
            $(_this+' .showParameter').css({'display':'none'});
            $('#displayPhoto').css({'display':'none'});
            if (param.groupselect == '0') {
                $(_this+' .classifyProduct').css({'display':'block'});
                $(_this+' .selectCondition').attr('checked',true);
                $(_this+' .selectPrecise').removeAttr('checked');
    			$(_this+' .timecondition').css({'display':'block'});
    			$(_this+' .peoplecondition').css({'display':'block'});
                $(_this+' .goodSelect [data-type="range"]').css({'display':'block'});
                $(_this+' .goodSelect [data-type="accurate"]').css({'display':'none'});
                $("#tab1"+id).addClass('active');
                $("#tab2"+id).removeClass('active');
                if(param.goodclass == 'points'){
                    $(_this+' .points').css({'display':'block'});
                    $(_this+' .general').css({'display':'none'});
                    $(_this+' .points0').css({'display':'block'});
                    $(_this+' .general0').css({'display':'none'});
                    $(_this+' .iorder').val('salePoints');
                }else if(param.goodclass == 'general'){
                    $(_this+' .points').css({'display':'none'});
                    $(_this+' .general').css({'display':'block'});
                    $(_this+' .points0').css({'display':'none'});
                    $(_this+' .general0').css({'display':'block'});
                }
                $(_this+' .iorder option[value=iSales7]').css({'display':'none'});//根据不同的展现方式显示不同的排序规则
                $(_this+' .iorder option[value=iSales30]').css({'display':'none'});

            }else{
                $(_this+' .selectCondition').removeAttr('checked');
                $(_this+' .selectPrecise').attr('checked',true);
                $(_this+' .timecondition').css({'display':'none'});
                $(_this+' .peoplecondition').css({'display':'none'});
                $(_this+' .classifyProduct').css({'display':'none'});
            }
    	}
    	
    	//秒杀
    	if (param.goodStyle == '2') {
    		$(_this+' .classifyProduct').css({'display':'none'});
          	$(_this+' .selectGroup').css({'display':'block'});
          	$('.bShowGoodClass').css({ 'display': 'none' });
          	$(_this+" .secondKillShowStyle").css({ 'display': 'block' });
            $(_this+' .showParameter').css({'display':'none'});
            $('#displayPhoto').css({'display':'none'});
            $(_this+' .peoplecondition').css({'display':'none'});
            if(param.groupselect == '0'){
                $(_this+' .classifyProduct').css({'display':'block'});
                $(_this+' .selectCondition').attr('checked',true);
                $(_this+' .selectPrecise').removeAttr('checked');
    			$(_this+' .timecondition').css({'display':'block'});
                $(_this+' .goodSelect [data-type="range"]').css({'display':'block'});
                $(_this+' .goodSelect [data-type="accurate"]').css({'display':'none'});
                $("#tab1"+id).addClass('active');
                $("#tab2"+id).removeClass('active');
                if(param.goodclass == 'points'){
                    $(_this+' .points').css({'display':'block'});
                    $(_this+' .general').css({'display':'none'});
                    $(_this+' .points0').css({'display':'block'});
                    $(_this+' .general0').css({'display':'none'});
                    $(_this+' .iorder').val('salePoints');
                }else if(param.goodclass == 'general'){
                    $(_this+' .points').css({'display':'none'});
                    $(_this+' .general').css({'display':'block'});
                    $(_this+' .points0').css({'display':'none'});
                    $(_this+' .general0').css({'display':'block'});
                }
               $(_this+' .iorder option[value=iSales7]').css({'display':'none'});//根据不同的展现方式显示不同的排序规则
               $(_this+' .iorder option[value=iSales30]').css({'display':'none'});
            }else{
                $(_this+' .selectCondition').removeAttr('checked');
                $(_this+' .selectPrecise').attr('checked',true);
                $(_this+' .timecondition').css({'display':'none'});
                $(_this+' .classifyProduct').css({'display':'none'});
            }
            if(param.isEnter){    //初始化入口操作
                	$(_this+' .showStyle_enter').trigger('click');
                	$(_this+' .showStyle_list').removeAttr('checked');
                	$(_this+' .showStyle_enter').attr('checked',true);
                	$(_this+' .moreLink').closest('li').show();
            }
    	}
    }
    /******积分换购和现金购买切换的时候显示的控制****/
    widget.prototype.switchPointerStyle = function(goodClassparam){
        if(goodClassparam=="points"){
            $$('.points').css({'display':'block'});
            $$('.general').css({'display':'none'});
            $$('.points0').css({'display':'block'});
            $$('.general0').css({'display':'none'});
        }else{
            $$('.points').css({'display':'none'});
            $$('.general').css({'display':'block'});
            $$('.points0').css({'display':'none'});
            $$('.general0').css({'display':'block'});
        }
    }
    /***********团购活动初始化的界面显示*********/
    widget.prototype.initGroupStyle = function(timeCondition,timeUnit1,timeUnit2,groupSuccType,time1,time2,_this){
        switch(timeCondition){
            case '1':
                $(_this+' .startTimecondition').attr('checked',true);
                $(_this+' .inputstart').val(time1);
                this.jsSelectItemByValue($(_this+' .starttimeselect')[0],timeUnit1);
            break;
            case '2':
                $(_this+' .endTimecondition').attr('checked',true);
                $(_this+' .inputend').val(time2);
                this.jsSelectItemByValue($(_this+' .endtimeselect')[0],timeUnit2);
            break;
            case '3':
                $(_this+' .ending').attr('checked',true);
            break;
            case '4':
                $(_this+' .allgroup').attr('checked',true);
            break;
        };
        switch(groupSuccType){
            case '0':
                $(_this+' .fullpeople').attr('checked',true);
            break;
            case '1':
                $(_this+' .fullnumber').attr('checked',true);
            break;
            case '2':
                $(_this+' .fullAll').attr('checked',true);
            break;
        }
    }
    /******判断哪个option应该被选中***/
    widget.prototype.jsSelectItemByValue = function(objSelect, objItemText){
        var isExit = false;
        for (var i = 0; i < objSelect.options.length; i++) {
            if (objSelect.options[i].value == objItemText) {
                objSelect.options[i].selected = true;
                isExit = true;
                break;
            }
        }
    }
    return widget;
});
