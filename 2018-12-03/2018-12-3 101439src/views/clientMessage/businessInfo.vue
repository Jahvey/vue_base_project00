<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm" @findOne="findOne"
       :disableRowButtons="disableRowButtons"             @contractList="contractList"       >
  </csc-single-table>
</template>

<script>
  // 经营信息
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
              dealproj: '超级挑战赛',
              dealbrand: '苏联老字号',
              licetype: '旅游',
              comedate: '1917-11-07',
              liceid: 'zz13325431',
              liceaddr: '卢比扬卡',
              dealscope: '社会主义建设',
              dealaddr: '西伯利亚伐木场',
              dealaddrkind: '国营',
              yearamt: '638229382',
              empnum: '500000',
              lastchanperson: '戈尔巴乔夫',
              lastchandate: '1991-12-25',
              monthavesell: '143221543',
              monthavecost: '1231412'
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
              { label: '经营项目', prop: 'dealproj', isSort: true },
              { label: '经营字号', prop: 'dealbrand', isSort: true }, // currency：货币
              { label: '注册类型', prop: 'licetype', isSort: true },
              { label: '成立日期', prop: 'comedate', isSort: true },
              { label: '营业执照号', prop: 'liceid', isSort: true },
              { label: '注册地址', prop: 'liceaddr', isSort: true },
              { label: '经营范围', prop: 'dealscope', isSort: true },
              { label: '经营场所', prop: 'dealaddr', isSort: true },
              { label: '经营场所性质', prop: 'dealaddrkind', isSort: true },
              { label: '年营业额', prop: 'yearamt', isSort: true },
              { label: '雇员人数', prop: 'empnum', isSort: true },
              { label: '最后修改人', prop: 'lastchanperson', isSort: true },
              { label: '最后修改日期', prop: 'lastchandate', isSort: true },
              { label: '月均销售额', prop: 'monthavesell', isSort: true },
              { label: '月均经营费用', prop: 'monthavecost', isSort: true }
            ]
          },
          buttons: [
            { label: '查看', funcName: 'findOne' }
          ]
        }
      }
    },

    components: { CscSingleTable }, // 引入的子组件
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
