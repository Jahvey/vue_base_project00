<template>
  <div class="app-container">
    <csc-single-table
      :pageDef="pageDef"
      :entity="entity"
      :disableQueryForm="disableQueryForm"
      :disableRowButtons="disableRowButtons"
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

  export default {
    name: "edit-mortgage-pledge",
    beforeCreate(){
      //alert(this.$store.getters.listLoading);
      //this.$store.commit("SET_LISTLOADING",false);
      //alert(this.$store.getters.listLoading);
    },
    data(){
      return {
        disableRowButtons:false,//每一行的修改、删除按钮是否显示(操作按钮)，false为要显示
        disableQueryForm:true,//是否显示查询表单
        entity: {
          data:[
            {
              corpName:"红十字协会",
              corpPropCd:"公益",
              busiLicenseNo:"YYZZ121321321",
              officePhoneNo:"0298871232",
              email:"849408073@qq.com",
              adminPhoneNo:"11002033",
              date:"2018年12月21日",
            },
            {
              corpName:"红十字协会",
              corpPropCd:"公益",
              busiLicenseNo:"YYZZ121321321",
              officePhoneNo:"0298871232",
              email:"849408073@qq.com",
              adminPhoneNo:"11002033",
              date:"2018年12月21日",
            },
            {
              corpName:"红十字协会",
              corpPropCd:"公益",
              busiLicenseNo:"YYZZ121321321",
              officePhoneNo:"0298871232",
              email:"849408073@qq.com",
              adminPhoneNo:"11002033",
              date:"2018年12月21日",
            },
            {
              corpName:"红十字协会",
              corpPropCd:"公益",
              busiLicenseNo:"YYZZ121321321",
              officePhoneNo:"0298871232",
              email:"849408073@qq.com",
              adminPhoneNo:"11002033",
              date:"2018年12月21日",
            },
          ],
          total:100,
          totalRec:"",
        },//数据实体，总条数等
        selectedRow:{},
        pageDef: {
          queryDef: {//查询列
            columnNum: 2, //一行几列
            queryCols: [//条件输入框
              {label: "机构名称", inputType: "input", modelName: "corpName"},
              {label: "机构性质", inputType: "select", modelName: "corpPropCd", enumType: "corpPropCd"}
            ]
          },
          tabDef: {
            //只能有一个为true
            isExpand:false,//如果设置了 expand 则显示为一个可展开的按钮
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              //当前可接受的全部参数
              //{label: "机构名称", prop: "corpName",isFormat:true,isRef:false,isDateTime:false,isDate:false,isCustom:false}
              {label: "机构名称", prop: "corpName"},
              {label: "机构性质", prop: "corpPropCd", isFormat: true},
              {label: "营业执照号", prop: "busiLicenseNo"},
              {label: "办公电话", prop: "officePhoneNo"},
              {label: "注册邮箱", prop: "email"},
              {label: "管理员手机", prop: "adminPhoneNo"},
              {label: "时间", prop: "date",isDate:false},
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
        this.$store.dispatch('setListLoading', false);//返回结果是时关闭遮罩
        // getOrgList(listQuery).then(response => {
        //   this.entity = response
        // })
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
