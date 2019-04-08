package com.cdgit.loan.contract.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.contract.bean.CrtTbOrgAccRel;
import com.cdgit.loan.contract.mapper.CrtOrganizationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 *组织机构相关
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class CrtOrganizationServiceImpl {

	@Autowired
	CrtOrganizationMapper organizationMapper;
	
	
	/**
	 * 分页查询经办机构与会计机构关联表
	 * 	pageNum：当前页
	 * 	pageSize：每页条数
	 * @param map
	 * @return	
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CrtTbOrgAccRel> searchOrgAccRelList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CrtTbOrgAccRel> orgAccRelList = organizationMapper.searchOrgAccRelList(map);
        PageInfo pageInfo=new PageInfo(orgAccRelList,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	
}
