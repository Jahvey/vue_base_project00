package com.cdgit.loan.customerManage.bean;

import java.math.BigDecimal;
import java.util.Date;

public class SubContract {
    private String subcontractId;

    private String subcontractNum;

    private String subcontractManualNum;

    private String subcontractType;

    private String subcontractStatus;

    private String ifTopSubcon;

    private Date signDate;

    private String beginDate;

    private String endDate;

    private BigDecimal subcontractAmt;

    private String userNum;

    private String orgNum;

    private Date createTime;

    private Date updateTime;

    private String partyId;

    private String bz;

    private BigDecimal zgbjxe;

    private Short jggzrbldj;

    private BigDecimal zfwyjbl;

    private BigDecimal changePercent;

    private Short jrncrbzj;

    private BigDecimal bzjje;

    private BigDecimal bzjbl;

    private String bzjlx;

    private BigDecimal aylljx;

    private BigDecimal anlljx;

    private Short jrtzkh;

    private BigDecimal aviAmt;

    private BigDecimal totalAmt;

    private String paperConNum;

    private String bzjjxzq;

    private String conPartyId;

    private String ifDataMove;

    private String qtjsxfs;

    private String proguarantyWay;

    private String proguarantyType;

    private String proguarantyForm;

    private String subScope;

    private BigDecimal dbRate;
    
    //查询字段
    private String partyName;

    private String productType;

    private String currencyCd;
    
    private String contractNum;
    
    private BigDecimal subContractSum;
    
    private String collType;
    
    private String sortType;
    
    private String conYuE;

    private String status;
    
    
    public String getCollType() {
		return collType;
	}

	public void setCollType(String collType) {
		this.collType = collType;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getConYuE() {
		return conYuE;
	}

	public void setConYuE(String conYuE) {
		this.conYuE = conYuE;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public BigDecimal getSubContractSum() {
		return subContractSum;
	}

	public void setSubContractSum(BigDecimal subContractSum) {
		this.subContractSum = subContractSum;
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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    public Short getJggzrbldj() {
        return jggzrbldj;
    }

    public void setJggzrbldj(Short jggzrbldj) {
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

    public Short getJrncrbzj() {
        return jrncrbzj;
    }

    public void setJrncrbzj(Short jrncrbzj) {
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

    public Short getJrtzkh() {
        return jrtzkh;
    }

    public void setJrtzkh(Short jrtzkh) {
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
        SubContract other = (SubContract) that;
        return (this.getSubcontractId() == null ? other.getSubcontractId() == null : this.getSubcontractId().equals(other.getSubcontractId()))
            && (this.getSubcontractNum() == null ? other.getSubcontractNum() == null : this.getSubcontractNum().equals(other.getSubcontractNum()))
            && (this.getSubcontractManualNum() == null ? other.getSubcontractManualNum() == null : this.getSubcontractManualNum().equals(other.getSubcontractManualNum()))
            && (this.getSubcontractType() == null ? other.getSubcontractType() == null : this.getSubcontractType().equals(other.getSubcontractType()))
            && (this.getSubcontractStatus() == null ? other.getSubcontractStatus() == null : this.getSubcontractStatus().equals(other.getSubcontractStatus()))
            && (this.getIfTopSubcon() == null ? other.getIfTopSubcon() == null : this.getIfTopSubcon().equals(other.getIfTopSubcon()))
            && (this.getSignDate() == null ? other.getSignDate() == null : this.getSignDate().equals(other.getSignDate()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getSubcontractAmt() == null ? other.getSubcontractAmt() == null : this.getSubcontractAmt().equals(other.getSubcontractAmt()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPartyId() == null ? other.getPartyId() == null : this.getPartyId().equals(other.getPartyId()))
            && (this.getBz() == null ? other.getBz() == null : this.getBz().equals(other.getBz()))
            && (this.getZgbjxe() == null ? other.getZgbjxe() == null : this.getZgbjxe().equals(other.getZgbjxe()))
            && (this.getJggzrbldj() == null ? other.getJggzrbldj() == null : this.getJggzrbldj().equals(other.getJggzrbldj()))
            && (this.getZfwyjbl() == null ? other.getZfwyjbl() == null : this.getZfwyjbl().equals(other.getZfwyjbl()))
            && (this.getChangePercent() == null ? other.getChangePercent() == null : this.getChangePercent().equals(other.getChangePercent()))
            && (this.getJrncrbzj() == null ? other.getJrncrbzj() == null : this.getJrncrbzj().equals(other.getJrncrbzj()))
            && (this.getBzjje() == null ? other.getBzjje() == null : this.getBzjje().equals(other.getBzjje()))
            && (this.getBzjbl() == null ? other.getBzjbl() == null : this.getBzjbl().equals(other.getBzjbl()))
            && (this.getBzjlx() == null ? other.getBzjlx() == null : this.getBzjlx().equals(other.getBzjlx()))
            && (this.getAylljx() == null ? other.getAylljx() == null : this.getAylljx().equals(other.getAylljx()))
            && (this.getAnlljx() == null ? other.getAnlljx() == null : this.getAnlljx().equals(other.getAnlljx()))
            && (this.getJrtzkh() == null ? other.getJrtzkh() == null : this.getJrtzkh().equals(other.getJrtzkh()))
            && (this.getAviAmt() == null ? other.getAviAmt() == null : this.getAviAmt().equals(other.getAviAmt()))
            && (this.getTotalAmt() == null ? other.getTotalAmt() == null : this.getTotalAmt().equals(other.getTotalAmt()))
            && (this.getPaperConNum() == null ? other.getPaperConNum() == null : this.getPaperConNum().equals(other.getPaperConNum()))
            && (this.getBzjjxzq() == null ? other.getBzjjxzq() == null : this.getBzjjxzq().equals(other.getBzjjxzq()))
            && (this.getConPartyId() == null ? other.getConPartyId() == null : this.getConPartyId().equals(other.getConPartyId()))
            && (this.getIfDataMove() == null ? other.getIfDataMove() == null : this.getIfDataMove().equals(other.getIfDataMove()))
            && (this.getQtjsxfs() == null ? other.getQtjsxfs() == null : this.getQtjsxfs().equals(other.getQtjsxfs()))
            && (this.getProguarantyWay() == null ? other.getProguarantyWay() == null : this.getProguarantyWay().equals(other.getProguarantyWay()))
            && (this.getProguarantyType() == null ? other.getProguarantyType() == null : this.getProguarantyType().equals(other.getProguarantyType()))
            && (this.getProguarantyForm() == null ? other.getProguarantyForm() == null : this.getProguarantyForm().equals(other.getProguarantyForm()))
            && (this.getSubScope() == null ? other.getSubScope() == null : this.getSubScope().equals(other.getSubScope()))
            && (this.getDbRate() == null ? other.getDbRate() == null : this.getDbRate().equals(other.getDbRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSubcontractId() == null) ? 0 : getSubcontractId().hashCode());
        result = prime * result + ((getSubcontractNum() == null) ? 0 : getSubcontractNum().hashCode());
        result = prime * result + ((getSubcontractManualNum() == null) ? 0 : getSubcontractManualNum().hashCode());
        result = prime * result + ((getSubcontractType() == null) ? 0 : getSubcontractType().hashCode());
        result = prime * result + ((getSubcontractStatus() == null) ? 0 : getSubcontractStatus().hashCode());
        result = prime * result + ((getIfTopSubcon() == null) ? 0 : getIfTopSubcon().hashCode());
        result = prime * result + ((getSignDate() == null) ? 0 : getSignDate().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getSubcontractAmt() == null) ? 0 : getSubcontractAmt().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPartyId() == null) ? 0 : getPartyId().hashCode());
        result = prime * result + ((getBz() == null) ? 0 : getBz().hashCode());
        result = prime * result + ((getZgbjxe() == null) ? 0 : getZgbjxe().hashCode());
        result = prime * result + ((getJggzrbldj() == null) ? 0 : getJggzrbldj().hashCode());
        result = prime * result + ((getZfwyjbl() == null) ? 0 : getZfwyjbl().hashCode());
        result = prime * result + ((getChangePercent() == null) ? 0 : getChangePercent().hashCode());
        result = prime * result + ((getJrncrbzj() == null) ? 0 : getJrncrbzj().hashCode());
        result = prime * result + ((getBzjje() == null) ? 0 : getBzjje().hashCode());
        result = prime * result + ((getBzjbl() == null) ? 0 : getBzjbl().hashCode());
        result = prime * result + ((getBzjlx() == null) ? 0 : getBzjlx().hashCode());
        result = prime * result + ((getAylljx() == null) ? 0 : getAylljx().hashCode());
        result = prime * result + ((getAnlljx() == null) ? 0 : getAnlljx().hashCode());
        result = prime * result + ((getJrtzkh() == null) ? 0 : getJrtzkh().hashCode());
        result = prime * result + ((getAviAmt() == null) ? 0 : getAviAmt().hashCode());
        result = prime * result + ((getTotalAmt() == null) ? 0 : getTotalAmt().hashCode());
        result = prime * result + ((getPaperConNum() == null) ? 0 : getPaperConNum().hashCode());
        result = prime * result + ((getBzjjxzq() == null) ? 0 : getBzjjxzq().hashCode());
        result = prime * result + ((getConPartyId() == null) ? 0 : getConPartyId().hashCode());
        result = prime * result + ((getIfDataMove() == null) ? 0 : getIfDataMove().hashCode());
        result = prime * result + ((getQtjsxfs() == null) ? 0 : getQtjsxfs().hashCode());
        result = prime * result + ((getProguarantyWay() == null) ? 0 : getProguarantyWay().hashCode());
        result = prime * result + ((getProguarantyType() == null) ? 0 : getProguarantyType().hashCode());
        result = prime * result + ((getProguarantyForm() == null) ? 0 : getProguarantyForm().hashCode());
        result = prime * result + ((getSubScope() == null) ? 0 : getSubScope().hashCode());
        result = prime * result + ((getDbRate() == null) ? 0 : getDbRate().hashCode());
        return result;
    }
}