import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)//开发环境不使用懒加载
// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'
import Login from '../views/login/index'
/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
  }
**/
export const constantRouterMap = [
  { path: '/login', component: _import('login/index'), hidden: true },
  { path: '/404', component: _import('404'), hidden: true },
  {
    path: '/',
    component: Login,
    name: '登录',
  },
  {
    path: '/dashboard',
    component: Layout,
    redirect: '/dashboard/index',
    leaf: true,
    menuShow: true,
    // hidden: true,
    meta: { title: '首页', icon: 'organization' },
      children: [{
        path: 'index',
        name: '首页测试1',
        // menuShow: true,
        meta: { title: '首页测试', icon: 'manage' },
        component: _import('dashboard/index')
      }]
  },
  //以前可用的登录首页 现在要改掉
  // {
  //   path: '/',
  //   component: Layout,
  //   redirect: '/dashboard',
  //   name: '首页1',
  //   children: [{
  //     path: 'dashboard',
  //     component: _import('dashboard/index')
  //   }]
  // },
  {
    path: '/org',
    component: Layout,
    redirect: '/org/info',
    name: '机构管理',
    meta: { title: '机构管理', icon: 'organization' },
    roles: ['admin'],
    children: [{
      path: 'info',
      name: 'orgInfo',
      component: _import('org/OrgInfo'),
      meta: { title: '机构维护', icon: 'manage' }
    }, {
      path: 'add',
      name: 'orgAdd',
      hidden: true,
      component: _import('org/OrgAdd'),
      meta: { title: '机构新增', icon: 'manage' }
    }, {
      path: 'edit',
      name: 'orgEdit',
      hidden: true,
      component: _import('org/OrgEdit'),
      meta: { title: '机构修改', icon: 'manage' }
    }]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/info',
    name: '用户管理',
    meta: { title: '用户管理', icon: 'organization' },
    roles: ['admin'],
    children: [{
      path: 'info',
      name: 'userInfo',
      component: _import('user/userInfo'),
      meta: { title: '用户信息', icon: 'manage' }
    }, {
      path: 'test',
      name: 'userList',
      component: _import('user/userList'),
      meta: { title: '用户测试列表', icon: 'manage' }
    }, {
        path: 'add',
        name: 'add',
        hidden: true,
        component: _import('user/userAdd'),
        meta: { title: '用户新增', icon: 'manage' }
      }, {
        path: 'userAdd',
        name: 'userAdd',
        hidden: true,
        component: _import('user/userAdd1'),
        meta: { title: '用户测试列表新增新增', icon: 'manage' }
      },{
        path: 'natural',
        name: 'naturalPersonList',
        component: _import('user/naturalPersonList'),
        meta: { title: '自然人客户列表', icon: 'manage' }
      },{
      path: 'natural1',
      name: 'naturalPersonList1',
      component: _import('user/naturalPersonList1'),
      meta: { title: '自然人客户列表1', icon: 'manage' }
    },{
      path: 'tabtest',
      name: 'tabtest',
      component: _import('user/tabTest'),
      meta: { title: 'tabtest', icon: 'manage' }
    },{
      path: 'user',
      name: 'user',
      component: _import('user/user'),
      meta: { title: 'user', icon: 'manage' }
    }, {
        path: 'loanCount',
        name: 'loanCount',
        component: _import('user/loanCount'),
        meta: { title: 'loanCount', icon: 'manage' }
      },{
      path: 'manyTable',
      name: 'manyTable',
      component: _import('user/ManyTable'),
      meta: { title: 'manyTable', icon: 'manage' }
    },{
      path: 'userEdit',
      name: 'userEdit',
      hidden: true,
      component: _import('user/userEdit'),
      meta: { title: '用户测试列表修改', icon: 'manage' }
    }]
  },
  {
    path: '/csm', // 主路径需要更改
    component: Layout,
    // redirect: '/contract/info',    
    // redirect: '/contract/list',  //路由，并没有配置这个，404
    name: '我的客户',
    meta: { title: '我的客户', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'workdesk/mycust_natural',
        name: '自然人客户', 
        component: _import('csm/workdesk/mycust_natural'), 
        meta: { title: '自然人客户', icon: 'manage' }
      },
      {
        path: 'natural/natural_info',
        name: '自然人客户概况信息', 
        component: _import('csm/natural/natural_info'), 
        meta: { title: '自然人客户概况信息', icon: 'manage' }
      },
      {
        path: 'account/csm_entrust_account_list',
        name: '委托方账户信息', 
        component: _import('csm/account/csm_entrust_account_list'), 
        meta: { title: '委托方账户信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_relative_list',
        name: '对私客户关系个人信息', 
        component: _import('csm/natural/natural_relative_list'), 
        meta: { title: '对私客户关系个人信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_business',
        name: '经营信息', 
        component: _import('csm/natural/natural_business'), 
        meta: { title: '经营信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_school',
        name: '高校信息', 
        component: _import('csm/natural/natural_school'), 
        meta: { title: '高校信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_credit_list',
        name: '信用信息', 
        component: _import('csm/natural/natural_credit_list'),
        meta: { title: '信用信息', icon: 'manage' }
      },
      {
        path: 'corporation/csm_external_eval_result_list_in',
        name: '内部评级信息', 
        component: _import('csm/corporation/csm_external_eval_result_list_in'), 
        meta: { title: '内部评级信息', icon: 'manage' }
      },
      {
        path: 'corporation/csm_impornant_event_list',
        name: '重大事件',
        component: _import('csm/corporation/csm_impornant_event_list'), 
        meta: { title: '重大事件', icon: 'manage' }
      },
      {
        path: 'corporation/ews_warn_main',
        name: '预警客户信息',
        component: _import('csm/corporation/ews_warn_main'), 
        meta: { title: '预警客户信息', icon: 'manage' }
      }
    ]
  },
    {
    path: '/crt', 
    component: Layout,
    // redirect: '/contract/info',    
    // redirect: '/contract/list',  
    name: '合同签约',
    meta: { title: '合同签约', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'con_apply/con_apply_tz',
        name: '主合同管理', 
        component: _import('crt/con_apply/con_apply_tz'), 
        meta: { title: '主合同管理', icon: 'manage' }
      },
      {
        path: 'subContractManage/subContarct_list',
        name: '担保合同管理', 
        component: _import('grt/subContractManage/subContarct_list'), 
        meta: { title: '担保合同管理', icon: 'manage' }
      },
      {
        path: 'con_apply/con_apply_print',
        name: '合同打印', 
        component: _import('crt/con_apply/con_apply_print'), 
        meta: { title: '合同打印', icon: 'manage' }
      }
    ]
  },
  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开 注意: 这个功能只在 HTML5 history 模式下可用。
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

