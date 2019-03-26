<template>
  <mycsc-single-table
    :pageDef="pageDef"
    :entity="entity"
    @pageQuery="doPageQuery"
  >
  </mycsc-single-table>
</template>

<script>
  /*import MyCscSingleTable from '@/components/CscSingleTable/MyCscSingleTable'
  import { queryGradeInfo } from '@/api/grade'*/
  export default {
    data() {
      return {
        listLoading: false,
        entity: {},
        pageDef: {
          queryDef: {
            columnNum: 2,
            queryRules:{
              certType:[
                { required: true, message: '请选择证件类型', trigger: 'blur' }
              ]
            },
            queryCols: [
              { label: '客户编号', inputType: 'input', modelName: 'partyId' },
              { label: '客户名称 ', inputType: 'input', modelName: 'partyName' },
              { label: '评级类型', inputType: 'select', modelName: 'certType',enumType:'rating_type' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'partyName', isSort: true},
              { label: '评级日期', prop: 'ratingDt', isSort: true},
              { label: '评级类型', prop: 'ratingType', isSort: true },
              { label: '信用等级', prop: 'creditRatingCd', isSort: true },
              { label: '起始日期', prop: 'effectiveStartDt', isSort: true },
              { label: '到期日期', prop: 'effectiveEndDt', isSort: true },
              { label: '是否有效评级', prop: 'ratingState', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true }
            ]
          },
          buttons: []
        }
      }
    },
    /*components: {MyCscSingleTable},*/
    methods: {
      doPageQuery(listQuery) {
        queryGradeInfo(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      }
    },
    mounted() {
      this.doPageQuery()
    }
  }
</script>
