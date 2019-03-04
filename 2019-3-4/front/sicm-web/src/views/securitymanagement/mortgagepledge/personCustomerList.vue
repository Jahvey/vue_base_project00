<template>
  <csc-single-table
    :pageDef="pageDef"
    :entity="entity"
    :disableRowButtons="disableRowButtons"
    @add="doAdd"
    @doEdit="doEdit"
    @pageQuery="doPageQuery"
    @rowChange="rowChange"
    @doDelete="doDelete"
    @rowDbclick="rowDbclick"
  >
  </csc-single-table>
</template>

<script>
  import { getPersonCustomerList} from '@/api/securitymanagement'
  import enums from "@/utils/enums"
    export default {
        name: "person-customer-list",
      data(){
        return {
          entity: {},
          disableRowButtons:true,
          selectedRow:{},
          pageDef: {
            queryDef: {
              columnNum: 3, //一行几列
              queryCols: [
                {label: "客户名称", inputType: "input", modelName: "partyName"},
                {label: "客户编号", inputType: "input", modelName: "partyNum"},
                {label: "证件类型", inputType: "select", modelName: "certType",enumType:"idTypeCd"},
                {label: "证件号码", inputType: "input", modelName: "certNum"},
                {label: "手机号码", inputType: "input", modelName: "phoneNumber"},
              ]
            },
            tabDef: {
              isSelect: false, //是否可以多选
              isIndex: true,  //是否有序号
              //表格字段定义
              tabCols: [
/*                {label: "客户编号", prop: "corpName"},
                {label: "客户名称", prop: "corpPropCd"},
                {label: "证件类型", prop: "busiLicenseNo"},
                {label: "证件号码", prop: "officePhoneNo"},
                {label: "手机号码", prop: "email"},
                {label: "是否农户", prop: "adminPhoneNo"}*/
                {label: "客户编号", prop: "partyNum"},
                {label: "客户名称", prop: "partyName"},
                {label: "证件类型", prop: "certType",isFormat: true,enumType:"idTypeCd"},
                {label: "证件号码", prop: "certNum"},
                {label: "手机号码", prop: "phoneNumber"},
                {label: "是否农户", prop: "isFarmer",isFormat: true,enumType:"commonYesAndNotCd"}
              ]
            },
          }
        }
      },
      methods: {
        rowChange(row){
          this.selectedRow = row;
          this.$emit('customerInfo',row);
        },
        doPageQuery(listQuery){
           getPersonCustomerList(listQuery).then(response => {
             if(response.data.code == enums.stateCode.code.success){//返回数据成功
               var myEntity = {};
               myEntity.total=response.data.data.total;
               myEntity.data = response.data.data.list;
               /**
                * 总结一个很奇怪的地方,为啥以下方式不行
                * this.entity.total = response.data.data.total;
                * this.entity.data = response.data.data.list;
                */
               this.entity = myEntity;
               this.$store.dispatch('setListLoading', false);
             } else{
               this.$message({
                 message: '获取数据失败啦！',
                 type: 'error'
               });
             }
           })
        },
        doAdd(){
          this.$router.push({ name: 'orgAdd',query:{method:'add'}})
        },

        doEdit(row){
          this.$router.push({ name: 'orgEdit', query: { orgInfoId: row.orgInfoId,method:'doEdit' }})
        },

        doDelete(row,listquery,index){
          deleteOrg(row).then(response => {
            this.$message({
              message: '删除机构信息成功',
              type: 'success'
            });
            this.entity.data.splice(index, 1);
          });
        },
        rowDbclick(row){
          this.$router.push({ name: 'orgEdit', query: { orgInfoId: row.orgInfoId,method:'detail' }})
        }
      }
    }
</script>

<style scoped>

</style>
