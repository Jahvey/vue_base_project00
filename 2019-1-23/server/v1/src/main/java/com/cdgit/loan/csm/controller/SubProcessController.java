package com.cdgit.loan.csm.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.configuration.SystemConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.common.util.BeanUtil;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbConAttachedInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubContractTPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConZhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbLoanSummaryMapper;
import com.cdgit.loan.csm.po.TbBizAmountApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.cdgit.loan.csm.po.TbConAttachedInfoPo;
import com.cdgit.loan.csm.po.TbConPayoutPlanPo;
import com.cdgit.loan.csm.po.TbConSubContractTPo;
import com.cdgit.loan.csm.po.TbConZhPo;
import com.cdgit.loan.csm.po.TbLoanPayoutPlanPo;
import com.cdgit.loan.csm.po.TbLoanSummaryPo;

@RestController
@RequestMapping("SubProcess")
public class SubProcessController {
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	CsmTbBizAmountApproveMapper csmTbBizAmountApproveMapper;
	
	
	@Autowired
	CsmTbConSubContractTPoMapper csmTbConSubContractTPoMapper;
	
	@Autowired
	CsmTbBizApproveMapper csmTbBizApproveMapper;
	
	@Autowired
	CsmTbConAttachedInfoPoMapper csmTbConAttachedInfoPoMapper;
	
	
	@Autowired
	CsmTbLoanSummaryMapper csmTbLoanSummaryMapper;
	
	@Autowired
	CsmTbConZhPoMapper csmTbConZhPoMapper;
	
	
	
	@GetMapping("testBeanUtilsDemo")
	void testBeanUtilsDemo(){
		TbLoanPayoutPlanPo tar = new TbLoanPayoutPlanPo();
		
		TbConPayoutPlanPo src = new TbConPayoutPlanPo();
		
		src.setContractDetailId("2323456");
		src.setCreateTime(new Date());
		BeanUtil.copyBeanProperties(src, tar);
		System.out.println(src);
		System.out.println(tar);

		
		tar=new TbLoanPayoutPlanPo();
		src = new TbConPayoutPlanPo();
		tar.setSummaryId("7778888899999");
		tar.setLoanuse("abcdefg");
		tar.setLoanId("1111111111333333");
		tar.setCreateTime(new Date());
		BeanUtil.copyBeanProperties(tar, src);
		
		
		System.out.println(src);
		System.out.println(tar);
		
		
		
	}
	
	
	
	@GetMapping("/queryListCsmTbConZhInfo")
	List<TbConZhPo> queryListCsmTbConZhInfo(String contractId){
		return csmTbConZhPoMapper.queryListCsmTbConZhInfo(contractId);
		
	}
	
	
	@GetMapping("/queryOneTbLoanSummaryBySummaryId")
	TbLoanSummaryPo queryOneTbLoanSummaryBySummaryId(String summaryId){
		return csmTbLoanSummaryMapper.queryOneTbLoanSummaryBySummaryId(summaryId);
		
	}
	
	

	
	@GetMapping("/queryOneTbBizAmountApproveByAmountId")
	TbBizAmountApprovePo queryOneTbBizAmountApproveByAmountId(String amountId){
		
		return csmTbBizAmountApproveMapper.queryOneTbBizAmountApproveByAmountId(amountId);
		
	}
	
	//TODO 1-18明天待测试。。。。。
	@GetMapping("/queryOneTbBizAmountDetailApproveByAmountDetailId")
	TbBizAmountDetailApprovePo queryOneTbBizAmountDetailApproveByAmountDetailId(String amountDetailId){
		
		return csmTbBizAmountDetailApproveMapper.queryOneTbBizAmountDetailApproveByAmountDetailId(amountDetailId);
		
	}
	
	
	
	@GetMapping("/queryOneTbConSubContractTPoInfo")
	TbConSubContractTPo	queryOneTbConSubContractTPoInfo(String subcontractId){
		return csmTbConSubContractTPoMapper.queryOneTbConSubContractTPoInfo(subcontractId);

		
	}
	
	
	
	@GetMapping("/queryOneTbBizApproveByApproveId")
	TbBizApprovePo queryOneTbBizApproveByApproveId(String approveId){
		return csmTbBizApproveMapper.queryOneTbBizApproveByApproveId(approveId);
	}
	
	@GetMapping("/queryCsmTbConAttachedInfoPo")
	TbConAttachedInfoPo queryCsmTbConAttachedInfoPo(String contractId){
		return csmTbConAttachedInfoPoMapper.queryCsmTbConAttachedInfoPo(contractId);
	}
	
	
	
	

	
	
	
	
	
	

}
