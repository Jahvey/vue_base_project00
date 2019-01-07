<template>
    <div class="app-container">
        <el-row :gutter="20" type="flex" justify="center">
            <el-form ref="mpCustomerBasicInfoValidate" :model="grtCollateralInfo" :rules="rulesCustomerBasicInfo" label-width="120px" label-position="right">
              <el-col :span="24">
                <el-form-item  label="抵质押人类型" >
                  <el-radio-group v-model="grtCollateralInfo.customerType" @change="switchMyType" prop="mpType" disabled >
                    <el-radio :label="1">法人客户</el-radio>
                    <el-radio :label="2">个人客户</el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
              <el-col :span="24">
                <el-form-item label="客户类型" prop="partyTypeCd">
                  <el-select :disabled="inputComponentDisable"  v-model="grtCollateralInfo.partyTypeCd" placeholder="请选择" >
                    <el-option v-for="(value,key) in customerTypeOption" :key="key" :label="value" :value="key"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="24">
                  <el-form-item label="组织机构代码" prop="organizationCode">
                    <el-input :disabled="inputComponentDisable" v-model="grtCollateralInfo.organizationCode" ></el-input>
                  </el-form-item>
              </el-col>
              <el-col :span="24">
                <el-form-item label="客户编号" prop="customerNum">
                  <el-input disabled v-model="grtCollateralInfo.customerNum" ></el-input>
                </el-form-item>
              </el-col>
              <!--客户名全称开始-->
              <el-col :span="24">
                <el-form-item label="客户名全称" prop="customerFullName">
                  <el-popover
                    placement="top-start"
                    width="900"
                    v-model="customerPopoverIsVisible"
                    trigger="click">
                    <!--法人客户和个人客户查询界面不一样，所有这里用动态组件-->
                    <compoment v-bind:is="currentCustomerView" @customerInfo="customerInfo">
                    </compoment>
                    <el-input disabled="true" v-model="grtCollateralInfo.customerFullName" slot="reference" ></el-input>
                  </el-popover>
                </el-form-item>
              </el-col>
              <!--客户名全称结束-->
            </el-form>
        </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
            <el-button :disabled="inputComponentDisable" size="medium" type="primary" @click="doConfirmCustomerBasicInfo">{{buttonCommitState}}</el-button>
            <el-button size="medium" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
      <!--抵质押品基本信息dialog 开始-->
      <el-dialog
        title="选择添加信息"
        :visible.sync="mpGoodsBasicInfoDialogVisible"
        width="50%"
        :before-close="handleGoodsBasicInfoClose">
        <el-row :gutter="20">
            <el-form ref="mpGoodsBasicInfoValidate" :model="grtCollateralInfo" :rules="rulesMpGoodsBasicInfo" label-width="120px" label-position="right">
              <el-col :span="24">
                <el-form-item label="抵质押人" >
                  <el-input v-model="grtCollateralInfo.customerFullName" disabled="true"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="24">
                <el-form-item label="抵质押品类别" prop="collateralTypeCd">
                  <el-select v-model="grtCollateralInfo.collateralTypeCd" placeholder="请选择">
                    <el-option v-for="(value,key) in CollateralStatusCd" :key="key" :label="value" :value="key"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="24">
                <el-form-item label="抵质押品名称" prop="collateralName">
                  <el-input v-model="grtCollateralInfo.collateralName" ></el-input>
                </el-form-item>
              </el-col>
            </el-form>
        </el-row>
        <span slot="footer" class="dialog-footer">
          <el-button @click="mpGoodsBasicInfoDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="doConfirmMpGoodsBasicInfo">确 定</el-button>
        </span>
      </el-dialog>
      <!--抵质押品基本信息dialog 结束-->
      <el-dialog
        title="选择添加信息"
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
              <compoment v-bind:is="currentView" v-bind:grtCollateralInfo="grtCollateralInfo">
<!--                <summaryInfo/>
                <insuranceInfo/>
                <checkInInfo/>
                <notarizationInfo/>
                <accidentInfo/>
                <transferOwnership/>
                <salaryAccount/>
                <landManageRight/>
                <otherMp/>-->
              </compoment>
            </keep-alive>
          </el-col>
        </el-row>
      </el-dialog>
      <!--抵制押品详情信息dialog 开始-->
    </div>
</template>

<script>
  import {extend} from "@/utils/validate"

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
  import errorPage from './errorPage'//错误页面信息
  /*查询客户页面*/personCustomerList
  import personCustomerList from './personCustomerList'//个人客户查询页面
  import enums from "@/utils/enums"
  import { saveBasicCollateral} from '@/api/securitymanagement'

  export default {
        name: "add-mortgage-pledge",
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
          errorPage,
        },
      data(){
          return{
            currentCustomerView:"personCustomerList",//查询客户页面
            currentView:"summaryInfo",//当前页面
            grtCollateralInfo:{
              guarantyId:"",//抵质押物id(返回值)
              customerType:2,//抵质押人类型
              partyTypeCd:"",//客户类型
              customerNum:"",//客户编号
              collateralTypeCd:"",//抵质押品类别
              collateralName:"",//抵质押品名称
              collateralNum:"",//抵质押物编号
              timeMark:"",//建档日期(呈报日期)D
              customerFullName:'',//客户名全称
              organizationCode:'',//组织机构代码
              dataCreatUserNum:"200555",//抵质押物创建人用户编号
              dataCreatorOrgCd:"0700",//抵质押物创建人所属机构
              lastUpdateUserNum:"200555",//最后维护人用户编号
              lastUpdateOrgCd:"0700",//最后维护人所属机构
            },
            mpCustomerBasicInfo:{ //抵质押品客户信息
              mpType:2,//抵质押人类型
              customerType:'',//客户类型
              organizationCode:'',//组织机构代码
              customerNumber:'',//客户编号
              customerFullName:'',//客户名全称

              collateralTypeCd:'',//抵质押品类别
              mpGoodsName:'',//抵质押品名称
              mpGoodsNumber:'GN003',//抵质押物编号
              mpDate:"2018-09-12 20:31",//建档日期
            },
            mpGoodsBasicInfo:{
              collateralTypeCd:'',//抵质押品类别
              mpGoodsName:'',//抵质押品名称
              mpGoodsNumber:'GN003',//抵质押物编号
              mpDate:"2018-09-12 20:31",//建档日期
            },//抵质押品类型和名称基本信息
            customerPopoverIsVisible:false,//是否显示popover
            customerTypeOption:enums.PersonalTypePCode,//客户类型选项
            CollateralStatusCd:enums.CollateralStatusCd,//抵制押品类型
            queryCustomerParameter:{},//查询客户参数信息
            rulesCustomerBasicInfo:{
              customerType: [
                {
                  required: true,
                  message: "请选择抵质押人类型",
                  trigger: 'change'
                }
              ],
              partyTypeCd: [
                {
                  required: true,
                  message: "请选择客户类型",
                  trigger: 'blur'
                }
              ],
              organizationCode: [
                {
                  required: false,
                  message: "组织机构代码",
                  trigger: 'blur'},
                {
                  max: 100,
                  message: '长度不超过 100 个字符',
                  trigger: 'blur'
                }
              ],
              customerNum: [
                {
                  required: false,
                  message: "客户编号",
                  trigger: 'blur'},
                {
                  max: 100,
                  message: '长度不超过 100 个字符',
                  trigger: 'blur'
                }
              ],
              customerFullName: [
                {
                  required: true,
                  message: "请输入客户名全称",
                  trigger: 'blur'},
                {
                  max: 100,
                  message: '长度不超过 100 个字符',
                  trigger: 'blur'
                }
              ],
            },//客户基本信息校验
            rulesMpGoodsBasicInfo:{
              collateralTypeCd: [
                {
                  required: true,
                  message: "请选择抵质押品类型",
                  trigger: 'blur'
                }
              ],
              collateralName: [
                {
                  required: true,
                  message: "请输入抵质押品名称",
                  trigger: 'blur'},
                {
                  max: 100,
                  message: '长度不超过 100 个字符',
                  trigger: 'blur'
                }
              ],
            },//抵质押品基本信息校验
            mpGoodsBasicInfoDialogVisible: false,//抵质押品基本信息填写dialog是否显示
            mpGoodsDetailInfoDialogVisible:false,//抵质押品详细信息填写dialog是否显示
            inputComponentDisable:false,
            buttonCommitState:"确定",
          }
      },

      computed:{
          transferData:function () {
            var transferData={};
            transferData.collateralTypeCd = this.grtCollateralInfo.collateralTypeCd;
            return transferData;
          },
      },
       methods:{
         onMenuItemClick:function (index,obj) {//展示当前页面的逻辑
           if(index == '1'){
             this.currentView = "summaryInfo";
           } else if(index=="2"){
             this.currentView = "depositReceipt";
             return;

             if(obj.collateralTypeCd =='工资账户'){
               this.currentView = "salaryAccount";
             } else if(obj.collateralTypeCd =='其他'){
               this.currentView = "otherMp";
             } else if(obj.collateralTypeCd =='土地承包经营权'){
               this.currentView = "landManageRight";
             }else if(obj.collateralTypeCd =='仓单'){
               this.currentView = "wareHouseReceipt";
             } else if(obj.collateralTypeCd =='存货'){
               this.currentView = "stock";
             } else if(obj.collateralTypeCd =='收费权'){
               this.currentView = "chargeRight";
             }else if(obj.collateralTypeCd =='12'){//'12': '存单',
               this.currentView = "depositReceipt";
             } else if(obj.collateralTypeCd =='债券'){
               this.currentView = "bond";
             } else if(obj.collateralTypeCd =='在建工程'){
               this.currentView = "buildingProject";
             }  else if(obj.collateralTypeCd =='土地使用权'){
               this.currentView = "landUseRight";
             } else if(obj.collateralTypeCd =='船舶'){
               this.currentView = "ship";
             } else if(obj.collateralTypeCd =='林权'){
               this.currentView = "forestRight";
             } else if(obj.collateralTypeCd =='知识产权'){
               this.currentView = "intellectualPropertyRight";
             } else if(obj.collateralTypeCd =='应收账款'){
               this.currentView = "fundsOnAccount";
             } else if(obj.collateralTypeCd =='股权'){
               this.currentView = "stockRight";
             } else if(obj.collateralTypeCd =='基金'){
               this.currentView = "fund";
             } else if(obj.collateralTypeCd =='票据'){
               this.currentView = "bill";
             } else if(obj.collateralTypeCd =='保单'){
               this.currentView = "warranty";
             }else if(obj.collateralTypeCd =='机器设备'){
               this.currentView = "machineEquipment";
             }else if(obj.collateralTypeCd =='交通运输工具'){
               this.currentView = "trafficTransportTool";
             } else if(obj.collateralTypeCd =='机动车'){
               this.currentView = "motorVehicle";
             } else if(obj.collateralTypeCd =='农机具'){
               this.currentView = "agriculturalImplements";
             }else{
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
         doConfirmCustomerBasicInfo:function () { //提交客户信息校验
             this.$refs["mpCustomerBasicInfoValidate"].validate((valid) => {
               if(valid){
                  this.mpGoodsBasicInfoDialogVisible= true;
               } else{
                 this.$message({
                   message: '请将信息填写完整',
                   type: 'error'
                 });
               }
            });
         },
         doConfirmMpGoodsBasicInfo:function () { //提交抵质押品信息校验
           this.$refs["mpGoodsBasicInfoValidate"].validate((valid) => {
             if(valid){
               saveBasicCollateral(this.grtCollateralInfo).then(response =>{
                 if(response.data.flag=='true'){
                   console.log(response.data);
                   this.grtCollateralInfo.collateralNum = response.data.grtCollateral.collateralNum;
                   this.grtCollateralInfo.guarantyId = response.data.grtCollateral.guarantyId;
                   console.log(this.grtCollateralInfo);
                   this.grtCollateralInfo.timeMark = response.data.grtCollateral.timeMark;
                   this.$confirm('是否继续填写抵质押品信息？', '数据已提交！', {
                     confirmButtonText: '确定',
                     cancelButtonText: '取消',
                     type: 'warning'
                   }).then(() => {
                     //确定后，清空弹出框数据，客户基本信息内容不可编辑，弹出编辑详细信息dialog
                     this.mpGoodsDetailInfoDialogVisible = true;
                   }).catch(() => {
                     //取消后，清空弹出框数据，客户基本信息内容不可编辑
                     this.$message({
                       message: '你可在抵质押品维护继续编辑详情信息',
                       type: 'success'
                     });
                   });
                   this.mpGoodsBasicInfoDialogVisible= false;
                   //先暂时不重置表单，会导致详细页面拿不到数据
                   //this.$refs["mpGoodsBasicInfoValidate"].resetFields();
                   this.buttonCommitState = "已提交";
                   this.inputComponentDisable = true;
                 } else{
                   this.$message({
                     message: '提交失败'+JSON.stringify(response.data),
                     type: 'error'
                   });
                 }
               });
             } else{
               this.$message({
                 message: '请将信息填写完整',
                 type: 'error'
               });
             }
           });
         },
         doReset:function () {
           this.$refs["mpCustomerBasicInfoValidate"].resetFields();
           this.buttonCommitState = "提交";
           this.inputComponentDisable = false;
         },
         doCustomerSearch:function(){
           //访问服务器数据更新表格
         },
         handleGoodsBasicInfoClose:function (done) {
           this.$confirm('确认关闭？')
             .then(_ => {
               done();
             })
             .catch(_ => {});
         },
         handleGoodsDetailInfoClose:function (done) {
           this.$confirm('确认关闭？')
             .then(_ => {
               this.currentView = "summaryInfo";
               done();
             })
             .catch(_ => {});
         },
         switchMyType:function (data) {
           if(data==1){ //法人客户
             this.customerTypeOption = enums.AABBCode;
           } else{  //个人客户
              this.customerTypeOption = enums.PersonalTypePCode;
              this.currentCustomerView = "personCustomerList";
           }
         },
         customerInfo:function (info) {
           this.grtCollateralInfo.customerFullName = info.partyName;
           this.grtCollateralInfo.customerNum =info.partyNum;
           this.customerPopoverIsVisible = false;
         },
       },
    }
</script>

<style scoped>
  .addMortgagePledge{
    width:100%;
    height:100%;
  }
  .el-menu-item{
    height: 40px;
    line-height: 40px;
  }
  .div-button-center{
    width: 100%;
    height: 100%;
    text-align: center;
  }
</style>
