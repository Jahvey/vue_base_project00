/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmRuleEngineMapper {

	//XFE_0003 name="移交申请未完成，包含的业务不允许处理" errMsg="该批复已被纳入[移交申请],在业务结束前无法处理"
	Integer ruleXFE_0003(String approveId);
	
	//RCON_0202 name="存在在途合同" errMsg="该业务已存在在途合同申请"
	Integer ruleRCON_0202(String amountDetailId);
	
	//RCON_0203" name="存在已生效合同"  errMsg="该业务已生成合同"
	Integer ruleRCON_0203(String amountDetailId);
	
	
	//RCON_0204 name="该业务已无可用额度" errMsg="该业务已无可用额度"
	Integer ruleRCON_0204(String amountDetailId);
	
	//RBIZ_0046" name="存在在途批复调整时不得调整" errMsg="该业务存在在途调整申请"
	Integer ruleRBIZ_0046(String applyId);
	
	//RCRD_0212" name="存在在途授信调整" errMsg="该授信数据存在在途授信调整 "
	Integer ruleRCRD_0212(String crdId);
	
	
	//主合同调整
	//XFE_0004" name="移交申请未完成，包含的业务不允许处理"  errMsg="该合同已被纳入[移交申请],在业务结束前无法处理"
	Integer ruleXFE_0004(String contractId);
	
	//RCON_0024" name="存在在途综合授信协议"  errMsg="有在途综合授信协议"
	Integer ruleRCON_0024(String applyId);
	
	//RCON_0058" name="有在途批复调整时不能调整综合授信协议"  errMsg="有在途批复调整时不能调整综合授信协议"
	Integer ruleRCON_0058(String applyId);
	
	
	//RCON_0059" name="有在途合同申请或调整时不能调整综合授信协议" errMsg="有在途合同申请或调整时不能调整综合授信协议"
	Integer ruleRCON_0059(String applyId);
	
	//RCON_0026" name="存在在途合同"  errMsg="有在途合同申请"
	Integer ruleRCON_0026(String amountDetailId);
	
	//RCON_0060" name="有在途综合授信协议申请或调整时不能调整合同"  errMsg="有在途综合授信协议申请或调整时不能调整合同"
	Integer ruleRCON_0060(String contractId);
	
	//RCON_0039" name="存在在途综合授信调整或单笔批复调整时不得调整业务合同"  errMsg="存在在途综合授信调整或单笔批复调整"
	Integer ruleRCON_0039(String contractId);
	
	//RCON_0040" name="存在在途出账不得调整业务合同"  errMsg="存在在途出账"
	Integer ruleRCON_0040(String contractId);
	
	//RBIZ_0024" name="批复已冻结"  errMsg="批复已冻结"
	Integer ruleRBIZ_0024(String applyId);
	
	//RGRT_0005" name="主合同下是否有在途的担保合同调整"  errMsg="合同下有在途的担保合同$[c]调整流程"
	Integer ruleRGRT_0005(String contractId);
	
	//RGRT_0012" name="判断是否有在途的保证金追加"  errMsg="该合同有在途的保证金追加"
	Integer ruleRGRT_0012(String contractId);
	
	//RCON_0043" name="该笔合同下的存在未结清借据"  errMsg="该笔合同下有未结清借据"
	Integer ruleRCON_0043(String contractId);
	
	//RCON_0044" name="合同是否循环" errMsg="该笔合同为循环合同"
	Integer ruleRCON_0044(String contractId);
	
	//合同失效的时候 added by shendl 如果合同下有临时出库的押品 不允许做合同失效 
	//RGRT_0017" name="判断是否有临时出库的押品"  errMsg="该合同有临时出库的押品，不允许做合同失效"
	Integer ruleRGRT_0017(String contractId);
	
	//RCON_0003" name="合同基本信息未保存" checktype="ineqn" checkedFieldName="$c" targetDataList="0" errCode="2015110-001" errMsg="合同基本信息未保存" 
	Integer ruleRCON_0003(String contractId);
	
	//RCON_0205" name="合同保证金比例必须大于业务保证金比例" checktype="ge" checkedFieldName="@bzjbl" startValue="$BIZ_ASSURE_PER" errCode="2015110-001" errMsg="合同保证金比例必须大于业务保证金比例$[BIZ_ASSURE_PER]" 
	Integer ruleRCON_0205(String amountDetailId);
	
	//RCON_0089" name="校验该笔合同是否出账成功" checktype="eqn" checkedFieldName="$c" targetDataList="0" errCode="2015110-001" errMsg="该合同已出账成功合同调整不允许调整金额"
	Integer ruleRCON_0089(String contractId);
	
}
