package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtIntangibleAssets;
/**
 * 无形资产mapper
 * @author wuyong
 *
 */
@Mapper
public interface GrtIntangibleAssetsMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtIntangibleAssets record);

    int insertSelective(GrtIntangibleAssets record);
}