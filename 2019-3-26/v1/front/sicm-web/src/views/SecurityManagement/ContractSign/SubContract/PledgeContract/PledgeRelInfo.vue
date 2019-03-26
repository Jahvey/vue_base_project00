<!--押品关联信息-->
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
  import applyMP from '../Common/ApplyMP'
  import applyConfirmMP from '../Common/ApplyConfirmMP'
  import {getConSub,delSubGrtRel,checkIfCommitSubBasicInfo} from '@/api/contractsign'
  import enums from "@/utils/enums"
    export default {
      name: "mortgage-rel-info",
      props:{
        info:{
          type:Object,
        },
      },
      components:{
        applyMP,
        applyConfirmMP,
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
                {label: "质押人名称", prop: "PARTY_NAME"},
                {label: "质押物编号", prop: "COLLATERAL_NUM"},
                {label: "质押物类型", prop: "COLLATERAL_TYPE_CD",isFormat: true,enumType:'CollateralStatusCd'},
                {label: "币种", prop: "CURRENCY_CD",isFormat: true,enumType:'currencyCd'},
/*                {label: "评估价值(元)", prop: "EVAL_VALUE",},*/
                {label: "抵质押物认定价值(元)", prop: "MARKET_VALUE",},
                {label: "已担保金额(元)", prop: "SET_GUARANTY_AMT"},
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
          currentView:"applyMP",
          dialogTitle:'',
        }
      },
      methods:{
        doPageQuery(listQuery){
          listQuery.contractId = this.info.contractId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.subcontractId = this.info.subcontractId;
          getConSub(listQuery).then(response => {
            if(response.data.code == enums.stateCode.code.success){//返回数据成功
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
        scan(){},
        ref(){
          var obj={};
          console.log("entity:"+JSON.stringify(this.entity));
          obj.subcontractId=this.info.subcontractId;
          checkIfCommitSubBasicInfo(obj).then(response => {
            if(response.data.code == enums.stateCode.code.success){
              this.currentView="applyMP";
              this.dialogTitle="关联质押品";
              this.deliverData.applyId = this.info.applyId;
              this.deliverData.subcontractType = this.info.subcontractType;
              this.deliverData.subcontractId = this.info.subcontractId;
              this.deliverData.partyId = this.info.partyId;
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
            obj.suretyId = row.SURETY_ID;
            obj.relationId = row.RELATION_ID;
            obj.grtAmt = row.GRT_AMT;
            obj.applyId =this.info.applyId;
            delSubGrtRel(obj).then(response=>{
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
          if(obj.flag==='showDialog'){
            this.dialogVisible=false;
            this.deliverData.suretyId=obj.suretyId;
            this.deliverData.marketValue=obj.marketValue.toString();
            this.deliverData.ableValue=obj.ableValue.toString();
            this.deliverData.grtStatus=obj.grtStatus;
            this.deliverData.partyId=obj.partyId;
            this.deliverData.applyMortgageValue=obj.applyMortgageValue;
            this.deliverData.subcontractId=this.info.subcontractId;
            this.deliverData.contractId=this.info.contractId;
            console.log("info:"+JSON.stringify(this.info));
            console.log("deliverData:"+JSON.stringify(this.deliverData));
            this.currentView="applyConfirmMP";
            this.dialogWidth="50%";
            this.dialogTitle="确认担保金额";
            this.dialogVisible=true;
          }
        }
      },
    }
</script>

<style scoped>

</style>
