package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtTrafficShip;
/**
 * 船舶Mapper
 * @author wuyong
 * @date 2019.1.7
 *
 */
@Mapper
public interface GrtTrafficShipMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtTrafficShip record);

    int insertSelective(GrtTrafficShip record);

    GrtTrafficShip selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtTrafficShip record);

    int updateByPrimaryKey(GrtTrafficShip record);
}