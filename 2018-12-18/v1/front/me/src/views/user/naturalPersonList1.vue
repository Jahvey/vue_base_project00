<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit" :disableQueryForm="disableQueryForm"
  @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>
</template>

<script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import { getUserList, getUserList1,deleteUser } from '@/api/user'
// import axios from 'axios'

export default {
  data() {
    return {
      disableQueryForm: false,//2018-11-30 控制按钮是否显示
      entity: {},
      pageDef: {
        // 查询条件定义
        queryDef: {
          columnNum: 3, // 一行几列
          queryCols: [
            { label: '客户名称', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型', inputType: 'input', modelName: 'certType' },
            { label: '证件号码', inputType: 'input', modelName: 'certNum' },
            { label: '中征码',inputType: 'input',modeleName:'middleCode'}
          ]
        },
        tabDef: {
          isSelect: false, // 是否可以多选
          isIndex: true, // 是否有序号
          // 表格字段定义
          tabCols: [
            { label: '客户名称', prop: 'partyName', isSort: true },
            { label: '证件类型', prop: 'certType', isSort: true },
            { label: '证件号码', prop: 'certNum', isSort: true },
            { label: '中征码', prop: 'middleCode', isSort: true },
            { label: '消费性评级', prop: 'xfCreditRatingCd', isSort: true },
            { label: '经营性评级', prop: 'jyCreditRatingCd', isSort: true },
            { label: '批复金额', prop: 'pfAmt', isSort: true },
            { label: '批复已用金额', prop: 'pfBalance', isSort: true },
            { label: '管户客户经理', prop: 'mainUserNum', isSort: true }
          ]
        }
      }
    }
  },
  components: { CscSingleTable },

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
      this.$router.push({ path: '/user/userEdit',query:{method:'doEdit'} })
    },

    doDelete(row, listQuery) {
      deleteUser(row).then(response => {
        this.userList(listQuery)
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      })
    }
  }



}

</script>
