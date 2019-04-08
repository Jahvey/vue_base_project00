<template>
  <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="natural_info">客户概况信息</el-menu-item>
      <el-menu-item index="csm_entrust_account_list">委托方账户信息</el-menu-item>
      <el-submenu index="1">
        <template slot="title">关系人信息</template>
        <el-menu-item index="natural_relative">对私客户关系个人信息</el-menu-item>
        <el-menu-item index="natural_relative_corp">对私客户关系企业信息</el-menu-item>
      </el-submenu>
      <el-menu-item index="natural_business">经营信息</el-menu-item>
      <el-menu-item index="natural_school">高校信息</el-menu-item>
      <el-menu-item index="natural_credit_list">信用信息</el-menu-item>
      <el-menu-item index="csm_external_eval_result_list">评级信息</el-menu-item>
      <el-menu-item index="csm_impornant_event_list">重大事件</el-menu-item>
      <el-menu-item index="ews_warn_main">预警信息</el-menu-item>
      <el-menu-item index="natural_additive_list">附加信息</el-menu-item>
      <el-submenu index="2">
        <template slot="title">本行业务信息</template>
        <el-submenu index="2-1">
          <template slot="title">本行融资情况</template>
          <el-menu-item index="mybank/financing_tab/pf_info">批复信息</el-menu-item>
          <el-menu-item index="mybank/guarantee_tab/yw_info">业务信息</el-menu-item>
        </el-submenu>
        <el-menu-item index="mybank/financing_tab">本行融资情况</el-menu-item>
        <el-menu-item index="mybank/guarantee_tab">为我行客户担保情况</el-menu-item>
        <el-menu-item index="mybank/csm_illegal_list">违约记录</el-menu-item>
        <el-menu-item index="mybank/refuse_list">拒贷信息</el-menu-item>
      </el-submenu>
      <el-menu-item index="csm_manage_team_list">我行管理团队</el-menu-item>
      <el-menu-item index="pro_biz_upload">相关文档</el-menu-item>
    </el-menu>

    <keep-alive>
      <router-view></router-view>
    </keep-alive>
    
  </div>

</template>
<script>
  export default {
    data() {
      return {
        activeIndex: '1'
      }
    },
    methods: {
      handleSelect(key, keyPath) {
        this.$router.push('/cusManage/natureCus/natureCusDetailInfo/'+ key)
      }
    }
  }
</script>

<!--
<template>
  <div class="page1">
    <p style="color: #999;font-size: 14px;">活动详情的按照内容板块可分别编辑，活动结束后不可编辑。</p>
    <el-tabs type="card" @tab-click="routerTo" :active-name="baseInfo">
      <el-tab-pane label="基本信息" name="baseInfo"></el-tab-pane>
      <el-tab-pane label="报名签到" name="2"></el-tab-pane>
      <el-tab-pane label="分享设置"></el-tab-pane>
      <el-tab-pane label="个性化设置"></el-tab-pane>
    </el-tabs>
      <router-view></router-view>
  </div>
</template>
<script>
  export default {

    data: function() {
      return {

      }
    },
    methods: {
      routerTo: function(val, event) {
        console.log(val, event)
        var name = event.target.getAttribute('id').substring(4)
        this.$router.push('/user/test/' + name)
      },
      handleCancel: function() {

      },
      handleSave: function() {

      }

    },
    watch: {

    },
    created: function() {

    }
  }

</script>

<style>
  .page1 .btn-group{margin: 10px 0;}
  .btn-group button{margin-right: 10px;padding: 10px 25px;}
</style>
-->
