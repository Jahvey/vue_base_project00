package com.cdgit.loan.customerManage.naturalRelative.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.naturalRelative.bean.NaturalRelative;

@Mapper
public interface NaturalRelativeMapper {
    int deleteByPrimaryKey(String naturalRelativeId);

    int insert(NaturalRelative record);

    int insertSelective(NaturalRelative record);

    NaturalRelative selectByPrimaryKey(String naturalRelativeId);

    int updateByPrimaryKeySelective(NaturalRelative record);

    int updateByPrimaryKey(NaturalRelative record);

	List<NaturalRelative> selectByPartyId(String partyId);
}