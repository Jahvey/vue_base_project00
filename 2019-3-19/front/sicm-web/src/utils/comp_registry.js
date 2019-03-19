import Vue from 'vue'
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'// 单表查询组件
import CscMasterTable from '@/components/CscMasterTable/CscMasterTable'// 主子表查询组件
import CscFormPage from '@/components/CscFormPage/CscFormPage'// 单表表单组件
import CscMasterFormPage from '@/components/CscMasterFormPage/CscMasterFormPage'// 主子表表单组件
import CscDate from '@/components/CscDate/CscDate'// 日期时间组件
import Ueditor from '@/components/Ueditor/Ueditor' // 富文本编辑组件
import CscBaseRef from '@/components/CscRef/CscBaseRef' // 参照基础组件
import CscFormDialog from "@/components/CscFormDialog/CscFormDialog" // 弹出框表单
import CscFormDialogWithTree from "@/components/CscFormDialog/CscFormDialogWithTree" // 弹出框表单
import CscFormDialog1 from "@/components/CscFormDialog/CscFormDialog1" // 弹出框表单  构建上方是tab标签 左边是el-tree 右边是内容区的dialog
import CscFormDialog2 from "@/components/CscFormDialog/CscFormDialog2" // 弹出框表单
import CscFormDialog3 from "@/components/CscFormDialog/CscFormDialog3" // 弹出框表单
// import CscTabTable from "@/components/CscTabTable/CscTabTable" //带tab标签的表单组件 每个标签内容自定义

// register component globally
Vue.component('csc-single-table', CscSingleTable)
Vue.component('csc-master-table', CscMasterTable)
Vue.component('csc-form-page', CscFormPage)
Vue.component('csc-master-form-page', CscMasterFormPage)
Vue.component('csc-base-ref', CscBaseRef)
Vue.component('csc-form-dialog', CscFormDialog)
Vue.component('csc-form-dialog-tree', CscFormDialogWithTree)//注册测试用组件 包含过滤框 el-tree
Vue.component('csc-form-dialog1', CscFormDialog1)
Vue.component('csc-form-dialog2', CscFormDialog2) //包含tab  tree  右侧切换区域  点击tab可切换内容 但点击 el-tree不能切换
Vue.component('csc-form-dialog3', CscFormDialog3)
// Vue.component('csc-tab-table', CscTabTable)
Vue.component('csc-date', CscDate)
Vue.component('ueditor', Ueditor)

