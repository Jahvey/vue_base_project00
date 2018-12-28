<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
  @view="view"     
  @bizApply="bizApply" 
  @newly="newly"
  @disab="disab" 
  @update="update" 
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
  import { getBizList } from '@/api/csm'// 正常往后台发送异步请求的类


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
            columnNum: 2, // 一行几列
            queryCols: [
            ]
          },
          tabDef: {
      
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
            
              { label: '客户编号', prop: 'partyNum', isSort: true},
              { label: '客户名称', prop: 'partyName', isSort: true},
              { label: '业务编号', prop: 'bizNum', isSort: true},
              { label: '业务产品', prop: 'productType', isSort: true,isFormat:true,enumType:'productType'},
              { label: '业务类型', prop: 'bizHappenType', isSort: true,isFormat:true,enumType:'bizHappenType'},//XD_SXYW0001
              { label: '业务性质', prop: 'creditMode', isSort: true,isFormat:true,enumType:'creditMode' },//XD_BIZ0003
              { label: '银团', prop: 'isBankTeamLoan', isSort: true,isFormat:true,enumType:'isBankTeamLoan' },//XD_0002
              { label: '合同起期', prop: 'validDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '业务金额（元）', prop: 'rmbAmt', isSort: true },
              { label: '可用金额（元）', prop: 'boUse', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true },


            ]
          },
          buttons: [
            { label: '业务申请', funcName: 'bizApply' },
            { label: '查看', funcName: 'view' },
            
            { label: '失效', funcName: 'disab' },
            { label: '调整', funcName: 'update' },
            { label: '重算额度', funcName: 'newly' },
            
            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {

        //console.log('listQuery ....' + listQuery)
        getBizList(listQuery).then(response => {
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
      newly() { 
       console.log('newly...')
      },
      update() { 
       console.log('update合同...')
      },
      disab() { 
       console.log('disable 合同...')
      },
      bizApply() { 
       console.log('bizApply 合同...')
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
