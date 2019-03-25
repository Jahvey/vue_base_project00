<!--填写押品信息 在关联抵押品信息时，需要确认担保金额信息，与业务申请时的担保金额可以不一样-->
<template>
  <el-container>
    <el-main>
      <el-row>
        <el-form el-form label-width="200px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
          <el-col :span="24">
            <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
              <el-input :disabled="inputComponentDisable2" v-model="data.marketValue" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="可用抵质押物价值(元)" prop="ableValue" >
              <el-input :disabled="inputComponentDisable2" v-model="data.ableValue" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="抵质押品占用价值(元)" prop="mortgageValue" >
              <el-input :disabled="inputComponentDisable" v-model="data.mortgageValue" style="width:100%"></el-input>
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
  import { getSubConAndMortgage,insertSubGrtRel} from '@/api/contractsign'
  import enums from "@/utils/enums"
    export default {
      name: "apply-confirm-m-p",
      props:{
        info:{
          type:Object,
        },
      },
      beforeMount(){
        //TODO 查询当前担保合同合同类型，若是最高额担保合同还要特殊处理。权利价值和可用权利价值 对应新疆表的市场价值，市场价值-已担保金额
        // TODO 普元的逻辑是查询该合同和押品信息，若为最高额:（1）比较担保合同ZGBJXE与押品MORTGAGE_VALUE，仅仅是提醒二者不相等；（2）将本页面的suretyAmt设置为押品的AVI_AMT可用担保金额
        //需要参数 subcontractId suretyId applyId已经从父页面传递过来
/*        getSubConAndMortgage(this.info).then(response =>{
          if(response.data.code == enums.stateCode.code.success){//返回数据成功
            this.data.marketValue= response.data.mortgage.MARKET_VALUE.toString();
            this.data.ableValue= response.data.mortgage.ABLE_VALUE.toString();
          } else{
            this.$message({
              message: '获取数据失败啦！',
              type: 'error'
            });
          }
        });*/
        this.data.marketValue = this.info.marketValue;
        this.data.ableValue = this.info.ableValue;
        this.data.suretyId = this.info.suretyId;
        this.data.grtStatus = this.info.grtStatus;
        this.data.partyId = this.info.partyId;
        this.data.applyMortgageValue = this.info.applyMortgageValue;
        this.data.subcontractId = this.info.subcontractId;
        this.data.contractId=this.info.contractId;
      },
      data(){
          return{
            buttonText:"保存",
            buttonDisable:false,
            isLoading:false,//按钮提交状态
            inputComponentDisable:false,
            inputComponentDisable2:true,
            data:{
              marketValue:"",//抵质押物认定价值
              ableValue:"",//可用抵质押物价值
              mortgageValue:"",//抵质押品占用价值
              suretyAmt:"",//担保确认金额
            },
            rules:{
              marketValue:[
                {
                  required: true,
                  message: "请输入抵质押物认定价值",
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
              ableValue:[
                {
                  required: true,
                  message: "请输入可用抵质押物价值",
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
              mortgageValue:[
                {
                  required: true,
                  message: "请输入抵质押品占用价值",
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
              if(Number(this.data.suretyAmt)>Number(this.data.mortgageValue)){
                this.$message({
                  message: '担保确认金额不能大于抵质押品占用价值',
                  type: 'error'
                });
                return;
              }
              if(Number(this.data.suretyAmt) / Number(this.data.mortgageValue) >= 0.9){
                this.$message({
                  message: '抵质押率不能超过90%',
                  type: 'error'
                });
                return;
              }
              this.buttonText="";
              this.isLoading=true;
              this.buttonDisable=true;
              insertSubGrtRel(this.data).then(response=>{
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
