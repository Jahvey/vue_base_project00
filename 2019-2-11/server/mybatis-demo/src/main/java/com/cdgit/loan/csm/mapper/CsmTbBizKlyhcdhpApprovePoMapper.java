package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizKlyhcdhpApprovePo;

@Mapper
public interface CsmTbBizKlyhcdhpApprovePoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbBizKlyhcdhpApprovePo record);

    int insertSelective(CsmTbBizKlyhcdhpApprovePo record);

    CsmTbBizKlyhcdhpApprovePo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbBizKlyhcdhpApprovePo record);

    int updateByPrimaryKey(CsmTbBizKlyhcdhpApprovePo record);
    
    CsmTbBizKlyhcdhpApprovePo queryByAmountDetailId(String amountDetailId);
}