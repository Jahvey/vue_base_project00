<template>
    <div class="edit-insurance-info">
      <el-row>
        <el-form el-form ref="updateInsuranceInfoValidate" label-width="200px" :model="grtCollateralInsurance" label-position="right" :rules="rules" >
          <el-col :span="12">
            <el-form-item label="保险机构" prop="insuranceCompanyName">
              <el-input  v-model="grtCollateralInsurance.insuranceCompanyName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保险单编号" prop="insurancePolicyNum">
              <el-input  v-model="grtCollateralInsurance.insurancePolicyNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="担保险种" prop="insuranceType">
              <el-input  v-model="grtCollateralInsurance.insuranceType" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="投保人" prop="policyHolder">
              <el-input  v-model="grtCollateralInsurance.policyHolder" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="第一受益人" prop="insuranceBenefitiary">
              <el-input  v-model="grtCollateralInsurance.insuranceBenefitiary" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="currencyCd" >
              <el-select  v-model="grtCollateralInsurance.currencyCd" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="投保金额(元)" prop="insuranceAmt">
              <el-input  v-model="grtCollateralInsurance.insuranceAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="起始日期" prop="startDate" >
              <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="grtCollateralInsurance.startDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="到期日期" prop="endDate" >
              <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="grtCollateralInsurance.endDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="生效日期" prop="effectiveDate" >
              <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd"  v-model="grtCollateralInsurance.effectiveDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="12">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmUpdateInsuranceInfo">{{buttonText}}</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
  import enums from "@/utils/enums"
  import commonUtil from '@/utils/commonUtil'
  import { updateCollateralInsurance} from '@/api/securitymanagement'
    export default {
        name: "edit-insurance-info",
      props:{
        grtCollateralInsurance:Object,
      },
      data(){
          return{
            currencyOption:enums.currencyCd,//币种类型选项
            rules:{
              insuranceCompanyName: [
                {
                  required: true,
                  message: "请输入保险机构",
                  trigger: 'change'
                }
              ],
              insurancePolicyNum: [
                {
                  required: true,
                  message: "请输入保险单编号",
                  trigger: 'change'
                }
              ],
              insuranceType: [
                {
                  required: true,
                  message: "请输入保险险种",
                  trigger: 'change'
                }
              ],
              policyHolder: [
                {
                  required: true,
                  message: "请输入投保人",
                  trigger: 'change'
                }
              ],
              insuranceBenefitiary: [
                {
                  required: true,
                  message: "第一受益人",
                  trigger: 'change'
                }
              ],
              currencyCd: [
                {
                  required: true,
                  message: "请选择币种",
                  trigger: 'change'
                }
              ],
              insuranceAmt: [
                {
                  required: true,
                  message: "请输入投保金额",
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
              startDate:[
                {
                  required: true,
                  message: "请选择日期",
                  trigger: 'change',
                  //type: 'date'
                },
              ],
              endDate:[
                {
                  required: true,
                  message: "请选择日期",
                  trigger: 'change',
                  //type: 'date'
                },
              ],
              effectiveDate:[
                {
                  required: true,
                  message: "请选择日期",
                  trigger: 'change',
                  //type: 'date'
                },
              ],
            },
            buttonText:"提交",
            buttonDisable:false,
          }
      },
      methods:{
        doConfirmUpdateInsuranceInfo:function () {
          this.$refs["updateInsuranceInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
              this.buttonDisable = true;
              this.buttonText = "提交中";
              updateCollateralInsurance(this.grtCollateralInsurance).then(response => {
                if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
                  //提示父组件关闭dialog,并且刷新，重置当前表单
                  this.$refs["updateInsuranceInfoValidate"].resetFields();
                  this.$emit('backFlag',"ok");
                  this.$message({
                    message: '数据提交成功！',
                    type: 'success'
                  });
                } else{
                  this.$message({
                    message: '操作失败！'+JSON.stringify(response.data),
                    type: 'error'
                  });
                }
                this.buttonDisable = false;
                this.buttonText = "提交";
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
          this.$refs["updateInsuranceInfoValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .edit-insurance-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .edit-insurance-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
