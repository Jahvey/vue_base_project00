<template>
  <div class="app-wrapper" :class="{hideSidebar:!sidebar.opened}">
    <sidebar class="sidebar-container"></sidebar>
    <div class="main-container">
      <navbar></navbar>
      <app-main>

        <div>
          <el-tabs v-model="editableTabsValue2" type="card" closable @tab-click="tabClick" @tab-remove="removeTab">
            <el-tab-pane
              v-for="(item, index) in editableTabs2"
              :key="item.name"
              :label="item.name"
              :name="item.name"
            >
              <router-view/>
            </el-tab-pane>
          </el-tabs>
        </div>

      </app-main>
    </div>
  </div>
</template>

<script>
import { Navbar, Sidebar, AppMain } from '@/views/layout/components'

export default {
  name: 'layout',
  data() {
    return {}
  },
  components: {
    Navbar,
    Sidebar,
    AppMain
  },
  computed: {
    editableTabsValue2: {
      get() {
        if(this.$store.state.menu.showTab !== null &&
          this.$store.state.menu.showTab !== undefined){
          return this.$store.state.menu.showTab.name
        }
      },
      set() {
        //
      }
    },
    editableTabs2: {
      get() {
        return this.$store.state.menu.menuList
      },
      set() {
        //
      }

    },
    sidebar() {
      return this.$store.state.app.sidebar
    }
  },
  methods: {
    removeTab(targetName) {
      console.log("targetName: ",targetName);
      this.$store.commit('setDeleteMenuList', {
        name: targetName,
        path: ""
      });
      if(this.$store.state.menu.showTab !== null &&
        this.$store.state.menu.showTab !== undefined){
        let path = this.$store.state.menu.showTab.path;
        this.$router.push({path: path});
      }
    },
    tabClick(tab){
      let arr = this.$store.state.menu.menuList;
      this.$router.push({
        path: arr[tab.index].path
      });

    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
@import "src/styles/mixin.scss";
.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;
}
</style>
