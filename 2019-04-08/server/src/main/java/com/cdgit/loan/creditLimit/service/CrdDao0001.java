package com.cdgit.loan.creditLimit.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.business.bean.TbBizAmountDetailApply;
import com.cdgit.loan.business.bean.TbBizApply;
import com.cdgit.loan.business.bean.TbBizApplyLocking;
import com.cdgit.loan.business.mapper.BusinessMapper;
import com.cdgit.loan.common.bean.ApplyDaoParam;
import com.cdgit.loan.common.service.AApplyDao;
import com.cdgit.loan.common.service.ApplyDaoUtils;
import com.cdgit.loan.common.util.BeanUtil;
import com.cdgit.loan.common.util.BizDaoUtil;
import com.cdgit.loan.common.util.BizNumGenerator;
import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.MoneyUtil;
import com.cdgit.loan.common.util.uid.UUIDGenerator;
import com.cdgit.loan.creditLimit.bean.TbCrdApply;
import com.cdgit.loan.creditLimit.bean.TbCrdDetailApply;
import com.cdgit.loan.creditLimit.mapper.CrdDaoUtilMapper;
import com.cdgit.loan.creditLimit.mapper.CreditLimitMapper;
import com.cdgit.loan.user.bean.TbCsmCorporation;
import com.cdgit.loan.user.mapper.TbCsmCorporationMapper;


/**
 * 授信-分离式-创建
 * 
 * @author crms18
 * 
 */
public class CrdDao0001 extends AApplyDao {
	
	@Autowired
	TbCsmCorporationMapper corporationMapper;
	
	@Autowired
	CrdDaoUtilMapper crdDaoUtilMapper;
	
	@Autowired
	CreditLimitMapper creditLimitMapper;
	
	@Autowired
	BusinessMapper businessMapper;
	
	public String getEntityId() {
		return "crdId";
	}

	@Override
	public String createValid(Map<String, Object> map) {
		
		TbCsmCorporation corp=corporationMapper.selectByPrimaryKey((String)map.get("partyId"));
		
		String rule = "CSM_0205";
		// 担保公司必须在非融资业务客户的分离式授信名单内才能发起业务
		if ("1".equals(corp.getIsThirdCust()) && "1".equals(corp.getThirdCustTypeCd())) {
			rule = "CSM_0206";
		}
		map.put("listType", "02");
		createValidOther(map);
		map.put("userNum", GitUtil.getCurrentUserId());
		
//		RuleUtil.runRules(map, rule//
//				, "RCRD_0224"// 客户存在在途授信业务
//				, "RCRD_0223"// 客户存在已生效授信业务
//				, "RBIZ_0085"// 存在在途的单笔业务申请
//				, "XFE_0002"// 业务移交
		// , "RBIZ_0042"// 统一授信成员存在在途综合授信或非银团非低风险的单笔业务
		// , "RBIZ_0019"// 统一授信成员只能发起低风险或银团贷款
//		);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Object createApply(Map<String, Object> dataMap) {
		TbCrdApply crd = createCrd(dataMap);
		createBiz(crd, dataMap);
		// 关联有效的非低，非银团合同与借据，关联都以合同层面关联
		Map<String, Object[]> joinMap = joinAvailConToDtl(dataMap);
		for (String productCd : joinMap.keySet()) {
			Object[] infos = joinMap.get(productCd);
			TbCrdDetailApply crdDtl = createCrdDtl(crd, productCd, infos);
			// 保存明细与合同的关联关系，在流程结束时修改已有合同与用信关联关系
			saveApplyLocking(crdDtl.getCrdDtlId(), (Set<String>) infos[0]);//这个方法待TB_BIZ_APPLY_LOCKING 生成后再做
		}
		if (joinMap.size() > 0) {
//			CreditReckonUtil.getCrdApp().refurbish(crd.getString("crdId"));// 调用这个类里面的方法CrdAppCreditReckon
			crdDaoUtilMapper.updateCrdAppCredit(crd.getCrdId());//提交有没有问题 先已经插入,后面再更新
		}
		return crd;
	}

	@Override
	public Object update(Map<String, Object> dataMap) {
		String crdId = (String) dataMap.get("crdId");
//		DataObject crd = EntityUtil.getEntityById(CrdTableName.TB_CRD_APPLY, "crdId", crdId);
		TbCrdApply crd=crdDaoUtilMapper.selectCrdAppByPrimaryKey(crdId);
		if (!"01".equals(crd.getStatusCd())) {
			throw new RuntimeException("非[未提交]状态数据不允许操作");
		}
		updateCrd(crd, dataMap);
		updateBiz(crd, dataMap);
		return crd;
	}

//	@Override
//	public void remove(String crdId) {
//		DataObject crdApp = EntityUtil.getEntityById(CrdTableName.TB_CRD_APPLY, "crdId", crdId);
//		remove(crdApp);
//	}
	
//	@Override
//	public void remove(DataObject crdApp) {
//		if (!"01".equals(crdApp.getString("statusCd"))) {
//			throw new RuntimeException("非[未提交]状态数据不允许操作");
//		}
//		String crdId = crdApp.getString("crdId");
//		// 删除明细信息
//		DatabaseExt.executeNamedSql(DBUtil.DB_NAME_DEF, "com.bos.crd.AppCrdSql.removeCrdDtlAll", crdId);
//		// 删除附属数据
//		removeCrdOther(crdId);
//		// 删除关联的用信信息
//		String bizId = crdApp.getString("bizId");
//		if (bizId != null) {
//			ApplyDaoParam param = getDaoParam();
//			param.setPhase("biz");
//			param.setCode("0201");
//			ApplyDaoUtil.getApplyDao(param).remove(bizId);
//		}
//		// 删除授信主体
//		DatabaseUtil.deleteEntity(DBUtil.DB_NAME_DEF, crdApp);
//	}

	@Override
	public Object saveDetail(Map<String, Object> dataMap) {
		saveDetailValid(dataMap);
//		DataObject crdDtl = EosUtil.createDataObjectByMap(CrdTableName.TB_CRD_DETAIL_APPLY, dataMap);
//		TbCrdDetailApply crdDtl=new TbCrdDetailApply();
		
		TbCrdDetailApply crdDtl=(TbCrdDetailApply)BeanUtil.convertMap(TbCrdDetailApply.class, dataMap);
		MoneyUtil.validRmb(dataMap);//
		if (dataMap.get("crdDtlId") == null) {// 添加明细
//			DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, crdDtl);
			crdDtl.setCrdDtlId(UUIDGenerator.getUUID());
			creditLimitMapper.insertCrdAppDtl(crdDtl);
		} else {
//			crdDtl.set("updateTime", GitUtil.getCurrDate());
//			DataObject temp = EosUtil.copy(crdDtl, "oldCrdDtlId", "crdId", "applyDate", "boUse");
//			DatabaseUtil.updateEntity(DBUtil.DB_NAME_DEF, temp);
			
			crdDtl.setUpdateTime(GitUtil.getCurrDate());
			crdDtl.setOldCrdDtlId("");//理解为置空  这段逻辑需要测试
			crdDtl.setBoUse(new BigDecimal(0.0d));
//			crdDtl.setCrdId("");//
			creditLimitMapper.updateCrdDtlApply(crdDtl);
			
			removeBizDtl(crdDtl);
		}
//		CreditReckonUtil.getCrdApp().refurbish((String) dataMap.get("crdId"));
		return crdDtl;
	}
	
	@Override
	public void removeDetail(String crdDtlId) {
		TbCrdDetailApply crdDtl=crdDaoUtilMapper.selectCrdDtlApp(crdDtlId);
		BigDecimal boUse = crdDtl.getBoUse();
		if (boUse != null && boUse.compareTo(BigDecimal.ZERO) > 0) {
			throw new RuntimeException("该明细为纳入数据，项下存在生效合同或借据信息，無法删除");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("crdDtlId", crdDtlId);
//		RuleUtil.runRules(map, "RCRD_0219");
		removeBizDtl(crdDtl);
		creditLimitMapper.deleteCrdDtl(crdDtlId);
	}

	protected String createValidOther(Map<String, Object> map) {
		return null;
	}

	/**
	 * 统计当前时间点，客户名下所有有效合同信息
	 * 注意：该算法全部按照人民币币种计算，如果合同存在其他币种自动转换为人民币，并且按照合同签约时的汇率统计额度,授信途中不再显示其他币种
	 * 
	 * @param dataMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object[]> joinAvailConToDtl(Map<String, Object> dataMap) {
		List datas=crdDaoUtilMapper.getAvailConToCrdDtl(dataMap);
		
		Map<String, Object[]> joinMap = new HashMap<String, Object[]>();
		for (int i = 0; i < datas.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) datas.get(i);
			// 分离式授信使用二级产品; 一体化授信使用三级产品
			String productCd = getProductCd(map);
			if (productCd == null) {
				throw new RuntimeException("需要纳入的数据没有找到对应的产品信息[" + map + "]");
			}
			Object[] joinInfo = joinMap.get(productCd);
			if (joinInfo == null) {
				joinInfo = new Object[] { new HashSet<String>(), BigDecimal.ZERO };
				joinMap.put(productCd, joinInfo);
			}
			// joinInfo[0] = ((BigDecimal) joinInfo[0]).add(getConOpenAmt(map));
			((Set<String>) joinInfo[0]).add((String) map.get("APPROVE_ID"));
			joinInfo[1] = ((BigDecimal) joinInfo[1]).add((BigDecimal) map.get("CON_OCCUPY"));
		}
		return joinMap;
	}

//	protected BigDecimal getConOpenAmt(Map<String, Object> map) {// 计算合同敞口额度
//		return CreditReckonUtil.getCon().getOpenGob(map);
//	}

	protected void saveApplyLocking(String crdDtlId, Set<String> bizIds) {
		for (String bizId : bizIds) {
			TbBizApplyLocking locking=new TbBizApplyLocking();
			locking.setApplyId(crdDtlId);
			locking.setLockBizId(bizId);
			locking.setLockTable("TB_BIZ_APPROVE");
			locking.setLockType("crdApp");
			businessMapper.insertLocking(locking);
		}
	}

	/**
	 * 创建额度申请基本信息
	
	 * <p>Title: createCrd</p>  
	
	 * <p>Description: </p>  
	
	 * @param dataMap
	 * @return
	 */
	public TbCrdApply createCrd(Map<String, Object> dataMap) {
//		DataObject crd = EosUtil.createDataObjectByMap(CrdTableName.TB_CRD_APPLY, dataMap);
		TbCrdApply crd=new TbCrdApply();
		crd.setCrdId(UUIDGenerator.getUUID());
		crd.setCsmCrdLevel(CsmUtil.getCreditLevel((String)dataMap.get("partyId"), null));
		crd.setCrdNum("SX" + BizNumGenerator.getBizNum("SEQ_BIZ_PF"));
		crd.setOrgNum(GitUtil.getCurrentOrgCd());
		crd.setUserNum(GitUtil.getCurrentUserId());
//		crd.set("createTime", GitUtil.getCurrDate());
//		crd.setCreateTime(GitUtil.getCurrDate());//数据库还没这个字段
		crd.setApplyDate(GitUtil.getBusiDate());
		crd.setTermNum(new BigDecimal(12));
		crd.setStatusCd("01");//
		crd.setTermUnit("04");;
		crd.setHappenType(BizDaoUtil.getHappenType((String) dataMap.get("partyId")));
		crd.setCreditMode(getCreditMode());
		crdDaoUtilMapper.insertCrd(crd);
		return crd;
	}

	protected Object updateCrd(TbCrdApply crd, Map<String, Object> dataMap) {
		// 只更新修改过的数据  如何实现只更新修改过的数据
//		Object temp = DataObjectUtil.createDataObject(CrdTableName.TB_CRD_APPLY);
		crd.setGuarantyType((String)dataMap.get("guarantyType"));
		crd.setTermNum((BigDecimal)dataMap.get("termNum"));
		crdDaoUtilMapper.updateCrdApp(crd);//后期需要修改
		return crd;
	}

	/**
	 * 
	
	 * <p>Title: createCrdDtl</p>  
	
	 * <p>Description: </p>  
	
	 * @param crd
	 * @param productCd
	 * @param infos
	 * @return
	 */
	protected TbCrdDetailApply createCrdDtl(TbCrdApply crd, String productCd, Object[] infos) {
//		DataObject crdDtl = DataObjectUtil.createDataObject(CrdTableName.TB_CRD_DETAIL_APPLY);
//		DatabaseUtil.insertEntity(DBUtil.DB_NAME_DEF, crdDtl);
		TbCrdDetailApply crdDtl=new TbCrdDetailApply();
		crdDtl.setCrdDtlId(UUIDGenerator.getUUID());
		crdDtl.setCrdId(crd.getCrdId());
		crdDtl.setTermUnit(crd.getTermUnit());
		crdDtl.setProductType(productCd);
		crdDtl.setCycleInd(productCd.startsWith("01003") ? "0" : "1");
		crdDtl.setCreditMode(getCreditMode());
		crdDtl.setCurrencyCd(MoneyUtil.CURRENCYCD_CNY);
		crdDtl.setBoUse((BigDecimal) infos[1]);
		crdDtl.setDtlAmt((BigDecimal) infos[1]);
		crdDtl.setRmbAmt((BigDecimal) infos[1]);
		return crdDtl;
	}

	/**
	 * 以前的模式是无论分离式授信 一体模式创建用信记录
	分离式在流程结束时删除
	 * <p>Title: createBiz</p>  
	
	 * <p>Description: </p>  
	
	 * @param crd
	 * @param dataMap
	 * @return
	 */
	protected Object createBiz(TbCrdApply crd, Map<String, Object> dataMap) {
		dataMap.put("crdId", crd.getCrdId());
		dataMap.put("csmCrdLevel", crd.getCsmCrdLevel());
		dataMap.put("termNum", crd.getTermNum());
		dataMap.put("termUnit", crd.getTermUnit());
		// 创建用信基本信息,无论分离还是一体模式都创建用信用信记录，分离式在流程结束时删除
		ApplyDaoParam param = getDaoParam();
		param.setPhase("biz");
		param.setCode("0201");
		Object biz = ApplyDaoUtils.getApplyDao(param).create(dataMap);
		// 在crd中缓存bizid方便后续处理                        如何替换下面的更新 bizId这一步 先生成bizId直接插入
		crd.setBizId(((TbBizApply)biz).getApplyId());//从创建的用信记录中查询bizid  如何定义一个通用的DataObject 对象  这里需要考虑下
		crdDaoUtilMapper.updateCrdApp(crd);
		return biz;
	}

	protected Object updateBiz(TbCrdApply crd, Map<String, Object> dataMap) {
		// 联动刷新用信数据
		dataMap.put("bizId", crd.getBizId());
		dataMap.put("bizHappenType", crd.getHappenType());
		ApplyDaoParam param = getDaoParam();
		param.setPhase("biz");
		param.setCode("0201");
		return ApplyDaoUtils.getApplyDao(param).update(dataMap);
	}

	protected TbCrdDetailApply saveDetailValid(Map<String, Object> dataMap) {
		String productType = (String) dataMap.get("productType");
		if (productType.startsWith("01006")) {// 贴现
			throw new RuntimeException("综合授信下不能做该产品");
		} else if (GitUtil.contain(productType, new String[] { "01007012" })) {
			throw new RuntimeException("福费廷只能申请低风险业务");
		} else if (ApplyDaoUtils.CREDIT_MODE_UNITE.equals(dataMap.get("creditMode")) && productType.startsWith("01008")) {
			dataMap.put("listType", "02");
			dataMap.put("ruleMsg", "无法以一体化模式添加该产品");
//			RuleUtil.runRules(dataMap, "RBIZ_0200");
		}
//		if (CreditReckonUtil.getCrdDtl().isOpenGobProduct(productType)) {
//			BigDecimal assurePer;
//			if (dataMap.get("assurePer") == null) {
//				dataMap.put("assurePer", "0");
//			} else if ((assurePer = new BigDecimal((String) dataMap.get("assurePer"))).compareTo(BigDecimal.ZERO) < 0 || assurePer.compareTo(MoneyUtil.HUNDRED) > 0) {
//				throw new RuntimeException("保证金比例只能在[0-100]之间");
//			}
//		}
		BigDecimal dtlAmt = new BigDecimal((String) dataMap.get("dtlAmt"));
		if (dtlAmt.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("错误的明细金额[" + dtlAmt + "]");
		}
		String crdDtlId = (String) dataMap.get("crdDtlId");
		if (crdDtlId == null) {// 添加明细
//			RuleUtil.runRules(dataMap, "RCRD_0217", "RCRD_0218");
			return null;
		}
		
		TbCrdDetailApply crdDtl = crdDaoUtilMapper.selectCrdDtlApp(crdDtlId);
		
		
		BigDecimal minAmt = crdDtl.getBoUse();
		String oldProductType = crdDtl.getProductType();
		if (ApplyDaoUtils.CREDIT_MODE_UNITE.equals(dataMap.get("creditMode"))) {
			if (!productType.startsWith(oldProductType)) {
				throw new RuntimeException("非[分离式]模式下不允许变更产品信息");
			}
		} else {
			if (!oldProductType.startsWith(productType)) {
				throw new RuntimeException("[分离式]模式下不允许变更产品类型");
			}
		}
		if (minAmt != null && minAmt.compareTo(BigDecimal.ZERO) > 0) {
			if (dtlAmt.compareTo(minAmt) < 0) {
				throw new RuntimeException("该明细额度不能小于[" + minAmt + "]");
			}
		}
//		RuleUtil.runRules(dataMap, "RCRD_0219", "RCRD_0220");
		return crdDtl;
	}

	protected void removeBizDtl(TbCrdDetailApply crdDtl) {
		// 此处模式只支持crdDtl - bizDtl 1：1模式，若要扩展需要改造
		String bizDtlId = CrdDaoUtil.getAppCrdBizDtlId(crdDtl.getCrdDtlId());
		if (bizDtlId == null) {
			return;
		}
//		DataObject bizDtl = DataObjectUtil.createDataObject(BizTableName.TB_BIZ_AMOUNT_DETAIL_APPLY);
		
		TbBizAmountDetailApply bizDtl=new TbBizAmountDetailApply();
		bizDtl.setAmountDetailId(bizDtlId);
		bizDtl.setProductType(crdDtl.getProductType());
		ApplyDaoParam param = getDaoParam();
		param.setPhase("biz");
		param.setCode("0201");
		param.setProduct(bizDtl.getProductType());
		ApplyDaoUtils.getDetailDao(param).remove(bizDtl);
	}

//	private void removeCrdOther(String crdId) {
//		// 岗位责任
//		BizDaoUtil.removeTbBizXb(crdId);
//		// 授信测算
//		CrdDaoUtil.removeTbBizCreditLineMeasure(crdId);
//		// 监管报送信息
//		// BizDaoUtil.removeTbBizYesornoApply(crdId);
//		// -----------------
//		// BizDaoUtil.removeTbBizBankStructApply(crdId);
//	}

	protected String getCreditMode() {
		return ApplyDaoUtils.CREDIT_MODE_CLEFT;
	}

	protected String getProductCd(Map<String, Object> conMap) {
		return (String) conMap.get("SUPERIOR_ID");
	}
}

