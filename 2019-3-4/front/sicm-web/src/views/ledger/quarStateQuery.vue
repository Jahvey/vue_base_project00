<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>

</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryQuarState} from '@/api/ledger'

  export default {
    name: "quarStateQuery",
    data() {
      return {
        entity: {},
        disableRowButtons:true,
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '机构名称', inputType: 'input', modelName: 'orgNum' },
              { label: '经办人', inputType: 'input', modelName: 'userNum' },
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '借据编号', inputType: 'input', modelName: 'summaryNum' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '季度日期', inputType: 'date', modelName: 'tsDate' },
              { label: '是否对账成功', inputType: 'select', modelName: 'ifAccount',enumType:'ifAccount' },
              { label: '是否已打印', inputType: 'select', modelName: 'ifPrint',enumType:'ifPrint' }
            ]
          },
          tabDef: {
            isSelect: true, // 是否可以多选
            isIndex: false, // 是否有序号
            disableRowButtons:false,
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '开始日期', prop: 'beginDate', isSort: true },
              { label: '结束日期', prop: 'endDate', isSort: true },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '对账标志', prop: 'ifAccount', isSort: true },
              { label: '是否已打印', prop: 'ifPrint', isSort: true, isFormat: true,enumType:'ifPrint'},
              { label: '季度日期', prop: 'tsDate', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true }
            ],
          }
        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryQuarState(listQuery)
      },

      queryQuarState(listQuery) {
        queryQuarState(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      }

      // rowDbclick(row) {
      //   this.$router.push({ path: '/user/add/card/' + row.userId })
      // },
      //
      // create() {
      //   this.$router.push({ path: '/user/add' })
      // },
      // doEdit(row) {
      //   this.$router.push({ path: '/user/add/edit/' + row.userId })
      // },
      // doDelete(row, listQuery) {
      //   deleteUser(row).then(response => {
      //     this.userList(listQuery)
      //     this.$message({
      //       type: 'success',
      //       message: '删除成功!'
      //     })
      //   })
      // }
    }

  }
</script>

<style scoped>

</style>
