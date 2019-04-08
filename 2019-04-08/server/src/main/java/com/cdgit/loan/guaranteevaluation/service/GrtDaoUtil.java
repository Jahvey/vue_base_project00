package com.cdgit.loan.guaranteevaluation.service;

import java.util.Map;


public class GrtDaoUtil {

	@SuppressWarnings("unchecked")
	public static void removeTbBizGrtRel(String applyId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.grt.grt.getGrtRelByAppId", applyId);
//		if (datas == null || datas.length == 0) {
//			return;
//		}
//		for (int i = 0; i < datas.length; i++) {
//			Map<String, String> map = (Map<String, String>) datas[i];
//			DataObject grtRel = DataObjectUtil.createDataObject(BizTableName.TB_BIZ_GRT_REL);
//			grtRel.set("relationId", map.get("RELATION_ID"));
//			DatabaseUtil.deleteEntity(DBUtil.DB_NAME_DEF, grtRel);
//			GrtIfsUtil.removeGrtRel(applyId, map.get("SURETY_NO"), map.get("SURETY_ID"));
//		}
	}

	public static String getSuretyNo(String suretyId) {
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.grt.grt.getSuretyNo", suretyId);
//		return datas == null || datas.length == 0 ? null : (String) datas[0];
		return "";
	}

	public static void createTbBizGrtRel(String appBizId, String oldBizId) {
//		DataObject[] datas = EntityUtil.searchEntitysByTemplate(BizTableName.TB_BIZ_GRT_REL, "applyId", oldBizId);
//		for (DataObject obj : datas) {
//			String suretyId = obj.getString("suretyId");
//			obj.set("applyId", appBizId);
//			obj.set("createTime", GitUtil.getCurrDate());
//			obj.unset("relationId");
//			DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, obj);
//			GrtIfsUtil.createGrtRel(appBizId, getSuretyNo(suretyId), suretyId);
//		}
	}
}
