/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmNaturalInfoVo;
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
	

}
