<template>
    <div class="mp-detail-for-ware-house-receipt">
      <el-row>
        <el-form el-form label-width="170px" :model="wareHouseReceiptInfo" label-position="right" :rules="rules" ref="mpWareHouseReceiptDetailValidate" >
          <el-col :span="24">
            <p>价值信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="customerType" >
              <el-select :disabled="inputComponentDisable"  v-model="wareHouseReceiptInfo.currency" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.evaluateWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定方式" prop="customerType" >
              <el-select :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.originalWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定时间"  >
              <el-date-picker v-model="wareHouseReceiptInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价值认定到期日"  >
              <el-date-picker v-model="wareHouseReceiptInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <p>仓单信息</p>
          </el-col>
          <el-col :span="12">
            <el-form-item label="品种" prop="variety" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.variety" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="数量(吨)" prop="number" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.number" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="有效截止日" >
              <el-date-picker v-model="wareHouseReceiptInfo.validTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="仓库名称" prop="whrName" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.whrName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="仓库地址" prop="whrAddress" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.whrAddress" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="户主名称" prop="shipperName" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.shipperName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="品名" prop="goodsName" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.goodsName" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="商标" prop="tradeMark" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.tradeMark" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="等级" prop="level" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.level" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="入库日期" >
              <el-date-picker v-model="wareHouseReceiptInfo.inStorageTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="类别" prop="type" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.type" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="入库经办人" prop="inStoragePerson" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.inStoragePerson" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="入库审批人" prop="inStorageExaminePerson" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.inStorageExaminePerson" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保管费用(元)" prop="safeKeepingMoney" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.safeKeepingMoney" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="保管费是否缴清" prop="ifPayAllSkMoney" >
              <el-select :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.ifPayAllSkMoney" placeholder="请选择" style="width:100%">
                <el-option
                  v-for="item in yesNotOption"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="市场价值(元)" prop="marketWorth" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.marketWorth" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="币种" prop="sfwCurrency" >
              <el-select :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.sfwCurrency" placeholder="请选择" style="width:100%">
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
            <el-form-item label="仓单创办人" prop="sfwCreator" >
              <el-input :disabled="inputComponentDisable" v-model="wareHouseReceiptInfo.sfwCreator" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" >
            <el-form-item label="其他情况说明" prop="otherSituationExplain" >
              <el-input :disabled="inputComponentDisable" type="textarea" v-model="wareHouseReceiptInfo.otherSituationExplain" style="width:100%"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <el-row>
        <el-col :span="6" :offset="10">
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmWareHouseReceiptDetail" >{{buttonText}}</el-button>
          <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
        </el-col>
      </el-row>
    </div>
</template>

<script>
    export default {
      name: "mp-detail-for-ware-house-receipt",
      data(){
        return{
          wareHouseReceiptInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            variety:"",//品种
            number:"",//数量(吨)
            validTime:"2019-08-09",//有效截止日
            whrName:"",//仓库名称
            whrAddress:"",//仓库地址
            shipperName:"",//户主名称
            goodsName:"",//品名
            tradeMark:"",//商标
            level:"",//等级
            inStorageTime:"",//入库日期
            type:"",//类别
            inStoragePerson:"",//入库经办人
            inStorageExaminePerson:"",//入库审批人
            safeKeepingMoney:"",//保管费用(元)
            ifPayAllSkMoney:"",//保管费是否缴清
            marketWorth:"",//市场价值(元)
            sfwCurrency:"",//币种（仓单）
            sfwCreator:"",//仓单创办人
            otherSituationExplain:"",//其他情况说明
          },
          rules:{
            variety: [
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
            whrName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            whrAddress: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            shipperName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            goodsName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            safeKeepingMoney: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifPayAllSkMoney: [
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
            sfwCurrency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            sfwCreator: [
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
        doConfirmWareHouseReceiptDetail:function () {
          this.$refs["mpWareHouseReceiptDetailValidate"].validate((valid) => {
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
          this.$refs["mpWareHouseReceiptDetailValidate"].resetFields();
        },
      },

    }
</script>

<style scoped>
  .mp-detail-for-ware-house-receipt{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-ware-house-receipt p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
