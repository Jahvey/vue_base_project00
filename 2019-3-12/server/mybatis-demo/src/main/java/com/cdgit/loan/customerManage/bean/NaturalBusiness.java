package com.cdgit.loan.customerManage.bean;

import java.util.Date;

public class NaturalBusiness {
    private String businessId;

    private String dealproj;

    private String dealbrand;

    private String licetype;

    private Date comedate;

    private String liceid;

    private String liceaddr;

    private String dealscope;

    private String dealaddr;

    private String dealaddrkind;

    private String yearamt;

    private String empnum;

    private String lastchanperson;

    private Date lastchandate;

    private String monthavesell;

    private String monthavecost;

    private String partyId;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getDealproj() {
        return dealproj;
    }

    public void setDealproj(String dealproj) {
        this.dealproj = dealproj == null ? null : dealproj.trim();
    }

    public String getDealbrand() {
        return dealbrand;
    }

    public void setDealbrand(String dealbrand) {
        this.dealbrand = dealbrand == null ? null : dealbrand.trim();
    }

    public String getLicetype() {
        return licetype;
    }

    public void setLicetype(String licetype) {
        this.licetype = licetype == null ? null : licetype.trim();
    }

    public Date getComedate() {
        return comedate;
    }

    public void setComedate(Date comedate) {
        this.comedate = comedate;
    }

    public String getLiceid() {
        return liceid;
    }

    public void setLiceid(String liceid) {
        this.liceid = liceid == null ? null : liceid.trim();
    }

    public String getLiceaddr() {
        return liceaddr;
    }

    public void setLiceaddr(String liceaddr) {
        this.liceaddr = liceaddr == null ? null : liceaddr.trim();
    }

    public String getDealscope() {
        return dealscope;
    }

    public void setDealscope(String dealscope) {
        this.dealscope = dealscope == null ? null : dealscope.trim();
    }

    public String getDealaddr() {
        return dealaddr;
    }

    public void setDealaddr(String dealaddr) {
        this.dealaddr = dealaddr == null ? null : dealaddr.trim();
    }

    public String getDealaddrkind() {
        return dealaddrkind;
    }

    public void setDealaddrkind(String dealaddrkind) {
        this.dealaddrkind = dealaddrkind == null ? null : dealaddrkind.trim();
    }

    public String getYearamt() {
        return yearamt;
    }

    public void setYearamt(String yearamt) {
        this.yearamt = yearamt == null ? null : yearamt.trim();
    }

    public String getEmpnum() {
        return empnum;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum == null ? null : empnum.trim();
    }

    public String getLastchanperson() {
        return lastchanperson;
    }

    public void setLastchanperson(String lastchanperson) {
        this.lastchanperson = lastchanperson == null ? null : lastchanperson.trim();
    }

    public Date getLastchandate() {
        return lastchandate;
    }

    public void setLastchandate(Date lastchandate) {
        this.lastchandate = lastchandate;
    }

    public String getMonthavesell() {
        return monthavesell;
    }

    public void setMonthavesell(String monthavesell) {
        this.monthavesell = monthavesell == null ? null : monthavesell.trim();
    }

    public String getMonthavecost() {
        return monthavecost;
    }

    public void setMonthavecost(String monthavecost) {
        this.monthavecost = monthavecost == null ? null : monthavecost.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
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
        NaturalBusiness other = (NaturalBusiness) that;
        return (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (this.getDealproj() == null ? other.getDealproj() == null : this.getDealproj().equals(other.getDealproj()))
            && (this.getDealbrand() == null ? other.getDealbrand() == null : this.getDealbrand().equals(other.getDealbrand()))
            && (this.getLicetype() == null ? other.getLicetype() == null : this.getLicetype().equals(other.getLicetype()))
            && (this.getComedate() == null ? other.getComedate() == null : this.getComedate().equals(other.getComedate()))
            && (this.getLiceid() == null ? other.getLiceid() == null : this.getLiceid().equals(other.getLiceid()))
            && (this.getLiceaddr() == null ? other.getLiceaddr() == null : this.getLiceaddr().equals(other.getLiceaddr()))
            && (this.getDealscope() == null ? other.getDealscope() == null : this.getDealscope().equals(other.getDealscope()))
            && (this.getDealaddr() == null ? other.getDealaddr() == null : this.getDealaddr().equals(other.getDealaddr()))
            && (this.getDealaddrkind() == null ? other.getDealaddrkind() == null : this.getDealaddrkind().equals(other.getDealaddrkind()))
            && (this.getYearamt() == null ? other.getYearamt() == null : this.getYearamt().equals(other.getYearamt()))
            && (this.getEmpnum() == null ? other.getEmpnum() == null : this.getEmpnum().equals(other.getEmpnum()))
            && (this.getLastchanperson() == null ? other.getLastchanperson() == null : this.getLastchanperson().equals(other.getLastchanperson()))
            && (this.getLastchandate() == null ? other.getLastchandate() == null : this.getLastchandate().equals(other.getLastchandate()))
            && (this.getMonthavesell() == null ? other.getMonthavesell() == null : this.getMonthavesell().equals(other.getMonthavesell()))
            && (this.getMonthavecost() == null ? other.getMonthavecost() == null : this.getMonthavecost().equals(other.getMonthavecost()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + ((getDealproj() == null) ? 0 : getDealproj().hashCode());
        result = prime * result + ((getDealbrand() == null) ? 0 : getDealbrand().hashCode());
        result = prime * result + ((getLicetype() == null) ? 0 : getLicetype().hashCode());
        result = prime * result + ((getComedate() == null) ? 0 : getComedate().hashCode());
        result = prime * result + ((getLiceid() == null) ? 0 : getLiceid().hashCode());
        result = prime * result + ((getLiceaddr() == null) ? 0 : getLiceaddr().hashCode());
        result = prime * result + ((getDealscope() == null) ? 0 : getDealscope().hashCode());
        result = prime * result + ((getDealaddr() == null) ? 0 : getDealaddr().hashCode());
        result = prime * result + ((getDealaddrkind() == null) ? 0 : getDealaddrkind().hashCode());
        result = prime * result + ((getYearamt() == null) ? 0 : getYearamt().hashCode());
        result = prime * result + ((getEmpnum() == null) ? 0 : getEmpnum().hashCode());
        result = prime * result + ((getLastchanperson() == null) ? 0 : getLastchanperson().hashCode());
        result = prime * result + ((getLastchandate() == null) ? 0 : getLastchandate().hashCode());
        result = prime * result + ((getMonthavesell() == null) ? 0 : getMonthavesell().hashCode());
        result = prime * result + ((getMonthavecost() == null) ? 0 : getMonthavecost().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        return result;
    }
}