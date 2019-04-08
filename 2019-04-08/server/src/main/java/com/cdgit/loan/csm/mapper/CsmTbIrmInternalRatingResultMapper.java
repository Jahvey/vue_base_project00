package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbIrmInternalRatingResult;

@Mapper
public interface CsmTbIrmInternalRatingResultMapper {

	String getPartyCreditLevel(String partyId);
	
    int deleteByPrimaryKey(String irrResultId);

    int insert(CsmTbIrmInternalRatingResult record);

    int insertSelective(CsmTbIrmInternalRatingResult record);

    CsmTbIrmInternalRatingResult selectByPrimaryKey(String irrResultId);

    int updateByPrimaryKeySelective(CsmTbIrmInternalRatingResult record);

    int updateByPrimaryKey(CsmTbIrmInternalRatingResult record);
}