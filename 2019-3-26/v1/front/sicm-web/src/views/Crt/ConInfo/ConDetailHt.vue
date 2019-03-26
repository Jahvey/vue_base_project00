<!--con_detail_ht的信息，使用原生element-ui写这个界面-->
<template>
  <el-row :gutter="20" class="form">
    <el-form  label-width="200px"  size="medium"
    :rules="rules" :model="conInfoForm" ref="conInfoForm"
             label-position="right"
             :disabled=isconInfoForm>

    <div  >
      <el-col :span="12">
        <el-form-item label="客户名称:" prop="partyName" class="special-input">
          <el-input v-model="conInfoForm.partyName" style="width:100%" :disabled=true></el-input>
          <!--style="width:150px"-->
        </el-form-item>
      </el-col>
     
      
    </div>

    <conDkllRate :conDetailHtData="conDetailHtData" v-show="conDetailHtData.visiable">
    </conDkllRate>

    
    
    </el-form>


    <el-row align="middle" class="bottomBtn">
      <el-col align="center" v-if="!showDisabled">
        <el-button size="medium" type="primary" @click="onSubmit">保存</el-button>

      </el-col>
      <el-col align="center" v-else>
        <el-button size="medium" type="primary" @click="doCancel">返回</el-button>
      </el-col>
    </el-row>



  </el-row>
</template>

<script>

  import {} from '@/api/csm'
  import enums from "@/utils/enums"//格式化的枚举
  import axios from 'axios'
  import qs from 'qs'
  import conDkllRate from "@/views/Biz/BizProductDetail/ConDetailHt/ConDkllRate"

  export default {
    name: "conDetailHt",

    components: {
      //引入的组件
      conDkllRate
    },
    props: {

      paramsConTree:{ //用于接受父组件传来的参数
        //con_tree传递过来的参数放在这里
      }
    },
    data() {
      return {
        conDetailHtData:{

        },
        showDisabled:false,
        isconInfoForm:false,
        dataMap:'',     //这边保存了 相关合同数据 
        conInfoForm: {//初始化con_info_ht的form表单
          partyName: '',
          partyNum: '',


        },
        //合同明细页面需要展示的相关数据参数
        contractId:'',
        xgbz:'',
        proFlag:'',
        productType:'',
        oldContractId:'',
        legCode:'0700', //TODO 先写死

        rules: {//表单验证
          // contractAmt:[
          //       {required: true, message: '金额不允许为空', trigger: 'blur'},
          //      // {type: 'number', message: '请输入数字', trigger: 'blur'},
          //       {min: 100, max: 100000000000, message: '请在出账范围内出账', trigger: 'blur'},

          // ],


        },

        guarantyType: enums.guarantyTypeCd, //担保方式 CDZC0005
        mainGuarantyType: enums.mainGuarantyTypeCd, //主担保方式 CDZC0005
        agriculLoans: enums.YesOrNoCd,

        currencyCd: enums.currencyCd,//币种格式化  CD000001
        cycleUnit: enums.cycleUnitCd,   //XD_GGCD6009
        
        repaymentType: enums.repaymentTypeCd,//还款方式  XD_SXCD1162
        productType: enums.productType,
        cycleIndCon: enums.isBankTeamLoan,




      }

    },
    created() {
      this.conDetailHtData={visiable:true}
      console.log("conDetailHtData "+this.conDetailHtData.visiable);
      let param = this.paramsConTree
      console.log("数据传输成功！"+JSON.stringify(param))


    this.initConInfoHt(param)

    },
    methods: {
      onSubmit(data){
        console.log("点击了保存..."+JSON.stringify(data));

      },
      doCancel(data){
        console.log("点击了doCancel..."+JSON.stringify(data));

      },


      initConInfoHt(data) {//初始化页面合同信息

    

      },

    }

  }



</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .form {
    margin-top: 20px;
    margin-right: 20px
  }

  .bottomBtn {
  margin-top: 10px;
}
</style>
