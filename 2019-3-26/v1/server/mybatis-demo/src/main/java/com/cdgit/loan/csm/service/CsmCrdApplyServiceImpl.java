/**
 * 
 */
package com.cdgit.loan.csm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.bean.CsmCrdApplyCorpHisVo;
import com.cdgit.loan.csm.mapper.CsmCrdApplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CsmCrdApplyServiceImpl {
	
	@Autowired
	CsmCrdApplyMapper csmCrdApplyMapper;

	//查询对公、自然人、同业额度历史列表
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageInfo<CsmCrdApplyCorpHisVo> queryCorpHis(Map map){
		//引入配置的分页插件，当前页和每页条数
		PageHelper.startPage((Integer)map.get("pageNum"),(Integer)map.get("pageSize"));
		List<CsmCrdApplyCorpHisVo> CsmCrdApplyCorpHisVoQuery = csmCrdApplyMapper.queryCorpHis(map);
		PageInfo pageInfo=new PageInfo(CsmCrdApplyCorpHisVoQuery,(Integer)map.get("pageSize"));
		        
    	return pageInfo;
	}
	
	
}
