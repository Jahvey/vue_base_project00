<!--suppress ALL -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
      <el-form-item slot="mainContractDetailShow" label="主合同明细信息" prop="mainContractDetailShow"><!--这个label展示在下面-->
        <el-checkbox-group v-model="form.mainContractDetailShow">
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
  // 主合同明细信息，下面有2个tab表单和一个text文本框我该怎么引入？？？http://192.168.1.105:7001/default/crt/con_info/con_detail_ht_xw_uncycle.jsp
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  


  export default {
    data() {
      return {
        srvObj: {},
        form: {
          mainContractDetailShow: [],
          payWay:'自主支付',
          leastPrepayAmount:'',
          prepayJs:'',
          prepaymentPenalty:'否',
          rateType:'固定利率',
          yearRate:'3.5',
          irUpdateFrequency:'不调整',  // 利率调整方式
          interestCollectType:'按季节息',
          holidayFlg:'否',
          gracePeriodType:'无宽限期',
          overdueRateUpProportion:'50',

          aSendAddr:'1(华阳)',
          aPostcode:'621000', // 首次还款期次
          aReceiver:'土狗',
          aPhone:'110',
          bSendAddr:'2(双流)',
          bPostcode:'622000', // 首次还款期次
          bReceiver:'花你妈',
          bPhone:'119',
          cSendAddr:'3(大邑)',
          cPostcode:'623000', // 首次还款期次
          cReceiver:'江狗',
          cPhone:'120',
          dSendAddr:'4(高新)',
          dPostcode:'624000', // 首次还款期次
          dReceiver:'高飞',
          dPhone:'129',

          arbitrateType:'诉讼',
          aHoldCount:'3',
          bHoldCount:'3',
          totalCount:'6', // 贷款用途
        },
        refVisible: { pkOrg: false },
        pageDef: {
          disabled: true, // 页面按钮隐藏
          name: '用户信息',
          columnNum: 2,
          pageCols: [// 格式有问题
            { label: '资金支付方式:', inputType: 'select', modelName: 'payWay' }, // 明细信息 // 本来是用的是checkbox
            { label: '提前还款最低金额:', inputType: 'input', modelName: 'leastPrepayAmount' },
            { label: '提前还款基数(元):', inputType: 'input', modelName: 'prepayJs' },
            { label: '提前还款是否收取违约金:', inputType: 'select', modelName: 'prepaymentPenalty' },
            // { label: '违约金比例%:', inputType: 'input', modelName: 'prepayMakeupRate' },

            { label: '利率类型:', inputType: 'select', modelName: 'rateType' },  // 利率信息
            { label: '申请利率（%）:', inputType: 'input', modelName: 'yearRate' },
            { label: '利率调整方式:', inputType: 'select', modelName: 'irUpdateFrequency' },
            { label: '结息周期:', inputType: 'select', modelName: 'interestCollectType' },
            { label: '节假日顺延标志:', inputType: 'select', modelName: 'holidayFlg' }, // 有疑问cycleUnit
            // { label: '节假日利息处理方式:', inputType: 'date', modelName: 'holidayIntFlg' },
            { label: '宽限期方式:', inputType: 'select', modelName: 'gracePeriodType' },
            { label: '逾期罚息率（%）:', inputType: 'input', modelName: 'overdueRateUpProportion' },

            { label: '甲方送达地址:', inputType: 'input', modelName: 'aSendAddr' },  // 甲方通知文书送达
            { label: '甲方邮编:', inputType: 'input', modelName: 'aPostcode' },
            { label: '甲方收件人:', inputType: 'input', modelName: 'aReceiver' },
            { label: '甲方电话:', inputType: 'input', modelName: 'aPhone' },
            { label: '甲方电子邮箱:', inputType: 'input', modelName: 'aEmail' },
            { label: '甲方其他方式:', inputType: 'input', modelName: 'aOther' },
            { label: '乙方送达地址:', inputType: 'input', modelName: 'bSendAddr' },  // 乙方通知文书送达
            { label: '乙方邮编:', inputType: 'input', modelName: 'bPostcode' },
            { label: '乙方收件人:', inputType: 'input', modelName: 'bReceiver' },
            { label: '乙方电话:', inputType: 'input', modelName: 'bPhone' },
            { label: '乙方电子邮箱:', inputType: 'input', modelName: 'bEmail' },
            { label: '乙方其他方式:', inputType: 'input', modelName: 'bOther' },
            { label: '丙方送达地址:', inputType: 'input', modelName: 'cSendAddr' },  // 丙方通知文书送达
            { label: '丙方邮编:', inputType: 'input', modelName: 'cPostcode' },
            { label: '丙方收件人:', inputType: 'input', modelName: 'cReceiver' },
            { label: '丙方电话:', inputType: 'input', modelName: 'cPhone' },
            { label: '丙方电子邮箱:', inputType: 'input', modelName: 'cEmail' },
            { label: '丙方其他方式:', inputType: 'input', modelName: 'cOther' },
            { label: '丁方送达地址:', inputType: 'input', modelName: 'dSendAddr' },  // 丁方通知文书送达
            { label: '丁方邮编:', inputType: 'input', modelName: 'dPostcode' },
            { label: '丁方收件人:', inputType: 'input', modelName: 'dReceiver' },
            { label: '丁方电话:', inputType: 'input', modelName: 'dPhone' },
            { label: '丁方电子邮箱:', inputType: 'input', modelName: 'dEmail' },
            { label: '丁方其他方式:', inputType: 'input', modelName: 'dOther' },

            { label: '争议解决方式:', inputType: 'select', modelName: 'arbitrateType' }, // 仲裁方式

            { label: '甲方持有份数:', inputType: 'input', modelName: 'aHoldCount' },  // 签署协议
            { label: '乙方持有份数:', inputType: 'input', modelName: 'bHoldCount' },
            { label: '丙方持有份数:', inputType: 'input', modelName: 'dHoldCount' },  // d
            { label: '丁方持有份数:', inputType: 'input', modelName: 'eHoldCount' },  // e
            { label: '第三方名称:', inputType: 'input', modelName: 'cName' },
            { label: '第三方方持有份数:', inputType: 'input', modelName: 'cHoldCount' },
            { label: '共计份数:', inputType: 'input', modelName: 'totalCount' }
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
