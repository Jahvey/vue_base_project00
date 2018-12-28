package com.cdgit.loan.sysManage.acRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.sysManage.acRole.bean.AcRole;

import feign.Param;

@Mapper
public interface AcRoleMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(AcRole record);

    int insertSelective(AcRole record);

    AcRole selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(AcRole record);

    int updateByPrimaryKey(AcRole record);
    
    List<AcRole> queryAllRole(@Param(value = "rolename") String rolename);
}