<template>
  <div>
    <div>
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
              </el-row>
            </el-header>
            <el-main style="padding:10px;margin: 10px;margin-top:5px;margin-bottom:5px;border: 1px solid #E4E7ED;">
              <component v-bind:is="currentView" v-bind:info="info" :paramToCheckInfo="paramToCheckInfo"></component>
              <!--<ImportantCheckInfo v-bind:is="currentView" v-bind:info="info" :paramToCheckInfo="paramToCheckInfo"></ImportantCheckInfo>
              <ImportantCheckEventInfo v-bind:is="currentView1" v-bind:info="info" :paramToCheckInfo="paramToCheckInfo"></ImportantCheckEventInfo>-->
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
 // import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import ImportantCheckInfo from './ImportantCheckInfo'//基本信息
  import ImportantCheckEventInfo from './ImportantCheckEventInfo'//基本信息
  import {queryImportantCheck} from '@/api/Afterloan'
  export default {
    name: "importantCheck",
    data() {
      return {
        disableRowButtons: true,
        paramToCheckInfo:{//用于向子组件传递参数

        },
        dialogVisible:false,//对话框
        fullScreen:true,//是否全屏
        currentView:"ImportantCheckInfo",

        data: [
          {
            label: '重点检查信息',
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
            label: '重大事件',
            id:'2',
            icon:'el-icon-menu',
            children: [
              {
                id:'2-1',
                label: '事件信息',
                icon:'el-icon-document',
              }
            ]
          },
          {
            id:"3",
            label: '影像资料',
            icon:'el-icon-menu',
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
              { label: '合同编号', inputType: 'input', modelName: 'contractNum' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isCheckRadio:true,//是否单选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户编号', prop: 'partyId', isSort: true },
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '合同编号', prop: 'contractNum', isSort: true },
              { label: '合同金额', prop: 'contractAmt', isSort: true },
              { label: '已用合同金额', prop: 'conBalance', isSort: true },
              { label: '合同起期', prop: 'beginDate', isSort: true },
              { label: '合同止期', prop: 'endDate', isSort: true },
              { label: '上次重点检查日期', prop: 'createDate', isSort: true },
            ]
          },
          buttons: [
            { label: '创建', funcName: 'create' }
          ]
        }
      }
    },
    components: { CscSingleTable,ImportantCheckInfo,ImportantCheckEventInfo},

    methods: {
      doPageQuery(listQuery) {
        this.queryImportantCheck(listQuery)
      },

      queryImportantCheck(listQuery) {
        queryImportantCheck(listQuery).then(response => {
          this.entity = response.data
          this.$store.dispatch('setListLoading', false)
        }).catch((error) => {
          console.log(error)
        })
      },

      create(row){
        alert(JSON.stringify(row));
        if(row == null || row == ''){
          alert("请选择一条记录！")
          return false
        }

        this.paramToCheckInfo={
          dialogVisible:true,
          orgNum:row.orgNum,
          partyName:row.partyName,//客户名称
          contractNum:row.contractNum,
          contractAmt:row.contractAmt,
          conYuE:row.conYuE,
          beginDate:row.beginDate,
          endDate:row.endDate,
        }
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
          this.currentView='ImportantCheckInfo'
        } else if(item.id=='2-1'){
          //重大事件
          console.log("事件信息");
          this.currentView='ImportantCheckEventInfo'
        } else if(item.id=='3'){
          //影像资料
          console.log("影像资料");
        } else if(item.id=='4'){
          //意见
          console.log("意见");
        }
      },



    },

  }
</script>

<style scoped>

</style>
