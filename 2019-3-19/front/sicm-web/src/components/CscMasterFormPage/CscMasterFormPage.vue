<template>
  <section>
    <el-row :gutter="20" class="formPage">
      <el-form :ref="pageDef.name" :id="pageDef.name" :model="formData" :rules="pageDef.formRules" label-width="120px" label-position="right">
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
      </el-form>
    </el-row>
    <el-row>
      <slot name="selfDefine"></slot>
    </el-row>
    <template v-if="pageDef.childTabDefs && pageDef.childTabDefs.length > 0">
      <el-row>
        <el-tabs v-model="activeName" type="border-card">
          <template v-for="childTabDef,index in pageDef.childTabDefs">
            <el-tab-pane :label="childTabDef.title" :name="childTabDef.childFieldName">
              <csc-child-edit-table :pageDef="childTabDef" :entity="formData" @childFieldChange="childFieldChange"></csc-child-edit-table>
            </el-tab-pane>
          </template>
        </el-tabs>
      </el-row>
    </template>
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
import { extend } from "@/utils/validate"
import CscChildEditTable from "@/components/CscChildEditTable/CscChildEditTable"
import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"

export default {
  name: "CscMasterFormPage",
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
      activeName:null,
      form: {

      }
    }
  },

  computed:{
    disabled() {
      return this.pageDef.disabled
    }
  },

  created() {
    this.activeName = this.pageDef.childTabDefs[0].childFieldName
    for (var i = 0; this.pageDef.childTabDefs && i < this.pageDef.childTabDefs.length; i++) {
      this.pageDef.childTabDefs[i]['buttonVisible'] = !this.pageDef.disabled
    }
  },

  components:{CscChildEditTable, CscFormColumn},

  mounted() {
    this.pageDef.pageCols.forEach((item, idx) => {
      if (item.inputType === "select") {
        // this.formData[item.options] = this.getEnums(item.enumType)
      }
    });
  },

  watch: {
    pageDef: function() {
      for (var i = 0; this.pageDef.childTabDefs && i < this.pageDef.childTabDefs.length; i++) {
        this.pageDef.childTabDefs[i]['buttonVisible'] = !this.pageDef.disabled
      }
    }
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
    },

    childFieldChange(modelName, val, childName, form) {
      this.$emit('childFieldChange', modelName, val, childName, form)
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
