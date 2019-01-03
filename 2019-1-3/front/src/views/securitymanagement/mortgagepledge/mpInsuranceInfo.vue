<template>
    <div class="mp-insurance-info">
      <el-row>
          <p>保险信息</p>
      </el-row>
      <el-row >
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
          title="添加保险信息"
          :visible.sync="dialogVisible"
          width="80%"
          :before-close="handleClose"
          append-to-body>
          <addInsuranceInfo v-on:backFlag="getMsg" v-bind:grtCollateralInfo="grtCollateralInfo"/>
        </el-dialog>
      </template>
      <template>
        <el-dialog
          title="更新保险信息"
          :visible.sync="dialogVisible2"
          width="80%"
          :before-close="handleClose"
          append-to-body>
          <editInsuranceInfo v-on:backFlag="getMsg2" v-bind:grtCollateralInsurance="grtCollateralInsurance"/>
        </el-dialog>
      </template>
    </div>
</template>

<script>
  import addInsuranceInfo from './addInsuranceInfo'
  import editInsuranceInfo from './editInsuranceInfo'
  import enums from "@/utils/enums"
  import { getAllCollateralInsurance,deleteCollateralInsuranceById,deleteCollateralInsuranceBatch} from '@/api/securitymanagement'
    export default {
      name: "mp-insurance-info",
      components:{
        addInsuranceInfo,
        editInsuranceInfo
      },
      props:{
        grtCollateralInfo:Object,
      },
      data() {
        return {
          entity: {},
          disableRowButtons:false,//显示查询删除按钮
          disableQueryForm:true,//禁止查询表单
          disableQueryButtons:true,//不显示刷新重置按钮
          selectedRow:{},
          pageDef: {
            queryDef: {
              columnNum: 3, //一行几列
              queryCols: [
                {label: "保险机构", inputType: "input", modelName: "insuranceCompanyName"},
                {label: "保险单编号", inputType: "input", modelName: "insurancePolicyNum"},
                {label: "担保险种", inputType: "input", modelName: "insuranceType"},
              ]
            },
            tabDef: {
              isSelect: true, //是否可以多选
              isIndex: false,  //是否有序号
              //表格字段定义
              tabCols: [
                {label: "保险机构", prop: "insuranceCompanyName"},
                {label: "保险单编号", prop: "insurancePolicyNum"},
                {label: "担保险种", prop: "insuranceType"},
                {label: "投保人", prop: "policyHolder"},
                {label: "第一受益人", prop: "insuranceBenefitiary"},
                {label: "币种", prop: "currencyCd",isFormat: true,enumType:"currencyCd"},
                {label: "投保金额(元)", prop: "insuranceAmt"},
                {label: "起始日期", prop: "startDate",isDate:true},
                {label: "到期日期", prop: "endDate",isDate:true},
                {label: "生效日期", prop: "effectiveDate",isDate:true},
              ]
            },
            buttons: [
              {label: "新增", funcName: "add", disabled: false},
              {label: "批量删除", funcName: "deleteBatch", disabled: false},
              {label: "刷新", funcName: "refresh", disabled: false},
            ]
          },
          multipleSelection: [],
          dialogVisible: false,//添加保险dialog
          dialogVisible2: false,//更新保险dialog
          grtCollateralInsurance:{},
        }
      },
      watch:{
      },
      methods: {
        doPageQuery(listQuery){
          listQuery.guarantyId = this.grtCollateralInfo.guarantyId;
          getAllCollateralInsurance(listQuery).then(response => {
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
          this.grtCollateralInsurance = row;
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
            deleteCollateralInsuranceBatch(row).then(response => {
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
          deleteCollateralInsuranceById(row).then(response => {
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
        handleClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {});
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
      }
    }
</script>

<style scoped>
  .mp-insurance-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-insurance-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
  .el-pagination{
    margin:10px 0;
    text-align: center;
  }
  .insurance-t .el-button + .el-button{
    margin-left:0px;
  }
  .insurance-t .el-button--mini{
    padding: 6px;
  }
</style>
