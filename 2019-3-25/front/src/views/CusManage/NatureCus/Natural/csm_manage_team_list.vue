<template>
  <div class="app-container">
    <csc-single-button-table
      :pageDef="pageDef"
      :entity="entity"
      :disableQueryForm="disableQueryForm"
      :disableRowButtons="disableRowButtons"
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
              {label: "用户编号", prop: "userNum"},
              {label: "用户名称", prop: "userNum"},
              {label: "管理权限", prop: "userPlacingCd"},
              {label: "所在机构名称", prop: "orgNum"}
            ]
          },
          buttons: []
        }
      }
    },
    methods: {
      doPageQuery(listQuery){
        let query =  Object.assign({},listQuery,{partyId:this.$route.query.rowData.partyId});
        this.$api.cusManage_naturalCus.getManagementTeamList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询我行管理团队信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询我行管理团队失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询我行管理团队失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      }
    }
  }
</script>
