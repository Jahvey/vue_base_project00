<template>
  <div class="biz-info">
    <el-row>
      <el-form el-form ref="updateBizInfoValidate" label-width="200px" :model="bizInfo" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="客户编号" prop="partyNum">
            <el-input  v-model="bizInfo.partyNum" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="客户名称" prop="partyName">
            <el-input  v-model="bizInfo.partyName" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="证件类型" prop="certType">
            <el-input  v-model="bizInfo.certType" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="证件号码" prop="certNum">
            <el-input  v-model="bizInfo.certNum" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="信用等级" prop="creditLevel">
            <el-input  v-model="bizInfo.creditLevel" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务品种" prop="productType">
            <el-input  v-model="bizInfo.productType" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务类型" prop="currencyCd" >
            <el-select  v-model="bizInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption"  disabled :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用信编号" prop="bizNum">
            <el-input  v-model="bizInfo.bizNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="申请额度（元）" prop="rmbAmt">
            <el-input  v-model="bizInfo.rmbAmt" disabled  style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="申请期限" prop="termNum,termUnit">
            <el-input  v-model="bizInfo.termNum" style="width: 60%; float: left"></el-input>
            <el-input  v-model="bizInfo.termUnit" style="width: 40%; float: left"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保方式" prop="guarantyType" >
            <el-checkbox-group v-model="bizInfo.guarantyType">
              <el-checkbox label="信用" value="01" name="guarantyType"></el-checkbox>
              <el-checkbox label="保证" value="04" name="guarantyType"></el-checkbox>
              <el-checkbox label="抵押" value="02" name="guarantyType"></el-checkbox>
              <el-checkbox label="质押" value="03" name="guarantyType"></el-checkbox>
              <el-checkbox label="保证金" value="05" name="guarantyType"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否银团" prop="isBankTeamLoan">
            <el-input  v-model="bizInfo.isBankTeamLoan" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务状态" prop="becomeEffectiveMark">
            <el-input  v-model="bizInfo.becomeEffectiveMark" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item prop="busiPartner" label="是否有按揭合作商">
            <el-select clearable v-model="bizInfo.busiPartner" >
              <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item prop="whetherBzxzfdk" label="是否个人购买保障性住房">
            <el-select clearable v-model="bizInfo.whetherBzxzfdk" >
              <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="经办机构" prop="orgNum">
            <el-input  v-model="bizInfo.orgNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="经办人" prop="userNum">
            <el-input  v-model="bizInfo.userNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="申请日期" prop="applyDate">
            <el-input v-model="natural.applyDate" ></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="12">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmBizApply">{{buttonText}}</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import enums from "@/utils/enums"
  import commonUtil from '@/utils/commonUtil'
  import { bizApply } from '@/api/csm'
  export default {
    name: "biz-info",
    props:{
      bizInfo:Object,
      natural:Object
    },
    data(){
      return{
        yesOrNoOpts: enums.yesOrNo,//是否
        currencyOption:enums.currencyCd,//币种类型选项
        rules:{
          productType: [
            {
              required: true,
              message: "请选择业务品种",
              trigger: 'change'
            }
          ],
          guarantyType: [
            { type: 'array', required: true, message: '请至少选择一个担保方式', trigger: 'change' }
          ],
          insuranceCompanyName: [
            {
              required: true,
              message: "请输入保险机构",
              trigger: 'change'
            }
          ],
          insurancePolicyNum: [
            {
              required: true,
              message: "请输入保险单编号",
              trigger: 'change'
            }
          ],
          insuranceType: [
            {
              required: true,
              message: "请输入保险险种",
              trigger: 'change'
            }
          ],
          policyHolder: [
            {
              required: true,
              message: "请输入投保人",
              trigger: 'change'
            }
          ],
          insuranceBenefitiary: [
            {
              required: true,
              message: "第一受益人",
              trigger: 'change'
            }
          ],
          currencyCd: [
            {
              required: true,
              message: "请选择币种",
              trigger: 'change'
            }
          ],
          insuranceAmt: [
            {
              required: true,
              message: "请输入投保金额",
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
          startDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          endDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          effectiveDate:[
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
      doConfirmBizApply:function () {
        this.$refs["updateBizInfoValidate"].validate((valid) => {
          if(valid){
            //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
            this.buttonDisable = true;
            this.buttonText = "提交中";
            bizApply(this.bizInfo).then(res => {
              if(res && res.data && res.data.code == 200){//返回数据成功
                //提示父组件关闭dialog,并且刷新，重置当前表单
                this.$refs["updateBizInfoValidate"].resetFields();
                this.$emit('backFlag',"ok");
                this.$message({
                  message: '数据提交成功！',
                  type: 'success'
                });
              } else{
                this.$message({message: '业务申请失败, 错误信息：' + res, type: 'error'})
                console.error('重算额度失败, 错误信息：' + res)
              }
              this.buttonDisable = false;
              this.buttonText = "确定";
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
        this.$refs["updateBizInfoValidate"].resetFields();
      },
    },
  }
</script>
