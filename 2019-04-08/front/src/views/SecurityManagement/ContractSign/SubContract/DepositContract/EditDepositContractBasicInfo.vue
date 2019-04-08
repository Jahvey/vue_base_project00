<!--保证金合同修改、查看页面-->
<template>
  <el-container class="edit-deposit-contract-basic-info" v-loading.fullscreen.lock="isLoading">
    <el-main style="height:530px;">
      <el-row>
        <el-form el-form label-width="200px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
          <el-row>
            <h3>基本信息</h3>
            <el-col :span="9" :offset="3">
              <el-form-item label="几日内存入保证金" prop="jrncrbzj">
                <el-input :disabled="inputComponentDisable" v-model="data.jrncrbzj"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="9" >
              <el-form-item label="保证金比例(%)" prop="bzjbl">
                <el-input :disabled="inputComponentDisable" v-model="data.bzjbl" @input.native="valueChange"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" :offset="3">
              <el-form-item label="币种" prop="bz" >
                <el-select :disabled="inputComponentDisable || inputComponentDisable4"  v-model="data.bz" placeholder="请选择" style="width:100%">
                  <el-option v-for="(value,key) in currencyCd" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="9" >
              <el-form-item label="保证金金额" prop="bzjje">
                <el-input :disabled="inputComponentDisable||inputComponentDisable2" v-model="data.bzjje"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" offset="3">
              <el-form-item label="保证金类型" prop="bzjlx" >
                <el-select :disabled="inputComponentDisable || inputComponentDisable3"  v-model="data.bzjlx" placeholder="请选择"  style="width:100%">
                  <el-option v-for="(value,key) in marginSortCd" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="9">
              <el-form-item label="保证金起始日" prop="beginDate"   :rules="[{ required:data.bzjlx == '02'? false:true, message: '请选择日期', trigger: 'change' }]">
                <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.beginDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="9" offset="3">
              <el-form-item label="保证金到期日" prop="endDate" :rules="[{ required:data.bzjlx == '02'? false:true, message: '请选择日期', trigger: 'change' }]">
                <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.endDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="9" >
              <el-form-item label="按年利率计息(%)" prop="anlljx" :rules="[{ required:data.bzjlx == '02'? false:true, message: '按年利率计息(%)不能为空', trigger: 'change' },{
                  max: 6,
                  message: '长度不超过 6 个字符',
                  trigger: 'change'
                },
                 {
                  pattern: /^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/,
                  message: '请输入0-100内的数，保留两位小数',
                  trigger: 'change'
                }
                ]">
                <el-input :disabled="inputComponentDisable" v-model="data.anlljx"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" offset="3">
              <el-form-item label="保证金结息周期" prop="bzjjxzq" >
                <el-select :disabled="inputComponentDisable"  v-model="data.bzjjxzq" placeholder="请选择" style="width:100%">
                  <el-option v-for="(value,key) in bzjjxzqCd" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="9" >
              <el-form-item label="其他计收利息方式" prop="qtjsxfs">
                <el-input :disabled="inputComponentDisable" v-model="data.qtjsxfs"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" offset="3">
              <el-form-item label="若保证金价值下降，应在几日内通知客户补充保证金" prop="jrtzkh">
                <el-input :disabled="inputComponentDisable" v-model="data.jrtzkh"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" >
              <el-form-item label="签订日期" prop="signDate" >
                <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.signDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="9" >
              <el-form-item label="担保范围" prop="subScope" >
                <el-select :disabled="inputComponentDisable"  v-model="data.subScope" placeholder="请选择" style="width:100%">
                  <el-option v-for="(value,key) in subScopeCd" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="21" :offset="3">担保范围说明：</el-col>
            <el-col :span="21" offset="3">
              <p>一：主合同项下的全部主债权本金、利息、罚息、复利、违约金、损害赔偿金、乙方实现债权的全部费用等</p>
              <p>二：主合同项下的合同金额对应的主债权本金及利息、罚息、复利、违约金、损害赔偿金、乙方实现债权的全部费用等</p>
            </el-col>
          </el-row>
          <el-row>
            <h3>通知和文书送达</h3>
            <el-row>
              <h4>甲方(保证人)送达地址和联系方式 </h4>
              <el-col :span="9" :offset="3">
                <el-form-item label="送达地址" prop="aSendAddr">
                  <el-input :disabled="inputComponentDisable" v-model="data.aSendAddr"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" >
                <el-form-item label="邮编" prop="aPostcode">
                  <el-input :disabled="inputComponentDisable" v-model="data.aPostcode"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="收件人" prop="aReceiver">
                  <el-input :disabled="inputComponentDisable" v-model="data.aReceiver"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9">
                <el-form-item label="电话" prop="aPhone">
                  <el-input :disabled="inputComponentDisable" v-model="data.aPhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="电子邮箱" prop="aEmail">
                  <el-input :disabled="inputComponentDisable" v-model="data.aEmail"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" >
                <el-form-item label="其他方式" prop="aOther">
                  <el-input :disabled="inputComponentDisable" v-model="data.aOther"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <h4>乙方(贷款人)送达地址和联系方式</h4>
              <el-col :span="9" :offset="3">
                <el-form-item label="送达地址" prop="bSendAddr">
                  <el-input :disabled="inputComponentDisable" v-model="data.bSendAddr"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" >
                <el-form-item label="邮编" prop="bPostcode">
                  <el-input :disabled="inputComponentDisable" v-model="data.bPostcode"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="收件人" prop="bReceiver">
                  <el-input :disabled="inputComponentDisable" v-model="data.bReceiver"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9">
                <el-form-item label="电话" prop="bPhone">
                  <el-input :disabled="inputComponentDisable" v-model="data.bPhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="电子邮箱" prop="bEmail">
                  <el-input :disabled="inputComponentDisable" v-model="data.bEmail"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <h4>丙方送达地址和联系方式 </h4>
              <el-col :span="9" :offset="3">
                <el-form-item label="送达地址" prop="cSendAddr">
                  <el-input :disabled="inputComponentDisable" v-model="data.cSendAddr"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" >
                <el-form-item label="邮编" prop="cPostcode">
                  <el-input :disabled="inputComponentDisable" v-model="data.cPostcode"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="收件人" prop="cReceiver">
                  <el-input :disabled="inputComponentDisable" v-model="data.cReceiver"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9">
                <el-form-item label="电话" prop="cPhone">
                  <el-input :disabled="inputComponentDisable" v-model="data.cPhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="电子邮箱" prop="cEmail">
                  <el-input :disabled="inputComponentDisable" v-model="data.cEmail"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <h4>丁方送达地址和联系方式 </h4>
              <el-col :span="9" :offset="3">
                <el-form-item label="送达地址" prop="dSendAddr">
                  <el-input :disabled="inputComponentDisable" v-model="data.dSendAddr"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" >
                <el-form-item label="邮编" prop="dPostcode">
                  <el-input :disabled="inputComponentDisable" v-model="data.dPostcode"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="收件人" prop="dReceiver">
                  <el-input :disabled="inputComponentDisable" v-model="data.dReceiver"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9">
                <el-form-item label="电话" prop="dPhone">
                  <el-input :disabled="inputComponentDisable" v-model="data.dPhone"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="电子邮箱" prop="dEmail">
                  <el-input :disabled="inputComponentDisable" v-model="data.dEmail"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-row>
          <el-row>
            <h3>仲裁方式</h3>
            <el-col :span="9" :offset="3">
              <el-form-item label="争议解决方式" prop="arbitrateType" >
                <el-select :disabled="inputComponentDisable"  v-model="data.arbitrateType"  placeholder="请选择" style="width:100%">
                  <el-option v-for="(value,key) in arbitrateTypeCd" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <!--诉讼和其他一个都不显示-->
            <!--仲裁-->
            <template v-if="data.arbitrateType=='02'">
              <el-col :span="9">
                <el-form-item label="仲裁委员会名称" prop="arbitrateName">
                  <el-input :disabled="inputComponentDisable" v-model="data.arbitrateName"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9" :offset="3">
                <el-form-item label="仲裁委员会地址" prop="arbitrateAddress">
                  <el-input :disabled="inputComponentDisable" v-model="data.arbitrateAddress"></el-input>
                </el-form-item>
              </el-col>
            </template>
            <!--指定诉讼-->
            <template v-if="data.arbitrateType=='04'">
              <el-col :span="9">
                <el-form-item label="指定诉讼法院" prop="legalCourt">
                  <el-input :disabled="inputComponentDisable" v-model="data.legalCourt"></el-input>
                </el-form-item>
              </el-col>
            </template>
          </el-row>
          <el-row>
            <h3>协议签署</h3>
            <el-col :span="9" :offset="3">
              <el-form-item label="甲方持有份数" prop="aHoldCount">
                <el-input :disabled="inputComponentDisable" v-model="data.aHoldCount"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9">
              <el-form-item label="乙方持有份数" prop="bHoldCount">
                <el-input :disabled="inputComponentDisable" v-model="data.bHoldCount"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" :offset="3">
              <el-form-item label="丙方持有份数" prop="dHoldCount">
                <el-input :disabled="inputComponentDisable" v-model="data.dHoldCount"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9">
              <el-form-item label="丁方持有份数" prop="eHoldCount">
                <el-input :disabled="inputComponentDisable" v-model="data.eHoldCount"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" :offset="3">
              <el-form-item label="第三方名称" prop="cName">
                <el-input :disabled="inputComponentDisable" v-model="data.cName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9">
              <el-form-item label="第三方持有份数" prop="cHoldCount">
                <el-input :disabled="inputComponentDisable" v-model="data.cHoldCount"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" :offset="3">
              <el-form-item label="共计份数" prop="totalCount">
                <el-input :disabled="inputComponentDisable" v-model="data.totalCount"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <h3></h3>
            <el-col :span="18" :offset="3">
              <el-form-item label="补充条款" prop="addClause">
                <el-input :disabled="inputComponentDisable" type="textarea" v-model="data.addClause"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-row>
      <el-row >
        <el-col :span="12" :offset="12">
          <el-button v-if="ifShowButton" size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" :loading="isLoading">{{buttonText}}</el-button>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
  import { getGrtConInfo,updateGrtConInfo} from '@/api/contractsign'
  import enums from "@/utils/enums"
    export default {
        name: "edit-deposit-contract-basic-info",
      props:{
        info:{
          type:Object,
        },
      },
      beforeMount() {
        if (this.info.isScan) {
          this.ifShowButton = false;
          this.inputComponentDisable = true;
        }
        this.buttonText='';
        this.isLoading=true;
        this.buttonDisable=true;
        getGrtConInfo(this.info).then(response=>{
          if(response.data.code == enums.stateCode.code.success){//返回数据成功
            //国结的产品 放开对币种的控制
            this.contractAmt = response.data.contractBean.contractAmt;
            this.mBzjbl = response.data.contractBean.mBzjbl;
            if (response.data.contractBean.productType.substring(0, 5).indexOf(
                "01007") != -1) {
              this.inputComponentDisable4 = false;
            }
            this.data = response.data.contractBean;
            this.buttonText='确认';
            this.isLoading=false;
            this.buttonDisable=false;
          } else{
            this.$message({
              message: '获取数据失败啦！'+JSON.stringify(response.data),
              type: 'error'
            });
          }
        });
      },
      data(){
          return{
            buttonDisable:false,
            isLoading:false,
            buttonText:"确认",
            inputComponentDisable:false,
            inputComponentDisable2:true,
            inputComponentDisable3:false,
            inputComponentDisable4:true,
            ifShowButton:true,
            marginSortCd:enums.marginSortCd,
            currencyCd:enums.currencyCd,
            subScopeCd:enums.subScopeCd,
            bzjjxzqCd:enums.bzjjxzqCd,
            proguarantyWayCd:enums.proguarantyWayCd,
            proguarantyTypeCd:enums.proguarantyTypeCd,
            proguarantyFormCd:enums.proguarantyFormCd,
            arbitrateTypeCd:enums.arbitrateTypeCd,
            contractAmt:"",//合同金额
            mBzjbl:"",//主合同的保证金比例
            data:{
              jrncrbzj:"",//几日内存入保证金
              bz:"CNY",//币种
              bzjbl:"",//保证金比例(%)
              bzjje:"",//保证金金额
              bzjlx:"",//保证金类型
              beginDate:"",//保证金起始日
              endDate:"",//保证金到期日
              anlljx:"",//按年利率计息(%)
              qtjsxfs:"",//其他计收利息方式
              bzjjxzq:"",//保证金结息周期
              jrtzkh:"",//若保证金价值下降，应在几日内通知客户补充保证金
              signDate:"",//签订日期
              subScope:"",//担保范围
              /*通知和文书送达*/
              aSendAddr:"",
              aPostcode:"",
              aReceiver:"",
              aPhone:"",
              aEmail:"",
              aOther:"",

              bSendAddr:"",
              bPostcode:"",
              bReceiver:"",
              bPhone:"",
              bEmail:"",

              cSendAddr:"",
              cPostcode:"",
              cReceiver:"",
              cPhone:"",
              cEmail:"",

              dSendAddr:"",
              dPostcode:"",
              dReceiver:"",
              dPhone:"",
              dEmail:"",
              /*仲裁方式*/
              arbitrateType:"",//仲裁方式
              arbitrateName:"",//仲裁委员会名称
              arbitrateAddress:"",//仲裁委员会地址
              legalCourt:"",//指定诉讼法院
              /*协议签署*/
              aHoldCount:"",//甲方持有份数
              bHoldCount:"",//乙方持有份数
              dHoldCount:"",//丙方持有份数
              eHoldCount:"",//丁方持有份数
              cName:"",//第三方名称
              cHoldCount:"",//第三方名称持有份数
              totalCount:"",//共计份数
              /*补充条款*/
              addClause:"",//补充条款
            },
            rules:{
              /*基本信息校验*/
              bzjjxzq:[
                {
                  required: true,
                  message: "请选择保证金结息周期",
                  trigger: 'change'
                },
              ],
              jrncrbzj:[
                {
                  required: true,
                  message: "几日内存入保证金不能为空",
                  trigger: 'change'
                },
                {
                  max: 8,
                  message: '长度不超过 8 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[+]{0,1}(\d+)$/,
                  message: '请输入整数',
                  trigger: 'change'
                }
              ],
              bzjbl:[
                {
                  required: true,
                  message: "保证金比例不能为空",
                  trigger: 'change'
                },
                {
                  max: 6,
                  message: '长度不超过 6 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/,
                  message: '请输入0-100内的数，保留两位小数',
                  trigger: 'change'
                }
              ],
              bzjlx:[
                {
                  required: true,
                  message: "请选择保证金类型",
                  trigger: 'change'
                },
              ],
              bz:[
                {
                  required: true,
                  message: "请选择币种",
                  trigger: 'change'
                },
              ],
              bzjje:[
                {
                  required: true,
                  message: "保证金金额不能为空",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                  message: '请输入正确的金额',
                  trigger: 'change'
                }
              ],
              signDate:[
                {
                  required: true,
                  message: "请选择日期",
                  trigger: 'change'
                },
              ],
              qtjsxfs:[
                {
                  required: false,
                  message: "请输入",
                  trigger: 'change'
                },
                {
                  max: 300,
                  message: '长度不超过 300 个字符',
                  trigger: 'change'
                },
              ],
              jrtzkh:[
                {
                  required: true,
                  message: "请输入正整数",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[1-9]\d*$/,
                  message: '请输入正整数',
                  trigger: 'change'
                }
              ],
              subScope:[
                {
                  required: true,
                  message: "请选择担保范围",
                  trigger: 'change'
                },
              ],
              proguarantyWay:[
                {
                  required: true,
                  message: "请选择保证保证方式",
                  trigger: 'change'
                },
              ],
              proguarantyType:[
                {
                  required: true,
                  message: "请选择保证保证类型",
                  trigger: 'change'
                },
              ],
              proguarantyForm:[
                {
                  required: true,
                  message: "请选择保证保证形式",
                  trigger: 'change'
                },
              ],
              /*通知和文书送达校验*/
              aSendAddr:[
                {
                  required: true,
                  message: "送达地址不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              aPostcode:[
                {
                  required: true,
                  message: "邮编不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              aReceiver:[
                {
                  required: true,
                  message: "收件人不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              aPhone:[
                {
                  required: true,
                  message: "电话不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              aEmail:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              aOther:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              bSendAddr:[
                {
                  required: true,
                  message: "送达地址不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              bPostcode:[
                {
                  required: true,
                  message: "邮编不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              bReceiver:[
                {
                  required: true,
                  message: "收件人不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              bPhone:[
                {
                  required: true,
                  message: "电话不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              bEmail:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],

              cSendAddr:[
                {
                  required: false,
                  message: "送达地址不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              cPostcode:[
                {
                  required: false,
                  message: "邮编不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              cReceiver:[
                {
                  required: false,
                  message: "收件人不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              cPhone:[
                {
                  required: false,
                  message: "电话不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              cEmail:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              dSendAddr:[
                {
                  required: false,
                  message: "送达地址不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              dPostcode:[
                {
                  required: false,
                  message: "邮编不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              dReceiver:[
                {
                  required: false,
                  message: "收件人不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              dPhone:[
                {
                  required: false,
                  message: "电话不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              dEmail:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              /*仲裁方式*/
              arbitrateType:[
                {
                  required: true,
                  message: "请选择仲裁方式",
                  trigger: 'change'
                },
              ],
              arbitrateName:[
                {
                  required: true,
                  message: "仲裁委员会名称不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              arbitrateAddress:[
                {
                  required: true,
                  message: "仲裁委员会地址不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              legalCourt:[
                {
                  required: true,
                  message: "指定诉讼法院不能为空",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                },
              ],
              /*协议签署*/
              cName:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 30,
                  message: '长度不超过 30 个字符',
                  trigger: 'change'
                }
              ],
              dHoldCount:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[1-9]\d*$/,
                  message: '请输入正整数',
                  trigger: 'change'
                }
              ],
              eHoldCount:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[1-9]\d*$/,
                  message: '请输入正整数',
                  trigger: 'change'
                }
              ],
              cHoldCount:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[1-9]\d*$/,
                  message: '请输入正整数',
                  trigger: 'change'
                }
              ],
              aHoldCount:[
                {
                  required: true,
                  message: "甲方持有份数不能为空",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[1-9]\d*$/,
                  message: '请输入正整数',
                  trigger: 'change'
                }
              ],
              bHoldCount:[
                {
                  required: true,
                  message: "乙方持有份数不能为空",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[1-9]\d*$/,
                  message: '请输入正整数',
                  trigger: 'change'
                }
              ],
              totalCount:[
                {
                  required: true,
                  message: "共计份数不能为空",
                  trigger: 'change'
                },
                {
                  max: 10,
                  message: '长度不超过 10 个字符',
                  trigger: 'change'
                },
                {
                  pattern: /^[1-9]\d*$/,
                  message: '请输入正整数',
                  trigger: 'change'
                }
              ],
              /*补充条款*/
              addClause:[
                {
                  required: false,
                  message: "",
                  trigger: 'change'
                },
                {
                  max: 100,
                  message: '长度不超过 100 个字符',
                  trigger: 'change'
                }
              ],
            },
          }
      },
      methods:{
        'data.bzjlx'(val){
          this.$nextTick(()=>{
            if(val !== '1'){

              //this.newBasicForm.govtOrgLevel='';// 政府机构级别,
            }
            this.$refs.data.validateField('anlljx');
            this.$refs.data.validateField('beginDate');
            this.$refs.data.validateField('endDate');
          })
        },
        valueChange(){
          var reg=/^(((\d|[1-9]\d)(\.\d{1,2})?)|100|100.0|100.00)$/;
          if(reg.test(this.data.bzjbl)){
            this.data.bzjje = (Math.ceil((this.contractAmt*this.data.bzjbl/100)*100)/100)+"";
          } else{
            this.data.bzjje="";
          }
        },
        comfirm(){
          this.$refs["validate"].validate((valid) => {
            if(valid){
              if(this.contractAmt==null || this.contractAmt=='' || Number(this.contractAmt) <=0){
                this.$message({
                  message: '请输入正确的合同金额',
                  type: 'error'
                });
                return;
              }
              if(this.mBzjbl!=null && this.mBzjbl!=''){
                if( Number(this.mBzjbl) > Number(this.data.bzjbl)){
                  alert("保证比例不能低于["+this.mBzjbl+"%]");
                  return ;
                }
              }
              this.buttonText='';
              this.isLoading=true;
              this.buttonDisable=true;
              updateGrtConInfo(this.data).then(response=>{
                if(response.data.code == enums.stateCode.code.success){//返回数据成功
                  this.$message({
                    message: '保存成功！',
                    type: 'success'
                  });
                } else{
                  this.$message({
                    message: JSON.stringify(response.data),
                    type: 'error'
                  });
                }
                this.buttonText='确认';
                this.isLoading=false;
                this.buttonDisable=false;
              });
            } else{
              this.$message({
                message: '请将信息填写完整',
                type: 'error'
              });
            }
          });
        }
      },
    }
</script>

<style scoped>
  .edit-deposit-contract-basic-info h3,.edit-deposit-contract-basic-info h4{
    border-bottom: 1px solid #ccc;
  }
  .edit-deposit-contract-basic-info h4{
    margin-left: 20px;
    margin-right: 20px;
  }
</style>
