cb.widgets.register('district', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;
    widget.prototype.NewConfig = '';
    /**
     * 运行模板
     */
    widget.prototype.runTemplate = function (error, result) {
        this.getElement().find('.i-city').click(function () {
            myApp.popup('.popup-districtStyle');
            $$('.popup-districtStyle').css('display','block');
        });
        if(cb.util.localStorage.getItem('Areatag')!=='null'){
            $$('.currentCitylocation').html(cb.util.localStorage.getItem('Areatag'));
        }else{
            this.getLocation();
        }
    };
    /**
     * 通过微信定位,定位到当前的所在城市
     */
    widget.prototype.getLocation = function () {
        var getLocationProxy = cb.rest.DynamicProxy.create({
            	getDefaultArea: { url: 'client/Areas/getDefaultArea', method: 'POST', options: { token: true } }
        }); 
        if (cb.config && cb.config.fromWechat) {
            wx.getLocation({
                type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
                success: function (res) {
                    var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                    var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                    var realparam = {
                        lng: longitude,
                        lat: latitude
                    };
                    getLocationProxy.getDefaultArea(realparam, function (err, result) {
                        if (err) {
                            myApp.toast(err.message, 'error').show(true);
                            return;
                        }else{
                            $$('.currentCitylocation').html(result.tag);
                        }
                    });
                },
                cancel: function (res) {
                    var realparam = {
                        lng: '',
                        lat: ''
                    };
                },
                fail: function (res) {
                    var realparam = {
                        lng: '',
                        lat: ''
                    };
                }
            });
        }else{
            $$('#currentCitylocation').html('北京');
        }
    };
    return widget;
});