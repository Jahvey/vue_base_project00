<!--详细信息  票据-->
<template>
  <div class="mp-detail-for-bill">
    <el-row>
      <el-form el-form label-width="200px" :model="billInfo" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="billInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="billInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="billInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="billInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>票据信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="票据种类" prop="billType" >
            <el-select :disabled="inputComponentDisable"  v-model="billInfo.billType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in billTypeOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="票据号码" prop="billNum" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.billNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="billCurrencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="billInfo.billCurrencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="票面金额(元)" prop="billAmt" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.billAmt" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="出票日"  prop="billSignupDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="billInfo.billSignupDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="到期日期" prop="billExpireDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="billInfo.billExpireDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="期限(月)" prop="billTerm" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.billTerm" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <!--         <el-col :span="12" >
                   <el-form-item label="出票人全称" prop="remitterName" >
                     <el-input :disabled="inputComponentDisable" v-model="billInfo.remitterName" style="width:100%"></el-input>
                   </el-form-item>
                 </el-col>
                 <el-col :span="12" >
                   <el-form-item label="出票人账号" prop="remitterAccount" >
                     <el-input :disabled="inputComponentDisable" v-model="billInfo.remitterAccount" style="width:100%"></el-input>
                   </el-form-item>
                 </el-col>
                 <el-col :span="12" >
                   <el-form-item label="出票人开户银行全称" prop="remitterBank" >
                     <el-input :disabled="inputComponentDisable" v-model="billInfo.remitterBank" style="width:100%"></el-input>
                   </el-form-item>
                 </el-col>-->
        <el-col :span="12" >
          <el-form-item label="承兑人(出票人)全称" prop="remitterName" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.remitterName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="承兑人(出票人)账号" prop="remitterAccount" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.remitterAccount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="承兑人(出票人)开户银行全称" prop="remitterBank" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.remitterBank" style="width:100%"></el-input>
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
          <el-form-item label="查询结果" prop="searchResult" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.searchResult" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="承兑银行全称" prop="acceptorBank" >
            <el-input :disabled="inputComponentDisable" v-model="billInfo.acceptorBank" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="billInfo.otherNote" style="width:100%"></el-input>
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
  import { updateBillAndGrtCollateral,selectBillByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-bill",
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
        selectBillByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.billInfo = response.data.data;
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
        billInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*票据*/
          billType:"",//票据种类
          billNum:"",//票据号码
          billCurrencyCd:"",//币种
          billAmt:"",//票面金额(元)
          billSignupDate:"",//出票日
          billExpireDate:"",//到期日期
          billTerm:"",//期限(月)
          /*            remitterName:"",//出票人全称
                      remitterAccount:"",//出票人账号
                      remitterBank:"",//出票人开户银行全称
                      remitterName:"",//承兑人全称
                      remitterAccount:"",//承兑人账号
                      remitterBank:"",//承兑人开户银行全称*/
          remitterName:"",//承兑人(出票人)全称
          remitterAccount:"",//承兑人(出票人)账号
          remitterBank:"",//承兑人(出票人)开户银行全称
          payeeName:"",//收款人全称
          payeeAccount:"",//收款人账号
          payeeBank:"",//收款人开户银行全称
          searchResult:"",//查询结果
          acceptorBank:"",//承兑银行全称
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
          /*票据 rules*/
          remitterName: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          remitterAccount: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'change'
            },
            {
              pattern: /^[0-9]*$/,
              message: '请输入数字',
              trigger: 'change'
            }
          ],
          remitterBank: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          payeeName: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          payeeAccount: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'change'
            },
            ,
            {
              pattern: /^[0-9]*$/,
              message: '请输入数字',
              trigger: 'change'
            }
          ],
          payeeBank: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          searchResult: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          acceptorBank: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          billType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          billNum: [
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
              message: '只能是数字、字母或其组合',
              trigger: 'blur'
            }
          ],
          billCurrencyCd: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            }
          ],
          billAmt: [
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
          billSignupDate: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          billExpireDate: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          billTerm: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max:8,
              message: '长度不超过 8 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[1-9]\d*$/,
              message: '请输入正整数',
              trigger: 'blur'
            }
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
        /*票据opt*/
        billTypeOpt:enums.BillTypeCd,
      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateBillAndGrtCollateral(this.billInfo).then(response =>{
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
