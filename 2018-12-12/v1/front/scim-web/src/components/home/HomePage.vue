<template>
    <div class="wrap">
      <page-header/>
      <page-body>
        <page-sidebar/>
        <page-main-side>
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
        </page-main-side>
      </page-body>
      <page-footer/>
    </div>
</template>
<script>
    import Body from '@/layouts/body/Body'
    import Footer from '@/layouts/footer/Footer'
    import Header from '@/layouts/header/Header'
    import MainSide from '@/layouts/main/MainSide'
    import HomePageSide from './HomePageSide'

    export default {
      data() {
        return {}
      },
      components: {
        'page-header': Header,
        'page-body': Body,
        'page-main-side': MainSide,
        'page-sidebar': HomePageSide,
        'page-footer': Footer
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
