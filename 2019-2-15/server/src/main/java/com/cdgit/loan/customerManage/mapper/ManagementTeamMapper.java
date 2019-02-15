package com.cdgit.loan.customerManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.customerManage.bean.ManagementTeam;

@Mapper
public interface ManagementTeamMapper {
    int deleteByPrimaryKey(String managementTeamId);

    int insert(ManagementTeam record);

    int insertSelective(ManagementTeam record);

    ManagementTeam selectByPrimaryKey(String managementTeamId);

    int updateByPartyId(ManagementTeam record);

    int updateByPrimaryKey(ManagementTeam record);
    
    List<ManagementTeam> managementTeamList(String partyId);
}