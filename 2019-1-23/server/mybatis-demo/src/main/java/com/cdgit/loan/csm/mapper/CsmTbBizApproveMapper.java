package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizApprovePo;

@Mapper
public interface CsmTbBizApproveMapper {
	
	
	TbBizApprovePo queryOneTbBizApproveByApproveId(String approveId);
	
    int deleteCsmTbBizApproveByApproveId(String approveId);

    int insertCsmTbBizApprove(TbBizApprovePo record);

    int insertCsmTbBizApproveSelective(TbBizApprovePo record);


    int updateCsmTbBizApproveSelective(TbBizApprovePo record);

    int updateCsmTbBizApprove(TbBizApprovePo record);

	
}