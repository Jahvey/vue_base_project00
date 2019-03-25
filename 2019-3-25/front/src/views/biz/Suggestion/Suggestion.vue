<template>
    <div class="suggestion">
      <el-row>
        <p class="m-t-b-0">意见</p>
        <el-collapse value="yes" accordion>
          <el-collapse-item name="yes">
            <template slot="title" >
              审批<i class="header-icon el-icon-edit"></i>
            </template>
            <el-row>
              <el-form el-form label-width="130px"  size="mini" :model="data" label-position="right" :rules="rules" ref="validate" >
                <el-col :span="22">
                  <el-form-item label="意见" prop="suggestion" >
                    <el-input :disabled="inputComponentDisable" :rows="2" v-model="data.suggestion"  placeholder="请输入内容" type="textarea" style="width:100%"></el-input>
                  </el-form-item>
                </el-col>
              </el-form>
            </el-row>
            <el-row>
              <el-col :span="6" :offset="10">
                <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" :loading="isLoading">{{buttonText}}</el-button>
                <el-button size="medium"  v-bind:disabled="buttonDisable" type="primary" :loading="isLoading" @click="reverse">撤销</el-button>
              </el-col>
            </el-row>
          </el-collapse-item>
        </el-collapse>
      </el-row>
    </div>
</template>

<script>
    export default {
      name: "suggestion",
      data(){
          return{
            buttonText:"提交",
            buttonDisable:false,
            isLoading:false,//按钮提交状态
            inputComponentDisable:false,
            data:{
              suggestion:"",
            },
            rules:{},
          }
      },
      beforeMount(){
        var processDefName = 'com.bos.bps.csm.group_cust_rd_mccb';//流程定义名称
        var processInstanceName = '客户管理-集团客户认定';//流程实例名称
        var isGroup = false;
        var isMembers = false;
        var processInstId = "";//流程id
        var productType_ = "";//产品类型
        var partyId = "";//客户id
      },
      methods:{
        comfirm(){

        },
        reverse(){

        },
      },
    }
</script>

<style>
  .m-t-b-0{
    margin-top: 0;
    margin-bottom: 0;
    border-bottom: 1px solid #CCCCCC;
  }
 .suggestion .el-collapse-item__header{
    font-weight: bold;
    font-size: 15px;
  }
  .suggestion .header-icon{
    margin-left: 15px;
  }
</style>
