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
  import { queryNaturalSchool } from '@/api/csm'// 正常往后台发送异步请求的类
 

  export default {
    name: 'natural_school',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          // data: [
          //   {
          //     collegename: '四川大学',
          //     collegeaddr: '四川成都',
          //     institutename: '云计算',
          //     collegetype: '全日制本科',
          //     educsign:'学士学位',
          //     subjectname: '大数据',
          //     graduateyear: '2016',
          //     lastchandate:'2017-8-9',
          //     lastchanperson:'wanghao',
          //     areacode:'027',

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
     
              { label: '高校名称', prop: 'collegename', isSort: true },
              { label: '高校地址', prop: 'collegeaddr', isSort: true },
              { label: '院系名称', prop: 'institutename', isSort: true }, // currency：货币
              { label: '院校类型', prop: 'collegetype', isSort: true },
              { label: '就读学位', prop: 'educsign', isSort: true },
              { label: '专业名称', prop: 'subjectname', isSort: true },
              { label: '毕业年份', prop: 'graduateyear', isSort: true },
              { label: '最后修改日期', prop: 'lastchandate', isSort: true },
              { label: '最后修改人', prop: 'lastchanperson', isSort: true },
              { label: '行政区划代码', prop: 'areacode', isSort: true }

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
        queryNaturalSchool(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)

     
        }).catch((error) => {
    
          console.log(error)
        })
      },

      findOne() { // 重置表单就是直接清空表单里面的数据
        alert('查询')
      }
    },

    mounted() {

      this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
