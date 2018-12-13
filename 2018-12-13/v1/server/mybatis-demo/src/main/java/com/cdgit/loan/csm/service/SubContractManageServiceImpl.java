package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.SubContractListVo;
import com.cdgit.loan.csm.mapper.SubContractManageMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SubContractManageServiceImpl {
	
	@Autowired
	private SubContractManageMapper subContractManageMapper;
	
	//查询所有担保合同列表
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<SubContractListVo> findSubContractList(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<SubContractListVo> SubContractListVoQuery = subContractManageMapper.findSubContractList(map);
		PageInfo pageInfo=new PageInfo(SubContractListVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	

}
