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
            <el-form-item label="事件类型：" prop="eventTypeCd">
              <el-select v-model="dataForm.eventTypeCd" placeholder="请选择事件类型" :disabled="thisView">
                <el-option label="重大事件" value="1"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发生日期：" prop="happenDate">
              <el-date-picker
                v-bind:disabled="thisView"
                v-model="dataForm.happenDate"
                type="date"
                align= "left"
                placeholder="选择发生日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="事件描述及原因：" prop="eventState">
              <el-input v-model="dataForm.eventState" placeholder="事件描述及原因" :disabled="thisView"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-if="isAdd" label="登记日期：" prop="createTime">
              <el-date-picker
                disabled
                v-model="dataForm.createTime"
                type="date"
                align= "left">
              </el-date-picker>
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
        isAdd:true,

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
          eventTypeCd: '',happenDate: '',eventState: '',createTime: new Date(),
          partyId:this.$route.query.rowData.partyId
        },
        dataFormBlank: {
          eventTypeCd: '',happenDate: '',eventState: '',createTime: new Date(),
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
              {label: "事件类型", prop: "eventTypeCd"},
              {label: "发生日期", prop: "happenDate",isDate:true},
              {label: "事件描述及原因", prop: "eventState"}
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
        this.$api.cusManage_naturalCus.getImpornantEventList(query).then((res) => {
          console.log(JSON.stringify(res))
          if(res && res.data && res.data.code == 200){//返回数据成功
            let myEntity = {};
            myEntity.total= res.data.data.total;
            myEntity.data = res.data.data.list;
            this.entity = myEntity;
            this.$store.dispatch('setListLoading', false);
          } else{
            this.$message({
              message: '查询重大事件信息失败！',
              type: 'error'
            });
          }
          this.$store.dispatch('setListLoading', false);//切记查询成功后取消遮罩
        }).catch((res) => {
          this.$message({message: '初始查询重大事件信息失败, 错误信息：' + res, type: 'error'})
          console.error('初始查询重大事件信息失败, 错误信息：' + res)
        }).then(data!=null?data.callback:'')
      },
      // 显示新增界面
      doAdd: function () {
        this.dialogLable = '新增重大事件';
        this.dialogVisible = true;
        this.isAddOrEdit = 'add';
        this.thisView = false;
        this.viewButton = true;
        this.isAdd = true;
      },
      doEdit(row){
        this.dialogLable = '编辑重大事件';
        this.dialogVisible = true;
        this.dataForm = Object.assign({},row);
        this.isAddOrEdit = 'edit';
        this.thisView = false;
        this.viewButton = true;
        this.isAdd = false;
        this.isEndLong();
      },
      doDelete(row,listquery,index){
        this.$confirm('是否确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          this.$api.cusManage_naturalCus.deleteImpornantEvent(row).then(res => {
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
        this.dialogLable = '查看重大事件';
        this.dialogVisible = true;
        this.dataForm = Object.assign({},row);
        this.thisView = true;
        this.isAdd = false;
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
                this.$api.cusManage_naturalCus.addImpornantEvent(params).then((res) => {
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
                this.$api.cusManage_naturalCus.updateImpornantEvent(params).then((res) => {
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
