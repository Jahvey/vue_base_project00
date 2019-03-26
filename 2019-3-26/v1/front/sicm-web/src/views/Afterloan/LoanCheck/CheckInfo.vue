<template>
  <div>
    <div>
      <p class="m1">基本信息</p>
      <div class="m2"></div>
      <csc-form-page
          :pageDef="pageDef"
          :formData="form"
          @click="doCancel">
        </csc-form-page>
    </div>
    <div>
        <p class="m1">授信资金用途</p>
        <div class="m2" style="margin-bottom:15px"></div>
        <el-row class="m4">
          <el-button type="primary" @click="dialogFormVisible = true">增加</el-button>
          <el-button type="primary" @click="del">删除</el-button>
        </el-row>
        <csc-single-table
           :pageDef="pageDef2"
           :entity="form2"
           :disableRowButtons="disableRowButtons"
           :disableQueryForm="disableQueryForm"
           :disableQueryButtons="disableQueryButtons"
           @delete="del"
           @add="dialogFormVisible"
           @doSave="doSave">
        </csc-single-table>
    </div>
    <div>
      <p class="m1">检查信息</p>
      <div class="m2"></div>
        <csc-form-page
          :pageDef="pageDef1"
          :formData="form1"
          @click="doCancel1">
        </csc-form-page>
    </div>
    <el-row class="m3">
      <el-button type="primary"  @click="Save">保存</el-button>
      <el-button type="primary">临时保存</el-button>
    </el-row>
    <!-- 增加页面弹框 -->
    <el-dialog title="新增" :visible.sync="dialogFormVisible">
      <el-form :model="form3">
        <el-form-item label="支付时间" :label-width="formLabelWidth">
          <el-input v-model="form3.payTime" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付金额" :label-width="formLabelWidth">
          <el-input v-model="form3.applyAmount" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付对象" :label-width="formLabelWidth">
          <el-input v-model="form3.payObject" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付用途" :label-width="formLabelWidth">
          <el-input v-model="form3.payUse" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="支付方式" :label-width="formLabelWidth">
          <el-select v-model="form3.payWay" placeholder="--请选择--">
            <el-option label="转账支付" value="0"></el-option>
            <el-option label="现金支付" value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否符合审批或约定用途" :label-width="formLabelWidth">
          <el-select v-model="form3.isFitDeal" placeholder="--请选择--">
            <el-option label="是" value="1"></el-option>
            <el-option label="否" value="0"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="doSave">保 存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  import CscFormPage from '@/components/CscFormPage/CscFormPage'
  import {queryBorList,addMoneyUse,queryMoneyUse,queryFirstCheckInfoBySummaryId} from '@/api/afterloan'
  import enums from "@/utils/enums"//格式化的枚举类
    export default {
      name: "CheckInfo",
      props:{
        paramToCheckInfo:{

        },
      },


      data() {
        return {
          disableRowButtons:true,
          disableQueryForm:true,
          disableQueryButtons:true,
          dialogFormVisible: false,
          formLabelWidth: '80px',
          disabled:true,
          entity: {},
          form: {
              partyName:this.paramToCheckInfo.partyName,//客户名称
              partyTypeCd:this.paramToCheckInfo.partyTypeCd,//客户类型
              certType:this.paramToCheckInfo.certType,//证件类型
              certNum:this.paramToCheckInfo.certNum,//证件号码
              summaryAmt:this.paramToCheckInfo.summaryAmt,//借据金额
              jjye:this.paramToCheckInfo.jjye,//借据余额
              beginDate:this.paramToCheckInfo.beginDate,//借据起期
              endDate:this.paramToCheckInfo.endDate,//借据止期
              loanUse:this.paramToCheckInfo.loanUse,//贷款用途
          },
          form1:{
            checkWay:'',
            checkPerson:'李谭荔 ',
            checkDate:'2018-03-11',
            checkResult:'',
            checkCount:'1'
          },
          form2:[{
            payTime:'2019-02-08',
            applyAmount:'5000',
            payObject:'按时吃',
            payUse:'事多的撒多',
            payWay:'现金',
            isFitDeal:'否'
          }],
          form3: {
            payTime: '',
            applyAmount: '',
            payObject: '',
            payUse: '',
            payWay: '',
            isFitDeal: '',
          },
          pageDef: {
            disabled: true, // 页面按钮隐藏
            name: '用户信息',
            columnNum: 2,
            pageCols: [
              {label: '客户名称:', inputType: 'input', modelName: 'partyName'},
              {label: '客户类型:', inputType: 'input', modelName: 'partyTypeCd',enumType: 'CustomerClassCd'},
              {label: '证件类型:', inputType: 'input', modelName: 'certType',enumType: 'idTypeCd'},
              {label: '证件号码:', inputType: 'input', modelName: 'certNum'},
              {label: '借据金额:', inputType: 'input', modelName: 'summaryAmt'},
              {label: '借据余额:', inputType: 'input', modelName: 'jjye'},
              {label: '借据起期:', inputType: 'date', modelName: 'beginDate'},
              {label: '借据止期:', inputType: 'date', modelName: 'endDate'},
              {label: '贷款用途:', inputType: 'input', modelName: 'loanUse'}
            ]
          },
          pageDef1: {
            disabled: true, // 页面按钮隐藏
            name: '检查信息',
            columnNum: 2,
            pageCols: [
              {label: '检查方式:', inputType: 'select', modelName: 'checkWay',enumType: 'checkWay'},
              {label: '检查人:', inputType: 'input', modelName: 'checkPerson'},
              {label: '检查日期:', inputType: 'date', modelName: 'checkDate'},
              {label: '累计检查次数:', inputType: 'input', modelName: 'checkCount'},
              {label: '检查结论:', inputType: 'textarea', modelName: 'checkResult'}
            ]
          },
          pageDef2: {
            // 查询条件定义
            queryDef: {},
            tabDef: {
              isSelect: true, // 是否可以多选
              isIndex: true, // 是否有序号
              // 表格字段定义
              tabCols: [
                { label: '支付时间', prop: 'payTime', isSort: true },
                { label: '支付金额', prop: 'applyAmount', isSort: true },
                { label: '支付对象', prop: 'payObject', isSort: true },
                { label: '支付用途', prop: 'payUse', isSort: true },
                { label: '支付方式', prop: 'payWay', isSort: true, isFormat: true,enumType:'payWay'},
                { label: '是否符合审批或约定用途', prop: 'isFitDeal', isSort: true }
              ]
            },
          },

        }
      },

      components: {CscFormPage,CscSingleTable,enums},
      created() {
        console.log("接受数据成功！[paramToCheckInfo]"+JSON.stringify(this.paramToCheckInfo))
        let param = this.$route.params
        console.log(param)
        this.queryBorList(param)
      },

      methods: {
        doPageQuery(listQuery) {
          alert("执行没有！11")
          this.queryMoneyUse(listQuery)
          this.queryFirstCheckInfoBySummaryId(listQuery)
        },

        queryMoneyUse(listQuery) {
          queryMoneyUse(listQuery).then(response => {
            this.entity = response.data
            this.$store.dispatch('setListLoading', false)
          }).catch((error) => {
            console.log(error)
          })
        },

        queryFirstCheckInfoBySummaryId(listQuery){
          alert("执行没有！2")
           queryFirstCheckInfoBySummaryId(this.paramToCheckInfo.summaryId).then(response =>{
             console.log("响应数据！[paramToCheckInfo]"+JSON.stringify(response.data))
             this.form1 = response.data
             this.$store.dispatch('setListLoading', false)
           }).catch((error) => {
             console.log(error)
           })
         },

        async queryBorList(param) {
          queryBorList(param).then(response => {
            if (null == response.data || JSON.stringify(response.data).replace(/^\s+|\s+$/g, "") == "") {//replace(/^\s+|\s+$/g, "");
              alert("没有查询到该条数据，检查数据是否正确")
              return false
            }
            this.form = response.data
            console.log(this.form)
          }).catch((error) => {
            console.log(error)
          })
        },

        doSave(){
          alert('进来没有1111！');
          console.log("传入参数1:"+JSON.parse(JSON.stringify(this.form)));
          addMoneyUse(this.form3).then(response => {
            alert('进来没有2222！');
            this.$message({
              type: 'success',
              message: '保存成功!'
            });
            this.dialogFormVisible = false;
            /*this.$router.back()*/
          }).catch((error)=>{
            console.log(error)
          })
        },

        Save(){
          this.$message({
            type: 'success',
            message: '保存成功!'
          });
          this.$router.back()
        },
        doCancel() {
          this.$router.back()
        },
        doCancel1() {
          this.$router.back()
        }
      },
    }
</script>

<style scoped>
  .m1{
    text-align: left !important;
    font-size: 16px;
    font-weight: bold;
    margin-bottom: 5px;
  }
  .m2{
    border-top:solid 1px #A9A3A5;
    height: 1px !important;
    margin-top: 2px;
  }
  .m3{
    text-align: right;
  }
  .m4{
    text-align: left;
  }
</style>
