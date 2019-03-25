<!--详细信息  收费权-->
<template>
  <div class="mp-detail-for-charge-right">
    <el-row>
      <el-form el-form label-width="170px" :model="chargeRightInfo" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="chargeRightInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="chargeRightInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="chargeRightInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="chargeRightInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>收费权信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费项目" prop="chargingRightName" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.chargingRightName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费标准" prop="chargingRightStander" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.chargingRightStander" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费权质押批文单位" prop="approveOrg" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.approveOrg" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费批准文件全称" prop="chargingRightFileName" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.chargingRightFileName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费批准文件编号" prop="approveDocumentNum" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.approveDocumentNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费权现金流分析" prop="chargeRightCashflowAnalysis" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.chargeRightCashflowAnalysis" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费许可证编号" prop="chargesLicenseNum" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.chargesLicenseNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="归集账号" prop="collectionAccount" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.collectionAccount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="开户行全称" prop="openBank" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.openBank" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="收费还贷比例" prop="chargeRepaymentRate" >
            <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.chargeRepaymentRate" ><template slot="append">%</template></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="chargeRightInfo.otherNote" style="width:100%"></el-input>
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
  import { updateChargingRightMortgageAndGrtCollateral,selectChargingRightMortgageByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-charge-right",
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
        selectChargingRightMortgageByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.chargeRightInfo = response.data.data;
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
        chargeRightInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*收费权信息*/
          chargingRightName:"",//收费项目
          chargingRightStander:"",//收费标准
          approveOrg:"",//收费权质押批文单位
          chargingRightFileName:"",//收费批准文件全称
          approveDocumentNum:"",//收费批准文件编号
          chargeRepaymentRate:"",//收费还款比例
          chargeRightCashflowAnalysis:"",//收费权现金流分析
          chargesLicenseNum:"",//收费许可证编号
          collectionAccount:"",//归集账号
          openBank:"",//开户银行全称
          otherNote:"",//其他情况说明
        },
        rules:{
          chargingRightName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          chargesLicenseNum: [
            {
              required: false,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          chargeRightCashflowAnalysis: [
            {
              required: false,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          chargingRightStander: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          approveOrg: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          chargingRightFileName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          approveDocumentNum: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          chargeRepaymentRate: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
            {
              pattern: /^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/,
              message: '请输入0-100内的数字,保留两位小数',
              trigger: 'change'
            }
          ],
          collectionAccount: [
            {
              required: true,
              message: "请输入",
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
          openBank: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
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
        },
        merchandiseTypeCdOpt:enums.merchandise_type_cd,//
        buttonDisable:false,
        buttonText:"提交",
        inputComponentDisable:false,
        currencyOption:enums.currencyCd,//币种类型选项
        worthEvaluateWayOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        yesNotOption:enums.commonYesAndNotCd,//是否选择

      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateChargingRightMortgageAndGrtCollateral(this.chargeRightInfo).then(response =>{
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
  .mp-detail-for-charge-right{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-charge-right p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
