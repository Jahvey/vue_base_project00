<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm" @findOne="findOne"
       :disableRowButtons="disableRowButtons"             @contractList="contractList"       >
  </csc-single-table>
</template>

<script>
  // 本行业务信息---》违约记录
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getContractList } from '@/api/contract'// 正常往后+台发送异步请求的类
  //  import { getContractList } from '@/api/api'//api是自己写的用来测试mock假数据的路径，配置了这个之后mock会拦截正常请求

  export default {
    // name: 'mortgageContract',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              PARTY_NAME: '军育苗',
              CONTRACT_NUM: 'HT080420180723014563',
              SUMMARY_NUM: 'JJ3014563',
              YQ_AMT: '78.44',
              OVERDUE_DATE: '2018-08-21 ',
              REPAY_DATE: '2018-08-21',
              REMARK: ' 利息逾期 ',
              USER_NUM: '胥弋梅',
              ORG_NUM: '1200'
            }
          ]
        },
        // disableQueryForm: true,credit
        pageDef: {
          // 查询条件定义
          queryDef: {},
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '借款人名称', prop: 'PARTY_NAME', isSort: true },
              { label: '合同编号', prop: 'CONTRACT_NUM', isSort: true },
              { label: '借据编号', prop: 'SUMMARY_NUM', isSort: true },
              { label: '逾期/垫款金额', prop: 'YQ_AMT', isSort: true },
              { label: '逾期/垫款日期', prop: 'OVERDUE_DATE', isSort: true },
              { label: '归还日期', prop: 'REPAY_DATE', isSort: true },
              { label: '备注', prop: 'REMARK', isSort: true },
              { label: '经办人', prop: 'USER_NUM', isSort: true },
              { label: '经办机构', prop: 'ORG_NUM', isSort: true }
            ]
          }
        }
      }
    },

    components: { CscSingleTable },
    methods: {
      doPageQuery() {
        // this.contractList(listQuery)
        // console.log('doPageQuery...')
      },

      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

        this.listLoading = true
        console.log('listQuery ....' + listQuery)
        getContractList(params).then(response => {
          this.entity = response
          // console.log(" response.data.entity"+ response.data.entity)
          this.listLoading = false
        }).catch((error) => {
          // alert(error)
          console.log(error)
        })
      },
      findOne() { // 重置表单就是直接清空表单里面的数据
        alert('查询')
      }
    },
    computed: { // 计算属性
      disabled() { // 控制页面渲染
        // return this.disableQueryForm = true
      }

    },
    mounted() {
      // disableQueryForm() {
      //   console.log('emit disableQueryForm.....')
      //   return this.disableQueryForm
      // },
      this.contractList() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
