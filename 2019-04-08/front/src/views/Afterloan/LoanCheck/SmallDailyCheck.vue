<template>
  <csc-single-table :disableRowButtons='disableRowButtons' :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
                    @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>

</template>

<script>
  // import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {querySmallDailyCheck} from '@/api/Afterloan'
  export default {
    name: "smallDailyCheck",
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
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '中征码', inputType: 'input', modelName: 'middleCode' }
            ]
          },
          tabDef: {
            isSelect: true, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户编号', prop: 'partyId', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '中征码', prop: 'middleCode', isSort: true },
              { label: '贷款金额', prop: 'summaryAmt', isSort: true },
              { label: '贷款余额', prop: 'jjye', isSort: true }
            ]
          },
          buttons: [
            { label: '创建', funcName: 'create' }
          ]
        }
      }
    },
    components: { CscSingleTable},

    methods: {
      doPageQuery(listQuery) {
        this.querySmallDailyCheck(listQuery)
      },

      querySmallDailyCheck(listQuery) {
        querySmallDailyCheck(listQuery).then(response => {
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
