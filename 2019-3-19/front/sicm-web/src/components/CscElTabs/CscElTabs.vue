<template>

    <el-tabs v-model="tabsDef.activeName" type="card" @tab-click="handleTabClick">

      <template  v-for="(tabPane,idx) in tabsDef.tabPanes">
        <el-tab-pane :label="tabPane.tabName" :name="tabPane.name">

          <div>

            <!--下面是tab的内容 可以再根据组件数组封装-->
            <div class="treeLeft">
              <!-- 左边的类似于导航的树-->
              <csc-el-tree :treeDef="tabsDef" @nodeClick="nodeClick">
              </csc-el-tree>
            </div>

            <!-- 右侧内容区-->
            <div class="treeRight">
              <component :is="tabComponent"></component>
            </div>

          </div>




        </el-tab-pane>
      </template>

    </el-tabs>

</template>

<script>
  import CscElTree from "../CscElTree/CscElTree";

  //以下仅供测试  下面就是具体的页面内容
  const first = resolve => require(['../../views/user/first.vue'], resolve)
  const second = resolve => require(['../../views/user/second.vue'], resolve)
  const third = resolve => require(['../../views/user/third.vue'], resolve)
  const four = resolve => require(['../../views/user/four.vue'], resolve)
  const five = resolve => require(['../../views/user/five.vue'], resolve)
  const six = resolve => require(['../../views/user/six.vue'], resolve)
  const seven = resolve => require(['../../views/user/seven.vue'], resolve)
  const eight = resolve => require(['../../views/user/eight.vue'], resolve)


    export default {
      name: "csc-el-tabs",
      tabComponent: 'first',//2019-01-03 当前切换的组件
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
        CscElTree,
        first,
        second,
        third,
        four,
        five,
        six,
        seven,
        eight
      },

      //
      beforeCreate: function () {

      },

      //
      created: function() {
        this.tabComponent=first;
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
