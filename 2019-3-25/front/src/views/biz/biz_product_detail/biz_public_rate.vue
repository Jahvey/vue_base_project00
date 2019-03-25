<!--自己用原生的element写，这是利率信息页面-->
<template>
  <el-container>
    <el-main>
      <legend>利率信息</legend>
      <hr>
      <div id="tableloanrate">

        <!--表单2-->
        <el-row :gutter="20"
                class="form">
          <el-form el-form
                   label-width="200px"
                   size="mini"
                   :model="form2"
                   ref="form2"
                   label-position="right">
            <el-col :span="12">
              <el-form-item label="利率类型:"
                            prop="loanOrg"
                            class="special-input">
                <el-input v-model="form2.loanOrg"
                          :disabled=false
                          @blur="selectAccOrg"></el-input>

              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="浮动方式:"
                            v-show="isPayOutFlag"
                            prop="payOutFlag"
                            class="special-input">

              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="经办人:"
                            prop="userNum"
                            class="special-input">
                <el-input v-model="form2.userNum"
                          :disabled=true></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="经办机构:"
                            prop="payOutFlag"
                            class="special-input">
                <el-input v-model="form2.orgNum"
                          :disabled=true></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>

      </div>

    </el-main>

    <el-footer>
      <el-row :gutter="20">
        <el-col :span="6">
          <el-button type="primary"
                     v-show="isSave"
                     :disabled=!isSave
                     @click="save"
                     size="medium">保存</el-button>
        </el-col>
      </el-row>
    </el-footer>
  </el-container>

</template>

<script>
import qs from 'qs'

export default {
  name: 'biz_public_rate',
  components: {

    // loanInfo1,
    // bhInfo,
    // payOrgSelect
  },
  props: {
    paramsInfo: {// 接收父组件传递过来的参数

    }
  },
  data() {
    return {
      payInfoParam: {// 父子传参，把这个pay_Info的信息传递到嵌入这个页面的子组件

      },
      childFlag: {// 直接从父页面给一些标志位给子页面，要定义很多属性
        isYearRate: false,
        isLoanAmt: false,
        isEndDate: false
      },
      o: '', // 定义一个变量接收后台返回值
      currentView: '', // 加载的东西
      isSave: true,
      isPrintFKPZ: true,
      isPrintFKCXPZ: true,
      isLoanInfo1: false, // 基本贷款信息（停用这个）
      isBhInfo: false, // 保函信息（停用这个）
      isPayOutFlag: true, // 借新还旧相关
      dialogVisible: false,
      form2: {// 原生写法，必须要把form表单里面的所有属性都申明出来，否则无法展示
        loanOrg: '',
        payOutFlag: '',
        userNum: '', // 经办人以后可以直接从session里面去获取，获取实际名字
        orgNum: ''
      }
    }
  },
  created() {
    // let param = {loanId: this.paramsInfo.loanId, addr: this.paramsInfo.addr}//因为页面加载时间不一致，这些参数可能会在这个页面渲染之后出现，导致报错
    const param = { loanId: '402881e967bb828101686fbaa3be0122', addr: 'pay/payout_info/loan_info' }
    this.initPayInfo(param)// 初始化pay_info
  },
  methods: {
    initPayInfo(data) {
      getInitPayInfo(data).then(response => { // 初始化pay_info的部分信息，流程id没有接上来
        const o = response.data
        this.o = o
        this.initDate(this.o)// 初始化日期
        this.form2 = o.loanInfo
        const productType = o.contractInfo.productType
        const pjzl = o.loanInfo.pjzl
        let proFlag

        if (productType == '01004001' || productType == '01006001' || productType == '01006002' ||
          productType == '01008001' || productType == '01008002' || productType == '01008010' || productType == '01010001' ||
          productType == '01011001' || productType == '01012001' || productType == '01006010') { // 村镇银行贴现产品
          this.isPrintFKPZ = false
          this.isPrintFKCXPZ = false
        } else {
          if (o.objs) { // 查询是否是会计复核岗
            const postNum = o.objs
            if (postNum > 0) {
              /*             if( o.tbProcess.processdefname.indexOf("repayback")!=-1){//这是流程相关的东西，先注释掉
                             nui.get("printFKPZ").hide();
                             nui.get("printFKCXPZ").show();
                           }else{
                             nui.get("printFKCXPZ").hide();
                             nui.get("printFKPZ").show();
                           }*/
            } else {
              this.isPrintFKPZ = false
              this.isPrintFKCXPZ = false
            }
          }
        }
        // 如果没有还款方式，默认1200
        if (o.loanInfo.repayType == null || o.loanInfo.repayType == '') {
          this.o.loanInfo.repayType = '1200'
        }

        const flagType = o.bizHappenType// 借新还旧标志
        const bizHappenType = flagType.substring(0, 2)
        const ynflag = flagType.substring(3, 4)
        if (bizHappenType != '06') {
          this.isPayOutFlag = false
        } else { // 借新还旧是否归还利息
          if (!o.loanInfo.payOutFlag) {
            this.o.loanInfo.payOutFlag = '1'
          }
        }
        if (ynflag == '1') { // 年利率可以编辑
          this.childFlag.isYearRate = false
        } else { // 年利率不可以编辑
          this.childFlag.isYearRate = true
        }
        proFlag = '1'// 先在这里给你写一个假数据，以后是直接从其他页面传递过来
        if (proFlag != '1') { // 如果流程标识为0表示为查看，隐藏保存按钮禁用控件，pay_apply已经赋了初始值	1
          this.isSave = false
          // this.isEnable()//无法实现
          // form.setEnabled(false);//整个表单（子组件和父组件表单）不可编辑
        }
        // 如果开始时间或者结束时间存在，则计算基准利率
        const beginDate = o.loanInfo.beginDate
        const endDate = o.loanInfo.endDate
        if (beginDate && endDate) {
          // this.countRate(o,setValue)//计算基准利率  setValue is not defined 有问题，在这里直接调用这个方法
        }
        // 国结的产品，一个合同只能做一次出账 而且出账金额要等于合同金额
        if (productType == '01007001' || productType == '01007003' || productType == '01007004' || productType == '01007009' ||
          productType == '01007012' || productType == '01007011' || productType == '01007006' || productType == '01007005' ||
          productType == '01007010' || productType == '01007013' || productType == '01007014') {
          this.o.loanInfo.loanAmt = o.contractInfo.contractAmt
          this.childFlag.isLoanAmt = true// 出账金额不允许修改
        }
        // 银承
        if (productType == '01008001' || productType == '01008002' || productType == '01008010') {
          if (pjzl == '02') { // 电票
            if (o.hps != null) {
              this.o.loanInfo.endDate = o.hps.drftExpDt
              this.childFlag.isEndDate = true// 到期日期不允许修改
            }
          } else { // 不是电票
            this.childFlag.isEndDate = false// 到期日期可以修改
          }
        }
        this.payInfoParam = { o: this.o, childFlag: this.childFlag }
        if (data.addr == 'pay/payout_info/bh_info') { // 保函、信贷证明、项目贷款承诺函
          this.currentView = 'bhInfo'
          console.log('保函、信贷证明、项目贷款承诺函:pay/payout_info/bh_info')
        } else if (data.addr == 'pay/payout_info/cdhp_info') { // 承兑汇票
          alert('承兑汇票:pay/payout_info/cdhp_info')
        } else if (data.addr == 'pay/payout_info/tx_info') { // 村镇银行贴现产品
          alert('村镇银行贴现产品:pay/payout_info/tx_info')
        } else if (data.addr == 'pay/payout_info/yh_info') { // 押汇类产品
          alert('押汇类产品:pay/payout_info/yh_info')
        } else if (data.addr == 'pay/payout_info/xyz_info') { // 信用证
          alert('信用证:pay/payout_info/xyz_info')
        } else {
          this.currentView = 'loanInfo1'
          console.log('普通贷款信息:pay/payout_info/loan_info')
        }
        console.log(this.o)
      }).catch((error) => {
        console.log(error)
        console.log('pay_info报错了')
      })
    },
    save() { // 验证规则写在哪？form表单引入验证规则之后save需不需要也引入那些验证规则？？
      const childData = this.$refs.currentView.payChildForm// 获取的子组件的form表单内容
      let beginDate = childData.beginDate
      let endDate = childData.endDate

      if (beginDate == '' || beginDate == null || endDate == '' || endDate == null) {
        return alert('请填入正确的期限')
      }
      // this.isSave = true//暂时不用
      if (typeof (beginDate) !== 'number') {
        beginDate = Date.parse(beginDate)
      }
      if (typeof (endDate) !== 'number') {
        endDate = Date.parse(endDate)
      }
      if (childData.loanAmt == null || childData.loanAmt == '') {
        alert('出账金额不能为0')
        // nui.get("btnCreate").setEnabled(true)//保存按钮可编辑
        return
      }
      if (beginDate == endDate) {
        alert('出账起期不能等于出账止期')
        // nui.get("btnCreate").setEnabled(true);//保存按钮可编辑
        return
      }
      // 合同起期大于营业日期即借据起期，不让申请        感觉前面验证开始日期的时候已经处理了
      if (beginDate < parseFloat(this.o.contractInfo.beginDate)) {
        nui.alert('借据起期小于合同起期')
        // nui.get("btnCreate").setEnabled(true);////保存按钮可编辑
        return
      }
      // nui.get("btnCreate").setEnabled(false);
      console.log('保存安妮---------------------------------')
      childData.beginDate = beginDate
      childData.endDate = endDate

      const postData = qs.stringify({
        baseRateValue: childData.baseRateValue,
        beginDate: childData.beginDate,
        currencyCd: '9527'
      })
      savePayInfo(childData).then(response => {
        const yy = response.data// 真实结果
        console.log(yy)
      }).catch((error) => {
        console.log(error)
        console.log('childData，保存报错了！！！！！！')
      })
    },
    printFKPZ() {
      alert('打印放款凭证')
    },
    printFKCXPZ() {
      alert('打印放款撤销凭证')
    },

    fatherFunc(str) {
      alert('父组件的方法，测试用' + str)
    },
    cancel() {
      this.dialogVisible = false
    }
  }
}

</script>

<style scoped>
.form {
  margin-top: 20px;
  margin-right: 20px;
}
</style>
