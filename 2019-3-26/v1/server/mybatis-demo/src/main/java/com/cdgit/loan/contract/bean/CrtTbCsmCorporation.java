package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Tb_Csm_Corporation：公司客户
 * @author mch
 *
 */
public class CrtTbCsmCorporation {
	
    private String partyId;						//客户id

    private String corpCustomerTypeCd;			//客户性质(:XD_KHCD0252)

    private String englishName;					//英文名称

    private String economicSectorCode;			//企业出资人经济成分(:CDKH0028)

    private String industrialTypeCd;			//行业门类(:CDKH0095)

    private String listingCorporation;			//是否上市公司(:YesOrNo)

    private BigDecimal registerAssets;			//注册资本

    private String registerAssetsCurrencyCd;	//注册资本币种(:CD000001)

    private Long employeesNumber;				//从业人数

    private String governmentTentNo;			//地税登记证号码

    private Date creditRelationshipTime;		//与我行建立信贷关系时间

    private Date registerDate;					//注册登记日期

    private String legalCertificateNo;			//法人代表证件号码

    private Date legalCertificateEndDate;		//法人代表证件到期日

    private String registrationType;			//登记注册类型(:CDKH0024)

    private String updateUserNum;				//更新人

    private String updateOrgNum;				//更新机构

    private Date updateTime;					//更新时间

    private String areaType;					//区域类型-境内外(:XD_KHCD0210)

    private String contryRegionCd;				//国家或地区(:CD000003)

    private String legalName;					//法人代表名称

    private String legalCertType;				//法人代表证件类型(:CDKH0002)

    private String registrCd;					//注册登记号码

    private Date registerEndDate;				//营业执照到期日

    private String businessScope;				//经营范围

    private String orgRegisterCd;				//组织机构代码

    private Date orgRegisterEndDate;			//组织机构代码到期日

    private String middelCode;					//中征码

    private String orgCreditCode;				//机构信用代码

    private String nationalTaxNo;				//国税登记证号码

    private String industrialTypeBigCd;			//行业大类(:CDKH0095)

    private String industrialTypeMidCd;			//行业中类(:CDKH0095)

    private String industrialTypeSamllCd;		//行业小类(:CDKH0095)

    private String enterpriseScaleGx;			//工信部企业规模(:CDKH0027)

    private String countBoreEnterScale;			//统计口径企业规模(:CDKH0027)

    private String isGroupCust;					//统一授信客户成员标志(:YesOrNo)

    private String attachGroupName;				//所属集团名称(:YesOrNo)

    private String whetherImpExp;				//进出口权标志(:YesOrNo)

    private String stockholderOfBank;			//我行股东标志(:YesOrNo)

    private String jointGuarantee;				//联保小组标志(:YesOrNo)

    private String familyEnterprise;			//家族企业标志(:YesOrNo)

    private String whetherGovernmentFinanceCor;	//融资平台标志(:YesOrNo)

    private String countrysideEnterprise;		//农村企业标志(:YesOrNo)

    private String whetherBlackList;			//黑名单标志(:YesOrNo)

    private String focusCustomer;				//重点客户标志(:YesOrNo)

    private String isRealEstateDev;				//是否从事房地产开发(:YesOrNo)

    private Date createtime;					//客户登记日期

    private String fundSrc;						//经费来源

    private BigDecimal openFund;				//开办资金

    private String isBasebankRelaCust;			//是否我行关联方(:YesOrNo)

    private String thirdCustTypeCd;				//第三方客户类型(:XD_KHCD7001)

    private String isThirdCust;					//是否第三方客户(:YesOrNo)

    private Date enterpriseCertEndDate;			//事业法人证书到期日

    private String enterpriseCertNum;			//事业法人证书号

    private String unifySocietyCreditNum;		//统一社会信用代码

    private String singleLpCustInd;				//单一法人客户标志

    private String stopCorpInd;					//关停企业标志

    private String legalContry;					//法人代表名称

    private String bankScaleIdentify;			//银行认定企业规模(:CDKH0027)

    private String legalPhoneNumber;			//法人代表联系电话

    private Date legalRegistDate;				//证件签发日期

    private String legalContrySign;				//法人代表国籍

    private String whetherTechnic;				//是否科技型企业(YesOrNo)

    private String whetherGreenGroup;			//是否绿色信贷企业(YesOrNo)

    private String whetherJmrh;					//是否军民融合企业(YesOrNo)

    private String whetherArgRelated;			//是否涉农型企业(YesOrNo)

    private String whetherOpenAcct;				//是否在我行开立基本账户(YesOrNo)

    private String whetherPovertyAdd;			//是否扶贫企业(YesOrNo)

    private String area;						//经营场地面积(平方米)

    private String owner;						//经营场地所有权(CDJYSYQ00)

    private String nationalEconomyType;			//国民经济部门类型(ECIF_GMJJBMLX01)

    private String chainSign;					//供应链客户标志

    private String mainCustTypeCd;				//客户主体类型(ECIF_KHZTLX0001)

    private String orgStatus;					//机构状态(CDZZ0004)

    private String ifCsy;

    private String loanTurn;					//行业投向

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getCorpCustomerTypeCd() {
        return corpCustomerTypeCd;
    }

    public void setCorpCustomerTypeCd(String corpCustomerTypeCd) {
        this.corpCustomerTypeCd = corpCustomerTypeCd == null ? null : corpCustomerTypeCd.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getEconomicSectorCode() {
        return economicSectorCode;
    }

    public void setEconomicSectorCode(String economicSectorCode) {
        this.economicSectorCode = economicSectorCode == null ? null : economicSectorCode.trim();
    }

    public String getIndustrialTypeCd() {
        return industrialTypeCd;
    }

    public void setIndustrialTypeCd(String industrialTypeCd) {
        this.industrialTypeCd = industrialTypeCd == null ? null : industrialTypeCd.trim();
    }

    public String getListingCorporation() {
        return listingCorporation;
    }

    public void setListingCorporation(String listingCorporation) {
        this.listingCorporation = listingCorporation == null ? null : listingCorporation.trim();
    }

    public BigDecimal getRegisterAssets() {
        return registerAssets;
    }

    public void setRegisterAssets(BigDecimal registerAssets) {
        this.registerAssets = registerAssets;
    }

    public String getRegisterAssetsCurrencyCd() {
        return registerAssetsCurrencyCd;
    }

    public void setRegisterAssetsCurrencyCd(String registerAssetsCurrencyCd) {
        this.registerAssetsCurrencyCd = registerAssetsCurrencyCd == null ? null : registerAssetsCurrencyCd.trim();
    }

    public Long getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Long employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getGovernmentTentNo() {
        return governmentTentNo;
    }

    public void setGovernmentTentNo(String governmentTentNo) {
        this.governmentTentNo = governmentTentNo == null ? null : governmentTentNo.trim();
    }

    public Date getCreditRelationshipTime() {
        return creditRelationshipTime;
    }

    public void setCreditRelationshipTime(Date creditRelationshipTime) {
        this.creditRelationshipTime = creditRelationshipTime;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getLegalCertificateNo() {
        return legalCertificateNo;
    }

    public void setLegalCertificateNo(String legalCertificateNo) {
        this.legalCertificateNo = legalCertificateNo == null ? null : legalCertificateNo.trim();
    }

    public Date getLegalCertificateEndDate() {
        return legalCertificateEndDate;
    }

    public void setLegalCertificateEndDate(Date legalCertificateEndDate) {
        this.legalCertificateEndDate = legalCertificateEndDate;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType == null ? null : registrationType.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType == null ? null : areaType.trim();
    }

    public String getContryRegionCd() {
        return contryRegionCd;
    }

    public void setContryRegionCd(String contryRegionCd) {
        this.contryRegionCd = contryRegionCd == null ? null : contryRegionCd.trim();
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    public String getLegalCertType() {
        return legalCertType;
    }

    public void setLegalCertType(String legalCertType) {
        this.legalCertType = legalCertType == null ? null : legalCertType.trim();
    }

    public String getRegistrCd() {
        return registrCd;
    }

    public void setRegistrCd(String registrCd) {
        this.registrCd = registrCd == null ? null : registrCd.trim();
    }

    public Date getRegisterEndDate() {
        return registerEndDate;
    }

    public void setRegisterEndDate(Date registerEndDate) {
        this.registerEndDate = registerEndDate;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getOrgRegisterCd() {
        return orgRegisterCd;
    }

    public void setOrgRegisterCd(String orgRegisterCd) {
        this.orgRegisterCd = orgRegisterCd == null ? null : orgRegisterCd.trim();
    }

    public Date getOrgRegisterEndDate() {
        return orgRegisterEndDate;
    }

    public void setOrgRegisterEndDate(Date orgRegisterEndDate) {
        this.orgRegisterEndDate = orgRegisterEndDate;
    }

    public String getMiddelCode() {
        return middelCode;
    }

    public void setMiddelCode(String middelCode) {
        this.middelCode = middelCode == null ? null : middelCode.trim();
    }

    public String getOrgCreditCode() {
        return orgCreditCode;
    }

    public void setOrgCreditCode(String orgCreditCode) {
        this.orgCreditCode = orgCreditCode == null ? null : orgCreditCode.trim();
    }

    public String getNationalTaxNo() {
        return nationalTaxNo;
    }

    public void setNationalTaxNo(String nationalTaxNo) {
        this.nationalTaxNo = nationalTaxNo == null ? null : nationalTaxNo.trim();
    }

    public String getIndustrialTypeBigCd() {
        return industrialTypeBigCd;
    }

    public void setIndustrialTypeBigCd(String industrialTypeBigCd) {
        this.industrialTypeBigCd = industrialTypeBigCd == null ? null : industrialTypeBigCd.trim();
    }

    public String getIndustrialTypeMidCd() {
        return industrialTypeMidCd;
    }

    public void setIndustrialTypeMidCd(String industrialTypeMidCd) {
        this.industrialTypeMidCd = industrialTypeMidCd == null ? null : industrialTypeMidCd.trim();
    }

    public String getIndustrialTypeSamllCd() {
        return industrialTypeSamllCd;
    }

    public void setIndustrialTypeSamllCd(String industrialTypeSamllCd) {
        this.industrialTypeSamllCd = industrialTypeSamllCd == null ? null : industrialTypeSamllCd.trim();
    }

    public String getEnterpriseScaleGx() {
        return enterpriseScaleGx;
    }

    public void setEnterpriseScaleGx(String enterpriseScaleGx) {
        this.enterpriseScaleGx = enterpriseScaleGx == null ? null : enterpriseScaleGx.trim();
    }

    public String getCountBoreEnterScale() {
        return countBoreEnterScale;
    }

    public void setCountBoreEnterScale(String countBoreEnterScale) {
        this.countBoreEnterScale = countBoreEnterScale == null ? null : countBoreEnterScale.trim();
    }

    public String getIsGroupCust() {
        return isGroupCust;
    }

    public void setIsGroupCust(String isGroupCust) {
        this.isGroupCust = isGroupCust == null ? null : isGroupCust.trim();
    }

    public String getAttachGroupName() {
        return attachGroupName;
    }

    public void setAttachGroupName(String attachGroupName) {
        this.attachGroupName = attachGroupName == null ? null : attachGroupName.trim();
    }

    public String getWhetherImpExp() {
        return whetherImpExp;
    }

    public void setWhetherImpExp(String whetherImpExp) {
        this.whetherImpExp = whetherImpExp == null ? null : whetherImpExp.trim();
    }

    public String getStockholderOfBank() {
        return stockholderOfBank;
    }

    public void setStockholderOfBank(String stockholderOfBank) {
        this.stockholderOfBank = stockholderOfBank == null ? null : stockholderOfBank.trim();
    }

    public String getJointGuarantee() {
        return jointGuarantee;
    }

    public void setJointGuarantee(String jointGuarantee) {
        this.jointGuarantee = jointGuarantee == null ? null : jointGuarantee.trim();
    }

    public String getFamilyEnterprise() {
        return familyEnterprise;
    }

    public void setFamilyEnterprise(String familyEnterprise) {
        this.familyEnterprise = familyEnterprise == null ? null : familyEnterprise.trim();
    }

    public String getWhetherGovernmentFinanceCor() {
        return whetherGovernmentFinanceCor;
    }

    public void setWhetherGovernmentFinanceCor(String whetherGovernmentFinanceCor) {
        this.whetherGovernmentFinanceCor = whetherGovernmentFinanceCor == null ? null : whetherGovernmentFinanceCor.trim();
    }

    public String getCountrysideEnterprise() {
        return countrysideEnterprise;
    }

    public void setCountrysideEnterprise(String countrysideEnterprise) {
        this.countrysideEnterprise = countrysideEnterprise == null ? null : countrysideEnterprise.trim();
    }

    public String getWhetherBlackList() {
        return whetherBlackList;
    }

    public void setWhetherBlackList(String whetherBlackList) {
        this.whetherBlackList = whetherBlackList == null ? null : whetherBlackList.trim();
    }

    public String getFocusCustomer() {
        return focusCustomer;
    }

    public void setFocusCustomer(String focusCustomer) {
        this.focusCustomer = focusCustomer == null ? null : focusCustomer.trim();
    }

    public String getIsRealEstateDev() {
        return isRealEstateDev;
    }

    public void setIsRealEstateDev(String isRealEstateDev) {
        this.isRealEstateDev = isRealEstateDev == null ? null : isRealEstateDev.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFundSrc() {
        return fundSrc;
    }

    public void setFundSrc(String fundSrc) {
        this.fundSrc = fundSrc == null ? null : fundSrc.trim();
    }

    public BigDecimal getOpenFund() {
        return openFund;
    }

    public void setOpenFund(BigDecimal openFund) {
        this.openFund = openFund;
    }

    public String getIsBasebankRelaCust() {
        return isBasebankRelaCust;
    }

    public void setIsBasebankRelaCust(String isBasebankRelaCust) {
        this.isBasebankRelaCust = isBasebankRelaCust == null ? null : isBasebankRelaCust.trim();
    }

    public String getThirdCustTypeCd() {
        return thirdCustTypeCd;
    }

    public void setThirdCustTypeCd(String thirdCustTypeCd) {
        this.thirdCustTypeCd = thirdCustTypeCd == null ? null : thirdCustTypeCd.trim();
    }

    public String getIsThirdCust() {
        return isThirdCust;
    }

    public void setIsThirdCust(String isThirdCust) {
        this.isThirdCust = isThirdCust == null ? null : isThirdCust.trim();
    }

    public Date getEnterpriseCertEndDate() {
        return enterpriseCertEndDate;
    }

    public void setEnterpriseCertEndDate(Date enterpriseCertEndDate) {
        this.enterpriseCertEndDate = enterpriseCertEndDate;
    }

    public String getEnterpriseCertNum() {
        return enterpriseCertNum;
    }

    public void setEnterpriseCertNum(String enterpriseCertNum) {
        this.enterpriseCertNum = enterpriseCertNum == null ? null : enterpriseCertNum.trim();
    }

    public String getUnifySocietyCreditNum() {
        return unifySocietyCreditNum;
    }

    public void setUnifySocietyCreditNum(String unifySocietyCreditNum) {
        this.unifySocietyCreditNum = unifySocietyCreditNum == null ? null : unifySocietyCreditNum.trim();
    }

    public String getSingleLpCustInd() {
        return singleLpCustInd;
    }

    public void setSingleLpCustInd(String singleLpCustInd) {
        this.singleLpCustInd = singleLpCustInd == null ? null : singleLpCustInd.trim();
    }

    public String getStopCorpInd() {
        return stopCorpInd;
    }

    public void setStopCorpInd(String stopCorpInd) {
        this.stopCorpInd = stopCorpInd == null ? null : stopCorpInd.trim();
    }

    public String getLegalContry() {
        return legalContry;
    }

    public void setLegalContry(String legalContry) {
        this.legalContry = legalContry == null ? null : legalContry.trim();
    }

    public String getBankScaleIdentify() {
        return bankScaleIdentify;
    }

    public void setBankScaleIdentify(String bankScaleIdentify) {
        this.bankScaleIdentify = bankScaleIdentify == null ? null : bankScaleIdentify.trim();
    }

    public String getLegalPhoneNumber() {
        return legalPhoneNumber;
    }

    public void setLegalPhoneNumber(String legalPhoneNumber) {
        this.legalPhoneNumber = legalPhoneNumber == null ? null : legalPhoneNumber.trim();
    }

    public Date getLegalRegistDate() {
        return legalRegistDate;
    }

    public void setLegalRegistDate(Date legalRegistDate) {
        this.legalRegistDate = legalRegistDate;
    }

    public String getLegalContrySign() {
        return legalContrySign;
    }

    public void setLegalContrySign(String legalContrySign) {
        this.legalContrySign = legalContrySign == null ? null : legalContrySign.trim();
    }

    public String getWhetherTechnic() {
        return whetherTechnic;
    }

    public void setWhetherTechnic(String whetherTechnic) {
        this.whetherTechnic = whetherTechnic == null ? null : whetherTechnic.trim();
    }

    public String getWhetherGreenGroup() {
        return whetherGreenGroup;
    }

    public void setWhetherGreenGroup(String whetherGreenGroup) {
        this.whetherGreenGroup = whetherGreenGroup == null ? null : whetherGreenGroup.trim();
    }

    public String getWhetherJmrh() {
        return whetherJmrh;
    }

    public void setWhetherJmrh(String whetherJmrh) {
        this.whetherJmrh = whetherJmrh == null ? null : whetherJmrh.trim();
    }

    public String getWhetherArgRelated() {
        return whetherArgRelated;
    }

    public void setWhetherArgRelated(String whetherArgRelated) {
        this.whetherArgRelated = whetherArgRelated == null ? null : whetherArgRelated.trim();
    }

    public String getWhetherOpenAcct() {
        return whetherOpenAcct;
    }

    public void setWhetherOpenAcct(String whetherOpenAcct) {
        this.whetherOpenAcct = whetherOpenAcct == null ? null : whetherOpenAcct.trim();
    }

    public String getWhetherPovertyAdd() {
        return whetherPovertyAdd;
    }

    public void setWhetherPovertyAdd(String whetherPovertyAdd) {
        this.whetherPovertyAdd = whetherPovertyAdd == null ? null : whetherPovertyAdd.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getNationalEconomyType() {
        return nationalEconomyType;
    }

    public void setNationalEconomyType(String nationalEconomyType) {
        this.nationalEconomyType = nationalEconomyType == null ? null : nationalEconomyType.trim();
    }

    public String getChainSign() {
        return chainSign;
    }

    public void setChainSign(String chainSign) {
        this.chainSign = chainSign == null ? null : chainSign.trim();
    }

    public String getMainCustTypeCd() {
        return mainCustTypeCd;
    }

    public void setMainCustTypeCd(String mainCustTypeCd) {
        this.mainCustTypeCd = mainCustTypeCd == null ? null : mainCustTypeCd.trim();
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus == null ? null : orgStatus.trim();
    }

    public String getIfCsy() {
        return ifCsy;
    }

    public void setIfCsy(String ifCsy) {
        this.ifCsy = ifCsy == null ? null : ifCsy.trim();
    }

    public String getLoanTurn() {
        return loanTurn;
    }

    public void setLoanTurn(String loanTurn) {
        this.loanTurn = loanTurn == null ? null : loanTurn.trim();
    }
}