<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>

</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryMonitorLedger} from '@/api/ledger'

  export default {
    name: "monitorLedger",
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
              { label: '监控类型', inputType: 'select', modelName: 'jklx',enumType:'MonitorType'},
              { label: '贷款品种', inputType: 'select', modelName: 'productType',enumType:'productType' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '借据编号', inputType: 'input', modelName: 'summaryNum' },
              { label: '借据起期', inputType: 'date', modelName: 'beginDate' },
              { label: '借据止期', inputType: 'date', modelName: 'endDate' },
              { label: '金额（万元）', inputType: 'select', modelName: 'summaryAmt1',enumType:'Amount' },
              { label: '天数', inputType: 'select', modelName: 'ts',enumType:'Days' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: false, // 是否有序号
            disableRowButtons:false,
            // 表格字段定义
            tabCols1: [
              { label: '机构名称', prop: 'orgNum', isSort: true ,isShow:true},
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true,isFormat: true,enumType:'productType'},
              { label: '合同编号', prop: 'contractNum', isSort: true},
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '币种', prop: 'summaryCurrencyCd', isSort: true, isFormat: true,enumType:'currencyCd' },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '逾期天数', prop: 'yqts', isSort: true },
              { label: '逾期本金', prop: 'jjyqbj', isSort: true },
              { label: '正常利息', prop: 'normalItr', isSort: true },
              { label: '拖欠利息', prop: 'arrearItr', isSort: true },
              { label: '罚息', prop: 'punishItr', isSort: true },
              { label: '还款账号', prop: 'zh', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true }
            ],
            tabCols2: [
              { label: '机构名称', prop: 'orgNum', isSort: true ,isShow:true},
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true,isFormat: true,enumType:'productType' },
              { label: '合同编号', prop: 'contractNum', isSort: true},
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '币种', prop: 'summaryCurrencyCd', isSort: true,isFormat: true,enumType:'currencyCd' },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '分类', prop: 'fljg', isSort: true ,isFormat: true,enumType:'fljg'},
              { label: '到期天数', prop: 'dqts', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true }
            ],
            tabCols3: [
              { label: '机构名称', prop: 'orgNum', isSort: true ,isShow:true},
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true, isFormat: true,enumType:'productType' },
              { label: '合同编号', prop: 'contractNum', isSort: true},
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '币种', prop: 'summaryCurrencyCd', isSort: true,isFormat: true,enumType:'currencyCd'},
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '分类', prop: 'fljg', isSort: true ,isFormat: true,enumType:'fljg' },
              { label: '已发放天数', prop: 'fkts', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true }
            ],
            tabCols4: [
              { label: '机构名称', prop: 'orgNum', isSort: true ,isShow:true},
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true,isFormat: true,enumType:'productType' },
              { label: '合同编号', prop: 'contractNum', isSort: true},
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '币种', prop: 'summaryCurrencyCd', isSort: true,isFormat: true,enumType:'currencyCd' },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '分类', prop: 'fljg', isSort: true ,isFormat: true,enumType:'fljg' },
              { label: '回收金额', prop: 'padUpPrn', isSort: true },
              { label: '回收日期', prop: 'rcvDate', isSort: true }
            ],
            tabCols5: [
              { label: '机构名称', prop: 'orgNum', isSort: true ,isShow:true},
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true,isFormat: true,enumType:'productType' },
              { label: '合同编号', prop: 'contractNum', isSort: true},
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '币种', prop: 'summaryCurrencyCd', isSort: true,isFormat: true,enumType:'currencyCd' },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '分类', prop: 'fljg', isSort: true ,isFormat: true,enumType:'fljg' },
              { label: '逾期天数', prop: 'yqts', isSort: true },
              { label: '正常利息', prop: 'normalItr', isSort: true },
              { label: '拖欠利息', prop: 'arrearItr', isSort: true },
              { label: '罚息', prop: 'punishItr', isSort: true }
            ]
          }
        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryMonitorLedger(listQuery)
      },

      queryMonitorLedger(listQuery) {
     //   alert(JSON.stringify(listQuery))
        queryMonitorLedger(listQuery).then(response => {
          if(listQuery.jklx===null || listQuery.jklx=== ' ' || listQuery.jklx==='1'){
            this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols1;
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }else if(listQuery.jklx && listQuery.jklx==='2'){
            this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols2;
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }else if(listQuery.jklx && listQuery.jklx==='3'){
            this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols3;
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }else if(listQuery.jklx && listQuery.jklx==='4'){
            this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols4;
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }else{
            this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols5;
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }
          /*this.entity = response.data
          this.$store.dispatch('setListLoading', true)*/
        }).catch((error) => {
          console.log(error)
        })
      },
      /*MonitorType(){
        var vm = new vue({el:MonitorType});
        var MonitorType = vm.$refs.MonitorType.innerText
        if(MonitorType==null||MonitorType==''||MonitorType==1)
      }*/
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
