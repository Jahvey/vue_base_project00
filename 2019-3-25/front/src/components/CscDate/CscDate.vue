<template>
  <div>
    <template v-if="type=='date'">
      <el-date-picker v-model="value1" type="date" size="mini" placeholder="选择日期">
      </el-date-picker>
    </template>

    <template v-else-if="type=='dateRange'">
      <el-date-picker
        v-model="value1"
        type="daterange"
        align="right"
        unlink-panels
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期">
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

  watch: {
    value1: function(val) {
      if (val != null && val != undefined) {
        this.$emit('update:value', val.format('yyyyMMddhhmmss'))
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
