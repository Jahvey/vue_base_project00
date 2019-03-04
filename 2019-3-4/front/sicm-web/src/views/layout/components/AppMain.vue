<template>
  <div class="app-main">

    <transition name="fade" mode="out-in">
      <!-- <router-view :key="key"></router-view> -->
      <slot />
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
