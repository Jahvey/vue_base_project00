<template>

  <div>
    <h3>tab2 这是第一个标签页,左侧是配置节点树，右侧是内容区。20190115 根据传入的值动态加载左侧树 左侧树如何加载，右侧内容区 动态设置是否可编辑</h3>
    <!--下面是tab的内容 可以再根据组件数组封装-->
    <div class="treeLeft">
      <!-- 左边的类似于导航的树-->
      <!--<csc-el-contract-table-tree :treeDef="tabsDef" @nodeClick="nodeClick">-->

      <!--</csc-el-contract-table-tree>-->

      <csc-el-contract-table-tree @nodeClick="nodeClick">

      </csc-el-contract-table-tree>

      <!--<component :is="detailComponent"></component>-->

    </div>

    <!-- 右侧内容区-->
    <div class="treeRight">
      <component :is="detailComponent"></component>
    </div>

  </div>

</template>

<script>

  import CscElContractTableTree from "../../components/CscElTree/CscElContractTableTree";

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
    name: "tab2",
    data(){
      return {
        detailComponent: 'second',//2019-01-03 当前切换的组件
      }
    },
    props:{

      // pageDef: {
      //   type: Object,
      //   required: true
      // },
      // tabsDef: {
      //   type: Object,
      //   required: true
      // }


    },
    components:{
      "csc-el-contract-table-tree":CscElContractTableTree,
      first,
      second,
      third,
      four,
      five,
      six,
      seven,
      eight
    },

    beforeCreate: function(){

    },

    created: function(){
      this.detailComponent=second;
    },

    mounted: function () {

    },

    methods:{
      nodeClick(url){
        console.log("nodeClick:"+url);
        this.detailComponent=url;
        // this.$router.push({path:obj});//针对从我的工作中进去的流程内容，用该方式实现
      }
    }

  }
</script>

<style scoped>
  .treeLeft {
    float:left;
    width:20%;
  }

  .treeRight {
    float: right;
    width: 80%;
  }
</style>
