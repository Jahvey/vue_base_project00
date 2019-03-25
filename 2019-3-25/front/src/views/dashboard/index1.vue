<template>
  <div class="app-container">
      <el-row class="warp">
        <el-col :span="24">
          <el-form ref="dashboard" :model="cusInfo" label-width="80px">
            <el-col :span="12">
            <el-form-item label="客户编号" prop="cusNo">
              <el-input v-model="cusInfo.cusNo" disabled></el-input>
            </el-form-item>
            </el-col>
            <el-col :span="12">
            <el-form-item label="客户名称" prop="useranme">
              <el-input v-model="cusInfo.useranme" disabled></el-input>
            </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="cerType" label="证件类型">
                <el-select clearable v-model="cusInfo.cerType" disabled>
                  <el-option v-for="(value,key) in idTypeCdOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>

            </el-col>
            <el-col :span="12">
            <el-form-item prop="ccode" label="证件号码">
              <el-input v-model="cusInfo.ccode" disabled></el-input>
            </el-form-item>
            </el-col>
            <el-col :span="12">
            <el-form-item prop="phone" label="联系电话">
              <el-input v-model="cusInfo.phone" disabled></el-input>
            </el-form-item>
            </el-col>
            <el-col :span="12">
            <el-form-item prop="email" label="邮箱地址">
              <el-input v-model="cusInfo.email" disabled></el-input>
            </el-form-item>
            </el-col>
          </el-form>
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
export default {
  name: 'dashboard',
  data(){
    return {
      idTypeCdOpts: enums.idTypeCd,//直接从配置文件读取
      //调用服务的方式获取客户信息
      cusInfo1:{

      },
      cusInfo:{
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

