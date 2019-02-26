<template>
  <csc-single-table 
  :pageDef="pageDef" 
:entity="entity" 
@pageQuery="doPageQuery" 
:disableRowButtons="disableRowButtons"
@clearFrom="clearFrom"
>
  </csc-single-table>
</template>

<script>
  
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  //import { queryConApvList } from '@/api/contract'// 正常往后台发送异步请求的类

  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    data() {
      return {

        listLoading: false,
        disableRowButtons: true, // 隐藏tab表单按钮
        entity: {},
        pageDef: {
          name:"业务明细页面",
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType', enumType: 'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '合同状态', inputType: 'select', modelName: 'conStatus', enumType: 'conStatus' },
              { label: '业务品种', inputType: 'select', modelName: 'productType' ,enumType: 'productType'} // 树形下拉框
            ]
          },
          tabDef: {
            isSelect: false,
            isIndex: true,
            tabCols: [
              { label: '合同编号', prop: 'contractNum', modelName:'contractNum',isSort: true ,
                isLink: true,url:'/crt/con_info/con_info_ht_xw',param:["contractNum","conStatus"]},
              { label: '业务性质', prop: 'bizTypeFlag', isSort: true, isFormat: true, enumType: 'bizTypeFlag' },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true, isFormat: true, enumType: 'idTypeCd' },
              { label: '证件号码', prop: 'certNum', modelName:'certNum',isSort: true,isParam:true },
              { label: '业务品种', prop: 'productType', isSort: true, isFormat: true, enumType: 'productType' },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true, isFormat: true, enumType: 'currencyCd' },
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '合同可用金额', prop: 'conBalance', isSort: true }
            ]
          },
          buttons: []
        }
      }
    },

    components: { CscSingleTable },

    methods: {

      doPageQuery(listQuery) {
        console.log("[biz_tx_all] param "+JSON.stringify(listQuery))
        // queryConApvList(listQuery).then(response => {
        //   this.entity = response.data
        //   // console.log(response.data.contractNum)
        //   this.$store.dispatch('setListLoading', false)
        // }).catch((error) => {
        //   console.log(error)
        // })
      },
      testFn(row){
        alert(row.contractNum)
      },
      clearFrom() { // 重置表单就是直接清空表单里面的数据
        alert('重置')
      }
    },
    mounted() {
      this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  }

  }
</script>
