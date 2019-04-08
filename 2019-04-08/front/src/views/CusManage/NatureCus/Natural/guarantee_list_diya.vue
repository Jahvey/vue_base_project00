<template>
  <div class="app-container">
    <legend>为我行客户担保情况-本行保证情况</legend>
    <csc-single-button-table
      :pageDef="pageDef"
      :entity="entity"
      @pageQuery="doPageQuery"
      :disableQueryForm="disableQueryForm"
      :disableRowButtons="disableRowButtons"
    >
    </csc-single-button-table>
  </div>
</template>
<script>
  import {isEmpty} from "@/utils/validate"

  export default {
    data(){
      return {
        disableQueryForm:true,
        disableRowButtons:true,
        entity: {},
        selectedRow:{},
        pageDef: {
          queryDef: {
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "借款人名称", prop: "partyName"},
              {label: "业务品种", prop: "productType"},
              {label: "借款合同编号", prop: "contractNum"},
              {label: "抵/质押合同编号", prop: "subcontractNum"},
              {label: "抵/质押类型", prop: "collType"},
              {label: "抵/质押物类型", prop: "sortType"},
              {label: "币种", prop: "currencyCd"},
              {label: "借款余额", prop: "conYuE"},
              {label: "担保金额", prop: "subcontractAmt"},
              {label: "担保合同起期", prop: "beginDate"},
              {label: "担保合同止期", prop: "endDate"},
              {label: "抵/质押物出入库状态", prop: "status"}
            ]
          },
          buttons: []
        }
      }
    },
    methods: {
      doPageQuery(listQuery){
        let query =  Object.assign({},listQuery,{partyId:this.$route.query.rowData.partyId});
        this.$api.cusManage_naturalCus.getSubContractDYList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询本行抵质押情况失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询本行抵质押情况失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询本行抵质押情况失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      }
    }
  }
</script>
