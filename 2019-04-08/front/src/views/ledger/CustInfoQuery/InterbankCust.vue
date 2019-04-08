<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {querySametradeCust} from '@/api/Ledger'
    export default {
        name: "interbank-cust",
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
                { label: '区域类型', inputType: 'select', modelName: 'areaType',enumType:'regionaType' },
                { label: '金融机构类型', inputType: 'select', modelName: 'financeEnterpriseType',enumType:'financialInstitutionsType' },
                { label: '客户名称', inputType: 'input', modelName: 'partyName' },
                { label: '统一社会信用代码', inputType: 'input', modelName: 'unifySocietyCreditNum' },
                { label: '营业执照', inputType: 'input', modelName: 'registerCode' },
                { label: '组织机构代码', inputType: 'input', modelName: 'orgRegisterCd'},
                { label: 'Swift码', inputType: 'input', modelName: 'swiftBicNum' }
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '机构名称', prop: 'orgNum', isSort: true },
                { label: '区域类型', prop: 'areaType', isSort: true, isFormat: true,enumType:'regionaType' },
                { label: '金融机构类型', prop: 'financeEnterpriseType', isSort: true, isFormat: true,enumType:'financialInstitutionsType' },
                { label: '客户名称', prop: 'partyName', isSort: true },
                { label: '统一社会信用代码', prop: 'unifySocietyCreditNum', isSort: true },
                { label: '营业执照', prop: 'registerCode', isSort: true },
                { label: '组织机构代码', prop: 'orgRegisterCd', isSort: true },
                { label: 'swift码', prop: 'swiftBicNum', isSort: true },
                { label: '管户经理', prop: 'userNum', isSort: true }
              ],
            }

          }
        }
      },
      components: { CscSingleTable },

      methods: {
        doPageQuery(listQuery) {
          this.querySametradeCust(listQuery)
        },

        querySametradeCust(listQuery) {
          querySametradeCust(listQuery).then(response => {
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
