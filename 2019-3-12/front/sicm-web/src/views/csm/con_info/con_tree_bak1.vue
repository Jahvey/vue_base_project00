<template>
  <!--pay_tree.jsp:分发加载菜单栏信息-->
  <div class="conTree">
    <el-button @click="open" type="primary">打开</el-button>
    <el-dialog
      :visible.sync="dialogVisible"
      width="100%"
      :fullscreen="fullScreen"
      :before-close="handleGoodsDetailInfoClose">
      <el-tabs v-model="activeTabName" @tab-click="chooseTabClick">
        <el-tab-pane label="合同签约" name="baseInfo">
          <el-container style="height: 540px; border: 1px solid #DCDFE6">
            <el-aside width="230px">
              <el-tree
              
                :data="menuTree"
                :props="defaultProps"
                node-key="id"
                default-expand-all
                :expand-on-click-node="false"
                @node-click="handleNodeClick"
              >
                <!--自定义节点内容，这里用不上这个-->
                <!--<span class="custom-tree-node" slot-scope="{ node, data }">
                  <span>
                      <i class="el-icon-tickets"></i>{{ node.label }}
                  </span>
                </span>-->
              </el-tree>
            </el-aside>
            <el-container>
              <el-header style="border: 1px solid #409EFF; margin: 10px;text-align: center;line-height: 40px"
                         height="40px">
                <el-row :gutter="20">
                  <el-col :span="6">
                    <el-button type="text" @click="getCustmer" size="medium">客户信息</el-button>
                  </el-col>
                  <el-col :span="6">
                    <el-button type="text" @click="getApprove" size="medium">业务信息</el-button>
                  </el-col>
                  <el-col :span="6">
                    <el-button type="text" @click="getSummary" size="medium">借据信息</el-button>
                  </el-col>
                  <el-col :span="6">
                    <el-button type="text" @click="getContract" size="medium">合同信息</el-button>
                  </el-col>
                </el-row>
              </el-header>
              <el-main style="padding:10px;margin: 1px;margin-top:1px;margin-bottom:5px;border: 1px solid #E4E7ED;">
                <!--动态组件,paramsInfo:父组件要带给子组件的参数-->
                <keep-alive>
                  <compoment v-bind:is="currentView" :paramsInfo="paramsInfo"></compoment>
                </keep-alive>
              </el-main>
            </el-container>
          </el-container>
        </el-tab-pane>
        <el-tab-pane label="过程历史" name="processHistory">
          过程历史
          <li>测试1</li>
          <li>测试2</li>
          <li>改造汽水人3号</li>
        </el-tab-pane>
      </el-tabs>

    </el-dialog>
  </div>
</template>

<script>
  //import payInfo from './pay_info'
  //import {getInitPayInfo, getInitProductType} from '@/api/loanInfo'
  import conApplyYwht from '@/views/crt/con_apply/con_apply_ywht'
  import {getDetailJspByContractId,getConInfoByContarctId,getBankTeamStruct}  from '@/api/csm'


  export default {
    name: 'conTree',
    components: {
     // payInfo
     conApplyYwht
    },
    data() {
      return {
        paramsInfo:{//使用父子传参的方式传递参数，父组件向子组件传递多个参数

        },
        dialogVisible: false,//对话框
        fullScreen: true,//是否全屏
        activeTabName: 'baseInfo',//默认选中baseInfo的Tab表单
        currentView: 'conApplyYwht',//默认选中放款信息
        //怎么在前台写一个json数据，然后丢到这里来？？？
        menuTree: [],//自定义一个全局的tree，这里动态渲染，问题还不小
        data: [
          {
            label: '放款申请信息',
            id: '1',
            icon: 'el-icon-circle-plus',
            children: [
              {
                id: '1-1',
                label: '放款信息',
                icon: 'el-icon-tickets',
              },
              {
                id: '1-2',
                label: '账户信息',
                icon: 'el-icon-tickets',
              },
              {
                id: '1-3',
                label: '还本计划表',
                icon: 'el-icon-tickets',
              },
              {
                id: '1-4',
                label: '贴息信息',
                icon: 'el-icon-tickets',
              },
              {
                id: '1-5',
                label: '受托支付信息',
                icon: 'el-icon-tickets',
              },
              {
                id: '1-6',
                label: '汇票明细信息',
                icon: 'el-icon-tickets',
              }
            ]
          },
          {
            id: "2",
            label: '业务同意发放通知书',
            icon: 'el-icon-tickets',
          },
          {
            id: '3',
            label: '批复意见书',
            icon: 'el-icon-tickets',
          },
          {
            id: '4',
            label: '历史批复信息',
            icon: 'el-icon-tickets',
          },
          {
            id: '5',
            label: '影像资料',
            icon: 'el-icon-tickets',
          },
          {
            id: '6',
            label: '意见',
            icon: 'el-icon-tickets',
          }
        ],
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      }
    },
    created() {
      //这个数据，接上合同的模态框之后可以在合同里面传过来 
      //let param = this.$route.params
      let param = {contractId: '5AF812FCFC2300CAE05010AC57DD7D12',applyId:'xxx'}
      this.initData(param)
    },
    methods: {
      initData(data) {
        let partyId
        //这三个数据都是从request域中得到的
        let proFlag //1：可修改。0：不可修改
        let contractId = ''//协议申请ID
        let processInstId=''
        let jspName='1' //合同详细信息页面
        let tableName='tb_con_ldzj'
        let conSrc='2'   //区分是单笔业务还是综合授信业务，单笔为1，综合为2
        let syndicatedObjectCd = "100"
        let productType
        let cycleIndCon
        let contypename 
        let bizType='01'
        let applyId
        let amountDetailId


        // let menuTree=this.menuTree
        console.log("[开始调用接口]data:{conctractId"+data.contractId+",applyId:"+data.applyId+"}")

        getDetailJspByContractId(data).then(response=>{
          let mydata=response.data

          console.log("getDetailJspByContractId:"+JSON.stringify(mydata))
          jspName=mydata.jspAddress
          productType=mydata.productType
          tableName=mydata.tableName
          cycleIndCon=mydata.cycleIndCon
          console.log("[异步请求 拿到数据了没有]productType:"+productType+",tableName:"+tableName)
          }).catch((error) => {
          console.log(error)
          console.log('将品种对应的合同明细页面取出来报错了')
        })

        console.log("[测试拿到数据了没有]productType:"+productType+",tableName:"+tableName)

        getConInfoByContarctId(data).then(response=>{
          let mydata=response.data

          console.log("getConInfoByContarctId"+JSON.stringify(mydata))
            contypename="综合授信项下主合同"

          //公司客户
          if("00" == mydata.tbBizAmountDetailApprove.creditMode){
            contypename="用信项下主合同"
          }

          proFlag=data.proFlag1

          //如果是银团，行内银团合同只有利率信息
          if(mydata.bizInfo.isBankTeam!=null && mydata.bizInfo.isBankTeam !=''){
            if(mydata.bizInfo.isBankTeam=='1'){
              getBankTeamStruct(data).then(response1=>{
                let o=response1.data
                console.log("getBankTeamStruct:"+o)

                syndicatedObjectCd=o.bankTs.syndicatedObjectCd
                if(syndicatedObjectCd=='02'){
                  mydata.contractType="03"
                }

              }).catch((error)=>{
                console.log(error)
                console.log("查询银团结构信息 失败！！！")

              })

            }

          }

          //如果合同信息里协议id为空，则是单笔申请的业务
          if(mydata.conInfo.xyId==null || mydata.conInfo.xyId==''){
            this.conSrc="1"
            this.contypename = "单笔业务项下主合同"
          }

          this.bizType=mydata.bizInfo.bizType
          this.applyId=mydata.bizInfo.applyId
          this.partyId=mydata.bizInfo.partyId
          this.productType=mydata.conInfo.productType
          this.amountDetailId=mydata.conInfo.amountDetailId
        
          console.log("bizType"+bizType)
          if(bizType=='01'||bizType=='02'||bizType=='05'){
            if("01"==mydata.contractType){
              this.menuTree = [//军育苗做例子，这样怎么把上面定义的参数传递到该指定页面，例如 addr
                  {
                    label: '放款申请信息',
                    id: '1',
                    icon: 'el-icon-circle-plus',
                    children: [
                      {
                        id: '1-1',
                        label: '放款信息',
                        icon: 'el-icon-tickets',
                      },
                      {
                        id: '1-2',
                        label: '账户信息',
                        icon: 'el-icon-tickets',
                      },
                      {
                        id: '1-4',
                        label: '贴息信息',
                        icon: 'el-icon-tickets',
                      }
                    ]
                  }
                ]

                this.menuTree.push({
                    label: '放款申请信息1',
                    id: '2',
                    icon: 'el-icon-circle-plus',
                    children: [
                      {
                        id: '2-1',
                        label: '放款信息1',
                        icon: 'el-icon-tickets',
                      },
                      {
                        id: '2-2',
                        label: '账户信息1',
                        icon: 'el-icon-tickets',
                      },
                      {
                        id: '2-4',
                        label: '贴息信息1',
                        icon: 'el-icon-tickets',
                      }
                    ]
                  })



           }


          }




        }).catch((error)=>{
          console.log(error)
          console.log("查询合同明细信息报错")
        })


       
      },
      chooseTabClick(tab, event) {
        let count = 0
        count = count + 1
        console.log('选中这个tab组件要做的操作，点击的时候触发一个函数' + count)
      },
      getCustmer() {
        alert('客户信息，点击这个调转客户信息的tree')
      },
      getApprove() {
        alert('业务信息，点击这个调转业务信息的tree')
      },
      getSummary() {
        alert('借据信息，点击这个调转借据信息的tree')
      },
      getContract() {
        alert('合同信息，点击这个调转合同信息的tree')
      },
      open () {
        this.dialogVisible = true
      },
      handleGoodsDetailInfoClose: function (done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            //this.currentView = "summaryInfo";
            done();
          })
          .catch(_ => {
          });
      },
      /*树方法开始*/
      handleNodeClick(item, node, self) {//2019年1月31日14:33:19  点击选中
        if (item.id == '1-1') {
          console.log("放款信息")
          //this.currentView = 'conApplyYwht'
        } else if (item.id == '1-2') {
          console.log("账户信息");
        } else if (item.id == '1-3') {
          console.log("还本计划表");
        } else if (item.id == '1-4') {
          console.log("贴息信息");
        } else if (item.id == '1-5') {
          console.log("受托支付信息");
        } else if (item.id == '1-6') {
          console.log("汇票明细信息");
        } else if (item.id == '2') {
          console.log('业务同意发放通知书')
        } else if (item.id == '3') {
          console.log("批复意见书");
        } else if (item.id == '4') {
          console.log("历史批复信息");
        } else if (item.id == '5') {
          console.log("影像资料");
        }
      },
      startWith(src, str) {
        if (str == null || str == '' || src == null || src == '') {
          return -1
        }
        if (src.substr(0, str.length) == str) {
          return 1
        } else {
          return -1
        }
      }
    }
  }
</script>

<style scoped>
  .conTree {
    width: 100%;
    height: 100%;
  }

  .el-dialog__header {
    /* padding: 15px; */
    padding-bottom: 10px !important;
  }

  .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }
</style>
