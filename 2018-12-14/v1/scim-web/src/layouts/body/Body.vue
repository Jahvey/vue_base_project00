<template>
  <div class="page-body">
    <slot />
  </div>
</template>

<style lang="less" scoped>
  .page-body{
    width: 100%;
    height: calc(~'100vh - 60px');
  }
</style>
