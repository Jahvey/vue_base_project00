<template>
  <div class="add-check-in-info">
    <el-row>
      <el-form el-form ref="addCheckInInfoValidate" label-width="200px" :model="checkInInfo" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="登记编号" prop="checkInNumber">
            <el-input  v-model="checkInInfo.checkInNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="借款合同号" prop="borrowMoneyContractNumber">
            <el-input  v-model="checkInInfo.borrowMoneyContractNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记价值(元)" prop="checkInWorth">
            <el-input  v-model="checkInInfo.checkInWorth" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记机构类型" prop="checkInInstitutionType" >
            <el-select  v-model="checkInInfo.checkInInstitutionType" placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in checkInInstitutionTypeOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记机构名称" prop="checkInInstitutionName">
            <el-input  v-model="checkInInfo.checkInInstitutionName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记生效日期"  >
            <el-date-picker v-model="checkInInfo.workTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记到期日期"  >
            <el-date-picker v-model="checkInInfo.endTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmAddCheckInInfo">{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
      name: "add-check-in-info",
      data(){
          return{
            checkInInfo:{
              checkInNumber:'',//登记编号
              checkInInstitutionType:'国产管理部门',//登记机构类型
              checkInInstitutionName: '', //登记机构名称
              workTime: '2018-09-11',//登记生效日期
              endTime: '2019-09-10',//登记到期日期
              borrowMoneyContractNumber:"",//借款合同号
              checkInWorth:"",//登记价值(元)
            },
            checkInInstitutionTypeOpt:[
                {
                  value: '国产管理部门',
                  label: '国产管理部门'
                }, {
                  value: '其他',
                  label: '其他'
                },
            ],//登记机构类型选项
            rules:{
              checkInNumber: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              checkInInstitutionType: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              checkInInstitutionName: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              borrowMoneyContractNumber: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              checkInWorth: [
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
        doConfirmAddCheckInInfo:function () {
          this.$refs["addCheckInInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
/*              this.checkInInfo.checkInNumber = "";
              this.checkInInfo.checkInInstitutionName = "";
              this.checkInInfo.borrowMoneyContractNumber = "";
              this.checkInInfo.checkInWorth = "";*/
              //this.buttonDisable = true;
              //this.buttonText = "已提交";
              this.$refs["addCheckInInfoValidate"].resetFields();
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
          this.$refs["addCheckInInfoValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .add-check-in-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .add-check-in-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
