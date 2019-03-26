<!--查询客户结果-->
<template>
  <csc-single-table
    :pageDef="pageDef"
    :entity="entity"
    :disableRowButtons="disableRowButtons"
    @pageQuery="doPageQuery"
    @doChoose="doChoose"
  >
  </csc-single-table>
</template>

<script>
  import { selectCustomerAllByPartyTypeCd} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
        name: "CustomerTable",
      data(){
        return {
            tabCols1: [//自然人客户
              { label: 'CRMS客户编号', prop: 'partyNum'},
              { label: '客户名称', prop: 'partyName' },
              { label: '证件类型', prop: 'certType',isFormat: true,enumType:'idTypeCd' },
              { label: '证件号码', prop: 'certNum'},
              { label: '机构名称', prop: 'orgNum' },
              { label: '管户客户经理', prop: 'userNum'},
          ],
            tabCols2: [//对公客户
              { label: 'CRMS客户编号', prop: 'partyNum'},
              { label: '客户名称', prop: 'partyName' },
              { label: '统一社会信用代码', prop: 'unifySocietyCreditNum', },
              { label: '营业执照', prop: 'registrCd'},
              { label: '组织机构代码', prop: 'orgRegisterCd' },
              { label: '机构名称', prop: 'orgNum'},
              { label: '管户客户经理', prop: 'userNum'},
          ],
          queryCols1:[
            {label: "客户类型", inputType: "select", modelName: "partyTypeCd",enumType:'CustomerClassCd'},
            {label: "客户名称", inputType: "input", modelName: "partyName"},
            {label: "证件类型", inputType: "select", modelName: "certType",enumType:'idTypeCd'},
            {label: "证件号码", inputType: "input", modelName: "certNum"},
          ],
          queryCols2:[
            {label: "客户类型", inputType: "select", modelName: "partyTypeCd",enumType:'CustomerClassCd'},
            {label: "客户名称", inputType: "input", modelName: "partyName"},
            {label: "营业执照", inputType: "input", modelName: "registrCd"},
            {label: "组织机构代码", inputType: "input", modelName: "orgRegisterCd"},
            {label: "统一社会信用代码", inputType: "input", modelName: "unifySocietyCreditNum"},
          ],
          entity: {},
          disableRowButtons:true,
          pageDef: {
            queryDef: {
              columnNum: 3, //一行几列
              queryCols: []
            },
            tabDef: {
              isSelect: false, //是否可以多选
              isIndex: false,  //是否有序号
              isCheckRadio:true,//是否单选
              //表格字段定义
              tabCols: []
            },
            buttons: [
              {label: "确定", funcName: "doChoose", disabled: false},
            ]
          }
        }
      },
      methods: {
        doChoose(row) {
          this.$emit('backData', row);
        },
        doPageQuery(listQuery) {
          listQuery.legOrg = '9999';
          console.log(listQuery.partyTypeCd);
          if(listQuery.partyTypeCd ==undefined){
            listQuery.partyTypeCd = "02";
          }
          selectCustomerAllByPartyTypeCd(listQuery).then(response => {
            if (response.data.flag == enums.stateCode.flag.success) {//返回数据成功
              this.pageDef.queryDef.queryCols = null;
              this.pageDef.tabDef.tabCols = null;
              if(listQuery.partyTypeCd=='01'){//公司客户
                this.pageDef.queryDef.queryCols = this.queryCols2;
                this.pageDef.tabDef.tabCols = this.tabCols2;
              } else{//自然人客户
                this.pageDef.queryDef.queryCols = this.queryCols1;
                this.pageDef.tabDef.tabCols = this.tabCols1;
              }
              var myEntity = {};
              myEntity.total = response.data.data.total;
              myEntity.data = response.data.data.list;
              this.entity = myEntity;
              this.$store.dispatch('setListLoading', false);
            } else {
              this.$message({
                message: '获取数据失败啦！',
                type: 'error'
              });
            }
          })
        },
      },
    }
</script>

<style scoped>

</style>
