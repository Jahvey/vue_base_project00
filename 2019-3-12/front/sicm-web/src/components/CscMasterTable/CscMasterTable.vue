<template>
  <div class="app-container">
    <!--工具条-->
    <el-row :gutter="20" class="queryForm" v-if="!disableQueryForm">
      <el-form ref="form" :model="form" :rules="pageDef.queryRules" label-width="120px" label-position="right">
        <template v-for="(queryCol,idx) in pageDef.queryDef.queryCols">
          <el-col :span="24/pageDef.queryDef.columnNum">
            <template v-if="queryCol.inputType==='select'">
              <el-form-item :label="queryCol.label">
                <el-select clearable v-model="form[queryCol.modelName]" @clear="clearSelect(queryCol.modelName)">
                  <el-option v-for="(value,key) in getEnums(queryCol.enumType)" :key="key" :label="value" :value="key">
                  </el-option>
                </el-select>
              </el-form-item>
            </template>
            <template v-else-if="queryCol.inputType==='date'">
              <el-form-item :label="queryCol.label">
                <!-- <el-date-picker v-model="form[queryCol.modelName]" value-format="yyyyMMdd" type="date"
                                placeholder="选择日期">
                </el-date-picker> -->
                <csc-date :value.sync="form[queryCol.modelName]" type="date"></csc-date>
              </el-form-item>
            </template>
            <template v-else-if="queryCol.inputType==='datetime'">
              <el-form-item :label="queryCol.label">
                <!-- <el-date-picker v-model="form[queryCol.modelName]" type="datetime" placeholder="选择日期时间">
                </el-date-picker> -->
                <csc-date :value.sync="form[queryCol.modelName]" type="datetime"></csc-date>
              </el-form-item>
            </template>
            <template v-else-if="queryCol.inputType==='number'">
              <el-form-item :label="queryCol.label" :prop="queryCol.modelName">
                <el-input v-model.number="form[queryCol.modelName]"></el-input>
              </el-form-item>
            </template>
            <template v-else-if="queryCol.inputType==='slot'" >
              <slot :name="queryCol.modelName" ></slot>
            </template>
            <template v-else>
              <el-form-item :label="queryCol.label" :prop="queryCol.modelName">
                <el-input v-model="form[queryCol.modelName]"></el-input>
              </el-form-item>
            </template>
          </el-col>
          <!-- </template> -->
        </template>
        <!--end queryCols-->
      </el-form>
    </el-row>
    <!-- 查询 -->
    <el-row align="middle">
      <el-col :span="6" :offset="10">
        <el-button size="medium" type="primary" @click="doQuery">查询</el-button>
        <el-button size="medium" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>

    <!-- 列表按钮 -->
    <el-row class="toolBar">
      <el-button v-for="button,index in pageDef.buttons" @click="doClick(button.funcName)" 
      type="primary" size="mini" :disabled="buttonStates[index]">
        {{button.label}}
      </el-button>
      <!-- <el-button size="mini" class="filter-item" style="margin-left: 10px;" @click="doClick" type="primary" icon="el-icon-edit">新增</el-button> -->
    </el-row>
    <!--列表-->
    <el-row class="singleTable">
      <el-table :data="entity.data" highlight-current-row v-loading="listLoading" @selection-change="selectionChange"
                @row-click="rowChange" @select="rowChange" @row-dblclick="rowDbclick">
        <el-table-column v-if="pageDef.tabDef.isSelect" type="selection" width="55" header-align="center" align="center">
        </el-table-column>
        <el-table-column v-if="pageDef.tabDef.isIndex" label="序号" type="index" width="60" header-align="center"
                         align="center">
          <template slot-scope="scope">
            {{(listQuery.pageJump-1)*listQuery.recInPage+scope.$index+1}}
          </template>
        </el-table-column>
        <template v-for="tabCol in pageDef.tabDef.tabCols">
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
          <template v-else-if="tabCol.isCustom">
            <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="customFormat"
                             :width="tabCol.width" header-align="center" align="center">
                             <template slot-scope="scope">
                               <span v-html="customFormat(scope.row,scope.column,scope.row[tabCol.prop])">
                               {{customFormat(scope.row,scope.column,scope.row[tabCol.prop])}}
                               </span>
                             </template>
            </el-table-column>
          </template>
          <template v-else>
            <el-table-column :label="tabCol.label"  :prop="tabCol.prop" :sortable="tabCol.isSort" header-align="center"
                             align="center" :width="tabCol.width" :show-overflow-tooltip="tabCol.isOverflow">
            </el-table-column>
          </template>
        </template>
        <el-table-column label="操作" width="180" header-align="center" align="center" fixed="right"
          v-if="(pageDef.rowButtons == undefined || pageDef.rowButtons.length > 0) && !disableRowButtons">
          <template scope="scope">
            <template v-if="pageDef.rowButtons == undefined">
            <el-button type="primary" size="mini" @click="doEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button type="danger" size="mini" @click="doDelete(scope.$index, scope.row)">删除</el-button>
            </template>
            <template v-else>
              <el-button v-for="rowButton in pageDef.rowButtons" @click="doRowClick(rowButton.funcName, scope.$index, scope.row)" 
              :type="rowButton.type" size="mini" :disabled="evalRegulation(rowButton.regulation, scope.row)" 
              v-if="evalVisible(rowButton.visible, scope.row)">
                {{rowButton.label}}
              </el-button>
            </template>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
    <div v-show="!listLoading" class="pagination-container">
      <el-pagination background @size-change="doSizeChange" @current-change="doCurrentChange"
                     :current-page.sync="listQuery.pageJump" :page-sizes="[20,30,40,50]" :page-size="listQuery.recInPage"
                     layout="total, sizes, prev, pager, next, jumper" :total="totalRec">
      </el-pagination>
    </div>
    <br/>
    <br/>
    <!-- tabs标签 -->
    <template v-if="pageDef.childTabDefs && pageDef.childTabDefs.length > 0">
      <el-tabs v-model="activeName" type="border-card" @tab-click="tabHandleClick">
        <template v-for="childTabDef,index in pageDef.childTabDefs">
          <el-tab-pane :label="childTabDef.title" :name="childTabDef.childFieldName">

            <!--子表列表-->
            <el-table :data="childData" v-loading="childLoading" highlight-current-row>
              <el-table-column label="编号" type="index" width="60" header-align="center" align="center">
                <template slot-scope="scope">
                  {{scope.$index+1}}
                </template>
              </el-table-column>
              <template v-for="tabCol in childTabDef.tabCols">
                <template v-if="tabCol.isFormat">
                  <csc-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="formatVal" :enumType="tabCol.enumType" header-align="center" align="center" :fit="tabCol.isFit">
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
                <template v-else-if="tabCol.isCustom">
                  <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="childCustomFormat"
                                   :width="tabCol.width" header-align="center" align="center">
                                   <template slot-scope="scope">
                                     <span v-html="childCustomFormat(scope.row,scope.column,scope.row[tabCol.prop])">
                                     {{childCustomFormat(scope.row,scope.column,scope.row[tabCol.prop])}}
                                     </span>
                                   </template>
                  </el-table-column>
                </template>
                <template v-else>
                  <el-table-column :label="tabCol.label"  :prop="tabCol.prop" :sortable="tabCol.isSort" header-align="center"
                                   align="center" :width="tabCol.width" :show-overflow-tooltip="tabCol.isOverflow">
                  </el-table-column>
                </template>
              </template>
            </el-table>
          </el-tab-pane>
        </template>
      </el-tabs>
    </template>
  </div>
</template>
<script>
  import {formatter, getEnumObj} from "@/utils/formatter"
  import {isEmpty, extend} from "@/utils/validate"
  import commonUtil from "@/utils/commonUtil"
  import CscTableColumn from "@/components/CscTableColumn/CscTableColumn"

  export default {
    name: 'CscMasterTable',
    props: {
      pageDef: {
        type: Object,
        required: true
      },
      dataList: Array,
      entity: Object,
      disableQueryForm:{default:false},
      disableRowButtons:{default:false},
      autoQuery:{default:true}
    },
    data() {
      return {
        activeName:'',
        selection:[],
        currentRow: undefined, //当前行
        //分页查询参数
        form: {},
        listQuery: {
          pageJump: 1, //多页查询跳转页码
          recInPage: 20 //多页查询每页笔数
        }
      }
    },
    created() {
      // 存在子表，默认第一个tab页
      if (this.pageDef.childTabDefs && this.pageDef.childTabDefs.length > 0) {
        this.activeName = this.pageDef.childTabDefs[0]['childFieldName']
      }
      if (this.pageDef.defaultConditions) {
        Object.assign(this.listQuery, this.pageDef.defaultConditions)
      }
      if(this.autoQuery)this.doPageQuery()
    },
    components:{CscTableColumn},
    computed: {
      //分页查询总笔数
      totalRec: function () {
        return this.entity.totalRec
      },
      buttonStates() {
        let disableds = []
        for (var idx in this.pageDef.buttons) {
          var button = this.pageDef.buttons[idx]
          if (button.regulation) {

            let evalStr = button.regulation
            var reg = /\w+\s*\(\s*\)/g
            var result = evalStr.match(reg);
            if (result != null) {
              for (var index = 0; index < result.length; index++) {
                evalStr = evalStr.replace(result[index], 'this.pageDef.methods.' + (result[index]).replace('()', '(this.selection)'))
              }
              disableds.push(!eval(evalStr))
            } else {
              disableds.push(!eval(button.regulation))
            }
          } else {
            disableds.push(false)
          }
        }
        return disableds
      },
      childData() {
        if (this.selection && this.selection.length == 1) {
          return this.selection[0][this.activeName]
        }
        return null
      },
      listLoading(){
        return this.$store.getters.listLoading
      },
      childLoading(){
        return this.$store.getters.childLoading
      }

    },
    methods: {
      //格式化表格字段
      formatVal(row, column, cellValue, enumType) {
        if (enumType) {
          return formatter(enumType, cellValue)
        }
        return formatter(column.property, cellValue)
      },

      getEnums(enumType) {
        return getEnumObj(enumType)
      },

      //子组件按钮事件
      doClick(funcName){
        extend(this.form, this.listQuery)
        this.$emit(funcName, this.selection, this.form)
      },

      doRowClick(funcName, index, row){
        extend(this.form, this.listQuery)
        this.$emit(funcName, row, this.form)
      },
      //带查询条件的查询
      doQuery(){
        this.listQuery.pageJump = 1
        this.doPageQuery()
      },

      //重置
      doReset(){
        this.form = {}
      },

      doPageQuery() {
        this.$store.dispatch('setListLoading', true)
        this.selection = []
        extend(this.form, this.listQuery)
        this.$emit('pageQuery', this.form)
      },

      //查询每页笔数变化事件
      doSizeChange(val) {
        this.listQuery.recInPage = val
        this.doPageQuery()
      },

      //页码变化事件
      doCurrentChange(val) {
        this.listQuery.pageJump = val
        this.doPageQuery()
      },

      //编辑
      doEdit(index, row) {
        this.$emit('doEdit', row);
      },

      //删除
      doDelete(index, row) {
        this.$confirm('此操作将永久删除该单据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          this.$on('doDelete', function(row) {
            this.selection = []
          })
          this.$emit('doDelete', row, this.listQuery,index);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      //行点击和行选中事件，推荐单选使用
      rowChange(row, event, column){
        if (this.currentRow === row) {
          return
        }
        this.currentRow = row
        if (!this.pageDef.tabDef.isSelect) {
          this.selection = [row]
        }
        this.$store.dispatch('setChildLoading', true)
        this.$on("rowChange", function(row){
          this.$set(row, this.activeName, row[this.activeName])
        })
        this.$emit("rowChange", row)
      },

      tabHandleClick(tab, event) {
      },

      // 行选中事件，推荐多选使用
      selectionChange(selection) {
        this.selection = selection
        this.$emit('selectionChange', selection);
      },

      evalRegulation(regulation, row) {
        let evalStr = regulation
        if (regulation) {
          var reg = /\w+\s*(=|!)=\s*\w+/g
          var result = regulation.match(reg);
          if (result != null) {
            for (var idx in result) {
              evalStr = evalStr.replace(result[idx], 'row.' + result[idx])
            }
            return !eval(evalStr)
          } else {
            return !eval(regulation)
          }
        } else {
          return false
        }
      },

      evalVisible(visible, row) {
        let evalStr = visible
        if (visible) {
          var reg = /\w+\s*(=|!)=\s*\w+/g
          var result = visible.match(reg);
          if (result != null) {
            for (var idx in result) {
              evalStr = evalStr.replace(result[idx], 'row.' + result[idx])
            }
            return eval(evalStr)
          } else {
            return eval(visible)
          }
        } else {
          return true
        }
      },

      rowDbclick(row, event) {
        this.$emit('rowDbclick', row)
      },

      queryRef(row, column, cellValue) {
        var fval = ''
        if(cellValue !=='' && cellValue != undefined){
          this.$emit('queryRef', column.property, cellValue,function (val) {
            fval = val
          });
          return fval;
        }
      },

      formatDateTime(row, column, cellValue){
          return commonUtil.formatDateString(cellValue,'yyyy-MM-dd hh:mm:ss')
      },

      clearSelect(colName){
          delete this.form[colName]
      },

      formatDate(row, column, cellValue){
        return commonUtil.formatDateString(cellValue,'yyyy-MM-dd')
      },

      customFormat(row, column, cellValue) {
        if (cellValue !== "" && cellValue != undefined) {
          let fval = "";
          this.$emit("customFormat", row, column, cellValue, function(val) {
            fval = val;
          });
          return fval;
        } else {
          return cellValue;
        }
      },

      childCustomFormat(row, column, cellValue) {
        if (cellValue !== "" && cellValue != undefined) {
          let fval = "";
          this.$emit("childCustomFormat", this.activeName, row, column, cellValue, function(val) {
            fval = val;
          });
          return fval;
        } else {
          return cellValue;
        }
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

  .toolBar {
    margin-left: 10px
  }

  .singleTable{
    height: 50%;
  }

  .el-input {
    width: 100%;
  }

  .el-select {
    width: 100%;
  }

  .el-cascader {
    width: 100%;
  }

</style>
