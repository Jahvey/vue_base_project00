<!--suppress ALL -->
<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @click="doCancel">
      <el-form-item slot="natural_info" label="自然人客户概况信息" prop="natural_info"><!--这个label展示在下面-->
        <el-checkbox-group v-model="form.natural_info">
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
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  // import { queryNaturalForDesk } from '@/api/csm' // 暂时没有使用


  export default {
    data() {
      return {
        srvObj: {},
        form: {
           natural_info: [],
          // partyNum:'011004323050',   
          // ecifPartyNum:'013202006665',
          // partyName:'军育苗',
          // certType:'身份证',
          // certNum:'510101198808211176',
          // middleCode:'HT070020180906015681',
          // isPotentialCust:'是',
          // custType:'无',
          // isThirdCust:'否',
          // thirdCustTypeCd:'',
          // certCreateDate:'2012-11-12',
          // certEndDate:'2012-12-14',
          // checkDate:'2012-12-14',
          
          // //自然人详细信息
          // resdntCharCd:'居民',
          // genderCd:'男',
          // birthday:'1998-08-21',
          // countrySign:'中国',
          // nation:'汉族',
          // marriageCd:'未婚',
          // isFarmer:'否',
          // hukouRegisted:'四川成都',
          // schName:'四川大学',
          // educationBackgroudCd:'研究生',
          // profession:'大学助教',
          // professionalTitle:'无',
          // accountingAssistant:'java老师',
          // positionProperty:'事业单位',

          // natureOfUnit:'国企',
          // scaleOfUnit:'2000人',

          // workYears:'25年',
          // familyNumber:'1',
          // familyAddress:'湖北',
          // familyPhone:'12345678901',
          // communicationAddress:'湖北武汉',
          // communicationAddressCode:'666666',
          // liveAddressCode:'666666',
          // industry:'云计算软件工程',

          // phoneNumber:'12345678901',
          // flgSms:'是',
          // weixinNum:'xxx',
          // email:'xxx@qq.com',
          // workUnit:'川大',
          // unitAdress:'四川成都',
          // annualsalary:'14w',
          // unitPhone:'123456',
          // unitAddressCode:'666666',
          // industryDesc:'软件工程',
          // jointGuarantee:'否',
          // stockholderOfBank:'否',
          // isBasebankRelaCust:'否',
          // isGroupCust:'否',
          // attachGroupName:'四川大学',
          // whetherBlackList:'否',
          // blackListReason:'xxxxxx.yyyyyy',
          // isBankEmployee:'否',
          // ifcertificate:'否',
          // natiflag:'是',

          // //系统信息
          // orgNum:'0700',
          // userNum:'李谭荔',
          // createTime:'2018-08-21',




        },
        refVisible: { pkOrg: false },
        pageDef: {
          disabled: true, // 页面按钮隐藏
          name: '自然人客户概况信息',
          columnNum: 2,
          pageCols: [// 这里需要改为只读属性，格式有问题
            //基本信息
            { label: '客户编号:', inputType: 'input', modelName: 'partyNum' },
            { label: 'ECIF客户编号:', inputType: 'input', modelName: 'ecifPartyNum' },
            { label: '客户名称:', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型:', inputType: 'select', modelName: 'certType' },
            { label: '证件号码:', inputType: 'input', modelName: 'certNum' },
            { label: '中征码:', inputType: 'input', modelName: 'middleCode' },
            { label: '是否借贷客户:', inputType: 'input', modelName: 'isPotentialCust' },            
            { label: '个人分类:', inputType: 'select', modelName: 'custType' },            
            { label: '是否第三方客户:', inputType: 'input', modelName: 'isThirdCust' },            
            { label: '第三方客户类型:', inputType: 'select', modelName: 'thirdCustTypeCd' },            
            { label: '发证日期:', inputType: 'date', modelName: 'certCreateDate' }, // 有疑问cycleUnit
            { label: '到期日期:', inputType: 'date', modelName: 'certEndDate' },
            { label: '长期:', inputType: 'input', modelName: 'checkDate' },

            //详细信息
            { label: '居民性质:', inputType: 'select', modelName: 'resdntCharCd' },
            { label: '性别:', inputType: 'select', modelName: 'genderCd' },           
            { label: '出生日期:', inputType: 'date', modelName: 'birthday' },            
            { label: '国籍:', inputType: 'select', modelName: 'countrySign' },            
            { label: '民族:', inputType: 'input', modelName: 'nation' },            
            { label: '婚姻状况:', inputType: 'input', modelName: 'marriageCd' },           
            { label: '是否农户:', inputType: 'input', modelName: 'isFarmer' },            
            { label: '户籍所在地:', inputType: 'input', modelName: 'hukouRegisted' }, // 有问题，这里应该是一个checkbox，但是报错
            { label: '高校名称/毕业院校名称:', inputType: 'input', modelName: 'schName' },
            { label: '最高学历:', inputType: 'select', modelName: 'educationBackgroudCd' },  
            { label: '最高学位:', inputType: 'select', modelName: 'degreeCd' },           
            { label: '职业:', inputType: 'select', modelName: 'profession' },        
            { label: '职称:', inputType: 'select', modelName: 'professionalTitle' },
            { label: '职务:', inputType: 'select', modelName: 'accountingAssistant' },
            { label: '岗位性质:', inputType: 'select', modelName: 'positionProperty' },
            { label: '单位性质:', inputType: 'select', modelName: 'natureOfUnit' },           
            { label: '单位规模:', inputType: 'select', modelName: 'scaleOfUnit' },           
            { label: '目前工作持续年限:', inputType: 'input', modelName: 'workYears' },  // 注明分割
            { label: '家庭人口:', inputType: 'input', modelName: 'familyNumber' },            
            { label: '家庭住址:', inputType: 'input', modelName: 'familyAddress' },   
            { label: '住宅性质:', inputType: 'input', modelName: 'houseProperty' },   
                   
            { label: '家庭电话:', inputType: 'input', modelName: 'familyPhone' },  // 贷款分割线           
            { label: '通讯地址:', inputType: 'input', modelName: 'communicationAddress' },
            { label: '通讯地址邮编:', inputType: 'input', modelName: 'communicationAddressCode' },
            { label: '居住地址邮编:', inputType: 'input', modelName: 'liveAddressCode' },
            { label: '行业:', inputType: 'input', modelName: 'industry' },

            { label: '手机号码(短信推送):', inputType: 'input', modelName: 'phoneNumber' },
            { label: '短信推送号码是否核对:', inputType: 'input', modelName: 'flgSms' },
            { label: '微信号:', inputType: 'input', modelName: 'weixinNum' },
            { label: '电子邮箱:', inputType: 'input', modelName: 'email' },
            { label: '工作单位:', inputType: 'input', modelName: 'workUnit' },
            { label: '单位地址:', inputType: 'input', modelName: 'unitAdress' },
            { label: '年收入:', inputType: 'input', modelName: 'annualsalary' },
            { label: '单位电话:', inputType: 'input', modelName: 'unitPhone' },
            { label: '单位邮编:', inputType: 'input', modelName: 'unitAddressCode' },
            { label: '行业具体描述:', inputType: 'input', modelName: 'industryDesc' },
            { label: '联保小组标志:', inputType: 'input', modelName: 'jointGuarantee' },
            { label: '我行股东标志:', inputType: 'input', modelName: 'stockholderOfBank' },
            { label: '是否我行关联方:', inputType: 'input', modelName: 'isBasebankRelaCust' },
            { label: '是否集团成员:', inputType: 'input', modelName: 'isGroupCust' },
            { label: '所属集团名称:', inputType: 'input', modelName: 'attachGroupName' },
            { label: '黑名单标志:', inputType: 'input', modelName: 'whetherBlackList' },
            { label: '加入黑名单原因:', inputType: 'input', modelName: 'blackListReason' },
            { label: '是否为本行员工:', inputType: 'input', modelName: 'isBankEmployee' },
            { label: '是否有(营业执照):', inputType: 'input', modelName: 'ifcertificate' },
            { label: '是否是本地人:', inputType: 'input', modelName: 'natiflag' },
            
            //系统信息
            { label: '经办机构:', inputType: 'input', modelName: 'orgNum' },
            { label: '经办人:', inputType: 'input', modelName: 'userNum' },
            { label: '经办日期:', inputType: 'date', modelName: 'createTime' },
   
          ]
        }
      }
    },

    components: { CscFormPage },

   

    methods: {
      doCancel() {
        // this.$router.back()
        if (window.history.length <= 1) {
            this.$router.push({path:'/'})
            return false
        } else {
          this.$router.back(-1)
        }
      },
      naturalUserList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

    },
    mounted() {				// 页面加载完毕之后进行的渲染
      this.naturalUserList()
    }
  },
  }
</script>
