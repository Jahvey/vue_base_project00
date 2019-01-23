package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtBuildingProject;
/**
 * 在建工程 Mapper
 * @author wuyong
 * @date 2018.1.3
 *
 */
@Mapper
public interface GrtBuildingProjectMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtBuildingProject record);

    int insertSelective(GrtBuildingProject record);

    GrtBuildingProject selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtBuildingProject record);

    int updateByPrimaryKey(GrtBuildingProject record);
}