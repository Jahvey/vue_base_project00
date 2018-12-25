<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
  @view="view"      
  @disab="disab" 
  @update="update" 
@pageQuery="doPageQuery" 
@doEdit="doEdit"
@doDelete="doDelete"

  >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { findSubContractList } from '@/api/contract'// 正常往后台发送异步请求的类


  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    data() {
      return {
        listLoading: false,
        entity: {

        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '担保人名称', inputType: 'input', modelName: 'partyName' },
              { label: '担保合同编号', inputType: 'input', modelName: 'subcontractNum' },
              { label: '担保合同类型', inputType: 'input', modelName: 'subcontractTypeName' },

            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [

              { label: '担保合同编号', prop: 'subcontractNum', isSort: true },
              { label: '担保人名称', prop: 'partyName', isSort: true },
              { label: '币种', prop: 'currencyCdn', isSort: true,isFormat:true,enumType:'currencyCd' },
              { label: '担保合同金额', prop: 'subcontractAmt', isSort: true },
              { label: '担保合同类型', prop: 'subcontractTypeName', isSort: true },
              { label: '是否最高额', prop: 'ifTopSubcon', isSort: true },
              { label: '担保合同起期', prop: 'beginDate', isSort: true },
              { label: '担保合同止期', prop: 'endDate', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true }

            ]
          },
          buttons: [
            { label: '查看', funcName: 'view' },
            { label: '调整', funcName: 'update' },
            { label: '失效', funcName: 'disab' },
            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {

        //console.log('listQuery ....' + listQuery)
        findSubContractList(listQuery).then(response => {
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
      update() { 
       console.log('update合同...')
      },
      disab() { 
       console.log('disable 合同...')
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
