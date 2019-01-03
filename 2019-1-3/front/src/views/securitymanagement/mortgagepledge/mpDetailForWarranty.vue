<!--详细页面  保单-->
<template>
    <div class="mp-detail-for-warranty">
      <el-row>
        <el-form el-form label-width="200px" :model="warrantyInfo" label-position="right" :rules="rules" ref="mpWarrantyDetailValidate" >
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="currency" >
              <el-select :disabled="inputComponentDisable"  v-model="warrantyInfo.currency" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in currencyOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物认定价值(元)" prop="evaluateWorth" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="warrantyInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in worthEvaluateWayOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="账面原值/取得价值(元)" prop="originalWorth" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="warrantyInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="warrantyInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>保单信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保单号" prop="warrantyNumber" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.warrantyNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保单种类" prop="warrantyType" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.warrantyType" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保单金额(元)" prop="warrantyWorth" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.warrantyWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保单到期日"  >
              <el-date-picker v-model="warrantyInfo.warrantyEndTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="购买时间"  >
              <el-date-picker v-model="warrantyInfo.buyTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="投保人" prop="applicant" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.applicant" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="第一受益人" prop="firstFavoree" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.firstFavoree" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="投保金额(元)" prop="insureWorth" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.insureWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保险公司名称" prop="insuranceCompanyName" >
              <el-input :disabled="inputComponentDisable" v-model="warrantyInfo.insuranceCompanyName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="warrantyInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmWarrantyDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-warranty",
      data(){
        return{
          warrantyInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*保单*/
            warrantyNumber:"",//保单号
            warrantyType:"",//保单种类
            warrantyWorth:"",//保单金额(元)
            warrantyEndTime:"",//保单到期日
            buyTime:"",//购买时间
            applicant:"",//投保人
            firstFavoree:"",//第一受益人
            insureWorth:"",//投保金额(元)
            insuranceCompanyName:"",//保险公司名称
            otherSituationExplain:"",//其他情况说明
          },
          rules:{
            /*价值*/
            currency: [
              {
                required: true,
                message: "请选择币种",
                trigger: 'change'
              }
            ],
            worthEvaluateWay: [
              {
                required: true,
                message: "请选择评估方式",
                trigger: 'change'
              }
            ],
            evaluateWorth: [
              {
                required: true,
                message: "请输入抵质押物认定价值",
                trigger: 'blur'},
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
            originalWorth: [
              {
                required: true,
                message: "请输入账面原值/取得价值",
                trigger: 'blur'},
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
            /*保单 rules*/
            warrantyNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            warrantyType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            warrantyWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            warrantyEndTime: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            buyTime: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            applicant: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            firstFavoree: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            insureWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            insuranceCompanyName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            otherSituationExplain: [
              {
                required: false,
                message: "请输入其他情况说明",
                trigger: 'blur'},
              {
                max: 100,
                message: '长度不超过 100 个字符',
                trigger: 'blur'
              },
            ],
          },
          buttonDisable:false,
          buttonText:"提交",
          inputComponentDisable:false,
          currencyOption:[
            {
              value: '人民币',
              label: '人民币'
            }, {
              value: '美元',
              label: '美元'
            },
          ],//币种类型选项
          worthEvaluateWayOption:[
            {
              value: '评估确定',
              label: '评估确定'
            }, {
              value: '协商确定',
              label: '协商确定'
            },
          ],//价值认定方式
          yesNotOption:[
            {
              value: '是',
              label: '是'
            }, {
              value: '否',
              label: '否'
            },
          ],//是否选择
          /*保单opt*/
        }
      },
      methods:{
        doConfirmWarrantyDetail:function () {
          this.$refs["mpWarrantyDetailValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击
              this.buttonDisable = true;
              this.buttonText = "已提交";
              this.inputComponentDisable = true;
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
          this.$refs["mpWarrantyDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-warranty{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-warranty p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
