package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbBizFamilyFinace {
    private String financeId;

    private String partyId;

    private String applyId;

    private Date financeDate;

    private BigDecimal personMonthlyIncome;

    private BigDecimal familySteadyIncome;

    private BigDecimal familyRentIncome;

    private BigDecimal familyInvestmentShare;

    private BigDecimal familyOtherIncome;

    private BigDecimal financialAssets;

    private BigDecimal fixedAssets;

    private BigDecimal otherAsset;

    private BigDecimal incurDebts;

    private BigDecimal monthDebtPay;

    private String remark;

    private String orgNum;

    private String userNum;

    private Date dealDate;

    private Date createTime;

    private Date updateTime;

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public Date getFinanceDate() {
        return financeDate;
    }

    public void setFinanceDate(Date financeDate) {
        this.financeDate = financeDate;
    }

    public BigDecimal getPersonMonthlyIncome() {
        return personMonthlyIncome;
    }

    public void setPersonMonthlyIncome(BigDecimal personMonthlyIncome) {
        this.personMonthlyIncome = personMonthlyIncome;
    }

    public BigDecimal getFamilySteadyIncome() {
        return familySteadyIncome;
    }

    public void setFamilySteadyIncome(BigDecimal familySteadyIncome) {
        this.familySteadyIncome = familySteadyIncome;
    }

    public BigDecimal getFamilyRentIncome() {
        return familyRentIncome;
    }

    public void setFamilyRentIncome(BigDecimal familyRentIncome) {
        this.familyRentIncome = familyRentIncome;
    }

    public BigDecimal getFamilyInvestmentShare() {
        return familyInvestmentShare;
    }

    public void setFamilyInvestmentShare(BigDecimal familyInvestmentShare) {
        this.familyInvestmentShare = familyInvestmentShare;
    }

    public BigDecimal getFamilyOtherIncome() {
        return familyOtherIncome;
    }

    public void setFamilyOtherIncome(BigDecimal familyOtherIncome) {
        this.familyOtherIncome = familyOtherIncome;
    }

    public BigDecimal getFinancialAssets() {
        return financialAssets;
    }

    public void setFinancialAssets(BigDecimal financialAssets) {
        this.financialAssets = financialAssets;
    }

    public BigDecimal getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(BigDecimal fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public BigDecimal getOtherAsset() {
        return otherAsset;
    }

    public void setOtherAsset(BigDecimal otherAsset) {
        this.otherAsset = otherAsset;
    }

    public BigDecimal getIncurDebts() {
        return incurDebts;
    }

    public void setIncurDebts(BigDecimal incurDebts) {
        this.incurDebts = incurDebts;
    }

    public BigDecimal getMonthDebtPay() {
        return monthDebtPay;
    }

    public void setMonthDebtPay(BigDecimal monthDebtPay) {
        this.monthDebtPay = monthDebtPay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
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
        CsmTbBizFamilyFinace other = (CsmTbBizFamilyFinace) that;
        return (this.getFinanceId() == null ? other.getFinanceId() == null : this.getFinanceId().equals(other.getFinanceId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getFinanceDate() == null ? other.getFinanceDate() == null : this.getFinanceDate().equals(other.getFinanceDate()))
            && (this.getPersonMonthlyIncome() == null ? other.getPersonMonthlyIncome() == null : this.getPersonMonthlyIncome().equals(other.getPersonMonthlyIncome()))
            && (this.getFamilySteadyIncome() == null ? other.getFamilySteadyIncome() == null : this.getFamilySteadyIncome().equals(other.getFamilySteadyIncome()))
            && (this.getFamilyRentIncome() == null ? other.getFamilyRentIncome() == null : this.getFamilyRentIncome().equals(other.getFamilyRentIncome()))
            && (this.getFamilyInvestmentShare() == null ? other.getFamilyInvestmentShare() == null : this.getFamilyInvestmentShare().equals(other.getFamilyInvestmentShare()))
            && (this.getFamilyOtherIncome() == null ? other.getFamilyOtherIncome() == null : this.getFamilyOtherIncome().equals(other.getFamilyOtherIncome()))
            && (this.getFinancialAssets() == null ? other.getFinancialAssets() == null : this.getFinancialAssets().equals(other.getFinancialAssets()))
            && (this.getFixedAssets() == null ? other.getFixedAssets() == null : this.getFixedAssets().equals(other.getFixedAssets()))
            && (this.getOtherAsset() == null ? other.getOtherAsset() == null : this.getOtherAsset().equals(other.getOtherAsset()))
            && (this.getIncurDebts() == null ? other.getIncurDebts() == null : this.getIncurDebts().equals(other.getIncurDebts()))
            && (this.getMonthDebtPay() == null ? other.getMonthDebtPay() == null : this.getMonthDebtPay().equals(other.getMonthDebtPay()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getDealDate() == null ? other.getDealDate() == null : this.getDealDate().equals(other.getDealDate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFinanceId() == null) ? 0 : getFinanceId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getFinanceDate() == null) ? 0 : getFinanceDate().hashCode());
        result = prime * result + ((getPersonMonthlyIncome() == null) ? 0 : getPersonMonthlyIncome().hashCode());
        result = prime * result + ((getFamilySteadyIncome() == null) ? 0 : getFamilySteadyIncome().hashCode());
        result = prime * result + ((getFamilyRentIncome() == null) ? 0 : getFamilyRentIncome().hashCode());
        result = prime * result + ((getFamilyInvestmentShare() == null) ? 0 : getFamilyInvestmentShare().hashCode());
        result = prime * result + ((getFamilyOtherIncome() == null) ? 0 : getFamilyOtherIncome().hashCode());
        result = prime * result + ((getFinancialAssets() == null) ? 0 : getFinancialAssets().hashCode());
        result = prime * result + ((getFixedAssets() == null) ? 0 : getFixedAssets().hashCode());
        result = prime * result + ((getOtherAsset() == null) ? 0 : getOtherAsset().hashCode());
        result = prime * result + ((getIncurDebts() == null) ? 0 : getIncurDebts().hashCode());
        result = prime * result + ((getMonthDebtPay() == null) ? 0 : getMonthDebtPay().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getDealDate() == null) ? 0 : getDealDate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}