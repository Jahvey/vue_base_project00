package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConLdzjPo;
@Mapper
public interface CsmTbConLdzjPoMapper {
    int deleteByPrimaryKey(String applyDetailId);

    int insert(CsmTbConLdzjPo record);

    int insertSelective(CsmTbConLdzjPo record);

    CsmTbConLdzjPo selectByPrimaryKey(String applyDetailId);

    int updateByPrimaryKeySelective(CsmTbConLdzjPo record);

    int updateByPrimaryKey(CsmTbConLdzjPo record);
}