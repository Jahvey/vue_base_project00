<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>

</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryFundUseLedger} from '@/api/Ledger'

  export default {
    name: "fundUseLedgerQuery",
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
              { label: '支付日期', inputType: 'date', modelName: 'payTime' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: false, // 是否有序号
            disableRowButtons:false,
            // 表格字段定义
            tabCols: [
              { label: '机构名称', prop: 'orgNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true, isFormat: true,enumType:'idTypeCd'},
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '支付日期', prop: 'payTime ', isSort: true },
              { label: '币种', prop: 'summaryCurrencyCd', isSort: true,isFormat: true,enumType:'currencyCd' },
              { label: '支付金额', prop: 'applyAmount', isSort: true },
              { label: '支付对象', prop: 'payObject', isSort: true },
              { label: '贷款用途', prop: 'payUse', isSort: true },
              { label: '是否符合审批或约定用途', prop: 'isFitDeal', isSort: true }
            ],
          }
        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryFundUseLedger(listQuery)
      },

      queryFundUseLedger(listQuery) {
        queryFundUseLedger(listQuery).then(response => {
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
