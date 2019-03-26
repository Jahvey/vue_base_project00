<template>
  <div>
    <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" :disableRowButtons="disableRowButtons">
    </csc-single-table>
    <el-button @click="open" type="primary">查看</el-button>
  </div>
  <!--<div>
    <el-button @click="open" type="primary">发起分类备案</el-button>
  </div>-->
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryHistoriyAdjustRecord} from '@/api/afterloan'
  export default {
    name: "HistoriyAdjustRecord",
    data() {
      return {
        entity: {},
        disableRowButtons:true,
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 4, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd'},
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum'}
            ]
          },
          tabDef: {
            isSelect: true, // 是否可以多选
            isIndex: false, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true, isFormat: true,enumType:'idTypeCd' },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '授信品种', prop: 'productType', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true, isFormat: true,enumType:'currencyCd'},
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '合同已用金额', prop: 'conYuE', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '分类结果', prop: 'clsResult', isSort: true, isFormat: true,enumType:'fljg'}
            ],
          }

        }
      }
    },
    components: { CscSingleTable },

    methods: {
      doPageQuery(listQuery) {
        this.queryHistoriyAdjustRecord(listQuery)
      },

      queryHistoriyAdjustRecord(listQuery) {
        queryHistoriyAdjustRecord(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },
      open(row){
        alert("请选择一条业务")
        if(row==undefined){
          alert("请选择一条业务")
        }
      }
      /*rowDbclick(row) {
        this.$router.push({ path: '/user/add/card/' + row.userId })
      },

      create() {
        this.$router.push({ path: '/user/add' })
      },
      doEdit(row) {
        this.$router.push({ path: '/user/add/edit/' + row.userId })
      },
      doDelete(row, listQuery) {
        deleteUser(row).then(response => {
          this.userList(listQuery)
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        })
      }*/
    }
  }
</script>

<style scoped>

</style>


