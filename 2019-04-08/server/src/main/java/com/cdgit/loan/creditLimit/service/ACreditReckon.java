package com.cdgit.loan.creditLimit.service;

import java.math.BigDecimal;
import java.util.Map;

import com.cdgit.loan.common.util.GitUtil;
import com.cdgit.loan.common.util.MoneyUtil;
import com.cdgit.loan.common.util.StringUtil;


public abstract class ACreditReckon implements ICreditReckon {

	protected ICreditReckon sonReckon;
	protected String[] openGobProducts;

	@Override
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

	@Override
	public BigDecimal validNoUse(String bizId, BigDecimal amount) {
		if (StringUtil.isNull(bizId)) {
			throw new RuntimeException("冻结额度增加失败：错误的编号[" + bizId + "]");
		}
		if (amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {
			throw new RuntimeException("冻结额度增加失败：错误的额度[amount=" + MoneyUtil.getMoney(amount) + "]");
		}
		BigDecimal noUser = getNoUse(bizId);
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			if (noUser.compareTo(amount.abs()) < 0) {
				throw new RuntimeException("冻结额度恢复失败：可恢复额度[" + MoneyUtil.getMoney(noUser) + "]，恢复额度[" + MoneyUtil.getMoney(amount.abs()) + "]");
			}
		}
		return noUser;
	}

	@Override
	public void newly(String bizId) {
		Map<String, Object> map = getCreditMap(bizId);
		String statusCd = getStatus(map);
		if (statusCd == null) {
			return;
		}
		if (STATUS_DO.equals(statusCd)) {
			updateCredit(bizId, map);
		} else {
			abateCredit(bizId, statusCd);
		}
	}

	@Override
	public void abateCredit(String bizId, String statusCd) {
		if (statusCd == null || GitUtil.contain(statusCd, new String[] { "01", "02", "03" })) {
			throw new RuntimeException("请传入正确的状态[" + statusCd + "]");
		}
		abateCreditMe(bizId, statusCd);
		Object[] sonInfos = getSonIds(bizId);
		if (sonInfos == null || sonInfos.length == 0) {
			return;
		}
		// 半失效状态需要继续更新子节点数据
		// if (STATUS_ABATE.equals(statusCd)) {
		for (int i = 0; i < sonInfos.length; i++) {
			updateCreditSon(sonInfos[i]);
		}
		// }
		// else {
		// for (int i = 0; i < sonInfos.length; i++) {
		// abateCreditSon(sonInfos[i], statusCd);
		// }
		// }
	}

	public void updateCredit(String bizId, Map<String, Object> map) {
		Object[] sonInfos = getSonIds(bizId);
		if (sonInfos != null && sonInfos.length > 0) {
			for (int i = 0; i < sonInfos.length; i++) {
				updateCreditSon(sonInfos[i]);
			}
		}
		updateCreditMe(bizId, map);
	}

	@Override
	public BigDecimal getRmbAmt(String bizId) {
		Map<String, Object> map = getCreditMap(bizId);
		if (map == null || map.get("RMB_AMT") == null) {
			throw new RuntimeException("获取[rmbAmt]数据失败:[bizId=" + bizId + "]");
		}
		return (BigDecimal) map.get("RMB_AMT");
	}

	@Override
	public BigDecimal getOpenGob(String bizId) {
		Map<String, Object> map = getCreditMap(bizId);
		if (map == null || map.get("RMB_AMT") == null) {
			throw new RuntimeException("获取[rmbAmt]数据失败:[bizId=" + bizId + "]");
		}
		return getOpenGob((BigDecimal) map.get("RMB_AMT"), (BigDecimal) map.get("ASSURE_PER"), (String) map.get("PRODUCT_TYPE"));
	}

	@Override
	public BigDecimal getOpenGob(BigDecimal amt, BigDecimal assurePer, String productType) {
		if (amt == null) {
			throw new RuntimeException("请传入正确的额度信息[amt]");
		}
		if (isOpenGobProduct(productType)) {
			amt = amt.multiply(CreditReckonUtil.converPer(assurePer));
			return CreditReckonUtil.formatAmt(amt);
		}
		return CreditReckonUtil.formatAmt(amt);
	}

	@Override
	public BigDecimal getOpenGob(Map<String, Object> dataMap) {
		BigDecimal amt = (BigDecimal) dataMap.get("RMB_AMT");
		if (amt == null) {
			throw new RuntimeException("请传入正确的额度信息[RMB_AMT]");
		}
		return CreditReckonUtil.formatAmt(amt);
	}

	@Override
	public BigDecimal getOpenGob(Object bizObj) {
//		BigDecimal amt = bizObj.getBigDecimal("rmbAmt");
//		if (amt == null) {
//			throw new RuntimeException("请传入正确的额度信息[rmbAmt]");
//		}
//		return CreditReckonUtil.formatAmt(amt);
		return new BigDecimal(1);
	}

	@Override
	public BigDecimal getBoUse(String bizId) {
		Map<String, Object> map = getCreditMap(bizId);
		if (map == null || map.get("BO_USE") == null || !isBoUse(getStatus(map))) {
			return BigDecimal.ZERO;
		}
		return (BigDecimal) map.get("BO_USE");
	}

	@Override
	public BigDecimal getNoUse(String bizId) {
		Map<String, Object> map = getCreditMap(bizId);
		return map == null || map.get("NO_USE") == null ? BigDecimal.ZERO : (BigDecimal) map.get("NO_USE");
	}

	@Override
	public boolean isOpenGobProduct(String productCd) {
		return GitUtil.contain(productCd, openGobProducts);
	}

	protected void updateCreditSon(Object sonData) {
		sonReckon.newly((String) sonData);
	}

	protected void abateCreditSon(Object sonData, String statusCd) {
		sonReckon.abateCredit((String) sonData, statusCd);
	}

	protected abstract void updateCreditMe(String bizId, Map<String, Object> map);

	protected abstract void abateCreditMe(String bizId, String statusCd);

	protected boolean isBoUse(String status) {
		return STATUS_DO.equals(status);
	}

	public String getStatus(String bizId) {
		return getStatus(getCreditMap(bizId));
	}

	protected String getStatus(Map<String, Object> map) {
		return null;
	};

	public Object[] getSonIds(String bizId) {
		return null;
	}

	public void setSonReckon(ICreditReckon sonReckon) {
		this.sonReckon = sonReckon;
	}

	public ICreditReckon getSonReckon() {
		return sonReckon;
	}

	public String[] getOpenGobProducts() {
		return openGobProducts;
	}

	public void setOpenGobProducts(String[] openGobProducts) {
		this.openGobProducts = openGobProducts;
	}
}
