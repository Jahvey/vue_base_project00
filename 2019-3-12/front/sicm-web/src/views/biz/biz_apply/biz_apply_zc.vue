<template>
  <div>
    <!--<el-button type="primary" icon="el-icon-edit" @click="doEdit">编辑</el-button> -->
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
          // username:'213242342',
          // personName:'12312423',
          // idNo:'1312234',
          // mobile:'11111'
        },
        pageDef: {
          dialogFormVisible: false,//2018-12-19 csc-form-dialog对话框弹出
          title: "业务申请新增",//2018-12-19 csc-form-dialog对话框弹出标题
          name:'biz_apply_zc',
          columnNum:2, //一行几列
          formRules:{

          },
          //查询条件定义
          tabDef: {
            pageCols:[
              {label:"客户编号：",inputType:"input",modelName:"partyNum"},
              {label:"客户名称：",inputType:"input",modelName:"partyName"},
              {label:"证件类型：",inputType:"input",modelName:"certType"},
              {label:"证件号码：",inputType:"input",modelName:"certNum"},

              {label:"信用等级：",inputType:"input",modelName:"creditLevel"},
              {label:"业务性质：",inputType:"input",modelName:"creditMode"},
              {label:"业务类型：",inputType:"input",modelName:"bizHappenType"},
              {label:"业务品种：",inputType:"input",modelName:"productType"},


              {label:"业务品种：",inputType:"input",modelName:"productType"},
              {label:"担保方式：",inputType:"input",modelName:"guarantyType"},


              {label:"是否银团：",inputType:"input",modelName:"isBankTeamLoan"},
              {label:"是否有按揭合作商：",inputType:"input",modelName:"busiPartner"},
              {label:"是否个人购买保障性住房：",inputType:"input",modelName:"whetherBzxzfdk"},


              {label:"低风险类型：",inputType:"input",modelName:"lowRiskBizType"},




            ]
          }

        }
      }
    },

    components:{CscFormDialog},

    created() {
      this.pageDef.dialogFormVisible=true;

      console.log("userEditDialog创建进来没有");
      let info = this.$route.params;
      // if (info) { // 是否编辑
      //   if (info.method !== undefined) {
      //     this.canEdit = info.method == 'edit'
      //   }
      // }
      this.getCompleteData(this.$route.params.approveId)
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
       // this.pageDef.dialogFormVisible=true;
       // console.log("doEdit进来没有:"+"---"+this.pageDef.dialogFormVisible+"-----"+this.form["username"]);
      }
    }
  }
</script>
