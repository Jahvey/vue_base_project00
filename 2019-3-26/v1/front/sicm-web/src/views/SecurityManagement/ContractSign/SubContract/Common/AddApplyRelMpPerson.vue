<!--添加抵押合同，其实是选择担保人,选择成功后弹框到填写抵押品基本信息和押品关联信息，弹框的内容可以不填写，但是会生成一条
 抵押合同记录，可以选择这个记录编辑再次填写押品基本信息和关联信息-->
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
  import { selectParty} from '@/api/contractsign'
    export default {
      name: "add-mortgage-contract",
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
                {label: "证件类型", prop: "CERT_TYPE",isFormat: true,enumType:'idTypeCd'},
                {label: "证件号码", prop: "CERT_NUM"},
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
          selectParty(listQuery).then(response => {
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
          //当确认选中时，提交后台，生成抵质押合同编号
          var obj={};
          obj.subcontractType=row.SURETY_TYPE;
          obj.partyId=row.PARTY_ID;//抵质押人的partyId
          obj.flag='showDialog';
          this.$emit('backFlag',obj);
        },
        close(){
          this.$emit('backFlag',{flag:'close'});
        },
      },
    }
</script>

<style scoped>

</style>
