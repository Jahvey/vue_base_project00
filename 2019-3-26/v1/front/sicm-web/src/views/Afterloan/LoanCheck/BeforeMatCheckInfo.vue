<template>
    <div>
      <el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">
        <div>
          <el-row :gutter="20" class="form">
            <p class="m1">基本信息</p>
            <div class="m2" style="margin-bottom:15px"></div>
            <el-col :span="12">
              <el-form-item label="客户编号：" prop="partyNum" hide-required-asterisk="true">
                <el-input v-model="ruleForm.partyNum"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="客户名称：" prop="partyName">
                <el-input  v-model="ruleForm.partyName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="业务品种：" prop="productType">
                <el-input  v-model="ruleForm.productType"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="借据编号：" prop="summaryNum">
                <el-input  v-model="ruleForm.summaryNum"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="借据金额：" prop="summaryAmt" hide-required-asterisk="true">
                <el-input v-model="ruleForm.summaryAmt"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="借据余额：" prop="jjye">
                <el-input  v-model="ruleForm.jjye"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="借据起期：" prop="beginDate">
                <el-input  v-model="ruleForm.beginDate"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="借据止期：" prop="endDate">
                <el-input  v-model="ruleForm.endDate"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否存在影响按时归还我行贷款资金的因素：" prop="isRisk">
                <el-select v-model="ruleForm.isRisk" placeholder="--请选择--">
                  <el-option label="是" value="1"></el-option>
                  <el-option label="否" value="0"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="管户客户经理：" prop="userNum">
                <el-input  v-model="ruleForm.userNum"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="经营行负责人：" prop="OPERATORNAME">
                <el-input  v-model="ruleForm.OPERATORNAME"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
      </el-form>
      <el-row class="m4">
        <el-button type="primary" @click="submitForm('ruleForm')">保    存</el-button>
        <el-button type="primary">临时保存</el-button>
        <el-button type="primary">下载打印</el-button>
      </el-row>
    </div>
</template>

<script>
    import enums from "@/utils/enums"
    export default {
        name: "BeforeMatCheckInfo",
        props:{//接收父页面传来的参数
          paramToCheckInfo:{
          },
        },
      data(){
        return{
          ruleForm: {
            partyNum:this.paramToCheckInfo.partyNum,
            partyName:this.paramToCheckInfo.partyName,
            productType:this.paramToCheckInfo.productType,
            summaryNum:this.paramToCheckInfo.summaryNum,
            summaryAmt:this.paramToCheckInfo.summaryAmt,
            beginDate:this.paramToCheckInfo.beginDate,
            endDate:this.paramToCheckInfo.endDate,
            jjye:this.paramToCheckInfo.jjye,
            isRisk:this.paramToCheckInfo.isRisk,
            userNum:'李谭荔',
            OPERATORNAME:'羊江',
          },
          productType: enums.productType,
          rules: {//表单校验
            isRisk:[
              {required: true, message: '请至少选择一个选项', trigger: 'change' }
            ]
          },
        }
      },
      components: {enums},
      created() {
        console.log("接受数据成功！[paramToCheckInfo]"+JSON.stringify(this.paramToCheckInfo))
      },
      methods: {

        submitForm(ruleForm) {
          this.$refs[ruleForm].validate((valid) => {
            if (valid) {
              alert('确认提交吗？');
            } else {
              alert('请将信息填写完整！');
              console.log('error submit!!');
              return false;
            }
          });
        },


      }
    }
</script>

<style scoped>
  .m1{
    text-align: left !important;
    font-size: 16px;
    font-weight: bold;
    margin-bottom: 5px;
    margin-left: 15px;
  }
  .m2{
    border-top:solid 1px #A9A3A5;
    height: 1px !important;
    margin-top: 2px;
    margin-left: 10px;
  }
  .demo-form-inline{
    margin-left: 20px;
  }
 /* .m3{
    margin-bottom: 25px;
  }*/
  .m4{
    text-align: right !important;
  }
</style>
