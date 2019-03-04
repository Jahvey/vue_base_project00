<template>
 <div>
  <csc-single-table :pageDef="pageDef" @pageQuery="doPageQuery">

  </csc-single-table>
 </div>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryWorkedList} from '@/api/mywork'
    export default {
        name: "workedlist",
        data() {
          return {
            pageDef: {

              queryDef: {
                columnNum: 2,
                queryCols: [
                  {label: '客户名称',inputType: 'input',modelName: 'cusName'},
                  {label: '发起机构',inputType: 'input',modelName: 'orgid'},
                  {label: '发起人',inputType: 'input',modelName: 'createUserName'},
                  {label: '业务类型',inputType: 'input',modelName: 'processDefName'},
                  {label: '流程状态',inputType: 'input',modelName: 'processStatus'},
                  {label: '创建时间',inputType: 'dateRange',modelName: 'startDate'}
                ]
              },
              tabDef: {

                tabCols: [
                  {label: '流程编号', prop: 'processInstId'},
                  {label: '客户名称', prop: 'cusName'},
                  {label: '流程实例名称',prop: 'processInstName'},
                  {label: '发起人',prop: 'wfCreateUserName'},
                  {label: '发起机构',prop: 'wfCreateOrgName'},
                  {label: '下一操作机构',prop: 'appointOrgOame'},
                  {label: '下一操作人',prop: 'appointUserName'},
                  {label: '创建时间',prop:'createTime'},
                  {label: '最近更新时间',prop: 'lastUpDateTime'},
                  {label: '流程状态',prop: 'wfReadStatus'},
                  {label: '操作',prop: 'op'}
                ]
              }
            }
          }
        },
        components:{CscSingleTable},
        beforeCreate: function(){

      },
        created: function () {

      },
        methods: {
          doPageQuery(){
            queryWorkedList(listQuery).then(response => {
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
