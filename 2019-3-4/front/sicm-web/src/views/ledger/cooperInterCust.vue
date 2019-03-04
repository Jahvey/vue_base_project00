<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create"
                    @rowDbclick="rowDbclick" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
    import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
    import {queryThirdCust} from '@/api/ledger'
    export default {
        name: "cooper-inter-cust",
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
                { label: '合作中介类型', inputType: 'select', modelName: 'corpCustomerTypeCd',enumType:'cooperInterType' },
                { label: '客户名称', inputType: 'input', modelName: 'partyName'},
                { label: '统一社会信用代码', inputType: 'input', modelName: 'unifySocietyCreditNum' },
                { label: '营业执照', inputType: 'input', modelName: 'registrCd' },
                { label: '组织机构代码', inputType: 'input', modelName: 'orgRegisterCd' },
                { label: '中征码', inputType: 'input', modelName: 'middelCode' }
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '机构名称', prop: 'orgNum', isSort: true },
                { label: '客户名称', prop: 'partyName', isSort: true },
                { label: '统一社会信用代码', prop: 'unifySocietyCreditNum', isSort: true },
                { label: '合作中介类型', prop: 'corpCustomerTypeCd', isSort: true, isFormat: true,enumType:'cooperInterType' },
                { label: '营业执照', prop: 'registrCd', isSort: true },
                { label: '组织机构代码', prop: 'orgRegisterCd', isSort: true },
                { label: '中征码', prop: 'middelCode', isSort: true },
                { label: '信用等级', prop: 'creditTypeCd', isSort: true },
                { label: '管户经理', prop: 'userNum', isSort: true }
              ],
            }
            // buttons: [
            //   { label: '查询', funcName: 'query',disabled:false },
            //   { label: '重置', funcName: 'reset',disabled:false }
            // ]
          }
        }
      },
      components: { CscSingleTable },

      methods: {
        doPageQuery(listQuery) {
          this.queryThirdCust(listQuery)
        },

        queryThirdCust(listQuery) {
          queryThirdCust(listQuery).then(response => {
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
