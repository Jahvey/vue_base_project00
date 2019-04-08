package com.cdgit.loan.common.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BizDaoUtilMapper {

	void removeTbBizXmxxApply(String amountDetailId);
	
	void removeTbBizXb(String bizId);
	
	void removeTbBizYesornoApply(String applyId);
	
	void removeTbSysFlowTest(String applyId);
	
	void removeTbBizSummary(String applyId);
	
	void removeTbBizAmountApply(String applyId);
	
	void removeTbBizGrtMaxloanconApply(String applyId);
	
	void removeTbBizWyxxApply(String amountDetailId);
	
	void removeTbBizPjxxApply(String amountDetailId);
	
	void removeTbBizTxxxApply(String amountDetailId);
	
	void removeTbBizTx(String applyId);
	
//	void removeTbBizBankMemberApply(String syndicatedStructId);//待确定  直接写sql删除
	
	void removeTbBizBankMemberApply(String applyId);//待确定  直接写sql删除
	
	void removeTbBizXwHkjh(String amountDetailId);
	
	void removeTbBizBankStructApply(String applyId);
	
	int getPartyBizIds(String partyId);//查询是否有存量的批复业务
	
	Object[] getCrdByProduct(Map map);
	
}
