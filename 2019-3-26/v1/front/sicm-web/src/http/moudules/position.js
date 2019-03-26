import {myPost} from "@/utils/request1"

/* 
 * 岗位管理模块
 */

// 新增
export const save = (data) => {
    console.log("岗位新增传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omPosition/addPosition",data)
    return resutl
}
//修改
export const edit = (data) => {
    console.log("岗位修改传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omPosition/editPosition",data)
    return resutl
}
// // 删除
export const batchDelete = (data) => {
    console.log("岗位删除传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/omPosition/deletePosition",data)
    return resutl
}

// 查询岗位树
export const findPositionList = (data) => {
    console.log("查询岗位树POST")
    return myPost("yl/omPosition/queryPosition ",data)
}
