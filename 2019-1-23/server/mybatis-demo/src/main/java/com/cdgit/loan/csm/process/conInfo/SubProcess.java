package com.cdgit.loan.csm.process.conInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmTbBizAmountApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbLoanSummaryMapper;
import com.cdgit.loan.csm.po.TbBizAmountApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.po.TbLoanSummaryPo;


@Service
@Transactional
public class SubProcess {
	
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	CsmTbBizAmountApproveMapper csmTbBizAmountApproveMapper;
	
	@Autowired
	CsmTbBizApproveMapper csmTbBizApproveMapper;
	
	@Autowired
	CsmTbLoanSummaryMapper csmTbLoanSummaryMapper;
	
	//TODO 填充合同数据。。。。
	/**
	 * @param amountDetailId
	 *            合同发起，填充业务合同数据
	 * */
	public TbConContractInfoPo saveBizToCon(String amountDetailId) {
		TbConContractInfoPo tbConContractInfo=new TbConContractInfoPo();
		if (null == amountDetailId || "".equals(amountDetailId)) {
			throw new RuntimeException("协议合同ID为空");
		}
		// 查询批复明细信息
		
		TbBizAmountDetailApprovePo bizDetail = csmTbBizAmountDetailApproveMapper.queryOneTbBizAmountDetailApproveByAmountDetailId(amountDetailId);

		TbBizAmountApprovePo bizInfo = csmTbBizAmountApproveMapper.queryOneTbBizAmountApproveByAmountId(bizDetail.getAmountId());
		
		TbBizApprovePo bizApprove = csmTbBizApproveMapper.queryOneTbBizApproveByApproveId(bizInfo.getApproveId());
		
		// 借新还旧时释放原贷款借据担保额度--20151229 -BUG #7971 生产环境中发起借新还旧时，之前押品未释放，担保不足值
		
		
		
		String summaryId="";
		
		TbLoanSummaryPo summaryInfo = csmTbLoanSummaryMapper.queryOneTbLoanSummaryBySummaryId(summaryId);
		
		
		
		return tbConContractInfo;
		
		
		
	}
	
	
	

}
