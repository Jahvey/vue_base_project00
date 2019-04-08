<template>
  <!--
小微循环类合同明细页面
2019/3/27
-->
  <el-container>
    <el-main>
      <legend>主合同明细信息</legend>

      <div id="tableloanrate"
           columns="4">

        <el-row :gutter="20"
                class="form">
          <el-form el-form
                   label-width="200px"
                   :model="tbConContractInfo"
                   size="medium"
                   :rules="rules"
                   ref="tbConContractInfo"
                   label-position="right"
                   :disabled="disConDetailHtXwCycle">

            <div columns="1"
                 id="table1">
              <fieldset>
                <legend>
                  <span>明细信息</span>
                </legend>
                <!-- 委托贷款  费用信息 -->
                <div id="zffs"
                     columns="4">

                  <!--CDXY0144-->
                  <el-col :span="12">
                    <el-form-item label="资金支付方式:"
                                  prop="payWay"
                                  class="special-input">
                      <el-select v-model="tbConContractInfo.payWay"
                                 style="width:100%">
                        <el-option v-for="(value,key) in payWay"
                                   :key="key"
                                   :label="value"
                                   :value="key"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>

                </div>
                <div id="tqhk"
                     columns="4">
                  <el-col :span="12">
                    <el-form-item label="提前还款最低金额:"
                                  prop="leastPrepayAmount"
                                  class="special-input">
                      <el-input v-model="tbConContractInfo.leastPrepayAmount"
                                style="width:100%"></el-input>

                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="提前还款基数(元):"
                                  prop="prepayJs"
                                  class="special-input">
                      <el-input v-model="tbConContractInfo.prepayJs"
                                style="width:100%"></el-input>

                    </el-form-item>
                  </el-col>

                </div>

                <!-- 委托贷款  费用信息 modified by shendl 20180528 -->
                <!-- 委托贷款  费用信息  -->
                <div id="fyxx"
                     v-show="isFyxx"
                     columns="4">

                  <!--XD_FYZF001-->
                  <el-col :span="12">
                    <el-form-item label="手续费支付方:"
                                  prop="sxfPayWay"
                                  class="special-input">

                      <el-select v-model="tbConContractInfo.sxfPayWay"
                                 style="width:100%"
                                 placeholder="--请选择--">
                        <el-option v-for="(value,key) in sxfPayWay"
                                   :key="key"
                                   :label="value"
                                   :value="key"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>

                  <!--XD_FYZF001-->
                  <el-col :span="12">
                    <el-form-item label="其他费用支付方:"
                                  prop="qtfPayWay"
                                  class="special-input">

                      <el-select v-model="tbConContractInfo.qtfPayWay"
                                 style="width:100%"
                                 placeholder="--请选择--">
                        <el-option v-for="(value,key) in qtfPayWay"
                                   :key="key"
                                   :label="value"
                                   :value="key"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>

                  <!--XD_DBSX001 -->
                  <el-col :span="12">
                    <el-form-item label="担保手续办理方式:"
                                  prop="dbSxWay"
                                  class="special-input">

                      <el-select v-model="tbConContractInfo.dbSxWay"
                                 style="width:100%"
                                 placeholder="--请选择--">
                        <el-option v-for="(value,key) in dbSxWay"
                                   :key="key"
                                   :label="value"
                                   :value="key"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>

                  <el-col :span="12">
                    <el-form-item label="未按约定用途使用贷款的罚息率(%):"
                                  prop="disYtFx"
                                  class="special-input">
                      <el-input-number v-model="tbConContractInfo.disYtFx"
                                       controls-position="right"
                                       :precision="2"
                                       :step="0.1"
                                       :min="0"
                                       :max="100"
                                       style="width:100%"></el-input-number>

                    </el-form-item>
                  </el-col>

                </div>

              </fieldset>
            </div>

            <div columns="1"
                 id="table2">
              <fieldset>
                <legend>
                  <span>利率信息</span>
                </legend>
                <!--conDetailHtXwCycleData 子页面使用这个组件来接受-->
                <BizPublicRateXwCycle :conDetailHtXwCycleData="conDetailHtXwCycleData">

                </BizPublicRateXwCycle>

              </fieldset>
            </div>

            <div columns="1"
                 id="table6">
              <fieldset>
                <legend>
                  <span>通知和文书送达</span>
                </legend>

                <BizPublicNotice :conDetailHtData="conDetailHtData"
                                 v-show="conDetailHtData.visiable"></BizPublicNotice>

              </fieldset>
            </div>

            <div columns="1"
                 id="table6">
              <fieldset>
                <legend>
                  <span>仲裁方式</span>
                </legend>
                <BizPublicZcfs :conDetailHtData="conDetailHtData"
                               v-show="conDetailHtData.visiable"></BizPublicZcfs>

              </fieldset>
            </div>

            <div columns="1"
                 id="table7">
              <fieldset>
                <legend>
                  <span>协议签署</span>
                </legend>
                <BizPublicXyqs :conDetailHtData="conDetailHtData"
                               v-show="conDetailHtData.visiable"></BizPublicXyqs>

              </fieldset>
            </div>
            <div columns="1"
                 id="table9">
              <fieldset>
                <legend>
                  <span>财务约束指标</span>
                </legend>

                <div columns="4">
                  <el-col :span="12">
                    <el-form-item label="财务约束指标:"
                                  prop="constraintIndex"
                                  class="special-input">
                      <el-input v-model="tbConContractInfo.constraintIndex"
                                style="width:100%"></el-input>

                    </el-form-item>
                  </el-col>
                </div>

              </fieldset>
            </div>
            <div columns="1"
                 id="table8">
              <fieldset>
                <legend>
                  <span>补充条款</span>
                </legend>

                <div columns="4">
                  <el-col :span="12">
                    <el-form-item label="补充条款:"
                                  prop="addClause"
                                  class="special-input">
                      <el-input v-model="tbConContractInfo.addClause"
                                style="width:100%"></el-input>

                    </el-form-item>
                  </el-col>
                </div>

              </fieldset>
            </div>

            <div id="table5">
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
                         @click="save"
                         :disabled="disSave">保存</el-button>

            </el-col>

          </el-row>

        </el-row>

      </div>

    </el-main>

  </el-container>

</template>

<script>
import enums from '@/utils/enums'// 格式化的枚举
import { getConDetailInfoByContractId, getBizHappenType, deleteRepayPlan, saveConContractDetailInfo } from '@/api/csm'
import BizPublicRateXwCycle from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicRateXwCycle'

import BizPublicNotice from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicNotice'
import BizPublicZcfs from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicZcfs'

import BizPublicXyqs from '@/views/Biz/BizProductDetail/ConDetailHt/BizPublicXyqs'
import PayoutPlan from '@/views/Crt/ConDetail/PayoutPlan'
import LoanRepayPlan from '@/views/Crt/ConDetail/LoanRepayPlan'
import Fee from '@/views/Crt/ConDetail/Fee'

export default {
  name: 'ConDetailHtXwCycle',
  props: {
    paramsConTree: { // 用于接受父组件传来的参数
      // con_tree传递过来的参数放在这里
    }

  },
  components: {
    BizPublicRateXwCycle,
    BizPublicNotice,
    BizPublicZcfs,
    BizPublicXyqs,
    PayoutPlan,
    LoanRepayPlan,
    Fee
  },
  created() {
    const params = this.paramsConTree
    console.log('从conTree中传过来的数据 ' + JSON.stringify(params))
    this.contractId = this.paramsConTree.contractId
    this.amountDetailId = this.paramsConTree.amountDetailId
    this.proFlag = this.paramsConTree.proFlag
    this.productType = this.paramsConTree.productType
    this.oldContractId = ''
    this.baseRate = ''
    // 对私 隐藏费率信息项
    this.isTable5 = false
    // 对私 隐藏费用信息项
    this.isFyxx = false
    this.initPage()
  },
  data() {
    return {

      conDetailHtData: {// 往下面的各级页面传输的数据
        visiable: true
      },

      disConDetailHtXwCycle: false, // 控制整个页面是否禁用

      // TODO v-show
      showSave: true,
      isTable5: true,
      isFyxx: true,
      isPrepayMakeupRate: true,

      // disabled
      disSave: false,
      disPayWay: false,

      // 重要的一些数据
      contractId: '',
      amountDetailId: '',
      proFlag: '', // 流程中查看标识
      productType: '', // 贷种
      oldContractId: '',
      baseRate: '',
      rateFloatProportion: '',
      yearrate: '',
      // 整个form表单中的相关操作dis

      // 表单数据
      tbConContractInfo: {

      },
      o: {

      },
      // 费率信息相关
      fees: {

      },

      payWay: enums.payWayCd,
      sxfPayWay: enums.sxfPayWayCd,
      dbSxWay: enums.dbSxWayCd,
      qtfPayWay: enums.sxfPayWayCd,

      rules: {

      }

    }
  },

  methods: {
    // 初始化页面
    initPage() {
      var json = { contractId: this.contractId, productType: this.productType }

      getConDetailInfoByContractId(json).then((response) => {
        this.o = response.data
        console.log('[getConDetailInfoByContractId] o is ' + JSON.stringify(this.o))
        // form.setData(o)
        this.tbConContractInfo.payWay = this.o.tbConContractInfo.payWay
        this.tbConContractInfo.leastPrepayAmount = this.o.tbConContractInfo.leastPrepayAmount
        this.tbConContractInfo.prepayJs = this.o.tbConContractInfo.prepayJs

        this.tbConContractInfo.sxfPayWay = this.o.conDetail.sxfPayWay
        this.tbConContractInfo.qtfPayWay = this.o.conDetail.qtfPayWay
        this.tbConContractInfo.dbSxWay = this.o.conDetail.dbSxWay
        this.tbConContractInfo.disYtFx = this.o.conDetail.disYtFx

        this.tbConContractInfo.constraintIndex = this.o.tbConAttachedInfo.constraintIndex
        // 补充条款
        this.tbConContractInfo.addClause = this.o.tbConAttachedInfo.addClause

        this.conDetailHtData.contractId = this.contractId // 这样就完成了从上级页面传递到下级页面

        this.rateFloatProportion = this.o.apvrate.rateFloatProportion// 浮动比例
        this.yearrate = this.o.apvrate.yearRate// 固定利率

        // 争议解决方式只支持仲裁与诉讼  没有其他这个选项

        this.setXht()// 循环通/续接贷 资金支付方式默认为否
        // proFlag   如果流程标识为0表示为查看，隐藏保存按钮禁用控件
        if (this.proFlag != '1') {
          this.showSave = false
          // TODO 目前还没找到相关的div
          // nui.get('payoutdiv').hide()
          // nui.get('hkjhdiv').hide()

          this.disAttachedForm = true // 整个页面全都禁用
        }
        // 对私的委托贷款 才有费率信息项
        if (this.productType == '02005001' || this.productType == '02005002' || this.productType == '02005010') {
          this.isTable5 = true
          this.isFyxx = true
        }
      }).catch((error) => {
        console.log(error)
      })
    },
    // 循环通/续接贷资金支付方式默认为否 不可选
    setXht() {
      var jsonC = { contractId: this.contractId }

      getBizHappenType(jsonC).then((response) => {
        var o = response.data
        console.log('[getBizHappenType]o is ' + JSON.stringify(o))
        o = o.infos

        if (o[0].BIZHAPPENTYPE == '06') { // 借新还旧的业务
          if (this.tbConContractInfo.payWay != null) {
            this.tbConContractInfo.payWay = '0'// 自主字符
            this.disPayWay = true// 置灰
          }
        }
      }).catch((error) => {
        console.log(error)
      })
    },
    // 动态列表点击新增
    add(gr) {
      console.log('[add] gr' + JSON.stringify(gr))
    },

    // 动态列表删除操作
    remove(gr) {
      console.log('[remove] gr' + JSON.stringify(gr))
    },
    // 费率项 自动计算收费比例或者收费金额
    grid3Click(e) {
      console.log('[grid3Click] e is' + e)
    },

    save() {
      console.log('save...')

      this.$refs['tbConContractInfo'].validate((valid) => {
        if (valid) {
          console.log('校验通过')
        } else {
          alert('请按规则填写信息')
          return
        }
      })
      // 费用信息
      /* 费用 */
      console.log('费用 fees ' + this.fees)
      if (this.fees) {
        for (var i = 0; i < this.fees.length; i++) {
          if (this.fees[i].chargingType == null || this.fees[i].chargingType == '' ||
            this.fees[i].costType == null || this.fees[i].costType == '' ||
            this.fees[i].shouldFee == 0) {
            alert('请将费率信息填写完整！')
            this.disSave = false

            return
          }
          if ((this.fees[i].shouldFee == null || this.fees[i].shouldFee == '') && (this.fees[i].chargingProportion == null || this.fees[i].chargingProportion == '')) {
            alert('收费金额和收费比例必须填一项！')
            this.disSave = false

            return
          }
          var mny = /^([1-9][\d]{0,16}|0)(\.[\d]{2})?$/
          if (this.fees[i].shouldFee) {
            if (!mny.test(this.fees[i].shouldFee)) {
              alert('费率信息中收费金额输入有误！')
              this.initPage()
              this.disSave = false

              return
            }
          }
          mny = /^([1-9][\d]{0,16}|0)(\.[\d]{1,2})?$/
          if (this.fees[i].chargingProportion) {
            if (!mny.test(this.fees[i].chargingProportion)) {
              alert('费率信息中收费比例输入有误！')
              this.initPage()
              this.disSave = false

              return
            }
          }
        }
      }
      debugger
      var rateType = this.o.loanrate.rateType
      if (rateType == '1') { // 固定
        this.o.loanrate.floatWay = ''
        this.o.loanrate.rateFloatProportion = ''
        this.o.loanrate.baseRateValue = ''
      } else if (rateType == '2') { // 浮动
        this.o.loanrate.baseRateValue = this.baseRate// 基准利率
      }
      // 利率模块处理结束

      this.disSave = true // 将保存按钮的模块置灰色
      this.o.contractId = this.contractId
      this.o.productType = this.productType

      this.o.fees = this.fees// 费用信息
      this.o.op = '2'// 小微合同明细

      var json = this.o

      saveConContractDetailInfo(json).then((response) => {
        const msg = response.data
        console.log('[saveConContractDetailInfo]o is' + this.o + ',msg is ' + JSON.stringify(msg))
        if (msg) {
          alert(msg)
          this.disSave = false
        } else {
          alert('保存成功！')
          this.disSave = false
        }
        this.initPage()
      }).then((error) => {
        console.log(error)
      })
    }

  }

}
</script>

<style scoped>
.form {
  margin-top: 20px;
  margin-right: 20px;
}
</style>
