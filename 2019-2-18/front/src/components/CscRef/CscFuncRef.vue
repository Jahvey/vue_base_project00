<template>
  <csc-base-ref :modelName="modelName" :formData="formData" :condition="condition" :pageDef="pageDef" @doPageQuery="doPageQuery"
                :displayFiledName="displayFiledName" :disabled="disabled" :entity="entity" @getRefValue="getRefValue" title="功能菜单">

  </csc-base-ref>
</template>
<script>
  import CscBaseRef from "@/components/CscRef/CscBaseRef"
  import { pageQueryFunc } from '@/api/docSet'

  export default {
    name: 'CscFuncRef',
    props: {
      formData:Object,
      modelName:{
        required : true
      },
      displayFiledName:{
        default:'funcName'
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
              {label: "功能菜单", inputType: "input", modelName: "funcName"}
            ]
          },
          tabDef: {
            //表格字段定义
            tabCols: [
              {label: "功能菜单", prop:"funcName", isSort: true}
            ]
          },
          rowButtons: []
        }
      }
    },

    components:{CscBaseRef},

    methods: {
      doPageQuery(params){
        pageQueryFunc(params).then(response => {
          this.entity = response
        })
      },
      getRefValue(selectedRow, modelName) {
        this.$emit('getRefValue', selectedRow, modelName)
      }
    }
  }
</script>
