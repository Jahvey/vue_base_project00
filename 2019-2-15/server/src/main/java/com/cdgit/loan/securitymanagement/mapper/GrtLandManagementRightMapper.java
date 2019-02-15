package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtLandManagementRight;
/**
 * 土地经营权Mapper
 * @author wuyong
 * @date 2019.1.8
 *
 */
@Mapper
public interface GrtLandManagementRightMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtLandManagementRight record);

    int insertSelective(GrtLandManagementRight record);

    GrtLandManagementRight selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtLandManagementRight record);

    int updateByPrimaryKey(GrtLandManagementRight record);
}