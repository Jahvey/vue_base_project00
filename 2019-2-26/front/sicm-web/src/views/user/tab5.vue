<template>

<div>
  <h3>这是第五个标签页 左侧是导航菜单内附多级导航菜单 右侧是内容区</h3>
  <!--下面是tab的内容 可以再根据组件数组封装 后面可依据配置等动态组装-->
  <el-row>
 <el-col :span="6">
   <el-menu
   default-active="3"
   background-color="#545c64"
   text-color="#fff"
   active-text-color="#ffd04b"
   :collapse="isCollapse"
   class="el-menu-vertical-demo">

   <el-submenu>
     <template slot="title">
       <i class="el-icon-location"></i>
       <span>业务结构</span>
     </template>

     <el-menu-item index="1-1" v-on:click="onMenuItemClick('1-1','')">
       <i class="el-icon-document"></i>
       <span slot="title">基本信息</span>
     </el-menu-item>

     <el-menu-item index="1-2" v-on:click="onMenuItemClick('1-2','')">
       <i class="el-icon-document"></i>
       <span slot="title">明细信息</span>
     </el-menu-item>

     <el-menu-item index="1-3" v-on:click="onMenuItemClick('1-3','')">
       <i class="el-icon-document"></i>
       <span slot="title">家庭财务信息</span>
     </el-menu-item>

     <el-menu-item index="1-4" v-on:click="onMenuItemClick('1-4','')">
       <i class="el-icon-document"></i>
       <span slot="title">合作项目额度信息</span>
     </el-menu-item>

     <el-menu-item index="1-5" v-on:click="onMenuItemClick('1-5','')">
       <i class="el-icon-document"></i>
       <span slot="title">贴息信息</span>
     </el-menu-item>

     <el-menu-item index="1-6" v-on:click="onMenuItemClick('1-6','')">
       <i class="el-icon-document"></i>
       <span slot="title">监管报送信息</span>
     </el-menu-item>

   </el-submenu>

     <el-submenu>
       <template slot="title">
         <i class="el-icon-location"></i>
         <span>担保评价</span>
       </template>

       <el-menu-item index="2-1" v-on:click="onMenuItemClick('2-1','')">
         <i class="el-icon-document"></i>
         <span slot="title">保证人</span>
       </el-menu-item>

       <el-menu-item-group title="抵押">

         <el-menu-item index="2-2-1" v-on:click="onMenuItemClick('2-2-1','')">
           <i class="el-icon-document"></i>
           <span slot="title">抵押物</span>
         </el-menu-item>

         <el-menu-item index="2-2-2" v-on:click="onMenuItemClick('2-2-2','')">
           <i class="el-icon-document"></i>
           <span slot="title">最高额担保合同关联</span>
         </el-menu-item>

       </el-menu-item-group>

       <el-menu-item-group title="质押">

         <el-menu-item index="2-3-1" v-on:click="onMenuItemClick('2-3-1','')">
           <i class="el-icon-document"></i>
           <span slot="title">质押物</span>
         </el-menu-item>

         <el-menu-item index="2-3-2" v-on:click="onMenuItemClick('2-3-2','')">
           <i class="el-icon-document"></i>
           <span slot="title">最高额担保合同关联</span>
         </el-menu-item>
       </el-menu-item-group>

       <el-menu-item index="2-4" v-on:click="onMenuItemClick('2-4','')">
         <i class="el-icon-document"></i>
         <span slot="title">保证金</span>
       </el-menu-item>

       <el-menu-item index="2-5" v-on:click="onMenuItemClick('2-5','')">
         <i class="el-icon-document"></i>
         <span slot="title">信用保险</span>
       </el-menu-item>

     </el-submenu>


     <el-menu-item index="3" v-on:click="onMenuItemClick('3','')">
       <i class="el-icon-document"></i>
       <span slot="title">关联风险预警</span>
     </el-menu-item>

     <el-menu-item index="4" v-on:click="onMenuItemClick('4','')">
       <i class="el-icon-document"></i>
       <span slot="title">岗位责任</span>
     </el-menu-item>

     <el-menu-item index="5" v-on:click="onMenuItemClick('5','')">
       <i class="el-icon-document"></i>
       <span slot="title">业务同意发放通知书</span>
     </el-menu-item>

     <el-menu-item index="6" v-on:click="onMenuItemClick('6','')">
       <i class="el-icon-document"></i>
       <span slot="title">影像资料</span>
     </el-menu-item>

     <el-menu-item index="7" v-on:click="onMenuItemClick('7','')">
       <i class="el-icon-document"></i>
       <span slot="title">意见</span>
     </el-menu-item>

   </el-menu>
</el-col>

<el-col :span="18">
  <component v-bind:is="detailComponent"></component>
  <!--<router-view></router-view>-->
</el-col>

  </el-row>



</div>

</template>

<script>

  import CscElTableTree from "../../components/CscElTree/CscElTableTree";

  // import first from "../../views/user/first.vue";
  // import second from "../../views/user/second.vue";
  // import third from "../../views/user/third.vue";
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
      name: "tab5",
      data() {
        return {
          detailComponent: 'five',//2019-01-03 当前切换的组件
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
          }else if(index == '1-4'){
            this.detailComponent = seven;
            console.log("动态切换成功了吗？"+this.detailComponent);
          }else if(index =='2-2-1'){
            this.detailComponent = eight;
            console.log("动态切换成功了吗？"+this.detailComponent);
          } else if(index =='2-2-2'){
            this.detailComponent = seven;
            console.log("动态切换成功了吗？"+this.detailComponent);
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
