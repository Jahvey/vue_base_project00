import request from '@/utils/request'
import { myGet, myPost } from '@/utils/request1'



/**
 * 测试获取主合同列表，测试这个方法，后面跟的就是后台那个url
 * queryParams就是传入的分页的参数，但是字段和后台不匹配
 * pageJump:1
 * recInPage:20
 */
export function getApproveCons(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/conApply/getApproveCons', queryParams)
}

export function getPrintCons(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/conApply/getPrintCons', queryParams)
}

export function getContractList(queryParams) { // 这是联调后端的时候才使用的，现在使用的是mock的假数据，url不走这里
  return request({
    url: '/mybatis-service/contract/paginQueryContractByOrgid',
    method: 'post',
    entity: queryParams
  })
}

// 测试获取自然人客户列表
// export function queryNaturalForDesk(queryParams) {
//   return request({
//     url: 'mybatis-service/contract/queryNaturalForDesk',
//     method: 'post',
//     entity: queryParams
//   })
// }

// 测试获取自然人客户信息
// export function getNaturalPersonInfoById(queryParams) {
//   return request({
//     url: 'mybatis-service/contract/getNaturalPersonInfoById',
//     method: 'post',
//     entity: queryParams
//   })
// }

// export function saveContract(contractInfo) {
//   return request({
//     url: 'csc-service/contract/saveContract',
//     method: 'post',
//     entity: contractInfo
//   })
// }

// export function deleteContract(contractInfo) {
//   return request({
//     url: 'csc-service/contract/saveContract',
//     method: 'post',
//     entity: contractInfo
//   })
// }

// export function queryContract(contractInfo) {
//   return request({
//     url: 'csc-service/contract/queryContract',
//     method: 'post',
//     entity: contractInfo
//   })
// }

// export function queryContractRole(contractInfo) {
//   return request({
//     url: 'csc-service/contract/queryContractRole',
//     method: 'post',
//     entity: contractInfo
//   })
// }
