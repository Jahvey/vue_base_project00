<!--质押合同基本信息-->
<template>
  <el-container class="mortgage-contract-basic-info" v-loading.fullscreen.lock="isLoading">
    <el-main style="height:530px;">
      <el-row>
        <el-form el-form label-width="200px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
          <el-row>
            <h3>基本信息</h3>
            <el-col :span="9" :offset="3">
              <el-form-item label="质押合同编号" prop="subcontractNum">
                <el-input :disabled="inputComponentDisable || inputComponentDisable2" v-model="data.subcontractNum"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9">
              <el-form-item label="质押合同纸质编号" prop="paperConNum">
                <el-input :disabled="inputComponentDisable" v-model="data.paperConNum"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9" :offset="3">
              <el-form-item label="质押人名称" prop="partyName">
                <el-input :disabled="inputComponentDisable || inputComponentDisable2" v-model="data.partyName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="9">
              <el-form-item label="是否最高额质押" prop="ifTopSubcon" >
                <el-select :disabled="inputComponentDisable"  v-model="data.ifTopSubcon" placeholder="请选择" style="width:100%">
                  <el-option v-for="(value,key) in holidayFlg" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="9" :offset="3">
              <el-form-item label="币种" prop="bz" >
                <el-select :disabled="inputComponentDisable"  v-model="data.bz" placeholder="请选择" style="width:100%">
                  <el-option v-for="(value,key) in currencyCd" :key="key" :label="value" :value="key"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <template v-if="data.ifTopSubcon =='0' || data.ifTopSubcon =='' || data.ifTopSubcon==null ">
              <el-col :span="9">
                <el-form-item label="质押合同金额" prop="subcontractAmt">
                  <el-input :disabled="inputComponentDisable" v-model="data.subcontractAmt"></el-input>
                </el-form-item>
              </el-col>
            </template>
            <template v-if="data.ifTopSubcon =='1'">
              <el-col :span="9">
                <el-form-item label="质押最高本金限额" prop="zgbjxe">
                  <el-input :disabled="inputComponentDisable" v-model="data.zgbjxe"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="9":offset="3" >
                <el-form-item label="质押额度起期" prop="beginDate" >
                  <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.beginDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="9" >
                <el-form-item label="质押额度止期" prop="endDate" >
                  <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.endDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
            </template>
            <el-col :span="9" :offset="3">
              <el-form-item label="签订日期" prop="signDate" >
                <el-date-picker  :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="data.signDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="9" >
              <el-form-item label="几个工作日内办理登记" prop="jggzrbldj">
                <el-input :disabled="inputComponentDisable" v-model="data.jggzrbldj"></el-input>
              </el-form-item>
            </el-col>
            <template v-if="data.ifTopSubcon =='0' || data.ifTopSubcon =='' || data.ifTopSubcon==null ">
              <el-col :span="9" :offset="3">
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
            </template>

          </el-row>
          <el-row>
            <h3>通知和文书送达</h3>
            <el-row>
              <h4>甲方(担保人)送达地址和联系方式 </h4>
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
      <el-row>
        <el-dialog
          class="dialog-style"
          :title="dialogTitle"
          :visible.sync="dialogVisible"
          :width="dialogWidth"
          :fullscreen="fullScreen"
          v-if='dialogVisible'
          :before-close="handleGoodsDetailInfoClose"
          append-to-body>
          <!--动态组件-->
          <compoment v-bind:is="currentView" v-bind:info="deliverData" v-on:backFlag="getMsg"></compoment>
        </el-dialog>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
  import { getGrtConInfo,updateGrtConInfo} from '@/api/contractsign'
  import enums from "@/utils/enums"
  import signMaxLoanConfirm from '../Common/SignMaxLoanConfirm'
    export default {
      name: "mortgage-contract-basic-info",
      props:{
        info:{
          type:Object,
        },
      },
      components:{
        signMaxLoanConfirm,
      },
      beforeMount(){
        if(this.info.isScan){
          this.ifShowButton = false;
          this.inputComponentDisable = true;
        }
        this.buttonText='';
        this.isLoading=true;
        this.buttonDisable=true;
        getGrtConInfo(this.info).then(response=>{
          if(response.data.code == enums.stateCode.code.success){//返回数据成功
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
          //对话框
          dialogWidth:"60%",//弹出框的宽度
          dialogVisible:false,//对话框
          fullScreen:false,//是否全屏
          currentView:"signMaxLoanConfirm",
          dialogTitle:'选择',
          deliverData:{},//传递的数据
          buttonDisable:false,
          isLoading:false,
          buttonText:"确认",
          inputComponentDisable:false,
          inputComponentDisable2:true,
          ifShowButton:true,
          holidayFlg:enums.holidayFlg,
          currencyCd:enums.currencyCd,
          subScopeCd:enums.subScopeCd,
          arbitrateTypeCd:enums.arbitrateTypeCd,
          data:{
            subcontractNum:"",//质押合同编号
            partyName:"",//质押人名称
            paperConNum:"",//质押合同纸质编号
            ifTopSubcon:"",//是否最高额质押
            bz:"",//币种
            subcontractAmt:"",//质押合同金额
            zgbjxe:"",//质押最高本金限额
            beginDate:"",//质押额度起期
            endDate:"",//质押额度止期
            signDate:"",//签订日期
            jggzrbldj:"",//几个工作日内办理登记
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
            subcontractNum:[
              {
                required: true,
                message: "质押合同编号不能为空",
                trigger: 'change'
              },
            ],
            partyName:[
              {
                required: true,
                message: "质押人名称不能为空",
                trigger: 'change'
              },
            ],
            paperConNum:[
              {
                required: true,
                message: "质押合同纸质编号不能为空",
                trigger: 'change'
              },
              {
                max: 30,
                message: '长度不超过 30 个字符',
                trigger: 'change'
              },
            ],
            ifTopSubcon:[
              {
                required: true,
                message: "请选择是否最高额质押",
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
            subcontractAmt:[
              {
                required: true,
                message: "质押合同金额不能为空",
                trigger: 'change'
              },
              {
                max: 20,
                message: '长度不超过 20 个字符',
                trigger: 'change'
              },
              {
                pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                message: '请输入正确的金额',
                trigger: 'change'
              }
            ],
            zgbjxe:[
              {
                required: true,
                message: "质押最高本金限额不能为空",
                trigger: 'change'
              },
              {
                max: 20,
                message: '长度不超过 20 个字符',
                trigger: 'change'
              },
              {
                pattern: /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,}$/,
                message: '请输入正确的金额',
                trigger: 'change'
              }
            ],
            beginDate:[
              {
                required: true,
                message: "请选择日期",
                trigger: 'change'
              },
            ],
            endDate:[
              {
                required: true,
                message: "请选择日期",
                trigger: 'change'
              },
            ],
            signDate:[
              {
                required: true,
                message: "请选择日期",
                trigger: 'change'
              },
            ],
            jggzrbldj:[
              {
                required: true,
                message: "工作日不能为空",
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
        comfirm(){
          this.$refs["validate"].validate((valid) => {
            if(valid){
              this.buttonText='';
              this.isLoading=true;
              this.buttonDisable=true;
              updateGrtConInfo(this.data).then(response=>{
                if(response.data.code == enums.stateCode.code.success){//返回数据成功
                  this.buttonText='确定';
                  this.isLoading=false;
                  this.buttonDisable=false;
                  if(this.data.ifTopSubcon=='1'){
                    //当为最高额时，需要另外操作
                    this.deliverData.conSubconId = this.data.conSubconId;//贷款合同与担保合同关系表id
                    this.deliverData.subcontractId = this.data.subcontractId;//贷款合同与担保合同关系表id
                    this.dialogTitle="最高额担保确认金额";
                    this.currentView='signMaxLoanConfirm';
                    this.dialogWidth='40%';
                    this.dialogVisible=true;
                  } else{
                    this.$message({
                      message: '保存成功！',
                      type: 'success'
                    });
                  }
                } else{
                  this.$message({
                    message: '操作失败啦！'+JSON.stringify(response.data),
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
        },
        getMsg: function (obj) {
          if (obj.flag === 'close') {
            this.dialogVisible = false;
          }
        }
      },

    }
</script>

<style scoped>
  .mortgage-contract-basic-info h3,.mortgage-contract-basic-info h4{
    border-bottom: 1px solid #ccc;
  }
  .mortgage-contract-basic-info h4{
    margin-left: 20px;
    margin-right: 20px;
  }
</style>
