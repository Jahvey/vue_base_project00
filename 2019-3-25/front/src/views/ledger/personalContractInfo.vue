<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryPersonalContractInfo} from '@/api/ledger'
  export default {
    name: "personal-contract-info",
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
              { label: '贷款品种', inputType: 'input', modelName: 'productType' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '合同状态', inputType: 'select', modelName: 'conStatus',enumType:'conStatus' },
              { label: '主担保方式', inputType: 'select', modelName: 'mainGuarantyType',enumType:'mainGuarantyType' },
              { label: '合同金额', inputType: 'input', modelName: 'contractAmt' },
              { label: '合同已用金额', inputType: 'input', modelName: 'conYuE' },
              { label: '起始日', inputType: 'date', modelName: 'beginDate' },
              { label: '到期日', inputType: 'date', modelName: 'endDate' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: false, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '机构名称', prop: 'orgNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '合同状态', prop: 'conStatus', isSort: true ,isFormat: true,enumType:'conStatus'},
              { label: '贷款品种', prop: 'productType', isSort: true, isFormat: true,enumType:'productType' },
              { label: '币种', prop: 'currencyCd', isSort: true, isFormat: true,enumType:'currencyCd'},
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '合同已用金额', prop: 'conYuE', isSort: true },
              { label: '主担保方式', prop: 'mainGuarantyType', isSort: true,isFormat: true,enumType:'mainGuarantyType'},
              { label: '起始日', prop: 'beginDate', isSort: true },
              { label: '到期日', prop: 'endDate', isSort: true },
              { label: '逾期天数', prop: 'yqts', isSort: true },
              { label: '分类', prop: 'fljg', isSort: true, isFormat: true,enumType:'fljg'},
              { label: '经办人', prop: 'userNum', isSort: true }
            ],
          }

        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryPersonalContractInfo(listQuery)
      },

      queryPersonalContractInfo(listQuery) {
        queryPersonalContractInfo(listQuery).then(response => {
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

