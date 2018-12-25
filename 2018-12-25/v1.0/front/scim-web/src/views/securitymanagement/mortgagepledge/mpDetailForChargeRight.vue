<!--详细信息  收费权-->
<template>
    <div class="mp-detail-for-charge-right">
        <el-row>
          <el-form el-form label-width="170px" :model="chargeRightInfo" label-position="right" :rules="rules" ref="mpChargeRightDetailValidate" >
            <el-col :span="24">
              <p>价值信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="币种" prop="customerType" >
                <el-select :disabled="inputComponentDisable"  v-model="chargeRightInfo.currency" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.evaluateWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定方式" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="chargeRightInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.originalWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定时间"  >
                <el-date-picker v-model="chargeRightInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定到期日"  >
                <el-date-picker v-model="chargeRightInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>收费权信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费项目" prop="project" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.project" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费标准" prop="standard" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.standard" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费权质押批文单位" prop="office" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.office" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费批准文件全称" prop="officialName" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.officialName" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费批准文件编号" prop="serialNumber" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.serialNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费还贷比例" prop="ratio" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.ratio" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费权现金流分析" prop="analyze" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.analyze" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="收费许可证编号" prop="permissionNumber" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.permissionNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="归集账号" prop="account" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.account" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="开户行全称" prop="bankName" >
                <el-input :disabled="inputComponentDisable" v-model="chargeRightInfo.bankName" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24" >
              <el-form-item label="其他情况说明" prop="otherSituationExplain" >
                <el-input :disabled="inputComponentDisable" type="textarea" v-model="chargeRightInfo.otherSituationExplain" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmChargeRightDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-charge-right",
      data(){
        return{
          chargeRightInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*收费权信息*/
            project:"",//收费项目
            standard:"",//收费标准
            office:"",//收费权质押批文单位
            officialName:"",//收费批准文件全称
            serialNumber:"",//收费批准文件编号
            ratio:"",//收费还款比例
            analyze:"",//收费权现金流分析
            permissionNumber:"",//收费许可证编号
            account:"",//归集账号
            bankName:"",//开户银行全称
            otherSituationExplain:"",//其他情况说明
          },
          rules:{
            project: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            standard: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            office: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            officialName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            serialNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ratio: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            account: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            bankName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            otherSituationExplain: [
              {
                required: false,
                message: "请输入其他说明",
                trigger: 'blur'},
              {
                max: 100,
                message: '长度不超过 100 个字符',
                trigger: 'blur'
              },
            ],
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
        }
      },
      methods:{
        doConfirmChargeRightDetail:function () {
          this.$refs["mpChargeRightDetailValidate"].validate((valid) => {
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
          this.$refs["mpChargeRightDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-charge-right{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-charge-right p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
