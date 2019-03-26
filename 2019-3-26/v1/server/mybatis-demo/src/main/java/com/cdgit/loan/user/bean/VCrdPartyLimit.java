package com.cdgit.loan.user.bean;

import java.util.Date;

public class VCrdPartyLimit {
    private String PARTY_ID;

    private String LIMIT_ID;

    private String LIMIT_TYPE;

    private Short CREDIT_AMT;

    private Short USED_AMT;

    private Short USED_AMT_REAL;

    private Short AVAILABLE_AMT;

    private Short AVAILABLE_AMT_REAL;

    private String PARTY_NAME;

    private String CERT_TYPE;

    private String CERT_NUM;

    private String USER_NUM;

    private String ORG_NUM;

    private Date BEGIN_DATE;

    private Date END_DATE;

    public String getPARTY_ID() {
        return PARTY_ID;
    }

    public void setPARTY_ID(String PARTY_ID) {
        this.PARTY_ID = PARTY_ID == null ? null : PARTY_ID.trim();
    }

    public String getLIMIT_ID() {
        return LIMIT_ID;
    }

    public void setLIMIT_ID(String LIMIT_ID) {
        this.LIMIT_ID = LIMIT_ID == null ? null : LIMIT_ID.trim();
    }

    public String getLIMIT_TYPE() {
        return LIMIT_TYPE;
    }

    public void setLIMIT_TYPE(String LIMIT_TYPE) {
        this.LIMIT_TYPE = LIMIT_TYPE == null ? null : LIMIT_TYPE.trim();
    }

    public Short getCREDIT_AMT() {
        return CREDIT_AMT;
    }

    public void setCREDIT_AMT(Short CREDIT_AMT) {
        this.CREDIT_AMT = CREDIT_AMT;
    }

    public Short getUSED_AMT() {
        return USED_AMT;
    }

    public void setUSED_AMT(Short USED_AMT) {
        this.USED_AMT = USED_AMT;
    }

    public Short getUSED_AMT_REAL() {
        return USED_AMT_REAL;
    }

    public void setUSED_AMT_REAL(Short USED_AMT_REAL) {
        this.USED_AMT_REAL = USED_AMT_REAL;
    }

    public Short getAVAILABLE_AMT() {
        return AVAILABLE_AMT;
    }

    public void setAVAILABLE_AMT(Short AVAILABLE_AMT) {
        this.AVAILABLE_AMT = AVAILABLE_AMT;
    }

    public Short getAVAILABLE_AMT_REAL() {
        return AVAILABLE_AMT_REAL;
    }

    public void setAVAILABLE_AMT_REAL(Short AVAILABLE_AMT_REAL) {
        this.AVAILABLE_AMT_REAL = AVAILABLE_AMT_REAL;
    }

    public String getPARTY_NAME() {
        return PARTY_NAME;
    }

    public void setPARTY_NAME(String PARTY_NAME) {
        this.PARTY_NAME = PARTY_NAME == null ? null : PARTY_NAME.trim();
    }

    public String getCERT_TYPE() {
        return CERT_TYPE;
    }

    public void setCERT_TYPE(String CERT_TYPE) {
        this.CERT_TYPE = CERT_TYPE == null ? null : CERT_TYPE.trim();
    }

    public String getCERT_NUM() {
        return CERT_NUM;
    }

    public void setCERT_NUM(String CERT_NUM) {
        this.CERT_NUM = CERT_NUM == null ? null : CERT_NUM.trim();
    }

    public String getUSER_NUM() {
        return USER_NUM;
    }

    public void setUSER_NUM(String USER_NUM) {
        this.USER_NUM = USER_NUM == null ? null : USER_NUM.trim();
    }

    public String getORG_NUM() {
        return ORG_NUM;
    }

    public void setORG_NUM(String ORG_NUM) {
        this.ORG_NUM = ORG_NUM == null ? null : ORG_NUM.trim();
    }

    public Date getBEGIN_DATE() {
        return BEGIN_DATE;
    }

    public void setBEGIN_DATE(Date BEGIN_DATE) {
        this.BEGIN_DATE = BEGIN_DATE;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
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
        VCrdPartyLimit other = (VCrdPartyLimit) that;
        return (this.getPARTY_ID() == null ? other.getPARTY_ID() == null : this.getPARTY_ID().equals(other.getPARTY_ID()))
            && (this.getLIMIT_ID() == null ? other.getLIMIT_ID() == null : this.getLIMIT_ID().equals(other.getLIMIT_ID()))
            && (this.getLIMIT_TYPE() == null ? other.getLIMIT_TYPE() == null : this.getLIMIT_TYPE().equals(other.getLIMIT_TYPE()))
            && (this.getCREDIT_AMT() == null ? other.getCREDIT_AMT() == null : this.getCREDIT_AMT().equals(other.getCREDIT_AMT()))
            && (this.getUSED_AMT() == null ? other.getUSED_AMT() == null : this.getUSED_AMT().equals(other.getUSED_AMT()))
            && (this.getUSED_AMT_REAL() == null ? other.getUSED_AMT_REAL() == null : this.getUSED_AMT_REAL().equals(other.getUSED_AMT_REAL()))
            && (this.getAVAILABLE_AMT() == null ? other.getAVAILABLE_AMT() == null : this.getAVAILABLE_AMT().equals(other.getAVAILABLE_AMT()))
            && (this.getAVAILABLE_AMT_REAL() == null ? other.getAVAILABLE_AMT_REAL() == null : this.getAVAILABLE_AMT_REAL().equals(other.getAVAILABLE_AMT_REAL()))
            && (this.getPARTY_NAME() == null ? other.getPARTY_NAME() == null : this.getPARTY_NAME().equals(other.getPARTY_NAME()))
            && (this.getCERT_TYPE() == null ? other.getCERT_TYPE() == null : this.getCERT_TYPE().equals(other.getCERT_TYPE()))
            && (this.getCERT_NUM() == null ? other.getCERT_NUM() == null : this.getCERT_NUM().equals(other.getCERT_NUM()))
            && (this.getUSER_NUM() == null ? other.getUSER_NUM() == null : this.getUSER_NUM().equals(other.getUSER_NUM()))
            && (this.getORG_NUM() == null ? other.getORG_NUM() == null : this.getORG_NUM().equals(other.getORG_NUM()))
            && (this.getBEGIN_DATE() == null ? other.getBEGIN_DATE() == null : this.getBEGIN_DATE().equals(other.getBEGIN_DATE()))
            && (this.getEND_DATE() == null ? other.getEND_DATE() == null : this.getEND_DATE().equals(other.getEND_DATE()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPARTY_ID() == null) ? 0 : getPARTY_ID().hashCode());
        result = prime * result + ((getLIMIT_ID() == null) ? 0 : getLIMIT_ID().hashCode());
        result = prime * result + ((getLIMIT_TYPE() == null) ? 0 : getLIMIT_TYPE().hashCode());
        result = prime * result + ((getCREDIT_AMT() == null) ? 0 : getCREDIT_AMT().hashCode());
        result = prime * result + ((getUSED_AMT() == null) ? 0 : getUSED_AMT().hashCode());
        result = prime * result + ((getUSED_AMT_REAL() == null) ? 0 : getUSED_AMT_REAL().hashCode());
        result = prime * result + ((getAVAILABLE_AMT() == null) ? 0 : getAVAILABLE_AMT().hashCode());
        result = prime * result + ((getAVAILABLE_AMT_REAL() == null) ? 0 : getAVAILABLE_AMT_REAL().hashCode());
        result = prime * result + ((getPARTY_NAME() == null) ? 0 : getPARTY_NAME().hashCode());
        result = prime * result + ((getCERT_TYPE() == null) ? 0 : getCERT_TYPE().hashCode());
        result = prime * result + ((getCERT_NUM() == null) ? 0 : getCERT_NUM().hashCode());
        result = prime * result + ((getUSER_NUM() == null) ? 0 : getUSER_NUM().hashCode());
        result = prime * result + ((getORG_NUM() == null) ? 0 : getORG_NUM().hashCode());
        result = prime * result + ((getBEGIN_DATE() == null) ? 0 : getBEGIN_DATE().hashCode());
        result = prime * result + ((getEND_DATE() == null) ? 0 : getEND_DATE().hashCode());
        return result;
    }
}