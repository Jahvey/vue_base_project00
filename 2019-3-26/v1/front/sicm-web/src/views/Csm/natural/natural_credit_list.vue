<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity" 
  @findOne="findOne"
  @pageQuery="doPageQuery"
  :disableQueryForm="disableQueryForm" 
  :disableRowButtons="disableRowButtons"
   >
  </csc-single-table>
</template>

<script>
  // 账户信息
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getNaturalCreditList } from '@/api/csm'// 正常往后台发送异步请求的类
 

  export default {
    name: 'natural_credit_list',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          // data: [
          //   {
          //     partyName: '杜尤于',
          //     infoSrc: '启信宝',
          //     queryDate: '2017-08-07',
          //     djkLxyqTimes: '无',
          //     djkLjyqTimes:'无',
          //     dkLxqxTimes: '无',
          //     dkLjqxTimes: '无',
          //     sxbjYqCondition:'无',


          //   }
          // ]
        },
        // disableQueryForm: true,
        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
          
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '记录来源', prop: 'infoSrc', isSort: true },
              { label: '查询日期', prop: 'queryDate', isSort: true }, // currency：货币
              { label: '贷记卡及准贷记卡连续逾期次数', prop: 'djkLxyqTimes', isSort: true },
              { label: '贷记卡及准贷记卡累计逾期次数', prop: 'djkLjyqTimes', isSort: true },
              { label: '贷款连续欠息次数', prop: 'dkLxqxTimes', isSort: true },
              { label: '贷款累计欠息次数', prop: 'dkLjqxTimes', isSort: true },
              { label: '授信本金逾期情况', prop: 'sxbjYqCondition', isSort: true },


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
      doPageQuery(listQuery) {
        getNaturalCreditList(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)

     
        }).catch((error) => {
    
          console.log(error)
        })
      },


      findOne() { // 重置表单就是直接清空表单里面的数据
        console.log('查询')
      }
    },

    mounted() {

     this.doPageQuery() 
  
    }

  }
</script>
