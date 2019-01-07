/**
 * 
 */
package com.cdgit.loan.csm.bean;

/**
 * @author cwalk
 *
 */
public class CsmNaturalInfoVo {
	
	private String partyNum;                //客户编号
	                                      
	private String ecifPartyNum;            //ECIF客户编号
	                                     
	private String partyName;               //客户名称
	                                       
	private String certType;                //证件类型
	                                    
	private String certNum;                 //证件号码
	                                     
	private String middleCode;              //中征码
	                                        
	private String isPotentialCust;         //是否信贷客户
	                                  
	private String custType;                //个人分类
	                                   
	private String isThirdCust;             //是否第三方客户
	                                  
	private String thirdCustTypeCd;         //第三方客户类型
	                                    
	private String certCreateDate;          //发证日期
	                                   
	private String certEndDate;             //到期日期
	                                       
	private String checkDate;               //长期
	                                       
	//自然人详细信息                    
	private String resdntCharCd;            //居民性质
	                                  
	private String genderCd;                //性别
	                                     
	private String birthday;                //出生日期
	                                   
	private String countrySign;             //国籍
	                                    
	private String nation;                  //民族
	                                    
	private String marriageCd;              //婚姻状况
	                                    
	private String isFarmer;                //是否农户
	                                    
	private String hukouRegisted;           //户籍所在地
	                                    
	private String schName;                 //高校名称/毕业院校名称
	                                   
	private String educationBackgroudCd;    //最高学历
	
	private String degreeCd;                //最高学位
	                                   
	private String profession;              //职业
	                                
	private String professionalTitle;       //职称
	                                     
	private String accountingAssistant;     //职务
	                                  
	private String positionProperty;        //岗位性质
	                                     
	private String natureOfUnit;            //单位性质
	                                    
	private String scaleOfUnit;             //单位规模
	                                     
	private String workYears;               //目前工作持续年限
	                                  
	private String familyNumber;            //家庭人口
	                                  
	private String familyAddress;           //家庭住址
	
	private String houseProperty;           //住宅性质
	                                    
	private String familyPhone;             //家庭电话
	                                    
	private String communicationAddress;    //通讯地址
	                                     
	private String communicationAddressCode;//通讯地址邮编
	                                      
	private String liveAddressCode;         //居住地址邮编
	                                     
	private String industry;                //行业
	                                     
	private String phoneNumber;             //手机号码（短信推送）
	                                    
	private String flgSms;                  //短信推送号码是否核对
	                                   
	private String weixinNum;               //微信号
	                                   
	private String email;                   //电子邮箱
	                                   
	private String workUnit;                //工作单位
	                                 
	private String unitAdress;              //单位地址
	                                     
	private String annualsalary;            //年收入
	                                     
	private String unitPhone;               //单位电话
	                                     
	private String unitAddressCode;         //单位邮编
	                                      
	private String industryDesc;            //行业具体描述
	                                     
	private String jointGuarantee;          //联保小组标志
	                                     
	private String stockholderOfBank;       //我行股东标志
	                                     
	private String isBasebankRelaCust;      //是否我行关联方
	                                     
	private String isGroupCust;             //是否集团成员
	                                      
	private String attachGroupName;         //所属集团客户名称
	                                     
	private String whetherBlackList;        //黑名单标志
	                                       
	private String blackListReason;         //加入黑名单原因
	                                       
	private String isBankEmployee;          //是否本行员工
	                                        
	private String ifcertificate;           //是否有(营业执照)
	                                        
	private String natiflag;                //是否本地人
	                                      
	//系统信息                           
	private String orgNum;                  //经办机构
	                                       
	private String userNum;                 //经办人
	                                        
	private String createTime;              //经办日期

	public String getPartyNum() {
		return partyNum;
	}

	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}

	public String getEcifPartyNum() {
		return ecifPartyNum;
	}

	public void setEcifPartyNum(String ecifPartyNum) {
		this.ecifPartyNum = ecifPartyNum;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getMiddleCode() {
		return middleCode;
	}

	public void setMiddleCode(String middleCode) {
		this.middleCode = middleCode;
	}

	public String getIsPotentialCust() {
		return isPotentialCust;
	}

	public void setIsPotentialCust(String isPotentialCust) {
		this.isPotentialCust = isPotentialCust;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getIsThirdCust() {
		return isThirdCust;
	}

	public void setIsThirdCust(String isThirdCust) {
		this.isThirdCust = isThirdCust;
	}

	public String getThirdCustTypeCd() {
		return thirdCustTypeCd;
	}

	public void setThirdCustTypeCd(String thirdCustTypeCd) {
		this.thirdCustTypeCd = thirdCustTypeCd;
	}

	public String getCertCreateDate() {
		return certCreateDate;
	}

	public void setCertCreateDate(String certCreateDate) {
		this.certCreateDate = certCreateDate;
	}

	public String getCertEndDate() {
		return certEndDate;
	}

	public void setCertEndDate(String certEndDate) {
		this.certEndDate = certEndDate;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getResdntCharCd() {
		return resdntCharCd;
	}

	public void setResdntCharCd(String resdntCharCd) {
		this.resdntCharCd = resdntCharCd;
	}

	public String getGenderCd() {
		return genderCd;
	}

	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCountrySign() {
		return countrySign;
	}

	public void setCountrySign(String countrySign) {
		this.countrySign = countrySign;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getMarriageCd() {
		return marriageCd;
	}

	public void setMarriageCd(String marriageCd) {
		this.marriageCd = marriageCd;
	}

	public String getIsFarmer() {
		return isFarmer;
	}

	public void setIsFarmer(String isFarmer) {
		this.isFarmer = isFarmer;
	}

	public String getHukouRegisted() {
		return hukouRegisted;
	}

	public void setHukouRegisted(String hukouRegisted) {
		this.hukouRegisted = hukouRegisted;
	}

	public String getSchName() {
		return schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}

	public String getEducationBackgroudCd() {
		return educationBackgroudCd;
	}

	public void setEducationBackgroudCd(String educationBackgroudCd) {
		this.educationBackgroudCd = educationBackgroudCd;
	}

	public String getDegreeCd() {
		return degreeCd;
	}

	public void setDegreeCd(String degreeCd) {
		this.degreeCd = degreeCd;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	public String getAccountingAssistant() {
		return accountingAssistant;
	}

	public void setAccountingAssistant(String accountingAssistant) {
		this.accountingAssistant = accountingAssistant;
	}

	public String getPositionProperty() {
		return positionProperty;
	}

	public void setPositionProperty(String positionProperty) {
		this.positionProperty = positionProperty;
	}

	public String getNatureOfUnit() {
		return natureOfUnit;
	}

	public void setNatureOfUnit(String natureOfUnit) {
		this.natureOfUnit = natureOfUnit;
	}

	public String getScaleOfUnit() {
		return scaleOfUnit;
	}

	public void setScaleOfUnit(String scaleOfUnit) {
		this.scaleOfUnit = scaleOfUnit;
	}

	public String getWorkYears() {
		return workYears;
	}

	public void setWorkYears(String workYears) {
		this.workYears = workYears;
	}

	public String getFamilyNumber() {
		return familyNumber;
	}

	public void setFamilyNumber(String familyNumber) {
		this.familyNumber = familyNumber;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getHouseProperty() {
		return houseProperty;
	}

	public void setHouseProperty(String houseProperty) {
		this.houseProperty = houseProperty;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getCommunicationAddress() {
		return communicationAddress;
	}

	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public String getCommunicationAddressCode() {
		return communicationAddressCode;
	}

	public void setCommunicationAddressCode(String communicationAddressCode) {
		this.communicationAddressCode = communicationAddressCode;
	}

	public String getLiveAddressCode() {
		return liveAddressCode;
	}

	public void setLiveAddressCode(String liveAddressCode) {
		this.liveAddressCode = liveAddressCode;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFlgSms() {
		return flgSms;
	}

	public void setFlgSms(String flgSms) {
		this.flgSms = flgSms;
	}

	public String getWeixinNum() {
		return weixinNum;
	}

	public void setWeixinNum(String weixinNum) {
		this.weixinNum = weixinNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getUnitAdress() {
		return unitAdress;
	}

	public void setUnitAdress(String unitAdress) {
		this.unitAdress = unitAdress;
	}

	public String getAnnualsalary() {
		return annualsalary;
	}

	public void setAnnualsalary(String annualsalary) {
		this.annualsalary = annualsalary;
	}

	public String getUnitPhone() {
		return unitPhone;
	}

	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}

	public String getUnitAddressCode() {
		return unitAddressCode;
	}

	public void setUnitAddressCode(String unitAddressCode) {
		this.unitAddressCode = unitAddressCode;
	}

	public String getIndustryDesc() {
		return industryDesc;
	}

	public void setIndustryDesc(String industryDesc) {
		this.industryDesc = industryDesc;
	}

	public String getJointGuarantee() {
		return jointGuarantee;
	}

	public void setJointGuarantee(String jointGuarantee) {
		this.jointGuarantee = jointGuarantee;
	}

	public String getStockholderOfBank() {
		return stockholderOfBank;
	}

	public void setStockholderOfBank(String stockholderOfBank) {
		this.stockholderOfBank = stockholderOfBank;
	}

	public String getIsBasebankRelaCust() {
		return isBasebankRelaCust;
	}

	public void setIsBasebankRelaCust(String isBasebankRelaCust) {
		this.isBasebankRelaCust = isBasebankRelaCust;
	}

	public String getIsGroupCust() {
		return isGroupCust;
	}

	public void setIsGroupCust(String isGroupCust) {
		this.isGroupCust = isGroupCust;
	}

	public String getAttachGroupName() {
		return attachGroupName;
	}

	public void setAttachGroupName(String attachGroupName) {
		this.attachGroupName = attachGroupName;
	}

	public String getWhetherBlackList() {
		return whetherBlackList;
	}

	public void setWhetherBlackList(String whetherBlackList) {
		this.whetherBlackList = whetherBlackList;
	}

	public String getBlackListReason() {
		return blackListReason;
	}

	public void setBlackListReason(String blackListReason) {
		this.blackListReason = blackListReason;
	}

	public String getIsBankEmployee() {
		return isBankEmployee;
	}

	public void setIsBankEmployee(String isBankEmployee) {
		this.isBankEmployee = isBankEmployee;
	}

	public String getIfcertificate() {
		return ifcertificate;
	}

	public void setIfcertificate(String ifcertificate) {
		this.ifcertificate = ifcertificate;
	}

	public String getNatiflag() {
		return natiflag;
	}

	public void setNatiflag(String natiflag) {
		this.natiflag = natiflag;
	}

	public String getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	
	                                        
	
	
	
	
	
	

}
