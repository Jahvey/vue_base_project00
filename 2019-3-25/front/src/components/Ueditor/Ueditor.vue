<template>
  <div>
    <script id="editor" type="text/plain"></script>
  </div>
</template>
<script>
  import '../../../static/plugins/ueditor/ueditor.config.js'
  import '../../../static/plugins/ueditor/ueditor.all.js'
  import '../../../static/plugins/ueditor/lang/zh-cn/zh-cn.js'
  import '../../../static/plugins/ueditor/ueditor.parse.js'

//  UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
//  UE.Editor.prototype.getActionUrl = function(action) {
//    if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
//      return '/ue/ueUpload';
//    } else if (action == 'uploadvideo') {
//      return 'http://a.b.com/video.php';
//    } else {
//      return this._bkGetActionUrl.call(this, action);
//    }
//  }


  export default {
    name: 'Ueditor',
    data () {
      return {
        editor: null
      }
    },
    props: {
      defaultMsg: {
        type: String
      },
      config: {
        type: Object
      }
    },
    mounted() {
      const _this = this;
//      Object.assign(this.config,configJson);
      this.editor = UE.getEditor('editor', this.config); // 初始化UE
      this.editor.addListener("ready", function () {
        _this.editor.setContent(_this.defaultMsg); // 确保UE加载完成后，放入内容。
      });
    },
    methods: {
      getUEContent() { // 获取内容方法
        return this.editor.getContent()
      }
    },
    destroyed() {
      this.editor.destroy();
    }
  }
</script>
