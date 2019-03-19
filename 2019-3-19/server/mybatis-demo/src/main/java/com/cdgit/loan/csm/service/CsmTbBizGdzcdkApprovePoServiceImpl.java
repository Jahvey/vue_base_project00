package com.cdgit.loan.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizGdzcdkApprovePoMapper;
import com.cdgit.loan.csm.po.CsmTbBizGdzcdkApprovePo;

@Service
@Transactional
public class CsmTbBizGdzcdkApprovePoServiceImpl {

	@Autowired
	CsmTbBizGdzcdkApprovePoMapper csmTbBizGdzcdkApprovePoMapper;
	
	
	public CsmTbBizGdzcdkApprovePo selectByPrimaryKey(String applyDetailId){
		CsmTbBizGdzcdkApprovePo csmTbBizGdzcdkApprovePo = new CsmTbBizGdzcdkApprovePo();
		return (CsmTbBizGdzcdkApprovePo)csmTbBizGdzcdkApprovePoMapper.selectByPrimaryKey(applyDetailId);
		
	}
	
	
	
}
