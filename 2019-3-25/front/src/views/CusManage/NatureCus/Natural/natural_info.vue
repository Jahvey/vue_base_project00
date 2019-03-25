<template>
  <div class="app-container">
    <el-row class="warp">
      <el-col :span="24">
        <fieldset>
          <legend>基本信息：</legend>
          <el-form ref="dashboard" :model="party,natural" label-width="140px">
            <el-col :span="12">
              <el-form-item label="客户编号" prop="partyNum">
                <el-input v-model="party.partyNum" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="ECIF客户编号" prop="ecifPartyNum">
                <el-input v-model="party.ecifPartyNum" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="客户名称" prop="partyName">
                <el-input v-model="party.partyName" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="证件类型：" prop="certType">
                <el-select v-model="natural.certType" placeholder="请选择证件类型" :disabled="isView">
                  <el-option label="居民身份证" value="10"></el-option>
                  <el-option label="户口簿" value="11"></el-option>
                  <el-option label="中国护照-中华人民共和国因公护照" value="122"></el-option>
                  <el-option label="中国护照-中华人民共和国因私护照" value="121"></el-option>
                  <el-option label="军官证" value="13"></el-option>
                  <el-option label="军人士兵证" value="14"></el-option>
                  <el-option label="香港居民来往内地通行证" value="15"></el-option>
                  <el-option label="台湾居民来往大陆通行证" value="16"></el-option>
                  <el-option label="临时身份证" value="17"></el-option>
                  <el-option label="外国人永久居留证" value="18"></el-option>
                  <el-option label="警官证" value="19"></el-option>
                  <el-option label="其他证件" value="1X"></el-option>
                  <el-option label="武警士兵证" value="1a"></el-option>
                  <el-option label="军人文职干部证" value="1b"></el-option>
                  <el-option label="武警文职干部证" value="1c"></el-option>
                  <el-option label="驾驶证" value="1d"></el-option>
                  <el-option label="军人身份证" value="1e"></el-option>
                  <el-option label="武装警察身份证" value="1f"></el-option>
                  <el-option label="外国公民护照" value="1g"></el-option>
                  <el-option label="澳门居民来往内地通行证" value="1h"></el-option>
                  <el-option label="军事学员证" value="1i"></el-option>
                  <el-option label="军官退休证" value="1j"></el-option>
                  <el-option label="文职干部退休证" value="1k"></el-option>
                  <el-option label="离休干部荣誉证" value="1l"></el-option>
                  <el-option label="边民出入境通行证" value="1m"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="certNum" label="证件号码">
                <el-input v-model="natural.certNum" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="middleCode" label="中征码">
                <el-input v-model="natural.middleCode" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="isPotentialCust" label="是否信贷客户">
                <el-select clearable v-model="party.isPotentialCust" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="custType" label="个人分类">
                <el-select clearable v-model="natural.custType" :disabled="isView">
                  <el-option v-for="(value,key) in custTypeOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="cerType" label="是否第三方客户">
                <el-select clearable v-model="natural.isThirdCust" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="thirdCustTypeCd" label="第三方客户类型">
                <el-select clearable v-model="natural.thirdCustTypeCd" :disabled="isView">
                  <el-option label="委托方" value="0"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
        <fieldset>
          <legend>详细信息：</legend>
          <el-form ref="dashboard" :model="natural" label-width="140px">
            <el-col :span="12">
              <el-form-item prop="naturalPersonTypeCd" label="居民性质">
                <el-select clearable v-model="natural.naturalPersonTypeCd" :disabled="isView">
                  <el-option v-for="(value,key) in naturalPersonTypeCdOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="genderCd" label="性别">
                <el-select clearable v-model="natural.genderCd" :disabled="isView">
                  <el-option v-for="(value,key) in genderCdOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="出生日期" prop="birthday">
                <el-input v-model="natural.birthday" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="countrySign" label="国籍">
                <el-select clearable v-model="natural.countrySign" :disabled="isView">
                  <el-option v-for="(value,key) in countrySignOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="nation" label="民族">
                <el-select clearable v-model="natural.nation" :disabled="isView">
                  <el-option v-for="(value,key) in nationOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="marriageCd" label="婚姻状况">
                <el-select clearable v-model="natural.marriageCd" :disabled="isView">
                  <el-option v-for="(value,key) in marriageCdOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="isFarmer" label="是否农户">
                <el-select clearable v-model="natural.isFarmer" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="户籍所在地" prop="hukouRegisted">
                <el-input v-model="natural.hukouRegisted" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="高校/毕业院校名称" prop="schName">
                <el-input v-model="natural.schName" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="educationBackgroudCd" label="最高学历">
                <el-select clearable v-model="natural.educationBackgroudCd" :disabled="isView">
                  <el-option v-for="(value,key) in educationBackgroudCdOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="educationBackgroudCd" label="最高学位">
                <el-select clearable v-model="natural.educationBackgroudCd" :disabled="isView">
                  <el-option v-for="(value,key) in educationBackgroudCdOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="profession" label="职业">
                <el-select clearable v-model="natural.profession" :disabled="isView">
                  <el-option v-for="(value,key) in professionOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="professionalTitle" label="职称">
                <el-select clearable v-model="natural.professionalTitle" :disabled="isView">
                  <el-option v-for="(value,key) in professionalTitleOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="accountingAssistant" label="职务">
                <el-select clearable v-model="natural.accountingAssistant" :disabled="isView">
                  <el-option v-for="(value,key) in accountingAssistantOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="positionProperty" label="岗位性质">
                <el-select clearable v-model="natural.positionProperty" :disabled="isView">
                  <el-option v-for="(value,key) in accountingAssistantOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="natureOfUnit" label="单位性质">
                <el-select clearable v-model="natural.natureOfUnit" :disabled="isView">
                  <el-option v-for="(value,key) in accountingAssistantOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="scaleOfUnit" label="单位规模">
                <el-select clearable v-model="natural.scaleOfUnit" :disabled="isView">
                  <el-option v-for="(value,key) in accountingAssistantOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="目前工作持续年限" prop="workYears">
                <el-input v-model="natural.workYears" :disabled="isView">年</el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="家庭人口" prop="familyNumber">
                <el-input v-model="natural.familyNumber" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="家庭住址" prop="familyAddress">
                <el-input v-model="natural.familyAddress" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="houseProperty" label="住宅性质">
                <el-select clearable v-model="natural.houseProperty" :disabled="isView">
                  <el-option v-for="(value,key) in accountingAssistantOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="家庭电话" prop="familyPhone">
                <el-input v-model="natural.familyPhone" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="通讯地址" prop="communicationAddress">
                <el-input v-model="natural.communicationAddress" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="通讯地址邮编" prop="communicationAddressCode">
                <el-input v-model="natural.communicationAddressCode" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="居住地址邮编" prop="liveAddressCode">
                <el-input v-model="natural.liveAddressCode" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="industry" label="行业">
                <el-select clearable v-model="natural.industry" :disabled="isView">
                  <el-option v-for="(value,key) in accountingAssistantOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="手机号码（短信推送）" prop="phoneNumber">
                <el-input v-model="natural.phoneNumber" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="flgSms" label="短信推送号码是否核对：">
                <el-select clearable v-model="natural.flgSms" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="微信号" prop="weixinNum">
                <el-input v-model="natural.weixinNum" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="电子邮箱" prop="email">
                <el-input v-model="natural.email" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="工作单位" prop="workUnit">
                <el-input v-model="natural.workUnit" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="单位地址" prop="unitAdress">
                <el-input v-model="natural.unitAdress" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="年收入" prop="annualsalary">
                <el-input v-model="natural.annualsalary" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="单位电话" prop="unitPhone">
                <el-input v-model="natural.unitPhone" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="单位邮编" prop="unitAddressCode">
                <el-input v-model="natural.unitAddressCode" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="行业具体描述" prop="industryDesc">
                <el-input v-model="natural.industryDesc" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="houseProperty" label="联保小组标志">
                <el-select clearable v-model="natural.jointGuarantee" disabled>
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="stockholderOfBank" label="我行股东标志">
                <el-select clearable v-model="natural.stockholderOfBank" disabled>
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="isBasebankRelaCust" label="是否我行关联方">
                <el-select clearable v-model="natural.isBasebankRelaCust" disabled>
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="isGroupCust" label="是否集团成员">
                <el-select clearable v-model="natural.isGroupCust" disabled>
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="所属集团客户名称" prop="familyPhone">
                <el-input v-model="natural.attachGroupName" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="whetherBlackList" label="黑名单标志">
                <el-select clearable v-model="natural.whetherBlackList" disabled>
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="加入黑名单原因" prop="blackListReason">
                <el-input v-model="natural.blackListReason" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="isBankEmployee" label="是否本行员工">
                <el-select clearable v-model="natural.isBankEmployee" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="ifcertificate" label="是否有(营业执照)">
                <el-select clearable v-model="natural.ifcertificate" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="natiflag" label="是否本地人">
                <el-select clearable v-model="natural.natiflag" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
        <fieldset>
          <legend>系统信息：</legend>
          <el-form ref="dashboard" :model="natural,item" label-width="140px">
            <el-col :span="12">
              <el-form-item label="经办机构" prop="orgNum">
                <el-input v-model="item.orgNum" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="经办人" prop="userNum">
                <el-input v-model="item.userNum" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="经办日期" prop="createTime">
                <el-input v-model="natural.createTime" disabled></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
      </el-col>
    </el-row>
    <div v-if="buttonView">
      <el-button :size="size" type="primary" @click.native="saveNatural" :loading="editLoading">保存</el-button>
      <el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">临时保存</el-button>
      <el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">校验完整性</el-button>
    </div>
  </div>
  <!--<div class="dashboard-text">role:<span v-for='role in roles' :key='role'>{{role}}</span></div>-->
</template>

<dashboard a="1"></dashboard>
<script>
  import { mapGetters } from 'vuex'
  //import {getCusInfo,getAssetsList} from '@/api/org'
  import enums from "@/utils/enums"
  import commonUtil from "@/utils/commonUtil"
  export default {
    name: 'dashboard',
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

