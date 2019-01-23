package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtVehicleTypeMortgage;
/**
 * 交通运输设备Mapper
 * @author wuyong
 * @date 2019.1.7
 *
 */
@Mapper
public interface GrtVehicleTypeMortgageMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtVehicleTypeMortgage record);

    int insertSelective(GrtVehicleTypeMortgage record);

    GrtVehicleTypeMortgage selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtVehicleTypeMortgage record);

    int updateByPrimaryKey(GrtVehicleTypeMortgage record);
}