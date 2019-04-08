<template>
  <div class="bin-xw-detail">
    <el-row class="warp">
      <el-col :span="24">
        <fieldset>
          <legend>客户申请信息：</legend>
          <el-form ref="dashboard" :model="tbBizXwApply" label-width="140px">
            <el-col :span="12">
              <el-form-item label="申报金额" prop="applyXwAmt">
                <el-input v-model="tbBizXwApply.applyXwAmt" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="申请期限" prop="applyXwTerm,cycleUnitXw">
                <el-input v-model="tbBizXwApply.applyXwTerm" style="width:60%;float:left" disabled></el-input>
                <el-input v-model="tbBizXwApply.cycleUnitXw" style="width:40%;float:left" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="申请日期" prop="applyDate">
                <el-input v-model="tbBizXwApply.applyDate" disabled></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
        <fieldset>
          <legend>申报基本信息：</legend>
          <el-form ref="dashboard" :model="tbBizXwApply,tbBizApply,amountDetail,XwDetail" label-width="140px">
            <el-col :span="12">
              <el-form-item label="共同借款人" prop="gtjkr">
                <el-input v-model="tbBizXwApply.gtjkr"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="业务品种" prop="productType">
                <el-input  v-model="tbBizApply.productType" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="币种" prop="currencyCd">
                <el-input  v-model="amountDetail.currencyCd" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="申报金额" prop="detailAmt">
                <el-input  v-model="amountDetail.detailAmt" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="汇率" prop="exchangeRate">
                <el-input  v-model="amountDetail.exchangeRate" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="折算人民币金额" prop="rmbAmt">
                <el-input  v-model="amountDetail.rmbAmt" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="还款方式" prop="repaymentType">
                <el-input  v-model="amountDetail.repaymentType" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="首次还本期次" prop="firstRepayTerm">
                <el-input  v-model="amountDetail.firstRepayTerm" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="还款来源" prop="payment">
                <el-input  v-model="amountDetail.payment" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="贷款用途" prop="loanUse">
                <el-input  v-model="amountDetail.loanUse" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="委托人" prop="wtr">
                <el-input  v-model="tbBizXwApply.wtr" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="委托项目名称" prop="wtxmmc1">
                <el-input  v-model="XwDetail.wtxmmc1" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="证件类型" prop="zjlx">
                <el-input  v-model="XwDetail.zjlx" disabled style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="证件号码" prop="zjhm">
                <el-input  v-model="XwDetail.zjhm" disabled style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="委托人类型" prop="wtrlx">
                <el-input  v-model="tbBizXwApply.wtrlx" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="委托贷款性质" prop="wtdkxz">
                <el-input  v-model="tbBizXwApply.wtdkxz" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
        <fieldset>
          <legend>利率信息：</legend>
          <el-form ref="dashboard" :model="loanrate,tbBizApply" label-width="140px">
            <el-col :span="12">
              <el-form-item label="利率类型" prop="rateType">
                <el-input v-model="loanrate.rateType" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="浮动方式" prop="floatWay">
                <el-input v-model="loanrate.floatWay" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="浮动比例(%)" prop="rateFloatProportion">
                <el-input v-model="loanrate.rateFloatProportion" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="申请利率（%）" prop="yearRate">
                <el-input v-model="loanrate.yearRate" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="利率调整方式" prop="irUpdateFrequency">
                <el-input v-model="loanrate.irUpdateFrequency" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="结息周期" prop="interestCollectType">
                <el-input v-model="loanrate.interestCollectType" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="节假日顺延标志" prop="holidayFlg">
                <el-input v-model="loanrate.holidayFlg" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="节假日利息处理方式" prop="holidayIntFlg">
                <el-input v-model="loanrate.holidayIntFlg" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="宽限期方式" prop="gracePeriodType">
                <el-input v-model="loanrate.gracePeriodType" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="宽限期天数" prop="gracePeriodDay">
                <el-input v-model="loanrate.gracePeriodDay" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="宽限期利息处理方式" prop="graceCountIntFlag">
                <el-input v-model="loanrate.graceCountIntFlag" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="逾期罚息率（%）" prop="overdueRateUpProportion">
                <el-input v-model="loanrate.overdueRateUpProportion" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="申请日期" prop="applyDate">
                <el-input v-model="tbBizApply.applyDate" disabled></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
      </el-col>
    </el-row>
    <div v-if="buttonView" style="right:auto;left:0;">
      <el-button :size="size" type="primary" @click.native="saveAndUpdateXwProductDetail" :loading="editLoading">保存</el-button>
    </div>
  </div>
  <!--<div class="dashboard-text">role:<span v-for='role in roles' :key='role'>{{role}}</span></div>-->
</template>
<script>
  import { mapGetters } from 'vuex'
  //import {getCusInfo,getAssetsList} from '@/api/org'
  import enums from "@/utils/enums"
  import commonUtil from "@/utils/commonUtil"
  import { saveAndUpdateXwProductDetail } from '@/api/csm'
  export default {
    name: "biz-xw-detail",
    props:{
      tbBizXwApply:Object,
      tbBizApply:Object,
      amountDetail:Object,
      loanrate:Object,
      XwDetail:Object,
    },
    data(){
      return {
        idTypeCdOpts: enums.idTypeCd,//直接从配置文件读取
        yesOrNoOpts: enums.yesOrNo,//是否
        custTypeOpts: enums.custType,//个人分类
        genderCdOpts: enums.genderCd,//性别
        naturalPersonTypeCdOpts:enums.naturalPersonTypeCd,//居民性质
        countrySignOpts: enums.countrySign,//国籍
        nationOpts: enums.nation,//民族
        marriageCdOpts: enums.marriageCd,//婚姻状况
        educationBackgroudCdOpts:enums.educationBackgroudCd,//最高学历
        degreeCdOpts:enums.degreeCd,//最高学位
        professionOpts: enums.profession,//职业
        professionalTitleOpts: enums.professionalTitle,//职称
        accountingAssistantOpts: enums.accountingAssistant,//职务

        isView:false,
        buttonView:true,
        pageRequest: { partyId:''},
        size:'medium',
        editLoading: false,

        //调用服务的方式获取客户信息
        party:{
          partyNum:'011005752719',
          ecifPartyNum:'011005752719',
          isPotentialCust:'0',
          partyName:'张三',
        },
        natural:{
          cerType:'',
          certNum:'',
          middleCode:'',
          custType:'',
          isThirdCust:'',
          thirdCustTypeCd:'',
          naturalPersonTypeCd:'',
          genderCd:'',
          birthday:'',
          countrySign:'',
          nation:'',
          marriageCd:'',
          isFarmer:'',
          hukouRegisted:'',
          schName:'',
          educationBackgroudCd:'',
          degreeCd:'',
          profession:'',
          professionalTitle:'',
          accountingAssistant:'',
          positionProperty:'',
          natureOfUnit:'',
          scaleOfUnit:'',
          workYears:'',
          familyNumber:'',
          familyAddress:'',
          houseProperty:'',
          familyPhone:'',
          communicationAddress:'',
          communicationAddressCode:'',
          liveAddressCode:'',
          industry:'',
          phoneNumber:'',
          flgSms:'',
          weixinNum:'',
          email:'',
          workUnit:'',
          unitAdress:'',
          annualsalary:'',
          unitPhone:'',
          unitAddressCode:'',
          industryDesc:'',
          jointGuarantee:'',
          stockholderOfBank:'',
          isBasebankRelaCust:'',
          isGroupCust:'',
          attachGroupName:'',
          whetherBlackList:'',
          blackListReason:'',
          isBankEmployee:'',
          ifcertificate:'',
          natiflag:'',
          createTime:'',
        },
        item:{
          orgNum:"0700",
          userNum:"李谭荔"
        }
      }
    },
    methods:{

      // 表单提交
      saveAndUpdateXwProductDetail () {
        this.$refs['dashboard'].validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              this.editLoading = true;
              let params = Object.assign({}, this.tbBizXwApply,this.tbBizApply,
                this.amountDetail,this.XwDetail,this.loanrate,this.tbBizApply )
              saveAndUpdateXwProductDetail(params).then((res) => {
                this.editLoading = false;
                if(res && res.data && res.data.code == 200) {
                  if(this.$route.query.vueType == 'add'){
                    this.$message({ message: '添加成功', type: 'success' })
                  }else{
                    this.$message({ message: '修改成功', type: 'success' })
                  }
                } else {
                  if(this.$route.query.vueType == 'add'){
                    this.$message({message: '添加失败, ' + res.data.msg, type: 'error'})
                  }else{
                    this.$message({message: '修改失败, ' + res.data.msg, type: 'error'})
                  }
                }
              }).catch((res) =>{
                console.error(JSON.stringify(res))
              })

            })
          }
        })
      },
      isDisabled: function (vueType) {
        console.log('进入判断')
        if(vueType == 'view'){
          this.isView = true;
          this.buttonView = false;
        }else{
          this.isView = false;
          this.buttonView = true;
        }
      },
      //根据身份证号码获取生日性别
      getBD:  function (dataForm) {
        console.log('开始获取生日性别');
        //获取输入身份证号码 
        let UUserCard = dataForm.certNum;
        //获取出生日期 
        let birth = UUserCard.substring(6, 10) + "-" + UUserCard.substring(10, 12) + "-" + UUserCard.substring(12, 14);
        dataForm.birthday = birth;
        //获取性别 
        if (parseInt(UUserCard.substr(16, 1)) % 2 == 1) {
          dataForm.genderCd = '1';
        } else {
          dataForm.genderCd = '2';
        }
        console.log('开始获取生日'+birth);
        console.log('开始获取生日性别'+dataForm.genderCd );
      },
      //详细信息页面进入自动渲染数据
      infoInit: function(){
        console.log('进入新增渲染');
        this.pageRequest.partyId = this.$route.query.partyId;
        console.log( this.pageRequest);
        this.$api.cusManage_naturalCus.queryNaturalByPartyId(this.pageRequest).then((res) => {
          console.log('naturalRes:'+JSON.stringify(res.data))
          if(res && res.data && res.data.code == 200) {
            let dataForm =  Object.assign({}, res.data.data);
            this.party.isPotentialCust = dataForm.isPotentialCust;
            this.party.partyName = dataForm.partyName;
            this.party.ecifPartyNum = dataForm.ecifPartyNum;
            this.party.partyNum = dataForm.partyNum;
            if(dataForm.certType == '10'){
              console.log('进入身份证获取生日性别');
              this.getBD(dataForm);
            }
            console.log(dataForm);
            this.natural = Object.assign({}, dataForm);
            console.log(this.natural);
          } else {
            this.$message({message: '客户概况信息加载失败, ' + res.data.msg, type: 'error'})
          }
        }).catch((res) => {
          this.$message({message: '初始查询用户信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询用户信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
    },
    mounted() {
      // console.log('开始渲染');
      // console.log(this.$route.query.vueType);
      // let vueType = this.$route.query.vueType;
      // this.isDisabled(vueType);
      // this.infoInit();
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .dashboard {
    &-container {
      margin: 30px;
    }
    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }

  .form .form-left {
    width:50%; padding-left:1rem; padding-right:1rem; padding-top:1rem;
  }
  .form .form-right {
    width:50%; padding-left:1rem; padding-right:1rem; padding-top:1rem;
  }


</style>

