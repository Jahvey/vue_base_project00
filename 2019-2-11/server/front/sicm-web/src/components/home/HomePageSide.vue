<template>
  <sidebar>
    <el-menu :default-active="1+''" background-color="#f5f7fb" class="customer-sidebar" :class="{ abso: isCollapse }" :collapse="isCollapse" router>
    <template v-for="(item) in mainRouter" :index="item.index">
      <el-submenu :index="item.index">
        <template slot="title">{{item.name}}</template>
        <el-menu-item v-for="child in item.children" @click="addTab(child.name,child.path)" index="aaa" :route="{path: child.path}" :key="child.path">{{child.name}}</el-menu-item>
      </el-submenu>
    </template>
    </el-menu>
  </sidebar>
</template>
<script >
  import Sidebar from '@/layouts/sidebar/Sidebar.vue'
    export default {
      data() {
            return {
              isCollapse: false,
              mainRouter: this.$store.state.nav.leftMenuList
            }
        },
      components: {
        'sidebar': Sidebar
      },
      methods: {
        doCollapse() {
          this.isCollapse = !this.isCollapse
          this.$root.eventHub.$emit('isCollapse', this.isCollapse)
        },
        addTab(targetName,path) {
          this.$store.commit('setAddMenuList', {
            name: targetName,
            path: path
          });
        }
      }
    }
</script>
