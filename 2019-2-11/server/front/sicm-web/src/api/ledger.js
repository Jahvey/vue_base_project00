import request from '@/utils/request'
import {myGet,myPost} from '@/utils/request1'

//自然人客户查询
// export function queryNaturalPerson(queryParams) {
//   return request({
//     url: 'mybatis-service/natural/queryNaturalPerson',
//     method: 'post',
//     entity: queryParams
//   })
// }
//对公客户查询
export function queryPubCust(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/natural/queryPubCust', queryParams)
}
//自然人客户查询
export function queryNaturalPerson(queryParams) {
  console.log(queryParams)
  // alert(JSON.stringify(queryParams));
  return myGet('mybatis-service/natural/queryNaturalPerson', queryParams)
}
//联保客户查询
export function querGuarCustInfo(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/natural/querGuarCust', queryParams)
}

//同业客户查询
export function querySametradeCust(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/natural/querySametradeCust', queryParams)
}

//集团客户查询
export function queryGroupCorporation(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/natural/queryGroupCorporation', queryParams)
}

//合作中介客户查询
export function queryThirdCust(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/natural/queryThirdCust', queryParams)
}

//合作中介客户查询
export function queryWriteOff(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/asset/queryWriteOff', queryParams)
}

//担保公司业务管理台账查询
export function queryGuarAccount(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryGuarAccount', queryParams)
}

//客户额度台账查询
export function queryCustQuotaAccount(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryCustQuotaAccount', queryParams)
}

//集团客户批复
export function queryGroupCustomerReply(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryGroupCustomerReply', queryParams)
}

//单一客户批复
export function querySingleCustomerReply(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/querySingleCustomerReply', queryParams)
}

//公司合同信息查询
export function queryCompanyContractInfo(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryCompanyContractInfo', queryParams)
}


//个人合同信息查询
export function queryPersonalContractInfo(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryPersonalContractInfo', queryParams)
}

//公司借据信息查询
export function queryCorporateLendInfo(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryCorporateLendInfo', queryParams)
}

//个人借据信息查询
export function queryPersonalLendInfo(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryPersonalLendInfo', queryParams)
}

//合作项目额度使用明细查询
export function queryCooperaProjectQuota(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/guarAccount/queryCooperaProjectQuota', queryParams)
}

//客户评级查询
export function queryCustRateInfo(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryCustRateInfo', queryParams)
}

//风险分类查询
export function queryRiskClass(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryRiskClass', queryParams)
}

//贷后变更查询
export function queryChangeAfterLoan(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryChangeAfterLoan', queryParams)
}

//贷后检查查询
export function queryPostLoanInspect(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryPostLoanInspect', queryParams)
}
//拒贷查询
export function queryDeclineLoan(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryDeclineLoan', queryParams)
}
//资金使用台账查询
export function queryFundUseLedger(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryFundUseLedger', queryParams)
}

//还款计划查询
export function queryRepaymentPlan(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryRepaymentPlan', queryParams)
}

//历史流水查询
export function queryDetailedHistory(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryDetailedHistory', queryParams)
}

//流程查询
export function queryTechProcess(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryTechProcess', queryParams)
}

//季度对账单查询
export function queryQuarState(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryQuarState', queryParams)
}

//企业规模认定查询
export function queryRecognEnterpriseScale(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryRecognEnterpriseScale', queryParams)
}

//借据信息查询
export function queryBorrowQuery(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryBorrowQuery', queryParams)
}

//贷款交易明细查询
export function queryLoadDetail(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryLoadDetail', queryParams)
}

//监控查询
export function queryMonitorLedger(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/monitorQuery/queryMonitorLedger', queryParams)
}

//固定查询（表内）
export function queryBnFixed(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryBnFixed', queryParams)
}

//固定查询（表外）
export function queryBwFixed(queryParams) {
  console.log(queryParams)
  return myGet('mybatis-service/pubQuery/queryBwFixed', queryParams)
}


















