<!--当保证合同为最高额时，需要填写本次担保金额-->
<template>
  <el-container>
    <el-main>
      <el-row>
        <el-form el-form label-width="200px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
          <el-col :span="24">
            <el-form-item label="业务申请担保金额(元)" prop="suretyAmt1" >
              <el-input :disabled="inputComponentDisable2" v-model="data.suretyAmt1" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="业务申请可用金额(元)" prop="usableGuaranteeLimit" >
              <el-input :disabled="inputComponentDisable2" v-model="data.usableGuaranteeLimit" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="担保确认金额(元)" prop="suretyAmt" >
              <el-input :disabled="inputComponentDisable" v-model="data.suretyAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="12" :offset="9">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="confirm" :loading="isLoading">{{buttonText}}</el-button>
          <el-button size="medium"  type="primary" @click="close">关闭</el-button>
        </el-col>
      </el-row>
    </el-footer>
  </el-container>
</template>

<script>
  import enums from "@/utils/enums"
  import { getSubConBzr,insertSubGrtRel2} from '@/api/contractsign'
    export default {
        name: "add-confirm-guarantor",
      props:{
        info:{
          type:Object,
        },
      },
      beforeMount(){
        this.buttonDisable=true;
        this.buttonText="";
        this.isLoading=true;
        getSubConBzr(this.info).then(response => {
          if(response.data.code == enums.stateCode.code.success){
            this.buttonDisable=false;
            this.buttonText="保存";
            this.isLoading=false;
            this.data.suretyAmt1=response.data.suretyAmt;
            this.data.usableGuaranteeLimit=response.data.usableGuaranteeLimit;
          } else{
            this.$message({
              message: JSON.stringify(response.data),
              type: 'error'
            });
          }
        });
      },
      data(){
        return{
          buttonText:"保存",
          buttonDisable:false,
          isLoading:false,//按钮提交状态
          inputComponentDisable:false,
          inputComponentDisable2:true,
          data:{
            suretyAmt1:"",//业务申请担保金额(元)
            usableGuaranteeLimit:"",//业务申请可用金额(元)
            suretyAmt:"",//担保确认金额(元)
          },
          rules:{
            suretyAmt1:[
              {
                required: true,
                message: "请输入业务申请担保金额",
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
            usableGuaranteeLimit:[
              {
                required: true,
                message: "请输入业务申请可用金额",
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
            suretyAmt:[
              {
                required: true,
                message: "请输入担保确认金额",
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
          },
        }
      },
      methods:{
        confirm(){
          this.$refs["validate"].validate((valid) => {
            if(valid){
              if(Number(this.data.suretyAmt)>Number(this.data.usableGuaranteeLimit)){
                this.$message({
                  message: '担保确认金额不能大于业务申请可用金额',
                  type: 'error'
                });
                return;
              }
              this.buttonText="";
              this.isLoading=true;
              this.buttonDisable=true;
              var saveObj = {};
              saveObj.suretyAmt=this.data.suretyAmt;
              saveObj.suretyId=this.info.suretyId;
              saveObj.contractId=this.info.contractId;
              saveObj.subcontractId=this.info.subcontractId;
              insertSubGrtRel2(saveObj).then(response=>{
                if(response.data.code == enums.stateCode.code.success) {//保存成功
                  this.$message({
                    message: '保存成功',
                    type: 'success'
                  });
                  var obj={};
                  obj.flag='ok';
                  this.$emit('backFlag',obj);
                } else{
                  this.$message({
                    message: JSON.stringify(response.data),
                    type: 'error'
                  });
                }
                this.buttonText="保存";
                this.isLoading=false;
                this.buttonDisable=false;
              });
            } else{
              this.$message({
                message: '请将信息填写完整',
                type: 'error'
              });
            }
          });
        },
        close(){
          var obj={};
          obj.flag='close';
          this.$emit('backFlag',obj);
        }
      }
    }
</script>

<style scoped>

</style>
