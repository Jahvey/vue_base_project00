<!--详细信息 农机具-->
<template>
  <div class="mp-detail-for-agricultural-implements">
    <el-row>
      <el-form el-form ref="validate" label-width="200px" :model="AgriculturalImplementsInfo" label-position="right" :rules="rules" >
        <el-col :span="24">
          <p>抵质押基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="国家或地区" prop="nationalityCd" >
            <el-select :disabled="inputComponentDisable"  v-model="AgriculturalImplementsInfo.nationalityCd" placeholder="请选择" style="width:100%" >
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
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.provinceCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable"  v-model="AgriculturalImplementsInfo.cityCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.districtCd"  placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable"  type="textarea" v-model="AgriculturalImplementsInfo.streetAddress" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物获取途径" prop="acquireWayOfCollateralCd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.acquireWayOfCollateralCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in acquireWayOfCollateralCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保权认定生效方式" prop="wayGuarantyEffectiveCd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.wayGuarantyEffectiveCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in wayGuarantyEffectiveCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共同财产" prop="commonAssetsInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.commonAssetsInd" @change="commonOwnerNameChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="commonOwnerNameDisable">
          <el-col :span="12">
            <el-form-item label="共有人名称" prop="commonOwnerName" >
              <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.commonOwnerName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="权利证明类型" prop="rightCertTypeCd" >
            <el-select :disabled="inputComponentDisable"  v-model="AgriculturalImplementsInfo.rightCertTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in rightCertTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权利证明编号" prop="rightCertificationNum" >
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.rightCertificationNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押权取得/占有时间" prop="handoverDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd"  v-model="AgriculturalImplementsInfo.handoverDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物发证机关" prop="collateralCardDepartment" >
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.collateralCardDepartment" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCdOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in assetStatusOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间"  prop="evaluateDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="AgriculturalImplementsInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日" prop="submittingDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="AgriculturalImplementsInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>抵制押物状态信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否可转让" prop="takeoverInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.takeoverInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否将全部价值抵押到我行" prop="allPledgeInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.allPledgeInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否租赁或许可他人使用" prop="rentedLicensedInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.rentedLicensedInd" @change="rentedLicensedIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="rentedLicensedIndDisable">
          <el-col :span="12">
            <el-form-item label="承租人名称" prop="renterName" >
              <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.renterName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="租赁到期日期" prop="leaseExpirationDate" >
              <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="AgriculturalImplementsInfo.leaseExpirationDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否国有资产" prop="nationalisationInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.nationalisationInd" @change="nationalisationIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="nationalisationIndDisable">
          <el-col :span="12">
            <el-form-item label="是否取得国资部门批准" prop="isStateSectorApproval" >
              <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.isStateSectorApproval" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否法律规定禁止流通财产" prop="forbidCirculateInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.forbidCirculateInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所有权是否有争议" prop="propertyDisputedInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.propertyDisputedInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否查封、扣押或监管" prop="invalidInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.invalidInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物权是否存在瑕疵" prop="blemishInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.blemishInd" @change="blemishIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="blemishIndDisable">
          <el-col :span="12">
            <el-form-item label="抵质押物权属瑕疵情况" prop="blemishNote" >
              <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.blemishNote" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="24">
          <p>农机具基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="农机具名称" prop="vehicleName">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.vehicleName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="农机具类型" prop="vehiclesNature">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.vehiclesNature" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车牌号" prop="carCardNum">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.carCardNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="颜色" prop="color">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.color" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="动力燃料" prop="fuel" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.fuel" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in fuelOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发动机号" prop="engineNum">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.engineNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车架号" prop="frameworkNum">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.frameworkNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="原购置价格(元)" prop="oriPurchasePrice">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.oriPurchasePrice" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无行驶证" prop="dirverLicenseInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.dirverLicenseInd" @change="dirverLicenseIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="dirverLicenseIndDisable">
          <el-col :span="12">
            <el-form-item label="行驶证号码" prop="licenseNum">
              <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.licenseNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="行驶证发证机构" prop="licenseDepartment">
              <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.licenseDepartment" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="已行驶里程(公里)" prop="runnedKm">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.runnedKm" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="挂牌日期" prop="hangDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="AgriculturalImplementsInfo.hangDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册地址" prop="registerAddress">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.registerAddress" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权利人名称" prop="licenseOwner">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.licenseOwner" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无附加费证" prop="coverChargeCertInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.coverChargeCertInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无运营证" prop="carryLicenseInd" >
            <el-select :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.carryLicenseInd" @change="carryLicenseIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="carryLicenseIndDisable">
          <el-col :span="12">
            <el-form-item label="营运证号" prop="invoiceNo">
              <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.invoiceNo" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="已使用年限(年)" prop="usedYear">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.usedYear" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="AgriculturalImplementsInfo.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="制造商" prop="manufacturingCompany">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.manufacturingCompany" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车龄(年)" prop="carAge">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.carAge" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车品牌" prop="carBrand">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.carBrand" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="车型号" prop="carType">
            <el-input :disabled="inputComponentDisable" v-model="AgriculturalImplementsInfo.carType" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="出厂日期"  prop="producedDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="AgriculturalImplementsInfo.producedDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="购买日期" prop="purchaseYear">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="AgriculturalImplementsInfo.purchaseYear" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="报废年限" prop="rejectYear">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="AgriculturalImplementsInfo.rejectYear" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="事故记录" prop="troubleRecords" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="AgriculturalImplementsInfo.troubleRecords" style="width:100%"></el-input>
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
  import enums from "../../../utils/enums";
  import commonUtil from '@/utils/commonUtil'
  import { updateAgricultureToolAndGrtCollateral,selectAgricultureToolByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-agricultural-implements",
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
        selectAgricultureToolByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.AgriculturalImplementsInfo = response.data.data;
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
        AgriculturalImplementsInfo:{
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
          /*抵质押物状态信息*/
          takeoverInd:"",//是否可转让
          allPledgeInd:"",//是否将全部价值抵押到我行
          rentedLicensedInd:"",//是否租赁或许可他人使用
          renterName:"",//承租人名称
          leaseExpirationDate:"",//租赁到期日期
          nationalisationInd:"",//是否国有资产
          isStateSectorApproval:"",//是否取得国资部门批准
          forbidCirculateInd:"",//是否法律规定禁止流通财产
          propertyDisputedInd:"",//所有权是否有争议
          invalidInd:"",//是否查封、扣押或监管
          blemishInd:"",//抵质押物权是否存在瑕疵
          blemishNote:"",//抵质押物权属瑕疵情况
          /*农机具基本信息*/
          vehicleName:"",//农机具辆名称
          vehiclesNature:"",//农机具类型
          carCardNum:"",//车牌号
          color:"",//颜色
          fuel:"",//动力燃料
          engineNum:"",//发动机号
          frameworkNum:"",//车架号
          oriPurchasePrice:"",//原购置价格(元)
          dirverLicenseInd:"",//有无行驶证
          licenseNum:"",//行驶证号码
          licenseDepartment:"",//行驶证发证机构
          runnedKm:"",//已行驶里程(km)
          hangDate:"",//挂牌日期
          registerAddress:"",//注册地址
          licenseOwner:"",//权利人名称
          coverChargeCertInd:"",//有无附加费证
          carryLicenseInd:"",//有无运营证
          invoiceNo:"",//运营证号
          usedYear:"",//已使用年限
          otherNote:"",//其他情况说明
          manufacturingCompany:"",//制造商
          carAge:"",//车龄(年)
          carBrand:"",//车品牌
          carType:"",//车型号
          producedDate:"",//出厂日期
          purchaseYear:"",//购买日期
          rejectYear:"",//报废年限
          troubleRecords:"",//事故记录
        },//农机具信息
        /*动态标志 共有人*/
        commonOwnerNameDisable:false,
        /*动态标志 租赁或已许可他人使用*/
        rentedLicensedIndDisable:false,
        /*动态标志 是否国有资产*/
        nationalisationIndDisable:false,
        /*动态标志 抵质押物权属瑕疵情况*/
        blemishIndDisable:false,
        /*动态标志 有无所有权证*/
        ownerLicenseIndDisable:false,
        /*动态标志 有无行车证*/
        dirverLicenseIndDisable:false,
        /*动态标志 有无运营证*/
        hasOperationCertificateDisable:false,
        acquireWayOfCollateralCdOpt:enums.AcquireWayOfCollateralCode,
        wayGuarantyEffectiveCdOpt:enums.GuarantyRightEffectiveType,
        yesNotOpt:enums.commonYesAndNotCd,
        rightCertTypeCdOpt:enums.GuarantyCertificate,
        currencyCdOption:enums.currencyCd,//币种类型选项
        assetStatusOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        landUseTypeOpt:enums.LandUseTypeCode,
        vehicleTypeOpt:enums.TransportUsedType,
        landCharacterOpt:enums.LandCharacterCode,
        notOrHaveOpt:enums.commonHaveNotCd,
        houseLicenseTypeOpt:enums.EstateWarrantTypeCd,
        landAcquiringWayCdOpt:enums.HouseConfigurationPCode,
        cashCapacityOpt:enums.RealizationAbilityCd,
        positionTypeCdOpt:enums.PositionTypeCd,
        utilizationTypeOpt:enums.UtilizationType,
        fuelOpt:enums.FuelTypeCode,
        countryAndRegionOpt:[
          {
            value: '中国',
            label: '中国'
          }, {
            value: '美国',
            label: '美国'
          },
        ],//国家和地区选项
        provinceOpt:[
          {
            value: '四川省',
            label: '四川省'
          },
        ],
        cityOpt:[
          {
            value: '绵阳市',
            label: '绵阳市'
          },
        ],
        districtOpt:[
          {
            value: '涪城区',
            label: '涪城区'
          },
        ],
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
          /*抵质押物状态信息*/
          takeoverInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          allPledgeInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          rentedLicensedInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          renterName: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          leaseExpirationDate: [
            {
              required: true,
              message: "请选择日期",
              trigger: 'change'
            }
          ],
          nationalisationInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          isStateSectorApproval: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          forbidCirculateInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          propertyDisputedInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          invalidInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          blemishInd: [
            {
              required: true,
              message: "请选择是否",
              trigger: 'change'
            }
          ],
          /*农机具 rules部分*/
          rejectYear: [
            {
              required: false,
              message: "",
              trigger: 'change'
            }
          ],
          purchaseYear: [
            {
              required: true,
              message: "请选择日期",
              trigger: 'change'
            }
          ],
          carAge: [
            {
              required: true,
              message: "请输入车龄",
              trigger: 'change'
            },
            {
              max: 20,
              message: '长度不超过 20 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^([1-9]\d*|[0]{1,1})$/,
              message: '请输入正整数值',
              trigger: 'blur'
            }
          ],
          ownerCertifyNumber: [
            {
              required: true,
              message: "",
              trigger: 'change'
            }
          ],
          licenseOwner: [
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
          engineNum: [
            {
              required: false,
              message: "请输入发动机号",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          runnedKm: [
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
              message: '请输入正确里程值',
              trigger: 'blur'
            }
          ],
          carryLicenseInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          dirverLicenseInd: [
            {
              required: false,
              message: "",
              trigger: 'change'
            }
          ],
          licenseNum: [
            {
              required: true,
              message: "请输入行驶证号码",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          licenseDepartment: [
            {
              required: true,
              message: "请输入行驶证发证机构",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          oriPurchasePrice: [
            {
              required: true,
              message: "请输入购置价格",
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
          carCardNum: [
            {
              required: false,
              message: "请输入车牌号",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          vehicleName: [
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
          hangDate: [
            {
              required: true,
              message: "请选择日期",
              trigger: 'change'
            }
          ],
          manufacturingCompany: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          carType: [
            {
              required: true,
              message: "请输入车型号",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          productiveYear: [
            {
              required: true,
              message: "",
              trigger: 'change'
            }
          ],
          carBrand: [
            {
              required: true,
              message: "请输入车品牌",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          producedDate: [
            {
              required: true,
              message: "请选择日期",
              trigger: 'change'
            }
          ],
          usedYear: [
            {
              required: true,
              message: "请输入已经使年限",
              trigger: 'change'
            },
            {
              max: 20,
              message: '长度不超过 20 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[+]{0,1}(\d+)$/,
              message: '请输入正确数字',
              trigger: 'blur'
            }
          ],
          color: [
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
          ],
          fuel: [
            {
              required: false,
              message: "",
              trigger: 'change'
            }
          ],
          frameworkNum: [
            {
              required: true,
              message: "请输入车架号",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          registerAddress: [
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
          coverChargeCertInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          vehiclesNature: [
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
          invoiceNo: [
            {
              required: true,
              message: "请输入营运证号",
              trigger: 'change'
            },
            {
              max: 30,
              message: '长度不超过 30 个字符',
              trigger: 'blur'
            },
          ],
          troubleRecords: [
            {
              required: false,
              message: "请输入事故记录",
              trigger: 'blur'},
            {
              max: 100,
              message: '长度不超过 100 个字符',
              trigger: 'blur'
            },
          ],
          otherNote: [
            {
              required: false,
              message: "请输入其他情况说明",
              trigger: 'blur'},
            {
              max: 300,
              message: '长度不超过 300 个字符',
              trigger: 'blur'
            },
          ],
        },
        buttonDisable:false,
        buttonText:"确定",
        inputComponentDisable:false,
      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateAgricultureToolAndGrtCollateral(this.AgriculturalImplementsInfo).then(response =>{
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
      hasOperationCertificateChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.hasOperationCertificateDisable = true;
        } else{
          this.hasOperationCertificateDisable = false;
        }
      },
      ownerLicenseIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.ownerLicenseIndDisable = true;
        } else{
          this.ownerLicenseIndDisable = false;
        }
      },
      blemishIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.blemishIndDisable = true;
        } else{
          this.blemishIndDisable = false;
        }
      },
      dirverLicenseIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.dirverLicenseIndDisable = true;
        } else{
          this.dirverLicenseIndDisable = false;
        }
      },
      carryLicenseIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.carryLicenseIndDisable = true;
        } else{
          this.carryLicenseIndDisable = false;
        }
      },
    },
  }
</script>

<style scoped>
  .mp-detail-for-agricultural-implements{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-agricultural-implements p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
