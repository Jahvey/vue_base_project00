<!--关联保证合同的保证人页面-->
<template>
  <div class="mortgage-rel-info">
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
  import {getConSubBzr,delSubGrtRel2,checkIfCommitSubBasicInfo} from '@/api/contractsign'
  import addApplyRelGuarantor from './AddApplyRelGuarantor'
  import addConfirmGuarantor from './AddConfirmGuarantor'
  import editGuarantor from '@/views/SecurityManagement/OperationApplay/GuaranteeEvaluation/Guarantor/EditGuarantor'
  import enums from "@/utils/enums"
    export default {
        name: "guarantor-rel-info",
        props:{
          info:{
            type:Object,
          },
        },
      components:{
        addApplyRelGuarantor,
        addConfirmGuarantor,
        editGuarantor,
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
                {label: "账户名称", inputType: "input", modelName: "PARTY_NAME"},
              ]
            },
            tabDef: {
              isSelect: false, //是否可以多选
              isIndex: false,  //是否有序号
              isCheckRadio:true,//是否单选
              //表格字段定义
              tabCols: [
                {label: "保证人名称", prop: "PARTY_NAME"},
                {label: "证件类型", prop: "CERT_TYPE",isFormat: true,enumType:'idTypeCd'},
                {label: "证件号码", prop: "CERT_NUM"},
                /*{label: "币种", prop: "CURRENCY_CD",isFormat: true,enumType:'currencyCd'},*/
                /*                {label: "评估价值(元)", prop: "EVAL_VALUE",},*/
                {label: "申请担保金额(元)", prop: "TOTAL_AMT",},
                {label: "已担保金额(元)", prop: "USED_AMT"},
                {label: "担保确认金额(元)", prop: "SURETY_AMT"},
              ]
            },
            buttons: [
              {label: "关联", funcName: "ref", disabled: false},
              {label: "查看", funcName: "scan", disabled: false},
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
          listQuery.contractId = this.info.contractId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.subcontractId = this.info.subcontractId;
          getConSubBzr(listQuery).then(response => {
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
          listQuery.contractId = this.info.contractId;
          listQuery.subcontractId = this.info.subcontractId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listQuery);
        },
        ref(){
          var obj={};
          obj.subcontractId=this.info.subcontractId;
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
          //2.必须先填写保证基本信息才能关联
          checkIfCommitSubBasicInfo(obj).then(response => {
            if(response.data.code == enums.stateCode.code.success){
              this.currentView="addApplyRelGuarantor";
              this.dialogTitle="保证人列表";
              this.deliverData.applyId = this.info.applyId;
              this.deliverData.subcontractType = this.info.subcontractType;
              this.deliverData.subcontractId = this.info.subcontractId;
              //this.deliverData.partyId = this.info.partyId;
              this.deliverData.contractId=this.info.contractId;
              this.dialogWidth="80%";
              this.dialogVisible=true;
            }else{
              this.$message({
                message: JSON.stringify(response.data),
                type: 'error'
              });
            }
          });
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
          this.deliverData.suretyId=row.SURETY_ID;
          this.deliverData.applyId=this.info.applyId;
          this.deliverData.isScan = true;
          this.currentView = "editGuarantor";
          this.dialogTitle = "查看保证人";
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
            obj.suretyId = row.SURETY_ID;
            obj.relationId = row.RELATION_ID;
            delSubGrtRel2(obj).then(response=>{
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
            this.dialogWidth="40%";
            this.dialogVisible = true;
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
