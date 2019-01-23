package com.cdgit.loan.customerManage.naturalSchool.bean;

import java.util.Date;

public class NaturalSchool {
    private String schoolId;

    private String collegename;

    private String collegeaddr;

    private String institutename;

    private String collegetype;

    private String educsign;

    private String subjectname;

    private Date graduateyear;

    private String lastchandate;

    private String lastchanperson;

    private String areacode;

    private String empnum;

    private String partyId;

    private String nationalityCd;

    private String provinceCd;

    private String cityCd;

    private String district;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename == null ? null : collegename.trim();
    }

    public String getCollegeaddr() {
        return collegeaddr;
    }

    public void setCollegeaddr(String collegeaddr) {
        this.collegeaddr = collegeaddr == null ? null : collegeaddr.trim();
    }

    public String getInstitutename() {
        return institutename;
    }

    public void setInstitutename(String institutename) {
        this.institutename = institutename == null ? null : institutename.trim();
    }

    public String getCollegetype() {
        return collegetype;
    }

    public void setCollegetype(String collegetype) {
        this.collegetype = collegetype == null ? null : collegetype.trim();
    }

    public String getEducsign() {
        return educsign;
    }

    public void setEducsign(String educsign) {
        this.educsign = educsign == null ? null : educsign.trim();
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname == null ? null : subjectname.trim();
    }

    public Date getGraduateyear() {
        return graduateyear;
    }

    public void setGraduateyear(Date graduateyear) {
        this.graduateyear = graduateyear;
    }

    public String getLastchandate() {
        return lastchandate;
    }

    public void setLastchandate(String lastchandate) {
        this.lastchandate = lastchandate == null ? null : lastchandate.trim();
    }

    public String getLastchanperson() {
        return lastchanperson;
    }

    public void setLastchanperson(String lastchanperson) {
        this.lastchanperson = lastchanperson == null ? null : lastchanperson.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getEmpnum() {
        return empnum;
    }

    public void setEmpnum(String empnum) {
        this.empnum = empnum == null ? null : empnum.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getNationalityCd() {
        return nationalityCd;
    }

    public void setNationalityCd(String nationalityCd) {
        this.nationalityCd = nationalityCd == null ? null : nationalityCd.trim();
    }

    public String getProvinceCd() {
        return provinceCd;
    }

    public void setProvinceCd(String provinceCd) {
        this.provinceCd = provinceCd == null ? null : provinceCd.trim();
    }

    public String getCityCd() {
        return cityCd;
    }

    public void setCityCd(String cityCd) {
        this.cityCd = cityCd == null ? null : cityCd.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
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
        NaturalSchool other = (NaturalSchool) that;
        return (this.getSchoolId() == null ? other.getSchoolId() == null : this.getSchoolId().equals(other.getSchoolId()))
            && (this.getCollegename() == null ? other.getCollegename() == null : this.getCollegename().equals(other.getCollegename()))
            && (this.getCollegeaddr() == null ? other.getCollegeaddr() == null : this.getCollegeaddr().equals(other.getCollegeaddr()))
            && (this.getInstitutename() == null ? other.getInstitutename() == null : this.getInstitutename().equals(other.getInstitutename()))
            && (this.getCollegetype() == null ? other.getCollegetype() == null : this.getCollegetype().equals(other.getCollegetype()))
            && (this.getEducsign() == null ? other.getEducsign() == null : this.getEducsign().equals(other.getEducsign()))
            && (this.getSubjectname() == null ? other.getSubjectname() == null : this.getSubjectname().equals(other.getSubjectname()))
            && (this.getGraduateyear() == null ? other.getGraduateyear() == null : this.getGraduateyear().equals(other.getGraduateyear()))
            && (this.getLastchandate() == null ? other.getLastchandate() == null : this.getLastchandate().equals(other.getLastchandate()))
            && (this.getLastchanperson() == null ? other.getLastchanperson() == null : this.getLastchanperson().equals(other.getLastchanperson()))
            && (this.getAreacode() == null ? other.getAreacode() == null : this.getAreacode().equals(other.getAreacode()))
            && (this.getEmpnum() == null ? other.getEmpnum() == null : this.getEmpnum().equals(other.getEmpnum()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getNationalityCd() == null ? other.getNationalityCd() == null : this.getNationalityCd().equals(other.getNationalityCd()))
            && (this.getProvinceCd() == null ? other.getProvinceCd() == null : this.getProvinceCd().equals(other.getProvinceCd()))
            && (this.getCityCd() == null ? other.getCityCd() == null : this.getCityCd().equals(other.getCityCd()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSchoolId() == null) ? 0 : getSchoolId().hashCode());
        result = prime * result + ((getCollegename() == null) ? 0 : getCollegename().hashCode());
        result = prime * result + ((getCollegeaddr() == null) ? 0 : getCollegeaddr().hashCode());
        result = prime * result + ((getInstitutename() == null) ? 0 : getInstitutename().hashCode());
        result = prime * result + ((getCollegetype() == null) ? 0 : getCollegetype().hashCode());
        result = prime * result + ((getEducsign() == null) ? 0 : getEducsign().hashCode());
        result = prime * result + ((getSubjectname() == null) ? 0 : getSubjectname().hashCode());
        result = prime * result + ((getGraduateyear() == null) ? 0 : getGraduateyear().hashCode());
        result = prime * result + ((getLastchandate() == null) ? 0 : getLastchandate().hashCode());
        result = prime * result + ((getLastchanperson() == null) ? 0 : getLastchanperson().hashCode());
        result = prime * result + ((getAreacode() == null) ? 0 : getAreacode().hashCode());
        result = prime * result + ((getEmpnum() == null) ? 0 : getEmpnum().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getNationalityCd() == null) ? 0 : getNationalityCd().hashCode());
        result = prime * result + ((getProvinceCd() == null) ? 0 : getProvinceCd().hashCode());
        result = prime * result + ((getCityCd() == null) ? 0 : getCityCd().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        return result;
    }
}