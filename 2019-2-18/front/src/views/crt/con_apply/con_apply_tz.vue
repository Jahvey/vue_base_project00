<template>
  <csc-single-table 
  :pageDef="pageDef" 
  :entity="entity"
  @view="view"     
  @create="create" 
  @disab="disab" 
  @update="update" 
@pageQuery="doPageQuery" 
@doEdit="doEdit"
@doDelete="doDelete"
  :disableQueryForm="disableQueryForm" 
  :disableRowButtons="disableRowButtons" 
  >
  </csc-single-table>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import { getApproveCons,MainConConractUpdateValidate,updateValidateForCon,disabValidateForCon,tzContractInfo,
  getConInfoBizType } from '@/api/csm'


  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    data() {
      return {
        disableQueryForm: true, // 父组件给的新的值，隐藏form表单按钮
        disableRowButtons: true, // 隐藏tab表单按钮
        listLoading: false,
        entity: {// 这个就相当于一个form表单，在这里定义之后可以直接在上面去使用 entity.属性名

        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 2, // 一行几列
            queryCols: [
              { label: '主合同编号', inputType: 'input', modelName: 'contractNum' },
             // { label: '合同状态', inputType: 'hidden',modelName:'conStatus',inputValue:'03'},

            ]
          },
          tabDef: {
            isCheckRadio:true,
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
          
              
              { label: '合同性质', prop: 'creditMode', isSort: true,isFormat:true,enumType:'creditMode' },
              { label: '合同编号', prop: 'contractNum', isSort: true,isLink: true,url:'/crt/con_info/con_info_ht_xw',param:["contractNum","conStatus"]  },
              { label: '合同品种', prop: 'productType', isSort: true,isFormat:true,enumType:'productType' },
              { label: '币种', prop: 'currencyCd', isSort: true ,isFormat:true,enumType:'currencyCd'},
              { label: '合同金额', prop: 'contractAmt', isSort: true },

              { label: '可用金额(元)', prop: 'conBalance', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true }


            ]
          },
          buttons: [
            { label: '查看', funcName: 'view' },
            { label: '合同创建', funcName: 'create' },
            { label: '调整', funcName: 'update' },
            { label: '合同失效', funcName: 'disab' },
            ]
        }
      }
    },

    components: { CscSingleTable }, // 这个没有问题

    methods: {

      doPageQuery(listQuery) {

        getApproveCons(listQuery).then(response => {
          this.entity = response.data
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
      view(row) {
        console.log('view 合同...')

        if(0==row.length){
          alert("请选择一笔生效合同。")
          return false
        }

        MainConConractUpdateValidate(row).then(response=>{
          this.entity=response.data
          console.log("response data...."+this.entity)

        }
          ).catch((e)=>{
            console.log(e)
          })
        // this.$router.push({path: '/contract/contractAdd'})
      },


      create(row) { 
       console.log('create合同...'+JSON.stringify(row))
       if(0==row.length){
        alert("请选择一笔生效合同。")
        return false
       }


       this.$router.push({name: '业务合同列表',params:{partyId:row.partyId,type:'02' }}) 
      },


      update(row) { 
       console.log('update合同...')
       if(0==row.length){
        alert("请选择一笔生效合同。")
        return false
       }

       let params={param:row.contractId,name:"XFE_0004"}
         updateValidateForCon(params).then(response=>{
          let res=response.data
          console.log("XFE_0004:res "+JSON.stringify(res))
          if(res!=0){
            alert("该合同已被纳入[移交申请],在业务结束前无法处理")
            return false
          }

         }).catch((error)=>{
          console.log(error)
         })

       //综合授信协议存在在途的调整不允许重复调整
       if(row.bizType=="综合授信协议"){  //TODO 这里的方法根本没有调用 2019-2-14
        //
        params={param:row.applyId,name:"RCON_0024"}
               updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0024:res "+JSON.stringify(res))
                if(res!=0){
                  alert("有在途综合授信协议")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

        //存在在途综合授信调整或单笔批复调整时不得调整综合授信协议
        params={param:row.applyId,name:"RCON_0058"}
               updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0058:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RCON_0058]有在途批复调整时不能调整综合授信协议")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })
        //存在在途合同调整
        params={param:row.applyId,name:"RCON_0059"}
               updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0059:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RCON_0059]有在途合同申请或调整时不能调整综合授信协议")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })


       }else{//单笔
        //合同在途调整校验
        params={param:row.amountDetailId,name:"RCON_0026"}
               updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0026:res "+JSON.stringify(res))
                if(res!=0){
                  alert("有在途合同申请")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

               //存在在途综合授信协议协议调整
        params={param:row.contractId,name:"RCON_0060"}
                updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0060:res "+JSON.stringify(res))
                if(res!=0){
                  alert("有在途综合授信协议申请或调整时不能调整合同")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })
               //存在在途综合授信调整或单笔批复调整时不得调整业务合同
        params={param:row.contractId,name:"RCON_0039"}
                updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0039:res "+JSON.stringify(res))
                if(res!=0){
                  alert("存在在途综合授信调整或单笔批复调整")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })
              //存在在途出账不得调整业务合同
        params={param:row.contractId,name:"RCON_0040"}
                updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0040:res "+JSON.stringify(res))
                if(res!=0){
                  alert("存在在途出账")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

       }


       //规则校验：冻结批复不能调整
        params={param:row.applyId,name:"RBIZ_0024"}
                updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RBIZ_0024:res "+JSON.stringify(res))
                if(res!=0){
                  alert("批复已冻结")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

        //合同下有担保合同调整在途
        params={param:row.contractId,name:"RGRT_0005"}
                updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RGRT_0005:res "+JSON.stringify(res))
                if(res!=0){
                  alert("合同下有在途的担保合同$[c]调整流程")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })
        //added by shendl合同下有在途的保证金追加
        params={param:row.contractId,name:"RGRT_0012"}
                updateValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RGRT_0012:res "+JSON.stringify(res))
                if(res!=0){
                  alert("该合同有在途的保证金追加")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

        params={contractId:row.contractId,bizType:row.bizType}

                tzContractInfo(params).then(response=>{
                  let res=response.data
                  console.log("[tzContractInfo]result is:"+JSON.stringify(res))
                  if(res.msg !=null){
                    alert(res.msg)
                    return false
                  }


                  this.$router.push({name: 'con_tree',
                    params:{contractId:res.conInfo.contractId,
                     contractType:"02",
                     amountDetailId:row.amountDetailId,
                     proFlag:"1",
                     processInstId:res.processInstId

                   }})

                }).catch((error)=>{
                  console.log(error)
                })




      },



      disab(row) { 
       console.log('disable 合同...')
       if(0==row.length){
        alert("请选择一笔生效合同。")
        return false
       }

       let params={}

       //综合授信协议不允许手工失效
       if(row.bizType=="综合授信协议"){
        alert("综合授信协议不允许手工失效！")
        return false

       }else{//单笔
        //合同有在途调整不允许手工失效
        params={param:row.amountDetailId,name:"RCON_0026"}
        disabValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0026:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RCON_0026]有在途合同申请")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

        //存在在途出账不得调整业务合同
        params={param:row.contractId,name:"RCON_0040"}
        disabValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0040:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RCON_0040]存在在途出账")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

        //存在未结清借据
        params={param:row.contractId,name:"RCON_0043"}
        disabValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RCON_0043:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RCON_0043]该笔合同下有未结清借据")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

       }

       //合同下有担保合同调整在途
       params={param:row.contractId,name:"RGRT_0005"}
        disabValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RGRT_0005:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RGRT_0005]合同下有在途的担保合同$[c]调整流程")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

       //合同下有在途的保证金追加
       params={param:row.contractId,name:"RGRT_0012"}
        disabValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RGRT_0012:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RGRT_0012]该合同有在途的保证金追加")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

        //新需求：合同下有临时出库的押品  不让做合同失效 
        params={param:row.contractId,name:"RGRT_0017"}
        disabValidateForCon(params).then(response=>{
                let res=response.data
                console.log("RGRT_0017:res "+JSON.stringify(res))
                if(res!=0){
                  alert("[RGRT_0017]该合同有临时出库的押品，不允许做合同失效")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

        getContractBizType(row.contractId,"2")


      },
      //获取业务性质
      getContractBizType(contractId, flag) {
        console.log("[getContractBizType]contractId="+contractId+",flag="+flag)
        let params={contractId:contractId}
        getConInfoBizType(params).then(response=>{
                let res=response.data
                console.log("获取业务性质: "+JSON.stringify(res))
                if(res.bizType!=null){
                  recounted(contractId, flag, res.bizType)
                }else{
                  alert("业务信息为空，合同失效操作失败！")
                  return false
                }

               }).catch((error)=>{
                console.log(error)
               })

      },
      recounted(contractId, flag, bizType) {
        


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
