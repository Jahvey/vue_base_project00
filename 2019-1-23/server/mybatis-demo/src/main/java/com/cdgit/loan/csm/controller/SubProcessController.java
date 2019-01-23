package com.cdgit.loan.csm.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgit.loan.csm.mapper.CsmTbBizAmountApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizSummaryMapper;
import com.cdgit.loan.csm.mapper.CsmTbConAttachedInfoPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubContractTPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubGrtRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractMapper;
import com.cdgit.loan.csm.mapper.CsmTbConSubcontractRelMapper;
import com.cdgit.loan.csm.mapper.CsmTbConZhPoMapper;
import com.cdgit.loan.csm.mapper.CsmTbGrtMortgageBasicMapper;
import com.cdgit.loan.csm.mapper.CsmTbLoanSummaryMapper;
import com.cdgit.loan.csm.po.TbBizAmountApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.cdgit.loan.csm.po.TbBizSummaryPo;
import com.cdgit.loan.csm.po.TbConAttachedInfoPo;
import com.cdgit.loan.csm.po.TbConSubContractTPo;
import com.cdgit.loan.csm.po.TbConSubGrtRelPo;
import com.cdgit.loan.csm.po.TbConSubcontractPo;
import com.cdgit.loan.csm.po.TbConSubcontractRelPo;
import com.cdgit.loan.csm.po.TbConZhPo;
import com.cdgit.loan.csm.po.TbGrtMortgageBasicPo;
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
	
	@Autowired
	CsmTbConSubcontractRelMapper csmTbConSubcontractRelMapper;
	
	@Autowired
	CsmTbConSubGrtRelMapper csmTbConSubGrtRelMapper;
	
	@Autowired
	CsmTbConSubcontractMapper CsmTbConSubcontractMapper;
	
	@Autowired
	CsmTbGrtMortgageBasicMapper csmTbGrtMortgageBasicMapper;
	
	@Autowired
	CsmTbBizSummaryMapper  csmTbBizSummaryMapper;
	
	
	
	
	@GetMapping("/queryOneTbBizSummaryByApplyId")
	TbBizSummaryPo queryOneTbBizSummaryByApplyId(String applyId){
		 
		 return csmTbBizSummaryMapper.queryOneTbBizSummaryByApplyId(applyId);
	 }
	
	//这两个都成功了
	@GetMapping("/queryOneTbGrtMortgageBasic")
	TbGrtMortgageBasicPo queryOneTbGrtMortgageBasic(String suretyId){
		return csmTbGrtMortgageBasicMapper.queryOneCsmTbGrtMortgageBasic(suretyId);
	}
	@GetMapping("/updateCsmTbGrtMortgageBasic")
	void updateCsmTbGrtMortgageBasic(String suretyId){
		TbGrtMortgageBasicPo grt=csmTbGrtMortgageBasicMapper.queryOneCsmTbGrtMortgageBasic(suretyId);
		
		grt.setAviAmt(new BigDecimal("3333333"));
		csmTbGrtMortgageBasicMapper.updateCsmTbGrtMortgageBasicByPrimaryKeySelective(grt);
		
		
	}
	
	@GetMapping("/queryCsmTbConSubcontractPo")
	TbConSubcontractPo queryCsmTbConSubcontractPo(String subcontractId){
		
		return CsmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		
	}
	
	//TODO 测试相应的updateCsmTbConSubcontract
	@GetMapping("/updateCsmTbConSubcontract")
	void updateCsmTbConSubcontract(String subcontractId){
		TbConSubcontractPo subCon=CsmTbConSubcontractMapper.queryCsmTbConSubcontractPo(subcontractId);
		
		subCon.setAnlljx(new BigDecimal("22222"));
		subCon.setAviAmt(new BigDecimal("12345.02"));
		CsmTbConSubcontractMapper.updateCsmTbConSubcontractByPrimaryKeySelective(subCon);
	}
	
	
	@GetMapping("/queryListTbConSubGrtRel")
	List<TbConSubGrtRelPo> queryListTbConSubGrtRel(String subcontractId){
		return csmTbConSubGrtRelMapper.queryListTbConSubGrtRel(subcontractId);
		
	}
	
	
	//TODO  TbConSubcontractRel 待测试。。。。。。
	@GetMapping("/queryListCsmTbConSubcontractRelByconId")
	List<TbConSubcontractRelPo> queryListCsmTbConSubcontractRelByconId(String contractId){
		return csmTbConSubcontractRelMapper.queryListCsmTbConSubcontractRelByconId(contractId);
		
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
