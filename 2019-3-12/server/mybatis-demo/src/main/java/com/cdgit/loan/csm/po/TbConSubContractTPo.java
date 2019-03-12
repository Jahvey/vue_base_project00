package com.cdgit.loan.csm.po;

import java.math.BigDecimal;
import java.util.Date;

public class TbConSubContractTPo {//Tb_Con_SubContract_T 担保合同临时表
    private String id;

    private String subcontractId;

    private String subcontractNum;

    private String subcontractManualNum;

    private String subcontractType;

    private String subcontractStatus;

    private String ifTopSubcon;

    private Date signDate;

    private Date beginDate;

    private Date endDate;

    private BigDecimal subcontractAmt;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String partyId;

    private String bz;

    private BigDecimal zgbjxe;

    private BigDecimal jggzrbldj;

    private BigDecimal zfwyjbl;

    private BigDecimal changePercent;

    private BigDecimal jrncrbzj;

    private BigDecimal bzjje;

    private BigDecimal bzjbl;

    private String bzjlx;

    private BigDecimal aylljx;

    private BigDecimal anlljx;

    private BigDecimal jrtzkh;

    private BigDecimal aviAmt;

    private BigDecimal totalAmt;

    private String paperConNum;

    private String bzjjxzq;

    private String conPartyId;

    private String ifDataMove;

    private String status;

    private String qtjsxfs;

    private String proguarantyWay;

    private String proguarantyType;

    private String proguarantyForm;

    private String subScope;

    private BigDecimal dbRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSubcontractId() {
        return subcontractId;
    }

    public void setSubcontractId(String subcontractId) {
        this.subcontractId = subcontractId == null ? null : subcontractId.trim();
    }

    public String getSubcontractNum() {
        return subcontractNum;
    }

    public void setSubcontractNum(String subcontractNum) {
        this.subcontractNum = subcontractNum == null ? null : subcontractNum.trim();
    }

    public String getSubcontractManualNum() {
        return subcontractManualNum;
    }

    public void setSubcontractManualNum(String subcontractManualNum) {
        this.subcontractManualNum = subcontractManualNum == null ? null : subcontractManualNum.trim();
    }

    public String getSubcontractType() {
        return subcontractType;
    }

    public void setSubcontractType(String subcontractType) {
        this.subcontractType = subcontractType == null ? null : subcontractType.trim();
    }

    public String getSubcontractStatus() {
        return subcontractStatus;
    }

    public void setSubcontractStatus(String subcontractStatus) {
        this.subcontractStatus = subcontractStatus == null ? null : subcontractStatus.trim();
    }

    public String getIfTopSubcon() {
        return ifTopSubcon;
    }

    public void setIfTopSubcon(String ifTopSubcon) {
        this.ifTopSubcon = ifTopSubcon == null ? null : ifTopSubcon.trim();
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
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

    public BigDecimal getSubcontractAmt() {
        return subcontractAmt;
    }

    public void setSubcontractAmt(BigDecimal subcontractAmt) {
        this.subcontractAmt = subcontractAmt;
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

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId == null ? null : partyId.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public BigDecimal getZgbjxe() {
        return zgbjxe;
    }

    public void setZgbjxe(BigDecimal zgbjxe) {
        this.zgbjxe = zgbjxe;
    }

    public BigDecimal getJggzrbldj() {
        return jggzrbldj;
    }

    public void setJggzrbldj(BigDecimal jggzrbldj) {
        this.jggzrbldj = jggzrbldj;
    }

    public BigDecimal getZfwyjbl() {
        return zfwyjbl;
    }

    public void setZfwyjbl(BigDecimal zfwyjbl) {
        this.zfwyjbl = zfwyjbl;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(BigDecimal changePercent) {
        this.changePercent = changePercent;
    }

    public BigDecimal getJrncrbzj() {
        return jrncrbzj;
    }

    public void setJrncrbzj(BigDecimal jrncrbzj) {
        this.jrncrbzj = jrncrbzj;
    }

    public BigDecimal getBzjje() {
        return bzjje;
    }

    public void setBzjje(BigDecimal bzjje) {
        this.bzjje = bzjje;
    }

    public BigDecimal getBzjbl() {
        return bzjbl;
    }

    public void setBzjbl(BigDecimal bzjbl) {
        this.bzjbl = bzjbl;
    }

    public String getBzjlx() {
        return bzjlx;
    }

    public void setBzjlx(String bzjlx) {
        this.bzjlx = bzjlx == null ? null : bzjlx.trim();
    }

    public BigDecimal getAylljx() {
        return aylljx;
    }

    public void setAylljx(BigDecimal aylljx) {
        this.aylljx = aylljx;
    }

    public BigDecimal getAnlljx() {
        return anlljx;
    }

    public void setAnlljx(BigDecimal anlljx) {
        this.anlljx = anlljx;
    }

    public BigDecimal getJrtzkh() {
        return jrtzkh;
    }

    public void setJrtzkh(BigDecimal jrtzkh) {
        this.jrtzkh = jrtzkh;
    }

    public BigDecimal getAviAmt() {
        return aviAmt;
    }

    public void setAviAmt(BigDecimal aviAmt) {
        this.aviAmt = aviAmt;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getPaperConNum() {
        return paperConNum;
    }

    public void setPaperConNum(String paperConNum) {
        this.paperConNum = paperConNum == null ? null : paperConNum.trim();
    }

    public String getBzjjxzq() {
        return bzjjxzq;
    }

    public void setBzjjxzq(String bzjjxzq) {
        this.bzjjxzq = bzjjxzq == null ? null : bzjjxzq.trim();
    }

    public String getConPartyId() {
        return conPartyId;
    }

    public void setConPartyId(String conPartyId) {
        this.conPartyId = conPartyId == null ? null : conPartyId.trim();
    }

    public String getIfDataMove() {
        return ifDataMove;
    }

    public void setIfDataMove(String ifDataMove) {
        this.ifDataMove = ifDataMove == null ? null : ifDataMove.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getQtjsxfs() {
        return qtjsxfs;
    }

    public void setQtjsxfs(String qtjsxfs) {
        this.qtjsxfs = qtjsxfs == null ? null : qtjsxfs.trim();
    }

    public String getProguarantyWay() {
        return proguarantyWay;
    }

    public void setProguarantyWay(String proguarantyWay) {
        this.proguarantyWay = proguarantyWay == null ? null : proguarantyWay.trim();
    }

    public String getProguarantyType() {
        return proguarantyType;
    }

    public void setProguarantyType(String proguarantyType) {
        this.proguarantyType = proguarantyType == null ? null : proguarantyType.trim();
    }

    public String getProguarantyForm() {
        return proguarantyForm;
    }

    public void setProguarantyForm(String proguarantyForm) {
        this.proguarantyForm = proguarantyForm == null ? null : proguarantyForm.trim();
    }

    public String getSubScope() {
        return subScope;
    }

    public void setSubScope(String subScope) {
        this.subScope = subScope == null ? null : subScope.trim();
    }

    public BigDecimal getDbRate() {
        return dbRate;
    }

    public void setDbRate(BigDecimal dbRate) {
        this.dbRate = dbRate;
    }

	@Override
	public String toString() {
		return "TbConSubContractTPo [id=" + id + ", subcontractId=" + subcontractId + ", subcontractNum="
				+ subcontractNum + ", subcontractManualNum=" + subcontractManualNum + ", subcontractType="
				+ subcontractType + ", subcontractStatus=" + subcontractStatus + ", ifTopSubcon=" + ifTopSubcon
				+ ", signDate=" + signDate + ", beginDate=" + beginDate + ", endDate=" + endDate + ", subcontractAmt="
				+ subcontractAmt + ", userNum=" + userNum + ", orgNum=" + orgNum + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", partyId=" + partyId + ", bz=" + bz + ", zgbjxe=" + zgbjxe
				+ ", jggzrbldj=" + jggzrbldj + ", zfwyjbl=" + zfwyjbl + ", changePercent=" + changePercent
				+ ", jrncrbzj=" + jrncrbzj + ", bzjje=" + bzjje + ", bzjbl=" + bzjbl + ", bzjlx=" + bzjlx + ", aylljx="
				+ aylljx + ", anlljx=" + anlljx + ", jrtzkh=" + jrtzkh + ", aviAmt=" + aviAmt + ", totalAmt=" + totalAmt
				+ ", paperConNum=" + paperConNum + ", bzjjxzq=" + bzjjxzq + ", conPartyId=" + conPartyId
				+ ", ifDataMove=" + ifDataMove + ", status=" + status + ", qtjsxfs=" + qtjsxfs + ", proguarantyWay="
				+ proguarantyWay + ", proguarantyType=" + proguarantyType + ", proguarantyForm=" + proguarantyForm
				+ ", subScope=" + subScope + ", dbRate=" + dbRate + "]";
	}
	

}
