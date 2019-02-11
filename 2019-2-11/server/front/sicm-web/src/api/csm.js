import request from '@/utils/request'
import { myGet, myPost } from '@/utils/request1'

/* export function getUserList(queryParams) {
  return request({
    url: 'csc-service/user/paginQueryUserByOrgid',
    method: 'post',
    entity: queryParams
  })
}

export function getUserListbyId(queryParams) {
  return request({
    url: 'csc-service/user/queryUserById',
    method: 'post',
    entity: queryParams
  })
} */

//
export function getApproveCons(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/conApply/getApproveCons', queryParams)
}
//获取打印合同列表
export function getPrintCons(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/conApply/getPrintCons', queryParams)
}

export function findSubContractList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/subContractManage/findSubContractList', queryParams)
}



//查询自然人委托方账户信息
export function getEntrustAccountsByPartyId(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getEntrustAccountsByPartyId', queryParams)
}

//查询自然人关联关系
export function getRelativePsnList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getRelativePsnList', queryParams)
}


//查询自然人信用信息
export function queryNaturalBusiness(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/queryNaturalBusiness', queryParams)
}


//查询自然人
export function queryNaturalSchool(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/queryNaturalSchool', queryParams)
}

//查询自然人客户信用信息
export function getNaturalCreditList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getNaturalCreditList', queryParams)
}



//查询自然人评级历史列表查询生效的评级信息
export function getHisIrmByParty(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/corporation/getHisIrmByParty', queryParams)
}



export function getCsmImpornantEventInfo(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/corporation/getCsmImpornantEventInfo', queryParams)
}

//附加信息
export function getAdditiveList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getAdditiveList', queryParams)
}


//本行融资情况-批复
export function getfinancingList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getfinancingList', queryParams)
}


//本行融资情况  业务
export function getfinancingListYW(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getfinancingListYW', queryParams)
}


//为我行客户担保情况
export function getGuaranteeList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getGuaranteeList', queryParams)
}



export function getGuaranteeListDY(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getGuaranteeListDY', queryParams)
}


//违约记录
export function getIllegalList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getIllegalList', queryParams)
}




//额度信息
//查询对公、自然人、同业额度历史列表
export function queryCorpHis(queryParams){
  console.log(queryParams)
  return myGet('/mybatis-service/CrdApply/queryCorpHis',queryParams)
}

//业务信息

export function getBizInfo(queryParams){

  console.log(queryParams)
  return myGet('/mybatis-service/BizInfo/getBizInfo',queryParams)
}

//
export function getBizList(queryParams){

  console.log(queryParams)
  return myGet('/mybatis-service/BizSql/getBizList',queryParams)
}
//借新还旧(循环通/续借贷)
export function getApplyJxhjBizInfo(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/bizApply/getApplyJxhjBizInfo', queryParams)
}


//获取原担保合同中 对应的押品信息
export function findOldDbList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/subContractManage/findOldDbList', queryParams)
}

//获取原担保合同中 对应的押品信息
export function findOldContractList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/subContractManage/findOldContractList', queryParams)
}


export function queryNaturalForDesk(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/queryNaturalForDesk', queryParams)
}


//测试获取自然人客户列表
// export function queryNaturalForDesk(queryParams) {
//   return request({
//     url: 'mybatis-service/user/queryNaturalForDesk',
//     method: 'post',
//     entity: queryParams
//   })
// }

//测试获取自然人客户信息
// export function getNaturalPersonInfoById(queryParams) {
//   return request({
//     url: 'mybatis-service/user/getNaturalPersonInfoById',
//     method: 'post',
//     entity: queryParams
//   })
// }

