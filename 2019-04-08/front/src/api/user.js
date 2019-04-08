import request from '@/utils/request'
import {myGet,myPost} from '@/utils/request1'
// export function getUserList(queryParams) {
//   return request({
//     url: 'csc-service/user/paginQueryUserByOrgid',
//     method: 'post',
//     entity: queryParams
//   })
// }

export function getUserList(queryParams) {
  // return request({
  //   // url: 'mybatis-service/mynatureal/queryNaturalForDesk',
  //   url: 'mybatis-service/mynatureal/queryNaturalForDesk',
  //   method: 'get',
  //   entity: queryParams
  // })

  // return request.get('mybatis-service/mynatureal/queryNaturalForDesk',queryParams)
  // console.log("传入分页查询参数1:"+JSON.parse(JSON.stringify(queryParams)));
  return myGet('mybatis-service/mynatureal/queryNaturalForDesk',queryParams)
}

export function queryProductByAuth(queryParams) {
  // console.log("传入分页查询参数1:"+JSON.parse(JSON.stringify(queryParams)));
  return myPost('mybatis-service/product/queryProductByAuth',queryParams)
}

export function queryPartyRole(queryParams) {
  // console.log("传入分页查询参数1:"+JSON.parse(JSON.stringify(queryParams)));
  return myPost('mybatis-service/product/queryPartyRole',queryParams)
}

export function orgRoleAllowAdd(queryParams) {
  // console.log("传入分页查询参数1:"+JSON.parse(JSON.stringify(queryParams)));
  return myPost('mybatis-service/product/queryPartyRole',queryParams)
}

export function getUserList1(queryParams) {
  // return request({
  //   // url: 'mybatis-service/mynatureal/queryNaturalForDesk',
  //   url: 'mybatis-service/mynatureal/queryNaturalForDesk',
  //   method: 'get',
  //   entity: queryParams
  // })

  // return request.get('mybatis-service/mynatureal/queryNaturalForDesk',queryParams)
  console.log("传入分页查询参数1:"+JSON.parse(JSON.stringify(queryParams)));
  return myGet('mybatis-service/mynatureal/queryNaturalForDesk1',queryParams)
}

export function getEnumsValue(queryParams) {
  console.log("getEnumsValue传入参数:"+queryParams);
  return myGet('mybatis-service/businessEntry/getEnumsValue',queryParams)
}

export function getUserListbyId(queryParams) {
  return request({
    url: 'csc-service/user/queryUserById',
    method: 'post',
    entity: queryParams
  })
}
//测试获取自然人客户列表
export function queryNaturalForDesk(queryParams) {
  return request({
    url: 'mybatis-service/mynatureal/queryNaturalForDesk',
    method: 'get',
    entity: queryParams
  })
}

//测试获取自然人客户信息
export function getNaturalPersonInfoById(queryParams) {
  return request({
    url: 'mybatis-service/mynatureal/getNaturalPersonInfoById',
    method: 'post',
    entity: queryParams
  })
}
//保存自然人客户信息
export function saveNaturalPersonInfo(userInfo) {
  return request({
    url: 'mybatis-service/mynatureal/saveNaturalPersonInfo',
    method: 'post',
    entity: userInfo
  })
}

export function deleteUser(userInfo) {
  return request({
    url: 'csc-service/user/deleteUser',
    method: 'post',
    entity: userInfo
  })
}

export function saveUser(userInfo) {
  return request({
    url: 'csc-service/user/saveUser',
    method: 'post',
    entity: userInfo
  })
}

export function queryUser(userInfo) {
  return request({
    url: 'csc-service/user/queryUser',
    method: 'post',
    entity: userInfo
  })
}

//2019-1-9 修改用于测试页面多选框  其实查询岗位
export function queryUserRole(queryParams) {
  console.log("queryUserRole:"+queryParams);
  return myGet('mybatis-service/businessEntry/queryOmPosition',queryParams)
}
