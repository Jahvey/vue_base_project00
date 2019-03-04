package com.cdgit.loan.user.mapper;

import com.cdgit.loan.user.bean.TbCsmManagementTeam;

public interface TbCsmManagementTeamMapper {
    int deleteByPrimaryKey(String MANAGEMENT_TEAM_ID);

    int insert(TbCsmManagementTeam record);

    int insertSelective(TbCsmManagementTeam record);

    TbCsmManagementTeam selectByPrimaryKey(String MANAGEMENT_TEAM_ID);

    int updateByPrimaryKeySelective(TbCsmManagementTeam record);

    int updateByPrimaryKey(TbCsmManagementTeam record);
}