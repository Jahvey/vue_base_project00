package com.cdgit.loan.contract.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.contract.bean.BizAmountDetailApprove;

@Mapper
public interface BizAmountDetailApproveMapper {
	
    void insert(BizAmountDetailApprove record);

    void insertSelective(BizAmountDetailApprove record);
    
    /**
     * 测试：根据approve_id获取一条业务申请明细信息
     * @return
     */
    BizAmountDetailApprove getBizAmountDetailApproveById(String approveId);
}