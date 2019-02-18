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

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' 
  import { getRelativePsnList } from '@/api/csm'
 

  export default {
    name: 'natural_relative_list',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          // data: [
          //   {
          //     partyName: '呵呵哒',
          //     partyTypeCd: '科学养猪',
          //     certType: '身份证',
          //     certNum: 'jj237297328',
          //     appellation:'xxxxxxx',
          //     partnerCompany: '四川大学333',
          //     partnerPhoneNum: '729385022',
          //     remark:'xxxxx.yyyyyy'

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
             // { label: '选择', prop: 'checkcolumn', isSort: true },
              { label: '关系人名称', prop: 'partyName', isSort: true },
              { label: '客户类型', prop: 'partyTypeCd', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true }, // currency：货币
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '关联关系', prop: 'appellation', isSort: true },
              { label: '工作单位', prop: 'partnerCompany', isSort: true },
              { label: '联系电话', prop: 'partnerPhoneNum', isSort: true },
              { label: '备注', prop: 'remark', isSort: true }
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
        getRelativePsnList(listQuery).then(response => {
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
