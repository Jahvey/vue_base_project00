<template>
  <!--<el-dialog :title="pageDef.title" :visible.sync="pageDef.dialogFormVisible" :fullscreen="true">-->
  <!--<el-dialog :title="pageDef.title" :visible.sync="pageDef.dialogFormVisible" :fullscreen="true" @open="open()">-->

    <el-dialog :title="pageDef.title" :visible.sync="pageDef.dialogFormVisible" :fullscreen="true">

      <el-input
        placeholder="输入关键字进行过滤"
        v-model="filterText">
      </el-input>

      <!-- 2018-12-27 以下树为测试动态为每层节点添加不同图标 后期实现如何对非最底层节点实现打开和收起是两个图标 最底层如何区分-->
    <el-tree
    :data="data"
    :props="defaultProps"
    :highlight-current="true"
    :check-strictly="true"
    node-key="label"
    accordion
    show-checkbox
    ref="tree"
    :filter-node-method="filterNode"
    @node-click="handleNodeClick"
    @check-change="checkChange"
   >

       <span class="custom-tree-node" slot-scope="{node,data}">
        <span>
         <template v-if="data.productLevel==='1'">
           <i class="el-icon-info"></i>
         </template>

        <template v-else-if="data.productLevel==='2'">
          <i class="el-icon-edit"></i>
        </template>

         <template v-else>
          <i class="el-icon-success"></i>
         </template>
      {{ node.label}}</span>

       </span>

    </el-tree>

    <!--<el-tree-->
      <!--ref="tree"-->
      <!--:data="productList"-->
      <!--:props="defaultProps"-->
      <!--node-key="productCd"-->
      <!--accordion-->
      <!--@node-click="handleNodeClick">-->

        <!--<span slot-scope="{ node, data }">-->

          <!--<template v-if="node.productLevel==='1'">-->
          <!--<span>-->
          <!--<i :class="el-icon-edit"></i>-->
        <!--{{ node.label }}</span>-->
          <!--</template>-->

           <!--<template v-else-if="node.productLevel==='2'">-->

         <!--<span>-->
           <!--<i :class="el-icon-edit"></i>-->
        <!--{{ node.label }}</span>-->

      <!--</template>-->

          <!--<template v-else>-->

         <!--<span>-->
          <!--<i :class="el-icon-edit"></i>-->
        <!--{{ node.label }}</span>-->
        <!--</template>-->

      <!--</span>-->

    <!--</el-tree>-->

    <!--<el-tree-->
      <!--ref="tree"-->
      <!--:data="productList"-->
      <!--:props="defaultProps"-->
      <!--:icon-class="el-icon"-->
      <!--node-key="productCd"-->
      <!--accordion-->
      <!--show-checkbox-->
      <!--default-expand-all-->
      <!--:expand-on-click-node="false"-->
      <!--@node-click="handleNodeClick">-->


    <!--<span slot-scope="{ node,data }">-->
        <!--<span>1111-->
        <!--{{node.label}}-->
        <!--</span>-->
        <!--<span>-->
          <!--<el-button-->
            <!--type="text"-->
            <!--size="mini"-->
            <!--@click="() => append(data)">-->
            <!--Append-->
          <!--</el-button>-->
          <!--<el-button-->
            <!--type="text"-->
            <!--size="mini"-->
            <!--@click="() => remove(node, data)">-->
            <!--Delete-->
          <!--</el-button>-->
        <!--</span>-->
      <!--</span>-->
<!--</el-tree>-->

    <div class="buttons">
      <!--<el-button @click="getCheckedNodes">通过 node 获取</el-button>-->
      <!--<el-button @click="getCheckedKeys">通过 key 获取</el-button>-->
      <!--<el-button @click="setCheckedNodes">通过 node 设置</el-button>-->
      <!--<el-button @click="setCheckedKeys">通过 key 设置</el-button>-->
      <el-button @click="resetChecked">清空</el-button>
      <el-button @click="getCheckedNodesAndClose">确定</el-button>
    </div>

  </el-dialog>
</template>

<script>
import { getEnumObj } from "@/utils/formatter"
import CscFormColumn from "@/components/CscFormColumn/CscFormColumn"
import ElTabPane from "element-ui/packages/tabs/src/tab-pane";

import {queryProductByAuth } from '@/api/user'

export default {
  name: "CscFormDialogWithTree",
  data() {
    return{
      filterText: '',//定义el-tree过滤内容
      activeName2: 'first',
      i: 0,//用于控制check-change
      productList:[],//产品树定义
      listQuery: {
        orgcode: '0700', // 多页查询跳转页码
        partyTypeCd: '02', // 多页查询每页笔数
        productCd: '02'
      },
      currCheckedNode: null,//2018-12-28 当前被选中节点对象
      data: [{
        label: '一级 1',
        icon:'el-icon-success',
        productLevel: '1',
        children: [{
          label: '二级 1-1',
          icon: "el-icon-delete",
          productLevel: '2',
          children: [{
            label: '三级 1-1-1',
            icon: "el-icon-delete",
            productLevel: '3'
          }]
        }]
      }, {
        label: '一级 2',
        productLevel: '1',
        icon: "el-icon-delete",
        children: [{
          label: '二级 2-1',
          productLevel: '2',
          icon: 'el-icon-delete',
          children: [{
            label: '三级 2-1-1',
            productLevel: '3',
            icon: "el-icon-delete"
          }]
        }, {
          label: '二级 2-2',
          icon: 'el-icon-delete',
          productLevel: '2',
          children: [{
            label: '三级 2-2-1',
            productLevel: '3',
            icon: "el-icon-delete"
          }]
        }]
      }, {
        label: '一级 3',
        icon: "el-icon-delete",
        productLevel: '1',
        children: [{
          label: '二级 3-1',
          productLevel: '2',
          icon: 'el-icon-delete',
          children: [{
            label: '三级 3-1-1',
            productLevel: '3',
            icon: "el-icon-delete"
          }]
        }, {
          label: '二级 3-2',
          icon: 'el-icon-delete',
          productLevel: '2',
          children: [{
            label: '三级 3-2-1',
            productLevel: '3',
            icon: "el-icon-delete"
          }]
        }]
      }],

      defaultProps: {
        children: 'children',
        label: 'label',
        icon:'el-icon-delete',
        productLevel:'0'
      }

      // defaultProps: {
      //   children: 'childList',//子列表名字
      //   label: 'productName', // 这里的名字要和你封装的数据中的节点的名字一样
      //   productLevel: '1',
      //   icon: "el-icon-delete"
      // }


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
    CscFormColumn},

  beforeCreate:function() {
    // console.log("beforeCreated进来dialogFormVisible:"+this.pageDef.dialogFormVisible);
    // console.log("beforeCreate进来form:"+JSON.stringify(this.form));
    console.log("beforeCreate进来form:"+123456);

  },

  created:function() {
    console.log("created进来cscformdialog:"+JSON.stringify(this.form))
  },
mounted:function(){

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
      console.log(tab, event);
    },
    handleNodeClick(item,node,self) {//2018-12-25  点击选中

      console.log("handleNodeClick这样能获取item:"+JSON.stringify(item));
      console.log("handleNodeClick这样能获取node:"+node);
      console.log("handleNodeClick这样能获取self:"+self);

      //方案一 不用复选框   已经测试通过 选中值返回父组件
      // this.currCheckedNode=item;

      //方案二 用复选框 控制单选
      this.currCheckedNode=item.label;
      this.$refs.tree.setCheckedKeys([item.label])

    },
  checkChange(item,node,self){//如果出现复选框 则在节点点击时控制只能单选   第二个参数 节点是否被选中 第三个参数节点的子树中是否有被选中的节点
    // console.log("checkChange这样能获取item:"+JSON.stringify(item));
    // console.log("checkChange这样能获取node:"+JSON.stringify(node));
    // console.log("checkChange这样能获取self:"+JSON.stringify(self));
    this.i++;
    if(this.i%2==0){
      if(node == true) {//点击未选中复选框
        console.log("进来1:"+JSON.stringify(item));

        // this.currCheckedNode=item.label;
        // this.$refs.tree.setCheckedKeys([item.label]);

        this.currCheckedNode=item;
        this.$refs.tree.setCheckedNodes([]);
        this.$refs.tree.setCheckedNodes([item]);
      }else{
        //以上只保证至少选中一个
        console.log("进来2:"+JSON.stringify(item));
        // if(this.currCheckedNode==item.label){//
        //   this.$refs.tree.setCheckedKeys([item.label]);
        // }
        // this.$refs.tree.setCheckedKeys([]);


        this.currCheckedNode=null;
        this.$refs.tree.setCheckedNodes([]);
        //点击已经选中的节点，置空

      }
    }

  },
    getCheckedNodes() {
      console.log("这样能获取1:"+this.$refs.tree.getCheckedNodes());
    },
    getCheckedNodesAndClose() {
      console.log("这样能获取getCheckedNodesAndClose:"+this.$refs.tree.getCheckedNodes());
      // if(!currCheckedNode){
      //   this.$message({
      //     type: 'success',
      //     message: '请选择一条记录!'
      //   })
      // }

      //2018-12-28 如何修改父组件的值
      console.log("currCheckedNode值:"+JSON.stringify(this.currCheckedNode));
      this.$emit("getProductCd",this.currCheckedNode);
      this.pageDef.dialogFormVisible=false;//dialog关闭 可以加入回调函数  清空数据
    },
    getCheckedKeys() {
      console.log("这样能获取2:"+this.$refs.tree.getCheckedKeys());
    },
    resetChecked() {
      this.$refs.tree.setCheckedNodes([]);
      // this.$refs.tree.setCheckedKeys([]);
    },
    doProductQuery(listQuery) {
      console.log("子组件doProductQuery到底执行没有1:"+JSON.stringify(listQuery));
      queryProductByAuth(listQuery).then(response => {
        console.log("父组件到底执行没有1ResponseMsg:"+response.data);
        // alert("父组件getUserList1:"+JSON.parse(JSON.stringify(response.data)));
        // alert(''.concat(response.data, '\r\n', response.status, '\r\n', response.statusText, '\r\n', response.headers, '\r\n', response.config));
        this.productList = response.data;//如果定义的是返回responsemsg 这里response.data  就是
        console.log("父组件到底执行没有3ResponseMsg:"+response.data);
        this.$store.dispatch('setListLoading', false);
      }).catch((error) => {
        console.log(error)
      })
    },
    open(){
      // let listQuery={
      //   orgcode: '0700', // 多页查询跳转页码
      //   partyTypeCd: '02', // 多页查询每页笔数
      //   productCd: '02'
      // }
      this.doProductQuery(this.listQuery);
    },
    append(data) {
      const newChild = { id: id++, label: 'testtest', children: [] };
      if (!data.children) {
        this.$set(data, 'children', []);
      }
      data.children.push(newChild);
    },

    remove(node, data) {
      const parent = node.parent;
      const children = parent.data.children || parent.data;
      const index = children.findIndex(d => d.id === data.id);
      children.splice(index, 1);
    },
    filterNode(value, data) {//文本输入过滤框
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    checkGroupNode: function (a, b) {
      console.log("checkGroupNodea"+a);
      console.log("checkGroupNodeb"+b);
      if (b.checkedKeys.length > 0) {
        this.$refs.tree.setCheckedKeys([a.id]);
      }
    }

  },
  computed:{

  },
  //观测过滤搜索框的值
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val);
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss" scoped>

  @import "src/styles/mixin.scss";
  $bg:#2d3a4b;
  $dark_gray:#889aa4;
  $light_gray:#eee;

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

//根节点
.el-tree-parent {
  url:'../icons/apply.png'
}
  //最底层子节点
.el-tree-child {
  url:'../../icons/add.png'
}
.svg-container {
  padding: 6px 5px 6px 15px;
  color: $dark_gray;
  vertical-align: middle;
  width: 30px;
  display: inline-block;
  &_login {
    font-size: 20px;
  }
}

.tree-icon {
  display: inline-block;
}
  .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }

  //css代码
  .el-tree-node__expand-icon{
    border:0;
    /*自定义，必要时用!important*/
  }
  .el-tree-node__expand-icon.expanded{
    /*自定义，必要时用!important*/
    url:'../../icons/apply.png'
  }
  .el-tree > .el-tree-node > .el-tree-node__content > .el-checkbox{
    display: none;
  }
  .el-tree > .el-tree-node > .el-tree-node__children > .el-tree-node > .el-tree-node__content > .el-checkbox{
    display: none;
  }


  .el-tree-node__content{
    height: 35px;
    margin: 10px 0px;
    .el-tree-node__expand-icon {
      padding: 0px;
      margin-right: 20px;
      width: 30px;
      height: 30px;
      content: url("'../../icons/add.png");
    }
    .el-tree-node__expand-icon.expanded{
      transform: rotate(0deg);
    }
  }



</style>
