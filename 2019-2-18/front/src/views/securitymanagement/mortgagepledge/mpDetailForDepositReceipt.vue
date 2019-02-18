<!--存单-->
<template>
  <div class="mp-detail-for-deposit-receipt">
    <el-row>
      <el-form el-form label-width="170px" :model="depositoryReceiptInfo" label-position="right" :rules="rules" ref="mpRepositoryReceiptDetailValidate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="depositoryReceiptInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="depositoryReceiptInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="depositoryReceiptInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>存单质押信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存单号码" prop="depositReceiptNum" >
            <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.depositReceiptNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存单类型" prop="depositType" >
            <el-select :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.depositType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in typeOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="drCurrency" >
            <el-select :disabled="inputComponentDisable"  v-model="depositoryReceiptInfo.drCurrency" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="金额(元)" prop="amt" >
            <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.amt" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账号" prop="accountNum" >
            <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.accountNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存期(月)" prop="depositTerm" >
            <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.depositTerm" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存单开户日" prop="startDate"  >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="depositoryReceiptInfo.startDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存单到期日" prop="expireDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="depositoryReceiptInfo.expireDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="开户银行全称" prop="openBank" >
            <el-input :disabled="inputComponentDisable" v-model="depositoryReceiptInfo.openBank" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否止付" prop="stopPaymentInd" >
            <el-select :disabled="inputComponentDisable"  v-model="depositoryReceiptInfo.stopPaymentInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共有人" prop="commonAssetsInd" >
            <el-select :disabled="inputComponentDisable" v-on:change="onSelectChange" v-model="depositoryReceiptInfo.commonAssetsInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOption" :key="key" :label="value" :value="key">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="depositoryReceiptInfo.otherNote" style="width:100%"></el-input>
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
      <partOwnerInfo v-bind:info="grtCollateralInfo"/>
    </template>
  </div>
</template>

<script>
  import partOwnerInfo from './mpPartOwnerInfo'
  import enums from "@/utils/enums"
  import { updateGrtDepositAndGrtCollateral,selectGrtDepositByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-deposit-receipt",
    components:{
      partOwnerInfo
    },
    props:{
      grtCollateralInfo:Object,
      isUpdate:{
        default:false,
        type:Boolean,
      },
    },
    beforeMount(){
      //数据回显
      if(this.isUpdate){
        selectGrtDepositByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.depositoryReceiptInfo = response.data.data;
            console.log(this.depositoryReceiptInfo);
          } else{
            this.$message({
              message: '数据回显'+JSON.stringify(response.data),
              type: 'error'
            });
          }
        });
      }
    },
    data(){
      return{
        depositoryReceiptInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*存单质押信息*/
          depositReceiptNum:"",//存单号码
          depositType:"",//存单类型
          drCurrency:"",//币种
          amt:"",//金额
          accountNum:"",//账号
          depositTerm:"",//存期
          startDate:"",//存单开户日
          expireDate:"",//存单到期日
          openBank:"",//开户银行全称
          stopPaymentInd:"",//是否止付
          commonAssetsInd:"0",//是否共有人
          otherNote:"",//其他情况说明
        },
        rules:{
          depositReceiptNum: [
            {
              required: true,
              message: "存单号码不能为空!",
              trigger: 'change'
            },
            {
              pattern: /^[0-9]*$/,
              message: '请输入正确的存单号',
              trigger: 'blur'
            },
            {
              max: 25,
              message: '长度不超过 25 个字符',
              trigger: 'blur'
            },
          ],
          depositType: [
            {
              required: true,
              message: "请选择存单类型",
              trigger: 'change'
            }
          ],
          drCurrency: [
            {
              required: true,
              message: "请选择币种",
              trigger: 'change'
            },
          ],
          startDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          submittingDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          evaluateDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          expireDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          amt: [
            {
              required: true,
              message: "请输入金额",
              trigger: 'change'
            }
          ],
          depositTerm: [
            {
              required: true,
              message: "存期",
              trigger: 'change'
            },
            {
              max: 10,
              message: '长度不超过 10 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[1-9]\d*$/,
              message: '请输入正确的存期',
              trigger: 'blur'
            }
          ],
          accountNum: [
            {
              required: true,
              message: "请输入账号",
              trigger: 'change'
            },
            {
              max: 19,
              message: '长度不超过 19 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[0-9]{16,19}$/,
              message: '请输入正确的银行账号',
              trigger: 'blur'
            }
          ],
          openBank: [
            {
              required: true,
              message: "请输入开户行",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'blur'
            },
          ],
          stopPaymentInd: [
            {
              required: true,
              message: "选择是否止付",
              trigger: 'change'
            }
          ],
          commonAssetsInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          otherNote: [
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
          currencyCd: [
            {
              required: true,
              message: "请选择币种",
              trigger: 'change'
            }
          ],
          assetStatus: [
            {
              required: true,
              message: "请选择评估方式",
              trigger: 'change'
            }
          ],
          marketValue: [
            {
              required: true,
              message: "请输入抵质押物认定价值",
              trigger: 'blur'
            },
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
          bookValue: [
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
        currencyOption:enums.currencyCd,//币种类型选项
        worthEvaluateWayOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        yesNotOption:enums.commonYesAndNotCd,//是否选择
        typeOpt:enums.SecurityMoneyInterestTypeCd,//定期活期
      }
    },
    methods:{
      doConfirmRepositoryReceiptDetail:function () {
        this.$refs["mpRepositoryReceiptDetailValidate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateGrtDepositAndGrtCollateral(this.depositoryReceiptInfo).then(response =>{
              if(response.data.flag=='true') {
                //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击
                this.buttonDisable = true;
                this.buttonText = "已提交";
                this.inputComponentDisable = true;
                this.$message({
                  message: '提交成功',
                  type: 'success'
                });
              } else{
                this.buttonDisable = false;
                this.buttonText = "提交";
                this.$message({
                  message: '提交失败'+JSON.stringify(response.data),
                  type: 'error'
                });
              }
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
        if(data == enums.stateCode.result.yes){
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
