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
              <!--动态组件-->
                <compoment v-bind:is="currentView" v-bind:info="info"></compoment>
            </el-main>
          </el-container>
        </el-container>
      </el-dialog>
    </div>
</template>

<script>
  import guarantor from './GuaranteeeValuation/Guarantor/Guarantor'//保证人
  import deposit from './GuaranteeeValuation/Deposit/Deposit'//保证金
  import creditInsurance from './GuaranteeeValuation/CreditinSurance/CreditInsurance'//信用保险
  import mortgageGoods from './GuaranteeeValuation/Mortgage/MortgageGoods'//抵押物
  import pledgeGoods from './GuaranteeeValuation/Pledge/PledgeGoods'//质押物
  import suggestion from './suggestion/Suggestion'//意见
  import { getBizInfo} from '@/api/securitymanagement'
    export default {
      name: "TestMainPage",
      components:{
        guarantor,
        deposit,
        creditInsurance,
        suggestion,
        mortgageGoods,
        pledgeGoods,
      },
      beforeMount(){
        //TODO 初始化数据，获取业务信息
        getBizInfo(this.info).then(response =>{

        });
      },
      data() {
        return {
          dialogVisible:false,//对话框
          fullScreen:true,//是否全屏
          currentView:"guarantor",
          info:{//向子页面传递数据对象
            //applyId:"402881e967bb82810168788f50bd0159",//业务id
            //partyId:"5AF8118FED19FABDE05010AC57DD79A2",//客户id
            applyId:"ff808081655a216d01655b1499720630",//业务id
            partyId:"ff808081655a216d01655b1037910619",//客户id
            processInstId:"",//流程ID
          },
          data: [
            {
              label: '业务结构',
              id:'1',
              icon:'el-icon-menu',
              children: [
                {
                  id:'1-1',
                  label: '基本信息',
                  icon:'el-icon-document',
                },
                {
                  id:'1-2',
                  label: '业务明细',
                  icon:'el-icon-document',
                },
                {
                  id:'1-3',
                  label: '家庭财务信息',
                  icon:'el-icon-document',
                },
                {
                  id:'1-4',
                  label: '合作项目额度信息',
                  icon:'el-icon-document',
                },
                {
                  id:'1-5',
                  label: '贴息信息',
                  icon:'el-icon-document',
                },
                {
                  id:'1-6',
                  label: '监管报送信息',
                  icon:'el-icon-document',
                },
              ]
            },
            {
              id:"2",
              label: '担保评价',
              icon:'el-icon-menu',
              children:
                [
                  {
                    id:'2-1',
                    label: '保证人',
                    icon:'el-icon-document',
                  },
                  {
                    id:'2-2',
                    label: '抵押',
                    icon:'el-icon-menu',
                    children:
                      [
                        {
                          id:'2-2-1',
                          label: '抵押物',
                          icon:'el-icon-document',
                        },
                        {
                          id:'2-2-2',
                          label: '最高额担保合同关联',
                          icon:'el-icon-document',
                        }
                      ]
                    },
                  {
                    id:'2-3',
                    label: '质押',
                    icon:'el-icon-menu',
                    children:
                      [
                        {
                          id:'2-3-1',
                          label: '质押物',
                          icon:'el-icon-document',
                        },
                        {
                          id:'2-3-2',
                          label: '最高额担保合同关联',
                          icon:'el-icon-document',
                        }
                      ]
                   },
                  {
                    id:'2-4',
                    label: '保证金',
                    icon:'el-icon-document',
                  },
                  {
                    id:'2-5',
                    label: '信用保险',
                    icon:'el-icon-document',
                  },
                  ]
             },
            {
              id:'3',
              label: '关联风险预警',
              icon:'el-icon-document',
            },
            {
              id:'4',
              label: '岗位责任',
              icon:'el-icon-document',
            },
            {
              id:'5',
              label: '业务同意发放通知书',
              icon:'el-icon-document',
            },
            {
              id:'6',
              label: '影像资料',
              icon:'el-icon-document',
            },
            {
              id:'7',
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
            //基本信息
            console.log("基本信息");
          } else if(item.id=='1-2'){
            //业务明细
            console.log("业务明细");
          } else if(item.id=='1-3'){
            //家庭财务信息
            console.log("家庭财务信息");
          } else if(item.id=='1-4'){
            //合作项目额度信息
            console.log("合作项目额度信息");
          } else if(item.id=='1-5'){
            //贴息信息
            console.log("贴息信息");
          } else if(item.id=='1-6'){
            //监管报送信息
            console.log("监管报送信息");
          } else if(item.id=='2-1'){
            //保证人
            this.currentView="guarantor";
          } else if(item.id=='2-2-1'){
            //抵押物
            this.currentView='mortgageGoods';
          } else if(item.id=='2-2-2'){
            //最高额担保合同关联-抵押物
          } else if(item.id=='2-3-1'){
            //质押物
            this.currentView='pledgeGoods';
          } else if(item.id=='2-3-2'){
            //最高额担保合同关联-质押物
          } else if(item.id=='2-4'){
            //保证金
            console.log("保证金");
            this.currentView='deposit';
          } else if(item.id=='2-5'){
            //信用保险
            console.log("信用保险");
            this.currentView='creditInsurance';
          } else if(item.id=='3'){
            //关联风险预警
            console.log("关联风险预警");
          } else if(item.id=='4'){
            //岗位责任
            console.log("岗位责任");
          } else if(item.id=='5'){
            //业务同意发放通知书
            console.log("业务同意发放通知书");
          } else if(item.id=='6'){
            //影像资料
            console.log("影像资料");
          } else if(item.id=='7'){
            //意见
            this.currentView='suggestion';
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
.custom-tree-node {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  padding-right: 8px;
  background:#f00;
}
</style>
