package com.cdgit.loan.creditLimit.service;



public class CrdDaoUtil {

	public static String getAppCrdBizId(String crdAppId, String searchMode) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("crdId", crdAppId);
//		map.put("searchMode", searchMode);
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.crd.AppCrdSql.getBizId", map);
//		return datas.length > 0 ? (String) datas[0] : null;
		return "";
	}

	public static String getAppCrdBizDtlId(String crdDtlId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.crd.AppCrdSql.getBizDtlId", crdDtlId);
//		return datas.length > 0 ? (String) datas[0] : null;
		return "";
	}

	public static String getCrdBizId(String crdId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.crd.CrdSql.getBizId", crdId);
//		return datas.length > 0 ? (String) datas[0] : null;
		return "";
	}

	public static void updateTbBizAbateStatus(String abateId, String statusCd) {
//		DataObject obj = DataObjectUtil.createDataObject(BizTableName.TB_BIZ_ABATE);
//		obj.set("abateId", abateId);
//		obj.set("statusCd", statusCd);
//		if ("99".equals(statusCd)) {
//			obj.set("validDate", GitUtil.getBusiDate());
//		}
//		DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, obj);
	}

	public static void setCrdDtlTerm(Object crdDtl, Object crd) {
//		crdDtl.set("termNum", crd.getInt("termNum"));
//		crdDtl.set("termUnit", crd.get("termUnit"));
//		crdDtl.set("beginDate", crd.get("validDate"));
//		crdDtl.set("endDate", crd.getDate("endDate"));
	}

	public static void removeTbBizCreditLineMeasure(String applyId) {
//		DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF, "com.bos.biz.BizDaoSql.removeTbBizCreditLineMeasure", applyId);
	}

	public static void setCrdBizId(String crdId, String bizId) {
//		DataObject temp = DataObjectUtil.createDataObject(CrdTableName.TB_CRD_APPROVE);
//		temp.set("crdId", crdId);
//		temp.set("bizId", bizId);
//		DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, temp);
	}

	// ----------------------------
	public static void updateTbCrdFreezeStatus(String frzId, String statusCd) {
//		DataObject frz = DataObjectUtil.createDataObject(CrdTableName.TB_CRD_FREEZE);
//		frz.set("frzId", frzId);
//		frz.set("statusCd", statusCd);
//		if ("99".equals(statusCd)) {
//			frz.set("validDate", GitUtil.getBusiDate());
//		}
//		DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, frz);
//		LogUtil.info("修改批复[冻结]状态:frzId=" + frzId + ",statusCd=" + statusCd);
	}

}
