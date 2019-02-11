package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbCsmGroupCompanyPo;

@Mapper
public interface CsmTbCsmGroupCompanyPoMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(CsmTbCsmGroupCompanyPo record);

    int insertSelective(CsmTbCsmGroupCompanyPo record);

    CsmTbCsmGroupCompanyPo selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(CsmTbCsmGroupCompanyPo record);

    int updateByPrimaryKey(CsmTbCsmGroupCompanyPo record);
}