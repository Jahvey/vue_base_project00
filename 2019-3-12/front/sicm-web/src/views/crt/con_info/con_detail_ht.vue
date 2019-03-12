<!--con_detail_ht的信息，使用原生element-ui写这个界面-->
<template>
  <el-row :gutter="20" class="form">
    <el-form  label-width="200px"  size="medium"
    :rules="rules" :model="conInfoForm" ref="conInfoForm"
             label-position="right"
             :disabled=isconInfoForm>


    <div id="table1">
      <el-col :span="12">
        <el-form-item label="客户名称:" prop="partyName" class="special-input">
          <el-input v-model="conInfoForm.partyName" style="width:100%" :disabled=true></el-input>
          <!--style="width:150px"-->
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="客户编号:" prop="partyNum" class="special-input">
          <el-input v-model="conInfoForm.partyNum" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="业务品种:" prop="productType" class="special-input">
          <el-select v-model="conInfoForm.productType" style="width:100%" :disabled=true >
            <el-option v-for="(value,key) in productType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="合同编号:" prop="contractNum" class="special-input">
          <el-input v-model="conInfoForm.contractNum" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="纸质合同编号:" prop="paperConNum" class="special-input">
          <el-input v-model="conInfoForm.paperConNum" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="原合同编号:" prop="oldContractNum" class="special-input">
          <el-input v-model="conInfoForm.oldContractNum" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="币种:" prop="currencyCd" class="special-input">
          <el-select v-model="conInfoForm.currencyCd" style="width:100%" :disabled=isCurrencyCd @change="bzChange">
            <el-option v-for="(value,key) in currencyCd" :key="key" :label="value" :value="key"></el-option>
          </el-select>
          
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="金额:" prop="contractAmt" class="special-input">
          <el-input type="number" v-model.number="conInfoForm.contractAmt" style="width:100%" :disabled=isContractAmt></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="保证金比例:" prop="bzjbl" class="special-input" v-show="assure_per" >
          <el-input v-model="conInfoForm.bzjbl" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="起始日期:" prop="beginDate" class="special-input">
          <el-date-picker type="date" format="yyyy-MM-dd" v-model="conInfoForm.beginDate"
                          style="width:100%" placeholder="选择起始日期" :disabled=isXgbz
                          @change="validateBeginDate"></el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="合同期限:" prop="sqqx" class="special-input">
          <el-input v-model="conInfoForm.contractTerm" style="width:60%;float:left" @blur="getConEndate"></el-input>
          <el-select v-model="conInfoForm.cycleUnit" style="width:40%;float:left" :disabled=false >
            <el-option v-for="(value,key) in cycleUnit" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="到期日期:" prop="endDate" class="special-input">
          <el-date-picker type="date" format="yyyy-MM-dd" v-model="conInfoForm.endDate"
                          style="width:100%" placeholder="选择截止日期" :disabled=isXgbz 
                          @change="getTerm"></el-date-picker>
         
        </el-form-item>
      </el-col>
    </div>



    <div id="hkxx" v-show="hkxx">
      <el-col :span="12" v-show="hkfs">
        <el-form-item label="还款方式:" prop="repaymentType" class="special-input">

          <el-select v-model="conInfoForm.repaymentType" style="width:100%" :disabled=isRepaymentType @change="conRpTpChg">
            <el-option v-for="(value,key) in repaymentType" :key="key" :label="value" :value="key"></el-option>
          </el-select>

          
        </el-form-item>
      </el-col>
      <el-col :span="12" v-if="schkq">
        <el-form-item label="首次还款期次:" prop="firstRepayTerm" class="special-input">
          <el-input v-model="conInfoForm.firstRepayTerm" style="width:100%" :disabled=isFirstRepayTerm></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12" v-if="zdhkr">
        <el-form-item label="指定还款日:" prop="specPaymentDate" class="special-input">
          <el-input v-model="conInfoForm.specPaymentDate" style="width:100%" :disabled=isXgbz placeholder="请指定还款日"></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12" v-if="jgts">
        <el-form-item label="间隔天数:" prop="internalDays" class="special-input">
          <el-input v-model="conInfoForm.internalDays" style="width:100%" :disabled=true></el-input>
        </el-form-item>
      </el-col>

    </div>

    <div>
      <el-col :span="12">
        <el-form-item label="合同循环标识:" prop="cycleIndCon" class="special-input">
          <el-select v-model="conInfoForm.cycleIndCon" style="width:100%" :disabled=isCycleIndCon >
            <el-option v-for="(value,key) in cycleIndCon" :key="key" :label="value" :value="key"></el-option>
          </el-select>
         
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="签约日期:" prop="contractDate" class="special-input">
          <el-date-picker type="date" format="yyyy-MM-dd" v-model="conInfoForm.contractDate"
                          style="width:100%" :disabled=isXgbz placeholder="请选择签约日期" @change="qyrq"></el-date-picker>
                           <!-- @change="childValidateEndDate" -->
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="签约地点:" prop="contractAddress" class="special-input">
          <el-input v-model="conInfoForm.contractAddress" style="width:100%" :disabled=isXgbz></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="贷款用途:" prop="loanUse" class="special-input">
          <el-input v-model="conInfoForm.loanUse" style="width:100%" :disabled=isXgbz></el-input>
        </el-form-item>
      </el-col>
    </div>

    <div id="exchangeRate" v-show="exchangeRate">
      <el-col :span="12">
        <el-form-item label="汇率:" prop="exchangeRate" class="special-input">
          <el-input v-model="conInfoForm.exchangeRate" style="width:100%" :disabled=true ></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="折算人民币金额:" prop="rmbAmt" class="special-input">
          <el-input v-model="conInfoForm.rmbAmt" style="width:100%" :disabled=true @change="validAmt"></el-input>
        </el-form-item>
      </el-col>


    </div>

    <div id="dbfs" v-show="dbfs">
      <el-col :span="12">
        <el-form-item label="担保方式:" prop="guarantyType" class="special-input">
          <el-select v-model="conInfoForm.guarantyType" style="width:100%" :disabled=true @change="guarantyTypechg">
            <el-option v-for="(value,key) in guarantyType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="主担保方式:" prop="mainGuarantyType" class="special-input">
          <el-select v-model="conInfoForm.mainGuarantyType" style="width:100%" :disabled=true>
            <el-option v-for="(value,key) in mainGuarantyType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </div>

    <div id="nongdandai" v-show="nongdandai">
      <el-col :span="12">
        <el-form-item label="是否融单:" prop="agriculLoans" class="special-input">
          <el-select v-model="conInfoForm.agriculLoans" style="width:100%" :disabled=true @change="changeCon">
            <el-option v-for="(value,key) in agriculLoans" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>

    </div>




  <fieldset id="bzxx" v-show="bzxx">
    <legend>
      <span>标志信息</span>
    </legend>
    <hr>
    <div id="table2" v-show="table2">
      <el-col :span="12">
        <el-form-item label="行业投向:" prop="loanTurn" class="special-input">
          <el-select v-model="conInfoForm.loanTurn" style="width:100%" :disabled=isXgbz @change="selectTrade4">
            <el-option v-for="(value,key) in loanTurn" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="涉及环境、安全等重大情况:" prop="riskInfo" class="special-input">
          <el-select v-model="conInfoForm.riskInfo" style="width:100%" :disabled=isXgbz>
            <el-option v-for="(value,key) in riskInfo" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </div>
    <div id="cqcs"  v-show="cqcs">
      <el-col :span="12">
        <el-form-item label="采取措施:" prop="act" class="special-input">
          <el-select v-model="conInfoForm.act" style="width:100%" :disabled=isXgbz>
            <el-option v-for="(value,key) in act" :key="key" :label="value" :value="key"></el-option>
          </el-select>

        </el-form-item>
      </el-col>
    </div>

    <div >
      <el-col :span="12">
        <el-form-item label="节能环保项目及服务类型:" prop="serviceType" class="special-input">
          <el-select v-model="conInfoForm.serviceType" style="width:100%" :disabled=isXgbz @change="servicetype">
            <el-option v-for="(value,key) in serviceType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </div>
    <div id="jnjpl" v-show="jnjpl">
      <el-col :span="12">
        <el-form-item label="节能减排量:" prop="reduceAmount" class="special-input">
          <el-select v-model="conInfoForm.reduceAmount" style="width:100%" :disabled=isXgbz >
            <el-option v-for="(value,key) in reduceAmount" :key="key" :label="value" :value="key"></el-option>
          </el-select>
     
        </el-form-item>
      </el-col>
    </div>

    <div >
      <el-col :span="12">
        <el-form-item label="产业结构调整类型:" prop="ajustType" class="special-input">
          <el-select v-model="conInfoForm.ajustType" style="width:100%" :disabled=true >
            <el-option v-for="(value,key) in ajustType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="工业转型升级标识:" prop="upgradeType" class="special-input">
          <el-select v-model="conInfoForm.upgradeType" style="width:100%" :disabled=true >
            <el-option v-for="(value,key) in upgradeType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="战略新兴产业类型:" prop="newProductType" class="special-input">
          <el-select v-model="conInfoForm.newProductType" style="width:100%" :disabled=true >
            <el-option v-for="(value,key) in newProductType" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </div>

    <div  id="kfdk" v-show="kfdk">
      <el-col :span="12">
        <el-form-item label="人行保障住房分类:" prop="rhbzffl" class="special-input">
          <el-select v-model="conInfoForm.rhbzffl" style="width:100%" :disabled=true >
            <el-option v-for="(value,key) in rhbzffl" :key="key" :label="value" :value="key"></el-option>
          </el-select> 
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="银监保障住房分类:" prop="yjbzffl" class="special-input">
          <el-select v-model="conInfoForm.yjbzffl" style="width:100%" :disabled=true >
            <el-option v-for="(value,key) in yjbzffl" :key="key" :label="value" :value="key"></el-option>
          </el-select> 
        </el-form-item>
      </el-col>

    </div>

    <div  id="table3" v-show="table3">
      <el-col :span="12">
        <el-form-item label="是否涉农企业:" prop="whetherArgRelated" class="special-input">
          <el-select v-model="conInfoForm.whetherArgRelated" style="width:100%" :disabled=true @change="changeArgRelated">
            <el-option v-for="(value,key) in whetherArgRelated" :key="key" :label="value" :value="key"></el-option>
          </el-select> 
        </el-form-item>
      </el-col>
      <div id="argType1" v-show="argType1">
      <el-col :span="12">
        <el-form-item label="涉农企业类型:" prop="argType" class="special-input">
          <el-select v-model="conInfoForm.argType" style="width:100%" :disabled=isArgType >
            <el-option v-for="(value,key) in argType" :key="key" :label="value" :value="key"></el-option>
          </el-select> 
        </el-form-item>
      </el-col>
      </div>
      <div id="supArgType1" v-show="supArgType1">
      <el-col :span="12">
        <el-form-item label="支农贷款类型:" prop="supArgType" class="special-input">
          <el-select v-model="conInfoForm.supArgType" style="width:100%" :disabled=isSupArgType >
            <el-option v-for="(value,key) in supArgType" :key="key" :label="value" :value="key"></el-option>
          </el-select> 
   
        </el-form-item>
      </el-col>
      </div>

    </div>

    <div  id="greenTable" v-show="greenTable">
      <el-col :span="12">
        <el-form-item label="是否绿色贷款:" prop="greenLoan" class="special-input">
          <el-select v-model="conInfoForm.greenLoan" style="width:100%" :disabled=true  @change="greenLoanChange">
            <el-option v-for="(value,key) in greenLoan" :key="key" :label="value" :value="key"></el-option>
          </el-select> 
        </el-form-item>
      </el-col>

      <div id="greenLoanUse1" v-show="greenLoanUse1">
      <el-col :span="12">
        <el-form-item label="绿色贷款的贷款用途:" prop="greenLoanUse" class="special-input">
          <el-select v-model="conInfoForm.greenLoanUse" style="width:100%" :disabled=isGreenLoanUse >
            <el-option v-for="(value,key) in greenLoanUse" :key="key" :label="value" :value="key"></el-option>
          </el-select>  
        </el-form-item>
      </el-col>
      </div>

      <div id="greenRiskType1" v-show="greenRiskType1">
      <el-col :span="12">
        <el-form-item label="环境、安全等重大风险企业类别:" prop="greenRiskType" class="special-input">
          <el-select v-model="conInfoForm.greenRiskType" style="width:100%" :disabled=isGreenRiskType  @change="greenRiskTypeChange">
            <el-option v-for="(value,key) in greenRiskType" :key="key" :label="value" :value="key"></el-option>
          </el-select>  
        </el-form-item>
      </el-col>
      </div>

      <div id="greenRiskDetail011" v-show="greenRiskDetail011">
      <el-col :span="12">
        <el-form-item label="涉及环境保护违法违规类型:" prop="greenRiskDetail01" class="special-input">
          <el-select v-model="conInfoForm.greenRiskDetail01" style="width:100%" :disabled=isGeenRiskDetail01 >
            <el-option v-for="(value,key) in greenRiskDetail01" :key="key" :label="value" :value="key"></el-option>
          </el-select>  
        </el-form-item>
      </el-col>
      </div>

    <div id="greenRiskDetail021" v-show="greenRiskDetail021">
      <el-col :span="12">
        <el-form-item label="安全生产违法违规类型:" prop="greenRiskDetail02" class="special-input">
          <el-select v-model="conInfoForm.greenRiskDetail02" style="width:100%" :disabled=isGeenRiskDetail02 >
            <el-option v-for="(value,key) in greenRiskDetail02" :key="key" :label="value" :value="key"></el-option>
          </el-select>        
        </el-form-item>
      </el-col>
    </div>

    <div id="greenRiskDetail041" v-show="greenRiskDetail041">
      <el-col :span="12">
        <el-form-item label="职业病预防控制措施不达标类型:" prop="greenRiskDetail04" class="special-input">
          <el-select v-model="conInfoForm.greenRiskDetail04" style="width:100%" :disabled=isGeenRiskDetail04 >
            <el-option v-for="(value,key) in greenRiskDetail04" :key="key" :label="value" :value="key"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </div>
  </div>

  </fieldset>


    </el-form>


    <el-row align="middle" class="bottomBtn">
      <el-col align="center" v-if="!showDisabled">
        <el-button size="medium" type="primary" @click="onSubmit">保存</el-button>
        <!--<el-button size="medium" type="primary" @click="doReset">重置</el-button>-->
      </el-col>
      <el-col align="center" v-else>
        <el-button size="medium" type="primary" @click="doCancel">返回</el-button>
      </el-col>
    </el-row>



  </el-row>
</template>

<script>

  import {} from '@/api/csm'
  import enums from "@/utils/enums"//格式化的枚举
  import axios from 'axios'
  import qs from 'qs'

  export default {
    name: "conInfoHt1",

    components: {
      //引入的组件
    },
    props: {

      paramsConTree:{ //用于接受父组件传来的参数
        //con_tree传递过来的参数放在这里
      }
    },
    data() {
      return {

        isconInfoForm:false,  //只开放相关的提供查看

        //disable     
        isCycleIndCon:false,//默认不禁用 是否融单这个选项


        //show or not 默认都是显示的
        hkfs:true,





        dataMap:'',     //这边保存了 相关合同数据 
        conInfoForm: {//初始化con_info_ht的form表单
          partyName: '',
          partyNum: '',
          productType: '',
          contractNum: '',
          paperConNum: '',
          oldContractNum: '',
          currencyCd: '',
          contractAmt: '',
          bzjbl: '',
          beginDate: '',
          contractTerm: '',
          cycleUnit: '',
          endDate: '',
          repaymentType: '',
          firstRepayTerm: '',
          specPaymentDate: '',
          internalDays: '',
          cycleIndCon: '',
          contractDate: '',
          contractAddress: '',
          loanUse: '',
          exchangeRate: '',
          rmbAmt: '',
          guarantyType: '',

          mainGuarantyType:'',
          agriculLoans:'',
          loanTurn:'',
          riskInfo:'',
          act:'',
          serviceType:'',
          reduceAmount:'',
          ajustType:'',
          upgradeType:'',
          newProductType:'',
          rhbzffl:'',
          yjbzffl:'',
          whetherArgRelated:'',
          argType:'',
          supArgType:'',
          greenLoan:'',
          greenLoanUse:'',
          greenRiskType:'',
          greenRiskDetail01:'',
          greenRiskDetail02:'',
          greenRiskDetail04:''

        },
        //合同明细页面需要展示的相关数据参数
        contractId:'',
        xgbz:'',
        proFlag:'',
        productType:'',
        oldContractId:'',
        legCode:'0700', //TODO 先写死

        rules: {//表单验证
          contractAmt:[
                {required: true, message: '金额不允许为空', trigger: 'blur'},
               // {type: 'number', message: '请输入数字', trigger: 'blur'},
                {min: 100, max: 100000000000, message: '请在出账范围内出账', trigger: 'blur'},

          ],
          bzjbl:[ //保证金比例
            {required: true, message: '保证金不允许为空', trigger: 'blur'},
            {min: 0, max: 100, message: '保证金比例必须在0~1之间', trigger: 'blur'},

          ]

        },

        guarantyType: enums.guarantyTypeCd, //担保方式 CDZC0005
        mainGuarantyType: enums.mainGuarantyTypeCd, //主担保方式 CDZC0005
        agriculLoans: enums.YesOrNoCd,

        currencyCd: enums.currencyCd,//币种格式化  CD000001
        cycleUnit: enums.cycleUnitCd,   //XD_GGCD6009
        
        repaymentType: enums.repaymentTypeCd,//还款方式  XD_SXCD1162
        productType: enums.productType,
        cycleIndCon: enums.isBankTeamLoan,




      }

    },
    created() {
      let param = this.paramsConTree
      console.log("数据传输成功！"+JSON.stringify(param))

      this.contractId=param.contractId
      this.xgbz=param.xgbz
      this.proFlag=param.proFlag
      this.productType=param.productType
      this.oldContractId=''


    //获取相应的法人代码 
    this.initConInfoHt(param)

    },
    methods: {


      initConInfoHt(data) {//初始化页面合同信息

        axios.get(
          '/mybatis-service/process/conInfoSxxy/getConInfoMapByContarctId',{
            params:{
              contractId:this.contractId,
              contractType:'02'
            }
          }

          )
        .then((res)=> {  //这里必须使用箭头函数来赋值
         // console.log(res.data)
        let childData = res.data
        this.dataMap=childData    //将请求后台得到的相关的数据信息保存到dataMap中
        console.log(this.dataMap)
  
        this.conInfoForm.partyName = childData.party.partyName
        this.conInfoForm.partyNum = childData.party.partyNum
        

        //基本信息
        this.conInfoForm.productType = childData.conInfo.productType
        this.conInfoForm.contractNum = childData.conInfo.contractNum
        this.conInfoForm.paperConNum = childData.conInfo.paperConNum
        this.conInfoForm.oldContractNum = childData.conInfo.oldContractNum
        this.conInfoForm.currencyCd = childData.conInfo.currencyCd
        this.conInfoForm.contractAmt = childData.conInfo.contractAmt
        this.conInfoForm.bzjbl = childData.conInfo.bzjbl
        this.conInfoForm.beginDate = childData.conInfo.beginDate
        this.conInfoForm.contractTerm = childData.conInfo.contractTerm
        this.conInfoForm.cycleUnit = childData.conInfo.cycleUnit
        this.conInfoForm.endDate = childData.conInfo.endDate
        this.conInfoForm.repaymentType = childData.conInfo.repaymentType
        this.conInfoForm.firstRepayTerm = childData.conInfo.firstRepayTerm
        this.conInfoForm.specPaymentDate = childData.conInfo.specPaymentDate
        this.conInfoForm.internalDays = childData.conInfo.internalDays
        this.conInfoForm.cycleIndCon = childData.conInfo.cycleIndCon
        this.conInfoForm.contractDate = childData.conInfo.contractDate
        this.conInfoForm.contractAddress = childData.conInfo.contractAddress
        this.conInfoForm.loanUse = childData.conInfo.loanUse
        this.conInfoForm.exchangeRate = childData.conInfo.exchangeRate
        this.conInfoForm.rmbAmt = childData.conInfo.rmbAmt
        this.conInfoForm.guarantyType = childData.conInfo.guarantyType
        this.conInfoForm.mainGuarantyType = childData.conInfo.mainGuarantyType
        this.conInfoForm.agriculLoans = childData.conInfo.agriculLoans

        //标志信息
        this.conInfoForm.loanTurn = childData.tbConFlagInfo.loanTurn
        this.conInfoForm.riskInfo = childData.tbConFlagInfo.riskInfo
        this.conInfoForm.act = childData.tbConFlagInfo.act
        this.conInfoForm.serviceType = childData.tbConFlagInfo.serviceType
        this.conInfoForm.reduceAmount = childData.tbConFlagInfo.reduceAmount
        this.conInfoForm.ajustType = childData.tbConFlagInfo.ajustType
        this.conInfoForm.upgradeType = childData.tbConFlagInfo.upgradeType
        this.conInfoForm.newProductType = childData.tbConFlagInfo.newProductType
        this.conInfoForm.rhbzffl = childData.tbConFlagInfo.rhbzffl
        this.conInfoForm.yjbzffl = childData.tbConFlagInfo.yjbzffl
        this.conInfoForm.whetherArgRelated = childData.tbConFlagInfo.whetherArgRelated
        this.conInfoForm.argType = childData.tbConFlagInfo.argType
        this.conInfoForm.supArgType = childData.tbConFlagInfo.supArgType
        
        this.conInfoForm.greenLoanUse = childData.tbConFlagInfo.greenLoanUse
        this.conInfoForm.greenRiskType = childData.tbConFlagInfo.greenRiskType



      }).catch((error)=>{
        console.log(error)
      })


      },

    }

  }



</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .form {
    margin-top: 20px;
    margin-right: 20px
  }

  .bottomBtn {
  margin-top: 10px;
}
</style>
