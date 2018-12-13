package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.TbLstInfo;

@Mapper
public interface TbLstInfoMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(TbLstInfo record);

    int insertSelective(TbLstInfo record);

    TbLstInfo selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(TbLstInfo record);

    int updateByPrimaryKey(TbLstInfo record);
}