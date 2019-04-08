<template>
  <el-row :gutter="20"
          class="form">

    <el-form label-width="200px"
             size="medium"
             label-position="right"
             :model="tbConAttachedInfo"
             ref="tbConAttachedInfo"
             :rules="rules"
             :disabled=disBizPublicXyqs>
      <div columns="4">
        <fieldset>
          <legend>
            <span>协议签署公共页面
            </span>
          </legend>

          <el-col :span="12">
            <el-form-item label="甲方持有份数:"
                          prop="aHoldCount"
                          class="special-input">

              <el-input-number v-model="tbConAttachedInfo.aHoldCount"
                               controls-position="right"
                               :step="1"
                               :min="1"
                               :max="4"
                               style="width:100%"></el-input-number>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="乙方持有份数:"
                          prop="bHoldCount"
                          class="special-input">
              <el-input-number v-model="tbConAttachedInfo.bHoldCount"
                               controls-position="right"
                               :step="1"
                               :min="1"
                               :max="4"
                               style="width:100%"></el-input-number>

            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="丙方持有份数:"
                          prop="dHoldCount"
                          class="special-input">
              <el-input-number v-model="tbConAttachedInfo.dHoldCount"
                               controls-position="right"
                               :step="1"
                               :min="1"
                               :max="4"
                               style="width:100%"></el-input-number>

            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="丁方持有份数:"
                          prop="eHoldCount"
                          class="special-input">
              <el-input-number v-model="tbConAttachedInfo.eHoldCount"
                               controls-position="right"
                               :step="1"
                               :min="1"
                               :max="4"
                               style="width:100%"></el-input-number>

            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="第三方名称:"
                          prop="cName"
                          class="special-input">
              <el-input v-model="tbConAttachedInfo.cName"
                        style="width:100%"></el-input>

            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="第三方持有份数:"
                          prop="cHoldCount"
                          class="special-input">
              <el-input v-model="tbConAttachedInfo.cHoldCount"
                        style="width:100%"></el-input>

            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="共计份数:"
                          prop="totalCount"
                          class="special-input">
              <el-input-number v-model="tbConAttachedInfo.totalCount"
                               controls-position="right"
                               :step="1"
                               :min="1"
                               :max="4"
                               style="width:100%"></el-input-number>

            </el-form-item>
          </el-col>

        </fieldset>
      </div>

    </el-form>
  </el-row>

</template>

<script>

export default {
  name: 'BizPublicXyqs',
  components: {

  },
  props: {

  },
  data() {
    return {
      // 控制页面整体是否禁用
      disBizPublicXyqs: false,

      tbConAttachedInfo: {

      },

      rules: {
        aHoldCount: [
          { required: true, message: '请输入正确的数字', trigger: 'blur' }

        ],
        bHoldCount: [
          { required: true, message: '请输入正确的数字', trigger: 'blur' }

        ],
        totalCount: [
          { required: true, message: '请输入正确的数字', trigger: 'blur' }

        ]

      }

    }
  },
  methods: {

  }
}
</script>
<style scoped>
</style>

