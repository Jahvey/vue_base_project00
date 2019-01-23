/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmEntrustAccountVo;
import com.cdgit.loan.csm.bean.CsmNatrualPersonVo;
import com.cdgit.loan.csm.mapper.CsmNatrualPersonMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 * @Time   下午5:33:58
 * @filepath com.cdgit.loan.csm.service
 * @filename CsmNatrualPersonServiceImpl.java
 */
@Service
@Transactional
public class CsmNatrualPersonServiceImpl {
	
	@Autowired
	CsmNatrualPersonMapper csmNatrualPersonMapper;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmNatrualPersonVo> queryNaturalForDesk(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmNatrualPersonVo> CsmNatrualPersonVoQuery = csmNatrualPersonMapper.queryNaturalForDesk(map);
		PageInfo pageInfo=new PageInfo(CsmNatrualPersonVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmEntrustAccountVo> getEntrustAccountsByPartyId(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmEntrustAccountVo> CsmEntrustAccountVoQuery = csmNatrualPersonMapper.getEntrustAccountsByPartyId(map);
		PageInfo pageInfo=new PageInfo(CsmEntrustAccountVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	
	
	

}
