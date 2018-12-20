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

//查询自然人委托方账户信息
export function getEntrustAccountsByPartyId(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/account/getEntrustAccountsByPartyId', queryParams)
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



//测试获取自然人客户列表
export function queryNaturalForDesk(queryParams) {
  return request({
    url: 'mybatis-service/user/queryNaturalForDesk',
    method: 'post',
    entity: queryParams
  })
}

//测试获取自然人客户信息
export function getNaturalPersonInfoById(queryParams) {
  return request({
    url: 'mybatis-service/user/getNaturalPersonInfoById',
    method: 'post',
    entity: queryParams
  })
}

