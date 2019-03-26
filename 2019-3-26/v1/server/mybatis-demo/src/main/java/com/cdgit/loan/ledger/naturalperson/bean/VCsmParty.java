package com.cdgit.loan.ledger.naturalperson.bean;

public class VCsmParty {
    private String partyId;

    private String partyNum;

    private String partyName;

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
        VCsmParty other = (VCsmParty) that;
        return (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getPartyNum() == null ? other.getPartyNum() == null : this.getPartyNum().equals(other.getPartyNum()))
            && (this.getPartyName() == null ? other.getPartyName() == null : this.getPartyName().equals(other.getPartyName()))
            && (this.getPartyTypeCd() == null ? other.getPartyTypeCd() == null : this.getPartyTypeCd().equals(other.getPartyTypeCd()))
            && (this.getIsPotentialCust() == null ? other.getIsPotentialCust() == null : this.getIsPotentialCust().equals(other.getIsPotentialCust()))
            && (this.getExamineState() == null ? other.getExamineState() == null : this.getExamineState().equals(other.getExamineState()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getCertNum() == null ? other.getCertNum() == null : this.getCertNum().equals(other.getCertNum()))
            && (this.getMiddleCode() == null ? other.getMiddleCode() == null : this.getMiddleCode().equals(other.getMiddleCode()))
            && (this.getOrgRegisterCd() == null ? other.getOrgRegisterCd() == null : this.getOrgRegisterCd().equals(other.getOrgRegisterCd()))
            && (this.getRegistrCd() == null ? other.getRegistrCd() == null : this.getRegistrCd().equals(other.getRegistrCd()))
            && (this.getUnifySocietyCreditNum() == null ? other.getUnifySocietyCreditNum() == null : this.getUnifySocietyCreditNum().equals(other.getUnifySocietyCreditNum()))
            && (this.getLinkmanName() == null ? other.getLinkmanName() == null : this.getLinkmanName().equals(other.getLinkmanName()))
            && (this.getLinkmanPhone() == null ? other.getLinkmanPhone() == null : this.getLinkmanPhone().equals(other.getLinkmanPhone()))
            && (this.getIsThirdCust() == null ? other.getIsThirdCust() == null : this.getIsThirdCust().equals(other.getIsThirdCust()))
            && (this.getThirdCustTypeCd() == null ? other.getThirdCustTypeCd() == null : this.getThirdCustTypeCd().equals(other.getThirdCustTypeCd()))
            && (this.getClaCustType() == null ? other.getClaCustType() == null : this.getClaCustType().equals(other.getClaCustType()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getEcifPartyNum() == null ? other.getEcifPartyNum() == null : this.getEcifPartyNum().equals(other.getEcifPartyNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getPartyNum() == null) ? 0 : getPartyNum().hashCode());
        result = prime * result + ((getPartyName() == null) ? 0 : getPartyName().hashCode());
        result = prime * result + ((getPartyTypeCd() == null) ? 0 : getPartyTypeCd().hashCode());
        result = prime * result + ((getIsPotentialCust() == null) ? 0 : getIsPotentialCust().hashCode());
        result = prime * result + ((getExamineState() == null) ? 0 : getExamineState().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNum() == null) ? 0 : getCertNum().hashCode());
        result = prime * result + ((getMiddleCode() == null) ? 0 : getMiddleCode().hashCode());
        result = prime * result + ((getOrgRegisterCd() == null) ? 0 : getOrgRegisterCd().hashCode());
        result = prime * result + ((getRegistrCd() == null) ? 0 : getRegistrCd().hashCode());
        result = prime * result + ((getUnifySocietyCreditNum() == null) ? 0 : getUnifySocietyCreditNum().hashCode());
        result = prime * result + ((getLinkmanName() == null) ? 0 : getLinkmanName().hashCode());
        result = prime * result + ((getLinkmanPhone() == null) ? 0 : getLinkmanPhone().hashCode());
        result = prime * result + ((getIsThirdCust() == null) ? 0 : getIsThirdCust().hashCode());
        result = prime * result + ((getThirdCustTypeCd() == null) ? 0 : getThirdCustTypeCd().hashCode());
        result = prime * result + ((getClaCustType() == null) ? 0 : getClaCustType().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getEcifPartyNum() == null) ? 0 : getEcifPartyNum().hashCode());
        return result;
    }
}