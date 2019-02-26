package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CsmExeRuleEngineMapper {
	
	//移交申请未完成，包含的业务不允许处理  调整
	Integer ruleEngine_XFE_0006(String subcontractId);
	
	//校验是否已经有在途的担保合同调整
	Integer ruleEngine_SUBCON_FLOW(String subcontractId);
	
	//校验是否已经有在途的主合同调整
	Integer ruleEngine_RGRT_0006(String subcontractId);
	
	//added by shendl 判断是否有在途的保证金追加
	Integer ruleEngine_SUBCON_0009(String subcontractId);
	
	
	
}
