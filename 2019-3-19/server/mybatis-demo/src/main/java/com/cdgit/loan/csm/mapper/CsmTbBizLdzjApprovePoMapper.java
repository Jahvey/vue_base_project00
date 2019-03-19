package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizLdzjApprovePo;

@Mapper
public interface CsmTbBizLdzjApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizLdzjApprovePo record);

    int insertSelective(CsmTbBizLdzjApprovePo record);

    CsmTbBizLdzjApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizLdzjApprovePo record);

    int updateByPrimaryKey(CsmTbBizLdzjApprovePo record);
    
    CsmTbBizLdzjApprovePo queryByAmountDetailId(String amountDetailId);
}