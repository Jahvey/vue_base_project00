package com.cdgit.loan.securitymanagement.bean;

/**
 * 共有人bean
 * @author wuyong
 * @date 2018.12.28
 *
 */
public class GrtTogetherCorrelative {
    private String togetherCorrelativeId;

    private String collateralNum;

    private String togetherCorrelativeName;

    private String togetherCertificateType;

    private String togetherCertificateNum;

    private String guarantyId;

    public String getTogetherCorrelativeId() {
        return togetherCorrelativeId;
    }

    public void setTogetherCorrelativeId(String togetherCorrelativeId) {
        this.togetherCorrelativeId = togetherCorrelativeId == null ? null : togetherCorrelativeId.trim();
    }

    public String getCollateralNum() {
        return collateralNum;
    }

    public void setCollateralNum(String collateralNum) {
        this.collateralNum = collateralNum == null ? null : collateralNum.trim();
    }

    public String getTogetherCorrelativeName() {
        return togetherCorrelativeName;
    }

    public void setTogetherCorrelativeName(String togetherCorrelativeName) {
        this.togetherCorrelativeName = togetherCorrelativeName == null ? null : togetherCorrelativeName.trim();
    }

    public String getTogetherCertificateType() {
        return togetherCertificateType;
    }

    public void setTogetherCertificateType(String togetherCertificateType) {
        this.togetherCertificateType = togetherCertificateType == null ? null : togetherCertificateType.trim();
    }

    public String getTogetherCertificateNum() {
        return togetherCertificateNum;
    }

    public void setTogetherCertificateNum(String togetherCertificateNum) {
        this.togetherCertificateNum = togetherCertificateNum == null ? null : togetherCertificateNum.trim();
    }

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
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
        GrtTogetherCorrelative other = (GrtTogetherCorrelative) that;
        return (this.getTogetherCorrelativeId() == null ? other.getTogetherCorrelativeId() == null : this.getTogetherCorrelativeId().equals(other.getTogetherCorrelativeId()))
            && (this.getCollateralNum() == null ? other.getCollateralNum() == null : this.getCollateralNum().equals(other.getCollateralNum()))
            && (this.getTogetherCorrelativeName() == null ? other.getTogetherCorrelativeName() == null : this.getTogetherCorrelativeName().equals(other.getTogetherCorrelativeName()))
            && (this.getTogetherCertificateType() == null ? other.getTogetherCertificateType() == null : this.getTogetherCertificateType().equals(other.getTogetherCertificateType()))
            && (this.getTogetherCertificateNum() == null ? other.getTogetherCertificateNum() == null : this.getTogetherCertificateNum().equals(other.getTogetherCertificateNum()))
            && (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTogetherCorrelativeId() == null) ? 0 : getTogetherCorrelativeId().hashCode());
        result = prime * result + ((getCollateralNum() == null) ? 0 : getCollateralNum().hashCode());
        result = prime * result + ((getTogetherCorrelativeName() == null) ? 0 : getTogetherCorrelativeName().hashCode());
        result = prime * result + ((getTogetherCertificateType() == null) ? 0 : getTogetherCertificateType().hashCode());
        result = prime * result + ((getTogetherCertificateNum() == null) ? 0 : getTogetherCertificateNum().hashCode());
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        return result;
    }
}