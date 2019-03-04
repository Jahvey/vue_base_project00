cb.views.register('LoginViewController', function (controllerName) {
    var view = function (widgets) {
        cb.views.BaseView.call(this, widgets);
    };
    view.prototype = new cb.views.BaseView();
    view.prototype.controllerName = controllerName;

    view.prototype.login = function (options) {
        if ($$('.popup-prodSUK').hasClass('modal-in')) {
            myApp.closeModal('.popup-prodSUK');
        }
        $$('.popup-overlay').removeClass('modal-overlay-visible');
    	this.getAccountInfor();
        this._set_data('options', options);
        cb.rest.ContextBuilder.removeToken();
        delete cb.rest.AppContext.token;
        myApp.loginScreen(".login-screen.login");
    };

    view.prototype.init = function (callback) {
        var self = this;
        var $parent = this.getView().parents('.login-screen.login');
        this.registerEvent($parent, 'open');
        this.registerEvent($parent, 'opened');
        this.registerEvent($parent, 'close');
        this.registerEvent($parent, 'closed');       
        $$('#login_pwd').val('');
        $$('#login_uname').val('');
        $$('.list-onOff').children('i').removeClass('icon-loginclear').addClass('icon-dropdown');
        $$('#mylogin').find('span.list-onOff').on('click', function () {
            if ($$(this).children('i').hasClass('icon-dropdown')) {
                $$(this).children('i').removeClass('icon-dropdown').addClass('icon-dropup');
                $$(this).parent().children('div.list-login').show();
            } else if ($$(this).children('i').hasClass('icon-dropup')) {
                $$(this).children('i').removeClass('icon-dropup').addClass('icon-dropdown');
                $$(this).parent().children('div.list-login').hide();
            } else if ($$(this).children('i').hasClass('icon-loginclear')) {
                if ($$('#mylogin .list-login ul').children('li').length != 0) {
                    $$(this).children('i').removeClass('icon-loginclear').addClass('icon-dropdown');
                    $$(this).parent().children('div.list-login').hide();
                } else {
                    $$(this).hide();
                }
                $$('#mylogin').find('input').val('');
            }
        });
        $$("#cancel_login").on('click', function () {
            myApp.closeModal('.login-screen.modal-in');
            //if (loginView == 'view-3' || loginView == 'view-4') {
            if (myApp.mainView.container.id == 'categoryView') {
                $$('.toolbar.tabbar.homeNavBar').removeClass('toolbar-hidden');
                $$('#categoryView').trigger('show');
            } else if (myApp.mainView.container.id !== 'homeView') {
                $$('.toolbar.tabbar.homeNavBar').removeClass('toolbar-hidden');
                $$('#homeView').trigger('show');
            }
                
            callback();
            //$$('.views').children().removeClass('active');
            //$$('.view-main').addClass('active');
            //$$('.toolbar.tabbar.homeNavBar').removeClass('toolbar-hidden');
            //}
        });
        $$('#indexLogin').on('click', function (e) {
            self.loginClick(callback);
        });
        $$('.forgetPwd').on('click', function () {
            myApp.closeModal('.login-screen.modal-in');
            $$('.views').children().removeClass('active');
            $$('.view-main').addClass('active');
            myApp.mainView.router.loadPage({
                url: 'forgetPwd'
            });
        });
        $$('.registerBtn').on('click', function () {
            $$('.views').children().removeClass('active');
            $$('.view-main').addClass('active');
            myApp.mainView.router.loadPage({
                url: 'register'
            });
            myApp.closeModal('.login-screen.modal-in');
        });
    };

    view.prototype.registerEvent = function (modal, type) {
        var self = this;
        modal.on(type, function () {
            var options = self._get_data('options');
            if (options && typeof options[type] === 'function')
                options[type]();
        });
    };

    //获取多账户的登录信息
    view.prototype.getAccountInfor = function () {
        if (cb.util.localStorage.getItem('login_photo') && cb.util.localStorage.getItem('login_photo') != "undefined") {
            var photoStr = cb.util.localStorage.getItem('login_photo');
            $$('.login-avatar').children('img').attr('src', cb.util.adjustImgSrc(photoStr));
        } else {
            $$('.login-avatar').children('img').attr('src', '../../img/avatar.png');
        }
        if (cb.util.localStorage.getItem('accountList')) {
            var accoutStr = cb.util.localStorage.getItem('accountList').split('|');
            $$('#mylogin .list-login ul').children().remove();
            for (var i = 0; i < accoutStr.length; i++) {
                if (!accoutStr[i]) continue;
                var li = '<li><span class="accountItem">' + accoutStr[i] + '</span><span class="value-clear"><i class="icon icon-loginclear"></i></span></li>';
                $$('#mylogin .list-login ul').append(li);
            }
        }
        if ($$('#mylogin .list-login ul').children('li').length == 0) {
            $$('#mylogin .list-onOff').children('i').removeClass('icon-dropdown').addClass('icon-loginclear').hide();

        }
        $$('#mylogin input[name="username"]').keyup(function () {
            $$('#mylogin .list-onOff').children('i').removeClass('icon-dropdown').addClass('icon-loginclear');
            if ($$(this).val()) {
                $$('#mylogin').find('span.list-onOff').show();
                $$('#mylogin').find('span.list-onOff').children().show();
            } else {
                $$('#mylogin').find('span.list-onOff').children().hide();
            }
        });
        //清除账户信息
        $$('#mylogin .list-login span.value-clear').on('click', function (e) {
            var txt = $$(this).parent().children('.accountItem').text();
            var accountStr = cb.util.localStorage.getItem('accountList');
            if (accountStr.indexOf(txt) >= 0) {
                cb.util.localStorage.setItem('accountList', accountStr.replace(txt, ''));
                $$(this).parent().remove();
            }
            $$('#login_pwd').val('');
            $$('#login_uname').val('');
            if ($$('#mylogin .list-login li').length == 0) {
                $$('#mylogin .list-login').hide();
                $$('#mylogin').find('span.list-onOff').children('i').removeClass('icon-dropup').addClass('icon-dropdown');
            }
            e.stopPropagation();
        });

        $$('#mylogin .list-login li').on('click', function () {
            $$('#mylogin').find('input[name="username"]').val($$(this).children('span.accountItem').text());
            $$('#mylogin').find('input[name="password"]').val('');

            $$('#mylogin .list-login').hide();

            $$('#mylogin').find('span.list-onOff').children('i').removeClass('icon-dropup').addClass('icon-dropdown');
        });
    };

    //点击登陆调用的服务
    view.prototype.loginClick = function (callback) {
        var self = this;
        //myApp.showIndicator();
        var proxy = cb.rest.DynamicProxy.create({
            login: {
                url: 'client/MemberLogin/authenticate',
                method: 'POST',
                options: { mask: true }
            }
        });
        proxy.login({
            username: $$('#login_uname').val(),
            password: $$('#login_pwd').val()
        }, function (err, result) {
            //myApp.hideIndicator();
            if (err) {
                myApp.toast(err.message, 'error').show(true);
                return;
            };
            try {
                cb.rest.ContextBuilder.setToken(result.token);
                cb.util.localStorage.setItem('accountList', $$('#login_uname').val());
                cb.util.localStorage.setItem('accountInfo', JSON.stringify(result));
                cb.rest.AppContext.token = result.token;
            }
            catch (e) {
                myApp.alert('您现在处于无痕模式，请先关闭无痕模式再试', '提示信息');
                return;
            }

            myApp.closeModal('.login-screen.login.modal-in');
            var options = self._get_data('options');
            if (options) {
                if (options.callback) {
                    options.callback();
                } else if (options.controller) {
                    cb.executeController(options.controller);
                } else {
                    //myApp.mainView.router.refreshPage();
                    myApp.mainView.router.reloadPage(myApp.mainView.url);
                }
            } else {
                //myApp.mainView.router.refreshPage();
                myApp.mainView.router.reloadPage(myApp.mainView.url);
            }
            if (callback) {
                callback();
            }
            
        });
    }

    return view;
});