package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtWoodlandProperty;

/**
 * 林权Mapper
 * @author wuyong
 * @date 2019.1.9
 *
 */
@Mapper
public interface GrtWoodlandPropertyMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtWoodlandProperty record);

    int insertSelective(GrtWoodlandProperty record);

    GrtWoodlandProperty selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtWoodlandProperty record);

    int updateByPrimaryKey(GrtWoodlandProperty record);
}