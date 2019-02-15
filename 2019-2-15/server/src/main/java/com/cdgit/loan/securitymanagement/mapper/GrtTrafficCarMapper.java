package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtTrafficCar;
/**
 * 机动车Mapper
 * @author wuyong
 * @date 2019.1.7
 *
 */
@Mapper
public interface GrtTrafficCarMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtTrafficCar record);

    int insertSelective(GrtTrafficCar record);

    GrtTrafficCar selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtTrafficCar record);

    int updateByPrimaryKey(GrtTrafficCar record);
}