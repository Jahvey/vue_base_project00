package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConPayoutPlanPo;

@Mapper
public interface CsmTbConPayoutPlanPoMapper {
    int deleteByPrimaryKey(String payoutPlanId);

    int insert(CsmTbConPayoutPlanPo record);

    int insertSelective(CsmTbConPayoutPlanPo record);

    CsmTbConPayoutPlanPo selectByPrimaryKey(String payoutPlanId);

    int updateByPrimaryKeySelective(CsmTbConPayoutPlanPo record);

    int updateByPrimaryKey(CsmTbConPayoutPlanPo record);
    
    List<CsmTbConPayoutPlanPo> queryListByConDetailId(String contractDetailId);
}