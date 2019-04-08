<template>

  <el-row :gutter="20"
          class="form">
    <el-form label-width="200px"
             size="medium"
             :rules="rules"
             :model="conDetail"
             ref="conDetail"
             label-position="right"
             :disabled="disProductLdzjForm">

      <div id='ht1'
           columns="4"
           v-show="isHt1">

        <!--zffsChange()-->
        <el-col :span="12">
          <el-form-item label="资金支付方式:"
                        prop="payWay"
                        class="special-input">

            <el-select v-model="conDetail.payWay"
                       style="width:100%"
                       @change="zffsChange">
              <el-option v-for="(value,key) in payWay"
                         :key="key"
                         :label="value"
                         :value="key"></el-option>
            </el-select>

          </el-form-item>
        </el-col>

      </div>

      <div id='ht2'
           columns="4"
           v-show="isHt2">

        <el-col :span="12">
          <el-form-item label="提前还款最低金额:"
                        prop="leastPrepayAmount"
                        class="special-input">
            <el-input v-model="conDetail.leastPrepayAmount"
                      style="width:100%"></el-input>

          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="提前还款基数:"
                        prop="prepayJs"
                        class="special-input">
            <el-input v-model="conDetail.prepayJs"
                      style="width:100%"></el-input>

          </el-form-item>
        </el-col>

      </div>
      <div id='ht3'
           columns="4"
           v-show="isHt3">
        <el-col :span="12">
          <el-form-item label="是否军民融合属性:"
                        prop="sfjmrhsx"
                        class="special-input">
            <el-select v-model="conDetail.sfjmrhsx"
                       style="width:100%">
              <el-option v-for="(value,key) in sfjmrhsx"
                         :key="key"
                         :label="value"
                         :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <!--XD_JMRHSX001-->
        <el-col :span="12">
          <el-form-item label="军民融合属性:"
                        prop="jmrhsx"
                        class="special-input">
            <el-select v-model="conDetail.jmrhsx"
                       style="width:100%">
              <el-option v-for="(value,key) in jmrhsx"
                         :key="key"
                         :label="value"
                         :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>

      </div>

      <div id='htdc'
           columns="4"
           v-show="isHtdc">

        <el-col :span="12">
          <el-form-item label="提前还款是否收取违约金:"
                        prop="prepaymentPenalty"
                        class="special-input">
            <el-select v-model="conDetail.prepaymentPenalty"
                       style="width:100%"
                       @change="onselectPrepaymentPenalty1">
              <el-option v-for="(value,key) in prepaymentPenalty"
                         :key="key"
                         :label="value"
                         :value="key"></el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12"
                v-show="isPrepayMakeupRate">
          <el-form-item label="违约金比例%:"
                        prop="prepayMakeupRate"
                        class="special-input">
            <el-input-number v-model="conDetail.prepayMakeupRate"
                             controls-position="right"
                             :precision="2"
                             :step="0.1"
                             :min="0"
                             :max="100"
                             style="width:100%"></el-input-number>

          </el-form-item>
        </el-col>

      </div>

      <!-- 支付方式是受托支付  约定受托支付单比支付金额(含/万)以上 -->
      <div id='stmin'
           columns="4"
           v-show="isStmin">

        <el-col :span="12">
          <el-form-item label="受托支付单笔支付金额(含)以上:"
                        prop="minAmt"
                        class="special-input">
            <el-input v-model="conDetail.minAmt"
                      style="width:100%"></el-input>

          </el-form-item>
        </el-col>

      </div>

    </el-form>

  </el-row>

</template>

<script>
import enums from '@/utils/enums'
import { } from '@/api/csm'
export default {
  name: 'productLdzj',
  props: {
    conDetailHtData: {// 专门接受从父组件传递过来的参数

    }

  },

  components: {

  },
  created() {
    console.log('[created]...')
    const params = this.conDetailHtData
    console.log('传入参数 params ' + JSON.stringify(params))
    this.isSq = false
    this.isHt1 = false
    this.isHt2 = false
    this.isHt3 = false
    this.isHtdc = false
    // 支付方式是受托支付  约定受托支付单笔支付金额(含)以上
    this.isStmin = false
    this.initPage(params)
  },
  data() {
    return {
      disProductLdzjForm: false, // 控制整个页面是否显示

      // v-show标志位：
      isStmin: true,
      isHtdc: true,
      isHt3: true,
      isHt2: true,
      isHt1: true,
      isSq: true,
      isPrepayMakeupRate: true,
      // disabled标志位

      // 相关的数据
      cycleIndCon: '',
      productType: '',
      stepFlag: '',

      // 相关的格式化
      prepaymentPenalty: enums.YesOrNoCd, // XD_0002

      payWay: enums.payWayCd, // CDXY0144
      sfjmrhsx: enums.YesOrNoCd, // YesOrNo
      jmrhsx: enums.jmrhsxCd, // XD_JMRHSX001

      rules: {

      },
      conDetail: {// 整个form表单的相关数据

      }

    }
  },

  methods: {

    initPage(params) {
      this.cycleIndCon = params.cycleIndCon// 循环标志
      this.productType = params.productType// 贷种
      if (this.cycleIndCon == null || this.cycleIndCon == '' || this.cycleIndCon == 'null') {
        this.cycleIndCon = '1'
      }

      this.stepFlag = params.stepFlag// 阶段标志
      if (this.stepFlag == 'biz') {
        this.isSq = true
      }
      if (this.stepFlag == 'con') {
        if (this.productType == '01001001' || this.productType == '01001040' ||
          this.productType == '01001041' || this.productType == '01001042') {
          this.isHt1 = true
          this.isHt2 = true
          this.isHt3 = true
        } else {
          this.isHt1 = true
          this.isHt2 = true
        }
        if (this.cycleIndCon == '0') {
          this.isHtdc = true
        }

        // modified by shendl 20180330 支付方式是受托支付  约定受托支付单比支付金额(含 / 万)以上
        if (this.productType == '01001011' || this.productType == '01001001' || this.productType == '02001016' || this.productType == '02003004' || this.productType == '02001001' || this.productType == '02003008' ||
          this.productType == '02003012' || this.productType == '02003013' || this.productType == '02001002' || this.productType == '02003001' || this.productType == '02001007' || this.productType == '01001016' ||
          this.productType == '02003005' || this.productType == '02003002' || this.productType == '01001013' || this.productType == '02001015' || this.productType == '01001009' || this.productType == '01001023' ||
          this.productType == '02003006' || this.productType == '01001017' || this.productType == '02001008' || this.productType == '02003009' || this.productType == '01001014' || this.productType == '02003007' ||
          this.productType == '01001007' || this.productType == '01001029' || this.productType == '02001005' || this.productType == '02001013' || this.productType == '01001041' || this.productType == '01001028' ||
          this.productType == '01001015' || this.productType == '02001003' || this.productType == '01001012' || this.productType == '01001027' || this.productType == '01001008' || this.productType == '02003010' ||
          this.productType == '01001020' || this.productType == '01001021' || this.productType == '01001024' || this.productType == '01001019' || this.productType == '01001025' || this.productType == '01001010' ||
          this.productType == '02003011' || this.productType == '01001018' || this.productType == '01001026' || this.productType == '02001014' || this.productType == '01001022' || this.productType == '01001040' ||
          this.productType == '01001041' || this.productType == '01001042' || this.productType == '01003011') {
          this.isStmin = true
        }
      }
    },

    zffsChange(e) {
      console.log('[zffsChange] e ' + JSON.stringify(e))
      var way = this.conDetail.payWay
      if (way == 0) {
        this.isStmin = false
      }
      if (way == 1) {
        this.isStmin = true
      }
    },
    onselectPrepaymentPenalty1() {
      console.log('[onselectPrepaymentPenalty1]')
    }

  }

}
</script>
<style scoped>
.form {
  margin-top: 20px;
  margin-right: 20px;
}

.bottomBtn {
  margin-top: 10px;
}
</style>

