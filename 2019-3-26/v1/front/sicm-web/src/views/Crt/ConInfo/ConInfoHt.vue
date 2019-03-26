<!--con_info_ht的信息，使用原生element-ui写这个界面-->
<template>
  <el-row :gutter="20"
          class="form">
    <el-form label-width="200px"
             size="medium"
             :rules="rules"
             :model="conInfoForm"
             ref="conInfoForm"
             label-position="right"
             :disabled=isconInfoForm>
      <fieldset>
        <legend>
          <span>基本信息</span>
        </legend>

        <div id="table1">
          <el-col :span="12">
            <el-form-item label="客户名称:"
                          prop="partyName"
                          class="special-input">
              <el-input v-model="conInfoForm.partyName"
                        style="width:100%"></el-input>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户编号:"
                          prop="partyNum"
                          class="special-input">
              <el-input v-model="conInfoForm.partyNum"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="业务品种:"
                          prop="productTypeCd"
                          class="special-input">
              <el-select v-model="conInfoForm.productType"
                         style="width:100%">
                <el-option v-for="(value,key) in productTypeCd"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合同编号:"
                          prop="contractNum"
                          class="special-input">
              <el-input v-model="conInfoForm.contractNum"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="纸质合同编号:"
                          prop="paperConNum"
                          class="special-input">
              <el-input v-model="conInfoForm.paperConNum"
                        style="width:100%"
                        placeholder="请输入纸质合同编号"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原合同编号:"
                          prop="oldContractNum"
                          class="special-input">
              <el-input v-model="conInfoForm.oldContractNum"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种:"
                          prop="currencyCd"
                          class="special-input">
              <el-select v-model="conInfoForm.currencyCd"
                         style="width:100%"
                         :disabled="disCurrencyCd"
                         @change="bzChange">
                <el-option v-for="(value,key) in currencyCd"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="金额:"
                          prop="contractAmt"
                          class="special-input">
              <el-input v-model="conInfoForm.contractAmt"
                        style="width:100%;float:left"
                        :disabled="disContractAmt"
                        @change="validAmt"></el-input>

            </el-form-item>
          </el-col>
          <el-col :span="12"
                  v-show="isBzjbl">
            <el-form-item label="保证金比例:"
                          prop="bzjbl"
                          class="special-input">
              <el-input-number v-model="conInfoForm.bzjbl"
                               controls-position="right"
                               :precision="2"
                               :step="0.1"
                               :min="0"
                               :max="100"
                               style="width:100%"
                               :disabled="disBzjbl"></el-input-number>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="起始日期:"
                          prop="beginDate"
                          class="special-input">
              <el-date-picker type="date"
                              format="yyyy-MM-dd"
                              v-model="conInfoForm.beginDate"
                              style="width:100%"
                              placeholder="选择起始日期"
                              @change="validateBeginDate"
                              :disabled="disbeginDate"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合同期限:"
                          prop="contractTerm"
                          class="special-input">
              <el-input v-model="conInfoForm.contractTerm"
                        style="width:60%;float:left"
                        @blur="getConEndate"></el-input>
              <el-select v-model="conInfoForm.cycleUnit"
                         style="width:40%;float:left">
                <el-option v-for="(value,key) in cycleUnit"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="到期日期:"
                          prop="endDate"
                          class="special-input">
              <el-date-picker type="date"
                              format="yyyy-MM-dd"
                              v-model="conInfoForm.endDate"
                              style="width:100%"
                              placeholder="选择截止日期"
                              @change="getTerm"
                              :disabled="disendDate"></el-date-picker>

            </el-form-item>
          </el-col>
        </div>

        <div id="hkxx"
             v-show="hkxx">
          <el-col :span="12"
                  v-show="hkfs">
            <el-form-item label="还款方式:"
                          prop="repaymentType"
                          class="special-input">

              <el-select v-model="conInfoForm.repaymentType"
                         style="width:100%"
                         :disabled=disRepaymentType
                         @change="conRpTpChg">
                <el-option v-for="(value,key) in repaymentType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>
          <el-col :span="12"
                  v-show="schkq">
            <el-form-item label="首次还款期次:"
                          prop="firstRepayTerm"
                          class="special-input">
              <el-input v-model="conInfoForm.firstRepayTerm"
                        style="width:100%"
                        :disabled=disFirstRepayTerm></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12"
                  v-show="zdhkr">
            <el-form-item label="指定还款日:"
                          prop="specPaymentDate"
                          class="special-input">
              <el-input v-model="conInfoForm.specPaymentDate"
                        style="width:100%"
                        placeholder="请指定还款日"
                        :disabled="disspecPaymentDate"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12"
                  v-show="jgts">
            <el-form-item label="间隔天数:"
                          prop="internalDays"
                          class="special-input">
              <el-input v-model="conInfoForm.internalDays"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>

        </div>

        <div>
          <el-col :span="12">
            <el-form-item label="合同循环标识:"
                          prop="cycleIndCon"
                          class="special-input">
              <el-select v-model="conInfoForm.cycleIndCon"
                         style="width:100%"
                         :disabled=disCycleIndCon>
                <el-option v-for="(value,key) in cycleIndCon"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="签约日期:"
                          prop="contractDate"
                          class="special-input">
              <el-date-picker type="date"
                              format="yyyy-MM-dd"
                              v-model="conInfoForm.contractDate"
                              style="width:100%"
                              placeholder="请选择签约日期"
                              @change="qyrq"
                              :disabled="discontractDate"></el-date-picker>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="签约地点:"
                          prop="contractAddress"
                          class="special-input">
              <el-input v-model="conInfoForm.contractAddress"
                        style="width:100%"
                        :disabled="discontractAddress"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="贷款用途:"
                          prop="loanUse"
                          class="special-input">
              <el-input v-model="conInfoForm.loanUse"
                        style="width:100%"
                        :disabled="disloanUse"></el-input>
            </el-form-item>
          </el-col>
        </div>

        <div id="exchangeRate"
             v-show="exchangeRate">
          <el-col :span="12">
            <el-form-item label="汇率:"
                          prop="exchangeRate"
                          class="special-input">
              <el-input v-model="conInfoForm.exchangeRate"
                        style="width:60%;float:left"></el-input>
              <el-button type="primary"
                         icon="el-icon-search"
                         style="width:40%;float:left"
                         @click="pjcx">获取汇率</el-button>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="折算人民币金额:"
                          prop="rmbAmt"
                          class="special-input">
              <el-input v-model="conInfoForm.rmbAmt"
                        style="width:100%"
                        @change="validAmt"></el-input>
            </el-form-item>
          </el-col>

        </div>

        <div id="dbfs"
             v-show="dbfs">
          <el-col :span="12">
            <el-form-item label="担保方式:"
                          class="special-input">

              <el-checkbox-group v-model="conInfoForm.guarantyType"
                                 @change="guarantyTypechg"
                                 :disabled="disGuarantyType">
                <el-checkbox label="01">信用</el-checkbox>
                <el-checkbox label="02">抵押</el-checkbox>
                <el-checkbox label="03">质押</el-checkbox>
                <el-checkbox label="04">保证</el-checkbox>
                <el-checkbox label="05">保证金</el-checkbox>
              </el-checkbox-group>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="主担保方式:"
                          prop="mainGuarantyType"
                          class="special-input">
              <el-select v-model="conInfoForm.mainGuarantyType"
                         style="width:100%">
                <el-option v-for="(value,key) in mainGuarantyType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </div>

        <div id="nongdandai"
             v-show="nongdandai">
          <el-col :span="12">
            <el-form-item label="是否融单:"
                          prop="agriculLoans"
                          class="special-input">
              <el-select v-model="conInfoForm.agriculLoans"
                         style="width:100%"
                         @change="changeCon">
                <el-option v-for="(value,key) in agriculLoans"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </div>

      </fieldset>

      <fieldset id="bzxx"
                v-show="bzxx">
        <legend>
          <span>标志信息</span>
        </legend>

        <div id="table2"
             v-show="table2">
          <el-col :span="12">
            <el-form-item label="行业投向:"
                          prop="loanTurn"
                          class="special-input">
              <el-select v-model="conInfoForm.loanTurn"
                         style="width:100%"
                         placeholder="--请选择--"
                         @change="selectTrade4"
                         :disabled="disloanTurn">
                <el-option v-for="(value,key) in loanTurn"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="涉及环境、安全等重大情况:"
                          prop="riskInfo"
                          class="special-input">
              <el-select v-model="conInfoForm.riskInfo"
                         style="width:100%"
                         :disabled="disriskInfo">
                <el-option v-for="(value,key) in riskInfo"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </div>
        <div id="cqcs"
             v-show="cqcs">
          <el-col :span="12">
            <el-form-item label="采取措施:"
                          prop="act"
                          class="special-input">
              <el-select v-model="conInfoForm.act"
                         style="width:100%"
                         :disabled="disact">
                <el-option v-for="(value,key) in act"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>
        </div>

        <div>
          <el-col :span="12">
            <el-form-item label="节能环保项目及服务类型:"
                          prop="serviceType"
                          class="special-input">
              <el-select v-model="conInfoForm.serviceType"
                         style="width:100%"
                         @change="servicetype"
                         :disabled="disserviceType">
                <el-option v-for="(value,key) in serviceType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </div>
        <div id="jnjpl"
             v-show="jnjpl">
          <el-col :span="12">
            <el-form-item label="节能减排量:"
                          prop="reduceAmount"
                          class="special-input">
              <el-select v-model="conInfoForm.reduceAmount"
                         style="width:100%"
                         :disabled="disreduceAmount">
                <el-option v-for="(value,key) in reduceAmount"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>
        </div>

        <div>
          <el-col :span="12">
            <el-form-item label="产业结构调整类型:"
                          prop="ajustType"
                          class="special-input">
              <el-select v-model="conInfoForm.ajustType"
                         style="width:100%">
                <el-option v-for="(value,key) in ajustType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="工业转型升级标识:"
                          prop="upgradeType"
                          class="special-input">
              <el-select v-model="conInfoForm.upgradeType"
                         style="width:100%">
                <el-option v-for="(value,key) in upgradeType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="战略新兴产业类型:"
                          prop="newProductType"
                          class="special-input">
              <el-select v-model="conInfoForm.newProductType"
                         style="width:100%">
                <el-option v-for="(value,key) in newProductType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </div>

        <div id="kfdk"
             v-show="kfdk">
          <el-col :span="12">
            <el-form-item label="人行保障住房分类:"
                          prop="rhbzffl"
                          class="special-input">
              <el-select v-model="conInfoForm.rhbzffl"
                         style="width:100%">
                <el-option v-for="(value,key) in rhbzffl"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="银监保障住房分类:"
                          prop="yjbzffl"
                          class="special-input">
              <el-select v-model="conInfoForm.yjbzffl"
                         style="width:100%">
                <el-option v-for="(value,key) in yjbzffl"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </div>

        <div id="table1"
             v-show="table1">
          <el-col :span="12">
            <el-form-item label="是否涉农企业:"
                          prop="whetherArgRelated"
                          class="special-input">
              <el-select v-model="conInfoForm.whetherArgRelated"
                         style="width:100%"
                         @change="changeArgRelated">
                <el-option v-for="(value,key) in whetherArgRelated"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <div v-show="isArgType">
            <el-col :span="12">
              <el-form-item label="涉农企业类型:"
                            prop="argType"
                            class="special-input">
                <el-select v-model="conInfoForm.argType"
                           style="width:100%"
                           :disabled="disArgType">
                  <el-option v-for="(value,key) in argType"
                             :key="key"
                             :label="value"
                             :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </div>
          <div v-show="isSupArgType">
            <el-col :span="12">
              <el-form-item label="支农贷款类型:"
                            prop="supArgType"
                            class="special-input">
                <el-select v-model="conInfoForm.supArgType"
                           style="width:100%"
                           :disabled="disSupArgType">
                  <el-option v-for="(value,key) in supArgType"
                             :key="key"
                             :label="value"
                             :value="key"></el-option>
                </el-select>

              </el-form-item>
            </el-col>

          </div>

        </div>

        <div columns="4"
             id="greenTable"
             v-show="greenTable">

          <el-col :span="12">
            <el-form-item label="是否绿色贷款:"
                          prop="greenLoan"
                          class="special-input">
              <el-select v-model="conInfoForm.greenLoan"
                         style="width:100%"
                         @change="greenLoanChange">
                <el-option v-for="(value,key) in greenLoan"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12"
                  v-show="isGreenLoanUse">
            <el-form-item label="绿色贷款的贷款用途:"
                          prop="greenLoanUse"
                          class="special-input">
              <el-select v-model="conInfoForm.greenLoanUse"
                         style="width:100%">
                <el-option v-for="(value,key) in greenLoanUse"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12"
                  v-show="isGreenRiskType">
            <el-form-item label="环境、安全等重大风险企业类别:"
                          prop="greenRiskType"
                          class="special-input">
              <el-select v-model="conInfoForm.greenRiskType"
                         style="width:100%"
                         @change="greenRiskTypeChange">
                <el-option v-for="(value,key) in greenRiskType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12"
                  v-show="isGreenRiskDetail01">
            <el-form-item label="涉及环境保护违法违规类型:"
                          prop="greenRiskDetail01"
                          class="special-input">
              <el-select v-model="conInfoForm.greenRiskDetail01"
                         style="width:100%">
                <el-option v-for="(value,key) in greenRiskDetail01"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12"
                  v-show="isGreenRiskDetail02">
            <el-form-item label="安全生产违法违规类型:"
                          prop="greenRiskDetail02"
                          class="special-input">
              <el-select v-model="conInfoForm.greenRiskDetail02"
                         style="width:100%">
                <el-option v-for="(value,key) in greenRiskDetail02"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </div>

        <el-col :span="12"
                v-show="isGreenRiskDetail04">
          <el-form-item label="职业病预防控制措施不达标类型:"
                        prop="greenRiskDetail04"
                        class="special-input">
            <el-select v-model="conInfoForm.greenRiskDetail04"
                       style="width:100%">
              <el-option v-for="(value,key) in greenRiskDetail04"
                         :key="key"
                         :label="value"
                         :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>

        </div>

      </fieldset>

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
</template>

<script>

import { getConInfoMapByContarctId, RuleEngineMapper, updateConInfo,
  getMonthAddDate, getTermByEndDate, getChangeRate } from '@/api/csm'

import { validatePhoneTwo, validatePostCode, validateEMail } from '@/utils/conValidate.js'
import enums from '@/utils/enums'// 格式化的枚举
import axios from 'axios'
import qs from 'qs'

export default {
  name: 'conInfoHt',

  components: {

  },
  props: {

    paramsConTree: { // 用于接受父组件传来的参数
      // con_tree传递过来的参数放在这里
      proFlag: '1',
      contractId: '123'

    }
  },
  computed: {
    selected: ''
  },
  data() {
    return {

      isconInfoForm: false, // 只开放相关的提供查看

      showSave: true, // 默认是选择查看，不允许编辑

      // disable
      disGuarantyType: false, // CDZC0005 抵押方式的多选框是否禁用

      disContractAmt: false, // 默认是放款金额是可以修改的
      disCurrencyCd: false, // 默认可行选择其他货币

      disArgType: false, // 是否禁用涉农选项
      disSupArgType: false, // 是否禁用支农贷类型
      disBzjbl: false, // 是否禁用保证金比例
      disSave: false, // 禁用掉是否保存这个选项
      disCycleIndCon: false, // 默认不禁用 是否融单这个选项
      disFirstRepayTerm: false, // 默认选择不禁用 首次还款期次
      disRepaymentType: false, // 默认显示本次出账方式

      disbeginDate: false,
      disendDate: false,
      disspecPaymentDate: false,
      discontractDate: false,
      discontractAddress: false,
      disloanUse: false,
      disloanTurn: false,
      disriskInfo: false,
      disact: false,
      disserviceType: false,
      disreduceAmount: false,

      // show or not 默认都是显示的
      hkfs: true,
      schkq: true,
      zdhkr: true,
      jgts: true,

      bzxx: true, // 是否显示标志信息内容
      kfdk: true,
      hkxx: true, // 将默认的还款方式 界面设置为可见
      exchangeRate: true,
      nongdandai: true, // 默认显示是否融单这个选项
      cqcs: true,
      jnjpl: true,
      greenTable: true,

      table1: true,
      table2: true,
      dbfs: true,

      isBzjbl: true, // 是否显示保证金比例
      isArgType: true, // 是否涉农
      isSupArgType: true, // 是否支农贷类型

      isGreenRiskDetail01: true, // 涉及环境保护违法违规类型
      isGreenRiskDetail04: true,
      isGreenRiskDetail02: true,
      isGreenLoanUse: true, // 是否显示绿色贷款
      isGreenRiskType: true, // 是否禁用 风险类别选项

      o: {
        conInfo: { guarantyType: '' }

      }, // 这边保存了 相关合同数据
      conInfoForm: {// 初始化con_info_ht的form表单
        guarantyType: ['01', '05']

      },
      // 合同明细页面需要展示的相关数据参数
      contractId: '',
      xgbz: '',
      proFlag: '',
      productType: '',
      oldContractId: '',
      legCode: '0700', // TODO 先写死

      rules: {// 表单验证
        paperConNum: [
          { required: true, message: '纸质合同编号不能为空!', trigger: 'blur' }
        ],
        currencyCd: [{
          required: true, message: '币种信息不能为空!', trigger: 'blur'
        }],
        contractAmt: [
          { required: true, message: '请输入合同金额', trigger: 'blur' },
          {
            pattern: /^([1-9][\d]{2,10})(\.[\d]{1,2})?$/,
            message: '请输入正确的金额,在100 ~ 100,000,000,000 之间,并保留两位小数',
            trigger: 'blur'
          }
        ],
        bzjbl: [
          { required: true, message: '保证金比例不能为空', trigger: 'blur' },
          {
            pattern: /^([1-9][\d]{0,2}|0)$/,
            message: '请输入正确的比例,在0 ~ 100之间,并保留两位小数',
            trigger: 'blur'

          }
        ],
        beginDate: [{ required: true, message: '起始日期不能为空', trigger: 'blur' }],
        contractTerm: [{ required: true, message: '合同期限不能为空', trigger: 'blur' },
          { pattern: /^([1-9][\d]{0,3}|[1-8][\d]{4}|[9][0-4][\d]{3}|[9][5][0]{3}|0)?$/,
            message: '请输入正确的合同期限,在0 ~ 95000 之间',
            trigger: 'blur'
          }
        ]

      },

      // guarantyType: enums.guarantyTypeCd, // 担保方式 CDZC0005
      mainGuarantyType: enums.guarantyTypeCd, // 主担保方式 CDZC0005
      agriculLoans: enums.YesOrNoCd,

      currencyCd: enums.currencyCd, // 币种格式化  CD000001
      cycleUnit: enums.cycleUnitCd, // XD_GGCD6009

      repaymentType: enums.repaymentTypeCd, // 还款方式  XD_SXCD1162
      productTypeCd: enums.productType,
      cycleIndCon: enums.isBankTeamLoan,

      loanTurn: enums.loanTurnCd, // 行业投向 CDXY0300
      riskInfo: enums.riskInfoCd, // 涉及环境、安全等重大情况 XD_SXYW0211
      act: enums.takeStepsCd, // 采取措施  XD_SXYW0212
      serviceType: enums.serviceTypeCd, // XD_SXYW0215 节能环保项目及服务类型
      reduceAmount: enums.reduceAmountCd, // XD_SXYW0214 节能减排量
      ajustType: enums.ajustTypeCd, // 产业结构调整类型 XD_SXCD8030
      upgradeType: enums.YesOrNoCd, // 工业转型升级标识 YesOrNoCd
      newProductType: enums.newProductTypeCd, // 战略新兴产业类型 XD_SXCD1204
      rhbzffl: enums.rhbzfflCd, // 人行保障住房分类 XD_SXYW0232
      yjbzffl: enums.yjbzfflCd, // 银监保障住房分类 XD_SXYW0233
      whetherArgRelated: enums.YesOrNoCd, // 是否涉农企业
      argType: enums.argTypeCd, // 涉农企业类型 XD_SNQYLX1001
      supArgType: enums.supArgTypeCd, // 支农贷款类型 XD_ZNDKLX1002
      greenLoan: enums.YesOrNoCd, // 是否绿色贷款
      greenLoanUse: enums.greenLoanUseCd, // 绿色贷款的贷款用途 XD_DKSQLX0002
      greenRiskType: enums.greenRiskTypeCd, // 环境、安全等重大风险企业类别 XD_DKSQLX0001
      greenRiskDetail01: enums.greenRiskDetail01Cd, // XD_DKSQLX0003
      greenRiskDetail02: enums.greenRiskDetail02Cd, // XD_DKSQLX0004
      greenRiskDetail04: enums.greenRiskDetail04Cd // XD_DKSQLX0005

    }
  },
  created() {
    const param = this.paramsConTree
    console.log('数据传输成功！' + JSON.stringify(param))

    this.contractId = param.contractId
    this.xgbz = param.xgbz
    this.proFlag = param.proFlag
    this.productType = param.productType
    this.oldContractId = ''

    this.kfdk = false
    if (this.productType == '01002003') {
      this.kfdk = true
    }

    if (this.productType == '01008001' || this.productType == '01008002' || this.productType == '01008010' ||
      this.productType == '01009001' || this.productType == '01009002' || this.productType == '01009010' ||
      this.productType == '01007008' || this.productType == '01010001' || this.productType == '01007007' ||
      this.productType == '01011001' || this.productType == '01012001') {
      this.hkfs = false
      this.schkq = false
    }

    // 01007013信用证开证  01007010提货担保 01007014国际保函 为表外业务，故在合同签约界面删除“还款方式”、“首次还款期次”、“指定还款日”等功能界面
    if (this.productType == '01007013' || this.productType == '01007010' || this.productType == '01007014') {
      this.hkxx = false
    }

    // 获取相应的法人代码

    this.initConInfoHt(param)
  },
  mounted() {
    // this.clearValidate('conInfoForm') // 清除整个表单的校验
  },
  methods: {
    // clearValidate(formName) {
    //   this.$refs[formName].clearValidate()
    // },
    // 牌价查询---获取当前币种的汇率信息
    pjcx() {
      var bz = this.conInfoForm.currencyCd
      if (bz == 'CNY') {
        // 人民币  汇率默认1
        this.o.conInfo.exchangeRate = '1'
        this.conInfoForm.exchangeRate = '1'
        this.count()
      } else {
        var json = { bz: bz }
        getChangeRate(json).then((response) => {
          const text = response.date
          console.log('[getChangeRate]..' + JSON.stringify(text))
          if (text) {
            if (text.validityInd == '1') {
              if (text.msg == '' || text.msg == null) {
                this.conInfoForm.exchangeRate = parseFloat(parseFloat(text.disRateOfRmb) / parseFloat(100)).toFixed(8)
                this.o.conInfo.exchangeRate = this.conInfoForm.exchangeRate

                alert('币种[' + bz + ']的汇率信息获取成功')
                this.count()
              } else {
                alert(text.msg + ',请国结系统推送当天的利率信息到信贷系统！')
              }
            } else {
              alert('未获取到汇率信息')
            }
          } else {
            alert('未获取到汇率信息')
          }
        }).catch((error) => {
          console.log(error)
        })
      }
    },

    changeCon() {
      var agriculLoans = this.conInfoForm.agriculLoans
      if (agriculLoans == '1') {
        this.disCycleIndCon = false
      } else {
        this.conInfoForm.cycleIndCon = '0'
        this.disCycleIndCon = true
      }
    },

    // 合同起期不能小于批复生效日
    validateBeginDate() {
      console.log('[validateBeginDate] invoke...')
      this.getConEndate()// 合同起期变化时 止期也变化(放在前面 避免合同调整时被屏蔽)
      if (this.oldContractId != null && this.oldContractId != '') { // 合同调整不校验
        return
      } else {
        // var beginDate = this.o.conInfo.beginDate
        var beginDate = this.conInfoForm.beginDate
        var validDate = this.o.bizInfo.validDate
        console.log('beginDate:' + beginDate + ',validDate:' + validDate)

        if (beginDate != null && beginDate != '') {
          if (beginDate.substr(0, 10) < validDate.substr(0, 10)) {
            alert('合同起期不能小于批复生效日期!')
            this.conInfoForm.beginDate = ''
            return
          }
        }
      }
    },

    // 通过起始日期和期限 计算出合同到期日期
    getConEndate() {
      console.log('[getConEndate] invoke...')

      var beginDate = this.conInfoForm.beginDate// 合同起始日期
      var conTerm = this.conInfoForm.contractTerm// 合同期限
      var conUnit = this.conInfoForm.cycleUnit// 合同期限单位
      var creditTerm = this.o.bizDtlInfo.creditTerm// 批复里的期限
      var cycleUnit = this.o.bizDtlInfo.cycleUnit// 批复里的期限单位
      console.log('beginDate:' + beginDate + ',conTerm:' + conTerm + ',conUnit:' + conUnit + ',creditTerm' + creditTerm + ',cycleUnit:' + cycleUnit)
      var qxdw// 期限单位(后台)
      var conqxdw = '月'// 期限单位(页面显示)
      if (conUnit != null) { // 合同里存的期限单位
        if (conUnit == '01') { // 如果合同期限单位为01则是年
          qxdw = 'Y'
        } if (conUnit == '03') { // 如果合同期限单位为03则是季
          qxdw = 'J'
        } if (conUnit == '04') { // 如果合同期限单位为04则是月
          qxdw = 'M'
        } if (conUnit == '05') { // 如果合同期限单位为05 则是日
          qxdw = 'D'
        }
      }
      if (cycleUnit != null) { // 批复里存的期限单位
        if (cycleUnit == '01') { // 如果合同期限单位为01则是年
          conqxdw = '年'
        } if (cycleUnit == '03') { // 如果合同期限单位为03则是季
          conqxdw = '季'
        } if (cycleUnit == '04') { // 如果合同期限单位为04则是月
          conqxdw = '月'
        } if (cycleUnit == '05') { // 如果合同期限单位为05 则是日
          conqxdw = '日'
        }
      }
      if (creditTerm != null && cycleUnit != null && creditTerm < conTerm) {
        // 两个地方的数据要同步更新

        this.conInfoForm.endDate = ''

        alert('合同期限不能大于批复期限' + creditTerm + '个月')
        return
      }
      if (beginDate != null && conTerm != null) {
        var date = beginDate.substring(0, 10)// 截取起始日期
        var json = { 'qxdw': qxdw, 'qx': conTerm, 'rq': date }
        console.log('json is ' + JSON.stringify(json))

        getMonthAddDate(json).then(response => {
          const data = response.data
          console.log('[getMonthAddDate] res ' + JSON.stringify(data))

          this.o.conInfo.endDate = data.dqrq
          this.conInfoForm.endDate = data.dqrq
        }).catch((error) => {
          console.log(error)
        })
      }
    },

    initConInfoHt(data) { // 初始化页面合同信息
      // axios.get(
      //   '/mybatis-service/process/conInfoSxxy/getConInfoMapByContarctId', {
      //     params: {
      //       contractId: this.contractId,
      //       contractType: '02'
      //     }
      //   }

      // )
      const params = {
        contractId: this.contractId,
        contractType: '02'
      }
      getConInfoMapByContarctId(params)
        .then((res) => { // 这里必须使用箭头函数来赋值
          console.log('initConInfoHt.....')
          const childData = res.data
          this.o = childData // 将请求后台得到的相关的数据信息保存到dataMap中
          // console.log('o is :' + JSON.stringify(this.o))

          if (!childData.tbConFlagInfo.greenLoan) {
            this.conInfoForm.greenLoan = '0'
          } else {
            this.conInfoForm.greenLoan = childData.tbConFlagInfo.greenLoan
          }

          this.enableAassurePer(childData.conInfo.productType)

          this.conInfoForm.partyName = childData.party.partyName
          this.conInfoForm.partyNum = childData.party.partyNum
          // 基本信息
          this.conInfoForm.productType = childData.conInfo.productType
          this.conInfoForm.contractNum = childData.conInfo.contractNum
          this.conInfoForm.paperConNum = childData.conInfo.paperConNum
          this.conInfoForm.oldContractNum = childData.conInfo.oldContractNum
          this.conInfoForm.currencyCd = childData.conInfo.currencyCd
          this.conInfoForm.contractAmt = childData.conInfo.contractAmt
          this.conInfoForm.bzjbl = childData.conInfo.bzjbl
          this.conInfoForm.beginDate = childData.conInfo.beginDate
          this.conInfoForm.contractTerm = childData.conInfo.contractTerm
          this.conInfoForm.cycleUnit = childData.conInfo.cycleUnit
          this.conInfoForm.endDate = childData.conInfo.endDate
          this.conInfoForm.repaymentType = childData.conInfo.repaymentType
          this.conInfoForm.firstRepayTerm = childData.conInfo.firstRepayTerm
          this.conInfoForm.specPaymentDate = childData.conInfo.specPaymentDate
          this.conInfoForm.internalDays = childData.conInfo.internalDays
          this.conInfoForm.cycleIndCon = childData.conInfo.cycleIndCon
          this.conInfoForm.contractDate = childData.conInfo.contractDate
          this.conInfoForm.contractAddress = childData.conInfo.contractAddress
          this.conInfoForm.loanUse = childData.conInfo.loanUse
          this.conInfoForm.exchangeRate = childData.conInfo.exchangeRate
          this.conInfoForm.rmbAmt = childData.conInfo.rmbAmt
          this.conInfoForm.guarantyType = childData.conInfo.guarantyType.split(',')
          this.conInfoForm.mainGuarantyType = childData.conInfo.mainGuarantyType
          this.conInfoForm.agriculLoans = childData.conInfo.agriculLoans

          // 标志信息
          this.conInfoForm.loanTurn = childData.tbConFlagInfo.loanTurn
          this.conInfoForm.riskInfo = childData.tbConFlagInfo.riskInfo
          this.conInfoForm.act = childData.tbConFlagInfo.act
          this.conInfoForm.serviceType = childData.tbConFlagInfo.serviceType
          this.conInfoForm.reduceAmount = childData.tbConFlagInfo.reduceAmount
          this.conInfoForm.ajustType = childData.tbConFlagInfo.ajustType
          this.conInfoForm.upgradeType = childData.tbConFlagInfo.upgradeType
          this.conInfoForm.newProductType = childData.tbConFlagInfo.newProductType
          this.conInfoForm.rhbzffl = childData.tbConFlagInfo.rhbzffl
          this.conInfoForm.yjbzffl = childData.tbConFlagInfo.yjbzffl
          this.conInfoForm.whetherArgRelated = childData.tbConFlagInfo.whetherArgRelated
          this.conInfoForm.argType = childData.tbConFlagInfo.argType
          this.conInfoForm.supArgType = childData.tbConFlagInfo.supArgType
          this.conInfoForm.greenLoanUse = childData.tbConFlagInfo.greenLoanUse
          this.conInfoForm.greenRiskType = childData.tbConFlagInfo.greenRiskType

          this.conInfoForm.greenRiskDetail01 = childData.tbConFlagInfo.greenRiskDetail01
          this.conInfoForm.greenRiskDetail02 = childData.tbConFlagInfo.greenRiskDetail02
          this.conInfoForm.greenRiskDetail04 = childData.tbConFlagInfo.greenRiskDetail04

          // 调整时初始化原合同金额
          if (childData.conInfo.loanUse == null || childData.conInfo.loanUse == '') {
            this.conInfoForm.loanUse = childData.bizDtlInfo.loanUse
            console.log('调整之后的原合同金额:' + this.conInfoForm.loanUse)
          }

          this.conInfoForm.cycleUnit = '04'
          // 合同调整时，金额、币种不能变
          this.oldContractId = childData.conInfo.oldContractId

          if (this.productType == '01001050' || this.productType == '01001040' || this.productType == '01001001') {
            const agriculLoans = this.conInfoForm.agriculLoans

            if (!agriculLoans) {
              this.conInfoForm.agriculLoans = '0'
            }
          } else {
            this.nongdandai = false
          }

          const cycleIndCon = childData.conInfo.agriculLoans

          if (cycleIndCon != '1') {
            this.conInfoForm.cycleIndCon = '0'
          }
          this.disCycleIndCon = true // 选择禁止修改是否融单这个选项

          if (this.oldContractId != null && this.oldContractId != '') {
            if (this.productType == '01007001' || this.productType == '01007002' || this.productType == '01007003' ||
              this.productType == '01007004' || this.productType == '01007005' || this.productType == '01007006' ||
              this.productType == '010070009' || this.productType == '010070010' || this.productType == '01007011' ||
              this.productType == '01007012' || this.productType == '01007013' || this.productType == '01007014') {
              // TODO 还款方式这边需要将下拉选项框给 动态添加，现在无法搞定 2019/03/01
              // 6个表内业务---三种还款方式
              if (this.productType == '01007001' || this.productType == '01007003' || this.productType == '01007004' ||
                this.productType == '01007006' || this.productType == '01007005' || this.productType == '01007011') {
                //	nui.get("bizDtlInfo.repaymentType").setData(getDictData('XD_SXCD1162','str','1100,1200,1400'));
                // 5个表外业务---两种还款方式 (3个表外+2个表内走表外)
              } else if (this.productType == '01007009' || this.productType == '01007012' ||
                this.productType == '01007014' || this.productType == '01007013' || this.productType == '01007010') {
                // nui.get("bizDtlInfo.repaymentType").setData(getDictData('XD_SXCD1162','str','1100,1400'));//去掉了1700等本等息
              }

              this.disFirstRepayTerm = false
            } else if (this.productType == '01006001' || this.productType == '01006002' ||
              this.productType == '01006010') { // 村镇银行贴现产品
              this.conInfoForm.repaymentType = '21'
              this.disRepaymentType = true
            } else {
              // TODO 还款方式这边需要将下拉选项框给 动态添加，现在无法搞定 2019/03/01
              if (childData.conInfo.cycleIndCon != null &&
                childData.conInfo.cycleIndCon != '' &&
                childData.conInfo.cycleIndCon == '1') {
                if (this.legCode == '5099') {
                  // nui.get("conInfo.repaymentType").setData(getDictData('XD_SXCD1162','str','1100,1200'));
                } else {
                  // nui.get("conInfo.repaymentType").setData(getDictData('XD_SXCD1162','str','1100'));
                }
              } else {
                if (this.legCode == '5099') {
                  // nui.get("conInfo.repaymentType").setData(getDictData('XD_SXCD1162','str','0100,0200,0300,0400,1100,1200,1400,1410'));
                } else {
                  // nui.get("conInfo.repaymentType").setData(getDictData('XD_SXCD1162','str','0100,0200,1100,1400,1410'));
                }
              }

              this.disFirstRepayTerm = false
            }

            // 出账成功不允许调整合同金额
            const json1 = { param: this.oldContractId, name: 'RCON_0089' }
            RuleEngineMapper(json1).then((response) => {
              const msg = response.data

              console.log('[RCON_0089]msg ' + msg)
              if (msg == '0') {
                this.disContractAmt = true // 出账成功后不允许调整合同金额
              } else {
                this.disContractAmt = false
                console.log('该合同已出账成功合同调整不允许调整金额!')// 允许调整金额
              }

              this.disCurrencyCd = true // 将金额这一栏给不允许调整
            }).catch((error) => {
              console.log(error)
            })
          }
          // 贴现不展示担保方式
          if (this.productType == '01006001' || this.productType == '01006002' ||
            this.productType == '01006010' // 村镇银行贴现产品
          ) {
            console.log('村镇银行贴现产品...')
            this.dbfs = false
            this.o.conInfo.repaymentType = '21'
            this.conInfoForm.repaymentType = '21'
            this.disRepaymentType = true
          } else {
            // 如果担保方式有保证金，主担保方式换成质押，如果已有质押，则直接去掉
            var grt = this.o.conInfo.guarantyType
            if (grt.indexOf('03') != -1) {
              grt = grt.replace('05', '')
            } else {
              grt = grt.replace('05', '03')
            }
            // TODO 一些需要添加的字典项 2019/3/4
            // nui.get("conInfo.mainGuarantyType").setData(getDictData('CDZC0005','str',grt));
            // nui.get("conInfo.guarantyType").setData(getDictData('CDZC0005','str',o.bizInfo.guarantyType));
          }

          // 设计环境、安全等重大情况 节能环保服务及项目类型 重点关注行业类型 默认为 未涉及 0非节能环保服务及项目类型 0非重点关注行业类型
          if (this.o.tbConFlagInfo.riskInfo == null || this.o.tbConFlagInfo.riskInfo == '') {
            this.o.tbConFlagInfo.riskInfo = '0'
            this.conInfoForm.riskInfo = '0'
          }
          if (this.o.tbConFlagInfo.serviceType == null || this.o.tbConFlagInfo.serviceType == '') {
            this.o.tbConFlagInfo.serviceType = '0'
            this.conInfoForm.serviceType = '0'
          }
          // 间隔天数反显7天
          if (this.o.conInfo.internalDays == null || this.o.conInfo.internalDays == '') {
            this.o.conInfo.internalDays = '7'
            this.conInfoForm.internalDays = '7'
          }

          this.exchangeRate = false
          this.riskinfo()
          this.servicetype()

          // 国结贸易融资表内业务要求能在合同签约的时候操作还款方式
          if (this.productType == '01007001' || this.productType == '01007003' || this.productType == '01007004' || this.productType == '01007009' ||
            this.productType == '01007012' || this.productType == '01007011' || this.productType == '01007006' || this.productType == '01007005') {
            this.disRepaymentType = false
          }
          // 国结：等额本息、等额本金、阶段性等额本金、阶段性等额本息---不要
          if (this.productType == '01007001' || this.productType == '01007003' || this.productType == '01007004' ||
            this.productType == '01007009' || this.productType == '01007012' || this.productType == '01007011' ||
            this.productType == '01007006' || this.productType == '01007005' || this.productType == '01007014' ||
            this.productType == '01007013' || this.productType == '01007010') { // 国结：等额本息、等额本金、阶段性等额本金、阶段性等额本息---不要
            // TODO 2019/02/28 只显示一些必要的属性
            // nui.get("conInfo.repaymentType").setData(getDictData('XD_SXCD1162','str','1100,1200,1400'));//去掉了1700等本等息
          }

          return { currencyCd: this.conInfoForm.currencyCd, func: this.setShowMode }
        }).then(
          function(data) {
            console.log('合同加载完成之后的操作!' + JSON.stringify(data))

            data.func(data.currencyCd)
          }).catch((err) => {
          console.log(err)
        })
    },
    // 合同明细页面加载晚吃之后进行的一些相关操作
    setShowMode(currencyCd) {
      console.log('[setShowMode]currencyCd ' + JSON.stringify(currencyCd))

      const bz = currencyCd
      console.log('币种 bz = ' + bz)
      if (bz == '' || bz == null || bz == 'null' || bz == 'undefined') {

      } else if (bz != 'CNY') {
        this.disExchangeRate = true
      } else {
        this.disExchangeRate = false
      }

      console.log('proFlag :' + this.proFlag + ',xbgz :' + this.xgbz)
      // proFlag   如果流程标识为0表示为查看，隐藏保存按钮禁用控件
      if (this.proFlag != '1') {
        this.showSave = false
        this.isconInfoForm = true
      }

      if (this.xgbz == '1') {
        this.bzxx = false

        this.disbeginDate = true
        this.disendDate = true
        this.disspecPaymentDate = true
        this.discontractDate = true
        this.discontractAddress = true
        this.disloanUse = true

        this.disloanTurn = true
        this.disriskInfo = true
        this.disact = true
        this.disserviceType = true
        this.disreduceAmount = true
      }
    },

    // 通过起始日期、到期日期、期限单位计算期限
    getTerm() {
      console.log('[getTerm] invoke...')
      // var beginDate = this.o.conInfo.beginDate.substring(0, 10)// 合同起期
      // var endDate = this.o.conInfo.endDate.substring(0, 10)// 合同止期
      // var termUnit = this.o.conInfo.cycleUnit// 合同期限单位
      // var creditTerm = this.o.bizDtlInfo.creditTerm// 批复里的期限
      var beginDate = this.conInfoForm.beginDate.substring(0, 10)// 合同起期
      var endDate = this.conInfoForm.endDate.substring(0, 10)// 合同止期
      var termUnit = this.conInfoForm.cycleUnit// 合同期限单位
      var creditTerm = this.o.bizDtlInfo.creditTerm// 批复里的期限
      console.log('beginDate:' + beginDate + ',endDate:' + endDate + ',termUnit:' + termUnit + ',creditTerm:' + creditTerm)
      if (beginDate != null && termUnit != null) {
        if (endDate <= beginDate) {
          this.conInfoForm.endDate = ''// 将合同止期置为空
          alert('合同止期不能小于等于合同起期')
          return
        }
        // 期限单位目前默认为"月(M)"
        var termData = { 'beginDate': beginDate, 'endDate': endDate, 'termUnit': 'M' }
        console.log('termData ' + JSON.stringify(termData))
        getTermByEndDate(termData).then((response) => {
          const data = response.data
          console.log('[getTermByEndDate] ' + JSON.stringify(data))
          if (data != null) {
            if (data.term > creditTerm) { // 如果计算出的合同期限大于批复期限
              this.conInfoForm.endDate = ''

              return alert('不能大于批复期限' + creditTerm + '个月,请重新选择到期日期')
            }
          }
          this.conInfoForm.contractTerm = data.term
          this.o.conInfo.contractTerm = data.term
        }).catch((error) => {
          console.log(error)
        })
      }
    },

    // 签约日期要大于或等于批复起期
    qyrq() {
      var conDate = this.conInfoForm.contractDate
      var validDate = this.o.bizInfo.validDate
      if (conDate != null && conDate != '') {
        if (conDate <= validDate) {
          alert('签约日期不能小于批复生效日期!')
          this.conInfoForm.contractDate = ''
        }
      }
    },

    // 担保方式发生改变
    guarantyTypechg() {
      var guarantyType = this.conInfoForm.guarantyType
      console.log('原担保方式:guarantyType ' + guarantyType)
      guarantyType = guarantyType.toString()
      if (guarantyType.indexOf('03') != -1) {
        guarantyType = guarantyType.replace('05', '')
      } else {
        guarantyType = guarantyType.replace('05', '03')
      }
      console.log('现担保方式:guarantyType ' + guarantyType)
      this.conInfoForm.guarantyType = guarantyType.split(',') // 注意这个地方必须要分割，这个Form中，这个元素是一个数组
      this.o.conInfo.guarantyType = guarantyType
      this.conInfoForm.mainGuarantyType = ''
      // nui.get("conInfo.mainGuarantyType").setData(getDictData('CDZC0005','str',guarantyType));
    },

    // 是否涉农
    changeArgRelated(e) {
      console.log('[changeArgRelated] invoke....' + e)
      if (e == '1') {
        this.isArgType = true

        this.supArgTypeFun(1)
      } else {
        this.isArgType = false

        this.conInfoForm.argType = ''

        this.supArgTypeFun(0)
      }
    },
    supArgTypeFun(x) {
      console.log('[supArgType] invoke.....' + x)
      if (x == '0') {
        this.isSupArgType = false

        if (this.conInfoForm.supArgType) { this.conInfoForm.supArgType = '' }
      } else {
        this.isSupArgType = true
      }
    },

    greenLoanChange() {
      console.log('[greenLoanChange] invoke....' + this.conInfoForm.greenLoan)
      if (this.conInfoForm.greenLoan == '1') {
        this.isGreenLoanUse = true
        this.isGreenRiskType = true
      } else {
        this.isGreenLoanUse = false// 隐藏绿色贷款用途
        this.isGreenRiskType = false// 隐藏环境、安全等重大风险企业类别
        this.isGreenRiskDetail01 = false// 隐藏涉及环境保护违法违规类型
        this.isGreenRiskDetail02 = false // 隐藏安全生产违法违规类型
        this.isGreenRiskDetail04 = false// 隐藏职业病预防控制措施不达标类型s
      }
    },
    greenRiskTypeChange() {
      const greenRiskType = this.conInfoForm.greenRiskType
      console.log('[greenRiskTypeChange] invoke...' + greenRiskType)

      if (greenRiskType == '1' || greenRiskType == '2' || greenRiskType == '4') {
        if (greenRiskType == '1') {
          this.isGreenRiskDetail01 = true
        } else {
          this.isGreenRiskDetail01 = false
        }

        if (greenRiskType == '2') {
          this.isGreenRiskDetail02 = true
        } else {
          this.isGreenRiskDetail02 = false
        }

        if (greenRiskType == '4') {
          this.isGreenRiskDetail04 = true
        } else {
          this.isGreenRiskDetail04 = false
        }
      }
    },

    selectTrade4(e) {
      console.log('TODO [selectTrade4] invoke.....')
    },

    ValidateForm() { // 子组件的form表单验证
      let flg = false
      this.$refs.conInfoForm.validate((valid) => {
        if (valid) {
          flg = true
        } else {
          alert('请按规则填写信息!')
          flg = false
        }
      })
      return flg
    },
    childSaveShow(data) { // 在保存成功之后需要返显数据

    },
    save() {
      console.log('点击了保存按钮。。。')

      // 有关表单的ref属性
      this.$refs['conInfoForm'].validate((valid) => {
        console.log(valid)

        if (valid) {
          console.log('校验通过！')
        } else {
          alert('请按规则填写信息！')
          return false
        }
      })

      // 合同币种不是人民币的时候新增的汇率信息和折算人民币金额必须要
      var bz = this.o.conInfo.currencyCd
      var conInfoExchangeRate = this.o.conInfo.exchangeRate
      var conInfoRmbAmt = this.o.conInfo.rmbAmt

      if (bz != 'CNY') {
        this.disExchangeRate = false
        if (conInfoExchangeRate == null || conInfoExchangeRate == '' || conInfoRmbAmt == null || conInfoRmbAmt == '') {
          alert('汇率信息和折算人民币信息错误！')
          return
        }
      }

      console.log(this.contractId + '...' + JSON.stringify(this.o))
      this.o.tbConFlagInfo.contractId = this.contractId // 从vue 的data中取出相应的数据

      if (this.o.tbConFlagInfo.greenLoan == '0') {
        this.o.tbConFlagInfo.greenLoanUse = null
        this.o.tbConFlagInfo.greenRiskType = null
        this.o.tbConFlagInfo.greenRiskDetail = null
      } else {
        this.o.tbConFlagInfo.greenRiskDetail = this.getGreenRiskDetail()
      }
      // 给合同余额赋值
      var conBalance = this.o.conInfo.conBalance
      var oldAmt = this.o.conInfo.oldamt// 合同调整时页面初始化此隐藏域
      if (conBalance == '' || conBalance == null || conBalance == 'null') {
        conBalance = 0
      }
      if (conBalance != 0) {
        var ocupy = parseFloat(oldAmt) - parseFloat(conBalance)
        this.o.conInfo.conBalance = parseFloat(this.conInfoForm.contractAmt) - parseFloat(ocupy)
      } else {
        this.o.conInfo.conBalance = parseFloat(this.conInfoForm.contractAmt)
      }
      // 贴现没有担保方式，但是为了算业务别默认质押
      if (this.productType == '01006001' || this.productType == '01006002' ||
        this.productType == '01006010' // 村镇银行贴现产品
      ) {
        this.o.conInfo.mainGuarantyType = '03'
      }
      console.log('o conInfo' + this.o.conInfo.conBalance)
      // 期限校验
      var condate = this.o.conInfo.endDate
      var conbedate = this.o.conInfo.beginDate
      condate = condate.toString()
      conbedate = conbedate.toString()
      if (condate != null || condate != undefined || conbedate != null || conbedate != undefined) {
        alert('合同终止日期不能为空')
        this.disSave = false

        return
      }
      if (condate.substr(0, 10) <= conbedate.substr(0, 10)) {
        alert('合同止期不能小于等于合同起期') // 失败时后台直接返回出错信息
        this.disSave = false // 显示保存按钮

        return
      }
      // 评级行业分类和综合授信行业不一致时，不允许发起综合授信业务申报
      this.o.partyId = this.o.party.partyId
      this.o.bizType = this.o.bizInfo.bizType

      // axios.post(
      //   "/mybatis-service/process/ApplyDaoEos/updateConInfo",
      //   JSON.stringify(this.o),{
      //   headers: {
      //    'Content-Type':'application/json; charset=UTF-8'
      //   }
      // }).then((res)=>{
      //   let value=res.data
      //  console.log(value)
      //  alert("保存成功！")

      // }).catch((error)=>{
      //   console.log(error)
      // })

      updateConInfo(this.o).then((response) => {
        const res = response.data
        console.log('【updateConInfo】res ' + JSON.stringify(res))
        alert('保存成功！')
        // this.initConInfoHt(res)
      }).catch((error) => {
        console.log(error)
      })
    },

    riskinfo() {
      console.log('[riskinfo] invoke.....')
      var riskinfo = this.o.tbConFlagInfo.riskInfo
      if (riskinfo == '0' || riskinfo == '') {
        this.cqcs = false
      } else {
        this.cqcs = true
      }
    },

    servicetype() {
      console.log('[servicetype] invoke....')
      var riskinfo = this.o.tbConFlagInfo.serviceType

      if (riskinfo == '0' || riskinfo == '') {
        this.jnjpl = false
      } else {
        this.jnjpl = true
      }
    },

    enableAassurePer(productCd, value) {
      console.log('[enableAassurePer] invoke..... productCd:' + productCd + ' , value ' + value)
      if (productCd == '01008002' || productCd == '01008010' || productCd == '01008001' || productCd == '01009001' || productCd == '01009002' || productCd == '01009010' || productCd == '010090022' || productCd == '01007014') {
        this.disBzjbl = true
        this.conInfoForm.bzjbl = value
      } else {
        this.disBzjbl = false
      }
    },

    getGreenRiskDetail() {
      const greenRiskType = this.conInfoForm.greenRiskType
      console.log('[getGreenRiskDetail] invoke...' + greenRiskType)
      if (greenRiskType == '1') {
        return this.o.tbConFlagInfo.greenRiskDetail01
      } else if (greenRiskType == '2') {
        return this.o.tbConFlagInfo.greenRiskDetail02
      } else if (greenRiskType == '4') {
        return this.o.tbConFlagInfo.greenRiskDetail04
      }
      return null
    },
    bzChange() {
      const bz = this.conInfoForm.currencyCd
      console.log('[bzChange] invoke.....' + bz)

      if (bz == '' || bz == null || bz == 'null' || bz == 'undefined') {

      } else if (bz != 'CNY') {
        this.disExchangeRate = false
        this.conInfoForm.exchangeRate = ''
        this.conInfoForm.rmbAmt = ''
      } else {
        var conAmt = this.conInfoForm.contractAmt
        this.disExchangeRate = true
        this.conInfoForm.exchangeRate = '1'
        this.conInfoForm.rmbAmt = conAmt
      }
      this.count()
    },

    validAmt() {
      var appAmt = this.conInfoForm.rmbAmt// 批复折算人民币金额
      var conAmt = this.conInfoForm.contractAmt// 合同金额
      var exchangeRate = this.conInfoForm.exchangeRate// 批复币种汇率
      console.log('[validAmt] invoke....appAmt:' + appAmt + ',conAmt:' + conAmt + ',exchangeRate:' + exchangeRate)
      if (exchangeRate == '' || exchangeRate == null) {
        exchangeRate = 1
      }
      var changeAmt = (parseFloat(conAmt) * parseFloat(exchangeRate)).toFixed(6)//
      // 合同金额不能大于批复可用金额
      // 如果金额不是人民币  先不用校验--需要用折算人民币金额校验
      var bz = this.conInfoForm.currencyCd
      if (bz != 'CNY') {
        const rate = this.conInfoForm.exchangeRate // 汇率
        if (rate == '' || rate == null || rate == 'null' || rate == 'undefined') {
          alert('请先获取当前币种[' + bz + ']的汇率信息')
          this.conInfoForm.contractAmt = ''

          return
        }
      }

      // 调整时校验调整后金额不能小于已占用金额
      var conBalance = this.conInfoForm.conBalance
      var oldAmt = this.conInfoForm.oldAmt// 合同调整时页面初始化此隐藏域
      if (conBalance == '' || conBalance == null || conBalance == 'null') {
        conBalance = 0
      }
      if (conBalance != 0) { // 调整时、合同金额不能小于已占用金额--合同调整不能修改金额
        var ocupy = parseFloat(oldAmt) - parseFloat(conBalance)
        if (conAmt - ocupy < 0) {
          alert('合同金额不能小于已占用金额!')
          this.conInfoForm.contractAmt = ''

          return
        }
      }
      if (bz == 'CNY') {
        this.conInfoForm.rmbAmt = changeAmt
      }
      this.count()
    },
    // 折算人民币金额的计算
    count() {
      var rate = this.conInfoForm.exchangeRate // 汇率
      var bz = this.conInfoForm.currencyCd // 币种
      var conAmt = this.conInfoForm.contractAmt// 合同金额

      if (bz == '' || bz == null || bz == 'null' || bz == 'undefined') {

      } else if (rate == '' || rate == null || rate == 'null' || rate == 'undefined') {

      } else if (conAmt == '' || conAmt == null || conAmt == 'null' || conAmt == 'undefined') {

      } else { // 币种 汇率 合同金额 都要有值
        this.conInfoForm.rmbAmt = parseFloat(rate) * parseFloat(conAmt)
        console.log('[count()] conInfoForm.rmbAmt ' + this.conInfoForm.rmbAmt)
      }
    },

    conRpTpChg() {
      console.log('[conRpTpChg] invoke.....')
      var hkfs = this.conInfoForm.repaymentType
      // var hkfs = nui.get("conInfo.repaymentType").getValue();
      if (hkfs == '0300' || hkfs == '0400') {
        this.schkq = true

        // $("#schkq").css("display","block");
        // nui.get("conInfo.firstRepayTerm").show();
      } else {
        this.schkq = false
        this.conInfoForm.firstRepayTerm = '' // 将值置空
        // $("#schkq").css("display","none");
        // nui.get("conInfo.firstRepayTerm").hide();
        // nui.get("conInfo.firstRepayTerm").setValue('');
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
