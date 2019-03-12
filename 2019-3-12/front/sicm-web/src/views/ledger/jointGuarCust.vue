<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {querGuarCustInfo} from '@/api/ledger'
    export default {
        name: "joint-guar-cust",
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
                { label: '联保小组编号', inputType: 'input', modelName: 'partyId' },
                { label: '联保小组成员', inputType: 'input', modelName: 'relatedCustPartyId' },
                { label: '成员社会信用代码', inputType: 'input', modelName: 'unifySocietyCreditNum' },
                { label: '成员营业执照', inputType: 'input', modelName: 'registerCode' },
                { label: '成员证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
                { label: '成员证件号码', inputType: 'input', modelName: 'certNum' },
                { label: '成员组织机构代码', inputType: 'input', modelName: 'orgRegisterCd' },
                { label: '成员中征码', inputType: 'input', modelName: 'middleCode' },
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '联保小组编号', prop: 'partyId', isSort: true },
                { label: '联保小组类型', prop: 'jointGuaranteeType', isSort: true },
                { label: '成员人数', prop: 'Id', isSort: true },
                { label: '联保小组状态', prop: 'jointGuaranteeStatus', isSort: true }
              ],
            }

          }
        }
      },
      components: { CscSingleTable },

      methods: {
        doPageQuery(listQuery) {
          this.querGuarCustInfo(listQuery)
        },

        querGuarCustInfo(listQuery) {
          querGuarCustInfo(listQuery).then(response => {
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
