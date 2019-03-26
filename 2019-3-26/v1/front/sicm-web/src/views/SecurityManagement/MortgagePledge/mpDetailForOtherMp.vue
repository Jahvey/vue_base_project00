<template>
  <div class="mp-detail-for-other-mp">
    <el-row>
      <el-form el-form ref="validate" label-width="200px" :model="mpOtherInfo" label-position="right" :rules="rules" >
        <el-col :span="24">
          <p>抵质押基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="国家或地区" prop="nationalityCd" >
            <el-select :disabled="inputComponentDisable"  v-model="mpOtherInfo.nationalityCd" placeholder="请选择" style="width:100%" >
              <el-option
                v-for="item in nationalityCdOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="省/直辖市/自治区" prop="provinceCd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.provinceCd"  placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in provinceCdOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="城市/自治州" prop="cityCd" >
            <el-select :disabled="inputComponentDisable"  v-model="mpOtherInfo.cityCd"  placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in cityCdOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="区/县" prop="districtCd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.districtCd"  placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in districtCdOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="镇/街道、门牌号" prop="streetAddress" >
            <el-input :disabled="inputComponentDisable"  type="textarea" v-model="mpOtherInfo.streetAddress" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物获取途径" prop="acquireWayOfCollateralCd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.acquireWayOfCollateralCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in acquireWayOfCollateralCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保权认定生效方式" prop="wayGuarantyEffectiveCd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.wayGuarantyEffectiveCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in wayGuarantyEffectiveCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共同财产" prop="commonAssetsInd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.commonAssetsInd" @change="commonOwnerNameChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="commonOwnerNameDisable">
          <el-col :span="12">
            <el-form-item label="共有人名称" prop="commonOwnerName" >
              <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.commonOwnerName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="权利证明类型" prop="rightCertTypeCd" >
            <el-select :disabled="inputComponentDisable"  v-model="mpOtherInfo.rightCertTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in rightCertTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权利证明编号" prop="rightCertificationNum" >
            <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.rightCertificationNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押权取得/占有时间" prop="handoverDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd"  v-model="mpOtherInfo.handoverDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物发证机关" prop="collateralCardDepartment" >
            <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.collateralCardDepartment" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCdOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in assetStatusOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间"  prop="evaluateDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="mpOtherInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日" prop="submittingDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="mpOtherInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>其他信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押品名称" prop="collateralName" >
            <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.collateralName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押品数量" prop="impawnAmount" >
            <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.impawnAmount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数量单位" prop="impawnAmountCd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.impawnAmountCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in impawnAmountCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押品取得时间"  prop="impawnGetDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="mpOtherInfo.impawnGetDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押品有效到期日" prop="impawnExpireDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="mpOtherInfo.impawnExpireDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否办理止付(登记)" prop="registerInd" >
            <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.registerInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="mpOtherInfo.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm">{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>

</template>

<script>
  import enums from "../../../utils/enums";
  import { updateOtherAndGrtCollateral,selectOtherByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-other-mp",
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
        selectOtherByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.mpOtherInfo = response.data.data;
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
        mpOtherInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          /*抵质押物基本信息*/
          nationalityCd:"中国",//国家或地区
          provinceCd:"四川",//省/直辖市/自治区
          cityCd:"绵阳",//城市/自治州
          districtCd:"涪城区",//区/县
          streetAddress:"",//镇以下的信息
          acquireWayOfCollateralCd:"",//抵质押物获取途径
          wayGuarantyEffectiveCd:"",//担保权认定生效方式
          commonAssetsInd:"",//是否共同财产
          commonOwnerName:"",//共有人名称
          rightCertTypeCd:"",//权利证明类型
          rightCertificationNum:"",//权利证明编号
          handoverDate:"",//抵质押权取得/占有时间
          collateralCardDepartment:"",//抵质押物发证机关
          /*价值信息*/
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*其他信息*/
          collateralName:"",//抵质押品名称
          impawnAmount:"",//抵质押品数量
          impawnAmountCd:"",//数量单位
          impawnGetDate:"",//抵质押品取得时间
          impawnExpireDate:"",//抵质押品有效到期日
          registerInd:"",//是否办理止付(登记)
          otherNote:"",//其他情况说明
        },
        /*动态标志 共有人*/
        commonOwnerNameDisable:false,
        /*动态标志 租赁或已许可他人使用*/
        rentedLicensedIndDisable:false,
        /*动态标志 是否国有资产*/
        nationalisationIndDisable:false,
        /*动态标志 抵质押物权属瑕疵情况*/
        blemishIndDisable:false,
        notOrHaveOpt:enums.commonHaveNotCd,
        houseLicenseTypeOpt:enums.EstateWarrantTypeCd,
        landAcquiringWayCdOpt:enums.HouseConfigurationPCode,
        cashCapacityOpt:enums.RealizationAbilityCd,
        positionTypeCdOpt:enums.PositionTypeCd,
        utilizationTypeOpt:enums.UtilizationType,
        nationalityCdOpt:[
          {
            value: '中国',
            label: '中国'
          }, {
            value: '美国',
            label: '美国'
          },
        ],//国家和地区选项
        provinceCdOpt:[
          {
            value: '四川省',
            label: '四川省'
          },
        ],
        cityCdOpt:[
          {
            value: '绵阳市',
            label: '绵阳市'
          },
        ],
        districtCdOpt:[
          {
            value: '涪城区',
            label: '涪城区'
          },
        ],
        acquireWayOfCollateralCdOpt:enums.AcquireWayOfCollateralCode,
        wayGuarantyEffectiveCdOpt:enums.GuarantyRightEffectiveType,
        yesNotOpt:enums.commonYesAndNotCd,
        rightCertTypeCdOpt:enums.GuarantyCertificate,
        currencyCdOption:enums.currencyCd,//币种类型选项
        assetStatusOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        impawnAmountCdOpt:enums.AmountUnitCode,
        buttonDisable:false,
        buttonText:"确定",
        inputComponentDisable:false,
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
          /*抵质押基本信息 rules*/
          collateralCardDepartment: [
            {
              required: true,
              message: "请填写抵质押物发证机关",
              trigger: 'change'
            }
          ],
          handoverDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          rightCertificationNum: [
            {
              required: false,
              message: "请填写权利证明编号",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'blur'
            },
          ],
          rightCertTypeCd: [
            {
              required: true,
              message: "请选择权利证明类型",
              trigger: 'change'
            }
          ],
          commonAssetsInd: [
            {
              required: true,
              message: "请选择是否共同财产",
              trigger: 'change'
            }
          ],
          commonOwnerName: [
            {
              required: true,
              message: "请填写共有人名称",
              trigger: 'change'
            },
            {
              max: 20,
              message: '长度不超过 20 个字符',
              trigger: 'blur'
            },
          ],
          wayGuarantyEffectiveCd: [
            {
              required: true,
              message: "请选择担保权设定生效方式",
              trigger: 'change'
            },
          ],
          acquireWayOfCollateralCd: [
            {
              required: true,
              message: "请选择抵质押物取得途径",
              trigger: 'change'
            }
          ],
          streetAddress: [
            {
              required: true,
              message: "请填写详细地址",
              trigger: 'change'
            }
          ],
          districtCd: [
            {
              required: true,
              message: "请选择区/县",
              trigger: 'change'
            }
          ],
          cityCd: [
            {
              required: true,
              message: "请选择城市/自治州",
              trigger: 'change'
            }
          ],
          provinceCd: [
            {
              required: true,
              message: "请选择省/直辖市/自治区",
              trigger: 'change'
            }
          ],
          nationalityCd: [
            {
              required: true,
              message: "请选择国家或区域",
              trigger: 'change'
            }
          ],
          /*其他信息*/
          impawnGetDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          impawnExpireDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          collateralName: [
            {
              required: true,
              message: "请输入抵质押品名称",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          impawnAmount: [
            {
              required: true,
              message: "请输入抵质押品数量",
              trigger: 'change'
            },
            {
              max: 10,
              message: '长度不超过 10 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[1-9]\d*$/,
              message: '请输入正整数',
              trigger: 'blur'
            }
          ],
          impawnAmountCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          registerInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
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

      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateOtherAndGrtCollateral(this.mpOtherInfo).then(response =>{
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
      commonOwnerNameChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.commonOwnerNameDisable = true;
        } else{
          this.commonOwnerNameDisable = false;
        }
      },
      commonOwnerNameChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.commonOwnerNameDisable = true;
        } else{
          this.commonOwnerNameDisable = false;
        }
      },
      rentedLicensedIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.rentedLicensedIndDisable = true;
        } else{
          this.rentedLicensedIndDisable = false;
        }
      },
      nationalisationIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.nationalisationIndDisable = true;
        } else{
          this.nationalisationIndDisable = false;
        }
      },
      carryLicenseIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.carryLicenseIndDisable = true;
        } else{
          this.carryLicenseIndDisable = false;
        }
      },
      groundRemiseCdChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.groundRemiseCdDisable = true;
        } else{
          this.groundRemiseCdDisable = false;
        }
      },
      blemishIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.blemishIndDisable = true;
        } else{
          this.blemishIndDisable = false;
        }
      },
    },
  }
</script>

<style scoped>
  .mp-detail-for-other-mp{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-other-mp p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
