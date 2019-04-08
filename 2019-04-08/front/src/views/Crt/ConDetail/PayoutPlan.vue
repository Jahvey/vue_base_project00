<template>
  <fieldset>
    <legend>
      <span>提款计划</span>
    </legend>
    <div>
      <csc-single-table :pageDef="pageDef"
                        :entity="entity"
                        @add="add"
                        @remove="remove"
                        @pageQuery="doPageQuery"
                        :disableQueryForm="disableQueryForm"
                        :disableRowButtons="disableRowButtons">
      </csc-single-table>

    </div>

  </fieldset>
</template>
<script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import { queryPayoutPlan } from '@/api/csm'

export default {
  name: 'PayoutPlan',

  components: {

    CscSingleTable

  },
  props: {
    conDetailHtXwCycleData: {// 接受来自 父组件的参数列表

    }

  },

  data() {
    return {

      disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
      disableRowButtons: true, // 隐藏tab表单按钮
      listLoading: false,
      entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名

      },
      pageDef: {
        // 查询条件定义
        queryDef: {
          columnNum: 2, // 一行几列
          queryCols: []
        },
        tabDef: {
          isCheckRadio: true,
          isSelect: false, // 是否可以多选
          isIndex: true, // 是否有序号
          // 表格字段定义
          tabCols: [

            { label: '日期', prop: 'payoutDate', isSort: true },
            { label: '金额', prop: 'payoutAmt', isSort: true }

          ]
        },
        buttons: [
          { label: '添加', funcName: 'add' },
          { label: '删除', funcName: 'remove' }

        ]
      }
    }
  },

  methods: {
    add() {
      console.log('[add]')
    },
    remove() {
      console.log('[remove]')
    },
    doPageQuery(listParams) {
      console.log('listParams ' + JSON.stringify(listParams))
      const params = Object.assign({}, listParams, this.conDetailHtXwCycleData)

      queryPayoutPlan(params).then((response) => {
        this.entity = response.data
      }).catch((error) => {
        console.log(error)
      })
    }

  },
  created() {
    console.log('从父组件传来的参数:conDetailHtXwCycleData' + JSON.stringify(this.conDetailHtXwCycleData))
    this.doPageQuery()
  }

}
</script>


<style scoped>
.form {
  margin-top: 20px;
  margin-right: 20px;
}
</style>
