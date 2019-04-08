<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryPersonalLendInfo} from '@/api/Ledger'
  export default {
    name: "personal-lend-info",
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
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '贷款品种', inputType: 'input', modelName: 'loanSubject1',enumType:'productType' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '借据编号', inputType: 'input', modelName: 'summaryNum'},
              { label: '借据状态', inputType: 'select', modelName: 'summaryStatusCd',enumType:'summaryStatusCd' },
              { label: '借据起期', inputType: 'date', modelName: 'beginDate' },
              { label: '借据止期', inputType: 'date', modelName: 'endDate' },
              { label: '借据金额', inputType: 'input', modelName: 'summaryAmt' },
              { label: '借据余额', inputType: 'input', modelName: 'jjye' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '机构名称', prop: 'orgNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '展期协议号', prop: 'periodNum', isSort: true },
              { label: '贷款品种', prop: 'loanSubject1', isSort: true,isFormat: true,enumType:'productType' },
              { label: '币种', prop: 'currencyCd', isSort: true, isFormat: true,enumType:'currencyCd' },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '展期到期日', prop: 'lastPayDate', isSort: true },
              { label: '借据状态', prop: 'summaryStatusCd', isSort: true, isFormat: true,enumType:'summaryStatusCd' },
              { label: '逾期天数', prop: 'yqts', isSort: true },
              { label: '逾期本金', prop: 'jjyqbj', isSort: true },
              { label: '正常利息', prop: 'normalItr', isSort: true },
              { label: '拖欠利息', prop: 'arrearItr', isSort: true },
              { label: '罚息', prop: 'newPnsItr', isSort: true },
              { label: '复利', prop: 'newFlItr', isSort: true },
              { label: '展期标志', prop: 'periodFlag', isSort: true, isFormat: true,enumType:'upgradeType'},
              { label: '展期状态', prop: 'periodState', isSort: true, isFormat: true,enumType:'periodState'},
              { label: '合作项目名称', prop: 'itemname', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true }
            ],
          }

        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryPersonalLendInfo(listQuery)
      },

      queryPersonalLendInfo(listQuery) {
        queryPersonalLendInfo(listQuery).then(response => {
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



