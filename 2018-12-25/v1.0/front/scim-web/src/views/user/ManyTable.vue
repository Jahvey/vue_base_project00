<template>
  <div>
    <el-tabs type="border-card">
      <el-tab-pane label="主体信息">
        主体信息
      </el-tab-pane>
      <el-tab-pane label="明细信息">
        明细信息
      </el-tab-pane>
      <el-tab-pane label="现金流">
        现金流
      </el-tab-pane>
      <el-tab-pane label="费用列表">费用列表</el-tab-pane>
      <el-tab-pane label="固有收入信息">固有收入信息</el-tab-pane>
      <el-tab-pane label="特有信息">特有信息</el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
  // import TableBasicInfo from './TableBasicInfo.vue'
  // import TableSubjectInfo from './TableSubjectInfo.vue'

  export default {
    data() {
      return {
        parentMsg: '',
        total: 0
      }
    },
    components: {
      // 'basic-info': TableBasicInfo,
      // 'subject-info': TableSubjectInfo
    },
    created(){
      console.log("ManyTable创建进来没有"+JSON.stringify(this.$route.query));
    },
    methods: {
      incrementTotal(value){
        this.total = value
      }
    }

  }
</script>
