<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryCooperaProjectQuota} from '@/api/Ledger'
  export default {
    name: "coopera-project-quota",
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
              { label: '第三方客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '合作项目名称', inputType: 'input', modelName: 'hzName' },
              { label: '业务品种', inputType: 'input', modelName: 'productType',enumType:'productType' },
              { label: '借据状态', inputType: 'select', modelName: 'summaryStatusCd',enumType:'summaryStatusCd' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '机构名称', prop: 'orgNum', isSort: true },
              { label: '第三方客户名称', prop: 'partyName', isSort: true },
              { label: '合作项目名称', prop: 'hzName', isSort: true },
              { label: '借款人名称', prop: 'partyName2', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '贷款品种', prop: 'loanSubject1', isSort: true,isFormat: true,enumType:'productType' },
              { label: '币种', prop: 'currencyCd', isSort: true, isFormat: true,enumType:'currencyCd' },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '借据状态', prop: 'summaryStatusCd', isSort: true, isFormat: true,enumType:'summaryStatusCd' },
              { label: '逾期天数', prop: 'yqts', isSort: true },
              { label: '逾期本金', prop: 'jjyqbj', isSort: true },
              { label: '正常利息', prop: 'normalItr', isSort: true },
              { label: '拖欠利息', prop: 'arrearItr', isSort: true },
              { label: '罚息', prop: 'newPnsItr', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true }
            ],
          }

        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryCooperaProjectQuota(listQuery)
      },

      queryCooperaProjectQuota(listQuery) {
        queryCooperaProjectQuota(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },

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



