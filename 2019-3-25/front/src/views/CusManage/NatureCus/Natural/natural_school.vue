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
            <el-form-item label="高校名称：" prop="collegename">
              <el-input v-model="dataForm.collegename" placeholder="高校名称" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="高校地址：" prop="collegeaddr">
              <el-input v-model="dataForm.collegeaddr" placeholder="高校地址" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="院系名称：" prop="institutename">
              <el-input v-model="dataForm.institutename" placeholder="院系名称" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="院校类型：" prop="collegetype">
              <el-select v-model="dataForm.collegetype"  @change="enType" placeholder="请选择院校类型" :disabled="thisView">
                <el-option label="重点本科院校" value="1"></el-option>
                <el-option label="普通本科院校" value="2"></el-option>
                <el-option label="独立学院" value="3"></el-option>
                <el-option label="高职高专院校" value="4"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="就读学位：" prop="educsign">
              <el-select v-model="dataForm.educsign"  @change="enType" placeholder="请选择就读学位" :disabled="thisView">
                <el-option label="其他" value="0"></el-option>
                <el-option label="名誉博士" value="1"></el-option>
                <el-option label="博士" value="2"></el-option>
                <el-option label="硕士" value="3"></el-option>
                <el-option label="学士" value="4"></el-option>
                <el-option label="未知" value="9"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="专业名称：" prop="subjectname">
              <el-input v-model="dataForm.subjectname" placeholder="专业名称" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="毕业年份：" prop="graduateyear">
              <el-date-picker
                v-bind:disabled="thisView"
                v-model="dataForm.graduateyear"
                type="date"
                align= "left"
                placeholder="选择毕业年份">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="国家或地区：" prop="nationalityCd">
              <el-select v-model="dataForm.nationalityCd"  @change="enType" placeholder="请选择国家或地区" :disabled="thisView">
                <el-option label="中国" value="CHN"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="省/自治区/直辖市：" prop="provinceCd">
              <el-select v-model="dataForm.provinceCd"  @change="enType" placeholder="请选择省/自治区/直辖市" :disabled="thisView">
                <el-option label="中国" value="CHN"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="市/自治州：" prop="cityCd">
              <el-select v-model="dataForm.cityCd"  @change="enType" placeholder="请选择市/自治州" :disabled="thisView">
                <el-option label="中国" value="CHN"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="区/县：" prop="district">
              <el-select v-model="dataForm.district"  @change="enType" placeholder="请选择区/县" :disabled="thisView">
                <el-option label="中国" value="CHN"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="行政区划代码：" prop="areacode">
              <el-input v-model="dataForm.areacode" placeholder="行政区划代码" :disabled="thisView"></el-input>
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
          collegename: '',collegeaddr: '',institutename: '',collegetype: '',
          educsign: '',subjectname: '',graduateyear:'',nationalityCd: '',provinceCd: '',cityCd:'',
          district: '',areacode: '',lastchandate: '',lastchanperson: '李谭荔',
          partyId:this.$route.query.rowData.partyId
        },
        dataFormBlank: {
          collegename: '',collegeaddr: '',institutename: '',collegetype: '',
          educsign: '',subjectname: '',graduateyear:'',nationalityCd: '',provinceCd: '',cityCd:'',
          district: '',areacode: '',lastchandate: '',lastchanperson: '李谭荔',
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
              {label: "高校名称", prop: "collegename"},
              {label: "高校地址", prop: "collegeaddr"},
              {label: "院系名称", prop: "institutename"},
              {label: "院校类型", prop: "collegetype"},
              {label: "就读学位", prop: "educsign"},
              {label: "专业名称", prop: "subjectname"},
              {label: "毕业年份", prop: "graduateyear"},
              {label: "最后修改日期", prop: "lastchandate"},
              {label: "最后修改人", prop: "lastchanperson"},
              {label: "行政区划代码", prop: "areacode"}
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
        this.$api.cusManage_naturalCus.getNaturalSchoolList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询高校信息信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询高校信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询高校信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
      // 显示新增界面
      doAdd: function () {
        this.dialogLable = '新增高校信息';
        this.dialogVisible = true;
        this.isAddOrEdit = 'add';
        this.thisView = false;
        this.viewButton = true;
      },
      doEdit(row){
        this.dialogLable = '编辑高校信息';
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
          this.$api.cusManage_naturalCus.deleteNaturalSchool(row).then(res => {
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
        this.dialogLable = '查看高校信息';
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
                this.$api.cusManage_naturalCus.addNaturalSchool(params).then((res) => {
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
                this.$api.cusManage_naturalCus.updateNaturalSchool(params).then((res) => {
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

