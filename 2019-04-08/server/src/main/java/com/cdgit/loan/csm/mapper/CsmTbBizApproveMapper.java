package com.cdgit.loan.csm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizApprovePo;

@Mapper
public interface CsmTbBizApproveMapper {
	
	String getPartyBizIds(String partyId);
	
	TbBizApprovePo queryByApplyId(String applyId);
	
	String[] getBizIds(String crdId);
	
	TbBizApprovePo queryOneTbBizApproveByApproveId(String approveId);
	
	List<HashMap<String, Object>> getBizGrtRel(String contractId);
	
    int deleteCsmTbBizApproveByApproveId(String approveId);

    int insertCsmTbBizApprove(TbBizApprovePo record);

    int insertCsmTbBizApproveSelective(TbBizApprovePo record);

    int updateCsmTbBizApproveSelective(TbBizApprovePo record);

    int updateCsmTbBizApprove(TbBizApprovePo record);

	
}