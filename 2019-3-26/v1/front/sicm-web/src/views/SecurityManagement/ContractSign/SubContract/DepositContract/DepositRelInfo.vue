<template>
  <div class="deposit-rel-info">
    <el-row>
      <csc-single-table
        :pageDef="pageDef"
        :entity="entity"
        :disableRowButtons="disableRowButtons"
        :disableQueryForm="disableQueryForm"
        :disableQueryButtons="disableQueryButtons"
        @refresh="refresh"
        @scan="scan"
        @ref="ref"
        @deletes="deletes"
        @edit="edit"
        @add="add"
        @pageQuery="doPageQuery"
      >
      </csc-single-table>
    </el-row>
    <el-row>
      <el-dialog
        class="dialog-style"
        :title="dialogTitle"
        :visible.sync="dialogVisible"
        :width="dialogWidth"
        :fullscreen="fullScreen"
        v-if='dialogVisible'
        :before-close="handleGoodsDetailInfoClose"
        append-to-body>
        <!--动态组件-->
        <compoment v-bind:is="currentView" v-bind:info="deliverData" v-on:backFlag="getMsg"></compoment>
      </el-dialog>
    </el-row>
  </div>
</template>
<script>
  import {getConSubBzj,delSubGrtRel3,checkIfCommitSubBasicInfo} from '@/api/contractsign'
  import addApplyRelDeposit from './AddApplyRelDeposit'
  import addDepositWhenContract from './AddDepositWhenContract'
  import editDeposit from '@/views/SecurityManagement/OperationApplay/GuaranteeEvaluation/Deposit/EditDeposit'
  import enums from "@/utils/enums"
    export default {
      name: "deposit-rel-info",
      props:{
        info:{
          type:Object,
        },
      },
      components:{
        addApplyRelDeposit,
        editDeposit,
        addDepositWhenContract
      },
      data(){
        return{
          dialogWidth:"80%",//弹出框的宽度
          entity: {},
          disableRowButtons:true,//显示查询删除按钮
          disableQueryForm:true,//禁止查询表单
          disableQueryButtons:true,//不显示刷新重置按钮
          deliverData:{},//向子页面传递的数据
          pageDef: {
            queryDef: {
              columnNum:0, //一行几列
              queryCols: [
                {label: "开户人", inputType: "input", modelName: "ACCT_NAME"},
              ]
            },
            tabDef: {
              isSelect: false, //是否可以多选
              isIndex: false,  //是否有序号
              isCheckRadio:true,//是否单选
              //表格字段定义
              tabCols: [
                {label: "保证金类型", prop: "MARGIN_SORT",isFormat: true,enumType:'marginSortCd'},
                {label: "开户行", prop: "OPEN_BANK"},
                {label: "开户人", prop: "ACCT_NAME"},
                {label: "保证金账号", prop: "MARGIN_ACCOUNT",},
                {label: "币种", prop: "CURRENCY_CD",isFormat: true,enumType:'currencyCd'},
                {label: "保证金金额", prop: "ACC_BALANCE"},
                {label: "追加标志", prop: "APPEND_FLAG"},
                {label: "追加金额", prop: "APPEND_AMT"},
                {label: "起始日期", prop: "BEGIN_DATE"},
                {label: "执行利率(%)", prop: "MARGIN_RATE"},
              ]
            },
            buttons: [
              {label: "添加", funcName: "add", disabled: false},
              {label: "关联", funcName: "ref", disabled: false},
              {label: "查看", funcName: "scan", disabled: false},
              {label: "编辑", funcName: "edit", disabled: false},
              {label: "删除", funcName: "deletes", disabled: false},
              {label: "刷新", funcName: "refresh", disabled: false},
            ]
          },
          dialogVisible:false,//对话框
          fullScreen:false,//是否全屏
          currentView:"addApplyRelGuarantor",
          dialogTitle:'',
        }
      },
      methods:{
        doPageQuery(listQuery){
          //listQuery.contractId = this.info.contractId;
          //listQuery.subcontractType = this.info.subcontractType;
          listQuery.subcontractId = this.info.subcontractId;
          getConSubBzj(listQuery).then(response => {
            if(response.data.code == enums.stateCode.code.success){//返回数据成功
              var myEntity = {};
              myEntity.total=response.data.data.total;
              myEntity.data = response.data.data.list;
              console.log("我是data:"+response.data);
              this.entity = myEntity;
              this.$store.dispatch('setListLoading', false);
            } else{
              this.$message({
                message: '获取数据失败啦！',
                type: 'error'
              });
            }
          });
        },
        refresh(){
          var listQuery = {};
          //listQuery.contractId = this.info.contractId;
          listQuery.subcontractId = this.info.subcontractId;
          //listQuery.subcontractType = this.info.subcontractType;
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listQuery);
        },
        ref(){
          //1.保证合同只能关联一个保证人
          if(this.entity.total==undefined){
            this.$message({
              message: "请刷新关联保证人页面再做此操作",
              type: 'error'
            });
            return;
          }
          if(this.entity.total>0){
            this.$message({
              message: "一个保证合同只能关联一个保证人",
              type: 'error'
            });
            return;
          }
          var obj={};
          obj.subcontractId=this.info.subcontractId;
          this.currentView="addApplyRelDeposit";
          this.dialogTitle="保证金列表";
          this.deliverData.applyId = this.info.applyId;
          this.deliverData.subcontractType = this.info.subcontractType;
          this.deliverData.subcontractId = this.info.subcontractId;
          this.deliverData.contractId = this.info.contractId;
          this.dialogWidth="80%";
          this.dialogVisible=true;
        },
        scan(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要操作的数据!',
              type: 'error'
            });
            return;
          }
          var obj={};
          this.deliverData.suretyKeyId=row.SURETY_KEY_ID;
          this.deliverData.isScan = true;
          this.currentView = "editDeposit";
          this.dialogTitle = "查看保证金";
          this.dialogWidth="60%"
          this.dialogVisible = true;
        },
        deletes(row){
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
            console.log("数据:"+JSON.stringify(row));
            var obj = {};
            obj.relationId = row.RELATION_ID;
            delSubGrtRel3(obj).then(response=>{
              if(response.data.code == enums.stateCode.code.success) {//返回数据成功
                this.$message({
                  message: '删除成功',
                  type: 'success'
                });
                this.refresh();
              }else{
                this.$message({
                  message: JSON.stringify(response.data),
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
        add(){
          //1.保证合同只能关联一个保证人
          if(this.entity.total==undefined){
            this.$message({
              message: "请刷新关联保证人页面再做此操作",
              type: 'error'
            });
            return;
          }
          if(this.entity.total>0){
            this.$message({
              message: "一个保证合同只能关联一个保证人",
              type: 'error'
            });
            return;
          }
          this.deliverData.subcontractId = this.info.subcontractId;
          this.deliverData.contractId=this.info.contractId;
          this.deliverData.applyId=this.info.applyId;
          this.deliverData.partyId=this.info.conPartyId;
          this.currentView = "addDepositWhenContract";
          this.dialogTitle = "新增保证金";
          this.dialogWidth="60%"
          this.dialogVisible = true;
        },
        edit(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要操作的数据!',
              type: 'error'
            });
            return;
          }
          this.deliverData.suretyKeyId=row.SURETY_KEY_ID;
          this.deliverData.isScan = false;
          this.deliverData.partyId = this.info.partyId;
          this.deliverData.applyId = this.info.applyId;
          this.currentView = "editDeposit";
          this.dialogTitle = "编辑保证金";
          this.dialogWidth="60%"
          this.dialogVisible = true;
        },
        getMsg: function (obj) {
          if (obj.flag === 'ok') {
            this.dialogVisible = false;
            this.refresh();
          }
          if (obj.flag === 'close') {
            this.dialogVisible = false;
          }
          if(obj.flag === 'showDialog'){
            this.dialogVisible = false;
            this.deliverData.suretyId = obj.suretyId;
            this.deliverData.subcontractId = this.info.subcontractId;
            this.deliverData.contractId=this.info.contractId;
            this.currentView="addConfirmGuarantor";
          }
        },
        handleGoodsDetailInfoClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
              //this.refresh();
            })
            .catch(_ => {});
        },
      },
    }
</script>

<style scoped>

</style>
