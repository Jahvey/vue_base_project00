<!--详细信息  林权-->
<template>
  <div class="mp-detail-for-forest-right">
    <el-row>
      <el-form el-form ref="mpForestRightValidate" label-width="200px" :model="forestRightInfo" label-position="right" :rules="rules" >
        <el-col :span="24">
          <p>抵质押基本信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="国家或地区" prop="countryAndRegion" >
            <el-select :disabled="inputComponentDisable"  v-model="forestRightInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.province"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable"  v-model="forestRightInfo.city"  placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.district"  placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable"  type="textarea" v-model="forestRightInfo.townBelow" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.mpGetWay" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.isPartOwner" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable"  v-model="forestRightInfo.rightProveType" placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.rightProveNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押权取得/占有时间"  >
            <el-date-picker v-model="forestRightInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.mpCertificateOffice" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="customerType" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.currency" placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.evaluateWorth" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="customerType" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.originalWorth" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间"  >
            <el-date-picker v-model="forestRightInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  >
            <el-date-picker v-model="forestRightInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>抵制押物状态信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否可转让" prop="ifTransferOwner" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifTransferOwner" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifWholeMortgage" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifToOtherOwner" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifStateOwner" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifGetApprove" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifBanCirculate" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifOwnerRightConfusion" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifSealDetainSuperVise" placeholder="请选择" style="width:100%">
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
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.ifMpRightHasFlaw" placeholder="请选择" style="width:100%">
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
          <p>林权信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林权类型" prop="forestRightType" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.forestRightType" placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in forestRightTypeOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林权证编号" prop="forestRightCertifyNumber">
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.forestRightCertifyNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林地类型" prop="forestLandType" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.forestLandType" placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in forestLandTypeOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="面积(亩)" prop="forestArea">
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.forestArea" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林种" prop="forestSeedType" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.forestSeedType" placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in forestSeedTypeOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="树种" prop="treeSeed">
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.treeSeed" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林龄(年)" prop="forestAge">
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.forestAge" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林木数量(棵/株)" prop="treeNumber">
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.treeNumber" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林地所有权类型" prop="forestOwnerType" >
            <el-select :disabled="inputComponentDisable" v-model="forestRightInfo.forestOwnerType" placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in forestOwnerTypeOpt"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="林权剩余有效使用年限(年)" prop="restUseForestTime">
            <el-input :disabled="inputComponentDisable" v-model="forestRightInfo.restUseForestTime" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="四至界地" prop="otherSituationExplain" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="forestRightInfo.feature" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherSituationExplain" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="forestRightInfo.otherSituationExplain" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmForestRightDetail" >{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
        name: "mp-detail-for-forest-right",
      data(){
        return{
          forestRightInfo:{
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
            /*林权基本信息*/
            forestRightType:"人工商品木",//林权类型
            forestRightCertifyNumber:"",//林权证书编号
            forestLandType:"出让",//林地类型
            forestArea:"",//面积(亩)
            forestSeedType:"用材林",//林种
            treeSeed:"",//树种
            forestAge:"",//林龄(年)
            treeNumber:"",//林木数量(棵/株)
            forestOwnerType:"个人",//林地所有权类型
            restUseForestTime:"",//林权剩余有效期使用年限(年)
            feature:"",//四至界地
            otherSituationExplain:"",//其他情况说明
          },//林权信息
          /*林权Opt*/
          forestRightTypeOpt:[
            {
              value: '人工商品木',
              label: '人工商品木'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          forestLandTypeOpt:[
            {
              value: '出让',
              label: '出让'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          forestSeedTypeOpt:[
            {
              value: '用材林',
              label: '用材林'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          forestOwnerTypeOpt:[
            {
              value: '个人',
              label: '个人'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          /*林权Opt end*/
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
            /*林权 rules部分*/
            forestRightType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            forestRightCertifyNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            forestLandType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            forestArea: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            forestAge: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            treeSeed: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            treeNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            forestOwnerType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            restUseForestTime: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            feature: [
              {
                required: false,
                message: "请输入四至界地",
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
        doConfirmForestRightDetail:function () {
          this.$refs["mpForestRightValidate"].validate((valid) => {
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
          this.$refs["mpForestRightValidate"].resetFields();
        },
      },
    }
</script>

<style scoped>
  .mp-detail-for-forest-right{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-forest-right p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
