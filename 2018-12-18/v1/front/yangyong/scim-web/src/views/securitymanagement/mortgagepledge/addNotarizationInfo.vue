<template>
  <div class="add-notarization-info">
    <el-row>
      <el-form el-form ref="addNotarizationInfoValidate" label-width="200px" :model="notarizationInfo" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="借款合同号" prop="borrowMoneyContractNumber">
            <el-input  v-model="notarizationInfo.borrowMoneyContractNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="借款人名称" prop="borrowMoneyPerson">
            <el-input  v-model="notarizationInfo.borrowMoneyPerson" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公证书编号" prop="notarizationNumber">
            <el-input  v-model="notarizationInfo.notarizationNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公证处名称" prop="notarizationConstitution">
            <el-input  v-model="notarizationInfo.notarizationConstitution" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公证日期"  >
            <el-date-picker v-model="notarizationInfo.notarizationTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
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
    export default {
      name: "add-notarization-info",
      data(){
          return{
            notarizationInfo:{
              borrowMoneyContractNumber:"",//借款合同号
              borrowMoneyPerson:"",//借款人名称
              notarizationNumber:'',//公证书编号
              notarizationConstitution:'',//公证处名称
              notarizationTime: '2018-09-11',//公证日期

            },
            rules:{
              borrowMoneyContractNumber: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              borrowMoneyPerson: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              notarizationNumber: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              notarizationConstitution: [
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
        doConfirmAddNotarizationInfo:function () {
          this.$refs["addNotarizationInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
              this.$refs["addNotarizationInfoValidate"].resetFields();
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
