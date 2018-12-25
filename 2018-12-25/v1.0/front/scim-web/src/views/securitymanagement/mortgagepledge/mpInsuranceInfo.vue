<template>
    <div class="mp-insurance-info">
      <el-row>
          <p>保险信息</p>
      </el-row>
      <el-row >
          <el-table
            class="insurance-t"
            max-height="350"
            ref="multipleTable"
            :data="insuranceInfo"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column align="center" type="selection" ></el-table-column>
            <el-table-column align="center" label="保险机构"  prop="insuranceInstitution" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="insuranceNumber" label="保险单编号" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="insuranceType" label="担保险种" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="insurancePerson" label="投保人" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="firstBenefitPerson" label="第一受益人" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="currency" label="币种" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="guaranteeMoney" label="投保金额(元)" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="startTime" label="起始日期" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="endTime" label="到期日期" show-overflow-tooltip></el-table-column>
            <el-table-column align="center" prop="workTime" label="生效日期" show-overflow-tooltip></el-table-column>
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
          title="提示"
          :visible.sync="dialogVisible"
          width="80%"
          :before-close="handleClose"
          append-to-body>
          <addInsuranceInfo v-on:backFlag="getMsg"/>
        </el-dialog>
      </template>
    </div>
</template>

<script>
  import addInsuranceInfo from './addInsuranceInfo'
    export default {
      name: "mp-insurance-info",
      components:{
        addInsuranceInfo
      },
      data() {
        return {
          insuranceInfo: [
            {
              insuranceInstitution: '中国人寿保险',
              insuranceNumber: 'RS1298832432324',
              insuranceType: '损坏险',
              insurancePerson:"张三",
              firstBenefitPerson:"赵清华",
              currency:"人民币",//
              guaranteeMoney:"189.20",
              startTime:"2018-09-11",
              endTime:"2019-09-10",
              workTime:"2018-09-11",
            },
            {
              insuranceInstitution: '中国人寿保险',
              insuranceNumber: 'RS1298832432324',
              insuranceType: '损坏险',
              insurancePerson:"张三",
              firstBenefitPerson:"赵清华",
              currency:"人民币",//
              guaranteeMoney:"189.20",
              startTime:"2018-09-11",
              endTime:"2019-09-10",
              workTime:"2018-09-11",
            },
            {
              insuranceInstitution: '中国人寿保险',
              insuranceNumber: 'RS1298832432324',
              insuranceType: '损坏险',
              insurancePerson:"张三",
              firstBenefitPerson:"赵清华",
              currency:"人民币",//
              guaranteeMoney:"189.20",
              startTime:"2018-09-11",
              endTime:"2019-09-10",
              workTime:"2018-09-11",
            },
            {
              insuranceInstitution: '中国人寿保险',
              insuranceNumber: 'RS1298832432324',
              insuranceType: '损坏险',
              insurancePerson:"张三",
              firstBenefitPerson:"赵清华",
              currency:"人民币",//
              guaranteeMoney:"189.20",
              startTime:"2018-09-11",
              endTime:"2019-09-10",
              workTime:"2018-09-11",
            },
            {
              insuranceInstitution: '中国人寿保险',
              insuranceNumber: 'RS1298832432324',
              insuranceType: '损坏险',
              insurancePerson:"张三",
              firstBenefitPerson:"赵清华",
              currency:"人民币",//
              guaranteeMoney:"189.20",
              startTime:"2018-09-11",
              endTime:"2019-09-10",
              workTime:"2018-09-11",
            },
            {
              insuranceInstitution: '中国人寿保险',
              insuranceNumber: 'RS1298832432324',
              insuranceType: '损坏险',
              insurancePerson:"张三",
              firstBenefitPerson:"赵清华",
              currency:"人民币",//
              guaranteeMoney:"189.20",
              startTime:"2018-09-11",
              endTime:"2019-09-10",
              workTime:"2018-09-11",
            },
            {
              insuranceInstitution: '中国人寿保险',
              insuranceNumber: 'RS1298832432324',
              insuranceType: '损坏险',
              insurancePerson:"张三",
              firstBenefitPerson:"赵清华",
              currency:"人民币",//
              guaranteeMoney:"189.20",
              startTime:"2018-09-11",
              endTime:"2019-09-10",
              workTime:"2018-09-11",
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
      watch:{
        insuranceInfoChange:function (data) {

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
        handleClose:function (done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {});
        },
        getMsg:function (flag) {//关闭增加保险信息dialog
          if(flag === 'ok'){
            this.dialogVisible = false;
          }
        },
      }
    }
</script>

<style scoped>
  .mp-insurance-info{
    width:100%;
    height:100%;
    padding-left: 10px;
    padding-right: 10px;
  }
  .mp-insurance-info p{
    border-bottom: 1px solid #CCCCCC;
    font-size: 18px;
  }
  .el-pagination{
    margin:10px 0;
    text-align: center;
  }
  .insurance-t .el-button + .el-button{
    margin-left:0px;
  }
  .insurance-t .el-button--mini{
    padding: 6px;
  }
</style>
