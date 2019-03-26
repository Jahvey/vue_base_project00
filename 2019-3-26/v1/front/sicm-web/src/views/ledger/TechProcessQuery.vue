<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>

</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryTechProcess} from '@/api/Ledger'

  export default {
    name: "techProcessQuery",
    data() {
      return {
        entity: {},
        disableRowButtons:true,
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'cusName' },
              { label: '发起机构', inputType: 'input', modelName: 'createOrgNum' },
              { label: '发起人', inputType: 'input', modelName: 'createUserName' },
              { label: '业务类型', inputType: 'select', modelName: 'bizType',enumType:'bizType' },
              { label: '创建时间', inputType: 'date', modelName: 'createTime'}
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: false, // 是否有序号
            disableRowButtons:false,
            // 表格字段定义
            tabCols: [
              { label: '流程编号', prop: 'processId', isSort: true },
              { label: '客户名称', prop: 'cusName', isSort: true },
              { label: '发起机构', prop: 'createOrgNum', isSort: true },
              { label: '发起人', prop: 'createUserName', isSort: true},
              { label: '创建时间', prop: 'createTime', isSort: true },
              { label: '最近更新时间', prop: 'lastUpdateTime', isSort: true },
              { label: '流程状态', prop: 'processStatus', isSort: true, isFormat: true,enumType:'processStatus' },
              { label: '操作', prop: '详情', isSort: true }
            ],
          }
        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryTechProcess(listQuery)
      },

      queryTechProcess(listQuery) {
        queryTechProcess(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      }

      // rowDbclick(row) {
      //   this.$router.push({ path: '/user/add/card/' + row.userId })
      // },
      //
      // create() {
      //   this.$router.push({ path: '/user/add' })
      // },
      // doEdit(row) {
      //   this.$router.push({ path: '/user/add/edit/' + row.userId })
      // },
      // doDelete(row, listQuery) {
      //   deleteUser(row).then(response => {
      //     this.userList(listQuery)
      //     this.$message({
      //       type: 'success',
      //       message: '删除成功!'
      //     })
      //   })
      // }
    }

  }
</script>

<style scoped>

</style>
