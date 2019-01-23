package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 执行规则	一般返回值为0符合，否则不满足，特殊情况会注明
 * @author Administrator
 *
 */
@Mapper
public interface CrtRuleEngineMapper {

	//在途出账校验		errMsg="该合同有未放款的业务"
	Integer checkRLON_0001(String contractId);
	
	//冻结批复不能发起出账		errMsg="批复冻结不能发起出账"
	Integer checkRCON_0027(String contractId);
	
	//移交申请未完成，包含的业务不允许处理		errMsg="该合同已被纳入[移交申请],在业务结束前无法处理"
	Integer checkXFE_0004(String contractId);
	
	//担保总金额小于合同金额		errMsg="从合同足值校验未通过"
	Integer checkRCON_0014(String contractId);
	
	//存在在途合同		errMsg="有在途合同申请"
	Integer checkRCON_0026(String amountDetailId);
	
	//存在未入库的押品	errMsg="存在未入库的押品"
	Integer checkRLON_0008(String contractId);
	
	//按揭存在未入库的押品	errMsg="存在未入库的押品"
	Integer checkRLON_0036(String contractId);
	
	//检查合同可用余额 	errMsg="合同可用余额不足不允许出账" 
	Integer checkRLON_0035(String contractId);
	
	//检查合同可用余额 	errMsg="合同可用余额不足不允许出账" 
	Integer checkRLON_0201(String contractId);
	
	//出账检查是否在合同期限内	errMsg="请在合同起止日期内出账"	targetDataList="1"  
	Integer checkRLON_0034(String contractId);
	
	//国结出账校验	errMsg="国结产品的合同出账只能做一次出账[该合同已出账]"
	Integer checkRLON_0028(String contractId);
	
	//银承、贴现是否已出账校验	errMsg="该合同已出账"
	Integer checkRLON_0033(String contractId);

	
}
