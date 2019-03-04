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
export function objToStrMap(obj) {
    let strMap = new Map()
    for (let k of Object.keys(obj)) {
      //
      console.log("k:"+k)
      k=k.replace(/[%22]/g, "")
      if(obj[k]!=null){
        obj[k]=obj[k].replace(/[%22]/g, "")
      }

      strMap.set(k, obj[k])
    }
    return strMap
  }

export function jsonToStrMap(jsonStr){
  return objToStrMap(JSON.parse(jsonStr))
}

//con_info_ht.vue
export function updateConInfo(queryParams){
  console.log(queryParams)
  return myGet("/mybatis-service/process/ApplyDaoEos/updateConInfo",queryParams)

}

export function getMonthAddDate(queryParams){
  console.log(queryParams)
  return myGet("/mybatis-service/process/dateCountUtil/MonthAddDate",queryParams)

}

export function getTermByEndDate(queryParams){
  console.log(queryParams)
  return myGet("/mybatis-service/process/dateCountUtil/getTermByEndDate",queryParams)

}

export function getChangeRate(queryParams){
  console.log(queryParams)
  return myGet("/mybatis-service/process/conInfoSxxy/getChangeRate",queryParams)

}


//con_apply_tz.jsp

export function updateValidateForCon(queryParams) {
  // body...
  console.log(queryParams)
  return myGet('/mybatis-service/ruleEngine/updateValidateForCon',queryParams)
}

export function disabValidateForCon(queryParams) {
  // body...
  console.log(queryParams)
  return myGet('/mybatis-service/ruleEngine/disabValidateForCon',queryParams)
}

//合同调整接口
export function tzContractInfo(queryParams) {
  // body...
  console.log(queryParams)
  return myGet('/mybatis-service/process/conApply/tzContractInfo',queryParams)
}



//合同失效
//获取业务性质
export function getConInfoBizType(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/conApply/getConInfoBizType',queryParams)
}

//合同失效主要功能
export function disConInfo(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/conApply/disConInfo',queryParams)
}


//合同失效后通知押品系统
export function disConSynColl(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/conSynToCollByWebService/disConSynColl',queryParams)
}




//con_tree.jsp
//先将品种对应的合同明细页面取出来

export function getDetailJspByContractId(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/conContractInfo/getDetailJspByContractId',queryParams)
}


export function getConInfoMapByContarctId(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/conInfoSxxy/getConInfoMapByContarctId',queryParams)
}


//根据合同id 拿到相关合同明细
export function getConInfoByContarctId(queryParams) {
  console.log("myGet getConInfoByContarctId..."+JSON.stringify(queryParams))
  return myGet('/mybatis-service/process/conInfoSxxy/getConInfoByContarctId',queryParams)
}

export function getBankTeamStruct(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/bizInfo/getBankTeamStruct',queryParams)

}

export function saveConInfoToPro(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/conApply/saveConInfoToPro',queryParams)
}

export function RuleEngineMapper(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/rule/RuleEngineMapper',queryParams)
}


//合同签约 合同创建
export function createConInfo(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/ApplyDaoEos/create',queryParams)
}


export function getApproveAndSxxy(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/process/getApproveAndSxxy',queryParams)
}


//测试合同调整传入map数据能否接受，测试成功
export function MainConConractUpdateValidate(queryParams) {
  console.log(queryParams)
  console.log("jsonToStrMap(queryParams)"+objToStrMap(queryParams))
  return myGet('/mybatis-service/ruleEngine/MainConConractUpdateValidate', queryParams)
}



//得到抵押合同列表 2019/2/22
export function getConGrtList(queryParams) {
  // body...
  console.log(queryParams)
  return myGet('/mybatis-service/conGrt/getConGrtList',queryParams)
}



//
export function getApproveCons(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/conApply/getApproveCons', queryParams)
}
//获取打印合同列表
export function getPrintCons(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/conApply/getPrintCons', queryParams)
}

export function findSubContractList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/subContractManage/findSubContractList', queryParams)
}



//查询自然人委托方账户信息
export function getEntrustAccountsByPartyId(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getEntrustAccountsByPartyId', queryParams)
}

//查询自然人关联关系
export function getRelativePsnList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getRelativePsnList', queryParams)
}


//查询自然人信用信息
export function queryNaturalBusiness(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/queryNaturalBusiness', queryParams)
}


//查询自然人
export function queryNaturalSchool(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/queryNaturalSchool', queryParams)
}

//查询自然人客户信用信息
export function getNaturalCreditList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getNaturalCreditList', queryParams)
}



//查询自然人评级历史列表查询生效的评级信息
export function getHisIrmByParty(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/corporation/getHisIrmByParty', queryParams)
}



export function getCsmImpornantEventInfo(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/corporation/getCsmImpornantEventInfo', queryParams)
}

//附加信息
export function getAdditiveList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getAdditiveList', queryParams)
}


//本行融资情况-批复
export function getfinancingList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getfinancingList', queryParams)
}


//本行融资情况  业务
export function getfinancingListYW(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getfinancingListYW', queryParams)
}


//为我行客户担保情况
export function getGuaranteeList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getGuaranteeList', queryParams)
}



export function getGuaranteeListDY(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/myBank/getGuaranteeListDY', queryParams)
}


//违约记录
export function getIllegalList(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/getIllegalList', queryParams)
}




//额度信息
//查询对公、自然人、同业额度历史列表
export function queryCorpHis(queryParams){
  console.log(queryParams)
  return myGet('/mybatis-service/CrdApply/queryCorpHis',queryParams)
}

//业务信息

export function getBizInfo(queryParams){

  console.log(queryParams)
  return myGet('/mybatis-service/BizInfo/getBizInfo',queryParams)
}

//
export function getBizList(queryParams){

  console.log(queryParams)
  return myGet('/mybatis-service/BizSql/getBizList',queryParams)
}
//借新还旧(循环通/续借贷)
export function getApplyJxhjBizInfo(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/bizApply/getApplyJxhjBizInfo', queryParams)
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


export function queryNaturalForDesk(queryParams) {
  console.log(queryParams)
  return myGet('/mybatis-service/natural/queryNaturalForDesk', queryParams)
}


//测试获取自然人客户列表
// export function queryNaturalForDesk(queryParams) {
//   return request({
//     url: 'mybatis-service/user/queryNaturalForDesk',
//     method: 'post',
//     entity: queryParams
//   })
// }

//测试获取自然人客户信息
// export function getNaturalPersonInfoById(queryParams) {
//   return request({
//     url: 'mybatis-service/user/getNaturalPersonInfoById',
//     method: 'post',
//     entity: queryParams
//   })
// }

