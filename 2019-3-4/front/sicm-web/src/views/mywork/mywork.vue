<template>
  <div>
    <csc-tab-table :pageDef="pageDef">

    </csc-tab-table>
  </div>

</template>

<script>
 // import CscTabTable from "@/components/CscTabTable/CscTabTable"
    export default {
        name: "mywork",
        data() {
        return {
          pageDef: {
            activeName: "tab1",
            tabPanes: [
              {tabName: '待办列表', name: 'workinglist'},
              {tabName: '跟踪列表', name: 'workedlist'},
              {tabName: '提示列表', name: 'remind_total'}
            ]
          }
        }
        },

        components: {'csc-tab-table':CscTabTable},
        methods: {

        }
    }
</script>

<style scoped>

</style>
