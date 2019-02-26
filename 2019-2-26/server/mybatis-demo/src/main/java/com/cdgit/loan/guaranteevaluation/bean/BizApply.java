package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 		1.记录业务基本信息，充当合同签订的审批依据。
		2.记录业务申请审批记录信息，支持业务申请审批业务的流转，并留下业务审计痕迹。
 * @author wuyong
 *
 */
public class BizApply {
    private String applyId;

    private String bizNum;

    private String bizType;

    private String statusType;

    private String lowRiskBizType;

    private String bizHappenType;

    private String orgNum;

    private String userNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date updateTime;

    private String isBankTeamLoan;

    private String oldApplyId;

    private String ifDataMove;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date applyDate;

    private String applyModeType;

    private String partyId;

    private String bizHappenNature;

    private String productType;

    private String isGreenLoan;

    private String loanType;

    private String busiPartner;

    private String bizTypeFlag;

    private String whetherBzxzfdk;

    private String zdfxqyType;

    private String greenLoan;

    private String sjhjbhwfwgType;

    private String aqscwfwgType;

    private String zybyfkzbdbType;

    private String guarantyType;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal termNum;

    private String termUnit;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal rmbAmt;

    private String crdId;

    private String creditMode;

    private String csmCrdLevel;

    private String procInstId;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getBizNum() {
        return bizNum;
    }

    public void setBizNum(String bizNum) {
        this.bizNum = bizNum == null ? null : bizNum.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType == null ? null : statusType.trim();
    }

    public String getLowRiskBizType() {
        return lowRiskBizType;
    }

    public void setLowRiskBizType(String lowRiskBizType) {
        this.lowRiskBizType = lowRiskBizType == null ? null : lowRiskBizType.trim();
    }

    public String getBizHappenType() {
        return bizHappenType;
    }

    public void setBizHappenType(String bizHappenType) {
        this.bizHappenType = bizHappenType == null ? null : bizHappenType.trim();
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

    public String getIsBankTeamLoan() {
        return isBankTeamLoan;
    }

    public void setIsBankTeamLoan(String isBankTeamLoan) {
        this.isBankTeamLoan = isBankTeamLoan == null ? null : isBankTeamLoan.trim();
    }

    public String getOldApplyId() {
        return oldApplyId;
    }

    public void setOldApplyId(String oldApplyId) {
        this.oldApplyId = oldApplyId == null ? null : oldApplyId.trim();
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyModeType() {
        return applyModeType;
    }

    public void setApplyModeType(String applyModeType) {
        this.applyModeType = applyModeType == null ? null : applyModeType.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getBizHappenNature() {
        return bizHappenNature;
    }

    public void setBizHappenNature(String bizHappenNature) {
        this.bizHappenNature = bizHappenNature == null ? null : bizHappenNature.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getIsGreenLoan() {
        return isGreenLoan;
    }

    public void setIsGreenLoan(String isGreenLoan) {
        this.isGreenLoan = isGreenLoan == null ? null : isGreenLoan.trim();
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    public String getBusiPartner() {
        return busiPartner;
    }

    public void setBusiPartner(String busiPartner) {
        this.busiPartner = busiPartner == null ? null : busiPartner.trim();
    }

    public String getBizTypeFlag() {
        return bizTypeFlag;
    }

    public void setBizTypeFlag(String bizTypeFlag) {
        this.bizTypeFlag = bizTypeFlag == null ? null : bizTypeFlag.trim();
    }

    public String getWhetherBzxzfdk() {
        return whetherBzxzfdk;
    }

    public void setWhetherBzxzfdk(String whetherBzxzfdk) {
        this.whetherBzxzfdk = whetherBzxzfdk == null ? null : whetherBzxzfdk.trim();
    }

    public String getZdfxqyType() {
        return zdfxqyType;
    }

    public void setZdfxqyType(String zdfxqyType) {
        this.zdfxqyType = zdfxqyType == null ? null : zdfxqyType.trim();
    }

    public String getGreenLoan() {
        return greenLoan;
    }

    public void setGreenLoan(String greenLoan) {
        this.greenLoan = greenLoan == null ? null : greenLoan.trim();
    }

    public String getSjhjbhwfwgType() {
        return sjhjbhwfwgType;
    }

    public void setSjhjbhwfwgType(String sjhjbhwfwgType) {
        this.sjhjbhwfwgType = sjhjbhwfwgType == null ? null : sjhjbhwfwgType.trim();
    }

    public String getAqscwfwgType() {
        return aqscwfwgType;
    }

    public void setAqscwfwgType(String aqscwfwgType) {
        this.aqscwfwgType = aqscwfwgType == null ? null : aqscwfwgType.trim();
    }

    public String getZybyfkzbdbType() {
        return zybyfkzbdbType;
    }

    public void setZybyfkzbdbType(String zybyfkzbdbType) {
        this.zybyfkzbdbType = zybyfkzbdbType == null ? null : zybyfkzbdbType.trim();
    }

    public String getGuarantyType() {
        return guarantyType;
    }

    public void setGuarantyType(String guarantyType) {
        this.guarantyType = guarantyType == null ? null : guarantyType.trim();
    }

    public BigDecimal getTermNum() {
        return termNum;
    }

    public void setTermNum(BigDecimal termNum) {
        this.termNum = termNum;
    }

    public String getTermUnit() {
        return termUnit;
    }

    public void setTermUnit(String termUnit) {
        this.termUnit = termUnit == null ? null : termUnit.trim();
    }

    public BigDecimal getRmbAmt() {
        return rmbAmt;
    }

    public void setRmbAmt(BigDecimal rmbAmt) {
        this.rmbAmt = rmbAmt;
    }

    public String getCrdId() {
        return crdId;
    }

    public void setCrdId(String crdId) {
        this.crdId = crdId == null ? null : crdId.trim();
    }

    public String getCreditMode() {
        return creditMode;
    }

    public void setCreditMode(String creditMode) {
        this.creditMode = creditMode == null ? null : creditMode.trim();
    }

    public String getCsmCrdLevel() {
        return csmCrdLevel;
    }

    public void setCsmCrdLevel(String csmCrdLevel) {
        this.csmCrdLevel = csmCrdLevel == null ? null : csmCrdLevel.trim();
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId == null ? null : procInstId.trim();
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
        BizApply other = (BizApply) that;
        return (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getBizNum() == null ? other.getBizNum() == null : this.getBizNum().equals(other.getBizNum()))
            && (this.getBizType() == null ? other.getBizType() == null : this.getBizType().equals(other.getBizType()))
            && (this.getStatusType() == null ? other.getStatusType() == null : this.getStatusType().equals(other.getStatusType()))
            && (this.getLowRiskBizType() == null ? other.getLowRiskBizType() == null : this.getLowRiskBizType().equals(other.getLowRiskBizType()))
            && (this.getBizHappenType() == null ? other.getBizHappenType() == null : this.getBizHappenType().equals(other.getBizHappenType()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsBankTeamLoan() == null ? other.getIsBankTeamLoan() == null : this.getIsBankTeamLoan().equals(other.getIsBankTeamLoan()))
            && (this.getOldApplyId() == null ? other.getOldApplyId() == null : this.getOldApplyId().equals(other.getOldApplyId()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate()))
            && (this.getApplyModeType() == null ? other.getApplyModeType() == null : this.getApplyModeType().equals(other.getApplyModeType()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getBizHappenNature() == null ? other.getBizHappenNature() == null : this.getBizHappenNature().equals(other.getBizHappenNature()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getIsGreenLoan() == null ? other.getIsGreenLoan() == null : this.getIsGreenLoan().equals(other.getIsGreenLoan()))
            && (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
            && (this.getBusiPartner() == null ? other.getBusiPartner() == null : this.getBusiPartner().equals(other.getBusiPartner()))
            && (this.getBizTypeFlag() == null ? other.getBizTypeFlag() == null : this.getBizTypeFlag().equals(other.getBizTypeFlag()))
            && (this.getWhetherBzxzfdk() == null ? other.getWhetherBzxzfdk() == null : this.getWhetherBzxzfdk().equals(other.getWhetherBzxzfdk()))
            && (this.getZdfxqyType() == null ? other.getZdfxqyType() == null : this.getZdfxqyType().equals(other.getZdfxqyType()))
            && (this.getGreenLoan() == null ? other.getGreenLoan() == null : this.getGreenLoan().equals(other.getGreenLoan()))
            && (this.getSjhjbhwfwgType() == null ? other.getSjhjbhwfwgType() == null : this.getSjhjbhwfwgType().equals(other.getSjhjbhwfwgType()))
            && (this.getAqscwfwgType() == null ? other.getAqscwfwgType() == null : this.getAqscwfwgType().equals(other.getAqscwfwgType()))
            && (this.getZybyfkzbdbType() == null ? other.getZybyfkzbdbType() == null : this.getZybyfkzbdbType().equals(other.getZybyfkzbdbType()))
            && (this.getGuarantyType() == null ? other.getGuarantyType() == null : this.getGuarantyType().equals(other.getGuarantyType()))
            && (this.getTermNum() == null ? other.getTermNum() == null : this.getTermNum().equals(other.getTermNum()))
            && (this.getTermUnit() == null ? other.getTermUnit() == null : this.getTermUnit().equals(other.getTermUnit()))
            && (this.getRmbAmt() == null ? other.getRmbAmt() == null : this.getRmbAmt().equals(other.getRmbAmt()))
            && (this.getCrdId() == null ? other.getCrdId() == null : this.getCrdId().equals(other.getCrdId()))
            && (this.getCreditMode() == null ? other.getCreditMode() == null : this.getCreditMode().equals(other.getCreditMode()))
            && (this.getCsmCrdLevel() == null ? other.getCsmCrdLevel() == null : this.getCsmCrdLevel().equals(other.getCsmCrdLevel()))
            && (this.getProcInstId() == null ? other.getProcInstId() == null : this.getProcInstId().equals(other.getProcInstId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getBizNum() == null) ? 0 : getBizNum().hashCode());
        result = prime * result + ((getBizType() == null) ? 0 : getBizType().hashCode());
        result = prime * result + ((getStatusType() == null) ? 0 : getStatusType().hashCode());
        result = prime * result + ((getLowRiskBizType() == null) ? 0 : getLowRiskBizType().hashCode());
        result = prime * result + ((getBizHappenType() == null) ? 0 : getBizHappenType().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsBankTeamLoan() == null) ? 0 : getIsBankTeamLoan().hashCode());
        result = prime * result + ((getOldApplyId() == null) ? 0 : getOldApplyId().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getApplyModeType() == null) ? 0 : getApplyModeType().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getBizHappenNature() == null) ? 0 : getBizHappenNature().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getIsGreenLoan() == null) ? 0 : getIsGreenLoan().hashCode());
        result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
        result = prime * result + ((getBusiPartner() == null) ? 0 : getBusiPartner().hashCode());
        result = prime * result + ((getBizTypeFlag() == null) ? 0 : getBizTypeFlag().hashCode());
        result = prime * result + ((getWhetherBzxzfdk() == null) ? 0 : getWhetherBzxzfdk().hashCode());
        result = prime * result + ((getZdfxqyType() == null) ? 0 : getZdfxqyType().hashCode());
        result = prime * result + ((getGreenLoan() == null) ? 0 : getGreenLoan().hashCode());
        result = prime * result + ((getSjhjbhwfwgType() == null) ? 0 : getSjhjbhwfwgType().hashCode());
        result = prime * result + ((getAqscwfwgType() == null) ? 0 : getAqscwfwgType().hashCode());
        result = prime * result + ((getZybyfkzbdbType() == null) ? 0 : getZybyfkzbdbType().hashCode());
        result = prime * result + ((getGuarantyType() == null) ? 0 : getGuarantyType().hashCode());
        result = prime * result + ((getTermNum() == null) ? 0 : getTermNum().hashCode());
        result = prime * result + ((getTermUnit() == null) ? 0 : getTermUnit().hashCode());
        result = prime * result + ((getRmbAmt() == null) ? 0 : getRmbAmt().hashCode());
        result = prime * result + ((getCrdId() == null) ? 0 : getCrdId().hashCode());
        result = prime * result + ((getCreditMode() == null) ? 0 : getCreditMode().hashCode());
        result = prime * result + ((getCsmCrdLevel() == null) ? 0 : getCsmCrdLevel().hashCode());
        result = prime * result + ((getProcInstId() == null) ? 0 : getProcInstId().hashCode());
        return result;
    }
}