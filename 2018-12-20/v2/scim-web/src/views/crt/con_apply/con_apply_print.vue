<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
  @view="view"     

@pageQuery="doPageQuery" 
@doEdit="doEdit"
@doDelete="doDelete"


  >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { getPrintCons } from '@/api/contract'// 正常往后台发送异步请求的类




  export default {
    data() {
      return {
        listLoading: false,
        entity: {},
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '合同类型', inputType: 'input', modelName: 'conTypeCn' },
              
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
             
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '借款/担保人', prop: 'partyName', isSort: true },
              { label: '合同类型', prop: 'conTypeCn', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true },
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '展期协议号', prop: 'periodNum', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true }


            ]
          },
          buttons: [
            { label: '合同打印', funcName: 'view' },

            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    created(){
      console.log("多参数传递:" + JSON.stringify(this.$store.state.urlParam.queryParam));
       //  console.log("params:...."+this.$route.query.id+".."+this.$route.query.key)
        // console.log(this.$route.query.abc)	
    },
    
    methods: {

      

      doPageQuery(listQuery) {

      

        //console.log('listQuery ....' + listQuery)
        getPrintCons(listQuery).then(response => {
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
