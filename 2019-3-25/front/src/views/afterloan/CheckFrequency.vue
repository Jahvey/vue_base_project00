<template>
  <csc-single-table :disableRowButtons='disableRowButtons' :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
                    @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>


</template>

<script>
  // import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'

  import {queryCheckFrequency} from '@/api/afterloan'
  export default {
    name: "CheckFrequency",
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
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '所属机构', inputType: 'input', modelName: 'orgNum' },
              { label: '信用评级', inputType: 'input', modelName: 'creditRatingCd' },
              { label: '风险分类', inputType: 'select', modelName: 'classificationResultCd',enumType:'fljg' },
              { label: '是否异地', inputType: 'select', modelName: 'isDifferentPlace',enumType:'isDifferentPlace' },
              { label: '预警级别', inputType: 'select', modelName: 'warningLevelCd',enumType:'warningLevelCd' },
              { label: '监控名单类型', inputType: 'select', modelName: 'listStatus',enumType:'listStatus' },
              { label: '检查频率', inputType: 'select', modelName: 'setRate',enumType:'setRate' }
            ]
          },
          tabDef: {
            isSelect: true, // 是否可以多选
            isIndex: false, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '所属机构', prop: 'orgNum', isSort: true },
              { label: '客户类型', prop: 'customerTypeCd', isSort: true,isFormat:true,enumType:'CustomerClassCd' },
              { label: '信用等级', prop: 'creditRatingCd', isSort: true },
              { label: '风险分类', prop: 'classificationResultCd', isSort: true,isFormat:true,enumType:'fljg'},
              { label: '是否异地', prop: 'isDifferentPlace', isSort: true,isFormat:true,enumType:'isDifferentPlace'},
              { label: '预警级别', prop: 'warningLevelCd', isSort: true ,isFormat:true,enumType:'warningLevelCd'},
              { label: '监控名单类型', prop: 'listStatus', isSort: true ,isFormat:true,enumType:'listStatus'},
              { label: '检查频率(变更前)', prop: 'approveRate', isSort: true ,isFormat:true,enumType:'setRate'},
              { label: '检查频率(变更后)', prop: 'setRate', isSort: true,isFormat:true,enumType:'setRate' }
            ]
          },
          buttons: [
            { label: '设置', funcName: 'set' }
          ]
        }
      }
    },
    components: { CscSingleTable},

    methods: {
      doPageQuery(listQuery) {
        this.queryCheckFrequency(listQuery)
      },

      queryCheckFrequency(listQuery) {
        queryCheckFrequency(listQuery).then(response => {
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
