<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryPubCust} from '@/api/Ledger'
    export default {
      name: "pub-cust",
      data() {
        return {
          entity: {},
          disableRowButtons:true,
          pageDef: {

            // 查询条件定义
            queryDef: {
              columnNum: 4, // 一行几列
              queryCols: [
                { label: '机构名称', inputType: 'input', modelName: 'orgname' },
                { label: '客户名称', inputType: 'input', modelName: 'partyName' },
                { label: '组织机构代码', inputType: 'input', modelName: 'orgRegisterCd' },
                { label: '统一社会信用代码', inputType: 'input', modelName: 'unifySocietyCreditNum' },
                { label: '营业执照', inputType: 'input', modelName: 'registrCd' },
                { label: '客户性质', inputType: 'select', modelName: 'corpCustomerTypeCd',enumType:'customeNature' },
                { label: '中征码', inputType: 'input', modelName: 'middleCode' },
                { label: '第三方客户类型', inputType: 'select', modelName: 'thirdCustTypeCd',enumType:'thirdCustomeType' }
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '机构名称', prop: 'orgname', isSort: true },
                { label: '客户名称', prop: 'partyName', isSort: true },
                { label: '统一社会信用代码', prop: 'unifySocietyCreditNum', isSort: true },
                { label: '客户性质', prop: 'corpCustomerTypeCd', isSort: true,isFormat: true,enumType:'customeNature'},
                { label: '营业执照', prop: 'registrCd', isSort: true },
                { label: '组织机构代码', prop: 'orgRegisterCd', isSort: true },
                { label: '中征码', prop: 'middleCode', isSort: true },
                { label: '行业类型', prop: 'industrialTypeCd', isSort: true,isFormat: true,enumType:'loanTurn' },
                { label: '企业规模', prop: 'enterpriseScaleGx', isSort: true,isFormat: true,enumType:'enterpriseScale' },
                { label: '信用等级', prop: 'generalAdjustRatingCd', isSort: true},
                { label: '第三方客户类型', prop: 'thirdCustTypeCd', isSort: true,isFormat: true,enumType:'thirdCustomeType' },
                { label: '管户经理', prop: 'userNum', isSort: true }
              ],
            }

          }
        }
      },
      components: { CscSingleTable },

      methods: {
        doPageQuery(listQuery) {
          this.queryPubCust(listQuery)
        },

        queryPubCust(listQuery) {
          queryPubCust(listQuery).then(response => {
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }).catch((error) => {
            console.log(error)
          })
        }

       /* rowDbclick(row) {
          this.$router.push({ path: '/user/add/card/' + row.userId })
        },

        create() {
          this.$router.push({ path: '/user/add' })
        },
        doEdit(row) {
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
      }
    }
</script>

<style scoped>

</style>
