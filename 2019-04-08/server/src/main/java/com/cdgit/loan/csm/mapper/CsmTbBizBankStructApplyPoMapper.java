package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizBankStructApplyPo;

@Mapper
public interface CsmTbBizBankStructApplyPoMapper {
    int deleteByPrimaryKey(String syndicatedStructId);

    int insert(CsmTbBizBankStructApplyPo record);

    int insertSelective(CsmTbBizBankStructApplyPo record);

    CsmTbBizBankStructApplyPo selectByPrimaryKey(String syndicatedStructId);

    int updateByPrimaryKeySelective(CsmTbBizBankStructApplyPo record);

    int updateByPrimaryKey(CsmTbBizBankStructApplyPo record);
    
    CsmTbBizBankStructApplyPo queryByApplyId(String applyId);
}