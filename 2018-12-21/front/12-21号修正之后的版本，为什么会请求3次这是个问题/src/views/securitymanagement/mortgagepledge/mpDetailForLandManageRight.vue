<!--详细信息  土地经营权-->
<template>
    <div class="mp-detail-for-land-manage-right">
      <el-row >
        <el-form el-form ref="mpLandManageRightDetailValidate" label-width="200px" :model="landManageRightInfo" label-position="right" :rules="rules" >
          <el-col :span="24">
            <p>抵质押基本信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="国家或地区" prop="countryAndRegion" >
              <el-select :disabled="inputComponentDisable"  v-model="landManageRightInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.province"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="landManageRightInfo.city"  placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.district"  placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable"  type="textarea" v-model="landManageRightInfo.townBelow" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.mpGetWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.isPartOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable"  v-model="landManageRightInfo.rightProveType" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.rightProveNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押权取得/占有时间"  >
              <el-date-picker v-model="landManageRightInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.mpCertificateOffice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="landManageRightInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="landManageRightInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>抵制押物状态信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否可转让" prop="ifTransferOwner" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifTransferOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifWholeMortgage" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifToOtherOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifStateOwner" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifGetApprove" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifBanCirculate" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifOwnerRightConfusion" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifSealDetainSuperVise" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.ifMpRightHasFlaw" placeholder="请选择" style="width:100%">
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
            <p>土地承包经营权信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="产权人" prop="landOwner" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.landOwner" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地承包经营权性质" prop="landManageRightNature" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landManageRightNature" placeholder="请选择" style="width:100%">
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
            <el-form-item label="承包经营起始日"  >
              <el-date-picker v-model="landManageRightInfo.landManageStartTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="承包经营终止日"  >
              <el-date-picker v-model="landManageRightInfo.landManageEndTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="年承包费用(元)" prop="landManagePayment" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.landManagePayment" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="承包费缴纳方式" prop="landManagePayWay" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landManagePayWay" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in landManagePayWayOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="承包费到期日期" >
              <el-date-picker v-model="landManageRightInfo.landManagePaymentEndTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经营类别" prop="landManageType" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.landManageType" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经营规模" prop="landManageScale" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.landManageScale" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="承包经营届满日" >
              <el-date-picker v-model="landManageRightInfo.landManageLastDay" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地使用状态" prop="landWorkState" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landWorkState" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in landWorkStateOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="周边环境状况" prop="landEnvironmentState" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landEnvironmentState" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in landEnvironmentStateOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="承包土地面积(亩)" prop="landManageArea" >
              <el-input :disabled="inputComponentDisable" v-model="landManageRightInfo.landManageArea" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地使用权性质" prop="landUseRightNature" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landUseRightNature" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in landUseRightNatureOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="土地用途" prop="landUse" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landUse" placeholder="请选择" style="width:100%">
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
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landGetWay" placeholder="请选择" style="width:100%">
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
            <el-form-item label="土地出让金缴税情况" prop="landTransferFeeState" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landTransferFeeState" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in landTransferFeeStateOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="承包费用缴纳情况" prop="landContractPayState" >
              <el-select :disabled="inputComponentDisable" v-model="landManageRightInfo.landContractPayState" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in landContractPayStateOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="地上定作物说明" prop="landGroundContentExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="landManageRightInfo.landGroundContentExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="landManageRightInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmLandManageRightDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
      name: "mp-detail-for-land-manage-right",
      data(){
        return{
          landManageRightInfo:{
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
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            ifTransferOwner:"是",//是否可转让
            ifWholeMortgage:"是",//是否将全部价值抵押到我行
            ifToOtherOwner:"是",//是否租赁或许可他人使用
            ifStateOwner:"否",//是否国有资产
            ifGetApprove:"是",//是否取得国资部门批准
            ifBanCirculate:"否",//是否法律规定禁止流通财产
            ifOwnerRightConfusion:"否",//所有权是否有争议
            ifSealDetainSuperVise:"否",//是否查封、扣押或监管
            ifMpRightHasFlaw:"否",//抵质押物权是否存在瑕疵
            landOwner:"",//产权人
            landManageRightNature:"",//土地承包经营权性质
            landManageStartTime:"",//承包经营起始日
            landManageEndTime:"",//承包经营终止日
            landManagePayment:"",//年承包费用(元)
            landManagePayWay:"",//承包费缴纳方式
            landManagePaymentEndTime:"",//承包费到期日期
            landManageType:"",//经营类别
            landManageScale:"",//经营规模
            landManageLastDay:"",//承包经营届满日
            landWorkState:"",//土地使用状态
            landEnvironmentState:"",//周边环境状况
            landManageArea:"",//承包土地面积(亩)
            landUseRightNature:"集体",//土地使用权性质
            landUse:"农业用途",//土地用途
            landGetWay:"协议转让",//土地取得方式
            landTransferFeeState:"全部缴纳",//土地出让金缴税情况
            landContractPayState:"全部缴纳",//承包费用缴纳情况
            landGroundContentExplain:"",//地上定作物说明
            otherSituationExplain:"",//其他情况说明
          },//土地经营权基本信息
          landContractPayStateOpt:[
            {
              value: '全部缴纳',
              label: '全部缴纳'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          landTransferFeeStateOpt:[
            {
              value: '全部缴纳',
              label: '全部缴纳'
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
          landUseRightNatureOpt:[
            {
              value: '集体',
              label: '集体'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          landEnvironmentStateOpt:[
            {
              value: '优良',
              label: '优良'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          landWorkStateOpt:[
            {
              value: '使用',
              label: '使用'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          landManagePayWayOpt:[
            {
              value: '按年缴',
              label: '按年缴'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],
          landManageRightNature:[
            {
              value: '一手承包',
              label: '一手承包'
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
            landWorkState: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landManageScale: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landManageType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landManagePayWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landManagePayment: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landManageRightNature: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landOwner: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landEnvironmentState: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landManageArea: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            landUseRightNature: [
              {
                required: true,
                message: "请选择土地使用权性质",
                trigger: 'change'
              }
            ],
            landUse: [
              {
                required: true,
                message: "请选择土地用途",
                trigger: 'change'
              }
            ],
            landGetWay: [
              {
                required: true,
                message: "请选择土地获取方式",
                trigger: 'change'
              }
            ],
            landTransferFeeState: [
              {
                required: true,
                message: "请选择土地出让金缴税情况",
                trigger: 'change'
              }
            ],
            landContractPayState: [
              {
                required: true,
                message: "请选择承包费用缴纳情况",
                trigger: 'change'
              }
            ],
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
          },
          buttonDisable:false,
          buttonText:"确定",
          inputComponentDisable:false,
        }
      },
      methods:{
        doConfirmLandManageRightDetail:function () {
          this.$refs["mpLandManageRightDetailValidate"].validate((valid) => {
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
          this.$refs["mpSalaryAccountDetailValidate"].resetFields();
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
