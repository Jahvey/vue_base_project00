package com.cdgit.loan.business.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizBankStructApply {
    private String syndicatedStructId;

    private String myselfRoleCd;

    private String syndicatedObjectCd;

    private String syndicatedWayCd;

    private BigDecimal syndicatedLoanAmt;

    private String currencyCd;

    private String syndicatedProjectName;

    private String projectAddress;

    private Date createTime;

    private Date updateTime;

    private String customerGroupName;

    private String groupCustomer;

    private String applyId;

    public String getSyndicatedStructId() {
        return syndicatedStructId;
    }

    public void setSyndicatedStructId(String syndicatedStructId) {
        this.syndicatedStructId = syndicatedStructId == null ? null : syndicatedStructId.trim();
    }

    public String getMyselfRoleCd() {
        return myselfRoleCd;
    }

    public void setMyselfRoleCd(String myselfRoleCd) {
        this.myselfRoleCd = myselfRoleCd == null ? null : myselfRoleCd.trim();
    }

    public String getSyndicatedObjectCd() {
        return syndicatedObjectCd;
    }

    public void setSyndicatedObjectCd(String syndicatedObjectCd) {
        this.syndicatedObjectCd = syndicatedObjectCd == null ? null : syndicatedObjectCd.trim();
    }

    public String getSyndicatedWayCd() {
        return syndicatedWayCd;
    }

    public void setSyndicatedWayCd(String syndicatedWayCd) {
        this.syndicatedWayCd = syndicatedWayCd == null ? null : syndicatedWayCd.trim();
    }

    public BigDecimal getSyndicatedLoanAmt() {
        return syndicatedLoanAmt;
    }

    public void setSyndicatedLoanAmt(BigDecimal syndicatedLoanAmt) {
        this.syndicatedLoanAmt = syndicatedLoanAmt;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public String getSyndicatedProjectName() {
        return syndicatedProjectName;
    }

    public void setSyndicatedProjectName(String syndicatedProjectName) {
        this.syndicatedProjectName = syndicatedProjectName == null ? null : syndicatedProjectName.trim();
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
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

    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public void setCustomerGroupName(String customerGroupName) {
        this.customerGroupName = customerGroupName == null ? null : customerGroupName.trim();
    }

    public String getGroupCustomer() {
        return groupCustomer;
    }

    public void setGroupCustomer(String groupCustomer) {
        this.groupCustomer = groupCustomer == null ? null : groupCustomer.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
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
        TbBizBankStructApply other = (TbBizBankStructApply) that;
        return (this.getSyndicatedStructId() == null ? other.getSyndicatedStructId() == null : this.getSyndicatedStructId().equals(other.getSyndicatedStructId()))
            && (this.getMyselfRoleCd() == null ? other.getMyselfRoleCd() == null : this.getMyselfRoleCd().equals(other.getMyselfRoleCd()))
            && (this.getSyndicatedObjectCd() == null ? other.getSyndicatedObjectCd() == null : this.getSyndicatedObjectCd().equals(other.getSyndicatedObjectCd()))
            && (this.getSyndicatedWayCd() == null ? other.getSyndicatedWayCd() == null : this.getSyndicatedWayCd().equals(other.getSyndicatedWayCd()))
            && (this.getSyndicatedLoanAmt() == null ? other.getSyndicatedLoanAmt() == null : this.getSyndicatedLoanAmt().equals(other.getSyndicatedLoanAmt()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getSyndicatedProjectName() == null ? other.getSyndicatedProjectName() == null : this.getSyndicatedProjectName().equals(other.getSyndicatedProjectName()))
            && (this.getProjectAddress() == null ? other.getProjectAddress() == null : this.getProjectAddress().equals(other.getProjectAddress()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCustomerGroupName() == null ? other.getCustomerGroupName() == null : this.getCustomerGroupName().equals(other.getCustomerGroupName()))
            && (this.getGroupCustomer() == null ? other.getGroupCustomer() == null : this.getGroupCustomer().equals(other.getGroupCustomer()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSyndicatedStructId() == null) ? 0 : getSyndicatedStructId().hashCode());
        result = prime * result + ((getMyselfRoleCd() == null) ? 0 : getMyselfRoleCd().hashCode());
        result = prime * result + ((getSyndicatedObjectCd() == null) ? 0 : getSyndicatedObjectCd().hashCode());
        result = prime * result + ((getSyndicatedWayCd() == null) ? 0 : getSyndicatedWayCd().hashCode());
        result = prime * result + ((getSyndicatedLoanAmt() == null) ? 0 : getSyndicatedLoanAmt().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getSyndicatedProjectName() == null) ? 0 : getSyndicatedProjectName().hashCode());
        result = prime * result + ((getProjectAddress() == null) ? 0 : getProjectAddress().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCustomerGroupName() == null) ? 0 : getCustomerGroupName().hashCode());
        result = prime * result + ((getGroupCustomer() == null) ? 0 : getGroupCustomer().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        return result;
    }
}