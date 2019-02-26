<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
  @view="view"     

@pageQuery="doPageQuery" 
@doEdit="doEdit"
@doDelete="doDelete"
  :disableQueryForm="disableQueryForm" 
  :disableRowButtons="disableRowButtons"  

  >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { getApplyJxhjBizInfo } from '@/api/csm'// 正常往后台发送异步请求的类




  export default {
    data() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名

        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [

            ]
          },
          tabDef: {
      
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
             
              
              { label: '客户名称', prop: 'partyName', isSort: true},
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true ,isFormat:true,enumType:'currencyCd'},//CD000001
              { label: '借据金额', prop: 'summaryAmt', isSort: true },

              { label: '借据余额', prop: 'jjYe', isSort: true },
              { label: '借据状态', prop: 'summaryStatusCd', isSort: true },  //XD_SXYW0226
              { label: '到期日期', prop: 'endDate', isSort: true }


            ]
          },
          buttons: [
            { label: '循环通/续接贷', funcName: 'view' },

            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {

        //console.log('listQuery ....' + listQuery)
        getApplyJxhjBizInfo(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
    
     
        }).catch((error) => {
    
          console.log(error)
        })
      },
      // 行事件
      doEdit(row) {
        console.log('row ....')
      //  this.$router.push({path: '/contract/add/edit/' + row.contractId})
      },
      view() {
        console.log('view 合同...')
        // this.$router.push({path: '/contract/contractAdd'})
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
      this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  }

  }
</script>
