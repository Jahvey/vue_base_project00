<template>
  <div class="container" style="width:99%;margin-top:-25px;">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input lable="用户编号" v-model="filters.empcode" placeholder="用户编号"></el-input>
			</el-form-item>
			<el-form-item>
				<el-input label="用户名称" v-model="filters.empname" placeholder="用户名称"></el-input>
			</el-form-item>
			<el-form-item>
				<el-input label="机构号" v-model="filters.inorgid" type="hidden"></el-input>
			</el-form-item>
			<el-form-item>
                <popup-tree-input 
                  :data="deptData" :props="deptTreeProps" :prop="filters.inorgname" 
				  placeholder = "点击选择所属机构"
                  :node-key="''+filters.inorgid" :currentChangeHandle="handleTreeSelectChange">
                </popup-tree-input>
            </el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:role:view" type="primary" @click="findPage(null),changePageNum()"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:user:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
<!--表格内容栏-->
	<kt-table permsEdit="sys:user:edit" permsDelete=""
		:data="pageResult" :columns="columns"
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete" @handleRoleEdit="handleRoleEdit"
		:showRoleEdit = "showRoleEdit" >
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="75%" :visible.sync="dialogVisible" :close-on-click-modal="false">
		<el-row :gutter="20">
			<el-form :model="dataForm" label-width="120px" :rules="dataFormRules" ref="dataForm" :size="size"
				label-position="right">
          		<el-col :span="12">
					<el-form-item label="用户编号" prop="empcode">
						<el-input v-model="dataForm.empcode"></el-input>
					</el-form-item>
				</el-col>
          		<el-col :span="12">
					<el-form-item label="用户名称" prop="empname">
						<el-input v-model="dataForm.empname"></el-input>
					</el-form-item>
				</el-col>
          		<el-col :span="12">
					<el-form-item label="身份证号码">
						<el-input v-model="dataForm.cardno"></el-input>
					</el-form-item>
				</el-col>
          		<el-col :span="12">
					<el-form-item label="出生日期" prop="birthdate">
						<el-date-picker
							v-model="dataForm.birthdate"
							type="date"
							align= "left"
							placeholder="选择日期">
							</el-date-picker>
					</el-form-item>		
				</el-col>
          		<el-col :span="12">	
					<el-form-item label="性别" prop="gender">	
						<el-select clearable v-model="dataForm.gender">
						<el-option v-for="(value,key) in genders" :key="key" :label="value" :value="key">
						</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="所属机构号" prop="orgid">
						<el-input v-model="dataForm.orgid" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
          		<el-col :span="12">
					<el-form-item label="所属机构" prop="inorgname">
						<popup-tree-input 
							:data="deptData" :props="deptTreeProps" :prop="dataForm.inorgname==null?'':dataForm.inorgname" 
							placeholder = "点击选择所属机构"
							:node-key="''+dataForm.inorgname" :currentChangeHandle="deptTreeCurrentChangeHandle">
						</popup-tree-input>
					</el-form-item>
				</el-col>
				<el-col :span="12">	
					<el-form-item label="所在职位" prop="position">	
						<el-select clearable v-model="dataForm.position">
						<el-option v-for="(value,key) in yesOrNo" :key="key" :label="value" :value="key">
						</el-option>
						</el-select>
					</el-form-item>
				</el-col>
			</el-form>
		</el-row>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="dialogVisible = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
	<el-dialog title="角色配置" width="75%" :visible.sync="roleEditDialogVisible" :close-on-click-modal="false">
		<div>
		<csc-el-transfer :pageDef="pageDef" @doQuery="doQuery">
    	</csc-el-transfer>
		<el-button :size="size" type="primary" @click.native="submitRoleBox">{{$t('action.submit')}}</el-button>

		</div>
	</el-dialog>
  </div>
</template>

<script>
import PopupTreeInput from "@/components/PopupTreeInput"
import CscElTransfer from "@/components/CscElTransfer/CscElTransfer"
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import { format } from "@/utils/datetime"
import commonUtil from "@/utils/commonUtil"
import TableTreeColumn from '@/views/Core/TableTreeColumn'
import {getAllOrgTree} from '@/utils/commonSysManageUtil'
import enums from '@/utils/enums'
export default {
	components:{
		PopupTreeInput,
		KtTable,
		KtButton,
		CscElTransfer
	},
	data() {
		return {
			showRoleEdit:true,
			size: 'small',
			filters: {
				empname: '',
				empcode: '',
				empstatus: '',
				orgcode:''
			},
			columns: [
				{prop:"empcode", label:"用户编号", minWidth:50},
				{prop:"empname", label:"用户名", minWidth:120},
				{prop:"inorgname", label:"所属机构", minWidth:120},
				{prop:"empstatus", label:"用户状态", minWidth:100},
				{prop:"status", label:"使用现状", minWidth:120}
			],
			pageRequest: { pageNum: 1, pageSize: 10 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			dialogVisible: false, // 新增编辑界面是否显示
			roleEditDialogVisible: false,//角色配置界面是否显示
			editLoading: false,
			dataFormRules: {
				name: [
					{ required: true, message: '请输入用户名', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据
			dataForm: {
				empcode: '',empname: '',empcardno: '',empbirthdate: '',
				gender: '',orgid: '',inorgname: '',position: ''
			},
			deptData: getAllOrgTree(),
			deptTreeProps: {
				label: 'remark',
				children: 'children'
			},
			roles: [],
			genders: enums.genderCd,yesOrNo: enums.yesOrNo,
			pageDef:{
				isManyButton: true,//2019-1-17 后期修改transfer 下的main.vue 可以支持多个按钮
				showButton: false,//是否展示按钮
				buttonTexts:["取消授权","授权"],
				titles: ['未授予角色', '已授予角色'],
				// name: {key: 'value',label: 'desc'},//设置别名
				name: {key: 'roleid',label: 'rolename'},//设置别名
				totalData: [],//两边总共的数据  应该是组件自己去区分加载
				rightData: [],//右侧选择框值 调用服务查询  未有角色
				leftData: [] //左侧选择框值   已有角色
			}
		}
	},
	methods: {
		changePageNum: function(){
			this.pageRequest.pageNum = 1
		},
		// 获取分页数据
		findPage: function (data) {
			
			if(data !== null) {
				this.pageRequest = data.pageRequest
			}
			commonUtil.extend(this.pageRequest,this.filters)
			this.$api.user.findPage(this.pageRequest).then((res) => {
        		console.log('userRes:'+JSON.stringify(res.data))
				this.pageResult = res.data.data
				//this.findUserRoles()
			}).catch((res) => {
				this.$message({message: '初始查询用户信息失败, 错误信息：' + res, type: 'error'})
				console.error('初始查询用户信息失败, 错误信息：' + res)
            }).then(data!=null?data.callback:'')
		},
		// 加载用户角色信息
		findUserRoles: function () {
			this.$api.role.findAll().then((res) => {
				// 加载角色集合
				this.roles = res.data	
			})
		},
		// 批量删除
		handleDelete: function (dataFromKtTable) {
			let params = {"empid": dataFromKtTable.row.empid}
                this.$api.user.batchDelete(params).then( res => {
                    console.log("userDlt",JSON.stringify(res))
                    dataFromKtTable.callback(res)
            }).catch((res) =>{
                console.error(JSON.stringify(res))
            })
		},
		handleRoleEdit: function(row){
			this.row = row
			this.doQuery(row.userid)
		},
		// 显示新增界面
		handleAdd: function () {
			this.dialogVisible = true
			this.operation = true
			this.dataForm = {
			}
		},
		// 显示编辑界面
		handleEdit: function (params) {
			this.dialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
		},
		    // 表单提交
        submitForm () {
            this.$refs['dataForm'].validate((valid) => {
                if (valid) {
                    this.$confirm('确认提交吗？', '提示', {}).then(() => {
                        this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						console.info(JSON.stringify(params))
                        if(this.operation){
                            this.$api.user.save(params).then((res) => {
                                this.editLoading = false

                                if(res && res.data && res.data.code == 200) {
                                    this.$message({ message: '添加成功', type: 'success' })
                                    this.dialogVisible = false
                                    this.$refs['dataForm'].resetFields()
                                    this.findPage(null)
                                } else {
                                    this.$message({message: '添加失败, ' + res.data.msg, type: 'error'})
                                }
                            }).catch((res) =>{
                                console.error(JSON.stringify(res))
                            })
                        }else{
                            this.$api.user.edit(params).then((res) => {
                                this.editLoading = false
                                if(res && res.data && res.data.code == 200) {
                                    this.$message({ message: '修改成功', type: 'success' })
                                    this.dialogVisible = false
                                    this.$refs['dataForm'].resetFields()
                                    this.findPage(null)
                                } else {
                                    this.$message({message: '修改失败, ' + res.data.msg, type: 'error'})
                                }
                            }).catch((res) =>{
                                console.error(JSON.stringify(res))
                            })
                        }
                    })
                }
            })
        },
		// 菜单树选中
      	deptTreeCurrentChangeHandle (data, node) {
			console.log(data.orgid,data.orgname,data.remark)
        	this.dataForm.inorgname = data.remark
        	this.dataForm.orgid = data.orgid
		},
		// 时间格式化
      	dateFormat: function (row, column, cellValue, index){
          	return format(row[column.property])
      	},
		handleTreeSelectChange (data, node) {

			  console.log(data.orgid,data.orgname,data.remark,data.parentorgid,data.parentorgname)
			  this.filters.inorgname = data.remark
			  this.filters.inorgid = data.orgid
			 // this.filters.inorgid = data.orgid
		},
		test() {

		},
		submitRoleBox: function(){
			let userInfo= JSON.parse(sessionStorage.getItem("userInfo"))
			let params={
				orgid: userInfo.orgid,
				operatorid: userInfo.operatorid,
				roles: this.pageDef.rightData
			}
			this.$api.user.insertOperatorRole(params).then((res) => {
				if(res && res.data && res.data.code == 200){
					this.$message({ message: '用户角色配置成功', type: 'success' })
					this.roleEditDialogVisible = false
				}else{
					this.$message({ message: res.data.msg, type: 'error' })
				}
			}).catch((res) =>{
				console.error(JSON.stringify(res))
			})

		},
		doQuery(userid) {//一次查询能否把左右两侧数据都查询出来
			let params = {userId: userid}
			this.$api.role.getRolesSelectBoxData(params).then((res) => {
                                if(res && res.data && res.data.code == 200) {
									this.roleEditDialogVisible = true
									this.pageDef.rightData = res.data.rightData
									this.pageDef.totalData = res.data.allData
                                }else{
									this.$message({ message: res.data.msg, type: 'error' })
								}
                            }).catch((res) =>{
                                console.error(JSON.stringify(res))
                            })
		}
	},
	mounted() {
	}
}
</script>

<style scoped>

</style>