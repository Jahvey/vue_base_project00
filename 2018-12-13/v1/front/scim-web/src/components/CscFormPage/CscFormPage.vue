<template>
  <section>
    <el-row :gutter="20" class="formPage">
      <el-form :ref="pageDef.name" :model="formData" :rules="pageDef.formRules" label-width="120px" label-position="right">
        <template v-for="(col,idx) in pageDef.pageCols">
          <template v-if="col.inputType==='refType'">
            <el-col :span="24/pageDef.columnNum" :key="idx">
              <slot :name="col.modelName"></slot>
            </el-col>
          </template>
          <template v-else>
            <csc-form-column :col="col" :form="formData" :disabled="disabled" :span="24/pageDef.columnNum" @change="fieldChange" :idx="idx"></csc-form-column>
          </template>
        </template>
        <!--end cols-->
      </el-form>
    </el-row>
    <el-row>
      <slot name="selfDefine"></slot>
    </el-row>
    <el-row align="middle" class="bottomBtn">
      <el-col align="center" v-if="!disabled">
        <el-button size="medium" type="primary" @click="doSave">保存</el-button>
        <!--<el-button size="medium" type="primary" @click="doReset">重置</el-button>-->
        <el-button size="medium" type="primary" @click="doCancel">取消</el-button>
      </el-col>
      <el-col align="center" v-else>
        <el-button size="medium" type="primary" @click="doCancel">返回</el-button>
      </el-col>
    </el-row>
  </section>
</template>
<script>
import { getEnumObj } from "@/utils/formatter"
// import cascade from "@/utils/cascade"
import { extend } from "@/utils/validate"
import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"

export default {
  name: "CscFormPage",
  props: {
    pageDef: {
      type: Object,
      required: true
    },
    formData: {
      type: Object,
      required: true
    },
    formRules: {
      type: Object
    },
    checkBoxes: {
      type: Object
    },
    checkBoxData: {
      type: Object
    }
  },

  data() {
    return {
      form: {

      }
    }
  },

  mounted() {
    this.pageDef.pageCols.forEach((item, idx) => {
      if (item.inputType === "select") {
        this.formData[item.options] = this.getEnums(item.enumType)
      }
    });
  },
  
  computed:{
    disabled() {
      return this.pageDef.disabled
    }
  },

  components:{CscFormColumn},

  watch: {
  },

  methods: {
    getEnums(enumType) {
      return getEnumObj(enumType)
    },

    getCasOptions(colName) {
      return null//cascade(colName)
    },

    doReset() {
      this.form = {}
    },

    doSave() {
      // extend(this.form, this.formData)
      if (this.pageDef.formRules !== undefined) {
        this.$refs[this.pageDef.name].validate((valid) => {
          if (valid) {
            this.$emit("doSave", this.formData);
          } else {
            return false;
          }
        });
      } else {
        this.$emit("doSave", this.formData);
      }


    },

    doCancel() {
      this.$emit("doCancel")
    },

    checkNumber(rule, value, callback) {
      //          alert(1)
      if (value) {
        return callback(new Error('年龄不能为空'));
      }

      callback();
    },

    fieldChange(modelName, val){
      this.$emit('fieldChange', modelName, val)
    }


  }
}

</script>
<style rel="stylesheet/scss" lang="scss" scoped>
.formPage {
  margin-top: 20px;
  margin-right: 20px
}

.bottomBtn {
  margin-top: 10px;
}

</style>
