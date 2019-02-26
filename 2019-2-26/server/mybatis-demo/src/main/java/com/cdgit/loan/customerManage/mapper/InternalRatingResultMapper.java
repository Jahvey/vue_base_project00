package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.customerManage.bean.InternalRatingResult;

@Mapper
public interface InternalRatingResultMapper {
    int deleteByPrimaryKey(String irrResultId);

    int insert(InternalRatingResult record);

    int insertSelective(InternalRatingResult record);

    InternalRatingResult selectByPrimaryKey(String irrResultId);

    int updateByPrimaryKeySelective(InternalRatingResult record);

    int updateByPrimaryKey(InternalRatingResult record);
    
    List<InternalRatingResult> getdbjreslt(@Param("partyId") String partyId, @Param("userNum") String userNum
    		, @Param("orgNum")String orgNum, @Param("thirdPartyTypeCd")String thirdPartyTypeCd);
}