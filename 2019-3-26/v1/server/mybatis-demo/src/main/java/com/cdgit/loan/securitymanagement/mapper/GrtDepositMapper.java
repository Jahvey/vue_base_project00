package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtDeposit;
/**
 * 存单maper
 * @author wuyong
 *
 */
@Mapper
public interface GrtDepositMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtDeposit record);

    int insertSelective(GrtDeposit record);

    GrtDeposit selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtDeposit record);

    int updateByPrimaryKey(GrtDeposit record);
}