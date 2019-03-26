<template>
  <div class="natural-flg">
    <el-row class="warp">
      <el-col :span="24">
          <el-form ref="dashboard" :model="bizFlg" label-width="140px">
            <el-col :span="12">
              <el-form-item prop="checkFlg" label="是否二手房监管">
                <el-select clearable v-model="bizFlg.checkFlg" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-form>
      </el-col>
    </el-row>
    <div v-if="buttonView">
      <el-button :size="size" type="primary" @click.native="saveNatural" :loading="editLoading">保存</el-button>
    </div>
  </div>
  <!--<div class="dashboard-text">role:<span v-for='role in roles' :key='role'>{{role}}</span></div>-->
</template>
<script>
  import { mapGetters } from 'vuex'
  //import {getCusInfo,getAssetsList} from '@/api/org'
  import enums from "@/utils/enums"
  import commonUtil from "@/utils/commonUtil"
  export default {
    name: "natural-flg",
    props:{
      bizFlg:Object,
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
        size:'small',
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
      saveNatural () {
        this.$refs['dashboard'].validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              this.editLoading = true;
              let params = Object.assign({}, this.natural,this.party )
              console.log(this.party);
                console.log(params);
              this.$api.cusManage_naturalCus.update(params).then((res) => {
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
      console.log('开始渲染');
      console.log(this.$route.query.vueType);
      let vueType = this.$route.query.vueType;
      this.isDisabled(vueType);
      this.infoInit();
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

