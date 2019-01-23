package com.cdgit.loan.customerManage.approve.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.approve.bean.Approve;

@Mapper
public interface ApproveMapper {
    int deleteByPrimaryKey(String approveId);

    int insert(Approve record);

    int insertSelective(Approve record);

    Approve selectByPrimaryKey(String approveId);

    int updateByPrimaryKeySelective(Approve record);

    int updateByPrimaryKey(Approve record);

	List<Approve> financingList(String partyId);
}