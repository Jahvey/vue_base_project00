<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
  </csc-single-table>
</template>

<script>
    import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
    import {queryGuarAccount} from '@/api/Ledger'
    export default {
        name: "guar-company-manage-account",
      data() {
        return {
          entity: {
          },
          disableRowButtons:true,
          pageDef: {
            // 查询条件定义
            queryDef: {
              columnNum: 2, // 一行几列
              queryCols: [
                { label: '机构名称', inputType: 'input', modelName: 'orgNum' },
                { label: '客户名称', inputType: 'input', modelName: 'partyName' }
              ]
            },
            tabDef: {
              isSelect: false, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '客户名称', prop: 'partyName', isSort: true },
                { label: '授信总额', prop: 'creditAmount', isSort: true },
                { label: '单户总额', prop: 'simpleAmount', isSort: true },
                { label: '可用余额', prop: 'avalibleamt', isSort: true },
                { label: '合作状态', prop: 'creditStatus', isSort: true },
                { label: '额度起始日', prop: 'beginDate', isSort: true },
                { label: '额度到期日', prop: 'endDate', isSort: true },
                { label: '保证金存储方式', prop: 'accnoWay', isSort: true , isFormat:true,enumType:'accnoWay'},
                { label: '性质', prop: 'creditType', isSort: true },
                { label: '责任分担比例%', prop: 'creditApport', isSort: true },
                { label: '内部评级', prop: 'innerCret', isSort: true },
                { label: '经办机构', prop: 'orgNum', isSort: true },
                { label: '经办人', prop: 'userNum', isSort: true }
              ],
            }

          }
        }
      },
      components: { CscSingleTable },

      methods: {
        doPageQuery(listQuery) {
          this.queryGuarAccount(listQuery)
        },

        queryGuarAccount(listQuery) {
          queryGuarAccount(listQuery).then(response => {
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }).catch((error) => {
            console.log(error)
          })
        },

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
