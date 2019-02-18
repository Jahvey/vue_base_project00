package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConFeePo;

@Mapper
public interface CsmTbConFeePoMapper {
    int deleteByPrimaryKey(String feeId);

    int insert(CsmTbConFeePo record);

    int insertSelective(CsmTbConFeePo record);

    CsmTbConFeePo selectByPrimaryKey(String feeId);

    int updateByPrimaryKeySelective(CsmTbConFeePo record);

    int updateByPrimaryKey(CsmTbConFeePo record);
    
    List<CsmTbConFeePo> queryListByConId(String contractDetailId);
}