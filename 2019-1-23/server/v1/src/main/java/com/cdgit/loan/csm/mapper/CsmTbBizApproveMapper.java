package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizApprovePo;

@Mapper
public interface CsmTbBizApproveMapper {
	
	
	TbBizApprovePo queryOneTbBizApproveByApproveId(String approveId);

	
}