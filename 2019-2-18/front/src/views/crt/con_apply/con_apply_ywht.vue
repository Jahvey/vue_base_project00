<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"  
  @create="create" 
@pageQuery="doPageQuery" 
@doDelete="doDelete"
  :disableQueryForm="disableQueryForm" 
  :disableRowButtons="disableRowButtons" 
  >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { createConInfo,getApproveAndSxxy } from '@/api/csm'



  export default {
    data() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {

        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [
              { label: '业务编号', inputType: 'input', modelName: 'bizNum' }
          
            ]
          },
          tabDef: {
            isCheckRadio:true,
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [

              
              { label: '业务编号', prop: 'bizNum', isSort: true},
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '业务性质', prop: 'creditMode', isSort: true,isFormat:true,enumType:'creditMode' },
              { label: '业务类型', prop: 'bizHappenType', isSort: true },
              { label: '币种', prop: 'currencyCd', isSort: true ,isFormat:true,enumType:'currencyCd'},
              { label: '业务额度', prop: 'detailAmt', isSort: true },

              { label: '可用金额(元)', prop: 'boUse', isSort: true },
              { label: '起始日期', prop: 'validDate', isSort: true }


            ]
          },
          buttons: [
    
            { label: '合同创建', funcName: 'create' },
   
            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题
    created(){
      let param=this.$route.params
      console.log("页面跳转成功："+JSON.stringify(param))

    },

    methods: {

      doPageQuery(listQuery) {

        getApproveAndSxxy(listQuery).then(response => {
          this.entity = response.data
          //console.log("[getApproveAndSxxy]"+JSON.stringify(this.entity))
          this.$store.dispatch('setListLoading', false)

        }).catch((error) => {
    
          console.log(error)
        })
      },
      // 行事件
      doEdit(row) {
        console.log('row ....')
      //  this.$router.push({path: '/contract/add/edit/' + row.contractId})
      },
     
      create(row) { 
       console.log('[con_apply_ywht] create合同...'+JSON.stringify(row))
       createConInfo(row).then(response1 => {
          this.entity = response1.data
          console.log("合同创建成功！！[ConInfo] "+JSON.stringify(this.entity))
        

        }).catch((error) => {
    
          console.log(error)
        })



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
    mounted() {				
      this.doPageQuery() // 这个方法是调用上面的方法从后台获取数据，会发送异步请求
  }

  }
</script>
