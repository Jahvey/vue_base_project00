package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConCreditInfoPo;
@Mapper
public interface CsmTbConCreditInfoPoMapper {
    int deleteByPrimaryKey(String contractId);

    int insert(CsmTbConCreditInfoPo record);

    int insertSelective(CsmTbConCreditInfoPo record);

    CsmTbConCreditInfoPo selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(CsmTbConCreditInfoPo record);

    int updateByPrimaryKey(CsmTbConCreditInfoPo record);
}