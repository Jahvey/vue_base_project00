<template>
  <div>
    <el-tabs type="border-card">
      <el-tab-pane label="概况">
        <csc-form-page :pageDef="pageDef" :formData="form" @doSave="doSave" @doCancel="doCancel">
        </csc-form-page>
      </el-tab-pane>
      <el-tab-pane label="证件信息">
        <csc-form-page :pageDef="cardMsg" :formData="form" @doSave="doSave" @doCancel="doCancel">
        </csc-form-page>
      </el-tab-pane>
      <el-tab-pane label="分类信息">
        <csc-form-page :pageDef="assortMsg" :formData="form" @doSave="doSave" @doCancel="doCancel">
        </csc-form-page>
      </el-tab-pane>
      <el-tab-pane label="企业规模">
        <csc-form-page :pageDef="enterpriseScale" :formData="form" @doSave="doSave" @doCancel="doCancel">
        </csc-form-page>
      </el-tab-pane>
      <el-tab-pane label="重要标志">
        <csc-form-page :pageDef="symbol" :formData="form" @doSave="doSave" @doCancel="doCancel">
        </csc-form-page>
      </el-tab-pane>
    </el-tabs>
    <!-- <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree> -->
  </div>
</template>

<script>
// import {getUserList,getUserListByPage} from "@/api/query"
import CscFormPage from "@/components/CscFormPage/CscFormPage"
import { queryUser,queryUserRole } from '@/api/user'

export  default {
  data() {
    return {
      data: [{
          label: '客户信息管理',
          children: [{
            id : 1,
            label: '基本概况信息（企业类）',
          },
          {
            id : 2,
            label: '基本概况信息（事业类）',
          }]
        }],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
      srvObj: {},
      form:{userRoleIdForShow:[]},
      refVisible:{pkOrg:false},
      pageDef: {
        name:'概况',
        columnNum:2, //一行几列
        formRules:{
          custName:[
            { required: true, message: '请输客户名称', trigger: 'blur' },
            { pattern: /^\w*$/, message: '客户名称只能包含字母、数字以及_', trigger: 'blur' },
            { max:100, message: '最大长度为100个字符', trigger: 'blur' }
          ],
          districtType:[
            { required: true, message: '请输入区域类型', trigger: 'blur' },
            { max:100, message: '最大长度为100个字符', trigger: 'blur' }
          ],
          custType:[
            { required: true, message: '请选择客户类型', trigger: 'blur' },
            { max:4, message: '最大长度为4个字符', trigger: 'blur' }
          ],
          registCode:[
            { required: true, message: '请输入注册登记号码', trigger: 'blur' },
            { max:20, message: '最大长度为20个字符', trigger: 'blur' }
          ],
          isCreditCust:[
            { required: true, message: '请选择是否授信客户', trigger: 'blur' }
          ],
          isThirdCust:[
            { required: true, message: '请选择是否第三方客户', trigger: 'blur' }
          ],
          thirdCustType:[
            { required: true, message: '请选择第三方客户类型', trigger: 'blur' }
          ]
        },
        
        pageCols:[
          {label:"客户名称",inputType:"input",modelName:"custName"},
          {label:"国家或地区",inputType:"select",modelName:"district"},
          {label:"区域类型",inputType:"select",modelName:"districtType"},
          {label:"客户类型",inputType:"select",modelName:"custType"},
          {label:"统一社会信用代码",inputType:"input",modelName:"creditCode"},
          {label:"注册登记号码",inputType:"input",modelName:"registCode"},
          {label:"组织机构代码",inputType:"input",modelName:"orgCode"},
          {label:"中征码",inputType:"input",modelName:"middleCode"},
          {label:"是否授信客户",inputType:"select",modelName:"isCreditCust",enumType:"ifUsed"},
          {label:"是否第三方客户",inputType:"select",modelName:"isThirdCust",enumType:"ifUsed"},
          {label:"第三方客户类型",inputType:"select",modelName:"thirdCustType"}
        ]
      },
      cardMsg:{
        name:'证件信息',
        columnNum:2,
        formRules:{
          legalReprName:[
            { required: true, message: '请输法人代表姓名', trigger: 'blur' }
          ],
          legalCardType:[
            { required: true, message: '请输入法人代表证件类型', trigger: 'blur' }
          ],
          legalIdCard:[
            { required: true, message: '请输入法人代表证件号码', trigger: 'blur' }
          ],
          certExpireDate:[
            { required: true, message: '请输入证件到期日', trigger: 'blur' }
          ],
          registType:[
            { required: true, message: '请输入登记注册类型', trigger: 'blur' }
          ],
          promoterEco:[
            { required: true, message: '请输入企业出资人经济成分', trigger: 'blur' }
          ],
          registCode:[
            { required: true, message: '请输入注册登记号码', trigger: 'blur' }
          ],
          registDate:[
            { required: true, message: '请输入注册登记日期', trigger: 'blur' }
          ],
          registCertExpireDate:[
            { required: true, message: '请输入注册登记证到期日', trigger: 'blur' }
          ],
          scope:[
            { required: true, message: '请输入经营范围', trigger: 'blur' },
            { max: 800, message:"最大长度为800个字符", trigger:"blur"}
          ],
          currency:[
            { required: true, message: '请输入注册资本币种', trigger: 'blur' }
          ],
          registeredCapital:[
            { required: true, message: '请输入注册资本', trigger: 'blur' },
            { pattern: /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/, message: '注册资本只能只能为最多两位小数的数字', trigger: 'blur' }
          ],
          taxRegisterCode:[
            { required: true, message: '请输入国税登记证号码', trigger: 'blur' },
            { pattern: /^[A-Za-z0-9]{15}$/, message: '国税登记证号码只能只能为15位或20位字母和数字', trigger: 'blur' }
          ],
          landTaxRegisterCode:[
            { required: true, message: '请输入地税登记证号码', trigger: 'blur' },
            { pattern: /^[A-Za-z0-9]{20}$/, message: '地税登记证号码只能只能为15位或20位字母和数字', trigger: 'blur' }
          ]
        },
        pageCols:[
          {label:"法人代表姓名",inputType:"input",modelName:"legalReprName"},
          {label:"法人代表证件类型",inputType:"select",modelName:"legalCardType"},
          {label:"法人代表证件号码",inputType:"input",modelName:"legalIdCard"},
          {label:"证件到期日",inputType:"date",modelName:"certExpireDate"},
          {label:"登记注册类型",inputType:"select",modelName:"registType"},
          {label:"企业出资人经济成分",inputType:"select",modelName:"promoterEco"},
          {label:"统一社会信用代码",inputType:"input",modelName:"creditCode"},
          {label:"注册登记号码",inputType:"input",modelName:"registCode"},
          {label:"注册登记日期",inputType:"date",modelName:"registDate"},
          {label:"注册登记证到期日",inputType:"date",modelName:"registCertExpireDate"},
          {label:"经营范围",inputType:"input",modelName:"scope"},
          {label:"注册资本币种",inputType:"select",modelName:"currency"},
          {label:"注册资本",inputType:"input",modelName:"registeredCapital"},
          {label:"组织机构代码",inputType:"input",modelName:"orgCode"},
          {label:"组织机构代码证到期日",inputType:"date",modelName:"orgCodeExpireDate"},
          {label:"中征码",inputType:"input",modelName:"middleCode"},
          {label:"机构信用代码",inputType:"input",modelName:"orgCreditCode"},
          {label:"国税登记证号码",inputType:"input",modelName:"taxRegisterCode"},
          {label:"地税登记证号码",inputType:"input",modelName:"landTaxRegisterCode"},
          {label:"法人国藉、控股股东或者实际控制人",inputType:"input",modelName:"controller"}
        ]
      },
      assortMsg:{
        name:'分类信息',
        columnNum:2,
        formRules:{
          industryCategory:[
            { required: true, message: '请输入行业门类', trigger: 'blur' }
          ],
          industryHeading:[
            { required: true, message: '请输入行业大类', trigger: 'blur' }
          ],
          industryMiddle:[
            { required: true, message: '请输入行业中类', trigger: 'blur' }
          ],
          industrySubd:[
            { required: true, message: '请输入行业小类', trigger: 'blur' }
          ],
        },
        pageCols:[
          {label:"行业门类",inputType:"select",modelName:"industryCategory"},
          {label:"行业大类",inputType:"select",modelName:"industryHeading"},
          {label:"行业中类",inputType:"select",modelName:"industryMiddle"},
          {label:"行业小类",inputType:"select",modelName:"industrySubd"}
        ]
      },
      enterpriseScale:{
        name:'企业规模',
        columnNum:2,
        formRules:{
          personNum:[
            { required: true, message: '请输入从业人数（人）', trigger: 'blur' },
            { pattern: /^[0-9]$/, message: '从业人数（人）只能只能为数字', trigger: 'blur' }
          ],
          miitScale:[
            { required: true, message: '工信部企业规模不能为空', trigger: 'blur' }
          ],
          statisticScale:[
            { required: true, message: '请输入统计口径企业规模', trigger: 'blur' }
          ],
        },
        pageCols:[
          {label:"从业人数（人）",inputType:"input",modelName:"personNum"},
          {label:"工信部企业规模",inputType:"input",modelName:"miitScale"},
          {label:"统计口径企业规模",inputType:"input",modelName:"statisticScale"}
        ]
      },
      symbol:{
        name:'重要标志',
        columnNum:2,
        formRules:{

        },
        pageCols:[
          {label:"是否上市公司",inputType:"select",modelName:"isQuotedCom"},
          {label:"进出口权标志",inputType:"select",modelName:"im_ex_right"},
          {label:"家族企业标志",inputType:"select",modelName:"familyCom"},
          {label:"融资平台标志",inputType:"select",modelName:"lgfpSymbol"},
          {label:"重点客户标志",inputType:"select",modelName:"importantCust"},
          {label:"是否从事房地产开发",inputType:"select",modelName:"isEstate"},
          {label:"农村企业标志",inputType:"select",modelName:"countryEnterprise"},
          {label:"是否我行关联方",inputType:"input",modelName:"isAffiliate"},
          {label:"我行股东标志",inputType:"input",modelName:"stockholder"},
          {label:"联保小组标志",inputType:"input",modelName:"jointGuarantee"},
          {label:"是否统一授信成员",inputType:"input",modelName:"isCreditMember"},
          {label:"所属统一授信客户名称",inputType:"input",modelName:"creditCustName"},
          {label:"黑名单标志",inputType:"input",modelName:"blackListSymbol"},
          {label:"与我行建立信贷关系日期",inputType:"input",modelName:"creditRelationTime"}
        ]
      }
    }
  },

  components:{CscFormPage},

  created() {
    let info = this.$route.params;
    if (info) { // 是否编辑
      if (info.method !== undefined) {
        this.canEdit = info.method == 'edit'
      }
    }
    this.getCompleteData(this.$route.params.userId)
  },

  methods:{
    async getCompleteData(userId) {
      this.queryUserRoleForShow();
      if (userId) { // 修改的单据
        queryUser({userId:userId}).then(response => {
          let rowdata = {};
          Object.assign(rowdata, response);
          rowdata.userRoleIdForShow=[];
          rowdata.userRoleList.forEach((userRoleT, index) => {  
            rowdata.userRoleIdForShow.push(userRoleT.roleName);
          });
          this.form = rowdata;
          debugger
        }).catch((error)=>{
          console.log(error)
        })
      }
    },
    doCancel() {
      this.$router.back()
    },
    transUserRoleToCode(userRoleNames){
        var userRoleCode = [];
        userRoleNames.forEach((val, index) => {
          var userRoleObj = {};
          userRoleObj = this.srvObj[val];
          userRoleCode.push(userRoleObj)
        });
        return userRoleCode;
      },
    handleNodeClick(data) {
      console.log(data.$treeNodeId);
    },
    doSave(form){
      form.userRoleList=this.transUserRoleToCode(this.form.userRoleIdForShow);
      saveUser(form).then(response => {
        this.$message({
          type: 'success',
          message: '保存成功!'
        })
        this.$router.back()
      })
    }
  }
}
</script>