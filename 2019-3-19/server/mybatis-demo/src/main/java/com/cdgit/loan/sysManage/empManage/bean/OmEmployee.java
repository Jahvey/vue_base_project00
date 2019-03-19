package com.cdgit.loan.sysManage.empManage.bean;

import java.util.Date;

public class OmEmployee {
    private Long empid;

    private String empcode;

    private Long operatorid;

    private String userid;

    private String empname;

    private String realname;

    private String gender;

    private Date birthdate;

    private Long position;

    private String empstatus;

    private String cardtype;

    private String cardno;

    private Date indate;

    private Date outdate;

    private String otel;

    private String oaddress;

    private String ozipcode;

    private String oemail;

    private String faxno;

    private String mobileno;

    private String msn;

    private String htel;

    private String haddress;

    private String hzipcode;

    private String pemail;

    private String party;

    private String degree;

    private Long major;

    private String specialty;

    private String workexp;

    private Date regdate;

    private Date createtime;

    private Date lastmodytime;

    private String orgidlist;

    private Long orgid;

    private String remark;

    private String education;

    private String licenseno;

    private Date intotradedate;

    private Date runmarkdate;

    private String emplevel;

    private String departmentId;
    
    private int inorgid;
	private String inorgname;
 
    private int orglevel;
	private String orgcode;
	private String status;
	private String lastlogin;

    
    public int getInorgid() {
		return inorgid;
	}

	public void setInorgid(int inorgid) {
		this.inorgid = inorgid;
	}

	public String getInorgname() {
		return inorgname;
	}

	public void setInorgname(String inorgname) {
		this.inorgname = inorgname;
	}

	public int getOrglevel() {
		return orglevel;
	}

	public void setOrglevel(int orglevel) {
		this.orglevel = orglevel;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Long getEmpid() {
        return empid;
    }

    public void setEmpid(Long empid) {
        this.empid = empid;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode == null ? null : empcode.trim();
    }

    public Long getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Long operatorid) {
        this.operatorid = operatorid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getEmpstatus() {
        return empstatus;
    }

    public void setEmpstatus(String empstatus) {
        this.empstatus = empstatus == null ? null : empstatus.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getOtel() {
        return otel;
    }

    public void setOtel(String otel) {
        this.otel = otel == null ? null : otel.trim();
    }

    public String getOaddress() {
        return oaddress;
    }

    public void setOaddress(String oaddress) {
        this.oaddress = oaddress == null ? null : oaddress.trim();
    }

    public String getOzipcode() {
        return ozipcode;
    }

    public void setOzipcode(String ozipcode) {
        this.ozipcode = ozipcode == null ? null : ozipcode.trim();
    }

    public String getOemail() {
        return oemail;
    }

    public void setOemail(String oemail) {
        this.oemail = oemail == null ? null : oemail.trim();
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno == null ? null : faxno.trim();
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno == null ? null : mobileno.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getHtel() {
        return htel;
    }

    public void setHtel(String htel) {
        this.htel = htel == null ? null : htel.trim();
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress == null ? null : haddress.trim();
    }

    public String getHzipcode() {
        return hzipcode;
    }

    public void setHzipcode(String hzipcode) {
        this.hzipcode = hzipcode == null ? null : hzipcode.trim();
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail == null ? null : pemail.trim();
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party == null ? null : party.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public Long getMajor() {
        return major;
    }

    public void setMajor(Long major) {
        this.major = major;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getWorkexp() {
        return workexp;
    }

    public void setWorkexp(String workexp) {
        this.workexp = workexp == null ? null : workexp.trim();
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastmodytime() {
        return lastmodytime;
    }

    public void setLastmodytime(Date lastmodytime) {
        this.lastmodytime = lastmodytime;
    }

    public String getOrgidlist() {
        return orgidlist;
    }

    public void setOrgidlist(String orgidlist) {
        this.orgidlist = orgidlist == null ? null : orgidlist.trim();
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getLicenseno() {
        return licenseno;
    }

    public void setLicenseno(String licenseno) {
        this.licenseno = licenseno == null ? null : licenseno.trim();
    }

    public Date getIntotradedate() {
        return intotradedate;
    }

    public void setIntotradedate(Date intotradedate) {
        this.intotradedate = intotradedate;
    }

    public Date getRunmarkdate() {
        return runmarkdate;
    }

    public void setRunmarkdate(Date runmarkdate) {
        this.runmarkdate = runmarkdate;
    }

    public String getEmplevel() {
        return emplevel;
    }

    public void setEmplevel(String emplevel) {
        this.emplevel = emplevel == null ? null : emplevel.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
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
        OmEmployee other = (OmEmployee) that;
        return (this.getEmpid() == null ? other.getEmpid() == null : this.getEmpid().equals(other.getEmpid()))
            && (this.getEmpcode() == null ? other.getEmpcode() == null : this.getEmpcode().equals(other.getEmpcode()))
            && (this.getOperatorid() == null ? other.getOperatorid() == null : this.getOperatorid().equals(other.getOperatorid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getEmpname() == null ? other.getEmpname() == null : this.getEmpname().equals(other.getEmpname()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthdate() == null ? other.getBirthdate() == null : this.getBirthdate().equals(other.getBirthdate()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getEmpstatus() == null ? other.getEmpstatus() == null : this.getEmpstatus().equals(other.getEmpstatus()))
            && (this.getCardtype() == null ? other.getCardtype() == null : this.getCardtype().equals(other.getCardtype()))
            && (this.getCardno() == null ? other.getCardno() == null : this.getCardno().equals(other.getCardno()))
            && (this.getIndate() == null ? other.getIndate() == null : this.getIndate().equals(other.getIndate()))
            && (this.getOutdate() == null ? other.getOutdate() == null : this.getOutdate().equals(other.getOutdate()))
            && (this.getOtel() == null ? other.getOtel() == null : this.getOtel().equals(other.getOtel()))
            && (this.getOaddress() == null ? other.getOaddress() == null : this.getOaddress().equals(other.getOaddress()))
            && (this.getOzipcode() == null ? other.getOzipcode() == null : this.getOzipcode().equals(other.getOzipcode()))
            && (this.getOemail() == null ? other.getOemail() == null : this.getOemail().equals(other.getOemail()))
            && (this.getFaxno() == null ? other.getFaxno() == null : this.getFaxno().equals(other.getFaxno()))
            && (this.getMobileno() == null ? other.getMobileno() == null : this.getMobileno().equals(other.getMobileno()))
            && (this.getMsn() == null ? other.getMsn() == null : this.getMsn().equals(other.getMsn()))
            && (this.getHtel() == null ? other.getHtel() == null : this.getHtel().equals(other.getHtel()))
            && (this.getHaddress() == null ? other.getHaddress() == null : this.getHaddress().equals(other.getHaddress()))
            && (this.getHzipcode() == null ? other.getHzipcode() == null : this.getHzipcode().equals(other.getHzipcode()))
            && (this.getPemail() == null ? other.getPemail() == null : this.getPemail().equals(other.getPemail()))
            && (this.getParty() == null ? other.getParty() == null : this.getParty().equals(other.getParty()))
            && (this.getDegree() == null ? other.getDegree() == null : this.getDegree().equals(other.getDegree()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getSpecialty() == null ? other.getSpecialty() == null : this.getSpecialty().equals(other.getSpecialty()))
            && (this.getWorkexp() == null ? other.getWorkexp() == null : this.getWorkexp().equals(other.getWorkexp()))
            && (this.getRegdate() == null ? other.getRegdate() == null : this.getRegdate().equals(other.getRegdate()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getLastmodytime() == null ? other.getLastmodytime() == null : this.getLastmodytime().equals(other.getLastmodytime()))
            && (this.getOrgidlist() == null ? other.getOrgidlist() == null : this.getOrgidlist().equals(other.getOrgidlist()))
            && (this.getOrgid() == null ? other.getOrgid() == null : this.getOrgid().equals(other.getOrgid()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getLicenseno() == null ? other.getLicenseno() == null : this.getLicenseno().equals(other.getLicenseno()))
            && (this.getIntotradedate() == null ? other.getIntotradedate() == null : this.getIntotradedate().equals(other.getIntotradedate()))
            && (this.getRunmarkdate() == null ? other.getRunmarkdate() == null : this.getRunmarkdate().equals(other.getRunmarkdate()))
            && (this.getEmplevel() == null ? other.getEmplevel() == null : this.getEmplevel().equals(other.getEmplevel()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmpid() == null) ? 0 : getEmpid().hashCode());
        result = prime * result + ((getEmpcode() == null) ? 0 : getEmpcode().hashCode());
        result = prime * result + ((getOperatorid() == null) ? 0 : getOperatorid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getEmpname() == null) ? 0 : getEmpname().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthdate() == null) ? 0 : getBirthdate().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getEmpstatus() == null) ? 0 : getEmpstatus().hashCode());
        result = prime * result + ((getCardtype() == null) ? 0 : getCardtype().hashCode());
        result = prime * result + ((getCardno() == null) ? 0 : getCardno().hashCode());
        result = prime * result + ((getIndate() == null) ? 0 : getIndate().hashCode());
        result = prime * result + ((getOutdate() == null) ? 0 : getOutdate().hashCode());
        result = prime * result + ((getOtel() == null) ? 0 : getOtel().hashCode());
        result = prime * result + ((getOaddress() == null) ? 0 : getOaddress().hashCode());
        result = prime * result + ((getOzipcode() == null) ? 0 : getOzipcode().hashCode());
        result = prime * result + ((getOemail() == null) ? 0 : getOemail().hashCode());
        result = prime * result + ((getFaxno() == null) ? 0 : getFaxno().hashCode());
        result = prime * result + ((getMobileno() == null) ? 0 : getMobileno().hashCode());
        result = prime * result + ((getMsn() == null) ? 0 : getMsn().hashCode());
        result = prime * result + ((getHtel() == null) ? 0 : getHtel().hashCode());
        result = prime * result + ((getHaddress() == null) ? 0 : getHaddress().hashCode());
        result = prime * result + ((getHzipcode() == null) ? 0 : getHzipcode().hashCode());
        result = prime * result + ((getPemail() == null) ? 0 : getPemail().hashCode());
        result = prime * result + ((getParty() == null) ? 0 : getParty().hashCode());
        result = prime * result + ((getDegree() == null) ? 0 : getDegree().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getSpecialty() == null) ? 0 : getSpecialty().hashCode());
        result = prime * result + ((getWorkexp() == null) ? 0 : getWorkexp().hashCode());
        result = prime * result + ((getRegdate() == null) ? 0 : getRegdate().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getLastmodytime() == null) ? 0 : getLastmodytime().hashCode());
        result = prime * result + ((getOrgidlist() == null) ? 0 : getOrgidlist().hashCode());
        result = prime * result + ((getOrgid() == null) ? 0 : getOrgid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getLicenseno() == null) ? 0 : getLicenseno().hashCode());
        result = prime * result + ((getIntotradedate() == null) ? 0 : getIntotradedate().hashCode());
        result = prime * result + ((getRunmarkdate() == null) ? 0 : getRunmarkdate().hashCode());
        result = prime * result + ((getEmplevel() == null) ? 0 : getEmplevel().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        return result;
    }
}