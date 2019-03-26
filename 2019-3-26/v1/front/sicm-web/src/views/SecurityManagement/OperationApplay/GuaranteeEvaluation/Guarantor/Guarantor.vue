<!--保证人页面-->
<template>
  <div>
    <el-row>
      <p class="m-t-b-0">保证人</p>
      <el-col :span="24">
        <csc-single-table
          :pageDef="pageDef"
          :entity="entity"
          :disableRowButtons="disableRowButtons"
          :disableQueryForm="disableQueryForm"
          :disableQueryButtons="disableQueryButtons"
          @add="doAdd"
          @refresh="refresh"
          @doEdit="doEdit"
          @scan="scan"
          @pageQuery="doPageQuery"
          @doDelete="doDelete"
        >
        </csc-single-table>
      </el-col>
    </el-row>
    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="60%"
      :fullscreen="fullScreen"
      v-if='dialogVisible'
      :before-close="handleGoodsDetailInfoClose"
      append-to-body>
      <!--动态组件-->
        <compoment v-bind:is="currentView" v-bind:info="info" v-on:backFlag="getMsg"></compoment>
    </el-dialog>
  </div>
</template>

<script>
  import { getGuaranteerList,getGuaranteerBySuretyId,deleteGuaranteeApplyTbGrtGuaranteerBySuretyId} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
  import addGuarantor from './AddGuarantor'
  import editGuarantor from './EditGuarantor'
    export default {
      name: "guarantor",
      components:{
        addGuarantor,
        editGuarantor,
      },
      props:{
        info:{
          type:Object,
        },
      },
      data(){
          return{
/*            info:{
              applyId:"402881e967bb82810168788f50bd0159",//业务id
              partyId:"5AF8118FED19FABDE05010AC57DD79A2",//客户id

            },*/
            entity: {},
            disableRowButtons:true,//显示查询删除按钮
            disableQueryForm:true,//禁止查询表单
            disableQueryButtons:true,//不显示刷新重置按钮
            pageDef: {
              queryDef: {
                columnNum:0, //一行几列
                queryCols: [
                  {label: "保证人名称", inputType: "input", modelName: "partyName"},
                ]
              },
              tabDef: {
                isSelect: false, //是否可以多选
                isIndex: false,  //是否有序号
                isCheckRadio:true,//是否单选
                //表格字段定义
                tabCols: [
                  {label: "保证人名称", prop: "partyName"},
                  {label: "已担保金额", prop: "usedGuaranteeLimit"},
                  {label: "申请担保金额", prop: "suretyAmt",},
                ]
              },
              buttons: [
                {label: "增加", funcName: "add", disabled: false},
                {label: "编辑", funcName: "doEdit", disabled: false},
                {label: "查看", funcName: "scan", disabled: false},
                {label: "删除", funcName: "doDelete", disabled: false},
                {label: "刷新", funcName: "refresh", disabled: false},
              ]
            },
            dialogVisible:false,//对话框
            fullScreen:true,//是否全屏
            currentView:"addGuarantor",
            dialogTitle:'新增保证人',
          }
      },
      methods:{
        doPageQuery(listQuery){
          listQuery.applyId = this.info.applyId;
          getGuaranteerList(listQuery).then(response => {
            if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
              var myEntity = {};
              myEntity.total=response.data.data.total;
              myEntity.data = response.data.data.list;
              this.entity = myEntity;
              this.$store.dispatch('setListLoading', false);
            } else{
              this.$message({
                message: '获取数据失败啦！',
                type: 'error'
              });
            }
          })
        },
        doAdd(){
          this.dialogVisible = true;
          this.currentView = "addGuarantor";
        },
        doEdit(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要修改的数据!',
              type: 'error'
            });
            return;
          }
          this.dialogVisible = true;
          this.currentView = "editGuarantor";
          this.info.suretyId = row.suretyId;
          this.dialogTitle = "编辑保证人";
        },
        scan(row){//查看详情
          if(row.length<=0){
            this.$message({
              message: '请选择要查看的数据!',
              type: 'error'
            });
            return;
          }
          this.dialogVisible = true;
          this.currentView = "editGuarantor";
          this.info.suretyId = row.suretyId;
          this.info.isScan = true;
          this.dialogTitle = "查看保证人";
        },
        refresh(){
          var listquery = {};
          listquery.applyId = this.info.applyId;
          listquery.pageNum=1;
          listquery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listquery);
        },
        doDelete(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要删除的数据!',
              type: 'error'
            });
            return;
          }
          this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
          }).then(() => {
            deleteGuaranteeApplyTbGrtGuaranteerBySuretyId(row).then(response => {
              if(response.data.flag == enums.stateCode.flag.success){//
                this.$message({
                  message: '删除成功',
                  type: 'success'
                });
                this.refresh();
              } else{
                this.$message({
                  message: '删除失败!'+JSON.stringify(response.data),
                  type: 'error'
                });
              }
            });
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            })
          });
        },
        handleGoodsDetailInfoClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {});
        },
        getMsg: function (obj) {
          if (obj.flag === 'ok') {
            this.dialogVisible = false;
            this.refresh();
          }
          if(obj.flag==='close'){
            this.dialogVisible = false;
          }
        },
      },
    }
</script>

<style scoped>
.m-t-b-0{
  margin-top: 0;
  margin-bottom: 0;
}
</style>
