package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbLstInfo;

public interface TbLstInfoMapper {
    int deleteByPrimaryKey(String partyId);

    int insert(TbLstInfo record);

    int insertSelective(TbLstInfo record);

    TbLstInfo selectByPrimaryKey(String partyId);

    int updateByPrimaryKeySelective(TbLstInfo record);

    int updateByPrimaryKey(TbLstInfo record);
}