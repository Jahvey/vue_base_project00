<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons"
   :disableQueryButtons="disableQueryButtons">
  </csc-single-table>

</template>

<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryBwFixed} from '@/api/Ledger'

  export default {
    name: "fixedQueryBw",
    data() {
      return {
        entity: {},
        disableRowButtons:true,
        disableQueryButtons:true,
        pageDef: {
          // 查询条件定义
          queryDef: {
            /*columnNum: 4, // 一行几列
            queryCols: [
              //{label: '机构名称', inputType: 'input', modelName: 'orgNum' },
              // { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              // { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              // { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              // { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              // { label: '借据编号', inputType: 'input', modelName: 'summaryNum' },
              // { label: '还款日期', inputType: 'input', modelName: 'endDate' }
            ]*/
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: false, // 是否有序号
            disableRowButtons:false,
            // 表格字段定义
            tabCols: [
              { label: '机构', prop: 'orgName', isSort: true },
              { label: '正常',isHead: true,contents:[
                  {label: '户数',prop: 'zchs',isSort:true},
                  {label:'笔数',prop: 'zcbs',isSort:true},
                  {label:'余额',prop: 'zcye',isSort:true}
                ]},
              { label: '关注',isHead: true,contents:[
                  {label: '户数',prop: 'gzhs',isSort:true},
                  {label:'笔数',prop: 'gzbs',isSort:true},
                  {label:'垫款余额',prop: 'gzdk',isSort:true},
                  {label:'余额',prop: 'gzye',isSort:true}
                ]},
              { label: '次级',isHead: true,contents:[
                  {label: '户数',prop: 'cjhs',isSort:true},
                  {label:'笔数',prop: 'cjbs',isSort:true},
                  {label:'垫款余额',prop: 'cjdk',isSort:true},
                  {label:'余额',prop: 'cjye',isSort:true}
                ]},
              { label: '可疑',isHead: true,contents:[
                  {label: '户数',prop: 'kyhs',isSort:true},
                  {label:'笔数',prop: 'kybs',isSort:true},
                  {label:'垫款余额',prop: 'kydk',isSort:true},
                  {label:'余额',prop: 'kyye',isSort:true}
                ]},
              { label: '损失',isHead: true,contents:[
                  {label: '户数',prop: 'sshs',isSort:true},
                  {label:'笔数',prop: 'ssbs',isSort:true},
                  {label:'垫款余额',prop: 'ssdk',isSort:true},
                  {label:'余额',prop: 'ssye',isSort:true}
                ]},
              { label: '合计',isHead: true,contents:[
                  {label: '户数',prop: 'hjhs',isSort:true},
                  {label:'笔数',prop: 'hjbs',isSort:true},
                  {label:'垫款余额',prop: 'hjdk',isSort:true},
                  {label:'余额',prop: 'hjye',isSort:true}
                ]}
            ]
          }
        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryBwFixed(listQuery)
      },

      queryBwFixed(listQuery) {
        queryBwFixed(listQuery).then(response => {
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
