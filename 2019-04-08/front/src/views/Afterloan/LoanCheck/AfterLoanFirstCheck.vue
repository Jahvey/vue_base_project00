<template>
  <div>
    <div class="TestMainPage">
      <!--<el-button @click="open" type="primary" style="text-align: left">创建</el-button>-->
      <el-dialog
        :visible.sync="paramToCheckInfo.dialogVisible"
        width="100%"
        v-if="paramToCheckInfo.dialogVisible"
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
              <CheckInfo v-bind:is="currentView" v-bind:info="info" :paramToCheckInfo="paramToCheckInfo"></CheckInfo>
            </el-main>
          </el-container>
        </el-container>
      </el-dialog>
    </div>
    <csc-single-table
      :disableRowButtons='disableRowButtons'
      :pageDef="pageDef"
      :entity="entity"
      @pageQuery="doPageQuery"
      @create="create"
      @doEdit="doEdit"
      @doDelete="doDelete"
      @rowDbclick="rowDbclick">
    </csc-single-table>
  </div>
</template>

<script>
  import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryBorList} from '@/api/Afterloan'
  import CheckInfo from './CheckInfo'//基本信息

  export default {
    name: "afterLoanFirstCheck",
    data() {
      return {
        paramToCheckInfo:{//用于向子组件传递参数

        },
        disableRowButtons: true,

        dialogVisible:false,//对话框
        fullScreen:true,//是否全屏
        currentView:"CheckInfo",
        paramsInfo:{

        },
        form:{
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
        },
        entity: {
        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' },
              { label: '借据编号', inputType: 'input', modelName: 'summaryNum' },
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' }
            ]
          },
          buttons: [
            { label: '创建', funcName: 'create' }
          ],
          tabDef: {
            isSelect: false, // 是否可以多选
            isIndex: true, // 是否有序号
            isCheckRadio:true,
            // 表格字段定义
            tabCols: [
              { label: '客户编号', prop: 'partyNum', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '借据编号', prop: 'summaryNum', isSort: true },
              { label: '借据金额', prop: 'summaryAmt', isSort: true },
              { label: '借据余额', prop: 'jjye', isSort: true },
              { label: '借据起期', prop: 'beginDate', isSort: true },
              { label: '借据止期', prop: 'endDate', isSort: true },
              { label: '完成情况', prop: 'finishDes', isSort: true },
            ]
          },
          /*buttons: [
            { label: '创建', funcName: 'create' }
          ]*/
        }
      }
    },
    components: { CscSingleTable,CscFormDialog3,CheckInfo},

    methods: {
      doPageQuery(listQuery) {
        this.queryBorList(listQuery)
      },

      queryBorList(listQuery) {
        queryBorList(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },
      create(row){
        alert(JSON.stringify(row));
        if (row==null || row == '') {
          alert("请选中一条记录!")
          return false
        }

        this.paramToCheckInfo={
          dialogVisible:true,
          partyName:row.partyName,//客户名称
          partyTypeCd:row.partyTypeCd,//客户类型
          certType:row.certType,//证件类型
          certNum:row.certNum,//证件号码
          summaryAmt:row.summaryAmt,//借据金额
          jjye:row.jjye,//借据余额
          beginDate:row.beginDate,//借据起期
          endDate:row.endDate,//借据止期
          loanUse:row.loanUse,//贷款用途
          checkPerson:row.checkPerson,//检查人
          firstCheckId:row.firstCheckId,//首次检查编号
          checkCount:row.checkCount,//检查次数
          summaryId:row.summaryId
        }
          // this.dialogVisible=true;
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
        } else if(item.id=='2'){
          //影像资料
          console.log("影像资料");
        } else if(item.id=='3'){
          //意见
          console.log("意见");
        }
      },

    },

  }
</script>

<style scoped>
  .buttons{
    margin-left: 10px;
  }
</style>
