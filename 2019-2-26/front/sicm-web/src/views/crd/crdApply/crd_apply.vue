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
  import { queryCorpHis } from '@/api/csm'// 正常往后台发送异步请求的类


  export default {
    data() {
      return {
        disableQueryForm: false, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {

        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [
            { label: '客户编号:', inputType: 'input', modelName: 'partyNum' },
            { label: '客户名称:', inputType: 'input', modelName: 'partyName' },
            { label: '客户评级:', inputType: 'input', modelName: 'creditRating' },
            { label: '额度类型:', inputType: 'input', modelName: 'limitType' },

            ]
          },
          tabDef: {
      
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
            
             
              { label: '客户名称', prop: 'partyName', isSort: true},
              { label: '证书类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd'},//CDKH0002
              { label: '证件号码', prop: 'certNum', isSort: true},
              { label: '额度类型', prop: 'limitType', isSort: true,isFormat:true,enumType:'limitType'},//XD_SXYW0228
              { label: '额度总额', prop: 'creditAmt', isSort: true },
              { label: '已用额度', prop: 'usedAmt', isSort: true },
              { label: '可用额度', prop: 'availableAmt', isSort: true },
              { label: '起始日', prop: 'beginDate', isSort: true },
              { label: '到期日', prop: 'endDate', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true },

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
        queryCorpHis(listQuery).then(response => {
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
      this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  }

  }
</script>
