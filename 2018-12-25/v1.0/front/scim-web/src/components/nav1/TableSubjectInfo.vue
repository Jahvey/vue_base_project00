<template>
    <div>
      <component-a @zhou="incrementCon"/>
    </div>
</template>
<script>
  import componentA from './componentA.vue'

    export default {
      components: {
        'component-a': componentA
      },
      data() {
        return {
          counter: 0
        }
      },
      methods: {
        incrementCon(value){
          this.$emit('increment',value)
        }
      }
    }
</script>
