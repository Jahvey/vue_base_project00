<template>
  <div class="app-container">
    <csc-single-table
      :pageDef="pageDef"
      :entity="entity"
      :disableQueryForm="disableQueryForm"
      :disableRowButtons="disableRowButtons"
      @add="doAdd"
      @doEdit="doEdit"
      @pageQuery="doPageQuery"
      @rowChange="rowChange"
      @doDelete="doDelete"
      @rowDbclick="rowDbclick"
      @deleteBatch="deleteBatch"
    >
    </csc-single-table>
    <el-dialog
      title="修改信息"
      :visible.sync="mpGoodsDetailInfoDialogVisible"
      width="95%"
      fullscreen="true"
      v-if='mpGoodsDetailInfoDialogVisible'
      :before-close="handleGoodsDetailInfoClose">
      <el-row>
        <el-col :span="3">
          <el-menu
            default-active="1"
            class="el-menu-vertical-demo">
            <el-menu-item index="1" v-on:click="onMenuItemClick('1','')">
              <i class="el-icon-document"></i>
              <span slot="title">概况</span>
            </el-menu-item>
            <el-menu-item index="2" v-on:click="onMenuItemClick('2',transferData)">
              <i class="el-icon-document"></i>
              <span slot="title">详细信息</span>
            </el-menu-item>
            <el-menu-item index="3" v-on:click="onMenuItemClick('3',transferData)">
              <i class="el-icon-document"></i>
              <span slot="title">保险信息</span>
            </el-menu-item>
            <el-menu-item index="4" v-on:click="onMenuItemClick('4',transferData)">
              <i class="el-icon-document"></i>
              <span slot="title">登记信息</span>
            </el-menu-item>
            <el-menu-item index="5" v-on:click="onMenuItemClick('5',transferData)">
              <i class="el-icon-document"></i>
              <span slot="title">公证信息</span>
            </el-menu-item>
            <el-menu-item index="6" v-on:click="onMenuItemClick('6',transferData)">
              <i class="el-icon-document"></i>
              <span slot="title">意外情况</span>
            </el-menu-item>
            <el-menu-item index="7" v-on:click="onMenuItemClick('7',transferData)">
              <i class="el-icon-document"></i>
              <span slot="title">过户信息</span>
            </el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="21">
          <!--动态组件-->
          <keep-alive>
            <compoment v-bind:is="currentView" v-bind:grtCollateralInfo="grtCollateralInfo" v-bind:isUpdate="isUpdate"></compoment>
          </keep-alive>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>
<script>
  import { selectGrtCollateralAll,deleteGrtCollateralById,deleteGrtCollateralBatch} from '@/api/securitymanagement'
  import salaryAccount from './mpDetailForSalaryAccount'//工资账户
  import landManageRight from './mpDetailForLandManageRight'//土地承包经营权
  import otherMp from './mpDetailForOtherMp' //其他
  import summaryInfo from './mpSummaryInfo'//概况信息
  import insuranceInfo from './mpInsuranceInfo'//保险信息
  import checkInInfo from './mpCheckInInfo'//登记信息
  import notarizationInfo from './mpNotarizationInfo'//公证信息
  import accidentInfo from './mpAccidentInfo'//意外信息
  import transferOwnership from './mpTransferOwnership'//过户信息
  import wareHouseReceipt from './mpDetailForWareHouseReceipt'//仓单信息
  import stock from './mpDetailForStock'//存货
  import chargeRight from './mpDetailForChargeRight'//收费权信息
  import depositReceipt from './mpDetailForDepositReceipt'//存单
  import bond from './mpDetailForBond'//债券
  import buildingProject from './mpDetailForBuildingProject'//在建工程
  import landUseRight from './mpDetailForLandUseRight'//土地使用权
  import ship from './mpDetailForShip'//船舶
  import forestRight from './mpDetailForForestRight'//林权
  import intellectualPropertyRight from './mpDetailForIntellectualPropertyRight'//知识产权
  import fundsOnAccount from './mpDetailForFundsOnAccount'//应收账款
  import stockRight from './mpDetailForStockRight'//股权
  import fund from './mpDetailForFund'//基金
  import bill from './mpDetailForBill'//票据
  import warranty from './mpDetailForWarranty'//保单
  import machineEquipment from './mpDetailForMachineEquipment'//机器设备
  import trafficTransportTool from './mpDetailForTrafficTransportTool'//交通运输工具
  import motorVehicle from './mpDetailForMotorVehicle'//机动车
  import agriculturalImplements from './mpDetailForAgriculturalImplements'//农机具
  import realEstate from './mpDetailRealEstate'//农机具
  import errorPage from './errorPage'//错误页面信息
  /*查询客户页面*/
  import personCustomerList from './personCustomerList'//个人客户查询页面
  import enums from "@/utils/enums"
  export default {
    name: "edit-mortgage-pledge",
    components:{
      summaryInfo,
      salaryAccount,
      landManageRight,
      otherMp,
      insuranceInfo,
      checkInInfo,
      notarizationInfo,
      accidentInfo,
      transferOwnership,
      wareHouseReceipt,
      stock,
      chargeRight,
      depositReceipt,
      bond,
      buildingProject,
      landUseRight,
      ship,
      forestRight,
      intellectualPropertyRight,
      fundsOnAccount,
      stockRight,
      fund,
      bill,
      warranty,
      machineEquipment,
      trafficTransportTool,
      motorVehicle,
      agriculturalImplements,
      personCustomerList,
      realEstate,
      errorPage,
    },
    beforeUpdate(){
      //alert(this.$store.getters.listLoading);
      //this.$store.commit("SET_LISTLOADING",false);
      //alert(this.$store.getters.listLoading);
    },
    data(){
      return {
        isUpdate:true,//是更新操作标志
        currentView:"summaryInfo",//当前页面
        grtCollateralInfo:{
          guarantyId:"",//抵质押物id(返回值)
          customerNum:"",//客户编号
          collateralTypeCd:"",//抵质押品类别
          collateralName:"",//抵质押品名称
          collateralNum:"",//抵质押物编号
          timeMark:"",//建档日期(呈报日期)D
          partyName:'',//客户名全称
          /*读取storage*/
          dataCreatUserNum:"200555",//抵质押物创建人用户编号
          dataCreatorOrgCd:"0700",//抵质押物创建人所属机构
          lastUpdateUserNum:"200555",//最后维护人用户编号
          lastUpdateOrgCd:"0700",//最后维护人所属机构
        },
        mpGoodsDetailInfoDialogVisible:false,//抵质押品详细信息填写dialog是否显示
        disableRowButtons:false,//每一行的修改、删除按钮是否显示(操作按钮)，false为要显示
        disableQueryForm:false,//是否显示查询表单,false为要显示
        entity: {},//数据实体，总条数等
        selectedRow:{},
        pageDef: {
          queryDef: {//查询列
            columnNum: 3, //一行几列
            queryCols: [//条件输入框
              {label: "抵质押人", inputType: "input", modelName: "partyName"},
              {label: "抵质押物类别", inputType: "select", modelName: "collateralTypeCd",enumType: "CollateralStatusCd"},
              {label: "客户类型", inputType: "select", modelName: "customerType", enumType: "CustomerClassCd"},
            ]
          },
          tabDef: {
            //只能有一个为true
            isExpand:false,//如果设置了 expand 则显示为一个可展开的按钮
            isSelect: true, //是否可以多选
            isIndex: false,  //是否有序号
            isCheckRadio:false,//设置表格是否可以单选
            mutiCheckParam: "guarantyId",//多选项时暂时只支持获取一个参数
            //表格字段定义
            tabCols: [
              //当前可接受的全部参数
              //{label: "机构名称", prop: "corpName",isFormat:true,isRef:false,isDateTime:false,isDate:false,isCustom:false}
              {label: "抵质押人", prop: "partyName"},
              {label: "抵质押物名称", prop: "collateralName"},
              {label: "抵质押物类别", prop: "collateralTypeCd",isFormat:true,enumType:"CollateralStatusCd"},
              {label: "认定价值(元)", prop: "marketValue"},
              {label: "币种", prop: "currencyCd",isFormat:true,enumType:"currencyCd"},
              {label: "客户类型", prop: "customerType",isFormat:true,enumType:"CustomerClassCd"},
              {label: "创建时间", prop: "timeMark"},
              {label: "是否绑定业务", prop: "isBind"},
            ]
          },
          buttons: [
            //{label: "新增", funcName: "add", disabled: false},
            //{label: "批量删除", funcName: "deleteBatch", disabled: false},
            //{label: "维护", funcName: "doEdit", disabled: false},
          ]
        }
      }
    },
    computed:{
      transferData:function () {
        var transferData={};
        transferData.collateralTypeCd = this.grtCollateralInfo.collateralTypeCd;
        return transferData;
      },
    },
    methods: {
      onMenuItemClick:function (index,obj) {//展示当前页面的逻辑
        if(index == '1'){
          this.currentView = "summaryInfo";
        } else if(index=="2"){
          if(obj.collateralTypeCd ==enums.mpType.GC_GZZH){//工资账户
            this.currentView = "salaryAccount";
          } else if(obj.collateralTypeCd == enums.mpType.GC_QT){//其他
            this.currentView = "otherMp";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_TDCBJYQ){//土地承包经营权
            this.currentView = "landManageRight";
          }else if(obj.collateralTypeCd ==enums.mpType.GC_CANGD){//仓单
            this.currentView = "wareHouseReceipt";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_CH){//存货
            this.currentView = "stock";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_SFQ){//收费权
            this.currentView = "chargeRight";
          }else if(obj.collateralTypeCd ==enums.mpType.GC_CD){//'12': '存单',
            this.currentView = "depositReceipt";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_ZJ){//债券
            this.currentView = "bond";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_ZJGC){//在建工程
            this.currentView = "buildingProject";
          }  else if(obj.collateralTypeCd ==enums.mpType.GC_TDSYQ){//土地使用权
            this.currentView = "landUseRight";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_CB){//船舶
            this.currentView = "ship";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_LQ){//林权
            this.currentView = "forestRight";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_ZSCQ){//知识产权
            this.currentView = "intellectualPropertyRight";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_YSZK){//应收账款
            this.currentView = "fundsOnAccount";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_GQ){//股权
            this.currentView = "stockRight";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_JJ){//基金
            this.currentView = "fund";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_PJ){//票据
            this.currentView = "bill";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_BD){//保单
            this.currentView = "warranty";
          }else if(obj.collateralTypeCd ==enums.mpType.GC_JQSB){//机器设备
            this.currentView = "machineEquipment";
          }else if(obj.collateralTypeCd == enums.mpType.GC_JTYSGJ){//交通运输工具*
            this.currentView = "trafficTransportTool";
          } else if(obj.collateralTypeCd == enums.mpType.GC_JDC){//机动车
            this.currentView = "motorVehicle";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_NJJ){ //农机具
            this.currentView = "agriculturalImplements";
          } else if(obj.collateralTypeCd ==enums.mpType.GC_FDC){//房地产
            this.currentView = "realEstate";
          } else{
            this.currentView = "errorPage";
          }
        } else if(index == "3"){
          this.currentView = "insuranceInfo";
        } else if(index == "4"){
          this.currentView = "checkInInfo";
        } else if(index == "5"){
          this.currentView = "notarizationInfo";
        } else if(index == "6"){
          this.currentView = "accidentInfo";
        } else if(index == "7"){
          this.currentView = "transferOwnership";
        }
      },
      rowChange(row){
        this.selectedRow = row
      },
      doPageQuery(listQuery){
        //alert(JSON.stringify(listQuery));
        listQuery.customerType = '02';
        selectGrtCollateralAll(listQuery).then(response => {
          if(response.data.flag == enums.stateCode.flag.success){//返回数据成功
            var myEntity = {};
            console.log(response.data.data.list)
            myEntity.total=response.data.data.total;
            myEntity.data = response.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '获取数据失败啦！'+JSON.stringify(response),
              type: 'error'
            });
          }
        })
      },
      doAdd(){

      },

      doEdit(row){
        this.grtCollateralInfo.guarantyId = row.guarantyId;
        this.grtCollateralInfo.customerNum = row.partyNum;
        this.grtCollateralInfo.collateralTypeCd = row.collateralTypeCd;
        this.grtCollateralInfo.collateralName = row.collateralName;
        this.grtCollateralInfo.collateralNum = row.collateralNum;
        this.grtCollateralInfo.timeMark = row.timeMark;
        this.grtCollateralInfo.partyName = row.partyName;
        this.mpGoodsDetailInfoDialogVisible= true;
      },
      deleteBatch(row,listquery,index){
        if(row.length<=0){
          this.$message({
            message: '请选择要删除的数据!',
            type: 'error'
          });
          return;
        }
        this.$confirm('此操作将永久删除该单据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          deleteGrtCollateralBatch(row).then(response => {
            if(response.data.flag == enums.stateCode.flag.success){//
              this.$message({
                message: '删除机构信息成功',
                type: 'success'
              });
              this.$store.dispatch('setListLoading', true);
              this.doPageQuery(listquery);
            } else{
              this.$message({
                message: '删除失败!'+JSON.stringify(response.data),
                type: 'error'
              });
            }
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        });
      },
      doDelete(row,listquery,index){
        deleteGrtCollateralById(row).then(response => {
          if(response.data.flag == enums.stateCode.flag.success){//
            this.$message({
              message: '删除信息成功',
              type: 'success'
            });
            this.$store.dispatch('setListLoading', true);
            this.doPageQuery(listquery);
          } else if(response.data.flag == enums.stateCode.flag.fail){
            this.$message({
              message: JSON.stringify(response.data.message),
              type: 'error'
            });
          } else {
            this.$message({
              message: '删除失败!'+JSON.stringify(response.data),
              type: 'error'
            });
          }
        });
      },
      rowDbclick(row){
        this.$router.push({ name: 'orgEdit', query: { orgInfoId: row.orgInfoId,method:'detail' }})
      },
      handleGoodsDetailInfoClose:function (done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            this.currentView = "summaryInfo";
            done();
          })
          .catch(_ => {});
      },
    }
  }
</script>
