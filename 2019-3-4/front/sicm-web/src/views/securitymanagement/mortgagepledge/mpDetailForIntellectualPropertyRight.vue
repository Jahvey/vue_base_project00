<!--详细页面 知识产权-->
<template>
  <div class="mp-detail-for-intellectual-property-right">
    <el-row>
      <el-form el-form ref="validate" label-width="200px" :model="intellectualPropertyRightInfo" label-position="right" :rules="rules" >
        <el-col :span="24">
          <p>抵质押基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="国家或地区" prop="nationalityCd" >
            <el-select :disabled="inputComponentDisable"  v-model="intellectualPropertyRightInfo.nationalityCd" placeholder="请选择" style="width:100%" >
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
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.provinceCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable"  v-model="intellectualPropertyRightInfo.cityCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.districtCd"  placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable"  type="textarea" v-model="intellectualPropertyRightInfo.streetAddress" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物获取途径" prop="acquireWayOfCollateralCd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.acquireWayOfCollateralCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in acquireWayOfCollateralCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保权认定生效方式" prop="wayGuarantyEffectiveCd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.wayGuarantyEffectiveCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in wayGuarantyEffectiveCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共同财产" prop="commonAssetsInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.commonAssetsInd" @change="commonOwnerNameChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="commonOwnerNameDisable">
          <el-col :span="12">
            <el-form-item label="共有人名称" prop="commonOwnerName" >
              <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.commonOwnerName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="权利证明类型" prop="rightCertTypeCd" >
            <el-select :disabled="inputComponentDisable"  v-model="intellectualPropertyRightInfo.rightCertTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in rightCertTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权利证明编号" prop="rightCertificationNum" >
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.rightCertificationNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押权取得/占有时间" prop="handoverDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd"  v-model="intellectualPropertyRightInfo.handoverDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物发证机关" prop="collateralCardDepartment" >
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.collateralCardDepartment" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCdOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in assetStatusOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间"  prop="evaluateDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="intellectualPropertyRightInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日" prop="submittingDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="intellectualPropertyRightInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>抵制押物状态信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否可转让" prop="takeoverInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.takeoverInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否将全部价值抵押到我行" prop="allPledgeInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.allPledgeInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否租赁或许可他人使用" prop="rentedLicensedInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.rentedLicensedInd" @change="rentedLicensedIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="rentedLicensedIndDisable">
          <el-col :span="12">
            <el-form-item label="承租人名称" prop="renterName" >
              <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.renterName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="租赁到期日期" prop="leaseExpirationDate" >
              <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="intellectualPropertyRightInfo.leaseExpirationDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否国有资产" prop="nationalisationInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.nationalisationInd" @change="nationalisationIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="nationalisationIndDisable">
          <el-col :span="12">
            <el-form-item label="是否取得国资部门批准" prop="isStateSectorApproval" >
              <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.isStateSectorApproval" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否法律规定禁止流通财产" prop="forbidCirculateInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.forbidCirculateInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所有权是否有争议" prop="propertyDisputedInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.propertyDisputedInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否查封、扣押或监管" prop="invalidInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.invalidInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物权是否存在瑕疵" prop="blemishInd" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.blemishInd"  @change="blemishIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="blemishIndDisable">
          <el-col :span="12">
            <el-form-item label="抵质押物权属瑕疵情况" prop="blemishNote" >
              <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.blemishNote" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="24">
          <p>知识产权信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权证性质" prop="propertyRightNature">
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.propertyRightNature" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产权证名称" prop="licenseName">
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.licenseName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产权证编号" prop="licenseNum">
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.licenseNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="发证机关" prop="licenseDepartment">
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.licenseDepartment" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="商标类型" prop="brandType" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.brandType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in brandTypeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="商标已核定使用的商品种类" prop="productClass">
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.productClass" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="专利权客体类型" prop="patentType" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.patentType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in patentTypeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="专利权客体产业用途" prop="patentPurpose">
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.patentPurpose" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="产权人" prop="licenseOwner">
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.licenseOwner" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="作品首次发表年份" prop="publishedYear" >
            <el-input :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.publishedYear" style="width:100%"></el-input>

          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="作品类型" prop="productionType" >
            <el-select :disabled="inputComponentDisable" v-model="intellectualPropertyRightInfo.productionType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in productionTypeOpt" :key="key" :label="value" :value="key"></el-option>

            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保护期届满日期"  prop="procetedDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="intellectualPropertyRightInfo.procetedDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="核准日期"  prop="checkedDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="intellectualPropertyRightInfo.checkedDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="intellectualPropertyRightInfo.otherNote" style="width:100%"></el-input>
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
  import { updateIntellPropertyRightsAndGrtCollateral,selectIntellPropertyRightsByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-intellectual-property-right",
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
        selectIntellPropertyRightsByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.intellectualPropertyRightInfo = response.data.data;
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
        intellectualPropertyRightInfo:{
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
          /*知识产权基本信息*/
          propertyRightNature:"",//权证性质
          licenseName:"",//产权证名称
          licenseNum:"",//产权证编号
          licenseDepartment:"",//发证机关
          brandType:"",//商标类型
          productClass:"",//商标已核定使用的商品种类
          patentType:"",//专利权客体类型
          patentPurpose:"",//专利权客体产业用途
          licenseOwner:"",//产权人
          publishedYear:"",//作品首次发表年份
          productionType:"",//作品类型
          procetedDate:"",//保护期届满日期
          checkedDate:"",//核准日期
          otherNote:"",//其他情况说明
        },//知识产权信息
        /*动态标志 共有人*/
        commonOwnerNameDisable:false,
        /*动态标志 租赁或已许可他人使用*/
        rentedLicensedIndDisable:false,
        /*动态标志 是否国有资产*/
        nationalisationIndDisable:false,
        /*动态标志 有无土地证*/
        landLicenseIndDisable:false,
        /*动态标志 有无房产权证*/
        houseLicenseIndDisable:false,
        /*动态标志 抵质押物权属瑕疵情况*/
        blemishIndDisable:false,
        /*动态标志 是否拖欠工程款*/
        isPaymentArrearsDisable:false,
        /*知识产权Opt*/
        productionTypeOpt:enums.ProductionTypeCode,
        patentTypeOpt:enums.PatentTypeCode,
        brandTypeOpt:enums.BrandTypeCode,
        /*知识产权Opt end*/
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
          /*知识产权 rules部分*/
          brandType: [
            {
              required: false,
              message: "请选择",
              trigger: 'change'
            }
          ],
          productClass: [
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
          patentType: [
            {
              required: false,
              message: "请选择",
              trigger: 'change'
            }
          ],
          patentPurpose: [
            {
              required: false,
              message: "",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          licenseOwner: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 15,
              message: '长度不超过 15 个字符',
              trigger: 'change'
            },
          ],
          publishedYear: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              pattern: /^\d{4}$/,
              message: '请输入四个数字组成的年份',
              trigger: 'blur'
            },
          ],
          productionType: [
            {
              required: false,
              message: "请选择",
              trigger: 'change'
            }
          ],
          procetedDate: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          checkedDate: [
            {
              required: false,
              message: "请选择",
              trigger: 'change'
            }
          ],
          propertyRightNature: [
            {
              required: false,
              message: "true",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'change'
            },
          ],
          licenseName: [
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
          licenseNum: [
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
          licenseDepartment: [
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
            updateIntellPropertyRightsAndGrtCollateral(this.intellectualPropertyRightInfo).then(response =>{
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
      landLicenseIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.landLicenseIndDisable = true;
        } else{
          this.landLicenseIndDisable = false;
        }
      },
      isPaymentArrearsChange:function (val) {
        if(val == enums.stateCode.result.yes){
          this.isPaymentArrearsDisable = true;
        } else{
          this.isPaymentArrearsDisable = false;
        }
      },
      houseLicenseIndChange:function (val) {
        if(val == enums.stateCode.contain.have){
          this.houseLicenseIndDisable = true;
        } else{
          this.houseLicenseIndDisable = false;
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
  .mp-detail-for-intellectual-property-right{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-intellectual-property-right p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
