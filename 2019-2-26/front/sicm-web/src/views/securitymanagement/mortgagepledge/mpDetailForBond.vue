<!--详细信息-----债券-->
<template>
  <div class="mp-detail-for-bond">
    <el-row>
      <el-form el-form label-width="200px" :model="bondInfo" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="bondInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="bondInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="bondInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>债券</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发行人名称" prop="issuePersName" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.issuePersName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券等级" prop="bondLevelType" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.bondLevelType" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券种类" prop="k71zqzl" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.k71zqzl" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in typeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记机构" prop="registerOrgName" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.registerOrgName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券面值(元)" prop="bondValue" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.bondValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="bondValueCurrencyCd" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.bondValueCurrencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="按发行主体划分债券类型" prop="bondType" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.bondType" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="签发公司的经营状况" prop="signCompanyStatus" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.signCompanyStatus" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="签发公司类别" prop="signCompanyType" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.signCompanyType" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in signCompanyTypeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="代理发行人" prop="agencyMan" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.agencyMan" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债劵人名称" prop="creditorName" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.creditorName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券发行类型" prop="bondSingedType" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.bondSingedType" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in bondSingedTypeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券到期日" prop="bondMaturity" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="bondInfo.bondMaturity" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券利息支付类型" prop="bondInterestPayType" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.bondInterestPayType" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in bondInterestPayTypeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券利息支付方式" prop="bondInterestPayMode" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.bondInterestPayMode" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in bondInterestPayModeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券期限" prop="bondTerm" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.bondTerm" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券期限单位" prop="bondTermUnitCd" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.bondTermUnitCd" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in bondTermUnitCdOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="是否记名债券" prop="signBondInd" >
            <el-select :disabled="inputComponentDisable" v-model="bondInfo.signBondInd" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in yesNotOption" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="债券年利率" prop="bondAnnualRate" >
            <el-input :disabled="inputComponentDisable" v-model="bondInfo.bondAnnualRate" style="width:100%">
              <template slot="append">%</template>
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="bondInfo.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
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
  import { updateBondPledgeAndGrtCollateral,selectBondPledgeByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-bond",
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
        selectBondPledgeByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.bondInfo = response.data.data;
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
        bondInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*债券信息*/
          issuePersName:"",//发行人名称
          bondLevelType:"",//债券等级
          k71zqzl:"",//债券种类
          registerOrgName:"",//登记机构
          bondValue:"",//债券面值(元)
          bondValueCurrencyCd:"",//币种
          bondType:"",//按发行主体划分债券类型
          signCompanyStatus:"",//签发公司的经营状态
          signCompanyType:"",//签发公司类别
          agencyMan:"",//代理发行人
          creditorName:"",//债券人名称
          bondSingedType:"",//债券发行类型
          bondMaturity:"",//债券到期日
          bondInterestPayType:"",//债券利息支付类型
          bondInterestPayMode:"",//债券利息支付方式
          bondTerm:"",//债券年限
          bondTermUnitCd:"",//债券期限单位
          bondAnnualRate:"",//债券年利率
          signBondInd:"",//是否记名债券
          otherNote:"",//其他情况说明
        },
        rules:{
          issuePersName: [
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
          bondLevelType: [
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
          ],
          k71zqzl: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          signBondInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          registerOrgName: [
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
          bondValue: [
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
          bondValueCurrencyCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          bondType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          signCompanyStatus: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          signCompanyType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          agencyMan: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          creditorName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'change'
            },
          ],
          bondSingedType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          bondInterestPayType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          bondInterestPayMode: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          bondTerm: [
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
              pattern: /^[+]{0,1}(\d+)$/,
              message: '请输入正整数',
              trigger: 'blur'
            }
          ],
          bondTermUnitCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          bondAnnualRate: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 5,
              message: '长度不超过 5 个字符',
              trigger: 'change'
            },
            {
              pattern: /^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/,
              message: '请输入1-100的数,保留两位小数',
              trigger: 'change'
            }
          ],
          ifRemember: [
            {
              required: true,
              message: "",
              trigger: 'change'
            }
          ],
          otherNote: [
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
          bondMaturity:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
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
        },
        buttonDisable:false,
        buttonText:"提交",
        inputComponentDisable:false,
        currencyOption:enums.currencyCd,//币种类型选项
        worthEvaluateWayOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        yesNotOption:enums.commonYesAndNotCd,//是否选择
        bondTypeOpt:enums.BondTypeCd,
        typeOpt:enums.BondTypePCode,
        signCompanyTypeOpt:enums.SignCompanyTypeCd,
        bondSingedTypeOpt:enums.BondSingedTypeCd,
        bondInterestPayTypeOpt:enums.BondInterestPayTypeCd,
        bondInterestPayModeOpt:enums.BondInterestPayModeCode,
        bondTermUnitCdOpt:enums.TermCd,
      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateBondPledgeAndGrtCollateral(this.bondInfo).then(response =>{
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
    },
  }
</script>

<style scoped>
  .mp-detail-for-bond{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-bond p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
