<template>
  <el-row :gutter="20"
          class="form">

    <!--通知书文书送达公共页面-->
    <el-form label-width="200px"
             size="medium"
             label-position="right"
             :model="notice"
             ref="notice"
             :rules="rules"
             :disabled=bizPublicNoticeDisable>
      <fieldset class="fieldsetnew">
        <legend>
          <span>甲方{{this.abcNames[0]}}送达地址和联系方式
          </span>
        </legend>
        <div id="loanrate"
             columns="4">

          <el-col :span="12">
            <el-form-item label="送达地址:"
                          prop="SendAddr"
                          class="special-input">
              <el-input type="textarea"
                        :autosize="{ minRows: 1, maxRows: 3}"
                        placeholder="enter"
                        v-model="notice.SendAddr">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="邮编:"
                          prop="Postcode"
                          class="special-input">

              <el-input placeholder="postcode"
                        class="innerbox"
                        v-model="notice.Postcode">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="收件人:"
                          prop="Receiver"
                          class="special-input">

              <el-input placeholder="receiver"
                        v-model="notice.Receiver">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">

            <el-form-item label="电话:"
                          prop="Phone"
                          class="special-input">

              <!-- <el-select v-model="notice.TelKinds"
                         @change="TelKindsEvent"
                         placeholder="手机"
                         style="width:40%;float:left">
                <el-option v-for="(value,key) in TelKinds"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select> -->

              <el-input placeholder="tel"
                        style="width:100%;float:left"
                        v-model="notice.Phone">
              </el-input>
            </el-form-item>

          </el-col>
          <el-col :span="12">
            <el-form-item label="电子邮箱:"
                          prop="Email"
                          class="special-input">

              <el-input placeholder="email address"
                        v-model="notice.Email">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="其他方式:"
                          prop="Other"
                          class="special-input">

              <el-input placeholder="anything else"
                        v-model="notice.Other">
              </el-input>
            </el-form-item>
          </el-col>

        </div>

      </fieldset>

      <fieldset class="fieldsetnew">
        <legend>
          <span>乙方{{this.abcNames[1]}}送达地址和联系方式
          </span>
        </legend>
        <div columns="4">

          <el-col :span="12">
            <el-form-item label="送达地址:"
                          prop="SendAddr"
                          class="special-input">
              <el-input type="textarea"
                        :autosize="{ minRows: 1, maxRows: 3}"
                        placeholder="enter"
                        v-model="notice2.SendAddr">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="邮编:"
                          prop="Postcode"
                          class="special-input">

              <el-input placeholder="postcode"
                        v-model="notice2.Postcode">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="收件人:"
                          prop="Receiver"
                          class="special-input">

              <el-input placeholder="receiver"
                        v-model="notice2.Receiver">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="电话:"
                          prop="Phone"
                          class="special-input">

              <el-input placeholder="tel"
                        v-model="notice2.Phone">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="电子邮箱:"
                          prop="Email"
                          class="special-input">

              <el-input placeholder="email address"
                        v-model="notice2.Email">
              </el-input>
            </el-form-item>
          </el-col>

        </div>

      </fieldset>

      <fieldset class="fieldsetnew">
        <legend>
          <span>丙方{{this.abcNames[2]}}送达地址和联系方式
          </span>
        </legend>
        <div columns="4">

          <el-col :span="12">
            <el-form-item label="送达地址:"
                          prop="SendAddr"
                          class="special-input">
              <el-input type="textarea"
                        :autosize="{ minRows: 1, maxRows: 3}"
                        placeholder="SendAddr"
                        v-model="notice3.SendAddr">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="邮编:"
                          prop="Postcode"
                          class="special-input">

              <el-input placeholder="postcode"
                        v-model="notice3.Postcode">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="收件人:"
                          prop="Receiver"
                          class="special-input">

              <el-input placeholder="receiver"
                        v-model="notice3.Receiver">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="电话:"
                          prop="Phone"
                          class="special-input">

              <el-input placeholder="tel"
                        v-model="notice3.Phone">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="电子邮箱:"
                          prop="Email"
                          class="special-input">

              <el-input placeholder="email address"
                        v-model="notice3.Email">
              </el-input>
            </el-form-item>
          </el-col>

        </div>

      </fieldset>

      <fieldset class="fieldsetnew">
        <legend>
          <span>丁方送达地址和联系方式
          </span>
        </legend>
        <div columns="4">

          <el-col :span="12">
            <el-form-item label="送达地址:"
                          prop="SendAddr"
                          class="special-input">
              <el-input type="textarea"
                        :autosize="{ minRows: 1, maxRows: 3}"
                        placeholder="enter"
                        v-model="notice4.SendAddr">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="邮编:"
                          prop="Postcode"
                          class="special-input">

              <el-input placeholder="postcode"
                        v-model="notice4.Postcode">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="收件人:"
                          prop="Receiver"
                          class="special-input">

              <el-input placeholder="receiver"
                        v-model="notice4.Receiver">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="电话:"
                          prop="Phone"
                          class="special-input">

              <el-input placeholder="tel"
                        v-model="notice4.Phone">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="电子邮箱:"
                          prop="Email"
                          class="special-input">

              <el-input placeholder="email address"
                        v-model="notice4.Email">
              </el-input>
            </el-form-item>
          </el-col>

        </div>

      </fieldset>

    </el-form>
  </el-row>

</template>

<script>

import { validatePhoneTwo, validatePostCode, validateEMail } from '@/utils/conValidate.js'

export default {
  name: 'bizPublicNotice',

  props: {

  },

  data() {
    return {

      // 控制整个页面是否可编辑，默认可以编辑
      bizPublicNoticeDisable: false,
      telKinds: false, // 默认选中手机

      // 一些隐藏的属性
      contractId: '',
      uuid: '',
      TelKinds: ['固话', '手机'],
      notice: {

      },
      notice2: {

      },
      notice3: {

      },
      notice4: {

      },
      configs: [
        // 委托贷款
        ['(委托人)', '(受托银行)', '(借款人)', '02005002', '01013001', '01013010', '02005010']
      ],
      abcNames: ['(借款人)', '(贷款人)', '', ''],
      productType: '',

      rules: {// 表单验证
        SendAddr: [
          { required: true, message: '地址信息不能为空!', tigger: 'blur' },
          { min: 0, max: 500, message: '地址长度最长为500个字符!', tigger: 'blur' }
        ],
        Postcode: [
          { required: true, validator: validatePostCode, tigger: 'blur' }
        ],
        Phone: [
          { required: true, message: '电话信息不能为空!', tigger: 'blur' },
          { validator: validatePhoneTwo, message: '电话信息不合法!', tigger: 'blur' }
        ],
        Receiver: [
          { required: true, message: '收件人信息不能为空!', tigger: 'blur' },
          { min: 0, max: 100, message: '收件人信息不能超过100个字符!', tigger: 'blur' }

        ],
        Email: [
          { required: false, validator: validateEMail, message: '电子邮件信息不合法!', tigger: 'blur' }
        ],
        Other: [
          { required: false, min: 0, max: 500, message: '长度超过了500个字符!', tigger: 'blur' }
        ]
      }

    }
  },
  created() {
    // let productType = request.getParameter("productType");
    this.productType = '01013001'
    // 暂时不用
    if (this.productType != null && (this.productType = this.productType.trim()) != null && this.configs.length > 0) {
      for (var i = 0; i < this.configs.length; i++) {
        for (var j = 3; j < this.configs[i].length; j++) {
          if (this.productType === this.configs[i][j]) {
            this.abcNames[0] = this.configs[i][0]
            this.abcNames[1] = this.configs[i][1]
            this.abcNames[2] = this.configs[i][2]
          }
        }
      }
    }
  },
  methods: {
    TelKindsEvent(value) {
      console.log('TelKindsEvent invoke...' + value)
      this.telKinds = true
    }

  }

}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.form {
  margin-top: 20px;
  margin-right: 20px;
}

// .bottomBtn {
//   margin-top: 10px;
// }
</style>

