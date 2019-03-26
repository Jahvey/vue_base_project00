<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>

</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryRepaymentPlan} from '@/api/Ledger'

  export default {
    name: "repaymentPlan",
    data() {
      return {
        entity: {},
        disableRowButtons:true,
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 4, // 一行几列
            queryCols: [
              { label: '机构名称', inputType: 'input', modelName: 'orgNum' },
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '借据编号', inputType: 'input', modelName: 'summaryNum' },
              { label: '还款日期', inputType: 'date', modelName: 'endDate' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            disableRowButtons:false,
            // 表格字段定义
            tabCols: [
              { label: '机构名称', prop: 'orgNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true, isFormat: true,enumType:'idTypeCd'},
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '还款日期', prop: 'endDate', isSort: true },
              { label: '还贷期次', prop: 'qc', isSort: true },
              { label: '应还本金', prop: 'bj', isSort: true },
              { label: '应还利息', prop: 'lx', isSort: true },
              { label: '应还本息合计', prop: 'amt', isSort: true },
              { label: '还款账号', prop: 'hkzh', isSort: true },
              { label: '联系方式', prop: 'phoneNumber', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true }
            ],
          }
        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryRepaymentPlan(listQuery)
      },

      queryRepaymentPlan(listQuery) {
        queryRepaymentPlan(listQuery).then(response => {
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
