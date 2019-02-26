package com.cdgit.loan.sysManage.acMenu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdgit.loan.sysManage.acMenu.bean.AcMenu;

@Mapper
public interface AcMenuMapper {

	 
	AcMenu selectByPrimaryKey(String menuid);
	
	List<AcMenu> queryMenuTree();
	
	List<AcMenu> queryMenuTreeByRole(String roleid);
	
	List<AcMenu> queryMenuByParentsid(String parentsid);
	
	List<AcMenu> queryMenuByRoleid(String roleid);
	
	int insertSelective(AcMenu menu);
	
	int updateByPrimaryKeySelective(AcMenu menu);
	
	int deleteByPrimaryKey(String menuid);
	
	
}
