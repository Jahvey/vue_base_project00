<template>
  <div class="app-container">
    <!-- 列表按钮 -->
    <el-row class="toolBar" v-if="pageDef.buttonVisible">
      <el-button @click="doAdd" type="primary" size="mini">新增</el-button>
      <!-- <el-button size="mini" class="filter-item" style="margin-left: 10px;" @click="doClick" type="primary" icon="el-icon-edit">新增</el-button> -->
    </el-row>
    <!--列表-->
    <el-table :data="entity[pageDef.childFieldName]" highlight-current-row>
      <el-table-column label="编号" type="index" width="60" header-align="center"
                       align="center">
        <template slot-scope="scope">
          {{scope.$index+1}}
        </template>
      </el-table-column>
      <template v-for="tabCol in pageDef.tabCols">
        <!-- 是否排序 -->
        <!--<template v-if="tabCol.isSort">-->
        <!-- 枚举类是否需要格式化 -->
        <template v-if="tabCol.isFormat">
          <csc-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="formatVal"
            :enumType="tabCol.enumType" header-align="center" align="center" :fit="tabCol.isFit">
          </csc-table-column>
        </template>
        <!--是否是参照-->
        <template v-else-if="tabCol.isRef">
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="queryRef"
                            header-align="center" align="center" :width="tabCol.width">
          </el-table-column>
        </template>
        <template v-else-if="tabCol.isDateTime">
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="formatDateTime"
                           :width="135" header-align="center" align="center">
          </el-table-column>
        </template>
        <template v-else-if="tabCol.isDate">
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="formatDate"
                           :width="135" header-align="center" align="center">
          </el-table-column>
        </template>
        <template v-else>
          <el-table-column :label="tabCol.label"  :prop="tabCol.prop" :sortable="tabCol.isSort" header-align="center"
                           align="center" :width="tabCol.width" :show-overflow-tooltip="tabCol.isOverflow">
          </el-table-column>
        </template>
      </template>
      <el-table-column label="操作" width="180" header-align="center" align="center" v-if="pageDef.buttonVisible">
        <template scope="scope">
          <template>
            <el-button type="primary" size="mini" @click="doEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button type="danger" size="mini" @click="doDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </template>
      </el-table-column>
    </el-table>
    <csc-form-dialog :pageDef="pageDef" :form="form" @doSave="doSave" :index="index" @childFieldChange="childFieldChange"></csc-form-dialog>
  </div>
</template>
<script>
  import {formatter, getEnumObj} from "@/utils/formatter"
  import {isEmpty, extend} from "@/utils/validate"
  import CscTableColumn from "@/components/CscTableColumn/CscTableColumn"
  import CscFormDialog from "@/components/CscFormDialog/CscFormDialog"

  export default {
    name: 'CscChildEditTable',
    props: {
      pageDef: {
        type: Object,
        required: true
      },
      entity: Object
    },
    data() {
      return {
        form:{},
        index:-1
      }
    },
    created() {
      this.pageDef.pageCols = []
      for (var i = 0; i < this.pageDef.tabCols.length; i++) {
        var tabCol = this.pageDef.tabCols[i]
        let pageCol = {}
        Object.assign(pageCol, tabCol)
        pageCol.modelName = pageCol.prop
        if (pageCol.isFormat) {
          pageCol.inputType = "select"
        } else if (pageCol.isRef) {
          pageCol.inputType = "refType"
        } else if (pageCol.isDateTime) {
          pageCol.inputType = "datetime"
        } else if (pageCol.isDate) {
          pageCol.inputType = "date"
        }
        this.pageDef.pageCols.push(pageCol)
      }
    },

    components:{CscTableColumn, CscFormDialog},
    computed: {
    },
    methods: {
      //格式化表格字段
      formatVal(row, column, cellValue) {
        return formatter(column.property, cellValue)
      },

      getEnums(enumType) {
        return getEnumObj(enumType)
      },

      //子组件按钮事件
      doAdd(funcName){
        this.form = {}
        this.index = -1
        this.$set(this.pageDef, 'dialogFormVisible', true)
        this.$emit("doAdd")
      },

      //编辑
      doEdit(index, row) {
        this.form = {}
        Object.assign(this.form, row)
        this.index = index
        this.$set(this.pageDef, 'dialogFormVisible', true)
        this.$emit('doEdit', index, this.form);
      },

      //删除
      doDelete(index, row) {
        this.$confirm('此操作将永久删除该单据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          this.entity[this.pageDef.childFieldName].splice(index, 1);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },

      doSave(index, row) {
        if (this.entity[this.pageDef.childFieldName] && this.entity[this.pageDef.childFieldName] instanceof Array) {
          if (index >= 0) {
            this.$set(this.entity[this.pageDef.childFieldName], index, row)
          } else {
            this.entity[this.pageDef.childFieldName].push(row)
          }
        } else {
          this.$set(this.entity, this.pageDef.childFieldName, [row])
        }
      },
    
      childFieldChange(modelName, val, childName, form){
        this.$emit('childFieldChange', modelName, val, childName, form)
      }

    }
  }

</script>
<style rel="stylesheet/scss" lang="scss" scoped>
  .el-main {
    background-color: #409EFF;
    text-align: center;
  }

  .queryForm {
    margin-top: 20px;
    margin-right: 20px
  }

  .el-input {
    width: 80%;
  }

  .el-select {
    width: 80%;
  }

  .toolBar {
    margin-left: 10px
  }

</style>