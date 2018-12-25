<!--详细信息  交通运输工具-->
<template>
    <div class="mp-detail-for-traffic-transport-tool">
      <el-row>
        <el-form el-form ref="mpTrafficTransportToolDetailValidate" label-width="200px" :model="trafficTransportToolInfo" label-position="right" :rules="rules" >
          <el-col :span="24">
            <p>抵质押基本信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="国家或地区" prop="countryAndRegion" >
              <el-select :disabled="inputComponentDisable"  v-model="trafficTransportToolInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.province"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="trafficTransportToolInfo.city"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.district"  placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable"  type="textarea" v-model="trafficTransportToolInfo.townBelow" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.mpGetWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.isPartOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="trafficTransportToolInfo.rightProveType" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.rightProveNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押权取得/占有时间"  >
              <el-date-picker v-model="trafficTransportToolInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.mpCertificateOffice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="trafficTransportToolInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="trafficTransportToolInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>抵制押物状态信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否可转让" prop="ifTransferOwner" >
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifTransferOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifWholeMortgage" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifToOtherOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifStateOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifGetApprove" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifBanCirculate" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifOwnerRightConfusion" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifSealDetainSuperVise" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifMpRightHasFlaw" placeholder="请选择" style="width:100%">
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
            <p>交通运输工具基本信息</p>
          </el-col>

          <el-col :span="12">
            <el-form-item label="运输工具名称" prop="tttName">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.tttName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="使用类型" prop="useType" >
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.useType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in useTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="承载能力" prop="loadCapacity">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.loadCapacity" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="制造年度" prop="productiveYear">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.productiveYear" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="制造地" prop="producePlace">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.producePlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="品牌" prop="brand">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.brand" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="规格型号" prop="specificationModel">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.specificationModel" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报废年限" >
              <el-date-picker v-model="trafficTransportToolInfo.scrappedYear" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="已使用年限" prop="haveUseYear">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.haveUseYear" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="购买日期" >
              <el-date-picker v-model="trafficTransportToolInfo.buyDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="出厂日期" >
              <el-date-picker v-model="trafficTransportToolInfo.outFactoryDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="原购置价格(元)" prop="originalPrice">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.originalPrice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="折余价值(元)" prop="restWorth">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.restWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="有无所有权证" prop="ifHaveOwnerCertify" >
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifHaveOwnerCertify" placeholder="请选择" style="width:100%">
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
            <el-form-item label="所有权证号" prop="ownerCertifyNumber">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ownerCertifyNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="所有权人名称" prop="ownerRightName">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ownerRightName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="有无运营证" prop="ifHaveOperationCertify" >
              <el-select :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ifHaveOperationCertify" placeholder="请选择" style="width:100%">
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
            <el-form-item label="运营证发证机关" prop="ocOffice">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.ocOffice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="运营证号" prop="operationCertifyNumber">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.operationCertifyNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发动机号" prop="engineNumber">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.engineNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="号牌" prop="numberPlate">
              <el-input :disabled="inputComponentDisable" v-model="trafficTransportToolInfo.numberPlate" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="事故记录" prop="accidentRecord" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="trafficTransportToolInfo.accidentRecord" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="trafficTransportToolInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmTrafficTransportToolDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-traffic-transport-tool",
      data(){
        return{
          trafficTransportToolInfo:{
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
            /*交通运输工具基本信息*/
            tttName:"",//运输工具名称
            useType:"运营",//使用类型
            loadCapacity:"",//承载能力
            productiveYear:"",//制造年度
            producePlace:"",//制造地
            brand:"",//品牌
            specificationModel:"",//规格型号
            scrappedYear:"",//报废年限
            haveUseYear:"",//已使用年限
            buyDate:"",//购买日期
            outFactoryDate:"",//出厂日期
            originalPrice:"",//原购置价(元)
            restWorth:"",//折余价值(元)
            ifHaveOwnerCertify:"有",//有无所有权证
            ownerCertifyNumber:"",//所有权证号
            ownerRightName:"",//所有权人名称
            ifHaveOperationCertify:"有",//有无运营证
            ocOffice:"",//运营证发证机关
            operationCertifyNumber:"",//运营证号
            engineNumber:"",//发动机号
            numberPlate:"",//号牌
            accidentRecord:"",//事故记录
            otherSituationExplain:"",//其他情况说明
          },//交通运输工具信息
          /*交通运输工具Opt*/
          useTypeOpt:[
            {
              value: '运营',
              label: '运营'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],

          /*交通运输工具类型抵押Opt end*/
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
            /*交通运输工具 rules部分*/
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
            restWorth: [
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
                required: true,
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
            producePlace: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveOwnerCertify: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            ifHaveOperationCertify: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            operationCertifyNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ocOffice: [
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
            tttName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            loadCapacity: [
              {
                required: false,
                message: "",
                trigger: 'change'
              }
            ],
            useType: [
              {
                required: true,
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
        doConfirmTrafficTransportToolDetail:function () {
          this.$refs["mpTrafficTransportToolDetailValidate"].validate((valid) => {
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
          this.$refs["mpTrafficTransportToolDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-traffic-transport-tool{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-traffic-transport-tool p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
