<template>
  <div class="add-accident-info">
    <el-row>
      <el-form el-form ref="addAccidentInfoValidate" label-width="200px" :model="accidentInfo" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="意外情况类型" prop="mpGoodsType">
            <el-select v-model="accidentInfo.accidentInfoType" placeholder="请选择">
              <el-option
                v-for="item in accidentInfoTypeOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发生日期"  >
            <el-date-picker v-model="accidentInfo.accidentHappenTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="损失价值(元)" prop="lossWorth">
            <el-input  v-model="accidentInfo.lossWorth" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="补偿价值(元)" prop="compensationWorth">
            <el-input  v-model="accidentInfo.compensationWorth" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="原因" prop="accidentReason">
            <el-input type="textarea" v-model="accidentInfo.accidentReason" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmAddAccidentInfo">{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
      name: "add-accident-info",
      data(){
          return{
            accidentInfo:{
              accidentInfoType:"损坏",//意外情况类型
              accidentHappenTime:"2018-09-11",//发生日期
              accidentReason:'',//原因
              lossWorth:'',//损失价值(元)
              compensationWorth:'',//补偿价值(元)

            },
            rules:{
              accidentInfoType: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              accidentReason: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              lossWorth: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
              compensationWorth: [
                {
                  required: true,
                  message: "",
                  trigger: 'change'
                }
              ],
            },
            accidentInfoTypeOpt:[
              {
                value: '损毁',
                label: '损毁'
              }, {
                value: '其他',
                label: '其他'
              },
            ],
            buttonText:"提交",
            buttonDisable:false,
          }
      },
      methods:{
        doConfirmAddAccidentInfo:function () {
          this.$refs["addAccidentInfoValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
              this.$refs["addAccidentInfoValidate"].resetFields();
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
          this.$refs["addAccidentInfoValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .add-accident-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .add-accident-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
