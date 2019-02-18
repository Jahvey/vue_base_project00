package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.BizApprove;

@Mapper
public interface BizApproveMapper {
	
    /**
     * 根据传进来的ID查询一条信息
     * @param approveId
     * @return
     */
    BizApprove queryBizApproveByApproveId(String approveId);
}