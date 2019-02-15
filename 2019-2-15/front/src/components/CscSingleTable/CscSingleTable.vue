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
                           @focus="getAllValue(queryCol.enumType)"
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

            <template v-else-if="queryCol.inputType==='dateRange'">
              <el-form-item :label="queryCol.label">
                <csc-date :value.sync="form[queryCol.modelName]" type="dateRange"></csc-date>
              </el-form-item>
            </template>

            <template v-else-if="queryCol.inputType==='dateRange2'">

              <el-form-item :label="queryCol.label">
                <el-col :span="5">
                  <csc-date :value.sync="form[queryCol.modelName]" type="date"></csc-date>
                </el-col>
                <el-col class="line" :span="2">{{queryCol.param.label}}</el-col>
                <el-col :span="5">
                  <csc-date :value.sync="form[queryCol.param.modelName]" type="date"></csc-date>
                </el-col>
              </el-form-item>
            </template>

            <template v-else-if="queryCol.inputType==='dateRange11'">
              <el-form-item :label="queryCol.label">

              <el-row>

              <el-col :span="12/pageDef.queryDef.columnNum">
              <csc-date :value.sync="form[queryCol.modelName]" type="date"></csc-date>
              </el-col>

              <el-form-item :label="queryCol.param.label">
              <el-col :span="12/pageDef.queryDef.columnNum">
              <csc-date :value.sync="form[queryCol.param.modelName]" type="date"></csc-date>
              </el-col>
              </el-form-item>

              </el-row>


              </el-form-item>
            </template>

            <template v-else-if="queryCol.inputType==='dateRange3'">


                <el-col :span="12/pageDef.queryDef.columnNum">
                  <el-form-item :label="queryCol.label">
                    <el-col>
                      <csc-date :value.sync="form[queryCol.modelName]" type="date"></csc-date>
                    </el-col>
                  </el-form-item>
                </el-col>

                <el-col  :span="12/pageDef.queryDef.columnNum">

                  <el-form-item :label="queryCol.param.label">
                  <el-col>
                  <csc-date :value.sync="form[queryCol.param.modelName]" type="date"></csc-date>
                  </el-col>
                  </el-form-item>
                </el-col>





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
    <el-row align="middle" v-if="!disableQueryForm && !disableQueryButtons  "><!--增加了一个button按钮属性-->
      <el-col align="center">
        <el-button size="medium" type="primary" @click="doQuery">查询</el-button>
        <el-button size="medium" type="primary" @click="doReset">重置</el-button>
      </el-col>
    </el-row>

    <!-- 列表按钮 -->
    <el-row class="toolBar">
      <el-button v-for="button,index in pageDef.buttons" @click="doRadioClick(button.funcName)"
                 type="primary" size="mini" :disabled="false">
        {{button.label}}
      </el-button>
      <!-- <el-button size="mini" class="filter-item" style="margin-left: 10px;" @click="doClick" type="primary" icon="el-icon-edit">新增</el-button> -->
    </el-row>
    <!--列表，使用element-ui加入动态数据   如果加入checkbox控制单选全选的话 如果点击全选或取消全选 会触发两个方法selection-change select-all -->
    <!--如果是通过勾选复选框控制结合单选全选控制的话，选择 取消选择都会触发selection-change  select  current-change  怎么实现获取选择框的值？？-->
    <el-row class="singleTable">
    <!--<el-table  :data="entity.data" highlight-current-row v-loading="listLoading" @selection-change="selectionChange"-->
              <!--@row-click="rowChange" @select="rowChange" @row-dblclick="rowDbclick">-->
    <el-table  :data="entity.data" highlight-current-row v-loading="listLoading" @selection-change="selectionChange" @cell-click=""
              @row-click="rowChange" @select="rowCheckChange" @current-change="rowCheckedChange" @select-all="selectAllChange"  @row-dblclick="rowDbclick">
        <!--设置表格是否点击扩展-->
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
        <!--设置表格是否可以全选-->
      <el-table-column v-if="pageDef.tabDef.isSelect" type="selection" width="55" header-align="center" align="center">
      </el-table-column>

      <!--设置表格是否可以单选-->
        <el-table-column v-if="pageDef.tabDef.isCheckRadio" label="选择" width="55" header-align="center" align="center">
          <template slot-scope="scope">
            <el-radio :label="scope.$index" v-model="templateRadio"
                      @change.native="getTemplateRow(scope.$index,scope.row,pageDef.tabDef.checkParam)">&nbsp</el-radio>
          </template>
        </el-table-column>

        <!--设置显示序号-->
      <el-table-column v-if="pageDef.tabDef.isIndex" label="序号" type="index" width="60" header-align="center"
                       align="center">
        <template slot-scope="scope">
          {{(listQuery.pageNum-1)*listQuery.pageSize+scope.$index+1}}
        </template>
      </el-table-column>
        <!--遍历表头 start-->
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
        <template v-else-if="tabCol.isLink" >
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :width="135"
                           show-overflow-tooltip header-align="center" align="center"  >
            <template slot-scope="scope">
             <!-- <a href="www.baidu.com"
                  >{{scope.row[tabCol.prop]}}</a>--><!--先写死，获得合同编号@click="tabCol.fn(scope.row)"-->
              <!--<router-link :to="{path:'/crt/con_info/con_info_ht_xw',query:{queryParam:scope.row[tabCol.prop]}}">{{scope.row[tabCol.prop]}}</router-link>-->
              <!--<router-link class="isLink" :to="{path:tabCol.url,query:{[tabCol.prop]:scope.row[tabCol.prop]}}"-->
                           <!--@click.native="getUrlParam(scope.row,scope.$index,tabCol.param)">-->
                <!--<u>{{scope.row[tabCol.prop]}}</u></router-link>-->
              <router-link class="isLink" :to="{path:tabCol.url,query:{}}"
                           @click.native="getUrlParam(scope.row,scope.$index,tabCol.param)">
                <u>{{scope.row[tabCol.prop]}}</u></router-link>
              <!--{{appendRequestUrlParam(tabCol.prop,scope.row[tabCol.prop],tabCol.url)}}-->
            </template>
          </el-table-column>
      </template>

        <template v-else-if="tabCol.isDialog" >
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :width="135"
                           show-overflow-tooltip header-align="center" align="center"  >
            <template scope="scope">
              <div style="color:blue;text-decoration:underline;cursor:pointer;"
                   @click="getUrlParamDialog(scope.row,scope.$index,tabCol.param)">{{scope.row[tabCol.prop]}}</div>
            </template>
          </el-table-column>
        </template>

        <template v-else-if="tabCol.isParam" >
          <el-table-column :label="tabCol.label" :prop="tabCol.prop" :sortable="tabCol.isSort" :width="135"
                           show-overflow-tooltip header-align="center" align="center"  >
            <template slot-scope="scope">
              {{scope.row[tabCol.prop]}}
              <!--{{appendRequestParam(tabCol.prop,scope.row[tabCol.prop])}}-->
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
        <template v-else-if="tabCol.isHead">
          <el-table-column :label="tabCol.label">
            <template v-for="content in tabCol.contents">
              <el-table-column :label="content.label"  :prop="content.prop" :sortable="content.isSort" header-align="center"
                               align="center" :width="content.width" :show-overflow-tooltip="content.isOverflow">
              </el-table-column>
            </template>

          </el-table-column>
        </template>
        <!--一般默认的表头样式-->
        <template v-else>
          <el-table-column :label="tabCol.label"  :prop="tabCol.prop" :sortable="tabCol.isSort" header-align="center"
                           align="center" :width="tabCol.width" :show-overflow-tooltip="tabCol.isOverflow">
          </el-table-column>
        </template>
      </template>
        <!--遍历表头 end-->
      <el-table-column label="操作" width="210" header-align="center" align="center" fixed="right"
        v-if="(pageDef.rowButtons == undefined || pageDef.rowButtons.length > 0) && !disableRowButtons">
        <template scope="scope">

          <template v-if="pageDef.rowButtons == undefined">
            <el-button type="primary" size="mini" @click="doEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button type="danger" size="mini" @click="doDelete(scope.$index, scope.row)">删除</el-button>
          </template>
          <!--操作按钮自定义-->
          <template v-else>
            <el-button v-for="rowButton in pageDef.rowButtons"
                       @click="doRowClick(rowButton.funcName, scope.$index, scope.row)"
                       :type="rowButton.type" size="mini" :disabled="evalRegulation(rowButton.regulation, scope.row)"
                       v-if="rowButton">
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
import { formatter, getEnumObj } from '@/utils/formatter'
import { extend } from '@/utils/validate'
import commonUtil from '@/utils/commonUtil'
import CscTableColumn from '@/components/CscTableColumn/CscTableColumn'

import { getEnumsValue } from '@/api/user'
import ElRow from "element-ui/packages/row/src/row";

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
    // disableRowButtons: Boolean,
    disableQueryForm: {
      type: Boolean,
      default: false
    },
    disableQueryButtons: {
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
      selection: [],//多选框的值
      templateRadio:null,//单选框的值
      templateSelection: [],//2019-1-7 当前选中行测试 选中行以后 点击按钮操作
      currentRow: undefined, // 当前行
      // 分页查询参数
      matchRefList: [],
      enumsRefList: [],//根据标准数据key值查询列表
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
    }
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
      Object.assign(this.listQuery, this.pageDef.defaultConditions)
    }
    if (this.autoQuery) this.doPageQuery()



  },

  components: {
    ElRow,
    CscTableColumn },

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
      const disableds = []
      for (var idx in this.pageDef.buttons) {
        var button = this.pageDef.buttons[idx]
        if (button.regulation) {
          let evalStr = button.regulation
          var reg = /\w+\s*\(\s*\)/g
          var result = evalStr.match(reg)
          if (result != null) {
            for (var index = 0; index < result.length; index++) {
              evalStr = evalStr.replace(
                result[index],
                'this.pageDef.methods.' +
                  result[index].replace('()', '(this.selection)')
              )
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
    listLoading() {
      console.log("子组件加载完成与否2:"+this.$store.getters.listLoading);
      return this.$store.getters.listLoading
    }
  },
  methods: {
    matchIdChange(val) {//

    },
    // 模糊查询方法
    queryallRef(val) {//类似于百度搜索引擎的模糊查询下拉列表 关联查询
      this.matchRefList = [];


      //this.enumsRefList 的值何时动态查询出来
      // this.enumsRefList=[
      //   {
      //   keyId: 1,
      //   keyName: '张三'
      // }, {
      //     keyId: 2,
      //     keyName: '李四'
      // }, {
      //     keyId: 3,
      //     keyName: '王五'
      // },{
      //     keyId: 1,
      //     keyName: '哈张'
      //   }, {
      //     keyId: 2,
      //     keyName: '小李'
      //   }, {
      //     keyId: 3,
      //     keyName: '大王'
      //   }
        // ];


        if (val != '' && val !=null) {
          console.log("queryallRef1:"+JSON.stringify(val));
          this.loading = true;
          setTimeout(() => {
            this.loading = false;
            this.matchRefList = this.enumsRefList.filter(item => {
              return item.keyName.toLowerCase()
                .indexOf(val.toLowerCase()) > -1;
            });
          }, 200);

        } else {
          this.matchRefList = [];
        }
      console.log("queryallRef2:"+JSON.stringify(this.matchRefList));
    },

    // getEnumsValue(enumType) {//2019-1-8 测试调用后台服务获取标准数据
    //   this.$emit("getEnumsValue",enumType);
    // },

    getAllValue(listQuery) {
      // console.log("getAllValue1:"+listQuery);
      let query={"dicttypeid":listQuery};
      if(this.enumsRefList && this.enumsRefList.length > 0){
        //如果已经存在 则不处理了
      }else {
        getEnumsValue(query).then(response => {
          // this.enumsRefList = response.data;//如果定义的是返回responsemsg 这里response.data  就是   方法一

          // console.log("getAllValue4:"+JSON.stringify(response));
          this.enumsRefList = response.data.map(item => { //组装，只需要keyId和keyName   方法二
            // console.log("getAllValue2:"+JSON.stringify(item));
            return {keyId: item.DICTID, keyName: item.DICTNAME};
          });
          // this.$store.dispatch('setListLoading', false);
          console.log("getAllValue3:"+JSON.stringify(this.enumsRefList));
        }).catch((error) => {
          console.log(error)
        })
      }

    },

    // 格式化表格字段
    formatVal(row, column, cellValue, enumType) {
      if (enumType) {
        return formatter(enumType, cellValue)
      }
      return formatter(column.property, cellValue)
    },

    getEnums(enumType) {
      return getEnumObj(enumType)
    },
    // 子组件按钮事件  复选框
    doClick(funcName) {
      extend(this.form, this.listQuery)
      this.$emit(funcName, this.selection, this.form)
    },

    // 子组件按钮事件 单选框 2019-1-7 子组件table上方按钮事件 类似于 查看 失效 调整等
    doRadioClick(funcName) {
      extend(this.form, this.listQuery);
      if(this.templateSelection==null){
        console.log("do ...el-radio.....")
        return false
      }
      console.log("子组件doRadioClick:"+JSON.stringify(this.templateSelection));
      this.$emit(funcName, this.templateSelection);//当前选中行
    },

    doRowClick(funcName, index, row) {
      extend(this.form, this.listQuery)
      this.$emit(funcName, row, this.form, index)
    },
    // 带查询条件的查询
    doQuery() {
      // this.listQuery.pageJump = 1;
      this.listQuery.pageNum = 1;
      this.doPageQuery()
    },

    // 重置
    doReset() {
      this.form = {}
      this.$emit('doReset')
    },

    doPageQuery() {
      this.$store.dispatch('setListLoading', true);//查询时增加遮罩
      extend(this.form, this.listQuery)
      this.$emit('pageQuery', this.form)
    },

    // 查询每页笔数变化事件
    doSizeChange(val) {
      // this.listQuery.recInPage = val;
      this.listQuery.pageSize = val;
      this.doPageQuery()
    },

    // 页码变化事件
    doCurrentChange(val) {
      // this.listQuery.pageJump = val;
      this.listQuery.pageNum = val;
      this.doPageQuery()
    },

    // 编辑
    doEdit(index, row) {
      this.$emit('doEdit', row)
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
          this.$emit('doDelete', row, this.listQuery, index)
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
    },
    // 行点击和行选中事件
    rowChange(row, event, column) {
      this.currentRow = row
      if (!this.pageDef.tabDef.isSelect) {
        this.selection = [row]
      }
      this.$emit('rowChange', row)
    },

    // 测试时 单独写手动勾选checkbox行选中事件  如何区分是选中还是取消选中
    selectAllChange(selection) {//该方法比selectionChange 后执行   select-all	当用户手动勾选全选 Checkbox 时触发的事件	selection
      console.log("selectAllChange1:"+JSON.stringify(selection));
      if (this.pageDef.tabDef.isSelect) {
        if(selection && selection.length > 0){
          this.selection=[];//切记要清空
          for(var i = 0; i< selection.length;++i){
            this.selection.push(selection[i][this.pageDef.tabDef.mutiCheckParam]);
          }
        }else{
          //取消全选时将选择的数组清空  或者以@分隔
          this.selection=[];
        }
      }
      console.log("selectAllChange:"+JSON.stringify(this.selection));
    },

    // 测试时 单独写手动勾选checkbox行选中事件  如何区分是选中还是取消选中
    rowCheckChange(selection,row) {//该方法比selectionChange 后执行   @select
      console.log("rowCheckChange1:"+JSON.stringify(row));
      console.log("rowCheckChange2:"+JSON.stringify(selection));
      this.currentRow = row
      if (this.pageDef.tabDef.isSelect) {

        this.selection=[];
        if(selection && selection.length > 0){
          for(var i=0;i<selection.length;++i){
            this.selection.push(selection[i][this.pageDef.tabDef.mutiCheckParam])
          }
        }
      }

      console.log("rowCheckChange3:"+JSON.stringify(this.selection));
      this.$emit('rowChange', row)
    },

    // 测试时 单独写checkbox行选中事件  如何区分是选中还是取消选中
    rowCheckedChange(currentRow, oldCurrentRow) {//2019-1-8 选中行或者选中checkbox 都会触发执行  要注意  @current-change
      console.log("rowCheckedChange1:"+JSON.stringify(currentRow));
      console.log("rowCheckedChange2:"+JSON.stringify(oldCurrentRow));
      if(currentRow){
        this.selection.push(currentRow[this.pageDef.tabDef.mutiCheckParam]);
      }else{
        if(this.selection && this.selection.length > 0){
          let i=this.selection.indexOf(oldCurrentRow[this.pageDef.tabDef.mutiCheckParam])
          this.selection.splice(i,1)//删除一个元素
        }
      }

      console.log("rowCheckedChange3:"+JSON.stringify(this.selection));
    },

    selectionChange(selection) {//2019-1-7 修改获取选择框值得方法  根据key 值获取   @selection-change
      console.log("selectionChange1:"+JSON.stringify(selection))
      console.log("selectionChange2:"+JSON.stringify(this.selection))
      this.selection = selection;
      console.log("selectionChange3:"+JSON.stringify(this.selection))
      this.$emit('selectionChange', selection)

      //
      let checkParam=this.pageDef.tabDef.checkParam;


    },

    evalRegulation(regulation, row) {
      let evalStr = regulation
      if (regulation) {
        var reg = /\w+\s*(=|!)=\s*'*\w+'*/g
        var result = regulation.match(reg)
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
        var reg = /\w+\s*(=|!)=\s*'*\w+'*/g
        var result = visible.match(reg)
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

    queryRef(row, column, cellValue) {//cellValue
      // console.log("queryRef33:"+cellValue);
      // console.log("queryRef11:"+JSON.stringify(row));
      let columnName=column.property;
      // console.log("queryRef22:"+ row[columnName]);
      //第一种 以前的方法待测试 column.property 是列属性 pfAmt等
      // var fval = ''
      // if (cellValue !== '' && cellValue != undefined) {
      //   console.log("子组件queryRef:"+column.property);
      //   this.$emit('queryRef', column.property, cellValue, function(val) {
      //     fval = val
      //   })
      //   return fval
      // }

      //第二种 先写一个格式化金额的
      return commonUtil.numberToPercent(row[columnName],"#,##0.00");

    },

    formatDateTime(row, column, cellValue) {
      return commonUtil.formatDateString(cellValue, 'yyyy-MM-dd hh:mm:ss')
    },

    clearSelect(colName) {
      delete this.form[colName]
    },

    formatDate(row, column, cellValue) {
      return commonUtil.formatDateString(cellValue, 'yyyy-MM-dd')
    },

    customFormat(row, column, cellValue) {
      // console.log("子组件customFormat:"+cellValue+"---val:"+column+"row:"+row);
      if (cellValue !== '' && cellValue != undefined) {
        let fval = ''
        this.$emit('customFormat', cellValue, function(val) {
          // console.log("子组件customFormat的val:"+val);
          fval = val
        })
        // console.log("子组件customFormat的fval:"+fval);
        return fval
      } else {
        // return cellValue

        let fval = ''
        this.$emit('customFormat', cellValue, function(val) {
          fval = val
        })
        return fval
      }
    },
    appendRequestUrlParam(key,value,url){
        // console.log("url参数:" + key + "..." + value);

      let target="targetUrl";

      let urlData={
        "targetUrl": url
           };
      // var str=eval('('+ '{"'+ key +'": "'+ value +'"  "," + "targetUrl:" + "'+url+'" }' +')');
      // console.log("拼接字符串:"+'('+ '{"'+ key +'": "'+ value +'"  "," + "targetUrl:" + "'+url+'" }' +')' );
      var str=eval('('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')');
      console.log("拼接字符串:"+    '('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')'   );
      let targetUrl=this.$store.state.urlParam.targetUrl;
      console.log("打开url:"+targetUrl);
      if(!targetUrl){
          console.log(" this.$store.commit invoke  getUrlParam.....")
        this.$store.commit("getUrlParam",str);
      }


      // let count=1;
      // if(requestUrlParam=="begin"&&num==count){
      //
      //   requestUrlParam=''
      //   requestUrlParam+="&"+key+"="+value
      //   count=1
      // }else{
      //   requestUrlParam+="&"+key+"="+value
      //   count++
      //
      // }
    },

    appendRequestParam(key,value){
      console.log(key+"appendRequestParam"+value);
      var str1=eval('('  +  '{"'+ key +'"  : "'+ value +'"}'    +')');
      console.log("拼接字符串:"+    '('  +  '{"'+ key +'"  : "'+ value +'"}'    +')'   );
        this.$store.commit("getParam",str1);
    },
    //点击行时获取参数
    getUrlParam(row,index,param){
      let queryKey=this.$store.state.urlParam.queryKey;
      let queryParam={};
      this.$store.state.urlParam.queryParam=queryParam;
      console.log("urlParam的key值:"+JSON.stringify(param));
      console.log("urlParam的row值:"+JSON.stringify(row));
      console.log("urlParam的row值:"+index);
      // var str=eval(  '('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')'  );
      // console.log("拼接字符串:"+    '('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')'   );

      // this.$route.query=

      var str='(';
      str+= '{' ;
      console.log("拼接字符串的值1:"+str);
      for(var i=0;i<param.length;++i){
        console.log("key值分别是:"+param[i]);
        // console.log("urlParam的age值:"+row["age"]+"urlParam的name值:"+row["name"]);
        console.log("urlParam的动态值:"+row[param[i]]);
        if(i+1<param.length){
          str += '"'+param[i]+'": "'+row[param[i]]+'", ';
        }else{
          str += '"'+param[i]+'": "'+row[param[i]]+'"  ';
        }

        console.log("拼接字符串的值2:"+str);
      }
      str+=' }'    +')';
      console.log("拼接字符串的值3:"+str);
      console.log("拼接字符串的值4:"+eval(str));
      this.$store.state.urlParam.queryParam=eval(str);
      console.log("shijizhi:"+JSON.stringify(this.$store.state.urlParam.queryParam));
    },

    //点击行时获取参数
    getUrlParamDialog(row,index,param){
      // let queryKey=this.$store.state.urlParam.queryKey;
      let queryParam={};
      this.$store.state.urlParam.queryParam=queryParam;
      console.log("getUrlParamDialog urlParam的key值:"+JSON.stringify(param));
      console.log("getUrlParamDialog urlParam的row值:"+JSON.stringify(row));
      console.log("getUrlParamDialog urlParam的row值:"+index);
      // var str=eval(  '('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')'  );
      // console.log("拼接字符串:"+    '('  +  '{"'+ key +'"  : "'+ value +'","'+ target +'" : "'+ url +'"  }'    +')'   );

      // this.$route.query=

      var str='(';
      str+= '{' ;
      console.log("getUrlParamDialog 拼接字符串的值1:"+str);
      for(var i=0;i<param.length;++i){
        console.log("getUrlParamDialog key值分别是:"+param[i]);
        // console.log("urlParam的age值:"+row["age"]+"urlParam的name值:"+row["name"]);
        console.log("getUrlParamDialog urlParam的动态值:"+row[param[i]]);
        if(i+1<param.length){
          str += '"'+param[i]+'": "'+row[param[i]]+'", ';
        }else{
          str += '"'+param[i]+'": "'+row[param[i]]+'"  ';
        }

        console.log("getUrlParamDialog 拼接字符串的值2:"+str);
      }
      str+=' }'    +')';
      console.log("getUrlParamDialog 拼接字符串的值3:"+str);
      console.log("getUrlParamDialog 拼接字符串的值4:"+eval(str));
      this.$store.state.urlParam.queryParam=eval(str);
      console.log("getUrlParamDialog shijizhi:"+JSON.stringify(this.$store.state.urlParam.queryParam));
      this.$emit('showDialog');
    },

    getTemplateRow(index,row,checkParam){//2019-1-7 获取单选框选中数据
      //直接传递整行数据
      console.log("getTemplateRow:"+JSON.stringify(row));
      this.templateRadio=index;
      this.templateSelection = row;

      //根据key值获取需要的参数值
      var str='(';
      str+= '{' ;
      console.log("拼接字符串的值1:"+str);
      for(var i=0;i<checkParam.length;++i){
        console.log("key值分别是:"+checkParam[i]);
        // console.log("urlParam的age值:"+row["age"]+"urlParam的name值:"+row["name"]);
        console.log("urlParam的动态值:"+row[checkParam[i]]);
        if(i+1<checkParam.length){
          str += '"'+checkParam[i]+'": "'+row[checkParam[i]]+'", ';
        }else{
          str += '"'+checkParam[i]+'": "'+row[checkParam[i]]+'"  ';
        }

        console.log("拼接字符串的值2:"+str);
      }
      str+=' }'    +')';
      console.log("拼接字符串的值3:"+str);
      this.templateSelection=eval(str);

    }
  }
}
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
  .isLink{
    color: blue;
  }
</style>
