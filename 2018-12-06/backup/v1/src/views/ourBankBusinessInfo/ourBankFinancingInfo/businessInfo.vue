<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm" @findOne="findOne"
       :disableRowButtons="disableRowButtons"             @contractList="contractList"       >
  </csc-single-table>
</template>

<script>
  // 本行业务信息
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getContractList } from '@/api/contract'// 正常往后+台发送异步请求的类
  //  import { getContractList } from '@/api/api'//api是自己写的用来测试mock假数据的路径，配置了这个之后mock会拦截正常请求

  export default {
    // name: 'mortgageContract',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              contractNum: 'HT070020180906015681',
              productType: '快帮贷',
              currencyCd: '人民币',
              contractAmt: '10,000.00',
              conYuE: '0.00',
              beginDate: '2018-09-06',
              endDate: '2019-09-05',
              // bzjje: '0',
              yqts: '0',
              jjyqbj: '0.00',
              arrearItr: '0.00',
              clsResult: '正常1',
              orgNum: '0700',
              userNum: '李谭荔'
            },
            {
              contractNum: 'HT120020180725014694',
              productType: '快捷贷',
              currencyCd: '人民币',
              contractAmt: '300,000.00',
              conYuE: '300,000.00',
              beginDate: '2018-07-25',
              endDate: '2019-07-25',
              // bzjje: '0',
              yqts: '16',
              jjyqbj: '0.00',
              arrearItr: '78.11',
              clsResult: '正常3',
              orgNum: '1200',
              userNum: '胥弋梅'
            }
          ]
        },
        // disableQueryForm: true,credit
        pageDef: {
          // 查询条件定义
          queryDef: {},
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '业务品种', prop: 'productType', isSort: true }, // currency：货币
              { label: '币种', prop: 'currencyCd', isSort: true },
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '合同已用金额', prop: 'conYuE', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '逾期天数', prop: 'yqts', isSort: true },
              { label: '逾期本金', prop: 'jjyqbj', isSort: true },
              { label: '逾期利息', prop: 'arrearItr', isSort: true },
              { label: '分类', prop: 'clsResult', isSort: true },
              { label: '经办机构', prop: 'orgNum', isSort: true },
              { label: '经办人', prop: 'userNum', isSort: true }
            ]
          }
        }
      }
    },

    components: { CscSingleTable },
    methods: {
      doPageQuery() {
        // this.contractList(listQuery)
        // console.log('doPageQuery...')
      },

      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

        this.listLoading = true
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
      findOne() { // 重置表单就是直接清空表单里面的数据
        alert('查询')
      }
    },
    computed: { // 计算属性
      disabled() { // 控制页面渲染
        // return this.disableQueryForm = true
      }

    },
    mounted() {
      // disableQueryForm() {
      //   console.log('emit disableQueryForm.....')
      //   return this.disableQueryForm
      // },
      this.contractList() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
