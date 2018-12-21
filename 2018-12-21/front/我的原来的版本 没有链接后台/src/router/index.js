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

 path: '/biz', // 主路径需要更改
    component: Layout,
    // redirect: '/contract/info',    //重定向需要更改,info改成什么？
    // redirect: '/contract/list',  //路由，并没有配置这个，404
    name: '业务结构信息',
    meta: { title: '业务结构信息', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'biz_info',
        name: '业务结构基本信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('biz/biz_info'), // 更改，这个方法需要再仔细看一下
        meta: { title: '业务结构基本信息', icon: 'manage' }
      }
    ]


},
  {
    path: '/contract', // 主路径需要更改
    component: Layout,
    // redirect: '/contract/info',    //重定向需要更改,info改成什么？
    // redirect: '/contract/list', 	//路由，并没有配置这个，404
    name: '合同管理',
    meta: { title: '合同管理', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'info',
        name: '贷款合同', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('contract/loanContract'), // 更改，这个方法需要再仔细看一下
        meta: { title: '贷款合同', icon: 'manage' }
      },
      {
        path: 'add', // 这个算一个映射路径，和上面的拼接/contract/add
        name: '内部银团合同',
        // component: _import('contract/contractInfo/mainContractInfo'), // 页面
        component: _import('contract/innerContract'),
        meta: { title: '内部银团合同', icon: 'manage' }
      },
      {
        path: 'mainContractInfo', // 这个算一个映射路径，和上面的拼接/contract/mainContractInfo
        name: '主合同基本信息',
        component: _import('contract/contractInfo/mainContractInfo'),
        meta: { title: '主合同基本信息', icon: 'manage' }
      },
      {
        path: 'mainContractDetail', // 这个算一个映射路径，和上面的拼接/contract/mainContractInfo
        name: '主合同明细信息',
        component: _import('contract/contractInfo/mainContractItem'), // mainContractDetail
        meta: { title: '主合同明细信息', icon: 'manage' }
      },
      {
        path: 'mortgageContract',
        name: '从合同之抵押合同',
        component: _import('contract/serventContractInfo/mortgageContract'), // mainContractDetail
        meta: { title: '从合同之抵押合同', icon: 'manage' }
      },
      {
        path: 'pledgeContract',
        name: '从合同之质押合同',
        component: _import('contract/serventContractInfo/pledgeContract'), // mainContractDetail
        meta: { title: '从合同之质押合同', icon: 'manage' }
      },
      {
        path: 'ensureContract',
        name: '从合同之保证合同',
        component: _import('contract/serventContractInfo/ensureContract'), // mainContractDetail
        meta: { title: '从合同之保证合同', icon: 'manage' }
      },
      {
        path: 'relationEnsureMoney',
        name: '从合同之关联保证金',
        component: _import('contract/serventContractInfo/relationEnsureMoney'), // mainContractDetail
        meta: { title: '关联保证金', icon: 'manage' }
      },
      {
        path: 'accountMessage',
        name: '账户信息',
        component: _import('contract/accountMessage'), // mainContractDetail
        meta: { title: '账户信息', icon: 'manage' }
      },
      {
        path: 'receiptMessage',
        name: '借据信息',
        component: _import('contract/receiptMessage'), // mainContractDetail
        meta: { title: '借据信息', icon: 'manage' }
      }
    ]
  },

  {
    path: '/clientMessage', // 主路径需要更改
    // redirect: '/contract/list', 	//路由，并没有配置这个，404
    name: '客户信息',
    // component: _import('clientMessage'),
    component: Layout, // 左侧主导航栏
    meta: { title: '客户信息', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'clientBaseInfo',
        name: '客户概况信息',
        component: _import('clientMessage/clientBaseInfo'),
        meta: { title: '客户概况信息', icon: 'manage' }
      },
      {
        path: 'entrustAccountInfo',
        name: '委托方账户信息',
        component: _import('clientMessage/entrustAccountInfo'),
        meta: { title: '委托方账户信息', icon: 'manage' }
      },
      {
        path: 'relativeListInfo',
        name: '对私客户关系个人信息',
        component: _import('clientMessage/relativeListInfo/personRelativeInfo'),
        meta: { title: '对私客户关系个人信息', icon: 'manage' }
      },
      {
        path: 'companyRelativeInfo',
        name: '对私客户关系企业信息',
        component: _import('clientMessage/relativeListInfo/companyRelativeInfo'),
        meta: { title: '对私客户关系企业信息', icon: 'manage' }
      },
      {
        path: 'businessInfo',
        name: '经营信息',
        component: _import('clientMessage/businessInfo'),
        meta: { title: '经营信息', icon: 'manage' }
      },
      {
        path: 'universityInfo',
        name: '高校信息',
        component: _import('clientMessage/universityInfo'),
        meta: { title: '高校信息', icon: 'manage' }
      },
      {
        path: 'creditInfo',
        name: '信用信息',
        component: _import('clientMessage/creditInfo'),
        meta: { title: '信用信息', icon: 'manage' }
      },
      {
        path: 'creditRatingInfo',
        name: '评级信息',
        component: _import('clientMessage/creditRatingInfo'),
        meta: { title: '评级信息', icon: 'manage' }
      },
      {
        path: 'importantEvent',
        name: '重大事件',
        component: _import('clientMessage/importantEvent'),
        meta: { title: '重大事件', icon: 'manage' }
      },
      {
        path: 'warningMessage',
        name: '预警客户信息',
        component: _import('clientMessage/warningMessage'),
        meta: { title: '预警客户信息', icon: 'manage' }
      },
      {
        path: 'otherInfo',
        name: '附加信息',
        component: _import('clientMessage/otherInfo'), // financingInfo
        meta: { title: '附加信息', icon: 'manage' }
      }
    ]
  },

  {
    path: '/ourBankBusinessInfo', // 主路径需要更改
    // redirect: '/contract/list', 	//路由，并没有配置这个，404business
    name: '本行业务信息',
    component: Layout, // 左侧主导航栏
    meta: { title: '本行业务信息', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'ourBankFinancingInfo/financingInfo',
        name: '批复信息',
        component: _import('ourBankBusinessInfo/ourBankFinancingInfo/financingInfo'),
        meta: { title: '批复信息', icon: 'manage' }
      },
      {
        path: 'ourBankFinancingInfo/businessInfo',
        name: '业务信息',
        component: _import('ourBankBusinessInfo/ourBankFinancingInfo/businessInfo'),
        meta: { title: '业务信息', icon: 'manage' }
      },
      {
        path: 'ourBankClientGuaranteeInfo/ourBankGuaranteeInfo',
        name: '为我行客户担保情况',
        component: _import('ourBankBusinessInfo/ourBankClientGuaranteeInfo/ourBankGuaranteeInfo'),
        meta: { title: '本行保证情况', icon: 'manage' }
      },
      {
        path: 'ourBankClientGuaranteeInfo/ourBankPledgeInfo',
        name: '本行抵押情况',
        component: _import('ourBankBusinessInfo/ourBankClientGuaranteeInfo/ourBankPledgeInfo'),
        meta: { title: '本行抵押情况', icon: 'manage' }
      },
      {
        path: 'ourBankBusinessInfo/illegalRecord',
        name: '违约记录',
        component: _import('ourBankBusinessInfo/illegalRecord'),
        meta: { title: '违约记录', icon: 'manage' }
      },
      {
        path: 'ourBankBusinessInfo/refuseMessage',
        name: '拒贷信息',
        component: _import('ourBankBusinessInfo/refuseMessage'),
        meta: { title: '拒贷信息', icon: 'manage' }
      },
      {
        path: 'ourBankBusinessInfo/manageTeam',
        name: '我行管理团队',
        component: _import('ourBankBusinessInfo/manageTeam'),
        meta: { title: '我行管理团队', icon: 'manage' }
      }
    ]
  },
  {
    path: '/csm', // 主路径需要更改
    component: Layout,
    // redirect: '/contract/info',    //重定向需要更改,info改成什么？
    // redirect: '/contract/list',  //路由，并没有配置这个，404
    name: '我的客户',
    meta: { title: '我的客户', icon: 'organization' },
    roles: ['admin'], // 这里需要更改
    children: [
      {
        path: 'workdesk/mycust_natural',
        name: '自然人客户', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/workdesk/mycust_natural'), // 更改，这个方法需要再仔细看一下
        meta: { title: '自然人客户', icon: 'manage' }
      },
      {
        path: 'natural/natural_info',
        name: '自然人客户概况信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/natural/natural_info'), // 更改，这个方法需要再仔细看一下
        meta: { title: '自然人客户概况信息', icon: 'manage' }
      },
      {
        path: 'account/csm_entrust_account_list',
        name: '委托方账户信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/account/csm_entrust_account_list'), // 更改，这个方法需要再仔细看一下
        meta: { title: '委托方账户信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_relative_list',
        name: '对私客户关系个人信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/natural/natural_relative_list'), // 更改，这个方法需要再仔细看一下
        meta: { title: '对私客户关系个人信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_business',
        name: '经营信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/natural/natural_business'), // 更改，这个方法需要再仔细看一下
        meta: { title: '经营信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_school',
        name: '高校信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/natural/natural_school'), // 更改，这个方法需要再仔细看一下
        meta: { title: '高校信息', icon: 'manage' }
      },
      {
        path: 'natural/natural_credit_list',
        name: '信用信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/natural/natural_credit_list'), // 更改，这个方法需要再仔细看一下
        meta: { title: '信用信息', icon: 'manage' }
      },
      {
        path: 'corporation/csm_external_eval_result_list_in',
        name: '内部评级信息', // 这个是组织信息，需要更改    ，为何路由永远走的贷款合同这一栏，下面那个打不开？
        component: _import('csm/corporation/csm_external_eval_result_list_in'), // 更改，这个方法需要再仔细看一下
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
    path: '/crt', // 主路径需要更改
    component: Layout,
    // redirect: '/contract/info',    //重定向需要更改,info改成什么？
    // redirect: '/contract/list',  //路由，并没有配置这个，404
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
	  
	  /* 
	  ,
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
      } */
    ]
  },
  
  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开 注意: 这个功能只在 HTML5 history 模式下可用。
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

