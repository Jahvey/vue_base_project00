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
            <el-form-item label="经营项目：" prop="dealproj">
              <el-input v-model="dataForm.dealproj" placeholder="经营项目" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经营字号：" prop="dealbrand">
              <el-input v-model="dataForm.dealbrand" placeholder="经营字号" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册类型：" prop="licetype">
              <el-select v-model="dataForm.licetype"  @change="enType" placeholder="请选择注册类型" :disabled="thisView">
                <el-option label="国有" value="01"></el-option>
                <el-option label="个体户" value="02"></el-option>
                <el-option label="外资" value="03"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="成立日期：" prop="comedate">
              <el-date-picker
                v-bind:disabled="thisView"
                v-model="dataForm.comedate"
                type="date"
                align= "left"
                placeholder="选择成立日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="营业执照号：" prop="liceid">
              <el-input v-model="dataForm.liceid" placeholder="营业执照号" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="注册地址：" prop="liceaddr">
              <el-input v-model="dataForm.liceaddr" placeholder="注册地址" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经营范围：" prop="dealscope">
              <el-input v-model="dataForm.dealscope" placeholder="经营范围" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经营场所：" prop="dealaddr">
              <el-input v-model="dataForm.dealaddr" placeholder="经营场所" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="经营场所性质：" prop="dealaddrkind">
              <el-select v-model="dataForm.dealaddrkind"  @change="enType" placeholder="经营场所性质" :disabled="thisView">
                <el-option label="自有" value="01"></el-option>
                <el-option label="租赁" value="02"></el-option>
                <el-option label="其他" value="03"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="年营业额：" prop="yearamt">
              <el-input v-model="dataForm.yearamt" placeholder="年营业额" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col><el-col :span="12">
          <el-form-item label="雇员人数：" prop="empnum">
            <el-input v-model="dataForm.empnum" placeholder="雇员人数" :disabled="thisView"></el-input>
          </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="月均销售额：" prop="monthavesell">
              <el-input v-model="dataForm.monthavesell" placeholder="月均销售额" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="月均经营费用：" prop="monthavecost">
              <el-input v-model="dataForm.monthavecost" placeholder="月均经营费用" :disabled="thisView"></el-input>
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
        isView:true,//是查看隐藏编辑删除按钮
        thisView:false,//查看disabled
        viewButton:true,

        disableQueryForm:true,
        entity: {},
        selectedRow:{},
        // 界面数据
        dataForm: {
          dealproj: '',dealbrand: '',licetype: '',comedate: '',
          liceid: '',liceaddr: '',dealscope:'',dealaddr: '',dealaddrkind: '',yearamt:'',
          empnum: '',monthavesell: '',monthavecost:'',lastchandate: '',lastchanperson: '李谭荔',
          partyId:this.$route.query.rowData.partyId
        },
        dataFormBlank: {
          dealproj: '',dealbrand: '',licetype: '',comedate: '',
          liceid: '',liceaddr: '',dealscope:'',dealaddr: '',dealaddrkind: '',yearamt:'',
          empnum: '',monthavesell: '',monthavecost:'',lastchandate: '',lastchanperson: '李谭荔',
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
              {label: "经营项目", prop: "dealproj"},
              {label: "经营字号", prop: "dealbrand", isFormat: true},
              {label: "注册类型", prop: "licetype"},
              {label: "成立日期", prop: "comedate", isDate:true},
              {label: "营业执照号", prop: "liceid"},
              {label: "注册地址", prop: "liceaddr"},
              {label: "经营范围", prop: "dealscope"},
              {label: "经营场所", prop: "dealaddr"},
              {label: "经营场所性质", prop: "dealaddrkind"},
              {label: "年营业额", prop: "yearamt"},
              {label: "雇员人数", prop: "empnum"},
              {label: "月均销售额", prop: "monthavesell"},
              {label: "月均经营费用", prop: "monthavecost"},
              {label: "最后修改日期", prop: "lastchandate"},
              {label: "最后修改人", prop: "lastchanperson"}
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
        this.$api.cusManage_naturalCus.getNaturalBusinessList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询经营信息信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询经营信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询经营信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
      // 显示新增界面
      doAdd: function () {
        this.dialogLable = '新增经营信息';
        this.dialogVisible = true;
        this.isAddOrEdit = 'add';
        this.thisView = false;
        this.viewButton = true;
      },
      doEdit(row){
        this.dialogLable = '编辑经营信息';
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
          this.$api.cusManage_naturalCus.deleteNaturalBusiness(row).then(res => {
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
        this.dialogLable = '查看经营信息';
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
                this.$api.cusManage_naturalCus.addNaturalBusiness(params).then((res) => {
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
                this.$api.cusManage_naturalCus.updateNaturalBusiness(params).then((res) => {
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
