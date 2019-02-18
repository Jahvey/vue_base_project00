<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
  @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>
</template>

<script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import { getUserList,getUserList1,deleteUser } from '@/api/user'
// import axios from 'axios'

export default {
  data() {
    return {
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
            { label: '消费性评级', prop: 'generalAdjustRatIingCD', isSort: true },
            { label: '经营性评级', prop: 'generalAdjustRatingCD', isSort: true },
            { label: '批复金额', prop: 'creditAmt', isSort: true },
            { label: '批复已用金额', prop: 'usedAmtReal', isSort: true },
            { label: '管户客户经理', prop: 'userNum', isSort: true }
          ]
        }
      }
    }
  },
  components: { CscSingleTable },

  methods: {
    doPageQuery(listQuery) {

      console.log("到底执行没有1:"+222111);

      // getUserList(listQuery).then(response => {
      //   console.log("到底执行没有:"+111222);
      //   this.entity = response
      // }).catch((error) => {
      //   console.log(error)
      // })



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
