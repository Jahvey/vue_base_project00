package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConGdzcdkPo;

@Mapper
public interface CsmTbConGdzcdkPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConGdzcdkPo record);

    int insertSelective(CsmTbConGdzcdkPo record);

    CsmTbConGdzcdkPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConGdzcdkPo record);

    int updateByPrimaryKey(CsmTbConGdzcdkPo record);
}