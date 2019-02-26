/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.ApplyJxhjBizInfoVo;
import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.mapper.CsmBizApplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmBizApplyServiceImpl {
	
	@Autowired
	CsmBizApplyMapper bizApplyMapper;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ApplyJxhjBizInfoVo> getApplyJxhjBizInfo(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ApplyJxhjBizInfoVo> ApplyJxhjBizInfoVoQuery = bizApplyMapper.getApplyJxhjBizInfo(map);
		PageInfo pageInfo=new PageInfo(ApplyJxhjBizInfoVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	

}
