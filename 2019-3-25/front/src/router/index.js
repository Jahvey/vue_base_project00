import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import NotFound from '@/views/Error/404'
import Home from '@/views/Home'
import Intro from '@/views/Intro/Intro'
import Generator from '@/views/Generator/Generator'
import api from '@/http/api'
import store from '@/store'
import { getIFramePath, getIFrameUrl } from '@/utils/iframe'

import natural_natural_info from '../views/cusManage/natureCus/natural/natural_info'//客户概况信息
import natural_csm_entrust_account_list from '../views/cusManage/natureCus/natural/csm_entrust_account_list'//委托方账户信息
import natural_natural_relative from '../views/cusManage/natureCus/natural/natural_relative'//关系人个人信息
import natural_natural_relative_corp from '../views/cusManage/natureCus/natural/natural_relative_corp'//关系人企业信息
import natural_natural_business from '../views/cusManage/natureCus/natural/natural_business'//经营信息
import natural_natural_school from '../views/cusManage/natureCus/natural/natural_school' //高校信息
import natural_natural_credit_list from '../views/cusManage/natureCus/natural/natural_credit_list'//信用信息
import natural_csm_external_eval_result_list from '../views/cusManage/natureCus/natural/csm_external_eval_result_list'//评级信息
import natural_csm_impornant_event_list from '../views/cusManage/natureCus/natural/csm_impornant_event_list'//重大事件
import natural_ews_warn_main from '../views/cusManage/natureCus/natural/ews_warn_main'//预警信息
import natural_natural_additive_list from '../views/cusManage/natureCus/natural/natural_additive_list'//附加信息
import mybank_financing_list from '../views/cusManage/natureCus/natural/financing_list'//本行融资情况批复信息
import mybank_financing_list_yewu from '../views/cusManage/natureCus/natural/financing_list_yewu'//本行融资情况业务信息
import mybank_guarantee_list from '../views/cusManage/natureCus/natural/guarantee_list'//为我行客户担保情况本行保证情况
import mybank_guarantee_list_diya from '../views/cusManage/natureCus/natural/guarantee_list_diya'//为我行客户担保情况本行抵质押情况
import mybank_csm_illegal_list from '../views/cusManage/natureCus/natural/csm_illegal_list'//违约记录
import mybank_refuse_list from '../views/cusManage/natureCus/natural/refuse_list'//拒贷信息
import natural_csm_manage_team_list from '../views/cusManage/natureCus/natural/csm_manage_team_list'//我行管理团队
import natural_pro_biz_upload from '../views/cusManage/natureCus/natural/pro_biz_upload'//相关文档

Vue.use(Router)

var natureCusRouters =
  [
    {path: 'natural_info',name: '客户概况信息',component: natural_natural_info},
    {path: 'csm_entrust_account_list',name: '委托方账户信息',component: natural_csm_entrust_account_list},
    {path: 'natural_relative',name: '对私客户关系个人信息',component: natural_natural_relative},
    {path: 'natural_relative_corp',name: '对私客户关系企业信息',component: natural_natural_relative_corp},
    {path: 'natural_business',name: '经营信息',component: natural_natural_business},
    {path: 'natural_school',name: '高校信息',component: natural_natural_school},
    {path: 'natural_credit_list',name: '信用信息',component: natural_natural_credit_list},
    {path: 'csm_external_eval_result_list',name: '评级信息',component: natural_csm_external_eval_result_list},
    {path: 'csm_impornant_event_list',name: '重大事件',component: natural_csm_impornant_event_list},
    {path: 'ews_warn_main',name: '预警信息',component: natural_ews_warn_main},
    {path: 'natural_additive_list',name: '附加信息',component: natural_natural_additive_list},
    {path: 'financing_list',name: '批复信息',component: mybank_financing_list},
    {path: 'financing_list_yewu',name: '业务信息',component: mybank_financing_list_yewu},
    {path: 'guarantee_list',name: '本行保证情况',component: mybank_guarantee_list},
    {path: 'guarantee_list_diya',name: '本行抵质押情况',component: mybank_guarantee_list_diya},
    {path: 'csm_illegal_list',name: '违约记录',component: mybank_csm_illegal_list},
    {path: 'refuse_list',name: '拒贷信息',component: mybank_refuse_list},
    {path: 'csm_manage_team_list',name: '我行管理团队',component: natural_csm_manage_team_list},
    {path: 'pro_biz_upload',name: '相关文档',component: natural_pro_biz_upload}
  ]
const router = new Router({
  routes: [
    {
      path: '/',
      name: '首页',
      component: Home,
      children: [
        {
          path: '',
          name: '系统介绍',
          component: Intro
        }
      ]
    },
    {
      path: '/login',
      name: '登录',
      component: Login
    },
    {
      path: '/404',
      name: 'notFound',
      component: NotFound
    }
  ]
})

router.beforeEach((to, from, next) => {
  // 登录界面登录成功之后，会把用户信息保存在会话
  // 存在时间为会话生命周期，页面关闭即失效。
  let userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
  if (to.path === '/login') {
    // 如果是访问登录界面，如果用户会话信息存在，代表已登录过，跳转到主页
    if(userInfo && userInfo.empname) {
      next({ path: '/' })
    } else {
      next()
    }
  } else {
    if (!userInfo) {
      // 如果访问非登录界面，且户会话信息不存在，代表未登录，则跳转到登录界面
      next({ path: '/login' })
    } else {
      // 加载动态菜单和路由
      addDynamicMenuAndRoutes(sessionStorage.getItem("currRole"),userInfo.empname, to, from)
      next()
    }
  }
})

/**
 * 加载动态菜单和路由
 */
function addDynamicMenuAndRoutes(roleid,userName, to, from) {
  // 处理IFrame嵌套页面
  handleIFrameUrl(to.path)
  if(store.state.app.menuRouteLoaded) {
    console.log('动态菜单和路由已经存在.')
    return
  }
  api.menu.queryMenuTreeByRole({roleid:roleid})
    .then(res => {
      // 添加动态路由
      let dynamicRoutes = addDynamicRoutes(res.data.data)
      router.options.routes[0].children = router.options.routes[0].children.concat(dynamicRoutes)
      router.addRoutes(router.options.routes)
      // 保存加载状态
      store.commit('menuRouteLoaded', true)
      // 保存菜单树
      store.commit('setNavTree', res.data.data)
    }).then(res => {
    api.user.findPermissions({'name':userName}).then(res => {
      // 保存用户权限标识集合
      store.commit('setPerms', res.data)
    })
  })
    .catch(function(res) {
    })
}

/**
 * 处理IFrame嵌套页面
 */
function handleIFrameUrl(path) {
  // 嵌套页面，保存iframeUrl到store，供IFrame组件读取展示
  let url = path
  let length = store.state.iframe.iframeUrls.length
  for(let i=0; i<length; i++) {
    let iframe = store.state.iframe.iframeUrls[i]
    if(path != null && path.endsWith(iframe.path)) {
      url = iframe.url
      store.commit('setIFrameUrl', url)
      break
    }
  }
}

/**
 * 添加动态(菜单)路由
 * @param {*} menuList 菜单列表
 * @param {*} routes 递归创建的动态(菜单)路由
 */
function addDynamicRoutes (menuList = [], routes = []) {
  //自然人客户路由
  var temp = []
  for (var i = 0; i < menuList.length; i++) {
    if (menuList[i].children && menuList[i].children.length >= 1) {
      temp = temp.concat(menuList[i].children)
    } else if (menuList[i].menuaction && /\S/.test(menuList[i].menuaction)) {
      menuList[i].menuaction = menuList[i].menuaction.replace(/^\//, '')
      // 创建路由配置
      var route = {
        path: menuList[i].menuaction,
        component: null,
        name: menuList[i].menuname,
        meta: {
          keepAlive: true
        }
      }
      if(/natural/.test(menuList[i].menuaction)){
        route.children = natureCusRouters
      }

      let path = getIFramePath(menuList[i].menuaction)
      if (path) {
        // 如果是嵌套页面, 通过iframe展示
        route['path'] = path
        route['component'] = resolve => require([`@/views/IFrame/IFrame`], resolve)
        // 存储嵌套页面路由路径和访问URL
        let url = getIFrameUrl(menuList[i].menuaction)
        let iFrameUrl = {'path':path, 'url':url}
        store.commit('addIFrameUrl', iFrameUrl)
      } else {
        try {
          // 根据菜单URL动态加载vue组件，这里要求vue组件须按照url路径存储
          // 如url="sys/user"，则组件路径应是"@/views/sys/user.vue",否则组件加载不到
          let array = menuList[i].menuaction.split('/')
          let url = ''
          for(let i=0; i<array.length; i++) {
            url += array[i].substring(0,1).toUpperCase() + array[i].substring(1) + '/'
          }
          url = url.substring(0, url.length - 1)
          route['component'] = resolve => require([`@/views/${url}`], resolve)
        } catch (e) {}
      }
      routes.push(route)
    }
  }
  if (temp.length >= 1) {
    addDynamicRoutes(temp, routes)
  } else {
    console.log('动态路由加载...')
    console.log(routes)
    console.log('动态路由加载完成.')
  }
  return routes
}

export default router
