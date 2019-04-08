<template>
  <csc-single-table :disableRowButtons='disableRowButtons' :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
                    @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>

</template>

<script>
  // import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryFirstCheckReport} from '@/api/Afterloan'
  export default {
    name: "firstCheckReport",
    data() {
      return {
        disableRowButtons: true,
        entity: {
        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '借据编号', inputType: 'input', modelName: 'summaryNum' },
              { label: '报告编号', inputType: 'input', modelName: 'reportNum' }
            ]
          },
          tabDef: {
            isSelect: true, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户编号', prop: 'partyId', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '报告编号', prop: 'reportNum', isSort: true },
              { label: '报告名称', prop: 'reportName', isSort: true },
            ]
          },
          buttons: [
            { label: '查看', funcName: 'create' },
            { label: '下载打印', funcName: 'create' }
          ]
        }
      }
    },
    components: { CscSingleTable},

    methods: {
      doPageQuery(listQuery) {
        this.queryFirstCheckReport(listQuery)
      },

      queryFirstCheckReport(listQuery) {
        queryFirstCheckReport(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },

      /*  rowDbclick(row) {
          this.$router.push({ path: '/user/add/card/' + row.userId })
        },*/

      // create() {
      //   this.$router.push({ path: './firstCheck' })
      // },
      /* doEdit(row) {
         this.$router.push({ path: '/user/add/edit/' + row.userId })
       },
       doDelete(row, listQuery) {
         deleteUser(row).then(response => {
           this.userList(listQuery)
           this.$message({
             type: 'success',
             message: '删除成功!'
           })
         })
       }*/
    },

  }
</script>

<style scoped>

</style>
