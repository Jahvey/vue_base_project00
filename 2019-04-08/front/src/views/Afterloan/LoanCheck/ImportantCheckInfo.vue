<template>
    <div>
      <el-form  :model="ruleForm" ref="ruleForm" :rules="rules" class="demo-form-inline"  label-width="230px" size="mini"  label-position="left ">
        <div>
          <div>
            <el-row :gutter="20" class="form">
              <p class="m1">基本信息</p>
              <div class="m2" style="margin-bottom:15px"></div>
              <el-col :span="12">
                <el-form-item label="机构名称：" prop="orgNum" hide-required-asterisk="true">
                  <el-input v-model="ruleForm.orgNum"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="客户名称：" prop="partyName">
                  <el-input  v-model="ruleForm.partyName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="合同编号：" prop="contractNum">
                  <el-input  v-model="ruleForm.contractNum"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="合同金额：" prop="contractAmt">
                  <el-input  v-model="ruleForm.contractAmt"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="合同已用金额：" prop="conYuE" hide-required-asterisk="true">
                  <el-input v-model="ruleForm.conYuE"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="合同起期：" prop="beginDate">
                  <el-input  v-model="ruleForm.beginDate"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="合同止期：" prop="endDate">
                  <el-input  v-model="ruleForm.endDate"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="业务品种：" prop="productType">
                  <el-input  v-model="ruleForm.productType"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="逾期本金：" prop="YQBJ" hide-required-asterisk="true">
                  <el-input v-model="ruleForm.YQBJ"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="欠息合计：" prop="QXHJ">
                  <el-input  v-model="ruleForm.QXHJ"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="分类：" prop="FXFL">
                  <el-input  v-model="ruleForm.FXFL"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20" class="form">
              <p class="m1"> 检查信息</p>
              <div class="m2" style="margin-bottom:15px"></div>
              <el-col :span="12">
                <el-form-item label="问题描述：" prop="problemDes">
                  <el-input type="textarea" v-model="ruleForm.problemDes"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </div>
          <div>
            <el-row :gutter="20" class="form">
              <p class="m1">处置进度</p>
              <div class="m2" style="margin-bottom:15px"></div>
              <el-col :span="12">
                <el-form-item label="催收情况：" prop="collectCondition">
                  <el-input type="textarea" v-model="ruleForm.collectCondition"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="诉讼情况：" prop="legalCondition">
                  <el-input type="textarea" v-model="ruleForm.legalCondition"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="其他情况 ：" prop="otherCondition">
                  <el-input type="textarea" v-model="ruleForm.otherCondition"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="经营行负责人：" prop="bankLeader">
                  <el-input  v-model="ruleForm.bankLeader"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="化解工作负责人：" prop="workLeader">
                  <el-input  v-model="ruleForm.workLeader"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="总行负责人：" prop="headLeader">
                  <el-input  v-model="ruleForm.headLeader"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="是否新增：" prop="isNewadd">
                  <el-select v-model="ruleForm.isNewadd" placeholder="--请选择--">
                    <el-option label="是" value="0"></el-option>
                    <el-option label="否" value="1"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </div>
            <el-row class="m4">
              <el-button type="primary" @click="submitForm('ruleForm')">保    存</el-button>
              <el-button type="primary">临时保存</el-button>
              <el-button type="primary">下载打印</el-button>
            </el-row>
        </div>
      </el-form>
    </div>
</template>

<script>
    export default {
        name: "ImportantCheckInfo",
        props:{
          paramToCheckInfo:{

          },
        },
        data(){
            return{
              ruleForm: {
                orgNum:this.paramToCheckInfo.orgNum,
                partyName:this.paramToCheckInfo.partyName,
                contractNum:this.paramToCheckInfo.contractNum,
                contractAmt:this.paramToCheckInfo.contractAmt,
                conYuE:this.paramToCheckInfo.conYuE,
                beginDate:this.paramToCheckInfo.beginDate,
                endDate:this.paramToCheckInfo.endDate,
                productType:this.paramToCheckInfo.productType,
                YQBJ:this.paramToCheckInfo.YQBJ,
                QXHJ:this.paramToCheckInfo.QXHJ,
                FXFL:this.paramToCheckInfo.FXFL,
                problemDes:'',
                collectCondition:'',
                legalCondition:'',
                otherCondition:'',
                bankLeader:'',
                workLeader:'',
                headLeader:'',
                isNewadd:'',
              },
              rules: {//表单校验
                problemDes: [
                  { required: true, message: '问题描述不能为空！ ', trigger: 'blur' }
                ],
                bankLeader: [
                  { required: true, message: '请输入经营行负责人！ ', trigger: 'blur' }
                ],
                workLeader: [
                  { required: true, message: '请输入化解工作负责人！ ', trigger: 'blur' }
                ],
                isNewadd:[
                  {required: true, message: '请至少选择一个选项', trigger: 'change' }
                ]
              },


            }
        },
      created() {
        console.log("接受数据成功！[paramToCheckInfo]"+JSON.stringify(this.paramToCheckInfo))
        /*let param = this.$route.params
        console.log(param)
        this.queryBorList(param)*/
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
  /*.m3{
    margin-bottom: 25px;
  }*/
  .m4{
    text-align: right !important;
  }
</style>
