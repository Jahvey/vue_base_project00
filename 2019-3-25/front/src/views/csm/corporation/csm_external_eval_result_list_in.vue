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
 
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' 
  import { getHisIrmByParty } from '@/api/csm'


  export default {
    name: 'csm_external_eval_result_list_in',  
    data: function() {
      return {

       // disableQueryButtons: true, 
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,

        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          // data: [
          //   {
          //     PARTY_NAME: 'wanghao',
          //     RATING_DT: '2018-07-24',
          //     RATING_TYPE: '商业贷款',
          //     CREDIT_RATING_CD: '良好',
          //     EFFECTIVE_START_DT: '2016-11-30',
          //     EFFECTIVE_END_DT: '2017-11-22',
          //     RATING_STATE: '非常有效',
          //     USER_NUM: '23333',
          //     ORG_NUM: 'AMD YES协会'
          //   }
          // ]
        },
        pageDef: {
          // 查询条件定义
          queryDef: { 
            columnNum: 2, // 一行几列
            queryCols: [
              { label: '客户编号', inputType: 'input', modelName: 'partyNum' },
              { label: '客户名称', inputType: 'input', modelName: 'partyName' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '评级日期', prop: 'ratingDt', isSort: true }, // currency：货币
              { label: '贷款性质', prop: 'ratingType', isSort: true },
              { label: '信用等级', prop: 'creditRatingCd', isSort: true },
              { label: '起始日期', prop: 'effectiveStartDt', isSort: true },
              { label: '到期日期', prop: 'effectiveEndDt', isSort: true },
              { label: '是否有效评级', prop: 'ratingState', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true }
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
      doPageQuery(listQuery) {
        getHisIrmByParty(listQuery).then(response => {
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
