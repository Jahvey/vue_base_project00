package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtEarningsAccount;

/**
 * 工资账户Mapper
 * @author wuyong
 * @date 2019.1.8
 *
 */
@Mapper
public interface GrtEarningsAccountMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtEarningsAccount record);

    int insertSelective(GrtEarningsAccount record);

    GrtEarningsAccount selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtEarningsAccount record);

    int updateByPrimaryKey(GrtEarningsAccount record);
}