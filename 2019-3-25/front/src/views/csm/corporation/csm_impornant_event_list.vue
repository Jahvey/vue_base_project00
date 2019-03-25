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
  import { getCsmImpornantEventInfo } from '@/api/csm'
 

  export default {
    name: 'csm_impornant_event_list',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {
          // data: [
          //   {
          //     eventTypeCd: '紧急事件',
          //     happenDate: '2017-09-23',
          //     eventState: '身份证',

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
             // { label: '选择', prop: 'checkcolumn', isSort: true },
              { label: '事件类型', prop: 'eventTypeCd', isSort: true },
              { label: '发生日期', prop: 'happenDate', isSort: true },
              { label: '事件描述及原因', prop: 'eventState', isSort: true }

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
        getCsmImpornantEventInfo(listQuery).then(response => {
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
