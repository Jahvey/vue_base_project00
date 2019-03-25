package com.cdgit.loan.csm.pub;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MoneyUtil {
	/**
	 * 人民币币种编码
	 */
	public static final String CURRENCYCD_CNY = "CNY";
	
	public static final BigDecimal HUNDRED = new BigDecimal("100");
	
	public  HashMap<String, Object> validRmb(HashMap<String, Object> dataObj) {
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
	
}
