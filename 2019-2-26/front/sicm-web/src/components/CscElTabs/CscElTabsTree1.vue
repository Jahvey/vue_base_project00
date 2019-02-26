<template>

    <el-tabs v-model="tabsDef.activeName" type="card" @tab-click="handleTabClick">

      <template  v-for="(tabPane,idx) in tabsDef.tabPanes">
        <el-tab-pane :label="tabPane.tabName" :name="tabPane.name">

          <component :is="tabComponent"></component>




        </el-tab-pane>
      </template>

    </el-tabs>

</template>

<script>
  import CscElTableTree from "../CscElTree/CscElTableTree";

  //以下仅供测试  下面就是具体的页面内容

  const tab1 = resolve => require(['../../views/user/tab1.vue'], resolve)
  const tab2 = resolve => require(['../../views/user/tab2.vue'], resolve)
  const tab3 = resolve => require(['../../views/user/tab3.vue'], resolve)

    export default {
      name: "csc-el-tabs-tree",
      tabComponent: 'tab1',//2019-01-03 当前切换的组件
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
        CscElTableTree,
        tab1,
        tab2,
        tab3
      },

      //
      beforeCreate: function () {


      },

      //
      created: function() {
        this.tabComponent=tab1;
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
