<template>
  <div class="container" style="width:99%;margin-top:-25px;">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.name" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:dept:view" type="primary" @click="findTreeData(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:dept:add" type="primary" @click="handleAdd"/>
			</el-form-item>
		</el-form>
	</div>
	<!--表格树内容栏-->
    <el-table :data="tableTreeDdata" stripe size="mini" style="width: 100%;"
      v-loading="loading" element-loading-text="$t('action.loading')">
      <el-table-column
        prop="orgid" header-align="center" align="center" width="80" label="机构编号">
      </el-table-column>
      <table-tree-column 
        prop="remark" header-align="center" treeKey="orgid" width="400" label="机构名称">
      </table-tree-column>
      <el-table-column 
        prop="parentorgname" header-align="center" align="center" width="400" label="上级机构">
      </el-table-column>
      <el-table-column
        prop="createtime" header-align="center" align="center" label="创建时间" :formatter="dateFormat">
      </el-table-column>
      <el-table-column
        fixed="right" header-align="center" align="center" width="180" :label="$t('action.operation')">
        <template slot-scope="scope">
          <kt-button :label="$t('action.edit')" perms="sys:dept:edit" @click="handleEdit(scope.row)"/>
          <kt-button :label="$t('action.delete')" perms="sys:dept:delete" type="danger" @click="handleDelete(scope.row)"/>
        </template>
      </el-table-column>
    </el-table>
    <!-- 新增修改界面 -->
    <el-dialog  :title="!dataForm.orgid ? '新增' : '修改'" width="80%" :visible.sync="dialogVisible" :close-on-click-modal="false">
      <el-row :gutter="20">
        <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="submitForm()" 
          label-width="90px" :size="size" style="text-align:left;">
          <el-col :span="12">
            <el-form-item label="上级机构号" prop="parentorgid">
              <el-input v-model="dataForm.parentorgid" placeholder="" :disabled="true"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="上级机构" prop="parentorgname">
                <popup-tree-input 
                  :data="popupTreeData" :props="popupTreeProps" :prop="dataForm.parentorgname==null?'':dataForm.parentorgname" 
                  :node-key="''+dataForm.parentorgname" :currentChangeHandle="handleTreeSelectChange">
                </popup-tree-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="机构号" prop="orgcode">
              <el-input v-model="dataForm.orgcode" placeholder="机构号"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="机构名称" prop="orgname">
              <el-input v-model="dataForm.orgname"  placeholder="机构名称"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-if="dataForm.type !== 2" label="排序编号" prop="orderNum">
              <el-input-number v-model="dataForm.orderNum" controls-position="right" :min="0" label="排序编号"></el-input-number>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="机构描述" prop="remark">
              <el-input type="textarea" v-model="dataForm.remark"  placeholder="机构描述"></el-input>
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
import KtButton from "@/views/Core/KtButton"
import TableTreeColumn from '@/views/Core/TableTreeColumn'
import PopupTreeInput from "@/components/PopupTreeInput"
import FaIconTooltip from "@/components/FaIconTooltip"
import { format } from "@/utils/datetime"
import {getAllOrgTree} from '@/utils/commonSysManageUtil'
export default {
	components:{
    PopupTreeInput,
    KtButton,
    TableTreeColumn,
    FaIconTooltip
	},
	data() {
		return {
			size: 'small',
      loading: false,
      rootname:'绵阳市商业银行股份有限公司集团',
      true: true,
			filters: {
				orgname: ''
      },
      tableTreeDdata: [],
      dialogVisible: false,
      operaType: '',
      dataForm: {
        orgid: 0,
        orgname: '',
        parentorgid: 0,
        parentName: '',
        orglevel: '',
        orderNum: 0
      },
      dataRule: {
        orgname: [
          { required: true, message: '机构名称不能为空', trigger: 'blur' }
        ],
        parentName: [
          { required: true, message: '上级机构不能为空', trigger: 'change' }
        ],
        remark: [
          {required: true, message: "机构描述不能为空", trigger: 'change'}
        ]
      },
      popupTreeData: [],
      popupTreeProps: {
				label: 'remark',
				children: 'children'
      },
      orgLevelOpts:{
        "1": "一级",
        "2": "二级",
        "3": "三级",
        "4": "四级",
        "5": "五级",
      }
		}
	},
	methods: {
		// 获取数据
    findTreeData: function () {
     // this.loading = true
      this.popupTreeData = this.tableTreeDdata = getAllOrgTree(this,res => {
        this.loading = false
      })
    },
		// 获取上级机构树
    getParentMenuTree: function (tableTreeDdata) {
      // let parent = {
      //   parentorgid: 0,
      //   name: '集团',
      //   children: tableTreeDdata
      // }
      return tableTreeDdata
    },
		// 显示新增界面
		handleAdd: function () {
      this.dialogVisible = true
      this.operaType = 'add'
			this.dataForm = {
        orgid: '',
        orgname: '',
        parentorgid: '',
        parentorgname: '',
        orglevel: '',
        remark: '',
        orderNum: ''
      }
		},
		// 显示编辑界面
		handleEdit: function (row) {
      this.dialogVisible = true
      this.operaType = 'update'
      Object.assign(this.dataForm, row);
		},
    // 删除
    handleDelete (row) {
      this.$confirm('确认删除选中记录吗？', '提示', {
				type: 'warning'
      }).then(() => {
        let params = {"orgid": row.orgid}
        this.$api.dept.batchDelete(params).then( res => {
          console.log("orgDlt",JSON.stringify(res))
          this.findTreeData()
          this.$message({message: '删除成功', type: 'success'})
        })
      })
    },
      // 机构树选中
    handleTreeSelectChange (data, node) {
      console.log(data.orgid,data.orgname,data.parentorgid,data.parentorgname)
      this.dataForm.parentorgid = data.orgid
      this.dataForm.parentorgname = data.remark
      this.dataForm.orglevel = data.orglevel + 1
    },
    // 表单提交
    submitForm () {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
            let params = Object.assign({}, this.dataForm)
            if('add' === this.operaType){
              this.$api.dept.save(params).then((res) => {
                this.editLoading = false
                if(res && res.data && res.data.code == 200) {
                  this.$message({ message: '添加机构成功', type: 'success' })
                  this.dialogVisible = false
                  this.$refs['dataForm'].resetFields()
                } else {
                  this.$message({message: '添加机构失败, ' + res.msg, type: 'error'})
                }
                this.findTreeData()
              })
            }
            if('update' === this.operaType){
              this.$api.dept.edit(params).then((res) => {
                this.editLoading = false
                if(res && res.data && res.data.code == 200) {
                  this.$message({ message: '修改机构成功', type: 'success' })
                  this.dialogVisible = false
                  this.$refs['dataForm'].resetFields()
                } else {
                  this.$message({message: '修改机构失败, ' + res.msg, type: 'error'})
                }
                this.findTreeData()
              })
            }
					})
				}
      })
    },
		// 时间格式化
    dateFormat: function (row, column, cellValue, index){
      return format(row[column.property])
    }
    
	},
	mounted() {
    //this.findTreeData()
	}
}
</script>

<style scoped>

</style>