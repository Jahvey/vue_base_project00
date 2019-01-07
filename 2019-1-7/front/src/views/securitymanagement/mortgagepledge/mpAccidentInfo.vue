<template>
  <div class="mp-accident-info">
    <el-row>
      <p>意外信息</p>
    </el-row>
    <el-row>
      <csc-single-table
        :pageDef="pageDef"
        :entity="entity"
        :disableRowButtons="disableRowButtons"
        :disableQueryForm="disableQueryForm"
        :disableQueryButtons="disableQueryButtons"
        @add="doAdd"
        @deleteBatch="deleteBatch"
        @refresh="refresh"
        @doEdit="doEdit"
        @pageQuery="doPageQuery"
        @doDelete="doDelete"
      >
      </csc-single-table>
    </el-row>

    <template>
      <el-dialog
        title="添加意外信息"
        :visible.sync="dialogVisible"
        width="80%"
        :before-close="handleClose"
        append-to-body>
        <addAccidentInfo v-on:backFlag="getMsg" v-bind:grtCollateralInfo="grtCollateralInfo"/>
      </el-dialog>
    </template>
    <template>
      <el-dialog
        title="修改意外信息"
        :visible.sync="dialogVisible2"
        width="80%"
        :before-close="handleClose"
        append-to-body>
        <addAccidentInfo v-on:backFlag="getMsg2" v-bind:grtCollateralAccident="grtCollateralAccident"/>
      </el-dialog>
    </template>
  </div>
</template>

<script>
  import addAccidentInfo from './addAccidentInfo'
  import editAccidentInfo from './editAccidentInfo'
  import { getAllGrtCollateralAccident,deleteGrtCollateralAccidentById,deleteGrtCollateralAccidentBatch} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
  export default {
    name: "mp-accident-info",
    components:{
      addAccidentInfo,
      editAccidentInfo,
    },
    props:{
      grtCollateralInfo:Object,
    },
    data(){
      return{
        entity: {},
        disableRowButtons:false,//显示查询删除按钮
        disableQueryForm:true,//禁止查询表单
        disableQueryButtons:true,//不显示刷新重置按钮
        pageDef: {
          queryDef: {
            columnNum:2, //一行几列
            queryCols: [
              {label: "意外情况类型", inputType: "input", modelName: "accidentTypeCd"},
              {label: "币种类型", inputType: "input", modelName: "currencyCd"},
            ]
          },
          tabDef: {
            isSelect: true, //是否可以多选
            isIndex: false,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "意外情况类型", prop: "accidentTypeCd",isFormat:true,enumType:"CollateralState"},
              {label: "发生日期", prop: "occurDate" },
              {label: "原因", prop: "reason"},
              {label: "损失价值(元)", prop: "priceLosses",},
              {label: "补偿价值(元)", prop: "pricesCompensation"},
              //{label: "币种类型", prop: "registerExpirationDate"},
            ]
          },
          buttons: [
            {label: "新增", funcName: "add", disabled: false},
            {label: "批量删除", funcName: "deleteBatch", disabled: false},
            {label: "刷新", funcName: "refresh", disabled: false},
          ]
        },
        multipleSelection: [],
        dialogVisible: false,//添加登记信息dialog
        dialogVisible2: false,//更新登记信息dialog
        grtCollateralAccident:{},
      }
    },
    methods: {

      handleClose: function (done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {
          });
      },
      doPageQuery(listQuery){
        listQuery.guarantyId = this.grtCollateralInfo.guarantyId;
        getAllGrtCollateralAccident(listQuery).then(response => {
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
      },
      doEdit(row){
        this.dialogVisible2 = true;
        this.grtCollateralAccident = row;
      },
      refresh(row,listquery,index){
        this.$store.dispatch('setListLoading', true);
        this.doPageQuery(listquery);
      },
      deleteBatch(row,listquery,index){
        if(row.length<=0){
          this.$message({
            message: '请选择要删除的数据!',
            type: 'error'
          });
          return;
        }
        this.$confirm('此操作将永久删除该单据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          deleteGrtCollateralAccidentBatch(row).then(response => {
            if(response.data.flag == enums.stateCode.flag.success){//
              this.$message({
                message: '删除机构信息成功',
                type: 'success'
              });
              this.$store.dispatch('setListLoading', true);
              this.doPageQuery(listquery);
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
      doDelete(row,listquery,index){
        deleteGrtCollateralAccidentById(row).then(response => {
          if(response.data.flag == enums.stateCode.flag.success){//
            this.$message({
              message: '删除机构信息成功',
              type: 'success'
            });
            this.$store.dispatch('setListLoading', true);
            this.doPageQuery(listquery);
          } else{
            this.$message({
              message: '删除失败!'+JSON.stringify(response.data),
              type: 'error'
            });
          }
        });
      },
      getMsg: function (flag) {
        if (flag === 'ok') {
          this.dialogVisible = false;
          var listquery = {};
          listquery.pageNum=1;
          listquery.pageSize=20;
          listquery.guarantyId = this.grtCollateralInfo.guarantyId;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listquery);
        }
      },
      getMsg2: function (flag) {
        if (flag === 'ok') {
          this.dialogVisible2 = false;
          var listquery = {};
          listquery.pageNum=1;
          listquery.pageSize=20;
          listquery.guarantyId = this.grtCollateralInfo.guarantyId;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listquery);
        }
      },
    },
  }
</script>

<style scoped>
  .mp-accident-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-accident-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
  .el-pagination{
    margin:10px 0;
    text-align: center;
  }
  .accident-t .el-button + .el-button{
    margin-left:0px;
  }
  .accident-t .el-button--mini{
    padding: 6px;
  }
</style>
