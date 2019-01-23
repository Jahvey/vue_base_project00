/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmIllegalListVo;
import com.cdgit.loan.csm.bean.CsmNaturalAdditiveListVo;
import com.cdgit.loan.csm.bean.CsmNaturalBusinessVo;
import com.cdgit.loan.csm.bean.CsmNaturalCreditListVo;
import com.cdgit.loan.csm.bean.CsmNaturalInfoVo;
import com.cdgit.loan.csm.bean.CsmNaturalSchoolVo;
import com.cdgit.loan.csm.bean.CsmRelativePsnListVo;
import com.cdgit.loan.csm.mapper.CsmNatrualMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CsmNatrualServiceImpl {
	
	@Autowired
	CsmNatrualMapper csmNatrualMapper;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmNaturalInfoVo> getNaturalInfo(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmNaturalInfoVo> CsmNaturalInfoVoQuery =csmNatrualMapper.getNaturalInfo(map) ;
		PageInfo pageInfo=new PageInfo(CsmNaturalInfoVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmRelativePsnListVo> getRelativePsnList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmRelativePsnListVo> CsmRelativePsnListVoQuery =csmNatrualMapper.getRelativePsnList(map) ;
		PageInfo pageInfo=new PageInfo(CsmRelativePsnListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmNaturalBusinessVo> queryNaturalBusiness(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmNaturalBusinessVo> CsmNaturalBusinessVoQuery =csmNatrualMapper.queryNaturalBusiness(map);
		PageInfo pageInfo=new PageInfo(CsmNaturalBusinessVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmNaturalSchoolVo> queryNaturalSchool(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmNaturalSchoolVo> CsmNaturalSchoolVoQuery =csmNatrualMapper.queryNaturalSchool(map);
		PageInfo pageInfo=new PageInfo(CsmNaturalSchoolVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmNaturalCreditListVo> getNaturalCreditList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmNaturalCreditListVo> CsmNaturalCreditListVoQuery =csmNatrualMapper.getNaturalCreditList(map);
		PageInfo pageInfo=new PageInfo(CsmNaturalCreditListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmIllegalListVo> getIllegalList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmIllegalListVo> CsmIllegalListVoQuery =csmNatrualMapper.getIllegalList(map);
		PageInfo pageInfo=new PageInfo(CsmIllegalListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmNaturalAdditiveListVo> getAdditiveList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmNaturalAdditiveListVo> CsmNaturalAdditiveListVoQuery =csmNatrualMapper.getAdditiveList(map);
		PageInfo pageInfo=new PageInfo(CsmNaturalAdditiveListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}

}
