<template>
  <div>
    <el-tabs v-model="pageDef.activeName" type="card" @tab-click="handleClick">
      <template  v-for="(tabPane,idx) in pageDef.tabPanes">
        <el-tab-pane :label="tabPane.tabName" :name="tabPane.name">

          <component :is="tabComponent"></component>

        </el-tab-pane>
      </template>
    </el-tabs>
  </div>

</template>

<script>
  const workinglist = resolve => require(['../../views/mywork/workinglist.vue'], resolve)
  const workedlist = resolve => require(['../../views/mywork/workedlist.vue'], resolve)
  const remind_total = resolve => require(['../../views/mywork/remind_total.vue'], resolve)
    export default {
        name: "CscTabTable",
        props: {
        pageDef: {
          type: Object,
          required: true
          }
        },
        data() {
          return {
            tabComponent: this.pageDef.activeName
          }
         },

      components: {
        workinglist,
        workedlist,
        remind_total
      },

      beforeCreate: function(){

      },

      created: function () {
        // this.tabComponent=this.pageDef.activeName;
      },

      methods: {
        handleClick(tab, event) {//tab选项卡切换
          console.log("handleTabClick:"+tab.name);
          this.tabComponent=tab.name;
        }
      }
    }
</script>

<style scoped>

</style>
