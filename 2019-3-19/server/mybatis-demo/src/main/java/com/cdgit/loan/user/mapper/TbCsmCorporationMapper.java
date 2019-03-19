package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.TbCsmCorporation;
import com.cdgit.loan.user.bean.TbCsmCorporationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbCsmCorporationMapper {
    long countByExample(TbCsmCorporationExample example);

    int deleteByExample(TbCsmCorporationExample example);

    int deleteByPrimaryKey(String partyId);

    int insert(TbCsmCorporation record);

    int insertSelective(TbCsmCorporation record);

    List<TbCsmCorporation> selectByExample(TbCsmCorporationExample example);

    TbCsmCorporation selectByPrimaryKey(@Param(value = "partyId")String partyId);

    int updateByExampleSelective(@Param("record") TbCsmCorporation record, @Param("example") TbCsmCorporationExample example);

    int updateByExample(@Param("record") TbCsmCorporation record, @Param("example") TbCsmCorporationExample example);

    int updateByPrimaryKeySelective(TbCsmCorporation record);

    int updateByPrimaryKey(TbCsmCorporation record);
    
    Integer queryThirdPartythreeDB(String partyId);
}