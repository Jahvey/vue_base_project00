<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm" @findOne="findOne"
                    @contractList="contractList"       >
  </csc-single-table>
</template>

<script>
  // 从合同信息之抵押合同
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 这个是子组件
  import { getContractList } from '@/api/contract'// 正常往后台发送异步请求的类
  //  import { getContractList } from '@/api/api'//api是自己写的用来测试mock假数据的路径，配置了这个之后mock会拦截正常请求

  export default {
    data: function() {
      return {
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              SUBCONTRACT_NUM: 'HT111063729',
              PARTY_NAME: '苟富贵',
              IF_TOP_SUBCON: '是',
              BZ: '人民币',
              SUBCONTRACT_AMT: 15000.00,
              SURETY_AMT: 14000.00,
              OPERATION_TYPE: '填什么？'
            }
          ]
        },
        // disableQueryForm: true,
        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '抵押合同编号', prop: 'SUBCONTRACT_NUM', isSort: true },
              { label: '抵押人名称', prop: 'PARTY_NAME', isSort: true },
              { label: '是否最高额', prop: 'IF_TOP_SUBCON', isSort: true },
              { label: '币种', prop: 'BZ', isSort: true },
              { label: '担保合同金额', prop: 'SUBCONTRACT_AMT', isSort: true },
              { label: '本次担保金额', prop: 'SURETY_AMT', isSort: true }, // currency：货币
              { label: '操作类型标识', prop: 'OPERATION_TYPE', isSort: true }
            ]
          },
          buttons: [
            { label: '查看', funcName: 'findOne' }
          ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题
    // mounted()页面加载完毕之后进行的渲染
    // computed: {				// 页面加载完毕之后进行的渲染
    //   disableQueryForm() {
    //     return this.disableQueryForm
    //   }
    // },
    mounted: {
      disableQueryForm() {
        console.log('emit disableQueryForm.....')
        return this.disableQueryForm
      }

      // disableQueryForm: true
    },

    methods: {
      // disableQueryForm() {
      //   // disableQueryForm = true
      //   this.$emit('disableQueryForm', true) // 父子传参，把这个设置了的值传递给父组件
      //   console.log('emit disableQueryForm.....')
      // },

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
    computed: {
      disabled() { // 控制页面渲染
        // return this.disableQueryForm = true
      }

    },
    mounted() {				// 骑马的，安装好的
      this.contractList() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
