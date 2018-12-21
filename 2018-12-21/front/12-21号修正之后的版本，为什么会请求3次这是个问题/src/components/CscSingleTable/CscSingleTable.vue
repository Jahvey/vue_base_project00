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
            <template v-else-if="queryCol.inputType==='select1'">
              <el-form-item :label="queryCol.label">
                <el-select clearable v-model="form[queryCol.modelName]" @clear="clearSelect(queryCol.modelName)"
                           filterable  remote :loading="loading" :placeholder="queryCol.placeholder"
                           :remote-method="queryallRef"
                           @change="matchIdChange">
                  <el-option v-for="item in matchRefList" :key="item.keyId" :label="item.keyName"
                             :value="item.keyId">
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
    <el-row align="middle" v-if="!disableQueryForm">
      <el-col align="center">
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
    <!--<el-table  :data="entity.data" highlight-current-row v-loading="listLoading" @selection-change="selectionChange"-->
              <!--@row-click="rowChange" @select="rowChange" @row-dblclick="rowDbclick">-->
      <el-table  :data="entity.data" highlight-current-row v-loading="listLoading" @selection-change="selectionChange"
      @row-click="rowChange" @select="rowChange" @row-dblclick="rowDbclick">
      <template v-if="pageDef.tabDef.isExpand">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="table-expand">
              <template v-for="expandCol in pageDef.tabDef.expandCols">
                <el-form-item>
                  <span style="color: #6495ED; font-size: 20px">{{expandCol.label}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                  <span>{{ props.row[expandCol.prop] }}</span>
                </el-form-item>
              </template>
            </el-form>
          </template>
        </el-table-column>
      </template>
      <el-table-column v-if="pageDef.tabDef.isSelect" type="selection" width="55" header-align="center" align="center">
      </el-table-column>
      <el-table-column v-if="pageDef.tabDef.isIndex" label="序号" type="index" width="60" header-align="center"
                       align="center">
        <template slot-scope="scope">
          {{(listQuery.pageNum-1)*listQuery.pageSize+scope.$index+1}}
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

        
        <template v-else-if="tabCol.isLink">
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :width="135"
                           show-overflow-tooltip header-align="center" align="center" >
            <template slot-scope="scope">
         
             <!-- 
               <router-link to="/crt/con_apply/con_apply_print">{{scope.row[tabCol.prop]}}</router-link>
              -->
               <!--
              <router-link :to="{path:'/crt/con_apply/con_apply_print',query:{queryParam:scope.row[tabCol.prop]}}">{{scope.row[tabCol.prop]}}</router-link>
                 -->
             <!--  <router-link  :to="{path:tabCol.url,query:{id:scope.row[tabCol.prop],key:requestUrlParam}}"   @click.native="getRequestUrlParams2('12345')">{{scope.row[tabCol.prop]}}</router-link> -->
            {{appendRequestUrlParam(tabCol.prop,scope.row[tabCol.prop],tabCol.url)}}

            <router-link  :to="{path:tabCol.url,query:{[tabCol.prop]:scope.row[tabCol.prop]}}">{{scope.row[tabCol.prop]}}</router-link>
            <!-- <router-link  :to="{path:tabCol.url,query:{id:scope.row[tabCol.prop],key:requestUrlParam}}"   @click.native="getRequestUrlParams2(requestUrlParam)">{{scope.row[tabCol.prop]}}</router-link> -->
            </template>
          </el-table-column>
      </template>

      <template v-else-if="tabCol.isParam">
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :width="135"
                           show-overflow-tooltip header-align="center" align="center" >
                           
            <template slot-scope="scope">
                <!-- invoke function  param  scope.row[tabCol.prop]  return val-->
              <!-- {{tabCol.prop}}-{{scope.row}} -->
              {{scope.row[tabCol.prop]}}
              {{appendRequestParam(tabCol.prop,scope.row[tabCol.prop])}}
            </template>
          </el-table-column>
      </template>


        <template v-else-if="tabCol.isCustom">
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :formatter="customFormat"
                           :width="tabCol.width" header-align="center" align="center" :show-overflow-tooltip="tabCol.isOverflow">
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
            <el-button v-for="rowButton in pageDef.rowButtons"
                       @click="doRowClick(rowButton.funcName, scope.$index, scope.row)"
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
                     :current-page.sync="listQuery.pageNum" :page-sizes="[10,20,30,40,50]" :page-size="listQuery.pageSize"
                     layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

    <!--<div v-show="!listLoading" class="pagination-container">-->
      <!--<el-pagination background @size-change="doSizeChange" @current-change="doCurrentChange"-->
                     <!--:current-page.sync="listQuery.pageNum" :page-sizes="[10,20,30,40,50]" :page-size="listQuery.pageSize"-->
                     <!--layout="total, sizes, prev, pager, next, jumper" :total="total">-->
      <!--</el-pagination>-->
    <!--</div>-->

  </div>
</template>
<script>
import { formatter, getEnumObj } from '@/utils/formatter';
import { extend } from '@/utils/validate';
import commonUtil from '@/utils/commonUtil';
import CscTableColumn from '@/components/CscTableColumn/CscTableColumn';


export default {
  name: 'CscSingleTable',
  props: {
    
    pageDef: {
      type: Object,
      required: true
    },
    dataList: Array,
    matchObj: Object,
    entity: Object,
    disableQueryForm: {
      type: Boolean,
      default: false
    },
    disableRowButtons: {
      type: Boolean,
      default: false
    },
    autoQuery: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      //全局使用处理传递多参数
      requestUrlParam: this.CommonUtils.requestUrlParam,
   
      selection: [],
      currentRow: undefined, // 当前行
      // 分页查询参数
      matchRefList: [],
      // form: {curUserNum:"200555",orgcode:"0700"},
      form: {},
      loading: false,
      listQuery: {
        // pageJump: 1, // 多页查询跳转页码
        // recInPage: 20 // 多页查询每页笔数
        curUserNum: '200555',// 2018-11-30  当前操作员号 如何动态放入
        orgcode: '0700',//2018-11-30  当前操作员所在机构  如何动态放入
        pageNum: 1, // 多页查询跳转页码
        pageSize: 20 // 多页查询每页笔数
      }
    };
  },
  beforeCreate(){
    console.log("子组件beforeCreate:"+new Date());
  },
  created() {
    //console.log("create requestUrlParam"+requestUrlParam)
    
    console.log("子组件created:"+new Date());
    // if(this.disableQueryForm)
    //   this.disableQueryForm=true;
    if (this.pageDef.defaultConditions) {
      Object.assign(this.listQuery, this.pageDef.defaultConditions);
    }
    if (this.autoQuery) this.doPageQuery();
  },

  components: { CscTableColumn },

  computed: {
    // 分页查询总笔数
    // totalRec: function() {
    //   console.log("子组件中分页查询记录数:"+new Date());
    //   return this.entity.totalRec;
    // },
    total: function() {
      console.log("子组件中分页查询记录数:"+new Date()+"-"+this.entity.total+"---"+this.entity.totalRec);
      return this.entity.total;
    },
    buttonStates() {
      console.log("子组件加载完成与否1:"+this.$store.getters.listLoading);
      const disableds = [];
      for (var idx in this.pageDef.buttons) {
        var button = this.pageDef.buttons[idx];
        if (button.regulation) {
          let evalStr = button.regulation;
          var reg = /\w+\s*\(\s*\)/g;
          var result = evalStr.match(reg);
          if (result != null) {
            for (var index = 0; index < result.length; index++) {
              evalStr = evalStr.replace(
                result[index],
                'this.pageDef.methods.' +
                  result[index].replace('()', '(this.selection)')
              );
            }
            disableds.push(!eval(evalStr));
          } else {
            disableds.push(!eval(button.regulation));
          }
        } else {
          disableds.push(false);
        }
      }
      return disableds;
    },
    listLoading() {
      console.log("子组件加载完成与否2:"+this.$store.getters.listLoading);
      return this.$store.getters.listLoading;
    }
  },
  methods: {

         appendRequestUrlParam(key, value, url) {
        // console.log("url参数:" + key + "..." + value);

        let target = "targetUrl";

        let urlData = {
          "targetUrl": url
        };
        // var str=eval('('+ '{"'+ key +'": "'+ value +'"  "," + "targetUrl:" + "'+url+'" }' +')');
        // console.log("拼接字符串:"+'('+ '{"'+ key +'": "'+ value +'"  "," + "targetUrl:" + "'+url+'" }' +')' );
        var str = eval('(' + '{"' + key + '"  : "' + value + '","' + target + '" : "' + url + '"  }' + ')');
         console.log("拼接字符串:" + '(' + '{"' + key + '"  : "' + value + '","' + target + '" : "' + url + '"  }' + ')');
        let targetUrl = this.$store.state.urlParam.targetUrl;
         console.log("打开url:" + targetUrl);
        if (!targetUrl) {
          console.log(" this.$store.commit invoke  getUrlParam.....")
          this.$store.commit("getUrlParam", str);
        }


      },

      appendRequestParam(key, value) {
        // console.log(key+"appendRequestParam"+value);
        var str1 = eval('(' + '{"' + key + '"  : "' + value + '"}' + ')');
         console.log("拼接字符串:" + '(' + '{"' + key + '"  : "' + value + '"}' + ')');
        console.log(" this.$store.commit invoke   getParam.....")
        this.$store.commit("getParam", str1);
      },


    matchIdChange(val) {},
    // 模糊查询方法
    queryallRef(val) {
        this.matchRefList = [];
    },

    // 格式化表格字段
    formatVal(row, column, cellValue, enumType) {
      if (enumType) {
        return formatter(enumType, cellValue);
      }
      return formatter(column.property, cellValue);
    },

    getEnums(enumType) {
      return getEnumObj(enumType);
    },

    // 子组件按钮事件
    doClick(funcName) {
      extend(this.form, this.listQuery);
      this.$emit(funcName, this.selection, this.form);
    },

    doRowClick(funcName, index, row) {
      extend(this.form, this.listQuery);
      this.$emit(funcName, row, this.form, index);
    },
    // 带查询条件的查询
    doQuery() {
      // this.listQuery.pageJump = 1;
      this.listQuery.pageNum = 1;
      this.doPageQuery();
    },

    // 重置
    doReset() {
      this.form = {};
      this.$emit('doReset');
    },

    doPageQuery() {
      this.$store.dispatch('setListLoading', true);//查询时增加遮罩
      extend(this.form, this.listQuery);
      this.$emit('pageQuery', this.form);
    },

    // 查询每页笔数变化事件
    doSizeChange(val) {
      // this.listQuery.recInPage = val;
      this.listQuery.pageSize = val;
      this.doPageQuery();
    },

    // 页码变化事件
    doCurrentChange(val) {
      // this.listQuery.pageJump = val;
      this.listQuery.pageNum = val;
      this.doPageQuery();
    },

    // 编辑
    doEdit(index, row) {
      this.$emit('doEdit', row);
    },

    // 删除
    doDelete(index, row) {
      this.$confirm('此操作将永久删除该单据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      })
        .then(() => {
          this.$emit('doDelete', row, this.listQuery, index);
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
    },
    // 行点击和行选中事件
    rowChange(row, event, column) {
      this.currentRow = row;
      if (!this.pageDef.tabDef.isSelect) {
        this.selection = [row];
      }
      this.$emit('rowChange', row);
    },

    selectionChange(selection) {
      this.selection = selection;
      this.$emit('selectionChange', selection);
    },

    evalRegulation(regulation, row) {
      let evalStr = regulation;
      if (regulation) {
        var reg = /\w+\s*(=|!)=\s*'*\w+'*/g;
        var result = regulation.match(reg);
        if (result != null) {
          for (var idx in result) {
            evalStr = evalStr.replace(result[idx], 'row.' + result[idx]);
          }
          return !eval(evalStr);
        } else {
          return !eval(regulation);
        }
      } else {
        return false;
      }
    },

    evalVisible(visible, row) {
      let evalStr = visible;
      if (visible) {
        var reg = /\w+\s*(=|!)=\s*'*\w+'*/g;
        var result = visible.match(reg);
        if (result != null) {
          for (var idx in result) {
            evalStr = evalStr.replace(result[idx], 'row.' + result[idx]);
          }
          return eval(evalStr);
        } else {
          return eval(visible);
        }
      } else {
        return true;
      }
    },

    rowDbclick(row, event) {
      this.$emit('rowDbclick', row);
    },

    queryRef(row, column, cellValue) {
      var fval = '';
      if (cellValue !== '' && cellValue != undefined) {
        this.$emit('queryRef', column.property, cellValue, function(val) {
          fval = val;
        });
        return fval;
      }
    },

    formatDateTime(row, column, cellValue) {
      return commonUtil.formatDateString(cellValue, 'yyyy-MM-dd hh:mm:ss');
    },

    clearSelect(colName) {
      delete this.form[colName];
    },

    formatDate(row, column, cellValue) {
      return commonUtil.formatDateString(cellValue, 'yyyy-MM-dd');
    },

    customFormat(row, column, cellValue) {
      if (cellValue !== '' && cellValue != undefined) {
        let fval = '';
        this.$emit('customFormat', row, column, cellValue, function(val) {
          fval = val;
        });
        return fval;
      } else {
        return cellValue;
      }
    }
  }
};
</script>
<style rel='stylesheet/scss' lang='scss' scoped>
.el-main {
  background-color: #409eff;
  text-align: center;
}

.queryForm {
  margin-top: 20px;
  margin-right: 20px;
}

.toolBar {
  margin-left: 10px;
}

.singleTable {
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

.table-expand {
   font-size: 10;
}
.table-expand label {
  width: 90px;
  color: red;
}
.table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 90%;
}
</style>
