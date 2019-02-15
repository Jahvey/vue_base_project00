<template>
  <!--<el-dialog :title="pageDef.title" :visible.sync="pageDef.dialogFormVisible" :fullscreen="true">-->
  <el-dialog :title="pageDef.title" :visible.sync="pageDef.dialogFormVisible" :fullscreen="true">


    <!--<el-tabs v-model="activeName2" type="card" @tab-click="handleClick">-->
      <!--<el-tab-pane label="用户管理" name="first">用户管理</el-tab-pane>-->
      <!--<el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>-->
      <!--<el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>-->
      <!--<el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>-->
    <!--</el-tabs>-->

    <el-tabs v-model="pageDef.activeName" type="card" @tab-click="handleClick">
      <template  v-for="(tabPane,idx) in pageDef.tabPanes">
        <el-tab-pane :label="tabPane.tabName" :name="tabPane.name">
            {{tabPane.tabName}}
          <div>
            <component :is="tabComponent"></component>
          </div>
          <p>测试tab组件</p>
        </el-tab-pane>
      </template>
    </el-tabs>


    <!---vue内置组件  tab切换的时候缓存-->
    <!--<keep-alive>-->
      <!--<router-view></router-view>-->
    <!--</keep-alive>-->

    <!--<el-tree-->
      <!--:data="data"-->
      <!--:props="defaultProps"-->
      <!--accordion-->
      <!--@node-click="handleNodeClick">-->
    <!--</el-tree>-->

    <!--<el-tree :data="productList"-->
             <!--:props="defaultProps"-->
             <!--@node-click="handleNodeClick"-->
             <!--node-key="productCd"-->
             <!--show-checkbox=true>-->
    <!--</el-tree>-->



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
</template>

<script>
import { getEnumObj } from "@/utils/formatter"
import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"
import ElTabPane from "element-ui/packages/tabs/src/tab-pane"
import {queryProductByAuth } from '@/api/user'

// import first from "@/views/user/first"
// import second from "@/views/user/second"
// import third from "@/views/user/third"

const first = resolve => require(['../../views/user/first.vue'], resolve)
const second = resolve => require(['../../views/user/second.vue'], resolve)
const third = resolve => require(['../../views/user/third.vue'], resolve)

export default {
  name: "CscFormDialog",
  data() {
    return{
      activeName2: 'first',
      tabComponent: 'first',//当前切换的组件
      productList:{},//产品树定义
      listQuery: {
        orgcode: '0700', // 多页查询跳转页码
        partyTypeCd: '02', // 多页查询每页笔数
        productCd: '02'
      },

      data: [{
        label: '一级 1',
        children: [{
          label: '二级 1-1',
          children: [{
            label: '三级 1-1-1'
          }]
        }]
      }, {
        label: '一级 2',
        children: [{
          label: '二级 2-1',
          children: [{
            label: '三级 2-1-1'
          }]
        }, {
          label: '二级 2-2',
          children: [{
            label: '三级 2-2-1'
          }]
        }]
      }, {
        label: '一级 3',
        children: [{
          label: '二级 3-1',
          children: [{
            label: '三级 3-1-1'
          }]
        }, {
          label: '二级 3-2',
          children: [{
            label: '三级 3-2-1'
          }]
        }]
      }],


      // defaultProps: {
      //   children: 'children',
      //   label: 'label'
      // }
      defaultProps: {
        children: 'childList',//子列表名字
        label: 'productName' // 这里的名字要和你封装的数据中的节点的名字一样
      }




    };
  },
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
    show: {
      type: Boolean,
      default: false
    },
    dialogFormVisible: {
      type: Boolean,
      default: false
    }
  },
  watch: {

    // show () {
    //   this.visible = this.pageDef.dialogFormVisible;
    // }

  },
  components:{
    ElTabPane,
    CscFormColumn
    // ,first,second,third
  },

  beforeCreate:function() {
    // console.log("beforeCreated进来dialogFormVisible:"+this.pageDef.dialogFormVisible);
    // console.log("beforeCreate进来form:"+JSON.stringify(this.form));
    console.log("beforeCreate进来form:"+123456);
  },

  created:function() {
    console.log("created进来cscformdialog:"+JSON.stringify(this.form))
    this.doProductQuery();
    this.checkValue(this.activeName);//初始化时调用一次
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

    doCancel() {
      this.$set(this.pageDef, 'dialogFormVisible', false)
      this.$emit("doCancel")
    },

    fieldChange(modelName, val){
      this.$emit('childFieldChange', modelName, val, this.pageDef.name, this.form)
    },
    handleClick(tab, event) {//tab选项卡切换
      console.log(tab,event);
      console.log(event.target.getAttribute('id'))  //获取到当前元素的id
      console.log(tab.name)  //获取到当前元素的id
      this.checkValue(tab.name);
    },

    checkValue(value){//tab 中component名称
      console.log(value)  //获取到当前元素的id
      let comPons=JSON.stringify(this.components);
      console.log("开始components:"+this.components);
      //先做个判断有无该tab,如果有 则不再添加
      let comArr=comPons.split(",");
      if(!comArr.indexOf(value)){
        comPons=comPons+','+value;
        this.components=JSON.parse(comPons);
      }
      console.log("最终components:"+comPons);
      this.tabComponent=value;
    },


    doProductQuery(listQuery) {

      console.log("子组件doProductQuery到底执行没有1:"+new  Date());

      queryProductByAuth(listQuery).then(response => {
        console.log("父组件到底执行没有1ResponseMsg:"+response.data.total);
        // alert("父组件getUserList1:"+JSON.parse(JSON.stringify(response.data)));
        // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
        this.productlist = response.data;//如果定义的是返回responsemsg 这里response.data  就是
        console.log("父组件到底执行没有3ResponseMsg:"+response.data.totalRec);
        this.$store.dispatch('setListLoading', false);
      }).catch((error) => {
        console.log(error)
      })
    },
    handleNodeClick(item,node,self) {//2018-12-26
      console.log(item);
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
