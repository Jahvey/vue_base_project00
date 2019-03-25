<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>

</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryCustRateInfo} from '@/api/ledger'

  export default {
    name: "custRateQuery",
    data() {
      return {
        entity: {},
        disableRowButtons:true,
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '机构名称', inputType: 'input', modelName: 'orgname' },
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '信用等级', inputType: 'input', modelName: 'generalAdjustRatingCd' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            disableRowButtons:false,
            // 表格字段定义
            tabCols: [
              { label: '机构名称', prop: 'orgname', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true, isFormat: true,enumType:'idTypeCd'},
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '信用等级', prop: 'generalAdjustRatingCd', isSort: true },
              { label: '评级起期', prop: 'effectiveStartDt', isSort: true },
              { label: '评级止期', prop: 'effectiveEndDt', isSort: true },
              { label: '经办人', prop: 'operatorname', isSort: true }
            ],
          }
        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryCustRateInfo(listQuery)
      },

      queryCustRateInfo(listQuery) {
        queryCustRateInfo(listQuery).then(response => {
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
