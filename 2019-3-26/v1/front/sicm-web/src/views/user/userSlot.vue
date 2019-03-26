<template>
    <div>
      <slot  name=”header”>这是拥有命名的slot的默认内容</slot>

      <slot  name=”main”>这是拥有命名的slot的默认内容</slot>

      <slot  name=”footer”>这是拥有命名的slot的默认内容</slot>

      <slot  name=”other”>这是拥有命名的slot的默认内容</slot>
    </div>
</template>

<script>
    export default {
        name: "user-slot"
    }
</script>

<style scoped>

</style>
