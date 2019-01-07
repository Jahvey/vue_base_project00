<template>
    <div class="mp-detail-for-other-mp">
      <el-row>
        <el-form el-form ref="mpOtherMpDetailValidate" label-width="200px" :model="mpOtherInfo" label-position="right" :rules="rules" >
            <el-col :span="24">
              <p>抵质押基本信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="国家或地区" prop="countryAndRegion" >
                <el-select :disabled="inputComponentDisable"  v-model="mpOtherInfo.countryAndRegion" placeholder="请选择" style="width:100%" >
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
                <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.province"  placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable"  v-model="mpOtherInfo.city"  placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.district"  placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable"  type="textarea" v-model="mpOtherInfo.townBelow" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押物获取途径" prop="mpGetWay" >
                <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.mpGetWay" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.guaranteeWorkWay" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.isPartOwner" placeholder="请选择" style="width:100%">
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
                <el-select :disabled="inputComponentDisable"  v-model="mpOtherInfo.rightProveType" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.rightProveNumber" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押权取得/占有时间"  >
                <el-date-picker v-model="mpOtherInfo.mpRightGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="抵质押物发证机关" prop="mpCertificateOffice" >
                <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.mpCertificateOffice" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <p>价值信息</p>
            </el-col>
            <el-col :span="12">
              <el-form-item label="币种" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.currency" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.evaluateWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定方式" prop="customerType" >
                <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
                <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.originalWorth" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定时间"  >
                <el-date-picker v-model="mpOtherInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="价值认定到期日"  >
                <el-date-picker v-model="mpOtherInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
          <el-col :span="24">
            <p>其他信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押品名称" prop="mpGoodsName" >
              <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.mpGoodsName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押品数量" prop="mpNumber" >
              <el-input :disabled="inputComponentDisable" v-model="mpOtherInfo.mpNumber" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="数量单位" prop="unit" >
              <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.unit" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in unitOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押品取得时间"  >
              <el-date-picker v-model="mpOtherInfo.mpGetTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押品有效到期日"  >
              <el-date-picker v-model="mpOtherInfo.mpEndTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否办理止付(登记)" prop="ifDoneStopPayment" >
              <el-select :disabled="inputComponentDisable" v-model="mpOtherInfo.ifDoneStopPayment" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="mpOtherInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmOtherMpDetail">{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>

</template>

<script>
    export default {
      name: "mp-detail-for-other-mp",
      data(){
        return{
          mpOtherInfo:{
            countryAndRegion:"中国",//国家或地区
            province:"四川",//省/直辖市/自治区
            city:"绵阳",//城市/自治州
            district:"涪城区",//区/县
            townBelow:"",//镇以下的信息
            mpGetWay:"其他",//抵质押物获取途径
            guaranteeWorkWay:"公证",//担保权认定生效方式
            isPartOwner:"否",//是否共同财产
            rightProveType:"其他",//权利证明类型
            rightProveNumber:"",//权利证明编号
            mpRightGetTime:"",//抵质押权取得/占有时间
            mpCertificateOffice:"",//抵质押物发证机关
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            mpGoodsName:"",//抵质押品名称
            mpNumber:"",//抵质押品数量
            unit:"个",//数量单位
            mpGetTime:"",//抵质押品取得时间
            mpEndTime:"",//抵质押品有效到期日
            ifDoneStopPayment:"是",//是否办理止付(登记)
            otherSituationExplain:"",//其他情况说明
          },
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
            /*价值*/
            currency: [
              {
                required: true,
                message: "请选择币种",
                trigger: 'change'
              }
            ],
            worthEvaluateWay: [
              {
                required: true,
                message: "请选择评估方式",
                trigger: 'change'
              }
            ],
            evaluateWorth: [
              {
                required: true,
                message: "请输入抵质押物认定价值",
                trigger: 'blur'},
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
            originalWorth: [
              {
                required: true,
                message: "请输入账面原值/取得价值",
                trigger: 'blur'},
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
            mpGoodsName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            mpNumber: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            unit: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifDoneStopPayment: [
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
          ],//省选项
          cityOpt:[
            {
              value: '绵阳市',
              label: '绵阳市'
            },
          ],//市选项
          districtOpt:[
            {
              value: '涪城区',
              label: '涪城区'
            },
          ],//区选项
          mpGetWayOpt:[
            {
              value: '承包',
              label: '承包'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],//
          guaranteeWorkWayOpt:[
            {
              value: '公证',
              label: '公证'
            },
            {
              value: '其他',
              label: '其他'
            },
          ],//担保权认定生效方式
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
          ],//权利证明类型选项
          buttonDisable:false,
          buttonText:"确定",
          inputComponentDisable:false,
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
          unitOpt:[
            {
              value: '个',
              label: '个'
            },
            {
              value: '件',
              label: '件'
            },
          ],
        }
      },
      methods:{
        doConfirmOtherMpDetail:function () {
          this.$refs["mpOtherMpDetailValidate"].validate((valid) => {
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
          this.$refs["mpOtherMpDetailValidate"].resetFields();
        },

      },
    }
</script>

<style scoped>
  .mp-detail-for-other-mp{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-other-mp p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
