<!--详细信息  应收账款-->
<template>
  <div class="mp-detail-for-funds-on-account">
    <el-row>
      <el-form el-form label-width="200px" :model="foundsOnAccountsInfo" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="foundsOnAccountsInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="foundsOnAccountsInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="foundsOnAccountsInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>应收账款信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="付款人全称" prop="paymentPersName">
            <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.paymentPersName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="应收账款类型" prop="receiveAmtType" >
            <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.receiveAmtType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in receiveAmtTypeOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCs" >
            <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.currencyCs" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="应收账款发票实有金额(元)" prop="amt">
            <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.amt" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账龄单位" prop="accounYearsUnitCd" >
            <el-select :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.accounYearsUnitCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in accounYearsUnitCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账龄" prop="accountYears">
            <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.accountYears" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="还款期限(月)" prop="receivableCartNum">
            <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.receivableCartNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="约定收款日" prop="agreementAmtDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="foundsOnAccountsInfo.agreementAmtDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="该笔应收款供销合同编号" prop="receivableContractNum">
            <el-input :disabled="inputComponentDisable" v-model="foundsOnAccountsInfo.receivableContractNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="该账款入账日期" prop="receivableAccountDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="foundsOnAccountsInfo.receivableAccountDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="该应收款核实情况" prop="receivableCheckStutas" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="foundsOnAccountsInfo.receivableCheckStutas" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="foundsOnAccountsInfo.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" >{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import enums from "@/utils/enums"
  import { updateReceivableAndGrtCollateral,selectReceivableByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-funds-on-account",
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
        selectReceivableByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.foundsOnAccountsInfo = response.data.data;
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
        foundsOnAccountsInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*应收账款*/
          paymentPersName:"",//付款人全称
          receiveAmtType:"",//应收账款类型
          currencyCs:"",//币种(应收账款)
          amt:"",//应收账款发票实有金额(元)
          accountYears:"",//账龄
          accounYearsUnitCd:"",//账龄单位
          receivableCartNum:"",//还款期限(月)
          agreementAmtDate:"",//约定收款日
          receivableContractNum:"",//该笔应收款供销合同编号
          receivableAccountDate:"",//该账款入账日期
          receivableCheckStutas:"",//该应收款核实情况
          otherNote:"",//其他情况说明
        },
        rules:{
          /*价值信息 rules*/
          assetStatus: [
            {
              required: true,
              message: "请选择价值认定方式",
              trigger: 'change'
            }
          ],
          bookValue: [
            {
              required: true,
              message: "请输入帐面原值/取得价值",
              trigger: 'change'
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
          marketValue: [
            {
              required: true,
              message: "请输入抵质押物认定价值",
              trigger: 'change'
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
          currencyCd: [
            {
              required: true,
              message: "请选择币种",
              trigger: 'change'
            }
          ],
          evaluateDate:[
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
          /*应收账款 rules*/
          receivableCartNum: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 6,
              message: '长度不超过 6 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[1-9]\d*$/,
              message: '请输入1~999999之间的整数',
              trigger: 'blur'
            }
          ],
          agreementAmtDate: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          receivableContractNum: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[A-Za-z0-9]{4,40}$/,
              message: '编号只能是数字和字母的组合',
              trigger: 'blur'
            }
          ],
          receivableAccountDate: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          paymentPersName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          receiveAmtType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          currencyCs: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          amt: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
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
          accountYears: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 20,
              message: '长度不超过 20 个字符',
              trigger: 'change'
            },
            {
              pattern: /^[1-9]\d*$/,
              message: '请输入正整数',
              trigger: 'change'
            }
          ],
          accounYearsUnitCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          receivableCheckStutas: [
            {
              required: true,
              message: "请输入核实情况说明",
              trigger: 'blur'},
            {
              max: 150,
              message: '长度不超过 150 个字符',
              trigger: 'change'
            },
          ],
          otherNote: [
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
        merchandiseTypeCdOpt:enums.merchandise_type_cd,//
        buttonDisable:false,
        buttonText:"提交",
        inputComponentDisable:false,
        currencyOption:enums.currencyCd,//币种类型选项
        worthEvaluateWayOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        yesNotOption:enums.commonYesAndNotCd,//是否选择
        /*应收账款opt*/
        receiveAmtTypeOpt:enums.DueFromFundsTypeCd,
        accounYearsUnitCdOpt:enums.AccountYearUnitCode,
      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateReceivableAndGrtCollateral(this.foundsOnAccountsInfo).then(response =>{
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
        this.$refs["validate"].resetFields();
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
