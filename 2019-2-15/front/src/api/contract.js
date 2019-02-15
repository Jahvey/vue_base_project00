import request from '@/utils/request'
import { myGet, myPost } from '@/utils/request1'

// export function getContractList(queryParams) { // 这是联调后端的时候才使用的，现在使用的是mock的假数据，url不走这里
//   return request({
//     url: 'csc-service/contract/paginQueryContractByOrgid',
//     method: 'post',
//     entity: queryParams
//   })
// }

/**
 * 测试获取自然人客户列表，测试这个方法，后面跟的就是后台那个url
 * queryParams就是传入的参数，包含分页和高级查询
 * pageJump:1
 * recInPage:20
 */
export function queryConApvList(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/conContractInfo/queryConApvList', queryParams)
}

/**
 * 查询主合同基本信息，这里也应该传递多个参数，但是参数没有传够，只有一个合同编号传过来了
 */
export function getConInfoByContractNum(queryParams) {
  console.log(queryParams)// 参数传递不够，只有一个合同编号
  console.log('后台传递的合同编号：'+queryParams.contractNum)
  console.log('是否调用到了这个方法')
  return myGet('mybatis-service/conContractInfo/getConInfoByContractNum', queryParams)
}
// export function queryContract(contractInfo) {
//   return request({
//     url: 'csc-service/contract/queryContract',
//     method: 'post',
//     entity: contractInfo
//   })
// }
//
// export function queryContractRole(contractInfo) {
//   return request({
//     url: 'csc-service/contract/queryContractRole',
//     method: 'post',
//     entity: contractInfo
//   })
// }
