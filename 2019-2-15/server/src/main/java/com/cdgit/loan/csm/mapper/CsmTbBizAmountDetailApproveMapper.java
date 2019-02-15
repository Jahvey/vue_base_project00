package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;

@Mapper
public interface CsmTbBizAmountDetailApproveMapper {
	
	
	TbBizAmountDetailApprovePo queryOneTbBizAmountDetailApproveByAmountDetailId(String amountDetailId);
	
    int insertCsmTbBizAmountDetailApprove(TbBizAmountDetailApprovePo record);

    int insertCsmTbBizAmountDetailApproveSelective(TbBizAmountDetailApprovePo record);
    


}