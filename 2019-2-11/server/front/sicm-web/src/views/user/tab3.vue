<template>

  <div>
    <h3>这是第三个标签页 测试动态设置输入框是否可编辑  这个就是具体的业务逻辑页面 可以实际到具体的哪个字段</h3>
    <csc-form-page :pageDef="pageDef" :formData="form" @fieldChange="fieldChange">

    </csc-form-page>
  </div>



</template>

<script>
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  import {getTbCsmPartyInfoById,getTbCsmNaturalPersonInfoById} from '@/api/dashboard'
    export default {
        name: "tab3",
        data() {
          return {
            form:{},
            pageDef: {
              name: '',
              columnNum: 2,
              formRules:{

              },
              pageCols: [
                {label:"用户名",inputType:"input",modelName:"username",disabled: ''},
                {label:"姓名",inputType:"input",modelName:"personName",disabled: ''},
                {label:"证件类型",inputType:"select",modelName:"idTypeCd",enumType:"idTypeCd"},
                {label:"证件号码",inputType:"input",modelName:"idNo"},
                {label:"手机号",inputType:"input",modelName:"mobile"},
                {label:"邮箱",inputType:"input",modelName:"email"},
                {label:"参与人编号",inputType:"input",modelName:"partyNum"},
                {label:"参与人名称",inputType:"input",modelName:"partyName"}
              ]
            }
          }
        },
        props:{

        },
        components:{CscFormPage},
        methods:{
          getDisabledValue(){
            return true;
          },
          getNameDisabledValue() {
            return true;
          },

          getTbCsmPartyInfo() {
            let queryParams={partyId:"5AF8119026E0FABDE05010AC57DD79A2"};
            // alert("页面复制:"+queryParams.partyId);
            getTbCsmPartyInfoById({partyId:"5AF8119026E0FABDE05010AC57DD79A2"}).then(response => {
              // alert("具体值2:"+response);
              // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
              if (response !== undefined) {
                var obj = {}
                this.form = response.data;
              }
            })
          },
          fieldChange(modelName, val) {
            console.log("tab3:"+modelName+"--"+JSON.stringify(val));
          }

        },
      beforeCreate:function () {

      },
      created:function() {

      },
      mounted:function () {
        this.getTbCsmPartyInfo();
      }
    }
</script>

<style scoped>

</style>
