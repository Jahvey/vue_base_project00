package com.cdgit.loan.creditLimit.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.service.AApplyDao;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.creditLimit.bean.TbCrdApprove;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;
import com.cdgit.loan.creditLimit.bean.TbBizAbate;

/**
 * 授信-分离式-失效
 * 
 * @author crms18
 * 
 */
public class CrdDao0008 extends AApplyDao {
	
	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Override
	public String getEntityId() {
		return "abateId";
	}

	protected String getAbateType() {
		return "10";
	}

	@Override
	public String createValid(Map<String, Object> map) {
		String bizId = (String) map.get("bizId");
		if (StringUtil.isNull(bizId)) {
			throw new RuntimeException("无法获取到需失效的授信信息");
		}
//		DataObject crd = EntityUtil.getEntityById(CrdTableName.TB_CRD_APPROVE, "crdId", bizId);
		
		TbCrdApprove crd=creditLimitMapper.selectCrdApproveByPrimaryKey(bizId);
		
		if (!"03".equals(crd.getStatusCd())) {
			throw new RuntimeException("非[已生效]状态数据不能操作");
		} else if (!GitUtil.getCurrentUserId().equals(crd.getUserNum())) {
			throw new RuntimeException("非本人管理数据，请勿操作");
		}
		map.put("bizId", crd.getCrdId());
		map.put("abateType", getAbateType());
		map.put("crdId", crd.getCrdId());
//		RuleUtil.runRules(map, "RBIZ_0203"// 存在在途失效申请
//				, "RCRD_0212"// 存在在途授信调整
//				, "RCRD_0207"// 是否存在冻结申请
//				, "RCRD_0208"// 是否存在解冻申请
//				, "RCRD_0213"// 存在在途业务申请
//				, "RCRD_0214"// 存在在途合同签署或调整
//				, "RCRD_0215"// 存在在途出账
//		);
		if (!isComple(map)) {
//			RuleUtil.runRules(map, "RCRD_0216");// 该授信下存在生效的合同或借据
		}
		map.put("partyId", crd.getPartyId());
		map.put("creditMode", crd.getCreditMode());
		return null;
	}

	@Transactional
	@Override
	public Object createApply(Map<String, Object> dataMap) {
		TbBizAbate abate=new TbBizAbate();
		abate.setAbateType(getAbateType());
		abate.setUserNum(GitUtil.getCurrentUserId());
		abate.setOrgNum(GitUtil.getCurrentOrgCd());
		abate.setCreateDate(GitUtil.getCurrDate());
		abate.setStatusCd("00");;
		abate.setCompel(isComple(dataMap) ? "1" : "0");
		abate.setAbateId(UUIDGenerator.getUUID());
		creditLimitMapper.insertAbate(abate);
		creditLimitMapper.insertAbateDtl(dataMap);
		return abate;
	}

	@Override
	public Object update(Map<String, Object> dataMap) {
		TbBizAbate obj=creditLimitMapper.selectAbate((String) dataMap.get("abateId"));
		if (!"00".equals(obj.getStatusCd())) {
			throw new RuntimeException("非[创建]状态的数据不允许操作");
		}
		obj.setCompel(isComple(dataMap) ? "1" : "0");
		obj.setRemark((String)dataMap.get("remark"));
		obj.setUpdateDate(GitUtil.getCurrDate());
		creditLimitMapper.updateAbate(obj);
		return obj;
	}

	@Transactional
	@Override
	public void remove(String abateId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("abateId", abateId);
//		RuleUtil.runRules(map, "RCRD_0221");//规则验证后期打开
		creditLimitMapper.deleteAbateDtl(abateId);
		creditLimitMapper.deleteAbate(abateId);
	}

	@Override
	public Object saveDetail(Map<String, Object> detail) {
		String abateId = (String) detail.get("abateId");
		Map<String, String> map = new HashMap<String, String>();
		map.put("abateId", abateId);
//		RuleUtil.runRules(map, "RCRD_0221");
		creditLimitMapper.insertAbateDtl(map);
		
		return null;
	}

	@Transactional
	@Override
	public void removeDetails(String abateId, String[] detailIds) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("abateId", abateId);
//		RuleUtil.runRules(map, "RCRD_0221");
		for (String dtlId : detailIds) {
			map.put("bizDtlId", dtlId);
			creditLimitMapper.deleteAbateDtl(abateId);
		}
	}

	protected boolean isComple(Map<String, Object> map) {
		if (GitUtil.contain(map.get("compel"), new Object[] { "true", "1" })) {
			map.put("compel", "1");
			return true;
		} else {
			map.put("compel", "0");
			return false;
		}
	}
}
