<!--添加共有人页面-->
<template>
    <div class="add-part-owner-info">
        <el-row>
          <el-form el-form ref="addPartOwnerInfoValidate" label-width="200px" :model="partOwnerInfo" label-position="right" :rules="rules" >
            <el-col :span="12">
              <el-form-item label="共有人名称" prop="name">
                <el-input  v-model="partOwnerInfo.name" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="共有人证件类型" prop="certificateType" >
                <el-select :disabled="inputComponentDisable"  v-model="partOwnerInfo.certificateType" placeholder="请选择" style="width:100%">
                  <el-option v-for="(value,key) in certificateTypeOpt" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="共有人证件号码" prop="number">
                <el-input  v-model="partOwnerInfo.number" style="width:100%"></el-input>
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
    export default {
        name: "add-part-owner-info",
      data(){
        return{
          partOwnerInfo:{
            name:"",//共有人名称
            certificateType:"身份证",//共有人证件类型
            number:'',//共有人证件号码
          },
          certificateTypeOpt: enums.idTypeCd,
          rules:{
            name: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            certificateType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            number: [
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
          this.$refs["addPartOwnerInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
              this.$refs["addPartOwnerInfoValidate"].resetFields();
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
          this.$refs["addPartOwnerInfoValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .add-part-owner-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .add-part-owner-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
