<template>
  <div class="edit-check-in-info">
    <el-row>
      <el-form el-form ref="validate" label-width="200px" :model="grtCollateralRegistration" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="登记编号" prop="registerNum">
            <el-input  v-model="grtCollateralRegistration.registerNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="借款合同号" prop="contractNum">
            <el-input  v-model="grtCollateralRegistration.contractNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记价值(元)" prop="registerValue">
            <el-input  v-model="grtCollateralRegistration.registerValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记机构类型" prop="registerOrgTypeCd" >
            <el-select  v-model="grtCollateralRegistration.registerOrgTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in checkInInstitutionTypeOpt" :key="key" :label="value" :value="key">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记机构名称" prop="registerOrgName">
            <el-input  v-model="grtCollateralRegistration.registerOrgName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记生效日期"  >
            <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="grtCollateralRegistration.registerDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记到期日期"  >
            <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="grtCollateralRegistration.registerExpirationDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm">{{buttonText}}</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import enums from "@/utils/enums"
  import { updateCollateralRegistration} from '@/api/securitymanagement'
  import commonUtil from '@/utils/commonUtil'
    export default {
        name: "edit-check-in-info",
      props:{
        grtCollateralRegistration:Object,
      },
      beforeMount(){
        this.grtCollateralRegistration.registerDate = commonUtil.timeStampToDate(this.grtCollateralRegistration.registerDate);
        this.grtCollateralRegistration.registerExpirationDate = commonUtil.timeStampToDate(this.grtCollateralRegistration.registerExpirationDate);
      },
      data(){
        return{
          checkInInstitutionTypeOpt:enums.RegisterOrgTypeCode,//登记机构类型选项
          rules:{
            registerNum: [
              {
                required: true,
                message: "登记编号不能为空",
                trigger: 'change'
              }
            ],
            registerOrgTypeCd: [
              {
                required: true,
                message: "请选择登记部门类型",
                trigger: 'change'
              }
            ],
            registerOrgName: [
              {
                required: true,
                message: "请输入登记机构名称",
                trigger: 'change'
              }
            ],
            contractNum: [
              {
                required: true,
                message: "借款合同号不能为空",
                trigger: 'change'
              }
            ],
            registerValue: [
              {
                required: true,
                message: "登记价值不能为空",
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
            registerDate:[
              {
                required: true,
                message: "请选择日期",
                trigger: 'change',
                //type: 'date'
              },
            ],
            registerExpirationDate:[
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
        comfirm:function () {
          this.$refs["validate"].validate((valid) => {
            if(valid){
              this.buttonDisable = true;
              this.buttonText = "提交中";
              updateCollateralRegistration(this.grtCollateralRegistration).then(response => {
                if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
                  //提示父组件关闭dialog,并且刷新，重置当前表单
                  this.$refs["validate"].resetFields();
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
      },
    }
</script>

<style scoped>
  .edit-check-in-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .edit-check-in-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
