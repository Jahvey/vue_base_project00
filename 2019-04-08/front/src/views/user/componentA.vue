<template>
  <div>
    <el-input @change="incrementCon"></el-input>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        counter: 0
      }
    },
    methods: {
      incrementCon(value){
        this.$emit('zhou',value)
      }
    }
  }
</script>
