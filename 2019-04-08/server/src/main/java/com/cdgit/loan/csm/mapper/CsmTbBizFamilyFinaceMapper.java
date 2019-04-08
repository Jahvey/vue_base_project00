package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizFamilyFinace;

@Mapper
public interface CsmTbBizFamilyFinaceMapper {
    int deleteByPrimaryKey(String financeId);

    int insert(CsmTbBizFamilyFinace record);

    int insertSelective(CsmTbBizFamilyFinace record);

    CsmTbBizFamilyFinace selectByPrimaryKey(String financeId);

    int updateByPrimaryKeySelective(CsmTbBizFamilyFinace record);

    int updateByPrimaryKey(CsmTbBizFamilyFinace record);
}