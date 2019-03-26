<!--房地产-->
<template>
  <div class="mpDetailRealEstate">
    <el-row>
      <el-form el-form ref="validate" label-width="200px" :model="realEstate" label-position="right" :rules="rules" >
        <el-col :span="24">
          <p>抵质押基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="国家或地区" prop="nationalityCd" >
            <el-select :disabled="inputComponentDisable"  v-model="realEstate.nationalityCd" placeholder="请选择" style="width:100%" >
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
            <el-select :disabled="inputComponentDisable" v-model="realEstate.provinceCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable"  v-model="realEstate.cityCd"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="realEstate.districtCd"  placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable"  type="textarea" v-model="realEstate.streetAddress" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物获取途径" prop="acquireWayOfCollateralCd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.acquireWayOfCollateralCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in acquireWayOfCollateralCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="担保权认定生效方式" prop="wayGuarantyEffectiveCd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.wayGuarantyEffectiveCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in wayGuarantyEffectiveCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否共同财产" prop="commonAssetsInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.commonAssetsInd" @change="commonOwnerNameChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="commonOwnerNameDisable">
          <el-col :span="12">
            <el-form-item label="共有人名称" prop="commonOwnerName" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.commonOwnerName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="权利证明类型" prop="rightCertTypeCd" >
            <el-select :disabled="inputComponentDisable"  v-model="realEstate.rightCertTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in rightCertTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="权利证明编号" prop="rightCertificationNum" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.rightCertificationNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押权取得/占有时间" prop="handoverDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd"  v-model="realEstate.handoverDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物发证机关" prop="collateralCardDepartment" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.collateralCardDepartment" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyCdOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in assetStatusOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间"  prop="evaluateDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="realEstate.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日" prop="submittingDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="realEstate.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>抵制押物状态信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否可转让" prop="takeoverInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.takeoverInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否将全部价值抵押到我行" prop="allPledgeInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.allPledgeInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否租赁或许可他人使用" prop="rentedLicensedInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.rentedLicensedInd" @change="rentedLicensedIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="rentedLicensedIndDisable">
          <el-col :span="12">
            <el-form-item label="承租人名称" prop="renterName" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.renterName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="租赁到期日期" prop="leaseExpirationDate" >
              <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="realEstate.leaseExpirationDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否国有资产" prop="nationalisationInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.nationalisationInd" @change="nationalisationIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="nationalisationIndDisable">
          <el-col :span="12">
            <el-form-item label="是否取得国资部门批准" prop="isStateSectorApproval" >
              <el-select :disabled="inputComponentDisable" v-model="realEstate.isStateSectorApproval" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="是否法律规定禁止流通财产" prop="forbidCirculateInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.forbidCirculateInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所有权是否有争议" prop="propertyDisputedInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.propertyDisputedInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否查封、扣押或监管" prop="invalidInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.invalidInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物权是否存在瑕疵" prop="blemishInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.blemishInd" @change="blemishIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="blemishIndDisable">
          <el-col :span="12">
            <el-form-item label="抵质押物权属瑕疵情况" prop="blemishNote" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.blemishNote" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="24">
          <p>房地产类型抵押信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="房屋使用类型" prop="utilizationType" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.utilizationType" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in utilizationTypeOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否位于城市地带" prop="cityLocationInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.cityLocationInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="已使用年限(年)" prop="assetLife">
            <el-input :disabled="inputComponentDisable" v-model="realEstate.assetLife" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="地理位置" prop="buildingLocation" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.buildingLocation" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in positionTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="变现能力" prop="cashCapacity" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.cashCapacity" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in cashCapacityOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="总层数(层)" prop="totleFloor">
            <el-input :disabled="inputComponentDisable" v-model="realEstate.totleFloor" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="建筑面积(m2)" prop="buildAllArea" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.buildAllArea" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用地面积(m2)" prop="landArea" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.landArea" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="建筑年代" prop="constructedDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="realEstate.constructedDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="建筑结构" prop="landAcquiringWayCd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.landAcquiringWayCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in landAcquiringWayCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无房产权证" prop="houseLicenseInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.houseLicenseInd" @change="houseLicenseIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="houseLicenseIndDisable">
          <el-col :span="12">
            <el-form-item label="房产权证类型" prop="houseLicenseType" >
              <el-select :disabled="inputComponentDisable" v-model="realEstate.houseLicenseType" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in houseLicenseTypeOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="房产权证号" prop="houseLicenseNum" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.houseLicenseNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="房产权证人名称" prop="houseLicenseOwner" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.houseLicenseOwner" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="有无土地证" prop="landLicenseInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.landLicenseInd" @change="landLicenseIndChange" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <template v-if="landLicenseIndDisable">
          <el-col :span="12">
            <el-form-item label="核发日期"  prop="landLicenseDate" >
              <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="realEstate.landLicenseDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地权证类型" prop="landLicenseType" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.landLicenseType" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地证号" prop="landLicenseNum" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.landLicenseNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地权证人名称" prop="landLicenseOwner" >
              <el-input :disabled="inputComponentDisable" v-model="realEstate.landLicenseOwner" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地所有制性质" prop="landCharacter" >
              <el-select :disabled="inputComponentDisable" v-model="realEstate.landCharacter" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in landCharacterOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地使用权类型" prop="landUseType" >
              <el-select :disabled="inputComponentDisable" v-model="realEstate.landUseType" placeholder="请选择" style="width:100%">
                <el-option v-for="(value,key) in landUseTypeOpt" :key="key" :label="value" :value="key"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </template>
        <el-col :span="12">
          <el-form-item label="土地是否需要设定抵押" prop="isLandMortgage" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.isLandMortgage" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in yesNotOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="realEstate.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>房地产其他信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所在楼座" prop="buildingNum" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.buildingNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所在楼层(层)" prop="floor" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.floor" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="具体房号" prop="roomNum" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.roomNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="层高（m）" prop="floorHeight" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.floorHeight" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="庭院面积（m2）" prop="courtArea" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.courtArea" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="目前管理状况" prop="manageStatus" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.manageStatus" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="使用者" prop="roomUser" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.roomUser" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="户型" prop="houseModel" >
            <el-input :disabled="inputComponentDisable" v-model="realEstate.houseModel" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="户门朝向" prop="direction" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.direction" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in DoorOrientationCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="装修程度" prop="fitmentDegree" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.fitmentDegree" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in FitmentDegreeCd" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="有无私家车库" prop="selfCarbarnInd" >
            <el-select :disabled="inputComponentDisable" v-model="realEstate.selfCarbarnInd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in notOrHaveOpt" :key="key" :label="value" :value="key"></el-option>
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
  import { updateRealEstateAndGrtCollateral,selectRealEstateByGuarantyId} from '@/api/securitymanagement'
    export default {
        name: "mpDetailRealEstate",
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
          selectRealEstateByGuarantyId(this.grtCollateralInfo).then(response =>{
            if(response.data.flag=='true') {
              this.realEstate = response.data.data;
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
            realEstate:{
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
              assetLife:"",//已使用年限(年)
              buildingLocation:"",//地理位置
              cashCapacity:"",//变现能力
              totleFloor:"",//总层数(层)
              buildAllArea:"",//建筑面积
              landArea:"",//用地面积(M²)
              constructedDate:"",//建筑年代
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
              isLandMortgage:"",//土地是否需要设定抵押
              otherNote:"",//其他情况说明
              /*房地产其他信息*/
              buildingNum:"",//所在楼座
              floor:"",//所在楼层(层）
              roomNum:"",//具体房号
              floorHeight:"",//层高（m）
              courtArea:"",//庭院面积（m2）
              manageStatus:"",//目前管理状况
              roomUser:"",//使用者
              direction:"",//进户门朝向
              houseModel:"",//户型
              fitmentDegree:"",//装修程度
              selfCarbarnInd:"",//有无私家车库
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
            /*房产其他信息opt*/
            DoorOrientationCd:enums.DoorOrientationCd,
            FitmentDegreeCd:enums.FitmentDegreeCd,
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
              isLandMortgage: [
                {
                  required: true,
                  message: "请选择",
                  trigger: 'change'
                }
              ],
              houseLicenseType: [
                {
                  required: true,
                  message: "请选择类型",
                  trigger: 'change'
                }
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
              assetLife: [
                {
                  required: false,
                  message: "请输入已使用年限",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'blur'
                },
                {
                  pattern: /^([1-9]\d*|[0]{1,1})$/,
                  message: '请输入正整数或者0',
                  trigger: 'blur'
                }
              ],
              buildAllArea: [
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
              /*房地产其他信息 rules*/
              floor: [
                {
                  required: true,
                  message: "请输入已使用年限",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'blur'
                },
                {
                  pattern: /^[0-9]*$/,
                  message: '请输入正整数或者0',
                  trigger: 'blur'
                }
              ],
              roomNum: [
                {
                  required: false,
                  message: "请输入具体房号",
                  trigger: 'change'
                },
                {
                  max: 20,
                  message: '长度不超过 20 个字符',
                  trigger: 'blur'
                }
              ],
              buildingNum: [
                {
                  required: false,
                  message: "请输入所在楼座",
                  trigger: 'change'
                },
                {
                  max: 5,
                  message: '长度不超过 5 个字符',
                  trigger: 'blur'
                }
              ],
              floorHeight: [
                {
                  required: true,
                  message: "请输入层高",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'blur'
                },
                {
                  pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
                  message: '请输入正确数值',
                  trigger: 'blur'
                }
              ],
              courtArea: [
                {
                  required: true,
                  message: "请输入庭院面积",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'blur'
                },
                {
                  pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
                  message: '请输入正确数值',
                  trigger: 'blur'
                }
              ],
              direction: [
                {
                  required: false,
                  message: "请选择",
                  trigger: 'change'
                }
              ],
              fitmentDegree: [
                {
                  required: false,
                  message: "请选择",
                  trigger: 'change'
                }
              ],
              selfCarbarnInd: [
                {
                  required: false,
                  message: "请选择",
                  trigger: 'change'
                }
              ],
              manageStatus: [
                {
                  required: false,
                  message: "请输入目前管理状况",
                  trigger: 'change'
                },
                {
                  max: 50,
                  message: '长度不超过 50 个字符',
                  trigger: 'blur'
                }
              ],
              roomUser: [
                {
                  required: false,
                  message: "请输入使用者",
                  trigger: 'change'
                },
                {
                  max: 50,
                  message: '长度不超过 50 个字符',
                  trigger: 'blur'
                }
              ],
              houseModel: [
                {
                  required: false,
                  message: "请输入户型",
                  trigger: 'change'
                },
                {
                  max: 50,
                  message: '长度不超过 50 个字符',
                  trigger: 'blur'
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
              updateRealEstateAndGrtCollateral(this.realEstate).then(response =>{
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
  .mpDetailRealEstate{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mpDetailRealEstate p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
