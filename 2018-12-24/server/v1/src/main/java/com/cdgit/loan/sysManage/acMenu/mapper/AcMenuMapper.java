package com.cdgit.loan.sysManage.acMenu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.sysManage.acMenu.bean.AcMenu;

import feign.Param;

@Mapper
public interface AcMenuMapper {
    int deleteByPrimaryKey(String menuid);

    int insert(AcMenu record);

    int insertSelective(AcMenu record);

    AcMenu selectByPrimaryKey(String menuid);

    int updateByPrimaryKeySelective(AcMenu record);

    int updateByPrimaryKey(AcMenu record);
    
    List<AcMenu> queryMenuTree();
    
    List<AcMenu> queryMenuByParentsid(@Param(value = "parentsid") String parentsid);
}