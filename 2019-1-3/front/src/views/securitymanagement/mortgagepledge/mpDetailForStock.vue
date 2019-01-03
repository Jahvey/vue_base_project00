<!--详细信息 存货-->
<template>
    <div class="mp-detail-for-stock">
      <el-row>
        <el-form el-form label-width="170px" :model="stockInfo" label-position="right" :rules="rules" ref="mpStockDetailValidate" >
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="customerType" >
              <el-select :disabled="inputComponentDisable"  v-model="stockInfo.currency" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in currencyOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="抵质押物认定价值(元)" prop="evaluateWorth" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="stockInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in worthEvaluateWayOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="账面原值/取得价值(元)" prop="originalWorth" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="stockInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="stockInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>存货信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="存货类型" prop="stockType" >
              <el-select :disabled="inputComponentDisable" v-model="stockInfo.stockType" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in stockTypeOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="存货名称" prop="stockName" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.stockName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="数量" prop="number" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.number" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="单位" prop="stockType" >
              <el-select :disabled="inputComponentDisable" v-model="stockInfo.unit" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in unitOpt"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="单价(元)" prop="unitPrice" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.unitPrice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="市场价值(元)" prop="marketWorth" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.marketWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="存放时间"  >
              <el-date-picker v-model="stockInfo.storeTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="存放地点" prop="storePlace" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.storePlace" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="登记机关" prop="registerOffice" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.registerOffice" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保管责任人" prop="principal" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.principal" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保存状态" prop="state" >
              <el-input :disabled="inputComponentDisable" v-model="stockInfo.state" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="stockInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmStockDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "mp-detail-for-stock",
      data(){
        return{
          stockInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*存货信息*/
            stockType:"原材料",//存货类型
            stockName:"",//存货名称
            number:"",//数量
            unit:"个",//单位
            unitPrice:"",//单价
            marketWorth:"",//市场价值(元)
            storeTime:"",//存放时间
            storePlace:"",//存放地点
            registerOffice:"",//登记机关
            principal:"",//保管责任人
            state:"",//保存状态
            otherSituationExplain:"",//其他情况说明
          },
          rules:{
            stockType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            stockName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            number: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            unit: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            unitPrice: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            marketWorth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            storePlace: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            registerOffice: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            otherSituationExplain: [
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
            /*价值*/
            currency: [
              {
                required: true,
                message: "请选择币种",
                trigger: 'change'
              }
            ],
            worthEvaluateWay: [
              {
                required: true,
                message: "请选择评估方式",
                trigger: 'change'
              }
            ],
            evaluateWorth: [
              {
                required: true,
                message: "请输入抵质押物认定价值",
                trigger: 'blur'},
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
            originalWorth: [
              {
                required: true,
                message: "请输入账面原值/取得价值",
                trigger: 'blur'},
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
          },
          buttonDisable:false,
          buttonText:"提交",
          inputComponentDisable:false,
          unitOpt:[
            {
              value: '个',
              label: '个'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          stockTypeOpt:[
            {
              value: '原材料',
              label: '原材料'
            }, {
              value: '其他',
              label: '其他'
            },
          ],//
          currencyOption:[
            {
              value: '人民币',
              label: '人民币'
            }, {
              value: '美元',
              label: '美元'
            },
          ],//币种类型选项
          worthEvaluateWayOption:[
            {
              value: '评估确定',
              label: '评估确定'
            }, {
              value: '协商确定',
              label: '协商确定'
            },
          ],//价值认定方式
          yesNotOption:[
            {
              value: '是',
              label: '是'
            }, {
              value: '否',
              label: '否'
            },
          ],//是否选择
        }
      },
      methods:{
        doConfirmStockDetail:function () {
          this.$refs["mpStockDetailValidate"].validate((valid) => {
            if(valid){
              //访问服务器，返回结果，做判断，提交成功，输入框不可获取焦点，确定和重置按钮不可点击
              this.buttonDisable = true;
              this.buttonText = "已提交";
              this.inputComponentDisable = true;
              this.$message({
                message: '数据提交成功！',
                type: 'success'
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
          this.$refs["mpStockDetailValidate"].resetFields();
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
