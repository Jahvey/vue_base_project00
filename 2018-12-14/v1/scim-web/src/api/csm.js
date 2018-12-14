import request from '@/utils/request'

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

