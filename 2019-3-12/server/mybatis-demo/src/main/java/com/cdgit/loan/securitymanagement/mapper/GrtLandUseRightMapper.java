package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtLandUseRight;

/**
 * 土地使用权mapper
 * @author wuyong
 * @date 2019.1.8
 *
 */
@Mapper
public interface GrtLandUseRightMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtLandUseRight record);

    int insertSelective(GrtLandUseRight record);

    GrtLandUseRight selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtLandUseRight record);

    int updateByPrimaryKey(GrtLandUseRight record);
}