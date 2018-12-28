<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
  @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>
</template>

<script>
// import {getUserList,getUserListByPage} from "@/api/query"
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import { getUserList, deleteUser } from '@/api/user'

export default {
  data() {
    return {
      entity: {
        data:[
          {
            username:'123',
            personName:'wh',
          }

        ]

        
      },
      pageDef: {
        // 查询条件定义
        queryDef: {
          columnNum: 3, // 一行几列
          queryCols: [
            { label: '用户名', inputType: 'input', modelName: 'username' },
            { label: '姓名', inputType: 'input', modelName: 'personName' },
            { label: '手机号', inputType: 'input', modelName: 'mobile' }
          ]
        },
        tabDef: {
          isSelect: false, // 是否可以多选
          isIndex: true, // 是否有序号
          // 表格字段定义
          tabCols: [
            { label: '用户名', prop: 'username', isSort: true },
            { label: '姓名', prop: 'personName', isSort: true },
            { label: '手机号', prop: 'mobile', isSort: true },
            { label: '邮箱', prop: 'email', isSort: true },
            { label: '机构', prop: 'org', isSort: true }
          ]
        },
        buttons: [
          { label: '新增', funcName: 'create' },
          { label: '重置密码', funcName: 'resetPassword' }
        ]
      }
    }
  },

  components: { CscSingleTable },

  methods: {
    doPageQuery(listQuery) {
      this.userList(listQuery)
    },

    userList(listQuery) {
      getUserList(listQuery).then(response => {
        this.entity = response
      }).catch((error) => {
        console.log(error)
      })
    },

    rowDbclick(row) {
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
    }
  }
}
</script>
