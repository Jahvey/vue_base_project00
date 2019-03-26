<!--编辑、查看保证金-->
<template>
  <div>
    <el-row>
      <el-form el-form label-width="120px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="12">
          <el-form-item label="账户名称" prop="acctName">
            <el-input :disabled="inputComponentDisable" v-model="data.acctName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保证金账号" prop="marginAccount">
            <el-input :disabled="inputComponentDisable" v-model="data.marginAccount"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保证金类型" prop="marginSort" >
            <el-select :disabled="inputComponentDisable"  v-model="data.marginSort" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in marginSortCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="开户行" prop="openBank">
            <el-input :disabled="inputComponentDisable" v-model="data.openBank"></el-input>
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
          <el-form-item label="保证金金额" prop="accBalance">
            <el-input :disabled="inputComponentDisable" v-model="data.accBalance"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="起始日期" prop="beginDate" >
            <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.beginDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="到期日期" prop="endDate" >
            <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.endDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="12" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" :loading="isLoading">{{buttonText}}</el-button>
        <el-button size="medium"  type="primary" @click="close">关闭</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import { selectDepositBySuretyKeyId,updateDeposit} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
      name: "EditDeposit",
      props:{
        info:{
          type:Object,
        },
      },
      beforeMount(){
        //回显数据
        this.buttonDisable = true;
        this.buttonText = "";
        this.isLoading = true;
        if(this.info.isScan){
          this.inputComponentDisable = true;
          this.buttonDisable = true;
          this.buttonText = "保存";
          this.isLoading = false;
        }
        selectDepositBySuretyKeyId(this.info).then(response=>{
          if(response.data.flag == enums.stateCode.flag.success) {//返回数据成功
            this.data.suretyKeyId = response.data.cashDepositBean.suretyKeyId;
            this.data.suretyId = response.data.cashDepositBean.suretyId;
            this.data.relationId = response.data.cashDepositBean.relationId;
            this.data.acctName = response.data.cashDepositBean.acctName;
            this.data.marginAccount = response.data.cashDepositBean.marginAccount;
            this.data.marginSort = response.data.cashDepositBean.marginSort;
            this.data.openBank = response.data.cashDepositBean.openBank;
            this.data.currencyCd = response.data.cashDepositBean.currencyCd;
            this.data.accBalance = response.data.cashDepositBean.accBalance;
            this.data.beginDate = response.data.cashDepositBean.beginDate;
            this.data.endDate = response.data.cashDepositBean.endDate;
            this.data.marginRate = response.data.cashDepositBean.marginRate;
            this.data.appendFlag = response.data.cashDepositBean.appendFlag;
            this.buttonDisable = false;
            this.buttonText = "保存";
            this.isLoading = false;
          }else{
            this.$message({
              message: '获取数据失败啦！'+JSON.stringify(response.data),
              type: 'error'
            });
          }
          if(this.info.isScan){
            this.buttonDisable = true;
            this.buttonText = "保存";
            this.isLoading = false;
            this.inputComponentDisable = true;
          }
        });
      },
      data(){
        return{
          /*按钮数据*/
          buttonText:"保存",
          buttonDisable:false,
          isLoading:false,//按钮提交状态
          inputComponentDisable:false,
          marginSortCd:enums.marginSortCd,
          currencyCd:enums.currencyCd,
          data:{
            suretyKeyId:"",//
            suretyId:"",//
            relationId:"",//
            applyId:this.info.applyId,//业务id
            partyId:this.info.partyId,//客户id
            collType:"03",//担保类型，00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
            userNum:"200555",
            orgNum:"0700",
            acctName:"",//账户名称
            marginAccount:"",//保证金账号
            marginSort:"",//保证金类型
            openBank:"",//开户行
            currencyCd:"",//币种
            accBalance:"",//保证金金额
            beginDate:"",//起始日期
            endDate:"",//到期日期
            /*以下普元是隐藏*/
            marginRate:"",//执行利率
            appendFlag:"",//追加标志
          },
          rules:{
            acctName:[
              {
                required: true,
                message: "账户名称不能为空",
                trigger: 'change'
              },
              {
                max: 20,
                message: '长度不超过 20 个字符',
                trigger: 'change'
              },
            ],
            openBank:[
              {
                required: true,
                message: "开户行不能为空",
                trigger: 'change'
              },
              {
                max: 30,
                message: '长度不超过 30 个字符',
                trigger: 'change'
              },
            ],
            marginSort:[
              {
                required: true,
                message: "请选择保证金类型",
                trigger: 'change'
              }
            ],
            beginDate:[
              {
                required: true,
                message: "请选择开始日期",
                trigger: 'change'
              }
            ],
            endDate:[
              {
                required: true,
                message: "请选择到期日期",
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
            marginAccount:[
              {
                required: true,
                message: "保证金账号不能为空",
                trigger: 'change'
              },
              {
                max: 40,
                message: '长度不超过 40 个字符',
                trigger: 'change'
              },
              {
                pattern: /^[0-9]*$/,
                message: '账号只能为数字',
                trigger: 'change'
              }
            ],
            accBalance:[
              {
                required: true,
                message: "保证金金额不能为空",
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
        comfirm(){
          this.$refs["validate"].validate((valid) => {
            if(valid){
              this.buttonDisable = true;
              this.buttonText = "";
              this.isLoading = true;
              updateDeposit(this.data).then(response => {
                if(response.data.flag == enums.stateCode.flag.success) {//返回数据成功
                  var obj={};
                  obj.flag='ok';
                  this.$emit('backFlag',obj);
                  this.$message({
                    message: '数据提交成功！',
                    type: 'success'
                  });
                }else{
                  this.$message({
                    message: '获取数据失败啦！'+JSON.stringify(response.data),
                    type: 'error'
                  });
                  this.buttonDisable = false;
                  this.buttonText = "提交";
                  this.isLoading = false;
                }
              });
            } else{
              this.$message({
                message: '请将信息填写完整',
                type: 'error'
              });
            }
          });
        },
        close:function () {
          this.$refs["validate"].resetFields();
          var obj={};
          obj.flag='close';
          this.$emit('backFlag',obj);
        }
      },
    }
</script>

<style scoped>

</style>
