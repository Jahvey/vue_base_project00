<template>
  <div class="app-container">
    <el-row class="warp">
      <el-col :span="24">
        <fieldset>
          <legend>基本信息：</legend>
          <el-form ref="dashboard" :model="irmBaseInfo" label-width="140px">
            <el-col :span="8">
              <el-form-item label="客户编号" prop="partyNum">
                <el-input v-model="irmBaseInfo.party.partyNum" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="客户名称" prop="partyName">
                <el-input v-model="irmBaseInfo.party.partyName" disabled></el-input>
              </el-form-item>
              <el-checkbox v-if="irmBaseInfo.corporation" v-model="checked">企业成立未满 1 年或从事主要经营活动未满 1 年</el-checkbox>
            </el-col>
            <el-col :span="8" v-if="irmBaseInfo.corporation">
                <el-form-item label="评级类型" prop="pjlx">
                    <el-select v-model="irmBaseInfo.pjlx">
                        <el-option label="对公客户" value="3"></el-option>
                        <el-option label="担保公司" value="4"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            <el-col :span="8" v-if="irmBaseInfo.natural">
                <el-form-item  label="评级类型" prop="pjlx">
                    <el-select v-model="irmBaseInfo.pjlx">
                        <el-option label="消费性" value="1"></el-option>
                        <el-option label="经营性" value="2"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
            <el-form-item>
              <kt-button :label="$t('action.irmApply')" type="primary" @click="findTreeData()"/>
            </el-form-item>
            <el-form-item>
              <kt-button :label="$t('action.view')" type="primary" @click="handleView()"/>
            </el-form-item>
          </el-form>
        </fieldset>
        <fieldset>
          <legend>评级历史信息：</legend>
          <csc-single-table
            :pageDef="pageDef"
            :entity="entity"
            :disableQueryForm="disableQueryForm"
            @pageQuery="doPageQuery"
            @doView="doView"
            @doIrm ="doIrm"
          >
          </csc-single-table>
        </fieldset>
      </el-col>
    </el-row>

    <el-dialog  title="评级详情" width="80%" :visible.sync="dialogVisible" :close-on-click-modal="false">
      <financial-view-report-j :irmBaseInfo="irmBaseInfo">

      </financial-view-report-j>
      <div><h4>非财务信息</h4>
          <csc-single-table
                :pageDef= "pageDef_nonFinInfoS"
                :entity= "entity_nonFinInfoS"
                :disableQueryForm= "false"
                @pageQuery= "doPageQuery_nonFinInfoS"
                :autoQuery= "false"
                :disableRowButtons="true"
                :disableQueryButtons="true"
              >
          </csc-single-table>
      </div>
      <div><h4>通用评级调整项信息</h4>
          <csc-single-table
                :pageDef= "pageDef_OptionInfo"
                :entity= "entity_OptionInfo"
                :disableQueryForm="false"
                @pageQuery= "queryOpitionInfo"
                :autoQuery="false"
                :disableRowButtons="true"
                :disableQueryButtons="true"
              >
          </csc-single-table>
      </div>
      <div><h4>推翻历史</h4>
          <csc-single-table
                :pageDef= "pageDef_OverRecord"
                :entity= "entity_OverRecord"
                :disableQueryForm="false"
                @pageQuery= "queryOverRecordInfo"
                :autoQuery="false"
                :disableRowButtons="true"
                :disableQueryButtons="true"
              >
          </csc-single-table>
      </div>
      <span style="padding-top:30px">
        <el-button size="small" type="primary" @click="dialogVisible = false">关闭</el-button>
      </span>
    </el-dialog>
    <el-dialog title="" width="80%" v-if="dialogVisible_irmTree" :visible.sync="dialogVisible_irmTree" :close-on-click-modal="false">
        <irm-tree :irmBaseInfo_irmTree="irmTreeParams"></irm-tree>
    </el-dialog>
  </div>
</template>
<script>
  import {isEmpty} from "@/utils/validate"
  import FinancialViewReportJ from "@/views/IrmApply/FinancialViewReportJ"
  import IrmTree from "@/views/IrmApply/IrmTree"
  import Vue from 'vue'
  Vue.component('irm-tree', IrmTree)
  export default {
    
    data(){
      return {
        irmApply_BaseDt:{},//评级申请页面自定义值
        dialogVisible: false,
        dialogVisible_irmTree: false,
        checked: false,
        disableQueryForm:true,
        party: {
          partyName: '账传何奕挡悟与狸侏牛',
          partyNum: '022000243867',
          orgPjlx: '3',
          pjlx:'1',
          partyId: '5AF8118FED19FABDE05010AC57DD79A2'
          //5AF8118FED19FABDE05010AC57DD79A2//对私客户
          //5AF811909386FABDE05010AC57DD79A2//对公客户
        },
        irmTreeParams:{},
        irmBaseInfo:{pjlx:'1',party:{partyNum:'',partyName:'',orgPjlx:'',pjlx:'',partyId:''}},
        irmBaseInfo_irmTree: {},
        entity: {},
        entity_nonFinInfoS: {},
        entity_OptionInfo: {},
        entity_OverRecord: {},
        selectedRow:{},
        pageDef: {
          queryDef: {
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "客户名称", prop: "partyName"},
              {label: "评级日期", prop: "ratingDt"},
              {label: "贷款性质", prop: "ratingType"},
              {label: "信用等级", prop: "creditRatingCd"},
              {label: "起始日期", prop: "effectiveStartDt"},
              {label: "到期日期", prop: "effectiveEndDt"},
              {label: "是否有效评级", prop: "ratingState"},
              {label: "经办人", prop: "userNum"},
              {label: "经办机构", prop: "orgNum"}
            ]
          },
          buttons: [{label:"发起评级",type:"primary",funcName:"doIrm",visible:true}],
          rowButtons:[
            {label:"查看",type:"success",funcName:"doView",visible:true}
          ]
        },
        pageDef_nonFinInfoS: {
          queryDef: {
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "指标", prop: "indexName"},
              {label: "指标选项", prop: "indexOption"},
              {label: "备注", prop: "remarks"}
            ]
          }
        },
        pageDef_OptionInfo: {
          queryDef: {
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "调整编号", prop: "adjustOrder"},
              {label: "分类", prop: "adjustTypeCd"},//XD_PJCD0014
              {label: "调整事项", prop: "adjustOptionDescription"},
              {label: "是否存在", prop: "checked"},
              {label: "备注", prop: "remarks"}
            ]
          }
        },
        pageDef_OverRecord: {
          queryDef: {
          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "是否推翻", prop: "isOverthrow"},//XD_0002
              {label: "经办人", prop: "userNum"},
              {label: "经办机构", prop: "orgNum"},
              {label: "推翻后评级结果", prop: "creditRatingDisplay"},//afterGrade没有 只有creditRatingDisplay
              {label: "推翻日期", prop: "overthrowDT"},
              {label: "推翻原因", prop: "overthrowReason"},
              {label: "违约概率（PD2）", prop: "avagPD"}
            ]
          }
        }
        
      }
    },
    methods: {
      init: function(){
        this.irmBaseInfo.thirdPartyTypeCd = ''//第三方客户类型  前页面传入
        this.irmBaseInfo.userNum = ''//JspUtil.getStrHaveSign(GitUtil.getCurrentUserId())当前登录ID
        this.$api.irm_irm.queryCusInfo({partyId: this.party.partyId}).then((res) => {
            if(res && res.data && res.data.code == 200){//返回数据成功
              if(res.corporation){
                this.irmBaseInfo.corpCustomerTypeCd = res.corporation.corpCustomerTypeCd//对公客户类型corporation.corpCustomerTypeCd
                this.irmBaseInfo.thirdCustTypeCd = res.corporation.thirdCustTypeCd//o.corporation.thirdCustTypeCd
                this.irmBaseInfo.corporation = res.data.corporation
              }
              if(res.data.natural){
                this.irmBaseInfo.natural = res.data.natural
              }
              this.irmBaseInfo.party = res.data.party
              this.irmBaseInfo.partyTypeCd = res.data.party.partyTypeCd//party.partyTypeCd
            } else{
              this.$message({
                message: '查询客户基本信息失败！',
                type: 'error'
              });s
            }
          }).catch((res) => {
            this.$message({message: '查询客户基本信息失败, 错误信息：' + res, type: 'error'})
            console.error('查询客户基本信息失败, 错误信息：' + res)
        })
      },
      doPageQuery: function(){
        this.$store.dispatch('setListLoading', true);
        let query =  {partyId: this.party.partyId}
        this.$api.irm_irm.queryPaginationIrm(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询评级信息信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询评级信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询评级信息失败, 错误信息：' + res)
        })
      },
      doPageQuery_nonFinInfoS: function(applyId){
        let query =  {applyId: applyId}
        this.$api.irm_irm.queryReportNonFinanceinfo(query).then((res) => {
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total = res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity_nonFinInfoS = myEntity;
          } else{
            this.$message({
              message: '查询评级非财务信息失败！',
              type: 'error'
            });
          }
        }).catch((res) => {
          this.$message({message: '初始查询评级非财务信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询评级非财务信息失败, 错误信息：' + res)
        })
      },
      queryOpitionInfo(applyId){
        let query =  {applyId: applyId}
        this.$api.irm_irm.queryOpitionInfo(query).then((res) => {
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total = res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity_OptionInfo = myEntity;
          } else{
            this.$message({
              message: '查询通用评级调整项信息失败！',
              type: 'error'
            });
          }
        }).catch((res) => {
          this.$message({message: '初始查询通用评级调整项信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询通用评级调整项信息失败, 错误信息：' + res)
        })
      },
      queryOverRecordInfo(applyId,oldApplyId){
        let query =  {applyId: applyId,oldApplyId: oldApplyId}
        this.$api.irm_irm.queryOverRecordInfo(query).then((res) => {
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total = res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity_OverRecord = myEntity;
          } else{
            this.$message({
              message: '查询推翻历史信息失败！',
              type: 'error'
            });
          }
        }).catch((res) => {
          this.$message({message: '初始查询推翻历史信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询推翻历史信息失败, 错误信息：' + res)
        })
      },
      doView: function(row){
        this.queryCustInfoJj({partyId: this.party.partyId,applyId: row.iraApplyId})
        
      },
      //查询评级基本信息
      queryCustInfoJj(data){
        this.doPageQuery_nonFinInfoS(data.applyId);
        this.queryOpitionInfo(data.applyId);
        this.queryOverRecordInfo(data.applyId,this.irmBaseInfo.irmApply.original_IRA_APPLY_ID);
      },
      doIrm: function(){
        //判断评级类型
        if('' == this.irmBaseInfo.pjlx){
          alert('请选择评级类型！')
          return
        }
        //判断 是否 有在途业务 PJSQ_0001
        
        if(this.irmBaseInfo.thirdPartyTypeCd == "1"){
          //非当前客户管户经理，无法操作
        }else{
          alert('规则CSM_0205判断 非当前客户管户经理，无法操作')
        }
        alert('规则XFE_0002判断 参与移交的客户不允许做流程业务')
        //企业规模认定只对企业客户，对私、个体工商户不需要
        //发起评级之前 需要先做企业规模认定
        if("1" != this.irmBaseInfo.thirdPartyTypeCd){
          alert("规则RBIZ_0071做 企业规模认定")
        }
        
        let data={
          partyId: this.irmBaseInfo.party.partyId,
          choose: this.checked,
          pjlx: this.irmBaseInfo.pjlx
          }
        this.$api.irm_irm.createIrmApply(data).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            this.irmTreeParams.partyId= this.party.partyId
            this.irmTreeParams.iraApplyId = res.data.irmApply.ira_APPLY_ID
            this.irmTreeParams.processInstId = res.data.processInstId
            this.irmTreeParams.proFlag = 1
            this.irmTreeParams.pjlx = this.party.orgPjlx
            this.dialogVisible_irmTree = true
            
          } else{
            this.$message({
              message: res.data.msg,
              type: 'error'
            });
          }
        }).catch((res) => {
          this.$message({message: '初始查询评级信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询评级信息失败, 错误信息：' + res)
        })
      }
    },
    mounted() {
      this.init()
    }
  }
</script>
