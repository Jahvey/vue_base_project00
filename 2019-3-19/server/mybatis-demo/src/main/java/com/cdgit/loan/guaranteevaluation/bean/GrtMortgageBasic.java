package com.cdgit.loan.guaranteevaluation.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 押品基本信息表
 * @author wuyong
 *
 */
public class GrtMortgageBasic {
    private String suretyId;

    private String suretyNo;

    private String partyId;

    private String sortType;

    private String collType;

    private String assessForm;

    private Date assessDate;

    private Date assessEndDate;

    private String currencyCd;

    private BigDecimal assessValue;

    private BigDecimal mortgageValue;

    private BigDecimal mybankSetValue;

    private String ifOtherCommon;

    private String mortgageStatus;

    private String mortgageGainWay;

    private String cashAbility;

    private String mortgageMobility;

    private String orgNum;

    private String userNum;

    private Date createTime;

    private Date updateTime;

    private BigDecimal mybankAffirmValue;

    private BigDecimal suretyAmt;

    private BigDecimal mortgageRate;

    private BigDecimal totalAmt;

    private BigDecimal aviAmt;

    private String ifDataMove;

    private String ownershipNum;

    private String insuranceCondition;

    private String insuranceCompany;

    private String insuranceNum;

    private String suretyName;

    private String transFlag;

    private BigDecimal mortgagaAmt;

    private String isDoneZykh;

    private BigDecimal totalKhAmt;

    public String getSuretyId() {
        return suretyId;
    }

    public void setSuretyId(String suretyId) {
        this.suretyId = suretyId == null ? null : suretyId.trim();
    }

    public String getSuretyNo() {
        return suretyNo;
    }

    public void setSuretyNo(String suretyNo) {
        this.suretyNo = suretyNo == null ? null : suretyNo.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType == null ? null : sortType.trim();
    }

    public String getCollType() {
        return collType;
    }

    public void setCollType(String collType) {
        this.collType = collType == null ? null : collType.trim();
    }

    public String getAssessForm() {
        return assessForm;
    }

    public void setAssessForm(String assessForm) {
        this.assessForm = assessForm == null ? null : assessForm.trim();
    }

    public Date getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(Date assessDate) {
        this.assessDate = assessDate;
    }

    public Date getAssessEndDate() {
        return assessEndDate;
    }

    public void setAssessEndDate(Date assessEndDate) {
        this.assessEndDate = assessEndDate;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getAssessValue() {
        return assessValue;
    }

    public void setAssessValue(BigDecimal assessValue) {
        this.assessValue = assessValue;
    }

    public BigDecimal getMortgageValue() {
        return mortgageValue;
    }

    public void setMortgageValue(BigDecimal mortgageValue) {
        this.mortgageValue = mortgageValue;
    }

    public BigDecimal getMybankSetValue() {
        return mybankSetValue;
    }

    public void setMybankSetValue(BigDecimal mybankSetValue) {
        this.mybankSetValue = mybankSetValue;
    }

    public String getIfOtherCommon() {
        return ifOtherCommon;
    }

    public void setIfOtherCommon(String ifOtherCommon) {
        this.ifOtherCommon = ifOtherCommon == null ? null : ifOtherCommon.trim();
    }

    public String getMortgageStatus() {
        return mortgageStatus;
    }

    public void setMortgageStatus(String mortgageStatus) {
        this.mortgageStatus = mortgageStatus == null ? null : mortgageStatus.trim();
    }

    public String getMortgageGainWay() {
        return mortgageGainWay;
    }

    public void setMortgageGainWay(String mortgageGainWay) {
        this.mortgageGainWay = mortgageGainWay == null ? null : mortgageGainWay.trim();
    }

    public String getCashAbility() {
        return cashAbility;
    }

    public void setCashAbility(String cashAbility) {
        this.cashAbility = cashAbility == null ? null : cashAbility.trim();
    }

    public String getMortgageMobility() {
        return mortgageMobility;
    }

    public void setMortgageMobility(String mortgageMobility) {
        this.mortgageMobility = mortgageMobility == null ? null : mortgageMobility.trim();
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

    public BigDecimal getMybankAffirmValue() {
        return mybankAffirmValue;
    }

    public void setMybankAffirmValue(BigDecimal mybankAffirmValue) {
        this.mybankAffirmValue = mybankAffirmValue;
    }

    public BigDecimal getSuretyAmt() {
        return suretyAmt;
    }

    public void setSuretyAmt(BigDecimal suretyAmt) {
        this.suretyAmt = suretyAmt;
    }

    public BigDecimal getMortgageRate() {
        return mortgageRate;
    }

    public void setMortgageRate(BigDecimal mortgageRate) {
        this.mortgageRate = mortgageRate;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public BigDecimal getAviAmt() {
        return aviAmt;
    }

    public void setAviAmt(BigDecimal aviAmt) {
        this.aviAmt = aviAmt;
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getOwnershipNum() {
        return ownershipNum;
    }

    public void setOwnershipNum(String ownershipNum) {
        this.ownershipNum = ownershipNum == null ? null : ownershipNum.trim();
    }

    public String getInsuranceCondition() {
        return insuranceCondition;
    }

    public void setInsuranceCondition(String insuranceCondition) {
        this.insuranceCondition = insuranceCondition == null ? null : insuranceCondition.trim();
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany == null ? null : insuranceCompany.trim();
    }

    public String getInsuranceNum() {
        return insuranceNum;
    }

    public void setInsuranceNum(String insuranceNum) {
        this.insuranceNum = insuranceNum == null ? null : insuranceNum.trim();
    }

    public String getSuretyName() {
        return suretyName;
    }

    public void setSuretyName(String suretyName) {
        this.suretyName = suretyName == null ? null : suretyName.trim();
    }

    public String getTransFlag() {
        return transFlag;
    }

    public void setTransFlag(String transFlag) {
        this.transFlag = transFlag == null ? null : transFlag.trim();
    }

    public BigDecimal getMortgagaAmt() {
        return mortgagaAmt;
    }

    public void setMortgagaAmt(BigDecimal mortgagaAmt) {
        this.mortgagaAmt = mortgagaAmt;
    }

    public String getIsDoneZykh() {
        return isDoneZykh;
    }

    public void setIsDoneZykh(String isDoneZykh) {
        this.isDoneZykh = isDoneZykh == null ? null : isDoneZykh.trim();
    }

    public BigDecimal getTotalKhAmt() {
        return totalKhAmt;
    }

    public void setTotalKhAmt(BigDecimal totalKhAmt) {
        this.totalKhAmt = totalKhAmt;
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
        GrtMortgageBasic other = (GrtMortgageBasic) that;
        return (this.getSuretyId() == null ? other.getSuretyId() == null : this.getSuretyId().equals(other.getSuretyId()))
            && (this.getSuretyNo() == null ? other.getSuretyNo() == null : this.getSuretyNo().equals(other.getSuretyNo()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getSortType() == null ? other.getSortType() == null : this.getSortType().equals(other.getSortType()))
            && (this.getCollType() == null ? other.getCollType() == null : this.getCollType().equals(other.getCollType()))
            && (this.getAssessForm() == null ? other.getAssessForm() == null : this.getAssessForm().equals(other.getAssessForm()))
            && (this.getAssessDate() == null ? other.getAssessDate() == null : this.getAssessDate().equals(other.getAssessDate()))
            && (this.getAssessEndDate() == null ? other.getAssessEndDate() == null : this.getAssessEndDate().equals(other.getAssessEndDate()))
            && (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
            && (this.getAssessValue() == null ? other.getAssessValue() == null : this.getAssessValue().equals(other.getAssessValue()))
            && (this.getMortgageValue() == null ? other.getMortgageValue() == null : this.getMortgageValue().equals(other.getMortgageValue()))
            && (this.getMybankSetValue() == null ? other.getMybankSetValue() == null : this.getMybankSetValue().equals(other.getMybankSetValue()))
            && (this.getIfOtherCommon() == null ? other.getIfOtherCommon() == null : this.getIfOtherCommon().equals(other.getIfOtherCommon()))
            && (this.getMortgageStatus() == null ? other.getMortgageStatus() == null : this.getMortgageStatus().equals(other.getMortgageStatus()))
            && (this.getMortgageGainWay() == null ? other.getMortgageGainWay() == null : this.getMortgageGainWay().equals(other.getMortgageGainWay()))
            && (this.getCashAbility() == null ? other.getCashAbility() == null : this.getCashAbility().equals(other.getCashAbility()))
            && (this.getMortgageMobility() == null ? other.getMortgageMobility() == null : this.getMortgageMobility().equals(other.getMortgageMobility()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getMybankAffirmValue() == null ? other.getMybankAffirmValue() == null : this.getMybankAffirmValue().equals(other.getMybankAffirmValue()))
            && (this.getSuretyAmt() == null ? other.getSuretyAmt() == null : this.getSuretyAmt().equals(other.getSuretyAmt()))
            && (this.getMortgageRate() == null ? other.getMortgageRate() == null : this.getMortgageRate().equals(other.getMortgageRate()))
            && (this.getTotalAmt() == null ? other.getTotalAmt() == null : this.getTotalAmt().equals(other.getTotalAmt()))
            && (this.getAviAmt() == null ? other.getAviAmt() == null : this.getAviAmt().equals(other.getAviAmt()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getOwnershipNum() == null ? other.getOwnershipNum() == null : this.getOwnershipNum().equals(other.getOwnershipNum()))
            && (this.getInsuranceCondition() == null ? other.getInsuranceCondition() == null : this.getInsuranceCondition().equals(other.getInsuranceCondition()))
            && (this.getInsuranceCompany() == null ? other.getInsuranceCompany() == null : this.getInsuranceCompany().equals(other.getInsuranceCompany()))
            && (this.getInsuranceNum() == null ? other.getInsuranceNum() == null : this.getInsuranceNum().equals(other.getInsuranceNum()))
            && (this.getSuretyName() == null ? other.getSuretyName() == null : this.getSuretyName().equals(other.getSuretyName()))
            && (this.getTransFlag() == null ? other.getTransFlag() == null : this.getTransFlag().equals(other.getTransFlag()))
            && (this.getMortgagaAmt() == null ? other.getMortgagaAmt() == null : this.getMortgagaAmt().equals(other.getMortgagaAmt()))
            && (this.getIsDoneZykh() == null ? other.getIsDoneZykh() == null : this.getIsDoneZykh().equals(other.getIsDoneZykh()))
            && (this.getTotalKhAmt() == null ? other.getTotalKhAmt() == null : this.getTotalKhAmt().equals(other.getTotalKhAmt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuretyId() == null) ? 0 : getSuretyId().hashCode());
        result = prime * result + ((getSuretyNo() == null) ? 0 : getSuretyNo().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getSortType() == null) ? 0 : getSortType().hashCode());
        result = prime * result + ((getCollType() == null) ? 0 : getCollType().hashCode());
        result = prime * result + ((getAssessForm() == null) ? 0 : getAssessForm().hashCode());
        result = prime * result + ((getAssessDate() == null) ? 0 : getAssessDate().hashCode());
        result = prime * result + ((getAssessEndDate() == null) ? 0 : getAssessEndDate().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getAssessValue() == null) ? 0 : getAssessValue().hashCode());
        result = prime * result + ((getMortgageValue() == null) ? 0 : getMortgageValue().hashCode());
        result = prime * result + ((getMybankSetValue() == null) ? 0 : getMybankSetValue().hashCode());
        result = prime * result + ((getIfOtherCommon() == null) ? 0 : getIfOtherCommon().hashCode());
        result = prime * result + ((getMortgageStatus() == null) ? 0 : getMortgageStatus().hashCode());
        result = prime * result + ((getMortgageGainWay() == null) ? 0 : getMortgageGainWay().hashCode());
        result = prime * result + ((getCashAbility() == null) ? 0 : getCashAbility().hashCode());
        result = prime * result + ((getMortgageMobility() == null) ? 0 : getMortgageMobility().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getMybankAffirmValue() == null) ? 0 : getMybankAffirmValue().hashCode());
        result = prime * result + ((getSuretyAmt() == null) ? 0 : getSuretyAmt().hashCode());
        result = prime * result + ((getMortgageRate() == null) ? 0 : getMortgageRate().hashCode());
        result = prime * result + ((getTotalAmt() == null) ? 0 : getTotalAmt().hashCode());
        result = prime * result + ((getAviAmt() == null) ? 0 : getAviAmt().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getOwnershipNum() == null) ? 0 : getOwnershipNum().hashCode());
        result = prime * result + ((getInsuranceCondition() == null) ? 0 : getInsuranceCondition().hashCode());
        result = prime * result + ((getInsuranceCompany() == null) ? 0 : getInsuranceCompany().hashCode());
        result = prime * result + ((getInsuranceNum() == null) ? 0 : getInsuranceNum().hashCode());
        result = prime * result + ((getSuretyName() == null) ? 0 : getSuretyName().hashCode());
        result = prime * result + ((getTransFlag() == null) ? 0 : getTransFlag().hashCode());
        result = prime * result + ((getMortgagaAmt() == null) ? 0 : getMortgagaAmt().hashCode());
        result = prime * result + ((getIsDoneZykh() == null) ? 0 : getIsDoneZykh().hashCode());
        result = prime * result + ((getTotalKhAmt() == null) ? 0 : getTotalKhAmt().hashCode());
        return result;
    }
}