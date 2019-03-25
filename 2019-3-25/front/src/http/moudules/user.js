import axios from '../axios'
import {myPost,myGet} from "@/utils/request1"
/* 
 * 用户管理模块
 */

// 保存
export const save = (data) => {
    console.log("用户新增传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omEmployee/addEmp",data)
    return resutl
}
// 编辑
export const edit = (data) => {
    console.log("用户编辑传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omEmployee/editEmp",data)
    return resutl
}
// 删除
export const batchDelete = (data) => {
    console.log("用户删除传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omEmployee/deleteEmp",data)
    return resutl
}
//用户角色配置
export const insertOperatorRole = (data) => {
    console.log("用户编辑传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omEmployee/insertOperatorRole",data)
    return resutl
}

// 分页查询
export const findPage = (data) => {
    console.log("用户查询传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omEmployee/queryEmployee",data)
    return resutl
}
// 查找用户的菜单权限标识集合
export const findPermissions = (params) => {
    return axios({
        url: '/user/findPermissions',
        method: 'get',
        params
    })
}