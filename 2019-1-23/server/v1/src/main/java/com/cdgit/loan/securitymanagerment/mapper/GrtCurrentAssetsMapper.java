package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtCurrentAssets;
/**
 * 流动资产Mapper
 * @author wuyong
 * @date 2019.1.8
 *
 */
@Mapper
public interface GrtCurrentAssetsMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtCurrentAssets record);

    int insertSelective(GrtCurrentAssets record);
}