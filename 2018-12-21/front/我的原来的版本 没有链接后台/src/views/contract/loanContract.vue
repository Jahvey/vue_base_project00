<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
       @contractList="contractList"     @clearFrom="clearFrom"       >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { getContractList } from '@/api/contract'// 正常往后台发送异步请求的类
//  import { getContractList } from '@/api/api'//api是自己写的用来测试mock假数据的路径，配置了这个之后mock会拦截正常请求

  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    data() {
      return {
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              contractNum: '111',
              bizTypeFlag: '1',
              partyName: '你好',
              certType: '渣',
              certNum: 1234,
              productType: '贷款',
              beginDate: '1998-12-1',
              endDate: '2003-07-02',
              currencyCd: '人民币',
              contractAmt: '1789.97',
              conBalance: '123.11'
            },
            {
              contractNum: '112',
              bizTypeFlag: '1',
              partyName: '你好',
              certType: '渣',
              certNum: '1234',
              productType: '贷款',
              beginDate: '1998-12-1',
              endDate: '2002-01-22',
              currencyCd: '人民币',
              contractAmt: '1729.97',
              conBalance: '13.11'
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
              { label: '合同状态', inputType: 'select', modelName: 'status' },
              { label: '业务品种', inputType: 'select', modelName: 'productType' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '业务性质', prop: 'bizTypeFlag', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true },
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '合同可用金额', prop: 'conBalance', isSort: true }
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
        console.log('row ....')
      //  this.$router.push({path: '/contract/add/edit/' + row.contractId})
      },
      create() {
        console.log('create...')
        // this.$router.push({path: '/contract/contractAdd'})
      },
      clearFrom() { // 重置表单就是直接清空表单里面的数据
        alert('重置')
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
