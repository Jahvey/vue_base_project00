<template>

    <el-tabs v-model="pageDef.activeName" type="card" @tab-click="handleTabClick">

      <template  v-for="(tabPane,idx) in pageDef.tabPanes">
        <el-tab-pane :label="tabPane.tabName" :name="tabPane.name">

         <component :is="tabComponent"></component>




        </el-tab-pane>
      </template>

    </el-tabs>

</template>

<script>
  import CscElTableNaturalPersonTree from "../CscElTree/CscElTableNaturalPersonTree";

  //以下仅供测试  下面就是具体的页面内容

  const natural_info = resolve => require(['../../views/csm/natural/natural_info.vue'], resolve)
  const csm_entrust_account_list = resolve => require(['../../views/csm/account/csm_entrust_account_list.vue'], resolve)
  const natural_relative_list = resolve => require(['../../views/csm/natural/natural_relative_list.vue'], resolve)
  const natural_business = resolve => require(['../../views/csm/natural/natural_business.vue'], resolve)
  const natural_school = resolve => require(['../../views/csm/natural/natural_school.vue'], resolve)
  const natural_credit_list = resolve => require(['../../views/csm/natural/natural_credit_list.vue'], resolve)
  const csm_external_eval_result_list_in = resolve => require(['../../views/csm/corporation/csm_external_eval_result_list_in.vue'], resolve)
  const csm_impornant_event_list = resolve => require(['../../views/csm/corporation/csm_impornant_event_list.vue'], resolve)
  const ews_warn_main = resolve => require(['../../views/csm/corporation/ews_warn_main.vue'], resolve)
  const natural_additive_list = resolve => require(['../../views/csm/natural/natural_additive_list.vue'], resolve)
  const financing_list = resolve => require(['../../views/csm/myBank/financing_list.vue'], resolve)
  const financing_list_yewu = resolve => require(['../../views/csm/myBank/financing_list_yewu.vue'], resolve)
  const guarantee_list = resolve => require(['../../views/csm/myBank/guarantee_list.vue'], resolve)
  const guarantee_list_diya = resolve => require(['../../views/csm/myBank/guarantee_list_diya.vue'], resolve)
  const csm_illegal_list = resolve => require(['../../views/csm/corporation/csm_illegal_list.vue'], resolve)
  const refuse_list = resolve => require(['../../views/csm/myBank/refuse_list.vue'], resolve)
  const csm_manage_team_list = resolve => require(['../../views/csm/corporation/csm_manage_team_list.vue'], resolve)
  const pro_biz_upload = resolve => require(['../../views/csm/biz_info/pro_biz_upload.vue'], resolve)

    export default {
      name: "csc-el-csmnp-tabs-tree",
      tabComponent: 'natural_info',//2019-01-03 当前切换的组件
      data() {//切记 data是函数
        return {
          activeName:pageDef.activeName,//默认选中tab标签
        }
      },
      props:{
        pageDef: {
          type: Object,
          required: true
        },
        tabsDef: {
          type: Object,
          required: true
        }
      },
      components:{
        CscElTableNaturalPersonTree,
        natural_info,
        csm_entrust_account_list,
        natural_relative_list,
        natural_business,
        natural_school,
        natural_credit_list,
        csm_external_eval_result_list_in,
        csm_impornant_event_list,
        ews_warn_main,
        natural_additive_list,
        financing_list,
        financing_list_yewu,
        guarantee_list,
        guarantee_list_diya,
        csm_illegal_list,
        refuse_list,
        csm_manage_team_list,
        pro_biz_upload

      },

      //
      beforeCreate: function () {


      },

      //
      created: function() {

        this.tabComponent=natural_info;
        //console.log("this.tabComponent..................."+this.tabComponent)
        console.log("csc-el-csmnp-tabs-tree..................."+this.pageDef)
      },

      mounted: function(){

      },

      /**
       * handleTabClick 方法可将整个tab标签页下方内容包裹，动态切换的时候展示，每个标签页的内容可以写成一个vue文件，
       * 针对左侧有导航树的情况可视情况新增收缩按钮选项
       */
      methods: {
        handleTabClick(tab,event) {//
          console.log("handleTabClick:"+tab.name);
          this.tabComponent=tab.name;
        },
        nodeClick(url){
          console.log("nodeClick:"+url);
          this.tabComponent=url;
          // this.$router.push({path:obj});//针对从我的工作中进去的流程内容，用该方式实现
        }
      }
    }
</script>

<style scoped>
  .treeLeft {
    float:left;
    width:25%;
  }

  .treeRight {
    float: right;
    width: 75%;
  }
</style>
