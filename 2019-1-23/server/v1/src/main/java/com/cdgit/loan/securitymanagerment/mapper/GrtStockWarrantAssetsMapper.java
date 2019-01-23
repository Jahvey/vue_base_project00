package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtStockWarrantAssets;
/**
 * 股权信息Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtStockWarrantAssetsMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtStockWarrantAssets record);

    int insertSelective(GrtStockWarrantAssets record);

    GrtStockWarrantAssets selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtStockWarrantAssets record);

    int updateByPrimaryKey(GrtStockWarrantAssets record);
}