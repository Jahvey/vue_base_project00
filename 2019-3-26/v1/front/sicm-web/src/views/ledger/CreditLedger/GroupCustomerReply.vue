<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
    import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
    import {queryGroupCustomerReply} from '@/api/Ledger'
    export default {
        name: "group-customer-reply",
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
                { label: '客户名称', inputType: 'input', modelName: 'partyName' },
                { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
                { label: '证件号码', inputType: 'input', modelName: 'certNum' },
                { label: '批复编号', inputType: 'input', modelName: 'approvalNum' },
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '机构名称', prop: 'orgNum', isSort: true },
                { label: '客户名称', prop: 'partyName', isSort: true },
                { label: '批复编号', prop: 'approvalNum', isSort: true },
                { label: '业务性质', prop: 'bizType', isSort: true },
                { label: '币种', prop: 'currencyCd', isSort: true },
                { label: '批复金额', prop: 'creditAmount', isSort: true },
                { label: '已用金额', prop: 'creditUsed', isSort: true },
                { label: '可用余额', prop: 'creditAvi', isSort: true },
                { label: '起始日', prop: 'validDate', isSort: true },
                { label: '到期日', prop: 'endDate', isSort: true },
                { label: '经办人', prop: 'userNum', isSort: true }
              ],
            }

          }
        }
      },
      components: { CscSingleTable },

      methods: {
        doPageQuery(listQuery) {
          this.queryGroupCustomerReply(listQuery)
        },

        queryGroupCustomerReply(listQuery) {
          queryGroupCustomerReply(listQuery).then(response => {
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }).catch((error) => {
            console.log(error)
          })
        },

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
