<template>
  <div>
    <div>
      <p class="m1">贷款基本情况</p>
      <div class="m2" style="margin-bottom:15px"></div>
      <csc-single-table
        :disableRowButtons='disableRowButtons'
        :pageDef="pageDef"
        :entity="entity"
        :disableQueryButtons="disableQueryButtons"
        @pageQuery="doPageQuery"
      >
      </csc-single-table>
    </div>
      <el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">
        <div>
          <div>
            <el-row :gutter="20" class="form">
              <p class="m1"> 当前贷款现状</p>
              <div class="m2" style="margin-bottom:15px"></div>

                <el-col :span="12">
                  <el-form-item label="在他行或个人借款总额（万元）：" prop="loanAmt" hide-required-asterisk="true">
                    <el-input v-model="ruleForm.loanAmt"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="归还贷款及借款情况 ：" prop="repayCondition">
                    <el-input type="textarea" v-model="ruleForm.repayCondition"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="欠款情况 ：" prop="debtCondition">
                    <el-input type="textarea" v-model="ruleForm.debtCondition"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="当前信用报告显示是否正常：" prop="isNormal">
                    <el-select v-model="ruleForm.isNormal" placeholder="--请选择--">
                      <el-option label="是" value="0"></el-option>
                      <el-option label="否" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>

            </el-row>
          </div>
          <div>
            <el-row :gutter="20" class="form">
              <p class="m1">保证人现状</p>
              <div class="m2" style="margin-bottom:15px"></div>
          <!--    <el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">-->
                <el-col :span="12">
                  <el-form-item label="保证人的生产经营情况：" prop="guarantorBusiness">
                    <el-select v-model="ruleForm.guarantorBusiness" placeholder="--请选择--">
                      <el-option label="正常" value="0"></el-option>
                      <el-option label="不正常" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="保证人财务状况：" prop="guarantorFinance">
                    <el-select v-model="ruleForm.guarantorFinance" placeholder="--请选择--">
                      <el-option label="正常" value="0"></el-option>
                      <el-option label="不正常" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="保证人与借款人关系：" prop="guarantorRelation">
                    <el-select v-model="ruleForm.guarantorRelation" placeholder="--请选择--">
                      <el-option label="正常" value="0"></el-option>
                      <el-option label="不正常" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="保证人有无发生影响我行债权安全的重大事项：" prop="isGuarantorDebt">
                    <el-select v-model="ruleForm.isGuarantorDebt" placeholder="--请选择--">
                      <el-option label="有" value="0"></el-option>
                      <el-option label="无" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="保证有无风险：" prop="isGuarantorRisk">
                    <el-select v-model="ruleForm.isGuarantorRisk" placeholder="--请选择--">
                      <el-option label="有" value="0"></el-option>
                      <el-option label="无" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="其他情况 ：" prop="guarantorOthers">
                    <el-input type="textarea" v-model="ruleForm.guarantorOthers"></el-input>
                  </el-form-item>
                </el-col>
              <!--</el-form>-->
            </el-row>
           </div>
          <div>
            <el-row :gutter="20" class="form">
              <p class="m1">抵（质）押物现状</p>
              <div class="m2" style="margin-bottom:15px"></div>
            <!--  <el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">-->
                <el-col :span="12">
                  <el-form-item label="抵（质）押物保管、保存是否完好：" prop="isMortgageGood">
                    <el-select v-model="ruleForm.isMortgageGood" placeholder="--请选择--">
                      <el-option label="是" value="0"></el-option>
                      <el-option label="否" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="抵（质）押物现值有无重大变化：" prop="isMortgageChange">
                    <el-select v-model="ruleForm.isMortgageChange" placeholder="--请选择--">
                      <el-option label="有" value="0"></el-option>
                      <el-option label="无" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="抵（质）押率是否控制在规定的范围内：" prop="isMortgageControl">
                    <el-select v-model="ruleForm.isMortgageControl" placeholder="--请选择--">
                      <el-option label="否" value="0"></el-option>
                      <el-option label="是" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="借款人是否擅自改变抵质押物的占管人、使用人：" prop="isMortgageChaOwn">
                    <el-select v-model="ruleForm.isMortgageChaOwn" placeholder="--请选择--">
                      <el-option label="是" value="0"></el-option>
                      <el-option label="否" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="借款人是否擅自转让、赠与、出租、设定担保物权等：" prop="isMortgageRent">
                    <el-select v-model="ruleForm.isMortgageRent" placeholder="--请选择--">
                      <el-option label="是" value="0"></el-option>
                      <el-option label="否" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="抵（质）押物有无风险：" prop="isMortgageRent">
                    <el-select v-model="ruleForm.isMortgageRent" placeholder="--请选择--">
                      <el-option label="有" value="0"></el-option>
                      <el-option label="无" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="其他情况 ：" prop="mortgageOthers">
                    <el-input type="textarea" v-model="ruleForm.mortgageOthers"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="借款人工作单位、地址、联系电话等信息的变更情况，借款人品行、职业、收入、住所和健康状况等影响还款能力和诚意的因素变化情况：" prop="customerCondition">
                    <el-input type="textarea" v-model="ruleForm.customerCondition"></el-input>
                  </el-form-item>
                </el-col>
              <!--</el-form>-->
            </el-row>
          </div>
          <div>
            <div>
              <el-row :gutter="20" class="form">
                <p class="m1">借款人当前财务情况</p>
                <div class="m2" style="margin-bottom:15px"></div>
                <!--<el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">-->
                  <el-col :span="12">
                    <el-form-item label="财务数据截止时间：" prop="financeEndDate" hide-required-asterisk="true">
                      <el-input v-model="ruleForm.financeEndDate" type="date"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="总资产（万元） ：" prop="assetAmt">
                      <el-input  v-model="ruleForm.assetAmt"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="总负债（万元） ：" prop="debtAmt">
                      <el-input  v-model="ruleForm.debtAmt"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="资产负债率% ：" prop="assetDebtRate">
                      <el-input  v-model="ruleForm.assetDebtRate"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="我行资金流量情况 ：" prop="amtFlowCondition">
                      <el-input type="textarea" v-model="ruleForm.amtFlowCondition"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="存贷比% ：" prop="loanRate">
                      <el-input  v-model="ruleForm.loanRate"></el-input>
                    </el-form-item>
                  </el-col>
                <!--</el-form>-->
              </el-row>
            </div>
          </div>
          <div>
            <div>
              <el-row :gutter="20" class="form">
                <p class="m1">本期贷款使用情况</p>
                <div class="m2" style="margin-bottom:15px"></div>
                <div class="m3">
                  <csc-single-table
                    :disableRowButtons='disableRowButtons'
                    :disableQueryButtons="disableQueryButtons"
                    :pageDef="pageDef1"
                    :entity="entity1"
                    @pageQuery="doPageQuery1">
                  </csc-single-table>
                </div>
                <!--<el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">-->
                  <el-col :span="12">
                    <el-form-item label="借款人家庭变化情况是否会对贷款产生影响 ：" prop="isFamilyAffect">
                      <el-input type="textarea" v-model="ruleForm.isFamilyAffect"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="通过走访开发商和对个人房产贷款项目进行实地考虑，掌握项目贷款资金使用和工程进度、房屋所有权证及抵押他项权证的办理情况：" prop="qzblCondition" hide-required-asterisk="true">
                      <el-input type="textarea" v-model="ruleForm.qzblCondition"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="其他可能影响个人贷款资产质量的因素变化情况 ：" prop="otherCondition">
                      <el-input type="textarea" v-model="ruleForm.otherCondition"></el-input>
                    </el-form-item>
                  </el-col>
                <!--</el-form>-->
              </el-row>
            </div>
          </div>
          <div>
            <div>
              <el-row :gutter="20" class="form">
                <p class="m1">检查发现问题处理意见</p>
                <div class="m2" style="margin-bottom: 15px;"></div>
                <!--<el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">-->
                  <el-col :span="12">
                    <el-form-item label="处理意见：" prop="tbAftNormalCheck.checkResult">
                      <el-select v-model="ruleForm.checkResult" placeholder="--请选择--">
                        <el-option label="借款人资信状况正常，保持当前授信情况不变" value="01"></el-option>
                        <el-option label="借款人资信状况出现一些潜在风险，但不影响正常还款，建议予以关注" value="02"></el-option>
                        <el-option label="借款人资信状况货担保物价值发生明显下降，建议调整或冻结,调整后，授信额度为  万" value="03"></el-option>
                        <el-option label="借款人资信状况已恶化，建议终止额度，并收回已发放贷款、处置抵质押物或启动司法程序" value="04"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="检查人：" prop="checkPerson" hide-required-asterisk="true">
                      <el-input v-model="ruleForm.checkPerson"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="检查日期：" prop="createDate">
                      <el-input type="date" v-model="ruleForm.createDate"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="检查地点 ：" prop="checkPlace">
                      <el-input type="textarea" v-model="ruleForm.checkPlace"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item label="检查方式：" prop="checkWay">
                      <el-select v-model="ruleForm.checkWay" placeholder="--请选择--">
                        <el-option label="电话检查" value="0"></el-option>
                        <el-option label="实地检查" value="1"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                <!--</el-form>-->
              </el-row>
            </div>
            <el-row class="m4">
              <el-button type="primary" @click="submitForm('ruleForm')">保    存</el-button>
              <el-button type="primary">临时保存</el-button>
              <el-button type="primary">下载打印</el-button>
            </el-row>
          </div>
        </div>
      </el-form>
  </div>
</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {querySummaryList,queryMoneyUse} from '@/api/Afterloan'
  export default {
    name: "DailyCheckInfo",
    data() {


      return {

        disableQueryButtons: true,
        disableRowButtons: true,
        entity: {
        },
        entity1: {
        },
        ruleForm: {
          loanAmt: '',
          repayCondition: '',
          debtCondition: '',
          isNormal: '',

          guarantorBusiness: '',
          guarantorRelation: '',
          guarantorFinance: '',
          isGuarantorDebt: '',
          isGuarantorRisk: '',
          guarantorOthers: '',
          isMortgageGood: '',
          isMortgageChange: '',
          isMortgageControl: '',
          isMortgageChaOwn: '',
          isMortgageRent: '',
          isMortgageRisk: '',
          mortgageOthers: '',
          customerCondition: '',
          financeEndDate: '',
          assetAmt: '',
          debtAmt: '',
          assetDebtRate: '',
          amtFlowCondition: '',
          loanRate: '',
          isFamilyAffect: '',
          qzblCondition: '',
          otherCondition: '',
          checkResult: '',
          checkPerson: '200555',
          createDate: '',
          checkPlace: '',
          checkWay: '',
        },

        rules: {//表单校验
          //当前贷款现状
          loanAmt: [
            {  trigger: 'blur' ,required: true, message: '金额不能为空'},
            {
              pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
              message: '请输入数字值',
              trigger: 'blur'
            }
          ],
          repayCondition: [
            { required: true, message: '请输入归还贷款及借款情况 ', trigger: 'blur' }
          ],
          debtCondition: [
            { required: true, message: '请输入欠款情况 ', trigger: 'blur' }
          ],
          isNormal: [
            {required: true, message: '请至少选择一个选项', trigger: 'change' }
          ],
          //抵（质）押物现状
          isMortgageGood: [
            { required: true, message: '请至少选择一个选项', trigger: 'change' }
          ],
          isMortgageChange: [
            { required: true, message: '请至少选择一个选项', trigger: 'change' }
          ],
          isMortgageControl: [
            { required: true, message: '请至少选择一个选项', trigger: 'change' }
          ],
          isMortgageChaOwn: [
            { required: true, message: '请至少选择一个选项', trigger: 'change' }
          ],
          isMortgageRent: [
            { required: true, message: '请至少选择一个选项', trigger: 'change' }
          ],
          isMortgageRisk: [
            { required: true, message: '请至少选择一个选项', trigger: 'change' }
          ],
          customerCondition: [
            { required: true, message: '此项不能为空 ', trigger: 'blur' }
          ],
          //借款人当前财务情况
          financeEndDate: [
            { required: true, message: '财务数据截止时间不能为空 ', trigger: 'blur' }
          ],
          assetAmt: [
            { required: true, message: '总资产不能为空 ', trigger: 'blur' },
            {
              pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
              message: '请输入数字值',
              trigger: 'blur'
            }
          ],
          debtAmt: [
            { required: true, message: '总负债不能为空 ', trigger: 'blur' },
            {
              pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
              message: '请输入数字值',
              trigger: 'blur'
            }
          ],
          amtFlowCondition: [
            { required: true, message: '我行资金流量情况不能为空 ', trigger: 'blur' }
          ],
          loanRate: [
            { required: true, message: '存贷比不能为空 ', trigger: 'blur' },
            {
              pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
              message: '请输入数字值',
              trigger: 'blur'
            }
          ],
          //本期贷款使用情况
          isFamilyAffect: [
            { required: true, message: '此项不能为空 ', trigger: 'blur' }
          ],
          qzblCondition: [
            { required: true, message: '此项不能为空 ', trigger: 'blur' }
          ],
          //检查发现问题处理意见
          checkResult: [
            { required: true, message: '请至少选择一个处理意见', trigger: 'change' }
          ],
          checkWay: [
            { required: true, message: '请至少选择一个检查方式', trigger: 'change' }
          ],
          checkPlace: [
            { required: true, message: '请输入检查地点 ', trigger: 'blur' }
          ],
        },

        pageDef: {
          // 查询条件定义
          queryDef: {},
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '合同编号', prop: 'CONTRACT_NUM', isSort: true },
              { label: '贷款种类', prop: 'PRODUCT_TYPE', isSort: true,isFormat: true,enumType:'productType'},
              { label: '贷款金额（元）', prop: 'CONTRACT_AMT', isSort: true },
              { label: '贷款余额（元）', prop: 'CON_YU_E', isSort: true },
              { label: '担保方式', prop: 'GUARANTY_TYPE', isSort: true, isFormat: true,enumType:'guarantyType'},
              { label: '检查方式', prop: 'CHECK_TYPE', isSort: true }
            ]
          },
        },

        pageDef1: {
          // 查询条件定义
          queryDef: {},
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '支付日期', prop: 'PAY_TIME', isSort: true },
              { label: '支付方式', prop: 'PAY_WAY', isSort: true,isFormat: true,enumType:'payWay'},
              { label: '支付对象', prop: 'PAY_OBJECT', isSort: true },
              { label: '支付用途', prop: 'PAY_USE', isSort: true },
              { label: '是否符合审批或约定用途', prop: 'IS_FIT_DEAL', isSort: true, isFormat: true,enumType:'commonYesAndNotCd'}
            ]
          },
        },




      }
    },
    components: { CscSingleTable},

    methods: {
      doPageQuery(listQuery) {
        this.querySummaryList(listQuery)
        this.queryMoneyUse(listQuery)
      },

      querySummaryList(listQuery) {
        querySummaryList(listQuery).then(response => {
          this.entity = response.data
          console.log("资金用途："+response.data)
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },

      queryMoneyUse(listQuery) {
        queryMoneyUse(listQuery).then(response => {
          this.entity1 = response.data
          console.log("资金用途："+response.data)
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },

      submitForm(ruleForm) {
        this.$refs[ruleForm].validate((valid) => {
          if (valid) {
            alert('确认提交吗？');
          } else {
            alert('请将信息填写完整！');
            console.log('error submit!!');
            return false;
          }
        });
      },

      /*  rowDbclick(row) {
          this.$router.push({ path: '/user/add/card/' + row.userId })
        },*/

      // create() {
      //   this.$router.push({ path: './firstCheck' })
      // },
      /* doEdit(row) {
         this.$router.push({ path: '/user/add/edit/' + row.userId })
       },
       doDelete(row, listQuery) {
         deleteUser(row).then(response => {
           this.userList(listQuery)
           this.$message({
             type: 'success',
             message: '删除成功!'
           })
         })
       }*/
    },

  }
</script>

<style scoped>
  .m1{
    text-align: left !important;
    font-size: 16px;
    font-weight: bold;
    margin-bottom: 5px;
    margin-left: 15px;
  }
  .m2{
    border-top:solid 1px #A9A3A5;
    height: 1px !important;
    margin-top: 2px;
    margin-left: 10px;
  }
  .demo-form-inline{
    margin-left: 20px;
  }
  .m3{
    margin-bottom: 25px;
  }
  .m4{
    text-align: right !important;
  }
</style>
