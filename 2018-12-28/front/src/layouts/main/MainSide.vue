<template>
  <div class="page-main">
    <slot />
  </div>
</template>

<script>
  export default {
  }
</script>

<style lang="less" scoped>
  .page-main{
    overflow: auto;
    height: 100%;
    padding-top: 0.1px;
    }
</style>
