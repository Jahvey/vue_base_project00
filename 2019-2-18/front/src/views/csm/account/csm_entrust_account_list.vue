<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"

@pageQuery="doPageQuery"
@view="view" 
@doEdit="doEdit"
@doDelete="doDelete"
  :disableQueryForm="disableQueryForm" 
  :disableRowButtons="disableRowButtons"  

   >
  </csc-single-table>
</template>

<script>
  // 账户信息
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' 
  import { getEntrustAccountsByPartyId } from '@/api/csm'
 

  export default {
    name: 'csm_entrust_account_list',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {

        },
        // disableQueryForm: true,
        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '账户名称', prop: 'accName', isSort: true },
              { label: '委托项目名称', prop: 'entrustProjectName', isSort: true },
              { label: '委托存款账号', prop: 'entrustAcc', isSort: true }, // currency：货币
              { label: '委托贷款基金账号', prop: 'entrustLoanAcc', isSort: true },
              { label: '委托贷款收息账号', prop: 'entrustReturnAcc', isSort: true },
              { label: '委托人收本账号', prop: 'entrustReturnPrincipalAcc', isSort: true },
              { label: '委托人收息账号', prop: 'entrustReturnInterestAcc', isSort: true }
            ]
          },
          buttons: [
            { label: '查看', funcName: 'findOne' }
          ]
        }
      }
    },

    components: { CscSingleTable }, // 引入的子组件

    methods: {

      doPageQuery(listQuery) {

  
        getEntrustAccountsByPartyId(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)

     
        }).catch((error) => {
    
          console.log(error)
        })
      },

      view(){
        console.log("view.....")
      },
      // 行事件
      doEdit(row) {
        console.log('row ....')
      //  this.$router.push({path: '/contract/add/edit/' + row.contractId})
      },

      doDelete() {
        // deleteContract(row).then(response => {
        //   this.contractList(listQuery)
        //   this.$message({
        //     type: 'success',
        //     message: '删除成功!'
        //   })
        // })
        console.log('del ....')
      }
    },
    mounted() {     
      this.doPageQuery() 
  }

  }
</script>
