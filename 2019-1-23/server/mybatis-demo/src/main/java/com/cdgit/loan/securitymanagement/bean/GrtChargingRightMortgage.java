package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 收费权bean
 * @author wuyong
 * @date 2018.1.9
 *
 */
public class GrtChargingRightMortgage {
    private String guarantyId;

    private String approveOrg;

    private String approveDocumentNum;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal chargeRepaymentRate;

    private String chargeRightCashflowAnalysis;

    private String collectionAccount;

    private String openBank;

    private String chargingRightName;

    private String chargingRightStander;

    private String chargingRightFileName;

    private String chargesLicenseNum;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getApproveOrg() {
        return approveOrg;
    }

    public void setApproveOrg(String approveOrg) {
        this.approveOrg = approveOrg == null ? null : approveOrg.trim();
    }

    public String getApproveDocumentNum() {
        return approveDocumentNum;
    }

    public void setApproveDocumentNum(String approveDocumentNum) {
        this.approveDocumentNum = approveDocumentNum == null ? null : approveDocumentNum.trim();
    }

    public BigDecimal getChargeRepaymentRate() {
        return chargeRepaymentRate;
    }

    public void setChargeRepaymentRate(BigDecimal chargeRepaymentRate) {
        this.chargeRepaymentRate = chargeRepaymentRate;
    }

    public String getChargeRightCashflowAnalysis() {
        return chargeRightCashflowAnalysis;
    }

    public void setChargeRightCashflowAnalysis(String chargeRightCashflowAnalysis) {
        this.chargeRightCashflowAnalysis = chargeRightCashflowAnalysis == null ? null : chargeRightCashflowAnalysis.trim();
    }

    public String getCollectionAccount() {
        return collectionAccount;
    }

    public void setCollectionAccount(String collectionAccount) {
        this.collectionAccount = collectionAccount == null ? null : collectionAccount.trim();
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    public String getChargingRightName() {
        return chargingRightName;
    }

    public void setChargingRightName(String chargingRightName) {
        this.chargingRightName = chargingRightName == null ? null : chargingRightName.trim();
    }

    public String getChargingRightStander() {
        return chargingRightStander;
    }

    public void setChargingRightStander(String chargingRightStander) {
        this.chargingRightStander = chargingRightStander == null ? null : chargingRightStander.trim();
    }

    public String getChargingRightFileName() {
        return chargingRightFileName;
    }

    public void setChargingRightFileName(String chargingRightFileName) {
        this.chargingRightFileName = chargingRightFileName == null ? null : chargingRightFileName.trim();
    }

    public String getChargesLicenseNum() {
        return chargesLicenseNum;
    }

    public void setChargesLicenseNum(String chargesLicenseNum) {
        this.chargesLicenseNum = chargesLicenseNum == null ? null : chargesLicenseNum.trim();
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
        GrtChargingRightMortgage other = (GrtChargingRightMortgage) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getApproveOrg() == null ? other.getApproveOrg() == null : this.getApproveOrg().equals(other.getApproveOrg()))
            && (this.getApproveDocumentNum() == null ? other.getApproveDocumentNum() == null : this.getApproveDocumentNum().equals(other.getApproveDocumentNum()))
            && (this.getChargeRepaymentRate() == null ? other.getChargeRepaymentRate() == null : this.getChargeRepaymentRate().equals(other.getChargeRepaymentRate()))
            && (this.getChargeRightCashflowAnalysis() == null ? other.getChargeRightCashflowAnalysis() == null : this.getChargeRightCashflowAnalysis().equals(other.getChargeRightCashflowAnalysis()))
            && (this.getCollectionAccount() == null ? other.getCollectionAccount() == null : this.getCollectionAccount().equals(other.getCollectionAccount()))
            && (this.getOpenBank() == null ? other.getOpenBank() == null : this.getOpenBank().equals(other.getOpenBank()))
            && (this.getChargingRightName() == null ? other.getChargingRightName() == null : this.getChargingRightName().equals(other.getChargingRightName()))
            && (this.getChargingRightStander() == null ? other.getChargingRightStander() == null : this.getChargingRightStander().equals(other.getChargingRightStander()))
            && (this.getChargingRightFileName() == null ? other.getChargingRightFileName() == null : this.getChargingRightFileName().equals(other.getChargingRightFileName()))
            && (this.getChargesLicenseNum() == null ? other.getChargesLicenseNum() == null : this.getChargesLicenseNum().equals(other.getChargesLicenseNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getApproveOrg() == null) ? 0 : getApproveOrg().hashCode());
        result = prime * result + ((getApproveDocumentNum() == null) ? 0 : getApproveDocumentNum().hashCode());
        result = prime * result + ((getChargeRepaymentRate() == null) ? 0 : getChargeRepaymentRate().hashCode());
        result = prime * result + ((getChargeRightCashflowAnalysis() == null) ? 0 : getChargeRightCashflowAnalysis().hashCode());
        result = prime * result + ((getCollectionAccount() == null) ? 0 : getCollectionAccount().hashCode());
        result = prime * result + ((getOpenBank() == null) ? 0 : getOpenBank().hashCode());
        result = prime * result + ((getChargingRightName() == null) ? 0 : getChargingRightName().hashCode());
        result = prime * result + ((getChargingRightStander() == null) ? 0 : getChargingRightStander().hashCode());
        result = prime * result + ((getChargingRightFileName() == null) ? 0 : getChargingRightFileName().hashCode());
        result = prime * result + ((getChargesLicenseNum() == null) ? 0 : getChargesLicenseNum().hashCode());
        return result;
    }
}