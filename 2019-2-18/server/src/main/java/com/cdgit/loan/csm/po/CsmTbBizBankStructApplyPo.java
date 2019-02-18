package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbBizBankStructApplyPo {
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
}