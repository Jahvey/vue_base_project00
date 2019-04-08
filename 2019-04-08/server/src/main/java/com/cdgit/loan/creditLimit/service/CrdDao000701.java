package com.cdgit.loan.creditLimit.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.service.AApplyDao;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.creditLimit.bean.TbCrdApprove;
import com.cdgit.loan.creditLimit.bean.TbCrdFreeze;
import com.cdgit.loan.creditLimit.bean.TbCrdFreezeDtl;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;


/**
 * 授信-分离式-冻结-全额
 * 
 * statusCd:00[创建];10[流程中];99[完成];
 * 
 * @author crms18
 * 
 */
public class CrdDao000701 extends AApplyDao {
	
	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Override
	public String getEntityId() {
		return "frzId";
	}

	@Override
	public String createValid(Map<String, Object> dataMap) {
		String crdId = (String) dataMap.get("crdId");
		if (StringUtil.isNull(crdId)) {
			throw new RuntimeException("授信冻结失败，没有获取到需冻结的授信信息");
		}
		dataMap.put("crdId", crdId);
		TbCrdApprove crd=new TbCrdApprove();
		if (!"03".equals(crd.getStatusCd())) {
			throw new RuntimeException("非[已生效]授信数据不允许冻结操作");
		} else if (!GitUtil.getCurrentUserId().equals(crd.getUserNum())) {
			throw new RuntimeException("非本人管理数据，请勿操作");
		} else if (crd.getBoUse().compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("该授信数据已无可用额度，无需冻结");
		}
		dataMap.put("partyId", crd.getPartyId());
		dataMap.put("approveId", crdId);
//		RuleUtil.runRules(dataMap, "XFE_0003", "RCRD_0207", "RCRD_0213"// 存在在途业务申请
//				, "RCRD_0214"// 存在在途合同签署或调整
//				, "RCRD_0215"// 存在在途出账
//		);
		return null;
	}

	@Transactional
	@Override
	public Object createApply(Map<String, Object> dataMap) {
		TbCrdFreeze frz=new TbCrdFreeze();
		frz.setFrzId(UUIDGenerator.getUUID());
		frz.setStatusCd("00");
		frz.setFrzType(getFrzType());
		frz.setUserNum(GitUtil.getCurrentUserId());
		frz.setOrgNum(GitUtil.getCurrentOrgCd());
		frz.setCreateTime(GitUtil.getCurrDate());
		creditLimitMapper.insertFrz(frz);
		dataMap.put("frzId", frz.getFrzId());
		initDtl(dataMap);
		return frz;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Object update(Map<String, Object> dataMap) {
		
		final String frzId = (String) dataMap.get("frzId");
		TbCrdFreeze obj=creditLimitMapper.selectCrdFrzByPrimaryKey(frzId);
//		TbCrdFreeze obj=new TbCrdFreeze();
//		obj.setFrzId(frzId);
//		DataObject obj = EntityUtil.getEntityById(CrdTableName.TB_CRD_FREEZE, "frzId", frzId);
		if (!"00".equals(obj.getStatusCd())) {
			throw new RuntimeException("非[创建]状态的数据不允许操作");
		}
		obj.setFrzReason((String)dataMap.get("frzReason"));
		creditLimitMapper.updateCrdFrz(obj);
		Object[] dtls = (Object[]) dataMap.get("dtls");
		if (dtls != null && dtls.length > 0) {
			for (int i = 0; i < dtls.length; i++) {
				Map<String, Object> d = (Map<String, Object>) dtls[i];
				
				TbCrdFreezeDtl crdFrzDtl=new TbCrdFreezeDtl();
				crdFrzDtl.setFrzId((String) dataMap.get("frzId"));
				crdFrzDtl.setCrdDtlId((String)d.get("crdDtlId"));
				crdFrzDtl.setFrzAmt(getFrzAmt(d.get("frzAmt")));
				
			}
		}
		return obj;
	}

	protected BigDecimal getFrzAmt(Object frzAmt) {
		if (frzAmt == null) {
			throw new RuntimeException("请填入欲冻结额度");
		}
		BigDecimal amt = new BigDecimal((String) frzAmt);
		if (amt.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("欲冻结额度不允许小于等于[0]");
		}
		return amt;
	}

	@Transactional
	@Override
	public void remove(String frzId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("frzId", frzId);
//		RuleUtil.runRules(map, "RCRD_0209");
		creditLimitMapper.removeFrzDtl(frzId);
		creditLimitMapper.deleteFrzByPrimaryKey(frzId);
	}

	@Override
	public Object saveDetail(Map<String, Object> detail) {
		String frzId = (String) detail.get("frzId");
		Map<String, String> map = new HashMap<String, String>();
		map.put("frzId", frzId);
//		RuleUtil.runRules(map, "RCRD_0209");
		initDtl(map);
		return null;
	}

	@Transactional
	@Override
	public void removeDetails(String frzId, String[] dtlIds) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("frzId", frzId);
//		RuleUtil.runRules(map, "RCRD_0209");
		for (String dtlId : dtlIds) {
			map.put("crdDtlId", dtlId);
			creditLimitMapper.deleteFrzDtlByPrimaryKey(map);
		}
	}

	protected String getFrzType() {
		return "01";
	}

	protected void initDtl(Map<String, ?> map) {
		creditLimitMapper.insertFrzDtl(map);
	}

}
