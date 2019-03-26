<template>
  <div class="natural-project">
    <el-row class="warp">
      <el-col :span="24">
        <el-form ref="dashboard" :model="party,tbBizXmxxApply,tbCrdThirdPartyLimit" label-width="140px">
          <el-col :span="12">
            <el-form-item label="客户编号" prop="partyNum">
              <el-input v-model="party.partyNum" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户名称" prop="partyName">
              <el-input v-model="party.partyName" :disabled="isView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合作项目名称" prop="itemName">
              <el-input v-model="tbCrdThirdPartyLimit.itemName" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合作项目类型" prop="itemType">
              <el-input v-model="tbCrdThirdPartyLimit.itemType"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合作项目额度起始日" prop="itemBeginDate">
              <el-input v-model="tbCrdThirdPartyLimit.itemBeginDate" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合作项目额度终止日" prop="itemEndDate">
              <el-input v-model="tbCrdThirdPartyLimit.itemEndDate" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="currencyCd">
              <el-input  v-model="tbCrdThirdPartyLimit.currencyCd" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合作项目额度控制方式" prop="crdControlType">
              <el-input  v-model="tbCrdThirdPartyLimit.crdControlType" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="合作项目额度" prop="itemAmt">
              <el-input  v-model="tbCrdThirdPartyLimit.itemAmt" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="最长贷款期限（年）" prop="longestLoanTerm">
              <el-input  v-model="tbCrdThirdPartyLimit.longestLoanTerm" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="最高贷款成数" prop="highestLoanRate">
              <el-input  v-model="tbCrdThirdPartyLimit.highestLoanRate" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="划款方向" prop="payDirection">
              <el-input  v-model="tbBizXmxxApply.payDirection" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="结算账号" prop="settleAccno">
              <el-input  v-model="tbCrdThirdPartyLimit.settleAccno" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保证金比例（%）" prop="depositPercentOne">
              <el-input  v-model="tbCrdThirdPartyLimit.depositPercentOne" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保证金账户归属机构" prop="depositAccOrgOne">
              <el-input  v-model="tbCrdThirdPartyLimit.depositAccOrgOne" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保证金账号" prop="depositAccnoOne">
              <el-input  v-model="tbCrdThirdPartyLimit.depositAccnoOne" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保证金户名" prop="depositAccnameOne">
              <el-input  v-model="tbCrdThirdPartyLimit.depositAccnameOne" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="主办行" prop="mainOrgId">
              <el-input  v-model="tbCrdThirdPartyLimit.mainOrgId" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经办人" prop="userNum">
              <el-input  v-model="tbCrdThirdPartyLimit.userNum" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经办日期" prop="dealDate">
              <el-input  v-model="tbCrdThirdPartyLimit.dealDate" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注" prop="itemRemark">
              <el-input  v-model="tbCrdThirdPartyLimit.itemRemark" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-col>
    </el-row>
    <div v-if="buttonView">
      <el-button :size="size" type="primary" @click.native="saveAndUpdateXmxxApply" :loading="editLoading">保存</el-button>
    </div>
  </div>
  <!--<div class="dashboard-text">role:<span v-for='role in roles' :key='role'>{{role}}</span></div>-->
</template>
<script>
  //import {getCusInfo,getAssetsList} from '@/api/org'
  import enums from "@/utils/enums"
  import commonUtil from "@/utils/commonUtil"
  import { saveAndUpdateXmxxApply } from '@/api/csm'

  export default {
    name: "natural-project",
    props:{
      party:{},
      tbCrdThirdPartyLimit:{},
      tbBizXmxxApply:{}
    },
    data(){
      return {
        idTypeCdOpts: enums.idTypeCd,//直接从配置文件读取
        yesOrNoOpts: enums.yesOrNo,//是否
        custTypeOpts: enums.custType,//个人分类
        genderCdOpts: enums.genderCd,//性别
        naturalPersonTypeCdOpts:enums.naturalPersonTypeCd,//居民性质
        countrySignOpts: enums.countrySign,//国籍
        nationOpts: enums.nation,//民族
        marriageCdOpts: enums.marriageCd,//婚姻状况
        educationBackgroudCdOpts:enums.educationBackgroudCd,//最高学历
        degreeCdOpts:enums.degreeCd,//最高学位
        professionOpts: enums.profession,//职业
        professionalTitleOpts: enums.professionalTitle,//职称
        accountingAssistantOpts: enums.accountingAssistant,//职务

        isView:false,
        buttonView:true,
        pageRequest: { partyId:''},
        size:'small',
        editLoading: false,

        item:{
          orgNum:"0700",
          userNum:"李谭荔"
        }
      }
    },
    methods:{

      // 表单提交
      saveAndUpdateXmxxApply () {
        this.$refs['dashboard'].validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              this.editLoading = true;
              let params = Object.assign({}, this.natural,this.family )
              console.log(params);
              saveAndUpdateFamilyFinace(params).then((res) => {
                this.editLoading = false;
                if(res && res.data && res.data.code == 200) {
                  this.$message({ message: '保存成功', type: 'success' })
                } else {
                  this.$message({message: '保存失败, ' + res.data.msg, type: 'error'})
                }
              }).catch((res) =>{
                console.error(JSON.stringify(res))
              })

            })
          }
        })
      },
    },
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

