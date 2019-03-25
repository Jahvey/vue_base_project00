package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.bean.CsmTbBizTx;

@Mapper
public interface CsmTbBizTxMapper {
    int deleteByPrimaryKey(String txId);

    int insert(CsmTbBizTx record);

    int insertSelective(CsmTbBizTx record);

    CsmTbBizTx selectByPrimaryKey(String txId);

    int updateByPrimaryKeySelective(CsmTbBizTx record);

    int updateByPrimaryKey(CsmTbBizTx record);
}