<!--详细信息  土地经营权-->
<template>
  <div class="mp-detail-for-land-manage-right">
    <el-row >
      <el-form el-form ref="validate" label-width="200px" :model="landManageRightInfo" label-position="right" :rules="rules" >
        <el-col :span="24">
          <p>抵质押基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="国家或地区" prop="nationalityCd" >
            <el-select :disabled="inputComponentDisable"  v-model="landManageRightInfo.nationalityCd" placeholder="请选择" style="width:100%" >
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
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.provinceCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable"  v-model="landManageRightInfo.cityCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.districtCd"  placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable"  type="textarea" v-model="landManageRightInfo.streetAddress" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物获取途径" prop="acquireWayOfCollateralCd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.acquireWayOfCollateralCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in acquireWayOfCollateralCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保权认定生效方式" prop="wayGuarantyEffectiveCd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.wayGuarantyEffectiveCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in wayGuarantyEffectiveCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共同财产" prop="commonAssetsInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.commonAssetsInd" @change="commonOwnerNameChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="commonOwnerNameDisable">
          <el-col :span="12">
            <el-form-item label="共有人名称" prop="commonOwnerName" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.commonOwnerName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="权利证明类型" prop="rightCertTypeCd" >
            <el-select :disabled="inputComponentDisable"  v-model="landManageRightInfo.rightCertTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in rightCertTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权利证明编号" prop="rightCertificationNum" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.rightCertificationNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押权取得/占有时间" prop="handoverDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd"  v-model="landManageRightInfo.handoverDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物发证机关" prop="collateralCardDepartment" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.collateralCardDepartment" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCdOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in assetStatusOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间"  prop="evaluateDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="landManageRightInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日" prop="submittingDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="landManageRightInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>抵制押物状态信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否可转让" prop="takeoverInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.takeoverInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否将全部价值抵押到我行" prop="allPledgeInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.allPledgeInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否租赁或许可他人使用" prop="rentedLicensedInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.rentedLicensedInd" @change="rentedLicensedIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="rentedLicensedIndDisable">
          <el-col :span="12">
            <el-form-item label="承租人名称" prop="renterName" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.renterName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="租赁到期日期" prop="leaseExpirationDate" >
              <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="landManageRightInfo.leaseExpirationDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否国有资产" prop="nationalisationInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.nationalisationInd" @change="nationalisationIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="nationalisationIndDisable">
          <el-col :span="12">
            <el-form-item label="是否取得国资部门批准" prop="isStateSectorApproval" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.isStateSectorApproval" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否法律规定禁止流通财产" prop="forbidCirculateInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.forbidCirculateInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所有权是否有争议" prop="propertyDisputedInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.propertyDisputedInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否查封、扣押或监管" prop="invalidInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.invalidInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物权是否存在瑕疵" prop="blemishInd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.blemishInd" @change="blemishIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="blemishIndDisable">
          <el-col :span="12">
            <el-form-item label="抵质押物权属瑕疵情况" prop="blemishNote" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.blemishNote" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="24">
          <p>土地承包经营权信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产权人" prop="licenseOwner" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.licenseOwner" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="土地承包经营权性质" prop="landBusinessNature" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landBusinessNature" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in landBusinessNatureOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承包经营起始日" prop="contractStartDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="landManageRightInfo.contractStartDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承包经营终止日"  prop="contractEndDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="landManageRightInfo.contractEndDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="年承包费用(元)" prop="annualCharge" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.annualCharge" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承包费缴纳方式" prop="contractFeesPayMethod" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.contractFeesPayMethod" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in contractFeesPayMethodOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承包费到期日期" prop="contractFeesDueDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="landManageRightInfo.contractFeesDueDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="经营类别" prop="managementTypeCd" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.managementTypeCd" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="经营规模" prop="managementSizeCd" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.managementSizeCd" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承包经营届满日" prop="expirateDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="landManageRightInfo.expirateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="土地使用状态" prop="landUseStatus" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landUseStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in landUseStatusOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="周边环境状况" prop="circleStatus" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.circleStatus" placeholder="请选择" style="width:100%">

              <el-option v-for="(value,key) in circleStatusOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承包土地面积(亩)" prop="landAcreage" >
            <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.landAcreage" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="土地使用权性质" prop="landUseNature" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landUseNature" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in landUseNatureOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="土地用途" prop="landUtilizationPurpose" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landUtilizationPurpose" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in landUtilizationPurposeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="土地取得方式" prop="landAcquiringWayCd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landAcquiringWayCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in landAcquiringWayCdOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="土地出让金缴税情况" prop="groundRemiseCd" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.groundRemiseCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in groundRemiseCdOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="承包费用缴纳情况" prop="contractFeesPaySituation" >
            <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.contractFeesPaySituation" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in groundRemiseCdOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="地上定作物说明" prop="signDesc" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="landManageRightInfo.signDesc" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="landManageRightInfo.otherNote" style="width:100%"></el-input>
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
  import { updateLandManagementRightAndGrtCollateral,selectLandManagementRightByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-land-manage-right",
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
        selectLandManagementRightByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.landManageRightInfo = response.data.data;
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
        landManageRightInfo:{
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
          /*土地经营权*/
          licenseOwner:"",//产权人
          landBusinessNature:"",//土地承包经营权性质
          contractStartDate:"",//承包经营起始日
          contractEndDate:"",//承包经营终止日
          annualCharge:"",//年承包费用(元)
          contractFeesPayMethod:"",//承包费缴纳方式
          contractFeesDueDate:"",//承包费到期日期
          managementTypeCd:"",//经营类别
          managementSizeCd:"",//经营规模
          expirateDate:"",//承包经营届满日
          landUseStatus:"",//土地使用状态
          circleStatus:"",//周边环境状况
          landAcreage:"",//承包土地面积(亩)
          landUseNature:"",//土地使用权性质
          landUtilizationPurpose:"",//土地用途
          landAcquiringWayCd:"",//土地取得方式
          groundRemiseCd:"",//土地出让金缴税情况
          contractFeesPaySituation:"",//承包费用缴纳情况
          signDesc:"",//地上定作物说明
          otherNote:"",//其他情况说明
        },//土地经营权基本信息
        /*动态标志 共有人*/
        commonOwnerNameDisable:false,
        /*动态标志 租赁或已许可他人使用*/
        rentedLicensedIndDisable:false,
        /*动态标志 是否国有资产*/
        nationalisationIndDisable:false,
        /*动态标志 抵质押物权属瑕疵情况*/
        blemishIndDisable:false,
        /*动态标志 土地出让金是否缴清*/
        groundRemiseCdDisable:false,
        acquireWayOfCollateralCdOpt:enums.AcquireWayOfCollateralCode,
        wayGuarantyEffectiveCdOpt:enums.GuarantyRightEffectiveType,
        yesNotOpt:enums.commonYesAndNotCd,
        rightCertTypeCdOpt:enums.GuarantyCertificate,
        currencyCdOption:enums.currencyCd,//币种类型选项
        assetStatusOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        landUseTypeOpt:enums.LandUseTypeCode,
        notOrHaveOpt:enums.commonHaveNotCd,
        houseLicenseTypeOpt:enums.EstateWarrantTypeCd,
        cashCapacityOpt:enums.RealizationAbilityCd,
        positionTypeCdOpt:enums.PositionTypeCd,
        utilizationTypeOpt:enums.UtilizationType,
        LandUtilization:enums.LandUtilization,
        landAcquiringWayCdOpt:enums.LandAcquiring,
        rawDegreeOpt:enums.ResvCrudeRipeDegreeCode,
        landCharacterOpt:enums.LandCharacterCode,
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
        groundRemiseCdOpt:enums.GroundRemiseCode,
        landAcquiringWayCdOpt:enums.LandAcquiring,
        landUtilizationPurposeOpt:enums.LandUtilization,
        landUseNatureOpt:enums.LandCharacterCode,
        circleStatusOpt:enums.HonorConditionCd,
        landUseStatusOpt:enums.LandUsedStatusCd,
        contractFeesPayMethodOpt:enums.ContractFeePaymentModeCd,
        landBusinessNatureOpt:enums.ContractProsecutionNatureCd,
        rules:{
          contractStartDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          contractEndDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          contractFeesDueDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          expirateDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          managementSizeCd: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          managementTypeCd: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          contractFeesPayMethod: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          landUseStatus: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          annualCharge: [
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
          landBusinessNature: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          licenseOwner: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          circleStatus: [
            {
              required: false,
              message: "",
              trigger: 'change'
            }
          ],
          landAcreage: [
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
              message: '请输入正确的数字',
              trigger: 'blur'
            }
          ],
          landUseNature: [
            {
              required: true,
              message: "请选择土地使用权性质",
              trigger: 'change'
            }
          ],
          landUtilizationPurpose: [
            {
              required: true,
              message: "请选择土地用途",
              trigger: 'change'
            }
          ],
          landAcquiringWayCd: [
            {
              required: true,
              message: "请选择土地获取方式",
              trigger: 'change'
            }
          ],
          groundRemiseCd: [
            {
              required: false,
              message: "请选择土地出让金缴税情况",
              trigger: 'change'
            }
          ],
          contractFeesPaySituation: [
            {
              required: false,
              message: "请选择承包费用缴纳情况",
              trigger: 'change'
            }
          ],
          signDesc: [
            {
              required: false,
              message: "请输入地上定作物说明",
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
              max: 100,
              message: '长度不超过 100 个字符',
              trigger: 'blur'
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
            updateLandManagementRightAndGrtCollateral(this.landManageRightInfo).then(response =>{
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
  .mp-detail-for-land-manage-right{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-land-manage-right p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
