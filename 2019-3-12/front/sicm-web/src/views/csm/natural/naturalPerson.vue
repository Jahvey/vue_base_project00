<template>
  <div>
    <!--<el-button type="primary" icon="el-icon-edit" @click="doEdit">编辑</el-button> -->
    <csc-form-dialog3 :pageDef="pageDef" :form="form" @doSave="doSave" @doCancel="doCancel">

      <!-- 父传子插槽 -->
      <!--<hr slot="selfDefine"></hr>-->
    </csc-form-dialog3>
  </div>
</template>

<script>
  import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  //import { saveUser ,queryUser,queryUserRole } from '@/api/user'

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
          title: "自然人客户详情",//2018-12-19 csc-form-dialog对话框弹出标题
          name:'NaturalCustomerForm',
          columnNum:2, //一行几列
          formRules:{

          },

          activeName:'tab1',//标签默认选中项  后期考虑动态根据标签加载dialog导航信息
          //动态传入标签数组
          tabPanes:[
            {tabName:'客户信息',name:'tab1'},
            {tabName:'评级信息',name:'tab4',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
            {tabName:'额度信息',name:'tab5',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
            {tabName:'业务申请',name:'tab2',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
            {tabName:'合同签约',name:'tab3',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}}


            //  {tabName:'客户信息',name:'tab1',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
            // {tabName:'评级信息',name:'tab4',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
            // {tabName:'额度信息',name:'tab5',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
            // {tabName:'业务申请',name:'tab2',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
            // {tabName:'合同签约',name:'tab3',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}}
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

    components:{CscFormDialog3},

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


      // doEdit(){
      //   this.pageDef.dialogFormVisible=true;
      //   console.log("doEdit进来没有:"+"---"+this.pageDef.dialogFormVisible+"-----"+this.form["username"]);
      // }


    },

    mounted() { 

      this.pageDef.dialogFormVisible=true;
      console.log("doEdit进来没有:"+"---"+this.pageDef.dialogFormVisible+"-----"+this.form["username"]);
     // this.doEdit() 
    }
  }
</script>
