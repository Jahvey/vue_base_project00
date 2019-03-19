package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtBill;
/**
 * 票据Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtBillMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtBill record);

    int insertSelective(GrtBill record);

    GrtBill selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtBill record);

    int updateByPrimaryKey(GrtBill record);
}