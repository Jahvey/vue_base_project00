<!--仲裁方式公共页面-->
<template>
  <el-row :gutter="20"
          class="form">

    <el-form label-width="200px"
             size="medium"
             label-position="right"
             :model="tbConAttachedInfo"
             ref="tbConAttachedInfo"
             :rules="rules"
             :disabled=bizPublicZcfsDisable>
      <fieldset>
        <legend>
          <span>仲裁方式
          </span>
        </legend>
        <div columns="4">

          <!--XD_SXYW0209-->
          <el-col :span="12">
            <el-form-item label="争议解决方式:"
                          prop="arbitrateType"
                          class="special-input">
              <el-select v-model="tbConAttachedInfo.arbitrateType"
                         @change="arbiTypeChange"
                         placeholder="---请选择---">
                <el-option v-for="(value,key) in arbitrateType"
                           :key="key"
                           :label="value"
                           :value="key"></el-option>
              </el-select>

            </el-form-item>
          </el-col>

          <div id="zcdiv"
               v-show="zcdiv">
            <el-col :span="12">
              <el-form-item label="仲裁委员会名称:"
                            prop="arbitrateName"
                            class="special-input">

                <el-input placeholder="arbitrateName"
                          v-model="tbConAttachedInfo.arbitrateName">
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="仲裁委员会地址:"
                            prop="arbitrateAddress"
                            class="special-input">

                <el-input placeholder="arbitrateAddress"
                          v-model="tbConAttachedInfo.arbitrateAddress">
                </el-input>
              </el-form-item>
            </el-col>
          </div>

          <div id="otherediv"
               v-show="otherediv">
            <el-col :span="12">

              <el-form-item label="其它方式:"
                            prop="other"
                            class="special-input">

                <el-input type="textarea"
                          :autosize="{ minRows: 1, maxRows: 3}"
                          placeholder="other"
                          style="width:100%;float:left"
                          v-model="tbConAttachedInfo.other">
                </el-input>
              </el-form-item>

            </el-col>
          </div>

          <!-- 村行的争议解决方式新增了一个  指定诉讼 -->
          <div id="courtdiv"
               v-show="courtdiv">
            <el-col :span="12">
              <el-form-item label="指定诉讼法院:"
                            prop="legalCourt"
                            class="special-input">

                <el-input placeholder="legalCourt"
                          v-model="tbConAttachedInfo.legalCourt">
                </el-input>
              </el-form-item>
            </el-col>

          </div>

        </div>

      </fieldset>

    </el-form>
  </el-row>
</template>
<script>

import enums from '@/utils/enums'// 格式化的枚举

export default {
  name: 'bizPublicZcfs',

  props: {

  },
  data() {
    return {
      bizPublicZcfsDisable: false, // 默认所有的都可以正常编辑
      zcdiv: true,
      otherediv: true,
      courtdiv: true,
      tbConAttachedInfo: {

      },
      arbitrateType: enums.arbitrateTypeCd,

      rules: {
        arbitrateType: [{ required: true, message: '必须选择一个', trigger: ['blur', 'change'] }

        ],
        arbitrateName: [{ required: true, message: '名称不能为空', trigger: 'blur' },
          { min: 0, max: 255, message: '名称不能超过255个字符', trigger: 'blur' }
        ],
        arbitrateAddress: [{ required: true, message: '地址不能为空', trigger: 'blur' },
          { min: 0, max: 255, message: '地址不能超过255个字符', trigger: 'blur' }
        ],
        other: [{ required: true, message: '其他方式不能为空', trigger: 'blur' },
          { min: 0, max: 500, message: '其他方式不能超过500个字符', trigger: 'blur' }
        ],
        legalCourt: [{ required: true, message: '必须指定法院', trigger: 'blur' },
          { min: 0, max: 200, message: '法院名称不能超过200个字符', trigger: 'blur' }
        ]
      }

    }
  },

  methods: {
    // 仲裁方式变更时触发
    arbiTypeChange(e) {
      console.log(e)
      if (e == '2') { // 仲裁
        this.otherediv = false
        this.zcdiv = true
        this.courtdiv = false
      } else if (e == '3') { // 其他
        this.otherediv = true
        this.zcdiv = false
        this.courtdiv = false
      } else if (e == '4') { // 选指定诉讼
        this.courtdiv = true
        this.zcdiv = false
        this.otherediv = false
      } else { // 诉讼
        this.otherediv = false
        this.zcdiv = false
        this.courtdiv = false
      }
    }
  }

}
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
.form {
  margin-top: 20px;
  margin-right: 20px;
}
</style>
