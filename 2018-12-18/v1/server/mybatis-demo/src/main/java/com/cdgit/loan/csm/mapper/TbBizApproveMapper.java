package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbBizApprove;

public interface TbBizApproveMapper {
    int deleteByPrimaryKey(String approveId);

    int insert(TbBizApprove record);

    int insertSelective(TbBizApprove record);

    TbBizApprove selectByPrimaryKey(String approveId);

    int updateByPrimaryKeySelective(TbBizApprove record);

    int updateByPrimaryKey(TbBizApprove record);
}