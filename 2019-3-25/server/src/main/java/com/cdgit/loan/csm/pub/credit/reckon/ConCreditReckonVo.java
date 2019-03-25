/**
 * 
 */
package com.cdgit.loan.csm.pub.credit.reckon;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.csm.mapper.CsmCreditReckonMapper;
import com.cdgit.loan.csm.po.TbConContractInfoPo;
import com.cdgit.loan.csm.pub.MoneyUtil;
import com.cdgit.loan.csm.pub.gitUtils.GitUtils;

import ch.qos.logback.core.db.dialect.DBUtil;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class ConCreditReckonVo {
	
	@Autowired
	GitUtils gitUtils;
	
	@Autowired
	CsmCreditReckonMapper csmCreditReckonMapper;
	
	private String[] openGobProducts={
				"01008002","01008010",
				"01008001","01009001",
				"01009002","01009010",
				"010090022","01007014"
			};
	
	
	public boolean isOpenGobProduct(String productCd) {
		return gitUtils.contain(productCd, openGobProducts);
	}
	
	public static BigDecimal converPer(BigDecimal per) {
		if (per == null || per.compareTo(BigDecimal.ZERO) <= 0) {
			return BigDecimal.ONE;
		} else if (per.compareTo(MoneyUtil.HUNDRED) >= 0) {
			return BigDecimal.ZERO;
		}
		return MoneyUtil.HUNDRED.subtract(per).divide(MoneyUtil.HUNDRED);
	}
	
	
	
	public  BigDecimal formatAmt(BigDecimal amt) {
		return amt.setScale(2, BigDecimal.ROUND_CEILING);
	}
	
//	public BigDecimal getOpenGob(Map<String, Object> dataMap) {
//		return getOpenGob((BigDecimal) dataMap.get("RMB_AMT"), (BigDecimal) dataMap.get("ASSURE_PER"), (String) dataMap.get("PRODUCT_TYPE"));
//	}
	
	
	
	public BigDecimal getOpenGob(BigDecimal amt, BigDecimal assurePer, String productType) {
		if (amt == null) {
			throw new RuntimeException("请传入正确的额度信息[amt]");
		}
		if (isOpenGobProduct(productType)) {
			amt = amt.multiply(converPer(assurePer));
			return formatAmt(amt);
		}
		return formatAmt(amt);
	}
	
	
	public BigDecimal getOpenGob(TbConContractInfoPo bizDtl) {
		return getOpenGob(bizDtl.getRmbAmt(), bizDtl.getBzjbl(), bizDtl.getProductType());
	}
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getCreditMap(String conId) {
		List<HashMap<String,Object>> datas = csmCreditReckonMapper.getConCredit(conId);
		
		
		if (datas == null || datas.size() == 0) {
			return null;
		}
		return datas.get(0);
	}

}
