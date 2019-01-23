package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtStockRightAssets;
/**
 * 股票信息Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtStockRightAssetsMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtStockRightAssets record);

    int insertSelective(GrtStockRightAssets record);

    GrtStockRightAssets selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtStockRightAssets record);

    int updateByPrimaryKey(GrtStockRightAssets record);
}