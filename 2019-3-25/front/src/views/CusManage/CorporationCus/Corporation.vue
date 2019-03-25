<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
  @doDelete="doDelete"  @rowDbclick="rowDbclick">
  </csc-single-table>
</template>
 <script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'

export default {
  data() {
    return {
      entity: {},
      pageDef: {
        // 查询条件定义
        queryDef: {
          columnNum: 3, // 一行几列
          queryCols: [
            { label: '客户名称', inputType: 'input', modelName: 'partyName' },
            { label: '统一社会信用代码', inputType: 'input', modelName: 'creditCode' },
            { label: '注册登记号码', inputType: 'input', modelName: 'registCode' },
            { label: '组织机构代码', inputType: 'input', modelName: 'orgCode' },
            { label: '中征码',inputType: 'input',modeleName:'middleCode'}
          ]
        },
        tabDef: {
          isSelect: false, // 是否可以多选
          isIndex: true, // 是否有序号
          // 表格字段定义
          tabCols: [
            { label: '客户名称', prop: 'partyName', isSort: true },
            { label: '区域类型', prop: 'districtType', isSort: true },
            { label: '客户类型', prop: 'mobile', isSort: true },
            { label: '注册登记号码', prop: 'email', isSort: true },
            { label: '统一社会信用代码', prop: 'creditCode', isSort: true },
            { label: '组织机构代码', prop: 'orgCode', isSort: true },
            { label: '中征码', prop: 'middleCode', isSort: true },
            { label: '是否授信客户', prop: 'isCreditCust', isSort: true },
            { label: '是否第三方客户', prop: 'isThirdCust', isSort: true },
            { label: '第三方客户类型', prop: 'thirdCType', isSort: true },
          ]
        },
        buttons: [
          { label: '新增', funcName: 'create',disabled:false },
          { label: '编辑', funcName: 'doEdit',disabled:false }
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
        this.entity = response.data;
        console.log("父组件到底执行没有3ResponseMsg:"+response.data.totalRec);
        this.$store.dispatch('setListLoading', false);
      }).catch((error) => {
        console.log(error)
      })
    },

    rowDbclick(row) {
      this.$router.push({ path: '/user/add/card/' + row.userId })
    },

    create() {
       this.$router.push({ path: '/corporationCus/corporationAdd' })
    },
    doEdit(row) {
      this.$router.push({ path: '/corporationCus/corpMessageList',query:{method:'doEdit'} })
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
//   import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
//  	export default {
 		
//  		data() {
//  			return {
//         entity: {},
//  				queryDef: {
//         columnNum: 3, // 一行几列
//           queryCols: [
//             { label: '客户名称', inputType: 'input', modelName: 'partyName' },
//             { label: '证件类型', inputType: 'input', modelName: 'certType' },
//             { label: '证件号码', inputType: 'input', modelName: 'certNum' },
//             { label: '中征码',inputType: 'input',modeleName:'middleCode'}
//           ]
//         }
//     	}
//  		},

//     components: { CscSingleTable },

//  		methods: {
 			
//       rowDbclick(row) {
//         this.$router.push({ path: '/Corporation' })
//       },

//       create() {
//         this.$router.push({ path: '/Corporation' })
//       },

//       doEdit(row) {
//         this.$router.push({ path: '/Corporation',query:{method:'doEdit'} })
//       },

//       doDelete(row, listQuery) {
//         deleteUser(row).then(response => {
//           this.userList(listQuery)
//           this.$message({
//             type: 'success',
//             message: '删除成功!'
//           })
//         })
//       }
//  		}
//  	}
	
 </script>