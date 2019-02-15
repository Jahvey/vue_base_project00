cb.widgets.register('MagicBox', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
        this.init();
        var self = this;
        this.getElement().click(function (e) {
            if (!self._get_data('hasClicked')) {
                if(self.designer){
                    self.getElement().css('min-height', '314px');
                    self._set_data('hasClicked', true);
                    self.initData.boxHeight = 314;
                    self.desingerStatusInit(self.initData);
                    self.removeHerf();
                }
            } else {
                e.stopImmediatePropagation();
            }
        });
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.proxy = cb.rest.DynamicProxy.create({
        getMemberByToken: { url: 'member/Members/getMemberByToken', method: 'POST', options: { token: true} },
        saveInfo: { url: 'member/Members/save', method: 'POST', options: { token: true} }
    });
    widget.prototype.processTemplate = function (item, config) {
        if (!item.startX && item.startX != 0 || !item.startY && item.startY != 0) return;
        var key = item.startX + '_' + item.startY + '_' + item.nX + '_' + item.nY;
        item.id = key;
        config.map[key] = item;
        return key;
    };
    widget.prototype.runTemplate = function (error, result) {
        var config = this.getConfig();
        config.map = {};
        var self = this;
        this.config = config;
        this.coefficient = this.getCoefficient();
        //配置id
        if (config.imagedata) {
            config.imagedata.forEach(function (item) {
                self.processTemplate(item, config);
            });
            this.drawImageByDiv(config.imagedata);
        }
    };
    widget.prototype.getCoefficient = function () {
        return this.getElement().width()/312;
        /*1iw，默认1*/
        // return 1;
    };
    widget.prototype.IsPC = function () {
        var userAgentInfo = navigator.userAgent;
        var Agents = ["Android", "iPhone","SymbianOS", "Windows Phone","iPad", "iPod"];
        var flag = true;
        for (var v = 0; v < Agents.length; v++) {
            if (userAgentInfo.indexOf(Agents[v]) > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    };
    widget.prototype.drawImageByDiv = function (datas) {
        var self = this;
        var maxHeight = 0;
        for (var i = 0; i < datas.length; i++) {
            var data = datas[i];
            if(!data.nX) continue;
            var parentSection = self.getElement().find(".section-border_" + data.id);
            if (parentSection.hasClass("section-border-none")) continue;
            if (!parentSection.length) {
                var initData = self.initData;
                var config = self.getConfig();
                var createDelSectionInner = function (point) {
                    var $div = $('<div class="section-border " data-id=' + point.id + '></div>');
                    var width = point.nX * initData.rectWidth * self.coefficient;
                    var height = point.nY * initData.rectHeight * self.coefficient;
                    var left = point.startX * initData.rectWidth * self.coefficient;
                    var top = point.startY * initData.rectHeight * self.coefficient;
                    $div.css({ left: left+'px', top: top+'px', width: width+'px', height: height+'px' });
                    if (maxHeight < top + height)
                        maxHeight = top + height;
                    $div.addClass("section-border_" + point.id);
                    if(!self._get_data("isDesingerStatus")){
                        $div.addClass("section-border-none");
                    };
                    $div.html('<div class="del" ></div>');
                    self.getElement().find(".MagicBox").append($div[0]);
                    parentSection = $div;
                };
                createDelSectionInner(data);
            }
            var imgObj = document.createElement("img");
            var aObj = document.createElement("a");
            if(!self.designer){
                aObj.href = data.href;
            };
            if(data.href.match(/[a-zA-z]+:\/\/[^\s]*/i)){
                $(aObj).addClass("external")
            };
            imgObj.src =cb.util.adjustImgSrc(data.url);
            aObj.style.display = "inline-block";
            imgObj.style.display = "inline-block";
            aObj.style.position = "absolute";
            var pData = {
                iLeft: data.startX * self.initData.rectWidth * self.coefficient,
                iTop: data.startY * self.initData.rectHeight * self.coefficient,
                iWidth: data.nX * self.initData.rectWidth * self.coefficient,
                iHeight: data.nY * self.initData.rectHeight * self.coefficient
            };
            imgObj.style.width = aObj.style.width = pData.iWidth  + "px";
            imgObj.style.height = aObj.style.height = pData.iHeight  + "px";
            $(aObj).append(imgObj);
            if (this.upContext)
                this.upContext.clearRect(pData.iLeft - 1, pData.iTop - 1, pData.iWidth + 2, pData.iHeight + 2);
            if(data.href){
            	parentSection.append(aObj);
            }else{  //修复自由设计模块二维码不能识别的问题
            	parentSection.append(imgObj);
            }
        };
        self.getElement().css('height', maxHeight + 'px');
    };
    widget.prototype.removeHerf = function (){
        var aDom = this.getElement().find(".MagicBox").find(".section-border a");
        for(var i = 0 ;i<aDom.length; i++){
            $(aDom[i]).removeAttr("href");
        }
    };
    widget.prototype.createDelSection = function (initData, config) {
        var self = this;
        var createDelSectionInner = function (point) {
            var $div = $('<div class="section-border " data-id=' + point.id + '></div>');
            var width = point.nX * initData.rectWidth + "px";
            var height = point.nY * initData.rectHeight + "px";
            var left = point.startX * initData.rectWidth + "px";
            var top = point.startY * initData.rectHeight + "px";
            $div.css({ left: left, top: top, width: width, height: height });
            $div.addClass("section-border_" + point.id);
            $div.html('<div class="del" ></div>');
            $(self.getElement()[0]).find(".MagicBox").append($div);
            self.delSectionEvent(initData, config);
        };
        for (var i = 0; i < config.imagedata.length; i++) {
            if (!config.imagedata[i].id) {
                console.log("id不存在,by createDelSection");
                self.processTemplate(config.imagedata[i], config);  
            };
            var parentSection = self.getElement().find(".section-border_" + config.imagedata[i].id);
            if (parentSection.hasClass("section-border-none")) continue;
            createDelSectionInner(config.imagedata[i]);
        };
    };
    widget.prototype.delSectionEvent = function (initData, config){
        var self = this;
        self.getElement().find(".section-border").click(function (e) {
            if(self._get_data('hasClicked')){
                e.stopPropagation();
                self.getElement().find(".section-border").addClass("section-border-none");
                $(this).removeClass("section-border-none");
                var point = config.map[$(this).attr("data-id")];
                self.execute('dblClick', point);
            }
        });
        self.getElement().find(".del").click(function (e) {
            e.stopPropagation();
            var point = config.map[$(this).parent().attr("data-id")];
            if (!point) return;
            var width = point.nX * initData.rectWidth
            var height = point.nY * initData.rectHeight
            var startX = point.startX * initData.rectWidth
            var startY = point.startY * initData.rectHeight;
            var key = $(this).parent().attr("data-id");
            self.upContext.clearRect(startX - 1, startY - 1, width + 2, height + 2);
            delete config.map[key];
            for (var i = 0; i < config.imagedata.length; i++) {
                if (config.imagedata[i].id == key) {
                    config.imagedata.splice(i, 1);
                    break;
                };
            };
            $(this).parent().remove();
            self.execute("delImage", point, self.getId());
        });
    };
    widget.prototype.drawImage = function (datas, upContext) {
        //give up this method;图片onload异步处理问题
        var self = this;
        var imgObj = new Image();
        for (var i = 0; i < datas.length; i++) {
            var data = datas[i];
            imgObj.onload = function () {
                self.isImgLoad = false;
                var startX = data.startX * self.initData.rectWidth;
                var startY = data.startY * self.initData.rectHeight;
                var width = data.nX * self.initData.rectWidth;
                var height = data.nY * self.initData.rectHeight;
                upContext.clearRect(startX, startY, width, height);
                upContext.drawImage(imgObj, startX, startY, width, height);
            };
            imgObj.src = data.url;
        }
    };
    widget.prototype.desingerStatusInit = function (initData) {
        this.MagicBox = this.getElement();
        var config = this.getConfig();
        this.canvas = this.MagicBox.find(".canvas")[0];
        this.context = this.canvas.getContext("2d");
        this.upCanvas = this.MagicBox.find(".upCanvas")[0];
        this.upContext = this.upCanvas.getContext("2d");
        this.canvas.width = this.upCanvas.width = parseFloat(this.MagicBox.css("width"));
        this.canvas.height = this.upCanvas.height = 314;
        var boxHeight = parseInt(this.MagicBox.css("height"));
        var nX = parseInt(this.canvas.width / initData.rectWidth);
        var nY = parseInt(initData.boxHeight / initData.rectHeight);
        var point = { nX: nX, nY: nY, startX: 0, startY: 0 };
        this.drawMagicCubeBg(point);
        this.eventRegister(initData);
    };
    widget.prototype.drawMagicCubeBg = function (point) {
        for (var j = point.startY; j < point.nY; j++) {
            for (var i = point.startX; i < point.nX; i++) {
                this.drawRect(this.context, i * this.initData.rectWidth + 1, j * this.initData.rectHeight + 1, this.initData.rectWidth, this.initData.rectHeight, this.initData.rectFillColor,this.initData.rectBorderColor);
            }
        };
    };
    widget.prototype.drawRect = function (cxt, x, y, width, height, fillColor,rectBorderColor ) {
        cxt.lineWidth = this.initData.rectBorder;
        cxt.strokeStyle = rectBorderColor;
        cxt.fillStyle = fillColor;
        cxt.fillRect(x, y, width, height);
        cxt.strokeRect(x, y, width, height);
    };
    widget.prototype.drawMagicCubeup = function (point) {
        for (var i = point.startX; i < point.nX; i++) {
            for (var j = point.startY; j < point.nY; j++) {
                this.drawRect(this.upContext, i * this.initData.rectWidth, j * this.initData.rectHeight, this.initData.rectWidth, this.initData.rectHeight, this.initData.rectFillColorUp, this.initData.rectBorderColorUp);
            }
        };
    };
    widget.prototype.eventRegister = function (initData) {
        var self = this;
        var maxCoord = { nX: 0, nY: 0 };
        var isDesinger = false;
        var config = this.getConfig();
        var windowToCanvas = function (e) {
            var bbox = self.canvas.getBoundingClientRect()
            return { x: e.clientX - bbox.left, y: e.clientY - bbox.top }
        };
        var calculateMaxPoint = function (point) {
            if (point.nX < maxCoord.nX) {
                point.nX = maxCoord.nX;
            } else {
                point.nX >= 8 ? 8 : point.nX;
                maxCoord.nX = point.nX;
            };
            if (point.nY < maxCoord.nY) {
                point.nY = maxCoord.nY;
            } else {
                maxCoord.nY = point.nY;
            };
            return point;
        };
        var isNeedAddBoxHeight = function (point) {
            return (point.nY + 1) * initData.rectHeight > parseInt(self.getElement().css("height"));
        };
        var addBoxHeight = function (point) {
            var MagicBoxHeight = parseInt(self.getElement().css("height"));
            MagicBoxHeight += self.initData.rectHeight
            self.getElement().css({ "height": MagicBoxHeight + "px" });
            self.boxHeight = MagicBoxHeight;
            var nX = parseInt(self.canvas.width / self.initData.rectWidth);
            var nY = parseInt(self.boxHeight / self.initData.rectHeight);
            self.drawMagicCubeBg({ nX: nX, nY: nY, startX: 0, startY: nY - 1 });
            self.drawMagicCubeup(point);
        };
        var ignoreMinDistance = function (aPoint, context) {
            var minDistance = Math.sqrt(
                    (aPoint.x - context.startPoint.x) * (aPoint.x - context.startPoint.x) +
                    (aPoint.y - context.startPoint.y) * (aPoint.y - context.startPoint.y)
                );
            return minDistance < 5 ? true : false;
        };
        var minimizeMaxDistance = function(aPoint){
            var nX = aPoint.x / initData.rectWidth - parseInt(aPoint.x / initData.rectWidth) > 0.2
                    ? parseInt(aPoint.x / initData.rectWidth) + 1 : parseInt(aPoint.x / initData.rectWidth) ;
            var nY = aPoint.y / initData.rectHeight - parseInt(aPoint.y / initData.rectHeight) > 0.2
                    ? parseInt(aPoint.y / initData.rectHeight) + 1 : parseInt(aPoint.y / initData.rectHeight) ;
            return {nX:nX, nY:nY};
        };
        this.upCanvas.mouseleaveEvent = function (e) {
            if (isDesinger) return;
            var aPoint = windowToCanvas(e);
            if (ignoreMinDistance(aPoint, this)) return;
            var nX = minimizeMaxDistance(aPoint).nX; //最大距离计算,减少灵敏度
            var nY = minimizeMaxDistance(aPoint).nY;
            maxXY = calculateMaxPoint({ nX: nX, nY: nY });
            var selectSectionDataTemp = {
                startX: this.startX,
                startY: this.startY,
                nX: maxXY.nX - this.startX,
                nY: maxXY.nY - this.startY
            };
            config.map = config.map || {};
            config.imagedata.push(selectSectionDataTemp);
            config.imagedata.forEach(function (item) {
                self.processTemplate(item, config);
            });
            maxCoord = { nX: 0, nY: 0 };
        };
        this.upCanvas.onmousedown = function (e) {
            e.preventDefault();
            if (isDesinger && self.canvas.style.display == "none") {
                $(self.canvas).show();
                self.getElement().find(".section-border").addClass("section-border-none");
                setTimeout(function () {
                    isDesinger = false;
                }, 500);
                return;
            };
            this.isDown = true;
            var aPoint = windowToCanvas(e);
            this.startX = parseInt(aPoint.x / initData.rectWidth);
            this.startY = parseInt(aPoint.y / initData.rectHeight);
            this.startPoint = aPoint;
        };
        this.upCanvas.onmousemove = function (e) {
            if (!this.isDown) return;
            e.preventDefault();
            var aPoint = windowToCanvas(e);
            if (ignoreMinDistance(aPoint, this)) return;//最小距离计算,防止误操作
            var nX = minimizeMaxDistance(aPoint).nX; //最大距离计算,减少灵敏度
            var nY = minimizeMaxDistance(aPoint).nY;
            maxXY = calculateMaxPoint({ nX: nX, nY: nY });
            var point = { nX: maxXY.nX, nY: maxXY.nY, startX: this.startX, startY: this.startY };
            //isNeedAddBoxHeight(point);
            if (false) {
                addBoxHeight(point)
            } else {
                self.drawMagicCubeup(point);
            };
        };
        this.upCanvas.onmouseup = function (e) {
            if (!this.isDown) return;
            e.preventDefault();
            this.isDown = false;
            this.mouseleaveEvent(e);
        };
        this.upCanvas.onmouseout = function (e) {
            e.preventDefault();
            if (!this.isDown) return;
            this.isDown = false;
            this.mouseleaveEvent(e);
        };
        var findCurrentSelectSection = function (e) {
            var aPoint = windowToCanvas(e);
            var section = {};
            pointX = parseInt(aPoint.x / initData.rectWidth) + 1;
            pointY = parseInt(aPoint.y / initData.rectHeight) + 1;
            if (config.imagedata) {
                for (var i = 0; i < config.imagedata.length; i++) {
                    var item = config.imagedata[i];
                    var inX = item.startX < pointX && (item.startX + item.nX + 1) > pointX;
                    var inY = item.startY < pointY && (item.startY + item.nY + 1) > pointY;
                    if (inX && inY) {
                        section = item;
                        break;
                    };
                };
                return section;
            };
        };
        $(this.upCanvas).on("dblclick", function (e) {
            isDesinger = true;
            var selectSection = findCurrentSelectSection(e);
            $(self.canvas).hide();
            setTimeout(function () {
                self.createDelSection(initData, config);
                self.execute('dblClick', selectSection);
            }, 100);
        });
        self.delSectionEvent(initData,config)
    };
    widget.prototype.init = function () {
        this.MagicBox = this.getElement();
        this.initData = {
            rectWidth: 39,
            rectHeight: 39,
            rectBorder: 0,
            rectBorderColor: "#353535",
            rectFillColor: "#fff",
            rectFillColorUp: "#fff",
            boxHeight: parseInt(this.MagicBox.css("height")),
            rectBorderColorUp:"blue"
        };
        //设计态标识
        this.designer = this.getConfig().designer;
        if(this.designer){
            //this.desingerStatusInit(this.initData);
        };
    };
    return widget;
});