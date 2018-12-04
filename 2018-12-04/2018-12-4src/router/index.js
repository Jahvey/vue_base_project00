import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)// 开发环境不使用懒加载
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
    name: '登录'
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
  // 以前可用的登录首页 现在要改掉
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
      meta: { title: '机构维护', icon: 'manage' }// 点击机构维护跳转的路径  org/pageQueryOrg
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
    }, {
      path: 'natural',
      name: 'naturalPersonList',
      component: _import('user/naturalPersonList'),
      meta: { title: '自然人客户列表', icon: 'manage' }
    }, {
      path: 'tabtest',
      name: 'tabtest',
      component: _import('user/tabTest'),
      meta: { title: 'tabtest', icon: 'manage' },
      children: [{
        path: 'tabtest1',
        name: 'tabtest1',
        component: _import('user/tabTest1'),
        meta: { title: 'tabtest1', icon: 'manage' }
      },
      {
        path: 'tabtest2',
        name: 'tabtest2',
        component: _import('user/tabTest2'),
        meta: { title: 'tabtest2', icon: 'manage' }
      }]
    }, {
      path: 'tabtest1',
      name: 'tabtest1',
      component: _import('user/tabTest1'),
      meta: { title: 'tabtest1', icon: 'manage' }
    }, {
      path: 'userEdit',
      name: 'userEdit',
      hidden: true,
      component: _import('user/userEdit'),
      meta: { title: '用户测试列表修改', icon: 'manage' }
    }]
  },

  {
    path: '/crt',
    component: Layout,
    // redirect: '/contract/info',    //重定向需要更改,info改成什么？
    name: '合同管理',
    meta: { title: '合同管理', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'con_pub/con_apv_list',
        name: '贷款合同',
        component: _import('crt/con_pub/con_apv_list'),
        meta: { title: '贷款合同', icon: 'manage' }
      },
      {
        path: 'con_pub/con_apv_list2',
        name: '内部银团合同',
        component: _import('crt/con_pub/con_apv_list2'),
        meta: { title: '内部银团合同', icon: 'manage' }
      },
      {
        path: 'con_info/con_info_ht_xw',
        name: '主合同基本信息',
        component: _import('crt/con_info/con_info_ht_xw'),
        meta: { title: '主合同基本信息', icon: 'manage' }
      },
      {
        path: 'con_info/con_detail_ht_xw_uncycle',
        name: '主合同明细信息',
        component: _import('crt/con_info/con_detail_ht_xw_uncycle'),
        meta: { title: '主合同明细信息', icon: 'manage' }
      },
      {
        path: 'con_grt/con_dy_list',
        name: '从合同之抵押合同',
        component: _import('crt/con_grt/con_dy_list'),
        meta: { title: '从合同之抵押合同', icon: 'manage' }
      },
      {
        path: 'con_grt/con_zy_list',
        name: '从合同之质押合同',
        component: _import('crt/con_grt/con_zy_list'),
        meta: { title: '从合同之质押合同', icon: 'manage' }
      },
      {
        path: 'con_grt/con_bzr_list',
        name: '从合同之保证合同',
        component: _import('crt/con_grt/con_bzr_list'),
        meta: { title: '从合同之保证合同', icon: 'manage' }
      },
      {
        path: 'con_grt/con_bzj_list',
        name: '从合同之关联保证金',
        component: _import('crt/con_grt/con_bzj_list'),
        meta: { title: '关联保证金', icon: 'manage' }
      },
      {
        path: 'accountInfo/account_list',
        name: '账户信息',
        component: _import('crt/accountInfo/account_list'),
        meta: { title: '账户信息', icon: 'manage' }
      }
    ]
  },

  {
    path: '/pay', // 主路径需要更改
    // redirect: '/contract/list', 	//路由，并没有配置这个，404
    name: '支付',
    component: Layout, // 左侧主导航栏
    meta: { title: '支付', icon: 'organization' },
    roles: ['admin'],
    children: [
      {
        path: 'payout_apply/pay_apply', // 外部引入的路由，com.bos.pay
        name: '借据信息',
        component: _import('pay/payout_apply/pay_apply'),
        meta: { title: '借据信息', icon: 'manage' }
      },
      {
        path: 'payout_apply/pay_apply', // 随便写的支付模块，随时替换，找到就替换，目前拿来占位
        name: '支付信息',
        component: _import('pay/payout_apply/pay_apply'),
        meta: { title: '支付信息', icon: 'manage' }
      }
    ]
  },

  {
    path: '/csm', // 主路径需要更改
    // redirect: '/contract/list', 	//路由，并没有配置这个，404
    name: '客户信息',
    component: Layout, // 左侧主导航栏
    meta: { title: '客户信息', icon: 'organization' },
    roles: ['admin'],
    children: [
      {
        path: 'natural/natural_info',
        name: '客户概况信息',
        component: _import('csm/natural/natural_info'),
        meta: { title: '客户概况信息', icon: 'manage' }
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
        path: 'natural/natural_relative_list_corp',
        name: '对私客户关系企业信息',
        component: _import('csm/natural/natural_relative_list_corp'),
        meta: { title: '对私客户关系企业信息', icon: 'manage' }
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
        name: '评级信息',
        component: _import('csm/corporation/csm_external_eval_result_list_in'),
        meta: { title: '评级信息', icon: 'manage' }
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
      },
      {
        path: 'natural/natural_additive_list',
        name: '附加信息',
        component: _import('csm/natural/natural_additive_list'),
        meta: { title: '附加信息', icon: 'manage' }
      },
      {
        path: 'myBank/financing_list',
        name: '批复信息', // 本行业务信息
        component: _import('csm/myBank/financing_list'),
        meta: { title: '批复信息', icon: 'manage' }
      },
      {
        path: 'myBank/financing_list_yewu',
        name: '业务信息', // 本行业务信息
        component: _import('csm/myBank/financing_list_yewu'),
        meta: { title: '业务信息', icon: 'manage' }
      },
      {
        path: 'myBank/guarantee_list',
        name: '为我行客户担保情况',
        component: _import('csm/myBank/guarantee_list'),
        meta: { title: '本行保证情况', icon: 'manage' }
      },
      {
        path: 'myBank/guarantee_list_diya',
        name: '本行抵押情况',
        component: _import('csm/myBank/guarantee_list_diya'),
        meta: { title: '本行抵质押情况', icon: 'manage' }
      },
      {
        path: 'corporation/csm_illegal_list',
        name: '违约记录',
        component: _import('csm/corporation/csm_illegal_list'),
        meta: { title: '违约记录', icon: 'manage' }
      },
      {
        path: 'myBank/refuse_list',
        name: '拒贷信息',
        component: _import('csm/myBank/refuse_list'),
        meta: { title: '拒贷信息', icon: 'manage' }
      },
      {
        path: 'corporation/csm_manage_team_list',
        name: '我行管理团队',
        component: _import('csm/corporation/csm_manage_team_list'),
        meta: { title: '我行管理团队', icon: 'drag' }
      }
    ]
  },

  {
    path: '/biz', // 主路径需要更改
    // redirect: '/contract/list', 	//路由，并没有配置这个，404business
    name: 'biz资料类',
    component: Layout, // 左侧主导航栏
    meta: { title: 'biz包', icon: 'organization' },
    roles: ['admin'],
    children: [
      {
        path: 'biz_info/pro_biz_upload',
        name: '相关文档',
        component: _import('biz/biz_info/pro_biz_upload'),
        meta: { title: '相关文档', icon: 'example' }
      },
      {
        path: 'biz/biz_info',
        name: '基本信息',
        component: _import('biz/biz/biz_info'),
        meta: { title: '基本信息', icon: 'example' }
      },
      {
        path: 'biz_info/biz_xw_detail',
        name: '基本信息',
        component: _import('biz/biz_info/biz_xw_detail'),
        meta: { title: '基本信息', icon: 'example' }
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

