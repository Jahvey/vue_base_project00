<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity" 
  @findOne="findOne"
  :disableQueryForm="disableQueryForm" 
  :disableRowButtons="disableRowButtons"            
   @contractList="contractList"   >
  </csc-single-table>
</template>

<script>
  // 账户信息
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getContractList } from '@/api/contract'// 正常往后台发送异步请求的类
 

  export default {
    name: 'ews_warn_main',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              WARN_DATE: '2017-09-23',
              RULE_ABSTRACT: '紧急事件',
              WARN_INFO: '中度紧急',
              WARN_LEVEL: '0',
              CLOSE_FLAG: '无',
              CLOSE_DATE: '2017-12-12',
              CLOSE_REASON: '因为某些你懂的原因'

            }
          ]
        },

        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
             // { label: '选择', prop: 'checkcolumn', isSort: true },
              { label: '预警日期', prop: 'WARN_DATE', isSort: true },
              { label: '预警简要信息', prop: 'RULE_ABSTRACT', isSort: true },
              { label: '预警情况', prop: 'WARN_INFO', isSort: true },
              { label: '预警等级', prop: 'WARN_LEVEL', isSort: true },
              { label: '关闭标志', prop: 'CLOSE_FLAG', isSort: true },
              { label: '关闭日期', prop: 'CLOSE_DATE', isSort: true },
              { label: '关闭原因', prop: 'CLOSE_REASON', isSort: true }

            ]
          },
          buttons: [
            { label: '查看', funcName: 'findOne' }
          ]
        }
      }
    },

    components: { CscSingleTable }, // 引入的子组件

    methods: {
      doPageQuery() {
        // this.contractList(listQuery)
         console.log('doPageQuery...')
      },

      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

        this.listLoading = true
        console.log('listQuery ....' + listQuery)
        getContractList(params).then(response => {
          this.entity = response
          console.log(" response.data.entity"+ response.data.entity)
          this.listLoading = false
        }).catch((error) => {
         
          console.log(error)
        })
      },
      findOne() { // 重置表单就是直接清空表单里面的数据
        alert('查询')
      }
    },

    mounted() {

      this.contractList() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
