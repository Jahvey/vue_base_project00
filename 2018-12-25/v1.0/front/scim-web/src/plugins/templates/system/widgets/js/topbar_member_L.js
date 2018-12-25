cb.widgets.register('TopbarMember', function (widgetType) {
    var widget = function (id, options) {
        cb.widgets.BaseWidget.call(this, id, options);
    };
    widget.prototype = new cb.widgets.BaseWidget();
    widget.prototype.widgetType = widgetType;

    widget.prototype.getProxy = function () {
        return { url: '/client/Corprations/getCorpBaseMsg', method: 'GET' };
    };

    widget.prototype.runTemplate = function (error, result) {
        if (result && result.siteName) {
            var $span = this.getElement().children('span');
            $span.html($span.html() + result.siteName);
        }
        var nologinDiv = this.getElement().children('div').first();
        var loginDiv = this.getElement().children('div').last();
        loginDiv.children().last().click(function () {
            var proxy = cb.rest.DynamicProxy.create({ logout: { url: 'client/MemberLogin/logout', method: 'GET', options: { token: true}} });
            proxy.logout(function (err, result) {
                if (err) return;
                //localStorage.removeItem('userData');
                cb.data.CookieParser.delCookie('inviteCode');
                cb.data.CookieParser.delCookie('promotCode');
                cb.data.CookieParser.delCookie('isReplaceCustommer');
                delete cb.rest.AppContext.inviteCode;
                delete cb.rest.AppContext.promotCode;
                cb.data.CookieParser.delCookie('token');
                //nologinDiv.css('display', 'inline-block');
                //loginDiv.css('display', 'none');
                location.href = '/';
            });
        });
        var token = cb.rest.AppContext.token;
        var userName = cb.rest.AppContext.cUserName;
        if (userName == "undefined") {
            userName = cb.data.CookieParser.getCookie('cPhone');
        }
        var isReplaceCustommer = cb.data.CookieParser.getCookie('isReplaceCustommer');
        // 代客下单
        if (isReplaceCustommer == "2") {
            var userName = decodeURI(cb.rest.AppContext.cUserName);
            if (userName == "undefined") {
                userName = cb.data.CookieParser.getCookie('cPhone');
            }
        }
        if (!token) {
            nologinDiv.css('display', 'inline-block');
            if (userName) {
                var $login = nologinDiv.children().first();
                $login.html(userName + ', ' + $login.html());
            }
        } else {
            loginDiv.css('display', 'inline-block');
            loginDiv.children().first().html(userName);
        }
        
        //薪福社跳转自己的登录页面
        if(location.host == "dev-fuli2.xinfushe.com"){
        	$('#topbar_member a:first').attr('href','https://dev.xinfushe.com/fuli/empLogin/needKey?type=login');
        }
    };
    widget.prototype.refreshLogin = function (data, giftPromotion) {
        var nologinDiv = this.getElement().children('div').first();
        var loginDiv = this.getElement().children('div').last();
        loginDiv.children().last().click(function () {
            var proxy = cb.rest.DynamicProxy.create({ logout: { url: 'client/MemberLogin/logout', method: 'GET', options: { token: true } } });
            proxy.logout(function (err, result) {
                if (err) return;
                //localStorage.removeItem('userData');
                cb.data.CookieParser.delCookie('token');
                //nologinDiv.css('display', 'inline-block');
                //loginDiv.css('display', 'none');
                location.href = '/';
            });
        });
        var token = cb.rest.AppContext.token;
        var userName = cb.rest.AppContext.cUserName;
        if (userName == "undefined") {
            userName = cb.data.CookieParser.getCookie('cPhone');
        }
        if (!token) {
            nologinDiv.css('display', 'inline-block');
            loginDiv.css('display', 'none');
            if (userName) {
                var $login = nologinDiv.children().first();
                $login.html(userName + ', ' + $login.html());
            }
        } else {
            nologinDiv.css('display', 'none');
            loginDiv.css('display', 'inline-block');
            loginDiv.children().first().html(userName);
        }
    };
    return widget;
});