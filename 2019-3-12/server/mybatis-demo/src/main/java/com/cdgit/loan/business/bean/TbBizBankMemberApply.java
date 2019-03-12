package com.cdgit.loan.business.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizBankMemberApply {
    private String syndicatedMemberId;

    private String ifMyselfBank;

    private String memberBankName;

    private String memberRoleCd;

    private BigDecimal promiseAmount;

    private String currencyCd;

    private BigDecimal promiseShare;

    private String membersBankNum;

    private String membersUserNum;

    private Date createTime;

    private Date updateTime;

    private String syndicatedStructId;

    private BigDecimal promiseRatio;

    private String syndicatedObjectCd;

    public String getSyndicatedMemberId() {
        return syndicatedMemberId;
    }

    public void setSyndicatedMemberId(String syndicatedMemberId) {
        this.syndicatedMemberId = syndicatedMemberId == null ? null : syndicatedMemberId.trim();
    }

    public String getIfMyselfBank() {
        return ifMyselfBank;
    }

    public void setIfMyselfBank(String ifMyselfBank) {
        this.ifMyselfBank = ifMyselfBank == null ? null : ifMyselfBank.trim();
    }

    public String getMemberBankName() {
        return memberBankName;
    }

    public void setMemberBankName(String memberBankName) {
        this.memberBankName = memberBankName == null ? null : memberBankName.trim();
    }

    public String getMemberRoleCd() {
        return memberRoleCd;
    }

    public void setMemberRoleCd(String memberRoleCd) {
        this.memberRoleCd = memberRoleCd == null ? null : memberRoleCd.trim();
    }

    public BigDecimal getPromiseAmount() {
        return promiseAmount;
    }

    public void setPromiseAmount(BigDecimal promiseAmount) {
        this.promiseAmount = promiseAmount;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getPromiseShare() {
        return promiseShare;
    }

    public void setPromiseShare(BigDecimal promiseShare) {
        this.promiseShare = promiseShare;
    }

    public String getMembersBankNum() {
        return membersBankNum;
    }

    public void setMembersBankNum(String membersBankNum) {
        this.membersBankNum = membersBankNum == null ? null : membersBankNum.trim();
    }

    public String getMembersUserNum() {
        return membersUserNum;
    }

    public void setMembersUserNum(String membersUserNum) {
        this.membersUserNum = membersUserNum == null ? null : membersUserNum.trim();
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

    public String getSyndicatedStructId() {
        return syndicatedStructId;
    }

    public void setSyndicatedStructId(String syndicatedStructId) {
        this.syndicatedStructId = syndicatedStructId == null ? null : syndicatedStructId.trim();
    }

    public BigDecimal getPromiseRatio() {
        return promiseRatio;
    }

    public void setPromiseRatio(BigDecimal promiseRatio) {
        this.promiseRatio = promiseRatio;
    }

    public String getSyndicatedObjectCd() {
        return syndicatedObjectCd;
    }

    public void setSyndicatedObjectCd(String syndicatedObjectCd) {
        this.syndicatedObjectCd = syndicatedObjectCd == null ? null : syndicatedObjectCd.trim();
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
        TbBizBankMemberApply other = (TbBizBankMemberApply) that;
        return (this.getSyndicatedMemberId() == null ? other.getSyndicatedMemberId() == null : this.getSyndicatedMemberId().equals(other.getSyndicatedMemberId()))
            && (this.getIfMyselfBank() == null ? other.getIfMyselfBank() == null : this.getIfMyselfBank().equals(other.getIfMyselfBank()))
            && (this.getMemberBankName() == null ? other.getMemberBankName() == null : this.getMemberBankName().equals(other.getMemberBankName()))
            && (this.getMemberRoleCd() == null ? other.getMemberRoleCd() == null : this.getMemberRoleCd().equals(other.getMemberRoleCd()))
            && (this.getPromiseAmount() == null ? other.getPromiseAmount() == null : this.getPromiseAmount().equals(other.getPromiseAmount()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getPromiseShare() == null ? other.getPromiseShare() == null : this.getPromiseShare().equals(other.getPromiseShare()))
            && (this.getMembersBankNum() == null ? other.getMembersBankNum() == null : this.getMembersBankNum().equals(other.getMembersBankNum()))
            && (this.getMembersUserNum() == null ? other.getMembersUserNum() == null : this.getMembersUserNum().equals(other.getMembersUserNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSyndicatedStructId() == null ? other.getSyndicatedStructId() == null : this.getSyndicatedStructId().equals(other.getSyndicatedStructId()))
            && (this.getPromiseRatio() == null ? other.getPromiseRatio() == null : this.getPromiseRatio().equals(other.getPromiseRatio()))
            && (this.getSyndicatedObjectCd() == null ? other.getSyndicatedObjectCd() == null : this.getSyndicatedObjectCd().equals(other.getSyndicatedObjectCd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSyndicatedMemberId() == null) ? 0 : getSyndicatedMemberId().hashCode());
        result = prime * result + ((getIfMyselfBank() == null) ? 0 : getIfMyselfBank().hashCode());
        result = prime * result + ((getMemberBankName() == null) ? 0 : getMemberBankName().hashCode());
        result = prime * result + ((getMemberRoleCd() == null) ? 0 : getMemberRoleCd().hashCode());
        result = prime * result + ((getPromiseAmount() == null) ? 0 : getPromiseAmount().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getPromiseShare() == null) ? 0 : getPromiseShare().hashCode());
        result = prime * result + ((getMembersBankNum() == null) ? 0 : getMembersBankNum().hashCode());
        result = prime * result + ((getMembersUserNum() == null) ? 0 : getMembersUserNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSyndicatedStructId() == null) ? 0 : getSyndicatedStructId().hashCode());
        result = prime * result + ((getPromiseRatio() == null) ? 0 : getPromiseRatio().hashCode());
        result = prime * result + ((getSyndicatedObjectCd() == null) ? 0 : getSyndicatedObjectCd().hashCode());
        return result;
    }
}