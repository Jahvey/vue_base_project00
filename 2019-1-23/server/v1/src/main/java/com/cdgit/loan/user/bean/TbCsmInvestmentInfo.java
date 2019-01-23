package com.cdgit.loan.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbCsmInvestmentInfo {
    private String investmentId;

    private String partyId;

    private String investimentMethodCd;

    private String currecyCd;

    private BigDecimal investmentAmt;

    private BigDecimal shareholdingRatio;

    private Date investmentDate;

    private Date createTime;

    private Date updateTime;

    private String updateUserNum;

    private String updateOrgNum;

    private String investCustId;

    private String investCustType;

    private String investCustName;

    private String registerNum;

    private String orgRegisterNum;

    private String middleNum;

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId == null ? null : investmentId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getInvestimentMethodCd() {
        return investimentMethodCd;
    }

    public void setInvestimentMethodCd(String investimentMethodCd) {
        this.investimentMethodCd = investimentMethodCd == null ? null : investimentMethodCd.trim();
    }

    public String getCurrecyCd() {
        return currecyCd;
    }

    public void setCurrecyCd(String currecyCd) {
        this.currecyCd = currecyCd == null ? null : currecyCd.trim();
    }

    public BigDecimal getInvestmentAmt() {
        return investmentAmt;
    }

    public void setInvestmentAmt(BigDecimal investmentAmt) {
        this.investmentAmt = investmentAmt;
    }

    public BigDecimal getShareholdingRatio() {
        return shareholdingRatio;
    }

    public void setShareholdingRatio(BigDecimal shareholdingRatio) {
        this.shareholdingRatio = shareholdingRatio;
    }

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
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

    public String getUpdateUserNum() {
        return updateUserNum;
    }

    public void setUpdateUserNum(String updateUserNum) {
        this.updateUserNum = updateUserNum == null ? null : updateUserNum.trim();
    }

    public String getUpdateOrgNum() {
        return updateOrgNum;
    }

    public void setUpdateOrgNum(String updateOrgNum) {
        this.updateOrgNum = updateOrgNum == null ? null : updateOrgNum.trim();
    }

    public String getInvestCustId() {
        return investCustId;
    }

    public void setInvestCustId(String investCustId) {
        this.investCustId = investCustId == null ? null : investCustId.trim();
    }

    public String getInvestCustType() {
        return investCustType;
    }

    public void setInvestCustType(String investCustType) {
        this.investCustType = investCustType == null ? null : investCustType.trim();
    }

    public String getInvestCustName() {
        return investCustName;
    }

    public void setInvestCustName(String investCustName) {
        this.investCustName = investCustName == null ? null : investCustName.trim();
    }

    public String getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(String registerNum) {
        this.registerNum = registerNum == null ? null : registerNum.trim();
    }

    public String getOrgRegisterNum() {
        return orgRegisterNum;
    }

    public void setOrgRegisterNum(String orgRegisterNum) {
        this.orgRegisterNum = orgRegisterNum == null ? null : orgRegisterNum.trim();
    }

    public String getMiddleNum() {
        return middleNum;
    }

    public void setMiddleNum(String middleNum) {
        this.middleNum = middleNum == null ? null : middleNum.trim();
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
        TbCsmInvestmentInfo other = (TbCsmInvestmentInfo) that;
        return (this.getInvestmentId() == null ? other.getInvestmentId() == null : this.getInvestmentId().equals(other.getInvestmentId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getInvestimentMethodCd() == null ? other.getInvestimentMethodCd() == null : this.getInvestimentMethodCd().equals(other.getInvestimentMethodCd()))
            && (this.getCurrecyCd() == null ? other.getCurrecyCd() == null : this.getCurrecyCd().equals(other.getCurrecyCd()))
            && (this.getInvestmentAmt() == null ? other.getInvestmentAmt() == null : this.getInvestmentAmt().equals(other.getInvestmentAmt()))
            && (this.getShareholdingRatio() == null ? other.getShareholdingRatio() == null : this.getShareholdingRatio().equals(other.getShareholdingRatio()))
            && (this.getInvestmentDate() == null ? other.getInvestmentDate() == null : this.getInvestmentDate().equals(other.getInvestmentDate()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUserNum() == null ? other.getUpdateUserNum() == null : this.getUpdateUserNum().equals(other.getUpdateUserNum()))
            && (this.getUpdateOrgNum() == null ? other.getUpdateOrgNum() == null : this.getUpdateOrgNum().equals(other.getUpdateOrgNum()))
            && (this.getInvestCustId() == null ? other.getInvestCustId() == null : this.getInvestCustId().equals(other.getInvestCustId()))
            && (this.getInvestCustType() == null ? other.getInvestCustType() == null : this.getInvestCustType().equals(other.getInvestCustType()))
            && (this.getInvestCustName() == null ? other.getInvestCustName() == null : this.getInvestCustName().equals(other.getInvestCustName()))
            && (this.getRegisterNum() == null ? other.getRegisterNum() == null : this.getRegisterNum().equals(other.getRegisterNum()))
            && (this.getOrgRegisterNum() == null ? other.getOrgRegisterNum() == null : this.getOrgRegisterNum().equals(other.getOrgRegisterNum()))
            && (this.getMiddleNum() == null ? other.getMiddleNum() == null : this.getMiddleNum().equals(other.getMiddleNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInvestmentId() == null) ? 0 : getInvestmentId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getInvestimentMethodCd() == null) ? 0 : getInvestimentMethodCd().hashCode());
        result = prime * result + ((getCurrecyCd() == null) ? 0 : getCurrecyCd().hashCode());
        result = prime * result + ((getInvestmentAmt() == null) ? 0 : getInvestmentAmt().hashCode());
        result = prime * result + ((getShareholdingRatio() == null) ? 0 : getShareholdingRatio().hashCode());
        result = prime * result + ((getInvestmentDate() == null) ? 0 : getInvestmentDate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUserNum() == null) ? 0 : getUpdateUserNum().hashCode());
        result = prime * result + ((getUpdateOrgNum() == null) ? 0 : getUpdateOrgNum().hashCode());
        result = prime * result + ((getInvestCustId() == null) ? 0 : getInvestCustId().hashCode());
        result = prime * result + ((getInvestCustType() == null) ? 0 : getInvestCustType().hashCode());
        result = prime * result + ((getInvestCustName() == null) ? 0 : getInvestCustName().hashCode());
        result = prime * result + ((getRegisterNum() == null) ? 0 : getRegisterNum().hashCode());
        result = prime * result + ((getOrgRegisterNum() == null) ? 0 : getOrgRegisterNum().hashCode());
        result = prime * result + ((getMiddleNum() == null) ? 0 : getMiddleNum().hashCode());
        return result;
    }
}