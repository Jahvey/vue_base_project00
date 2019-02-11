<template>
  <div>
    <el-dialog :visible.sync="dialogVisibles" class="theme1" @close="$emit('update:show', false)">
      <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
        <el-tab-pane :label="item.label" :name="'first'+index" v-for="(item,index) in panes" :key="index">

          <div class="el-tab-pane-box" :style="'height:'+height+'px;'">
            <slot name="pane" :data="index+1">{{item.label}}</slot>
          </div>

        </el-tab-pane>
      </el-tabs>
    </el-dialog>
  </div>
</template>

<script>

  export default {
    name: 'dialogTheme',
    components: {

    },

    props: {
      panes: {
        type: Array,
        default: () => ([])
      },
      height: {
        type: Number,
        default: 300
      },
      show: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        activeName: 'first0',
        dialogVisibles: this.show
      }
    },

    created() {

    },

    mounted() {

    },

    methods: {
      handleClick(item) {
        this.$emit('tab-click', item)
      }
    },
    watch: {
      show() {
        this.dialogVisibles = this.show
      }
    }

  }
</script>

<style lang="scss" scoped>
  // 组件样式调整
  .theme1{
    .el-dialog {
      background-color: rgba(0, 0, 0, 0);
      box-shadow: 1px 1px 3px rgba(0, 0, 0, 0);
    }
    .el-dialog__header {
      padding: 0;
    }
    .el-dialog__headerbtn {
      top: 64px;
      z-index: 9999;
      .el-dialog__close {
        color: #000;
      }
    }
    .el-dialog__body {
      padding: 0;
    }
    .el-tabs--card>.el-tabs__header .el-tabs__nav {
      border: none;
    }
    .el-tabs__header {
      margin: 0;
    }
    .el-tabs__content {
      background-color: #fff;
      padding: 20px;
    }
    .el-tabs--card>.el-tabs__header .el-tabs__item.is-active {
      border-bottom: 1px solid transparent;
      background: #fff;
    }
    .el-tabs--card>.el-tabs__header .el-tabs__item {
      border-bottom: 1px solid #a3a7af;
      border-left: 1px solid #a3a7af;
      background: #ddd;
      border-top-left-radius: 20px;
      border-top-right-radius: 20px;
      &:first-child {
        border-left: 1px solid transparent;
      }
    }
    .el-tabs__item:focus.is-active.is-focus:not(:active) {
      box-shadow: none;
      border-top-left-radius: 20px;
      border-top-right-radius: 20px;
    }
  }
</style>

