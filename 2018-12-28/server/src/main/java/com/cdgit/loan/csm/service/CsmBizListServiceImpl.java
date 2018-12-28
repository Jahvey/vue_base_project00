/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmBizListVo;
import com.cdgit.loan.csm.mapper.CsmBizListMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmBizListServiceImpl {
	
	@Autowired
	CsmBizListMapper csmBizListMapper;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmBizListVo> getBizList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmBizListVo> CsmBizListVoQuery = csmBizListMapper.getBizList(map);
		PageInfo pageInfo=new PageInfo(CsmBizListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	

}
