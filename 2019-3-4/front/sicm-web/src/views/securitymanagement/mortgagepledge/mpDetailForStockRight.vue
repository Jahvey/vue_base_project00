<!--详细信息  股权-->
<template>
  <div class="mp-detail-for-stock-right">
    <el-row>
      <el-form el-form label-width="200px" :model="stockRightInfo" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="stockRightInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="stockRightInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="stockRightInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>股权信息</p>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="股权登记机构" prop="stockRegistrationOrg" >
            <el-input :disabled="inputComponentDisable"  v-model="stockRightInfo.stockRegistrationOrg" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="股权登记通知书编号" prop="stockEquityNoticeNum" >
            <el-input :disabled="inputComponentDisable"  v-model="stockRightInfo.stockEquityNoticeNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="持股份额%" prop="controlCount" >
            <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.controlCount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="数量(股)" prop="stockCount" >
            <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.stockCount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="每股净资产(元)" prop="netValuePerStock" >
            <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.netValuePerStock" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="netValueCurrencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.netValueCurrencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="股权性质" prop="stockCharacter" >
            <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.stockCharacter" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in stockCharacterOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="被控股公司" prop="controledCompanyName" >
            <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.controledCompanyName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="被控股公司类别" prop="controledCompanyType" >
            <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.controledCompanyType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in srCompanyTypeOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="被控股公司主营业务" prop="companyHoldBiz" >
            <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.companyHoldBiz" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="stockRightInfo.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="股权是否上市" prop="stockListedInd" >
            <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.stockListedInd" @change="stockListedIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="stockListedIndDisable">
          <el-col :span="12" >
            <el-form-item label="股权名称" prop="stockName" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.stockName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市公司名称" prop="marketCompanyName" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.marketCompanyName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发行方式" prop="stockIssueTypeCd" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.stockIssueTypeCd" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in stockIssueTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市地点" prop="marketPlace" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.marketPlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="上市公司类型" prop="marketCompanyTypeCd" >
              <el-select :disabled="inputComponentDisable"  v-model="stockRightInfo.marketCompanyTypeCd" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in srCompanyTypeOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="最近一个交易日市价(元)" prop="averagePriceLatestDay" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.averagePriceLatestDay" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="每股最近一年均价(元)" prop="averagePriceLatestYear" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.averagePriceLatestYear" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" >
            <el-form-item label="上市公司经营情况" prop="marketCompanyOperStatus" >
              <el-input :disabled="inputComponentDisable" v-model="stockRightInfo.marketCompanyOperStatus" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" >{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import enums from "@/utils/enums"
  import { updateStockWarrantAssetsAndGrtCollateral,selectStockWarrantAssetsByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-stock-right",
    props:{
      grtCollateralInfo:Object,
      isUpdate:{
        default:false,
        type:Boolean,
      },
    },
    beforeMount(){
      //数据回显
      if(this.isUpdate){
        selectStockWarrantAssetsByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.stockRightInfo = response.data.data;
          } else{
            this.$message({
              message: '数据回显'+JSON.stringify(response.data),
              type: 'error'
            });
          }
        });
      }
    },
    data(){
      return{
        stockRightInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*股权*/
          stockRegistrationOrg:"",//股权登记机构
          stockEquityNoticeNum:"",//股权登记通知书编号
          controlCount:"",//持股份额%
          stockCount:"",//数量(股)
          netValuePerStock:"",//每股净资产(元)
          netValueCurrencyCd:"",//币种
          stockCharacter:"",//股权性质
          controledCompanyName:"",//被控股公司
          controledCompanyType:"",//被控股公司类别
          companyHoldBiz:"",//被控股公司主营业务
          otherNote:"",//其他情况说明
          stockListedInd:"",//股权是否上市
          stockName:"",//股权名称
          marketCompanyName:"",//上市公司名称
          stockIssueTypeCd:"",//发行方式
          marketPlace:"",//上市地点
          marketCompanyTypeCd:"",//上市公司类型
          averagePriceLatestDay:"",//最近一个交易日市价(元)
          averagePriceLatestYear:"",//每股最近一年均价(元)
          marketCompanyOperStatus:"",//上市公司经营情况
        },
        /*动态标志 股权是否上市*/
        stockListedIndDisable:false,
        rules:{
          /*价值信息 rules*/
          assetStatus: [
            {
              required: true,
              message: "请选择价值认定方式",
              trigger: 'change'
            }
          ],
          bookValue: [
            {
              required: true,
              message: "请输入帐面原值/取得价值",
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
          marketValue: [
            {
              required: true,
              message: "请输入抵质押物认定价值",
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
          currencyCd: [
            {
              required: true,
              message: "请选择币种",
              trigger: 'change'
            }
          ],
          evaluateDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          submittingDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          /*股权 rules*/
          stockName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max:30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          stockListedInd: [
            {
              required: false,
              message: "",
              trigger: 'change'
            }
          ],
          marketCompanyName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max:30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          stockIssueTypeCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          marketPlace: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max:30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          averagePriceLatestDay: [
            {
              required: false,
              message: "",
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
          averagePriceLatestYear: [
            {
              required: false,
              message: "",
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
          marketCompanyOperStatus: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          marketCompanyTypeCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],

          stockRegistrationOrg: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          stockEquityNoticeNum: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[A-Za-z0-9]{4,40}$/,
              message: '编号只能是数字、字母或其组合',
              trigger: 'blur'
            }
          ],
          controlCount: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              pattern: /^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/,
              message: '持股份额应该在0.01-100之间',
              trigger: 'blur'
            }
          ],
          stockCount: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 8,
              message: '长度不超过 8 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[1-9]\d*$/,
              message: '只能是正整数',
              trigger: 'blur'
            }
          ],
          netValuePerStock: [
            {
              required: true,
              message: "请输入",
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
          netValueCurrencyCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          stockCharacter: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          controledCompanyName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          controledCompanyType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          companyHoldBiz: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          otherNote: [
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
        merchandiseTypeCdOpt:enums.merchandise_type_cd,//
        buttonDisable:false,
        buttonText:"提交",
        inputComponentDisable:false,
        currencyOption:enums.currencyCd,//币种类型选项
        worthEvaluateWayOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        yesNotOption:enums.commonYesAndNotCd,//是否选择
        /*股权opt*/
        stockCharacterOpt:enums.StockCharacterTypeCd,
        srCompanyTypeOpt:enums.CustomerType,
        stockIssueTypeCdOpt:enums.StockIssueTypeCode,
      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateStockWarrantAssetsAndGrtCollateral(this.stockRightInfo).then(response =>{
              if(response.data.flag=='true') {
                //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击
                this.buttonDisable = true;
                this.buttonText = "已提交";
                this.inputComponentDisable = true;
                this.$message({
                  message: '提交成功',
                  type: 'success'
                });
              } else{
                this.buttonDisable = false;
                this.buttonText = "提交";
                this.$message({
                  message: '提交失败'+JSON.stringify(response.data),
                  type: 'error'
                });
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
      doReset:function () {
        this.$refs["validate"].resetFields();
      },
      stockListedIndChange:function (val) {
        if(val == enums.stateCode.result.yes){
          this.stockListedIndDisable = true;
        } else{
          this.stockListedIndDisable = false;
        }
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
