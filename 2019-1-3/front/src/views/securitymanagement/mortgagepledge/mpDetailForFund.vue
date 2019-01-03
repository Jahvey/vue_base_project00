<!--详细信息  基金-->
<template>
    <div class="mp-detail-for-fund">
      <el-row>
        <el-form el-form label-width="200px" :model="fundInfo" label-position="right" :rules="rules" ref="mpFundDetailValidate" >
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="currency" >
              <el-select :disabled="inputComponentDisable"  v-model="fundInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="fundInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="fundInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="fundInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>基金信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="基金性质" prop="foundNature" >
              <el-select :disabled="inputComponentDisable"  v-model="fundInfo.foundNature" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in foundNatureOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="基金登记机构" prop="foundRegisterOrg" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.foundRegisterOrg" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="数量(股)" prop="foundNumber" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.foundNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="控股份额" prop="haveFoundNumber" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.haveFoundNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="每股净资产(元)" prop="everyFoundWorth" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.everyFoundWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="fCurrency" >
              <el-select :disabled="inputComponentDisable"  v-model="fundInfo.fCurrency" placeholder="请选择" style="width:100%">
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
            <el-form-item label="基金是否上市" prop="ifListed" >
              <el-select :disabled="inputComponentDisable"  v-model="fundInfo.ifListed" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in yesNotOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="基金名称" prop="foundName" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.foundName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市公司名称" prop="listCompanyName" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.listCompanyName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发行方式" prop="issueWay" >
              <el-select :disabled="inputComponentDisable"  v-model="fundInfo.issueWay" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in issueWayOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市地点" prop="listedPlace" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.listedPlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="上市公司类型" prop="listedCompanyType" >
              <el-select :disabled="inputComponentDisable"  v-model="fundInfo.listedCompanyType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in listedCompanyTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市公司经营情况" prop="companySituation" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.companySituation" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="最近一个交易日市价(元)" prop="latestDealMarketWorth" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.latestDealMarketWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="每股最近一年均价(元)" prop="everySrLatestAverageWorth" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.everySrLatestAverageWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>基金基本信息</p>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="基金代码" prop="foundCode" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.foundCode" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="基金公司名称" prop="foundCompanyName" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.foundCompanyName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="基金类型" prop="foundType" >
              <el-select :disabled="inputComponentDisable"  v-model="fundInfo.foundType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in foundTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="股东代码" prop="shareHolderCode" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.shareHolderCode" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="卷商席位代码" prop="jsxwCode" >
              <el-input :disabled="inputComponentDisable" v-model="fundInfo.jsxwCode" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="fundInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmFundDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-fund",
      data(){
        return{
          fundInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*基金*/
            foundNature:"法人股",//基金性质
            foundRegisterOrg:"",//基金登记机构
            foundNumber:"",//数量(股)
            haveFoundNumber:"",//控股份额
            everyFoundWorth:"",//每股净资产(元)
            fCurrency:"人民币",//币种
            ifListed:"是",//基金是否上市
            foundName:"",//基金名称
            listCompanyName:"",//上市公司名称
            issueWay:"A股",//发行方式
            listedPlace:"",//上市地点
            listedCompanyType:"企业类",//上市公司类型
            companySituation:"",//上市公司经营情况
            latestDealMarketWorth:"",//最近一个交易日市价(元)
            everySrLatestAverageWorth:"",//每股最近一年均价(元)
            /*基金基本信息*/
            foundCode:"",//基金代码
            foundCompanyName:"",//基金公司名称
            foundType:"开放式",//基金类型
            shareHolderCode:"",//股东代码
            jsxwCode:"",//卷商席位代码
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
            /*基金 rules*/
            foundNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            haveFoundNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            everyFoundWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            fCurrency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifListed: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            foundName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            listCompanyName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            issueWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            listedPlace: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            listedCompanyType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            foundNature: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            foundRegisterOrg: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            companySituation: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            latestDealMarketWorth: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            everySrLatestAverageWorth: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            /*基金基本信息 rules*/
            foundCode: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            foundCompanyName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            foundType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            shareHolderCode: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            jsxwCode: [
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
          /*基金opt*/
          foundNatureOpt:[
            {
              value: '法人股',
              label: '法人股'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          listedCompanyTypeOpt:[
            {
              value: '企业类',
              label: '企业类'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          issueWayOpt:[
            {
              value: 'A股',
              label: 'A股'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          /*基金基本信息 opt*/
          foundTypeOpt:[
            {
              value: 'A股',
              label: 'A股'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
        }
      },
      methods:{
        doConfirmFundDetail:function () {
          this.$refs["mpFundDetailValidate"].validate((valid) => {
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
          this.$refs["mpFundDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-fund{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-fund p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
