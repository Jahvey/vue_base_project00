package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizMyhtxxApplyPo;

@Mapper
public interface CsmTbBizMyhtxxApplyPoMapper {
    int deleteByPrimaryKey(String htId);

    int insert(CsmTbBizMyhtxxApplyPo record);

    int insertSelective(CsmTbBizMyhtxxApplyPo record);

    CsmTbBizMyhtxxApplyPo selectByPrimaryKey(String htId);

    int updateByPrimaryKeySelective(CsmTbBizMyhtxxApplyPo record);

    int updateByPrimaryKey(CsmTbBizMyhtxxApplyPo record);
    
    List<CsmTbBizMyhtxxApplyPo> queryListByAmtDetailId(String amountDetailId);
}