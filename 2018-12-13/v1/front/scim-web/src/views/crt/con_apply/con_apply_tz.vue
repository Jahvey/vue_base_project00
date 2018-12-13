<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
  @view="view"     
  @create="create" 
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
  import { getApproveCons } from '@/api/contract'// 正常往后台发送异步请求的类


  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    data() {
      return {
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          // data: [

          //   {
          //     CREDIT_MODE: '112',
          //     CONTRACT_NUM: '123456789',
          //     PRODUCT_TYPE: '贷款',
          //     CURRENCY_CD: '人民币',
          //     CONTRACT_AMT: '1729.97',
          //     CON_BALANCE: '13.11',
          //     BEGIN_DATE: '1998-12-1',
          //     END_DATE: '2002-01-22',
          //   }
          // ]
        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [
              { label: '主合同编号', inputType: 'input', modelName: 'contractNum' },

            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              // { label: '合同性质', prop: 'CREDIT_MODE', isSort: true },
              // { label: '合同编号', prop: 'CONTRACT_NUM', isSort: true },
              // { label: '合同品种', prop: 'PRODUCT_TYPE', isSort: true },
              // { label: '币种', prop: 'CURRENCY_CD', isSort: true },
              // { label: '合同金额', prop: 'CONTRACT_AMT', isSort: true },
              // { label: '可用金额(元)', prop: 'CON_BALANCE', isSort: true },
              // { label: '合同起期', prop: 'BEGIN_DATE', isSort: true },
              // { label: '合同止期', prop: 'END_DATE', isSort: true }
              { label: '合同性质', prop: 'creditMode', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '合同品种', prop: 'productType', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true },
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '可用金额(元)', prop: 'conBalance', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true }


            ]
          },
          buttons: [
            { label: '查看', funcName: 'view' },
            { label: '合同创建', funcName: 'create' },
            { label: '调整', funcName: 'update' },
            { label: '合同失效', funcName: 'disab' },
            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {

        //console.log('listQuery ....' + listQuery)
        getApproveCons(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
          // console.log('response.data.entity...')
          //  console.log( response.data.entity)
     
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
      create() { 
       console.log('create合同...')
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
      this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  }

  }
</script>
