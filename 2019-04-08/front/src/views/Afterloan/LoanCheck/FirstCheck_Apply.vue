<template>
  <!--pay_tree.jsp:分发加载菜单栏信息-->
  <div class="payTree">
    <el-button @click="open" type="primary">打开</el-button>
    <el-dialog
      :visible.sync="dialogVisible"
      width="100%"
      :fullscreen="fullScreen"
      :before-close="handleGoodsDetailInfoClose" append-to-body>
      <el-tabs v-model="activeTabName" @tab-click="chooseTabClick">
        <el-tab-pane label="基本信息" name="baseInfo">
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
                    <el-button type="text" @click="getContract" size="medium">合同信息</el-button>
                  </el-col>
                  <el-col :span="6">
                    <el-button type="text" @click="getSummary" size="medium">借据信息</el-button>
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
        <!--<el-tab-pane label="过程历史" name="processHistory">
          过程历史
          <li>测试1</li>
          <li>测试2</li>
          <li>改造汽水人3号</li>
        </el-tab-pane>-->
      </el-tabs>
    </el-dialog>
  </div>

</template>

<script>
  /*import {getInitPayInfo, getInitProductType} from '@/api/loanInfo'
  import payInfo from './pay_info'//放款信息
  import payXwTx from './pay_xw_tx'//贴息信息
  import loanInfoStzf from './loan_info_stzf'//受托支付信息
  import accountList from '../account_info/account_list'//账户信息
  import repayPlanList from '../repay_plan/repay_plan_list'//还本计划表*/
  import enums from "@/utils/enums"
//  import MoneyUseList from "@Afterloan/LoanCheck/MoneyUseList"
  export default {
    name: 'FirstCheck_Apply',
    components: {
      enums,
//      MoneyUseList
      /*payInfo,
      accountList,
      payXwTx,
      repayPlanList*/
    },
    data() {
      return {
        paramsInfo: {//使用父子传参的方式传递参数，父组件向子组件传递多个参数

        },
        dialogVisible: false,//对话框
        fullScreen: true,//是否全屏
        activeTabName: 'baseInfo',//默认选中baseInfo的Tab表单
        currentView: 'payInfo',//默认选中放款信息
        //怎么在前台写一个json数据，然后丢到这里来？？？
        menuTree: [],//自定义一个全局的tree，这里动态渲染，问题还不小
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        partyTypeCd:enums.CustomerClassCd,
        certType:enums.idTypeCd,
        data:{
          partyName:"",//客户名称
          partyTypeCd:"",//客户类型
          certType:"",//证件类型
          certNum:"",//证件号码
          userNum:"200555",
          orgNum:"0700",
          summaryAmt:"",//借据金额
          jjye:"",//借据余额
          beginDate:"",//借据起始日期
          endDate:"",//借据到期日期
          loanUse:"",//贷款用途
        },
      }
    },
    created() {
      //这个数据，接上合同的模态框之后可以在合同里面传过来 let param = this.$route.params
      let param = {loanId: '402881e967bb828101686fbaa3be0122'}//数据暂时先这样在页面写死，军育苗
      this.initProductType(param)
    },
    methods: {
      initProductType(data) {
     /*   let addr = "pay/payout_info/loan_info"			//默认加载放款信息
        let productType = '01001001'		//默认：一般流动资金贷款 01001001
        let repayType = '0100'			//默认：等额本金
        let contractId = ''
        let loanstatus
        let partyId
        let trusToPayFlg = '0';	//受托支付标志
        let applyId = ''
        let bizNum = ''
        let loanNum = ''
        let partyTypeCd = ''
        let ecifPartyNum = ''
        let contractNum = ''
        let subCons
        let tranDate
        let guarantyType
        let contractDate
        let crdId
        let approveId

        // let menuTree=this.menuTree

        getInitProductType(data).then(response => {
          let mydata = response.data
          this.productType = mydata.loanInfo.productType
          if (mydata.loanInfo.repayType != null && mydata.loanInfo.repayType != '') {
            this.repayType = mydata.loanInfo.repayType
          }
          if (mydata.obj) {
            this.bizNum = mydata.obj.BIZ_NUM
            this.applyId = mydata.obj.APPLY_ID
            this.partyId = mydata.obj.PARTY_ID
            this.crdId = mydata.obj.CRD_ID
            this.approveId = mydata.obj.APPROVE_ID
          }
          this.partyId = mydata.loanInfo.partyId
          this.contractId = mydata.loanInfo.contractId
          this.loanstatus = mydata.loanInfo.loanStatus
          this.trusToPayFlg = mydata.loanInfo.trusToPayFlg
          this.loanNum = mydata.loanInfo.loanNum
          this.partyTypeCd = mydata.party.partyTypeCd
          this.ecifPartyNum = mydata.party.ecifPartyNum
          this.contractNum = mydata.contractInfo.contractNum
          this.guarantyType = mydata.contractInfo.guarantyType
          this.contractDate = mydata.contractInfo.contractDate
          this.subCons = mydata.subcon
          productType = this.productType
          this.menuTree.push({
            id: '5',
            label: '影像资料',
            icon: 'el-icon-tickets',
          })
          this.menuTree.push({
            id: '6',
            label: '意见',
            icon: 'el-icon-tickets',
          })

          this.paramsInfo = {//测试参数的传递，参数传递是没有问题的
            addr: this.addr,
            loanId: '402881e967bb828101686fbaa3be0122'
          }


          console.log('----------------我是一个蛇皮，卤鸡已经成功跳转了，妥妥的---------------------')
        }).catch((error) => {
          console.log(error)
          console.log('初始化pay_tree报错了')
        })*/
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
      getContract() {
        alert('合同信息，点击这个调转合同信息的tree')
      },
      getSummary(){
        alert('借据信息，点击这个调转借据信息的tree')
      },
      open() {
   //       this.dialogVisible = true,
          this.$router.push({ path: 'Afterloan/LoanCheck/MoneyUseList' })
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
          console.log("检查信息")
          this.currentView = 'MoneyUseList'
        } else if (item.id == '2') {
          console.log("影像资料")
        } else if (item.id == '3') {
          console.log("意见")
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
  .payTree {
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
