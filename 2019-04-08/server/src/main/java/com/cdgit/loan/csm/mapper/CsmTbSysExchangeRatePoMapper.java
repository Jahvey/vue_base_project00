package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbSysExchangeRatePo;

@Mapper
public interface CsmTbSysExchangeRatePoMapper {
    int deleteByPrimaryKey(String exchangeRateId);

    int insert(CsmTbSysExchangeRatePo record);

    int insertSelective(CsmTbSysExchangeRatePo record);

    CsmTbSysExchangeRatePo selectByPrimaryKey(String exchangeRateId);

    int updateByPrimaryKeySelective(CsmTbSysExchangeRatePo record);

    int updateByPrimaryKey(CsmTbSysExchangeRatePo record);
}