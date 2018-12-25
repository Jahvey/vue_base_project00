<!--详细信息  机动车-->
<template>
    <div class="mp-detail-for-motor-vehicle">
      <el-row>
        <el-form el-form ref="mpMotorVehicleDetailValidate" label-width="200px" :model="motorVehicleInfo" label-position="right" :rules="rules" >
          <el-col :span="24">
            <p>抵质押基本信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="国家或地区" prop="countryAndRegion" >
              <el-select :disabled="inputComponentDisable"  v-model="motorVehicleInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.province"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="motorVehicleInfo.city"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.district"  placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable"  type="textarea" v-model="motorVehicleInfo.townBelow" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.mpGetWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.isPartOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="motorVehicleInfo.rightProveType" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.rightProveNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押权取得/占有时间"  >
              <el-date-picker v-model="motorVehicleInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.mpCertificateOffice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="motorVehicleInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="motorVehicleInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>抵制押物状态信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否可转让" prop="ifTransferOwner" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifTransferOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifWholeMortgage" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifToOtherOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifStateOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifGetApprove" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifBanCirculate" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifOwnerRightConfusion" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifSealDetainSuperVise" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifMpRightHasFlaw" placeholder="请选择" style="width:100%">
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
            <p>机动车基本信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="机动车辆名称" prop="mvName">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.mvName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="车牌号" prop="numberPlate">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.numberPlate" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="颜色" prop="carColor">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.carColor" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="动力燃料" prop="powerFuel" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.powerFuel" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in powerFuelOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发动机号" prop="engineNumber">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.engineNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="车架号" prop="carFrameNumber">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.carFrameNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原购置价格(元)" prop="originalPrice">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.originalPrice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="有无行驶证" prop="ifHaveDriverLicense" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifHaveDriverLicense" placeholder="请选择" style="width:100%">
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
            <el-form-item label="行驶证号码" prop="driverLicenseNumber">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.driverLicenseNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="行驶证发证机构" prop="driverLicenseOffice">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.driverLicenseOffice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="已行驶里程(公里)" prop="driveDistance">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.driveDistance" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="挂牌日期" >
              <el-date-picker v-model="motorVehicleInfo.plugLicensePlate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册地址" prop="registerPlace">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.registerPlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="权利人名称" prop="ownerRightName">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.ownerRightName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="有无附加费证" prop="ifHaveAlternativeMoneyCertify" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifHaveAlternativeMoneyCertify" placeholder="请选择" style="width:100%">
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
            <el-form-item label="有无运营证" prop="ifHaveOperationCertify" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.ifHaveOperationCertify" placeholder="请选择" style="width:100%">
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
            <el-form-item label="已使用年限(年)" prop="haveUseYear">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.haveUseYear" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="mvCurrency" >
              <el-select :disabled="inputComponentDisable" v-model="motorVehicleInfo.mvCurrency" placeholder="请选择" style="width:100%">
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
            <el-form-item label="制造商" prop="producer">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.producer" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="车龄(年)" prop="carAge">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.carAge" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="车品牌" prop="brand">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.brand" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="车型号" prop="specificationModel">
              <el-input :disabled="inputComponentDisable" v-model="motorVehicleInfo.specificationModel" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="出厂日期" >
              <el-date-picker v-model="motorVehicleInfo.outFactoryDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="购买日期" >
              <el-date-picker v-model="motorVehicleInfo.buyDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报废年限" >
              <el-date-picker v-model="motorVehicleInfo.scrappedYear" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="事故记录" prop="accidentRecord" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="motorVehicleInfo.accidentRecord" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="motorVehicleInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmMotorVehicleDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-motor-vehicle",
      data(){
        return{
          motorVehicleInfo:{
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
            /*机动车基本信息*/
            mvName:"",//机动车辆名称
            numberPlate:"",//车牌号
            carColor:"",//颜色
            powerFuel:"",//动力燃料
            engineNumber:"",//发动机号
            carFrameNumber:"",//车架号
            originalPrice:"",//原购置价格(元)
            ifHaveDriverLicense:"有",//有无行驶证
            driverLicenseNumber:"",//行驶证号码
            driverLicenseOffice:"",//行驶证发证机构
            driveDistance:"",//已行驶里程(km)
            plugLicensePlate:"",//挂牌日期
            registerPlace:"",//注册地址
            ownerRightName:"",//权利人名称
            ifHaveAlternativeMoneyCertify:"无",//有无附加费证
            ifHaveOperationCertify:"无",//有无运营证
            haveUseYear:"",//已使用年限
            mvCurrency:"人民币",//币种
            producer:"",//制造商
            carAge:"",//车龄(年)
            brand:"",//车品牌
            specificationModel:"",//车型号
            outFactoryDate:"",//出厂日期
            buyDate:"",//购买日期
            scrappedYear:"",//报废年限
            accidentRecord:"",//事故记录
            otherSituationExplain:"",//其他情况说明
          },//机动车信息
          /*机动车Opt*/
          powerFuelOpt:[
            {
              value: '柴油',
              label: '柴油'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          /*机动车类型抵押Opt end*/
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
            /*机动车 rules部分*/
            scrappedYear: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            buyDate: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            carAge: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ownerCertifyNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ownerRightName: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            engineNumber: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            driveDistance: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveOperationCertify: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveDriverLicense: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            driverLicenseNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            driverLicenseOffice: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            originalPrice: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            numberPlate: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            mvName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            plugLicensePlate: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            producer: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            specificationModel: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            productiveYear: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            brand: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            outFactoryDate: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            haveUseYear: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            carColor: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            powerFuel: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            carFrameNumber: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            registerPlace: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveAlternativeMoneyCertify: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            mvCurrency: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            accidentRecord: [
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
          buttonText:"确定",
          inputComponentDisable:false,
        }
      },
      methods:{
        doConfirmMotorVehicleDetail:function () {
          this.$refs["mpMotorVehicleDetailValidate"].validate((valid) => {
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
          this.$refs["mpMotorVehicleDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-motor-vehicle{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-motor-vehicle p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
