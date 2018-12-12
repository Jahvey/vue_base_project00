<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity" 
  @findOne="findOne"
  :disableQueryForm="disableQueryForm" 
  :disableRowButtons="disableRowButtons"            
   @contractList="contractList"   >
  </csc-single-table>
</template>

<script>
  // 账户信息
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getContractList } from '@/api/contract'// 正常往后台发送异步请求的类
 

  export default {
    name: 'natural_business',
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          data: [
            {
              dealproj: '科学养猪',
              dealbrand: '科学养猪',
              licetype: '身份证',
              comedate: '2017-8-9',
              liceid:'jj237297328',
              liceaddr: '四川大学',
              dealscope: '科学养猪，科学种植，科学喂养',
              dealaddr:'成都市高新区孵化园',
              dealaddrkind:'个体工商户',
              yearamt:'200,000.00',
              empnum:'50',
              lastchanperson:'王豪',
              lastchandate:'2018-07-09',
              monthavesell:'35,000.00',
              monthavecost:'12,000.00'

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
             // { label: '选择', prop: 'checkcolumn', isSort: true },
              { label: '经营项目', prop: 'dealproj', isSort: true },
              { label: '经营字号', prop: 'dealbrand', isSort: true },
              { label: '注册类型', prop: 'licetype', isSort: true }, // currency：货币
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
         console.log('doPageQuery...')
      },

      contractList(listQuery) {
        const params = {
          listQuery: this.listQuery
        }

        this.listLoading = true
        console.log('listQuery ....' + listQuery)
        getContractList(params).then(response => {
          this.entity = response
          console.log(" response.data.entity"+ response.data.entity)
          this.listLoading = false
        }).catch((error) => {
         
          console.log(error)
        })
      },
      findOne() { // 重置表单就是直接清空表单里面的数据
        alert('查询')
      }
    },

    mounted() {

      this.contractList() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
