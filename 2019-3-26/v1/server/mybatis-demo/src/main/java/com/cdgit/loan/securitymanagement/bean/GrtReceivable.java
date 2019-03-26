package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.common.util.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 应收账款bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtReceivable {
    private String guarantyId;

    private String paymentPersName;

    private String currencyCs;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal amt;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal accountYears;

    private String accounYearsUnitCd;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date maturityDate;

    private String receivableContractNum;

    private String receivableManagerName;

    private String receivableCartType;

    private String receivableCartNum;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date receivableAccountDate;

    private String receivableCheckStutas;

    private String receiveAmtType;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date agreementAmtDate;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getPaymentPersName() {
        return paymentPersName;
    }

    public void setPaymentPersName(String paymentPersName) {
        this.paymentPersName = paymentPersName == null ? null : paymentPersName.trim();
    }

    public String getCurrencyCs() {
        return currencyCs;
    }

    public void setCurrencyCs(String currencyCs) {
        this.currencyCs = currencyCs == null ? null : currencyCs.trim();
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getAccountYears() {
        return accountYears;
    }

    public void setAccountYears(BigDecimal accountYears) {
        this.accountYears = accountYears;
    }

    public String getAccounYearsUnitCd() {
        return accounYearsUnitCd;
    }

    public void setAccounYearsUnitCd(String accounYearsUnitCd) {
        this.accounYearsUnitCd = accounYearsUnitCd == null ? null : accounYearsUnitCd.trim();
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getReceivableContractNum() {
        return receivableContractNum;
    }

    public void setReceivableContractNum(String receivableContractNum) {
        this.receivableContractNum = receivableContractNum == null ? null : receivableContractNum.trim();
    }

    public String getReceivableManagerName() {
        return receivableManagerName;
    }

    public void setReceivableManagerName(String receivableManagerName) {
        this.receivableManagerName = receivableManagerName == null ? null : receivableManagerName.trim();
    }

    public String getReceivableCartType() {
        return receivableCartType;
    }

    public void setReceivableCartType(String receivableCartType) {
        this.receivableCartType = receivableCartType == null ? null : receivableCartType.trim();
    }

    public String getReceivableCartNum() {
        return receivableCartNum;
    }

    public void setReceivableCartNum(String receivableCartNum) {
        this.receivableCartNum = receivableCartNum == null ? null : receivableCartNum.trim();
    }

    public Date getReceivableAccountDate() {
        return receivableAccountDate;
    }

    public void setReceivableAccountDate(Date receivableAccountDate) {
        this.receivableAccountDate = receivableAccountDate;
    }

    public String getReceivableCheckStutas() {
        return receivableCheckStutas;
    }

    public void setReceivableCheckStutas(String receivableCheckStutas) {
        this.receivableCheckStutas = receivableCheckStutas == null ? null : receivableCheckStutas.trim();
    }

    public String getReceiveAmtType() {
        return receiveAmtType;
    }

    public void setReceiveAmtType(String receiveAmtType) {
        this.receiveAmtType = receiveAmtType == null ? null : receiveAmtType.trim();
    }

    public Date getAgreementAmtDate() {
        return agreementAmtDate;
    }

    public void setAgreementAmtDate(Date agreementAmtDate) {
        this.agreementAmtDate = agreementAmtDate;
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
        GrtReceivable other = (GrtReceivable) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getPaymentPersName() == null ? other.getPaymentPersName() == null : this.getPaymentPersName().equals(other.getPaymentPersName()))
            && (this.getCurrencyCs() == null ? other.getCurrencyCs() == null : this.getCurrencyCs().equals(other.getCurrencyCs()))
            && (this.getAmt() == null ? other.getAmt() == null : this.getAmt().equals(other.getAmt()))
            && (this.getAccountYears() == null ? other.getAccountYears() == null : this.getAccountYears().equals(other.getAccountYears()))
            && (this.getAccounYearsUnitCd() == null ? other.getAccounYearsUnitCd() == null : this.getAccounYearsUnitCd().equals(other.getAccounYearsUnitCd()))
            && (this.getMaturityDate() == null ? other.getMaturityDate() == null : this.getMaturityDate().equals(other.getMaturityDate()))
            && (this.getReceivableContractNum() == null ? other.getReceivableContractNum() == null : this.getReceivableContractNum().equals(other.getReceivableContractNum()))
            && (this.getReceivableManagerName() == null ? other.getReceivableManagerName() == null : this.getReceivableManagerName().equals(other.getReceivableManagerName()))
            && (this.getReceivableCartType() == null ? other.getReceivableCartType() == null : this.getReceivableCartType().equals(other.getReceivableCartType()))
            && (this.getReceivableCartNum() == null ? other.getReceivableCartNum() == null : this.getReceivableCartNum().equals(other.getReceivableCartNum()))
            && (this.getReceivableAccountDate() == null ? other.getReceivableAccountDate() == null : this.getReceivableAccountDate().equals(other.getReceivableAccountDate()))
            && (this.getReceivableCheckStutas() == null ? other.getReceivableCheckStutas() == null : this.getReceivableCheckStutas().equals(other.getReceivableCheckStutas()))
            && (this.getReceiveAmtType() == null ? other.getReceiveAmtType() == null : this.getReceiveAmtType().equals(other.getReceiveAmtType()))
            && (this.getAgreementAmtDate() == null ? other.getAgreementAmtDate() == null : this.getAgreementAmtDate().equals(other.getAgreementAmtDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getPaymentPersName() == null) ? 0 : getPaymentPersName().hashCode());
        result = prime * result + ((getCurrencyCs() == null) ? 0 : getCurrencyCs().hashCode());
        result = prime * result + ((getAmt() == null) ? 0 : getAmt().hashCode());
        result = prime * result + ((getAccountYears() == null) ? 0 : getAccountYears().hashCode());
        result = prime * result + ((getAccounYearsUnitCd() == null) ? 0 : getAccounYearsUnitCd().hashCode());
        result = prime * result + ((getMaturityDate() == null) ? 0 : getMaturityDate().hashCode());
        result = prime * result + ((getReceivableContractNum() == null) ? 0 : getReceivableContractNum().hashCode());
        result = prime * result + ((getReceivableManagerName() == null) ? 0 : getReceivableManagerName().hashCode());
        result = prime * result + ((getReceivableCartType() == null) ? 0 : getReceivableCartType().hashCode());
        result = prime * result + ((getReceivableCartNum() == null) ? 0 : getReceivableCartNum().hashCode());
        result = prime * result + ((getReceivableAccountDate() == null) ? 0 : getReceivableAccountDate().hashCode());
        result = prime * result + ((getReceivableCheckStutas() == null) ? 0 : getReceivableCheckStutas().hashCode());
        result = prime * result + ((getReceiveAmtType() == null) ? 0 : getReceiveAmtType().hashCode());
        result = prime * result + ((getAgreementAmtDate() == null) ? 0 : getAgreementAmtDate().hashCode());
        return result;
    }
}