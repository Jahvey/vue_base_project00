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
