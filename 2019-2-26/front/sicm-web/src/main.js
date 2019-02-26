import Vue from 'vue'
import 'babel-polyfill'
import ElementUI from 'element-ui'
// import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN'
import App from './App'
import router from './router'
import store from './store'
import '@/icons' // icon
import '@/permission' // 权限
import '@/utils/comp_registry' // 全局组件注册
import '@/styles/occ.css'
import '@/styles/element-ui.scss'
import commonUtil from '@/utils/commonUtil'
import { addRoutes } from '@/router/dynamicRouter'

//这里之所以使用 require 而不是 import，是因为 require 可以直接从 node_modules 中查找，而 import 必须把路径写全
// import echarts from 'echarts'
// Vue.prototype.$echarts = echarts //将echarts注册成Vue的全局属性
// Vue.use(echarts);   //可以不用这个了

// Vue.prototype.HOST='/mybatis-service'

// import Mock from './mock'
// Mock.bootstrap();

commonUtil.dateformat()

window.$script = require('scriptjs')

Vue.use(ElementUI, { locale, size: 'small' })
// 防止F5刷新页面时路由没有加载
var userId = window.sessionStorage.userId
if (userId != undefined && userId != '') {
  var menus = addRoutes()
  router.addRoutes(menus)
  router.options.routes = router.options.routes.concat(menus)
}

Vue.config.productionTip = false



new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
