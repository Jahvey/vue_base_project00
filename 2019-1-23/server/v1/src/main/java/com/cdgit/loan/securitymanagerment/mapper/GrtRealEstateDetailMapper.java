package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtRealEstateDetail;
/**
 * 抵质押品 房地产 Mapper
 * @author wuyong
 * @date 2019.1.3
 *
 */
@Mapper
public interface GrtRealEstateDetailMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtRealEstateDetail record);

    int insertSelective(GrtRealEstateDetail record);

    GrtRealEstateDetail selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtRealEstateDetail record);

    int updateByPrimaryKey(GrtRealEstateDetail record);
}