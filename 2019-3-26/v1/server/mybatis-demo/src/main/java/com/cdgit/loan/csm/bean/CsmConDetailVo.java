/**
 * 
 */
package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cwalk
 *
 */
public class CsmConDetailVo {
	private String contractId;
	
	private String applyDetailId;
	
	private Date updateTime;
	
	private Date createTime;
	
	private String productType;
	
	private String srcTableName;
	
	private String tarTableName;
	
	private String loanUse;
	
	
	private BigDecimal hpTotalAmt;
	
	private String hpbh;
	
	private Date txqq;
	
	
	

	public BigDecimal getHpTotalAmt() {
		return hpTotalAmt;
	}

	public void setHpTotalAmt(BigDecimal hpTotalAmt) {
		this.hpTotalAmt = hpTotalAmt;
	}

	public String getHpbh() {
		return hpbh;
	}

	public void setHpbh(String hpbh) {
		this.hpbh = hpbh;
	}

	public Date getTxqq() {
		return txqq;
	}

	public void setTxqq(Date txqq) {
		this.txqq = txqq;
	}

	public String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getApplyDetailId() {
		return applyDetailId;
	}

	public void setApplyDetailId(String applyDetailId) {
		this.applyDetailId = applyDetailId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getSrcTableName() {
		return srcTableName;
	}

	public void setSrcTableName(String srcTableName) {
		this.srcTableName = srcTableName;
	}

	public String getTarTableName() {
		return tarTableName;
	}

	public void setTarTableName(String tarTableName) {
		this.tarTableName = tarTableName;
	}

	@Override
	public String toString() {
		return "CsmConDetailVo [contractId=" + contractId + ", applyDetailId=" + applyDetailId + ", updateTime="
				+ updateTime + ", createTime=" + createTime + ", productType=" + productType + ", srcTableName="
				+ srcTableName + ", tarTableName=" + tarTableName + ", loanUse=" + loanUse + ", hpTotalAmt="
				+ hpTotalAmt + ", hpbh=" + hpbh + ", txqq=" + txqq + "]";
	}

	
	
	

}
