<!--详细信息 工资账户-->
<template>
    <div class="mp-detail-for-salary-account">
        <el-row >
          <el-form el-form label-width="170px" :model="salaryAccountInfo" label-position="right" :rules="rules" ref="mpSalaryAccountDetailValidate" >
            <p>价值信息</p>
            <el-col :span="12">
              <el-form-item label="币种" prop="customerType" >
                <el-select :disabled="inputComponentDisable"  v-model="salaryAccountInfo.currency" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.evaluateWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定方式" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="salaryAccountInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.originalWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定时间"  >
                <el-date-picker v-model="salaryAccountInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定到期日"  >
                <el-date-picker v-model="salaryAccountInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <p>工资账户</p>
            <el-col :span="12">
              <el-form-item label="个人结算账号" prop="personalAccount" >
                <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.personalAccount" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="币种" prop="accountCurrency" >
                <el-select :disabled="inputComponentDisable" v-model="salaryAccountInfo.accountCurrency" placeholder="请选择" style="width:100%">
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
              <el-form-item label="月实发工资额(元)" prop="salaryMonthLimit" >
                <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.salaryMonthLimit" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否止付" prop="ifStopPayment" >
                <el-select :disabled="inputComponentDisable" v-model="salaryAccountInfo.ifStopPayment" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOption"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="开户银行全称" prop="bankToAccount" >
                <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.bankToAccount" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否共有人" prop="ifPartOwner" >
                <el-select :disabled="inputComponentDisable" v-model="salaryAccountInfo.ifPartOwner" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOption"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="24" >
              <el-form-item label="其他情况说明" prop="otherConditionMark" >
                <el-input :disabled="inputComponentDisable" type="textarea" v-model="salaryAccountInfo.otherConditionMark" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
        <el-row>
          <el-col :span="6" :offset="10">
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmSalaryAccountDetail" >{{buttonText}}</el-button>
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
          </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-salary-account",
      data(){
          return{
            salaryAccountInfo:{
              currency:"人民币",//币种
              evaluateWorth:"",//抵质押物认定价值(元)
              originalWorth:"",//账面原值/取得价值(元)
              worthEvaluateWay:"评估确定",//价值认定方式
              worthEvaluateTime:"",//价值认定时间
              worthEvaluateTimeExpire:"",//价值认定到期日
              personalAccount:"",//个人结算账户
              accountCurrency:"",//账户币种
              salaryMonthLimit:"",//月实发工资(元)
              bankToAccount:"",//开户银行名称
              ifStopPayment:"",//是否止付
              ifPartOwner:"",//是否共有人
              otherConditionMark:"",//其他信息说明
            },
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
            rules:{
              ifPartOwner: [
                {
                  required: true,
                  message: "请选择是否",
                  trigger: 'change'
                }
              ],
              ifStopPayment: [
                {
                  required: true,
                  message: "请选择是否",
                  trigger: 'change'
                }
              ],
              currency: [
                {
                  required: true,
                  message: "请选择币种",
                  trigger: 'change'
                }
              ],
              accountCurrency: [
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
              worthEvaluateTime: [
                {
                  required: true,
                  type:'string',
                  message: "请输入价值认定时间",
                  trigger: 'blur'
                },
              ],
              worthEvaluateTimeExpire: [
                {
                  required: true,
                  type:'string',
                  message: "请输入价值认定到期时间",
                  trigger: 'blur'
                },
              ],
              personalAccount: [
                {
                  required: true,
                  message: "请输入个人结算账户",
                  trigger: 'blur'},
                {
                  max: 20,
                  message: '长度不超过 20 个字符',
                  trigger: 'blur'
                },
                {
                  pattern: /^[0-9]*$/,
                  message: '请输入正确的银行账户',
                  trigger: 'blur'
                }
              ],
              salaryMonthLimit: [
                {
                  required: true,
                  message: "请输入月发工资额",
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
              bankToAccount: [
                {
                  required: true,
                  message: "请输入开户银行全称",
                  trigger: 'blur'},
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'blur'
                },
              ],
              otherConditionMark: [
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
            },//校验规则
            buttonDisable:false,
            buttonText:"确定",
            inputComponentDisable:false,
          }
      },
      methods:{
        doConfirmSalaryAccountDetail:function () {
          this.$refs["mpSalaryAccountDetailValidate"].validate((valid) => {
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
          this.$refs["mpSalaryAccountDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-salary-account{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-salary-account p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
