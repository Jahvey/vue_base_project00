package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizCkttfprzApprovePo;

@Mapper
public interface CsmTbBizCkttfprzApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizCkttfprzApprovePo record);

    int insertSelective(CsmTbBizCkttfprzApprovePo record);

    CsmTbBizCkttfprzApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizCkttfprzApprovePo record);

    int updateByPrimaryKey(CsmTbBizCkttfprzApprovePo record);
    
    CsmTbBizCkttfprzApprovePo queryByAmountDetailId(String amountDetailId);
}