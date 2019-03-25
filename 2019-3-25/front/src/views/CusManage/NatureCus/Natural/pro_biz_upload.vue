<template>
  <div class="app-container">
    <csc-single-button-table
      :pageDef="pageDef"
      :entity="entity"
      @pageQuery="doPageQuery"
      @rowDbclick="rowDbclick"
    >
    </csc-single-button-table>
  </div>
</template>
<script>
  import {isEmpty} from "@/utils/validate"

  export default {
    data(){
      return {
        entity: {},
        selectedRow:{},
        pageDef: {
          queryDef: {
            columnNum: 2, //一行几列
            queryCols: [
              {label: "文档名称", inputType: "input", modelName: "docName"}
            ]
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "文档名称", prop: "docName"},
              {label: "创建者", prop: "userNum"},
              {label: "创建时间", prop: "createTime"}
            ]
          },
          buttons: []
        }
      }
    },
    methods: {
        doPageQuery(listQuery){
            this.$api.cusManage_naturalCus.getNaturalBusinessList(listQuery).then((res) => {
            console.log(JSON.stringify(res))
            this.entity = res.data
            }).then(data!=null?data.callback:'')
            //this.entity = getCsmEntrustAccountList(listQuery)
        },
        rowDbclick(row){
        }
    }
  }
</script>
