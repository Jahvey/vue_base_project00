<template>
  <el-submenu v-if="menu.children && menu.children.length >= 1" :index="menu.menuid + ''">
    <template slot="title">
      <i :class="menu.imagepath" ></i>
      <span slot="title">{{menu.menuname}}</span>
    </template>
    <MenuTree v-for="item in menu.children" :key="item.menuid" :menu="item"></MenuTree>
  </el-submenu>
  <el-menu-item v-else :index="menu.menuid + ''" @click="handleRoute(menu)">
    <i :class="menu.imagepath"></i>
    <span slot="title">{{menu.menuname}}</span>
  </el-menu-item>
</template>

<script>
import { getIFrameUrl, getIFramePath } from '@/utils/iframe'
export default {
  name: 'MenuTree',
  props: {
    menu: {
      type: Object,
      required: true
    }
  },
  methods: {
    handleRoute (menu) {
    // 如果是嵌套页面，转换成iframe的path
    let path = getIFramePath(menu.menuaction)
    if(!path) {
      path = menu.menuaction
    }
    // 通过菜单URL跳转至指定路由
    this.$router.push("/")
    this.$router.push(path)
    }
  }
}
</script>

<style scoped lang="scss">
// .el-submenu, .el-menu-item {
//   background-color: #3c4b5a44;
// }
</style>