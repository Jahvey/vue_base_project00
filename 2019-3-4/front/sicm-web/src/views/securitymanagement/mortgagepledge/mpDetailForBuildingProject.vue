<!--详细信息 在建工程-->
<template>
  <div class="mp-detail-for-building-project">
    <el-row>
      <el-form el-form ref="validate" label-width="200px" :model="buildingProjectInfo" label-position="right" :rules="rules" >
        <el-col :span="24">
          <p>抵质押基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="国家或地区" prop="nationalityCd" >
            <el-select :disabled="inputComponentDisable"  v-model="buildingProjectInfo.nationalityCd" placeholder="请选择" style="width:100%" >
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
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.provinceCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable"  v-model="buildingProjectInfo.cityCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.districtCd"  placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable"  type="textarea" v-model="buildingProjectInfo.streetAddress" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物获取途径" prop="acquireWayOfCollateralCd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.acquireWayOfCollateralCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in acquireWayOfCollateralCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保权认定生效方式" prop="wayGuarantyEffectiveCd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.wayGuarantyEffectiveCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in wayGuarantyEffectiveCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共同财产" prop="commonAssetsInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.commonAssetsInd" @change="commonOwnerNameChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="commonOwnerNameDisable">
          <el-col :span="12">
            <el-form-item label="共有人名称" prop="commonOwnerName" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.commonOwnerName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="权利证明类型" prop="rightCertTypeCd" >
            <el-select :disabled="inputComponentDisable"  v-model="buildingProjectInfo.rightCertTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in rightCertTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权利证明编号" prop="rightCertificationNum" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.rightCertificationNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押权取得/占有时间" prop="handoverDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd"  v-model="buildingProjectInfo.handoverDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物发证机关" prop="collateralCardDepartment" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.collateralCardDepartment" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCdOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in assetStatusOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间"  prop="evaluateDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="buildingProjectInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日" prop="submittingDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="buildingProjectInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>抵制押物状态信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否可转让" prop="takeoverInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.takeoverInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否将全部价值抵押到我行" prop="allPledgeInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.allPledgeInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否租赁或许可他人使用" prop="rentedLicensedInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.rentedLicensedInd" @change="rentedLicensedIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="rentedLicensedIndDisable">
          <el-col :span="12">
            <el-form-item label="承租人名称" prop="renterName" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.renterName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="租赁到期日期" prop="leaseExpirationDate" >
              <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="buildingProjectInfo.leaseExpirationDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否国有资产" prop="nationalisationInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.nationalisationInd" @change="nationalisationIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="nationalisationIndDisable">
          <el-col :span="12">
            <el-form-item label="是否取得国资部门批准" prop="isStateSectorApproval" >
              <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.isStateSectorApproval" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否法律规定禁止流通财产" prop="forbidCirculateInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.forbidCirculateInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所有权是否有争议" prop="propertyDisputedInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.propertyDisputedInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否查封、扣押或监管" prop="invalidInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.invalidInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物权是否存在瑕疵" prop="blemishInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.blemishInd"  @change="blemishIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="blemishIndDisable">
          <el-col :span="12">
            <el-form-item label="抵质押物权属瑕疵情况" prop="blemishNote" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.blemishNote" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="24">
          <p>房地产类型抵押信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="房屋使用类型" prop="utilizationType" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.utilizationType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in utilizationTypeOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否位于城市地带" prop="cityLocationInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.cityLocationInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地理位置" prop="buildingLocation" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.buildingLocation" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in positionTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="变现能力" prop="cashCapacity" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.cashCapacity" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in cashCapacityOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="总层数(层)" prop="totleFloor">
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.totleFloor" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用地面积" prop="landArea" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landArea" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="房屋结构" prop="buildingStructure" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.buildingStructure" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="建筑年代" prop="constructedDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="buildingProjectInfo.constructedDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="建筑结构" prop="landAcquiringWayCd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.landAcquiringWayCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in landAcquiringWayCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无房产权证" prop="houseLicenseInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseLicenseInd" @change="houseLicenseIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="houseLicenseIndDisable">
          <el-col :span="12">
            <el-form-item label="房产权证类型" prop="houseLicenseType" >
              <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseLicenseType" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in houseLicenseTypeOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="房产权证号" prop="houseLicenseNum" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseLicenseNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="房产权证人名称" prop="houseLicenseOwner" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseLicenseOwner" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="有无土地证" prop="landLicenseInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.landLicenseInd" @change="landLicenseIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="landLicenseIndDisable">
          <el-col :span="12">
            <el-form-item label="核发日期"  prop="landLicenseDate" >
              <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="buildingProjectInfo.landLicenseDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地权证类型" prop="landLicenseType" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landLicenseType" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地证号" prop="landLicenseNum" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landLicenseNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地权证人名称" prop="landLicenseOwner" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landLicenseOwner" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地所有制性质" prop="landCharacter" >
              <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.landCharacter" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in landCharacterOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地使用权类型" prop="landUseType" >
              <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.landUseType" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in landUseTypeOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="buildingProjectInfo.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>在建工程信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="项目用途" prop="projectPurpose" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.projectPurpose" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="已完工建筑面积(M²)" prop="buildedArea" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.buildedArea" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="总投资预算(元)" prop="investBudget" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.investBudget" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="工程原设计规模(M²)" prop="proOriDesignSizeCd" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.proOriDesignSizeCd" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵押面积(M²)" prop="mortgageArea" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.mortgageArea" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="工程形象进度" prop="proProcess" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.proProcess" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="累计完成投资额(元)" prop="finishedMoney" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.finishedMoney" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="项目现状" prop="projectPresentStatus" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.projectPresentStatus" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="建设单位" prop="buildUnit" >
            <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.buildUnit" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否拖欠工程款" prop="isPaymentArrears" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.isPaymentArrears" @change="isPaymentArrearsChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="isPaymentArrearsDisable">
          <el-col :span="12">
            <el-form-item label="拖欠工程款的金额(元)" prop="arrearsAmt" >
              <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.arrearsAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="有无工程规划许可证" prop="proPlanLicInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.proPlanLicInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无建设用地规划许可证" prop="isHasLandLicense" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.isHasLandLicense" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无建筑工程施工许可证" prop="startWorkLicInd" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.startWorkLicInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="土地出让金是否缴清" prop="isPaymentLandTransfer" >
            <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.isPaymentLandTransfer" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
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
  import { updateBuildingProjectAndGrtCollateral,selectBuildingProjectByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-building-project",
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
        selectBuildingProjectByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.buildingProjectInfo = response.data.data;
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
        /*          pickerOptions0: {
                    disabledDate(time) {
                      var date = new Date(time.replace(/-/,"/"))
                      return date.getTime() > Date.now();
                    }
                  },*/
        buildingProjectInfo:{
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
          /*房地产类型抵押信息*/
          utilizationType:"",//房屋使用类型
          cityLocationInd:"",//是否位于城市地带
          buildingLocation:"",//地理位置
          cashCapacity:"",//变现能力
          totleFloor:"",//总层数(层)
          landArea:"",//用地面积(M²)
          constructedDate:"",//建筑年代
          buildingStructure:"",//房屋结构
          landAcquiringWayCd:"",//建筑结构
          houseLicenseInd:"",//有无房产权证
          houseLicenseType:"",//房产权证类型
          houseLicenseNum:"",//房产权证号
          houseLicenseOwner:"",//房产权证人名称
          landLicenseInd:"",//有无土地证
          landLicenseDate:"",//核发日期
          landLicenseType:"",//土地权证类型
          landLicenseNum:"",//土地证号
          landLicenseOwner:"",//土地权证人名称
          landCharacter:"",//土地所有制性质
          landUseType:"",//土地使用权类型
          otherNote:"",//其他情况说明
          /*在建工程信息*/
          projectPurpose:"",//项目用途
          buildedArea:"",//已完工建筑面积(M²)
          investBudget:"",//总投资预算(元)
          proOriDesignSizeCd:"",//工程原设计规模(M²)
          mortgageArea:"",//抵押面积(M²)
          proProcess:"",//工程形象进度(%)
          finishedMoney:"",//累计完成投资额(元)
          projectPresentStatus:"",//项目现状
          isPaymentArrears:"",//是否拖欠工程款
          arrearsAmt:"",//拖欠工程款的金额
          proPlanLicInd:"",//有无工程规划许可证
          isHasLandLicense:"",//有无建设用地规划许可证
          buildUnit:"",//建设单位
          startWorkLicInd:"",//有无建筑工程施工许可证
          isPaymentLandTransfer:"",//土地出让金是否缴清
        },//在建工程信息
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
        /*房地产类型抵押Opt*/
        landUseTypeOpt:enums.LandUseTypeCode,
        landCharacterOpt:enums.LandCharacterCode,
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
          /*房地产类型抵押信息rules部分*/
          houseLicenseType: [
            {
              required: true,
              message: "请选择类型",
              trigger: 'change'
            }
          ],
          buildingStructure: [
            {
              required: true,
              message: "请填写房屋结构",
              trigger: 'change'
            },
            {
              max: 5,
              message: '长度不超过 5 个字符',
              trigger: 'blur'
            },
          ],
          blemishNote: [
            {
              required: true,
              message: "请填写抵质押物权属瑕疵情况",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          landLicenseDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          constructedDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          houseLicenseInd: [
            {
              required: true,
              message: "请选择有无",
              trigger: 'change'
            }
          ],
          landArea: [
            {
              required: true,
              message: "请输入用地面积",
              trigger: 'change'
            },
            {
              max: 10,
              message: '长度不超过 10 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的面积',
              trigger: 'blur'
            }
          ],
          cashCapacity: [
            {
              required: true,
              message: "请选择变现能力",
              trigger: 'change'
            }
          ],
          totleFloor: [
            {
              required: true,
              message: "请填入层数",
              trigger: 'change'
            },
            {
              pattern: /^[1-9]\d*$/,
              message: '请输入正确楼层数',
              trigger: 'blur'
            },
            {
              max: 8,
              message: '长度不超过8 个字符',
              trigger: 'blur'
            },
          ],
          landAcquiringWayCd: [
            {
              required: true,
              message: "",
              trigger: 'change'
            }
          ],
          buildingLocation: [
            {
              required: true,
              message: "请选择地理位置",
              trigger: 'change'
            }
          ],
          utilizationType: [
            {
              required: true,
              message: "请选择房屋使用类型",
              trigger: 'change'
            }
          ],
          cityLocationInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          houseLicenseNum: [
            {
              required: true,
              message: "请输入房产权证号",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'blur'
            },
          ],
          landUseType: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          houseLicenseOwner: [
            {
              required: true,
              message: "请输入房产权证人名称",
              trigger: 'change'
            },
            {
              max: 40,
              message: '长度不超过 40 个字符',
              trigger: 'blur'
            },
          ],
          landCharacter: [
            {
              required: true,
              message: "土地所有制性质",
              trigger: 'change'
            }
          ],
          landLicenseInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          landLicenseType: [
            {
              required: true,
              message: "请输入土地权证类型",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          landLicenseNum: [
            {
              required: true,
              message: "请输入土地权证号",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          landLicenseOwner: [
            {
              required: true,
              message: "请输入土地权证人名称",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
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
          /*在建工程信息 rules*/
          isPaymentLandTransfer: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          startWorkLicInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          buildUnit: [
            {
              required: true,
              message: "请填写建设单位",
              trigger: 'change'
            }
          ],
          isHasLandLicense: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          isPaymentArrears: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          proPlanLicInd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          projectPresentStatus: [
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
          arrearsAmt: [
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
          finishedMoney: [
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
          proProcess: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 5,
              message: '长度不超过 5 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的进度',
              trigger: 'blur'
            }
          ],
          mortgageArea: [
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
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的面积',
              trigger: 'blur'
            }
          ],
          proOriDesignSizeCd: [
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
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的面积',
              trigger: 'blur'
            }
          ],
          buildedArea: [
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
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的面积',
              trigger: 'blur'
            }
          ],
          investBudget: [
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
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的金额',
              trigger: 'blur'
            }
          ],
          projectPurpose: [
            {
              required: true,
              message: "项目用途不能为空",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
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
            updateBuildingProjectAndGrtCollateral(this.buildingProjectInfo).then(response =>{
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
  .mp-detail-for-building-project{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-building-project p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
