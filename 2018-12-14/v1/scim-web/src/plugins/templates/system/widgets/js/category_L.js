cb.widgets.register('Category', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
        this.init();
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.init = function () {
        var config = this.getConfig();
        var $elem = this.getElement();
        var $ul = $elem.children('ul');
        if (config && config.show === 'true') {
            $ul.show();
            return;
        }
        $elem.children('div').hover(function () {
            $ul.show();
        }, function () {
            $ul.hide();
        });
        $ul.hover(function () {
            $(this).show();
        }, function () {
            $(this).hide();
        });
    };
    widget.prototype.getProxyData = function () {
        var queryString = new cb.util.queryString();
        if(location.href.indexOf('supplier_') > -1 || queryString.get('shop_id')){
        	var index = location.href.indexOf('supplier_');
        	var shop_id = queryString.get('shop_id') || location.href.substring(index+9);
        }
        return { shopId:shop_id};
    };
    widget.prototype.getProxy = function () {
        return { url: 'client/ProductClasses/getClasses?containsPointsClasses=true', method: 'POST' };
    };

    widget.prototype.runTemplate = function (error, result) {
        if (error || !result || !result.length) return;
        /**一行显示多个分类处理**/
        result = this.delCategoryToOneline(result)
        var queryString = new cb.util.queryString();
        if(location.href.indexOf('supplier_') > -1 || queryString.get('shop_id')){
        	var index = location.href.indexOf('supplier_');
        	var shop_id = queryString.get('shop_id') || location.href.substring(index+9);
        }
        var obj = {};
        var obj1 = {};
        result.forEach(function (item) {
            item.hasChildren = item.lsChildClass.length ? true : false;
            item.jsonId = String(item.id);
            obj[item.id] = item;
            item.shopId = shop_id;
            if(item.hasChildren){
            	item.lsChildClass.forEach(function(item1){
            		item1.hasChildren = item1.lsChildClass.length ? true : false;
            		obj1[item1.id] = item1;
            	});
            }
        });
        var $ul = this.getElement().children('ul');
        var html = this.render({ list: result });
        $ul.html(html);
        //this.execute('afterInit', $ul.height());
        $ul.children('li').hover(function () {
            var $this = $(this);
            $this.children("p").css({
                "background-color": "#fff",
                "border-right": "1px solid #ffffff"
            });
            if (!obj[$this.attr('data-id')].hasChildren) return;
            $this.children('div').show();
            if($this.children('div').length == 2){ //有推荐分类
            	$this.children('div').eq(0).css({'border-right': 'none'});
            	$this.children('div').eq(1).css({'border-left': 'none'});
            }
        }, function () {
            var $this = $(this);
            $this.children("p").css({
                "background-color": "transparent",
                "border-right": "1px solid #ffffff"
            });
            if (!obj[$this.attr('data-id')].hasChildren) return;
            $this.children('div').hide();
        });
        //// ������ⱳ����ɫ
        //$("div[data-type='Category']").css("background-color", "#31708f");
        //$("div[data-type='Category']").find(".header").css("background-color", "#31708f");
        //// �������������ɫ
        //$("div[data-type='Category']").find(".header").css("color", "#494848");
    };
    
    //PC端 一行显示多个分类处理
    widget.prototype.delCategoryToOneline = function(result){
    	var obj = {};
    	var newArr = [];
    	result.forEach(function(item,index){
    		if(obj[item.iLineNum]){
    			obj[item.iLineNum].RecommendedClass = obj[item.iLineNum].RecommendedClass.concat(item.RecommendedClass); //推荐分类的显示顺序和行号没有关系，只和序号有关系,最多显示6个
    			obj[item.iLineNum].RecommendedClass.sort(function(val1,val2){
    				return val1.iOrder - val2.iOrder;
    			}).splice(6);
    			if(obj[item.iLineNum].iOrder < item.iOrder){
    				if(String(obj[item.iLineNum].cName).length < 10){ //显示字数不超过10个字符，超出部分不显示
    				obj[item.iLineNum].cName = obj[item.iLineNum].cName.concat(item.cName);
    				obj[item.iLineNum].id = obj[item.iLineNum].id.concat(item.id);
    				}
    				obj[item.iLineNum].lsChildClass = obj[item.iLineNum].lsChildClass.concat(item.lsChildClass);
    			}else{
    				if(String(obj[item.iLineNum].cName).length < 10){ //显示字数不超过10个字符，超出部分不显示
	    				obj[item.iLineNum].cName = [item.cName].concat(obj[item.iLineNum].cName);
	    				obj[item.iLineNum].id = [item.id].concat(obj[item.iLineNum].id);
    				}
    				obj[item.iLineNum].lsChildClass = item.lsChildClass.concat(obj[item.iLineNum].lsChildClass);
    			}
    		}else{
    			if(item.iLineNum == 0){ //行号为0 默认值  独占一行
	    			obj[item.cCode] = item;
	    			obj[item.cCode].cName = [item.cName];
	    			obj[item.cCode].id = [item.id];
    			}else{
    				obj[item.iLineNum] = item;
    				obj[item.iLineNum].cName = [item.cName];
	    			obj[item.iLineNum].id = [item.id];
    			}
    		}
    	});
    	for(var i in obj){
    		newArr.push(obj[i]);
    	}
    	
    	return newArr;
    };

    return widget;
});