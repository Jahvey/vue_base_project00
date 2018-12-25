<!--详细信息 土地使用权-->
<template>
    <div class="mp-detail-for-land-use-right">
        <el-row>
          <el-form el-form ref="mpLandUseRightDetailValidate" label-width="200px" :model="landUseRightInfo" label-position="right" :rules="rules" >
            <el-col :span="24">
              <p>抵质押基本信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="国家或地区" prop="countryAndRegion" >
                <el-select :disabled="inputComponentDisable"  v-model="landUseRightInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.province"  placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable"  v-model="landUseRightInfo.city"  placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.district"  placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable"  type="textarea" v-model="landUseRightInfo.townBelow" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.mpGetWay" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.isPartOwner" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable"  v-model="landUseRightInfo.rightProveType" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.rightProveNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押权取得/占有时间"  >
                <el-date-picker v-model="landUseRightInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.mpCertificateOffice" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>价值信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="币种" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.currency" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.evaluateWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定方式" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.originalWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定时间"  >
                <el-date-picker v-model="landUseRightInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定到期日"  >
                <el-date-picker v-model="landUseRightInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>抵制押物状态信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否可转让" prop="ifTransferOwner" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifTransferOwner" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifWholeMortgage" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifToOtherOwner" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifStateOwner" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifGetApprove" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifBanCirculate" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifOwnerRightConfusion" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifSealDetainSuperVise" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifMpRightHasFlaw" placeholder="请选择" style="width:100%">
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
              <p>土地使用权</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地面积(M²)" prop="landArea" >
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.landArea" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地用途" prop="landUse" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.landUse" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in landUseOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地取得方式" prop="landGetWay" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.landGetWay" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in landGetWayOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="是否位于城市地带" prop="ifLocateCity" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifLocateCity" placeholder="请选择" style="width:100%">
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
              <el-form-item label="周边环境状况" >
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.landEnvironmentState" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="生熟状况" prop="ssProgress" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ssProgress" placeholder="请选择" style="width:100%">
                  <el-option
                    v-for="item in ssProgressOpt"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地权证所有人" prop="landRightOwner">
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.landRightOwner" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地权证号" prop="landRightCertifyNumber">
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.landRightCertifyNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="核发时间"  >
                <el-date-picker v-model="landUseRightInfo.checkDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="使用年限(年)" prop="useAbleYear">
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.useAbleYear" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="宗地号">
                <el-input :disabled="inputComponentDisable" v-model="landUseRightInfo.landNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="土地所有制性质" prop="landRightNature" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.landRightNature" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.landUseRightType" placeholder="请选择" style="width:100%">
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
              <el-form-item label="土地出让金是否缴清" prop="ifPayLandTransferMoney" >
                <el-select :disabled="inputComponentDisable" v-model="landUseRightInfo.ifPayLandTransferMoney" placeholder="请选择" style="width:100%">
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
              <el-form-item label="地上定作物说明" prop="landGroundContentExplain" >
                <el-input :disabled="inputComponentDisable" type="textarea" v-model="landUseRightInfo.landGroundContentExplain" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24" >
              <el-form-item label="其他情况说明" prop="otherSituationExplain" >
                <el-input :disabled="inputComponentDisable" type="textarea" v-model="landUseRightInfo.otherSituationExplain" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
        <el-row>
          <el-col :span="6" :offset="10">
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmLandUseRightDetail" >{{buttonText}}</el-button>
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
          </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
      name: "mp-detail-for-land-use-right",
      data(){
        return{
          landUseRightInfo:{
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
            /*土地使用权*/
            landArea:"",//土地面积(M²)
            landUse:"农业用地",//土地用途
            landGetWay:"协议转让",//土地取得方式
            ifLocateCity:"是",//是否位于城市地带
            landEnvironmentState:"",//周边环境状况
            ssProgress:"四通一平",//生熟程度
            landRightOwner:"",//土地权证所有人
            landRightCertifyNumber:"",//土地权证号
            checkDate:"",//核发日期
            useAbleYear:"",//使用年限(年)
            landNumber:"",//宗地号
            landRightNature:"国有",//土地所有制性质
            landUseRightType:"划拨",//土地使用权类型
            ifPayLandTransferMoney:"",//土地出让金是否缴清
            landGroundContentExplain:"",//地上定作物说明
            otherSituationExplain:"",//其他情况说明
          },//土地使用权信息
          /*土地使用权Opt*/
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
            ssProgressOpt:[
              {
                value: '四通一平',
                label: '四通一平'
              },
              {
                value: '其他',
                label: '其他'
              },
            ],
            landGetWayOpt:[
              {
                value: '协议转让',
                label: '协议转让'
              },
              {
                value: '其他',
                label: '其他'
              },
            ],
            landUseOpt:[
              {
                value: '农业用途',
                label: '农业用途'
              },
              {
                value: '其他',
                label: '其他'
              },
            ],
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
            /*土地使用权 rules部分*/
            landGroundContentExplain: [
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
            ifPayLandTransferMoney: [
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
            landRightNature: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            useAbleYear: [
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
            ssProgress: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifLocateCity: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landGetWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landUse: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landArea: [
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
        doConfirmLandUseRightDetail:function () {
          this.$refs["mpLandUseRightDetailValidate"].validate((valid) => {
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
          this.$refs["mpLandUseRightDetailValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-land-use-right{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-land-use-right p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
