package com.cdgit.loan.contract.bean;

/**
 * 不是表，这是一个视图，还是生成一个实体类，不一定用得上，先放这里
 * @author Administrator
 *
 */
public class VCsmParty {
	
    private String partyId;

    private String partyNum;					//客户编号

    private String partyName;					//客户名称

    private String partyTypeCd;

    private String isPotentialCust;

    private String examineState;

    private String certType;

    private String certNum;

    private String middleCode;

    private String orgRegisterCd;

    private String registrCd;

    private String unifySocietyCreditNum;

    private String linkmanName;

    private String linkmanPhone;

    private String isThirdCust;

    private String thirdCustTypeCd;

    private String claCustType;

    private String userNum;

    private String orgNum;

    private String ecifPartyNum;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getPartyNum() {
        return partyNum;
    }

    public void setPartyNum(String partyNum) {
        this.partyNum = partyNum == null ? null : partyNum.trim();
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
    }

    public String getPartyTypeCd() {
        return partyTypeCd;
    }

    public void setPartyTypeCd(String partyTypeCd) {
        this.partyTypeCd = partyTypeCd == null ? null : partyTypeCd.trim();
    }

    public String getIsPotentialCust() {
        return isPotentialCust;
    }

    public void setIsPotentialCust(String isPotentialCust) {
        this.isPotentialCust = isPotentialCust == null ? null : isPotentialCust.trim();
    }

    public String getExamineState() {
        return examineState;
    }

    public void setExamineState(String examineState) {
        this.examineState = examineState == null ? null : examineState.trim();
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

    public String getMiddleCode() {
        return middleCode;
    }

    public void setMiddleCode(String middleCode) {
        this.middleCode = middleCode == null ? null : middleCode.trim();
    }

    public String getOrgRegisterCd() {
        return orgRegisterCd;
    }

    public void setOrgRegisterCd(String orgRegisterCd) {
        this.orgRegisterCd = orgRegisterCd == null ? null : orgRegisterCd.trim();
    }

    public String getRegistrCd() {
        return registrCd;
    }

    public void setRegistrCd(String registrCd) {
        this.registrCd = registrCd == null ? null : registrCd.trim();
    }

    public String getUnifySocietyCreditNum() {
        return unifySocietyCreditNum;
    }

    public void setUnifySocietyCreditNum(String unifySocietyCreditNum) {
        this.unifySocietyCreditNum = unifySocietyCreditNum == null ? null : unifySocietyCreditNum.trim();
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName == null ? null : linkmanName.trim();
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone == null ? null : linkmanPhone.trim();
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

    public String getClaCustType() {
        return claCustType;
    }

    public void setClaCustType(String claCustType) {
        this.claCustType = claCustType == null ? null : claCustType.trim();
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    public String getEcifPartyNum() {
        return ecifPartyNum;
    }

    public void setEcifPartyNum(String ecifPartyNum) {
        this.ecifPartyNum = ecifPartyNum == null ? null : ecifPartyNum.trim();
    }
}