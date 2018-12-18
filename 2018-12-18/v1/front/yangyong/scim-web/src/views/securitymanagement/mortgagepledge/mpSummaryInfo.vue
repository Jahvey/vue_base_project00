<template>
    <div class="summary-info">
      <el-row :gutter="20" type="flex" justify="center" >
        <el-form label-width="120px" label-position="right">
          <el-col :span="24">
            <el-form-item label="抵质押物类别" >
              <el-input  v-model="mpBasicInfo.mpGoodsBasicInfo.mpGoodsType" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="抵质押物编号" >
              <el-input  v-model="mpBasicInfo.mpGoodsBasicInfo.mpGoodsNumber" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="抵质押物名称" >
              <el-input  v-model="mpBasicInfo.mpGoodsBasicInfo.mpGoodsName" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="抵质押人编号">
              <el-input  v-model="mpBasicInfo.mpCustomerBasicInfo.customerNumber" disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="建档日期" >
              <el-input  v-model="mpBasicInfo.mpGoodsBasicInfo.mpDate" disabled="true"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "summary-info",
      props:{
        mpBasicInfo:{
          type:Object,
          default:{
            mpCustomerBasicInfo:{
              mpType:'',//抵质押人类型
              customerType:'',//客户类型
              organizationCode:'',//组织机构代码
              customerNumber:'',//客户编号
              customerFullName:'',//客户名全称
            },
            mpGoodsBasicInfo:{
              mpGoodsType:'',//抵质押品类别
              mpGoodsName:'',//抵质押品名称
              mpGoodsNumber:'',//抵质押物编号
              mpDate:"",//建档日期
            },
          },
        }
      }
    }
</script>

<style scoped>
  .summary-info{
    width:100%;
    height:100%;
  }
</style>
