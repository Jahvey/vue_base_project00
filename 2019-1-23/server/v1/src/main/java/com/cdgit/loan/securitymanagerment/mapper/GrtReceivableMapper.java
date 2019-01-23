package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtReceivable;
/**
 * 应收账款Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtReceivableMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtReceivable record);

    int insertSelective(GrtReceivable record);

    GrtReceivable selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtReceivable record);

    int updateByPrimaryKey(GrtReceivable record);
}