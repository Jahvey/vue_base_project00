<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm" @findOne="findOne"
       :disableRowButtons="disableRowButtons"      :disableQueryButtons="disableQueryButtons"       @contractList="contractList"       >
  </csc-single-table>
</template>

<script>
  // 信用评级信息，这个似乎有点问题，表单布局
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getContractList } from '@/api/contract'// 正常往后+台发送异步请求的类
  //  import { getContractList } from '@/api/api'//api是自己写的用来测试mock假数据的路径，配置了这个之后mock会拦截正常请求

  export default {
    // name: 'mortgageContract',  // 客户编号和客户名称的form表单怎么回显？？上面那个是查询的
    data: function() {
      return {
        disableQueryForm: false,
        disableQueryButtons: true, // 隐藏查询表单的按钮，为何我自定义的传递不过去？？？
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              PARTY_NAME: '风卷残云',
              RATING_DT: '2018-07-24',
              RATING_TYPE: '商业贷款',
              CREDIT_RATING_CD: '良好',
              EFFECTIVE_START_DT: '2016-11-30',
              EFFECTIVE_END_DT: '2017-11-20',
              RATING_STATE: '非常有效',
              USER_NUM: '风车车',
              ORG_NUM: '假老练协会'
            }
          ]
        },
        pageDef: {
          // 查询条件定义
          queryDef: { // 写在查询定义里面是不是有问题？？
            columnNum: 2, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'input', modelName: 'certType' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'PARTY_NAME', isSort: true },
              { label: '评级日期', prop: 'RATING_DT', isSort: true }, // currency：货币
              { label: '贷款性质', prop: 'RATING_TYPE', isSort: true },
              { label: '信用等级', prop: 'CREDIT_RATING_CD', isSort: true },
              { label: '起始日期', prop: 'EFFECTIVE_START_DT', isSort: true },
              { label: '到期日期', prop: 'EFFECTIVE_END_DT', isSort: true },
              { label: '是否有效评级', prop: 'RATING_STATE', isSort: true },
              { label: '经办人', prop: 'USER_NUM', isSort: true },
              { label: '经办机构', prop: 'ORG_NUM', isSort: true }
            ]
          },
          buttons: [
            { label: '查看', funcName: 'findOne' }
          ]
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
        // alert('disableQueryForm' + this.disableQueryForm)
        // alert('disableQueryButton' + this.disableQueryButton)
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
