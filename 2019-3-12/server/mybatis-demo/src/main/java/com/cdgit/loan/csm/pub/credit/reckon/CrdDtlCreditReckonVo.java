/**
 * 
 */
package com.cdgit.loan.csm.pub.credit.reckon;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdgit.loan.common.util.StringUtil;
import com.cdgit.loan.csm.mapper.CsmCreditReckonMapper;

/**
 * @author cwalk
 *
 */
@Service
@Transactional
public class CrdDtlCreditReckonVo {

	public static final String CYCLE = "1";
	/**
	 * 针对 creditStatus字段设置，定义[01]为有效状态
	 */
	public static final String STATUS_DO = "01";
	/**
	 * 半失效状态，只失效自己
	 */
	public static final String STATUS_ABATE = "59";
	
	
	@Autowired
	CsmCreditReckonMapper csmCreditReckonMapper;
	
	private String[] openGobProducts={
			"01008002","01008010",
			"01008001","01009001",
			"01009002","01009010",
			"010090022","01007014",
			"01007","01008","01009"
		};
	
	
	
	public BigDecimal validBoUse(String bizId, BigDecimal appAmt) {
		if (StringUtil.isNull(bizId)) {
			throw new RuntimeException("可用额度扣减失败：错误的编号[" + bizId + "]");
		}
		if (appAmt == null || appAmt.compareTo(BigDecimal.ZERO) < 0) {
			throw new RuntimeException("可用额度扣减失败：错误的扣减额度[amount=" + appAmt + "]");
		}
		BigDecimal boUser = getBoUse(bizId);
		if (boUser.compareTo(appAmt) < 0) {
			throw new RuntimeException("可用额度校验失败：可用额度[" + boUser + "]，申请额度[" + appAmt + "]");
		}
		return boUser;
	}
	
	
	public BigDecimal getBoUse(String bizId) {
		HashMap<String, Object> map = getCreditMap(bizId);
		if (map == null || map.get("BO_USE") == null || !STATUS_DO.equals(map.get("CREDIT_STATUS"))) {
			return BigDecimal.ZERO;
		}
		return (BigDecimal) map.get("BO_USE");
	}
	
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getCreditMap(String crdDtlId) {
		List<HashMap<String,Object>> datas = csmCreditReckonMapper.getCrdDtlCredit(crdDtlId);
		
		//Object[] datas = DatabaseExt.queryByNamedSql(DBUtil.DB_NAME_DEF, "com.bos.pub.credit.reckon.CreditReckonSql.getCrdDtlCredit", crdDtlId);
		if (datas == null || datas.size() == 0) {
			return null;
		}
		return datas.get(0);
	}
	
	
	
	
	
	
	
}
