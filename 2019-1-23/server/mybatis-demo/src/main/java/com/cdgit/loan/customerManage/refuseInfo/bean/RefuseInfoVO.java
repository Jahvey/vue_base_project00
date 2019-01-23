package com.cdgit.loan.customerManage.refuseInfo.bean;

/**
 * 
 * 拒贷信息查询VO
 * 
 * */
public class RefuseInfoVO {
	
    private String approveId;
	
	private String applyDate;
	
    private String creditTerm;
	
	private String creditAmount;
	
    private String loanUse;
	
	private String validDate;
	
	private String partyId;
	
    private String partyName;
	
	private String refuse;
	
	private String remark;

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getCreditTerm() {
		return creditTerm;
	}

	public void setCreditTerm(String creditTerm) {
		this.creditTerm = creditTerm;
	}

	public String getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getRefuse() {
		return refuse;
	}

	public void setRefuse(String refuse) {
		this.refuse = refuse;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result + ((approveId == null) ? 0 : approveId.hashCode());
		result = prime * result + ((creditAmount == null) ? 0 : creditAmount.hashCode());
		result = prime * result + ((creditTerm == null) ? 0 : creditTerm.hashCode());
		result = prime * result + ((loanUse == null) ? 0 : loanUse.hashCode());
		result = prime * result + ((partyId == null) ? 0 : partyId.hashCode());
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		result = prime * result + ((refuse == null) ? 0 : refuse.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((validDate == null) ? 0 : validDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefuseInfoVO other = (RefuseInfoVO) obj;
		if (applyDate == null) {
			if (other.applyDate != null)
				return false;
		} else if (!applyDate.equals(other.applyDate))
			return false;
		if (approveId == null) {
			if (other.approveId != null)
				return false;
		} else if (!approveId.equals(other.approveId))
			return false;
		if (creditAmount == null) {
			if (other.creditAmount != null)
				return false;
		} else if (!creditAmount.equals(other.creditAmount))
			return false;
		if (creditTerm == null) {
			if (other.creditTerm != null)
				return false;
		} else if (!creditTerm.equals(other.creditTerm))
			return false;
		if (loanUse == null) {
			if (other.loanUse != null)
				return false;
		} else if (!loanUse.equals(other.loanUse))
			return false;
		if (partyId == null) {
			if (other.partyId != null)
				return false;
		} else if (!partyId.equals(other.partyId))
			return false;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
			return false;
		if (refuse == null) {
			if (other.refuse != null)
				return false;
		} else if (!refuse.equals(other.refuse))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (validDate == null) {
			if (other.validDate != null)
				return false;
		} else if (!validDate.equals(other.validDate))
			return false;
		return true;
	}
	
	
	
}