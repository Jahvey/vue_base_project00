package com.cdgit.loan.securitymanagement.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.securitymanagement.bean.GrtTrafficOthers;
/**
 * 交通运输工具（其他交通工具）Mapper
 * @author wuyong
 * @date 2019.1.11
 *
 */
@Mapper
public interface GrtTrafficOthersMapper {
    int deleteByPrimaryKey(String guarantyId);

    int insert(GrtTrafficOthers record);

    int insertSelective(GrtTrafficOthers record);

    GrtTrafficOthers selectByPrimaryKey(String guarantyId);

    int updateByPrimaryKeySelective(GrtTrafficOthers record);

    int updateByPrimaryKey(GrtTrafficOthers record);
}