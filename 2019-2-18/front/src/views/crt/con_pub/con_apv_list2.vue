<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
       :disableRowButtons="disableRowButtons"             @contractList="contractList"            >
  </csc-single-table>
</template>

<script>
  // 内部银团合同
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { getContractList } from '@/api/contract'// 正常往后台发送异步请求的类，这个内部银团合同没写
  //  import { getContractList } from '@/api/api'//api是自己写的用来测试mock假数据的路径，配置了这个之后mock会拦截正常请求

  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    name: 'innerContract',
    data() {
      return {
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {
          data: [
            {
              contractNum: '合同编号130',
              partyName: '张家辉',
              certType: '居民身份证',
              certNum: 511103189702041672,
              productType: '商业贷款',
              beginDate: '1998-12-1',
              endDate: '2003-07-02',
              currencyCd: '人民币',
              contractAmt: '12301.97',
              jjye: '9982.11'
            },
            {
              contractNum: '合同编号131',
              partyName: '古田勒',
              certType: '居民身份证',
              certNum: '511103199708096732',
              productType: '工业贷款',
              beginDate: '2008-12-1',
              endDate: '2012-01-22',
              currencyCd: '人民币',
              contractAmt: '18729.97',
              jjye: '12137.11'
            }
          ]
        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' },
              { label: '合同状态', inputType: 'select', modelName: 'status' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true },
              { label: '承诺金额', prop: 'contractAmt', isSort: true },
              { label: '已出账金额金额', prop: 'jjye', isSort: true }
            ]
          },
          buttons: [
            { label: '新增', funcName: 'create' },
            { label: '重置', funcName: 'clearFrom' }]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery() {
        // this.contractList(listQuery)
        // console.log('doPageQuery...')
      },

      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

        // const entity={
        //   contractNum:'1234'
        // }
        this.listLoading = true

        // console.log(entity.contractNum)
        console.log('listQuery ....' + listQuery)
        getContractList(params).then(response => {
          this.entity = response
          // console.log(" response.data.entity"+ response.data.entity)
          this.listLoading = false
        }).catch((error) => {
          // alert(error)
          console.log(error)
        })
      },
      // 行事件
      doEdit(row) {
        // console.log('row ....')
        //  this.$router.push({path: '/contract/add/edit/' + row.contractId})
      },
      create() {
        alert('我是心脏按钮')
        // this.$router.push({path: '/contract/contractAdd'})
      },
      clearFrom() { // 重置表单就是直接清空表单里面的数据，这个重置按钮不得行
        alert('重置按钮')
      },
      doDelete() {
        // deleteContract(row).then(response => {
        //   this.contractList(listQuery)
        //   this.$message({
        //     type: 'success',
        //     message: '删除成功!'
        //   })
        // })
        console.log('del ....')
      }
    },
    mounted() {				// 骑马的，安装好的
      this.contractList() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
