<template>
  <div>
    <!--表格栏-->
    <el-table :data="data.list" :highlight-current-row="highlightCurrentRow" @selection-change="selectionChange" 
          @current-change="handleCurrentChange" v-loading="loading" :element-loading-text="$t('action.loading')" :border="border" :stripe="stripe"
          :show-overflow-tooltip="showOverflowTooltip" :max-height="maxHeight" :size="size" :align="align" style="width:100%;" >
      <el-table-column type="selection" width="40" v-if="showBatchDelete & showOperation"></el-table-column>
      <el-table-column v-for="column in columns" header-align="center" align="center"
        :prop="column.prop" :label="column.label" :width="column.width" :min-width="column.minWidth"
        :fixed="column.fixed" :key="column.prop" :type="column.type" :formatter="column.formatter"
        :sortable="column.sortable==null?true:column.sortable">
      </el-table-column>
      <el-table-column :label="$t('action.operation')" :width="270" fixed="right" v-if="showOperation" header-align="center" align="center">
        <template slot-scope="scope">
          <kt-button :label="$t('action.edit')" :perms="permsEdit" v-if="showEdit" :size="size" type="primary" @click="handleEdit(scope.$index, scope.row)" />
          <kt-button :label="$t('action.delete')" :perms="permsDelete" v-if="showDelete" :size="size" type="danger" @click="handleDelete(scope.$index, scope.row)" />
          <kt-button :label="$t('action.view')" :perms="permsView" v-if="showView" :size="size" type="success" @click="handleView(scope.$index, scope.row)" />
        </template>
      </el-table-column>
    </el-table>
    <!--分页栏-->
    <div class="toolbar" style="padding:10px;">
      <kt-button :label="$t('action.batchDelete')" :perms="permsDelete" :size="size" type="danger" @click="handleBatchDelete()" 
        :disabled="this.selections.length===0" style="float:left;" v-if="showBatchDelete & showOperation"/>
      <kt-button :label="$t('action.roleEdit')" :size="size" type="primary" @click="handleRoleEdit()" 
        :disabled="this.selections.length===0" style="float:left;" v-if="showRoleEdit & showOperation"/>
      <el-pagination layout="total, sizes, prev, pager, next, jumper" @size-change="doSizeChange" @current-change="refreshPageRequest" :current-page="pageRequest.pageNum"
                     :page-sizes="[10,20,30,40,50]" :page-size="pageRequest.pageSize" :total="data.total" style="float:right;">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import KtButton from "@/views/Core/KtButton"
import commonUtil from "@/utils/commonUtil"
export default {
  name: 'KtTable',
  components:{
			KtButton
	},
  props: {
    loading: false,  // 加载标识
    columns: Array, // 表格列配置
    data: Object, // 表格分页数据
    permsEdit: String,  // 编辑权限标识
    permsDelete: String,  // 删除权限标识
    permsView: String,  // 查看权限标识
    size: { // 尺寸样式
      type: String,
      default: 'mini'
    },
    align: {  // 文本对齐方式
      type: String,
      default: 'left'
    },
    maxHeight: {  // 表格最大高度
      type: Number,
      default: 400
    },
    showOperation: {  // 是否显示操作组件
      type: Boolean,
      default: true
    },
    border: {  // 是否显示边框
      type: Boolean,
      default: false
    },
    stripe: {  // 是否显示斑马线
      type: Boolean,
      default: true
    },
    highlightCurrentRow: {  // // 是否高亮当前行
      type: Boolean,
      default: true
    },
    showOverflowTooltip: {  // 是否单行显示
      type: Boolean,
      default: true
    },
    showBatchDelete: {  // 是否显示操作组件
      type: Boolean,
      default: true
    },
    showRoleEdit: {
      type: Boolean,
      default: false
    },
    showEdit:{  // 是否显示编辑按钮
      type: Boolean,
      default: true
    },
    showDelete:{  // 是否显示删除按钮
      type: Boolean,
      default: true
    },
    showView:{  // 是否显示查看按钮
      type: Boolean,
      default: false
    },
  },
  data() {
    return {
      // 分页信息
			pageRequest: {
				pageNum: 1,
        pageSize: 10
      },
      selections: []  // 列表选中列
    }
  },
  methods: {
    // 分页查询
    findPage: function () {
        this.loading = true
        let callback = res => {
          this.loading = false
        }
        // this.pageRequest = this.commonUtil.extend(this.pageRequest,this.filters)
        // this.filters.pageNum = this.pageRequest.pageNum
        // this.filters.pageSize = this.pageRequest.pageSize
      this.$emit('findPage', {pageRequest:this.pageRequest, callback:callback})
    },
    // 选择切换
    selectionChange: function (selections) {
      this.selections = selections
      this.$emit('selectionChange', {selections:selections})
    },
    // 选择切换
    handleCurrentChange: function (val) {
      this.$emit('handleCurrentChange', {val:val})
    },
    // 查询每页笔数变化事件
    doSizeChange(pageSize) {
      this.pageRequest.pageSize = pageSize
      this.findPage()
    },
    // 换页刷新
		refreshPageRequest: function (pageNum) {
      this.pageRequest.pageNum = pageNum
      this.findPage()
    },
    // 编辑
		handleEdit: function (index, row) {
      this.$emit('handleEdit', {index:index, row:row})
		},
    // 删除
		handleDelete: function (index, row) {

      this.$confirm('确认删除选中记录吗？', '提示', {
				type: 'warning'
			}).then(() => {
        this.loading = true
        let callback = res => {
          if(res && res.data && res.data.code == 200) {
            this.$message({message: '删除成功', type: 'success'})
            this.findPage()
          } else {
            this.$message({message: '操作失败, ' + res.msg, type: 'error'})
          }
          this.loading = false
        }
        this.$emit('handleDelete', {"row": row,"callback": callback})
			}).catch(() => {
			})
		},
    handleView: function (index, row) {
      this.$emit('handleView', {index:index, row:row})
    },
		// 批量删除
		handleBatchDelete: function () {
			let ids = this.selections.map(item => item.id).toString()
			this.delete(ids)
		},
		// 删除操作
		delete: function (ids) {
			this.$confirm('确认删除选中记录吗？', '提示', {
				type: 'warning'
			}).then(() => {
				let params = []
				let idArray = (ids+'').split(',')
				for(var i=0; i<idArray.length; i++) {
					params.push({'id':idArray[i]})
        }
        this.loading = true
        let callback = res => {
          if(res.code == 200) {
            this.$message({message: '删除成功', type: 'success'})
            this.findPage()
          } else {
            this.$message({message: '操作失败, ' + res.msg, type: 'error'})
          }
          this.loading = false
        }
        this.$emit('handleDelete', {params:params, callback:callback})
			}).catch(() => {
			})
    },
    handleRoleEdit: function(){
      let rows = this.selections
      if(rows.length > 1){
        this.$message({message: '最多选择一条记录', type: 'warning'})
        return
      }
      if(rows.length == 0){
        this.$message({message: '请选择一条记录', type: 'warning'})
        return
      }
			this.$emit('handleRoleEdit',rows[0])
    }
  },
  mounted() {
    this.refreshPageRequest(1)
  }
}
</script>

<style scoped>

</style>
