import axios from '../axios'
import {myPost} from "@/utils/request1"
/* 
 * 菜单管理模块
 */

 // 保存
export const save = (data) => {
    return myPost('/yl/acMenu/addMenu',data)
}
//编辑
export const edit = (data) => {
    return myPost('/yl/acMenu/editMenu',data)
}
//删除
export const batchDelete = (data) => {
    return myPost('/yl/acMenu/deleteMenu',data)
}
// 查找导航菜单树
export const findNavTree = () => {
    // return axios({
    //     url: '/menu/findNavTree',
    //     method: 'get',
    //     params
    // })
    return myPost('/yl/acMenu/queryMenuTree',{})
}
export const queryMenuTreeByRole = (parmas) => {
    return myPost('/yl/acMenu/queryMenuTreeByRole',parmas)
}
export const testFindMenuTree = () => {
    return myPost('/yl/acMenu/queryMenuTree',{})
}
// 查找导航菜单树
export const findMenuTree = () => {
    return axios({
        url: '/menu/findMenuTree',
        method: 'get'
    })
}