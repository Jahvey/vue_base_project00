<template>
  <div>
    <el-row>
      <p class="m-t-b-0">信用保险</p>
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
  import { getCreditsafeList,getGuaranteerBySuretyId,delTbGrtCreditsafeBySuretyId} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
  import addCreditInsurance from './AddCreditInsurance'
  import editCreditInsurance from './EditCreditInsurance'
  export default {
    name: "CreditInsurance",
    components:{
      addCreditInsurance,
      editCreditInsurance,
    },
    beforeMount(){
      //TODO 加载页面前，应该查询该业务的担保方式，以及是授信阶段还是业务阶段，然后控制是否显示和隐藏操作按钮，这里先不做

    },
    data(){
      return{
        info:{
          applyId:"402881e967bb82810168788f50bd0159",//业务id
          partyId:"5AF8118FED19FABDE05010AC57DD79A2",//客户id
          collType:"05",//抵质押类型：01抵押 02质押 03保证金 04保证人 05信用保险
          proFlag:"",//流程id,如果流程标识为0表示为查看，隐藏保存按钮禁用控件
          crdId:"",//授信id
          phase:"",//代表阶段，crd代表授信阶段，biz代表业务阶段
        },//向子组件传递的值
        entity: {},
        disableRowButtons:true,//显示查询删除按钮
        disableQueryForm:true,//禁止查询表单
        disableQueryButtons:true,//不显示刷新重置按钮
        pageDef: {
          queryDef: {
            columnNum:0, //一行几列
            queryCols: [
              {label: "投保人", inputType: "input", modelName: "policyHolder"},
            ]
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: false,  //是否有序号
            isCheckRadio:true,//是否单选
            //表格字段定义
            tabCols: [
              {label: "投保人", prop: "policyHolder"},
              {label: "币种", prop: "currencyCd",isFormat: true,enumType:'currencyCd'},
              {label: "信用金额", prop: "creditLimit",},
              {label: "生效日期", prop: "effectiveDate",},
              {label: "到期日期", prop: "endDate",},
              {label: "本次担保金额", prop: "guaranteeMoney",},
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
        currentView:"addCreditInsurance",
        dialogTitle:'新增信用保险',
      }
    },
    methods:{
      doPageQuery(listQuery){
        listQuery.applyId = this.info.applyId;
        getCreditsafeList(listQuery).then(response => {
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
        });
      },
      doAdd(){
        this.dialogVisible = true;
        this.currentView = "addCreditInsurance";
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
        this.currentView = "editCreditInsurance";
        this.info.suretyId = row.suretyId;
        this.info.isScan = false;
        this.dialogTitle = "编辑信用保险";
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
        this.currentView = "editCreditInsurance";
        this.info.suretyId = row.suretyId;
        this.info.isScan = true;
        this.dialogTitle = "查看信用保险";
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
          delTbGrtCreditsafeBySuretyId(row).then(response => {
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

<style scoped>
  .m-t-b-0{
    margin-top: 0;
    margin-bottom: 0;
  }
</style>
