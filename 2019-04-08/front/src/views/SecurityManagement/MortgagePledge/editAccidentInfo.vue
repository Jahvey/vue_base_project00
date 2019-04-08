<template>
  <div class="edit-accident-info">
    <el-row>
      <el-form el-form ref="validate" label-width="200px" :model="grtCollateralAccident" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="意外情况类型" prop="accidentTypeCd">
            <el-select v-model="grtCollateralAccident.accidentTypeCd" placeholder="请选择">
              <el-option v-for="(value,key) in accidentInfoTypeOpt" :key="key" :label="value" :value="key">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发生日期" prop="occurDate" >
            <el-date-picker   format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="grtCollateralAccident.occurDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="损失价值(元)" prop="priceLosses">
            <el-input  v-model="grtCollateralAccident.priceLosses" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="补偿价值(元)" prop="pricesCompensation">
            <el-input  v-model="grtCollateralAccident.pricesCompensation" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="原因" prop="reason">
            <el-input type="textarea" v-model="grtCollateralAccident.reason" style="width:100%"></el-input>
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
  import { updateCollateralAccident} from '@/api/securitymanagement'
    export default {
        name: "edit-accident-info",
      props:{
        grtCollateralAccident:Object,
      },
      data(){
          return{
            rules:{
              accidentTypeCd: [
                {
                  required: true,
                  message: "请选择意外情况类型",
                  trigger: 'change'
                }
              ],
              reason: [
                {
                  required: true,
                  message: "请填写原因",
                  trigger: 'change'
                }
              ],
              pricesCompensation: [
                {
                  required: true,
                  message: "请输入损失价值",
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
              priceLosses: [
                {
                  required: true,
                  message: "请输入补偿价值",
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
              occurDate:[
                {
                  required: true,
                  message: "请选择日期",
                  trigger: 'change',
                  //type: 'date'
                },
              ],
            },
            accidentInfoTypeOpt:enums.CollateralState,
            buttonText:"提交",
            buttonDisable:false,
          }
      },
      beforeMount(){
      },
      methods:{
        comfirm:function () {
          this.$refs["validate"].validate((valid) => {
            if(valid){
              this.buttonDisable = true;
              this.buttonText = "提交中";
              updateCollateralAccident(this.grtCollateralAccident).then(response => {
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
  .edit-accident-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .edit-accident-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
