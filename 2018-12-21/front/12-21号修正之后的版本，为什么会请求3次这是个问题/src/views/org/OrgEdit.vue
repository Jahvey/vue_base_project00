<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-form ref="orgEdit" :model="orgInfo" :rules="rules"
               label-width="120px" label-position="right">
        <el-col :span="12">
          <el-form-item label="机构名称" prop="corpName">
            <el-input v-model="orgInfo.corpName" :disabled="isCard"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="机构性质" prop="corpPropCd">
            <el-select clearable v-model="orgInfo.corpPropCd" :disabled="isCard">
              <el-option v-for="(value,key) in corpPropOpts" :key="key" :label="value" :value="key">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col>
          <el-form-item label="服务类型" prop="corpTypes">
            <el-checkbox-group v-model="orgInfo.corpTypes" :disabled="isCard">
              <template v-for="(value,key) in srvObj">
                <el-col :span="6">
                  <el-checkbox :key="value.serviceTypeId" :label="key" :name="key">
                  </el-checkbox>
                </el-col>
              </template>
            </el-checkbox-group>
          </el-form-item>
        </el-col>
        <el-col>
          <el-form-item label="机构服务介绍" prop="corpIntroduction">
            <el-input type="textarea" v-model="orgInfo.corpIntroduction" :maxlength="200" :disabled="isCard"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="营业执照号" prop="busiLicenseNo">
            <el-input v-model="orgInfo.busiLicenseNo" :disabled="isCard"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="办公电话" prop="officePhoneNo">
            <el-input v-model="orgInfo.officePhoneNo" :disabled="isCard"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="注册邮箱" prop="email">
            <el-input v-model="orgInfo.email" :disabled="isCard"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="管理员手机" prop="adminPhoneNo">
            <el-input v-model="orgInfo.adminPhoneNo" :disabled="isCard"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <template v-if="isCard">
          <el-button size="medium" type="primary" @click="doBack">返回</el-button>
        </template>
        <template v-else>
          <el-button size="medium" type="primary" @click="doSave">保存</el-button>
          <el-button size="medium" type="primary" @click="doCancel">取消</el-button>
        </template>
      </el-col>
    </el-row>
  </div>
</template>
<script>
  import {getAllServices, saveOrg, queryOrg} from '@/api/org'
  import enums from "@/utils/enums"
  import {extend} from "@/utils/validate"

  export default {

    data(){
      return {
        corpPropOpts: enums.corpPropCd,
        srvObj: [],
        orgInfo: {
          corpTypes: [],
          services: []
        },


        rules: {
          corpName: [
            {required: true, message: "请输入机构名称", trigger: 'blur'},
            {max: 100, message: '长度不超过 100 个字符', trigger: 'blur'}
          ],
          corpPropCd: [
            {required: true, message: "请选择机构性质", trigger: 'change'}
          ],
          corpIntroduction: [
            {required: true, message: "请输入机构服务介绍", trigger: 'blur'},
            {max: 1000, message: '长度不超过 1000 个字符', trigger: 'blur'}
          ],
          busiLicenseNo: [
            {required: true, message: "请输入营业执照号", trigger: 'blur'}
          ],
          email: [
            {required: true, message: "请输入邮箱地址", trigger: 'blur'},
            {type: "email", message: "请输入正确的邮箱地址"}
          ],
          adminPhoneNo: [
            {required: true, message: '请输入管理员手机', trigger: 'blur'},
            { pattern: /^1[3-9](\d){9}$/g, message: '请输入正确的手机号码', trigger: 'blur' }
          ],

        },
        isCard:false
      }
    },

    mounted(){
      this.getServices();
      var method = this.$route.query.method;
      var orgInfoId = this.$route.query.orgInfoId;
      if (method !== 'add' && orgInfoId !== undefined) {
        var queryParams = {"orgInfoId": orgInfoId}
        queryOrg(queryParams).then(response => {
          if (response !== undefined) {
            var obj = {}
            extend(obj, this.orgInfo)
            extend(obj, response)
            this.orgInfo = obj
            this.transEditSrvsToList(response.services)
          }
        })
        if(method =='detail'){
            this.isCard=true
        }
      }
    },

    methods: {
      doSave(){
        this.$refs["orgAdd"].validate((valid) => {
          if (valid) {
            this.orgInfo.services = this.transSelectSrvsToList(this.orgInfo.corpTypes)
            saveOrg(this.orgInfo).then(response => {
              this.backToInfo()
              this.$message({
                message: '保存机构信息成功',
                type: 'success'
              });
            })
          } else {
            return false;
          }
        });
      },

      doCancel(){
        this.backToInfo()
      },

      doBack(){
        this.backToInfo()
      },

      getServices() {
        getAllServices().then(response => {
          this.srvObj = this.transSrvsListToObj(response)
        })
      },

      transSrvsListToObj(services){
        var srvObj = {};
        services.forEach(function (service, index) {
          srvObj[service.typeName] = {"serviceTypeId": service.serviceTypeId, "checked": false}
        });
        return srvObj;
      },

      transSelectSrvsToList(corpTypes){
        var services = [];
        corpTypes.forEach((val, index) => {
          if(this.srvObj[val] != undefined){
            var obj = {};
            obj.serviceTypeId = this.srvObj[val].serviceTypeId
            services.push(obj)
          }
        });
        return services;
      },

      transEditSrvsToList(services){
        services.forEach((service, index) => {
          this.orgInfo.corpTypes.push(service.typeName);
        });
      },

      backToInfo(){
        this.$router.push({name: "orgInfo"})
      }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
  .el-input {
    width: 100%;
  }

  .el-select {
    width: 100%;
  }
</style>
