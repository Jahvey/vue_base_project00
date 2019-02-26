<template>
  <div>
    <el-button type="primary" icon="el-icon-edit" @click="doEdit">编辑</el-button>
    <csc-form-dialog :pageDef="pageDef" :form="form" @doSave="doSave" @doCancel="doCancel">

      <!-- 父传子插槽 -->
      <!--<hr slot="selfDefine"></hr>-->
    </csc-form-dialog>
  </div>
</template>

<script>
import CscFormDialog from "@/components/CscFormDialog/CscFormDialog"
import { saveUser ,queryUser,queryUserRole } from '@/api/user'

export  default {
  data() {
    return {
      form:{
          username:'213242342',
          personName:'12312423',
          idNo:'1312234',
          mobile:'11111'
      },
      pageDef: {
        dialogFormVisible: false,//2018-12-19 csc-form-dialog对话框弹出
        title: "我的客户111",//2018-12-19 csc-form-dialog对话框弹出标题
        name:'myCustomerForm',
        columnNum:2, //一行几列
        formRules:{

        },
        activeName:'first',//标签默认选中项  后期考虑动态根据标签加载dialog导航信息
        //2018-12-29 动态传入标签数组  测试能否点击tab动态切换内容
        tabPanes:[
          {tabName:'标签一',name:'first',component:'first',components:['first']},
          {tabName:'标签二',name:'second',component:'second',components:['second']},
          {tabName:'标签三',name:'third',component:'third',components:['third']}
        ],
        //查询条件定义
        tabDef: {
          pageCols:[
            {label:"用户名",inputType:"input",modelName:"username",value:"qqqqq"},
            {label:"姓名",inputType:"input",modelName:"personName",value:"aaaa"},
            {label:"证件号码",inputType:"input",modelName:"idNo",value:"fffff"},
            {label:"手机号",inputType:"input",modelName:"mobile",value:"vvvv"}
          ]
        }

      }
    }
  },

  components:{CscFormDialog},

  created() {

    // console.log("userEditDialog创建进来没有");
    // let info = this.$route.params;
    // if (info) { // 是否编辑
    //   if (info.method !== undefined) {
    //     this.canEdit = info.method == 'edit'
    //   }
    // }
    // this.getCompleteData(this.$route.params.userId)
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
      // this.$router.back()
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
    },
    queryUserRoleForShow() {
      queryUserRole().then(response => {
          var srvObjT = {};
          response.forEach(function (service, index) {
            srvObjT[service.roleName] = {"roleId": service.roleId, "checked": false}
          });
          this.srvObj = srvObjT;
        })
    },
    doEdit(){
     this.pageDef.dialogFormVisible=true;
      console.log("doEdit进来没有:"+"---"+this.pageDef.dialogFormVisible+"-----"+this.form["username"]);
    }
  }
}
</script>
