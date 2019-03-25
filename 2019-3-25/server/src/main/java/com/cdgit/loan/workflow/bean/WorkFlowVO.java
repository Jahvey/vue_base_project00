package com.cdgit.loan.workflow.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class WorkFlowVO {

	private String name; 
	
	private Double contractAmt;
	
	private BigDecimal floatRate;
	
	private Date endDate;
	
	private boolean headerAdminFlag; //是否区联社管理员 
	
	private Timestamp current;
	
	/**
	 * 期限
	 */
	private Long term;
	
	private int isPJ;
	
	private String partyId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getContractAmt() {
		return contractAmt;
	}

	public void setContractAmt(Double contractAmt) {
		this.contractAmt = contractAmt;
	}

	public BigDecimal getFloatRate() {
		return floatRate;
	}

	public void setFloatRate(BigDecimal floatRate) {
		this.floatRate = floatRate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isHeaderAdminFlag() {
		return headerAdminFlag;
	}

	public void setHeaderAdminFlag(boolean headerAdminFlag) {
		this.headerAdminFlag = headerAdminFlag;
	}

	public Timestamp getCurrent() {
		return current;
	}

	public void setCurrent(Timestamp current) {
		this.current = current;
	}

	public Long getTerm() {
		return term;
	}

	public void setTerm(Long term) {
		this.term = term;
	}

	public int getIsPJ() {
		return isPJ;
	}

	public void setIsPJ(int isPJ) {
		this.isPJ = isPJ;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
}
