package com.cdgit.loan.csm.mapper;

import com.cdgit.loan.csm.bean.TbCsmManagementTeam;

public interface TbCsmManagementTeamMapper {
    int deleteByPrimaryKey(String MANAGEMENT_TEAM_ID);

    int insert(TbCsmManagementTeam record);

    int insertSelective(TbCsmManagementTeam record);

    TbCsmManagementTeam selectByPrimaryKey(String MANAGEMENT_TEAM_ID);

    int updateByPrimaryKeySelective(TbCsmManagementTeam record);

    int updateByPrimaryKey(TbCsmManagementTeam record);
}