package com.cdgit.loan.csm.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmConCreditInfo;
import com.cdgit.loan.csm.bean.CsmTbBizApprove;

@Mapper
public interface CsmConInfoBaseVoMapper {
	
	
	//查询协议信息
	List<CsmConCreditInfo> getCsmTbConCreditInfo(String contractId);
	
	//查询批复信息
	CsmTbBizApprove  queryCsmTbBizApproveVoInfo(String applyId);
	
	
	

}
