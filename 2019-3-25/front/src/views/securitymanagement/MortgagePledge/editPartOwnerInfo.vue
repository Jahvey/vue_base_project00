<!--编辑 共有人信息页面-->
<template>
    <div class="edit-part-owner-info">
      <el-row>
        <el-form el-form ref="updatePartOwnerInfoValidate" label-width="200px" :model="grtTogetherCorrelative" label-position="right" :rules="rules" >
          <el-col :span="12">
            <el-form-item label="共有人名称" prop="togetherCorrelativeName">
              <el-input  v-model="grtTogetherCorrelative.togetherCorrelativeName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="共有人证件类型" prop="togetherCertificateType" >
              <el-select :disabled="inputComponentDisable"  v-model="grtTogetherCorrelative.togetherCertificateType" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in certificateTypeOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="共有人证件号码" prop="togetherCertificateNum">
              <el-input  v-model="grtTogetherCorrelative.togetherCertificateNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmUpdateNotarizationInfo">{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>

    </div>
</template>

<script>
  import enums from "@/utils/enums"
  import { updateTogetherCorrelatived} from '@/api/securitymanagement'
    export default {
        name: "edit-part-owner-info",
      props:{
        grtTogetherCorrelative:Object,
      },
      data(){
        return{
/*          grtTogetherCorrelative:{
            togetherCorrelativeName:"",//共有人名称
            togetherCertificateType:"",//共有人证件类型
            togetherCertificateNum:'',//共有人证件号码
            guarantyId:this.info.guarantyId,//担保id
          },*/
          certificateTypeOpt: enums.idTypeCd,
          rules:{
            togetherCorrelativeName: [
              {
                required: true,
                message: "共有人名称不能为空",
                trigger: 'change'
              }
            ],
            togetherCertificateType: [
              {
                required: true,
                message: "证件类型不能为空",
                trigger: 'change'
              }
            ],
            togetherCertificateNum: [
              {
                required: true,
                message: "请输入证件号码",
                trigger: 'change'
              },
              {
                pattern: /^[A-Za-z0-9]{4,40}$/,
                message: '请输入正确的证件号码',
                trigger: 'blur'
              },
            ],
          },
          buttonText:"提交",
          buttonDisable:false,
        }
      },
      methods:{
        doConfirmUpdateNotarizationInfo:function () {
          this.$refs["updatePartOwnerInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
              this.buttonDisable = true;
              this.buttonText = "提交中";
              updateTogetherCorrelatived(this.grtTogetherCorrelative).then(response => {
                if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
                  //提示父组件关闭dialog,并且刷新，重置当前表单
                  this.$refs["updatePartOwnerInfoValidate"].resetFields();
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
          this.$refs["updatePartOwnerInfoValidate"].resetFields();
        },
      },

    }
</script>

<style scoped>
  .edit-part-owner-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .edit-part-owner-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
