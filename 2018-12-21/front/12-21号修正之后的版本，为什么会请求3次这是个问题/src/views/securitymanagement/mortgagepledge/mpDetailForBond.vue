<!--详细信息-----债券-->
<template>
    <div class="mp-detail-for-bond">
        <el-row>
          <el-form el-form label-width="200px" :model="bondInfo" label-position="right" :rules="rules" ref="mpRepositoryReceiptDetailValidate" >
              <el-col :span="24">
                <p>价值信息</p>
              </el-col>
              <el-col :span="12">
                <el-form-item label="币种" prop="customerType" >
                  <el-select :disabled="inputComponentDisable"  v-model="bondInfo.currency" placeholder="请选择" style="width:100%">
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
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.evaluateWorth" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="价值认定方式" prop="customerType" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.worthEvaluateWay" placeholder="请选择" style="width:100%">
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
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.originalWorth" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="价值认定时间"  >
                  <el-date-picker v-model="bondInfo.worthEvaluateTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="价值认定到期日"  >
                  <el-date-picker v-model="bondInfo.worthEvaluateTimeExpire" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="24">
                <p>存单质押信息</p>
              </el-col>
              <el-col :span="12">
                <el-form-item label="发行人名称" prop="name" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.name" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券等级" prop="bankName" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.rank" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券种类" prop="type" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.type" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="item in typeOpt"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="登记机构" prop="constitution" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.constitution" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券面值(元)" prop="worth" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.worth" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="币种" prop="bCurrency" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.bCurrency" placeholder="请选择" style="width:100%">
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
                <el-form-item label="按发行主体划分债券类型" prop="subjectType" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.subjectType" placeholder="请选择" style="width:100%">
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
                <el-form-item label="签发公司的经营状况" prop="state" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.state" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="签发公司类别" prop="companyType" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.companyType" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="item in companyTypeOpt"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="代理发行人" prop="proxy" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.proxy" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债劵人名称" prop="ownerName" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.ownerName" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券发行类型" prop="publishType" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.publishType" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="item in publishTypeOpt"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券到期日"  >
                  <el-date-picker v-model="bondInfo.endTime" type="date" placeholder="选择日期" style="width:100%"></el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券利息支付类型" prop="payType" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.payType" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="item in payTypeOpt"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券期限" prop="effectTime" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.effectTime" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券期限单位" prop="effectTimeUnit" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.effectTimeUnit" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="item in effectTimeUnitOpt"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="债券年利率" prop="ratio" >
                  <el-input :disabled="inputComponentDisable" v-model="bondInfo.ratio" style="width:100%">
                    <template slot="append">%</template>
                  </el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="是否记名债券" prop="ifRememberName" >
                  <el-select :disabled="inputComponentDisable" v-model="bondInfo.ifRememberName" placeholder="请选择" style="width:100%">
                    <el-option
                      v-for="item in yesNotOption"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="24" >
                <el-form-item label="其他情况说明" prop="otherSituationExplain" >
                  <el-input :disabled="inputComponentDisable" type="textarea" v-model="bondInfo.otherSituationExplain" style="width:100%"></el-input>
                </el-form-item>
              </el-col>
          </el-form>
        </el-row>
        <el-row>
          <el-col :span="6" :offset="10">
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doConfirmRepositoryReceiptDetail" >{{buttonText}}</el-button>
            <el-button size="medium" v-bind:disabled="buttonDisable" type="primary" @click="doReset">重置</el-button>
          </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
      name: "mp-detail-for-bond",
      data(){
        return{
          bondInfo:{
            currency:"人民币",//币种
            evaluateWorth:"",//抵质押物认定价值(元)
            originalWorth:"",//账面原值/取得价值(元)
            worthEvaluateWay:"评估确定",//价值认定方式
            worthEvaluateTime:"",//价值认定时间
            worthEvaluateTimeExpire:"",//价值认定到期日
            /*债券信息*/
            name:"",//发行人名称
            rank:"",//债券等级
            type:"国债",//债券种类
            constitution:"",//登记机构
            worth:"",//债券面值(元)
            bCurrency:"人民币",//币种
            subjectType:"金融债券",//按发行主体划分债券类型
            state:"",//签发公司的经营状态
            companyType:"金融保险业",//签发公司类别
            proxy:"",//代理发行人
            ownerName:"",//债券人名称
            publishType:"有形债券",//债券发行类型
            endTime:"",//债券到期日
            payType:"中期债劵",//债券利息支付类型
            payWay:"有息债券",//债券利息支付方式
            effectTime:"",//债券年限
            effectTimeUnit:"年",//债券期限单位
            ratio:"",//债券年利率
            ifRememberName:"是",//是否记名债券
            otherSituationExplain:"",//其他情况说明
          },
          rules:{
            name: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            rank: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            type: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            constitution: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            worth: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            bCurrency: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            subjectType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            state: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            companyType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            proxy: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ownerName: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            publishType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            payType: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            payWay: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            effectTime: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            effectTimeUnit: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ratio: [
              {
                required: true,
                message: "",
                trigger: 'change'
              }
            ],
            ifRemember: [
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
          ifShowPartOwnerInfo:false,
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
          subjectTypeOpt:[
            {
              value: '金融债券',
              label: '金融债券'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          typeOpt:[
            {
              value: '国债',
              label: '国债'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          companyTypeOpt:[
            {
              value: '金融保险业',
              label: '金融保险业'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          publishTypeOpt:[
            {
              value: '有形债券',
              label: '有形债券'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          payTypeOpt:[
            {
              value: '中期债券',
              label: '中期债券'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          payWayOpt:[
            {
              value: '有息债券',
              label: '有息债券'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
          effectTimeUnitOpt:[
            {
              value: '年',
              label: '年'
            }, {
              value: '其他',
              label: '其他'
            },
          ],
        }
      },
      methods:{
        doConfirmRepositoryReceiptDetail:function () {
          this.$refs["mpRepositoryReceiptDetailValidate"].validate((valid) => {
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
          this.$refs["mpRepositoryReceiptDetailValidate"].resetFields();
        },
        onSelectChange:function (data) {//是否共有人选择事件
          if(data == '是'){
            this.ifShowPartOwnerInfo = true;
          } else{
            this.ifShowPartOwnerInfo = false;
          }
        }
      },
    }
</script>

<style scoped>
  .mp-detail-for-bond{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-detail-for-bond p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
</style>
