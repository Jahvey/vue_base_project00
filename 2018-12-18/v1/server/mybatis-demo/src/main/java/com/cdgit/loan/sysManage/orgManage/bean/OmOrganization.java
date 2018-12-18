package com.cdgit.loan.sysManage.orgManage.bean;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class OmOrganization {
    private Long orgid;

    private String orgcode;

    private String orgname;

    private Short orglevel;

    private String orgdegree;

    private Long parentorgid;

    private String orgseq;

    private String orgtype;

    private String orgaddr;

    private String zipcode;

    private Long manaposition;

    private Long managerid;

    private String orgmanager;

    private String linkman;

    private String linktel;

    private String email;

    private String weburl;

    private Date startdate;

    private Date enddate;

    private String status;

    private String area;

    private Date createtime;

    private Date lastupdate;

    private Long updator;

    private Short sortno;

    private String isleaf;

    private String subcount;

    private String remark;

    private String buno;

    private String auditbankno;

    private String paymentsysno;

    private String parentorgcode;

    private String isteam;

    private String isTradeArea;

    private String legOrg;

    private String financialnum;

    private String financialorgcode;

    private String nonlocalcode;

    private String orgcreditcode;

    private String bankno;

    private String nationalityCd;

    private String provinceCd;

    private String cityCd;

    private String district;

    private String streetAddress;

    private String regAdministrativeDivisions;

    private String orgSeal;

    private String parentorgname;
    
    private List<OmOrganization> children = Lists.newArrayList();

    public List<OmOrganization> getChildren() {
		return children;
	}

	public void setChildren(List<OmOrganization> children) {
		this.children = children;
	}

	public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public Short getOrglevel() {
        return orglevel;
    }

    public void setOrglevel(Short orglevel) {
        this.orglevel = orglevel;
    }

    public String getOrgdegree() {
        return orgdegree;
    }

    public void setOrgdegree(String orgdegree) {
        this.orgdegree = orgdegree == null ? null : orgdegree.trim();
    }

    public Long getParentorgid() {
        return parentorgid;
    }

    public void setParentorgid(Long parentorgid) {
        this.parentorgid = parentorgid;
    }

    public String getOrgseq() {
        return orgseq;
    }

    public void setOrgseq(String orgseq) {
        this.orgseq = orgseq == null ? null : orgseq.trim();
    }

    public String getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(String orgtype) {
        this.orgtype = orgtype == null ? null : orgtype.trim();
    }

    public String getOrgaddr() {
        return orgaddr;
    }

    public void setOrgaddr(String orgaddr) {
        this.orgaddr = orgaddr == null ? null : orgaddr.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public Long getManaposition() {
        return manaposition;
    }

    public void setManaposition(Long manaposition) {
        this.manaposition = manaposition;
    }

    public Long getManagerid() {
        return managerid;
    }

    public void setManagerid(Long managerid) {
        this.managerid = managerid;
    }

    public String getOrgmanager() {
        return orgmanager;
    }

    public void setOrgmanager(String orgmanager) {
        this.orgmanager = orgmanager == null ? null : orgmanager.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinktel() {
        return linktel;
    }

    public void setLinktel(String linktel) {
        this.linktel = linktel == null ? null : linktel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl == null ? null : weburl.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Long getUpdator() {
        return updator;
    }

    public void setUpdator(Long updator) {
        this.updator = updator;
    }

    public Short getSortno() {
        return sortno;
    }

    public void setSortno(Short sortno) {
        this.sortno = sortno;
    }

    public String getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(String isleaf) {
        this.isleaf = isleaf == null ? null : isleaf.trim();
    }

    public String getSubcount() {
        return subcount;
    }

    public void setSubcount(String subcount) {
        this.subcount = subcount == null ? null : subcount.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBuno() {
        return buno;
    }

    public void setBuno(String buno) {
        this.buno = buno == null ? null : buno.trim();
    }

    public String getAuditbankno() {
        return auditbankno;
    }

    public void setAuditbankno(String auditbankno) {
        this.auditbankno = auditbankno == null ? null : auditbankno.trim();
    }

    public String getPaymentsysno() {
        return paymentsysno;
    }

    public void setPaymentsysno(String paymentsysno) {
        this.paymentsysno = paymentsysno == null ? null : paymentsysno.trim();
    }

    public String getParentorgcode() {
        return parentorgcode;
    }

    public void setParentorgcode(String parentorgcode) {
        this.parentorgcode = parentorgcode == null ? null : parentorgcode.trim();
    }

    public String getIsteam() {
        return isteam;
    }

    public void setIsteam(String isteam) {
        this.isteam = isteam == null ? null : isteam.trim();
    }

    public String getIsTradeArea() {
        return isTradeArea;
    }

    public void setIsTradeArea(String isTradeArea) {
        this.isTradeArea = isTradeArea == null ? null : isTradeArea.trim();
    }

    public String getLegOrg() {
        return legOrg;
    }

    public void setLegOrg(String legOrg) {
        this.legOrg = legOrg == null ? null : legOrg.trim();
    }

    public String getFinancialnum() {
        return financialnum;
    }

    public void setFinancialnum(String financialnum) {
        this.financialnum = financialnum == null ? null : financialnum.trim();
    }

    public String getFinancialorgcode() {
        return financialorgcode;
    }

    public void setFinancialorgcode(String financialorgcode) {
        this.financialorgcode = financialorgcode == null ? null : financialorgcode.trim();
    }

    public String getNonlocalcode() {
        return nonlocalcode;
    }

    public void setNonlocalcode(String nonlocalcode) {
        this.nonlocalcode = nonlocalcode == null ? null : nonlocalcode.trim();
    }

    public String getOrgcreditcode() {
        return orgcreditcode;
    }

    public void setOrgcreditcode(String orgcreditcode) {
        this.orgcreditcode = orgcreditcode == null ? null : orgcreditcode.trim();
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress == null ? null : streetAddress.trim();
    }

    public String getRegAdministrativeDivisions() {
        return regAdministrativeDivisions;
    }

    public void setRegAdministrativeDivisions(String regAdministrativeDivisions) {
        this.regAdministrativeDivisions = regAdministrativeDivisions == null ? null : regAdministrativeDivisions.trim();
    }

    public String getOrgSeal() {
        return orgSeal;
    }

    public void setOrgSeal(String orgSeal) {
        this.orgSeal = orgSeal == null ? null : orgSeal.trim();
    }

    public String getParentorgname() {
        return parentorgname;
    }

    public void setParentorgname(String parentorgname) {
        this.parentorgname = parentorgname == null ? null : parentorgname.trim();
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
        OmOrganization other = (OmOrganization) that;
        return (this.getOrgid() == null ? other.getOrgid() == null : this.getOrgid().equals(other.getOrgid()))
            && (this.getOrgcode() == null ? other.getOrgcode() == null : this.getOrgcode().equals(other.getOrgcode()))
            && (this.getOrgname() == null ? other.getOrgname() == null : this.getOrgname().equals(other.getOrgname()))
            && (this.getOrglevel() == null ? other.getOrglevel() == null : this.getOrglevel().equals(other.getOrglevel()))
            && (this.getOrgdegree() == null ? other.getOrgdegree() == null : this.getOrgdegree().equals(other.getOrgdegree()))
            && (this.getParentorgid() == null ? other.getParentorgid() == null : this.getParentorgid().equals(other.getParentorgid()))
            && (this.getOrgseq() == null ? other.getOrgseq() == null : this.getOrgseq().equals(other.getOrgseq()))
            && (this.getOrgtype() == null ? other.getOrgtype() == null : this.getOrgtype().equals(other.getOrgtype()))
            && (this.getOrgaddr() == null ? other.getOrgaddr() == null : this.getOrgaddr().equals(other.getOrgaddr()))
            && (this.getZipcode() == null ? other.getZipcode() == null : this.getZipcode().equals(other.getZipcode()))
            && (this.getManaposition() == null ? other.getManaposition() == null : this.getManaposition().equals(other.getManaposition()))
            && (this.getManagerid() == null ? other.getManagerid() == null : this.getManagerid().equals(other.getManagerid()))
            && (this.getOrgmanager() == null ? other.getOrgmanager() == null : this.getOrgmanager().equals(other.getOrgmanager()))
            && (this.getLinkman() == null ? other.getLinkman() == null : this.getLinkman().equals(other.getLinkman()))
            && (this.getLinktel() == null ? other.getLinktel() == null : this.getLinktel().equals(other.getLinktel()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getWeburl() == null ? other.getWeburl() == null : this.getWeburl().equals(other.getWeburl()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLastupdate() == null ? other.getLastupdate() == null : this.getLastupdate().equals(other.getLastupdate()))
            && (this.getUpdator() == null ? other.getUpdator() == null : this.getUpdator().equals(other.getUpdator()))
            && (this.getSortno() == null ? other.getSortno() == null : this.getSortno().equals(other.getSortno()))
            && (this.getIsleaf() == null ? other.getIsleaf() == null : this.getIsleaf().equals(other.getIsleaf()))
            && (this.getSubcount() == null ? other.getSubcount() == null : this.getSubcount().equals(other.getSubcount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBuno() == null ? other.getBuno() == null : this.getBuno().equals(other.getBuno()))
            && (this.getAuditbankno() == null ? other.getAuditbankno() == null : this.getAuditbankno().equals(other.getAuditbankno()))
            && (this.getPaymentsysno() == null ? other.getPaymentsysno() == null : this.getPaymentsysno().equals(other.getPaymentsysno()))
            && (this.getParentorgcode() == null ? other.getParentorgcode() == null : this.getParentorgcode().equals(other.getParentorgcode()))
            && (this.getIsteam() == null ? other.getIsteam() == null : this.getIsteam().equals(other.getIsteam()))
            && (this.getIsTradeArea() == null ? other.getIsTradeArea() == null : this.getIsTradeArea().equals(other.getIsTradeArea()))
            && (this.getLegOrg() == null ? other.getLegOrg() == null : this.getLegOrg().equals(other.getLegOrg()))
            && (this.getFinancialnum() == null ? other.getFinancialnum() == null : this.getFinancialnum().equals(other.getFinancialnum()))
            && (this.getFinancialorgcode() == null ? other.getFinancialorgcode() == null : this.getFinancialorgcode().equals(other.getFinancialorgcode()))
            && (this.getNonlocalcode() == null ? other.getNonlocalcode() == null : this.getNonlocalcode().equals(other.getNonlocalcode()))
            && (this.getOrgcreditcode() == null ? other.getOrgcreditcode() == null : this.getOrgcreditcode().equals(other.getOrgcreditcode()))
            && (this.getBankno() == null ? other.getBankno() == null : this.getBankno().equals(other.getBankno()))
            && (this.getNationalityCd() == null ? other.getNationalityCd() == null : this.getNationalityCd().equals(other.getNationalityCd()))
            && (this.getProvinceCd() == null ? other.getProvinceCd() == null : this.getProvinceCd().equals(other.getProvinceCd()))
            && (this.getCityCd() == null ? other.getCityCd() == null : this.getCityCd().equals(other.getCityCd()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getStreetAddress() == null ? other.getStreetAddress() == null : this.getStreetAddress().equals(other.getStreetAddress()))
            && (this.getRegAdministrativeDivisions() == null ? other.getRegAdministrativeDivisions() == null : this.getRegAdministrativeDivisions().equals(other.getRegAdministrativeDivisions()))
            && (this.getOrgSeal() == null ? other.getOrgSeal() == null : this.getOrgSeal().equals(other.getOrgSeal()))
            && (this.getParentorgname() == null ? other.getParentorgname() == null : this.getParentorgname().equals(other.getParentorgname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgid() == null) ? 0 : getOrgid().hashCode());
        result = prime * result + ((getOrgcode() == null) ? 0 : getOrgcode().hashCode());
        result = prime * result + ((getOrgname() == null) ? 0 : getOrgname().hashCode());
        result = prime * result + ((getOrglevel() == null) ? 0 : getOrglevel().hashCode());
        result = prime * result + ((getOrgdegree() == null) ? 0 : getOrgdegree().hashCode());
        result = prime * result + ((getParentorgid() == null) ? 0 : getParentorgid().hashCode());
        result = prime * result + ((getOrgseq() == null) ? 0 : getOrgseq().hashCode());
        result = prime * result + ((getOrgtype() == null) ? 0 : getOrgtype().hashCode());
        result = prime * result + ((getOrgaddr() == null) ? 0 : getOrgaddr().hashCode());
        result = prime * result + ((getZipcode() == null) ? 0 : getZipcode().hashCode());
        result = prime * result + ((getManaposition() == null) ? 0 : getManaposition().hashCode());
        result = prime * result + ((getManagerid() == null) ? 0 : getManagerid().hashCode());
        result = prime * result + ((getOrgmanager() == null) ? 0 : getOrgmanager().hashCode());
        result = prime * result + ((getLinkman() == null) ? 0 : getLinkman().hashCode());
        result = prime * result + ((getLinktel() == null) ? 0 : getLinktel().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getWeburl() == null) ? 0 : getWeburl().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLastupdate() == null) ? 0 : getLastupdate().hashCode());
        result = prime * result + ((getUpdator() == null) ? 0 : getUpdator().hashCode());
        result = prime * result + ((getSortno() == null) ? 0 : getSortno().hashCode());
        result = prime * result + ((getIsleaf() == null) ? 0 : getIsleaf().hashCode());
        result = prime * result + ((getSubcount() == null) ? 0 : getSubcount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBuno() == null) ? 0 : getBuno().hashCode());
        result = prime * result + ((getAuditbankno() == null) ? 0 : getAuditbankno().hashCode());
        result = prime * result + ((getPaymentsysno() == null) ? 0 : getPaymentsysno().hashCode());
        result = prime * result + ((getParentorgcode() == null) ? 0 : getParentorgcode().hashCode());
        result = prime * result + ((getIsteam() == null) ? 0 : getIsteam().hashCode());
        result = prime * result + ((getIsTradeArea() == null) ? 0 : getIsTradeArea().hashCode());
        result = prime * result + ((getLegOrg() == null) ? 0 : getLegOrg().hashCode());
        result = prime * result + ((getFinancialnum() == null) ? 0 : getFinancialnum().hashCode());
        result = prime * result + ((getFinancialorgcode() == null) ? 0 : getFinancialorgcode().hashCode());
        result = prime * result + ((getNonlocalcode() == null) ? 0 : getNonlocalcode().hashCode());
        result = prime * result + ((getOrgcreditcode() == null) ? 0 : getOrgcreditcode().hashCode());
        result = prime * result + ((getBankno() == null) ? 0 : getBankno().hashCode());
        result = prime * result + ((getNationalityCd() == null) ? 0 : getNationalityCd().hashCode());
        result = prime * result + ((getProvinceCd() == null) ? 0 : getProvinceCd().hashCode());
        result = prime * result + ((getCityCd() == null) ? 0 : getCityCd().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getStreetAddress() == null) ? 0 : getStreetAddress().hashCode());
        result = prime * result + ((getRegAdministrativeDivisions() == null) ? 0 : getRegAdministrativeDivisions().hashCode());
        result = prime * result + ((getOrgSeal() == null) ? 0 : getOrgSeal().hashCode());
        result = prime * result + ((getParentorgname() == null) ? 0 : getParentorgname().hashCode());
        return result;
    }
}