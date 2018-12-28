<template>
  <div>

    <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit" :disableQueryForm="disableQueryForm"
                      @doDelete="doDelete"  @rowDbclick="rowDbclick">
    </csc-single-table>

    <!--<csc-form-dialog :pageDef="pageDef1" :dialogFormVisible="true" title="测试dialog"></csc-form-dialog>-->


    <!--<el-dialog title="新增" :modal-append-to-body="false" :before-close="beforeClose" :visible.sync ="addFormVisible"-->
               <!--:fullscreen="true" :close-on-click-modal="false" custom-class="mydialog">-->
          <!--<span>就这点东西</span>-->
    <!--</el-dialog>-->


  </div>


</template>

<script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import CscFormDialog from '@/components/CscFormDialog/CscFormDialog'
import { getUserList, getUserList1,deleteUser } from '@/api/user'
// import axios from 'axios'

export default {
  data() {
    return {
      disableQueryForm: false,//2018-11-30 csc-form-page 控制按钮是否显示
      addFormVisible: false,
      dialogFormVisible: true,
      entity: {},
      pageDef: {
        // 查询条件定义
        queryDef: {
          columnNum: 3, // 一行几列
          queryCols: [
            { label: '客户名称', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
            { label: '证件号码', inputType: 'input', modelName: 'certNum' },
            { label: '中征码',inputType: 'input',modelName:'middleCode'}
          ]
        },
        tabDef: {
          isSelect: false, // 是否可以多选
          isIndex: true, // 是否有序号
          // 表格字段定义
          tabCols: [
            { label: '客户名称', prop: 'partyName', isSort: true,url:'/user/ManyTable',isLink: true,param:["partyName","certNum"]},
            { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
            { label: '证件号码', prop: 'certNum', isSort: true,isParam: true },
            { label: '中征码', prop: 'middleCode', isSort: true },
            { label: '消费性评级', prop: 'xfCreditRatingCd', isSort: true },
            { label: '经营性评级', prop: 'jyCreditRatingCd', isSort: true },
            { label: '批复金额', prop: 'pfAmt', isSort: true },
            { label: '批复已用金额', prop: 'pfBalance', isSort: true },
            { label: '管户客户经理', prop: 'mainUserNum', isSort: true }
          ]
        }
      },
      pageDef1: {
        dialogFormVisible: false,//2018-12-19 csc-form-dialog对话框弹出
        title: "我的客户",//2018-12-19 csc-form-dialog对话框弹出标题
        name:'用户信息',
        columnNum: 3, // 一行几列
          // 表格字段定义
          pageCols: [
            { label: '客户名称', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
            { label: '证件号码', inputType: 'input', modelName: 'certNum' },
            { label: '中征码',inputType: 'input',modelName:'middleCode'}
          ]
      }
    }
  },
  components: { CscSingleTable,CscFormDialog},

  beforeCreate:function(){
    console.log("父组件beforeCreate:"+new  Date());
    // this.disableQueryForm=true;
  },

 created:function () {
   console.log("父组件created:"+new  Date());
   // this.disableQueryForm=true;
 },

  mounted: function(){
    // console.log("父组件mounted:"+new  Date());
    // this.initParam();
  },

  methods: {

    // initParam(){
    //   console.log("父组件initParam:"+new  Date());
    //   this.disableQueryForm=true;
    // },

    doPageQuery(listQuery) {

      console.log("父组件doPageQuery到底执行没有1:"+new  Date());

      getUserList(listQuery).then(response => {
        console.log("父组件到底执行没有1ResponseMsg:"+response.data.total);
        // alert("父组件getUserList1:"+JSON.parse(JSON.stringify(response.data)));
        // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
        this.entity = response.data;//如果定义的是返回responsemsg 这里response.data  就是
        console.log("父组件到底执行没有3ResponseMsg:"+response.data.totalRec);
        this.$store.dispatch('setListLoading', false);
      }).catch((error) => {
        console.log(error)
      })



      // var params={"partyId":"5AF8119026E0FABDE05010AC57DD79A2"};
      // var url="mybatis-service/mynatureal/queryNaturalForDesk";
      // axios.get(url, {
      //   params: { 'orgcode': '0700' }
      // }).then(function (response) {
      //   alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
      //   this.entity = response
      // }).catch(function (error) {
      //   alert("111222:"+error);
      // });



    },

    rowDbclick(row) {
      this.$router.push({ path: '/user/userList' })
    },

    create() {
      this.$router.push({ path: '/user/userAdd' })
    },

    doEdit(row) {
      // this.$router.push({ path: '/user/userEdit',query:{method:'doEdit'} })//2018-12-19 以前点击编辑是路由跳转 今天测试改成弹出dialog
      console.log("进来没得哦:"+new Date());
      this.dialogFormVisible = true;//点击编辑时弹出dialog
      // this.addFormVisible = true;//2018-12-19 测试直接写弹框已通过
    },

    doDelete(row, listQuery) {
      deleteUser(row).then(response => {
        this.userList(listQuery)
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      })
    },
    //关闭模态框前的回调函数
    beforeClose(){

      // this.$confirm('确认关闭吗?', '提示', {type: 'warning'}).then(() => {
      //   this.addFormVisible=false;
      // }).catch(
      //   console.log("关闭失败")
      // );

      this.$confirm('确认关闭吗?, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.addFormVisible=false;
        this.$message({
          type: 'success',
          message: '关闭成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消关闭'
        });
      });


    }
  }



}

</script>
<style rel="stylesheet/scss" lang="scss">
  .mydialog{
    width: 100%;
    height: 100%;
  }
</style>
