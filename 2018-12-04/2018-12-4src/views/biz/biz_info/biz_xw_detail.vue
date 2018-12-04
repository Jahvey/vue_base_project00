<!--suppress ALL -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
      <el-form-item slot="clientBaseInfoShow" label="客户基本信息" prop="clientBaseInfoShow"><!--这个label展示在下面-->
        <el-checkbox-group v-model="form.clientBaseInfoShow">
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
  // 业务结构之业务明细 /default/biz/biz_info/biz_xw_detail.jsp
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  // import { getContractList } from '@/api/contract' // 暂时没有使用


  export default {
    data() {
      return {
        srvObj: {},
        form: {
          clientBaseInfoShow: [],
          applyXwAmt:'011004323050',
          applyXwTerm:'军育苗',
          certType:'居民身份证',
          certNum:'510721196601019530',
          csmCrdLevel:'无',
          productType:'快帮贷',
          bizHappenType:'存量新增',
          bizNum:'YW180906015696',
          rmbAmt:'20,000.00',
          termNum:'12月',
          guarantyType:'信用',
          isBankTeamLoan:'否',
          becomeEffectiveMark:'已生效',
          orgNum:'0700',
          userNum:'李谭荔',
          applyDate:'2018-09-06'
        },
        refVisible: { pkOrg: false },
        pageDef: {
          disabled: true, // 页面按钮隐藏，并且变为只读属性
          name: '用户信息',
          columnNum: 2,
          pageCols: [// 格式有问题
            { label: '申报金额:', inputType: 'input', modelName: 'applyXwAmt' },
            { label: '申请期限:', inputType: 'input', modelName: 'applyXwTerm' }, // 这个始终是有点问题的，格式
            { label: '申请日期:', inputType: 'date', modelName: 'applyDate' },
            { label: '共同借款人:', inputType: 'input', modelName: 'gtjkr' },  // 需要更改
            { label: '业务品种:', inputType: 'input', modelName: 'productType' },
            { label: '币种:', inputType: 'input', modelName: 'currencyCd' },
            { label: '申报金额:', inputType: 'input', modelName: 'detailAmt' },
            // { label: '汇率:', inputType: 'input', modelName: 'exchangeRate' },
            // { label: '折算人民币金额:', inputType: 'input', modelName: 'rmbAmt' },
            { label: '还款方式:', inputType: 'select', modelName: 'repaymentType' },
            // { label: '首次还本期次:', inputType: 'select', modelName: 'firstRepayTerm' }, // checkbox
            { label: '还款来源:', inputType: 'input', modelName: 'payment' },
            { label: '贷款用途:', inputType: 'input', modelName: 'loanUse' },
            { label: '利率类型:', inputType: 'select', modelName: 'rateType' },
            // { label: '浮动方式:', inputType: 'select', modelName: 'floatWay' },
            // { label: '浮动比例(%):', inputType: 'select', modelName: 'rateFloatProportion' },
            { label: '申请利率(%):', inputType: 'input', modelName: 'yearRate' },
            { label: '利率调整方式:', inputType: 'select', modelName: 'irUpdateFrequency' },
            { label: '结息周期:', inputType: 'select', modelName: 'interestCollectType' },
            { label: '节假日顺延标志:', inputType: 'select', modelName: 'holidayFlg' },
            { label: '宽限期方式:', inputType: 'select', modelName: 'gracePeriodType' },
            { label: '逾期罚息率(%):', inputType: 'input', modelName: 'overdueRateUpProportion' },
            { label: '申请日期:', inputType: 'date', modelName: 'applyDate' }
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
