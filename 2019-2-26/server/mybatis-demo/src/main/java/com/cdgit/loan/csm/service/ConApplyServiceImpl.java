package com.cdgit.loan.csm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgit.loan.csm.bean.ApproveAndSxxyVo;
import com.cdgit.loan.csm.bean.ApproveConsVo;
import com.cdgit.loan.csm.mapper.ConApplyMapper;
import com.cdgit.loan.csm.queryparams.ApproveConsVoQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@org.springframework.transaction.annotation.Transactional
public class ConApplyServiceImpl {
	
	@Autowired
	ConApplyMapper conApplyMapper;
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ApproveConsVo> getPrintCons(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ApproveConsVo> ApproveConsVoQuery = conApplyMapper.getPrintCons(map);
		PageInfo pageInfo=new PageInfo(ApproveConsVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	/**
	 * 分页查询首页合同信息
	 * 	pageNum：当前页
	 * 	pageSize：每页条数
	 * @param map
	 * @return	
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ApproveConsVo> getApproveCons(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ApproveConsVo> ApproveConsVoQuery = conApplyMapper.getApproveCons(map);
		PageInfo pageInfo=new PageInfo(ApproveConsVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
	
	
	
	
	
	/**
	 * 分页查询首页合同信息
	 * 	pageNum：当前页
	 * 	pageSize：每页条数
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ApproveConsVo> getApproveCons1(ApproveConsVoQuery approveConsVoQuery){
		//引入配置的分页插件 其中包含了分页的两个参数  当前的页码  和每页条数
		PageHelper.startPage(approveConsVoQuery.getPageNum(),approveConsVoQuery.getPageSize());
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("userNum", approveConsVoQuery.getUserNum());
		map.put("contractNum", approveConsVoQuery.getContractNum());
		map.put("partyId", approveConsVoQuery.getPartyId());
		List<ApproveConsVo>ApproveConsVoList= conApplyMapper.getApproveCons1(map);
        PageInfo pageInfo=new PageInfo(ApproveConsVoList,approveConsVoQuery.getPageSize());
    	return pageInfo;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<ApproveAndSxxyVo> getApproveAndSxxy(Map map){
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<ApproveAndSxxyVo> ApproveAndSxxyVoQuery = conApplyMapper.getApproveAndSxxy(map);
		PageInfo pageInfo=new PageInfo(ApproveAndSxxyVoQuery,(Integer)map.get("pageSize"));
    	return pageInfo;
	}
	

}
