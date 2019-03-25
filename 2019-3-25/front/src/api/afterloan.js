import request from '@/utils/request'
import { myGet, myPost } from '@/utils/request1'

//贷后首次检查借据列表查询
export function queryBorList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/afterloancheck/queryBorList', queryParams)
}

//贷后可日常检查客户列表查询
export function queryDailycheckCust(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/Dailycheck/queryDailycheckCust', queryParams)
}
//重点检查
export function queryImportantCheck(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/importantCheck/queryImportantCheck', queryParams)
}

//贷款到期前跟踪检查借据列表
export function queryBeforeMatCheck(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/beforeMatCheck/queryBeforeMatCheck', queryParams)
}

//小贷中心首次检查
export function queryMicCentreFirstCheck(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/micCentreFirstCheck/queryMicCentreFirstCheck', queryParams)
}

//首次检查报告
export function queryFirstCheckReport(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/firstCheckReport/queryFirstCheckReport', queryParams)
}
//小贷中心日常检查
export function querySmallDailyCheck(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/smallDailyCheck/querySmallDailyCheck', queryParams)
}
//日常检查报告
export function queryDailyCheckReport(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/dailyCheckReport/queryDailyCheckReport', queryParams)
}

//贷后检查名单列表查询
export function queryAfterLoanCheckRoster(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/CheckRoster/queryAfterLoanCheckRoster', queryParams)
}

//贷后检查频率列表查询
export function queryCheckFrequency(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/CheckFrequency/queryCheckFrequency', queryParams)
}

//风险分类-季度调整-小企业自然人/非小企业自然人
export function queryQuarSmallNatural(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/RiskClassQuar/queryQuarSmallNatural', queryParams)
}
//风险分类-历史调整记录
export function queryHistoriyAdjustRecord(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/RiskClassHistory/queryHistoriyAdjustRecord', queryParams)
}
//授信资金使用用途列表
export function queryMoneyUse(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/afterloancheck/queryMoneyUse', queryParams)
}
//新增授信资金用途
export function addMoneyUse(queryParams) {
  console.log(queryParams)
  return  myPost('/mybatis-service/afterloancheck/addMoneyUse', queryParams)
}
//检查信息查询
export function queryFirstCheckInfoBySummaryId(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/afterloancheck/queryFirstCheckInfoBySummaryId', queryParams)
}
//贷款基本情况
export function querySummaryList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/Dailycheck/querySummaryList', queryParams)
}
