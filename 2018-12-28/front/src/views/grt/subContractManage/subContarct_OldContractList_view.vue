<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
   

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
  import { findOldContractList } from '@/api/csm'// 正常往后台发送异步请求的类


  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    data() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {

        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [

              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true,isFormat:true,enumType:'currencyCd' },
              { label: '业务品种', prop: 'productType', isSort: true ,isFormat:true,enumType:'productType'},
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '合同已用金额', prop: 'conYuE', isSort: true },
              { label: '本次担保金额', prop: 'suretyAmt', isSort: true }

            ]
          },
          buttons: [

           ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {

        //console.log('listQuery ....' + listQuery)
        findOldContractList(listQuery).then(response => {
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
