<template>
    <div class="mptransfer-ownership">
        <el-row>
          <el-form label-width="120px" label-position="right">
            <el-col :span="24">
              <el-form-item label="抵质押人类型" prop="mpType">
                <el-radio v-model="mpCustomerBasicInfo.mpType" label="法人客户">法人客户</el-radio>
                <el-radio v-model="mpCustomerBasicInfo.mpType" label="个人客户">个人客户</el-radio>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="客户类型" prop="customerType">
                <el-select v-model="mpCustomerBasicInfo.customerType" placeholder="请选择">
                  <el-option
                    v-for="item in customerTypeOption"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="组织机构代码" prop="organizationCode">
                <el-input v-model="mpCustomerBasicInfo.organizationCode" ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="抵质押人编号" prop="customerNumber">
                <el-input  v-model="mpCustomerBasicInfo.customerNumber" ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="24">
              <el-form-item label="抵质押人名称" prop="customerFullName">
                <el-input  v-model="mpCustomerBasicInfo.customerFullName" ></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium"  type="primary" @click="dialogVisible = true" >{{buttonText}}</el-button>
        </el-col>
      </el-row>
      <template>
        <el-dialog
          title="客户信息"
          :visible.sync="dialogVisible"
          width="80%"
          :before-close="handleClose"
          append-to-body>
          <queryPropertyRightPerson v-on:backFlag="getMsg"/>
        </el-dialog>
      </template>
    </div>
</template>

<script>
    import queryPropertyRightPerson from "./queryPropertyRightPerson"
    export default {
      name: "mptransfer-ownership",
      components:{
        queryPropertyRightPerson
      },
      data(){
        return{
          mpCustomerBasicInfo:{
            mpType:'法人客户',//抵质押人类型
            customerType:'企业',//客户类型
            organizationCode:'',//组织机构代码
            customerNumber:'',//客户编号
            customerFullName:'',//客户名全称
            mpDate:"",//建档日期
          },
          customerTypeOption:[
            {
              value: '企业',
              label: '企业'
            }, {
              value: '个人',
              label: '个人'
            },
          ],//客户类型选项
          buttonText:"过户",
          dialogVisible: false
        }
      },
      methods:{
        getMsg:function (flag) {
          if(flag==='ok'){
            this.dialogVisible = false;
          }
        }
      },
    }
</script>

<style scoped>
  .mptransfer-ownership{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mptransfer-ownership p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
