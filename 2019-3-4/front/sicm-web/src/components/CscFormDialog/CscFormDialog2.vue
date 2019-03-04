<template>
  <div>
    <el-dialog :title="pageDef.title" :visible.sync="pageDef.dialogFormVisible" :before-close="handleClose" :fullscreen="true">


      <div class="top">
        <!-- 顶部布局的tab标签-->
        <csc-el-tabs :tabsDef="pageDef">

        </csc-el-tabs>
      </div>



      <!---vue内置组件  tab切换的时候缓存-->
      <keep-alive>
        <router-view></router-view>
      </keep-alive>




    </el-dialog>
  </div>

</template>

<script>
import { getEnumObj } from "@/utils/formatter"
import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"
import CscElTree from "../CscElTree/CscElTree";
import CscElTabs from "../CscElTabs/CscElTabs";
export default {
  data() {
    return{
      activeName2: 'first'
    };
  },
  name: "CscFormDialog2",
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

  components:{
    CscElTabs,
    CscElTree,
    CscFormColumn
  },

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

  .treeLeft {
    float:left;
    width:20%;
  }

  .treeRight {
    float: right;
    width: 80%;
  }
</style>
