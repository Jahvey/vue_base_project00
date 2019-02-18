<template>
    <div class="query-property-right-person">
      <el-row>
        <el-form :inline="true" :model="formInline" class="demo-form-inline">
          <el-form-item label="关键字查询">
            <el-input v-model="formInline.keywords" placeholder="请输入关键字"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary">查询</el-button>
          </el-form-item>
        </el-form>
      </el-row>
      <el-row>
        <el-table
          @row-click="chooseSelect"
          border="true"
          class="insurance-t"
          max-height="300"
          ref="multipleTable"
          :data="customerInfo"
          tooltip-effect="dark"
          style="width: 100%"
          @selection-change="handleSelectionChange">
          <el-table-column align="center" label="客户编号"  prop="customerNumber" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" prop="customerFullName" label="客户名全称" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" prop="customerType" label="客户类型" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" prop="organizationCode" label="组织机构代码" show-overflow-tooltip></el-table-column>
        </el-table>
      </el-row>
      <el-row>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[100, 200, 300, 400]"
          :page-size="100"
          layout="total, sizes, prev, pager, next, jumper"
          :total="400">
        </el-pagination>
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "query-property-right-person",
      data(){
          return{
            customerInfo:[
              {
                customerNumber: 'KH12312321',
                customerFullName: '李四',
                customerType: '企业',
                organizationCode:"ZZ12312312312",
              },
              {
                customerNumber: 'KH12312321',
                customerFullName: '李四',
                customerType: '企业',
                organizationCode:"ZZ12312312312",
              },
              {
                customerNumber: 'KH12312321',
                customerFullName: '李四',
                customerType: '企业',
                organizationCode:"ZZ12312312312",
              },
              {
                customerNumber: 'KH12312321',
                customerFullName: '李四',
                customerType: '企业',
                organizationCode:"ZZ12312312312",
              },
              {
                customerNumber: 'KH12312321',
                customerFullName: '李四',
                customerType: '企业',
                organizationCode:"ZZ12312312312",
              },
              {
                customerNumber: 'KH12312321',
                customerFullName: '李四',
                customerType: '企业',
                organizationCode:"ZZ12312312312",
              },
              {
                customerNumber: 'KH12312321',
                customerFullName: '李四',
                customerType: '企业',
                organizationCode:"ZZ12312312312",
              },
            ],
            currentPage1: 5,
            currentPage2: 5,
            currentPage3: 5,
            currentPage4: 4,
            formInline:{
              keywords:"",
            },

          }
      },
      methods:{
        toggleSelection(rows) {
          if (rows) {
            rows.forEach(row => {
              this.$refs.multipleTable.toggleRowSelection(row);
            });
          } else {
            this.$refs.multipleTable.clearSelection();
          }
        },
        handleSelectionChange(val) {
          this.multipleSelection = val;
        },
        handleSizeChange(val) {
          console.log(`每页 ${val} 条`);
        },
        handleCurrentChange(val) {
          console.log(`当前页: ${val}`);
        },
        handleClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {});
        },
        chooseSelect:function (row) {
          //alert(JSON.stringify(row));
          this.$emit('backFlag',"ok");
        },
      },
    }
</script>

<style scoped>
  .query-property-right-person{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .query-property-right-person p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
  .el-pagination{
    margin:10px 0;
    text-align: center;
  }
  .qprp-t .el-button + .el-button{
    margin-left:0px;
  }
  .qprp-t .el-button--mini{
    padding: 6px;
  }
</style>
