<template>

<div>
  <h3>这是第四个标签页 左侧是导航菜单 右侧是内容区</h3>
  <!--下面是tab的内容 可以再根据组件数组封装-->
  <!--<div class="treeLeft">-->
    <!--&lt;!&ndash; 左边的类似于导航的树&ndash;&gt;-->
    <!--<el-menu-->
      <!--default-active="1"-->
      <!--class="el-menu-vertical-demo">-->
      <!--<el-menu-item index="1" v-on:click="onMenuItemClick('1','')">-->
        <!--<i class="el-icon-document"></i>-->
        <!--<span slot="title">概况</span>-->
      <!--</el-menu-item>-->
      <!--<el-menu-item index="2" v-on:click="onMenuItemClick('2','')">-->
        <!--<i class="el-icon-document"></i>-->
        <!--<span slot="title">详细信息</span>-->
      <!--</el-menu-item>-->
      <!--<el-menu-item index="3" v-on:click="onMenuItemClick('3','')">-->
        <!--<i class="el-icon-document"></i>-->
        <!--<span slot="title">保险信息</span>-->
      <!--</el-menu-item>-->
      <!--<el-menu-item index="4" v-on:click="onMenuItemClick('4','')">-->
        <!--<i class="el-icon-document"></i>-->
        <!--<span slot="title">登记信息</span>-->
      <!--</el-menu-item>-->
      <!--<el-menu-item index="5" v-on:click="onMenuItemClick('5','')">-->
        <!--<i class="el-icon-document"></i>-->
        <!--<span slot="title">公证信息</span>-->
      <!--</el-menu-item>-->
      <!--<el-menu-item index="6" v-on:click="onMenuItemClick('6','')">-->
        <!--<i class="el-icon-document"></i>-->
        <!--<span slot="title">意外情况</span>-->
      <!--</el-menu-item>-->
      <!--<el-menu-item index="7" v-on:click="onMenuItemClick('7','')">-->
        <!--<i class="el-icon-document"></i>-->
        <!--<span slot="title">过户信息</span>-->
      <!--</el-menu-item>-->
    <!--</el-menu>-->


  <!--</div>-->

  <!--&lt;!&ndash; 右侧内容区&ndash;&gt;-->
  <!--<div class="treeRight">-->
    <!--<component :is="detailComponent"></component>-->
  <!--</div>-->

  <el-row>
 <el-col :span="3">
   <el-menu
   default-active="1"
   class="el-menu-vertical-demo">
   <el-menu-item index="1" v-on:click="onMenuItemClick('1','')">
   <i class="el-icon-document"></i>
   <span slot="title">概况</span>
   </el-menu-item>
   <el-menu-item index="2" v-on:click="onMenuItemClick('2','')">
   <i class="el-icon-document"></i>
   <span slot="title">详细信息</span>
   </el-menu-item>
   <el-menu-item index="3" v-on:click="onMenuItemClick('3','')">
   <i class="el-icon-document"></i>
   <span slot="title">保险信息</span>
   </el-menu-item>
   <el-menu-item index="4" v-on:click="onMenuItemClick('4','')">
   <i class="el-icon-document"></i>
   <span slot="title">登记信息</span>
   </el-menu-item>
   <el-menu-item index="5" v-on:click="onMenuItemClick('5','')">
   <i class="el-icon-document"></i>
   <span slot="title">公证信息</span>
   </el-menu-item>
   <el-menu-item index="6" v-on:click="onMenuItemClick('6','')">
   <i class="el-icon-document"></i>
   <span slot="title">意外情况</span>
   </el-menu-item>
   <el-menu-item index="7" v-on:click="onMenuItemClick('7','')">
   <i class="el-icon-document"></i>
   <span slot="title">过户信息</span>
   </el-menu-item>
   </el-menu>
</el-col>

<el-col :span="21">
  <component v-bind:is="detailComponent"></component>
  <!--<router-view></router-view>-->
</el-col>

  </el-row>



</div>

</template>

<script>

  import CscElTableTree from "../../components/CscElTree/CscElTableTree";

  import first from "../../views/user/first.vue";
  import second from "../../views/user/second.vue";
  import third from "../../views/user/third.vue";
  //以下仅供测试  下面就是具体的页面内容
  // const first = resolve => require(['../../views/user/first.vue'], resolve)
  // const second = resolve => require(['../../views/user/second.vue'], resolve)
  // const third = resolve => require(['../../views/user/third.vue'], resolve)
  const four = resolve => require(['../../views/user/four.vue'], resolve)
  const five = resolve => require(['../../views/user/five.vue'], resolve)
  const six = resolve => require(['../../views/user/six.vue'], resolve)
  const seven = resolve => require(['../../views/user/seven.vue'], resolve)
  const eight = resolve => require(['../../views/user/eight.vue'], resolve)



    export default {
      name: "tab4",
      data() {
        return {
          detailComponent: 'four',//2019-01-03 当前切换的组件
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
        "csc-el-table-tree":CscElTableTree,
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
        // this.detailComponent=four;
      },

      mounted: function () {

      },

      methods:{
        onMenuItemClick:function (index,obj) {//展示当前页面的逻辑
          if(index == '1'){
            this.detailComponent = first;
            console.log("动态切换成功了吗？"+this.detailComponent);
            // this.$router.push({ name: 'first', query: { orgInfoId: '1',method:'doEdit' }})
          }else if(index == "2"){
            this.detailComponent = seven;
            console.log("动态切换成功了吗？"+this.detailComponent);
            // this.$router.push({ name: 'first', query: { orgInfoId: '1',method:'doEdit' }})
          }  else if(index == "3"){
            this.detailComponent = second;
            console.log("动态切换成功了吗？"+this.detailComponent);
            // this.$router.push({ name: 'second', query: { orgInfoId: '1',method:'doEdit' }})
          } else if(index == "4"){
            this.detailComponent = third;
            console.log("动态切换成功了吗？"+this.detailComponent);
            // this.$router.push({ path: '/user/third' });
          } else if(index == "5"){
            this.detailComponent = four;
            console.log("动态切换成功了吗？"+this.detailComponent);
            // this.$router.push({ path: '/user/four' });
          } else if(index == "6"){
            this.detailComponent = five;
            console.log("动态切换成功了吗？"+this.detailComponent);
            // this.$router.push({ path: '/user/five' });
          } else if(index == "7"){
            this.detailComponent = six;
            console.log("动态切换成功了吗？"+this.detailComponent);
            // this.$router.push({ path: '/user/six' });
          }
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
