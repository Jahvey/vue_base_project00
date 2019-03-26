<!--抵押合同-->
<template>
  <div>
    <el-row>
      <p class="m-t-b-0">抵押合同</p>
      <el-col :span="24">
        <csc-single-table
          :pageDef="pageDef"
          :entity="entity"
          :disableRowButtons="disableRowButtons"
          :disableQueryForm="disableQueryForm"
          :disableQueryButtons="disableQueryButtons"
          @add="add"
          @refresh="refresh"
          @edit="edit"
          @scan="scan"
          @ref="ref"
          @delete="deletes"
          @pageQuery="doPageQuery"
          >
        </csc-single-table>
      </el-col>
    </el-row>
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
  </div>
</template>

<script>
  import { getConDyList,saveGrtCon,delConGrtRel} from '@/api/contractsign'
  import addApplyRelMpPerson from '../Common/AddApplyRelMpPerson'
  import guaranteeContractInfo from '../Common/GuaranteeContractInfo'
  import maxLoanList from '../Common/MaxLoanList'
  import maxLoanConfirm from '../Common/MaxLoanConfirm'

  import enums from "@/utils/enums"
    export default {
      name: "mortgage-contract",
      components:{
        addApplyRelMpPerson,
        guaranteeContractInfo,
        maxLoanList,
        maxLoanConfirm,
      },
      beforeMount(){
        this.deliverData.page='mortgage';
      },
      props:{
        info:{
          type:Object,
        },
      },
      data(){
        return{
          dialogWidth:"60%",//弹出框的宽度
          entity: {},
          disableRowButtons:true,//显示查询删除按钮
          disableQueryForm:true,//禁止查询表单
          disableQueryButtons:true,//不显示刷新重置按钮
          deliverData:{},//传递的数据
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
                {label: "抵押合同编号", prop: "SUBCONTRACT_NUM",isFormat: true,enumType:'marginSortCd'},
                {label: "抵押人名称", prop: "PARTY_NAME"},
                {label: "是否最高额", prop: "IF_TOP_SUBCON",isFormat: true,enumType:'holidayFlg'},
                {label: "币种", prop: "BZ",isFormat: true,enumType:'currencyCd'},
                {label: "担保合同金额", prop: "SUBCONTRACT_AMT",},
                {label: "本次担保金额", prop: "SURETY_AMT",},
                {label: "操作类型标识", prop: "OPERATION_TYPE",isFormat: true,enumType:'operationTypeCd'},
              ]
            },
            buttons: [
              {label: "增加", funcName: "add", disabled: false},
              {label: "引入", funcName: "ref", disabled: false},
              {label: "查看", funcName: "scan", disabled: false},
              {label: "编辑", funcName: "edit", disabled: false},
              {label: "删除", funcName: "delete", disabled: false},
              {label: "刷新", funcName: "refresh", disabled: false},
            ]
          },
          dialogVisible:false,//对话框
          fullScreen:false,//是否全屏
          currentView:"addApplyRelMpPerson",
          dialogTitle:'选择',
        }
      },
      methods:{
        doPageQuery(listQuery){
          // TODO 这里没传业务id
          //listQuery.applyId = this.info.applyId;
          listQuery.contractId = this.info.contractId;
          listQuery.subcontractType = this.info.subcontractType;
          getConDyList(listQuery).then(response => {
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
        handleGoodsDetailInfoClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
              this.refresh();
            })
            .catch(_ => {});
        },
        refresh(){
          var listQuery = {};
          // TODO 这里没传业务id
          //listQuery.applyId = this.info.applyId;
          listQuery.contractId = this.info.contractId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listQuery);
        },
        scan(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要查看的数据!',
              type: 'error'
            });
            return;
          }
          this.info.partyId=row.PARTY_ID;
          this.currentView='guaranteeContractInfo';
          this.dialogTitle="担保合同信息";
          this.dialogWidth='100%';
          this.fullScreen = true;
          this.deliverData.isScan=true;
          this.deliverData.subcontractId = row.SUBCONTRACT_ID;//担保合同Id
          this.deliverData.conSubconId = row.CON_SUBCON_ID;//贷款合同与担保合同关系表id
          this.deliverData.subcontractType = this.info.subcontractType;
          this.deliverData.applyId = this.info.applyId;
          this.deliverData.partyId = this.info.partyId;
          this.deliverData.contractId = this.info.contractId;
          this.dialogVisible=true;
        },
        edit(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要修改的数据!',
              type: 'error'
            });
            return;
          }
          this.info.partyId=row.PARTY_ID;
          if(this.info.xgbz=='1'){
            if(row.IF_TOP_SUBCON!='1'){
              this.$message({
                message: '只能对最高额合同进行编辑！',
                type: 'error'
              });
              return;
            }
          } else{
            if(row.OPERATION_TYPE=='01'){
              this.$message({
                message: '引入合同不允许编辑！',
                type: 'error'
              });
              return;
            }
            this.currentView='guaranteeContractInfo';
            this.dialogTitle="担保合同信息";
            this.dialogWidth='100%';
            this.fullScreen = true;
            this.deliverData.isScan=false;
            this.deliverData.subcontractId = row.SUBCONTRACT_ID;//担保合同Id
            this.deliverData.conSubconId = row.CON_SUBCON_ID;//贷款合同与担保合同关系表id
            this.deliverData.subcontractType = this.info.subcontractType;
            this.deliverData.applyId = this.info.applyId;
            this.deliverData.partyId = this.info.partyId;
            this.deliverData.contractId = this.info.contractId;
            this.dialogVisible=true;
          }
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
            var obj = {};
            obj.subcontractId = row.SUBCONTRACT_ID;
            obj.relationId = row.RELATION_ID;
            obj.conSubconId = row.CON_SUBCON_ID;
            obj.operationType = row.OPERATION_TYPE;
            obj.contractId = this.info.contractId;
            delConGrtRel(obj).then(response=>{
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
        ref(){
          this.dialogTitle="引入最高额担保合同";
          this.currentView='maxLoanList';
          this.deliverData.applyId = this.info.applyId;
          this.deliverData.subcontractType = this.info.subcontractType;
          this.deliverData.contractId = this.info.contractId;
          this.deliverData.conPartyId = this.info.conPartyId;
          this.deliverData.contractType = this.info.contractType;
          this.dialogWidth='60%';
          this.dialogVisible=true;
        },
        add(){//添加担保合同
          //需要传递applyId，subcontractType
          this.dialogTitle="选择";
          this.currentView='addApplyRelMpPerson';
          this.deliverData.applyId = this.info.applyId;
          this.deliverData.subcontractType = this.info.subcontractType;
          this.deliverData.contractId = this.info.contractId;
          this.dialogWidth='60%';
          this.dialogVisible=true;
        },
        getMsg: function (obj) {
          this.dialogVisible=false;
          if (obj.flag === 'ok') {
            this.refresh();
          }
          if(obj.flag==='close'){
            //this.dialogVisible = false;
          }
          if(obj.flag==='showDialog'){
            this.info.partyId=obj.partyId;
            this.info.subcontractType=obj.subcontractType;
            this.refresh();
            saveGrtCon(this.info).then(response=>{
              if(response.data.code == enums.stateCode.code.success) {//返回数据成功
                this.currentView='guaranteeContractInfo';
                this.dialogTitle="担保合同信息";
                this.dialogWidth='100%';
                this.fullScreen = true;
                this.deliverData.isScan=false;
                this.deliverData.subcontractId = response.data.subcontractId;//担保合同Id
                this.deliverData.conSubconId = response.data.conSubconId;//贷款合同与担保合同关系表id
                this.deliverData.subcontractType = this.info.subcontractType;
                this.deliverData.applyId = this.info.applyId;
                this.deliverData.partyId = this.info.partyId;
                this.deliverData.contractId = this.info.contractId;
                this.dialogVisible=true;
              }else{
                this.$message({
                  message: JSON.stringify(response.data),
                  type: 'error'
                });
              }
            });
          }
          if(obj.flag=='showDialog2'){
            this.deliverData.contractId = this.info.contractId;
            this.deliverData.subcontractId = obj.subcontractId;//担保合同Id
            this.deliverData.subcontractNum = obj.subcontractNum;//合同编号
            //this.deliverData.conSubconId = obj.conSubconId;//贷款合同与担保合同关系表id
            this.dialogTitle="最高额担保确认金额";
            this.currentView='maxLoanConfirm';
            this.dialogWidth='40%';
            this.dialogVisible=true;
          }
        },
      },
    }
</script>

<style>
  .dialog-style .el-dialog__body{
    padding: 0px 20px;
  }
  .dialog-style .el-dialog__header{
    background: #e7ebef;
  }
</style>
