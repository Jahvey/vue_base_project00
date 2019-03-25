<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity" 
  @findOne="findOne"
  @pageQuery="doPageQuery"
  :disableQueryButtons="disableQueryButtons" 
  :disableQueryForm="disableQueryForm" 
   >
  </csc-single-table>
</template>

<script>
  // 账户信息
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { getAdditiveList } from '@/api/csm'
 

  export default {
    name: 'natural_additive_list',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableQueryButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          // data: [
          //   {
          //     partyNum: '2017-09-23',
          //     partyName: '紧急事件',
          //     title: '中度紧急',
          //     detailInfo: '0'


          //   }
          // ]
        },

        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [

              { label: '客户编号', prop: 'partyNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '标题', prop: 'title', isSort: true },
              { label: '详情', prop: 'detailInfo', isSort: true }


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
        getAdditiveList(listQuery).then(response => {
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
