<!--详细信息 工资账户-->
<template>
  <div class="mp-detail-for-salary-account">
    <el-row >
      <el-form el-form label-width="170px" :model="salaryAccountInfo" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="salaryAccountInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="salaryAccountInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="salaryAccountInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="salaryAccountInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <p>工资账户</p>
        <el-col :span="12">
          <el-form-item label="个人结算账号" prop="personalSettlementAccount" >
            <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.personalSettlementAccount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencySpecies" >
            <el-select :disabled="inputComponentDisable" v-model="salaryAccountInfo.currencySpecies" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="月实发工资额(元)" prop="monthSendEarnings" >
            <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.monthSendEarnings" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否止付" prop="isPayment" >
            <el-select :disabled="inputComponentDisable" v-model="salaryAccountInfo.isPayment" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="开户银行全称" prop="openBankAccount" >
            <el-input :disabled="inputComponentDisable" v-model="salaryAccountInfo.openBankAccount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共有人" prop="isCommonPerson" >
            <el-select :disabled="inputComponentDisable" v-on:change="onSelectChange" v-model="salaryAccountInfo.isCommonPerson" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherExplain" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="salaryAccountInfo.otherExplain" style="width:100%"></el-input>
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
    <!--共有人信息页面-->
    <template v-if="ifShowPartOwnerInfo">
      <partOwnerInfo v-bind:info="grtCollateralInfo"/>
    </template>
  </div>
</template>

<script>
  import partOwnerInfo from './mpPartOwnerInfo'
  import enums from "@/utils/enums"
  import { updateEarningsAccountAndGrtCollateral,selectEarningsAccountByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-salary-account",
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
        selectEarningsAccountByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.salaryAccountInfo = response.data.data;
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
        salaryAccountInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*工资信息*/
          personalSettlementAccount:"",//个人结算账户
          currencySpecies:"",//账户币种
          monthSendEarnings:"",//月实发工资(元)
          openBankAccount:"",//开户银行名称
          isPayment:"",//是否止付
          isCommonPerson:"",//是否共有人
          otherExplain:"",//其他信息说明
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
          /*工资账户*/
          currencySpecies: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          isCommonPerson: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          isPayment: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          personalSettlementAccount: [
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
          monthSendEarnings: [
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
          openBankAccount: [
            {
              required: true,
              message: "请输入开户银行全称",
              trigger: 'blur'},
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          otherExplain: [
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
        buttonText:"提交",
        inputComponentDisable:false,
        currencyOption:enums.currencyCd,//币种类型选项
        worthEvaluateWayOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        yesNotOption:enums.commonYesAndNotCd,//是否选择
        ifShowPartOwnerInfo:false,
      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateEarningsAccountAndGrtCollateral(this.salaryAccountInfo).then(response =>{
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
