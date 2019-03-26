package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtRealEstateMortgage;
/**
 * 房地产类型抵押 Mapper
 * @author wuyong
 * @date 2019.1.3
 */
@Mapper
public interface GrtRealEstateMortgageMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtRealEstateMortgage record);

    int insertSelective(GrtRealEstateMortgage record);

    GrtRealEstateMortgage selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtRealEstateMortgage record);

    int updateByPrimaryKey(GrtRealEstateMortgage record);
}