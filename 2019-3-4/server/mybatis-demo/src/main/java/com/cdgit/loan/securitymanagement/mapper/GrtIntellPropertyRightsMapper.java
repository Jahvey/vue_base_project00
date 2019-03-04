package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtIntellPropertyRights;
/**
 * 知识产权Mapper
 * @author wuyong
 * @date 2019.1.9
 *
 */
@Mapper
public interface GrtIntellPropertyRightsMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtIntellPropertyRights record);

    int insertSelective(GrtIntellPropertyRights record);

    GrtIntellPropertyRights selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtIntellPropertyRights record);

    int updateByPrimaryKey(GrtIntellPropertyRights record);
}