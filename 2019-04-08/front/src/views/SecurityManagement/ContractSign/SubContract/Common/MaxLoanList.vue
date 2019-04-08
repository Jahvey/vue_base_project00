<!--引入最高额担保合同List页面-->
<template>
  <div>
    <el-row>
      <csc-single-table
        :pageDef="pageDef"
        :entity="entity"
        :disableRowButtons="disableRowButtons"
        :disableQueryForm="disableQueryForm"
        :disableQueryButtons="disableQueryButtons"
        @choose="choose"
        @refresh="refresh"
        @pageQuery="doPageQuery"
      >
      </csc-single-table>
    </el-row>
    <el-row>
      <el-col :span="10" :offset="12">
        <el-button size="medium"  type="primary" @click="close">关闭</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import enums from "@/utils/enums"
  import { getMaxLoanCon,checkHaveRef} from '@/api/contractsign'
    export default {
        name: "MaxLoanList",
      props:{
        info:{
          type:Object,
        },
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
                {label: "担保人名称", prop: "PARTY_NAME"},
                {label: "担保合同编号", prop: "SUBCONTRACT_NUM"},
                {label: "担保合同纸质编号", prop: "PAPER_CON_NUM"},
                {label: "币种", prop: "BZ",isFormat: true,enumType:'currencyCd'},
                {label: "担保合同金额", prop: "ZGBJXE"},
                {label: "可用担保金额", prop: "AVI_AMT"},
                {label: "担保合同止期", prop: "END_DATE"},
              ]
            },
            buttons: [
              {label: "选择", funcName: "choose", disabled: false},
              {label: "刷新", funcName: "refresh", disabled: false},
            ]
          },
          dialogVisible:false,//对话框
          fullScreen:false,//是否全屏
          dialogTitle:'选择',
        }
      },
      methods:{
        doPageQuery(listQuery){
          listQuery.contractId = this.info.contractId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.conPartyId = this.info.conPartyId;
          listQuery.applyId = this.info.applyId;
          listQuery.contractType = this.info.contractType;
          getMaxLoanCon(listQuery).then(response => {
            if(response.data.code == enums.stateCode.code.success){//返回数据成功
              var myEntity = {};
              myEntity.total=response.data.data.total;
              myEntity.data = response.data.data.list;
              this.entity = myEntity;
              this.$store.dispatch('setListLoading', false);
            } else{
              this.$message({
                message: '获取数据失败啦！'+JSON.stringify(response.data),
                type: 'error'
              });
            }
          });
        },
        refresh(){
          var listQuery = {};
          listQuery.contractId = this.info.contractId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.conPartyId = this.info.conPartyId;
          listQuery.applyId = this.info.applyId;
          listQuery.contractType = this.info.contractType;
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listQuery);
        },
        choose(row){
          if(row.length<=0){
            this.$message({
              message: '请选择要引入的数据!',
              type: 'error'
            });
            return;
          }
          //1.综合授信 检查是否已经引入了同样的最高额担保合同
          //2.单笔合同 检查是否已经引入了同样的最高额担保合同
          var data={};
          data.contractId=this.info.contractId;
          data.subcontractNum=row.SUBCONTRACT_NUM;
          checkHaveRef(data).then(response=>{
            if(response.data.code == enums.stateCode.code.success) {//保存成功
              var obj={};
              if(this.info.contractType=='02'){ //业务
                obj.subcontractId=row.SUBCONTRACT_ID;
                obj.subcontractNum=row.SUBCONTRACT_NUM;
                //obj.conSubconId=row.CON_SUBCON_ID;
                obj.flag='showDialog2';
                this.$emit('backFlag',obj);
              } else{ //授信协议
                this.$message({
                  message: "contractType为01时的授信协议还未完成！",
                  type: 'error'
                });
              }
            }else{
              this.$message({
                message: JSON.stringify(response.data),
                type: 'error'
              });
            }
          });
        },
        close(){
          this.$emit('backFlag',{flag:'close'});
        },
      },
    }
</script>

<style scoped>

</style>
