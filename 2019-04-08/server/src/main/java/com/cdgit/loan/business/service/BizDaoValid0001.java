package com.cdgit.loan.business.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.mapper.BusinessMapper;
import com.cdgit.loan.common.util.BizDaoUtil;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApprove;


public class BizDaoValid0001 implements BizDaoValid {
	
	@Autowired
	BusinessMapper businessMapper;
	
	@Override
	public String createValid(Map<String, Object> map) {
		String productType = (String) map.get("productType");
		if (productType == null) {
			throw new RuntimeException("用信数据创建失败：没有获取到产品信息");
		} else if ("01007012".equals(productType)) {
			throw new RuntimeException("福费廷只能申请低风险业务");
		} else if (productType.startsWith("01006")) {
			throw new RuntimeException("贴现产品只能申请低风险业务");
		}
		if ("1".equals(map.get("isBankTeamLoan"))) {
//			RuleUtil.runRules(map, "RBIZ_0019"); // 集团成员只能发起低或银团贷款
		}
//		RuleUtil.runRules(map, "RBIZ_0206"// 用信同产品只能一次申请一笔
//				, "XFE_0002"// 业务移交
//		);
		Map<String, String> crdMap = BizDaoUtil.getCrdByProduct((String) map.get("partyId"), (String) map.get("productType"));
		map.put("crdId", crdMap.get("CRD_ID"));
		map.put("crdDtlId", crdMap.get("CRD_DTL_ID"));
		map.put("currencyCd", crdMap.get("CURRENCY_CD"));

//		RuleUtil.runRules(map, "RCRD_0212");// 存在在途授信调整
		
		TbCrdDetailApprove crdDtl=businessMapper.selectCrdDtlApp((String) map.get("crdDtlId"));//调用
		
		if (!productType.startsWith(crdDtl.getProductType())) {
			throw new RuntimeException("非授信产品，不允许做业务申请");
		}
		return null;
	}

	@Override
	public void updateValid(Map<String, Object> dataMap) {
		final String applyId = (String) dataMap.get("applyId");		
		TbBizApply obj=businessMapper.selectBizApp(applyId);
		if (!"01".equals(obj.getStatusType())) {
			throw new RuntimeException("非[未提交]状态数据不允许操作");
		}
	}

	@Override
	public void removeValid(Object biz) {
//		if (!"01".equals(biz.getString("statusType"))) {
//			throw new RuntimeException("非[未提交]状态数据不允许操作");
//		}
	}

	@Override
	public void createDtlValid(Map<String, Object> dataMap) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveDtlValid(Map<String, Object> dataMap) {
//		DataObject bizDtl = (DataObject) dataMap.get("amountDetail");
//		DataObject biz = EntityUtil.getEntityById(BizTableName.TB_BIZ_APPLY, "applyId", bizDtl.getString("applyId"));
//		if (!"01".equals(biz.getString("statusType"))) {
//			throw new RuntimeException("非[未提交]状态数据不允许操作");
//		}
//		if (CreditReckonUtil.getBizDtl().isOpenGobProduct(bizDtl.getString("productType"))) {
//			String bzjblbdy = (String) ((Map<String, Object>) dataMap.get("productDetail")).get("bzjblbdy");
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("amountDetailId", bizDtl.getString("amountDetailId"));
//			map.put("assurePer", bzjblbdy);
//			bizDtl.set("assurePer", bzjblbdy);
//			RuleUtil.runRules(map, "RBIZ_0214");
//		} else {
//			bizDtl.set("assurePer", null);
//		}
//		BigDecimal bizOpenAmt = CreditReckonUtil.getBizDtl().getOpenGob(bizDtl);
//		// 计算敞口
//		if (GitUtil.contain(biz.get("bizHappenType"), new String[] { "11", "06" })) {
//			BigDecimal crdAmt = CreditReckonUtil.getCrdDtl().getRmbAmt(bizDtl.getString("crdDtlId"));
//			if (bizOpenAmt.compareTo(crdAmt) > 0) {
//				throw new RuntimeException("申请额度[" + bizOpenAmt + "]不允许大于最大可用额度[" + crdAmt + "]");
//			}
//			if ("06".equals(biz.get("bizHappenType"))) {
//				Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.biz.AppBizSql.getJxhjAmt", bizDtl.getString("applyId"));
//				if (bizDtl.getBigDecimal("rmbAmt").compareTo((BigDecimal) datas[0]) > 0) {
//					throw new RuntimeException("循环贷业务额度不能大于原借据余额[" + datas[0] + "]");
//				}
//			}
//		} else {
//			CreditReckonUtil.getCrdDtl().validBoUse(bizDtl.getString("crdDtlId"), bizOpenAmt);
//		}
	}
}
