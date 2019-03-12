<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity" 
  :disableQueryForm="disableQueryForm" 

:disableRowButtons="disableRowButtons"
@pageQuery="doPageQuery"
@addBtn="addBtn"
@importBtn="importBtn"
@findBtn="findBtn"
@editBtn="editBtn"
@deleteBtn="deleteBtn"

>
  </csc-single-table>
</template>

<script>
  // 从合同信息之抵押合同 http://192.168.1.105:7001/default/crt/con_grt/con_dy_list.jsp
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable' // 引入的这个是子组件，需要把父组件的值传递给子组件修改子组件
  import { getConGrtList } from '@/api/csm'


  export default {
    name: 'con_dy_list',//抵押合同列表
    data: function() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名
          // data: [
          //   {
          //     SUBCONTRACT_NUM: 'HT111063729',
          //     PARTY_NAME: '苟富贵',
          //     IF_TOP_SUBCON: '是',
          //     BZ: '人民币',
          //     SUBCONTRACT_AMT: 15000.00,
          //     SURETY_AMT: 14000.00,
          //     OPERATION_TYPE: '填什么？'
          //   }
          // ]
        },
        // disableQueryForm: true,
        pageDef: {
          // 查询条件定义
          queryDef: {},

          tabDef: {
            isCheckRadio:true,
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
            { label: '增加', funcName: 'addBtn' },
            { label: '引入', funcName: 'importBtn' },
            { label: '查看', funcName: 'findBtn' },
            { label: '编辑', funcName: 'editBtn' },
            { label: '删除', funcName: 'deleteBtn' }
          ]
        }
      }
    },

    components: { CscSingleTable }, // 引入的子组件


    methods: {
      doPageQuery(params) {
        console.log("[con_dy_list]")
       // params={pageSize:'20',pageNum:'1'}

        console.log(typeof(params))
        params.subcontractType="04"
        getConGrtList(params).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)

        }).catch((error) => {
          console.log(error)
        })

       //console.log("[con_dy_list]"+JSON.stringify(row))
      },



      addBtn(row){
        console.log("增加")
      },
      importBtn(row){
        console.log("引入")
      },
      findBtn(row){
        console.log("查看")
      },
     editBtn(row){
        console.log("编辑")
      },

      deleteBtn(row){
        console.log("删除")
      },



    },
    computed: { // 计算属性


    },
    mounted() {

      this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
    }

  }
</script>
