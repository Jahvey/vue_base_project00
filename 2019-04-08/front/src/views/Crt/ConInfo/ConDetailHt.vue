<!--con_detail_ht的信息，使用原生element-ui写这个界面-->
<template>
  <el-row :gutter="20"
          class="form">
    <el-form label-width="200px"
             size="medium"
             :rules="rules"
             :model="tbConAttachedInfo"
             ref="tbConAttachedInfo"
             label-position="right"
             :disabled='disTbConAttachedInfo'>

      <div columns="1"
           id="table1"
           v-show="isTable1">
        <fieldset>
          <legend>
            <span>明细信息</span>
          </legend>

          <ProductLdzj :conDetailHtData="conDetailHtData"
                       v-show="conDetailHtData.visiable"></ProductLdzj>
        </fieldset>
      </div>

      <div columns="1"
           id="table2"
           v-show="isTable2">
        <fieldset>
          <legend>
            <span>利率信息</span>
          </legend>
          <BizPublicRate :conDetailHtData="conDetailHtData"
                         v-show="conDetailHtData.visiable"></BizPublicRate>

        </fieldset>
      </div>
      <div columns="1"
           id="dkll"
           v-show="isDkll">
        <fieldset>
          <legend>
            <span>垫款利率信息</span>
          </legend>
          <conDkllRate :conDetailHtData="conDetailHtData"
                       v-show="conDetailHtData.visiable"></conDkllRate>

        </fieldset>
      </div>

      <div columns="1"
           id="table10"
           v-show="isTable10">
        <fieldset>
          <legend>
            <span>通知和文书送达</span>
          </legend>

          <BizPublicNotice :conDetailHtData="conDetailHtData"
                           v-show="conDetailHtData.visiable"></BizPublicNotice>

        </fieldset>
      </div>
      <div columns="1"
           id="table6"
           v-show="isTable6">
        <fieldset>
          <legend>
            <span>仲裁方式</span>
          </legend>
          <BizPublicZcfs :conDetailHtData="conDetailHtData"
                         v-show="conDetailHtData.visiable"></BizPublicZcfs>

        </fieldset>
      </div>

      <div columns="1"
           id="table7"
           v-show="isTable7">
        <fieldset>
          <legend>
            <span>协议签署</span>
          </legend>
          <BizPublicXyqs :conDetailHtData="conDetailHtData"
                         v-show="conDetailHtData.visiable"></BizPublicXyqs>

        </fieldset>
      </div>
      <div columns="1"
           id="table10"
           v-show="isTable10">
        <fieldset>
          <legend>
            <span>财务约束指标</span>
          </legend>
          <div columns="4">
            <el-col :span="12">
              <el-form-item label="财务约束指标:"
                            prop="constraintIndex"
                            class="special-input">
                <el-input type="textarea"
                          :autosize="{ minRows: 1, maxRows: 3}"
                          placeholder="请输入内容"
                          v-model="tbConAttachedInfo.constraintIndex">
                </el-input>

              </el-form-item>
            </el-col>

          </div>
        </fieldset>
      </div>
      <div columns="1"
           id="table8"
           v-show="isTable8">
        <fieldset>
          <legend>
            <span>补充条款</span>
          </legend>
          <div columns="4">

            <el-col :span="12">
              <el-form-item label="补充条款:"
                            prop="addClause"
                            class="special-input">
                <el-input type="textarea"
                          :autosize="{ minRows: 1, maxRows: 3}"
                          placeholder="请输入内容"
                          v-model="tbConAttachedInfo.addClause">
                </el-input>

              </el-form-item>
            </el-col>

          </div>
        </fieldset>
      </div>
      <!-- 合同打印模板针对流动资金贷款有个提款条件的打印项  新增该字段 modified by shendl -->
      <div columns="1"
           id="table11"
           v-show="isTable11">
        <fieldset>
          <legend>
            <span>提款条件</span>
          </legend>

          <div columns="4">
            <el-col :span="12">
              <el-form-item label="其他条件:"
                            prop="tkCondition"
                            class="special-input">

                <el-input type="textarea"
                          :autosize="{ minRows: 1, maxRows: 3}"
                          placeholder="请输入内容"
                          v-model="tbConAttachedInfo.tkCondition">
                </el-input>

              </el-form-item>
            </el-col>

          </div>
        </fieldset>
      </div>

      <div id="table9"
           v-show="isTable9">
        <Myht :conDetailHtData="conDetailHtData"
              v-show="conDetailHtData.visiable"></Myht>

      </div>
      <div id="table3"
           v-show="isTable3">
        <PayoutPlan :conDetailHtData="conDetailHtData"
                    v-show="conDetailHtData.visiable"></PayoutPlan>

      </div>

      <div id="table4"
           v-show="isTable4">
        <LoanRepayPlan :conDetailHtData="conDetailHtData"
                       v-show="conDetailHtData.visiable"></LoanRepayPlan>

      </div>
      <div id="table5"
           v-show="isTable5">
        <Fee :conDetailHtData="conDetailHtData"
             v-show="conDetailHtData.visiable"></Fee>
      </div>

    </el-form>

    <el-row align="middle"
            class="bottomBtn">
      <el-col align="center"
              v-show="showSave">
        <el-button size="medium"
                   type="primary"
                   @click="onSubmit"
                   :disabled="disSave">保存</el-button>

      </el-col>

    </el-row>

  </el-row>

</template>

<script>
import Myht from '@/views/Biz/BizProductDetail/ConDetailHt/Myht'
import ProductLdzj from '@/views/Biz/BizProductDetail/Gs/productLdzj'
import BizPublicRate from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicRate'

import BizPublicNotice from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicNotice'
import BizPublicZcfs from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicZcfs'

import BizPublicXyqs from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicXyqs'
import PayoutPlan from '@/views/Crt/ConDetail/PayoutPlan'
import LoanRepayPlan from '@/views/Crt/ConDetail/LoanRepayPlan'
import Fee from '@/views/Crt/ConDetail/Fee'

import conDkllRate from '@/views/Biz/BizProductDetail/ConDetailHt/ConDkllRate'

import { getConDetailInfoByContarctId, getBizHappenType,
  getChangeRate, saveConContractDetailInfo, checkYwbh } from '@/api/csm'
import enums from '@/utils/enums'// 格式化的枚举

export default {
  name: 'conDetailHt',
  components: {
    // 引入的组件
    ProductLdzj,
    conDkllRate,
    BizPublicRate,
    BizPublicNotice,
    BizPublicZcfs,
    BizPublicXyqs,
    PayoutPlan,
    LoanRepayPlan,
    Fee,
    Myht

  },
  props: {

    paramsConTree: { // 用于接受父组件传来的参数
      // con_tree传递过来的参数放在这里
    }
  },
  data() {
    return {
      conDetailHtData: {
        visiable: true

      },
      // v-show
      showSave: true, // 控制是否显示保存按钮

      isDkll: true,
      isTable1: true,
      isTable2: true,
      isTable10: true,
      isTable6: true,
      isTable7: true,
      isTable8: true,
      isTable11: true,

      isTable9: true,

      isTable3: true,
      isTable4: true,
      isTable5: true,

      // disabled
      disTbConAttachedInfo: false,
      disSave: false,

      o: {

      }, // 这边保存了 相关合同数据
      tbConAttachedInfo: {// 初始化con_detail_ht的form表单
        partyName: '',
        partyNum: ''

      },
      conDetail: {

      },
      loanrate: {

      },
      myht: {

      },
      // 合同明细页面需要展示的相关数据参数
      // 重要的数据
      contractId: '',
      amountDetailId: '',
      proFlag: '', // 流程中查看标识
      productType: '', // 贷种
      syndicatedObjectCd: '',

      cycleindcon: '1',
      repayType: '',
      baseRate: '',

      rules: {// 表单验证
        // contractAmt:[
        //       {required: true, message: '金额不允许为空', trigger: 'blur'},
        //      // {type: 'number', message: '请输入数字', trigger: 'blur'},
        //       {min: 100, max: 100000000000, message: '请在出账范围内出账', trigger: 'blur'},

        // ],

      },

      guarantyType: enums.guarantyTypeCd, // 担保方式 CDZC0005
      mainGuarantyType: enums.mainGuarantyTypeCd, // 主担保方式 CDZC0005
      agriculLoans: enums.YesOrNoCd,

      currencyCd: enums.currencyCd, // 币种格式化  CD000001
      cycleUnit: enums.cycleUnitCd, // XD_GGCD6009

      repaymentType: enums.repaymentTypeCd, // 还款方式  XD_SXCD1162

      cycleIndCon: enums.isBankTeamLoan

    }
  },
  created() {
    // this.conDetailHtData = { visiable: true }
    console.log('conDetailHtData ' + this.conDetailHtData.visiable)
    const param = this.tbConAttachedInfo
    console.log('数据传输成功！' + JSON.stringify(param))

    this.contractId = param.contractId
    this.amountDetailId = param.amountDetailId
    this.proFlag = param.proFlag
    this.productType = param.productType
    this.syndicatedObjectCd = param.syndicatedObjectCd

    // 初始化相关的页面
    this.isTable3 = false
    this.isTable4 = false
    this.isTable5 = false
    this.isTable6 = false
    this.isTable7 = false
    this.isTable9 = false
    this.isDkll = false

    // 合同打印模板针对流动资金贷款有个提款条件的打印项  新增该字段
    this.isTable11 = false
    console.log('[conDetailHt] productType ' + this.productType)
    if (this.productType == '01001011' || this.productType == '01001001' || this.productType == '02001016' || this.productType == '02003004' || this.productType == '02001001' || this.productType == '02003008' ||
      this.productType == '02003012' || this.productType == '02003013' || this.productType == '02001002' || this.productType == '02003001' || this.productType == '02001007' || this.productType == '01001016' ||
      this.productType == '02003005' || this.productType == '02003002' || this.productType == '01001013' || this.productType == '02001015' || this.productType == '01001009' || this.productType == '01001023' ||
      this.productType == '02003006' || this.productType == '01001017' || this.productType == '02001008' || this.productType == '02003009' || this.productType == '01001014' || this.productType == '02003007' ||
      this.productType == '01001007' || this.productType == '01001029' || this.productType == '02001005' || this.productType == '02001013' || this.productType == '01001041' || this.productType == '01001028' ||
      this.productType == '01001015' || this.productType == '02001003' || this.productType == '01001012' || this.productType == '01001027' || this.productType == '01001008' || this.productType == '02003010' ||
      this.productType == '01001020' || this.productType == '01001021' || this.productType == '01001024' || this.productType == '01001019' || this.productType == '01001025' || this.productType == '01001010' ||
      this.productType == '02003011' || this.productType == '01001018' || this.productType == '01001026' || this.productType == '02001014' || this.productType == '01001022' || this.productType == '01001040' ||
      this.productType == '01001041' || this.productType == '01001042' || this.productType == '01003011') {
      this.isTable11 = true
    }

    if (this.productType == '01006001' || this.productType == '01006002' || this.productType == '01008001' || this.productType == '01008002' ||
      this.productType == '01008010' || this.productType == '01006010' // 村镇银行贴现产品
    ) {
      this.isTable1 = false
    }

    if (this.productType.substr(0, 6).indexOf('010080') != -1) {
      var cycleFlag = param.cycleFlag// 循环标志
      if (cycleFlag == '0') {
        this.isTable1 = true
      } else {
        this.isTable1 = false
      }
    }

    this.initConInfoHt(param)
  },
  methods: {
    onSubmit(data) {
      console.log('点击了保存...' + JSON.stringify(data))
    },

    initConInfoHt(data) { // 初始化页面合同信息
      console.log('[initConInfoHt] param ' + JSON.stringify(data))
      var json = { contractId: this.contractId, productType: this.productType }
      getConDetailInfoByContarctId(json).then((response) => {
        this.o = response.data
        this.repayType = this.o.tbConContractInfo.repaymentType
        // 合同调整时有些东西能改
        this.oldContractId = this.o.tbConContractInfo.oldContractId
        // 争议解决方式只支持仲裁与诉讼  没有其他这个选项 20140417 modified by shendl
        // var arr = git.getDictDataFilter("XD_SXYW0209", "01,02,04");
        // nui.get("tbConAttachedInfo.arbitrateType").setData(arr);

        // 提前还款是否收取违约金
        if (this.conDetail.prepaymentPenalty) {
          if (this.o.tbConContractInfo.prepaymentPenalty) {
            this.conDetail.prepaymentPenalty = this.o.tbConContractInfo.prepaymentPenalty
            if (this.conDetail.prepayMakeupRate) {
              this.conDetail.prepayMakeupRate = this.o.tbConContractInfo.prepayMakeupRate
            }
          }
        }
        if (this.syndicatedObjectCd == '02') { // 行内银团
          this.isTable1 = false
          this.isTable8 = false

          if (this.oldContractId == null || this.oldContractId == '') { // 合同调整
            // 		var rategrid = new nui.Form("#table2");
            // rategrid.setEnabled(false);

            var rateType = this.loanrate.rateType
            if (rateType == '2') { // 浮动比例
              nui.get('loanrate.rateFloatProportion').setEnabled(true)
              this.rateFloatProportion = this.o.apvrate.rateFloatProportion
              nui.get('loanrate.yearRate').setEnabled(true)
              this.yearrate = this.o.apvrate.yearRate
            } else if (rateType == '1') { // 固定
              nui.get('loanrate.yearRate').setEnabled(true)
              this.yearrate = this.o.apvrate.yearRate
            }
          } else {
            debugger
            // var rateType = this.loanrate.rateType
            if (rateType == '2') { // 浮动比例
              this.rateFloatProportion = this.o.apvrate.rateFloatProportion
            } else if (rateType == '1') { // 固定
              this.yearrate = this.o.apvrate.yearRate
            }
          }

          // 节假日利息处理方式
          this.loanrate.holidayIntFlg = '1'
        } else {
          console.log('========== 开始[getConDetailInfoByContarctId] else ==========================')

          if (this.o.tbConContractInfo.cycleIndCon != null) {
            this.cycleindcon = this.o.tbConContractInfo.cycleIndCon
          }
          // 并购走单笔流贷合同(01005001并购代码　01003001客户并购贷款)
          if (this.productType == '01005001' || this.productType == '01003011') {
            this.cycleindcon = '0'
          }

          this.amountDetailId = this.o.tbConContractInfo.amountDetailId

          // 贸易合同信息
          if (this.productType == '01008001' || this.productType == '01008002' || this.productType == '01008010' || this.productType == '01009001' || this.productType == '01009002' || this.productType == '01009010') {
            this.isTable9 = true
            var json = { 'amountDetailId': this.contractId }// 此处存合同ID
            var myht = nui.get('myht')
            myht.load(json)
            if (this.proFlag != '1') {
              nui.get('myhtdiv').hide()
              myht.setEnabled(false)
            }
          }
          // 流贷中只有单笔有还款计划--只有14还款方式才有
          if (this.repayType == '1400' || this.repayType == '1410') {
            if (this.cycleindcon == '0' ||
              this.productType == '01002001' || this.productType == '01002002' || this.productType == '01002003' || this.productType == '01003001' || this.productType == '01003002' ||
              this.productType == '01003003' || this.productType == '01003004' || this.productType == '01003005' || this.productType == '01003006' ||
              this.productType == '01003007' || this.productType == '01003009' || this.productType == '01003011' || this.productType == '01003012' || this.productType == '01003013' ||
              this.productType == '01003015' || this.productType == '01003016' || this.productType == '01013001' || this.productType == '01013010' ||
              this.productType == '01003050' // 村镇银行固定资产产品
            ) {
              this.isTable4 = true
              var json = { 'contractId': this.contractId }
              var grid2 = nui.get('grid2')
              grid2.load(json)
              if (this.proFlag != '1') {
                nui.get('hkjhdiv').hide()
                grid2.setEnabled(false)
              }
            }
          }

          // 费用信息
          if (this.productType == '01013010' || this.productType == '01013001' || this.productType == '01008001' || this.productType == '01008010' || this.productType == '01008010' || this.productType == '01008002' || this.productType == '01011001' ||
            this.productType == '01009001' || this.productType == '01004001') {
            this.isTable5 = true
            var json = { 'contractId': this.contractId }// 由于国内保理申请就要填费用信息，此处用amountDetailId取信息
            var grid3 = nui.get('grid3')
            grid3.load(json)
            if (this.proFlag != '1' || this.productType == '01004001') {
              nui.get('feediv').hide()
              grid3.setEnabled(false)
            }
          }
          // 单次流贷才有提款计划，只有流贷才有合同循环标志，所以只要这个标志是0（初始化为1），就说明要显示提款计划--银承也有此标志
          if (this.cycleindcon == '0' && this.productType != '01008001' && this.productType != '01008010' && this.productType != '01008002') {
            this.isTable3 = true
            var json = { 'contractId': this.contractId }
            var grid1 = nui.get('grid1')
            grid1.load(json)
            if (proFlag != '1') {
              nui.get('payoutdiv').hide()
              grid1.setEnabled(false)
            }
          }

          if (this.productType == '02005002' || this.productType == '01013001' || this.productType == '01013010' || this.productType == '02005010') {
            this.isTable3 = true
            var json = { 'contractId': this.contractId }
            var grid1 = nui.get('grid1')
            grid1.load(json)
            if (this.proFlag != '1') {
              nui.get('payoutdiv').hide()
              grid1.setEnabled(false)
            }
          }

          // 贷款利率
          if (this.productType == '01008001' || this.productType == '01008002' || this.productType == '01008010' || this.productType == '01008010' || this.productType == '01009001' || this.productType == '01009002' || this.productType == '01009010' ||
            this.productType == '01010001' || this.productType == '01011001' || this.productType == '01012001' ||
            this.productType == '01004001'
          ) {
            this.isTable2 = false
          } else if (this.productType == '01006001' || this.productType == '01006002' ||
            this.productType == '01006010' // 村镇银行贴现产品
          ) { // 贴现只有申请利率
            $('#lllx').css('display', 'none')
            nui.get('loanrate.rateType').hide()
            nui.get('loanrate.rateType').setValue('')

            $('#floatWay').css('display', 'none')
            nui.get('loanrate.floatWay').hide()
            nui.get('loanrate.floatWay').setValue('')

            $('#rateFloatProportionq').css('display', 'none')
            nui.get('loanrate.rateFloatProportion').hide()
            nui.get('loanrate.rateFloatProportion').setValue('')

            $('#isChangeRate').css('display', 'none')
            nui.get('loanrate.irUpdateFrequency').hide()
            nui.get('loanrate.irUpdateFrequency').setValue('')

            $('#jxzq').css('display', 'none')
            nui.get('loanrate.interestCollectType').hide()
            nui.get('loanrate.interestCollectType').setValue('')

            $('#jjrsybz').css('display', 'none')
            nui.get('loanrate.holidayFlg').hide()
            nui.get('loanrate.holidayFlg').setValue('')

            $('#jjrlxclfs').css('display', 'none')
            nui.get('loanrate.holidayIntFlg').hide()
            nui.get('loanrate.holidayIntFlg').setValue('')

            $('#kxqfs').css('display', 'none')
            nui.get('loanrate.gracePeriodType').hide()
            nui.get('loanrate.gracePeriodType').setValue('')

            $('#gracePeriodDay').css('display', 'none')
            nui.get('loanrate.gracePeriodDay').hide()
            nui.get('loanrate.gracePeriodDay').setValue('')

            $('#kxqlxclfs').css('display', 'none')
            nui.get('loanrate.graceCountIntFlag').hide()
            nui.get('loanrate.graceCountIntFlag').setValue('')
            // 逾期罚息率
            if (this.productType == '01006001' || this.productType == '01006002' ||
              this.productType == '01006010' // 村镇银行贴现产品
            ) {
              $('#ovardueRate').css('display', 'none')
              nui.get('loanrate.overdueRateUpProportion').hide()
              nui.get('loanrate.overdueRateUpProportion').setValue('')
            }

            $('#yearRate').css('display', 'block')
            nui.get('loanrate.yearRate').show()

            nui.get('tableloanrate').refreshTable()
            nui.get('yearrate').setValue(o.apvrate.yearRate)
          } else {
            // 1、利率类型、浮动形式、浮动方式、利率调整方式、结息周期、节假日顺延标志、节假日利息处理方式、宽限期方式、宽限期天数、宽限期利息处理方式、罚息率应均为反显不可修改
            // 2、浮动比率/浮动值只允许在大于审批值（上浮大于，下浮小于）
            var rategrid = new nui.Form('#table2')
            rategrid.setEnabled(false)
            debugger
            var rateType = nui.get('loanrate.rateType').getValue()
            if (rateType == '2') { // 浮动比例
              nui.get('loanrate.rateFloatProportion').setEnabled(true)
              nui.get('rateFloatProportion').setValue(o.apvrate.rateFloatProportion)
              nui.get('loanrate.yearRate').setEnabled(true)
              nui.get('yearrate').setValue(o.apvrate.yearRate)
            } else if (rateType == '1') { // 固定
              nui.get('loanrate.yearRate').setEnabled(true)
              nui.get('yearrate').setValue(o.apvrate.yearRate)
            }
            // 节假日利息处理方式
            nui.get('loanrate.holidayIntFlg').setValue('1')

            // 结息周期--合同循环标志
            var conflg = this.o.tbConContractInfo.cycleIndCon
          }
          // 利率信息---国际保函 信用证开证和提货担保没有利率信息
          if (this.productType == '01007010' || this.productType == '01007013' || this.productType == '01007014') {
            this.isTable2 = false
          }
          // 明细信息add by shendl
          if (this.productType == '01007001' || this.productType == '01007003' || this.productType == '01007004' || this.productType == '01007009' ||
            this.productType == '01007011' || this.productType == '01007012' || this.productType == '01007005' || this.productType == '01007006') {
            // 国结的利率信息 暂时都设置为反显
            nui.get('loanrate.yearRate').setEnabled(true)
            nui.get('loanrate.overdueRateUpProportion').setEnabled(true)
          }

          // 垫款利率
          if (this.productType == '01008001' || this.productType == '01008002' || this.productType == '01008010' || this.productType == '01009001' || this.productType == '01009002' || this.productType == '01009010' ||
            this.productType == '01006001' || this.productType == '01006002' ||
            this.productType == '01006010' || // 村镇银行贴现产品
            this.productType == '01007009' ||
            this.productType == '01007010' || this.productType == '01007012' || this.productType == '01007013' || this.productType == '01007014') {
            this.isDkll = true
            // nui.get('conDetail.dkll').validate()
          }
          // 仲裁方式
          if (this.productType == '01001001' || this.productType == '01001002' || this.productType == '01001003' || this.productType == '01001004' || this.productType == '01001005' || this.productType == '01001006' ||
            this.productType == '01002001' || this.productType == '01002002' || this.productType == '01002003' || this.productType == '01003001' || this.productType == '01003002' || this.productType == '01003003' ||
            this.productType == '01003004' || this.productType == '01003005' || this.productType == '01003006' || this.productType == '01003007' || this.productType == '01003009' ||
            this.productType == '01003050' || this.productType == '01001050' || this.productType == '01001051' || this.productType == '01001052' || this.productType == '01001053' || this.productType == '01001054' ||// 村镇银行流动资金产品
            this.productType == '01003011' || this.productType == '01003012' || this.productType == '01003013' || this.productType == '01003015' || this.productType == '01003016' || this.productType == '01009001' || this.productType == '01011001' ||
            this.productType == '01010001' || this.productType == '01005001' || this.productType == '01006001' || this.productType == '01006002' || this.productType == '01008001' || this.productType == '01008002' ||
            this.productType == '01008010' || this.productType == '01006010' || // 村镇银行贴现产品
            this.productType == '01001007' || this.productType == '01001008' || this.productType == '01001009' || this.productType == '01001010' || this.productType == '01001011' ||
            this.productType == '01001012' || this.productType == '01001013' || this.productType == '01001014' || this.productType == '01001015' || this.productType == '01001016' ||
            this.productType == '01001017' || this.productType == '01001018' || this.productType == '01001019' || this.productType == '01001020' || this.productType == '01001021' ||
            this.productType == '01001022' || this.productType == '01001023' || this.productType == '01001024' || this.productType == '01001025' || this.productType == '01001026' ||
            this.productType == '01001027' || this.productType == '01001028' | this.productType == '01001029' || this.productType == '01001030' || this.productType == '01001031' || this.productType == '01008001' || this.productType == '01008010' ||
            this.productType == '01001040' || this.productType == '01001041' || this.productType == '01001042') {
            this.isTable6 = true
          }
          // 协议签署
          if (this.productType == '01001001' || this.productType == '01001002' || this.productType == '01001003' || this.productType == '01001004' || this.productType == '01001005' || this.productType == '01001006' ||
            this.productType == '01002001' || this.productType == '01002002' || this.productType == '01002003' || this.productType == '01003001' || this.productType == '01003002' || this.productType == '01003003' ||
            this.productType == '01003004' || this.productType == '01003005' || this.productType == '01003006' || this.productType == '01003007' ||
            this.productType == '01003050' || this.productType == '01001050' || this.productType == '01001051' || this.productType == '01001052' || this.productType == '01001053' || this.productType == '01001054' ||// 村镇银行固定资产产品
            this.productType == '01003009' || this.productType == '01003011' || this.productType == '01003012' || this.productType == '01003013' || this.productType == '01003015' || this.productType == '01003016' ||
            this.productType == '01008001' || this.productType == '01008002' || this.productType == '01008010' ||
            this.productType == '01009001' || this.productType == '01010001' || this.productType == '01011001' || this.productType == '01005001' ||
            this.productType == '01001007' || this.productType == '01001008' || this.productType == '01001009' || this.productType == '01001010' || this.productType == '01001011' ||
            this.productType == '01001012' || this.productType == '01001013' || this.productType == '01001014' || this.productType == '01001015' || this.productType == '01001016' ||
            this.productType == '01001017' || this.productType == '01001018' || this.productType == '01001019' || this.productType == '01001020' || this.productType == '01001021' ||
            this.productType == '01001022' || this.productType == '01001023' || this.productType == '01001024' || this.productType == '01001025' || this.productType == '01001026' ||
            this.productType == '01001027' || this.productType == '01001028' | this.productType == '01001029' || this.productType == '01001030' || this.productType == '01001031' || this.productType == '01006001' || this.productType == '01006002' || this.productType == '01008001' ||
            this.productType == '01008010' || this.productType == '01006010' || // 村镇银行贴现产品
            this.productType == '01001040' || this.productType == '01001041' || this.productType == '01001042') {
            this.isTable7 = true
          }

          // 20190402 开立保函协议  需要份数问题以及争议解决方式
          if (this.productType == '01009001' || this.productType == '01009002' || this.productType == '01009010') {
            this.isTable7 = true
            this.isTable6 = true
          }
          // 20190402 委托贷款  需要份数问题以及争议解决方式
          if (this.productType == '02005002' || this.productType == '01013001' || this.productType == '01013010' ||
            this.productType == '02005010' || this.productType == '02005001') {
            this.isTable7 = true
            this.isTable6 = true
          }

          // 补充条款
          if (this.productType == '01004001' || this.productType == '01010001' || this.productType == '01011001' || this.productType == '01012001') {
            $('#table8').css('display', 'none')
            // 国结的产品不显示 贴息和收费的标识
            // $("#sftx").css("display","none");
            // nui.get("loanrate.discFlag").hide();
            // $("#sqfy").css("display","none");
            // nui.get("loanrate.feeFlag").hide();
          }
          // 汇票贴现才会有发票/票据
          if (this.productType == '01006001' || this.productType == '01006002' ||
            this.productType == '01006010' // 村镇银行贴现产品
          ) {
            nui.get('conDetail.txqq').setEnabled(false)
            nui.get('conDetail.currencyCd').setValue('CNY')
          }
          // 融资性保函
          if (this.productType == '01009001') {
            // nui.get("conDetail.bhzl").setData(getDictData('XD_SXYW0207','str','15,16,17,18'));
          }
          // 非融资保函保函种类
          if (this.productType == '01009002' || this.productType == '01009010') {
            // nui.get("conDetail.bhzl").setData(getDictData('XD_SXYW0207','str','01,02,03,04,05,06,07,08,09,10,11,12,13,14,18'));
          }

          // 出口托收押汇合同中“押汇贴现标志”只能选押汇
          if (this.productType == '01007003') {
            this.conDetail.yhtxbz = '0'
            nui.get('conDetail.yhtxbz').setEnabled(false)
          }

          // 第三方类型
          this.thirdType()

          console.log('结束[getConDetailInfoByContarctId] else')
        }
      }).catch((error) => {
        console.log(error)
      })
    },
    thirdType(e) {
      console.log('[thirdType] e ' + JSON.stringify(e))
      if (this.tbConAttachedInfo.cType != null) {
        var thirdtype = this.tbConAttachedInfo.cType
        if (thirdtype == '') {
          nui.get('tbConAttachedInfo.cHoldCount').setEnabled(false)
          nui.get('tbConAttachedInfo.cHoldCount').setRequired(false)
          this.tbConAttachedInfo.cHoldCount = ''
          // form.validate()
        } else {
          nui.get('tbConAttachedInfo.cHoldCount').setEnabled(true)
          nui.get('tbConAttachedInfo.cHoldCount').setRequired(true)
          // form.validate()
        }
      }
    },
    save() {
      console.log('[save] invoke..')

      this.$refs['conInfoForm'].validate((valid) => {
        if (valid) {
          console.log('校验通过')
        } else {
          alert('请按规则填写信息')
          return
        }
      })

      this.disSave = true

      // 仲裁方式处理
      var arbivar = this.tbConAttachedInfo.arbitrateType
      if (arbivar == '02') { // 如果选仲裁，显示仲裁模块,并将“其他”项隐藏并清空
        this.tbConAttachedInfo.other = ''
      } else if (arbivar == '03') { // 如果选其他，显示其他模块,并将“仲裁”隐藏并清空
        this.tbConAttachedInfo.arbitrateName = ''
        this.tbConAttachedInfo.arbitrateAddress = ''
      } else { // 选诉讼或请选择，将“其他”及“仲裁”项隐藏并清空
        this.tbConAttachedInfo.other = ''
        this.tbConAttachedInfo.arbitrateName = ''
        this.tbConAttachedInfo.arbitrateAddress = ''
      }
      // 仲裁方式处理结束
      // 宽限期天数
      var gracePeriodType = this.loanrate.gracePeriodType
      if (gracePeriodType) {
        if (gracePeriodType != '2') {
          this.loanrate.gracePeriodDay = ''
        }
      }
      // 宽限期
      if (this.loanrate.gracePeriodType != null) {
        // var gracePeriodType = this.loanrate.gracePeriodType
        if (gracePeriodType != '2') {
          this.loanrate.gracePeriodDay = ''
        }
        if (gracePeriodType == '0') {
          this.loanrate.graceCountIntFlag = ''
        }
      }
      // 节假日
      if (this.loanrate.holidayFlg) {
        var holidayFlg = this.loanrate.holidayFlg
        if (holidayFlg == '0') {
          this.loanrate.holidayIntFlg = ''
        }
        // var gracePeriodType = this.loanrate.gracePeriodType
        if (holidayFlg != '' && holidayFlg != null) {
          if (holidayFlg != '0' && gracePeriodType != '0') {
            alert('节假日与宽限期只能使用一种!')
            this.disSave = false

            return
          }
        }
      }
      // 提前还款是否收取违约金

      // 利率模块处理结束

      // 利率
      var rateType = this.o.loanrate.rateType
      debugger
      if (rateType == '1') { // 固定
        this.o.loanrate.floatWay = ''
        this.o.loanrate.rateFloatProportion = ''
        this.o.loanrate.baseRateValue = ''
      } else if (rateType == '2') { // 浮动
        this.o.loanrate.baseRateValue = this.baseRate
      }
      // 进口保函，主合同明细信息中保函有效期应不得早于系统日
      if (this.productType == '01007008') {
        if (this.o.conDetail.bhyxq < this.o.tbConContractInfo.bizDate) {
          alert('保函有效期应不得早于当前日期！')
          this.disSave = false

          return
        }
      }
      // “进口信用证”，则主合同明细信息中“信用证有效期”应不得早于系统日
      if (this.productType == '01007007') {
        if (this.o.conDetail.xyzyxq < this.o.tbConContractInfo.bizDate) {
          alert('信用证有效期应不得早于当前日期！')
          this.disSave = false

          return
        }
      }

      // 贸易合同信息必填--银承、保函
      if (this.productType == '01008001' || this.productType == '01008002' || this.productType == '01008010' ||
        this.productType == '01009001') {
        if (this.syndicatedObjectCd != '02') {
          // 控制是否填写了有关页面的内容
          var myhtcount = nui.get('myht').getData().length
          if (myhtcount == '0') {
            alert('未填写贸易合同信息')
            this.disSave = false

            return
          }
        }
      }

      // 最低还款金额
      if (this.o.conDetail.leastPrepayAmount) {
        if (this.o.conDetail.leastPrepayAmount > this.o.tbConContractInfo.contractAmt) {
          alert('最低还款金额不能大于合同金额')
          this.disSave = false

          return
        }
      }

      var PayoutPlans = this.PayoutPlans/* 提款 */
      var repayPlans = this.repayPlans/* 还款 */
      var fees = this.fees/* 费用 */
      var myhtxxs = this.myht/* 贸易合同信息 */
      var amt = this.tbConContractInfo.contractAmt
      // 校验动态列表必输项
      // 提款计划--------------------begin-----------------
      if (PayoutPlans) {
        var beginDate = this.o.tbConContractInfo.beginDate
        var endDate = this.o.tbConContractInfo.endDate
        for (var i = 0; i < PayoutPlans.length; i++) {
          if (PayoutPlans[i].payoutDate == null || PayoutPlans[i].payoutDate == '' ||
            PayoutPlans[i].payoutAmt == null || PayoutPlans[i].payoutAmt == '') {
            alert('请将提款计划填写完整！')
            this.disSave = false

            return
          }
          if (PayoutPlans[i].payoutAmt < 100) {
            alert('提款金额不能小于100！')

            this.disSave = false
            return
          }
        }
      }

      // 提款计划-------------------end-----------------
      // 还款计划-----------------begin------------
      // var totalrepay = 0;
      if (repayPlans != null && repayPlans.length != '0') {
        var beginDate = this.o.tbConContractInfo.beginDate
        var endDate = this.o.tbConContractInfo.endDate
        for (var i = 0; i < repayPlans.length; i++) {
          if (repayPlans[i].repayDate == null || repayPlans[i].repayDate == '' ||
            repayPlans[i].repayAmt == null || repayPlans[i].repayAmt == '') {
            alert('请将还款计划填写完整！')
            this.disSave = false

            return
          }
        }
      }
      // 还款计划-----------------end------------
      // 费用信息
      if (fees) {
        for (var i = 0; i < fees.length; i++) {
          if (fees[i].chargingType == null || fees[i].chargingType == '' ||
            fees[i].costType == null || fees[i].costType == '' ||
            fees[i].shouldFee == 0) {
            alert('请将费率信息填写完整！')
            this.disSave = false

            return
          }
          if ((fees[i].shouldFee == null || fees[i].shouldFee == '') && (fees[i].chargingProportion == null || fees[i].chargingProportion == '')) {
            alert('收费金额和收费比例必须填一项！')
            this.disSave = false

            return
          }
        }
      }
      // 贸易合同信息
      if (myhtxxs) {
        for (var i = 0; i < myhtxxs.length; i++) {
          if (myhtxxs[i].htbh == null || myhtxxs[i].htbh == '' ||
            myhtxxs[i].htgf == null || myhtxxs[i].htgf == '' ||
            myhtxxs[i].htxf == null || myhtxxs[i].htxf == '' ||
            myhtxxs[i].htqdrq == null || myhtxxs[i].htqdrq == '' ||
            myhtxxs[i].currencyCd == null || myhtxxs[i].currencyCd == '' ||
            myhtxxs[i].htzje == null || myhtxxs[i].htzje == '') {
            alert('请将贸易合同信息填写完整！')
            this.disSave = false

            return
          }

          if (myhtxxs[i].htdqrq != null && myhtxxs[i].htdqrq != '') {
            if (myhtxxs[i].htqdrq > myhtxxs[i].htdqrq) {
              alert('贸易合同信息中签订日期不能大于到期日期！')
              this.disSave = false

              return
            }
          }

          if (myhtxxs[i].htzje == 0) {
            alert('贸易合同信息中合同总金额不能为0！')
            this.disSave = false
            return
          }
        }
      }

      this.o.contractId = this.contractId
      this.o.amountDetailId = this.amountDetailId
      this.o.productType = this.productType
      this.o.PayoutPlans = this.PayoutPlans
      this.o.repayPlans = this.repayPlans
      this.o.fees = this.fees
      this.o.myhtxxs = this.myhtxxs
      this.o.op = '1'// 对公合同明细
      var json = this.o

      // 国结三个表外业务---保证金信息
      if (this.productType == '01007013' || this.productType == '01007010' || this.productType == '01007014') {
        // 保证金账号、币种、金额、比例四个信息  要么全有 要么全都不能有
        var bondAcct = this.conDetail.bzjzh// 保证金账号
        var bondCurr = this.conDetail.bzjbz// 保证金币种
        var bondAmt = this.conDetail.bzjje// 保证金金额
        var bondRate = this.conDetail.bzjblbdy// 保证金比例不低于

        if (bondAcct != '' && bondAcct != null && bondAcct != 'null' && bondAcct != 'undefined') {
          if (bondCurr == null || bondCurr == '' || bondAmt == null || bondAmt == '' || bondRate == null || bondRate == '') {
            alert('保证金信息不完整,请检查[币种&金额&比例]！')
            this.disSave = false

            return
          }
        }
        if (bondCurr != '' && bondCurr != null && bondCurr != 'null' && bondCurr != 'undefined') {
          if (bondAcct == null || bondAcct == '' || bondAmt == null || bondAmt == '' || bondRate == null || bondRate == '') {
            alert('保证金信息不完整,请检查[账号&金额&比例]！')
            this.disSave = false

            return
          }
        }
        if (bondAmt != '' && bondAmt != null && bondAmt != 'null' && bondAmt != 'undefined') {
          if (bondCurr == null || bondCurr == '' || bondAcct == null || bondAcct == '' || bondRate == null || bondRate == '') {
            alert('保证金信息不完整,请检查[账号&币种&比例]！')
            this.disSave = false

            return
          }
        }
        if (bondRate != '' && bondRate != null && bondRate != 'null' && bondRate != 'undefined') {
          if (bondCurr == null || bondCurr == '' || bondAmt == null || bondAmt == '' || bondAcct == null || bondAcct == '') {
            alert('保证金信息不完整,请检查[币种&金额&比例]！')
            this.disSave = false
            return
          }
        }
      }

      // 如果点击保存的是国结的业务产品---调用国结系统的业务编号校验接口 校验业务编号的合法性
      if (this.productType == '01007001' || this.productType == '01007003' || this.productType == '01007004' || this.productType == '01007009' ||
        this.productType == '01007012' || this.productType == '01007011' || this.productType == '01007006' || this.productType == '01007005' ||
        this.productType == '01007010' || this.productType == '01007013') {
        // 如果是国结产品---信用证开证需要判断溢装比例更新合同金额
        if (this.productType == '01007013') {
          var yzbl = this.conDetail.yzbl
          var bz = this.tbConContractInfo.currencyCd// 合同币种
          var kzje = this.conDetail.kzje// 合同金额
          var exchangeRate = this.tbConContractInfo.exchangeRate// 合同汇率

          if (yzbl == null || yzbl == '') {
            yzbl = 0
          }

          var detailBalance = this.tbBizAmountDetailApprove.detailBalance// 批复可用金额
          var newAmt = parseFloat(kzje) * (1 + parseFloat(yzbl) / 100)// 新的合同金额
          var newRmbAmt = parseFloat(newAmt) * parseFloat(exchangeRate)// 新的折算人民币金额
          if (parseFloat(newRmbAmt) > parseFloat(detailBalance)) { // 合同折算人民币金额>批复可用金额
            alert('开证金额折算人民币金额[' + newRmbAmt + ']不能大于批复明细可用金额[CNY:' + detailBalance + ']')
            this.conDetail.kzje = ''
            this.disSave = false

            return
          }
          this.o.tbConContractInfo.contractAmt = newAmt
          this.o.tbConContractInfo.rmbAmt = newRmbAmt
          this.o.tbConContractInfo.conBalance = newAmt

          var bzjbz = this.conDetail.bzjbz// 保证金币种
          var bzjje = this.conDetail.bzjje// 保证金金额
          var bzjbl = this.conDetail.bzjblbdy// 保证金比例不低于
          var bzjRate = '1'// 保证金币种的汇率
          var bz = this.tbConContractInfo.currencyCd// 合同币种
          var conInfoRmbAmt = newRmbAmt// 新的折算人民币金额
          var conAmt = newAmt// 新的合同金额
          var minBzjje// 最低保证金金额
          if (bzjbz != '' && bzjbz != null && bzjbz != 'null' && bzjbz != 'undefined') {
            if (bz !== bzjbz) { // 保证金币种和合同币种不一致
              if (bzjbz != 'CNY') { // 保证金币种和合同币种不一致而且保证金币种不是人民币
                var jsonHl = { 'bz': bzjbz }

                getChangeRate(jsonHl).then((response) => {
                  const text = response.data

                  if (text) {
                    if (text.validityInd == '1') {
                      bzjRate = parseFloat(text.disRateOfRmb) / parseFloat(100)
                      if (bzjbl != '' && bzjbl != null && bzjbl != 'null' && bzjbl != 'undefined') {
                        minBzjje = parseFloat(conInfoRmbAmt) * parseFloat(bzjbl) / parseFloat(100) / parseFloat(bzjRate)
                      }
                      if (bzjje != '' && bzjje != null && bzjje != 'null' && bzjje != 'undefined') {
                        if ((parseFloat(bzjje)) < parseFloat(minBzjje)) {
                          alert('最低保证金金额[' + bzjbz + ':' + minBzjje + ']')
                          this.disSave = false

                          return
                        }
                      }
                    } else {
                      alert('未获取到币种[' + bzjbz + ']的汇率信息')
                      this.disSave = false

                      return
                    }
                  }
                }).catch((error) => {
                  console.log(error)
                })
              } else { // 保证金币种和合同币种不一致但是保证金币种是人民币
                if (bzjbl != '' && bzjbl != null && bzjbl != 'null' && bzjbl != 'undefined') {
                  minBzjje = parseFloat(conInfoRmbAmt) * parseFloat(bzjbl) / parseFloat(100) / parseFloat(bzjRate)
                }
                if (bzjje != '' && bzjje != null && bzjje != 'null' && bzjje != 'undefined') {
                  if ((parseFloat(bzjje)) < parseFloat(minBzjje)) {
                    alert('最低保证金金额[' + bzjbz + ':' + minBzjje + ']')
                    this.disSave = false
                    return
                  }
                }
              }
            } else { // 保证金币种和合同币种一致
              if (bzjbl != '' && bzjbl != null && bzjbl != 'null' && bzjbl != 'undefined') {
                minBzjje = parseFloat(conAmt) * parseFloat(bzjbl) / parseFloat(100) / parseFloat(bzjRate)
              }
              if (bzjje != '' && bzjje != null && bzjje != 'null' && bzjje != 'undefined') {
                if ((parseFloat(bzjje)) < parseFloat(minBzjje)) {
                  alert('最低保证金金额[' + bzjbz + ':' + minBzjje + ']')
                  this.disSave = false

                  return
                }
              }
            }
          }

          const json = this.o
          // 没有填写溢装比例或者填写为0---不处理合同金额
          if (yzbl == null || yzbl == '' || yzbl == 0) {
            // alert("信用证溢装比例的变化会引起合同金额的改变，请留意");

            saveConContractDetailInfo(json).then((response) => {
              const text = response.data
              if (text.msg) {
                alert(text.msg)
                this.disSave = false

                return '1'
              } else {
                this.disSave = false

                alert('保存成功!信用证溢装比例的变化会引起合同金额的改变，请留意')
                this.initPage()
                return '1'
              }
            }).catch((error) => {
              console.log(error)
            })
          } else {
            saveConContractDetailInfo(json).then((response) => {
              const text = response.data

              if (text.msg) {
                alert(text.msg)
                this.disSave = false

                return '1'
              } else {
                this.disSave = false

                alert('保存成功!合同金额根据溢装比例的变化更新为: [' + bz + ']' + newAmt)
                this.initPage()
                return '1'
              }
            }).catch((error) => {
              console.log(error)
            })
          }
          return
        }
        /**
      * 特殊处理(国结业务需求)
      * 1. 进口代收押汇01007006   产品代码的时候使用01007006 子类型是3
      */
        // 业务编号
        var ywbh = ''
        // 产品子类型
        var cpzlx = ''
        // 提示信息
        var str = '业务编号'
        console.log('[conDetail]数据为:' + JSON.stringify(this.conDetail))

        if (this.productType == '01007001') { // 出口信用证押汇
          ywbh = this.conDetail.yfh
          str = '议付号'

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0074', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)
            this.disSave = false
            return '1'
          }
        }
        if (this.productType == '01007003') { // 出口托收押汇
          ywbh = this.conDetail.tsh
          str = '托收号'

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0075', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)

            this.disSave = false
            return '1'
          }
        }
        if (this.productType == '01007004') { // 进口信用证押汇
          ywbh = this.conDetail.yfh
          str = '议付号'

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0076', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)

            this.disSave = false
            return '1'
          }
        }
        if (this.productType == '01007005') { // 进口T/T押汇
          ywbh = this.conDetail.ywbh
          cpzlx = '2'

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0077', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)
            this.disSave = false

            return '1'
          }
        }
        if (this.productType == '01007009') { // 进口代付
          ywbh = this.conDetail.ywbh
          cpzlx = this.conDetail.cplx

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0078', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)
            this.disSave = false

            return '1'
          }
        }
        if (this.productType == '01007010') { // 提货担保
          ywbh = this.conDetail.fph
          str = '审核号码'

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0079', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)
            this.disSave = false
            return '1'
          }
        }
        if (this.productType == '01007012') { // 国际福费廷
          ywbh = this.conDetail.ywbh
          cpzlx = this.conDetail.cplx

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0080', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)

            this.disSave = false

            return '1'
          }
        }
        if (this.productType == '01007011') { // 国际信用证打包贷款
          ywbh = this.conDetail.xyzh
          cpzlx = this.conDetail.tzlx
          str = '信用证号'

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0081', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)
            this.disSave = false
            return '1'
          }
        }
        if (this.productType == '01007006') { // 进口代收押汇
          ywbh = this.conDetail.ywbh
          cpzlx = '3'

          var jsonCheck = { 'ywbh': ywbh }
          msg = exeRule('RCON_0082', '1', jsonCheck)
          if (msg != null && msg != '') {
            alert(msg)
            this.disSave = false
            return '1'
          }
        }
        var json1 = { productType: this.productType, 'ywbh': ywbh, 'amountDetailId': this.amountDetailId, 'cpzlx': cpzlx, 'contractId': this.contractId }
        console.log('[checkYwbh] json1 ' + JSON.stringify(json1))
        checkYwbh(json1).then((response) => {
          const mydata = response.data
          if (mydata.isValid == '0') {
            alert('[' + str + ']校验失败:' + mydata.msg)
            this.disSave = false

            return
          } else {
            // 编号校验成功---国结返回的信息需要和当期合同信息做比较 并且给出相应的提示
            var amt = this.tbConContractInfo.contractAmt// 合同金额
            var bz = this.tbConContractInfo.currencyCd// 合同币种
            var gjbz = mydata.bz// 国结返回的币种
            if (gjbz == '' || gjbz == null || gjbz == 'undefinded') {
              alert('国结系统未返回当前业务所需币种信息，请到国结系统确认当前业务完整性')
              this.disSave = false

              return
            }
            var gjje = mydata.je// 国结返回的金额
            if (gjje == '' || gjje == null || gjje == 'undefinded') {
              alert('国结系统未返回当前业务所需金额信息，请到国结系统确认当前业务完整性')
              this.disSave = false

              return
            }
            var gjfkqx = mydata.fkqx// 国结返回的放款期限
            var gjyj = mydata.gjyj// 国结返回的意见
            if (gjbz == '01') {
              gjbz = 'CNY'
            } else if (gjbz == '250') { // 法国法郎
              gjbz = 'FRF'
            } else if (gjbz == '276') { // 德国马克
              gjbz = 'DEM'
            } else if (gjbz == '13') { // 港币
              gjbz = 'HKD'
            } else if (gjbz == '380') { // 意大利里拉
              gjbz = 'ITL'
            } else if (gjbz == '27') { // 日元
              gjbz = 'JPY'
            } else if (gjbz == '410') { // 韩国元
              gjbz = 'KRW'
            } else if (gjbz == '81') { // 澳门元
              gjbz = 'MOP'
            } else if (gjbz == '458') { // 马来西亚币
              gjbz = 'MYR'
            } else if (gjbz == '528') { // 荷兰盾
              gjbz = 'NLG'
            } else if (gjbz == '554') { // 新西兰元
              gjbz = 'NZD'
            } else if (gjbz == '29') { // 澳洲元
              gjbz = 'AUD'
            } else if (gjbz == '578') { // 挪威克朗
              gjbz = 'NOK'
            } else if (gjbz == '608') { // 菲律宾比索
              gjbz = 'PHP'
            } else if (gjbz == '643') { // 卢布
              gjbz = 'RUB'
            } else if (gjbz == '32') { // 新加坡元
              gjbz = 'SGD'
            } else if (gjbz == '724') { // 西班牙比塞塔
              gjbz = 'ESP'
            } else if (gjbz == '752') { // 瑞典克朗
              gjbz = 'SEK'
            } else if (gjbz == '15') { // 瑞士法郎
              gjbz = 'CHF'
            } else if (gjbz == '764') { // 泰国铢
              gjbz = 'THB'
            } else if (gjbz == '12') { // 英镑
              gjbz = 'GBP'
            } else if (gjbz == '14') { // 美元
              gjbz = 'USD'
            } else if (gjbz == '38') { // 欧元
              gjbz = 'EUR'
            } else if (gjbz == '040') { // 奥地利先令
              gjbz = 'ATS'
            } else if (gjbz == '999') { // 其他
              gjbz = 'OTHER'
            } else if (gjbz == '056') { // 比利时法郎
              gjbz = 'BEF'
            } else if (gjbz == '28') { // 加拿大元
              gjbz = 'CAD'
            } else if (gjbz == '158') { // 新台湾币
              gjbz = 'TWD'
            } else if (gjbz == '208') { // 丹麦克朗
              gjbz = 'DKK'
            } else if (gjbz == '246') { // 芬兰马克
              gjbz = 'FIM'
            } else {
              alert('国结系统对当前业务定义的币种[' + gjbz + ']找不到对应的信息，请检查！')
              this.disSave = false

              return
            }
            if (bz != gjbz) {
              alert('当前合同币种[' + bz + ']与国结系统对当前业务定义的币种[' + gjbz + ']不匹配，请检查！')
              this.disSave = false

              return
            }
            if (amt != gjje) {
              alert('当前合同金额[' + amt + ']与国结系统对当前业务定义的金额[' + gjje + ']不匹配，请检查！')
              this.disSave = false

              return
            }
            this.saveConContractDetailInfo(json)
          }
        }).catch((error) => {
          console.log(error)
        })
      } else {
        this.saveConContractDetailInfo(json)
      }
    },
    saveConContractDetailInfo(json) {
      console.log('[saveConContractDetailInfo] json' + JSON.stringify(json))
      saveConContractDetailInfo(json).then((response) => {
        const msg = response.data
        console.log('[msg] ' + msg)
        if (msg) {
          alert(msg)
        } else {
          nui.alert('保存成功')
        }
        this.initPage()
        this.disSave = false
      })
    },

    // 提前还款是否收取违约金
    onselectPrepaymentPenalty() {
      console.log('[onselectPrepaymentPenalty] ')
      if (this.conDetail.prepaymentPenalty == '1') {
        $('#prepayMakeupRate').css('display', 'block')
        nui.get('conDetail.wybcbl').show()
      } else {
        $('#prepayMakeupRate').css('display', 'none')
        nui.get('conDetail.wybcbl').hide()
        this.conDetail.wybcbl = ''
      }
    },
    // 提前还款是否收取违约金--流贷
    onselectPrepaymentPenalty1() {
      console.log('[onselectPrepaymentPenalty1]')
      if (this.conDetail.prepaymentPenalty == '1') {
        $('#prepayMakeupRate').css('display', 'block')
        nui.get('conDetail.prepayMakeupRate').show()
      } else {
        $('#prepayMakeupRate').css('display', 'none')
        nui.get('conDetail.prepayMakeupRate').hide()
        this.conDetail.prepayMakeupRate = ''
      }
    }

  }

}

</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.form {
  margin-top: 20px;
  margin-right: 20px;
}

.bottomBtn {
  margin-top: 10px;
}
</style>
