package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConGjfftPo;
@Mapper
public interface CsmTbConGjfftPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConGjfftPo record);

    int insertSelective(CsmTbConGjfftPo record);

    CsmTbConGjfftPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConGjfftPo record);

    int updateByPrimaryKey(CsmTbConGjfftPo record);
}