<template>
  <div class="biz-apply-zc">
    <template>
      <el-dialog
        :visible.sync="treeVisible"
        width="95%"
        :fullscreen="fullScreen"
        :before-close="handleGoodsDetailInfoClose"
        append-to-body>
        <AppBizTree v-bind:info="info" v-bind:bizInfo="bizInfo" />
      </el-dialog>
    </template>
    <el-row>
      <el-form el-form ref="updateBizInfoValidate" label-width="200px" :model="bizInfo" label-position="right" :rules="rules" >
        <el-col :span="12">
          <el-form-item label="客户编号" prop="partyNum">
            <el-input  v-model="bizInfo.partyNum" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="客户名称" prop="partyName">
            <el-input  v-model="bizInfo.partyName" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="证件类型" prop="certType">
            <el-input  v-model="bizInfo.certType" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="证件号码" prop="certNum">
            <el-input  v-model="bizInfo.certNum" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="信用等级" prop="creditLevel">
            <el-input  v-model="bizInfo.creditLevel" disabled style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务性质" prop="creditMode" >
            <el-select  v-model="bizInfo.creditMode" placeholder="请选择" disabled style="width:100%">
              <el-option v-for="(value,key) in creditModeOption"  :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务类型" prop="bizHappenType" >
            <el-select  v-model="bizInfo.bizHappenType" placeholder="请选择" disabled style="width:100%">
              <el-option v-for="(value,key) in bizHappenTypeOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="业务品种" prop="productType">
            <el-input  v-model="bizInfo.productType" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="担保方式" prop="guarantyType" >
            <el-checkbox-group v-model="bizInfo.guarantyType" style="width:100%">
              <el-checkbox label="01" name="guarantyType">信用</el-checkbox>
              <el-checkbox label="04" name="guarantyType">保证</el-checkbox>
              <el-checkbox label="02" name="guarantyType">抵押</el-checkbox>
              <el-checkbox label="03" name="guarantyType">质押</el-checkbox>
              <el-checkbox label="05" name="guarantyType">保证金</el-checkbox>
            </el-checkbox-group>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="12">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmBizApply">{{buttonText}}</el-button>
      </el-col>
    </el-row>
  </div>
</template>


<script>
  import enums from "@/utils/enums"
  import AppBizTree from '../BizApp/AppBizTree'
  import commonUtil from '@/utils/commonUtil'
  import { saveAppBizInfo } from '@/api/csm'
  export default {

    name: "biz-apply-zc",
    props:{
      bizInfo:{guarantyType:[]},
      treeVisible:false,
      bizVisible:false
    },
    components: { AppBizTree },
    data(){
      return{
        info:{},
        fullScreen:true,//是否全屏
        creditModeOption:enums.creditMode,//业务性质选项
        bizHappenTypeOption:enums.bizHappenType,//业务类型选项
        rules:{
          productType: [
            {
              required: true,
              message: "请选择业务品种",
              trigger: 'change'
            }
          ],
          guarantyType: [
            { type: 'array', required: true, message: '请至少选择一个担保方式', trigger: 'change' }
          ],
          insuranceCompanyName: [
            {
              required: true,
              message: "请输入保险机构",
              trigger: 'change'
            }
          ],
          insurancePolicyNum: [
            {
              required: true,
              message: "请输入保险单编号",
              trigger: 'change'
            }
          ],
          insuranceType: [
            {
              required: true,
              message: "请输入保险险种",
              trigger: 'change'
            }
          ],
          policyHolder: [
            {
              required: true,
              message: "请输入投保人",
              trigger: 'change'
            }
          ],
          insuranceBenefitiary: [
            {
              required: true,
              message: "第一受益人",
              trigger: 'change'
            }
          ],
          insuranceAmt: [
            {
              required: true,
              message: "请输入投保金额",
              trigger: 'change'
            },
            {
              max: 20,
              message: '长度不超过 20 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的金额',
              trigger: 'blur'
            }
          ],
          startDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          endDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          effectiveDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
        },
        buttonText:"提交",
        buttonDisable:false,
      }
    },

    methods:{
      handleGoodsDetailInfoClose:function (done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            this.$emit("bizTree");
            done();
          })
          .catch(_ => {});
      },
      doConfirmBizApply:function () {
        this.$refs["updateBizInfoValidate"].validate((valid) => {
          if(valid){
            //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击,清楚输入框数据
            //发起流程部分
            this.buttonDisable = true;
            this.buttonText = "提交中";
            this.bizInfo.guarantyType = this.bizInfo.guarantyType.toString();
            let params =  Object.assign({},this.bizInfo);
            saveAppBizInfo(params).then(res => {
              if(res && res.data && res.data.code == 200){//返回数据成功
                //提示父组件关闭dialog,并且刷新，重置当前表单
                this.$refs["updateBizInfoValidate"].resetFields();
                this.$emit('backFlag',"ok");
                this.$message({
                  message: '数据提交成功！',
                  type: 'success'
                });
                this.treeVisible = true;
              } else{
                this.$message({message: '业务申请失败, 错误信息：' + res.data.msg, type: 'error'})
                console.error('业务申请流程发起失败, 错误信息：' + res.data.msg)
                this.buttonDisable = false;
                this.buttonText = "提交";
              }
            });
          } else{
            this.$message({
              message: '请按规则填写信息',
              type: 'error'
            });
          }
        });
      },
      doReset:function () {

      },
      initPage:function () {
        let query =  Object.assign({},listQuery,{partyId:this.bizInfo.partyId});
        // //console.log('listQuery ....' + listQuery)
        // getBizList(query).then((res) => {
        //     console.log(JSON.stringify(res))
        //     if(res && res.data && res.data.code == 200){//返回数据成功
        //       let myEntity = {};
        //       myEntity.total= res.data.data.total;
        //       myEntity.data = res.data.data.list;
        //       this.entity = myEntity;
        //       this.$store.dispatch('setListLoading', false);
        //     } else{
        //       this.$message({
        //         message: '查询自然人业务申请信息信息失败！',
        //         type: 'error'
        //       });
        //     }
        //     this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        //   }).catch((res) => {
        //     this.$message({message: '初始查询自然人业务申请信息失败, 错误信息：' + res, type: 'error'})
        //     console.error('初始查询自然人业务申请信息失败, 错误信息：' + res)
        //   }).then(data!=null?data.callback:'')
      }
    },
    beforeCreate:{

    }
  }
</script>
