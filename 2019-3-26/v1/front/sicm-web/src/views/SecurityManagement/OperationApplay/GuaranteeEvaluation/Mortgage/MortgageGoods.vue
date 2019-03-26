<!--抵押物-->
<template>
    <div class="mortgage-goods">
      <el-row>
        <p class="m-t-b-0">抵押</p>
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
        :width="dialogWidth"
        :fullscreen="fullScreen"
        v-if='dialogVisible'
        :before-close="handleGoodsDetailInfoClose"
        class="mortgage-goods-dialog"
        append-to-body>
        <!--动态组件-->
        <compoment v-bind:is="currentView" v-bind:info="info" v-on:backFlag="getMsg"></compoment>
      </el-dialog>
    </div>
</template>

<script>
  import { getMortgageList,deleteMortgageByRelationId} from '@/api/securitymanagement'
  import addMortgageGoods from './AddMortgageGoods'
  import editMortgageGoods from './EditMortgageGoods'
  import enums from "@/utils/enums"
    export default {
      name: "mortgage-goods",
      props:{
        info:{
          type:Object,
        },
      },
      components:{
        addMortgageGoods,
        editMortgageGoods,
      },
      data(){
          return{
            entity: {},
            disableRowButtons:true,//显示查询删除按钮
            disableQueryForm:true,//禁止查询表单
            disableQueryButtons:true,//不显示刷新重置按钮
            pageDef: {
              queryDef: {
                columnNum:0, //一行几列
                queryCols: [
                  {label: "账户名称", inputType: "input", modelName: "partyName"},
                ]
              },
              tabDef: {
                isSelect: false, //是否可以多选
                isIndex: false,  //是否有序号
                isCheckRadio:true,//是否单选
                //表格字段定义
                tabCols: [
                  {label: "抵质押人名称", prop: "partyName",},
                  {label: "抵质押物名称", prop: "collateralName"},
                  {label: "抵质押物类型", prop: "collateralTypeCd",isFormat: true,enumType:'CollateralStatusCd'},
                  {label: "币种", prop: "currencyCd",isFormat: true,enumType:'currencyCd'},
                  {label: "抵质押物认定价值(元)", prop: "marketValue",},
                  {label: "已设定担保额(元)", prop: "setGuarantyAmt",},
                  {label: "抵质押品占用价值(元)", prop: "mortgageValue",},
                  {label: "本次实际担保债权金额(元)", prop: "suretyAmt",},
                  {label: "抵质押率%", prop: "mortgageRate",},
                  {label: "抵质押类型", prop: "mpType",isFormat: true,enumType:'collTypeCd'},
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
            currentView:"",
            dialogTitle:'新增抵押品',
            dialogWidth:"100%",//弹出框宽度
          }
      },
      methods:{
        doPageQuery(listQuery){
          listQuery.applyId = this.info.applyId;
          listQuery.suretyType = '01';
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          getMortgageList(listQuery).then(response => {
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
          this.dialogWidth="100%";
          this.dialogVisible = true;
          this.currentView = "addMortgageGoods";
        },
        doEdit(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要修改的数据!',
              type: 'error'
            });
            return;
          }
          this.dialogWidth="50%";
          this.currentView = "editMortgageGoods";
          this.info.relationId = row.relationId;
          this.dialogTitle = "编辑抵押品";
          this.info.isScan = false;
          this.dialogVisible = true;
        },
        scan(row){//查看详情
          if(row.length<=0){
            this.$message({
              message: '请选择要查看的数据!',
              type: 'error'
            });
            return;
          }
          this.dialogWidth="50%";
          this.currentView = "editMortgageGoods";
          this.info.relationId = row.relationId;
          this.info.isScan = true;
          this.dialogTitle = "查看抵押品";
          this.dialogVisible = true;
        },
        refresh(){
          var listQuery={};
          listQuery.applyId = this.info.applyId;
          listQuery.suretyType = '01';
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listQuery);
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
            deleteMortgageByRelationId(row).then(response => {
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
        getMsg: function (flag) {
          if (flag === 'ok') {
            this.dialogVisible = false;
            this.refresh();
          }
          if(flag==='close'){
            this.dialogVisible = false;
          }
        },
      },
    }
</script>

<style>
  .mortgage-goods .m-t-b-0{
    margin-top: 0;
    margin-bottom: 0;
    border-bottom: 1px solid #cccccc;
  }
  .mortgage-goods-dialog .el-dialog__body{
    padding-top: 0px!important;
    padding-bottom: 0px!important;
  }
</style>
