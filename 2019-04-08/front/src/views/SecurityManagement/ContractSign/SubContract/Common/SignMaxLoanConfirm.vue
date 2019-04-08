<!--当保存为最高额担保合同时，需要填写本次担保金额-->
<template>
  <el-container>
    <el-main>
      <el-row>
        <el-form el-form label-width="200px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
          <el-col :span="24">
            <el-form-item label="合同可用金额(元)" prop="aviAmt" >
              <el-input :disabled="inputComponentDisable2" v-model="data.aviAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="本次担保金额(元)" prop="suretyAmt" >
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
  import { getSubCon,updateConsubRel} from '@/api/contractsign'
    export default {
        name: "SignMaxLoanConfirm",
      props:{
        info:{
          type:Object,
        },
      },
      beforeMount(){
        var obj={};
        obj.subcontractId=this.info.subcontractId;
        obj.conSubconId=this.info.conSubconId;
        getSubCon(obj).then(response=>{
          if(response.data.code == enums.stateCode.code.success){//返回数据成功
            this.data.aviAmt = response.data.subcontractPo.zgbjxe.toString();
            if(response.data.subconRel.suretyAmt!=null && response.data.subconRel.suretyAmt!=undefined && response.data.subconRel.suretyAmt!=''){
              this.data.suretyAmt = response.data.subconRel.suretyAmt.toString();
            } else{
              this.data.suretyAmt = '0';
            }

          } else{
            this.$message({
              message: '获取数据失败啦！',
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
            aviAmt:"",//合同可用金额
            suretyAmt:"",//本次担保金额
          },
          rules:{
            aviAmt:[
              {
                required: true,
                message: "请输入合同可用金额",
                trigger: 'change'
              },
              {
                max: 9,
                message: '长度不超过 9 个字符',
                trigger: 'change'
              },
              /*              {
                              pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                              message: '请输入正确的金额',
                              trigger: 'change'
                            }*/
            ],
            suretyAmt:[
              {
                required: true,
                message: "请输入本次担保金额",
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
              if(Number(this.data.suretyAmt)>Number(this.data.aviAmt)){
                this.$message({
                  message: '本次担保金额不能大于合同可用金额',
                  type: 'error'
                });
                return;
              }
              this.buttonText="";
              this.isLoading=true;
              this.buttonDisable=true;
              var saveData={};
              saveData.conSubconId=this.info.conSubconId;
              saveData.suretyAmt=this.data.suretyAmt;
              updateConsubRel(saveData).then(response=>{
                if(response.data.code == enums.stateCode.code.success) {//保存成功
                  this.$message({
                    message: '保存成功',
                    type: 'success'
                  });
                  var obj={};
                  obj.flag='close';
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
