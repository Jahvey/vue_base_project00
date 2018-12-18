<template>
    <div class="mp-check-in-info">
      <el-row>
        <p>登记信息</p>
      </el-row>
      <el-row>
        <el-table
          class="checkininfo-t"
          max-height="350"
          ref="multipleTable"
          :data="checkInInfo"
          tooltip-effect="dark"
          style="width: 100%"
          @selection-change="handleSelectionChange">
          <el-table-column align="center" type="selection" ></el-table-column>
          <el-table-column align="center" label="登记编号"  prop="checkInNumber" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" prop="checkInInstitutionType" label="登记机构类型" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" prop="checkInInstitutionName" label="登记机构名称" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" prop="workTime" label="登记生效日期" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" prop="endTime" label="登记到期日期" show-overflow-tooltip></el-table-column>
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
          title="添加登记信息"
          :visible.sync="dialogVisible"
          width="80%"
          :before-close="handleClose"
          append-to-body>
          <addCheckInInfo v-on:backFlag="getMsg"/>
        </el-dialog>
      </template>
    </div>
</template>

<script>
  import addCheckInInfo from './addCheckInInfo'
    export default {
      name: "mp-check-in-info",
      components:{
        addCheckInInfo,
      },
      data(){
        return{
          checkInInfo:[
            {
              checkInNumber: 'DJ12132112',
              checkInInstitutionType: '政府认定',
              checkInInstitutionName: '中华权威登记机构',
              workTime:"2018-09-11",
              endTime:"2019-09-10",
            },
            {
              checkInNumber: 'DJ12132112',
              checkInInstitutionType: '政府认定',
              checkInInstitutionName: '中华权威登记机构',
              workTime:"2018-09-11",
              endTime:"2019-09-10",
            },
            {
              checkInNumber: 'DJ12132112',
              checkInInstitutionType: '政府认定',
              checkInInstitutionName: '中华权威登记机构',
              workTime:"2018-09-11",
              endTime:"2019-09-10",
            },
            {
              checkInNumber: 'DJ12132112',
              checkInInstitutionType: '政府认定',
              checkInInstitutionName: '中华权威登记机构',
              workTime:"2018-09-11",
              endTime:"2019-09-10",
            },
            {
              checkInNumber: 'DJ12132112',
              checkInInstitutionType: '政府认定',
              checkInInstitutionName: '中华权威登记机构',
              workTime:"2018-09-11",
              endTime:"2019-09-10",
            },
          ],
          multipleSelection: [],
          buttonAdd:"新增",
          buttonDelete:"删除",
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
      }
    }
</script>

<style scoped>
  .mp-check-in-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-check-in-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
  .el-pagination{
    margin:10px 0;
    text-align: center;
  }
  .checkininfo-t .el-button + .el-button{
    margin-left:0px;
  }
  .checkininfo-t .el-button--mini{
    padding: 6px;
  }
</style>
