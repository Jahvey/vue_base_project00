<template>
  <div>
    <el-select v-model="value6" placeholder="请选择">
      <el-option
        style="width: auto;height: auto;background-color: white"
        :key="value2"
        :label="value2"
        v-show="showTree"
        ref="selectOption"
        :value="value2">
        <el-tree
          :props="props"
          :data="data2"
          ref="tree"
          node-key="id"
          @node-click="nodeClick">
        </el-tree>
      </el-option>
    </el-select>

    <button>确定</button>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        value2: '',
        value6: '',
        showTree: true,
        props: {
          label: 'label',
          children: 'children'
        },
        data2:[{
          id: 1,
          label: '一级 1',
          children: [{
            id: 4,
            label: '二级 1-1',
          }]
        }, {
          id: 2,
          label: '一级 2',
          children: [{
            id: 5,
            label: '二级 2-1'
          }, {
            id: 6,
            label: '二级 2-2'
          }]
        }, {
          id: 3,
          label: '一级 3',
          children: [{
            id: 7,
            label: '二级 3-1'
          }, {
            id: 8,
            label: '二级 3-2'
          }]
        }]
      }
    },
    methods: {
      handleCheckChange(data, checked, indeterminate) {
        console.log(data.id);
//        this.setCheckedKeys(data.id)
      },
      setCheckedKeys(id) {
        this.$refs.tree.setCheckedKeys([id]);
      },
      nodeClick(data,node,self){

        if(data.children){

        }else {
          console.log(data)
          this.value6 = data.label;
        }
      }
    }
  }
</script>
