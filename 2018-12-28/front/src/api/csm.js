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
  return myGet('/mybatis-service/account/getEntrustAccountsByPartyId', queryParams)
}


//额度信息
//查询对公、自然人、同业额度历史列表
export function queryCorpHis(queryParams){
  console.log(queryParams)
  return myGet('/mybatis-service/CrdApply/queryCorpHis',queryParams)
}

//业务信息
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

