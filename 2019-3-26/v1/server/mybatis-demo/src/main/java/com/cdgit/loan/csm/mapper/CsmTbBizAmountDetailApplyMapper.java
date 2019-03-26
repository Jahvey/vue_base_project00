package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizAmountDetailApply;

@Mapper
public interface CsmTbBizAmountDetailApplyMapper {
    int deleteByPrimaryKey(String amountDetailId);

    int insert(CsmTbBizAmountDetailApply record);

    int insertSelective(CsmTbBizAmountDetailApply record);

    CsmTbBizAmountDetailApply selectByPrimaryKey(String amountDetailId);

    int updateByPrimaryKeySelective(CsmTbBizAmountDetailApply record);

    int updateByPrimaryKey(CsmTbBizAmountDetailApply record);
}