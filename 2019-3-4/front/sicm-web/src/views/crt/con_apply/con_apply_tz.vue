<template>
  <div> 
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

<!--
  <el-button type="text" @click="dialog1Visible = true">点击打开 Dialog</el-button>
-->
<!--
  <el-dialog
  title="合同失效提示"
  :visible.sync="dialog1Visible"
  width="30%"
  :before-close="handleClose"

  >
  <span>{{msgContents}}</span>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialog1Visible = false">取 消</el-button>
    <el-button type="primary" @click="dialog1Visible = false">确 定</el-button>
  </span>
</el-dialog>
-->

<!--conTree-->

  <conTree :paramsInfo="paramsInfo" v-if="paramsInfo.conTreeVisiable" ></conTree>


  </div>
  
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import conTree from '@/views/csm/con_info/con_tree'
  import { getApproveCons,MainConConractUpdateValidate,updateValidateForCon,disabValidateForCon,tzContractInfo,
  getConInfoBizType,disConInfo,disConSynColl} from '@/api/csm'


  // 合同模块也是需要引入用户的，以后需要根据用户查询对应的合同（高级查询）

  export default {
    data() {
      return {
        paramsInfo:{//使用父子传参的方式传递参数，父组件向子组件传递多个参数
          conTreeVisiable:false
        },
        
        partyId:'partyIdxxxxx',//这个id是从session中取到的
        confirmDisab:false, //是否执行下面的流程操作
        msgContents:'', //合同失效提示对话框 内容
        dialog1Visible: false,
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

    components: { 

    CscSingleTable,
    conTree

     }, // 这个没有问题

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
        this.paramsInfo={

         conTreeVisiable:true,
         contractId:row.contractId,
         contractType:'02',
         proFlag:'-1'
        }

        // MainConConractUpdateValidate(row).then(response=>{
        //   this.entity=response.data
        //   console.log("response data...."+this.entity)

        // }
          // ).catch((e)=>{
          //   console.log(e)
          // })
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

       // var vaildateFlag=true
       let rowData=row
       updateValidateForCon(row).then(response=>{
          let res=response.data
          let vaildateFlag=true
          console.log("dataMap is "+JSON.stringify(res))
          //XFE_0004
          if(res.XFE_0004!=0){
            alert("[XFE_0004]该合同已被纳入[移交申请],在业务结束前无法处理")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

        //综合授信协议存在在途的调整不允许重复调整
       if(rowData.bizType=="综合授信协议"){  //TODO 这里的方法根本没有调用 2019-2-14
        //RCON_0024
          if(res.RCON_0024!=0){
            alert("[RCON_0024]有在途综合授信协议")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

          //存在在途综合授信调整或单笔批复调整时不得调整综合授信协议
          if(res.RCON_0058!=0){
            alert("[RCON_0058]有在途批复调整时不能调整综合授信协议")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

          //存在在途合同调整
         if(res.RCON_0059!=0){
            alert("[RCON_0059]有在途合同申请或调整时不能调整综合授信协议")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }


       }else{//单笔
        //合同在途调整校验
        if(res.RCON_0026!=0){
            alert("[RCON_0026]有在途合同申请")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

        //存在在途综合授信协议协议调整
        if(res.RCON_0060!=0){
            alert("[RCON_0060]有在途综合授信协议申请或调整时不能调整合同")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

        //存在在途综合授信调整或单笔批复调整时不得调整业务合同
        if(res.RCON_0039!=0){
            alert("[RCON_0039]存在在途综合授信调整或单笔批复调整")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

        //存在在途出账不得调整业务合同
        if(res.RCON_0040!=0){
            alert("[RCON_0040]存在在途出账")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }


       }

  //规则校验：冻结批复不能调整
       // if(res.RBIZ_0024!=0){
       //      alert("[RBIZ_0024]批复已冻结")
       //      this.vaildateFlag=false
       //      return {vaildateFlag:this.vaildateFlag,param:row}
       //    }

  //合同下有担保合同调整在途
       if(res.RGRT_0005!=0){
            alert("[RGRT_0005]合同下有在途的担保合同$[c]调整流程")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

           //合同下有在途的保证金追加
       if(res.RGRT_0012!=0){
            alert("[RGRT_0012]该合同有在途的保证金追加")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }
       
          console.log("vaildateFlag:"+vaildateFlag)
          return {vaildateFlag:vaildateFlag,param:row,func:this.tzContractInfo}
         }).then(
         
          function (data) {
            console.log("接受到了参数vaildateFlag "+data.vaildateFlag+",param:"+ JSON.stringify(data.param))
            if(data.vaildateFlag){
              
             // console.log("flag的值"+data.vaildateFlag)
              data.func(data.vaildateFlag,data.param)
            }

          }


         ).catch((error)=>{
          console.log(error)
         })




      },

      tzContractInfo(vaildateFlag,param){
        if(vaildateFlag){
          console.log("执行合同更新方法")
          tzContractInfo(param).then(response=>{
                  let res=response.data
                  console.log("[tzContractInfo]result is:"+JSON.stringify(res))
                  if(res.msg !=null){
                    alert(res.msg)
                    return false
                  }

                  let params={contractId:res.conInfo.contractId,
                     contractType:"02",
                     amountDetailId:res.amountDetailId,
                     proFlag:"1",
                     processInstId:res.processInstId

                   }
                   console.log("[con_tree] params "+JSON.stringify(params))
                  this.$router.push({name: 'con_tree',
                    params:params
                  })

                }).catch((error)=>{
                  console.log(error)
                })

        }

      }
      ,


      disab(row) { 
       console.log('disable 合同...')
       if(0==row.length){
        alert("请选择一笔生效合同。")
        return false
       }


        disabValidateForCon(row).then(response=>{
          let res=response.data
          let vaildateFlag=true
          console.log("dataMap is "+JSON.stringify(res))

        //综合授信协议不允许手工失效
         if(row.bizType=="综合授信协议"){
          alert("综合授信协议不允许手工失效！")
          return false

         }else{//单笔
              //合同有在途调整不允许手工失效
              //RCON_0026
              if(res.RCON_0026!=0){
                alert("[RCON_0026]有在途合同申请")
                this.vaildateFlag=false
                return {vaildateFlag:this.vaildateFlag,param:row}
              }

              //存在在途出账不得调整业务合同
              //RCON_0040
              if(res.RCON_0040!=0){
                alert("[RCON_0040]存在在途出账")
                this.vaildateFlag=false
                return {vaildateFlag:this.vaildateFlag,param:row}
              }
              //存在未结清借据
              //RCON_0043
              if(res.RCON_0043!=0){
                alert("[RCON_0043]该笔合同下有未结清借据")
                this.vaildateFlag=false
                return {vaildateFlag:this.vaildateFlag,param:row}
              }

        }
          //存在未结清借据
          //RGRT_0005
          if(res.RGRT_0005!=0){
            alert("[RGRT_0005]合同下有在途的担保合同$[c]调整流程")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }
          //合同下有在途的保证金追加
          //RGRT_0012
          if(res.RGRT_0012!=0){
            alert("[RGRT_0012]该合同有在途的保证金追加")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }
          //新需求：合同下有临时出库的押品  不让做合同失效 
          //RGRT_0017
          if(res.RGRT_0017!=0){
            alert("[RGRT_0017]该合同有临时出库的押品，不允许做合同失效")
            this.vaildateFlag=false
            return {vaildateFlag:this.vaildateFlag,param:row}
          }

          return {vaildateFlag:vaildateFlag,param:row,func:this.getContractBizType}

        }).then(

          function (data) {
              console.log("接受到了参数vaildateFlag "+data.vaildateFlag+",param:"+ JSON.stringify(data.param))
                if(data.vaildateFlag){
                // console.log("flag的值"+data.vaildateFlag)
                data.func(data.param.contractId,"2")
              }
            }

          ).catch((error)=>{
          console.log(error)
        })



        //getContractBizType(row.contractId,"2")


      },
      //获取业务性质
      getContractBizType(contractId, flag) {
        console.log("[getContractBizType]contractId="+contractId+",flag="+flag)
        let params={contractId:contractId,flag:flag,bizType:''}
        getConInfoBizType(params).then(response=>{
                    let res=response.data
                    console.log("[获取业务性质]: "+JSON.stringify(res))
                    let biztypeFlag =false
                    if(res.BIZ_TYPE!=null){
                      //recounted(contractId, flag, res.bizType)
                      biztypeFlag=true
                      params.bizType=res.BIZ_TYPE
                      return {biztypeFlag:biztypeFlag,param:params,func:this.recounted}
                      
                    }else{
                      alert("业务信息为空，合同失效操作失败！")
                      return false
                    }
                    
                
               }).then(function (data) {
                 console.log("接受到了业务参数vaildateFlag "+data.biztypeFlag+",param:"+ JSON.stringify(data.param))

                  if(data.biztypeFlag){
              
                    data.func(data.param.contractId,data.param.flag,data.param.bizType)
                  }


               }).catch((error)=>{
                console.log(error)
               })

      },
      recounted(contractId, flag, bizType) {
        console.log("[recounted]函数被调用了!contractId="+contractId+" ,flag="+flag+" ,bizType="+bizType)

        var title="合同确认失效?";
        if(bizType=="01"||bizType=="04"){
          title="合同失效后批复同步失效，失效后将不能恢复";
        }
          //this.msgContents=title;
         // this.dialog1Visible=true;
          let params={contractId:contractId,flag:flag}

   
          this.$confirm(title)
          .then(_ => {

              disConInfo(params).then(response=>{
                 let res=response.data
                 console.log("[disConInfo]params "+JSON.stringify(params)+",res data "+JSON.stringify(res))
                  let disabFlag=false

                     if (res.msg != null) {
                        alert(res.msg); //失败时后台直接返回出错信息
                        return false

                     } else {
                       alert("更新失败"); //无返回信息
                        return false
                     }

                      return {disabFlag:disabFlag,param:{contractId:contractId},func:this.disConSynCollSystem}

                  }).then(function (data) {

                    console.log("接受到了合同失效后参数:disabFlag "+data.disabFlag+",param:"+ JSON.stringify(data.param))

                  if(data.disabFlag){
              
                    data.func(data.param.contractId)
                  }
                                
                 }
               ).catch((error)=>{
               console.log(error)
             })
          })
          .catch(_ => {});

      },
      //通知押品系统调整相关的业务逻辑
      disConSynCollSystem(contractId){

          console.log("[通知押品系统调整相关的业务逻辑]contractId:"+contractId)


      },

      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {

            done();
          })
          .catch(_ => {});
      },
      // dialog1Close(done){
      //   this.confirmDisab=true
      //   this.$confirm('dialog1Close确认关闭？')
      //     .then(_ => {

      //       done();
      //     })
      //     .catch(_ => {});

      // },
      // dialogConfirm(){
            
      //       console.log("hello....")
      //       this.confirmDisab=true
      //       // this.confirmDisable=true
      //        this.dialog1Visible=false
      //        console.log("confirmDisab:"+this.confirmDisab)
      //   },
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
