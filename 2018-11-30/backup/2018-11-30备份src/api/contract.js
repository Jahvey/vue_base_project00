import request from '@/utils/request'

export function getContractList(queryParams) { // 这是联调后端的时候才使用的，现在使用的是mock的假数据，url不走这里
  return request({
    url: 'csc-service/contract/paginQueryContractByOrgid',
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

export function saveContract(contractInfo) {
  return request({
    url: 'csc-service/contract/saveContract',
    method: 'post',
    entity: contractInfo
  })
}

export function deleteContract(contractInfo) {
  return request({
    url: 'csc-service/contract/saveContract',
    method: 'post',
    entity: contractInfo
  })
}

export function queryContract(contractInfo) {
  return request({
    url: 'csc-service/contract/queryContract',
    method: 'post',
    entity: contractInfo
  })
}

export function queryContractRole(contractInfo) {
  return request({
    url: 'csc-service/contract/queryContractRole',
    method: 'post',
    entity: contractInfo
  })
}
