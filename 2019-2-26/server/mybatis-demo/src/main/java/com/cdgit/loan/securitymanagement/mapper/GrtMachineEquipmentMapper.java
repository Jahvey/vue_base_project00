package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtMachineEquipment;
/**
 * 仪器设备Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtMachineEquipmentMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtMachineEquipment record);

    int insertSelective(GrtMachineEquipment record);

    GrtMachineEquipment selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtMachineEquipment record);

    int updateByPrimaryKey(GrtMachineEquipment record);
}