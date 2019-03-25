<template>
  <csc-single-table :disableRowButtons='disableRowButtons' :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
                    @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>


</template>

<script>
  // import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryAfterLoanCheckRoster} from '@/api/afterloan'
  export default {
    name: "afterLoanCheckRoster",
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
              { label: '所属机构', inputType: 'input', modelName: 'orgNum' },
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '检查类型', inputType: 'select', modelName: 'checkType',enumType:'remindType' },
              { label: '检查截止日期', inputType: 'date', modelName: 'stDate' },
              { label: '完成情况', inputType: 'select', modelName: 'remindStatus',enumType:'ifAccount' },
              { label: '经办人', inputType: 'input', modelName: 'userNum' },
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '所属机构', prop: 'orgNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '客户类型', prop: 'partyTypeCd', isSort: true,isFormat:true,enumType:'CustomerClassCd' },
              { label: '预警级别', prop: 'warningLevelCd', isSort: true,isFormat:true,enumType:'warningLevelCd' },
              { label: '检查类型', prop: 'remindType', isSort: true ,isFormat:true,enumType:'remindType'},
              { label: '检查截止日期', prop: 'lastDate', isSort: true },
              { label: '完成情况', prop: 'remindStatus', isSort: true ,isFormat:true,enumType:'ifAccount'},
              { label: '经办人', prop: 'userNum', isSort: true },
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
        this.queryAfterLoanCheckRoster(listQuery)
      },

      queryAfterLoanCheckRoster(listQuery) {
        queryAfterLoanCheckRoster(listQuery).then(response => {
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
