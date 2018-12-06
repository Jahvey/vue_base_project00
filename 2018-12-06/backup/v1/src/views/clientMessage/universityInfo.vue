<template>
  <csc-single-table :pageDef="pageDef" :entity="entity" :disableQueryForm="disableQueryForm" @findOne="findOne"
       :disableRowButtons="disableRowButtons"             @contractList="contractList"       >
  </csc-single-table>
</template>

<script>
  // 大学信息
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
              collegename: '麻省理工学院',
              collegeaddr: '马萨诸塞州波士顿都市区剑桥市',
              institutename: '空气动力学',
              collegetype: '工学院',
              educsign: '未知',
              subjectname: '航空航天',
              graduateyear: '1932',
              lastchandate: '1933-06-23',
              lastchanperson: '马林·福多',
              areacode: '北美'
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
              { label: '高校名称', prop: 'collegename', isSort: true },
              { label: '高校地址', prop: 'collegeaddr', isSort: true }, // currency：货币
              { label: '院系名称', prop: 'institutename', isSort: true },
              { label: '院校类型', prop: 'collegetype', isSort: true },
              { label: '就读学位', prop: 'educsign', isSort: true },
              { label: '专业名称', prop: 'subjectname', isSort: true },
              { label: '毕业年分', prop: 'graduateyear', isSort: true },
              { label: '最后修改日期', prop: 'lastchandate', isSort: true },
              { label: '最后修改人', prop: 'lastchanperson', isSort: true },
              { label: '行政区划代码', prop: 'areacode', isSort: true }
            ]
          },
          buttons: [
            { label: '查看', funcName: 'findOne' }
          ]
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
