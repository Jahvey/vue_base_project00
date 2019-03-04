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
    width: 100%;
    height: 100%;
    overflow: auto;
  }
</style>
