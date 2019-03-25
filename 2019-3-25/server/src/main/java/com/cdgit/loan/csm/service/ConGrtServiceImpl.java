/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.ConGrtMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class ConGrtServiceImpl {

	@Autowired
	ConGrtMapper conGrtMapper;
	
	
	//将查询出来的hashmap列表整体返回到页面当中
	public  PageInfo<HashMap<String, Object>> getConGrtList(HashMap<String, Object> map) {
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<HashMap<String, Object>> getConGrtListQuery = conGrtMapper.getConDyList(map);
		PageInfo pageInfo=new PageInfo(getConGrtListQuery,(Integer)map.get("pageSize"));
		
		return pageInfo;
		
	}
	
	
	
	
}
