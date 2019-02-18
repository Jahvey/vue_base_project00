<!--添加公证信息-->
<template>
  <div class="add-notarization-info">
    <el-row>
      <el-form el-form ref="addNotarizationInfoValidate" label-width="200px" :model="grtCollateralNotarization" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="借款合同号" prop="loanContractNum">
            <el-input  v-model="grtCollateralNotarization.loanContractNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="借款人名称" prop="loanManName">
            <el-input  v-model="grtCollateralNotarization.loanManName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公证书编号" prop="notarialDeedNo">
            <el-input  v-model="grtCollateralNotarization.notarialDeedNo" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公证处名称" prop="notarialOrg">
            <el-input  v-model="grtCollateralNotarization.notarialOrg" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公证日期" prop="recordDate" >
            <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="grtCollateralNotarization.recordDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmAddNotarizationInfo">{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import enums from "@/utils/enums"
  import { saveCollateralNotarization} from '@/api/securitymanagement'
    export default {
      name: "add-notarization-info",
      props:{
        grtCollateralInfo:Object,
      },
      data(){
          return{
            grtCollateralNotarization:{
              guarantyId:this.grtCollateralInfo.guarantyId,//担保id
              notarialDeedNo:'',//公证书编号
              notarialOrg:'',//公证处名称
              recordDate: '',//公证日期
              /*查找带回参数*/
              loanContractNum:"",//借款合同号
              loanManName:"",//借款人名称
              loanCertificateType:"",//借款证件类型
              certificateCode:"",//证件号码
            },
            rules:{
              loanContractNum: [
                {
                  required: true,
                  message: "借款合同号不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'blur'
                },
              ],
              loanManName: [
                {
                  required: true,
                  message: "借款人名称不能为空",
                  trigger: 'change'
                },
                {
                  max: 8,
                  message: '长度不超过 8 个字符',
                  trigger: 'blur'
                },
              ],
              notarialDeedNo: [
                {
                  required: true,
                  message: "公证书编号不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'blur'
                },
              ],
              notarialOrg: [
                {
                  required: true,
                  message: "公证处名称不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'blur'
                },
              ],
              recordDate:[
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
        doConfirmAddNotarizationInfo:function () {
          this.$refs["addNotarizationInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
              this.buttonDisable = true;
              this.buttonText = "提交中";
              saveCollateralNotarization(this.grtCollateralNotarization).then(response => {
                if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
                  //提示父组件关闭dialog,并且刷新，重置当前表单
                  this.$refs["addNotarizationInfoValidate"].resetFields();
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
          this.$refs["addNotarizationInfoValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .add-notarization-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .add-notarization-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
