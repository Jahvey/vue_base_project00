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
  import { findOldDbList } from '@/api/csm'


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
            queryCols: []
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [

              { label: '抵质押类型', prop: 'subconractType', isSort: true,isFormat:true,enumType:'collType' },
              { label: '抵质押人名称', prop: 'partyName', isSort: true },
              { label: '抵质押物编号', prop: 'suretyNo', isSort: true },
              { label: '抵质押物类型', prop: 'sortType', isSort: true,isFormat:true,enumType:'sortType' },
              { label: '币种', prop: 'currencyCdn', isSort: true,isFormat:true,enumType:'currencyCd' },
              { label: '评估价值（元）', prop: 'assessValue', isSort: true },
              { label: '权利价值（元）', prop: 'mortgageValue', isSort: true },
              { label: '已担保金额（元）', prop: 'usedAmt', isSort: true },
              { label: '本次担保金额（元）', prop: 'suretyAmt', isSort: true }

            ]
          },
          buttons: [
            { label: '查看', funcName: 'view' }

            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {

   
        findOldDbList(listQuery).then(response => {
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
      this.doPageQuery() 
  }

  }
</script>
