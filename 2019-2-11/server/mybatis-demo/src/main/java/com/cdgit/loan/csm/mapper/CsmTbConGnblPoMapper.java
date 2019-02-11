package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConGnblPo;
@Mapper
public interface CsmTbConGnblPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConGnblPo record);

    int insertSelective(CsmTbConGnblPo record);

    CsmTbConGnblPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConGnblPo record);

    int updateByPrimaryKey(CsmTbConGnblPo record);
}