package com.cdgit.ledger.naturalperson.bean;

import java.util.Date;

public class TbClaClassTestRecord {
    private String ctRcdId;

    private Date testDate;

    private Short overdue;

    private Date updateTime;

    private Date createTime;

    private String isHighQuality;

    private String status;

    private String isRestructuredLoan;

    private String isObservationPeriod;

    private String riskTypeCd;

    private String creditTypeCd;

    private String guaranteeTypeCd;

    private String g0;

    private String g1;

    private String g2;

    private String g3;

    private String lastClass;

    private String remark;

    private String testPhone;

    private String orgName;

    private String userName;

    private String testName;

    private String userNum;

    private String partenerId;

    private String loanSummaryId;

    public String getCtRcdId() {
        return ctRcdId;
    }

    public void setCtRcdId(String ctRcdId) {
        this.ctRcdId = ctRcdId == null ? null : ctRcdId.trim();
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Short getOverdue() {
        return overdue;
    }

    public void setOverdue(Short overdue) {
        this.overdue = overdue;
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

    public String getIsHighQuality() {
        return isHighQuality;
    }

    public void setIsHighQuality(String isHighQuality) {
        this.isHighQuality = isHighQuality == null ? null : isHighQuality.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsRestructuredLoan() {
        return isRestructuredLoan;
    }

    public void setIsRestructuredLoan(String isRestructuredLoan) {
        this.isRestructuredLoan = isRestructuredLoan == null ? null : isRestructuredLoan.trim();
    }

    public String getIsObservationPeriod() {
        return isObservationPeriod;
    }

    public void setIsObservationPeriod(String isObservationPeriod) {
        this.isObservationPeriod = isObservationPeriod == null ? null : isObservationPeriod.trim();
    }

    public String getRiskTypeCd() {
        return riskTypeCd;
    }

    public void setRiskTypeCd(String riskTypeCd) {
        this.riskTypeCd = riskTypeCd == null ? null : riskTypeCd.trim();
    }

    public String getCreditTypeCd() {
        return creditTypeCd;
    }

    public void setCreditTypeCd(String creditTypeCd) {
        this.creditTypeCd = creditTypeCd == null ? null : creditTypeCd.trim();
    }

    public String getGuaranteeTypeCd() {
        return guaranteeTypeCd;
    }

    public void setGuaranteeTypeCd(String guaranteeTypeCd) {
        this.guaranteeTypeCd = guaranteeTypeCd == null ? null : guaranteeTypeCd.trim();
    }

    public String getG0() {
        return g0;
    }

    public void setG0(String g0) {
        this.g0 = g0 == null ? null : g0.trim();
    }

    public String getG1() {
        return g1;
    }

    public void setG1(String g1) {
        this.g1 = g1 == null ? null : g1.trim();
    }

    public String getG2() {
        return g2;
    }

    public void setG2(String g2) {
        this.g2 = g2 == null ? null : g2.trim();
    }

    public String getG3() {
        return g3;
    }

    public void setG3(String g3) {
        this.g3 = g3 == null ? null : g3.trim();
    }

    public String getLastClass() {
        return lastClass;
    }

    public void setLastClass(String lastClass) {
        this.lastClass = lastClass == null ? null : lastClass.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTestPhone() {
        return testPhone;
    }

    public void setTestPhone(String testPhone) {
        this.testPhone = testPhone == null ? null : testPhone.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getPartenerId() {
        return partenerId;
    }

    public void setPartenerId(String partenerId) {
        this.partenerId = partenerId == null ? null : partenerId.trim();
    }

    public String getLoanSummaryId() {
        return loanSummaryId;
    }

    public void setLoanSummaryId(String loanSummaryId) {
        this.loanSummaryId = loanSummaryId == null ? null : loanSummaryId.trim();
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
        TbClaClassTestRecord other = (TbClaClassTestRecord) that;
        return (this.getCtRcdId() == null ? other.getCtRcdId() == null : this.getCtRcdId().equals(other.getCtRcdId()))
            && (this.getTestDate() == null ? other.getTestDate() == null : this.getTestDate().equals(other.getTestDate()))
            && (this.getOverdue() == null ? other.getOverdue() == null : this.getOverdue().equals(other.getOverdue()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsHighQuality() == null ? other.getIsHighQuality() == null : this.getIsHighQuality().equals(other.getIsHighQuality()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsRestructuredLoan() == null ? other.getIsRestructuredLoan() == null : this.getIsRestructuredLoan().equals(other.getIsRestructuredLoan()))
            && (this.getIsObservationPeriod() == null ? other.getIsObservationPeriod() == null : this.getIsObservationPeriod().equals(other.getIsObservationPeriod()))
            && (this.getRiskTypeCd() == null ? other.getRiskTypeCd() == null : this.getRiskTypeCd().equals(other.getRiskTypeCd()))
            && (this.getCreditTypeCd() == null ? other.getCreditTypeCd() == null : this.getCreditTypeCd().equals(other.getCreditTypeCd()))
            && (this.getGuaranteeTypeCd() == null ? other.getGuaranteeTypeCd() == null : this.getGuaranteeTypeCd().equals(other.getGuaranteeTypeCd()))
            && (this.getG0() == null ? other.getG0() == null : this.getG0().equals(other.getG0()))
            && (this.getG1() == null ? other.getG1() == null : this.getG1().equals(other.getG1()))
            && (this.getG2() == null ? other.getG2() == null : this.getG2().equals(other.getG2()))
            && (this.getG3() == null ? other.getG3() == null : this.getG3().equals(other.getG3()))
            && (this.getLastClass() == null ? other.getLastClass() == null : this.getLastClass().equals(other.getLastClass()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getTestPhone() == null ? other.getTestPhone() == null : this.getTestPhone().equals(other.getTestPhone()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getTestName() == null ? other.getTestName() == null : this.getTestName().equals(other.getTestName()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getPartenerId() == null ? other.getPartenerId() == null : this.getPartenerId().equals(other.getPartenerId()))
            && (this.getLoanSummaryId() == null ? other.getLoanSummaryId() == null : this.getLoanSummaryId().equals(other.getLoanSummaryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCtRcdId() == null) ? 0 : getCtRcdId().hashCode());
        result = prime * result + ((getTestDate() == null) ? 0 : getTestDate().hashCode());
        result = prime * result + ((getOverdue() == null) ? 0 : getOverdue().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsHighQuality() == null) ? 0 : getIsHighQuality().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsRestructuredLoan() == null) ? 0 : getIsRestructuredLoan().hashCode());
        result = prime * result + ((getIsObservationPeriod() == null) ? 0 : getIsObservationPeriod().hashCode());
        result = prime * result + ((getRiskTypeCd() == null) ? 0 : getRiskTypeCd().hashCode());
        result = prime * result + ((getCreditTypeCd() == null) ? 0 : getCreditTypeCd().hashCode());
        result = prime * result + ((getGuaranteeTypeCd() == null) ? 0 : getGuaranteeTypeCd().hashCode());
        result = prime * result + ((getG0() == null) ? 0 : getG0().hashCode());
        result = prime * result + ((getG1() == null) ? 0 : getG1().hashCode());
        result = prime * result + ((getG2() == null) ? 0 : getG2().hashCode());
        result = prime * result + ((getG3() == null) ? 0 : getG3().hashCode());
        result = prime * result + ((getLastClass() == null) ? 0 : getLastClass().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTestPhone() == null) ? 0 : getTestPhone().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTestName() == null) ? 0 : getTestName().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getPartenerId() == null) ? 0 : getPartenerId().hashCode());
        result = prime * result + ((getLoanSummaryId() == null) ? 0 : getLoanSummaryId().hashCode());
        return result;
    }
}