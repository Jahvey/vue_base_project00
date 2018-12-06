<template>
  <div class="app-container">
    <csc-single-table
      :pageDef="pageDef"
      :entity="entity"
      @add="doAdd"
      @doEdit="doEdit"
      @pageQuery="doPageQuery"
      @rowChange="rowChange"
      @doDelete="doDelete"
      @rowDbclick="rowDbclick"
    >
    </csc-single-table>
  </div>
</template>
<script>
  import { getOrgList ,deleteOrg} from '@/api/org'
  import {isEmpty} from "@/utils/validate"

  export default {
    data(){
      return {
        entity: {},
        selectedRow:{},
        pageDef: {
          queryDef: {
            columnNum: 2, //一行几列
            queryCols: [
              {label: "机构名称", inputType: "input", modelName: "corpName"},
              {label: "机构性质", inputType: "select", modelName: "corpPropCd", enumType: "corpPropCd"}
            ]
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "机构名称", prop: "corpName"},
              {label: "机构性质", prop: "corpPropCd", isFormat: true},
              {label: "营业执照号", prop: "busiLicenseNo"},
              {label: "办公电话", prop: "officePhoneNo"},
              {label: "注册邮箱", prop: "email"},
              {label: "管理员手机", prop: "adminPhoneNo"}
            ]
          },
          buttons: [
            {label: "新增", funcName: "add", disabled: false},
            {label: "修改", funcName: "doEdit", disabled: false}
          ]
        }
      }
    },
    methods: {
      rowChange(row){
        this.selectedRow = row
      },
      doPageQuery(listQuery){
        getOrgList(listQuery).then(response => {
          this.entity = response
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
