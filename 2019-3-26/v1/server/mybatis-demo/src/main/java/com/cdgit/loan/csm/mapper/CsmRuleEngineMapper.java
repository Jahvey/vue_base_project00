/**
 * 
 */
package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author cwalk
 *
 */
@Mapper
public interface CsmRuleEngineMapper {

	//XFE_0002 name="参与移交的客户不允许做流程业务" errMsg="该客户已被纳入[客户移交或者机构拆并],在业务结束前无法申请新的业务"
	Integer ruleXFE_0002(String partyId);
	
	//XFE_0003 name="移交申请未完成，包含的业务不允许处理" errMsg="该批复已被纳入[移交申请],在业务结束前无法处理"
	Integer ruleXFE_0003(String approveId);
	
	//RBIZ_0001" name="客户存在在途授信业务" errMsg="已发起综合授信业务"
	Integer ruleRBIZ_0001(String partyId);
	
	//RBIZ_0002" name="客户存在已生效授信业务" errMsg="已存在生效的综合授信业务"
	Integer ruleRBIZ_0002(String partyId);
		
	//RBIZ_0206" name="该产品已存在在途用信业务申请" errMsg="该产品已存在在途用信业务申请"
	Integer ruleRBIZ_0206(@Param(value="partyId") String partyId,@Param(value="productType") String productType);
		
	//RBIZ_0019" name="是否单笔低风险" errMsg="统一授信成员只能发起低风险或银团贷款"
	Integer ruleRBIZ_0019(String partyId);
	
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
	
	
	//ruleCheck
	//RCON_0085" name="还款计划不同期次还款日期不能一样"  errMsg="还款计划不同期次还款日期不能一样" 
	Integer ruleRCON_0085(String contractId);
	
	//RCON_0053" name="还款计划金额与合同总金额不等"  errMsg="还款计划总金额不等于合同金额" 
	Integer ruleRCON_0053(String contractId);
	
	//RCON_0054" name="还款计划最后一期止期必须和合同止期一样" errMsg="还款计划最后一期止期必须和合同止期一样" 
	Integer ruleRCON_0054(String contractId);
	
	//RCON_0052" name="提款计划金额与合同总金额不等"  errMsg="提款计划总金额不等于合同金额"
	Integer ruleRCON_0052(String contractId);
	
	//RCON_0055" name="还款计划日期必须在合同起期和止期之间" errMsg="还款计划日期必须在合同起期和止期之间"
	Integer ruleRCON_0055(String contractId);
	
	//RCON_0056" name="提款计划日期必须在合同起期和止期之间"  errMsg="提款计划日期必须在合同起期和止期之间"
	Integer ruleRCON_0056(String contractId);
	
	
	
	
	
	
}
