<template>
  <div class="container" style="width:99%;margin-top:-25px;">
	<el-collapse v-model="activeNames">
	<el-collapse-item title="角色管理" class="menu-container menu-header" name="1">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.rolename" placeholder="角色名"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:role:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:role:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:role:edit" permsDelete="sys:role:delete" :highlightCurrentRow="true" :stripe="false"
		:data="pageResult" :columns="columns" :showBatchDelete="false" @handleCurrentChange="handleRoleSelectChange"
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete" :operaButtons="operaButtons">
	</kt-table>
	<!-- </el-col> -->
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="dialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="角色编号" prop="roleid">
				<el-input v-model="dataForm.roleid" :disabled="getIsAdd(operaType)" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="角色名称" prop="rolename">
				<el-input v-model="dataForm.rolename" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="dialogVisible = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
	</el-collapse-item>
	
	<el-collapse-item title="角色菜单" name="2">
	<!--角色菜单，表格树内容栏-->
	<div class="menu-container">
		<div class="menu-header">
			<span><B>角色菜单授权</B></span>
		</div>
		<el-tree 
			class="filter-tree"
			:data="menuData" 
			size="mini" 
			default-expand-all
			show-checkbox node-key="menuid" 
			:props="defaultProps"
			style="width: 100%;pading-top:20px;" 
			ref="menuTree" 
			:render-content="renderContent"
			v-loading="menuLoading" 
			element-loading-text="拼命加载中" 
			:check-strictly="true"
			@check-change="handleMenuCheckChange">
		</el-tree>
		<div style="float:left;padding-left:24px;padding-top:12px;padding-bottom:4px;">
			<el-checkbox v-model="checkAll" @change="handleCheckAll" :disabled="this.selectRole.roleid == null"><b>全选</b></el-checkbox>
			<kt-button label="展开" type="primary" @click="openAllNodes(true)"/>
			<kt-button label="收起" type="primary" @click="openAllNodes(false)"/>
		</div>
		<div style="float:right;padding-right:15px;padding-top:4px;padding-bottom:4px;">
			<kt-button :label="$t('action.reset')" perms="sys:role:edit" type="primary" @click="resetSelection" 
				:disabled="this.selectRole.roleid == null"/>
			<kt-button :label="$t('action.submit')" perms="sys:role:edit" type="primary" @click="submitAuthForm" 
				:disabled="this.selectRole.roleid == null" :loading="authLoading"/>
		</div>
	</div>
	</el-collapse-item>
	</el-collapse>
  </div>
</template>

<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import TableTreeColumn from '@/views/Core/TableTreeColumn'
import { format } from "@/utils/datetime"
import commonUtil from "@/utils/commonUtil"
export default {
	components:{
		KtTable,
		KtButton,
		TableTreeColumn
	},
	data() {
		return {
			activeNames: ['1','2'],
			size: 'small',
			filters: {
				rolename: ''
			},
			columns: [
				{prop:"roleid", label:"角色编号", minWidth:50},
				{prop:"rolename", label:"角色名", minWidth:120}
			],
			operaButtons:[
				{label:"权限",operaFn:function(index,row){this.activeNames = ['2']}}
			]
				
			,
			pageRequest: { pageNum: 1, pageSize: 10 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			dialogVisible: false, // 新增编辑界面是否显示
			editLoading: false,
			dataFormRules: {
				rolename: [
					{ required: true, message: '请输入角色名称', trigger: 'blur' }
				],
				roleid: [
					{ required: true, message: '请输入角色编号', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据
			dataForm: {
				id: 0,
				name: '',
				remark: ''
			},
			selectRole: {},
			menuData: [],
			menuSelections: [],
			menuLoading: false,
			authLoading: false,
			checkAll: false,
			currentRoleMenus: [],
			defaultProps: {
				children: 'children',
				label: 'name'
			},
			operaType: ''
		}
	},
	methods: {
		//判断编辑页面是否为编辑或新增。用于控制输入框disabled属性
		getIsAdd : function(operaType){
			return operaType == 'edt' ? true : false
		},
		// 获取数据
        findPage: function (data) {
            if(data !== null) {
				this.pageRequest = data.pageRequest
			}else{
                this.loading = true
            }
            commonUtil.extend(this.pageRequest,this.filters)
			this.$api.role.findPage(this.pageRequest).then((res) => {
        		console.log('roleRes:'+JSON.stringify(res.data))
                this.pageResult = res.data.data
			}).catch((res) => {
                this.$message({message: '初始查询岗位信息失败, 错误信息：' + res, type: 'error'})
				console.error('初始查询岗位信息失败, 错误信息：' + res)
            }).then(
                data!=null?data.callback:this.loading = false
            )
		},
		findMenuTreeData: function(){
			this.$api.menu.findNavTree().then(res => {
				this.menuData = res.data.data
				console.info(JSON.stringify(this.menuData))
			})
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.role.batchDelete(data.params).then(data.callback)
		},
		// 显示新增界面
		handleAdd: function () {
			this.dialogVisible = true
			this.operation = true
			this.dataForm = {
				id: 0,
				name: '',
				remark: ''
			}
			this.operaType = 'add'
		},
		// 显示编辑界面
		handleEdit: function (params) {
			this.dialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
			this.operaType = 'edt'
		},
		// 编辑
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						this.$api.role.save(params).then((res) => {
							this.editLoading = false
							if(res.code == 200) {
								this.$message({ message: '操作成功', type: 'success' })
								this.dialogVisible = false
								this.$refs['dataForm'].resetFields()
							} else {
								this.$message({message: '操作失败, ' + res.msg, type: 'error'})
							}
							this.findPage(null)
						})
					})
				}
			})
		},
		// 获取数据
		findTreeData: function () {
			this.menuLoading = true
			this.$api.menu.testFindMenuTree().then((res) => {
				this.menuData = res.data
				this.menuLoading = false
			})
		},
		// 角色选择改变监听
		handleRoleSelectChange(val) {
			if(val == null || val.val == null) {
				return
			}
			this.selectRole = val.val
			this.$api.role.findRoleMenus({'roleId':val.val.roleid}).then((res) => {
				this.currentRoleMenus = res.data.data
				this.$refs.menuTree.setCheckedNodes(res.data.data)
			})
		},
		// filterNode(value, data) {
		// 	if (!value) return true;
		// 	return data.label.indexOf(value) !== -1;
		// },
		// filterChange(){
		// 	alert(app.filterText)
		// 	this.$refs.menuTree.filter(app.filterText);
		// },
		// 树节点选择监听
		handleMenuCheckChange(data, check, subCheck) {
			if(check) {
				// 节点选中时同步选中父节点
				let parentId = data.parentsid
				this.$refs.menuTree.setChecked(parentId, true, false)
			} else {
				// 节点取消选中时同步取消选中子节点
				if(data.children != null) {
					data.children.forEach(element => {
						this.$refs.menuTree.setChecked(element.menuid, false, false)
					});
				}
			}
		},
		openAllNodes(tof) {
			for(var i=0;i<this.$refs.menuTree.store._getAllNodes().length;i++){
					this.$refs.menuTree.store._getAllNodes()[i].expanded=tof;
				}
		},
		// 重置选择
		resetSelection() {
			this.checkAll = false
			this.$refs.menuTree.setCheckedNodes(this.currentRoleMenus)
		},
		// 全选操作
		handleCheckAll() {
			if(this.checkAll) {
				let allMenus = []
				this.checkAllMenu(this.menuData, allMenus)
				console.info(JSON.stringify(allMenus))
				this.$refs.menuTree.setCheckedNodes(allMenus)
			} else {
				this.$refs.menuTree.setCheckedNodes([])
			}
		},
		// 递归全选
		checkAllMenu(menuData, allMenus) {
			menuData.forEach(menu => {
				allMenus.push(menu)
				if(menu.children) {
					this.checkAllMenu(menu.children, allMenus)
				}
			});
		},
		// 角色菜单授权提交
		submitAuthForm() {
			let roleId = this.selectRole.roleid
			this.authLoading = true
			let checkedNodes = this.$refs.menuTree.getCheckedNodes(false, true)
			let roleMenus = []
			for(let i=0, len=checkedNodes.length; i<len; i++) {
				let roleMenu = { roleId:roleId, menuId:checkedNodes[i].menuid }
				roleMenus.push(roleMenu)
			}
			this.$api.role.saveRoleMenus(roleMenus).then((res) => {
				if(res.data.code == 200) {
					this.$message({ message: '操作成功', type: 'success' })
				} else {
					this.$message({message: '操作失败, ' + res.data.msg, type: 'error'})
				}
				this.authLoading = false
			})
		},
		renderContent(h, { node, data, store }) {
			return 
			(
			<div class="column-container">
				<span style="text-algin:center;margin-right:80px;">{data.menuname}</span>
				<span style="text-algin:center;margin-right:80px;">
					<el-tag type={data.type == 0?'':data.type == 1?'success':'info'} size="small">
						{data.type == 0?'目录':data.type == 1?'菜单':'按钮'}
					</el-tag>
				</span>
				<span style="text-algin:center;margin-right:80px;"> <i class={data.imagepath}></i></span>
				<span style="text-algin:center;margin-right:80px;">{data.parentname?data.parentname:'顶级菜单'}</span>
				<span style="text-algin:center;margin-right:80px;">{data.menuaction?data.menuaction:'\t'}</span>
			</div>);
      	},
		// 时间格式化
      	dateFormat: function (row, column, cellValue, index){
          	return format(row[column.property])
      	}
		
	},
	mounted() {
		this.findMenuTreeData()
	}
}
</script>
<style scoped>
.menu-container {
	margin-top: 10px;
}
.menu-header {
	padding-left: 8px;
	padding-bottom: 5px;
	text-align: left;
	font-size: 16px;
	color: rgb(20, 89, 121);
	
}
</style>