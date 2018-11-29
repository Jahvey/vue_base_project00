<template>
  <div class="app-main">


    <transition name="fade" mode="out-in"><!--注释掉mode="out-in"也没用，还是报错-->
      <!-- <router-view :key="key"></router-view> -->
      <slot /><!--内容分发的插槽，把父组件的内容和子组件的模板混合起来用-->
      <router-view></router-view>
     </transition>
  </div>
</template>

<script>
export default {
  name: 'AppMain',
  computed: {
    // key() {
    //   return this.$route.name !== undefined ? this.$route.name + +new Date() : this.$route + +new Date()
    // }
  }
}
</script>
