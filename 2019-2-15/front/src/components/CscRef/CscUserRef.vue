<template>
  <csc-base-ref :modelName="modelName" :formData="formData" :condition="condition" :pageDef="pageDef" @doPageQuery="doPageQuery"
  :displayFiledName="displayFiledName" :disabled="disabled" :entity="entity" @getRefValue="getRefValue" title="用户信息">
    
  </csc-base-ref>
</template>
<script>
  import CscBaseRef from "@/components/CscRef/CscBaseRef"
  import { getUserList } from '@/api/user'

  export default {
    name: 'CscUserRef',
    props: {
      formData:Object,
      modelName:{
        required : true
      },
      displayFiledName:{
        default:'personName'
      },
      condition:Object,
      disabled:{
        default:false
      }
    },

    data(){
      return {
        entity: {},
        pageDef: {
          queryDef: {
            columnNum: 3, //一行几列
            queryCols: [
              {label: "姓名", inputType: "input", modelName: "personName"},
              {label: "证件号码", inputType: "input", modelName: "idNo"},
              {label: "手机号", inputType: "input", modelName: "mobile"}
            ]
          },
          tabDef: {
            //表格字段定义
            tabCols: [
              {label: "姓名", prop:"personName", isSort: true},
              {label: "证件类型", prop:"idTypeCd", isSort: true, isFormat:true},
              {label: "证件号码", prop:"idNo", isSort: true},
              {label: "手机", prop:"mobile", isSort: true}
            ]
          },
          rowButtons: []
        }
      }
    },

    components:{CscBaseRef},

    methods: {
      doPageQuery(params){
        getUserList(params).then(response => {
          this.entity = response
        })
      }, 
      getRefValue(selectedRow, modelName) {
        this.$emit('getRefValue', selectedRow, modelName)
      }
    }
  }
</script>
