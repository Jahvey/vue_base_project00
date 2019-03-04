<template>
  <div>
    <csc-form-page :pageDef="pageDef" :formData="form" @doSave="doSave" @doCancel="doCancel">
      <el-form-item slot="userRoleIdForShow" label="用户角色" prop="userRoleIdForShow">
            <el-checkbox-group v-model="form.userRoleIdForShow">
              <template v-for="(value,key) in srvObj">
                <el-col :span="6">
                  <el-checkbox :key="value.roleId" :label="value.roleName" :name="key">
                  </el-checkbox>
                </el-col>
              </template>
            </el-checkbox-group>
          </el-form-item>
    </csc-form-page>
  </div>
</template>

<script>
// import {getUserList,getUserListByPage} from "@/api/query"
import CscFormPage from "@/components/CscFormPage/CscFormPage"
import { saveUser ,queryUser,queryUserRole } from '@/api/user'

export  default {
  data() {
    return {
      srvObj: {},//查询多选框的值
      form:{userRoleIdForShow:[]},//设定多选框选中的值
      refVisible:{pkOrg:false},
      pageDef: {
        name:'用户信息',
        columnNum:2, //一行几列
        formRules:{
          username:[
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { pattern: /^\w*$/, message: '用户名只能包含字母、数字以及_', trigger: 'blur' },
            { max:100, message: '最大长度为100个字符', trigger: 'blur' }
          ],
          personName:[
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { max:100, message: '最大长度为100个字符', trigger: 'blur' }
          ],
          idTypeCd:[
            { required: true, message: '请选择证件类型', trigger: 'blur' },
            { max:4, message: '最大长度为4个字符', trigger: 'blur' }
          ],
          idNo:[
            { required: true, message: '请输入证件号码', trigger: 'blur' },
            { max:20, message: '最大长度为20个字符', trigger: 'blur' }
          ],
          mobile:[
            { required: true, message: '请输入手机号', trigger: 'blur' },
            { pattern: /^1[3-9](\d){9}$/g, message: '请输入正确的手机号码', trigger: 'blur' }
          ],
          email:[
            { pattern: /^\w+@\w+\.(cn|com|net|org)$/, message: '请输入正确的邮箱', trigger: 'blur' },
            { max:60, message: '最大长度为60个字符', trigger: 'blur' }
          ]
        },
        //查询条件定义
        pageCols:[
          {label:"用户名",inputType:"input",modelName:"username",disabled:''},
          {label:"姓名",inputType:"input",modelName:"personName"},
          {label:"证件类型",inputType:"select",modelName:"idTypeCd",enumType:"idTypeCd"},
          {label:"证件号码",inputType:"input",modelName:"idNo"},
          {label:"手机号",inputType:"input",modelName:"mobile"},
          {label:"邮箱",inputType:"input",modelName:"email"},
          {label:"角色",inputType:"refType",modelName:"userRoleIdForShow"}
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


      // if (userId) { // 修改的单据
      //   queryUser({userId:userId}).then(response => {
      //     let rowdata = {};
      //     Object.assign(rowdata, response);
      //     rowdata.userRoleIdForShow=[];
      //     rowdata.userRoleList.forEach((userRoleT, index) => {
      //       rowdata.userRoleIdForShow.push(userRoleT.roleName);
      //     });
      //     this.form = rowdata;
      //     debugger
      //   }).catch((error)=>{
      //     console.log(error)
      //   })
      // }


    },
    doCancel() {
      this.$router.back()
    },
    // transUserRoleToCode(userRoleNames){
    //     var userRoleCode = [];
    //     userRoleNames.forEach((val, index) => {
    //       var userRoleObj = {};
    //       userRoleObj = this.srvObj[val];
    //       userRoleCode.push(userRoleObj)
    //     });
    //     return userRoleCode;
    //   },

    transUserRoleToCode(userRoleNames){
      var userRoleCode = [];
      userRoleNames.forEach((val, index) => {
        var userRoleObj = {};
        userRoleObj = this.srvObj[index];//整个选中对象
        // userRoleObj = {"roleId":this.srvObj[index].roleId};//只保存id
        userRoleObj = this.srvObj[index].roleId;//只保存id
        userRoleCode.push(userRoleObj);
      });
      return userRoleCode;
    },

    doSave(form){
      console.log("doSave userRoleList1:"+JSON.stringify(this.form.userRoleIdForShow));
      form.userRoleList=this.transUserRoleToCode(this.form.userRoleIdForShow);
      console.log("doSave userRoleList2:"+JSON.stringify(form.userRoleList));
      saveUser(form).then(response => {
        this.$message({
          type: 'success',
          message: '保存成功!'
        })
        this.$router.back()
      })
    },
    queryUserRoleForShow() {


      // queryUserRole().then(response => {
      //     var srvObjT = {};
      //     response.forEach(function (service, index) {
      //       srvObjT[service.roleName] = {"roleId": service.roleId, "checked": false}
      //     });
      //     this.srvObj = srvObjT;
      //   })
      let queryParam={"legorg":'5099'};
      queryUserRole(queryParam).then(response => {
        var srvObjT = {};
        response.data.forEach(function (service, index) {
          console.log("service1:"+JSON.stringify(service));
          srvObjT[index] = {"roleId": service.POSICODE, "roleName": service.POSINAME, "checked": false}
        });
        this.srvObj = srvObjT;
      })


    }
  }
}
</script>
