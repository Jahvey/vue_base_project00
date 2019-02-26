package com.cdgit.loan.sysManage.empManage.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cdgit.loan.common.util.login.LoginUtil;

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

    private int errcount = 0;

    private Date startdate;

    private Date enddate;

    private String validtime;

    private String maccode;

    private String ipaddress;

    private String email;

    private String password1;

    private String useridmap;

    private String dynamicswitch;

    public AcOperator() throws Exception{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	this.invaldate = sdf.parse("2099-12-31");
    	this.startdate = new Date();
    	this.password = LoginUtil.md5();
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

    public int getErrcount() {
        return errcount;
    }

    public void setErrcount(int errcount) {
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


}