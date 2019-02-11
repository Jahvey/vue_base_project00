package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConBhPo;
@Mapper
public interface CsmTbConBhPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConBhPo record);

    int insertSelective(CsmTbConBhPo record);

    CsmTbConBhPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConBhPo record);

    int updateByPrimaryKey(CsmTbConBhPo record);
}