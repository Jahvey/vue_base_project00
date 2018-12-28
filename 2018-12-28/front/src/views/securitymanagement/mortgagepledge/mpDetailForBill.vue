<!--详细信息  票据-->
<template>
    <div class="mp-detail-for-bill">
      <el-row>
        <el-form el-form label-width="200px" :model="billInfo" label-position="right" :rules="rules" ref="mpBillDetailValidate" >
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="currency" >
              <el-select :disabled="inputComponentDisable"  v-model="billInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="billInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="billInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="billInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="billInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="billInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>票据信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="票据种类" prop="billType" >
              <el-select :disabled="inputComponentDisable"  v-model="billInfo.billType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in billTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="票据号码" prop="billNumber" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.billNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="bCurrency" >
              <el-select :disabled="inputComponentDisable"  v-model="billInfo.bCurrency" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in currencyOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="票面金额(元)" prop="billWorth" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.billWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="出票日"  >
              <el-date-picker v-model="billInfo.outBillTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="到期日期"  >
              <el-date-picker v-model="billInfo.endBillTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="期限(月)" prop="timeLimit" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.timeLimit" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="出票人全称" prop="outBillPersonName" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.outBillPersonName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="出票人账号" prop="outBillPersonAccount" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.outBillPersonAccount" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="出票人开户银行全称" prop="outBillPersonBank" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.outBillPersonBank" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="承兑人全称" prop="acceptorName" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.acceptorName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="承兑人账号" prop="acceptorAccount" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.acceptorAccount" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="承兑人开户银行全称" prop="acceptorBank" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.acceptorBank" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="收款人全称" prop="payeeName" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.payeeName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="收款人账号" prop="payeeAccount" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.payeeAccount" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="收款人开户银行全称" prop="payeeBank" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.payeeBank" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="查询结果" prop="checkResult" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.checkResult" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="承兑银行全称" prop="acceptingBank" >
              <el-input :disabled="inputComponentDisable" v-model="billInfo.acceptingBank" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="billInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmBillDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-bill",
      data(){
        return{
          billInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*票据*/
            billType:"银行承兑汇票",//票据种类
            billNumber:"",//票据号码
            bCurrency:"人民币",//币种
            billWorth:"",//票面金额(元)
            outBillTime:"",//出票日
            endBillTime:"",//到期日期
            timeLimit:"",//期限(月)
            outBillPersonName:"",//出票人全称
            outBillPersonAccount:"",//出票人账号
            outBillPersonBank:"",//出票人开户银行全称
            acceptorName:"",//承兑人全称
            acceptorAccount:"",//承兑人账号
            acceptorBank:"",//承兑人开户银行全称
            payeeName:"",//收款人全称
            payeeAccount:"",//收款人账号
            payeeBank:"",//收款人开户银行全称
            checkResult:"",//查询结果
            acceptingBank:"",//承兑银行全称
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
            /*票据 rules*/
            outBillPersonName: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            outBillPersonAccount: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            outBillPersonBank: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            acceptorName: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            acceptorAccount: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            acceptorBank: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            payeeName: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            payeeAccount: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            payeeBank: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            checkResult: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            acceptingBank: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            billType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            billNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            bCurrency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            billWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            outBillTime: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            endBillTime: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            timeLimit: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
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
          /*票据opt*/
          billTypeOpt:[
            {
              value: '银行承兑汇票',
              label: '银行承兑汇票'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
        }
      },
      methods:{
        doConfirmBillDetail:function () {
          this.$refs["mpBillDetailValidate"].validate((valid) => {
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
          this.$refs["mpBillDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-bill{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-bill p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
