<template>
  <!--pay_tree.jsp:分发加载菜单栏信息-->
  <div class="conTree">
    <el-button @click="open"
               type="primary">打开</el-button>
    <el-dialog :visible.sync="dialogVisible"
               width="100%"
               :fullscreen="fullScreen"
               :before-close="handleGoodsDetailInfoClose">
      <el-tabs v-model="activeTabName"
               @tab-click="chooseTabClick">
        <el-tab-pane label="合同签约"
                     name="baseInfo">
          <el-container style="height: 540px; border: 1px solid #DCDFE6">
            <el-aside width="230px">
              <el-tree :data="menuTree"
                       :props="defaultProps"
                       node-key="id"
                       default-expand-all
                       :expand-on-click-node="false"
                       @node-click="handleNodeClick">
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
                    <el-button type="text"
                               @click="getCustmer"
                               size="medium">客户信息</el-button>
                  </el-col>
                  <el-col :span="6">
                    <el-button type="text"
                               @click="getApprove"
                               size="medium">业务信息</el-button>
                  </el-col>
                  <el-col :span="6">
                    <el-button type="text"
                               @click="getSummary"
                               size="medium">借据信息</el-button>
                  </el-col>
                  <el-col :span="6">
                    <el-button type="text"
                               @click="getContract"
                               size="medium">合同信息</el-button>
                  </el-col>
                </el-row>
              </el-header>
              <el-main style="padding:10px;margin: 1px;margin-top:1px;margin-bottom:5px;border: 1px solid #E4E7ED;">
                <!--动态组件,paramsInfo:父组件要带给子组件的参数-->
                <keep-alive>
                  <compoment v-bind:is="currentView"
                             :paramsConTree="paramsConTree"></compoment>

                </keep-alive>
              </el-main>
            </el-container>
          </el-container>
        </el-tab-pane>
        <el-tab-pane label="过程历史"
                     name="processHistory">
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

// import conApplyYwht from '@/views/crt/con_apply/con_apply_ywht'
import { getDetailJspByContractId, getConInfoMapByContarctId, getBankTeamStruct, saveConInfoToPro, RuleEngineMapper } from '@/api/csm'

import con_dy_list from '@/views/Crt/ConGrt/ConDyList'
import con_zy_list from '@/views/Crt/ConGrt/ConZyList'
import con_bzr_list from '@/views/Crt/ConGrt/ConBzrList'
import con_bzj_list from '@/views/Crt/ConGrt/ConBzjList'

import con_info_xy from '@/views/Crt/ConInfo/ConInfoXy'
import con_detail_xy from '@/views/Crt/ConInfo/ConDetailXy'
import con_fs_xy from '@/views/Crt/ConInfo/ConFsXy'
import con_info_ht from '@/views/Crt/ConInfo/ConInfoHt'
import con_detail_ht from '@/views/Crt/ConInfo/ConDetailHt'
import biz_tx_all from '@/views/Crt/ConInfo/BizTxAll'
import biz_pj_all from '@/views/Crt/ConInfo/BizPjAll'
import con_info_ht_xw from '@/views/Crt/ConInfo/ConInfoHtXw'
import con_detail_ht_xw_house from '@/views/Crt/ConInfo/ConDetailHtXwHouse'
import con_detail_ht_xw_cycle from '@/views/Crt/ConInfo/ConDetailHtXwCycle'
import con_detail_ht_xw_uncycle from '@/views/Crt/ConInfo/ConDetailHtXwUncycle'

export default {
  name: 'conTree',
  components: {

    // conApplyYwht,
    con_dy_list,
    con_zy_list,
    con_bzr_list,
    con_bzj_list,

    con_info_xy,
    con_detail_xy,
    con_fs_xy,
    con_info_ht,
    con_detail_ht,
    biz_tx_all,
    biz_pj_all,
    con_info_ht_xw,
    con_detail_ht_xw_house,
    con_detail_ht_xw_cycle,
    con_detail_ht_xw_uncycle

  },
  props: {
    paramsInfo: {// 接收父组件传递过来的参数

    }
  },

  data() {
    return {
      // 以下是一些非常重要的数据
      partyId: '',
      // 这三个数据都是从request域中得到的
      proFlag: '', // 1：可修改。0：不可修改
      contractId: '', // 协议申请ID
      processInstId: '',
      contractType: '',

      jspName: '', // 合同详细信息页面
      tableName: '',
      conSrc: '', // 区分是单笔业务还是综合授信业务，单笔为1，综合为2
      syndicatedObjectCd: '',
      productType: '',
      cycleIndCon: '',
      contypename: '',
      bizType: '',
      applyId: '',
      amountDetailId: '',
      proFlag_s: '',
      o: '', // 用来接受子组件传过来的相关数据

      paramsConTree: {

      },

      dialogVisible: false, // 对话框
      fullScreen: true, // 是否全屏
      activeTabName: 'baseInfo', // 默认选中baseInfo的Tab表单
      currentView: '', // 默认选中放款信息
      // 怎么在前台写一个json数据，然后丢到这里来？？？
      menuTree: [], // 自定义一个全局的tree，这里动态渲染，问题还不小
      data: [],

      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  created() {
    // 这个数据，接上合同的模态框之后可以在合同里面传过来

    // let param = { contractId: '5AF812FCD14100CAE05010AC57DD7D12', applyId: 'ff808081628f641d0162b7d370400096' }
    console.log('this.paramsInfo is ' + JSON.stringify(this.paramsInfo))
    this.dialogVisible = this.paramsInfo.conTreeVisiable
    console.log('this.dialogVisible----------->' + this.paramsInfo.conTreeVisiable)
    // const param = this.paramsInfo
    // console.log(JSON.stringify(param))

    this.initData(this.paramsInfo)
  },
  methods: {

    initData(data) {
      console.log('[con_tree] init invoke....' + JSON.stringify(data))
      this.partyId = ''
      // 这三个数据都是从request域中得到的
      this.proFlag = data.proFlag // 1：可修改。0：不可修改
      this.contractId = data.contractId// 协议申请ID
      this.processInstId = data.processInstId
      this.contractType = data.contractType

      this.jspName = '1' // 合同详细信息页面
      this.tableName = 'tb_con_ldzj'
      this.conSrc = '2' // 区分是单笔业务还是综合授信业务，单笔为1，综合为2
      this.syndicatedObjectCd = '100'
      this.productType = ''
      this.cycleIndCon = ''
      this.contypename = ''
      this.bizType = '01'
      this.applyId = ''
      this.amountDetailId = data.amountDetailId
      this.proFlag_s = ''

      // this.menuTree = [//军育苗做例子，这样怎么把上面定义的参数传递到该指定页面，例如 addr
      //     {
      //       label: '综合授信协议',
      //       id: '1',
      //       url:'',
      //       icon: 'el-icon-circle-plus',
      //       children: [
      //         {
      //           id: '1-1',
      //           label: '基本信息',
      //           url:'con_info_xy',
      //           params:{
      //             contractId:contractId,
      //             proFlag:proFlag
      //           },
      //           icon: 'el-icon-tickets',
      //         },
      //         {
      //           id: '1-2',
      //           label: '明细信息',
      //           url:'con_detail_xy',
      //           params:{
      //             contractId:contractId,
      //             proFlag:"0"
      //           },
      //           icon: 'el-icon-tickets',
      //         },
      //         {
      //           id: '1-3',
      //           label: '附属信息',
      //           url:'con_fs_xy',
      //           params:{
      //             contractId:contractId,
      //             proFlag:proFlag
      //           },
      //           icon: 'el-icon-tickets',
      //         }
      //       ]
      //     }
      //   ]

      //         this.menuTree.push({
      //             label: '从合同信息',
      //             id: '2',
      //             url:'',
      //             icon: 'el-icon-circle-plus',
      //             children: [
      //               {
      //                 id: '2-1',
      //                 label: '抵押合同',
      //                 url:'conDyList',
      //                 params:{
      //                   contractId:contractId,
      //                   subcontractTypeCd:"01",
      //                   applyId:applyId,
      //                   contractType:"02",
      //                   partyId:partyId,
      //                   proFlag:proFlag
      //                 },
      //                 icon: 'el-icon-tickets',
      //               },
      //               {
      //                 id: '2-2',
      //                 label: '质押合同',
      //                 url:'con_zy_list',
      //                 params:{
      //                   contractId:contractId,
      //                   subcontractTypeCd:"02",
      //                   applyId:applyId,
      //                   contractType:"02",
      //                   partyId:partyId,
      //                   proFlag:proFlag
      //                 },
      //                 icon: 'el-icon-tickets',
      //               },
      //               {
      //                 id: '2-3',
      //                 label: '保证合同',
      //                 url:'con_bzr_list',
      //                 params:{
      //                   contractId:contractId,
      //                   subcontractTypeCd:"04",
      //                   applyId:applyId,
      //                   contractType:"02",
      //                   partyId:partyId,
      //                   proFlag:proFlag
      //                 },
      //                 icon: 'el-icon-tickets',
      //               },
      //               {
      //                 id: '2-4',
      //                 label: '关联保证金',
      //                 url:'con_bzj_list',
      //                 params:{
      //                   contractId:contractId,
      //                   subcontractTypeCd:"03",
      //                   applyId:applyId,
      //                   contractType:"02",
      //                   partyId:partyId,
      //                   proFlag:proFlag,
      //                   proFlag_s:proFlag_s
      //                 },
      //                 icon: 'el-icon-tickets',
      //               }
      //             ]

      //         })

      // let menuTree=this.menuTree
      console.log('[开始调用接口]data:{conctractId' + data.contractId + ',applyId:' + data.applyId + '}')

      getDetailJspByContractId(data).then(response => {
        const mydata = response.data

        console.log('getDetailJspByContractId:' + JSON.stringify(mydata))
        this.jspName = mydata.jspAddress
        this.productType = mydata.productType
        this.tableName = mydata.tableName
        this.cycleIndCon = mydata.cycleIndCon
        console.log('[异步请求 拿到数据了没有]productType:' + this.productType + ',tableName:' + this.tableName)
      }).catch((error) => {
        console.log(error)
        console.log('将品种对应的合同明细页面取出来报错了')
      })

      getConInfoMapByContarctId(data).then(response => {
        const mydata = response.data

        console.log('getConInfoByContarctId' + JSON.stringify(mydata))
        this.contypename = '综合授信项下主合同'

        // 公司客户
        if (mydata.tbBizAmountDetailApprove.creditMode == '00') {
          this.contypename = '用信项下主合同'
        }

        this.proFlag_s = mydata.proFlag1

        // 如果是银团，行内银团合同只有利率信息
        if (mydata.bizInfo.isBankTeam != null && mydata.bizInfo.isBankTeam != '') {
          if (mydata.bizInfo.isBankTeam == '1') {
            getBankTeamStruct(data).then(response1 => {
              const o = response1.data
              console.log('[getBankTeamStruct]:' + JSON.stringify(o))

              this.syndicatedObjectCd = o.syndicatedObjectCd
              if (this.syndicatedObjectCd == '02') {
                mydata.contractType = '03'
              }
            }).catch((error) => {
              console.log(error)
              console.log('查询银团结构信息 失败！！！')
            })
          }
        }

        // 如果合同信息里协议id为空，则是单笔申请的业务
        if (mydata.conInfo.xyId == null || mydata.conInfo.xyId == '') {
          this.conSrc = '1'
          this.contypename = '单笔业务项下主合同'
        }

        this.bizType = mydata.bizInfo.bizType
        this.applyId = mydata.bizInfo.applyId
        this.partyId = mydata.bizInfo.partyId
        this.productType = mydata.conInfo.productType
        this.amountDetailId = mydata.conInfo.amountDetailId

        this.contractType = mydata.contractType

        console.log('bizType ' + this.bizType)
        console.log('contractType ' + this.contractType)
        console.log('productType ' + this.productType)
        console.log('proFlag ' + this.proFlag)
        console.log('applyId ' + this.applyId)
        console.log('partyId ' + this.partyId)
        console.log('amountDetailId ' + this.amountDetailId)
        console.log('conSrc ' + this.conSrc)

        if (this.bizType == '01' || this.bizType == '02' || this.bizType == '05') {
          this.currentView = 'con_info_ht'
          this.paramsConTree = {
            contractId: this.contractId,
            proFlag: this.proFlag,
            productType: this.productType,
            conSrc: this.conSrc
          }
          console.log('currentView..' + JSON.stringify(this.currentView))
          console.log('params....' + JSON.stringify(this.paramsConTree))
          if (mydata.contractType == '01') {
            this.currentView = 'con_info_xy'
            this.paramsConTree = {
              contractId: this.contractId,
              proFlag: this.proFlag
            }
            console.log('currentView..' + JSON.stringify(this.currentView))
            console.log('params....' + JSON.stringify(this.paramsConTree))

            this.menuTree = [// 军育苗做例子，这样怎么把上面定义的参数传递到该指定页面，例如 addr
              {
                label: '综合授信协议',
                id: '1',
                url: '',
                icon: 'el-icon-circle-plus',
                children: [
                  {
                    id: '1-1',
                    label: '基本信息',
                    url: 'con_info_xy',
                    params: {
                      contractId: this.contractId,
                      proFlag: this.proFlag
                    },
                    icon: 'el-icon-tickets'
                  },
                  {
                    id: '1-2',
                    label: '明细信息',
                    url: 'con_detail_xy',
                    params: {
                      contractId: this.contractId,
                      proFlag: '0'
                    },
                    icon: 'el-icon-tickets'
                  },
                  {
                    id: '1-3',
                    label: '附属信息',
                    url: 'con_fs_xy',
                    params: {
                      contractId: this.contractId,
                      proFlag: this.proFlag
                    },
                    icon: 'el-icon-tickets'
                  }
                ]
              }
            ]

            this.menuTree.push({
              label: '从合同信息',
              id: '2',
              url: '',
              icon: 'el-icon-circle-plus',
              children: [
                {
                  id: '2-1',
                  label: '抵押合同',
                  url: 'con_dy_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '01',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-2',
                  label: '质押合同',
                  url: 'con_zy_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '02',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-3',
                  label: '保证合同',
                  url: 'con_bzr_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '04',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                }
              ]

            })
          }

          if (mydata.contractType == '02') {
            // 贴现

            if (this.productType == '01006001' || this.productType == '01006002' || this.productType == '01006010') { // 村镇银行贴现产品
              this.menuTree = [
                {
                  label: this.contypename,
                  id: '1',
                  url: '',
                  icon: 'el-icon-circle-plus',
                  children: [
                    {
                      id: '1-1',
                      label: '主合同基本信息',
                      url: 'con_info_ht',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType,
                        conSrc: this.conSrc

                      },
                      icon: 'el-icon-tickets'
                    },
                    {
                      id: '1-2',
                      label: '主合同明细信息',
                      url: 'con_detail_ht',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        jspName: this.jspName,
                        productType: this.productType,
                        amountDetailId: this.amountDetailId,
                        cycleIndCon: mydata.conInfo.cycleIndCon,
                        syndicatedObjectCd: this.syndicatedObjectCd
                      },
                      icon: 'el-icon-tickets'
                    },
                    {
                      id: '1-3',
                      label: '票据明细信息',
                      url: 'biz_tx_all',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType,
                        partyId: this.partyId,
                        ecifPartyNum: mydata.party.ecifPartyNum,
                        amountDetailId: this.amountDetailId,
                        contractNum: mydata.conInfo.contractNum
                        // contractId: mydata.conInfo.contractId
                      },
                      icon: 'el-icon-tickets'
                    }
                  ]
                }

              ]
            }// 银承
            else if (this.productType == '01008001' || this.productType == '01008002' || this.productType == '01008010') {
              this.menuTree = [
                {
                  label: this.contypename,
                  id: '1',
                  url: '',
                  icon: 'el-icon-circle-plus',
                  children: [
                    {
                      id: '1-1',
                      label: '主合同基本信息',
                      url: 'con_info_ht',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType,
                        conSrc: this.conSrc

                      },
                      icon: 'el-icon-tickets'
                    },
                    {
                      id: '1-2',
                      label: '主合同明细信息',
                      url: 'con_detail_ht',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        jspName: this.jspName,
                        productType: this.productType,
                        amountDetailId: this.amountDetailId,
                        cycleIndCon: mydata.conInfo.cycleIndCon,
                        syndicatedObjectCd: this.syndicatedObjectCd
                      },
                      icon: 'el-icon-tickets'
                    },
                    {
                      id: '1-3',
                      label: '票据明细信息',
                      url: 'biz_pj_all',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType,
                        partyId: this.partyId,
                        ecifPartyNum: mydata.party.ecifPartyNum,
                        amountDetailId: this.amountDetailId,
                        contractNum: mydata.conInfo.contractNum
                        // contractId: mydata.conInfo.contractId
                      },
                      icon: 'el-icon-tickets'
                    }
                  ]
                }

              ]
            } else {
              this.menuTree = [
                {
                  label: this.contypename,
                  id: '1',
                  url: '',
                  icon: 'el-icon-circle-plus',
                  children: [
                    {
                      id: '1-1',
                      label: '主合同基本信息',
                      url: 'con_info_ht',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType,
                        conSrc: this.conSrc

                      },
                      icon: 'el-icon-tickets'
                    },
                    {
                      id: '1-2',
                      label: '主合同明细信息',
                      url: 'con_detail_ht',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        jspName: this.jspName,
                        productType: this.productType,
                        amountDetailId: this.amountDetailId,
                        cycleIndCon: mydata.conInfo.cycleIndCon,
                        syndicatedObjectCd: this.syndicatedObjectCd
                      },
                      icon: 'el-icon-tickets'
                    }
                  ]
                }

              ]
            }

            this.menuTree.push({
              label: '从合同信息',
              id: '2',
              url: '',
              icon: 'el-icon-circle-plus',
              children: [
                {
                  id: '2-1',
                  label: '抵押合同',
                  url: 'con_dy_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '01',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-2',
                  label: '质押合同',
                  url: 'con_zy_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '02',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-3',
                  label: '保证合同',
                  url: 'con_bzr_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '04',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-4',
                  label: '关联保证金',
                  url: 'con_bzj_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '03',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag,
                    proFlag_s: this.proFlag_s
                  },
                  icon: 'el-icon-tickets'
                }
              ]

            })
          }

          if (mydata.contractType == '03') {
            console.log('contypename:' + this.contypename)
            this.menuTree = [
              {
                label: this.contypename,
                id: '1',
                url: '',
                icon: 'el-icon-circle-plus',
                children: [
                  {
                    id: '1-1',
                    label: '主合同基本信息',
                    url: 'con_info_ht',
                    params: {
                      contractId: this.contractId,
                      proFlag: this.proFlag,
                      productType: this.productType,
                      conSrc: this.conSrc

                    },
                    icon: 'el-icon-tickets'
                  },
                  {
                    id: '1-2',
                    label: '主合同明细信息',
                    url: 'con_detail_ht',
                    params: {
                      contractId: this.contractId,
                      proFlag: this.proFlag,
                      jspName: this.jspName,
                      productType: this.productType,
                      amountDetailId: this.amountDetailId,
                      cycleIndCon: mydata.conInfo.cycleIndCon,
                      syndicatedObjectCd: this.syndicatedObjectCd
                    },
                    icon: 'el-icon-tickets'
                  }
                ]
              }

            ]

            this.menuTree.push({
              label: '从合同信息',
              id: '2',
              url: '',
              icon: 'el-icon-circle-plus',
              children: [
                {
                  id: '2-1',
                  label: '抵押合同',
                  url: 'con_dy_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '01',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-2',
                  label: '质押合同',
                  url: 'con_zy_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '02',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-3',
                  label: '保证合同',
                  url: 'con_bzr_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '04',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag
                  },
                  icon: 'el-icon-tickets'
                },
                {
                  id: '2-4',
                  label: '关联保证金',
                  url: 'con_bzj_list',
                  params: {
                    contractId: this.contractId,
                    subcontractTypeCd: '03',
                    applyId: this.applyId,
                    contractType: '02',
                    partyId: this.partyId,
                    proFlag: this.proFlag,
                    proFlag_s: this.proFlag_s
                  },
                  icon: 'el-icon-tickets'
                }
              ]

            })
          }
        } else if (this.bizType == '04' || this.bizType == '06') { // 小微
          this.currentView = con_info_ht_xw

          this.paramsConTree = {
            contractId: this.contractId,
            proFlag: this.proFlag,
            productType: this.productType
          }
          console.log('currentView..' + JSON.stringify(this.currentView))
          console.log('params....' + JSON.stringify(this.paramsConTree))

          if (this.productType.substr(0, 5) == '02002' || this.productType == '02005003' || this.productType == '02005001') { // 房贷
            this.menuTree = [
              {
                label: this.contypename,
                id: '1',
                url: '',
                icon: 'el-icon-circle-plus',
                children: [
                  {
                    id: '1-1',
                    label: '主合同基本信息',
                    url: 'con_info_ht_xw',
                    params: {
                      contractId: this.contractId,
                      proFlag: this.proFlag,
                      productType: this.productType
                    },
                    icon: 'el-icon-tickets'
                  },
                  {
                    id: '1-2',
                    label: '主合同明细信息',
                    url: 'con_detail_ht_xw_house',
                    params: {
                      contractId: this.contractId,
                      proFlag: this.proFlag,
                      productType: this.productType,
                      amountDetailId: this.amountDetailId
                    },
                    icon: 'el-icon-tickets'
                  }
                ]
              }

            ]
          } else {
            if (this.cycleIndCon == '1') {
              // 循环类合同
              this.menuTree = [
                {
                  label: '单笔业务项下主合同',
                  id: '1',
                  url: '',
                  icon: 'el-icon-circle-plus',
                  children: [
                    {
                      id: '1-1',
                      label: '主合同基本信息',
                      url: 'con_info_ht_xw',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType
                      },
                      icon: 'el-icon-tickets'
                    },
                    {
                      id: '1-2',
                      label: '主合同明细信息',
                      url: 'con_detail_ht_xw_cycle',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType,
                        amountDetailId: this.amountDetailId
                      },
                      icon: 'el-icon-tickets'
                    }
                  ]
                }

              ]
            } else {
              this.menuTree = [
                {
                  label: '单笔业务项下主合同',
                  id: '1',
                  url: '',
                  icon: 'el-icon-circle-plus',
                  children: [
                    {
                      id: '1-1',
                      label: '主合同基本信息',
                      url: 'con_info_ht_xw',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType
                      },
                      icon: 'el-icon-tickets'
                    },
                    {
                      id: '1-2',
                      label: '主合同明细信息',
                      url: 'con_detail_ht_xw_uncycle',
                      params: {
                        contractId: this.contractId,
                        proFlag: this.proFlag,
                        productType: this.productType,
                        amountDetailId: this.amountDetailId
                      },
                      icon: 'el-icon-tickets'
                    }
                  ]
                }

              ]
            }
          }

          // 小薇合同通用的
          this.menuTree.push({
            label: '从合同信息',
            id: '2',
            url: '',
            icon: 'el-icon-circle-plus',
            children: [
              {
                id: '2-1',
                label: '抵押合同',
                url: 'con_dy_list',
                params: {
                  contractId: this.contractId,
                  subcontractTypeCd: '01',
                  applyId: this.applyId,
                  contractType: '02',
                  partyId: this.partyId,
                  proFlag: this.proFlag
                },
                icon: 'el-icon-tickets'
              },
              {
                id: '2-2',
                label: '质押合同',
                url: 'con_zy_list',
                params: {
                  contractId: this.contractId,
                  subcontractTypeCd: '02',
                  applyId: this.applyId,
                  contractType: '02',
                  partyId: this.partyId,
                  proFlag: this.proFlag
                },
                icon: 'el-icon-tickets'
              },
              {
                id: '2-3',
                label: '保证合同',
                url: 'con_bzr_list',
                params: {
                  contractId: this.contractId,
                  subcontractTypeCd: '04',
                  applyId: this.applyId,
                  contractType: '02',
                  partyId: this.partyId,
                  proFlag: this.proFlag
                },
                icon: 'el-icon-tickets'
              },
              {
                id: '2-4',
                label: '关联保证金',
                url: 'con_bzj_list',
                params: {
                  contractId: this.contractId,
                  subcontractTypeCd: '03',
                  applyId: this.applyId,
                  contractType: '02',
                  partyId: this.partyId,
                  proFlag: this.proFlag,
                  proFlag_s: this.proFlag_s
                },
                icon: 'el-icon-tickets'
              }
            ]

          })
        } else {
          // 这种数据基本为数据迁移问题
          alert('错误的业务性质TB_BIZ_APPROVE.BIZ_TYPE[XD_SXYW0002->' + this.bizType + ']')
          return false
        }

        // 剩下的页面主要是一些公共的信息
        if (mydata.contractType != '01') {
          this.menuTree.push({
            label: '账户信息',
            id: '3',
            url: 'account_list',
            params: { contractId: this.contractId, proFlag: this.proFlag },
            icon: 'el-icon-circle-plus'

          })
        }

        // 意见提交
        if (this.proFlag != '-1') {
          this.menuTree.push({
            label: '意见',
            id: '4',
            url: '/com.bos.bps.service.workFlowAdvice.flow', // 工作流，还没有接入
            params: {
              bizId: this.contractId,
              processInstId: this.processInstId,
              isSrc: '2',
              amountDetailId: this.amountDetailId,
              productType: this.productType,
              contractId: this.contractId,
              contractNum: mydata.conInfo.contractNum
            },
            icon: 'el-icon-circle-plus'

          })
        }

        // nodeclick({"node":menudata[0].children[0]})
      }).catch((error) => {
        console.log(error)
        console.log('查询合同明细信息报错')
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
    open() {
      this.dialogVisible = true
    },
    handleGoodsDetailInfoClose: function(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          // this.currentView = "summaryInfo";
          // 这个代码加入是确保能 够修改父组件的布尔值，能够将值重置为false，能够重复打开模态框 2019/2/22
          this.$set(this.paramsInfo, 'conTreeVisiable', false)

          done()
        })
        .catch(_ => {
        })
    },

    /* 树方法开始*/
    handleNodeClick(item, node, self) { // 2019年1月31日14:33:19  点击选中
      console.log('[handleNodeClick]item:' + JSON.stringify(item))
      this.paramsConTree = item.params

      if (item.url == null) {
        return false
      }

      if (item.label == '意见') {
        if (this.proFlag == '1') {
          const param1 = { contractId: item.params.contractId, processInstId: item.params.processInstId }
          // 点击意见时将授权参数传到流程区域
          saveConInfoToPro(param1).then(response1 => {
            const res = response1.data
            console.log('[saveConInfoToPro]:' + res)
          }).catch((error) => {
            console.log(error)
          })
        }
      }

      if (item.label == '主合同明细信息') {
        const param1 = { param: item.params.contractId, name: 'RCON_0003' }
        // 合同基本信息保存校验
        RuleEngineMapper(param1).then(response1 => {
          const res = response1.data
          console.log('RCON_0003 [RuleEngineMapper]:' + res)
          if (res == 0) {
            alert('合同基本信息未保存')
          }
        }).catch((error) => {
          console.log(error)
        })
      }

      this.currentView = item.url
      console.log('currentView is:' + item.url)
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
