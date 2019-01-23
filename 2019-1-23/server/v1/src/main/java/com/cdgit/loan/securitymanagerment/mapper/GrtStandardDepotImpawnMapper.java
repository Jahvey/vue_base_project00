package com.cdgit.loan.securitymanagerment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtStandardDepotImpawn;
/**
 * 仓单Mapper
 * @author wuyong
 * @date 2019.1.10
 *
 */
@Mapper
public interface GrtStandardDepotImpawnMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtStandardDepotImpawn record);

    int insertSelective(GrtStandardDepotImpawn record);

    GrtStandardDepotImpawn selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtStandardDepotImpawn record);

    int updateByPrimaryKey(GrtStandardDepotImpawn record);
}