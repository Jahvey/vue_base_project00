import axios from '../axios'
import {myGet,myPost} from "@/utils/request1"
/* 
 * 角色管理模块
 */

// 保存
export const save = (data) => {
    return axios({
        url: '/role/save',
        method: 'post',
        data
    })
}
// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/role/delete',
        method: 'post',
        data
    })
}
// 分页查询
// 分页查询
export const findPage = (data) => {
    return myPost("yl/acRole/queryPaginationRole",data)
}
// 查询全部
export const findAll = () => {
    return myPost("yl/acRole/queryAllRole",{})
}
// 查询角色菜单集合
export const findRoleMenus = (params) => {
    return myPost("yl/acRole/findRoleMenus",params)
}
// 保存角色菜单集合
export const saveRoleMenus = (data) => {
    return myPost("yl/acRole/saveRoleMenus",data)
}

//根据用户获取角色
export const getRolesByUserId = (data) => {
    return myPost("yl/acRole/saveRoleMenus",data)
}

export const getRolesSelectBoxData = (data) => {
    return myPost("yl/acRole/getRolesSelectBoxData",data) 
}