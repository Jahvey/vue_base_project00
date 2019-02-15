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
              
                :data="data"
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

  import {getDetailJspByContractId,getConInfoByContarctId,getBankTeamStruct}  from '@/api/csm'


  export default {
    name: 'conTree',
    components: {
     // payInfo
    },
    data() {
      return {
        paramsInfo:{//使用父子传参的方式传递参数，父组件向子组件传递多个参数

        },
        dialogVisible: false,//对话框
        fullScreen: true,//是否全屏
        activeTabName: 'baseInfo',//默认选中baseInfo的Tab表单
        currentView: 'payInfo',//默认选中放款信息
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
      let param = {contractId: '402881e967bb828101686fbaa3be0122',applyId:''}
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
        let bizType
        let applyId
        let amountDetailId


        // let menuTree=this.menuTree
        console.log("[开始调用接口]data:{conctractId"+data.contractId+",applyId:"+data.applyId+"}")
        getDetailJspByContractId(data).then(response=>{
          let mydata=response.data

          console.log("getDetailJspByContractId:"+mydata)
          this.jspName=mydata.jspAddress
          this.productType=mydata.productType
          this.tableName=mydata.tableName
          this.cycleIndCon=mydata.cycleIndCon

          }).catch((error) => {
          console.log(error)
          console.log('将品种对应的合同明细页面取出来报错了')
        })

        getConInfoByContarctId(data).then(response=>{
          let mydata=response.data

          console.log("getConInfoByContarctId"+mydata)
          this.contypename="综合授信项下主合同"

          //公司客户
          if("00" == mydata.tbBizAmountDetailApprove.creditMode){
            this.contypename="用信项下主合同"
          }

          this.proFlag=data.proFlag1

          //如果是银团，行内银团合同只有利率信息
          if(mydata.bizInfo.isBankTeam!=null && mydata.bizInfo.isBankTeam !=''){
            if(mydata.bizInfo.isBankTeam=='1'){
              getBankTeamStruct(data).then(response1=>{
                let o=response1.data
                console.log("getBankTeamStruct:"+o)
                
                this.syndicatedObjectCd=o.bankTs.syndicatedObjectCd
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
          if(data.conInfo.xyId==null || data.conInfo.xyId==''){
            this.conSrc="1"
            this.contypename = "单笔业务项下主合同"
          }

          this.bizType=mydata.bizInfo.bizType
          this.applyId=mydata.bizInfo.applyId
          this.partyId=mydata.bizInfo.partyId
          this.productType=mydata.conInfo.productType
          this.amountDetailId=mydata.conInfo.amountDetailId

          if(this.bizType=='01'||this.bizType=='02'||this.bizType=='05'){
            if("01"==mydata.contractType){
              

            }


          }



        }).catch((error)=>{
          console.log(error)
          console.log("查询合同明细信息报错")
        })







        getInitProductType(data).then(response => {
          let mydata = response.data
          // console.log(mydata)
          this.productType = mydata.loanInfo.productType
          if (mydata.loanInfo.repayType != null && mydata.loanInfo.repayType != '') {
            this.repayType = mydata.loanInfo.repayType
          }


       

          if (productType.substr(0, 4) == '0200' || productType.substr(0, 4) == '0300') {//个贷
            if (repayType.indexOf('14') != -1) {//有还款计划
              if (trusToPayFlg == '1') {//受托支付
                console.log("----------------------个贷，有还款计划，受托支付信息------------------")
                console.log("放款信息:/pay/payout_info/pay_info")
                console.log("账户信息:/pay/account_info/account_list")
                console.log("还本计划表:/pay/repay_plan/repay_plan_list")
                console.log("贴息信息:/pay/payout_info/pay_xw_tx")
                console.log("受托支付信息:/pay/payout_info/loan_info_stzf")
              } else {//自主支付
                console.log("--------------------个贷，有还款计划，自主支付-----------------")
                console.log("放款信息:/pay/payout_info/pay_info")
                console.log("账户信息:/pay/account_info/account_list")
                console.log("还本计划表:/pay/repay_plan/repay_plan_list")
                console.log("贴息信息:/pay/payout_info/pay_xw_tx")
              }
            } else {//无还款计划
              if (trusToPayFlg == '1') {//受托支付
                console.log("---------------------个贷，无还款计划，受托支付------------------")
                console.log("放款信息:/pay/payout_info/pay_info")
                console.log("账户信息:/pay/account_info/account_list")
                console.log("贴息信息:/pay/payout_info/pay_xw_tx")
                console.log("受托支付信息:/pay/payout_info/loan_info_stzf")
              } else {//自主支付
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
                this.paramsInfo={//测试参数的传递，参数传递是没有问题的
                  addr:this.addr,
                  loanId: '402881e967bb828101686fbaa3be0122'
                }
                console.log("---------------------------个贷，无还款计划，自助支付----------------------")
                console.log("放款信息:/pay/payout_info/pay_info")
                console.log("账户信息:/pay/account_info/account_list")
                console.log("贴息信息:/pay/payout_info/pay_xw_tx")
              }
            }
          } else if ('01006001' == productType || '01006002' == productType || '01006010' == productType) {
            console.log("----------------贴现-----------")
            console.log("放款信息:/pay/payout_info/pay_info")
            console.log("汇票明细信息:/pay/pjxx/pay_tx")
            console.log("账户信息:/pay/account_info/account_list")
          } else if ('01008001' == productType || '01008002' == productType || '01008010' == productType) {
            console.log("----------------银承-----------")
            console.log("放款信息:/pay/payout_info/pay_info")
            console.log("汇票明细信息:/pay/pjxx/pay_pj")
            console.log("账户信息:/pay/account_info/account_list")
          } else {
            if ((productType.substring(0, 5) == "01001" || productType.substring(0, 5) == "01003") && trusToPayFlg == '1') {
              if (repayType.indexOf('14') != -1) {
                console.log("01001-------------最后之作-----------01003+++trusToPayFlg==1")
                console.log("放款信息:/pay/payout_info/pay_info")
                console.log("账户信息:/pay/account_info/account_list")
                console.log("还本计划表:/pay/repay_plan/repay_plan_list")
                console.log("受托支付信息:/pay/payout_info/loan_info_stzf")
              } else {
                console.log("01001-------------最后之作不等于-------01003+++trusToPayFlg==1")
                console.log("放款信息:/pay/payout_info/pay_info " + {addr: addr})//这样直接打出来会直接拼接,就这样传参数
                console.log("账户信息:/pay/account_info/account_list")
                console.log("受托支付信息:/pay/payout_info/loan_info_stzf")
              }
            } else {
              if (repayType.indexOf('14') != -1) {
                console.log("---------------------你好我叫王大锤，是一个五指山---------------------")
                console.log("放款信息:/pay/payout_info/pay_info")
                console.log("账户信息:/pay/account_info/account_list")
                console.log("还本计划表:/pay/repay_plan/repay_plan_list")
              } else {
                this.menuTree = [
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
                      }
                    ]
                  }
                ]
                console.log("-----------------乐堡啤酒，拉开快乐---------------")
                console.log("放款信息:/pay/payout_info/pay_info")
                console.log("账户信息:/pay/account_info/account_list")
              }
            }
          }
          console.log('----------------我是一个蛇皮，卤鸡已经成功跳转了，妥妥的---------------------')
        }).catch((error) => {
          console.log(error)
          console.log('初始化pay_tree报错了')
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
          this.currentView = 'payInfo'
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
