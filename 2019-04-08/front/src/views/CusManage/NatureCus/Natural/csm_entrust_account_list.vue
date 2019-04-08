<template>
  <div class="container">
    <csc-single-button-table
      :pageDef="pageDef" :disableQueryForm="disableQueryForm"
      :entity="entity"
      @pageQuery="doPageQuery"
      @doAdd="doAdd"
      @doEdit="doEdit"
      @doDelete="doDelete"
      @doView="doView"
    >
    </csc-single-button-table>
    <!-- 新增编辑查看界面-->
    <el-dialog :title="dialogLable" align="center" width="50%":visible.sync="dialogVisible" :append-to-body='true'
               :close-on-click-modal="false" @close='closeDialog'>
      <el-row :gutter="20">
        <el-form :model="dataForm" label-width="120px" ref="dataForm" :size="size"
                 label-position="right">
          <el-col :span="12">
            <el-form-item label="账户名称：" prop="accName">
              <el-input v-model="dataForm.accName" placeholder="账户名称" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="委托项目名称：" prop="entrustProjectName">
              <el-input v-model="dataForm.entrustProjectName" placeholder="委托项目名称" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="委托贷款类型：" prop="entrustType">
              <el-select v-model="dataForm.entrustType"  @change="enType" placeholder="请选择委托贷款类型" :disabled="thisView">
                <el-option label="对公委托贷款" value="01"></el-option>
                <el-option label="公积金委托贷款" value="02"></el-option>
                <el-option label="个人委托贷款" value="03"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-if="isGold" label="委托存款账号：" prop="entrustAcc">
              <el-input v-model="dataForm.entrustAcc" placeholder="委托存款账号" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-if="isGold" label="委托人收本账号：" prop="entrustReturnPrincipalAcc">
              <el-input v-model="dataForm.entrustReturnPrincipalAcc" placeholder="委托人收本账号" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-if="isGold" label="委托人收息账号：" prop="entrustReturnInterestAcc">
              <el-input v-model="dataForm.entrustReturnInterestAcc" placeholder="委托人收息账号" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
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
        isGold:true, //是公积金类型隐藏后三项
        isView:true,//是查看隐藏编辑删除按钮
        thisView:false,//查看disabled
        viewButton:true,

        disableQueryForm:true,
        entity: {},
        selectedRow:{},
        // 界面数据
        dataForm: {
          accName: '',entrustProjectName: '',entrustType: '',entrustAcc: '',
          entrustReturnPrincipalAcc: '',entrustReturnInterestAcc: '',partyId:''
        },
        dataFormBlank: {
          accName: this.$route.query.rowData.partyName,entrustProjectName: '',entrustType: '',entrustAcc: '',
          entrustReturnPrincipalAcc: '',entrustReturnInterestAcc: '',partyId:this.$route.query.rowData.partyId
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
              {label: "账户名称", prop: "accName"},
              {label: "委托项目名称", prop: "entrustProjectName", isFormat: true},
              {label: "委托存款账号", prop: "entrustAcc"},
              {label: "委托贷款基金账号", prop: "entrustLoanAcc"},
              {label: "委托贷款收息账号", prop: "entrustReturnAcc"},
              {label: "委托人收本账号", prop: "entrustReturnPrincipalAcc"},
              {label: "委托人收息账号", prop: "entrustReturnInterestAcc"}
            ]
          },
          buttons: [{label:"新增",type:"primary",funcName:"doAdd",visible:this.isView}],
          rowButtons:[{label:"编辑",type:"primary",funcName:"doEdit",visible:this.isView},
                       {label:"删除",type:"danger",funcName:"doDelete",visible:this.isView},
                       {label:"查看",type:"success",funcName:"doView",visible:true}
          ]
        }
      }
    },
    methods: {
      doPageQuery(listQuery){
        let query =  Object.assign({},listQuery,{partyId:this.$route.query.rowData.partyId});
        this.$api.cusManage_naturalCus.getCsmEntrustAccountList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询委托方账户信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询委托方账户信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询委托方账户信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
      // 显示新增界面
      doAdd: function () {
        this.dialogLable = '新增委托方账户';
        this.dialogVisible = true;
        this.isAddOrEdit = 'add';
        this.thisView = false;
        this.viewButton = true;
      },
      doEdit(row){
        this.dialogLable = '编辑委托方账户';
        this.dialogVisible = true;
        this.dataForm = Object.assign({},row);
        this.isAddOrEdit = 'edit';
        this.thisView = false;
        this.viewButton = true;
        this.enType();
      },
      doDelete(row,listquery,index){
        this.$confirm('是否确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          this.$api.cusManage_naturalCus.deleteEntrustAccount(row).then(res => {
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
        this.dialogLable = '查看委托方账户';
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
                this.$api.cusManage_naturalCus.addEntrustAccount(params).then((res) => {
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
                this.$api.cusManage_naturalCus.updateEntrustAccount(params).then((res) => {
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
      //委托贷款类型
      enType: function(){
        let type = this.dataForm.entrustType;
        if(type=="02"){
          this.isGold = false;
        }else{
          this.isGold = true;
        }
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
       this.dataForm.accName = this.$route.query.rowData.partyName;
       this.dataForm.partyId = this.$route.query.rowData.partyId;
     }
  }
</script>
