<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm" @findOne="findOne"
       :disableRowButtons="disableRowButtons"             @contractList="contractList"       >
  </csc-single-table>
</template>

<script>
  // 信用信息，非常重要
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
              partyName: '军育苗',
              infoSrc: ' 启信宝',
              queryDate: '2018-07-24',
              djkLxyqTimes: '无',
              djkLjljTimes: '无',
              dkLxqxTimes: '无',
              dkLjqxTimes: '无',
              sxbjYqCondition: '无'
            }
          ]
        },
        // disableQueryForm: true,credit rating
        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '记录来源', prop: 'infoSrc', isSort: true }, // currency：货币
              { label: '查询日期', prop: 'queryDate', isSort: true },
              { label: '贷记卡及准贷记卡连续逾期次数', prop: 'djkLxyqTimes', isSort: true },
              { label: '贷记卡及准贷记卡累计逾期次数', prop: 'djkLjljTimes', isSort: true },
              { label: '贷款连续欠息次数', prop: 'dkLxqxTimes', isSort: true },
              { label: '贷款累计欠息次数', prop: 'dkLjqxTimes', isSort: true },
              { label: '授信本金逾期情况', prop: 'sxbjYqCondition', isSort: true }
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
