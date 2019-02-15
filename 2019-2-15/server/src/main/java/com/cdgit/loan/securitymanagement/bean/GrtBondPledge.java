package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 债券bean
 * @author wuyong
 * @date 2019.1.9
 *
 */
public class GrtBondPledge {
    private String guarantyId;

    private String issuePersName;

    private String bondLevelType;

    private String registerOrgName;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal bondValue;

    private String bondType;

    private String bondValueCurrencyCd;

    private String signCompanyStatus;

    private String signCompanyType;

    private String agencyMan;

    private String creditorName;

    private String bondSingedType;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date bondMaturity;

    private String bondInterestPayType;

    private String bondInterestPayMode;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal bondTerm;

    private String bondTermUnitCd;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal bondAnnualRate;

    private String signBondInd;

    private String k71zqzl;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getIssuePersName() {
        return issuePersName;
    }

    public void setIssuePersName(String issuePersName) {
        this.issuePersName = issuePersName == null ? null : issuePersName.trim();
    }

    public String getBondLevelType() {
        return bondLevelType;
    }

    public void setBondLevelType(String bondLevelType) {
        this.bondLevelType = bondLevelType == null ? null : bondLevelType.trim();
    }

    public String getRegisterOrgName() {
        return registerOrgName;
    }

    public void setRegisterOrgName(String registerOrgName) {
        this.registerOrgName = registerOrgName == null ? null : registerOrgName.trim();
    }

    public BigDecimal getBondValue() {
        return bondValue;
    }

    public void setBondValue(BigDecimal bondValue) {
        this.bondValue = bondValue;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType == null ? null : bondType.trim();
    }

    public String getBondValueCurrencyCd() {
        return bondValueCurrencyCd;
    }

    public void setBondValueCurrencyCd(String bondValueCurrencyCd) {
        this.bondValueCurrencyCd = bondValueCurrencyCd == null ? null : bondValueCurrencyCd.trim();
    }

    public String getSignCompanyStatus() {
        return signCompanyStatus;
    }

    public void setSignCompanyStatus(String signCompanyStatus) {
        this.signCompanyStatus = signCompanyStatus == null ? null : signCompanyStatus.trim();
    }

    public String getSignCompanyType() {
        return signCompanyType;
    }

    public void setSignCompanyType(String signCompanyType) {
        this.signCompanyType = signCompanyType == null ? null : signCompanyType.trim();
    }

    public String getAgencyMan() {
        return agencyMan;
    }

    public void setAgencyMan(String agencyMan) {
        this.agencyMan = agencyMan == null ? null : agencyMan.trim();
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName == null ? null : creditorName.trim();
    }

    public String getBondSingedType() {
        return bondSingedType;
    }

    public void setBondSingedType(String bondSingedType) {
        this.bondSingedType = bondSingedType == null ? null : bondSingedType.trim();
    }

    public Date getBondMaturity() {
        return bondMaturity;
    }

    public void setBondMaturity(Date bondMaturity) {
        this.bondMaturity = bondMaturity;
    }

    public String getBondInterestPayType() {
        return bondInterestPayType;
    }

    public void setBondInterestPayType(String bondInterestPayType) {
        this.bondInterestPayType = bondInterestPayType == null ? null : bondInterestPayType.trim();
    }

    public String getBondInterestPayMode() {
        return bondInterestPayMode;
    }

    public void setBondInterestPayMode(String bondInterestPayMode) {
        this.bondInterestPayMode = bondInterestPayMode == null ? null : bondInterestPayMode.trim();
    }

    public BigDecimal getBondTerm() {
        return bondTerm;
    }

    public void setBondTerm(BigDecimal bondTerm) {
        this.bondTerm = bondTerm;
    }

    public String getBondTermUnitCd() {
        return bondTermUnitCd;
    }

    public void setBondTermUnitCd(String bondTermUnitCd) {
        this.bondTermUnitCd = bondTermUnitCd == null ? null : bondTermUnitCd.trim();
    }

    public BigDecimal getBondAnnualRate() {
        return bondAnnualRate;
    }

    public void setBondAnnualRate(BigDecimal bondAnnualRate) {
        this.bondAnnualRate = bondAnnualRate;
    }

    public String getSignBondInd() {
        return signBondInd;
    }

    public void setSignBondInd(String signBondInd) {
        this.signBondInd = signBondInd == null ? null : signBondInd.trim();
    }

    public String getK71zqzl() {
        return k71zqzl;
    }

    public void setK71zqzl(String k71zqzl) {
        this.k71zqzl = k71zqzl == null ? null : k71zqzl.trim();
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
        GrtBondPledge other = (GrtBondPledge) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getIssuePersName() == null ? other.getIssuePersName() == null : this.getIssuePersName().equals(other.getIssuePersName()))
            && (this.getBondLevelType() == null ? other.getBondLevelType() == null : this.getBondLevelType().equals(other.getBondLevelType()))
            && (this.getRegisterOrgName() == null ? other.getRegisterOrgName() == null : this.getRegisterOrgName().equals(other.getRegisterOrgName()))
            && (this.getBondValue() == null ? other.getBondValue() == null : this.getBondValue().equals(other.getBondValue()))
            && (this.getBondType() == null ? other.getBondType() == null : this.getBondType().equals(other.getBondType()))
            && (this.getBondValueCurrencyCd() == null ? other.getBondValueCurrencyCd() == null : this.getBondValueCurrencyCd().equals(other.getBondValueCurrencyCd()))
            && (this.getSignCompanyStatus() == null ? other.getSignCompanyStatus() == null : this.getSignCompanyStatus().equals(other.getSignCompanyStatus()))
            && (this.getSignCompanyType() == null ? other.getSignCompanyType() == null : this.getSignCompanyType().equals(other.getSignCompanyType()))
            && (this.getAgencyMan() == null ? other.getAgencyMan() == null : this.getAgencyMan().equals(other.getAgencyMan()))
            && (this.getCreditorName() == null ? other.getCreditorName() == null : this.getCreditorName().equals(other.getCreditorName()))
            && (this.getBondSingedType() == null ? other.getBondSingedType() == null : this.getBondSingedType().equals(other.getBondSingedType()))
            && (this.getBondMaturity() == null ? other.getBondMaturity() == null : this.getBondMaturity().equals(other.getBondMaturity()))
            && (this.getBondInterestPayType() == null ? other.getBondInterestPayType() == null : this.getBondInterestPayType().equals(other.getBondInterestPayType()))
            && (this.getBondInterestPayMode() == null ? other.getBondInterestPayMode() == null : this.getBondInterestPayMode().equals(other.getBondInterestPayMode()))
            && (this.getBondTerm() == null ? other.getBondTerm() == null : this.getBondTerm().equals(other.getBondTerm()))
            && (this.getBondTermUnitCd() == null ? other.getBondTermUnitCd() == null : this.getBondTermUnitCd().equals(other.getBondTermUnitCd()))
            && (this.getBondAnnualRate() == null ? other.getBondAnnualRate() == null : this.getBondAnnualRate().equals(other.getBondAnnualRate()))
            && (this.getSignBondInd() == null ? other.getSignBondInd() == null : this.getSignBondInd().equals(other.getSignBondInd()))
            && (this.getK71zqzl() == null ? other.getK71zqzl() == null : this.getK71zqzl().equals(other.getK71zqzl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getIssuePersName() == null) ? 0 : getIssuePersName().hashCode());
        result = prime * result + ((getBondLevelType() == null) ? 0 : getBondLevelType().hashCode());
        result = prime * result + ((getRegisterOrgName() == null) ? 0 : getRegisterOrgName().hashCode());
        result = prime * result + ((getBondValue() == null) ? 0 : getBondValue().hashCode());
        result = prime * result + ((getBondType() == null) ? 0 : getBondType().hashCode());
        result = prime * result + ((getBondValueCurrencyCd() == null) ? 0 : getBondValueCurrencyCd().hashCode());
        result = prime * result + ((getSignCompanyStatus() == null) ? 0 : getSignCompanyStatus().hashCode());
        result = prime * result + ((getSignCompanyType() == null) ? 0 : getSignCompanyType().hashCode());
        result = prime * result + ((getAgencyMan() == null) ? 0 : getAgencyMan().hashCode());
        result = prime * result + ((getCreditorName() == null) ? 0 : getCreditorName().hashCode());
        result = prime * result + ((getBondSingedType() == null) ? 0 : getBondSingedType().hashCode());
        result = prime * result + ((getBondMaturity() == null) ? 0 : getBondMaturity().hashCode());
        result = prime * result + ((getBondInterestPayType() == null) ? 0 : getBondInterestPayType().hashCode());
        result = prime * result + ((getBondInterestPayMode() == null) ? 0 : getBondInterestPayMode().hashCode());
        result = prime * result + ((getBondTerm() == null) ? 0 : getBondTerm().hashCode());
        result = prime * result + ((getBondTermUnitCd() == null) ? 0 : getBondTermUnitCd().hashCode());
        result = prime * result + ((getBondAnnualRate() == null) ? 0 : getBondAnnualRate().hashCode());
        result = prime * result + ((getSignBondInd() == null) ? 0 : getSignBondInd().hashCode());
        result = prime * result + ((getK71zqzl() == null) ? 0 : getK71zqzl().hashCode());
        return result;
    }
}