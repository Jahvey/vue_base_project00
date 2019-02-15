<template>
  <div>
    <el-button type="primary" icon="el-icon-edit" @click="doEdit">编辑</el-button>
    <el-form ref="dialogWithTreeTest" :model="cusInfo" label-width="80px">
    <el-row>
      <el-col :span="12">
        <el-form-item label="产品代码" prop="productCd">
          <el-input v-model="cusInfo.productCd"></el-input>
        </el-form-item>
      </el-col>

      <el-col :span="12">
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="cusInfo.productName"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
    </el-form>


    <csc-form-dialog-tree :pageDef="pageDef" :form="form" @doSave="doSave" @doCancel="doCancel" @getProductCd="getProductCd">

      <!-- 父传子插槽 -->
      <!--<hr slot="selfDefine"></hr>-->
    </csc-form-dialog-tree>
  </div>
</template>

<script>
  import CscFormDialogWithTree from "@/components/CscFormDialog/CscFormDialogWithTree"
  import { saveUser ,queryUser,queryUserRole } from '@/api/user'

  export  default {
    name: 'dialogWithTreeTest',
    data() {
      return {
        cusInfo:
          {
          productCd:'',
          productName:'11111'
          },//2018-12-18 接收dialog传回的值
        form:{
          username:'213242342',
          personName:'12312423',
          idNo:'1312234',
          mobile:'11111'
        },
        pageDef: {
          dialogFormVisible: false,//2018-12-19 csc-form-dialog对话框弹出
          title: "我的客户222",//2018-12-19 csc-form-dialog对话框弹出标题
          name:'myCustomerForm',
          columnNum:2, //一行几列
          formRules:{

          },
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

    components:{CscFormDialogWithTree},

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
      },
      getProductCd(data){
        // this.cusInfo.productCd=data.productCd;
        // this.cusInfo.productName=data.productName;
        this.cusInfo.productCd=data.productLevel;
        this.cusInfo.productName=data.label;
      }
    }
  }
</script>
