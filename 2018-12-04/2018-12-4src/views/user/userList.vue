<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
  @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>
</template>

<script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import { getUserList, deleteUser } from '@/api/user'

export default {
  data() {
    return {
      entity: {},
      pageDef: {
        // 查询条件定义
        queryDef: {
          columnNum: 3, // 一行几列
          queryCols: [
            { label: 'ID', inputType: 'input', modelName: 'id' },
            { label: '姓名', inputType: 'input', modelName: 'name' },
            { label: '机构号', inputType: 'input', modelName: 'orgid' }
          ]
        },
        tabDef: {
          isSelect: false, // 是否可以多选
          isIndex: true, // 是否有序号
          // 表格字段定义
          tabCols: [
            { label: '用户编号', prop: 'ID', isSort: true },
            { label: '姓名', prop: 'NAME', isSort: true },
            { label: '机构号', prop: 'ORGID', isSort: true },
            { label: '机构名称', prop: 'ORGNAME', isSort: true },
            { label: '更新日期', prop: 'UPDATE_DATE', isSort: true }
          ]
        },
        buttons: [
          { label: '新增', funcName: 'create', disabled: false },
          { label: '修改', funcName: 'doEdit', disabled: false },
          { label: '删除', funcName: 'delete', disabled: true }
        ]
      }
    }
  },
  components: { CscSingleTable },

  methods: {
    doPageQuery(listQuery) {
      console.log('user listQuery...' + listQuery)
      getUserList(listQuery).then(response => {
        this.entity = response
        console.log('response ....' + response)
      }).catch((error) => {
        console.log(error)
      })
    },

    rowDbclick(row) {
      this.$router.push({ path: '/user/userList' })
    },

    create() {
      this.$router.push({ path: '/user/userAdd' })
    },

    doEdit(row) {
      this.$router.push({ path: '/user/userEdit', query: { method: 'doEdit' }})
    },

    doDelete(row, listQuery) {
      deleteUser(row).then(response => {
        this.userList(listQuery)
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      })
    }
  }
}

</script>
