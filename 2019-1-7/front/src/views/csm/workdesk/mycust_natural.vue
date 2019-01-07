<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity" 
  @pageQuery="doPageQuery" 
  @doEdit="doEdit"
 @doDelete="doDelete"
  @view="view"    
  >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { queryNaturalForDesk } from '@/api/csm'// 正常往后台发送异步请求的类


  export default {
    data() {
      return {
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名

        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '中征码', inputType: 'input', modelName: 'middelCode' },
             
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
         
              { label: '客户名称', prop: 'partyName', isSort: true,isLink: true,url:'/csm/natural/natural_info',param:["partyId","partyName"] },
              { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd'  },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '中征码', prop: 'middelCode', isSort: true },
              { label: '消费性评级', prop: 'xfCreditRatingCd', isSort: true },
              { label: '经营性评级', prop: 'jyCreditRatingCd', isSort: true },
              { label: '批复金额', prop: 'pfAmt', isSort: true },
              { label: '批复已用金额', prop: 'pfBalance', isSort: true },
              { label: '管户客户经理', prop: 'mainUserNum', isSort: true }
            ]
          },
          buttons: []
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      

      doPageQuery(listQuery) {

      

        queryNaturalForDesk(listQuery).then(response => {
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
