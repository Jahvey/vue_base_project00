import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)//开发环境不使用懒加载
// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'
import Login from '../views/login/index'
import securityManagement from '../views/securitymanagement/securityManagement'

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
      hidden: false,
      component: _import('org/OrgAdd'),
      meta: { title: '机构新增', icon: 'manage' }
    }, {
      path: 'edit',
      name: 'orgEdit',
      hidden: false,
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
    path: '/securityManagement',
    component: securityManagement,
    name: '担保品管理',
    meta: { title: '担保品管理', icon: 'organization' },
    menuShow: true,
    //redirect: '/securityManagement/mortgagepledge/addMortgagePledge',
    roles: ['admin'],
    children: [
        {
        path: 'addMortgagePledge',
        name: '抵质押品新增',
        component: _import('securitymanagement/mortgagepledge/addMortgagePledge'),//添加抵质押品
        meta: { title: '抵质押品新增', icon: 'manage' }
       },
      {
        path: 'editMortgagePledge',
        name: '抵质押品维护',
        component: _import('securitymanagement/mortgagepledge/editMortgagePledge'),//抵质押品维护
        meta: { title: '抵质押品维护', icon: 'manage' }
      },
      {
        path: 'addBondedInfo',
        name: '抵债信息新增',
        component: _import('securitymanagement/bondedinfo/addBondedInfo'),//添加抵债信息
        meta: { title: '抵债信息新增', icon: 'manage' }
      },
      {
        path: 'editBondedInfo',
        name: '抵债信息维护',
        component: _import('securitymanagement/bondedinfo/editBondedInfo'),//抵债信息维护
        meta: { title: '抵债信息维护', icon: 'manage' }
      },
	  ]
  },
  { path: '*', redirect: '/404', hidden: true },
]
export default new Router({
  // mode: 'history', //后端支持可开 注意: 这个功能只在 HTML5 history 模式下可用。
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

