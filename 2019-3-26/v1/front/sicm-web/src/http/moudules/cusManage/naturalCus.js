import axios from "@/http/axios";
import {myPost} from "@/utils/request1"

/*
 * 客户管理自然人客户管理模块
 */

// 自然人客户分页查询
export const findPage = (data) => {
  console.log("自然人客户查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/natural/naturalPerson",data);
  return resutl
}

// 自然人客户保存
export const save = (data) => {
  console.log("自然人客户保存传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/natural/addNatural",data);
  return resutl
}

// 自然人客户更新
export const update = (data) => {
  console.log("自然人客户更新传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/natural/editNatural",data);
  return resutl
}

// 根据partyId查询单条自然人客户
export const queryNaturalByPartyId = (data) => {
  console.log("自然人客户查询单条传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/natural/queryNaturalByPartyId",data);
  return resutl
}

//委托方账户列表查询
export const getCsmEntrustAccountList = (data) => {
    console.log("委托方账户查询传入参数:",JSON.stringify(data));
    let resutl = myPost("/mybatis-service/customer/entrustAccount/entrustAccountList",data);
    return resutl
};
// 委托方账户新增
export const addEntrustAccount = (data) => {
  console.log("委托方账户新增传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/entrustAccount/addEntrustAccount",data);
  return resutl
};
// 委托方账户编辑
export const updateEntrustAccount = (data) => {
  console.log("委托方账户更新传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/entrustAccount/updateEntrustAccount",data);
  return resutl
};
// 委托方账户删除
export const deleteEntrustAccount = (data) => {
  console.log("委托方账户删除传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/entrustAccount/deleteEntrustAccount",data);
  return resutl
};

//关系人信息列表查询
export const getNaturalRelativeList = (data) => {
  console.log("关系人信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalRelative/naturalRelativeList",data);
  return resutl
};
// 关系人信息新增
export const addNaturalRelative= (data) => {
  console.log("关系人信息新增传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalRelative/addNaturalRelative",data);
  return resutl
};
// 关系人信息编辑
export const updateNaturalRelative = (data) => {
  console.log("关系人信息更新传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalRelative/updateNaturalRelative",data);
  return resutl
};
// 关系人信息删除
export const deleteNaturalRelative = (data) => {
  console.log("关系人信息删除传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalRelative/deleteNaturalRelative",data);
  return resutl
};

//经营信息列表查询
export const getNaturalBusinessList = (data) => {
  console.log("经营信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalBusiness/naturalBusinessList",data);
  return resutl
};
// 经营信息新增
export const addNaturalBusiness = (data) => {
  console.log("经营信息新增传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalBusiness/addNaturalBusiness",data);
  return resutl
};
// 经营信息编辑
export const updateNaturalBusiness = (data) => {
  console.log("经营信息更新传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalBusiness/updateNaturalBusiness",data);
  return resutl
};
// 经营信息删除
export const deleteNaturalBusiness = (data) => {
  console.log("经营信息删除传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/naturalBusiness/deleteNaturalBusiness",data);
  return resutl
};

//信用信息列表查询
export const getCreditInfoList = (data) => {
  console.log("信用信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/creditInfo/creditInfoList",data);
  return resutl
};
// 信用信息新增
export const addCreditInfo= (data) => {
  console.log("信用信息新增传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/creditInfo/addCreditInfo",data);
  return resutl
};
// 信用信息编辑
export const updateCreditInfo = (data) => {
  console.log("信用信息更新传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/creditInfo/updateCreditInfo",data);
  return resutl
};
// 信用信息删除
export const deleteCreditInfo= (data) => {
  console.log("信用信息删除传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/creditInfo/deleteCreditInfo",data);
  return resutl
};

//评级信息列表查询
export const getInternalRatingResultList = (data) => {
  console.log("评级信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/internalRatingResult/internalRatingResultList",data);
  return resutl
};

//重大事件列表查询
export const getImpornantEventList = (data) => {
  console.log("重大事件查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/impornantEvent/impornantEventList",data);
  return resutl
};
// 重大事件新增
export const addImpornantEvent= (data) => {
  console.log("重大事件新增传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/impornantEvent/addImpornantEvent",data);
  return resutl
};
// 重大事件编辑
export const updateImpornantEvent = (data) => {
  console.log("重大事件更新传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/impornantEvent/updateImpornantEvent",data);
  return resutl
};
// 重大事件删除
export const deleteImpornantEvent= (data) => {
  console.log("重大事件删除传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/impornantEvent/deleteImpornantEvent",data);
  return resutl
};

//预警信息列表查询
export const getWarningList = (data) => {
  console.log("预警信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/warning/warningList",data);
  return resutl
};

//附加信息列表查询
export const getAdditiveInfoList = (data) => {
  console.log("附加信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/additiveInfo/additiveInfoList",data);
  return resutl
};
// 附加信息新增
export const addAdditiveInfo= (data) => {
  console.log("附加信息新增传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/additiveInfo/addAdditiveInfo",data);
  return resutl
};
// 附加信息编辑
export const updateAdditiveInfo = (data) => {
  console.log("附加信息更新传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/additiveInfo/updateAdditiveInfo",data);
  return resutl
};
// 附加信息删除
export const deleteAdditiveInfo= (data) => {
  console.log("附加信息删除传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/additiveInfo/deleteAdditiveInfo",data);
  return resutl
};

//本行业务信息
//本行融资情况
// 批复信息列表查询
export const getApproveList = (data) => {
  console.log("批复信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/approve/approveList",data);
  return resutl
};

//业务信息列表查询
export const getContractInfoList = (data) => {
  console.log("批复业务查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/contractInfo/contractInfoList",data);
  return resutl
};

//为我行客户担保情况
// 本行保证情况列表查询
export const getSubContractList = (data) => {
  console.log("本行保证情况查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/subContract/subContractList",data);
  return resutl
};

//本行抵质押情况列表查询
export const getSubContractDYList = (data) => {
  console.log("本行抵质押情况查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/subContract/subContractListDY",data);
  return resutl
};

//我行管理团队列表查询
export const getManagementTeamList = (data) => {
  console.log("我行管理团队查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/managementTeam/managementTeamList",data);
  return resutl
};

//违约记录列表查询
export const getIllegalRecordList = (data) => {
  console.log("违约记录查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/illegalRecord/illegalRecordList",data);
  return resutl
};

//拒贷信息列表查询
export const getRefuseInfoList = (data) => {
  console.log("拒贷信息查询传入参数:",JSON.stringify(data));
  let resutl = myPost("/mybatis-service/customer/refuseInfo/refuseInfoList",data);
  return resutl
};
