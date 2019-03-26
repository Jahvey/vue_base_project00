package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtFund;
/**
 * 基金Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtFundMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtFund record);

    int insertSelective(GrtFund record);

    GrtFund selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtFund record);

    int updateByPrimaryKey(GrtFund record);
}