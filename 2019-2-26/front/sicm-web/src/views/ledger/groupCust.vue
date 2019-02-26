<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
    import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
    import {queryGroupCorporation} from '@/api/ledger'
    export default {
        name: "group-cust",
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
                { label: '集团客户编号', inputType: 'input', modelName: 'partyNum' },
                { label: '集团客户名称', inputType: 'input', modelName: 'partyName'},
                { label: '成员客户名称', inputType: 'input', modelName: 'memberName' },
                { label: '成员营业执照', inputType: 'input', modelName: 'memberRegistrCd' },
                { label: '成员组织机构代码', inputType: 'input', modelName: 'memberOrgRegisterCd' },
                { label: '成员证件类型', inputType: 'select', modelName: 'memberCertType',enumType:'idTypeCd' },
                { label: '成员证件号码', inputType: 'input', modelName: 'memberCertNum' },
                { label: '成员中征码', inputType: 'input', modelName: 'memberMiddelCode' }
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '集团客户编号', prop: 'partyNum', isSort: true },
                { label: '集团客户名称', prop: 'partyName', isSort: true },
                { label: '集团客户管理方式', prop: 'groupManageWayCd', isSort: true, isFormat: true,enumType:'groupManageWayCd' },
                { label: '认定状态', prop: 'status', isSort: true, isFormat: true,enumType:'cognizanceStatus' },
                { label: '主办行', prop: 'orgNum', isSort: true },
                { label: '主办管户经理', prop: 'userNum', isSort: true }
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
          this.queryGroupCorporation(listQuery)
        },

        queryGroupCorporation(listQuery) {
          queryGroupCorporation(listQuery).then(response => {
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }).catch((error) => {
            console.log(error)
          })
        },

        /*rowDbclick(row) {
          this.$router.push({ path: '/user/add/card/' + row.userId })
        },

        create() {
          this.$router.push({ path: '/user/add' })
        },*/
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
