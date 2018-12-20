<template>
  <div class="app-container">
    <el-row class="warp">
      <el-col :span="24">
        <el-form ref="dashboard" :model="cusInfo" label-width="80px">
          <el-col :span="12">
            <el-form-item label="客户编号" prop="partyNum">
              <el-input v-model="cusInfo.partyNum"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户名称" prop="partyName">
              <el-input v-model="cusInfo.partyName"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="cusInfo.remark"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="英文名称" prop="partyName">
              <el-input v-model="cusInfo.englishName"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="中文简称" prop="partyName">
              <el-input v-model="cusInfo.chineseShortName"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="中文简称" prop="partyName">
              <el-input v-model="cusInfo.englishShortName"></el-input>
            </el-form-item>
          </el-col>

        </el-form>
      </el-col>
    </el-row>

    <el-row>
      <slot name="selfDefine"></slot>
    </el-row>

    <el-row align="middle" class="bottomBtn">
      <el-col align="center">
        <el-button size="medium" type="primary" @click="doSave">保存</el-button>
        <!--<el-button size="medium" type="primary" @click="doReset">重置</el-button>-->
        <el-button size="medium" type="primary" @click="doCancel">取消</el-button>
      </el-col>
    </el-row>


  </div>
  <!--<div class="dashboard-text">role:<span v-for='role in roles' :key='role'>{{role}}</span></div>-->
</template>

<dashboard a="1"></dashboard>
<script>
  import { mapGetters } from 'vuex'
  import {getTbCsmPartyInfoById,getTbCsmNaturalPersonInfoById} from '@/api/dashboard'
  import enums from "@/utils/enums"

  import axios from 'axios'

  export default {
    name: 'dashboard',
    data(){
      return {
        idTypeCdOpts: enums.idTypeCd,//直接从配置文件读取
        //调用服务的方式获取客户信息
        cusInfo:{},
        cusInfo1:{
          // cusNo:'20064449',
          // useranme:'建行',
          // cerType:'1',
          // ccode:'22233434',
          // phone:'13344444',
          // email:'74234243@163.com'
        }
      }
    },
    methods:{
      getTbCsmPartyInfo() {



        // var params={"partyId":"5AF8119026E0FABDE05010AC57DD79A2"};
        // var url="mybatis-service/mynatureal/getTbCsmPartyInfoById";
        // axios.get(url, {
        //   params: { 'partyId': '5AF8119026E0FABDE05010AC57DD79A2' }
        // }).then(function (response) {
        //   alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
        //   // alert("具体值:"+response.data.valueOf("partyNum"));
        //   let rowdata = {};
        //   Object.assign(rowdata, response.data);
        //   alert("具体值2:"+response.data.valueOf("partyNum"));
        //   this.cusInfo = rowdata;
        //   alert("具体值2:"+rowdata.partyNum);
        // }).catch(function (error) {
        //   alert("111222:"+error);
        // });
      let queryParams={partyId:"5AF8119026E0FABDE05010AC57DD79A2"};
      alert("页面复制:"+queryParams.partyId);
        getTbCsmPartyInfoById({partyId:"5AF8119026E0FABDE05010AC57DD79A2"}).then(response => {
          // alert("具体值2:"+response);
          // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
          if (response !== undefined) {
            var obj = {}
            this.cusInfo = response.data;
          }
        })

      },
      doCancel() {
        this.$router.back();//路由返回
      },
      doSave() {
        saveUser(cusInfo).then(response => {
          this.$message({
            type: 'success',
            message: '保存成功!'
          })
          this.$router.back()
        })
      }
    },
    mounted: function(){
      this.cusInfo={};
        this.getTbCsmPartyInfo();
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .dashboard {
    &-container {
      margin: 30px;
    }
    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }

  .form .form-left {
    width:50%; padding-left:1rem; padding-right:1rem; padding-top:1rem;
  }
  .form .form-right {
    width:50%; padding-left:1rem; padding-right:1rem; padding-top:1rem;
  }


</style>

