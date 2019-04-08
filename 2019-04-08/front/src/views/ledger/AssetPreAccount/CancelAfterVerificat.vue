<template>
    <csc-single-table :disableRowButtons='disableRowButtons' :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
                    @doDelete="doDelete"  @rowDbclick="rowDbclick">
    </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryWriteOff} from '@/api/Ledger'
    export default {
      name: "cancel-after-verificat",
      data() {
        return {
          disableRowButtons: true,
          entity: {
          },
          pageDef: {
            // 查询条件定义
            queryDef: {
              columnNum: 4, // 一行几列
              queryCols: [
                { label: '机构名称', inputType: 'input', modelName: 'regOrgId' },
                { label: '经办人', inputType: 'input', modelName: 'userNum' },
                { label: '客户名称', inputType: 'input', modelName: 'partyName' },
                { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
                { label: '证件号码', inputType: 'input', modelName: 'certNum' },
                { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
                { label: '借据编号', inputType: 'input', modelName: 'summaryNum' }
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: false, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '处置方案编号', prop: 'planNum', isSort: true },
                { label: '合同编号', prop: 'contractNum', isSort: true },
                { label: '借据编号', prop: 'summaryNum', isSort: true },
                { label: '客户名称', prop: 'partyName', isSort: true },
                { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
                { label: '证件号码', prop: 'certNum', isSort: true },
                { label: '业务品种', prop: 'productType', isSort: true },
                { label: '借据金额', prop: 'summaryAmt', isSort: true },
                { label: '借据余额', prop: 'summaryBal', isSort: true },
                { label: '借据起期', prop: 'sumEndDate', isSort: true },
                { label: '借据止期', prop: 'sumBeginDate', isSort: true },
                { label: '方案处置方式', prop: 'planType', isSort: true,isFormat:true,enumType:'disposalMethod' },
                { label: '核销本金', prop: 'cancelCapitalAmt', isSort: true },
                { label: '核销正常利息', prop: 'cancelNormalItr', isSort: true },
                { label: '核销拖欠利息', prop: 'cancelArrearItr', isSort: true },
                { label: '核销罚息', prop: 'cancelPunishItr', isSort: true },
                { label: '核销总额', prop: 'cancelAmt', isSort: true },
                { label: '是否保留追索权', prop: 'pursue', isSort: true,isFormat:true,enumType:'ifPrint' },
                { label: '经办机构', prop: 'regOrgId', isSort: true },
                { label: '经办人员', prop: 'userNum', isSort: true },
                { label: '经办日期', prop: 'regDate', isSort: true },
              ],
            }

          }
        }
      },
      components: { CscSingleTable },

      methods: {
        doPageQuery(listQuery) {
          this.queryWriteOff(listQuery)
        },

        queryWriteOff(listQuery) {
          queryWriteOff(listQuery).then(response => {
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }).catch((error) => {
            console.log(error)
          })
        },

        rowDbclick(row) {
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
        }
      },
      computed:{

      },
      created(){
       // alert(this.$store.getters.listLoading);
        //this.$store.setters.listLoading = true;
        //alert(1111);
        //alert(this.$store.getters.listLoading);
      },
    }
</script>

<style scoped>

</style>
