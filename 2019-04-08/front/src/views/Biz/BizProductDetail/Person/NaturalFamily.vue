<template>
  <div class="natural-family">
    <el-row class="warp">
      <el-col :span="24">
        <fieldset>
          <legend>家庭财务信息：</legend>
          <el-form ref="dashboard" :model="party" label-width="140px">
            <el-col :span="12">
              <el-form-item label="客户名称" prop="partyName">
                <el-input v-model="party.partyName" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="证件类型：" prop="certType">
                <el-select v-model="party.certType" placeholder="请选择证件类型" :disabled="isView">
                  <el-option label="居民身份证" value="10"></el-option>
                  <el-option label="户口簿" value="11"></el-option>
                  <el-option label="中国护照-中华人民共和国因公护照" value="122"></el-option>
                  <el-option label="中国护照-中华人民共和国因私护照" value="121"></el-option>
                  <el-option label="军官证" value="13"></el-option>
                  <el-option label="军人士兵证" value="14"></el-option>
                  <el-option label="香港居民来往内地通行证" value="15"></el-option>
                  <el-option label="台湾居民来往大陆通行证" value="16"></el-option>
                  <el-option label="临时身份证" value="17"></el-option>
                  <el-option label="外国人永久居留证" value="18"></el-option>
                  <el-option label="警官证" value="19"></el-option>
                  <el-option label="其他证件" value="1X"></el-option>
                  <el-option label="武警士兵证" value="1a"></el-option>
                  <el-option label="军人文职干部证" value="1b"></el-option>
                  <el-option label="武警文职干部证" value="1c"></el-option>
                  <el-option label="驾驶证" value="1d"></el-option>
                  <el-option label="军人身份证" value="1e"></el-option>
                  <el-option label="武装警察身份证" value="1f"></el-option>
                  <el-option label="外国公民护照" value="1g"></el-option>
                  <el-option label="澳门居民来往内地通行证" value="1h"></el-option>
                  <el-option label="军事学员证" value="1i"></el-option>
                  <el-option label="军官退休证" value="1j"></el-option>
                  <el-option label="文职干部退休证" value="1k"></el-option>
                  <el-option label="离休干部荣誉证" value="1l"></el-option>
                  <el-option label="边民出入境通行证" value="1m"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="certNum" label="证件号码">
                <el-input v-model="party.certNum" :disabled="isView"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="isPotentialCust" label="是否信贷客户">
                <el-select clearable v-model="party.isPotentialCust" :disabled="isView">
                  <el-option v-for="(value,key) in yesOrNoOpts" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
        <fieldset>
          <legend>家庭财务信息：</legend>
          <el-form ref="dashboard" :model="family" label-width="140px">
            <el-col :span="12">
              <el-form-item label="日期" prop="financeDate">
                <el-input v-model="family.financeDate" disabled></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="个人月收入" prop="personMonthlyIncome">
                <el-input v-model="family.personMonthlyIncome"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="家庭稳定收入（月）" prop="familySteadyIncome">
                <el-input  v-model="family.familySteadyIncome" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="家庭租金收入（月）" prop="familyRentIncome">
                <el-input  v-model="family.familyRentIncome" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="家庭投资分红（月）" prop="familyInvestmentShare">
                <el-input  v-model="family.familyInvestmentShare" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="家庭其它收入（月）" prop="familyOtherIncome">
                <el-input  v-model="family.familyOtherIncome" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="金融资产" prop="financialAssets">
                <el-input  v-model="family.financialAssets" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="固定资产" prop="fixedAssets">
                <el-input  v-model="family.fixedAssets" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="其它资产及投资" prop="otherAsset">
                <el-input  v-model="family.otherAsset" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="负债及或有负债" prop="incurDebts">
                <el-input  v-model="family.incurDebts" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="每月其它债务支出" prop="monthDebtPay">
                <el-input  v-model="family.monthDebtPay" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="备注" prop="remark">
                <el-input  v-model="family.remark" style="width:100%"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </fieldset>
      </el-col>
    </el-row>
    <div v-if="buttonView">
      <el-button :size="size" type="primary" @click.native="saveFamilyFinace" :loading="editLoading">保存</el-button>
    </div>
  </div>
  <!--<div class="dashboard-text">role:<span v-for='role in roles' :key='role'>{{role}}</span></div>-->
</template>
<script>
  import { mapGetters } from 'vuex'
  //import {getCusInfo,getAssetsList} from '@/api/org'
  import enums from "@/utils/enums"
  import commonUtil from "@/utils/commonUtil"
  import { saveAndUpdateFamilyFinace } from '@/api/csm'
  export default {
    name: "natural-family",
    props:{
      party:{},
      family:{},
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
      saveFamilyFinace () {
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
      isDisabled: function (vueType) {
        console.log('进入判断')
        if(vueType == 'view'){
          this.isView = true;
          this.buttonView = false;
        }else{
          this.isView = false;
          this.buttonView = true;
        }
      },
      //详细信息页面进入自动渲染数据
      infoInit: function(){
        // console.log('进入新增渲染');
        // this.pageRequest.partyId = this.$route.query.partyId;
        // console.log( this.pageRequest);
        // this.$api.cusManage_naturalCus.queryNaturalByPartyId(this.pageRequest).then((res) => {
        //   console.log('naturalRes:'+JSON.stringify(res.data))
        //   if(res && res.data && res.data.code == 200) {
        //     let dataForm =  Object.assign({}, res.data.data);
        //     this.party.isPotentialCust = dataForm.isPotentialCust;
        //     this.party.partyName = dataForm.partyName;
        //     this.party.ecifPartyNum = dataForm.ecifPartyNum;
        //     this.party.partyNum = dataForm.partyNum;
        //     if(dataForm.certType == '10'){
        //       console.log('进入身份证获取生日性别');
        //       this.getBD(dataForm);
        //     }
        //     console.log(dataForm);
        //     this.natural = Object.assign({}, dataForm);
        //     console.log(this.natural);
        //   } else {
        //     this.$message({message: '客户概况信息加载失败, ' + res.data.msg, type: 'error'})
        //   }
        // }).catch((res) => {
        //   this.$message({message: '初始查询用户信息失败, 错误信息：' + res, type: 'error'})
        //   console.error('初始查询用户信息失败, 错误信息：' + res)
        // }).then(data!=null?data.callback:'')
      },
    },
    mounted() {
      // console.log('开始渲染');
      // console.log(this.$route.query.vueType);
      // let vueType = this.$route.query.vueType;
      // this.isDisabled(vueType);
      // this.infoInit();
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

