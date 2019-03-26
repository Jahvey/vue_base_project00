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
              </el-row>
            </el-header>
            <el-main style="padding:10px;margin: 10px;margin-top:5px;margin-bottom:5px;border: 1px solid #E4E7ED;">
              <DailyCheckInfo v-bind:is="currentView" v-bind:info="info" :paramToCheckInfo="paramToCheckInfo"></DailyCheckInfo>
            </el-main>
          </el-container>
        </el-container>
      </el-dialog>
    </div>
    <!--<el-button type="primary" icon="el-icon-edit" @click="create">创建</el-button>-->
    <csc-single-table :disableRowButtons='disableRowButtons' :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
                      @doDelete="doDelete"  @rowDbclick="rowDbclick">
    </csc-single-table>
    <div style="margin-top: 10px">
      <el-form :inline="true" :model="formInline" class="demo-form-inline" style="text-align: left">
        <el-form-item label="日常检查类型：">
          <el-select v-model="formInline.region" placeholder="-- 请选择 --">
            <el-option label="个人贷款后跟踪检查表" value="01"></el-option>
            <el-option label="房地产项目跟踪检查表" value="02"></el-option>
            <el-option label="贸易型企业跟踪检查表" value="03"></el-option>
            <el-option label="生产型企业跟踪检查表" value="04"></el-option>
            <el-option label="学校、医院贷款跟踪检查表" value="05"></el-option>
            <el-option label="贸易型企业日常检查报告" value="06"></el-option>
            <el-option label="生产型企业日常检查报告" value="07"></el-option>
            <el-option label="贷款项目类企业日常检查报告" value="08"></el-option>
            <el-option label="委托贷款类日常检查报告" value="09"></el-option>
            <el-option label="个人经营类日常检查报告" value="10"></el-option>
            <el-option label="个人消费类日常检查报告" value="11"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="create">创 建</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import {queryDailycheckCust} from '@/api/Afterloan'
  import DailyCheckInfo from './DailyCheckInfo'//基本信息
  export default {
    name: "dailyCheck",
    data() {
      return {
        disableRowButtons: true,
        paramToCheckInfo:{//用于向子组件传递参数

        },
        dialogVisible:false,//对话框
        fullScreen:true,//是否全屏
        currentView:"DailyCheckInfo",
        data: [
          {
            label: '日常检查内容',
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
        formInline: {
          region: ''
        },
        pageDef: {
          // 查询条件定义
          queryDef: {
            columnNum: 3, // 一行几列
            queryCols: [
              { label: '客户名称', inputType: 'input', modelName: 'partyName' },
              { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'idTypeCd' },
              { label: '证件号码', inputType: 'input', modelName: 'certNum' }
            ]
          },
          tabDef: {
            isSelect: false, // 是否可以多选
            isCheckRadio:true,//是否单选
            isIndex: true, // 是否有序号
            // 表格字段定义
            tabCols: [
              { label: '客户名称', prop: 'partyName', isSort: true },
              { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
              { label: '证件号码', prop: 'certNum', isSort: true },
              { label: '货款金额', prop: 'amt', isSort: true },
              { label: '贷款余额', prop: 'balance', isSort: true },
              { label: '上次检查日期', prop: 'createDate', isSort: true }
            ]
          },
          buttons: [
            { label: '创建', funcName: 'create' }
          ]
        }
      }
    },
    components: { CscSingleTable,CscFormDialog3,DailyCheckInfo},

    methods: {
      doPageQuery(listQuery) {
        this.queryDailycheckCust(listQuery)
      },

      queryDailycheckCust(listQuery) {
        queryDailycheckCust(listQuery).then(response => {
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

</style>
