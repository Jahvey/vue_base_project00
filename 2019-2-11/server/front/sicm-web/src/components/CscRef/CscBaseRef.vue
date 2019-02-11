<template>
  <div>
    <el-input :value="formData[modelName] ? formData[modelName][displayFiledName] : null" class="input-with-select"
      :readonly="true" @focus="showDialog" :disabled="disabled">
      <el-button slot="append" icon="el-icon-search" @click="showDialog" :disabled="disabled"></el-button>
    </el-input>
    <div v-if="isVisible">
      <el-dialog :title="title" :visible.sync="isVisible" width="80%">
        <csc-single-table :pageDef="pageDef" :entity="entity" @pageQuery="doPageQuery" @rowChange="rowChange" @rowDbclick="rowDbclick" style="margin-top:-10vh">
        </csc-single-table>
        <el-row>
          <el-col align="center">
            <el-button type="primary" :disabled="!canSave" @click="onSave">确定</el-button>
            <el-button @click="doCancel">取消</el-button>
          </el-col>
        </el-row>
      </el-dialog>
    </div>
  </div>
</template>
<script>

  import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'
  export default {
    name: 'CscBaseRef',
    props: {
      pageDef: {
        type: Object,
        required: true
      },
      modelName:{
        required : true
      },
      formData:Object,
      entity:Object,
      displayFiledName:{
        default:'name'
      },
      title:String,
      condition:Object,
      disabled:{
        default:false
      }
    },

    data(){
      return {
        isVisible:false,
        selectedRow:undefined
      }
    },
    computed:{
      canSave() {
        if (this.selectedRow) {
          return true
        }
        return false
      }
    },

    created() {
      if (this.pageDef && this.pageDef.tabDef) {
        this.pageDef.tabDef.isSelect = false
        this.pageDef.tabDef.isIndex = true
      }
    },

    updated(){
      $("div.el-dialog :input.el-input__inner").attr("style", "border-color:rgb(216, 220, 229)")
    },

    methods: {
      rowChange(row) {
        this.selectedRow = row
      },
      rowDbclick(row) {
        this.isVisible = false
        this.$set(this.formData, this.modelName, this.selectedRow)
        this.$emit('getRefValue', row, this.modelName)
      },
      doPageQuery(listQuery){
        this.selectedRow = undefined
        let params = {}
        Object.assign(params, listQuery)
        if (this.condition) {
          Object.assign(params, this.condition)
        }
        this.$emit('doPageQuery', params)
      },
      onSave() {
        this.isVisible = false
        this.$set(this.formData, this.modelName, this.selectedRow)
        this.$emit('getRefValue', this.selectedRow, this.modelName)
      },
      doCancel() {
        this.isVisible = false
        this.$emit('getRefValue', null, this.modelName)
      },
      showDialog() {
        this.isVisible = true
      }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss" scoped>

.el-input {
  width: 80%;
}

</style>