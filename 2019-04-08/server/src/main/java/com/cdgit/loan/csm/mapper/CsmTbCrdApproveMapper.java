package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbCrdApprove;

@Mapper
public interface CsmTbCrdApproveMapper {
    int deleteByPrimaryKey(String crdId);

    int insert(CsmTbCrdApprove record);

    int insertSelective(CsmTbCrdApprove record);

    CsmTbCrdApprove selectByPrimaryKey(String crdId);
    
    CsmTbCrdApprove getCrdCredit(String crdId);
    
    String getBizId(String crdId);

    int updateByPrimaryKeySelective(CsmTbCrdApprove record);

    int updateByPrimaryKey(CsmTbCrdApprove record);
    
    int updateCrdCredit(String crdId);
}