designer.settings.register('image_text', function (widgetType) {
    var widget = function (instance) {
        designer.settings.BaseSetting.call(this, instance);
    };
    var NewConfig;
    var widgetname;
    var umEditor;
    widget.prototype = new designer.settings.BaseSetting();
    widget.prototype.widgetType = widgetType;
    widget.prototype.init = function (callback) {
        var self = this;
        var instance = self.getInstance();
        widgetname = instance.getId().substr(0, instance.getId().indexOf('*'));
        NewConfig = instance.getConfig();
        var proxy = cb.rest.DynamicProxy.create({
            getwidgetconfig: { url: '/remote', method: 'POST'}
        });
        proxy.getwidgetconfig({
            version: new cb.util.queryString().get('version') || '',
            iPageId: new cb.util.queryString().get('pagelistid'),
            serviceId:'restService',
            serviceParam:JSON.stringify({url:'csc-plat/client/Template/getwidgetconfig'}),
            jsonData:JSON.stringify({msgEntity:{orgPageId:NewConfig.orgPageId || instance.orgPageId}})
        }, function (err, result) {
            if (NewConfig == null) {
                var widgetconfig = JSON.parse(decodeURIComponent(result)).view.widget;
                for (i = 0; i < widgetconfig.length; i++) {
                    if (widgetconfig[i].$.name == widgetname) {
                        NewConfig = widgetconfig[i].config;
                    }
                }
            }
            callback(NewConfig);
        });
        $('.widgetconfig')[0].style.overflowY = 'initial';
    };
    widget.prototype.afterInit = function () {
        var self = this;
        var editorId = "myEditor" + Math.random().toString().substr(2);
        document.getElementsByClassName("upUeditor")[0].id = editorId;
        umEditor = UM.getEditor(editorId);
        umEditor.options.imageUrl = cb.rest._getUrl("remote/FileUpload/uploadeditor");
        umEditor.ready(function () {
            umEditor.execCommand("serverparam", 'type', 'image_text')
        });
        if (NewConfig[0] == "{") {
            umEditor.setContent(NewConfig.substring(11, NewConfig.length - 17));
        } else {
            if (typeof (NewConfig[0]) == "undefined") {
                umEditor.setContent(NewConfig.content);
            } else {
                umEditor.setContent(NewConfig[0]._);
            }
        }
        $(".submit").on("click", function () {
            NewConfig = [{ "_": '', "$": { "key": "content" } }];
            var htmlContent = umEditor.getContent().replace(/src=\"http.+\/pic/g,'src="/pic');
            NewConfig[0]._ = htmlContent;
            self.runTemplate(NewConfig);
        });
    };
    return widget;
});