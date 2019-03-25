<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @doSave="doSave" @doCancel="doCancel">
      <!-- <el-form-item slot="userRoleIdForShow" label="用户角色" prop="userRoleIdForShow">
            <el-checkbox-group v-model="form.userRoleIdForShow">
              <template v-for="(value,key) in srvObj">
                <el-col :span="8">
                  <el-checkbox :key="value.roleId" :label="key" :name="key">
                  </el-checkbox>
                </el-col>
              </template>
            </el-checkbox-group>
          </el-form-item> -->
    </csc-form-page>
  </div>
</template>

<script>
// import {getUserList,getUserListByPage} from "@/api/query"
import CscFormPage from "@/components/CscFormPage/CscFormPage"
import { queryUser,queryUserRole } from '@/api/user'

export  default {
  data() {
    return {
      srvObj: {},
      form:{userRoleIdForShow:[]},
      refVisible:{pkOrg:false},
      pageDef: {
        name:'用户信息',
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
            { required: true, message: '请选择是否授信客户', trigger: 'blur' },
            { message: '请选择是否授信客户', trigger: 'blur' }
          ],
          isThirdCust:[
            { required: true, message: '请选择是否第三方客户', trigger: 'blur' },
            { message: '请选择是否第三方客户', trigger: 'blur' }
          ],
          thirdCustType:[
            { required: true, message: '请选择第三方客户类型', trigger: 'blur' },
            { message: '请选择第三方客户类型', trigger: 'blur' }
          ]
        },
        //查询条件定义
        pageCols:[
          {label:"客户名称",inputType:"input",modelName:"custName"},
          {label:"国家或地区",inputType:"select",modelName:"district"},
          {label:"区域类型",inputType:"select",modelName:"districtType"},
          {label:"客户类型",inputType:"select",modelName:"custType"},
          {label:"统一社会信用代码",inputType:"input",modelName:"creditCode"},
          {label:"注册登记号码",inputType:"input",modelName:"registCode"},
          {label:"组织机构代码",inputType:"input",modelName:"orgCode"},
          {label:"中征码",inputType:"input",modelName:"middleCode"},
          {label:"是否授信客户",inputType:"select",modelName:"isCreditCust"},
          {label:"是否第三方客户",inputType:"select",modelName:"isThirdCust"},
          {label:"第三方客户类型",inputType:"select",modelName:"thirdCustType"}
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