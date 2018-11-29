<template>
  <el-dialog :title="pageDef.title" :visible="pageDef.dialogFormVisible">
    <el-form :ref="pageDef.name" :rules="pageDef.formRules" :model="form" label-width="120px" label-position="right">
      <template v-for="(col,idx) in pageDef.pageCols">
        <template v-if="col.inputType==='refType'">
          <el-col :span="24/pageDef.columnNum" :key="idx">
            <slot :name="col.modelName"></slot>
          </el-col>
        </template>
        <template v-else>
          <csc-form-column :col="col" :form="form" :span="24/pageDef.columnNum" @change="fieldChange" :idx="idx" :checkBoxes="checkBoxes" :checkBoxData="checkBoxData"></csc-form-column>
        </template>
      </template>
    </el-form>
    <div slot="footer" class="dialog-footer" align="center">
      <el-button type="primary" @click="doSave">保 存</el-button>
      <el-button @click="doCancel">取 消</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { getEnumObj } from "@/utils/formatter"
import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"
export default {
  name: "CscFormDialog",
  props: {
    pageDef: {
      type: Object,
      required: true
    },
    form: {
      type: Object
    },
    checkBoxes: {
      type: Object
    },
    checkBoxData: {
      type: Object
    },
    index:{
      type: Number
    }
  },

  components:{CscFormColumn},

  methods: {
    getEnums(enumType) {
      return getEnumObj(enumType)     //格式化
    },

    getCasOptions(colName) {
      return null//cascade(colName)
    },


    doSave() {
      if (this.pageDef.formRules !== undefined) {
        this.$refs[this.pageDef.name].validate((valid) => {     //父组件调用当前页面的页面定义名字属性进行验证
          if (valid) {
            this.$set(this.pageDef, 'dialogFormVisible', false)
            this.$emit("doSave", this.index, this.form);      //触发自定义函数，后面2个是参数，这参数什么效果？
          } else {
            return false;
          }
        });
      } else {
        this.$set(this.pageDef, 'dialogFormVisible', false)
        this.$emit("doSave", this.index, this.form);
      }
    },

    created() {
      console.log(this.pageDef)
    },

    doCancel() {
      this.$set(this.pageDef, 'dialogFormVisible', false)
      this.$emit("doCancel")
    },
    
    fieldChange(modelName, val){
      this.$emit('childFieldChange', modelName, val, this.pageDef.name, this.form)
    }

  }
}
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
.formPage {
  margin-top: 20px;
  margin-right: 20px
}

.el-input {
  width: 80%;
}

.el-select {
  width: 80%;
}

.el-cascader {
  width: 80%;
}

.bottomBtn {
  margin-top: 10px;
}

</style>
