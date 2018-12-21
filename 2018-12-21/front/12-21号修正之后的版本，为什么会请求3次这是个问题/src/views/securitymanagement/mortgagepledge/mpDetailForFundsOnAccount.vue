<!--详细信息  应收账款-->
<template>
    <div class="mp-detail-for-funds-on-account">
      <el-row>
        <el-form el-form label-width="200px" :model="foundsOnAccountsInfo" label-position="right" :rules="rules" ref="mpFundsOnAccountDetailValidate" >
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="customerType" >
              <el-select :disabled="inputComponentDisable"  v-model="foundsOnAccountsInfo.currency" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in currencyOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物认定价值(元)" prop="evaluateWorth" >
              <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in worthEvaluateWayOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="账面原值/取得价值(元)" prop="originalWorth" >
              <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="foundsOnAccountsInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="foundsOnAccountsInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>应收账款信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="付款人全称" prop="payName">
              <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.payName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="应收账款类型" prop="accountType" >
              <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.accountType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in accountTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="foaCurrency" >
              <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.foaCurrency" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in currencyOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="应收账款发票实有金额(元)" prop="factMoney">
              <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.factMoney" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="账龄" prop="accountAge">
              <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.accountAge" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="账龄单位" prop="accountAgeUnit" >
              <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.accountAgeUnit" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in accountAgeUnitOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="还款期限(月)" prop="payLimitTime">
              <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.payLimitTime" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="约定收款日"  >
              <el-date-picker v-model="foundsOnAccountsInfo.originalGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="该笔应收款供销合同编号" prop="contractNumber">
              <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.contractNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="该账款入账日期"  >
              <el-date-picker v-model="foundsOnAccountsInfo.inAccountTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="该应收款核实情况" prop="checkSituation" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="foundsOnAccountsInfo.checkSituation" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="foundsOnAccountsInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmFundsOnAccountDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
      name: "mp-detail-for-funds-on-account",
      data(){
        return{
          foundsOnAccountsInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*应收账款*/
            payName:"",//付款人全称
            accountType:"出口退税",//应收账款类型
            foaCurrency:"",//币种(应收账款)
            factMoney:"",//应收账款发票实有金额(元)
            accountAge:"",//账龄
            accountAgeUnit:"月",//账龄单位
            payLimitTime:"",//还款期限(月)
            originalGetTime:"",//约定收款日
            contractNumber:"",//该笔应收款供销合同编号
            inAccountTime:"",//该账款入账日期
            checkSituation:"",//该应收款核实情况
            otherSituationExplain:"",//其他情况说明
          },
          rules:{
            /*价值*/
            currency: [
              {
                required: true,
                message: "请选择币种",
                trigger: 'change'
              }
            ],
            worthEvaluateWay: [
              {
                required: true,
                message: "请选择评估方式",
                trigger: 'change'
              }
            ],
            evaluateWorth: [
              {
                required: true,
                message: "请输入抵质押物认定价值",
                trigger: 'blur'},
              {
                max: 20,
                message: '长度不超过 20 个字符',
                trigger: 'blur'
              },
              {
                pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
                message: '请输入正确的金额',
                trigger: 'blur'
              }
            ],
            originalWorth: [
              {
                required: true,
                message: "请输入账面原值/取得价值",
                trigger: 'blur'},
              {
                max: 20,
                message: '长度不超过 20 个字符',
                trigger: 'blur'
              },
              {
                pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
                message: '请输入正确的金额',
                trigger: 'blur'
              }
            ],
            /*应收账款 rules*/
            payLimitTime: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            originalGetTime: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            contractNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            inAccountTime: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            payName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            accountType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            foaCurrency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            factMoney: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            accountAge: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            accountAgeUnit: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            checkSituation: [
              {
                required: false,
                message: "请输入核实情况说明",
                trigger: 'blur'},
              {
                max: 100,
                message: '长度不超过 100 个字符',
                trigger: 'blur'
              },
            ],
            otherSituationExplain: [
              {
                required: false,
                message: "请输入其他情况说明",
                trigger: 'blur'},
              {
                max: 100,
                message: '长度不超过 100 个字符',
                trigger: 'blur'
              },
            ],
          },
          buttonDisable:false,
          buttonText:"提交",
          inputComponentDisable:false,
          currencyOption:[
            {
              value: '人民币',
              label: '人民币'
            }, {
              value: '美元',
              label: '美元'
            },
          ],//币种类型选项
          worthEvaluateWayOption:[
            {
              value: '评估确定',
              label: '评估确定'
            }, {
              value: '协商确定',
              label: '协商确定'
            },
          ],//价值认定方式
          yesNotOption:[
            {
              value: '是',
              label: '是'
            }, {
              value: '否',
              label: '否'
            },
          ],//是否选择
          /*应收账款opt*/
          accountTypeOpt:[
            {
              value: '出口退税',
              label: '出口退税'
            }, {
              value: '否',
              label: '否'
            },
          ],
          accountAgeUnitOpt:[
            {
              value: '月',
              label: '月'
            }, {
              value: '否',
              label: '否'
            },
          ],
        }
      },
      methods:{
        doConfirmFundsOnAccountDetail:function () {
          this.$refs["mpFundsOnAccountDetailValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击
              this.buttonDisable = true;
              this.buttonText = "已提交";
              this.inputComponentDisable = true;
              this.$message({
                message: '数据提交成功！',
                type: 'success'
              });
            } else{
              this.$message({
                message: '请将信息填写完整',
                type: 'error'
              });
            }
          });
        },
        doReset:function () {
          this.$refs["mpFundsOnAccountDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-funds-on-account{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-funds-on-account p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
