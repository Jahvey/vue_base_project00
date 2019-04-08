<template>
    <div class="TestMainPage">
      <el-button @click="open" icon="el-icon-caret-bottom">打开</el-button>
      <el-dialog
        :visible.sync="dialogVisible"
        width="95%"
        v-if="dialogVisible"
        :fullscreen="fullScreen"
        :before-close="handleGoodsDetailInfoClose">
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
                <span class="custom-tree-node" slot-scope="{ node, data }">
                  <span>
                      <i class="el-icon-menu"></i>{{ node.label }}
                  </span>
                </span>
            </el-tree>
          </el-aside>
          <el-container>
            <el-header style="border: 1px solid #409EFF; margin: 10px;text-align: center;line-height: 40px" height="40px">
              <el-button type="text" size="medium">客户信息</el-button>
              <el-button type="text" size="medium">授信信息</el-button>
            </el-header>
            <el-main style="padding:10px;margin: 10px;margin-top:5px;margin-bottom:5px;border: 1px solid #E4E7ED;">
                <compoment v-bind:is="currentView" v-bind:info="info"></compoment>
            </el-main>
          </el-container>
        </el-container>
      </el-dialog>
    </div>
</template>

<script>

  import mortgageContractList from './SubContract/MortgageContract/MortgageContractList'//
  import pledgeContractList from './SubContract/PledgeContract/PledgeContractList'
  import guarantorContractList from './SubContract/GuarantorContract/GuarantorContractList'
  import depositContractList from './SubContract/DepositContract/DepositContractList'
    export default {
      name: "TestMainPage",
      components:{
        mortgageContractList,
        pledgeContractList,
        guarantorContractList,
        depositContractList
      },
      beforeMount(){
        //TODO 初始化数据，获取业务信息
/*        getBizInfo(this.info).then(response =>{

        });*/
      },
      data() {
        return {
          dialogVisible:false,//对话框
          fullScreen:true,//是否全屏
          currentView:"mortgageContractList",
          info:{//向子页面传递数据对象
/*            applyId:"ff8080816588a9070165892cd2b30147",//业务id
            partyId:"5AF8119078FEFABDE05010AC57DD79A2",//客户id 客户为：族满骑业宫借与狸侏牛
            contractId:"ff8080816588a90701658d53ea5c0411",//合同ID*/
            /*测试合同签约*/
            applyId:"ff808081655a216d01655b1499720630",//业务id
            contractId:"ff808081655a216d01655b5cdb5f0752",//合同ID contractId
            conPartyId:"ff808081655a216d01655b1037910619",//TODO 合同签订人的客户id,客户id 客户为：杜尤于
            /*测试合同签约最高额*/
            //applyId:"ff8080815f774104015f7ad75fa30cbe",//业务id
            //contractId:"ff80808165c279e60165c2be058101ab",//合同ID contractId
            //conPartyId:"5AF8118FE818FABDE05010AC57DD79A2",//TODO 合同签订人的客户id,
            partyId:"",//用来保存担保品的客户id
            subcontractType:"01",//担保合同类型 00即可抵押也可质押 01抵押 02质押 03保证金 04保证人 05信用保险
            contractType:"02",//TODO 不清楚 contractType=02 01关联综合授信协议  		02关联业务合同
            proFlag:"",//TODO 不清楚 控制增加、引入、编辑、删除操作按钮是否显示，//1：可修改。0：不可修改
            xgbz:"",//TODO 不清楚 控制增加、引入按钮是否显示


            userNum:"200555",//用户编号
            orgNum:"0700",//所属机构
          },
          data: [
            {
              label: '单笔业务项下主合同',
              id:'1',
              icon:'el-icon-menu',
              children: [
                {
                  id:'1-1',
                  label: '主合同基本信息',
                  icon:'el-icon-document',
                },
                {
                  id:'1-2',
                  label: '主合同明细信息',
                  icon:'el-icon-document',
                },
              ]
            },
            {
              id:"2",
              label: '从合同信息',
              icon:'el-icon-menu',
              children:
                [
                  {
                    id:'2-1',
                    label: '抵押合同',
                    icon:'el-icon-document',
                  },
                  {
                    id:'2-2',
                    label: '质押合同',
                    icon:'el-icon-menu',
                    },
                  {
                    id:'2-3',
                    label: '保证合同',
                    icon:'el-icon-menu',
                   },
                  {
                    id:'2-4',
                    label: '关联保证金',
                    icon:'el-icon-document',
                  },
                  ]
             },
            {
              id:'3',
              label: '账户信息',
              icon:'el-icon-document',
            },
            {
              id:'4',
              label: '意见',
              icon:'el-icon-document',
            },
          ],
          defaultProps: {
            children: 'children',
            label: 'label'
          }
        }
      },
      methods:{
        open:function () {
            this.dialogVisible=true;
        },
        handleGoodsDetailInfoClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              //this.currentView = "summaryInfo";
              done();
            })
            .catch(_ => {});
        },
        /*树方法开始*/
        handleNodeClick(item,node,self) {//2018-12-25  点击选中
          if(item.id=='1-1'){
            //主合同基本信息
            console.log("主合同基本信息");
          } else if(item.id=='1-2'){
            //业务明细
            console.log("主合同明细信息");
          }  else if(item.id=='2-1'){
            //抵押合同
            this.info.subcontractType='01';
            this.currentView="mortgageContractList";
          } else if(item.id=='2-2'){
            //质押合同
            this.info.subcontractType='02';
            this.currentView='pledgeContractList';
          } else if(item.id=='2-3'){
            //保证合同
            this.info.subcontractType='04';
            this.currentView='guarantorContractList';
          } else if(item.id=='2-4'){
            //关联保证金
            this.info.subcontractType='03';
            this.currentView='depositContractList';
          }  else if(item.id=='3'){
            //账户信息
            console.log("账户信息");
          } else if(item.id=='4'){
            //意见
            console.log("意见");
          }
        },
      }
    }
</script>

<style scoped>
.TestMainPage{
  width:100%;
  height:100%;
}
.el-dialog__header {
  /* padding: 15px; */
  padding-bottom: 10px !important;
}
/*.custom-tree-node {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  padding-right: 8px;
  background:#f00;
}*/
</style>
