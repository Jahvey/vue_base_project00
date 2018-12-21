<!--详细信息  股权-->
<template>
    <div class="mp-detail-for-stock-right">
      <el-row>
        <el-form el-form label-width="200px" :model="stockRightInfo" label-position="right" :rules="rules" ref="mpStockRightDetailValidate" >
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="currency" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="stockRightInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="stockRightInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="stockRightInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>股权信息</p>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="股权登记机构" prop="registerConstitution" >
              <el-input :disabled="inputComponentDisable"  v-model="stockRightInfo.registerConstitution" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="股权登记通知书编号" prop="certifyNumber" >
              <el-input :disabled="inputComponentDisable"  v-model="stockRightInfo.certifyNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="持股份额%" prop="havePercent" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.havePercent" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="数量(股)" prop="haveNumber" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.haveNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="每股净资产(元)" prop="everyWorth" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.everyWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="srCurrency" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.srCurrency" placeholder="请选择" style="width:100%">
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
            <el-form-item label="股权性质" prop="stockRightNature" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.stockRightNature" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in stockRightNatureOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="被控股公司" prop="srCompany" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.srCompany" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="被控股公司类别" prop="srPassivityCompanyType" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.srPassivityCompanyType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in srCompanyTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="被控股公司主营业务" prop="scCompanyBusiness" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.scCompanyBusiness" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="stockRightInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="股权是否上市" prop="ifSrListed" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.ifSrListed" placeholder="请选择" style="width:100%">
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
            <el-form-item label="股权名称" prop="srName" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.srName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市公司名称" prop="srCompanyName" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.srCompanyName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发行方式" prop="srCompanyIssueWay" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.srCompanyIssueWay" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in srCompanyIssueWayOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市地点" prop="srListedPlace" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.srListedPlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="上市公司类型" prop="srCompanyType" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.srCompanyType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in srCompanyTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="最近一个交易日市价(元)" prop="latestDealMarketWorth" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.latestDealMarketWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="每股最近一年均价(元)" prop="everySrLatestAverageWorth" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.everySrLatestAverageWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市公司经营情况" prop="companySituation" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.companySituation" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmStockRightDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-stock-right",
      data(){
        return{
          stockRightInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*股权*/
            registerConstitution:"",//股权登记机构
            certifyNumber:"",//股权登记通知书编号
            havePercent:"",//持股份额%
            haveNumber:"",//数量(股)
            everyWorth:"",//每股净资产(元)
            srCurrency:"",//币种
            stockRightNature:"法人股",//股权性质
            srCompany:"",//被控股公司
            srPassivityCompanyType:"企业类",//被控股公司类别
            scCompanyBusiness:"",//被控股公司主营业务
            otherSituationExplain:"",//其他情况说明

            ifSrListed:"是",//股权是否上市
            srName:"",//股权名称
            srCompanyName:"",//上市公司名称
            srCompanyIssueWay:"",//发行方式
            srListedPlace:"",//上市地点
            srCompanyType:"企业类",//上市公司类型
            latestDealMarketWorth:"",//最近一个交易日市价(元)
            everySrLatestAverageWorth:"",//每股最近一年均价(元)
            companySituation:"",//上市公司经营情况

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
            /*股权 rules*/
            ifSrListed: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            srName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            srCompanyName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            srCompanyIssueWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            srListedPlace: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            srCompanyType: [
              {
                required: true,
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
            companySituation: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            registerConstitution: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            certifyNumber: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            havePercent: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            haveNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            everyWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            srCurrency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            stockRightNature: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            srCompany: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            srCompanyType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            scCompanyBusiness: [
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
          /*股权opt*/
          stockRightNatureOpt:[
            {
              value: '法人股',
              label: '法人股'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          srCompanyTypeOpt:[
            {
              value: '企业类',
              label: '企业类'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          srCompanyIssueWayOpt:[
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
        doConfirmStockRightDetail:function () {
          this.$refs["mpStockRightDetailValidate"].validate((valid) => {
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
          this.$refs["mpStockRightDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-stock-right{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-stock-right p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
