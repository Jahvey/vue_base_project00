<template>
  <div>
    <!--<el-button type="primary" icon="el-icon-edit" @click="doEdit">编辑</el-button>-->

    <csc-form-dialog3 :pageDef="pageDef" :form="form" @doSave="doSave" @doCancel="doCancel">

      <!-- 父传子插槽 -->
      <!--<hr slot="selfDefine"></hr>-->
    </csc-form-dialog3>
  </div>
</template>

<script>
  import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
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
          title: "担保合同信息",//2018-12-19 csc-form-dialog对话框弹出标题
          name:'sub_con_tree',
          columnNum:2, //一行几列
          
          treeData: [{
          label: '一级 1',
          icon:'el-icon-success',
          productLevel: '1',
          isLeaf: '0',
          children: [{
            label: '二级 1-1',
            icon: "el-icon-delete",
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 1-1-1',
              icon: "el-icon-delete",
              isLeaf: '1',
              url:'four',
              productLevel: '3'
            }]
          }]
        }, {
          label: '一级 2',
          productLevel: '1',
          isLeaf: '0',
          icon: "el-icon-delete",
          children: [{
            label: '二级 2-1',
            productLevel: '2',
            isLeaf: '0',
            icon: 'el-icon-delete',
            children: [{
              label: '三级 2-1-1',
              productLevel: '3',
              isLeaf: '1',
              url:'five',
              icon: "el-icon-delete"
            }]
          }, {
            label: '二级 2-2',
            icon: 'el-icon-delete',
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 2-2-1',
              productLevel: '3',
              isLeaf: '1',
              url:'six',
              icon: "el-icon-delete"
            }]
          }]
        }, {
          label: '一级 3',
          icon: "el-icon-delete",
          productLevel: '1',
          isLeaf: '0',
          children: [{
            label: '二级 3-1',
            productLevel: '2',
            isLeaf: '0',
            icon: 'el-icon-delete',
            children: [{
              label: '三级 3-1-1',
              productLevel: '3',
              isLeaf: '1',
              url:'seven',
              icon: "el-icon-delete"
            }]
          }, {
            label: '二级 3-2',
            icon: 'el-icon-delete',
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 3-2-1',
              productLevel: '3',
              isLeaf: '1',
              url:'eight',
              icon: "el-icon-delete"
            }]
          }]
        }],
          formRules:{

          },

          activeName:'tab1',//标签默认选中项  后期考虑动态根据标签加载dialog导航信息
          //动态传入标签数组
          tabPanes:[
            {tabName:'担保合同信息',name:'tab1',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},

          ],

          //查询条件定义
          tabDef: {
            pageCols:[
              // {label:"用户名",inputType:"input",modelName:"username",value:"qqqqq"},
              // {label:"姓名",inputType:"input",modelName:"personName",value:"aaaa"},
              // {label:"证件号码",inputType:"input",modelName:"idNo",value:"fffff"},
              // {label:"手机号",inputType:"input",modelName:"mobile",value:"vvvv"}
            ]
          }

        }
      }
    },

    components:{CscFormDialog3},

    created() {
       this.pageDef.dialogFormVisible=true
        console.log("doEdit进来没有:"+"---"+this.pageDef.dialogFormVisible+"-----"+this.form["username"])

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
      }
    }
  }
</script>
