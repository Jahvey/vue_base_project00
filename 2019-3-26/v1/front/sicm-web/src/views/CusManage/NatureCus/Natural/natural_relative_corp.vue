<template>
  <div class="container">
    <legend>对私客户关系企业信息</legend>
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
            <el-form-item label="关联方国别：" prop="legalContry">
              <el-select v-model="dataForm.legalContry"  @change="enType" placeholder="请选择关联方国别" :disabled="thisView">
                <el-option label="中国" value="CHN"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否我行客户：" prop="iscout">
              <el-select v-model="dataForm.iscout" placeholder="请选择出是否我行客户" :disabled="thisView">
                <el-option label="否" value="0"></el-option>
                <el-option label="是" value="1"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关系人名称：" prop="partyName">
              <el-input v-model="dataForm.partyName" placeholder="关系人名称" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="客户类型：" prop="custType">
              <el-select v-model="dataForm.custType" placeholder="请选择客户类型" :disabled="thisView">
                <el-option label="公司客户" value="01"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证件类型：" prop="certificateTypeCd">
              <el-select v-model="dataForm.certificateTypeCd" placeholder="请选择证件类型" :disabled="thisView">
                <el-option label="居民身份证" value="10"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证件号码：" prop="certId">
              <el-input v-model="dataForm.certId" placeholder="证件号码" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证件签发日期：" prop="certBeginDate">
              <el-date-picker
                v-bind:disabled="thisView"
                v-model="dataForm.certBeginDate"
                type="date"
                align= "left"
                placeholder="选择证件签发日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="关联关系：" prop="appellation">
              <el-input v-model="dataForm.appellation" placeholder="关联关系" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证件到期日期：" prop="certEndDate">
              <el-date-picker
                v-bind:disabled="isLong"
                v-model="dataForm.certEndDate"
                type="date"
                align= "left"
                placeholder="选择证件到期日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="长期：">
              <el-checkbox v-model="isCheck" @change="isEndLong" :disabled="thisView"></el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="工作单位：" prop="partnercompany">
              <el-input v-model="dataForm.partnercompany" placeholder="工作单位" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="联系电话：" prop="partnerphonenum">
              <el-input v-model="dataForm.partnerphonenum" placeholder="联系电话" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注：" prop="remark">
              <el-input v-model="dataForm.remark" placeholder="备注" :disabled="thisView"></el-input>
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

        isLong: false, //是否长期
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
          legalContry: '',iscout: '',partyName: '',custType: '01',
          certificateTypeCd: '',certId: '',certBeginDate:'',appellation: '',certEndDate: '',partnercompany:'',
          partnerphonenum: '',remark: '',
          partyId:this.$route.query.rowData.partyId
        },
        dataFormBlank: {
          legalContry: '',iscout: '',partyName: '',custType: '01',
          certificateTypeCd: '',certId: '',certBeginDate:'',appellation: '',certEndDate: '',partnercompany:'',
          partnerphonenum: '',remark: '',
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
              {label: "关系人名称", prop: "partyName"},
              {label: "客户类型", prop: "partyTypeCd"},
              {label: "证件类型", prop: "certType"},
              {label: "证件号码", prop: "certNum"},
              {label: "关联关系", prop: "appellation"},
              {label: "工作单位", prop: "partnerCompany"},
              {label: "联系电话", prop: "partnerPhoneNum"},
              {label: "备注", prop: "remark"}
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
      //是否长期判断
      isEndLong: function(){
        if(this.isCheck==true){
          this.isLong = true
          this.dataForm.certEndDate = "9999-12-31"
        }else{
          this.isLong = false
          this.dataForm.certEndDate = ""
        }
      },
      doPageQuery(listQuery){
        let query =  Object.assign({},listQuery,{partyId:this.$route.query.rowData.partyId,cType:'corporation'});
        this.$api.cusManage_naturalCus.getNaturalRelativeList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询关系人信息公司信息信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询关系人信息公司信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询关系人信息公司信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
      // 显示新增界面
      doAdd: function () {
        this.dialogLable = '新增关系人信息公司信息';
        this.dialogVisible = true;
        this.isAddOrEdit = 'add';
        this.thisView = false;
        this.viewButton = true;
        this.isCheck = false;
      },
      doEdit(row){
        this.dialogLable = '编辑关系人信息公司信息';
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
          this.$api.cusManage_naturalCus.deleteNaturalRelative(row).then(res => {
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
        this.dialogLable = '查看关系人信息公司信息';
        this.dialogVisible = true;
        this.dataForm = Object.assign({},row);
        this.thisView = true;
        this.viewButton = false;
        this.isEndLong();
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
                this.$api.cusManage_naturalCus.addNaturalRelative(params).then((res) => {
                  this.editLoading = false;
                  if(res && res.data && res.data.code == 200) {
                    this.$message({ message: '添加成功', type: 'success' })
                    this.dialogVisible = false;
                    this.isCheck = false;
                    this.doPageQuery(this.refreshQuery);
                  } else {
                    this.$message({message: '添加失败, ' + res.data.msg, type: 'error'})
                  }
                }).catch((res) =>{
                  console.error(JSON.stringify(res))
                })
              }else{
                this.$api.cusManage_naturalCus.updateNaturalRelative(params).then((res) => {
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
