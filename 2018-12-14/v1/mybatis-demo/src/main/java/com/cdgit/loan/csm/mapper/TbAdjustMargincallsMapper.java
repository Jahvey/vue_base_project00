package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbAdjustMargincalls;

public interface TbAdjustMargincallsMapper {
    int deleteByPrimaryKey(String suretyId);

    int insert(TbAdjustMargincalls record);

    int insertSelective(TbAdjustMargincalls record);

    TbAdjustMargincalls selectByPrimaryKey(String suretyId);

    int updateByPrimaryKeySelective(TbAdjustMargincalls record);

    int updateByPrimaryKey(TbAdjustMargincalls record);
}