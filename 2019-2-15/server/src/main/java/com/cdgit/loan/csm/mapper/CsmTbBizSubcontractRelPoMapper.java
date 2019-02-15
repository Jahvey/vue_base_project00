package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbBizSubcontractRelPo;

@Mapper
public interface CsmTbBizSubcontractRelPoMapper {
    int deleteByPrimaryKey(String relationId);

    int insert(CsmTbBizSubcontractRelPo record);

    int insertSelective(CsmTbBizSubcontractRelPo record);

    CsmTbBizSubcontractRelPo selectByPrimaryKey(String relationId);
    
    CsmTbBizSubcontractRelPo queryOneBySubcontractId(String subcontractId);

    int updateByPrimaryKeySelective(CsmTbBizSubcontractRelPo record);

    int updateByPrimaryKey(CsmTbBizSubcontractRelPo record);
}