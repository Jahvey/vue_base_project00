<template>
  <div>
    <!--可以对el-dialog 设置样式 width 等  class-->
    <el-dialog :title="pageDef.title" :visible.sync="pageDef.dialogFormVisible" :before-close="handleClose" :fullscreen="true">

      <el-tabs v-model="activeName2" type="card" @tab-click="handleClick">
        <el-tab-pane label="用户管理" name="first">
          用户管理
          <component :is="first"></component>

        </el-tab-pane>
        <el-tab-pane label="配置管理" name="second">
          <component :is="second"></component>
          配置管理
        </el-tab-pane>
        <el-tab-pane label="角色管理" name="third">

          角色管理
          <component :is="third"></component>
        </el-tab-pane>
        <el-tab-pane label="定时任务补偿" name="fourth">
          定时任务补偿
          <component :is="first"></component>
        </el-tab-pane>
      </el-tabs>

      <!---vue内置组件  tab切换的时候缓存-->
      <keep-alive>
        <router-view></router-view>
      </keep-alive>

      <el-form :ref="pageDef.name" :rules="pageDef.formRules" :model="form" label-width="120px" label-position="right">
        <template v-for="(pageCol,idx) in pageDef.tabDef.pageCols">
          <template v-if="pageCol.inputType==='refType'">
            <el-col :span="24/pageDef.columnNum" :key="idx">
              <slot :name="pageCol.modelName"></slot>
            </el-col>
          </template>
          <template v-else>
            <csc-form-column :col="pageCol" :form="form" :span="24/pageDef.columnNum" @change="fieldChange" :idx="idx" :checkBoxes="checkBoxes" :checkBoxData="checkBoxData"></csc-form-column>
          </template>
        </template>
      </el-form>
      <div slot="footer" class="dialog-footer" align="center">
        <el-button type="primary" @click="doSave">保 存</el-button>
        <el-button @click="doCancel">取 消</el-button>
      </div>


    </el-dialog>
  </div>

</template>

<script>
import { getEnumObj } from "@/utils/formatter"
import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"
export default {
  data() {
    return{
      activeName2: 'first'
    };
  },
  name: "CscFormDialog1",
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
    },


    width: {
      type: String,
      default: "35%"
    },
    height: {
      type: String,
      default: "1000px"
    }


  },

  components:{CscFormColumn},
  // components: {
  //   'basic-info': TableBasicInfo,
  //   'subject-info': TableSubjectInfo
  // },
  methods: {
    getEnums(enumType) {
      return getEnumObj(enumType)
    },

    getCasOptions(colName) {
      return null//cascade(colName)
    },


    doSave() {
      if (this.pageDef.formRules !== undefined) {
        this.$refs[this.pageDef.name].validate((valid) => {
          if (valid) {
            this.$set(this.pageDef, 'dialogFormVisible', false)
            this.$emit("doSave", this.index, this.form);
          } else {
            return false;
          }
        });
      } else {
        this.$set(this.pageDef, 'dialogFormVisible', false)
        this.$emit("doSave", this.index, this.form);
      }
    },

    beforeCreated() {
      // console.log("beforeCreated进来cscformdialog:"+this.pageDef)
    },

    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },

    created() {
      console.log("created进来cscformdialog:"+this.pageDef)
    },

    doCancel() {
      this.$set(this.pageDef, 'dialogFormVisible', false)
      this.$emit("doCancel")
    },

    fieldChange(modelName, val){
      this.$emit('childFieldChange', modelName, val, this.pageDef.name, this.form)
    },

    handleClick(tab, event) {//tab选项卡切换
      console.log(tab, event);
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
