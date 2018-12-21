<!--suppress ALL -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
      <el-form-item slot="clientBaseInfoShow" label="客户基本信息" prop="clientBaseInfoShow"><!--这个label展示在下面-->
        <el-checkbox-group v-model="form.clientBaseInfoShow">
          <template v-for="(value,key) in srvObj"><!--遍历表单srvObj-->
            <el-col :span="8">
              <el-checkbox :key="value.roleId" :label="key" :name="key"><!--:key值需要更改，这里没有roleId-->
              </el-checkbox>
            </el-col>
          </template>
        </el-checkbox-group>
      </el-form-item>
    </csc-form-page>
  </div>
</template>

<script>
  // 个人信息之客户基本信息
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  // import { getContractList } from '@/api/contract' // 暂时没有使用


  export default {
    data() {
      return {
        srvObj: {},
        form: {
          clientBaseInfoShow: [],
          partyNum:'011004323050',
          ecifPartyNum:'011004323050',
          partyName:'军育苗',
          certType:'居民身份证',
          certNum:'510721196601019530',
          middleCode:'无',
          isPotentialCust:'是',
          custType:'无',
          isThirdCust:'否',
          thirdCustTypeCd:'',

          resdntCharCd:'居民(境内)',
          genderCd:'男',
          birthday:'1966-01-01',
          countrySign:'中国',
          nation:'汉族',
          marriageCd:'未说明的婚姻状况',
          isFarmer:'否',
          hukouRegisted:'湖北省莱芜市剑咒区摇获路俩驰840号',
          schName:'无',
          educationBackgroudCd:'大学专科和专科学校（简称“大专”）',
          degreeCd:'其他', // 首次还款期次
          profession:'专业技术人员',
          professionalTitle:'无',
          accountingAssistant:'一般员工',
          positionProperty:'无',
          natureOfUnit:'企业',
          scaleOfUnit:'小型企业', // 贷款用途
          workYears:'10',
          familyNumber:'1',
          familyAddress:'湖北省莱芜市颈宵区惫掣街5号欢配露楼',
          houseProperty:'自置房/自有住宅无贷款',
          familyPhone:'暂无',
          communicationAddress:'湖北省莱芜市颈宵区惫掣街5号欢配露楼',
          communicationAddressCode:'621000',
          liveAddressCode:'621000',
          industry:'制造业',
          phoneNumber:'15887006666',
          flgSms:'否',
          weixinNum:'没有微信',
          email:'没有邮箱',
          workUnit:'绵阳市亚美胶带有限公司',
          unitAdress:'皇后大道',
          annualsalary:'100000',
          unitPhone:'15887006666',
          unitAddressCode:'单位右边',
          industryDesc:'交代厂',
          jointGuarantee:'否', // 联保小组标志
          stockholderOfBank:'否',
          isBasebankRelaCust:'否',
          isGroupCust:'否',
          attachGroupName:'无',
          whetherBlackList:'否',
          blackListReason:'',
          isBankEmployee:'否',
          ifcertificate:'否',
          natiflag:'是',
          orgNum:'0700',
          userNum:'李谭荔',
          createTime:'2018-03-11'
        },
        refVisible: { pkOrg: false },
        pageDef: {
          disabled: true, // 页面按钮隐藏，并且变为只读属性
          name: '用户信息',
          columnNum: 2,
          pageCols: [// 这里需要改为只读属性，格式有问题
            { label: '客户编号:', inputType: 'input', modelName: 'partyNum' },
            { label: 'ECIF客户编号:', inputType: 'input', modelName: 'ecifPartyNum' },
            { label: '客户名称:', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型:', inputType: 'select', modelName: 'certType' },
            { label: '证件号码:', inputType: 'select', modelName: 'certNum' },
            { label: '中征码:', inputType: 'input', modelName: 'middleCode' },
            { label: '是否信贷客户:', inputType: 'select', modelName: 'isPotentialCust' },
            { label: '个人分类:', inputType: 'select', modelName: 'custType' },
            { label: '是否第三方客户:', inputType: 'select', modelName: 'isThirdCust' },
            { label: '第三方客户类型:', inputType: 'select', modelName: 'thirdCustTypeCd' },
            // { label: '发证日期:', inputType: 'date', modelName: 'certCreateDate' },
            // { label: '到期日期:', inputType: 'date', modelName: 'certEndDate' },

            { label: '居民性质:', inputType: 'select', modelName: 'resdntCharCd' },
            { label: '性别:', inputType: 'select', modelName: 'genderCd' },
            { label: '出生日期:', inputType: 'date', modelName: 'birthday' },
            { label: '国籍:', inputType: 'select', modelName: 'countrySign' },
            { label: '民族:', inputType: 'select', modelName: 'nation' },
            { label: '婚姻状况:', inputType: 'select', modelName: 'marriageCd' },
            { label: '是否农户:', inputType: 'select', modelName: 'isFarmer' },
            { label: '户籍所在地:', inputType: 'input', modelName: 'hukouRegisted' },
            { label: '高校名称/毕业院校名称:', inputType: 'input', modelName: 'schName' },
            { label: '最高学历:', inputType: 'select', modelName: 'educationBackgroudCd' },
            { label: '最高学位:', inputType: 'select', modelName: 'degreeCd' },
            { label: '职业:', inputType: 'select', modelName: 'profession' },
            { label: '职称：', inputType: 'select', modelName: 'professionalTitle' },
            { label: '职务：', inputType: 'select', modelName: 'accountingAssistant' },
            { label: '岗位性质：', inputType: 'select', modelName: 'positionProperty' },
            { label: '单位性质：', inputType: 'select', modelName: 'natureOfUnit' },
            { label: '单位规模：', inputType: 'select', modelName: 'scaleOfUnit' },
            { label: '目前工作持续年限(年)：', inputType: 'input', modelName: 'workYears' },
            { label: '家庭人口：', inputType: 'input', modelName: 'familyNumber' },
            { label: '家庭住址：', inputType: 'input', modelName: 'familyAddress' },
            { label: '住宅性质：', inputType: 'select', modelName: 'houseProperty' },
            { label: '家庭电话：', inputType: 'input', modelName: 'familyPhone' },
            { label: '通讯地址：', inputType: 'input', modelName: 'communicationAddress' },
            { label: '通讯地址邮编：', inputType: 'input', modelName: 'communicationAddressCode' },
            { label: '居住地址邮编：', inputType: 'input', modelName: 'liveAddressCode' },
            { label: '行业:', inputType: 'select', modelName: 'industry' },
            { label: '手机号码（短信推送）：', inputType: 'input', modelName: 'phoneNumber' },
            { label: '短信推送号码是否核对：', inputType: 'select', modelName: 'flgSms' },
            { label: '微信号：', inputType: 'input', modelName: 'weixinNum' },
            { label: '电子邮箱：', inputType: 'input', modelName: 'email' },
            { label: '工作单位：', inputType: 'input', modelName: 'workUnit' },
            { label: '单位地址:', inputType: 'input', modelName: 'unitAdress' },
            { label: '年收入(元):', inputType: 'input', modelName: 'annualsalary' },
            { label: '单位电话:', inputType: 'input', modelName: 'unitPhone' },
            { label: '单位邮编:', inputType: 'input', modelName: 'unitAddressCode' },
            { label: '行业具体描述：', inputType: 'input', modelName: 'industryDesc' },
            { label: '联保小组标志：', inputType: 'select', modelName: 'jointGuarantee' },
            { label: '我行股东标志：', inputType: 'select', modelName: 'stockholderOfBank' },
            { label: '是否我行关联方', inputType: 'select', modelName: 'isBasebankRelaCust' },
            { label: '是否集团成员：', inputType: 'select', modelName: 'isGroupCust' },
            { label: '所属集团客户名称：', inputType: 'input', modelName: 'attachGroupName' },
            { label: '黑名单标志:', inputType: 'select', modelName: 'whetherBlackList' },
            { label: '加入黑名单原因:', inputType: 'input', modelName: 'blackListReason' },
            { label: '是否本行员工：', inputType: 'select', modelName: 'isBankEmployee' },
            { label: '是否有(营业执照)：', inputType: 'select', modelName: 'ifcertificate' },
            { label: '是否本地人：', inputType: 'select', modelName: 'natiflag' },
            { label: '经办机构', inputType: 'input', modelName: 'orgNum' },
            { label: '经办人：', inputType: 'input', modelName: 'userNum' },
            { label: '经办日期：', inputType: 'input', modelName: 'createTime' },
          ]
        }
      }
    },

    components: { CscFormPage },


    methods: {
      doCancel() {
        this.$router.back()
      },
      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

    },
    mounted() {				// 页面加载完毕之后进行的渲染
      this.contractList()
    }
  },
  }
</script>
