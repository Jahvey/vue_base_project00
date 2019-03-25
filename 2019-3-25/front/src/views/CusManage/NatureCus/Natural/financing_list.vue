<template>
  <div class="app-container">
    <legend>本行融资情况-批复信息</legend>
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
              {label: "批复编号", prop: "approvalNum"},
              {label: "业务性质", prop: "bizType"},
              {label: "批复金额", prop: "creditAmount"},
              {label: "批复已用金额", prop: "availableAmt"},
              {label: "批复起期", prop: "startDate"},
              {label: "批复止期", prop: "endDate"},
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
        this.$api.cusManage_naturalCus.getApproveList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询批复信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询批复信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询批复信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      }
    }
  }
</script>
