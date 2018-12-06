<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm"
       :disableRowButtons="disableRowButtons"             @contractList="contractList"    @enterAccount="enterAccount"
  @querysummaryInfo="querysummaryInfo" @repayCalc="repayCalc" @repayPlan="repayPlan" @printEnterAccountNote="printEnterAccountNote"
  @printClientReceipt="printClientReceipt" @printKHHD="printKHHD" @printLoanVoucher="printLoanVoucher"
  @printRepaymentVoucher="printRepaymentVoucher" @loanOrRepaymentRevocation="loanOrRepaymentRevocation">
  </csc-single-table>
</template>

<script>
  // 借据信息
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getContractList } from '@/api/contract'// 正常往后台发送异步请求的类
  //  import { getContractList } from '@/api/api'//api是自己写的用来测试mock假数据的路径，配置了这个之后mock会拦截正常请求

  export default {
    name: 'mortgageContract',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              SUMMARY_NUM: 'JJ243441',
              SUMMARY_CURRENCY_CD: '人民币',
              SUMMARY_AMT: '9879.00',
              JJYE: '2441.78',
              BEGIN_DATE: '2017-03-22',
              END_DATE: '2018-09-12',
              YEAR_RATE: '3.5',
              SUMMARY_STATUS_CD: '生效',
              ORG_NUM: '猪肉检疫局',
              USER_NUM: '唐马儒'
            }
          ]
        },
        // disableQueryForm: true,
        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '借据编号', prop: 'SUMMARY_NUM', isSort: true },
              { label: '币种', prop: 'SUMMARY_CURRENCY_CD', isSort: true },
              { label: '借据金额', prop: 'SUMMARY_AMT', isSort: true }, // currency：货币
              { label: '借据余额', prop: 'JJYE', isSort: true },
              { label: '借据起期', prop: 'BEGIN_DATE', isSort: true },
              { label: '借据止期', prop: 'END_DATE', isSort: true },
              { label: '利率（%）', prop: 'YEAR_RATE', isSort: true },
              { label: '借据状态', prop: 'SUMMARY_STATUS_CD', isSort: true },
              { label: '经办机构', prop: 'ORG_NUM', isSort: true },
              { label: '经办人', prop: 'USER_NUM', isSort: true }
            ]
          },
          buttons: [
            { label: '出账', funcName: 'enterAccount' },
            { label: '查看借据', funcName: 'querysummaryInfo' },
            { label: '还款试算', funcName: 'repayCalc' },
            { label: '还款计划', funcName: 'repayPlan' },
            { label: '打印出账通知书', funcName: 'printEnterAccountNote' },
            { label: '打印客户回单', funcName: 'printClientReceipt' },
            { label: '打印受托方结算信息回单', funcName: 'printKHHD' },
            { label: '打印放款凭证', funcName: 'printLoanVoucher' },
            { label: '打印还款凭证', funcName: 'printRepaymentVoucher' },
            { label: '放款/还款撤销', funcName: 'loanOrRepaymentRevocation' }
          ]
        }
      }
    },

    components: { CscSingleTable }, // 引入的子组件
    // mounted()页面加载完毕之后进行的渲染
    // computed: {				// 页面加载完毕之后进行的渲染
    //   disableQueryForm() {
    //     return this.disableQueryForm
    //   }
    // },

    methods: {
      doPageQuery() {
        // this.contractList(listQuery)
        // console.log('doPageQuery...')
      },

      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

        this.listLoading = true
        console.log('listQuery ....' + listQuery)
        getContractList(params).then(response => {
          this.entity = response
          // console.log(" response.data.entity"+ response.data.entity)
          this.listLoading = false
        }).catch((error) => {
          // alert(error)
          console.log(error)
        })
      },
      enterAccount() { // 重置表单就是直接清空表单里面的数据
        alert('出账')
      },
      querysummaryInfo() {
        alert('查看借据')
      },
      repayCalc() {
        alert('还款试算')
      },
      repayPlan() {
        alert('还款计划')
      },
      printEnterAccountNote() {
        alert('打印出账通知书')
      },
      printClientReceipt() {
        alert('打印客户回单')
      },
      printKHHD() {
        alert('打印受托方结算信息回单')
      },
      printLoanVoucher() {
        alert('打印放款凭证')
      },
      printRepaymentVoucher() {
        alert('打印还款凭证')
      },
      loanOrRepaymentRevocation() {
        alert('放款/还款撤销')
      }
    },
    computed: { // 计算属性
      disabled() { // 控制页面渲染
        // return this.disableQueryForm = true
      }

    },
    mounted() {
      this.contractList() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
