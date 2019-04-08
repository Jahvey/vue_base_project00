package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbSysBasicRatePo;
@Mapper
public interface CsmTbSysBasicRatePoMapper {
	
	CsmTbSysBasicRatePo selectByIntRateCd(String intRateCd);
	
    int deleteByPrimaryKey(String intRateId);

    int insert(CsmTbSysBasicRatePo record);

    int insertSelective(CsmTbSysBasicRatePo record);

    CsmTbSysBasicRatePo selectByPrimaryKey(String intRateId);

    int updateByPrimaryKeySelective(CsmTbSysBasicRatePo record);

    int updateByPrimaryKey(CsmTbSysBasicRatePo record);
}