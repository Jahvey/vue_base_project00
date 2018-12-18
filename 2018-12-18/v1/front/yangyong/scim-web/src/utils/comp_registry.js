import Vue from 'vue'
import CscSingleTable from '@/components/CscSingleTable/CscSingleTable'// 单表查询组件
import CscMasterTable from '@/components/CscMasterTable/CscMasterTable'// 主子表查询组件
import CscFormPage from '@/components/CscFormPage/CscFormPage'// 单表表单组件
import CscMasterFormPage from '@/components/CscMasterFormPage/CscMasterFormPage'// 主子表表单组件
import CscDate from '@/components/CscDate/CscDate'// 日期时间组件
import Ueditor from '@/components/Ueditor/Ueditor' // 富文本编辑组件
import CscBaseRef from '@/components/CscRef/CscBaseRef' // 参照基础组件
import CscFormDialog from "@/components/CscFormDialog/CscFormDialog" // 弹出框表单

// register component globally
Vue.component('csc-single-table', CscSingleTable)
Vue.component('csc-master-table', CscMasterTable)
Vue.component('csc-form-page', CscFormPage)
Vue.component('csc-master-form-page', CscMasterFormPage)
Vue.component('csc-base-ref', CscBaseRef)
Vue.component('csc-form-dialog', CscFormDialog)
Vue.component('csc-date', CscDate)
Vue.component('ueditor', Ueditor)

