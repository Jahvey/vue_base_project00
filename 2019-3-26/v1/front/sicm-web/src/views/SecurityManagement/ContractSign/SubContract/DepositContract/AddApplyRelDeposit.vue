<!--展示业务申请添加的保证金-->
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
  import { selSubGrtBzj,insertSubGrtRel3} from '@/api/contractsign'
    export default {
        name: "AddApplyRelDeposit",
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
                {label: "保证金类型", prop: "MARGIN_SORT",isFormat: true,enumType:'marginSortCd'},
                {label: "开户行", prop: "OPEN_BANK"},
                {label: "开户人", prop: "ACCT_NAME"},
                {label: "保证金账号", prop: "MARGIN_ACCOUNT",},
                {label: "币种", prop: "CURRENCY_CD",isFormat: true,enumType:'currencyCd'},
                {label: "保证金金额", prop: "ACC_BALANCE"},
                {label: "到期日期", prop: "END_DATE"},
                {label: "执行利率(%)", prop: "MARGIN_RATE"},
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
          listQuery.applyId = this.info.applyId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.subcontractId = this.info.subcontractId;
          selSubGrtBzj(listQuery).then(response => {
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
          listQuery.applyId = this.info.applyId;
          listQuery.subcontractType = this.info.subcontractType;
          listQuery.subcontractId = this.info.subcontractId;
          listQuery.pageNum=1;
          listQuery.pageSize=10;
          this.$store.dispatch('setListLoading', true);
          this.doPageQuery(listQuery);
        },
        choose(row){
          console.info("row:"+JSON.stringify(row));
          if(row.length<=0){
            this.$message({
              message: '请选择要引入的数据!',
              type: 'error'
            });
            return;
          }
          var saveObj={};
          saveObj.suretyId = row.SURETY_ID;
          saveObj.subcontractId=this.info.subcontractId;
          saveObj.contractId=this.info.contractId;
          insertSubGrtRel3(saveObj).then(response => {
            if(response.data.code == enums.stateCode.code.success){
              var obj2={};
              obj2.flag='ok';
              this.$emit('backFlag',obj2)
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
