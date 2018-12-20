<template>
  <div class="page-sidebar" :class="{ narrow: isCollapse }">
    <div class="page-siderbar-ctrl">
      <div class="icon" :class="{ narrow: isCollapse}" @click="doCollapse"></div>
    </div>

    <div class="page-sidebar-content">
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isCollapse: false
    }
  },
  methods: {
    doCollapse() {
      this.isCollapse = !this.isCollapse
      this.$root.eventHub.$emit('isCollapse', this.isCollapse)
    }
  }
}
</script>

<style lang="less" scoped>
  .page-sidebar{
    float: left;
    width: 240px;
    height: 100%;
    overflow: hidden;
    background: #f5f7fb;
    transition: width .3s ease-in-out;
    border-right: 1px solid #e6e6e6;
    &.narrow{
      width: 64px;
    }
    .page-siderbar-ctrl{
      width: 100%;
      height: 30px;
      background: #e1e3e6;
      .icon{
        width: 30px;
        height: 30px;
        margin: 0 auto;
        background: url("./sidebar-ctrl.png") no-repeat center;
        cursor: pointer;
        &.narrow{
          transform: rotate(90deg);
        }
      }
    }
    .page-sidebar-content{
      width: 260px;
      height: calc(~'100% - 30px');
      overflow: hidden;
      overflow-y: scroll;

    }
  }
  .customer-sidebar{
    &.abso{
      position: absolute;
    }
    border: 0;
    &:not(.el-menu--collapse) {
      width: 240px;
    }
  }
</style>
