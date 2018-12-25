<!--共有人信息-->
<template>
    <div class="mp-part-owner-info">
        <el-row>
          <p>共有人信息</p>
        </el-row>
        <el-row>
          <el-table
            class="part-owner-t"
            max-height="350"
            ref="multipleTable"
            :data="partOwnerInfo"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column align="center" type="selection" label="选择"></el-table-column>
            <el-table-column align="center" label="共有人姓名"  prop="name" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="certificateType" label="共有人证件类型" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="number" label="证件号码" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" label="操作" width="100">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
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
        <el-row>
          <el-col :span="6" :offset="10">
            <el-button size="medium"  type="primary" @click="dialogVisible = true" >{{buttonAdd}}</el-button>
            <el-button size="medium"  type="primary" @click="doReset">{{buttonDelete}}</el-button>
          </el-col>
        </el-row>
        <template>
          <el-dialog
            title="添加共有人信息"
            :visible.sync="dialogVisible"
            width="80%"
            :before-close="handleClose"
            append-to-body>
            <addPartOwnerInfo v-on:backFlag="getMsg"/>
          </el-dialog>
        </template>
    </div>
</template>

<script>
  import addPartOwnerInfo from './addPartOwnerInfo'
    export default {
        name: "mp-part-owner-info",
      components:{
        addPartOwnerInfo
      },
      data() {
        return {
          partOwnerInfo: [
            {
              name: '张山',
              certificateType: '身份证',
              number: '510902199312019872',
            },
            {
              name: '张山',
              certificateType: '身份证',
              number: '510902199312019872',
            },
            {
              name: '张山',
              certificateType: '身份证',
              number: '510902199312019872',
            },
            {
              name: '张山',
              certificateType: '身份证',
              number: '510902199312019872',
            },
            {
              name: '张山',
              certificateType: '身份证',
              number: '510902199312019872',
            },
            {
              name: '张山',
              certificateType: '身份证',
              number: '510902199312019872',
            },
          ],
          multipleSelection: [],
          buttonAdd: "新增",
          buttonDelete: "删除",
          currentPage1: 5,
          currentPage2: 5,
          currentPage3: 5,
          currentPage4: 4,
          dialogVisible: false
        }
      },
      methods: {
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
        handleClose: function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {
            });
        },
        getMsg: function (flag) {//关闭增加保险信息dialog
          if (flag === 'ok') {
            this.dialogVisible = false;
          }
        },
      },
    }
</script>

<style scoped>
  .mp-part-owner-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-part-owner-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
  .el-pagination{
    margin:10px 0;
    text-align: center;
  }
  .part-owner-t .el-button + .el-button{
    margin-left:0px;
  }
  .part-owner-t .el-button--mini{
    padding: 6px;
  }
</style>
