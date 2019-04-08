package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;

@Mapper
public interface CsmTbBizAmountDetailApproveMapper {
	List<TbBizAmountDetailApprovePo> queryListByAmountId(String amountId);
	
	TbBizAmountDetailApprovePo queryOneTbBizAmountDetailApproveByAmountDetailId(String amountDetailId);
	
    int insertCsmTbBizAmountDetailApprove(TbBizAmountDetailApprovePo record);

    int insertCsmTbBizAmountDetailApproveSelective(TbBizAmountDetailApprovePo record);
    


}