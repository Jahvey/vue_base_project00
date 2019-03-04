<!--详细信息 存货-->
<template>
  <div class="mp-detail-for-stock">
    <el-row>
      <el-form el-form label-width="170px" :model="stockInfo" label-position="right" :rules="rules" ref="validate" >
        <el-col :span="24">
          <p>价值信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="币种" prop="currencyCd" >
            <el-select :disabled="inputComponentDisable"  v-model="stockInfo.currencyCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in currencyOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="抵质押物认定价值(元)" prop="marketValue" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.marketValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定方式" prop="assetStatus" >
            <el-select :disabled="inputComponentDisable" v-model="stockInfo.assetStatus" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in worthEvaluateWayOption" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="账面原值/取得价值(元)" prop="bookValue" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.bookValue" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定时间" prop="evaluateDate" >
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="stockInfo.evaluateDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="价值认定到期日"  prop="submittingDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="stockInfo.submittingDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <p>存货信息</p>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存货类型" prop="merchandiseTypeCd" >
            <el-select :disabled="inputComponentDisable" v-model="stockInfo.merchandiseTypeCd" placeholder="请选择" style="width:100%">
              <el-option v-for="(value,key) in merchandiseTypeCdOpt" :key="key" :label="value" :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存货名称" prop="merchandiseName" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.merchandiseName" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数量" prop="amount" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.amount" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="单位" prop="unit" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.unit" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="单价(元)" prop="price" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.price" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="市场价值(元)" prop="rightPledgeNum" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.rightPledgeNum" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存放时间"  prop="storeStartDate">
            <el-date-picker :editable="false" :disabled="inputComponentDisable" format="yyyy-MM-dd" value-format="yyyy-MM-dd" v-model="stockInfo.storeStartDate" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="存放地点" prop="storePlace" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.storePlace" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记机关" prop="registOrg" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.registOrg" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保管责任人" prop="storeManager" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.storeManager" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="保存状态" prop="storeStutas" >
            <el-input :disabled="inputComponentDisable" v-model="stockInfo.storeStutas" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" >
          <el-form-item label="其他情况说明" prop="otherNote" >
            <el-input :disabled="inputComponentDisable" type="textarea" v-model="stockInfo.otherNote" style="width:100%"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row>
      <el-col :span="6" :offset="10">
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="comfirm" >{{buttonText}}</el-button>
        <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import enums from "@/utils/enums"
  import { updateMerchandiseAndGrtCollateral,selectMerchandiseByGuarantyId} from '@/api/securitymanagement'
  export default {
    name: "mp-detail-for-stock",
    props:{
      grtCollateralInfo:Object,
      isUpdate:{
        default:false,
        type:Boolean,
      },
    },
    beforeMount(){
      //数据回显
      if(this.isUpdate){
        selectMerchandiseByGuarantyId(this.grtCollateralInfo).then(response =>{
          if(response.data.flag=='true') {
            this.stockInfo = response.data.data;
          } else{
            this.$message({
              message: '数据回显'+JSON.stringify(response.data),
              type: 'error'
            });
          }
        });
      }
    },
    data(){
      return{
        stockInfo:{
          lastUpdateUserNum:this.grtCollateralInfo.lastUpdateUserNum,//最后维护人用户编号
          lastUpdateOrgCd:this.grtCollateralInfo.lastUpdateOrgCd,//最后维护人所属机构
          guarantyId:this.grtCollateralInfo.guarantyId,//担保ID
          currencyCd:"",//币种
          marketValue:"",//抵质押物认定价值(元)
          bookValue:"",//账面原值/取得价值(元)
          assetStatus:"",//价值认定方式
          evaluateDate:"",//价值认定时间
          submittingDate:"",//价值认定到期日
          /*存货信息*/
          merchandiseTypeCd:"",//存货类型
          merchandiseName:"",//存货名称
          amount:"",//数量
          unit:"",//单位
          price:"",//单价
          rightPledgeNum:"",//市场价值(元)
          storeStartDate:"",//存放时间
          storePlace:"",//存放地点
          registOrg:"",//登记机关
          storeManager:"",//保管责任人
          storeStutas:"",//保存状态
          otherNote:"",//其他情况说明
        },
        rules:{
          merchandiseTypeCd: [
            {
              required: true,
              message: "请选择",
              trigger: 'change'
            }
          ],
          merchandiseName: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          storeStutas: [
            {
              required: false,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          storeManager: [
            {
              required: false,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          amount: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 9,
              message: '长度不超过 9 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^[+]{0,1}(\d+)$/,
              message: '请输入正确的金额',
              trigger: 'blur'
            }
          ],
          unit: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            } ,
            {
              max: 5,
              message: '长度不超过 5 个字符',
              trigger: 'blur'
            },
          ],
          price: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 8,
              message: '长度不超过 8 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的金额',
              trigger: 'blur'
            }
          ],
          rightPledgeNum: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 10,
              message: '长度不超过 10 个字符',
              trigger: 'blur'
            },
            {
              pattern: /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/,
              message: '请输入正确的金额',
              trigger: 'blur'
            }
          ],
          storePlace: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          registOrg: [
            {
              required: true,
              message: "请输入",
              trigger: 'change'
            },
            {
              max: 50,
              message: '长度不超过 50 个字符',
              trigger: 'blur'
            },
          ],
          otherNote: [
            {
              required: false,
              message: "请输入其他说明",
              trigger: 'blur'},
            {
              max: 100,
              message: '长度不超过 100 个字符',
              trigger: 'blur'
            },
          ],
          storeStartDate:[
            {
              required: false,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            }
          ],
          /*价值信息 rules*/
          assetStatus: [
            {
              required: true,
              message: "请选择价值认定方式",
              trigger: 'change'
            }
          ],
          bookValue: [
            {
              required: true,
              message: "请输入帐面原值/取得价值",
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
          marketValue: [
            {
              required: true,
              message: "请输入抵质押物认定价值",
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
          currencyCd: [
            {
              required: true,
              message: "请选择币种",
              trigger: 'change'
            }
          ],
          evaluateDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
          submittingDate:[
            {
              required: true,
              message: "请选择日期",
              trigger: 'change',
              //type: 'date'
            },
          ],
        },
        merchandiseTypeCdOpt:enums.merchandise_type_cd,//
        buttonDisable:false,
        buttonText:"提交",
        inputComponentDisable:false,
        currencyOption:enums.currencyCd,//币种类型选项
        worthEvaluateWayOption:enums.GuarantyValueEvaluationMethod,//价值认定方式
        yesNotOption:enums.commonYesAndNotCd,//是否选择
      }
    },
    methods:{
      comfirm:function () {
        this.$refs["validate"].validate((valid) => {
          if(valid){
            this.buttonDisable = true;
            this.buttonText = "提交中";
            updateMerchandiseAndGrtCollateral(this.stockInfo).then(response =>{
              if(response.data.flag=='true') {
                //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击
                this.buttonDisable = true;
                this.buttonText = "已提交";
                this.inputComponentDisable = true;
                this.$message({
                  message: '提交成功',
                  type: 'success'
                });
              } else{
                this.buttonDisable = false;
                this.buttonText = "提交";
                this.$message({
                  message: '提交失败'+JSON.stringify(response.data),
                  type: 'error'
                });
              }
            });
          } else{
            this.$message({
              message: '请将信息填写完整',
              type: 'error'
            });
          }
        });
      },
      doReset:function () {
        this.$refs["validate"].resetFields();
      },
    },
  }
</script>

<style scoped>
  .mp-detail-for-stock{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-stock p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
