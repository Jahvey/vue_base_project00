<template>

 <div>
 <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery">

 </csc-single-table>
 </div>

</template>

<script>
  import {queryWorkingList} from '@/api/mywork'
    export default {
        name: "workinglist",
      data() {
          return {
            entity:{},
            pageDef:{

              queryDef: {
                columnNum: 2,
                queryCols: [
                  {label: '客户名称',inputType: 'input',modelName: 'custName'},
                  {label: '创建时间',inputType: 'dateRange',modelName: 'startDate'},
                  {label: '业务类型',inputType: 'input',modelName: 'flowTypeCd'}
                ]
              },
              tabDef: {
                tabCols: [
                  {label: '流程编号', prop: 'processInstId'},
                  {label: '客户名称', prop: 'cusName'},
                  {label: '流程实例名称',prop: 'processInstName'},
                  {label: '业务类型',prop: 'bizHappenType'},
                  {label: '客户行业',prop: ''},
                  {label: '产品类型',prop: 'productName'},
                  {label: '发起人',prop: 'wfCreateUserName'},
                  {label: '发起机构',prop: 'wfCreateOrgName'},
                  {label: '创建时间',prop:'createTime'},
                  {label: '当前活动',prop: 'activityInstName'},
                  {label: '阅读标志',prop: 'wfReadStatus'},
                  {label: '操作',prop: 'op'}
                ]
              }
            }
          }
      },
      components: {},
      beforeCreate: function(){

      },
      created: function(){

      },
      methods: {
        doPageQuery(){

          queryWorkingList(listQuery).then(response => {
            console.log("父组件到底执行没有1ResponseMsg:"+response.data.total);

            this.entity = response.data;//如果定义的是返回responsemsg 这里response.data  就是
            console.log("父组件到底执行没有3ResponseMsg:"+response.data.totalRec);
            this.$store.dispatch('setListLoading', false);
          }).catch((error) => {
            console.log(error)
          })

        }

      }
    }
</script>

<style scoped>

</style>
