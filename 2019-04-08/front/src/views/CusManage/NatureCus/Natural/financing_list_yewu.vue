<template>
  <div class="app-container">
    <legend>本行融资情况-业务信息</legend>
    <csc-single-button-table
      :pageDef="pageDef"
      :entity="entity"
      :disableQueryForm="disableQueryForm"
      :disableRowButtons="disableRowButtons"
      @pageQuery="doPageQuery"
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
              {label: "合同编号", prop: "contractNum"},
              {label: "业务品种", prop: "productType"},
              {label: "币种", prop: "currencyCd"},
              {label: "合同金额", prop: "contractAmt"},
              {label: "合同已用金额", prop: "conYuE"},
              {label: "合同起期", prop: "beginDate"},
              {label: "合同止期", prop: "endDate"},
              {label: "保证金余额", prop: "bzjje"},
              {label: "逾期天数", prop: "yqts"},
              {label: "逾期本金", prop: "jjyqbj"},
              {label: "逾期利息", prop: "arrearItr"},
              {label: "分类", prop: "clsResult"},
              {label: "经办机构", prop: "orgNum"},
              {label: "经办人", prop: "userNum"}
            ]
          },
          buttons: []
        }
      }
    },
    methods: {
      doPageQuery(listQuery){
        let query =  Object.assign({},listQuery,{partyId:this.$route.query.rowData.partyId});
        this.$api.cusManage_naturalCus.getContractInfoList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询业务信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询业务信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询业务信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      }
    }
  }
</script>
