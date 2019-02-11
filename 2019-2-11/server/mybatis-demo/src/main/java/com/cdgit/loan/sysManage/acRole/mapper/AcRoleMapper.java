package com.cdgit.loan.sysManage.acRole.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.sysManage.acMenu.bean.AcMenu;
import com.cdgit.loan.sysManage.acRole.bean.AcRole;
import com.cdgit.loan.sysManage.acRole.bean.AcRoleMenu;

import feign.Param;

@Mapper
public interface AcRoleMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(AcRole record);

    int insertSelective(AcRole record);

    AcRole selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(AcRole record);

    int updateByPrimaryKey(AcRole record);
    
    AcRoleMenu findRoleMenu(AcRoleMenu acRoleMenu);
    
    List<AcMenu> findRoleMenus(@Param(value = "roleId") String roleId);
    
    List<AcRole> queryAllRole(@Param(value = "rolename") String rolename);
    
    List<AcRole> getRolesByUserId(String userId);
    int addRoleMenu(AcRoleMenu acRoleMenu);
    
    int deleteRoleMenuByRoleId(String roleId);
}