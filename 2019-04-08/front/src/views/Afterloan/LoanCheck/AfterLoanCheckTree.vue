<template>
  <div class="TestMainPage">
    <el-button @click="open" icon="el-icon-caret-bottom">打开</el-button>
    <el-dialog
      :visible.sync="dialogVisible"
      width="100%"
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
          <el-main style="padding:10px;margin: 10px;margin-top:5px;margin-bottom:5px;border: 1px solid #E4E7ED;">
            <compoment v-bind:is="currentView" v-bind:info="info"></compoment>
          </el-main>
        </el-container>
      </el-container>
    </el-dialog>
  </div>
</template>

<script>
  import CheckInfo from './CheckInfo'//基本信息
  import MoneyUseList from './MoneyUseList'//授信资金使用列表
    export default {
        name: "AfterLoanCheckTree",
      components:{
//        mortgageContract, 意见页面暂时没写
        CheckInfo,
        MoneyUseList
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
          currentView:"CheckInfo",
          info:{
            partyName:"巩化孙",//客户名称
            partyTypeCd:" 自然人客户 ",//客户类型
            certType:"居民身份证 ",//证件类型
            certNum:"14000019700417110X",//证件号码
            summaryAmt:" 800,000.00 ",//借据金额
            jjye:" 800,000.00 ",//借据余额
            beginDate:"2018-08-06",//借据起期
            endDate:"2019-07-26",//借据止期
            loanUse:"住房装修",//贷款用途
            userNum:"200555",//用户编号
            orgNum:"0700",//所属机构
          },
          data: [
            {
              label: '首次检查信息',
              id:'1',
              icon:'el-icon-menu',
              children: [
                {
                  id:'1-1',
                  label: '检查信息',
                  icon:'el-icon-document',
                }
              ]
            },
            {
              id:"2",
              label: '影像资料',
              icon:'el-icon-menu',
            },
            {
              id:'3',
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
            //检查信息
            console.log("检查信息");
            console.log("1111111111"+node);
            console.log("2222222222"+self);
          } else if(item.id=='2'){
            //影像资料
            console.log("影像资料");
          } else if(item.id=='3'){
            //意见
            console.log("意见");
          }
        },
      }
    }
</script>

<style scoped>

</style>
