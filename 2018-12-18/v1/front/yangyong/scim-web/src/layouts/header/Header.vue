<template>
    <div class="page-header">
      <div class="logo"><router-link to="/">京北方资管系统</router-link></div>
      <div class="top-nav">
        <el-menu :default-active="activeIndex" class="el-menu-demo"
                 background-color="#3668b3"
                 text-color="#fff"
                 mode="horizontal" @select="handleSelect">
          <el-submenu index="2">
            <template slot="title">我的工作台</template>
            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>
            <el-menu-item index="2-3">选项3</el-menu-item>
          </el-submenu>
        </el-menu>
      </div>
    </div>
</template>
<script>
    export default {
      data() {
        return {
          activeIndex: '2'
        };
      },
      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        }
      }
    }
</script>

<style lang="less" scoped>
  .page-header {
    position: relative;
    width: 100%;
    height: 60px;
    background: #3668b3;
    clear: both;
    .logo {
      width: 220px;
      height: 40px;
      float: left;
      margin: 10px auto 10px 20px;
      overflow: hidden;
      a {
        color: #fff;
        font-size: 20px;
      }
      img {
        height: 40px;
      }
    }
  }

</style>
