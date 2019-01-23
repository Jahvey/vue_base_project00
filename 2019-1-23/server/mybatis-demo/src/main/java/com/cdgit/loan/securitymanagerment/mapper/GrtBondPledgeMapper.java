package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtBondPledge;
/**
 * 债券Mapper
 * @author wuyong
 * @date 2019.1.9
 *
 */
@Mapper
public interface GrtBondPledgeMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtBondPledge record);

    int insertSelective(GrtBondPledge record);

    GrtBondPledge selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtBondPledge record);

    int updateByPrimaryKey(GrtBondPledge record);
}