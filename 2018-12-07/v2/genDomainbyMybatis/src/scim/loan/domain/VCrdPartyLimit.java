package scim.loan.domain;

import java.math.BigDecimal;
import java.util.Date;

public class VCrdPartyLimit {
    private String partyId;

    private String limitId;

    private String limitType;

    private BigDecimal creditAmt;

    private BigDecimal usedAmt;

    private BigDecimal usedAmtReal;

    private BigDecimal availableAmt;

    private BigDecimal availableAmtReal;

    private String partyName;

    private String certType;

    private String certNum;

    private String userNum;

    private String orgNum;

    private Date beginDate;

    private Date endDate;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId == null ? null : limitId.trim();
    }

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }

    public BigDecimal getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(BigDecimal creditAmt) {
        this.creditAmt = creditAmt;
    }

    public BigDecimal getUsedAmt() {
        return usedAmt;
    }

    public void setUsedAmt(BigDecimal usedAmt) {
        this.usedAmt = usedAmt;
    }

    public BigDecimal getUsedAmtReal() {
        return usedAmtReal;
    }

    public void setUsedAmtReal(BigDecimal usedAmtReal) {
        this.usedAmtReal = usedAmtReal;
    }

    public BigDecimal getAvailableAmt() {
        return availableAmt;
    }

    public void setAvailableAmt(BigDecimal availableAmt) {
        this.availableAmt = availableAmt;
    }

    public BigDecimal getAvailableAmtReal() {
        return availableAmtReal;
    }

    public void setAvailableAmtReal(BigDecimal availableAmtReal) {
        this.availableAmtReal = availableAmtReal;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}