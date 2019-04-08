<!--查询业务申请中的抵押品信息公共页面，
签担保合同时，查询该客户下，该业务申请下  该笔业务下的担保物信息(担保合同可以关联的押品)-->
<template>
  <el-container>
    <el-main>
      <el-row>
        <csc-single-table
          :pageDef="pageDef"
          :entity="entity"
          :disableRowButtons="disableRowButtons"
          :disableQueryForm="disableQueryForm"
          :disableQueryButtons="disableQueryButtons"
          @refresh="refresh"
          @scan="scan"
          @choose="choose"
          @pageQuery="doPageQuery"
        >
        </csc-single-table>
      </el-row>
    </el-main>
  </el-container>
<!--      <el-dialog
        class="dialog-style"
        :title="dialogTitle"
        :visible.sync="dialogVisible"
        :width="dialogWidth"
        :fullscreen="fullScreen"
        v-if='dialogVisible'
        :before-close="handleGoodsDetailInfoClose"
        append-to-body>
        &lt;!&ndash;动态组件&ndash;&gt;
        <compoment v-bind:is="currentView" v-bind:info="info" v-on:backFlag="getMsg"></compoment>
      </el-dialog>-->
</template>

<script>
  import { selSubGrt} from '@/api/contractsign'
  import enums from "@/utils/enums"
    export default {
      name: "apply-m-p",
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
          deliverData:{},//向子页面传递的数据
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
                {label: "抵押人名称", prop: "PARTY_NAME"},
                {label: "抵押物编号", prop: "COLLATERAL_NUM"},
                {label: "抵押物类型", prop: "COLLATERAL_TYPE_CD",isFormat: true,enumType:'CollateralStatusCd'},
                {label: "币种", prop: "CURRENCY_CD",isFormat: true,enumType:'currencyCd'},
                {label: "市场价值(元)", prop: "MARKET_VALUE",},
                {label: "已担保金额(元)", prop: "SET_GUARANTY_AMT"},
              ]
            },
            buttons: [
              {label: "确认", funcName: "choose", disabled: false},
              {label: "查看", funcName: "scan", disabled: false},
              {label: "刷新", funcName: "refresh", disabled: false},
            ]
          },
          dialogVisible:false,//对话框
          fullScreen:false,//是否全屏
          currentView:"addMortgageContract",
          dialogTitle:'',
        }
      },
      methods:{
        doPageQuery(listQuery){
          listQuery.applyId = this.info.applyId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.subcontractId = this.info.subcontractId;
          listQuery.partyId = this.info.partyId;
          selSubGrt(listQuery).then(response => {
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
          listQuery.applyId = this.info.applyId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.subcontractId = this.info.subcontractId;
          listQuery.partyId = this.info.partyId;
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listQuery);
        },
        choose(row){
          if(row.length<=0){
            this.$message({
              message: '请选择一项数据!',
              type: 'error'
            });
            return;
          }
          var obj={};
          obj.suretyId=row.GUARANTY_ID;
          obj.marketValue = row.MARKET_VALUE;
          obj.applyMortgageValue = row.APPLY_MORTGAGE_VALUE;
          obj.ableValue= row.ABLE_VALUE;
          obj.grtStatus= row.COLLATERAL_STATUS_CD;
          obj.partyId= row.PARTY_ID;

          //bj.subcontractId=this.info.subcontractId;
          //obj.applyId=this.info.applyId;
          obj.flag='showDialog';
          this.$emit('backFlag',obj);

        },
        scan(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要查看的数据!',
              type: 'error'
            });
            return;
          }
        },

      },
    }
</script>

<style scoped>

</style>
