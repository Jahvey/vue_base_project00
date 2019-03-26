package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbLstInfo;

@Mapper
public interface CsmTbLstInfoMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(CsmTbLstInfo record);

    int insertSelective(CsmTbLstInfo record);

    CsmTbLstInfo selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(CsmTbLstInfo record);

    int updateByPrimaryKey(CsmTbLstInfo record);
}