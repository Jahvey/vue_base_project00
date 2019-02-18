/**
 * 
 */
package com.cdgit.loan.csm.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.bean.CsmConCreditInfo;
import com.cdgit.loan.csm.bean.CsmConInfoBaseVo;
import com.cdgit.loan.csm.bean.CsmTbBizApprove;
import com.cdgit.loan.csm.pub.gitUtils.CsmGitUtilsMapper;
import com.cdgit.loan.csm.mapper.CsmConInfoBaseVoMapper;
import com.cdgit.loan.csm.service.CsmConInfoBaseVoServiceImpl;

/**
 * @author cwalk
 *
 */
@RestController
@RequestMapping("conInfoSxxy")
//com.bos.conInfo.conInfoSxxy.getConInfoByContarctId.biz.ext
public class CsmConInfoBaseVoController {
	
	@Autowired
	CsmConInfoBaseVoServiceImpl csmConInfoBaseVoServiceImpl;
	
	@Autowired
	CsmConInfoBaseVoMapper csmConInfoBaseVoMapper;
	
	@Autowired
	CsmGitUtilsMapper csmGitUtilsMapper;
	
	//查询协议信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getCsmTbConCreditInfo")
	public List<CsmConCreditInfo> getCsmTbConCreditInfo(String contractId){

		return csmConInfoBaseVoMapper.getCsmTbConCreditInfo(contractId);
	
		
	}
	
	//
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryInitBusiDate")
	public Date queryInitBusiDate(){
		//如果营业事件为空，则设置一个营业时间
//		GitUtils gitUtils=new GitUtils();
//		return gitUtils.getBusiDate();
		return csmGitUtilsMapper.queryInitBusiDate();
		
	}
	
	
	//查询批复信息
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/queryCsmTbBizApproveVoInfo")
	public CsmTbBizApprove queryCsmTbBizApproveVoInfo(String applyId){

		System.err.println(csmConInfoBaseVoMapper.queryCsmTbBizApproveVoInfo(applyId));
		return csmConInfoBaseVoMapper.queryCsmTbBizApproveVoInfo(applyId);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getConInfoByContarctId")
	public CsmConInfoBaseVo getConInfoByContarctId(String contractId){

		return csmConInfoBaseVoServiceImpl.getConInfoByContarctId(contractId);
	
		
	}
	

	
	
	
}
