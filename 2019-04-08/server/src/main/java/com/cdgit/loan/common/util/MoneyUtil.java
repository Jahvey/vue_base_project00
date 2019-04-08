package com.cdgit.loan.common.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class MoneyUtil {
	/**
	 * 人民币币种编码
	 */
	public static final String CURRENCYCD_CNY = "CNY";

	public static final BigDecimal HUNDRED = new BigDecimal("100");

	/**
	 * 根据币种获取当前人民币金额
	 * @param amt
	 * @param currency_cd
	 * @return
	 */
//	public static BigDecimal getMoneyToRmb(BigDecimal amt, String currency_cd) {
//		if (amt == null || amt.compareTo(BigDecimal.ZERO) == 0) {
//			return amt;
//		}
//		BigDecimal changeRate = getExchangeRate(currency_cd);
//		amt = amt.multiply(changeRate);
//		return MoneyUtil.getMoney(amt);
//	}

	public static BigDecimal getMoney(BigDecimal money) {
		if (money == null) {
			return BigDecimal.ZERO.setScale(2);
		}
		return money.setScale(2, BigDecimal.ROUND_UP);
	}

	public static BigDecimal getMoney(String money) {
		if (money == null || (money = money.trim()).isEmpty()) {
			return BigDecimal.ZERO.setScale(2);
		}
		money = money.replace(",", "");
		if (money.isEmpty()) {
			return BigDecimal.ZERO.setScale(2);
		}
		BigDecimal b = new BigDecimal(money);
		return b.setScale(2, BigDecimal.ROUND_UP);
	}

	public  static Map<String, Object> validRmb(Map<String, Object> dataObj) {
		String[] amtKeys = { "amt", "dtlAmt", "detailAmt", "contractAmt", "loanAmt" };
		BigDecimal amt = null;
		for (String key : amtKeys) {
			if ((amt = (BigDecimal)dataObj.get(key)) != null) {
				break;
			}
		}
		if (amt == null) {
			throw new RuntimeException("未获取到申请金额信息");
		}
		BigDecimal rmb = (BigDecimal)dataObj.get("rmbAmt");
		BigDecimal rate = (BigDecimal)dataObj.get("exchangeRate");
		String currencyCd =(String) dataObj.get("currencyCd");
		if (rate == null) {
			if (!MoneyUtil.CURRENCYCD_CNY.equals(currencyCd)) {
				throw new RuntimeException("币种非[人民币]，必须填入对应的汇率信息");
			}
			rmb = amt;
			rate = BigDecimal.ONE;
			dataObj.put("exchangeRate", rate);
		} else {
			rmb = amt.multiply(rate);
		}
		dataObj.put("rmbAmt", rmb);
		
		
		return dataObj;
	}
	
	/**
	 * 根据信贷的币种码值获取当前币种汇率
	 * 
	 * @param currency_cd
	 * @return
	 */
//	public static BigDecimal getExchangeRate(String currency_cd) {
//		if (StringUtil.isNull(currency_cd)) {
//			throw new RuntimeException("错误的币种码值[" + currency_cd + "]");
//		} else if (CURRENCYCD_CNY.equals(currency_cd)) {
//			return BigDecimal.ONE;
//		}
//		DataObject hlObj = EosUtil.createDataObject();
//		hlObj.set("ccyTp", currency_cd);
//		try {
//			hlObj = EsbSocketService.instance().socketDataObject("RQ07003000001BODY01", new EsbAppHeadRq(), hlObj);
//			if (hlObj.getBigDecimal("crnExcRate") != null) {
//				throw new RuntimeException("获取汇率信息失败[currency_cd=" + currency_cd + "]");
//			}
//			return hlObj.getBigDecimal("crnExcRate").divide(HUNDRED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("获取汇率信息失败[currency_cd=" + currency_cd + "]");
//		}
//	}

//	public static void validRmb(Object dataObj) {
//		String[] amtKeys = { "amt", "dtlAmt", "detailAmt", "contractAmt", "loanAmt" };
//		BigDecimal amt = null;
//		for (String key : amtKeys) {
//			if ((amt = dataObj.getBigDecimal(key)) != null) {
//				break;
//			}
//		}
//		if (amt == null) {
//			throw new RuntimeException("未获取到申请金额信息");
//		}
//		BigDecimal rmb = dataObj.getBigDecimal("rmbAmt");
//		BigDecimal rate = dataObj.getBigDecimal("exchangeRate");
//		String currencyCd = dataObj.getString("currencyCd");
//		if (rate == null) {
//			if (!MoneyUtil.CURRENCYCD_CNY.equals(currencyCd)) {
//				throw new RuntimeException("币种非[人民币]，必须填入对应的汇率信息");
//			}
//			rmb = amt;
//			rate = BigDecimal.ONE;
//			dataObj.set("exchangeRate", rate);
//		} else {
//			rmb = amt.multiply(rate);
//		}
//		dataObj.set("rmbAmt", rmb);
//	}

}
