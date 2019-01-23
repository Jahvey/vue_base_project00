package com.cdgit.loan.customerManage.creditInfo.bean;

import java.util.Date;

public class CreditInfo {
    private String id;

    private String partyId;

    private String infoSrc;

    private Date queryDate;

    private String letterOfPresentation;

    private String title;

    private String djkLxyqTimes;

    private String djkLjyqTimes;

    private String dkLxqxTimes;

    private String dkLjqxTimes;

    private String sxbjYqCondition;

    private String branchbadrecord;

    private String natiflag;

    private String natureOfUnit;

    private String scaleOfUnit;

    private String isalertcorp;

    private String havelawsuit;

    private String badleaderflag;
    
    //查询字段
    private String partyName;

    
    public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getInfoSrc() {
        return infoSrc;
    }

    public void setInfoSrc(String infoSrc) {
        this.infoSrc = infoSrc == null ? null : infoSrc.trim();
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public String getLetterOfPresentation() {
        return letterOfPresentation;
    }

    public void setLetterOfPresentation(String letterOfPresentation) {
        this.letterOfPresentation = letterOfPresentation == null ? null : letterOfPresentation.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDjkLxyqTimes() {
        return djkLxyqTimes;
    }

    public void setDjkLxyqTimes(String djkLxyqTimes) {
        this.djkLxyqTimes = djkLxyqTimes == null ? null : djkLxyqTimes.trim();
    }

    public String getDjkLjyqTimes() {
        return djkLjyqTimes;
    }

    public void setDjkLjyqTimes(String djkLjyqTimes) {
        this.djkLjyqTimes = djkLjyqTimes == null ? null : djkLjyqTimes.trim();
    }

    public String getDkLxqxTimes() {
        return dkLxqxTimes;
    }

    public void setDkLxqxTimes(String dkLxqxTimes) {
        this.dkLxqxTimes = dkLxqxTimes == null ? null : dkLxqxTimes.trim();
    }

    public String getDkLjqxTimes() {
        return dkLjqxTimes;
    }

    public void setDkLjqxTimes(String dkLjqxTimes) {
        this.dkLjqxTimes = dkLjqxTimes == null ? null : dkLjqxTimes.trim();
    }

    public String getSxbjYqCondition() {
        return sxbjYqCondition;
    }

    public void setSxbjYqCondition(String sxbjYqCondition) {
        this.sxbjYqCondition = sxbjYqCondition == null ? null : sxbjYqCondition.trim();
    }

    public String getBranchbadrecord() {
        return branchbadrecord;
    }

    public void setBranchbadrecord(String branchbadrecord) {
        this.branchbadrecord = branchbadrecord == null ? null : branchbadrecord.trim();
    }

    public String getNatiflag() {
        return natiflag;
    }

    public void setNatiflag(String natiflag) {
        this.natiflag = natiflag == null ? null : natiflag.trim();
    }

    public String getNatureOfUnit() {
        return natureOfUnit;
    }

    public void setNatureOfUnit(String natureOfUnit) {
        this.natureOfUnit = natureOfUnit == null ? null : natureOfUnit.trim();
    }

    public String getScaleOfUnit() {
        return scaleOfUnit;
    }

    public void setScaleOfUnit(String scaleOfUnit) {
        this.scaleOfUnit = scaleOfUnit == null ? null : scaleOfUnit.trim();
    }

    public String getIsalertcorp() {
        return isalertcorp;
    }

    public void setIsalertcorp(String isalertcorp) {
        this.isalertcorp = isalertcorp == null ? null : isalertcorp.trim();
    }

    public String getHavelawsuit() {
        return havelawsuit;
    }

    public void setHavelawsuit(String havelawsuit) {
        this.havelawsuit = havelawsuit == null ? null : havelawsuit.trim();
    }

    public String getBadleaderflag() {
        return badleaderflag;
    }

    public void setBadleaderflag(String badleaderflag) {
        this.badleaderflag = badleaderflag == null ? null : badleaderflag.trim();
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
        CreditInfo other = (CreditInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getInfoSrc() == null ? other.getInfoSrc() == null : this.getInfoSrc().equals(other.getInfoSrc()))
            && (this.getQueryDate() == null ? other.getQueryDate() == null : this.getQueryDate().equals(other.getQueryDate()))
            && (this.getLetterOfPresentation() == null ? other.getLetterOfPresentation() == null : this.getLetterOfPresentation().equals(other.getLetterOfPresentation()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDjkLxyqTimes() == null ? other.getDjkLxyqTimes() == null : this.getDjkLxyqTimes().equals(other.getDjkLxyqTimes()))
            && (this.getDjkLjyqTimes() == null ? other.getDjkLjyqTimes() == null : this.getDjkLjyqTimes().equals(other.getDjkLjyqTimes()))
            && (this.getDkLxqxTimes() == null ? other.getDkLxqxTimes() == null : this.getDkLxqxTimes().equals(other.getDkLxqxTimes()))
            && (this.getDkLjqxTimes() == null ? other.getDkLjqxTimes() == null : this.getDkLjqxTimes().equals(other.getDkLjqxTimes()))
            && (this.getSxbjYqCondition() == null ? other.getSxbjYqCondition() == null : this.getSxbjYqCondition().equals(other.getSxbjYqCondition()))
            && (this.getBranchbadrecord() == null ? other.getBranchbadrecord() == null : this.getBranchbadrecord().equals(other.getBranchbadrecord()))
            && (this.getNatiflag() == null ? other.getNatiflag() == null : this.getNatiflag().equals(other.getNatiflag()))
            && (this.getNatureOfUnit() == null ? other.getNatureOfUnit() == null : this.getNatureOfUnit().equals(other.getNatureOfUnit()))
            && (this.getScaleOfUnit() == null ? other.getScaleOfUnit() == null : this.getScaleOfUnit().equals(other.getScaleOfUnit()))
            && (this.getIsalertcorp() == null ? other.getIsalertcorp() == null : this.getIsalertcorp().equals(other.getIsalertcorp()))
            && (this.getHavelawsuit() == null ? other.getHavelawsuit() == null : this.getHavelawsuit().equals(other.getHavelawsuit()))
            && (this.getBadleaderflag() == null ? other.getBadleaderflag() == null : this.getBadleaderflag().equals(other.getBadleaderflag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getInfoSrc() == null) ? 0 : getInfoSrc().hashCode());
        result = prime * result + ((getQueryDate() == null) ? 0 : getQueryDate().hashCode());
        result = prime * result + ((getLetterOfPresentation() == null) ? 0 : getLetterOfPresentation().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDjkLxyqTimes() == null) ? 0 : getDjkLxyqTimes().hashCode());
        result = prime * result + ((getDjkLjyqTimes() == null) ? 0 : getDjkLjyqTimes().hashCode());
        result = prime * result + ((getDkLxqxTimes() == null) ? 0 : getDkLxqxTimes().hashCode());
        result = prime * result + ((getDkLjqxTimes() == null) ? 0 : getDkLjqxTimes().hashCode());
        result = prime * result + ((getSxbjYqCondition() == null) ? 0 : getSxbjYqCondition().hashCode());
        result = prime * result + ((getBranchbadrecord() == null) ? 0 : getBranchbadrecord().hashCode());
        result = prime * result + ((getNatiflag() == null) ? 0 : getNatiflag().hashCode());
        result = prime * result + ((getNatureOfUnit() == null) ? 0 : getNatureOfUnit().hashCode());
        result = prime * result + ((getScaleOfUnit() == null) ? 0 : getScaleOfUnit().hashCode());
        result = prime * result + ((getIsalertcorp() == null) ? 0 : getIsalertcorp().hashCode());
        result = prime * result + ((getHavelawsuit() == null) ? 0 : getHavelawsuit().hashCode());
        result = prime * result + ((getBadleaderflag() == null) ? 0 : getBadleaderflag().hashCode());
        return result;
    }
}