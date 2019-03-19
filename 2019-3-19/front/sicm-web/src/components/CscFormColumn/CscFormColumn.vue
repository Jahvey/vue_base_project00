<template>
  <el-col v-if="col.inputType==='textarea'" :span="24" :key="idx">
    <el-form-item :label="col.label" :prop="col.modelName">
      <el-input type="textarea" v-model="form[col.modelName]" :value="col.value" :disabled="disabled || col.disabled" @blur="change"></el-input>
    </el-form-item>
  </el-col>
  <el-col v-else :span="span" :key="idx">
    <template v-if="col.inputType==='select'">
      <el-form-item :label="col.label" :prop="col.modelName">
        <el-select clearable v-model="form[col.modelName]" :disabled="disabled || col.disabled" @change="change">
          <el-option v-for="(value,key) in getEnums(col)" :key="key" :label="value" :value="key">
          </el-option>
        </el-select>
      </el-form-item>
    </template>
    <template v-else-if="col.inputType==='date'">
      <el-form-item :label="col.label" :prop="col.modelName">
        <el-date-picker v-model="form[col.modelName]" value-format="yyyyMMddhhmmss" type="date" placeholder="选择日期" :disabled="disabled || col.disabled" @change="change">
        </el-date-picker>
      </el-form-item>
    </template>
    <template v-else-if="col.inputType==='datetime'">
      <el-form-item :label="col.label" :prop="col.modelName">
        <el-date-picker v-model="form[col.modelName]" type="datetime" value-format="yyyyMMddhhmmss" placeholder="选择日期时间" :disabled="disabled || col.disabled" @change="change">
        </el-date-picker>
      </el-form-item>
    </template>
    <template v-else-if="col.inputType==='refType'">
      <!--<el-form-item :label="col.label" :prop="col.modelName"> -->
      <slot :name="col.modelName"></slot>
      <!--</el-form-item> -->
    </template>
    <template v-else-if="col.inputType==='number'">
      <el-form-item :label="col.label" :prop="col.modelName">
        <el-input v-model.number="form[col.modelName]" :disabled="disabled || col.disabled" @blur="change"></el-input>
      </el-form-item>
    </template>
    <template v-else-if="col.inputType === 'checkbox'">
      <el-form-item :label="col.label" :prop="col.modelName">
        <el-checkbox-group v-model="checkBoxData.checkBoxes[col.modelName]" :disabled="disabled || col.disabled" @change="change">
          <template v-for="item in checkBoxData.checkBoxes[col.checkBoxArrayName]">
            <el-col :span="8">
              <el-checkbox :key="item.serviceTypeId" :label="item.typeName" :name="item.serviceTypeId" :value="item.checked">
              </el-checkbox>
            </el-col>
          </template>
        </el-checkbox-group>
      </el-form-item>
    </template>
    <template v-else-if="col.inputType === 'cascade'">
      <el-form-item :label="col.label" :prop="col.modelName">
        <el-cascader clearable :options="col.options" v-model="form[col.modelName]" :props="{value:'v', label:'n', children:'c'}" :disabled="disabled || col.disabled" @change="change"></el-cascader>
      </el-form-item>
    </template>
    <template v-else>
      <el-form-item :label="col.label" :prop="col.modelName">
        <el-input v-model="form[col.modelName]" :value="col.value" :disabled="disabled || col.disabled" @blur="change"></el-input>
      </el-form-item>
    </template>
  </el-col>
</template>
<script>
import { getEnumObj } from "@/utils/formatter"
export default {
  name: "CscFormColumn",
  props: {
    col: {
      type: Object,
      required: true
    },
    form: {
      type: Object
    },
    disabled:Boolean,
    span:Number,
    idx:Number
  },

  mounted() {
    if (this.col.inputType === "select") {
      this.col.options = this.getEnums(this.col)
    }
  },

  methods: {
    getEnums(col) {
      if (col && col.enumType) {
        return getEnumObj(col.enumType)
      }
      return getEnumObj(col.modelName)
    },
    change($event) {
      console.log("CscFormColunmn:"+this.col.modelName+"--"+JSON.stringify($event.currentTarget)+"--"+this.form[this.col.modelName]);
      this.$emit('change', this.col.modelName, this.form[this.col.modelName])
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss" scoped>

.el-input {
  width: 80%;
}

.el-select {
  width: 80%;
}

.el-cascader {
  width: 80%;
}

</style>
