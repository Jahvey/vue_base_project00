<template>
  <csc-single-table :pageDef="pageDef"
                    :entity="entity"
                    @pageQuery="doPageQuery"
                    @view="view"
                    @edit="edit"
                    :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>

import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import { queryConDetailsXy } from '@/api/csm'

// 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）
// 协议明细信息
export default {
  name: 'ConDetailXy',
  props: {
    paramsConTree: {// 接受从conTree传过来的参数

    }

  },
  data() {
    return {
      contractId: '',
      bizType: '',

      listLoading: false,
      disableRowButtons: true, // 隐藏tab表单按钮
      entity: {},
      pageDef: {

        // 查询条件定义
        queryDef: {
          columnNum: 3, // 一行几列
          queryCols: [
            // { label: '客户名称', inputType: 'input', modelName: 'partyName' },
            // { label: '证件类型', inputType: 'select', modelName: 'certType', enumType: 'idTypeCd' },

          ]
        },
        tabDef: {
          isSelect: true,
          isIndex: true,
          tabCols: [
            { label: '业务品种', prop: 'productType', isSort: true, isFormat: true, enumType: 'productType' },
            { label: '币种', prop: 'currencyCd', isSort: true, isFormat: true, enumType: 'currencyCd' },
            { label: '金额', prop: 'detailAmt', isSort: true }

          ]
        },
        buttons: [
          { label: '查看', funcName: 'view' },
          { label: '编辑', funcName: 'edit' }
        ]
      }
    }
  },

  components: { CscSingleTable },
  created() {
    this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  },

  methods: {
    view(row) {
      if (row.length == 0) {
        alert('请您选择一条记录')
        return false
      }
      console.log('view' + JSON.stringify(row))
      const params = {
        amountDetailId: row.amountDetailId,
        productType: row.productType,
        modelFlag: '03',
        proFlag: '0'

      }
      console.log('调用相关的工作流com.bos.bizProductDetail.getProductDetail.flow 参数:' + JSON.stringify(params))
    },
    edit(row) {
      if (row.length == 0) {
        alert('请您选择一条记录')
        return false
      }
      console.log('edit' + JSON.stringify(row))

      if (row.productType == '01006001' || row.productType == '01006002' || row.productType == '01008001' || row.productType == '01008010' || row.productType == '01008002' ||
        row.productType == '01006010' // 村镇银行贴现产品
      ) {
        const params = {
          amountDetailId: row.amountDetailId,
          productType: row.productType,
          modelFlag: '03',
          proFlag: '1',
          edithp: '1'
        }
        console.log('调用相关的工作流com.bos.bizProductDetail.getProductDetail.flow 参数:' + JSON.stringify(params))
      } else {
        alert('非汇票产品不可编辑')
        return false
      }
    },

    doPageQuery(listQuery) {
      console.log('[con_detail_xy] param ' + JSON.stringify(listQuery))

      const params = Object.assign({}, this.paramsConTree, listQuery)
      console.log('成功接受到了来自父组件的参数：' + JSON.stringify(params))
      queryConDetailsXy(params).then((response) => {
        const o = response.data
        this.entity = o
      }).catch((error) => {
        console.log(error)
      })
    }

  },
  mounted() {
    // this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  }

}
</script>
