package scim.loan.dao;

import scim.loan.domain.TbCsmManagementTeam;

public interface TbCsmManagementTeamMapper {
    int deleteByPrimaryKey(String managementTeamId);

    int insert(TbCsmManagementTeam record);

    int insertSelective(TbCsmManagementTeam record);

    TbCsmManagementTeam selectByPrimaryKey(String managementTeamId);

    int updateByPrimaryKeySelective(TbCsmManagementTeam record);

    int updateByPrimaryKey(TbCsmManagementTeam record);
}