package com.cdgit.loan.csm.process.cons;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.uid.StringUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.csm.gitUtils.GitUtils;
import com.cdgit.loan.csm.gitUtils.CommonUtils;
import com.cdgit.loan.csm.mapper.ConApplyMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountDetailApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizAmountLoanrateApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizApproveMapper;
import com.cdgit.loan.csm.mapper.CsmTbBizSummaryMapper;
import com.cdgit.loan.csm.mapper.CsmTbConContractInfoMapper;
import com.cdgit.loan.csm.mapper.CsmTbLoanSummaryMapper;
import com.cdgit.loan.csm.po.TbBizAmountDetailApprovePo;
import com.cdgit.loan.csm.po.TbBizAmountLoanrateApprovePo;
import com.cdgit.loan.csm.po.TbBizApprovePo;
import com.cdgit.loan.csm.po.TbBizSummaryPo;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.po.TbLoanSummaryPo;
import com.cdgit.loan.csm.process.accInfo.ContractSub;
import com.cdgit.loan.csm.process.products.ProductUtil;


@Service
@Transactional
public class ConInfoCreateDao {//ConDao0001
	
	@Autowired
	CsmTbBizAmountDetailApproveMapper csmTbBizAmountDetailApproveMapper;
	
	@Autowired
	CsmTbBizApproveMapper  csmTbBizApproveMapper;
	
	@Autowired
	CsmTbBizSummaryMapper csmTbBizSummaryMapper;
	
	@Autowired
	CsmTbLoanSummaryMapper  csmTbLoanSummaryMapper;
	
	@Autowired
	CsmTbBizAmountLoanrateApproveMapper csmTbBizAmountLoanrateApproveMapper;
	@Autowired
	ConApplyMapper  conApplyMapper;
	
	@Autowired
	GitUtils gitUtils;
	@Autowired
	CommonUtils commonUtils; 
	
	@Autowired
	CsmTbConContractInfoMapper csmTbConContractInfoMapper;
	
	
	


	public TbConContractInfoPo create(Map<String, Object> apply) {//TODO 待测这个是创建合同的核心方法。。。。。。。。。。
		String error = createValid(apply);
		if (error != null) {
			throw new RuntimeException(error);
		}
		TbConContractInfoPo applyObj = createApply(apply);
		createProcess(applyObj);
		return applyObj;
	}
	
	public String createProcess(TbConContractInfoPo contractInfo) {
//		String flowName = getFlowName();
//		if (StringUtil.isNull(flowName)) {
//			return null;
//		}
//		String processId = processFactory.createBpsProcessThrowError(bizObj.getString(getEntityId()), flowName);
//		bizObj.set("processInstId", processId);
		return "";
	}
	
	public TbConContractInfoPo createApply(Map<String, Object> dataMap) {//TODO 未完成得部分周末弄.......
	
		String amountDetailId = (String) dataMap.get("amountDetailId");
		if (StringUtil.isNull(amountDetailId)) {
			throw new RuntimeException("创建合同失败：请传入业务编号");
		}
		
		TbBizAmountDetailApprovePo bizDtl = (TbBizAmountDetailApprovePo) dataMap.get("db_bizDtl");
		TbBizApprovePo biz = (TbBizApprovePo) dataMap.get("db_biz");
		
		// 借新还旧时释放原贷款借据担保额度--20151229 -BUG #7971 生产环境中发起借新还旧时，之前押品未释放，担保不足值
		if ("06".equals(biz.getBizHappenType())) {
			TbBizSummaryPo bizSum = csmTbBizSummaryMapper.queryOneTbBizSummaryByApplyId(biz.getApplyId());		
			TbLoanSummaryPo loan = csmTbLoanSummaryMapper.queryOneTbLoanSummaryBySummaryId(bizSum.getSummaryId());
			ContractSub cs = new ContractSub();
			cs.delSubcontract(loan.getContractId());
		}
		
		// 查询品种明细信息
		String entityName = ProductUtil.getEntityName(bizDtl.getProductType());
		entityName = entityName.replace("Apply", "Approve");
		//TODO 周一再说。。。。。。。
//		DataObject productDetail = DataObjectUtil.createDataObject(entityName);
//		productDetail.set("amountDetailId", amountDetailId);
//		DatabaseUtil.expandEntityByTemplate("default", productDetail, productDetail);

		// 查询利率
		TbBizAmountLoanrateApprovePo loanRate = csmTbBizAmountLoanrateApproveMapper.queryOneCsmTbBizAmountLoanrateApprove(amountDetailId);
	

		entityName = entityName.replace("biz", "crt");
		entityName = entityName.replace("Biz", "Con");
		entityName = entityName.replace("Approve", "");

		Date busDate = gitUtils.getBusiDate();
		// 保存业务合同信息
		//DataObject conDetail = DataObjectUtil.convertDataObject(productDetail, entityName, true);
		
		TbConContractInfoPo contractInfo = new TbConContractInfoPo();
		contractInfo.setAmountDetailId(amountDetailId);
		contractInfo.setCreateTime(gitUtils.getCurrDate());
		
		contractInfo.setPartyId(biz.getPartyId());
		contractInfo.setGuarantyType(biz.getGuarantyType());
		
		//借新还旧
		if("06".equals(biz.getBizHappenType())){
			String datas = conApplyMapper.queryJxhjOldConId(biz.getApplyId());
			if (datas == null || datas.equals("")) {
				throw new RuntimeException("无法找到循环贷所对应的原合同编号[applyId=" + biz.getApplyId() + "]");
			}
			contractInfo.setJxhjId(datas);
			
			
		}
		
		contractInfo.setCrdDtlId(bizDtl.getCrdDtlId());
		contractInfo.setProductType(bizDtl.getProductType());
		contractInfo.setCycleUnit(bizDtl.getCycleUnit());
		contractInfo.setRepaymentType(bizDtl.getRepaymentType());
		contractInfo.setExchangeRate(bizDtl.getExchangeRate());
		contractInfo.setCurrencyCd(bizDtl.getCurrencyCd());
		contractInfo.setCycleIndCon(bizDtl.getCycleIndCon());
		contractInfo.setCreditMode(bizDtl.getCreditMode());
		String conNum=gitUtils.getSeqNo("HT", gitUtils.getCurrentOrgCd());
		contractInfo.setContractNum(conNum);
		contractInfo.setPaperConNum(conNum);
		contractInfo.setBeginDate(busDate);
		contractInfo.setUserNum(gitUtils.getCurrentUserId());
		contractInfo.setOrgNum(gitUtils.getCurrentOrgCd());
		contractInfo.setSpecPaymentDate(new Short("21"));
		contractInfo.setConStatus("01");
		
		//有可能是一个bug
		
		Date validDate=biz.getValidDate();
		
		if(validDate!=null){
			//valiDate有为空的情况
			//Date tkdate = DateHelper.calculateDate(validDate, 0, 0, 30);
			Date tkdate=validDate;
			contractInfo.setTkDate(tkdate);
			
		}
		
		contractInfo.setHolidayFlg(bizDtl.getHolidayFlg());
		// 小微把贷款用途保存进合同基本信息
//		if (conDetail.get("loanUse") != null && !"".equals(conDetail.get("loanUse"))) {
//			conObj.set("loanUse", conDetail.get("loanUse"));
//		}
		contractInfo.setFirstRepayTerm(bizDtl.getFirstRepayTerm());
		contractInfo.setInternalDays(Integer.parseInt(commonUtils.getDBConfigVal("sys", "sys_internalDays")));
		contractInfo.setContractId(UUIDGenerator.getUUID());
		csmTbConContractInfoMapper.insertCsmTbConContractInfoSelective(contractInfo);
		
		
		// 汇票贴现要把所有票据的编号拼起来，逗号隔开--金额加起来
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return contractInfo;
		
		
	}
	
	

	public String createValid(Map<String, Object> dataMap) {
		String bizDtlId = (String) dataMap.get("AMOUNT_DETAIL_ID");
		TbBizAmountDetailApprovePo bizDtl = csmTbBizAmountDetailApproveMapper.queryOneTbBizAmountDetailApproveByAmountDetailId(bizDtlId);
		TbBizApprovePo biz = csmTbBizApproveMapper.queryOneTbBizApproveByApproveId(bizDtl.getApproveId());
		//DataObject bizDtl = EntityUtil.getEntityById(BizTableName.TB_BIZ_AMOUNT_DETAIL_APPROVE, "amountDetailId", bizDtlId);
		//DataObject biz = EntityUtil.getEntityById(BizTableName.TB_BIZ_APPROVE, "approveId", bizDtl.getString("approveId"));

		dataMap.put("amountDetailId", bizDtlId);
		dataMap.put("applyId", biz.getApproveId());// 调整之后old_apply_id存放的approve_id
		dataMap.put("approveId", biz.getApproveId());
		dataMap.put("crdId", biz.getCrdId());
//		RuleUtil.runRules(dataMap, "XFE_0003"// TODO 以后有时间得时候再做  2019-1-18........
//				, "RCON_0202"// 存在在途合同
//				, "RCON_0203"// 存在已生效合同
//				, "RCON_0204"// 该业务已无可用额度
//				, "RBIZ_0046" // 存在在途业务调整
//				, "RCRD_0212"// 存在在途授信调整
//		);

		dataMap.put("db_biz", biz);
		dataMap.put("db_bizDtl", bizDtl);
		return null;
	}
	
	

}
