package com.cdgit.loan.sysManage.empManage.bean;

import java.util.Date;

public class AcOperator {
    private Long operatorid;

    private String userid;

    private String password;

    private Date invaldate;

    private String operatorname;

    private String authmode;

    private String status;

    private Date unlocktime;

    private String menutype;

    private Date lastlogin;

    private Long errcount;

    private Date startdate;

    private Date enddate;

    private String validtime;

    private String maccode;

    private String ipaddress;

    private String email;

    private String password1;

    private String useridmap;

    private String dynamicswitch;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getInvaldate() {
        return invaldate;
    }

    public void setInvaldate(Date invaldate) {
        this.invaldate = invaldate;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname == null ? null : operatorname.trim();
    }

    public String getAuthmode() {
        return authmode;
    }

    public void setAuthmode(String authmode) {
        this.authmode = authmode == null ? null : authmode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getUnlocktime() {
        return unlocktime;
    }

    public void setUnlocktime(Date unlocktime) {
        this.unlocktime = unlocktime;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype == null ? null : menutype.trim();
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Long getErrcount() {
        return errcount;
    }

    public void setErrcount(Long errcount) {
        this.errcount = errcount;
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

    public String getValidtime() {
        return validtime;
    }

    public void setValidtime(String validtime) {
        this.validtime = validtime == null ? null : validtime.trim();
    }

    public String getMaccode() {
        return maccode;
    }

    public void setMaccode(String maccode) {
        this.maccode = maccode == null ? null : maccode.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1 == null ? null : password1.trim();
    }

    public String getUseridmap() {
        return useridmap;
    }

    public void setUseridmap(String useridmap) {
        this.useridmap = useridmap == null ? null : useridmap.trim();
    }

    public String getDynamicswitch() {
        return dynamicswitch;
    }

    public void setDynamicswitch(String dynamicswitch) {
        this.dynamicswitch = dynamicswitch == null ? null : dynamicswitch.trim();
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
        AcOperator other = (AcOperator) that;
        return (this.getOperatorid() == null ? other.getOperatorid() == null : this.getOperatorid().equals(other.getOperatorid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getInvaldate() == null ? other.getInvaldate() == null : this.getInvaldate().equals(other.getInvaldate()))
            && (this.getOperatorname() == null ? other.getOperatorname() == null : this.getOperatorname().equals(other.getOperatorname()))
            && (this.getAuthmode() == null ? other.getAuthmode() == null : this.getAuthmode().equals(other.getAuthmode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUnlocktime() == null ? other.getUnlocktime() == null : this.getUnlocktime().equals(other.getUnlocktime()))
            && (this.getMenutype() == null ? other.getMenutype() == null : this.getMenutype().equals(other.getMenutype()))
            && (this.getLastlogin() == null ? other.getLastlogin() == null : this.getLastlogin().equals(other.getLastlogin()))
            && (this.getErrcount() == null ? other.getErrcount() == null : this.getErrcount().equals(other.getErrcount()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getEnddate() == null ? other.getEnddate() == null : this.getEnddate().equals(other.getEnddate()))
            && (this.getValidtime() == null ? other.getValidtime() == null : this.getValidtime().equals(other.getValidtime()))
            && (this.getMaccode() == null ? other.getMaccode() == null : this.getMaccode().equals(other.getMaccode()))
            && (this.getIpaddress() == null ? other.getIpaddress() == null : this.getIpaddress().equals(other.getIpaddress()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword1() == null ? other.getPassword1() == null : this.getPassword1().equals(other.getPassword1()))
            && (this.getUseridmap() == null ? other.getUseridmap() == null : this.getUseridmap().equals(other.getUseridmap()))
            && (this.getDynamicswitch() == null ? other.getDynamicswitch() == null : this.getDynamicswitch().equals(other.getDynamicswitch()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperatorid() == null) ? 0 : getOperatorid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getInvaldate() == null) ? 0 : getInvaldate().hashCode());
        result = prime * result + ((getOperatorname() == null) ? 0 : getOperatorname().hashCode());
        result = prime * result + ((getAuthmode() == null) ? 0 : getAuthmode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUnlocktime() == null) ? 0 : getUnlocktime().hashCode());
        result = prime * result + ((getMenutype() == null) ? 0 : getMenutype().hashCode());
        result = prime * result + ((getLastlogin() == null) ? 0 : getLastlogin().hashCode());
        result = prime * result + ((getErrcount() == null) ? 0 : getErrcount().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getEnddate() == null) ? 0 : getEnddate().hashCode());
        result = prime * result + ((getValidtime() == null) ? 0 : getValidtime().hashCode());
        result = prime * result + ((getMaccode() == null) ? 0 : getMaccode().hashCode());
        result = prime * result + ((getIpaddress() == null) ? 0 : getIpaddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword1() == null) ? 0 : getPassword1().hashCode());
        result = prime * result + ((getUseridmap() == null) ? 0 : getUseridmap().hashCode());
        result = prime * result + ((getDynamicswitch() == null) ? 0 : getDynamicswitch().hashCode());
        return result;
    }
}