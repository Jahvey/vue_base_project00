<template>
  <div class="app-container">
    <legend>违约记录</legend>
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
              {label: "客户名称", prop: "partyName"},
              {label: "合同编号", prop: "contractNum"},
              {label: "借据编号", prop: "summaryNum"},
              {label: "逾期/垫款金额", prop: "yqAmt"},
              {label: "逾期/垫款日期", prop: "overdueDate"},
              {label: "归还日期", prop: "repayDate"},
              {label: "备注", prop: "remark"},
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
        this.$api.cusManage_naturalCus.getIllegalRecordList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询违约记录失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询违约记录失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询违约记录失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      }
    }
  }
</script>
