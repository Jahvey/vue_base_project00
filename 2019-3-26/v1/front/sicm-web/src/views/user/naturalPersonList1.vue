<template>
  <div>

    <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @create="create" @doEdit="doEdit"
                      @showDialog="showDialog" :disableQueryForm="disableQueryForm" @adjustContract="adjustContract"
                      @invalidContract="invalidContract" @doDelete="doDelete"  @rowDbclick="rowDbclick" @queryRef="queryRef"
                      @customFormat="customFormat">
    </csc-single-table>

    <!--<csc-form-dialog :pageDef="pageDef1" :dialogFormVisible="true" title="测试dialog"></csc-form-dialog>-->


    <!--<el-dialog title="新增" :modal-append-to-body="false" :before-close="beforeClose" :visible.sync ="addFormVisible"-->
               <!--:fullscreen="true" :close-on-click-modal="false" custom-class="mydialog">-->
          <!--<span>就这点东西</span>-->
    <!--</el-dialog>-->
    <csc-form-dialog3 :pageDef="pageDef" ref="form" @doSave="doSave" @doCancel="doCancel" @deReset="doReset">

      <!-- 父传子插槽 -->
      <!--<hr slot="selfDefine"></hr>-->
    </csc-form-dialog3>

  </div>


</template>

<script>
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
import CscFormDialog from '@/components/CscFormDialog/CscFormDialog'
import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3"
import { getUserList, getUserList1,deleteUser } from '@/api/user'
// import axios from 'axios'

export default {
  data() {
    return {
      disableQueryForm: false,//2018-11-30 csc-form-page 控制按钮是否显示
      addFormVisible: false,
      dialogFormVisible: true,
      certType1:'',//默认证件类型值
      entity: {},
      form: {},//
      pageDef: {


        //20190115 列表点击查看 调整等按钮引入dialog测试
        dialogFormVisible: false,//2018-12-19 csc-form-dialog对话框弹出
        title: "我的客户222",//2018-12-19 csc-form-dialog对话框弹出标题
        name:'myCustomerForm',
        columnNum:2, //一行几列
        activeName: 'tab1',//标签默认选中项  后期考虑动态根据标签加载dialog导航信息
        //动态传入标签数组
        tabPanes:[
          {tabName:'标签一',name:'tab1',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
          {tabName:'标签二',name:'tab2',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
          {tabName:'标签三',name:'tab3',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
          {tabName:'标签四',name:'tab4',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
          {tabName:'标签五',name:'tab5',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
          {tabName:'标签六',name:'tab6',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}},
          {tabName:'标签七',name:'tab7',url:'/user/ManyTable',components:["",""],param:{"contractNum":"dddd","customerNum":"321"}}
        ],




        // 查询条件定义
        queryDef: {
          columnNum: 2, // 一行几列
          queryCols: [
            { label: '客户名称', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型1', inputType: 'select', modelName: 'certType1',enumType:'idTypeCd' },
            { label: '证件类型', inputType: 'select1', modelName: 'certType',enumType:'XD_SXYW0001' },
            { label: '证件号码', inputType: 'input', modelName: 'certNum' },
            { label: '中征码',inputType: 'input',modelName:'middleCode'},
            {label: '创建时间',inputType: 'dateRange', modelName: 'startDate', param: {label: '至', inputType: 'dataRange', modelName: 'endDate'}}
          ]
        },
        tabDef: {
          isSelect: false, // 是否可以多选
          mutiCheckParam: "partyName",//多选项时暂时只支持获取一个参数
          isCheckRadio: true,//是否可以单选 单选覆盖全选
          checkParam: ["partyName","certNum"],//定义单选或复选按钮时 选择参数 单选  以@分割 复选再考虑下
          isIndex: true, // 是否有序号
          isExpand: false, //设置表格是否可展开  默认设置为false pc应该不需要 移动端可能更需要
          expandCols: [
            { label: '客户名称', prop: 'partyName'},
            { label: '证件类型', prop: 'certType'},
            { label: '证件号码', prop: 'certNum'},
            { label: '中征码', prop: 'middleCode'},
            { label: '消费性评级', prop: 'xfCreditRatingCd'},
            { label: '经营性评级', prop: 'jyCreditRatingCd' },
            { label: '批复金额', prop: 'pfAmt'},
            { label: '批复已用金额', prop: 'pfBalance'},
            { label: '管户客户经理', prop: 'mainUserNum'}
          ],
          // 表格字段定义
          tabCols: [
            // { label: '客户名称', prop: 'partyName', isSort: true,url:'/user/ManyTable',isLink: true,param:["partyName","certNum"]},
            // { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
            // { label: '证件号码', prop: 'certNum', isSort: true,isParam: true },
            // { label: '中征码', prop: 'middleCode', isSort: true },
            // { label: '消费性评级', prop: 'xfCreditRatingCd', isSort: true },
            // { label: '经营性评级', prop: 'jyCreditRatingCd', isSort: true },
            // { label: '批复金额', prop: 'pfAmt', isSort: true },
            // { label: '批复已用金额', prop: 'pfBalance', isSort: true },
            // { label: '管户客户经理', prop: 'mainUserNum', isSort: true },
            // { label: '正常',isHead: true,contents:[{ label: '户数',prop: 'pfAmt',isSort:true},{label:'金额',prop: 'pfBalance',isSort:true}]}
          ],
          // 2019-1-9 测试适用多个动态表头的方法  可根据实际需要动态添加不同表头
          tabCols1: [
            { label: '客户名称', prop: 'partyName', isSort: true,url:'/user/ManyTable',isLink: true,param:["partyName","certNum"]},
            { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
            { label: '证件号码', prop: 'certNum', isSort: true,isDialog: true,param:["partyName","certNum"] },
            { label: '中征码', prop: 'middleCode', isSort: true },
            { label: '消费性评级', prop: 'xfCreditRatingCd', isSort: true },
            { label: '经营性评级', prop: 'jyCreditRatingCd', isSort: true },
            { label: '批复金额', prop: 'pfAmt', isSort: true },
            { label: '管户客户经理', prop: 'mainUserNum', isSort: true },
            { label: '批复已用金额', prop: 'pfBalance', isSort: true },
            // { label: '正常',isHead: true,contents:[{ label: '户数',prop: 'pfAmt',isSort:true},{label:'金额',prop: 'pfBalance',isSort:true}]}//目前只支持两级嵌套
          ],
          tabCols2: [
            { label: '客户名称', prop: 'partyName', isSort: true,url:'/user/ManyTable',isLink: true,param:["partyName","certNum"]},
            { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
            { label: '证件号码', prop: 'certNum', isSort: true,isDialog: true, param:["partyName","certNum"]},
            { label: '中征码', prop: 'middleCode', isSort: true },
            { label: '消费性评级', prop: 'xfCreditRatingCd', isSort: true },
            { label: '经营性评级', prop: 'jyCreditRatingCd', isSort: true },
            { label: '批复金额', prop: 'pfAmt', isSort: true },
            { label: '批复已用金额', prop: 'pfBalance', isSort: true },
            // { label: '正常',isHead: true,contents:[{ label: '户数',prop: 'pfAmt',isSort:true},{label:'金额',prop: 'pfBalance',isSort:true}]}//目前只支持两级嵌套
          ],
          tabCols3: [
            { label: '客户名称', prop: 'partyName', isSort: true,url:'/user/ManyTable',isLink: true,param:["partyName","certNum"]},
            { label: '证件类型', prop: 'certType', isSort: true,isFormat:true,enumType:'idTypeCd' },
            { label: '证件号码', prop: 'certNum', isSort: true,isDialog: true, param:["partyName","certNum"]},
            { label: '中征码', prop: 'middleCode', isSort: true, isRef: true },
            { label: '消费性评级', prop: 'xfCreditRatingCd', isSort: true, isCustom: true, isOverflow: true },
            { label: '经营性评级', prop: 'jyCreditRatingCd', isSort: true },
            { label: '批复金额', prop: 'pfAmt', isSort: true, isRef: true },
            // { label: '正常',isHead: true,contents:[{ label: '户数',prop: 'pfAmt',isSort:true},{label:'金额',prop: 'pfBalance',isSort:true}]}//目前只支持两级嵌套
          ]
        },
        buttons: [
          {
            label: '调整',
            funcName: 'adjustContract'
          },
          {
            label: '合同失效',
            funcName: 'invalidContract'
          }
        ]
      },
      pageDef1: {
        dialogFormVisible: false,//2018-12-19 csc-form-dialog对话框弹出
        title: "我的客户",//2018-12-19 csc-form-dialog对话框弹出标题
        name:'用户信息',
        columnNum: 3, // 一行几列
          // 表格字段定义
          pageCols: [
            { label: '客户名称', inputType: 'input', modelName: 'partyName' },
            { label: '证件类型', inputType: 'select', modelName: 'certType',enumType:'XD_BIZ0003' },
            { label: '证件号码', inputType: 'input', modelName: 'certNum' },
            { label: '中征码',inputType: 'input',modelName:'middleCode'}
          ]
      }
    }
  },
  components: { CscSingleTable,CscFormDialog,CscFormDialog3},

  beforeCreate:function(){
    console.log("父组件beforeCreate:"+new  Date());
    // this.disableQueryForm=true;
  },

 created:function () {
   console.log("父组件created:"+new  Date());
   // this.disableQueryForm=true;
 },

  mounted: function(){
    // console.log("父组件mounted:"+new  Date());
    // this.initParam();
  },

  methods: {

    // initParam(){
    //   console.log("父组件initParam:"+new  Date());
    //   this.disableQueryForm=true;
    // },

    doPageQuery(listQuery) {

      console.log("父组件doPageQuery到底执行没有1:"+JSON.stringify(listQuery));

      getUserList(listQuery).then(response => {
        console.log("父组件到底执行没有1ResponseMsg:"+response.data.total);
        // alert("父组件getUserList1:"+JSON.parse(JSON.stringify(response.data)));
        // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
        if(listQuery.certType1 && listQuery.certType1==='11'){
          this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols2;
        }else if(listQuery.certType1 && listQuery.certType1==='10'){
          this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols1;
        }else{
          this.pageDef.tabDef.tabCols=this.pageDef.tabDef.tabCols3;
        }

        this.entity = response.data;//如果定义的是返回responsemsg 这里response.data  就是
        console.log("父组件到底执行没有3ResponseMsg:"+response.data.totalRec);
        this.$store.dispatch('setListLoading', false);
      }).catch((error) => {
        console.log(error)
      })



      // var params={"partyId":"5AF8119026E0FABDE05010AC57DD79A2"};
      // var url="mybatis-service/mynatureal/queryNaturalForDesk";
      // axios.get(url, {
      //   params: { 'orgcode': '0700' }
      // }).then(function (response) {
      //   alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
      //   this.entity = response
      // }).catch(function (error) {
      //   alert("111222:"+error);
      // });



    },

    rowDbclick(row) {
      this.$router.push({ path: '/user/userList' })
    },

    create() {
      this.$router.push({ path: '/user/userAdd' })
    },

    adjustContract(row){
      console.log("adjustContract:"+JSON.stringify(row));
      this.pageDef.dialogFormVisible=true;
      // this.$router.push({ path: '/user/userAdd' });
    },

    invalidContract(row) {
      console.log("invalidContract:"+JSON.stringify(row));
      this.pageDef.dialogFormVisible=true;
      // this.$router.push({ path: '/user/userAdd' });
    },

    showDialog() {
      // this.$router.push({ path: '/user/userEdit',query:{method:'doEdit'} })//2018-12-19 以前点击编辑是路由跳转 今天测试改成弹出dialog
      console.log("showDialog进来没得哦:"+new Date());
      this.pageDef.dialogFormVisible = true;//点击编辑时弹出dialog
      // this.addFormVisible = true;//2018-12-19 测试直接写弹框已通过
    },

    doDelete(row, listQuery) {
      deleteUser(row).then(response => {
        this.userList(listQuery)
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      })
    },
    //关闭模态框前的回调函数
    beforeClose(){

      // this.$confirm('确认关闭吗?', '提示', {type: 'warning'}).then(() => {
      //   this.addFormVisible=false;
      // }).catch(
      //   console.log("关闭失败")
      // );

      this.$confirm('确认关闭吗?, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.addFormVisible=false;
        this.$message({
          type: 'success',
          message: '关闭成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消关闭'
        });
      });


    },

    //tabCol isRef  子组件调用$emit 方法，父组件可以依次接收 然后再加工  这是我理解的参照
    queryRef(value,cellValue,getValue){
      if(value=='pfAmt'){//如果是批复金额 则按照 每个页面设定的格式要求操作 区别于cscsingletable里面做的统一格式化操作
        //有的要求金额保留四位，有的要求保留三位等
        if(cellValue){

        }else{
          return getValue(cellValue);
        }

      }else{
        return getValue(cellValue)
      }
    },

    //tabCol customerFormat  可以接收参数，甚至是函数
    customFormat(value,getValue){
      // console.log("父组件customFormat1:"+JSON.stringify(value));
      // console.log("父组件customFormat2:"+typeof(getValue));
      if(value && value=='AA+'){
        return getValue(value+"|优秀");
        // return value+"|优秀";
      }else if(value && value=='AA'){
        return getValue(value+"|良好");
        // return value+"|良好";
      }else if(!value){
        return getValue("无评级结果");
      }

    },
    async getCompleteData(userId) {
      this.queryUserRoleForShow();
      if (userId) { // 修改的单据
        queryUser({userId:userId}).then(response => {
          let rowdata = {};
          Object.assign(rowdata, response);
          rowdata.userRoleIdForShow=[];
          rowdata.userRoleList.forEach((userRoleT, index) => {
            rowdata.userRoleIdForShow.push(userRoleT.roleName);
          });
          this.form = rowdata;
          debugger
        }).catch((error)=>{
          console.log(error)
        })
      }
    },
    doCancel() {
      // this.$router.back()
    },
    transUserRoleToCode(userRoleNames){
      var userRoleCode = [];
      userRoleNames.forEach((val, index) => {
        var userRoleObj = {};
        userRoleObj = this.srvObj[val];
        userRoleCode.push(userRoleObj)
      });
      return userRoleCode;
    },

    doSave(form){
      form.userRoleList=this.transUserRoleToCode(this.form.userRoleIdForShow);
      saveUser(form).then(response => {
        this.$message({
          type: 'success',
          message: '保存成功!'
        })
        this.$router.back()
      })
    },
    queryUserRoleForShow() {
      queryUserRole().then(response => {
        var srvObjT = {};
        response.forEach(function (service, index) {
          srvObjT[service.roleName] = {"roleId": service.roleId, "checked": false}
        });
        this.srvObj = srvObjT;
      })
    },
    doEdit(){
      this.pageDef.dialogFormVisible=true;
      console.log("doEdit进来没有:"+"---"+this.pageDef.dialogFormVisible+"-----"+this.form["username"]);
    },
    doReset(){
      this.$refs[form].resetFields();
    }

  }



}

</script>
<style rel="stylesheet/scss" lang="scss">
  .mydialog{
    width: 100%;
    height: 100%;
  }
</style>
