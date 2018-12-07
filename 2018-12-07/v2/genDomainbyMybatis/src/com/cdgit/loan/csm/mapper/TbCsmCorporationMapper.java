package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cdgit.loan.csm.bean.TbCsmCorporation;
import com.cdgit.loan.csm.bean.TbCsmCorporationExample;

public interface TbCsmCorporationMapper {
    long countByExample(TbCsmCorporationExample example);

    int deleteByExample(TbCsmCorporationExample example);

    int deleteByPrimaryKey(String partyId);

    int insert(TbCsmCorporation record);

    int insertSelective(TbCsmCorporation record);

    List<TbCsmCorporation> selectByExample(TbCsmCorporationExample example);

    TbCsmCorporation selectByPrimaryKey(String partyId);

    int updateByExampleSelective(@Param("record") TbCsmCorporation record, @Param("example") TbCsmCorporationExample example);

    int updateByExample(@Param("record") TbCsmCorporation record, @Param("example") TbCsmCorporationExample example);

    int updateByPrimaryKeySelective(TbCsmCorporation record);

    int updateByPrimaryKey(TbCsmCorporation record);
}