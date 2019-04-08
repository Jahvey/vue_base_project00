<template>
  <div class="container">
    <csc-single-button-table
      :pageDef="pageDef" :disableQueryForm="disableQueryForm"
      :entity="entity"
      @pageQuery="doPageQuery"
      @doAdd="doAdd"
      @doEdit="doEdit"
      @doDelete="doDelete"
    >
    </csc-single-button-table>
    <!-- 新增编辑查看界面-->
    <el-dialog :title="dialogLable" align="center" width="50%":visible.sync="dialogVisible" :append-to-body='true'
               :close-on-click-modal="false" @close='closeDialog'>
        <el-col :span="24">
          <fieldset>
            <legend>信用信息</legend>
              <el-form ref="dataForm" :model="dataForm" label-width="140px">
                <el-col :span="12">
                  <el-form-item label="记录来源：" prop="infoSrc">
                    <el-select v-model="dataForm.infoSrc" placeholder="请选择证件类型" :disabled="thisView">
                      <el-option label="人民银行" value="1"></el-option>
                      <el-option label="启信宝" value="2"></el-option>
                      <el-option label="其它" value="9"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="查询日期：" prop="queryDate">
                    <el-date-picker
                      v-bind:disabled="thisView"
                      v-model="dataForm.queryDate"
                      type="date"
                      align= "left"
                      placeholder="选择查询日期">
                    </el-date-picker>
                  </el-form-item>
                </el-col>
              </el-form>
            </fieldset>
            <fieldset>
              <legend>截至贷款申请日24个月内信用记录</legend>
              <el-form ref="dashboard" :model="dataForm" label-width="140px">
                <el-col :span="12">
                  <el-form-item label="贷记卡及准贷记卡连续逾期次数：" prop="djkLxyqTimes">
                    <el-select v-model="dataForm.djkLxyqTimes" placeholder="请选择贷记卡及准贷记卡连续逾期次数" :disabled="thisView">
                      <el-option label="无" value="1"></el-option>
                      <el-option label="2次及以下" value="2"></el-option>
                      <el-option label="3次及以上" value="3"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="贷记卡及准贷记卡累计逾期次数：" prop="djkLjyqTimes">
                    <el-select v-model="dataForm.djkLjyqTimes" placeholder="请选择贷记卡及准贷记卡累计逾期次数" :disabled="thisView">
                      <el-option label="无" value="1"></el-option>
                      <el-option label="6次及以下" value="2"></el-option>
                      <el-option label="7次及以上" value="3"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="贷款连续欠息次数：" prop="dkLxqxTimes">
                    <el-select v-model="dataForm.dkLxqxTimes" placeholder="请选择贷款连续欠息次数" :disabled="thisView">
                      <el-option label="无" value="1"></el-option>
                      <el-option label="2次及以下" value="2"></el-option>
                      <el-option label="3次及以上" value="3"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="贷款累计欠息次数：" prop="dkLjqxTimes">
                    <el-select v-model="dataForm.dkLjqxTimes" placeholder="请选择贷款累计欠息次数" :disabled="thisView">
                      <el-option label="无" value="1"></el-option>
                      <el-option label="6次及以下" value="2"></el-option>
                      <el-option label="7次及以上" value="3"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="贷款本金逾期情况：" prop="sxbjYqCondition">
                    <el-select v-model="dataForm.sxbjYqCondition" placeholder="请选择贷款本金逾期情况" :disabled="thisView">
                      <el-option label="有" value="1"></el-option>
                      <el-option label="无" value="2"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="在工商税务等其他部门存在不良记录：" prop="branchbadrecord">
                    <el-select v-model="dataForm.branchbadrecord" placeholder="请选择在工商税务等其他部门存在不良记录" :disabled="thisView">
                      <el-option label="否" value="0"></el-option>
                      <el-option label="是" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="被银监部门列为预警单位：" prop="isalertcorp">
                    <el-select v-model="dataForm.isalertcorp" placeholder="请选择被银监部门列为预警单位" :disabled="thisView">
                      <el-option label="否" value="0"></el-option>
                      <el-option label="是" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="存在在诉案件或败诉案件：" prop="havelawsuit">
                    <el-select v-model="dataForm.havelawsuit" placeholder="请选择存在在诉案件或败诉案件" :disabled="thisView">
                      <el-option label="否" value="0"></el-option>
                      <el-option label="是" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="12">
                  <el-form-item label="出资人或高管人员存在不良信用记录：" prop="badleaderflag">
                    <el-select v-model="dataForm.badleaderflag" placeholder="请选择出资人或高管人员存在不良信用记录" :disabled="thisView">
                      <el-option label="否" value="0"></el-option>
                      <el-option label="是" value="1"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-form>
            </fieldset>
      </el-col>
      <div slot="footer" class="dialog-footer">
        <el-button v-if="viewButton" :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
        <el-button v-if="viewButton" :size="size" @click.native="dialogVisible = false">{{$t('action.cancel')}}</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import {isEmpty} from "@/utils/validate";
  import commonUtil from "@/utils/commonUtil";
  export default {
    data(){
      return {

        size: 'small',
        isAddOrEdit:'',
        dialogLable:'',

        dialogVisible: false, // 新增编辑界面是否显示
        editLoading: false,
        isView:true,//是查看隐藏编辑删除按钮
        thisView:false,//查看disabled
        viewButton:true,

        disableQueryForm:true,
        entity: {},
        selectedRow:{},
        // 界面数据
        dataForm: {
          infoSrc: '',queryDate: '',djkLxyqTimes: '',djkLjyqTimes: '',
          dkLxqxTimes: '',dkLjqxTimes: '',sxbjYqCondition: '',branchbadrecord: '',
          isalertcorp: '',havelawsuit: '',badleaderflag: '',
          partyId:this.$route.query.rowData.partyId
        },
        dataFormBlank: {
          infoSrc: '',queryDate: '',djkLxyqTimes: '',djkLjyqTimes: '',
          dkLxqxTimes: '',dkLjqxTimes: '',sxbjYqCondition: '',branchbadrecord: '',
          isalertcorp: '',havelawsuit: '',badleaderflag: '',
          partyId:this.$route.query.rowData.partyId
        },
        refreshQuery: {
          // pageJump: 1, // 多页查询跳转页码
          // recInPage: 20 // 多页查询每页笔数
          curUserNum: '200555',// 2018-11-30  当前操作员号 如何动态放入
          orgcode: '0700',//2018-11-30  当前操作员所在机构  如何动态放入
          pageNum: 1, // 多页查询跳转页码
          pageSize: 20, // 多页查询每页笔数
          partyId: this.$route.query.rowData.partyId
        },
        pageDef: {
          queryDef: {

          },
          tabDef: {
            isSelect: false, //是否可以多选
            isIndex: true,  //是否有序号
            //表格字段定义
            tabCols: [
              {label: "客户名称", prop: "partyName"},
              {label: "记录来源", prop: "infoSrc"},
              {label: "查询日期", prop: "queryDate"},
              {label: "贷记卡及准贷记卡连续逾期次数", prop: "djkLxyqTimes"},
              {label: "贷记卡及准贷记卡累计逾期次数", prop: "djkLjyqTimes"},
              {label: "贷款连续欠息次数", prop: "dkLxqxTimes"},
              {label: "贷款累计欠息次数", prop: "dkLjqxTimes"},
              {label: "授信本金逾期情况", prop: "sxbjYqCondition"},
            ]
          },
          buttons: [{label:"新增",type:"primary",funcName:"doAdd",visible:this.isView}],
        }
      }
    },
    methods: {
      doPageQuery(listQuery){
        let query =  Object.assign({},listQuery,{partyId:this.$route.query.rowData.partyId});
        this.$api.cusManage_naturalCus.getCreditInfoList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询信用信息信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询信用信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询信用信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
      // 显示新增界面
      doAdd: function () {
        this.dialogLable = '新增信用信息';
        this.dialogVisible = true;
        this.isAddOrEdit = 'add';
        this.thisView = false;
        this.viewButton = true;
      },
      doEdit(row){
        this.dialogLable = '编辑信用信息';
        this.dialogVisible = true;
        this.dataForm = Object.assign({},row);
        this.isAddOrEdit = 'edit';
        this.thisView = false;
        this.viewButton = true;
        this.isEndLong();
      },
      doDelete(row,listquery,index){
        this.$confirm('是否确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          this.$api.cusManage_naturalCus.deleteCreditInfo(row).then(res => {
            if(res && res.data && res.data.code == 200){
              this.$message({
                message: '删除成功',
                type: 'success'
              });
              this.$store.dispatch('setListLoading', true);
              this.doPageQuery(this.refreshQuery);
            } else{
              this.$message({
                message: '删除失败!'+JSON.stringify(response.data),
                type: 'error'
              });
            }
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        });
      },
      doView(row){
        this.dialogLable = '查看信用信息';
        this.dialogVisible = true;
        this.dataForm = Object.assign({},row);
        this.thisView = true;
        this.viewButton = false;
      },
      // 表单提交
      submitForm () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              this.editLoading = true;
              let params = Object.assign({}, this.dataForm );
              console.log("新增修改数据："+params);
              if(this.isAddOrEdit == 'add'){
                this.$api.cusManage_naturalCus.addCreditInfo(params).then((res) => {
                  this.editLoading = false;
                  if(res && res.data && res.data.code == 200) {
                    this.$message({ message: '添加成功', type: 'success' })
                    this.dialogVisible = false;
                    this.doPageQuery(this.refreshQuery);
                  } else {
                    this.$message({message: '添加失败, ' + res.data.msg, type: 'error'})
                  }
                }).catch((res) =>{
                  console.error(JSON.stringify(res))
                })
              }else{
                this.$api.cusManage_naturalCus.updateCreditInfo(params).then((res) => {
                  this.editLoading = false;
                  if(res && res.data && res.data.code == 200) {
                    this.$message({ message: '修改成功', type: 'success' })
                    this.dialogVisible = false;
                    this.doPageQuery(this.refreshQuery);
                  } else {
                    this.$message({message: '修改失败, ' + res.data.msg, type: 'error'})
                  }
                }).catch((res) =>{
                  console.error(JSON.stringify(res));
                })
              }
            })
          }
        })
      },
      closeDialog(){
        this.dataForm = this.dataFormBlank;
      },
    },
    beforeCreate() {
      let type = this.$route.query.vueType;
      console.log(this.$route.query.vueType)
      if(type=="view"){
        this.isView = false;
      }else{
        this.isView = true;
      }
      console.log(this.isView)
    },
    mounted() {
      this.dataForm.partyId = this.$route.query.rowData.partyId;
    }
  }
</script>
