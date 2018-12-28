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


  {//by wanghao
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
        name: '预警信息',
        component: _import('csm/corporation/ews_warn_main'), 
        meta: { title: '预警信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_additive_list',
        name: '附加信息',
        component: _import('csm/natural/natural_additive_list'), 
        meta: { title: '附加信息', icon: 'manage' }
      },
      {
        path: 'myBank/financing_list',
        name: '本行融资情况批复信息',
        component: _import('csm/myBank/financing_list'), 
        meta: { title: '本行融资情况批复信息', icon: 'manage' }
      },
      {
        path: 'myBank/financing_list_yewu',
        name: '本行融资情况业务信息',
        component: _import('csm/myBank/financing_list_yewu'), 
        meta: { title: '本行融资情况业务信息', icon: 'manage' }
      },
      {
        path: 'myBank/guarantee_tab',
        name: '为我行客户担保情况',
        component: _import('csm/myBank/guarantee_tab'), 
        meta: { title: '为我行客户担保情况', icon: 'manage' }
      },
      {
        path: 'myBank/guarantee_list_diya',
        name: '为我行客户质押情况',
        component: _import('csm/myBank/guarantee_list_diya'), 
        meta: { title: '为我行客户质押情况', icon: 'manage' }
      },
      {
        path: 'corporation/csm_illegal_list',
        name: '违法记录',
        component: _import('csm/corporation/csm_illegal_list'), 
        meta: { title: '违法记录', icon: 'manage' }
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
        meta: { title: '我行管理团队', icon: 'manage' }
      },
      {
        path: 'biz_info/pro_biz_upload',
        name: '相关文档',
        component: _import('csm/biz_info/pro_biz_upload'), 
        meta: { title: '相关文档', icon: 'manage' }
      }
    ]
  },
    {//by wanghao
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
      },
      {
        path: 'subContractManage/subContarct_dyzy_view',
        name: '抵质押合同基本信息', 
        component: _import('grt/subContractManage/subContarct_dyzy_view'), 
        meta: { title: '抵质押合同基本信息', icon: 'manage' }
      },
      {
        path: 'subContractManage/subContarct_OldDbList_view',
        name: '抵质押品关联信息', 
        component: _import('grt/subContractManage/subContarct_OldDbList_view'), 
        meta: { title: '抵质押品关联信息', icon: 'manage' }
      },
      {
        path: 'subContractManage/subContarct_OldContractList_view',
        name: '主合同关联信息', 
        component: _import('grt/subContractManage/subContarct_OldContractList_view'), 
        meta: { title: '主合同关联信息', icon: 'manage' }
      }
    ]
  },
  {//by wanghao
    path: '/biz', 
    component: Layout,
    // redirect: '/contract/info',    
    // redirect: '/contract/list',  
    name: '业务申请',
    meta: { title: '业务申请', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'biz/biz_list',
        name: '业务信息', 
        component: _import('biz/biz/biz_list'), 
        meta: { title: '业务信息', icon: 'manage' }
      },
      {
        path: 'biz_apply/biz_apply_jxhj',
        name: '循环贷/续接贷', 
        component: _import('biz/biz_apply/biz_apply_jxhj'), 
        meta: { title: '循环贷/续接贷', icon: 'manage' }
      }

    ]
  },
  {//by wanghao
    path: '/crd', 
    component: Layout,
    // redirect: '/contract/info',    
    name: '额度信息',
    meta: { title: '额度信息', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'crdApply/crd_apply',
        name: '综合授信额度信息', 
        component: _import('crd/crdApply/crd_apply'), 
        meta: { title: '综合授信额度信息', icon: 'manage' }
      }

    ]
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
  { path: '*', redirect: '/404', hidden: true },

]
export default new Router({
  // mode: 'history', //后端支持可开 注意: 这个功能只在 HTML5 history 模式下可用。
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

