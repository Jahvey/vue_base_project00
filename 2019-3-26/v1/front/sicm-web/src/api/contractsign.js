/*合同签约*/
import {myGet,myPost2,myPost} from '@/utils/request1'
import request from '@/utils/request'
//根据业务申请查询id查询业务信息
export function getConDyList(param) {
  return myGet('/mybatis-service/subContractSignController/getConDyList',param);
}
//抵押合同页面选择抵质人信息
export function selectParty(param) {
  return myGet('/mybatis-service/subContractSignController/selectParty',param);
}
//通过担保合同id查询合同信息
export function getGrtConInfo(param) {
  return myGet('/mybatis-service/subContractSignController/getGrtConInfo',param);
}
//通过更新担保合同信息
export function updateGrtConInfo(param) {
  return myGet('/mybatis-service/subContractSignController/updateGrtConInfo',param);
}
//获取 担保合同 对应的押品信息
export function getConSub(param) {
  return myGet('/mybatis-service/subContractSignController/getConSub',param);
}
//签担保合同时，查询该客户下，该业务申请下  该笔业务下的担保物信息(担保合同可以引入的押品)
export function selSubGrt(param) {
  return myGet('/mybatis-service/subContractSignController/selSubGrt',param);
}
//查询合同和将要绑定的押品信息
export function getSubConAndMortgage(param) {
  return myGet('/mybatis-service/subContractSignController/getSubConAndMortgage',param);
}
//保存担保合同
export function saveGrtCon(param) {
  return myGet('/mybatis-service/subContractSignController/saveGrtCon',param);
}
//删除关联的担保合同信息
export function delConGrtRel(param) {
  return myGet('/mybatis-service/subContractSignController/delConGrtRel',param);
}
//关联押品信息与担保合同
export function insertSubGrtRel(param) {
  return myGet('/mybatis-service/subContractSignController/insertSubGrtRel',param);
}
//删除抵质押物与担保合同关联关系
export function delSubGrtRel(param) {
  return myGet('/mybatis-service/subContractSignController/delSubGrtRel',param);
}
//核对担保合同基本信息是否填写
export function checkIfCommitSubBasicInfo(param) {
  return myGet('/mybatis-service/subContractSignController/checkIfCommitSubBasicInfo',param);
}
//查询主合同下的担保合同
export function getConGrtBZRList(param) {
  return myGet('/mybatis-service/subContractSignController/getConGrtBZRList',param);
}
//查询主合同下的担保合同
export function getConSubBzr(param) {
  return myGet('/mybatis-service/subContractSignController/getConSubBzr',param);
}
//查询签担保合同时，可以引入的保证人
export function selSubGrtBzr(param) {
  return myGet('/mybatis-service/subContractSignController/selSubGrtBzr',param);
}
export function insertSubGrtRel2(param) {
  return myPost('/mybatis-service/subContractSignController/insertSubGrtRel2',param);
}
//查询保证合同以及保证人信息
export function getSubConBzr(param) {
  return myGet('/mybatis-service/subContractSignController/getSubConBzr',param);
}
//删除保证合同的关联的保证人信息
export function delSubGrtRel2(param) {
  return myGet('/mybatis-service/subContractSignController/delSubGrtRel2',param);
}
//查询保证合同list
export function getConGRTBZJList(param) {
  return myGet('/mybatis-service/subContractSignController/getConGRTBZJList',param);
}
//查询保证合同关联的保证金
export function getConSubBzj(param) {
  return myGet('/mybatis-service/subContractSignController/getConSubBzj',param);
}
//查询业务申请关联的保证金
export function selSubGrtBzj(param) {
  return myGet('/mybatis-service/subContractSignController/selSubGrtBzj',param);
}
//关联保证金到保证合同
export function insertSubGrtRel3(param) {
  return myPost('/mybatis-service/subContractSignController/insertSubGrtRel3',param);
}
//删除保证金到保证合同
export function delSubGrtRel3(param) {
  return myGet('/mybatis-service/subContractSignController/delSubGrtRel3',param);
}
//合同签约时添加保证金
export function addConCashDeposit(param) {
  return myPost('/mybatis-service/subContractSignController/addConCashDeposit',param);
}
//查询可引入的最高额抵押合同
export function getMaxLoanCon(param) {
  return myGet('/mybatis-service/subContractSignController/getMaxLoanCon',param);
}
//查询担保合同信息用于输入担保合同本次担保金额时，判断可用金额
export function getSubCon(param) {
  return myGet('/mybatis-service/subContractSignController/getSubCon',param);
}
//1.综合授信 检查是否已经引入了同样的最高额担保合同
//2.单笔合同 检查是否已经引入了同样的最高额担保合同
export function checkHaveRef(param) {
  return myGet('/mybatis-service/subContractSignController/checkHaveRef',param);
}
//引入最高额担保合同保存本次担保金额
export function addMaxloancon(param) {
  return myPost('/mybatis-service/subContractSignController/addMaxloancon',param);
}
//保存最高额担保合同保存本次担保金额
export function updateConsubRel(param) {
  return myPost('/mybatis-service/subContractSignController/updateConsubRel',param);
}
