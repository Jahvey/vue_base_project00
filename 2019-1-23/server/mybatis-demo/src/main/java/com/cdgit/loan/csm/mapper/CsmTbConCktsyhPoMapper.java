package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.po.CsmTbConCktsyhPo;

public interface CsmTbConCktsyhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConCktsyhPo record);

    int insertSelective(CsmTbConCktsyhPo record);

    CsmTbConCktsyhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConCktsyhPo record);

    int updateByPrimaryKey(CsmTbConCktsyhPo record);
}