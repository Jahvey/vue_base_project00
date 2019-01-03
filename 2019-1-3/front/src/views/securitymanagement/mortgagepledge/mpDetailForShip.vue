<!--详细信息  船舶-->
<template>
    <div class="mp-detail-for-ship">
      <el-row>
        <el-form el-form ref="mpShipDetailValidate" label-width="200px" :model="shipInfo" label-position="right" :rules="rules" >
          <el-col :span="24">
            <p>抵质押基本信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="国家或地区" prop="countryAndRegion" >
              <el-select :disabled="inputComponentDisable"  v-model="shipInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.province"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="shipInfo.city"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.district"  placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable"  type="textarea" v-model="shipInfo.townBelow" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.mpGetWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.isPartOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="shipInfo.rightProveType" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.rightProveNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押权取得/占有时间"  >
              <el-date-picker v-model="shipInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.mpCertificateOffice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="shipInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="shipInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>抵制押物状态信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否可转让" prop="ifTransferOwner" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifTransferOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifWholeMortgage" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifToOtherOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifStateOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifGetApprove" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifBanCirculate" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifOwnerRightConfusion" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifSealDetainSuperVise" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifMpRightHasFlaw" placeholder="请选择" style="width:100%">
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
            <p>船舶基本信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="运输工具营运执照号" prop="transportToolLicense">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.transportToolLicense" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="运输工具名称" prop="transportToolName">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.transportToolName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="载重(吨)" prop="carryCapacity">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.carryCapacity" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="功率" prop="power">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.power" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="功率单位" prop="powerUnit" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.powerUnit" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in powerUnitOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="制造年度" prop="productDate">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.productDate" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="制造商" prop="producer">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.producer" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="制造地" prop="productPlace">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.productPlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.specificationModel" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="大修次数" prop="fixTimes">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.fixTimes" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="事故记录" prop="accidentRecord" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="shipInfo.accidentRecord" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="船牌号" prop="shipNumber">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.shipNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="动力类型" prop="powerType" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.powerType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in powerTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="动力燃料" prop="powerFuel" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.powerFuel" placeholder="请选择" style="width:100%">
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
            <el-form-item label="燃料标号" prop="fuelNumber">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.fuelNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="总吨位" prop="totalTonnage">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.totalTonnage" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="排水量(M³)" prop="displacement">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.displacement" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="有无航运证" prop="ifHaveShipCertify" >
              <el-select :disabled="inputComponentDisable" v-model="shipInfo.ifHaveShipCertify" placeholder="请选择" style="width:100%">
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
            <el-form-item label="航运证件号" prop="shipCertifyNumber">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.shipCertifyNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="挂牌日期"  >
              <el-date-picker v-model="shipInfo.hangDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册地址" prop="registerPlace">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.registerPlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保险缴至日期"  >
              <el-date-picker v-model="shipInfo.insuranceEndTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原船主名称" prop="originalShipHost">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.originalShipHost" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="原购置价格" prop="originalPrice">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.originalPrice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="已行驶里程(海里)" prop="travelDistance">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.travelDistance" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="已使用年限(年)" prop="haveUseYear">
              <el-input :disabled="inputComponentDisable" v-model="shipInfo.haveUseYear" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="shipInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmShipDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-ship",
      data(){
        return{
          shipInfo:{
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
            /*船舶基本信息*/
            transportToolLicense:"",//运输工具营运执照号
            transportToolName:"",//运输工具名称
            carryCapacity:"",//载重(吨)
            power:"",//功率
            powerUnit:"千瓦",//功率单位
            productDate:"",//制造年度
            producer:"",//制造商
            productPlace:"",//制造地
            specificationModel:"",//规格型号
            fixTimes:"",//大修次数
            accidentRecord:"",//事故记录
            shipNumber:"",//船牌号
            powerType:"",//动力类型
            powerFuel:"",//动力燃料
            fuelNumber:"",//燃料标号
            totalTonnage:"",//总吨位
            displacement:"",//排水量(M³)
            ifHaveShipCertify:"",//有无航运证
            shipCertifyNumber:"",//航运证件号
            hangDate:"",//挂牌日期
            registerPlace:"",//注册地址
            insuranceEndTime:"",//保险缴至日期
            originalShipHost:"",//原船主姓名
            originalPrice:"",//原购置价格
            travelDistance:"",//已行驶里程(海里)
            haveUseYear:"",//已使用年限(年)
            otherSituationExplain:"",//其他情况说明
          },//船舶信息
          /*船舶Opt*/
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
            powerTypeOpt:[
              {
                value: '内燃',
                label: '内燃'
              },
              {
                value: '其他',
                label: '其他'
              },
            ],
            powerUnitOpt:[
            {
              value: '千瓦',
              label: '千瓦'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          /*房地产类型抵押Opt end*/
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
            /*船舶 rules部分*/
            registerPlace: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            originalShipHost: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            originalPrice: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            travelDistance: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            haveUseYear: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            displacement: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveShipCertify: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            shipCertifyNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            powerType: [
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
            fuelNumber: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            totalTonnage: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            shipNumber: [
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
            productPlace: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            fixTimes: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            power: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            powerUnit: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            carryCapacity: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            transportToolLicense: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            transportToolName: [
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
            producer: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            productDate: [
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
          },
          buttonDisable:false,
          buttonText:"确定",
          inputComponentDisable:false,
        }
      },
      methods:{
        doConfirmShipDetail:function () {
          this.$refs["mpShipDetailValidate"].validate((valid) => {
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
          this.$refs["mpShipDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-ship{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-ship p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
