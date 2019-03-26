<template>
  <div>
    <el-row>
      <el-form el-form label-width="130px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="12">
          <el-form-item label="投保人" prop="policyHolder" >
            <el-input :disabled="inputComponentDisable" v-model="data.policyHolder" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保险人" prop="insurer" >
            <el-input :disabled="inputComponentDisable" v-model="data.insurer" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="受益人" prop="beneficiary" >
            <el-input :disabled="inputComponentDisable" v-model="data.beneficiary" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保单号" prop="policyNum" >
            <el-input :disabled="inputComponentDisable" v-model="data.policyNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="赔款转让协议编号" prop="ndemnityNum" >
            <el-input :disabled="inputComponentDisable" v-model="data.ndemnityNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="data.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="信用限额" prop="creditLimit" >
            <el-input :disabled="inputComponentDisable" v-model="data.creditLimit" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="生效日期" prop="effectiveDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.effectiveDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="到期日期" prop="endDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.endDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="最低偿债比例(%)" prop="minLossRate" >
            <el-input :disabled="inputComponentDisable" v-model="data.minLossRate" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="本次担保金额" prop="guaranteeMoney" >
            <el-input :disabled="inputComponentDisable" v-model="data.guaranteeMoney" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" :loading="isLoading">{{buttonText}}</el-button>
        <el-button size="medium"  type="primary" @click="close">关闭</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import { addGuaranteeApplyTbGrtCreditsafe} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
        name: "AddCreditInsurance",
      props:{
        info:{
          type:Object,
        },
      },
      data(){
          return{
            buttonText:"保存",
            buttonDisable:false,
            isLoading:false,//按钮提交状态
            inputComponentDisable:false,
            currencyCd:enums.currencyCd,
            data:{
              userNum:"200555",
              orgNum:"0700",
              policyHolder:"",//投保人
              insurer:"",//保险人
              beneficiary:"",//受益人
              policyNum:"",//保单号
              ndemnityNum:"",//赔款转让协议编号
              currencyCd:"",//币种
              creditLimit:"",//信用限额
              effectiveDate:"",//生效日期
              endDate:"",//到期日期
              minLossRate:"",//最低偿债比例（%）
              guaranteeMoney:"",//本次担保金额
              guaranteeType:this.info.collType,//担保类型
              partyId:this.info.partyId,//客户编号
              applyId:this.info.applyId,//业务id
            },
            rules:{
              policyHolder:[
                {
                  required: true,
                  message: "请输入投保人",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                }
              ],
              beneficiary:[
                {
                  required: true,
                  message: "请输入投保人",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                }
              ],
              insurer:[
                {
                  required: true,
                  message: "请输入保险人",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                }
              ],
              policyNum:[
                {
                  required: true,
                  message: "请输入保单号",
                  trigger: 'change'
                },
                {
                  max: 40,
                  message: '长度不超过 40 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^\w+$/,
                  message: '只能是数字、字母或者下划线',
                  trigger: 'change'
                }
              ],
              ndemnityNum:[
                {
                  required: false,
                  message: "请输入信用额度",
                  trigger: 'change'
                },
                {
                  max: 40,
                  message: '长度不超过 40 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^\w+$/,
                  message: '编号只能是数字、字母或者下划线',
                  trigger: 'change'
                }
              ],
              creditLimit:[
                {
                  required: true,
                  message: "请输入信用额度",
                  trigger: 'change'
                },
                {
                  max: 20,
                  message: '长度不超过 20 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                  message: '请输入正确的金额',
                  trigger: 'change'
                }
              ],
              guaranteeMoney:[
                {
                  required: true,
                  message: "请输入担保金额",
                  trigger: 'change'
                },
                {
                  max: 20,
                  message: '长度不超过 20 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                  message: '请输入正确的金额',
                  trigger: 'change'
                }
              ],
              endDate:[
                {
                  required: true,
                  message: "请选择日期",
                  trigger: 'change'
                }
              ],
              currencyCd:[
                {
                  required: true,
                  message: "请选择币种",
                  trigger: 'change'
                }
              ],
              effectiveDate:[
                {
                  required: true,
                  message: "请选择日期",
                  trigger: 'change'
                }
              ],
              minLossRate:[
                {
                  required: true,
                  message: "请输入比例",
                  trigger: 'change'
                },
                {
                  pattern: /^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/,
                  message: '请输入0-100以内的数字,保留两位小数',
                  trigger: 'change'
                }
              ],
            },
          }
      },
      methods:{
          //日期格式 yyyy-MM-dd
        compareDate:function(startDate,endDate){
          var arys1= new Array();
          var arys2= new Array();
          arys1=startDate.split('-');
          arys2=endDate.split('-');
          var sdate=new Date(arys1[0],parseInt(arys1[1]-1),arys1[2]);
          var edate=new Date(arys2[0],parseInt(arys2[1]-1),arys2[2]);
          if(sdate>edate){
            return false;
          } else{
            return true;
          }
        },
        close:function () {
          this.$refs["validate"].resetFields();
          this.$emit('backFlag',"close");
        },
        comfirm(){
          this.$refs["validate"].validate((valid) => {
            if(valid){
              if(Number(this.data.guaranteeMoney)>Number(this.data.creditLimit)){
                this.$message({
                  message: '担保金额不能大于信用金额',
                  type: 'error'
                });
                return;
              }
              if(!this.compareDate(this.data.effectiveDate,this.data.endDate)){
                this.$message({
                  message: '生效时间不能大于结束时间',
                  type: 'error'
                });
                return;
              }
              this.buttonText="";
              this.buttonDisable=true;
              this.isLoading=true;
              this.inputComponentDisable=true;
              addGuaranteeApplyTbGrtCreditsafe(this.data).then(response =>{
                if(response.data.flag == enums.stateCode.flag.success){//
                  this.$emit('backFlag',"ok");
                  this.$message({
                    message: '数据提交成功！',
                    type: 'success'
                  });
                }else{
                  this.$message({
                    message: '操作失败!'+JSON.stringify(response.data),
                    type: 'error'
                  });
                }
                this.buttonText="提交";
                this.buttonDisable=false;
                this.isLoading=false;
                this.inputComponentDisable=false;
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

</style>
