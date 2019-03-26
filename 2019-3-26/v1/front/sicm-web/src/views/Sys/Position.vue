<template>
  <div class="container" style="width:99%;margin-top:-25px;">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.posiname" placeholder="岗位名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:dept:view" type="primary" @click="changePageNum(),findPositionList(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:dept:add" type="primary" @click="handleAdd"/>
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:user:edit" permsDelete="sys:user:delete"
		:data="pageResult" :columns="columns"
		@findPage="findPositionList" @handleEdit="handleEdit" @handleDelete="handleDelete"
		:operaButtons = "[]" >
	</kt-table>
    <!-- 新增修改界面 -->
    <el-dialog :title="!dataForm.positionid ? '新增' : '修改'" width="80%" :visible.sync="dialogVisible" :close-on-click-modal="false">
      <el-row :gutter="20">
        <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="submitForm()" 
          label-width="90px" :size="size" style="text-align:left;">
          <el-col :span="12">
            <el-form-item label="岗位编码" prop="posicode">
              <el-input v-model="dataForm.posicode"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="岗位名称" prop="posiname">
                <el-input v-model="dataForm.posiname"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="说明" prop="posistate">
              <el-input type="textarea" v-model="dataForm.posistate" placeholder="机构号"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <span slot="footer" class="dialog-footer">
        <el-button :size="size"  @click="dialogVisible = false">{{$t('action.cancel')}}</el-button>
        <el-button :size="size"  type="primary" @click="submitForm()">{{$t('action.comfirm')}}</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import commonUtil from "@/utils/commonUtil"
export default {
	components:{
        KtButton,
		KtTable
	},
	data() {
		return {
			size: 'small',
            loading: false,
            true: true,
			filters: {
				posiname: ''
            },
            columns: [
				{prop:"posicode", label:"岗位编码", minWidth:50},
				{prop:"posiname", label:"岗位名称", minWidth:120},
				{prop:"posistate", label:"岗位描述", minWidth:120}
			],
            operation: false, // true:新增, false:编辑
			dialogVisible: false, // 新增编辑界面是否显示
			editLoading: false,
            operaType: '',
            pageRequest: { pageNum: 1, pageSize: 10 },
            dataForm: {
                positionid: '',
                posicode: '',
                posiname: '',
                posistate: ''
            },
            pageResult: {},
            dataRule: {
                posicode: [
                { required: true, message: '岗位编码不能为空', trigger: 'blur' }
                ],
                posiname: [
                { required: true, message: '岗位名称不能为空', trigger: 'change' }
                ],
                posistate: [
                {required: true, message: "岗位描述不能为空", trigger: 'change'}
                ]
            }
		}
	},
	methods: {
        //点击查询默认获取第一页数据
        changePageNum: function(){
			this.pageRequest.pageNum = 1
		},
		// 获取数据
        findPositionList: function (data) {
            if(data !== null) {
				this.pageRequest = data.pageRequest
			}else{
                this.loading = true
            }
            commonUtil.extend(this.pageRequest,this.filters)
			this.$api.position.findPositionList(this.pageRequest).then((res) => {
                console.log('positionRes:'+JSON.stringify(res.data))
                this.pageResult = res.data.data
			}).catch((res) => {
                this.$message({message: '初始查询岗位信息失败, 错误信息：' + res, type: 'error'})
				console.error('初始查询岗位信息失败, 错误信息：' + res)
            }).then(
                data!=null?data.callback:this.loading = false
            )
        },
	
        // 显示新增界面
        handleAdd: function () {
            this.dialogVisible = true
            this.operaType = 'add'
            this.dataForm = {
                positionid: '',
                posicode: '',
                posiname: '',
                posistate: ''
            }
        },
        // 显示编辑界面
        handleEdit: function (row) {
            this.dialogVisible = true
            this.operaType = 'update'
            Object.assign(this.dataForm, row.row);
            console.log(JSON.stringify(this.dataForm))
        },
        // 删除
        handleDelete (dataFromKtTable) {
            let params = {"positionid": dataFromKtTable.row.positionid}
                this.$api.position.batchDelete(params).then( res => {
                    console.log("positionDlt",JSON.stringify(res))
                    dataFromKtTable.callback(res)
            }).catch((res) =>{
                console.info(JSON.stringify(res))
                this.$message({message: '删除岗位失败,错误信息：' + res, type: 'error'})
            })
        },
        // 表单提交
        submitForm () {
            this.$refs['dataForm'].validate((valid) => {
                if (valid) {
                    this.$confirm('确认提交吗？', '提示', {}).then(() => {
                        this.editLoading = true
                        let params = Object.assign({}, this.dataForm)
                        if('add' === this.operaType){
                            this.$api.position.save(params).then((res) => {
                                this.editLoading = false

                                if(res && res.data && res.data.code == 200) {
                                    this.$message({ message: '添加岗位成功', type: 'success' })
                                    this.dialogVisible = false
                                    this.$refs['dataForm'].resetFields()
                                    this.findPositionList(null)
                                } else {
                                    this.$message({message: '添加岗位失败, ' + res.data.msg, type: 'error'})
                                }
                            }).catch((res) =>{
                                console.error(JSON.stringify(res))
                            })
                        }
                        if('update' === this.operaType){
                            this.$api.position.edit(params).then((res) => {
                                this.editLoading = false
                                if(res && res.data && res.data.code == 200) {
                                    this.$message({ message: '修改岗位成功', type: 'success' })
                                    this.dialogVisible = false
                                    this.$refs['dataForm'].resetFields()
                                    this.findPositionList(null)
                                } else {
                                    this.$message({message: '修改岗位失败, ' + res.data.msg, type: 'error'})
                                }
                            }).catch((res) =>{
                                console.info(JSON.stringify(res))
                                this.$message({message: '修改岗位失败,错误信息：' + res, type: 'error'})
                            })
                        }
                    })
                }
            })
        }
    },
	mounted() {
       // this.findPositionList()
	}
}
</script>

<style scoped>

</style>