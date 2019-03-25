import {myPost} from "@/utils/request1"

/* 
 * 评级模块
 */


 
 //查询客户信息
export const queryCusInfo = (data) => {
    console.log("查询客户信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryCusInfo",data)
    return resutl
}
// 查询评级信息
export const queryPaginationIrm = (data) => {
    console.log("查询评级信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryPaginationIrm",data)
    return resutl
}

//发起评级
export const createIrmApply = (data) => {
    console.log("发起评级传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/createIrmApply",data)
    return resutl
}

//查询评级申请信息
export const queryRatingApplyInfo = (data) => {
    console.log("查询评级申请传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryRatingApplyInfo",data)
    return resutl
}

//查询评级申请信息isObject
export const getIsProject = (data) => {
    console.log("查询评级申请信息isObject传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/getIsProject",data)
    return resutl
}
//查询评级申请信息
export const getIrmRatingApplyInfo = (data) => {
    console.log("查询评级申请信息状态传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/getIrmRatingApplyInfo",data)
    return resutl
}

export const queryCustInfoJj = (data) => {
    console.log("查询评级基本信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryCustInfoJj",data)
    return resutl
}

//查询非财务信息
export const queryReportNonFinanceinfo = (data) => {
    console.log("查询非财务信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryReportNonFinanceinfo",data)
    return resutl
}
//通用评级调整项信息
export const queryOpitionInfo = (data) => {
    console.log("查询通用评级调整项信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryOpitionInfo",data)
    return resutl
}
//推翻历史信息
export const queryOverRecordInfo = (data) => {
    console.log("查询推翻历史信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryOverRecordInfo",data)
    return resutl
}
//通过客户评级申请表中的评级模型和模型版本，以及评级申请id来查询非财务信息
export const queryNonFinanceInfo = (data) => {
    console.log("查询非财务信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryNonFinanceInfo",data)
    return resutl
}

//查询担保公司是否有财报信息
export const queryHasFinanceInfo = (data) => {
    console.log("查询担保公司是否有财报信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryHasFinanceInfo",data)
    return resutl
}
//插入非财报信息
export const addFinancialInfo = (data) => {
    console.log("插入非财报信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/addFinancialInfo",data)
    return resutl
}
//插入财报信息
export const addNonFinancialInfo = (data) => {
    console.log("插入财报信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/addNonFinancialInfo",data)
    return resutl
}
//获取客户经理评级结果集(R1)：
export const getModeScaleToCombobx = (data) => {
    console.log("插入财报信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/getModeScaleToCombobx",data)
    return resutl
}
//保存通用调整选项
export const getIrmApplyCd = (data) => {
    console.log("保存通用调整选项数据传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/getIrmApplyCd",data)
    return resutl
}
export const saveIrmApplyCd = (data) => {
    console.log("保存通用调整选项数据传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/saveIrmApplyCd",data)
    return resutl
}

//根据评级申请Id和参与人Id获取最新的评级引擎计算信息。
export const queryInitialRatingCd = (data) => {
    console.log("根据评级申请Id和参与人Id获取最新的评级引擎计算信息传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryInitialRatingCd",data)
    return resutl
}
//通过评级ID获取前手的评级结果
export const queryOverRecordFirst = (data) => {
    console.log("通过评级ID获取前手的评级结果传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/queryOverRecordFirst",data)
    return resutl
}
//保存推翻信息
export const addOrUpdateTFRecord = (data) => {
    console.log("通过评级ID获取前手的评级结果传入参数:",JSON.stringify(data))
    let resutl = myPost("yl/irmController/addOrUpdateTFRecord",data)
    return resutl
}
