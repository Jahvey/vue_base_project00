package com.cdgit.loan.customerManage.natural.bean;

import java.util.Date;

public class NaturalPerson {
    private String partyId;

    private String partyName;

    private String englishName;

    private String chineseShortName;

    private String englishShortName;

    private String genderCd;

    private String marriageCd;

    private Date birthday;

    private String degreeCd;

    private String educationBackgroudCd;

    private String nation;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String updateUserNum;

    private String updateOrgNum;

    private String naturalPersonTypeCd;

    private String workUnit;

    private String certType;

    private String certNum;

    private String hukouProperty;

    private String isFarmer;

    private String hukouRegisted;

    private String streetPoliceStation;

    private String healthState;

    private String profession;

    private String professionalTitle;

    private String accountingAssistant;

    private String positionProperty;

    private String workYears;

    private String familyNumber;

    private String provideForNumber;

    private String familyAddress;

    private String houseProperty;

    private String familyPhone;

    private String phoneNumber;

    private String unitAdress;

    private String unitPhone;

    private String industry;

    private String industryDesc;

    private String jointGuarantee;

    private String stockholderOfBank;

    private String whetherBlackList;

    private String blackListReason;

    private String isBankEmployee;

    private String employeeGrade;

    private String isSamllLoandEmp;

    private String countrySign;

    private String isBasebankRelaCust;

    private String isThirdCust;

    private String thirdCustTypeCd;

    private String middleCode;

    private String weixinNum;

    private String communicationAddress;

    private String communicationAddressCode;

    private String liveAddressCode;

    private String email;

    private String unitAddressCode;

    private String annualsalary;

    private String resdntCharCd;

    private String schName;

    private Date certCreateDate;

    private Date certEndDate;

    private String ifcertificate;

    private String natiflag;

    private String natureOfUnit;

    private String scaleOfUnit;

    private String flgSms;

    private String custType;
    
    //查询字段
    private String partyNum; //客户编号
    
    private String partyTypeCd; //
    
    private String isPotentialCust; //是否潜在客户
    
    private String ecifPartyNum;

    
    public String getPartyNum() {
		return partyNum;
	}

	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}

	public String getPartyTypeCd() {
		return partyTypeCd;
	}

	public void setPartyTypeCd(String partyTypeCd) {
		this.partyTypeCd = partyTypeCd;
	}

	public String getIsPotentialCust() {
		return isPotentialCust;
	}

	public void setIsPotentialCust(String isPotentialCust) {
		this.isPotentialCust = isPotentialCust;
	}

	public String getEcifPartyNum() {
		return ecifPartyNum;
	}

	public void setEcifPartyNum(String ecifPartyNum) {
		this.ecifPartyNum = ecifPartyNum;
	}

	public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getChineseShortName() {
        return chineseShortName;
    }

    public void setChineseShortName(String chineseShortName) {
        this.chineseShortName = chineseShortName == null ? null : chineseShortName.trim();
    }

    public String getEnglishShortName() {
        return englishShortName;
    }

    public void setEnglishShortName(String englishShortName) {
        this.englishShortName = englishShortName == null ? null : englishShortName.trim();
    }

    public String getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(String genderCd) {
        this.genderCd = genderCd == null ? null : genderCd.trim();
    }

    public String getMarriageCd() {
        return marriageCd;
    }

    public void setMarriageCd(String marriageCd) {
        this.marriageCd = marriageCd == null ? null : marriageCd.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDegreeCd() {
        return degreeCd;
    }

    public void setDegreeCd(String degreeCd) {
        this.degreeCd = degreeCd == null ? null : degreeCd.trim();
    }

    public String getEducationBackgroudCd() {
        return educationBackgroudCd;
    }

    public void setEducationBackgroudCd(String educationBackgroudCd) {
        this.educationBackgroudCd = educationBackgroudCd == null ? null : educationBackgroudCd.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getUpdateUserNum() {
        return updateUserNum;
    }

    public void setUpdateUserNum(String updateUserNum) {
        this.updateUserNum = updateUserNum == null ? null : updateUserNum.trim();
    }

    public String getUpdateOrgNum() {
        return updateOrgNum;
    }

    public void setUpdateOrgNum(String updateOrgNum) {
        this.updateOrgNum = updateOrgNum == null ? null : updateOrgNum.trim();
    }

    public String getNaturalPersonTypeCd() {
        return naturalPersonTypeCd;
    }

    public void setNaturalPersonTypeCd(String naturalPersonTypeCd) {
        this.naturalPersonTypeCd = naturalPersonTypeCd == null ? null : naturalPersonTypeCd.trim();
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType == null ? null : certType.trim();
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum == null ? null : certNum.trim();
    }

    public String getHukouProperty() {
        return hukouProperty;
    }

    public void setHukouProperty(String hukouProperty) {
        this.hukouProperty = hukouProperty == null ? null : hukouProperty.trim();
    }

    public String getIsFarmer() {
        return isFarmer;
    }

    public void setIsFarmer(String isFarmer) {
        this.isFarmer = isFarmer == null ? null : isFarmer.trim();
    }

    public String getHukouRegisted() {
        return hukouRegisted;
    }

    public void setHukouRegisted(String hukouRegisted) {
        this.hukouRegisted = hukouRegisted == null ? null : hukouRegisted.trim();
    }

    public String getStreetPoliceStation() {
        return streetPoliceStation;
    }

    public void setStreetPoliceStation(String streetPoliceStation) {
        this.streetPoliceStation = streetPoliceStation == null ? null : streetPoliceStation.trim();
    }

    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState == null ? null : healthState.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle == null ? null : professionalTitle.trim();
    }

    public String getAccountingAssistant() {
        return accountingAssistant;
    }

    public void setAccountingAssistant(String accountingAssistant) {
        this.accountingAssistant = accountingAssistant == null ? null : accountingAssistant.trim();
    }

    public String getPositionProperty() {
        return positionProperty;
    }

    public void setPositionProperty(String positionProperty) {
        this.positionProperty = positionProperty == null ? null : positionProperty.trim();
    }

    public String getWorkYears() {
        return workYears;
    }

    public void setWorkYears(String workYears) {
        this.workYears = workYears == null ? null : workYears.trim();
    }

    public String getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(String familyNumber) {
        this.familyNumber = familyNumber == null ? null : familyNumber.trim();
    }

    public String getProvideForNumber() {
        return provideForNumber;
    }

    public void setProvideForNumber(String provideForNumber) {
        this.provideForNumber = provideForNumber == null ? null : provideForNumber.trim();
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress == null ? null : familyAddress.trim();
    }

    public String getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(String houseProperty) {
        this.houseProperty = houseProperty == null ? null : houseProperty.trim();
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone == null ? null : familyPhone.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getUnitAdress() {
        return unitAdress;
    }

    public void setUnitAdress(String unitAdress) {
        this.unitAdress = unitAdress == null ? null : unitAdress.trim();
    }

    public String getUnitPhone() {
        return unitPhone;
    }

    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone == null ? null : unitPhone.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getIndustryDesc() {
        return industryDesc;
    }

    public void setIndustryDesc(String industryDesc) {
        this.industryDesc = industryDesc == null ? null : industryDesc.trim();
    }

    public String getJointGuarantee() {
        return jointGuarantee;
    }

    public void setJointGuarantee(String jointGuarantee) {
        this.jointGuarantee = jointGuarantee == null ? null : jointGuarantee.trim();
    }

    public String getStockholderOfBank() {
        return stockholderOfBank;
    }

    public void setStockholderOfBank(String stockholderOfBank) {
        this.stockholderOfBank = stockholderOfBank == null ? null : stockholderOfBank.trim();
    }

    public String getWhetherBlackList() {
        return whetherBlackList;
    }

    public void setWhetherBlackList(String whetherBlackList) {
        this.whetherBlackList = whetherBlackList == null ? null : whetherBlackList.trim();
    }

    public String getBlackListReason() {
        return blackListReason;
    }

    public void setBlackListReason(String blackListReason) {
        this.blackListReason = blackListReason == null ? null : blackListReason.trim();
    }

    public String getIsBankEmployee() {
        return isBankEmployee;
    }

    public void setIsBankEmployee(String isBankEmployee) {
        this.isBankEmployee = isBankEmployee == null ? null : isBankEmployee.trim();
    }

    public String getEmployeeGrade() {
        return employeeGrade;
    }

    public void setEmployeeGrade(String employeeGrade) {
        this.employeeGrade = employeeGrade == null ? null : employeeGrade.trim();
    }

    public String getIsSamllLoandEmp() {
        return isSamllLoandEmp;
    }

    public void setIsSamllLoandEmp(String isSamllLoandEmp) {
        this.isSamllLoandEmp = isSamllLoandEmp == null ? null : isSamllLoandEmp.trim();
    }

    public String getCountrySign() {
        return countrySign;
    }

    public void setCountrySign(String countrySign) {
        this.countrySign = countrySign == null ? null : countrySign.trim();
    }

    public String getIsBasebankRelaCust() {
        return isBasebankRelaCust;
    }

    public void setIsBasebankRelaCust(String isBasebankRelaCust) {
        this.isBasebankRelaCust = isBasebankRelaCust == null ? null : isBasebankRelaCust.trim();
    }

    public String getIsThirdCust() {
        return isThirdCust;
    }

    public void setIsThirdCust(String isThirdCust) {
        this.isThirdCust = isThirdCust == null ? null : isThirdCust.trim();
    }

    public String getThirdCustTypeCd() {
        return thirdCustTypeCd;
    }

    public void setThirdCustTypeCd(String thirdCustTypeCd) {
        this.thirdCustTypeCd = thirdCustTypeCd == null ? null : thirdCustTypeCd.trim();
    }

    public String getMiddleCode() {
        return middleCode;
    }

    public void setMiddleCode(String middleCode) {
        this.middleCode = middleCode == null ? null : middleCode.trim();
    }

    public String getWeixinNum() {
        return weixinNum;
    }

    public void setWeixinNum(String weixinNum) {
        this.weixinNum = weixinNum == null ? null : weixinNum.trim();
    }

    public String getCommunicationAddress() {
        return communicationAddress;
    }

    public void setCommunicationAddress(String communicationAddress) {
        this.communicationAddress = communicationAddress == null ? null : communicationAddress.trim();
    }

    public String getCommunicationAddressCode() {
        return communicationAddressCode;
    }

    public void setCommunicationAddressCode(String communicationAddressCode) {
        this.communicationAddressCode = communicationAddressCode == null ? null : communicationAddressCode.trim();
    }

    public String getLiveAddressCode() {
        return liveAddressCode;
    }

    public void setLiveAddressCode(String liveAddressCode) {
        this.liveAddressCode = liveAddressCode == null ? null : liveAddressCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUnitAddressCode() {
        return unitAddressCode;
    }

    public void setUnitAddressCode(String unitAddressCode) {
        this.unitAddressCode = unitAddressCode == null ? null : unitAddressCode.trim();
    }

    public String getAnnualsalary() {
        return annualsalary;
    }

    public void setAnnualsalary(String annualsalary) {
        this.annualsalary = annualsalary == null ? null : annualsalary.trim();
    }

    public String getResdntCharCd() {
        return resdntCharCd;
    }

    public void setResdntCharCd(String resdntCharCd) {
        this.resdntCharCd = resdntCharCd == null ? null : resdntCharCd.trim();
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName == null ? null : schName.trim();
    }

    public Date getCertCreateDate() {
        return certCreateDate;
    }

    public void setCertCreateDate(Date certCreateDate) {
        this.certCreateDate = certCreateDate;
    }

    public Date getCertEndDate() {
        return certEndDate;
    }

    public void setCertEndDate(Date certEndDate) {
        this.certEndDate = certEndDate;
    }

    public String getIfcertificate() {
        return ifcertificate;
    }

    public void setIfcertificate(String ifcertificate) {
        this.ifcertificate = ifcertificate == null ? null : ifcertificate.trim();
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

    public String getFlgSms() {
        return flgSms;
    }

    public void setFlgSms(String flgSms) {
        this.flgSms = flgSms == null ? null : flgSms.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
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
        NaturalPerson other = (NaturalPerson) that;
        return (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getPartyName() == null ? other.getPartyName() == null : this.getPartyName().equals(other.getPartyName()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getChineseShortName() == null ? other.getChineseShortName() == null : this.getChineseShortName().equals(other.getChineseShortName()))
            && (this.getEnglishShortName() == null ? other.getEnglishShortName() == null : this.getEnglishShortName().equals(other.getEnglishShortName()))
            && (this.getGenderCd() == null ? other.getGenderCd() == null : this.getGenderCd().equals(other.getGenderCd()))
            && (this.getMarriageCd() == null ? other.getMarriageCd() == null : this.getMarriageCd().equals(other.getMarriageCd()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getDegreeCd() == null ? other.getDegreeCd() == null : this.getDegreeCd().equals(other.getDegreeCd()))
            && (this.getEducationBackgroudCd() == null ? other.getEducationBackgroudCd() == null : this.getEducationBackgroudCd().equals(other.getEducationBackgroudCd()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUserNum() == null ? other.getUpdateUserNum() == null : this.getUpdateUserNum().equals(other.getUpdateUserNum()))
            && (this.getUpdateOrgNum() == null ? other.getUpdateOrgNum() == null : this.getUpdateOrgNum().equals(other.getUpdateOrgNum()))
            && (this.getNaturalPersonTypeCd() == null ? other.getNaturalPersonTypeCd() == null : this.getNaturalPersonTypeCd().equals(other.getNaturalPersonTypeCd()))
            && (this.getWorkUnit() == null ? other.getWorkUnit() == null : this.getWorkUnit().equals(other.getWorkUnit()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getCertNum() == null ? other.getCertNum() == null : this.getCertNum().equals(other.getCertNum()))
            && (this.getHukouProperty() == null ? other.getHukouProperty() == null : this.getHukouProperty().equals(other.getHukouProperty()))
            && (this.getIsFarmer() == null ? other.getIsFarmer() == null : this.getIsFarmer().equals(other.getIsFarmer()))
            && (this.getHukouRegisted() == null ? other.getHukouRegisted() == null : this.getHukouRegisted().equals(other.getHukouRegisted()))
            && (this.getStreetPoliceStation() == null ? other.getStreetPoliceStation() == null : this.getStreetPoliceStation().equals(other.getStreetPoliceStation()))
            && (this.getHealthState() == null ? other.getHealthState() == null : this.getHealthState().equals(other.getHealthState()))
            && (this.getProfession() == null ? other.getProfession() == null : this.getProfession().equals(other.getProfession()))
            && (this.getProfessionalTitle() == null ? other.getProfessionalTitle() == null : this.getProfessionalTitle().equals(other.getProfessionalTitle()))
            && (this.getAccountingAssistant() == null ? other.getAccountingAssistant() == null : this.getAccountingAssistant().equals(other.getAccountingAssistant()))
            && (this.getPositionProperty() == null ? other.getPositionProperty() == null : this.getPositionProperty().equals(other.getPositionProperty()))
            && (this.getWorkYears() == null ? other.getWorkYears() == null : this.getWorkYears().equals(other.getWorkYears()))
            && (this.getFamilyNumber() == null ? other.getFamilyNumber() == null : this.getFamilyNumber().equals(other.getFamilyNumber()))
            && (this.getProvideForNumber() == null ? other.getProvideForNumber() == null : this.getProvideForNumber().equals(other.getProvideForNumber()))
            && (this.getFamilyAddress() == null ? other.getFamilyAddress() == null : this.getFamilyAddress().equals(other.getFamilyAddress()))
            && (this.getHouseProperty() == null ? other.getHouseProperty() == null : this.getHouseProperty().equals(other.getHouseProperty()))
            && (this.getFamilyPhone() == null ? other.getFamilyPhone() == null : this.getFamilyPhone().equals(other.getFamilyPhone()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getUnitAdress() == null ? other.getUnitAdress() == null : this.getUnitAdress().equals(other.getUnitAdress()))
            && (this.getUnitPhone() == null ? other.getUnitPhone() == null : this.getUnitPhone().equals(other.getUnitPhone()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getIndustryDesc() == null ? other.getIndustryDesc() == null : this.getIndustryDesc().equals(other.getIndustryDesc()))
            && (this.getJointGuarantee() == null ? other.getJointGuarantee() == null : this.getJointGuarantee().equals(other.getJointGuarantee()))
            && (this.getStockholderOfBank() == null ? other.getStockholderOfBank() == null : this.getStockholderOfBank().equals(other.getStockholderOfBank()))
            && (this.getWhetherBlackList() == null ? other.getWhetherBlackList() == null : this.getWhetherBlackList().equals(other.getWhetherBlackList()))
            && (this.getBlackListReason() == null ? other.getBlackListReason() == null : this.getBlackListReason().equals(other.getBlackListReason()))
            && (this.getIsBankEmployee() == null ? other.getIsBankEmployee() == null : this.getIsBankEmployee().equals(other.getIsBankEmployee()))
            && (this.getEmployeeGrade() == null ? other.getEmployeeGrade() == null : this.getEmployeeGrade().equals(other.getEmployeeGrade()))
            && (this.getIsSamllLoandEmp() == null ? other.getIsSamllLoandEmp() == null : this.getIsSamllLoandEmp().equals(other.getIsSamllLoandEmp()))
            && (this.getCountrySign() == null ? other.getCountrySign() == null : this.getCountrySign().equals(other.getCountrySign()))
            && (this.getIsBasebankRelaCust() == null ? other.getIsBasebankRelaCust() == null : this.getIsBasebankRelaCust().equals(other.getIsBasebankRelaCust()))
            && (this.getIsThirdCust() == null ? other.getIsThirdCust() == null : this.getIsThirdCust().equals(other.getIsThirdCust()))
            && (this.getThirdCustTypeCd() == null ? other.getThirdCustTypeCd() == null : this.getThirdCustTypeCd().equals(other.getThirdCustTypeCd()))
            && (this.getMiddleCode() == null ? other.getMiddleCode() == null : this.getMiddleCode().equals(other.getMiddleCode()))
            && (this.getWeixinNum() == null ? other.getWeixinNum() == null : this.getWeixinNum().equals(other.getWeixinNum()))
            && (this.getCommunicationAddress() == null ? other.getCommunicationAddress() == null : this.getCommunicationAddress().equals(other.getCommunicationAddress()))
            && (this.getCommunicationAddressCode() == null ? other.getCommunicationAddressCode() == null : this.getCommunicationAddressCode().equals(other.getCommunicationAddressCode()))
            && (this.getLiveAddressCode() == null ? other.getLiveAddressCode() == null : this.getLiveAddressCode().equals(other.getLiveAddressCode()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getUnitAddressCode() == null ? other.getUnitAddressCode() == null : this.getUnitAddressCode().equals(other.getUnitAddressCode()))
            && (this.getAnnualsalary() == null ? other.getAnnualsalary() == null : this.getAnnualsalary().equals(other.getAnnualsalary()))
            && (this.getResdntCharCd() == null ? other.getResdntCharCd() == null : this.getResdntCharCd().equals(other.getResdntCharCd()))
            && (this.getSchName() == null ? other.getSchName() == null : this.getSchName().equals(other.getSchName()))
            && (this.getCertCreateDate() == null ? other.getCertCreateDate() == null : this.getCertCreateDate().equals(other.getCertCreateDate()))
            && (this.getCertEndDate() == null ? other.getCertEndDate() == null : this.getCertEndDate().equals(other.getCertEndDate()))
            && (this.getIfcertificate() == null ? other.getIfcertificate() == null : this.getIfcertificate().equals(other.getIfcertificate()))
            && (this.getNatiflag() == null ? other.getNatiflag() == null : this.getNatiflag().equals(other.getNatiflag()))
            && (this.getNatureOfUnit() == null ? other.getNatureOfUnit() == null : this.getNatureOfUnit().equals(other.getNatureOfUnit()))
            && (this.getScaleOfUnit() == null ? other.getScaleOfUnit() == null : this.getScaleOfUnit().equals(other.getScaleOfUnit()))
            && (this.getFlgSms() == null ? other.getFlgSms() == null : this.getFlgSms().equals(other.getFlgSms()))
            && (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getPartyName() == null) ? 0 : getPartyName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getChineseShortName() == null) ? 0 : getChineseShortName().hashCode());
        result = prime * result + ((getEnglishShortName() == null) ? 0 : getEnglishShortName().hashCode());
        result = prime * result + ((getGenderCd() == null) ? 0 : getGenderCd().hashCode());
        result = prime * result + ((getMarriageCd() == null) ? 0 : getMarriageCd().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getDegreeCd() == null) ? 0 : getDegreeCd().hashCode());
        result = prime * result + ((getEducationBackgroudCd() == null) ? 0 : getEducationBackgroudCd().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUserNum() == null) ? 0 : getUpdateUserNum().hashCode());
        result = prime * result + ((getUpdateOrgNum() == null) ? 0 : getUpdateOrgNum().hashCode());
        result = prime * result + ((getNaturalPersonTypeCd() == null) ? 0 : getNaturalPersonTypeCd().hashCode());
        result = prime * result + ((getWorkUnit() == null) ? 0 : getWorkUnit().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNum() == null) ? 0 : getCertNum().hashCode());
        result = prime * result + ((getHukouProperty() == null) ? 0 : getHukouProperty().hashCode());
        result = prime * result + ((getIsFarmer() == null) ? 0 : getIsFarmer().hashCode());
        result = prime * result + ((getHukouRegisted() == null) ? 0 : getHukouRegisted().hashCode());
        result = prime * result + ((getStreetPoliceStation() == null) ? 0 : getStreetPoliceStation().hashCode());
        result = prime * result + ((getHealthState() == null) ? 0 : getHealthState().hashCode());
        result = prime * result + ((getProfession() == null) ? 0 : getProfession().hashCode());
        result = prime * result + ((getProfessionalTitle() == null) ? 0 : getProfessionalTitle().hashCode());
        result = prime * result + ((getAccountingAssistant() == null) ? 0 : getAccountingAssistant().hashCode());
        result = prime * result + ((getPositionProperty() == null) ? 0 : getPositionProperty().hashCode());
        result = prime * result + ((getWorkYears() == null) ? 0 : getWorkYears().hashCode());
        result = prime * result + ((getFamilyNumber() == null) ? 0 : getFamilyNumber().hashCode());
        result = prime * result + ((getProvideForNumber() == null) ? 0 : getProvideForNumber().hashCode());
        result = prime * result + ((getFamilyAddress() == null) ? 0 : getFamilyAddress().hashCode());
        result = prime * result + ((getHouseProperty() == null) ? 0 : getHouseProperty().hashCode());
        result = prime * result + ((getFamilyPhone() == null) ? 0 : getFamilyPhone().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getUnitAdress() == null) ? 0 : getUnitAdress().hashCode());
        result = prime * result + ((getUnitPhone() == null) ? 0 : getUnitPhone().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getIndustryDesc() == null) ? 0 : getIndustryDesc().hashCode());
        result = prime * result + ((getJointGuarantee() == null) ? 0 : getJointGuarantee().hashCode());
        result = prime * result + ((getStockholderOfBank() == null) ? 0 : getStockholderOfBank().hashCode());
        result = prime * result + ((getWhetherBlackList() == null) ? 0 : getWhetherBlackList().hashCode());
        result = prime * result + ((getBlackListReason() == null) ? 0 : getBlackListReason().hashCode());
        result = prime * result + ((getIsBankEmployee() == null) ? 0 : getIsBankEmployee().hashCode());
        result = prime * result + ((getEmployeeGrade() == null) ? 0 : getEmployeeGrade().hashCode());
        result = prime * result + ((getIsSamllLoandEmp() == null) ? 0 : getIsSamllLoandEmp().hashCode());
        result = prime * result + ((getCountrySign() == null) ? 0 : getCountrySign().hashCode());
        result = prime * result + ((getIsBasebankRelaCust() == null) ? 0 : getIsBasebankRelaCust().hashCode());
        result = prime * result + ((getIsThirdCust() == null) ? 0 : getIsThirdCust().hashCode());
        result = prime * result + ((getThirdCustTypeCd() == null) ? 0 : getThirdCustTypeCd().hashCode());
        result = prime * result + ((getMiddleCode() == null) ? 0 : getMiddleCode().hashCode());
        result = prime * result + ((getWeixinNum() == null) ? 0 : getWeixinNum().hashCode());
        result = prime * result + ((getCommunicationAddress() == null) ? 0 : getCommunicationAddress().hashCode());
        result = prime * result + ((getCommunicationAddressCode() == null) ? 0 : getCommunicationAddressCode().hashCode());
        result = prime * result + ((getLiveAddressCode() == null) ? 0 : getLiveAddressCode().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getUnitAddressCode() == null) ? 0 : getUnitAddressCode().hashCode());
        result = prime * result + ((getAnnualsalary() == null) ? 0 : getAnnualsalary().hashCode());
        result = prime * result + ((getResdntCharCd() == null) ? 0 : getResdntCharCd().hashCode());
        result = prime * result + ((getSchName() == null) ? 0 : getSchName().hashCode());
        result = prime * result + ((getCertCreateDate() == null) ? 0 : getCertCreateDate().hashCode());
        result = prime * result + ((getCertEndDate() == null) ? 0 : getCertEndDate().hashCode());
        result = prime * result + ((getIfcertificate() == null) ? 0 : getIfcertificate().hashCode());
        result = prime * result + ((getNatiflag() == null) ? 0 : getNatiflag().hashCode());
        result = prime * result + ((getNatureOfUnit() == null) ? 0 : getNatureOfUnit().hashCode());
        result = prime * result + ((getScaleOfUnit() == null) ? 0 : getScaleOfUnit().hashCode());
        result = prime * result + ((getFlgSms() == null) ? 0 : getFlgSms().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        return result;
    }
}