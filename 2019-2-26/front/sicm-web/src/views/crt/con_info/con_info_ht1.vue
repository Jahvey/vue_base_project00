<!--con_info_ht的信息，使用原生element-ui写这个界面-->
<template>
  <el-row :gutter="20" class="form">
    <el-form el-form label-width="200px" size="mini" :rules="rules" :model="conInfoForm" ref="conInfoForm"
             label-position="right"
             :disabled=isconInfoForm>
      <el-col :span="12">
        <el-form-item label="客户名称:" prop="partyName" class="special-input">
          <el-input v-model="conInfoForm.partyName" style="width:100%" :disabled=true></el-input>
          <!--style="width:150px"-->
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="客户编号:" prop="partyNum" class="special-input">
          <el-input v-model="conInfoForm.partyNum" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="业务品种:" prop="productType" class="special-input">
         <el-select v-model="conInfoForm.productType" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in productType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="合同编号:" prop="contractNum" class="special-input">
          <el-input v-model="conInfoForm.contractNum" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="币种:" prop="currencyCd" class="special-input">
          <el-select v-model="conInfoForm.currencyCd" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in currencyCd" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="本次出账金额:" prop="loanAmt" class="special-input">
          <el-input v-model="conInfoForm.loanAmt" style="width:100%" :disabled=isLoanAmt
                    @change="childAmtChange"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="起始日:" prop="beginDate" class="special-input">
          <el-date-picker type="date" format="yyyy-MM-dd" v-model="conInfoForm.beginDate"
                          @change="childValidateBeginDate"
                          style="width:100%"></el-date-picker><!--validateBeginDate-->
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="放款期限:" prop="loanSubject1" class="special-input">
          <el-input v-model="conInfoForm.term" style="width:60%;float:left" @blur="getChildConEndate"></el-input>
          <!--@blur="getConEndate"-->
          <el-select v-model="conInfoForm.unit" style="width:40%;float:left" :disabled=true>
            <!--@change="countConEndate"-->
            <el-option v-for="(value,key) in unit" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="到期日:" prop="endDate" class="special-input"><!--@change=""getTerm""-->
          <el-date-picker type="date" format="yyyy-MM-dd" v-model="conInfoForm.endDate"
                          style="width:100%"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="还款方式:" prop="repayType" class="special-input">
          <el-select v-model="conInfoForm.repayType" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in repayType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="约定还款日:" prop="specPaymentDate" class="special-input">
          <el-input v-model="conInfoForm.specPaymentDate" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="基准利率(%):" prop="baseRateValue" class="special-input">
          <el-input v-model="conInfoForm.baseRateValue" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="利率类型:" prop="rateType" class="special-input">
          <el-select v-model="conInfoForm.rateType" style="width:100%" :disabled=true><!--@change="onselectType"-->
            <el-option v-for="(value,key) in rateType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="浮动方式:" prop="floatWay" class="special-input" v-if="isFloatWay">
          <el-select v-model="conInfoForm.floatWay" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in floatWay" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="浮动比例(%):" prop="rateFloatProportion" class="special-input" v-if="isRateFloatProportion">
          <el-input v-model="conInfoForm.rateFloatProportion" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="利率(%):" prop="yearRate" class="special-input">
          <el-input v-model="conInfoForm.yearRate" style="width:100%" :disabled=isYearRate></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="利率调整方式:" prop="irUpdateFrequency" class="special-input">
          <el-select v-model="conInfoForm.irUpdateFrequency" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in irUpdateFrequency" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="结息周期:" prop="interestCollectType" class="special-input">
          <el-select v-model="conInfoForm.interestCollectType" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in interestCollectType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="节假日顺延标志:" prop="holidayFlg" class="special-input"><!--@change="conChangeHoliday"-->
          <el-select v-model="conInfoForm.holidayFlg" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in holidayFlg" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="节假日利息处理方式:" prop="holidayIntFlg" class="special-input" v-show=isHolidayIntFlg>
          <el-select v-model="conInfoForm.holidayIntFlg" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in holidayIntFlg" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="宽限期方式:" prop="gracePeriodType" class="special-input"><!--@change="onselectGrace"-->
          <el-select v-model="conInfoForm.gracePeriodType" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in gracePeriodType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="宽限期天数:" prop="gracePeriodDay" class="special-input" v-show=isGracePeriodDay>
          <el-input v-model="conInfoForm.gracePeriodDay" style="width:100%" :disabled=isGracePeriodDay></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="宽限期利息处理方式:" prop="graceCountIntFlag" class="special-input" v-show=isGraceCountIntFlag>
          <el-select v-model="conInfoForm.graceCountIntFlag" style="width:100%" :disabled=isGraceCountIntFlag>
            <el-option v-for="(value,key) in graceCountIntFlag" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </el-form>
  </el-row>
</template>

<script>
 // import {getInitPayInfo, getInitProductType} from '@/api/loanInfo'
  import getConInfoByContarctId from '@/api/csm'
  import enums from "@/utils/enums"//格式化的枚举

  export default {
    name: "conInfoHt1",

    components: {
      //引入的组件
    },
    props: {
      conInfoParam: {
        //con_tree传递过来的参数放在这里
      }
    },
    data() {
      return {
        // isLoanAmt: false,//本次出账金额，默认可以修改
        // isFloatWay: true,
        // isRateFloatProportion: true,
        // isYearRate: true,
        // isHolidayIntFlg: true,//节假日利息
        // isGracePeriodDay: true,//宽限期
        // isGraceCountIntFlag: true,
        isconInfoForm: false,//默认表单可以编辑


        conInfoForm: {//初始化loan_info的form表单
          partyName: '',
          partyNum: '',
          productType: '',
          contractNum: '',
          paperConNum: '',
          oldContractNum: '',
          currencyCd: '',
          contractAmt: '',
          bzjbl: '',
          beginDate: '',
          contractTerm: '',
          cycleUnit: '',
          endDate: '',
          repaymentType: '',
          firstRepayTerm: '',
          specPaymentDate: '',
          internalDays: '',
          cycleIndCon: '',
          contractDate: '',
          contractAddress: '',
          loanUse: '',
          exchangeRate: '',
          rmbAmt: '',
          guarantyType: '',

          mainGuarantyType:'',
          agriculLoans:'',
          loanTurn:'',
          riskInfo:'',
          act:'',
          serviceType:'',
          reduceAmount:'',
          ajustType:'',
          upgradeType:'',
          newProductType:'',
          rhbzffl:'',
          yjbzffl:'',
          whetherArgRelated:'',
          argType:'',
          supArgType:'',
          greenLoan:'',
          greenLoanUse:'',
          greenRiskType:'',
          greenRiskDetail01:'',
          greenRiskDetail02:'',
          greenRiskDetail04:''

        },
        rules: {//表单验证
          // loanAmt: [//表单出账验证有巨大的问题，暂时放在这里，明天空了处理
          //   {required: true, message: '出账不允许为空', trigger: 'blur'},
          //   {type: 'number', message: '请输入数字', trigger: 'blur'},
          //   // {min: 100, max: 999999999999, message: '请在出账范围内出账', trigger: 'blur'}//有问题
          // ]
        },
        currencyCd: enums.currencyCd,//币种格式化
        unit: enums.unit,//期限单位
        irUpdateFrequency: enums.irUpdateFrequency,//利率调整方式
        repayType: enums.repaymentType,//还款方式
        rateType: enums.rateType,//利率类型：XD_SXCD1016
        floatWay: enums.floatWay,//浮动方式：XD_SXCD1147
        interestCollectType: enums.interestCollectType,//结息周期：XD_SXCD1018
        holidayFlg: enums.holidayFlg,//节假日顺延标志：XD_0002
        holidayIntFlg: enums.holidayIntFlg,//节假日利息处理方式：XD_SXYW0234
        gracePeriodType: enums.gracePeriodType,//宽限期方式：XD_SXYW0210
        graceCountIntFlag: enums.holidayIntFlg,//宽限期利息处理方式：XD_SXYW0234
      }

    },
    created() {
      let param = this.payInfoParam
      console.log(param.o)
      console.log(param.childFlag.isYearRate)
      this.initLoanInfo(param)
    },
    methods: {
      initLoanInfo(data) {//初始化出账信息
        let childData = data.o
        // this.conInfoForm = childData.loanInfo
        this.conInfoForm.loanNum = childData.loanInfo.loanNum
        this.conInfoForm.ntcNum = childData.loanInfo.loanNum
        this.conInfoForm.loanSubject1 = childData.loanInfo.loanSubject1
        this.conInfoForm.currencyCd = childData.loanInfo.currencyCd
        this.conInfoForm.loanAmt = childData.loanInfo.loanAmt
        this.conInfoForm.beginDate = childData.loanInfo.beginDate
        this.conInfoForm.term = childData.loanInfo.term
        this.conInfoForm.unit = childData.loanInfo.unit
        this.conInfoForm.endDate = childData.loanInfo.endDate
        this.conInfoForm.repayType = childData.loanInfo.repayType
        this.conInfoForm.specPaymentDate = childData.contractInfo.specPaymentDate
        this.conInfoForm.productName = childData.tbBizProductInfo.productName
        this.conInfoForm.baseRateValue = childData.loanrate.baseRateValue
        this.conInfoForm.rateType = childData.loanrate.rateType
        this.conInfoForm.floatWay = childData.loanrate.floatWay
        this.conInfoForm.rateFloatProportion = childData.loanrate.rateFloatProportion
        this.conInfoForm.yearRate = childData.loanrate.yearRate
        this.conInfoForm.irUpdateFrequency = childData.loanrate.irUpdateFrequency
        this.conInfoForm.interestCollectType = childData.loanrate.interestCollectType
        this.conInfoForm.holidayFlg = childData.loanrate.holidayFlg
        this.conInfoForm.holidayIntFlg = childData.loanrate.holidayIntFlg
        this.conInfoForm.gracePeriodType = childData.loanrate.gracePeriodType
        this.conInfoForm.gracePeriodDay = childData.loanrate.gracePeriodDay
        this.conInfoForm.graceCountIntFlag = childData.loanrate.graceCountIntFlag

        this.isYearRate = data.childFlag.isYearRate

        this.childOnselectType()
        this.childcOnChangeHoliday()
        // this.childIsEnable()
        // this.childIsYearRate()
      },

      childOnselectType() {//如果不是浮动利率，则隐藏显示浮动利率相关
        let fet;
        this.$emit('childOnselectType', this.conInfoForm.rateType, function (val) {//, this.isFloatWay, this.isRateFloatProportion,
          fet = val
        })
        this.isFloatWay = fet
        this.isRateFloatProportion = fet
      },
      childIsYearRate() {//利率是否可以编辑
        let fet
        this.$emit('childIsYearRate', function (val) {
          fet = val
        })
        this.isYearRate = fet
      },
      childIsEnable() {//标签或者表单是否可以编辑
        let fet
        this.$emit('childIsEnable', function (val) {
          fet = val
          console.log('拿到了表单是否可以编辑' + fet)
          console.log('拿到了表单是否可以编辑' + !fet)
        })
        this.isconInfoForm = fet
      },
      childcOnChangeHoliday() {//节假日利息处理方式
        let fet
        this.$emit('childcOnChangeHoliday', this.conInfoForm.holidayFlg, this.conInfoForm.holidayIntFlg, function (val) {
          fet = val
        })
        console.log('节假日利息处理方式: ' + fet)
        this.isHolidayIntFlg = fet
      },
      childAmtChange() {//金额校验
        let fet
        this.$emit('childAmtChange', this.conInfoForm.loanAmt, function (val) {
          fet = val
        })

        this.conInfoForm.loanAmt = fet.loanAmt
      },
      childValidateBeginDate() {//验证开始日期
        let fet
        this.$emit('childValidateBeginDate', this.conInfoForm, function (val) {
          fet = val
        })
        this.conInfoForm.beginDate = fet.beginDate
      },
      getChildConEndate() {//放款期限的校验 .beginDate, this.conInfoForm.term, this.conInfoForm.unit,
        let fet
        this.$emit('getChildConEndate', this.conInfoForm, function (val) {
          fet = val
        })
        // this.conInfoForm.beginDate = fet.beginDate
      },
      testDemo() {
        this.$emit('childDemo', ',老哥--------')
      }
    }
  }

</script>

<style scoped>
  .form {
    margin-top: 20px;
    margin-right: 20px
  }
</style>
