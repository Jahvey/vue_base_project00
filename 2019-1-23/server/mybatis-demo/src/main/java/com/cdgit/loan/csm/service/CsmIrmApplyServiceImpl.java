/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmHisIrmVo;
import com.cdgit.loan.csm.bean.CsmImpornantEventVo;
import com.cdgit.loan.csm.mapper.CsmIrmApplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CsmIrmApplyServiceImpl {
	
	@Autowired
	CsmIrmApplyMapper csmIrmApplyMapper;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmHisIrmVo> getHisIrmByParty(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmHisIrmVo> CsmHisIrmVoQuery =csmIrmApplyMapper.getHisIrmByParty(map);
		PageInfo pageInfo=new PageInfo(CsmHisIrmVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmImpornantEventVo> getCsmImpornantEventInfo(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmImpornantEventVo> CsmHisIrmVoQuery =csmIrmApplyMapper.getCsmImpornantEventInfo(map);
		PageInfo pageInfo=new PageInfo(CsmHisIrmVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	

	

}
