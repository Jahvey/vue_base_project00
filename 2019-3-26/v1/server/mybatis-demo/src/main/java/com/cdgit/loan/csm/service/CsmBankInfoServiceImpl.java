/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmBankFinancingListVo;
import com.cdgit.loan.csm.bean.CsmBankFinancingListYWVo;
import com.cdgit.loan.csm.bean.CsmBankGuaranteeListVo;
import com.cdgit.loan.csm.mapper.CsmBankInfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmBankInfoServiceImpl {
	
	
	@Autowired
	CsmBankInfoMapper csmBankInfoMapper;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmBankFinancingListVo> getfinancingList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmBankFinancingListVo> CsmBankFinancingListVoQuery = csmBankInfoMapper.getfinancingList(map);
		PageInfo pageInfo=new PageInfo(CsmBankFinancingListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmBankFinancingListYWVo> getfinancingListYW(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmBankFinancingListYWVo> CsmBankFinancingListYWVoQuery = csmBankInfoMapper.getfinancingListYW(map);
		PageInfo pageInfo=new PageInfo(CsmBankFinancingListYWVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmBankGuaranteeListVo> getGuaranteeList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmBankGuaranteeListVo> CsmBankGuaranteeListVoQuery = csmBankInfoMapper.getGuaranteeList(map);
		PageInfo pageInfo=new PageInfo(CsmBankGuaranteeListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmBankGuaranteeListVo> getGuaranteeListDY(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmBankGuaranteeListVo> CsmBankGuaranteeListVoQuery = csmBankInfoMapper.getGuaranteeListDY(map);
		PageInfo pageInfo=new PageInfo(CsmBankGuaranteeListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
}
