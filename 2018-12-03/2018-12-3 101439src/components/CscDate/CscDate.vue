<template>
  <div>
    <template v-if="type=='date'">
      <el-date-picker v-model="value1" type="date" placeholder="选择日期">
      </el-date-picker>
    </template>
    <template v-else>
      <el-date-picker v-model="value1" type="datetime" placeholder="选择日期时间">
      </el-date-picker>
    </template>
  </div>
</template>
<script>
import commonUtil from "@/utils/commonUtil"
export default {
  props: {
    value: String,
    type: String
  },

  data() {
    return {
      value1: commonUtil.stringToDate(this.value)
    }
  },

  watch: {// 侦听属性：如果 `value1` 发生改变，这个函数就会运行
    value1: function(val) {
      if (val != null && val != undefined) {
        this.$emit('update:value', val.format('yyyyMMddhhmmss'))    //触发自定义函数
      } else {
        this.$emit('update:value', null)
      }

    },
    value: function(val) {
      if (val != null && val != undefined) {
        this.value1 = commonUtil.stringToDate(val)
      }else{
        this.value1=null
      }
    }

  }
}

</script>
