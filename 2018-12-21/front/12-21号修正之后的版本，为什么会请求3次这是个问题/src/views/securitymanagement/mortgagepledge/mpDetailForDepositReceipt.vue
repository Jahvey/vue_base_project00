<!--存单-->
<template>
    <div class="mp-detail-for-deposit-receipt">
        <el-row>
          <el-form el-form label-width="170px" :model="depositoryReceiptInfo" label-position="right" :rules="rules" ref="mpRepositoryReceiptDetailValidate" >
              <el-col :span="24">
                <p>价值信息</p>
              </el-col>
              <el-col :span="12">
                <el-form-item label="币种" prop="customerType" >
                  <el-select :disabled="inputComponentDisable"  v-model="depositoryReceiptInfo.currency" placeholder="请选择" style="width:100%">
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
                  <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.evaluateWorth" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="价值认定方式" prop="customerType" >
                  <el-select :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
                  <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.originalWorth" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="价值认定时间"  >
                  <el-date-picker v-model="depositoryReceiptInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="价值认定到期日"  >
                  <el-date-picker v-model="depositoryReceiptInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="24">
                <p>存单质押信息</p>
              </el-col>
              <el-col :span="12">
                <el-form-item label="存单号码" prop="number" >
                  <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.number" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="存单类型" prop="type" >
                  <el-select :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.type" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="item in typeOpt"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="币种" prop="drCurrency" >
                  <el-select :disabled="inputComponentDisable"  v-model="depositoryReceiptInfo.drCurrency" placeholder="请选择" style="width:100%">
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
                <el-form-item label="金额(元)" prop="amount" >
                  <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.amount" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="账号" prop="account" >
                  <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.account" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="存期(月)" prop="depositTerm" >
                  <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.depositTerm" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="存单开户日"  >
                  <el-date-picker v-model="depositoryReceiptInfo.openTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="存单到期日"  >
                  <el-date-picker v-model="depositoryReceiptInfo.endTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="开户银行全称" prop="bankName" >
                  <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.bankName" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="是否止付" prop="ifStopPayment" >
                  <el-select :disabled="inputComponentDisable"  v-model="depositoryReceiptInfo.ifStopPayment" placeholder="请选择" style="width:100%">
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
                <el-form-item label="是否共有人" prop="ifPartOwner" >
                  <el-select :disabled="inputComponentDisable" v-on:change="onSelectChange" v-model="depositoryReceiptInfo.ifPartOwner" placeholder="请选择" style="width:100%">
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
                <el-form-item label="其他情况说明" prop="otherSituationExplain" >
                  <el-input :disabled="inputComponentDisable" type="textarea" v-model="depositoryReceiptInfo.otherSituationExplain" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
          </el-form>
        </el-row>
        <el-row>
          <el-col :span="6" :offset="10">
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmRepositoryReceiptDetail" >{{buttonText}}</el-button>
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
          </el-col>
        </el-row>
      <!--共有人信息页面-->
        <template v-if="ifShowPartOwnerInfo">
            <partOwnerInfo/>
        </template>
    </div>
</template>

<script>
    import partOwnerInfo from './mpPartOwnerInfo'
    export default {
      name: "mp-detail-for-deposit-receipt",
      components:{
        partOwnerInfo
      },
      data(){
        return{
          depositoryReceiptInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*存单质押信息*/
            number:"",//存单号码
            type:"活期",//存单类型
            drCurrency:"人民币",//币种
            amount:"",//金额
            account:"",//账号
            depositTerm:"",//存期
            openTime:"",//存单开户日
            endTime:"",//存单到期日
            bankName:"",//开户银行全称
            ifStopPayment:"是",//是否止付
            ifPartOwner:"否",//是否共有人
            otherSituationExplain:"",//其他情况说明
          },
          rules:{
            number: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            type: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            drCurrency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            amount: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            account: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            depositTerm: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            account: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            bankName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifStopPayment: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifPartOwner: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            otherSituationExplain: [
              {
                required: false,
                message: "请输入其他说明",
                trigger: 'blur'},
              {
                max: 100,
                message: '长度不超过 100 个字符',
                trigger: 'blur'
              },
            ],
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
          },
          ifShowPartOwnerInfo:false,
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
          typeOpt:[
            {
              value: '定期',
              label: '定期'
            }, {
              value: '活期',
              label: '活期'
            },
          ],//是否选择
        }
      },
      methods:{
        doConfirmRepositoryReceiptDetail:function () {
          this.$refs["mpRepositoryReceiptDetailValidate"].validate((valid) => {
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
          this.$refs["mpRepositoryReceiptDetailValidate"].resetFields();
        },
        onSelectChange:function (data) {//是否共有人选择事件
          if(data == '是'){
            this.ifShowPartOwnerInfo = true;
          } else{
            this.ifShowPartOwnerInfo = false;
          }
        }
      },
    }
</script>

<style scoped>
  .mp-detail-for-deposit-receipt{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-deposit-receipt p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
