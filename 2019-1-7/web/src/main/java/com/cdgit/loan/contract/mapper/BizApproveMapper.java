package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.BizApprove;

@Mapper
public interface BizApproveMapper {
	
    void deleteByPrimaryKey(String approveId);

    void insert(BizApprove record);

    void insertSelective(BizApprove record);

    /**
     * 根据传进来的ID查询一条信息
     * @param approveId
     * @return
     */
    BizApprove selectByPrimaryKey(String approveId);

    void updateByPrimaryKeySelective(BizApprove record);

    void updateByPrimaryKey(BizApprove record);
}