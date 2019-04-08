<template>
  <el-row :gutter="20"
          class="form">
    <el-form label-width="200px"
             size="medium"
             :rules="rules"
             :model="conInfoForm"
             ref="conInfoForm"
             label-position="right"
             :disabled=isconInfoForm>

      <div>
        <el-col :span="12">
          <el-form-item label="客户名称:"
                        prop="partyName"
                        class="special-input">
            <el-input v-model="conInfoForm.partyName"
                      style="width:100%"
                      :disabled=true></el-input>
            <!--style="width:150px"-->
          </el-form-item>
        </el-col>

      </div>

      <conDkllRate :conDetailHtData="conDetailHtData"
                   v-show="conDetailHtData.visiable">
      </conDkllRate>

    </el-form>

    <el-row align="middle"
            class="bottomBtn">
      <el-col align="center"
              v-show="showDisabled">
        <el-button size="medium"
                   type="primary"
                   @click="onSubmit">保存</el-button>

      </el-col>

    </el-row>

  </el-row>
</template>

<script>


import { } from '@/api/csm'
export default {
  data() {
    return {
      showDisabled: true
    }
  }
}
</script>

