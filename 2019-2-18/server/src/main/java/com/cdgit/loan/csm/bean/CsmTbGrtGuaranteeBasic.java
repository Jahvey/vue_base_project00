package com.cdgit.loan.csm.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CsmTbGrtGuaranteeBasic {
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
}