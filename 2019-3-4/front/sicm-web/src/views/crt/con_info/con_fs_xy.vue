<!--suppress ALL -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
    </csc-form-page>
  </div>
</template>

<script>
  // 主合同基本信息  /crt/con_info/con_info_ht_xw.jsp
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  //import {getConInfoByContractNum} from '@/api/contract' // 暂时没有使用


  export default {
    data() {
      return {
        srvObj: {},
        form: {},
        refVisible: {pkOrg: false},
        pageDef: {
          disabled: true, // 页面按钮隐藏
          name: '协议附属信息',
          columnNum: 2,
          pageCols: [
            {label: '客户名称:', inputType: 'input', modelName: 'partyName'},
            {label: '客户编号:', inputType: 'input', modelName: 'partyNum'},
            {label: '业务品种:', inputType: 'select', modelName: 'productType',enumType: 'productType'},
            {label: '合同编号:', inputType: 'input', modelName: 'contractNum'},
            {label: '纸质合同编号:', inputType: 'input', modelName: 'paperConNum'},
            {label: '原合同编号:', inputType: 'input', modelName: 'oldContractNum'},
            {label: '币种:', inputType: 'select', modelName: 'currencyCd',enumType: 'currencyCd'},
            {label: '金额:', inputType: 'input', modelName: 'contractAmt'},
            {label: '起始日期:', inputType: 'date', modelName: 'beginDate'},
            {label: '合同期限:', inputType: 'select', modelName: 'contractTerm'}, // 有疑问cycleUnit：期限单位
            {label: '期限单位:', inputType: 'select', modelName: 'cycleUnit'}, // 有疑问cycleUnit：期限单位
            {label: '到期日期:', inputType: 'date', modelName: 'endDate'},
            {label: '还款方式:', inputType: 'select', modelName: 'repaymentType',enumType: 'repaymentType'},
            {label: '首次还款期次:', inputType: 'input', modelName: 'firstRepayTerm'},
            {label: '合同循环标识:', inputType: 'select', modelName: 'cycleIndCon',enumType: 'cycleIndCon'},
            {label: '签约日期:', inputType: 'date', modelName: 'contractDate'},
            {label: '签约地点:', inputType: 'input', modelName: 'contractAddress'},
            {label: '指定还款日:', inputType: 'input', modelName: 'specPaymentDate'},
            {label: '间隔天数:', inputType: 'input', modelName: 'internalDays'},
            {label: '贷款用途:', inputType: 'input', modelName: 'loanUse'},
            {label: '担保方式:', inputType: 'select', modelName: 'guarantyType',enumType: 'guarantyType'}, // 做成checkbox
            {label: '主担保方式:', inputType: 'select', modelName: 'mainGuarantyType',enumType: 'mainGuarantyType'},

            {label: '行业投向:', inputType: 'select', modelName: 'loanTurn',enumType: 'loanTurn'},
            {label: '涉及环境、安全等重大情况：', inputType: 'select', modelName: 'riskInfo',enumType: 'riskInfo'},
            { label: '采取措施：', inputType: 'select', modelName: 'act' },
            {label: '节能环保项目及服务类型：', inputType: 'select', modelName: 'serviceType',enumType: 'serviceType'},
            { label: '节能减排量：', inputType: 'select', modelName: 'reduceAmount' },
            {label: '产业结构调整类型：', inputType: 'select', modelName: 'ajustType',enumType: 'ajustType'},
            {label: '工业转型升级标识：', inputType: 'select', modelName: 'upgradeType',enumType: 'upgradeType'},
            {label: '战略新兴产业类型：', inputType: 'select', modelName: 'newProductType',enumType: 'newProductType'},
            {label: '是否涉农企业：', inputType: 'select', modelName: 'whetherArgRelated',enumType: 'whetherArgRelated'},
            { label: '涉农企业类型：', inputType: 'select', modelName: 'argType' },
            { label: '支农贷款类型：', inputType: 'select', modelName: 'supArgType' },
            {label: '是否绿色贷款：', inputType: 'select', modelName: 'greenLoan',enumType: 'greenLoan'},
            { label: '绿色贷款的贷款用途：', inputType: 'select', modelName: 'greenLoanUse' },
            { label: '环境、安全等重大风险企业类别：', inputType: 'select', modelName: 'greenRiskType' },
            { label: '涉及环境保护违法违规类型：', inputType: 'select', modelName: 'greenRiskDetail01' },//checkbox
            { label: '安全生产违法违规类型：', inputType: 'select', modelName: 'greenRiskDetail02' },//checkbox
            { label: '职业病预防控制措施不达标类型：', inputType: 'select', modelName: 'greenRiskDetail04' }//checkbox
          ]
        }
      }
    },

    components: {CscFormPage},
    created() {
      // this.getConInfoByContractNum(this.$store.state.urlParam.queryParam.contractNum)
      let param=this.$store.state.urlParam.queryParam
      this.getConInfoByContractNum(param)
    },

    methods: {
      async getConInfoByContractNum(param) {
        console.log("[con_fs_xy] param:"+JSON.stringify(param))

        // getConInfoByContractNum(param).then(response => {  
        //   this.form = response.data
        //   console.log(this.form)
        // }).catch((error) => {
        //   console.log(error)
        // })
      },

      doCancel() {
        this.$router.back()
      }
      // ,
      // mounted() {				// 页面加载完毕之后进行的渲染
      //   this.getConInfoByContractNum()
      // }
    },
  }
</script>
