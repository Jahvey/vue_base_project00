package com.cdgit.loan.ledger.asset.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ChTbGrtGuaranteeBasic {
    private String suretyId;

    private String partyId;

    private String guaranteeType;

    private BigDecimal suretyAmt;

    private String currencyCd;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String isGuaranteeCompany;

    private String ifTopAmt;

    private String ifDataMove;

    private String guaranteeForm;

    private String guaranteeWay;

    private BigDecimal usableGuaranteeLimit;

    private String partyNo;

    private String accnoWay;

    public String getSuretyId() {
        return suretyId;
    }

    public void setSuretyId(String suretyId) {
        this.suretyId = suretyId == null ? null : suretyId.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType == null ? null : guaranteeType.trim();
    }

    public BigDecimal getSuretyAmt() {
        return suretyAmt;
    }

    public void setSuretyAmt(BigDecimal suretyAmt) {
        this.suretyAmt = suretyAmt;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
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

    public String getIsGuaranteeCompany() {
        return isGuaranteeCompany;
    }

    public void setIsGuaranteeCompany(String isGuaranteeCompany) {
        this.isGuaranteeCompany = isGuaranteeCompany == null ? null : isGuaranteeCompany.trim();
    }

    public String getIfTopAmt() {
        return ifTopAmt;
    }

    public void setIfTopAmt(String ifTopAmt) {
        this.ifTopAmt = ifTopAmt == null ? null : ifTopAmt.trim();
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getGuaranteeForm() {
        return guaranteeForm;
    }

    public void setGuaranteeForm(String guaranteeForm) {
        this.guaranteeForm = guaranteeForm == null ? null : guaranteeForm.trim();
    }

    public String getGuaranteeWay() {
        return guaranteeWay;
    }

    public void setGuaranteeWay(String guaranteeWay) {
        this.guaranteeWay = guaranteeWay == null ? null : guaranteeWay.trim();
    }

    public BigDecimal getUsableGuaranteeLimit() {
        return usableGuaranteeLimit;
    }

    public void setUsableGuaranteeLimit(BigDecimal usableGuaranteeLimit) {
        this.usableGuaranteeLimit = usableGuaranteeLimit;
    }

    public String getPartyNo() {
        return partyNo;
    }

    public void setPartyNo(String partyNo) {
        this.partyNo = partyNo == null ? null : partyNo.trim();
    }

    public String getAccnoWay() {
        return accnoWay;
    }

    public void setAccnoWay(String accnoWay) {
        this.accnoWay = accnoWay == null ? null : accnoWay.trim();
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
        ChTbGrtGuaranteeBasic other = (ChTbGrtGuaranteeBasic) that;
        return (this.getSuretyId() == null ? other.getSuretyId() == null : this.getSuretyId().equals(other.getSuretyId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getGuaranteeType() == null ? other.getGuaranteeType() == null : this.getGuaranteeType().equals(other.getGuaranteeType()))
            && (this.getSuretyAmt() == null ? other.getSuretyAmt() == null : this.getSuretyAmt().equals(other.getSuretyAmt()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsGuaranteeCompany() == null ? other.getIsGuaranteeCompany() == null : this.getIsGuaranteeCompany().equals(other.getIsGuaranteeCompany()))
            && (this.getIfTopAmt() == null ? other.getIfTopAmt() == null : this.getIfTopAmt().equals(other.getIfTopAmt()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getGuaranteeForm() == null ? other.getGuaranteeForm() == null : this.getGuaranteeForm().equals(other.getGuaranteeForm()))
            && (this.getGuaranteeWay() == null ? other.getGuaranteeWay() == null : this.getGuaranteeWay().equals(other.getGuaranteeWay()))
            && (this.getUsableGuaranteeLimit() == null ? other.getUsableGuaranteeLimit() == null : this.getUsableGuaranteeLimit().equals(other.getUsableGuaranteeLimit()))
            && (this.getPartyNo() == null ? other.getPartyNo() == null : this.getPartyNo().equals(other.getPartyNo()))
            && (this.getAccnoWay() == null ? other.getAccnoWay() == null : this.getAccnoWay().equals(other.getAccnoWay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuretyId() == null) ? 0 : getSuretyId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getGuaranteeType() == null) ? 0 : getGuaranteeType().hashCode());
        result = prime * result + ((getSuretyAmt() == null) ? 0 : getSuretyAmt().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsGuaranteeCompany() == null) ? 0 : getIsGuaranteeCompany().hashCode());
        result = prime * result + ((getIfTopAmt() == null) ? 0 : getIfTopAmt().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getGuaranteeForm() == null) ? 0 : getGuaranteeForm().hashCode());
        result = prime * result + ((getGuaranteeWay() == null) ? 0 : getGuaranteeWay().hashCode());
        result = prime * result + ((getUsableGuaranteeLimit() == null) ? 0 : getUsableGuaranteeLimit().hashCode());
        result = prime * result + ((getPartyNo() == null) ? 0 : getPartyNo().hashCode());
        result = prime * result + ((getAccnoWay() == null) ? 0 : getAccnoWay().hashCode());
        return result;
    }
}