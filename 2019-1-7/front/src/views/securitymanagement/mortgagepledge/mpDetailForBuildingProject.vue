<!--详细信息 在建工程-->
<template>
    <div class="mp-detail-for-building-project">
        <el-row>
          <el-form el-form ref="mpBuildingProjectDetailValidate" label-width="200px" :model="buildingProjectInfo" label-position="right" :rules="rules" >
            <el-col :span="24">
              <p>抵质押基本信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="国家或地区" prop="countryAndRegion" >
                <el-select :disabled="inputComponentDisable"  v-model="buildingProjectInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
                  <el-option
                    v-for="item in countryAndRegionOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="省/直辖市/自治区" prop="province" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.province"  placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in provinceOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="城市/自治州" prop="city" >
                <el-select :disabled="inputComponentDisable"  v-model="buildingProjectInfo.city"  placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in cityOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="区/县" prop="district" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.district"  placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in districtOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="24" >
              <el-form-item label="镇/街道、门牌号" prop="townBelow" >
                <el-input :disabled="inputComponentDisable"  type="textarea" v-model="buildingProjectInfo.townBelow" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.mpGetWay" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in mpGetWayOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="担保权认定生效方式" prop="guaranteeWorkWay" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in guaranteeWorkWayOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否共同财产" prop="isPartOwner" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.isPartOwner" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="权利证明类型" prop="rightProveType" >
                <el-select :disabled="inputComponentDisable"  v-model="buildingProjectInfo.rightProveType" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in rightProveTypeOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="权利证明编号" prop="rightProveNumber" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.rightProveNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押权取得/占有时间"  >
                <el-date-picker v-model="buildingProjectInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.mpCertificateOffice" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>价值信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="币种" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.currency" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.evaluateWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定方式" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.originalWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定时间"  >
                <el-date-picker v-model="buildingProjectInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定到期日"  >
                <el-date-picker v-model="buildingProjectInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>抵制押物状态信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否可转让" prop="ifTransferOwner" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifTransferOwner" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否将全部价值抵押到我行" prop="ifWholeMortgage" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifWholeMortgage" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否租赁或许可他人使用" prop="ifToOtherOwner" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifToOtherOwner" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否国有资产" prop="ifStateOwner" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifStateOwner" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否取得国资部门批准" prop="ifGetApprove" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifGetApprove" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否法律规定禁止流通财产" prop="ifBanCirculate" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifBanCirculate" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所有权是否有争议" prop="ifOwnerRightConfusion" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifOwnerRightConfusion" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否查封、扣押或监管" prop="ifSealDetainSuperVise" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifSealDetainSuperVise" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押物权是否存在瑕疵" prop="ifMpRightHasFlaw" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifMpRightHasFlaw" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>房地产类型抵押信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="房屋使用类型" prop="houseUseType" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseUseType" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in houseUseTypeOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="地理位置" prop="houseLocationState" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseLocationState" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in houseLocationStateOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="变现能力" prop="cashAbility" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.cashAbility" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in cashAbilityOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="总层数(层)" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.totalLayer" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="建筑面积(M²)" prop="buildingArea" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.buildingArea" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="用地面积" prop="landUseArea" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landUseArea" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="建筑年代"  >
                <el-date-picker v-model="buildingProjectInfo.buildingYear" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="建筑结构" prop="buildingStructure" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.buildingStructure" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in buildingStructureOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否位于城市地带" prop="ifLocateCity" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifLocateCity" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="已使用年限(年)"  >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.useYear" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="有无房产权证" prop="ifHaveLandCertify" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifHaveLandCertify" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in notOrHaveOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="房产权证类型" prop="houseRightCertifyType" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseRightCertifyType" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in houseRightCertifyTypeOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="房产权证号" prop="houseRightCertifyNumber" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseRightCertifyNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="房产权证人名称" prop="houseRightOwner" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.houseRightOwner" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="有无土地证" prop="ifHaveLandCertify" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifHaveLandCertify" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="核发日期"  >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.checkDate" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地权证类型" prop="landRightCertifyType" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landRightCertifyType" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地证号" prop="landRightCertifyNumber" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landRightCertifyNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地权证人名称" prop="landRightOwner" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.landRightOwner" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地所有制性质" prop="landRightNature" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.landRightNature" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in landRightNatureOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地使用权类型" prop="landUseRightType" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.landUseRightType" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in landUseRightTypeOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地是否需要设定抵押" prop="ifSetMp" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifSetMp" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="24" >
              <el-form-item label="其他情况说明" prop="otherSituationExplain" >
                <el-input :disabled="inputComponentDisable" type="textarea" v-model="buildingProjectInfo.otherSituationExplain" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>在建工程信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="项目用途" prop="projectUseType" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.projectUseType" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="已完工建筑面积(M²)" prop="finishArea" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.finishArea" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="总投资预算(元)" prop="investmentBudget" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.investmentBudget" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="工程原设计规模(M²)" prop="originalDesignScale" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.originalDesignScale" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵押面积(M²)" prop="mpArea" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.mpArea" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="工程形象进度" prop="projectProgress" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.projectProgress" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="累计完成投资额(元)" prop="currentFinishMoney" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.currentFinishMoney" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="项目现状" prop="projectState" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.projectState" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="建设单位" prop="buildConstitution" >
                <el-input :disabled="inputComponentDisable" v-model="buildingProjectInfo.buildConstitution" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否拖欠工程款" prop="ifDefaultMoney" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifDefaultMoney" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="有无工程规划许可证" prop="ifHaveProjectCertify" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifHaveProjectCertify" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in notOrHaveOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="有无建设用地规划许可证" prop="ifHavePlanCertify" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifHavePlanCertify" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in notOrHaveOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="有无建筑工程施工许可证" prop="ifHaveBuildCertify" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifHaveBuildCertify" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in notOrHaveOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地出让金是否缴清" prop="ifPayLandTransferMoney" >
                <el-select :disabled="inputComponentDisable" v-model="buildingProjectInfo.ifPayLandTransferMoney" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in yesNotOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmBuildingProjectDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
      name: "mp-detail-for-building-project",
      data(){
        return{
          buildingProjectInfo:{
            /*抵质押物基本信息*/
            countryAndRegion:"中国",//国家或地区
            province:"四川",//省/直辖市/自治区
            city:"绵阳",//城市/自治州
            district:"涪城区",//区/县
            townBelow:"",//镇以下的信息
            mpGetWay:"",//抵质押物获取途径
            guaranteeWorkWay:"",//担保权认定生效方式
            isPartOwner:"",//是否共同财产
            rightProveType:"",//权利证明类型
            rightProveNumber:"",//权利证明编号
            mpRightGetTime:"",//抵质押权取得/占有时间
            mpCertificateOffice:"",//抵质押物发证机关
            /*价值信息*/
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*抵质押物状态信息*/
            ifTransferOwner:"是",//是否可转让
            ifWholeMortgage:"是",//是否将全部价值抵押到我行
            ifToOtherOwner:"是",//是否租赁或许可他人使用
            ifStateOwner:"否",//是否国有资产
            ifGetApprove:"是",//是否取得国资部门批准
            ifBanCirculate:"否",//是否法律规定禁止流通财产
            ifOwnerRightConfusion:"否",//所有权是否有争议
            ifSealDetainSuperVise:"否",//是否查封、扣押或监管
            ifMpRightHasFlaw:"否",//抵质押物权是否存在瑕疵
            /*房地产类型抵押信息*/
            houseUseType:"住宅",//房屋使用类型
            houseLocationState:"好",//地理位置
            cashAbility:"易变现",//变现能力
            totalLayer:"",//总层数(层)
            buildingArea:"",//建筑面积(M²)
            landUseArea:"",//用地面积(M²)
            buildingYear:"",//建筑年代
            buildingStructure:"瓦混结构",//建筑结构
            ifLocateCity:"是",//是否位于城市地带
            useYear:"",//已使用年限(年)
            ifHouseRightCertify:"是",//有无房产权证
            houseRightCertifyType:"房屋所有权证",//房产权证类型
            houseRightCertifyNumber:"",//房产权证号
            houseRightOwner:"",//房产权证人名称
            ifHaveLandCertify:"有",//有无土地证
            checkDate:"",//核发日期
            landRightCertifyType:"",//土地权证类型
            landRightCertifyNumber:"",//土地证号
            landRightOwner:"",//土地权证人名称
            landRightNature:"国有",//土地所有制性质
            landUseRightType:"划拨",//土地使用权类型
            ifSetMp:"是",//土地是否需要设定抵押
            otherSituationExplain:"",//其他情况说明
            /*在建工程信息*/
            projectUseType:"",//项目用途
            finishArea:"",//已完工建筑面积(M²)
            investmentBudget:"",//总投资预算(元)
            originalDesignScale:"",//工程原设计规模(M²)
            mpArea:"",//抵押面积(M²)
            projectProgress:"",//工程形象进度(%)
            currentFinishMoney:"",//累计完成投资额(元)
            projectState:"",//项目现状
            ifDefaultMoney:"",//是否拖欠工程款
            ifHaveProjectCertify:"",//有无工程规划许可证
            ifHavePlanCertify:"",//有无建设用地规划许可证
            buildConstitution:"",//建设单位
            ifHaveBuildCertify:"",//有无建筑工程施工许可证
            ifPayLandTransferMoney:"",//土地出让金是否缴清
          },//在建工程信息
          /*房地产类型抵押Opt*/
          landUseRightTypeOpt:[
            {
              value: '划拨',
              label: '划拨'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          landRightNatureOpt:[
            {
              value: '国有',
              label: '国有'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          notOrHaveOpt:[
            {
              value: '有',
              label: '有'
            },
            {
              value: '无',
              label: '无'
            },
          ],
          houseRightCertifyTypeOpt:[
            {
              value: '房屋所有权证',
              label: '房屋所有权证'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          buildingStructureOpt:[
            {
              value: '瓦混结构',
              label: '瓦混结构'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          cashAbilityOpt:[
            {
              value: '易变现',
              label: '易变现'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          houseLocationStateOpt:[
            {
              value: '好',
              label: '好'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          houseUseTypeOpt:[
            {
              value: '住宅',
              label: '住宅'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
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
          mpGetWayOpt:[
            {
              value: '承包',
              label: '承包'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          guaranteeWorkWayOpt:[
            {
              value: '公证',
              label: '公证'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          yesNotOpt:[
            {
              value: '是',
              label: '是'
            },
            {
              value: '否',
              label: '否'
            },
          ],
          rightProveTypeOpt:[
            {
              value: '农村土地承包经营权',
              label: '农村土地承包经营权'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
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
          rules:{
            /*价值信息 rules*/
            worthEvaluateWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            originalWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            evaluateWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            currency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            /*抵质押基本信息 rules*/
            mpCertificateOffice: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            rightProveNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            rightProveType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            isPartOwner: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            guaranteeWorkWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            mpGetWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            townBelow: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            district: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            city: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            province: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            countryAndRegion: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            /*抵质押物状态信息*/
            ifTransferOwner: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifWholeMortgage: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifToOtherOwner: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifStateOwner: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifGetApprove: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifBanCirculate: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifOwnerRightConfusion: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifSealDetainSuperVise: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            ifMpRightHasFlaw: [
              {
                required: true,
                message: "请选择是否",
                trigger: 'change'
              }
            ],
            /*房地产类型抵押信息rules部分*/
            houseRightCertifyType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifHouseRightCertify: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landUseArea: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            buildingArea: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            cashAbility: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            houseLocationState: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            houseUseType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            houseRightCertifyNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landUseRightType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            houseRightOwner: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landRightNature: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifSetMp: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveLandCertify: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landRightCertifyType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landRightCertifyNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landRightOwner: [
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
            /*在建工程信息 rules*/
            ifPayLandTransferMoney: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveBuildCertify: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            buildConstitution: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifHavePlanCertify: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveProjectCertify: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifDefaultMoney: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            projectState: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            currentFinishMoney: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            projectProgress: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            mpArea: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            originalDesignScale: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            finishArea: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            investmentBudget: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            projectUseType: [
              {
                required: true,
                message: "",
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
        doConfirmBuildingProjectDetail:function () {
          this.$refs["mpBuildingProjectDetailValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击
              this.buttonDisable = true;
              this.inputComponentDisable = true;
              this.buttonText = "已提交";
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
          this.$refs["mpBuildingProjectDetailValidate"].resetFields();
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
