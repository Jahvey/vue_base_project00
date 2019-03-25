package com.cdgit.loan.csm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.csm.po.CsmTbConNoticeAddrsPo;

@Mapper
public interface CsmTbConNoticeAddrsPoMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(CsmTbConNoticeAddrsPo record);

    int insertSelective(CsmTbConNoticeAddrsPo record);

    CsmTbConNoticeAddrsPo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(CsmTbConNoticeAddrsPo record);

    int updateByPrimaryKey(CsmTbConNoticeAddrsPo record);
    
    CsmTbConNoticeAddrsPo queryByConId(String contractId);
}