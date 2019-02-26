package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.bean.RefuseInfoVO;

@Mapper
public interface RefuseInfoVOMapper {
    List<RefuseInfoVO> refuseList(String partyId);
}