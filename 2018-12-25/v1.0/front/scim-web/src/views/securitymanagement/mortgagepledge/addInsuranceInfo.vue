<template>
  <div class="add-insurance-info">
    <el-row>
      <el-form el-form ref="addInsuranceInfoValidate" label-width="200px" :model="insuranceInfo" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="抵质押物编号" >
            <el-input disabled="true" v-model="insuranceInfo.mpGoodsNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押品名称" >
            <el-input disabled="true" v-model="insuranceInfo.mpGoodsName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保险机构" prop="insuranceInstitution">
            <el-input  v-model="insuranceInfo.insuranceInstitution" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保险单编号" prop="insuranceNumber">
            <el-input  v-model="insuranceInfo.insuranceNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保险种" prop="insuranceType">
            <el-input  v-model="insuranceInfo.insuranceType" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="投保人" prop="insurancePerson">
            <el-input  v-model="insuranceInfo.insurancePerson" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="第一受益人" prop="firstBenefitPerson">
            <el-input  v-model="insuranceInfo.firstBenefitPerson" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currency" >
            <el-select  v-model="insuranceInfo.currency" placeholder="请选择" style="width:100%">
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
          <el-form-item label="投保金额(元)" prop="guaranteeMoney">
            <el-input  v-model="insuranceInfo.guaranteeMoney" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="起始日期"  >
            <el-date-picker v-model="insuranceInfo.startTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="到期日期"  >
            <el-date-picker v-model="insuranceInfo.endTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="生效日期"  >
            <el-date-picker v-model="insuranceInfo.workTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmAddInsuranceInfo">{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
      name: "add-insurance-info",
      data(){
          return{
            insuranceInfo:{
              mpGoodsNumber:'GN003',//抵质押物编号
              mpGoodsName:'爱情公寓3号房',//抵质押品名称
              insuranceInstitution: '', //保险机构
              insuranceNumber: '',//保险单编号
              insuranceType: '',//担保险种
              insurancePerson:"",//投保人
              firstBenefitPerson:"",//第一受益人
              currency:"人民币",//币种
              guaranteeMoney:"",//投保金额(元)
              startTime:"2018-09-11",//起始日期
              endTime:"2019-09-10",//到期日期
              workTime:"2018-09-11",//生效日期
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
            rules:{
              insuranceInstitution: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              insuranceNumber: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              insuranceType: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              insurancePerson: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              firstBenefitPerson: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              currency: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              guaranteeMoney: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
            },
            buttonText:"提交",
            buttonDisable:false,
          }
      },
      methods:{
        doConfirmAddInsuranceInfo:function () {
          this.$refs["addInsuranceInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
/*              this.insuranceInfo.insuranceInstitution = "";
              this.insuranceInfo.insuranceNumber = "";
              this.insuranceInfo.insuranceType = "";
              this.insuranceInfo.insurancePerson = "";
              this.insuranceInfo.firstBenefitPerson = "";
              this.insuranceInfo.guaranteeMoney = "";*/
              this.$refs["addInsuranceInfoValidate"].resetFields();
              //this.buttonDisable = true;
              //this.buttonText = "已提交";
              //提示父组件关闭dialog
              this.$emit('backFlag',"ok");
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
          this.$refs["addInsuranceInfoValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .add-insurance-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .add-insurance-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
