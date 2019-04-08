package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConGjInfoPo;
@Mapper
public interface CsmTbConGjInfoPoMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(CsmTbConGjInfoPo record);

    int insertSelective(CsmTbConGjInfoPo record);

    CsmTbConGjInfoPo selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(CsmTbConGjInfoPo record);

    int updateByPrimaryKey(CsmTbConGjInfoPo record);
}