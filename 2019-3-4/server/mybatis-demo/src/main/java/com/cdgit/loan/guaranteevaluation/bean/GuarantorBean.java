package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 自定义bean，保证人列表
 * @author GIT-cd
 *
 */
public class GuarantorBean {
	private String guaranteeType;
	private String currencyCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal suretyAmt;
    @JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal usableGuaranteeLimit;
    @JsonSerialize(using=BigDecimalConvertToString.class)
	private BigDecimal usedGuaranteeLimit;
	private String partyName;
	private String partyId;
	private String suretyId;
	private String relationId;
	public String getGuaranteeType() {
		return guaranteeType;
	}
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public BigDecimal getSuretyAmt() {
		return suretyAmt;
	}
	public void setSuretyAmt(BigDecimal suretyAmt) {
		this.suretyAmt = suretyAmt;
	}
	public BigDecimal getUsableGuaranteeLimit() {
		return usableGuaranteeLimit;
	}
	public void setUsableGuaranteeLimit(BigDecimal usableGuaranteeLimit) {
		this.usableGuaranteeLimit = usableGuaranteeLimit;
	}
	public BigDecimal getUsedGuaranteeLimit() {
		return usedGuaranteeLimit;
	}
	public void setUsedGuaranteeLimit(BigDecimal usedGuaranteeLimit) {
		this.usedGuaranteeLimit = usedGuaranteeLimit;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getSuretyId() {
		return suretyId;
	}
	public void setSuretyId(String suretyId) {
		this.suretyId = suretyId;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	
}
