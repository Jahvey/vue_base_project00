package com.cdgit.loan.creditLimit.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.creditLimit.bean.TbCrdApprove;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;


/**
 * 授信-分离式-解冻-全额
 * 
 * statusCd:00[创建];10[流程中];99[完成];
 * 
 * @author crms18
 * 
 */
public class CrdDao000711 extends CrdDao000701 {

	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Override
	public String createValid(Map<String, Object> dataMap) {
		String crdId = (String) dataMap.get("crdId");
		if (StringUtil.isNull(crdId)) {
			throw new RuntimeException("授信解冻失败，没有获取到需解冻的授信信息");
		}
		TbCrdApprove crd=creditLimitMapper.selectCrdApproveByPrimaryKey(crdId);
		if (!"03".equals(crd.getStatusCd())) {
			throw new RuntimeException("非[已生效]授信数据不允许冻结操作");
		} else if (!GitUtil.getCurrentUserId().equals(crd.getUserNum())) {
			throw new RuntimeException("非本人管理数据，请勿操作");
		} else if (crd.getNoUse().compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("该授信数据并无冻结额度，无需解冻");
		}
		dataMap.put("approveId", crdId);
		dataMap.put("partyId", crd.getPartyId());
//		RuleUtil.runRules(dataMap, "XFE_0003", "RCRD_0208");
		return null;
	}

	@Override
	protected BigDecimal getFrzAmt(Object frzAmt) {
		if (frzAmt == null) {
			throw new RuntimeException("请填入欲解冻额度");
		}
		BigDecimal amt = new BigDecimal((String) frzAmt);
		if (amt.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("欲解冻额度不允许小于等于[0]");
		}
		return amt;
	}

	@Override
	protected String getFrzType() {
		return "11";
	}

	@Override
	protected void initDtl(Map<String, ?> map) {
		creditLimitMapper.insertUnfrzDtl(map);
	}
}
