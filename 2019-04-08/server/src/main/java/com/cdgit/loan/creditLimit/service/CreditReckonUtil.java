package com.cdgit.loan.creditLimit.service;

import java.math.BigDecimal;

import com.cdgit.loan.common.mapper.BizDaoUtilMapper;
import com.cdgit.loan.common.util.MoneyUtil;
import com.cdgit.loan.common.util.SpringUtil;



public class CreditReckonUtil {

	/*public static ICreditReckon getCrdApp() {
		return (ICreditReckon)SpringUtil.getBean(CrdAppCreditReckon.class);
//		return getBean("creditReckonToCrdApp");
	}*/

//	public static ICreditReckon getCrd() {
//		return (ICreditReckon)SpringUtil.getBean(CrdCreditReckon.class);
////		return getBean("creditReckonToCrd");
//	}

	/*public static ICreditReckon getCrdDtl() {
		
		return (ICreditReckon)SpringUtil.getBean(CrdDtlCreditReckon.class);
		
//		return getBean("creditReckonToCrdDtl");
	}*/

//	public static ICreditReckon getBizApp() {
//		return getBean("creditReckonToBizApp");
//	}
//
//	public static ICreditReckon getBiz() {
//		return getBean("creditReckonToBiz");
//	}
//
//	public static ICreditReckon getBizDtl() {
//		return getBean("creditReckonToBizDtl");
//	}
//
//	public static ICreditReckon getCon() {
//		return getBean("creditReckonToCon");
//	}
//
//	public static ICreditReckon getLoan() {
//		return getBean("creditReckonToLoan");
//	}

	private static String[] maps = { "crdApp", "creditReckonToCrdApp"//
			, "crd", "creditReckonToCrd"//
			, "biz", "creditReckonToBiz"//
			, "crdDtl", "creditReckonToCrdDtl", "bizDtl", "creditReckonToBizDtl"//
			, "con", "creditReckonToCon" };

//	public static ICreditReckon getBeanByPhase(String phase) {
//		for (int i = 0; i < maps.length; i = i + 2) {
//			if (maps[i].equals(phase)) {
//				return getBean(maps[i + 1]);
//			}
//		}
//		throw new RuntimeException("尚未配置额度计算规则[phase=" + phase + "]");
//	}

	/*public static ICreditReckon getBean(String name) {
		return BeanFactory.newInstance().getBean(name);
	}*/

//	public static void newly(String phase, String bizId) {
//		getBeanByPhase(phase).newly(bizId);
//	}
//
//	public static void refurbish(String phase, String bizId) {
//		getBeanByPhase(phase).refurbish(bizId);
//	}

	public static BigDecimal converPer(BigDecimal per) {
		if (per == null || per.compareTo(BigDecimal.ZERO) <= 0) {
			return BigDecimal.ONE;
		} else if (per.compareTo(MoneyUtil.HUNDRED) >= 0) {
			return BigDecimal.ZERO;
		}
		return MoneyUtil.HUNDRED.subtract(per).divide(MoneyUtil.HUNDRED);
	}

	public static BigDecimal formatAmt(BigDecimal amt) {
		return amt.setScale(2, BigDecimal.ROUND_CEILING);
	}

}
