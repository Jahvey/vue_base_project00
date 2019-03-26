import axios from '../axios'
import {myGet,myPost} from "@/utils/request1"

/* 
 * 机构管理模块
 */

// 新增
export const save = (data) => {
    console.log("机构新增传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omOrg/addOrg",data)
    return resutl
}
//修改
export const edit = (data) => {
    console.log("机构修改传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omOrg/editOrg",data)
    return resutl
}
// // 删除
export const batchDelete = (data) => {
    console.log("机构删除传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omOrg/deleteOrg",data)
    return resutl
}
// //带条件查询机构
// export const queryOrgWithParams = () => {
//     return axios({
//         url: '/dept/queryOrgWithParams',
//         method: 'post'
//     })
// }

// 查询机构树
export const findDeptTree = () => {
    console.log("查询机构树POST")
    return myPost("yl/omOrg/queryOrg",{})
}
// export const findDeptTree = () => {
//     return axios({
//         url:'dept/omOrg/queryOrg',
//         method: 'post'
//     })
// }
