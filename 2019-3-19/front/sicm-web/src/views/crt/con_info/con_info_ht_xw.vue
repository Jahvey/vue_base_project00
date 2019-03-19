<template>

  <el-row :gutter="20"
          class="form">
    <el-form label-width="200px"
             size="medium"
             :rules="rules"
             :model="conInfoXwForm"
             ref="conInfoXwForm"
             label-position="right"
             :disabled=isconInfoXwForm>
      <fieldset>
        <legend>
          <span>基本信息</span>
        </legend>
        <div columns="4"
             id="table1"
             v-show="table1">

          <el-col :span="12">
            <el-form-item label="客户名称:"
                          prop="partyName"
                          class="special-input">
              <el-input v-model="conInfoXwForm.partyName"
                        style="width:100%"></el-input>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户编号:"
                          prop="partyNum"
                          class="special-input">
              <el-input v-model="conInfoXwForm.partyNum"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="业务品种:"
                          prop="productType"
                          class="special-input">
              <el-select v-model="conInfoXwForm.productType"
                         style="width:100%">
                <el-option v-for="(value,key) in productType"
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
              <el-input v-model="conInfoXwForm.contractNum"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="纸质合同编号:"
                          prop="paperConNum"
                          class="special-input">
              <el-input v-model="conInfoXwForm.paperConNum"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原合同编号:"
                          prop="oldContractNum"
                          class="special-input">
              <el-input v-model="conInfoXwForm.oldContractNum"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种:"
                          prop="currencyCd"
                          class="special-input">
              <el-select v-model="conInfoXwForm.currencyCd"
                         style="width:100%">
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
              <el-input v-model="conInfoXwForm.contractAmt"
                        :disabled="isContractAmt"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="起始日期:"
                          prop="beginDate"
                          class="special-input">
              <el-date-picker type="date"
                              format="yyyy-MM-dd"
                              v-model="conInfoXwForm.beginDate"
                              style="width:100%"
                              placeholder="选择起始日期"
                              @change="validateBeginDate"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合同期限:"
                          prop="contractTerm"
                          class="special-input">
              <el-input v-model="conInfoXwForm.contractTerm"
                        style="width:60%;float:left"
                        @blur="getConEndate"></el-input>
              <el-select v-model="conInfoXwForm.cycleUnit"
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
                              v-model="conInfoXwForm.endDate"
                              style="width:100%"
                              placeholder="选择截止日期"
                              @change="getTerm"></el-date-picker>

            </el-form-item>
          </el-col>

          <el-col :span="12"
                  v-show="hkfs">
            <el-form-item label="还款方式:"
                          prop="repaymentType"
                          class="special-input">

              <el-select v-model="conInfoXwForm.repaymentType"
                         style="width:100%"
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
              <el-input v-model="conInfoXwForm.firstRepayTerm"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="合同循环标识:"
                          prop="cycleIndCon"
                          class="special-input">
              <el-select v-model="conInfoXwForm.cycleIndCon"
                         style="width:100%"
                         :disabled="iscycleIndCon">
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
                              v-model="conInfoXwForm.contractDate"
                              style="width:100%"
                              placeholder="请选择签约日期"
                              @change="qyrq"></el-date-picker>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="签约地点:"
                          prop="contractAddress"
                          class="special-input">
              <el-input v-model="conInfoXwForm.contractAddress"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="指定还款日:"
                          prop="specPaymentDate"
                          class="special-input">
              <el-input v-model="conInfoXwForm.specPaymentDate"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="间隔天数:"
                          prop="internalDays"
                          class="special-input">
              <el-input v-model="conInfoXwForm.internalDays"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="贷款用途:"
                          prop="loanUse"
                          class="special-input">
              <el-input v-model="conInfoXwForm.loanUse"
                        :disabled="isloanUse"
                        style="width:100%"></el-input>
            </el-form-item>
          </el-col>

        </div>

        <div columns="4"
             id="dbfs"
             v-show="dbfs">

          <el-col :span="12">
            <el-form-item label="担保方式:"
                          prop="guarantyType"
                          class="special-input">
              <el-select v-model="conInfoXwForm.guarantyType"
                         style="width:100%"
                         @change="guarantyTypechg">
                <el-option v-for="(value,key) in guarantyType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="主担保方式:"
                          prop="mainGuarantyType"
                          class="special-input">
              <el-select v-model="conInfoXwForm.mainGuarantyType"
                         style="width:100%">
                <el-option v-for="(value,key) in mainGuarantyType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </div>

      </fieldset>

      <fieldset>
        <legend>
          <span>标志信息</span>
        </legend>

        <div columns="4"
             id="table2"
             v-show="table2">

          <el-col :span="12">
            <el-form-item label="行业投向:"
                          prop="loanTurn"
                          class="special-input">
              <el-select v-model="conInfoXwForm.loanTurn"
                         style="width:100%"
                         placeholder="--请选择--"
                         @change="selectTrade4">
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
              <el-select v-model="conInfoXwForm.riskInfo"
                         style="width:100%">
                <el-option v-for="(value,key) in riskInfo"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </div>

        <div columns="4"
             id="cqcs"
             v-show="cqcs">

          <el-col :span="12">
            <el-form-item label="采取措施:"
                          prop="act"
                          class="special-input">
              <el-select v-model="conInfoXwForm.act"
                         style="width:100%">
                <el-option v-for="(value,key) in act"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>

        </div>

        <div columns="4">

          <el-col :span="12">
            <el-form-item label="节能环保项目及服务类型:"
                          prop="serviceType"
                          class="special-input">
              <el-select v-model="conInfoXwForm.serviceType"
                         style="width:100%"
                         @change="servicetype">
                <el-option v-for="(value,key) in serviceType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </div>

        <div columns="4"
             id="jnjpl"
             v-show="jnjpl">

          <el-col :span="12">
            <el-form-item label="节能减排量:"
                          prop="reduceAmount"
                          class="special-input">
              <el-select v-model="conInfoXwForm.reduceAmount"
                         style="width:100%">
                <el-option v-for="(value,key) in reduceAmount"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>

        </div>

        <div columns="4">

          <el-col :span="12">
            <el-form-item label="产业结构调整类型:"
                          prop="ajustType"
                          class="special-input">
              <el-select v-model="conInfoXwForm.ajustType"
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
              <el-select v-model="conInfoXwForm.upgradeType"
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
              <el-select v-model="conInfoXwForm.newProductType"
                         style="width:100%">
                <el-option v-for="(value,key) in newProductType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </div>
        <div columns="4"
             id="table1"
             v-show="table1">

          <el-col :span="12">
            <el-form-item label="是否涉农企业:"
                          prop="whetherArgRelated"
                          class="special-input">
              <el-select v-model="conInfoXwForm.whetherArgRelated"
                         style="width:100%"
                         @change="changeArgRelated">
                <el-option v-for="(value,key) in whetherArgRelated"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <div id="argType"
               v-show="isArgType">
            <el-col :span="12">
              <el-form-item label="涉农企业类型:"
                            prop="argType"
                            class="special-input">
                <el-select v-model="conInfoXwForm.argType"
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
          <div id="supArgType"
               v-show="isSupArgType">
            <el-col :span="12">
              <el-form-item label="支农贷款类型:"
                            prop="supArgType"
                            class="special-input">
                <el-select v-model="conInfoXwForm.supArgType"
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
          <div columns="4"
               id="greenTable"
               v-show="greenTable">

            <el-col :span="12">
              <el-form-item label="是否绿色贷款:"
                            prop="greenLoan"
                            class="special-input">
                <el-select v-model="conInfoXwForm.greenLoan"
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
                <el-select v-model="conInfoXwForm.greenLoanUse"
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
                <el-select v-model="conInfoXwForm.greenRiskType"
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
                <el-select v-model="conInfoXwForm.greenRiskDetail01"
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
                <el-select v-model="conInfoXwForm.greenRiskDetail02"
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
              <el-select v-model="conInfoXwForm.greenRiskDetail04"
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

      <el-row align="middle"
              class="bottomBtn"
              v-show="isShowSave">
        <el-col align="center">
          <el-button size="medium"
                     type="primary"
                     @click="save"
                     :disabled="isSave">保存</el-button>
        </el-col>

      </el-row>

    </el-form>

  </el-row>
</template>
<script>

import { getConInfoMapByContarctId, getMonthAddDate, updateConInfo, RuleEngineMapper, getTermByEndDate } from '@/api/csm'
import enums from '@/utils/enums'// 格式化的枚举
// import axios from 'axios'
// import qs from 'qs'

export default {
  name: 'conInfoHtXw',
  props: {
    paramsConTree: { // 用于接受父组件传来的参数
      // con_tree传递过来的参数放在这里
      proFlag: '1',
      contractId: '123'
    }

  },

  data() {
    return {
      isconInfoXwForm: false, // 默认所有的设置都是打开的
      showDisabled: true,

      conInfoXwForm: {

      },
      o: {

      },
      rules: {

      },

      // 控制是否显示页面div元素
      table1: true,
      dbfs: true,

      table2: true,
      cqcs: true,
      jnjpl: true,
      greenTable: true,

      isShowSave: true,

      // 控制页面是否显示具体表单项
      hkfs: true,
      schkq: true,
      isGreenRiskDetail04: true,
      isGreenRiskDetail02: true,
      isGreenRiskDetail01: true,
      isGreenRiskType: true,
      isGreenLoanUse: true,
      isArgType: true,
      isSupArgType: true,

      // 控制页面是否disable某个页面元素
      isSave: false,
      iscycleIndCon: false,
      isloanUse: false,
      isContractAmt: false,
      disArgType: false,
      disSupArgType: false,

      // 控制页面字典项数据
      guarantyType: enums.guarantyTypeCd, // 担保方式 CDZC0005
      mainGuarantyType: enums.guarantyTypeCd, // 主担保方式 CDZC0005
      agriculLoans: enums.YesOrNoCd,

      currencyCd: enums.currencyCd, // 币种格式化  CD000001
      cycleUnit: enums.cycleUnitCd, // XD_GGCD6009

      repaymentType: enums.repaymentTypeCd, // 还款方式  XD_SXCD1162
      productType: enums.productType,
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
      greenRiskDetail04: enums.greenRiskDetail04Cd, // XD_DKSQLX0005

      // form表单常用数据区
      contractId: '', // 业务合同ID
      contractType: '',
      proFlag: '', // 流程中查看标识
      oldContractId: ''

    }
  },
  created() {
    console.log('created....')

    const params = { // TODO 这个contractId 记得要放开
      contractId: this.paramsConTree.contractId,
      contractType: '02',
      proFlag: this.paramsConTree.proFlag
    }
    this.initPage(params)
  },
  methods: {
    initPage(params) {
      this.contractId = params.contractId
      this.contractType = params.contractType
      this.proFlag = this.paramsConTree.proFlag

      console.log(this.contractId + ' ' + this.contractType + ' ' + this.proFlag)

      getConInfoMapByContarctId(params).then((response) => {
        this.o = response.data
        console.log('o is' + JSON.stringify(this.o))
        if (this.o.tbConFlagInfo) {
          if (!this.o.tbConFlagInfo.greenLoan) {
            this.o.tbConFlagInfo.greenLoan = '0'
          }

          if (this.o.tbConFlagInfo.greenRiskDetail) {
            this.o.tbConFlagInfo.greenRiskDetail01 = this.o.tbConFlagInfo.greenRiskDetail
            this.o.tbConFlagInfo.greenRiskDetail02 = this.o.tbConFlagInfo.greenRiskDetail
            this.o.tbConFlagInfo.greenRiskDetail04 = this.o.tbConFlagInfo.greenRiskDetail
          }
        }
        // form.setData(o);

        this.conInfoXwForm.partyName = this.o.party.partyName
        this.conInfoXwForm.partyNum = this.o.party.partyNum

        this.conInfoXwForm.productType = this.o.conInfo.productType
        this.conInfoXwForm.contractNum = this.o.conInfo.contractNum
        this.conInfoXwForm.paperConNum = this.o.conInfo.paperConNum
        this.conInfoXwForm.oldContractNum = this.o.conInfo.oldContractNum
        this.conInfoXwForm.currencyCd = this.o.conInfo.currencyCd
        this.conInfoXwForm.contractAmt = this.o.conInfo.contractAmt
        this.conInfoXwForm.beginDate = this.o.conInfo.beginDate
        this.conInfoXwForm.contractTerm = this.o.conInfo.contractTerm
        this.conInfoXwForm.cycleUnit = this.o.conInfo.cycleUnit
        this.conInfoXwForm.endDate = this.o.conInfo.endDate
        this.conInfoXwForm.repaymentType = this.o.conInfo.repaymentType
        this.conInfoXwForm.firstRepayTerm = this.o.conInfo.firstRepayTerm
        this.conInfoXwForm.cycleIndCon = this.o.conInfo.cycleIndCon
        this.conInfoXwForm.contractDate = this.o.conInfo.contractDate
        this.conInfoXwForm.contractAddress = this.o.conInfo.contractAddress
        this.conInfoXwForm.specPaymentDate = this.o.conInfo.specPaymentDate
        this.conInfoXwForm.internalDays = this.o.conInfo.internalDays
        this.conInfoXwForm.loanUse = this.o.conInfo.loanUse
        this.conInfoXwForm.guarantyType = this.o.conInfo.guarantyType
        this.conInfoXwForm.mainGuarantyType = this.o.conInfo.mainGuarantyType

        // 标志信息
        this.conInfoXwForm.loanTurn = this.o.tbConFlagInfo.loanTurn
        this.conInfoXwForm.riskInfo = this.o.tbConFlagInfo.riskInfo
        this.conInfoXwForm.act = this.o.tbConFlagInfo.act
        this.conInfoXwForm.serviceType = this.o.tbConFlagInfo.serviceType
        this.conInfoXwForm.reduceAmount = this.o.tbConFlagInfo.reduceAmount
        this.conInfoXwForm.ajustType = this.o.tbConFlagInfo.ajustType
        this.conInfoXwForm.upgradeType = this.o.tbConFlagInfo.upgradeType
        this.conInfoXwForm.newProductType = this.o.tbConFlagInfo.newProductType
        this.conInfoXwForm.whetherArgRelated = this.o.tbConFlagInfo.whetherArgRelated
        this.conInfoXwForm.argType = this.o.tbConFlagInfo.argType
        this.conInfoXwForm.supArgType = this.o.tbConFlagInfo.supArgType
        this.conInfoXwForm.greenLoan = this.o.tbConFlagInfo.greenLoan
        this.conInfoXwForm.greenLoanUse = this.o.tbConFlagInfo.greenLoanUse
        this.conInfoXwForm.greenRiskType = this.o.tbConFlagInfo.greenRiskType
        this.conInfoXwForm.greenRiskDetail01 = this.o.tbConFlagInfo.greenRiskDetail01
        this.conInfoXwForm.greenRiskDetail02 = this.o.tbConFlagInfo.greenRiskDetail02
        this.conInfoXwForm.greenRiskDetail04 = this.o.tbConFlagInfo.greenRiskDetail04

        // 调整时初始化原合同金额
        // nui.get('conInfo.oldamt').setValue(o.conInfo.contractAmt)
        this.conInfoXwForm.oldamt = this.o.conInfo.contractAmt
        this.o.conInfo.oldamt = this.o.conInfo.contractAmt

        if (this.o.conInfo.loanUse == null || this.o.conInfo.loanUse == '') {
          // nui.get('conInfo.loanUse').setValue(o.tbBizAmountDetailApprove.loanUse)
          this.conInfoXwForm.loanUse = this.o.tbBizAmountDetailApprove.loanUse
          this.o.conInfo.loanUse = this.o.tbBizAmountDetailApprove.loanUse
        }
        var grt = this.o.conInfo.guarantyType
        if (grt.indexOf('03') != -1) {
          grt = grt.replace('05', '')
        } else {
          grt = grt.replace('05', '03')
        }
        // nui.get('conInfo.cycleIndCon').setValue('0')
        // nui.get('conInfo.cycleIndCon').setEnabled(false)
        // nui.get('conInfo.mainGuarantyType').setData(getDictData('CDZC0005', 'str', grt))
        // nui.get('conInfo.guarantyType').setData(getDictData('CDZC0005', 'str', o.bizInfo.guarantyType))
        this.conInfoXwForm.cycleIndCon = '0'
        this.o.conInfo.cycleIndCon = '0'
        this.iscycleIndCon = true // 是否disable这个选项

        this.oldContractId = this.o.conInfo.oldContractId
        if (this.oldContractId != null && this.oldContractId != '') { // 合同调整
          // nui.get('conInfo.loanUse').setEnabled(true)

          this.isloanUse = false

          // 出账成功不允许调整合同金额
          const json1 = { param: this.oldContractId, name: 'RCON_0089' }
          RuleEngineMapper(json1).then((response) => {
            const msg = response.data

            console.log('[RCON_0089]msg ' + msg)
            if (msg == '0') {
              this.isContractAmt = true // 出账成功后不允许调整合同金额
            } else {
              this.isContractAmt = false
              alert('该合同已出账成功合同调整不允许调整金额!')// 允许调整金额
              return false
            }
          }).catch((error) => {
            console.log(error)
          })
        }
        // 间隔天数反显7天
        if (this.o.conInfo.internalDays == null || this.o.conInfo.internalDays == '') {
          this.conInfoXwForm.internalDays = '7'
          this.o.conInfo.internalDays = '7'
        }
        // 设计环境、安全等重大情况 节能环保服务及项目类型  默认为 未涉及 0非节能环保服务及项目类型
        if (this.o.tbConFlagInfo.riskInfo == null || this.o.tbConFlagInfo.riskInfo == '') {
          this.o.tbConFlagInfo.riskInfo = '0'
          this.conInfoXwForm.riskInfo = '0'
        }
        if (this.o.tbConFlagInfo.serviceType == null || this.o.tbConFlagInfo.serviceType == '') {
          this.o.tbConFlagInfo.serviceType = '0'
          this.conInfoXwForm.serviceType = '0'
        }

        this.riskinfo()
        this.servicetype()

        // 校验表单
        this.$refs['conInfoXwForm'].validate((valid) => {
          console.log(valid)

          if (valid) {
            console.log('校验通过！')
          } else {
            alert('请按规则填写信息！')
            return false
          }
        })
      }).catch((error) => {
        console.log(error)
      })

      // proFlag   如果流程标识为0表示为查看，隐藏保存按钮禁用控件
      if (this.proFlag != '1') {
        this.isShowSave = false
        this.isconInfoXwForm = true
      }
    },
    save() {
      console.log('save invoke....')

      this.$refs['conInfoXwForm'].validate((valid) => {
        console.log(valid)

        if (valid) {
          console.log('校验通过！')
          // alert('校验通过！')
          // .....
        } else {
          alert('请按规则填写信息！')
          return false
        }
      })
      this.isSave = true // 是否控制保存按钮可以编辑

      if (this.o.tbConFlagInfo.greenLoan === '0') {
        this.o.tbConFlagInfo.greenLoanUse = null
        this.o.tbConFlagInfo.greenRiskType = null
        this.o.tbConFlagInfo.greenRiskDetail = null
      } else {
        this.o.tbConFlagInfo.greenRiskDetail = this.getGreenRiskDetail()
      }

      // 业务合同信息
      this.o.conInfo.contractId = this.contractId
      // 业务标志信息
      this.o.tbConFlagInfo.contractId = this.contractId
      // 给合同余额赋值
      var conBalance = this.o.conInfo.conBalance
      var oldAmt = this.o.conInfo.oldamt// 合同调整时页面初始化此隐藏域
      if (conBalance == '' || conBalance == null || conBalance == 'null') {
        conBalance = 0
      }
      if (conBalance != 0) {
        var ocupy = parseFloat(oldAmt) - parseFloat(conBalance)
        this.o.conInfo.conBalance = parseFloat(this.o.conInfo.contractAmt) - parseFloat(ocupy)
      } else {
        this.o.conInfo.conBalance = parseFloat(this.o.conInfo.contractAmt)
      }
      var condate = this.o.conInfo.endDate
      var conbedate = this.o.conInfo.beginDate
      if (condate.substr(0, 10) <= conbedate.substr(0, 10)) {
        alert('合同止期不能小于等于合同起期') // 失败时后台直接返回出错信息

        this.isSave = false // 将保存提交按钮修改为可提交状态
        return false
      }

      updateConInfo(this.o).then((response) => {
        const res = response.date
        console.log(res)
        alert('保存成功!')
        this.initPage()
      }).catch((error) => {
        console.log(error)
      })
    },

    // 剩下的都是一些action操作

    riskinfo() {
      // var riskinfo = this.o.tbConFlagInfo.riskInfo
      var riskinfo = this.conInfoXwForm.riskInfo
      if (riskinfo == '0' || riskinfo == '') {
        this.cqcs = false
      } else {
        this.cqcs = true
      }
    },

    servicetype() {
      // var riskinfo = this.o.tbConFlagInfo.serviceType
      var riskinfo = this.conInfoXwForm.serviceType
      if (riskinfo == '0' || riskinfo == '') {
        this.jnjpl = false
      } else {
        this.jnjpl = true
      }
    },

    getGreenRiskDetail() {
      // var greenRiskType = this.o.tbConFlagInfo.greenRiskType
      var greenRiskType = this.conInfoXwForm.greenRiskType
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

    greenLoanChange() {
      // console.log('[greenLoanChange] invoke....1' + this.o.tbConFlagInfo.greenLoan)
      console.log('[greenLoanChange] invoke....' + this.conInfoXwForm.greenLoan)
      if (this.conInfoXwForm.greenLoan == '1') {
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
      const greenRiskType = this.conInfoXwForm.greenRiskType
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

    // setGreenShow(title, show) {
    //   if (show) {

    //     // $('#' + title).css('display', 'block')
    //     // nui.get('tbConFlagInfo.' + title).setVisible(true)
    //   } else {
    //     // $('#' + title).css('display', 'none')
    //     // nui.get('tbConFlagInfo.' + title).setValue(null)
    //     // nui.get('tbConFlagInfo.' + title).setVisible(false)
    //   }
    // },
    // 合同起期不能小于批复生效日
    validateBeginDate() {
      if (this.oldContractId != null && this.oldContractId != '') { // 合同调整
        return
      } else {
        var beginDate = this.conInfoXwForm.beginDate
        var validDate = this.conInfoXwForm.validDate

        if (beginDate != null && beginDate != '') {
          if (beginDate.substr(0, 10) < validDate.substr(0, 10)) {
            alert('合同起期不能小于批复生效日期!')
            this.conInfoXwForm.beginDate = ''
            this.conInfoXwForm.endDate = ''

            return
          }
        }
        this.getConEndate()// 起始日期变动时 自动计算合同到期日期
      }
    },
    qyrq() {
      var conDate = this.conInfoXwForm.contractDate
      var validDate = this.conInfoXwForm.validDate
      if (conDate != null && conDate != '') {
        if (conDate <= validDate) {
          alert('签约日期不能小于批复生效日期!')
          this.conInfoXwForm.contractDate = ''
          // nui.get("conInfo.contractDate").validate();
        }
      }
    },
    // 担保方式
    guarantyTypechg() {
      // 初始化时 对担保形式的显隐藏
      var guarantyType = this.conInfoXwForm.guarantyType

      if (guarantyType.indexOf('03') != -1) {
        guarantyType = guarantyType.replace('05', '')
      } else {
        guarantyType = guarantyType.replace('05', '03')
      }
      // nui.get('conInfo.mainGuarantyType').setData(getDictData('CDZC0005', 'str', guarantyType))
      this.conInfoXwForm.mainGuarantyType = ''
    },

    // 只有阶段性还款方式才显示首次还本期次
    conRpTpChg() {
      var hkfs = this.conInfoXwForm.repaymentType
      console.log('[conRpTpChg]' + hkfs)
      if (hkfs == '0300' || hkfs == '0400') {
        this.schkq = true
      } else {
        this.schkq = false

        this.conInfoXwForm.firstRepayTerm = ''
      }
    },
    // 通过起始日期、到期日期、期限单位计算期限
    getTerm() {
      var beginDate = this.conInfoXwForm.beginDate // 合同起期
      beginDate = (beginDate + '').substring(0, 10)
      var endDate = (this.conInfoXwForm.endDate + '').substring(0, 10)// 合同止期
      var termUnit = this.conInfoXwForm.cycleUnit// 合同期限单位
      var creditTerm = this.conInfoXwForm.creditTerm// 批复里的期限
      if (beginDate != null && termUnit != null) {
        if (endDate <= beginDate) {
          this.conInfoXwForm.endDate = ''// 将合同止期置为空
          alert('合同止期不能小于等于合同起期')
          return false
        }
        // 期限单位目前默认为"月(M)"
        var json = { 'beginDate': beginDate, 'endDate': endDate, 'termUnit': 'M' }

        getTermByEndDate(json).then((response) => {
          const data = response.data
          console.log('[getTermByEndDate]' + JSON.stringify(data))

          if (data != null) {
            if (data.term > creditTerm) { // 如果计算出的合同期限大于批复期限
              this.conInfoXwForm.endDate = ''
              return alert('不能大于批复期限' + creditTerm + '个月,请重新选择到期日期')
            }
          }

          // nui.get('conInfo.contractTerm').setValue(data.term)
          this.conInfoXwForm.contractTerm = data.term
        }).catch((error) => {
          console.log(error)
        })
      }
    },

    // 是否涉农
    changeArgRelated(e) {
      console.log('[changeArgRelated] invoke....' + e)
      if (e == '1') {
        this.isArgType = true
        if (this.conInfoXwForm.argType) {
          this.disArgType = false
        }

        this.supArgTypeFun(1)
      } else {
        this.isArgType = false
        if (this.conInfoXwForm.argType) {
          this.disArgType = true
        }
        this.conInfoXwForm.argType = ''

        this.supArgTypeFun(0)
      }
    },
    supArgTypeFun(x) {
      console.log('[supArgType] invoke.....' + x)
      if (x == '0') {
        this.isSupArgType = false
        // $('#supArgType').css('display', 'none')
        // if (nui.get('tbConFlagInfo.supArgType')) { nui.get('tbConFlagInfo.supArgType').setValue('') }
        // nui.get('tbConFlagInfo.supArgType').setVisible(false)
      } else {
        this.isSupArgType = true

        // $('#supArgType').css('display', 'block')
        // if (nui.get('tbConFlagInfo.supArgType')) { nui.get('tbConFlagInfo.supArgType').setVisible(true) }
      }
    },
    selectTrade4(e) {
      // var btnEdit = this
      console.log(JSON.stringify(e))
      console.log('[selectTrade4]打开字典树。。。。')
      // nui.open({
      //     url: nui.context + "/pub/dict/code_tree.jsp?dicttypeid=CDXY0300",
      //     title: "选择字典项",
      //     width: 800,
      //     height: 450,
      //     ondestroy: function (action) {
      //         if (action == "ok") {
      //             var iframe = this.getIFrameEl();
      //             var data = iframe.contentWindow.currentNode;
      //             data = nui.clone(data);
      //             if (data) {
      //                 btnEdit.setValue(data.dictid);
      //                 btnEdit.setText(data.dictname);
      //             }
      //         }
      //         if (action == "clear") { //清空选择的内容
      //         	btnEdit.setValue("");
      //         	btnEdit.setText("");
      //     	}
      // 	}
      // });
    },

    // 计算合同到期日期
    getConEndate() {
      console.log('getConEndate ......')
      const beginDate = this.o.conInfo.beginDate
      const approveTerm = this.o.bizDtlInfo.creditTerm
      const approveUnit = this.o.bizDtlInfo.cycleUnit
      const conTerm = this.o.conInfo.contractTerm

      if (approveTerm != null && approveUnit != null && conTerm > approveTerm) {
        // nui.get('conInfo.endDate').setValue('')
        this.conInfoXwForm.endDate = ''
        alert('合同期限不能大于批复期限[' + approveTerm + ']个月')
        return false
      }

      if (beginDate != null && conTerm != null) {
        var date = beginDate.substring(0, 10)

        const json = { 'qxdw': 'M', 'qx': conTerm, 'rq': date }

        getMonthAddDate(json).then((response) => {
          const myData = response.data
          console.log('[getMonthAddDate]' + JSON.stringify(myData))
          // 成功之后，返回合同到期日期
          this.conInfoXwForm.endDate = myData.dqrq
          this.o.conInfo.endDate = myData.dqrq
        }).catch((error) => {
          console.log(error)
        })
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
