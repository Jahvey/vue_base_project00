package com.cdgit.loan.securitymanagement.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.cdgit.loan.csm.common.BigDecimalConvertToString;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * 保单bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtGuaranteeSlip {
    private String guarantyId;

    private String k68bxgsmc;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal k68tbje;

    private String k68syr;

    private String k68dbr;

    private String k68bdzl;

    private String k68bzsm;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date k68grsj;
    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date k68bddqr;
    @JsonSerialize(using=BigDecimalConvertToString.class)
    private BigDecimal k68bdje;

    private String k68bdh;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getK68bxgsmc() {
        return k68bxgsmc;
    }

    public void setK68bxgsmc(String k68bxgsmc) {
        this.k68bxgsmc = k68bxgsmc == null ? null : k68bxgsmc.trim();
    }

    public BigDecimal getK68tbje() {
        return k68tbje;
    }

    public void setK68tbje(BigDecimal k68tbje) {
        this.k68tbje = k68tbje;
    }

    public String getK68syr() {
        return k68syr;
    }

    public void setK68syr(String k68syr) {
        this.k68syr = k68syr == null ? null : k68syr.trim();
    }

    public String getK68dbr() {
        return k68dbr;
    }

    public void setK68dbr(String k68dbr) {
        this.k68dbr = k68dbr == null ? null : k68dbr.trim();
    }

    public String getK68bdzl() {
        return k68bdzl;
    }

    public void setK68bdzl(String k68bdzl) {
        this.k68bdzl = k68bdzl == null ? null : k68bdzl.trim();
    }

    public String getK68bzsm() {
        return k68bzsm;
    }

    public void setK68bzsm(String k68bzsm) {
        this.k68bzsm = k68bzsm == null ? null : k68bzsm.trim();
    }

    public Date getK68grsj() {
        return k68grsj;
    }

    public void setK68grsj(Date k68grsj) {
        this.k68grsj = k68grsj;
    }

    public Date getK68bddqr() {
        return k68bddqr;
    }

    public void setK68bddqr(Date k68bddqr) {
        this.k68bddqr = k68bddqr;
    }

    public BigDecimal getK68bdje() {
        return k68bdje;
    }

    public void setK68bdje(BigDecimal k68bdje) {
        this.k68bdje = k68bdje;
    }

    public String getK68bdh() {
        return k68bdh;
    }

    public void setK68bdh(String k68bdh) {
        this.k68bdh = k68bdh == null ? null : k68bdh.trim();
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
        GrtGuaranteeSlip other = (GrtGuaranteeSlip) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getK68bxgsmc() == null ? other.getK68bxgsmc() == null : this.getK68bxgsmc().equals(other.getK68bxgsmc()))
            && (this.getK68tbje() == null ? other.getK68tbje() == null : this.getK68tbje().equals(other.getK68tbje()))
            && (this.getK68syr() == null ? other.getK68syr() == null : this.getK68syr().equals(other.getK68syr()))
            && (this.getK68dbr() == null ? other.getK68dbr() == null : this.getK68dbr().equals(other.getK68dbr()))
            && (this.getK68bdzl() == null ? other.getK68bdzl() == null : this.getK68bdzl().equals(other.getK68bdzl()))
            && (this.getK68bzsm() == null ? other.getK68bzsm() == null : this.getK68bzsm().equals(other.getK68bzsm()))
            && (this.getK68grsj() == null ? other.getK68grsj() == null : this.getK68grsj().equals(other.getK68grsj()))
            && (this.getK68bddqr() == null ? other.getK68bddqr() == null : this.getK68bddqr().equals(other.getK68bddqr()))
            && (this.getK68bdje() == null ? other.getK68bdje() == null : this.getK68bdje().equals(other.getK68bdje()))
            && (this.getK68bdh() == null ? other.getK68bdh() == null : this.getK68bdh().equals(other.getK68bdh()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getK68bxgsmc() == null) ? 0 : getK68bxgsmc().hashCode());
        result = prime * result + ((getK68tbje() == null) ? 0 : getK68tbje().hashCode());
        result = prime * result + ((getK68syr() == null) ? 0 : getK68syr().hashCode());
        result = prime * result + ((getK68dbr() == null) ? 0 : getK68dbr().hashCode());
        result = prime * result + ((getK68bdzl() == null) ? 0 : getK68bdzl().hashCode());
        result = prime * result + ((getK68bzsm() == null) ? 0 : getK68bzsm().hashCode());
        result = prime * result + ((getK68grsj() == null) ? 0 : getK68grsj().hashCode());
        result = prime * result + ((getK68bddqr() == null) ? 0 : getK68bddqr().hashCode());
        result = prime * result + ((getK68bdje() == null) ? 0 : getK68bdje().hashCode());
        result = prime * result + ((getK68bdh() == null) ? 0 : getK68bdh().hashCode());
        return result;
    }
}