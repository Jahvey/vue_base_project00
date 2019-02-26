package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConBgdkPo;
@Mapper
public interface CsmTbConBgdkPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConBgdkPo record);

    int insertSelective(CsmTbConBgdkPo record);

    CsmTbConBgdkPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConBgdkPo record);

    int updateByPrimaryKey(CsmTbConBgdkPo record);
    
    CsmTbConBgdkPo queryByConInfo(String contractId);
}