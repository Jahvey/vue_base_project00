<!--suppress ALL -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
      <el-form-item slot="mainContractShow" label="主合同详细信息" prop="mainContractShow"><!--这个label展示在下面-->
        <el-checkbox-group v-model="form.mainContractShow">
          <template v-for="(value,key) in srvObj"><!--遍历表单srvObj-->
            <el-col :span="8">
              <el-checkbox :key="value.roleId" :label="key" :name="key"><!--:key值需要更改，这里没有roleId-->
              </el-checkbox>
            </el-col>
          </template>
        </el-checkbox-group>
      </el-form-item>
    </csc-form-page>
  </div>
</template>

<script>
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  // import { getContractList } from '@/api/contract' // 暂时没有使用


  export default {
    data() {
      return {
        srvObj: {},
        form: {
          mainContractShow: [],
          partyName:'军育苗',
          partyNum:'011004323050',
          productType:'快帮贷',
          contractNum:'HT070020180906015681',
          paperConNum:'HT070020180906015681',
          oldContractNum:'暂无',
          currencyCd:'人民币',
          contractAmt:'10000.00',
          beginDate:'2018-09-06',
          contractTerm:'12月', // 这个写法有问题
          endDate:'2019-09-05',
          repaymentType:'等额本金',
          firstRepayTerm:'?', // 首次还款期次
          cycleIndCon:'否',
          contractDate:'2018-09-06',
          contractAddress:'1（南山）',
          specPaymentDate:'21',
          internalDays:'7',
          loanUse:'1(洋芋)', // 贷款用途
          guarantyType:'信用',
          mainGuarantyType:'信用',

          loanTurn:'防洪除涝设施管理',
          riskInfo:'未涉及',
          // act:''
          serviceType:'0-非节能环保项目及服务',
          ajustType:'奖励',
          upgradeType:'是',
          newProductType:'生物医药',
          whetherArgRelated:'否',
          greenLoan:'否'

        },
        refVisible: { pkOrg: false },
        pageDef: {
          disabled: true, // 页面按钮隐藏
          name: '用户信息',
          columnNum: 2,
          pageCols: [// 这里需要改为只读属性，格式有问题
            { label: '客户名称:', inputType: 'input', modelName: 'partyName' },
            { label: '客户编号:', inputType: 'input', modelName: 'partyNum' },
            { label: '业务品种:', inputType: 'input', modelName: 'productType' },
            { label: '合同编号:', inputType: 'input', modelName: 'contractNum' },
            { label: '纸质合同编号:', inputType: 'input', modelName: 'paperConNum' },
            { label: '原合同编号:', inputType: 'input', modelName: 'oldContractNum' },
            { label: '币种:', inputType: 'select', modelName: 'currencyCd' },
            { label: '金额:', inputType: 'input', modelName: 'contractAmt' },
            { label: '起始日期:', inputType: 'date', modelName: 'beginDate' },
            { label: '合同期限:', inputType: 'input', modelName: 'contractTerm' }, // 有疑问cycleUnit
            { label: '到期时间:', inputType: 'date', modelName: 'endDate' },
            { label: '还款方式:', inputType: 'select', modelName: 'repaymentType' },
            { label: '首次还款期次:', inputType: 'input', modelName: 'firstRepayTerm' },
            { label: '合同循环标识:', inputType: 'select', modelName: 'cycleIndCon' },
            { label: '签约日期:', inputType: 'date', modelName: 'contractDate' },
            { label: '签约地点:', inputType: 'input', modelName: 'contractAddress' },
            { label: '指定还款日:', inputType: 'input', modelName: 'specPaymentDate' },
            { label: '间隔天数:', inputType: 'input', modelName: 'internalDays' },
            { label: '贷款用途:', inputType: 'input', modelName: 'loanUse' },
            { label: '担保方式:', inputType: 'select', modelName: 'guarantyType' }, // 有问题，这里应该是一个checkbox，但是报错
            { label: '主担保方式:', inputType: 'select', modelName: 'mainGuarantyType' },

            { label: '行业投向:', inputType: 'select', modelName: 'loanTurn' },
            { label: '涉及环境、安全等重大情况：', inputType: 'select', modelName: 'riskInfo' },
            // { label: '采取措施：', inputType: 'select', modelName: 'act' },
            { label: '节能环保项目及服务类型：', inputType: 'select', modelName: 'serviceType' },
            // { label: '节能减排量：', inputType: 'select', modelName: 'reduceAmount' },
            { label: '产业结构调整类型：', inputType: 'select', modelName: 'ajustType' },
            { label: '工业转型升级标识：', inputType: 'select', modelName: 'upgradeType' },
            { label: '战略新兴产业类型：', inputType: 'select', modelName: 'newProductType' },
            { label: '是否涉农企业：', inputType: 'select', modelName: 'whetherArgRelated' },  // 注明分割
            // { label: '涉农企业类型：', inputType: 'select', modelName: 'argType' },
            // { label: '支农贷款类型：', inputType: 'select', modelName: 'supArgType' },
            { label: '是否绿色贷款：', inputType: 'select', modelName: 'greenLoan' },  // 贷款分割线
            // { label: '绿色贷款的贷款用途：', inputType: 'select', modelName: 'greenLoanUse' },
            // { label: '环境、安全等重大风险企业类别：', inputType: 'select', modelName: 'greenRiskType' },
            // { label: '涉及环境保护违法违规类型：', inputType: 'select', modelName: 'greenRiskDetail01' },
            // { label: '安全生产违法违规类型：', inputType: 'select', modelName: 'greenRiskDetail02' },
            // { label: '职业病预防控制措施不达标类型：', inputType: 'select', modelName: 'greenRiskDetail04' },

          ]
        }
      }
    },

    components: { CscFormPage },


    methods: {
      doCancel() {
        this.$router.back()
      },
      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

    },
    mounted() {				// 页面加载完毕之后进行的渲染
      this.contractList()
    }
  },
  }
</script>
