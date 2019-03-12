package com.cdgit.loan.csm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConRepayPlanPo;

@Mapper
public interface CsmTbConRepayPlanPoMapper { 
    int deleteByPrimaryKey(String repayPlanId);

    int insert(CsmTbConRepayPlanPo record);

    int insertSelective(CsmTbConRepayPlanPo record);

    CsmTbConRepayPlanPo selectByPrimaryKey(String repayPlanId);

    int updateByPrimaryKeySelective(CsmTbConRepayPlanPo record);

    int updateByPrimaryKey(CsmTbConRepayPlanPo record);
    
    List<CsmTbConRepayPlanPo> queryListByConId(String contractId);
    
}