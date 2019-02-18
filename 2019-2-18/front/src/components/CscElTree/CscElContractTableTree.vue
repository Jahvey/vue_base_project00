<template>

  <el-tree
    :data="data"
    :props="defaultProps"
    :highlight-current="true"
    :check-strictly="true"
    node-key="label"
    accordion
    ref="tree"
    :filter-node-method="filterNode"
    @check-change="checkChange"
    @node-click="handleNodeClick"
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

</template>

<script>

  //以下仅供测试  下面就是具体的页面内容



  export default {
    name: "csc-el-contract-table-tree",
    data() {
      return{
        activeName2: 'first',
        // data: [{
        //   label: '一级 1',
        //   icon:'el-icon-success',
        //   productLevel: '1',
        //   isLeaf: '0',
        //   children: [{
        //     label: '二级 1-1',
        //     icon: "el-icon-delete",
        //     isLeaf: '0',
        //     productLevel: '2',
        //     children: [{
        //       label: '三级 1-1-1',
        //       icon: "el-icon-delete",
        //       isLeaf: '1',
        //       url:'four',
        //       productLevel: '3'
        //     }]
        //   }]
        // }, {
        //   label: '一级 2',
        //   productLevel: '1',
        //   isLeaf: '0',
        //   icon: "el-icon-delete",
        //   children: [{
        //     label: '二级 2-1',
        //     productLevel: '2',
        //     isLeaf: '0',
        //     icon: 'el-icon-delete',
        //     children: [{
        //       label: '三级 2-1-1',
        //       productLevel: '3',
        //       isLeaf: '1',
        //       url:'five',
        //       icon: "el-icon-delete"
        //     }]
        //   }, {
        //     label: '二级 2-2',
        //     icon: 'el-icon-delete',
        //     isLeaf: '0',
        //     productLevel: '2',
        //     children: [{
        //       label: '三级 2-2-1',
        //       productLevel: '3',
        //       isLeaf: '1',
        //       url:'six',
        //       icon: "el-icon-delete"
        //     }]
        //   }]
        // }, {
        //   label: '一级 3',
        //   icon: "el-icon-delete",
        //   productLevel: '1',
        //   isLeaf: '0',
        //   children: [{
        //     label: '二级 3-1',
        //     productLevel: '2',
        //     isLeaf: '0',
        //     icon: 'el-icon-delete',
        //     children: [{
        //       label: '三级 3-1-1',
        //       productLevel: '3',
        //       isLeaf: '1',
        //       url:'seven',
        //       icon: "el-icon-delete"
        //     }]
        //   }, {
        //     label: '二级 3-2',
        //     icon: 'el-icon-delete',
        //     isLeaf: '0',
        //     productLevel: '2',
        //     children: [{
        //       label: '三级 3-2-1',
        //       productLevel: '3',
        //       isLeaf: '1',
        //       url:'eight',
        //       icon: "el-icon-delete"
        //     }]
        //   }]
        // },{
        //   label:'一级 4',
        //   icon:'el-icon-delete',
        //   isLeaf: '1',
        //   url:'first',
        //   productLevel:'1'
        // },{
        //   label:'一级 5',
        //   icon:'el-icon-delete',
        //   isLeaf: '0',
        //   productLevel:'1',
        //   children: [
        //     {
        //       label:'一级 5-1',
        //       icon:'el-icon-delete',
        //       isLeaf: '1',
        //       url:'five',
        //       productLevel:'2'
        //     },
        //     {
        //       label:'一级 5-2',
        //       icon:'el-icon-delete',
        //       isLeaf: '1',
        //       url:'six',
        //       productLevel:'2'
        //     }
        //   ]
        // }],

        data:[],

        data1: [{
          label: '一级 1',
          icon:'el-icon-success',
          productLevel: '1',
          isLeaf: '0',
          children: [{
            label: '二级 1-1',
            icon: "el-icon-delete",
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 1-1-1',
              icon: "el-icon-delete",
              isLeaf: '1',
              url:'four',
              productLevel: '3'
            }]
          }]
        }, {
          label: '一级 3',
          icon: "el-icon-delete",
          productLevel: '1',
          isLeaf: '0',
          children: [{
            label: '二级 3-1',
            productLevel: '2',
            isLeaf: '0',
            icon: 'el-icon-delete',
            children: [{
              label: '三级 3-1-1',
              productLevel: '3',
              isLeaf: '1',
              url:'seven',
              icon: "el-icon-delete"
            }]
          }, {
            label: '二级 3-2',
            icon: 'el-icon-delete',
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 3-2-1',
              productLevel: '3',
              isLeaf: '1',
              url:'eight',
              icon: "el-icon-delete"
            }]
          }]
        },{
          label:'一级 4',
          icon:'el-icon-delete',
          isLeaf: '1',
          url:'first',
          productLevel:'1'
        },{
          label:'一级 5',
          icon:'el-icon-delete',
          isLeaf: '0',
          productLevel:'1',
          children: [
            {
              label:'一级 5-1',
              icon:'el-icon-delete',
              isLeaf: '1',
              url:'five',
              productLevel:'2'
            },
            {
              label:'一级 5-2',
              icon:'el-icon-delete',
              isLeaf: '1',
              url:'six',
              productLevel:'2'
            }
          ]
        }],

        //根据取值动态设置不同的tree暂时就不从数据库或配置文件取了  数据库取还需要查询 目前就写在文件里
        data2: [{
          label: '一级 2',
          productLevel: '1',
          isLeaf: '0',
          icon: "el-icon-delete",
          children: [{
            label: '二级 2-1',
            productLevel: '2',
            isLeaf: '0',
            icon: 'el-icon-delete',
            children: [{
              label: '三级 2-1-1',
              productLevel: '3',
              isLeaf: '1',
              url:'five',
              icon: "el-icon-delete"
            }]
          }, {
            label: '二级 2-2',
            icon: 'el-icon-delete',
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 2-2-1',
              productLevel: '3',
              isLeaf: '1',
              url:'six',
              icon: "el-icon-delete"
            }]
          }]
        }, {
          label: '一级 3',
          icon: "el-icon-delete",
          productLevel: '1',
          isLeaf: '0',
          children: [{
            label: '二级 3-1',
            productLevel: '2',
            isLeaf: '0',
            icon: 'el-icon-delete',
            children: [{
              label: '三级 3-1-1',
              productLevel: '3',
              isLeaf: '1',
              url:'seven',
              icon: "el-icon-delete"
            }]
          }, {
            label: '二级 3-2',
            icon: 'el-icon-delete',
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 3-2-1',
              productLevel: '3',
              isLeaf: '1',
              url:'eight',
              icon: "el-icon-delete"
            }]
          }]
        },{
          label:'一级 4',
          icon:'el-icon-delete',
          isLeaf: '1',
          url:'first',
          productLevel:'1'
        },{
          label:'一级 5',
          icon:'el-icon-delete',
          isLeaf: '0',
          productLevel:'1',
          children: [
            {
              label:'一级 5-1',
              icon:'el-icon-delete',
              isLeaf: '1',
              url:'five',
              productLevel:'2'
            },
            {
              label:'一级 5-2',
              icon:'el-icon-delete',
              isLeaf: '1',
              url:'six',
              productLevel:'2'
            }
          ]
        }],
        data3: [{
          label: '一级 1',
          icon:'el-icon-success',
          productLevel: '1',
          isLeaf: '0',
          children: [{
            label: '二级 1-1',
            icon: "el-icon-delete",
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 1-1-1',
              icon: "el-icon-delete",
              isLeaf: '1',
              url:'four',
              productLevel: '3'
            }]
          }]
        }, {
          label: '一级 2',
          productLevel: '1',
          isLeaf: '0',
          icon: "el-icon-delete",
          children: [{
            label: '二级 2-1',
            productLevel: '2',
            isLeaf: '0',
            icon: 'el-icon-delete',
            children: [{
              label: '三级 2-1-1',
              productLevel: '3',
              isLeaf: '1',
              url:'five',
              icon: "el-icon-delete"
            }]
          }, {
            label: '二级 2-2',
            icon: 'el-icon-delete',
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 2-2-1',
              productLevel: '3',
              isLeaf: '1',
              url:'six',
              icon: "el-icon-delete"
            }]
          }]
        }, {
          label: '一级 3',
          icon: "el-icon-delete",
          productLevel: '1',
          isLeaf: '0',
          children: [{
            label: '二级 3-1',
            productLevel: '2',
            isLeaf: '0',
            icon: 'el-icon-delete',
            children: [{
              label: '三级 3-1-1',
              productLevel: '3',
              isLeaf: '1',
              url:'seven',
              icon: "el-icon-delete"
            }]
          }, {
            label: '二级 3-2',
            icon: 'el-icon-delete',
            isLeaf: '0',
            productLevel: '2',
            children: [{
              label: '三级 3-2-1',
              productLevel: '3',
              isLeaf: '1',
              url:'eight',
              icon: "el-icon-delete"
            }]
          }]
        },{
          label:'一级 4',
          icon:'el-icon-delete',
          isLeaf: '1',
          url:'first',
          productLevel:'1'
        },{
          label:'一级 5',
          icon:'el-icon-delete',
          isLeaf: '0',
          productLevel:'1',
          children: [
            {
              label:'一级 5-1',
              icon:'el-icon-delete',
              isLeaf: '1',
              url:'five',
              productLevel:'2'
            },
            {
              label:'一级 5-2',
              icon:'el-icon-delete',
              isLeaf: '1',
              url:'six',
              productLevel:'2'
            }
          ]
        }],
        defaultProps: {
          children: 'children',
          label: 'label',
          icon:'el-icon-delete',
          productLevel:'0',
          isLeaf: '0'
        }

      };
    },

    props:{

      // treeData:
      //   {
      //     type:Array,
      //     required:true
      //   }

    },
    watch:{


    },
    beforeCreate: function(){

    },
    created: function(){
      //初始化的时候根据 传入的值判断加载树节点
      let param=this.$store.state.urlParam.queryParam;//前面点击选择按钮或者超链接传递参数 怎么获取
      if(param.certNum=='510282198011307887'){
        this.data=this.data1;
      }else if(param.certNum=='510721196707120178'){
        this.data=this.data2;
      }else{
        this.data=this.data3;
      }
    },
    mounted: function () {

    },

    components:{

    },

    methods:{
      handleNodeClick(item,node,self) {//2018-12-25  点击选中

        console.log("handleNodeClick这样能获取item:"+JSON.stringify(item));
        console.log("handleNodeClick这样能获取node:"+node);
        console.log("handleNodeClick这样能获取self:"+self);

        //方案一 不用复选框   已经测试通过 选中值返回父组件
        // this.currCheckedNode=item;

        //方案二 用复选框 控制单选
        // this.currCheckedNode=item.label;
        // this.$refs.tree.setCheckedKeys([item.label])

        //方案三 测试为非叶子节点不能选择
        if(item.isLeaf==='0'){
          console.log("handleNodeClick:"+"请选择最底层节点");
        }else{
          // this.tabComponent=item.url;
          console.log("handleNodeClick:"+item.url);
          this.$emit('nodeClick',item.url)
        }



      },

      /**
       * 子组件触发父组件切换组件内容
       */
      nodeClick(){
        console.log("CscElTree组件子节点选择切换右侧页面:"+this.$refs.tree.getCheckedNodes().url);
        this.$emit('nodeClick',this.$refs.tree.getCheckedNodes())
      },
      filterNode() {

      },

      checkChange() {

      }
    }
  }
</script>

<style scoped>
  .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }
</style>
