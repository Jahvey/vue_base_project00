package com.cdgit.loan.business.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdgit.loan.business.bean.TbBizAmountApply;
import com.cdgit.loan.business.bean.TbBizAmountApprove;
import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.bean.TbBizApprove;
import com.cdgit.loan.business.mapper.BusinessMapper;
import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.service.ApplyDaoUtils;
import com.cdgit.loan.common.util.BeanUtil;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.guaranteevaluation.service.GrtDaoUtil;



public class BizDaoXX04 extends BizDaoXX01 {

	
	@Autowired
	BusinessMapper businessMapper;
	
	
	public TbBizApply createBiz(Map<String, Object> dataMap) {
//		Object biz = EntityUtil.getEntityById(BizTableName.TB_BIZ_APPROVE, "approveId", (String) dataMap.get("bizId"));
//		Object appBiz = DataObjectUtil.convertDataObject(biz, BizTableName.TB_BIZ_APPLY, true);
		TbBizApprove biz=businessMapper.selectBizApprove( (String) dataMap.get("bizId"));
		TbBizApply appBiz=new TbBizApply();
		BeanUtil.copyBeanProperties(biz, appBiz);
		appBiz.setApplyId(null);//appBiz.unset("applyId");
		appBiz.setUpdateTime(null);//appBiz.unset("updateTime");
		appBiz.setOldApplyId(biz.getApproveId());//这个就是原来的 业务申请的 approve_id
		if (dataMap.get("crdId") != null) {
			appBiz.setCrdId((String)dataMap.get("crdId"));
		}
		appBiz.setStatusType("01");
		appBiz.setBizHappenType("04");
		appBiz.setOrgNum(GitUtil.getCurrentOrgCd());
		appBiz.setUserNum(GitUtil.getCurrentUserId());
		appBiz.setCreateTime(GitUtil.getCurrDate());
		appBiz.setApplyDate(GitUtil.getBusiDate());

		appBiz.setApplyId(UUIDGenerator.getUUID());//这个是这次自己加的
		businessMapper.insertTbBizApply(appBiz);
//		appBiz.set("oldAppBizId", biz.get("applyId"));//这个还不知道怎么处理  业务批复对应的业务申请ID  可能需要定义一个组合对象
		return appBiz;
	}

	public TbBizAmountApply createBizA(TbBizApply biz, Map<String, Object> dataMap) {
//		Object appBizA = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_AMOUNT_APPROVE, "approveId", biz.getString("approveId"));//这个approveId从何而来
//		appBizA = DataObjectUtil.convertDataObject(appBizA, BizTableName.TB_BIZ_AMOUNT_APPLY, true);
		TbBizAmountApprove appBizA=businessMapper.selectBizAmountApprove(biz.getOldApplyId());//暂时这样写而已  我认为就是这个值
		TbBizAmountApply bizA=new TbBizAmountApply();
		BeanUtil.copyBeanProperties(appBizA, bizA);		
		bizA.setApplyId(biz.getApplyId());
		bizA.setCreateTime(GitUtil.getCurrDate());
		bizA.setStatusCd("01");
		bizA.setAmountId(UUIDGenerator.getUUID());//本次新增
		businessMapper.insertAmountApply(bizA);
		return bizA;
	}

	@SuppressWarnings("unchecked")
	public Object createBizDtl(TbBizApply biz, TbBizAmountApply bizA,Map<String, Object> dataMap) {
		final String newApplyId = biz.getApplyId();
		final String newAmountId = bizA.getAmountId();
		// 如果是一体化授信调整，该数据有值
		Map<String, String> cldDtlMatch = (Map<String, String>) dataMap.get("matchMap");
		if (cldDtlMatch == null) {
			cldDtlMatch = new HashMap<String, String>();
		}
//		Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.biz.BizSql.getBizDtlInfos", biz.get("oldApplyId"));
		Object[] datas = businessMapper.getBizDtlInfos(biz.getOldApplyId());
		for (int i = 0; i < datas.length; i++) {
			Map<String, Object> map = (Map<String, Object>) datas[i];
			ApplyDaoParam param = removeBizDtlDaoParam(map);
			map.put("applyId", newApplyId);
			map.put("amountId", newAmountId);
			map.put("bizDtlId", map.get("AMOUNT_DETAIL_ID"));
			map.put("crdDtlId", cldDtlMatch.get(map.get("CRD_DTL_ID")));
			ApplyDaoUtils.getDetailDao(param).create(map);
		}
		return null;
	}

	@Override
	protected ApplyDaoParam removeBizDtlDaoParam(Map<String, ?> map) {
		ApplyDaoParam param = new ApplyDaoParam("bizDtl", (String) map.get("CREDIT_MODE") + "04");
		param.setOrgCode((String) map.get("ORG_NUM"));
		param.setLegOrg(GitUtil.getLegorgByOrgCd(param.getOrgCode()));
		param.setProduct((String) map.get("PRODUCT_TYPE"));
		return param;
	}

	@Override
	public void createBizOther(Object appBiz, Map<String, Object> dataMap) {
		createTbBizGrtRel(appBiz, dataMap);
		createTbBizGrtMaxloanconApply(appBiz, dataMap);
		createTbBizYesornoApply(appBiz, dataMap);
		createTbBizBankStructApply(appBiz, dataMap);
		createTbBizTx(appBiz, dataMap);
		createTbBizXmxxApply(appBiz, dataMap);
		createFinanceInfo(appBiz, dataMap);
	}

	protected void createTbBizYesornoApply(Object appBiz, Map<String, Object> dataMap) {
//		DataObject data = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_YESORNO_APPLY, "applyId", appBiz.getString("oldAppBizId"));
//		if (data == null) {
//			return;
//		}
//		data.set("applyId", appBiz.get("applyId"));
//		data.unset("yesornoId");
//		DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, data);
	}

	protected void createTbBizTx(Object appBiz, Map<String, Object> dataMap) {
//		DataObject[] datas = EntityUtil.searchEntitysByTemplate(BizTableName.TB_BIZ_TX, "applyId", appBiz.getString("oldAppBizId"));
//		for (DataObject obj : datas) {
//			obj.set("applyId", appBiz.get("applyId"));
//			obj.unset("txId");
//			DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, obj);
//		}
	}

	protected void createFinanceInfo(Object appBiz, Map<String, Object> dataMap) {
//		DataObject party = EntityUtil.getEntityById(CsmTableName.TB_CSM_PARTY, "partyId", appBiz.getString("partyId"));
//		if (!CsmUtil.isNatural(party.getString("partyTypeCd"))) {
//			return;
//		}
//		String productType = (String) appBiz.get("productType");
//		// 消费--存在单独的表中
//		if (productType.indexOf("020020") != -1 || productType.indexOf("020030") != -1 || productType.indexOf("020040") != -1) {
//			DataObject data = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_FAMILY_FINANCE, "applyId", appBiz.getString("oldAppBizId"));
//			if (data != null) {
//				data.set("applyId", appBiz.get("applyId"));
//				data.unset("financeId");
//				DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, data);
//			}
//		} else {// 经营
//			try {
//				AccFinanceChange.copyFinancesByBizId(appBiz.getString("oldAppBizId"), appBiz.getString("applyId"));
//			} catch (Exception e) {
//				throw new RuntimeException("生成财报数据错误:" + e.getMessage());
//			}
//		}
	}

	protected void createTbBizXmxxApply(Object appBiz, Map<String, Object> dataMap) {
//		DataObject data = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_XMXX_APPLY, "amountDetailId", appBiz.getString("oldAppBizId"));
//		if (data != null) {
//			data.set("amountDetailId", appBiz.get("applyId"));
//			data.unset("relateId");
//			DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, data);
//		}
	}

	protected void createTbBizBankStructApply(Object appBiz, Map<String, Object> dataMap) {
//		DataObject data = EntityUtil.searchEntityByTemplate(BizTableName.TB_BIZ_BANK_STRUCT_APPLY, "applyId", appBiz.getString("oldAppBizId"));
//		if (data != null && data.get("syndicatedStructId") != null) {
//			DataObject[] datas = EntityUtil.searchEntitysByTemplate(BizTableName.TB_BIZ_BANK_MEMBER_APPLY, "syndicatedStructId", data.getString("syndicatedStructId"));
//			data.set("applyId", appBiz.get("applyId"));
//			data.unset("syndicatedStructId");
//			DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, data);
//			for (DataObject obj : datas) {
//				obj.set("syndicatedStructId", data.get("syndicatedStructId"));
//				obj.set("createTime", GitUtil.getCurrDate());
//				obj.unset("syndicatedMemberId");
//				DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, obj);
//			}
//		}
	}

	protected void createTbBizGrtRel(Object appBiz, Map<String, Object> dataMap) {
//		GrtDaoUtil.createTbBizGrtRel(appBiz.getApplyId(), appBiz.getString("oldAppBizId"));//第二个参数为原批复对应的业务申请id
	}

	protected void createTbBizGrtMaxloanconApply(Object appBiz, Map<String, Object> dataMap) {
//		Object[] datas = EntityUtil.searchEntitysByTemplate(BizTableName.TB_BIZ_GRT_MAXLOANCON_APPLY, "applyId", appBiz.getString("oldAppBizId"));
//		for (Object obj : datas) {
//			obj.set("applyId", appBiz.get("applyId"));
//			obj.set("createTime", GitUtil.getCurrDate());
//			obj.unset("relationId");
//			DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, obj);
//		}
	}
}
