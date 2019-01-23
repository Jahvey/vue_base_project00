package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtMerchandise;
/**
 * 商品存货Mapper
 * @author wuyong
 * @date 2019.1.8
 *
 */
@Mapper
public interface GrtMerchandiseMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtMerchandise record);

    int insertSelective(GrtMerchandise record);

    GrtMerchandise selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtMerchandise record);

    int updateByPrimaryKey(GrtMerchandise record);
}