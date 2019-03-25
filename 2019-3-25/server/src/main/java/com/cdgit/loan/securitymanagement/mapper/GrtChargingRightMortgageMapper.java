package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtChargingRightMortgage;

/**
 * 收费权Mappeer
 * @author wuyong
 * @date 2019.1.9
 *
 */
@Mapper
public interface GrtChargingRightMortgageMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtChargingRightMortgage record);

    int insertSelective(GrtChargingRightMortgage record);

    GrtChargingRightMortgage selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtChargingRightMortgage record);

    int updateByPrimaryKey(GrtChargingRightMortgage record);
}