<template>
  <csc-base-ref :modelName="modelName" :formData="formData" :condition="condition" :pageDef="pageDef" @doPageQuery="doPageQuery"
  :displayFiledName="displayFiledName" :entity="entity" @getRefValue="getRefValue" title="药品信息">
    
  </csc-base-ref>
</template>
<script>
  import CscBaseRef from "@/components/CscRef/CscBaseRef"
  import { getMedicineList } from '@/api/medicine'

  export default {
    name: 'CscOlderRef',
    props: {
      formData:Object,
      modelName:{
        required : true
      },
      displayFiledName:{
        default:'medicineName'
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
          //查询条件定义
          queryDef:{
            columnNum:3, //一行几列
            queryCols:[
              {label:"药品通用名称",inputType:"input",modelName:"medicineName"},
              {label:"功能主治",inputType:"input",modelName:"usgaes"},
              {label:"禁忌",inputType:"input",modelName:"restrictions"}
            ]
          },
          tabDef: {
            //表格字段定义
            tabCols: [
              {label: "药品通用名称", prop:"medicineName", isSort: true},
              {label: "药品汉语拼音", prop:"medicinePy", isSort: true},
              {label: "成份", prop:"component", isSort: true},
              {label: "性状", prop:"description", isSort: true},
              {label: "功能主治", prop:"usgaes", isSort: true},
              {label: "规格", prop:"specification", isSort: true},
              {label: "用法用量", prop:"dosageUse", isSort: true},
              {label: "不良反应", prop:"adverseReaction", isSort: true},
              {label: "禁忌", prop:"restrictions", isSort: true},
              {label: "注意事项", prop:"precautions", isSort: true},
              {label: "药物相互作用", prop:"interactions", isSort: true}

            ]
          },
          rowButtons: []
        }
      }
    },

    components:{CscBaseRef},

    methods: {
      doPageQuery(params){
        getMedicineList(params).then(response => {
          this.entity = response
        })
      }, 
      getRefValue(selectedRow, modelName) {
        this.$emit('getRefValue', selectedRow, modelName)
      }
    }
  }
</script>
