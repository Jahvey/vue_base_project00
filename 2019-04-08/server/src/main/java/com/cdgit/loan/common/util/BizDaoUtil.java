package com.cdgit.loan.common.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.mapper.BizDaoUtilMapper;

@Transactional
public class BizDaoUtil {
	
	private static BizDaoUtilMapper bizDaoUtilMapper=(BizDaoUtilMapper)SpringUtil.getBean(BizDaoUtilMapper.class);
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> getCrdByProduct(String partyId, String productType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("partyId", partyId);
		map.put("productCd", productType);
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.biz.BizSql.getCrdByProduct", map);
		
		Object[] datas = bizDaoUtilMapper.getCrdByProduct(map);
		
		if (datas.length > 0) {
			return (Map<String, String>) datas[0];
		}
		throw new RuntimeException("该客户下没有找到产品对应的授信信息[" + productType + "]");
	}

//	public static Map<String, Object> getAppBizDtlInfo(final String bizDtlId) {
//		DataObject bizDtl = EntityUtil.getEntityById(BizTableName.TB_BIZ_AMOUNT_DETAIL_APPLY, "amountDetailId", bizDtlId);
//		Map<String, Object> map = new HashMap<String, Object>();
//		final String productCd = bizDtl.getString("productType");
//		DataObject bizDtlRate = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_AMOUNT_LOANRATE_APPLY, "amountDetailId", bizDtlId);
//		String entityName = ProductUtil.getEntityName(productCd);
//		if (entityName != null) {
//			DataObject bizDtlP = EntityUtil.searchEntityByTemplate(entityName, "amountDetailId", bizDtlId);
//			map.put("productDetail", bizDtlP);
//			if (bizDtlP != null && GitUtil.contain(productCd, new String[] { "01013001", "01013010" })) {
//				map.put("wtxmId", bizDtlP.getString("wtxmId"));
//				Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.bizProductDetail.bizProject.getWtrXx", map);
//				if (datas != null && datas.length > 0) {
//					map.put("wtxm", datas[0]);
//				}
//			}
//		}
//		DataObject product = EntityUtil.searchEntityByTemplate(SysTableName.TB_SYS_PRODUCT, "productCd", productCd);
//		map.put("amountDetail", bizDtl);
//		map.put("loanrate", bizDtlRate);
//		map.put("productInfo", product);
//		return map;
//	}

//	public static Map<String, Object> getBizDtlInfo(final String bizDtlId) {
//		DataObject bizDtl = EntityUtil.getEntityById(BizTableName.TB_BIZ_AMOUNT_DETAIL_APPROVE, "amountDetailId", bizDtlId);
//		Map<String, Object> map = new HashMap<String, Object>();
//		final String productCd = bizDtl.getString("productType");
//		DataObject bizDtlRate = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_AMOUNT_LOANRATE_APPROVE, "amountDetailId", bizDtlId);
//		String entityName = ProductUtil.getEntityName(productCd);
//		if (entityName != null) {
//			entityName = entityName.replace("Apply", "Approve");
//			DataObject bizDtlP = EntityUtil.searchEntityByTemplate(entityName, "amountDetailId", bizDtlId);
//			map.put("productDetail", bizDtlP);
//			if (bizDtlP != null && GitUtil.contain(productCd, new String[] { "01013001", "01013010" })) {
//				map.put("wtxmId", bizDtlP.getString("wtxmId"));
//				Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.bizProductDetail.bizProject.getWtrXx", map);
//				if (datas != null && datas.length > 0) {
//					map.put("wtxm", datas[0]);
//				}
//			}
//		}
//		DataObject product = EntityUtil.searchEntityByTemplate(SysTableName.TB_SYS_PRODUCT, "productCd", productCd);
//		map.put("amountDetail", bizDtl);
//		map.put("loanrate", bizDtlRate);
//		map.put("productInfo", product);
//		return map;
//	}

	/**
	 * 判断首笔或存量是否有误，根据批复信息来？
	
	 * <p>Title: getHappenType</p>  
	
	 * <p>Description: </p>  
	
	 * @param partyId
	 * @return
	 */
	public static String getHappenType(String partyId) {
		int num=bizDaoUtilMapper.getPartyBizIds(partyId);
		return num == 0 ? "10" : "01";
	}

//	public static String getCreditMode(String bizDtlId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.biz.BizSql.getBizDtlCreditMode", bizDtlId);
//		return datas == null || datas.length == 0 ? null : (String) datas[0];
//	}

	public static String createBizNum() {
		return "YW" + BizNumGenerator.getBizNum("SEQ_BIZ_PF");
	}

	/*public static void setBizDtlTerm(DataObject bizDtl, Date beginDate, int termNum, String termUnit) {
		// 只有一体化用信明细带有期限数据
		if (!ApplyDaoUtil.CREDIT_MODE_UNITE.equals(bizDtl.get("creditMode"))) {
			bizDtl.set("creditTerm", termNum);
			bizDtl.set("cycleUnit", termUnit);
		}
		bizDtl.set("beginDate", beginDate);
		bizDtl.set("endDate", GitUtil.getEndDate(bizDtl.getDate("beginDate"), bizDtl.getInt("creditTerm"), bizDtl.getString("cycleUnit")));
	}*/

	public static void removeTbBizXmxxApply(String amountDetailId) {
		bizDaoUtilMapper.removeTbBizXmxxApply(amountDetailId);
	}

	public static void removeTbBizXb(String bizId) {
		bizDaoUtilMapper.removeTbBizXb(bizId);
	}

	public static void removeTbBizYesornoApply(String applyId) {
		bizDaoUtilMapper.removeTbBizYesornoApply(applyId);
	}

	public static void removeTbSysFlowTest(String applyId) {
		bizDaoUtilMapper.removeTbSysFlowTest(applyId);
	}

	public void removeTbBizSummary(String applyId) {
		bizDaoUtilMapper.removeTbBizSummary(applyId);
	}

	public static void removeTbBizAmountApply(String applyId) {
		bizDaoUtilMapper.removeTbBizAmountApply(applyId);
	}

	public static void removeTbBizGrtMaxloanconApply(String applyId) {
		bizDaoUtilMapper.removeTbBizGrtMaxloanconApply(applyId);
	}

	public void removeTbBizWyxxApply(String amountDetailId) {
		bizDaoUtilMapper.removeTbBizWyxxApply(amountDetailId);
	}

	public void removeTbBizPjxxApply(String amountDetailId) {
		bizDaoUtilMapper.removeTbBizPjxxApply(amountDetailId);
	}

	public static void removeTbBizTxxxApply(String amountDetailId) {
		bizDaoUtilMapper.removeTbBizTxxxApply(amountDetailId);
	}

	public static void removeTbBizTx(String applyId) {
		bizDaoUtilMapper.removeTbBizTx(applyId);
	}

	public static void removeTbBizBankStructApply(String applyId) {
		bizDaoUtilMapper.removeTbBizBankMemberApply(applyId);
		bizDaoUtilMapper.removeTbBizBankStructApply(applyId);
//		DataObject bankStruct = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_BANK_STRUCT_APPLY, "applyId", applyId);
//		if (bankStruct == null) {
//			return;
//		}
//		DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF, "com.bos.biz.BizDaoSql.removeTbBizBankMemberApply", bankStruct.get("syndicatedStructId"));
//		DatabaseUtil.deleteEntity(DBUtil.DB_NAME_DEF, bankStruct);
	}

	public void removeTbBizXwHkjh(String amountDetailId) {
		bizDaoUtilMapper.removeTbBizXwHkjh(amountDetailId);
	}
	// public static void removeTbBizMyhtxxApply(String amountDetailId) {
	// DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF,
	// "com.bos.biz.BizDaoSql.removeTbBizMyhtxxApply", amountDetailId);
	// }

	// public static void removeTbBizFpxxApply(String amountDetailId) {
	// DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF,
	// "com.bos.biz.BizDaoSql.removeTbBizFpxxApply", amountDetailId);
	// }

	// public static void removeTbBizApplyLocking(String applyId) {
	// DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF,
	// "com.bos.biz.BizDaoSql.removeTbBizApplyLocking", applyId);
	// }

}
