package com.cdgit.loan.afterloan.afterloancheck.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ChTbLoanMoneyUse {
    private String moneyUseId;

    private Date createTime;

    private Date updateTime;

    private String summaryId;

    private String loanId;

    private String partyId;

    private Date payTime;

    private BigDecimal applyAmount;

    private String payUse;

    private String payObject;

    private String isFitDeal;

    private String payWay;

    public String getMoneyUseId() {
        return moneyUseId;
    }

    public void setMoneyUseId(String moneyUseId) {
        this.moneyUseId = moneyUseId == null ? null : moneyUseId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getPayUse() {
        return payUse;
    }

    public void setPayUse(String payUse) {
        this.payUse = payUse == null ? null : payUse.trim();
    }

    public String getPayObject() {
        return payObject;
    }

    public void setPayObject(String payObject) {
        this.payObject = payObject == null ? null : payObject.trim();
    }

    public String getIsFitDeal() {
        return isFitDeal;
    }

    public void setIsFitDeal(String isFitDeal) {
        this.isFitDeal = isFitDeal == null ? null : isFitDeal.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChTbLoanMoneyUse other = (ChTbLoanMoneyUse) that;
        return (this.getMoneyUseId() == null ? other.getMoneyUseId() == null : this.getMoneyUseId().equals(other.getMoneyUseId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSummaryId() == null ? other.getSummaryId() == null : this.getSummaryId().equals(other.getSummaryId()))
            && (this.getLoanId() == null ? other.getLoanId() == null : this.getLoanId().equals(other.getLoanId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getApplyAmount() == null ? other.getApplyAmount() == null : this.getApplyAmount().equals(other.getApplyAmount()))
            && (this.getPayUse() == null ? other.getPayUse() == null : this.getPayUse().equals(other.getPayUse()))
            && (this.getPayObject() == null ? other.getPayObject() == null : this.getPayObject().equals(other.getPayObject()))
            && (this.getIsFitDeal() == null ? other.getIsFitDeal() == null : this.getIsFitDeal().equals(other.getIsFitDeal()))
            && (this.getPayWay() == null ? other.getPayWay() == null : this.getPayWay().equals(other.getPayWay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMoneyUseId() == null) ? 0 : getMoneyUseId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSummaryId() == null) ? 0 : getSummaryId().hashCode());
        result = prime * result + ((getLoanId() == null) ? 0 : getLoanId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getApplyAmount() == null) ? 0 : getApplyAmount().hashCode());
        result = prime * result + ((getPayUse() == null) ? 0 : getPayUse().hashCode());
        result = prime * result + ((getPayObject() == null) ? 0 : getPayObject().hashCode());
        result = prime * result + ((getIsFitDeal() == null) ? 0 : getIsFitDeal().hashCode());
        result = prime * result + ((getPayWay() == null) ? 0 : getPayWay().hashCode());
        return result;
    }

	@Override
	public String toString() {
		return "ChTbLoanMoneyUse [moneyUseId=" + moneyUseId + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", summaryId=" + summaryId + ", loanId=" + loanId + ", partyId=" + partyId + ", payTime="
				+ payTime + ", applyAmount=" + applyAmount + ", payUse=" + payUse + ", payObject=" + payObject
				+ ", isFitDeal=" + isFitDeal + ", payWay=" + payWay + "]";
	}
    
    
}