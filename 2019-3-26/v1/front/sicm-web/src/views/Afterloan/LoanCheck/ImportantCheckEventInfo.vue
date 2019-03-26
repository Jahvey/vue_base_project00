<template>
  <csc-single-table
    :disableRowButtons='disableRowButtons'
    :disableQueryForm='disableQueryForm'
    :pageDef="pageDef"
    :entity="entity"
    @pageQuery="doPageQuery"
    >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
 /* import {queryImportantCheck} from '@/api/Afterloan'*/
    export default {
        name: "ImportantCheckEventInfo",

      data() {
        return {
          disableRowButtons: true,
          disableQueryForm:true,
          entity: {
          },
          pageDef: {
            // 查询条件定义
            queryDef: {},
            tabDef: {
              isSelect: false, // 是否可以多选
              isCheckRadio:true,//是否单选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '事件类型', prop: 'eventTypeCd', isSort: true,isFormat:true,enumType:'eventTypeCd' },
                { label: '发生日期', prop: 'happenDate', isSort: true },
                { label: '事件描述及原因', prop: 'eventState', isSort: true },
              ]
            },
          }
        }
      },
      components: { CscSingleTable},

      methods: {
        doPageQuery(listQuery) {
          this.queryImportantCheck(listQuery)
        },

        queryImportantCheck(listQuery) {
          queryImportantCheck(listQuery).then(response => {
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }).catch((error) => {
            console.log(error)
          })
        },


      },


    }
</script>

<style scoped>

</style>
