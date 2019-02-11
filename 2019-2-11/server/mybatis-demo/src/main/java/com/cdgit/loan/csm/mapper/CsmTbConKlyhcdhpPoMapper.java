package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConKlyhcdhpPo;
@Mapper
public interface CsmTbConKlyhcdhpPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConKlyhcdhpPo record);

    int insertSelective(CsmTbConKlyhcdhpPo record);

    CsmTbConKlyhcdhpPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConKlyhcdhpPo record);

    int updateByPrimaryKey(CsmTbConKlyhcdhpPo record);
}