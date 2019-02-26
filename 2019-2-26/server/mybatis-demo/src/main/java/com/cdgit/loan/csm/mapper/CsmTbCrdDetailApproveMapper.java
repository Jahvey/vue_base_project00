package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbCrdDetailApprove;

@Mapper
public interface CsmTbCrdDetailApproveMapper {
    int deleteByPrimaryKey(String crdDtlId);

    int insert(CsmTbCrdDetailApprove record);

    int insertSelective(CsmTbCrdDetailApprove record);

    CsmTbCrdDetailApprove selectByPrimaryKey(String crdDtlId);
    
    String[] getCrdDtlIds(String crdId);

    int updateByPrimaryKeySelective(CsmTbCrdDetailApprove record);

    int updateByPrimaryKey(CsmTbCrdDetailApprove record);
}