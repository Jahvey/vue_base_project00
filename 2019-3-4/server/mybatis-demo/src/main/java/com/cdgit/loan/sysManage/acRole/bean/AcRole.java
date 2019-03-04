package com.cdgit.loan.sysManage.acRole.bean;

public class AcRole {
    private String roleid;

    private String rolename;

    private String roletype;

    private String roledesc;

    private Long appid;

    private String initflag;

    private String legOrg;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype == null ? null : roletype.trim();
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getInitflag() {
        return initflag;
    }

    public void setInitflag(String initflag) {
        this.initflag = initflag == null ? null : initflag.trim();
    }

    public String getLegOrg() {
        return legOrg;
    }

    public void setLegOrg(String legOrg) {
        this.legOrg = legOrg == null ? null : legOrg.trim();
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
        AcRole other = (AcRole) that;
        return (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()))
            && (this.getRolename() == null ? other.getRolename() == null : this.getRolename().equals(other.getRolename()))
            && (this.getRoletype() == null ? other.getRoletype() == null : this.getRoletype().equals(other.getRoletype()))
            && (this.getRoledesc() == null ? other.getRoledesc() == null : this.getRoledesc().equals(other.getRoledesc()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getInitflag() == null ? other.getInitflag() == null : this.getInitflag().equals(other.getInitflag()))
            && (this.getLegOrg() == null ? other.getLegOrg() == null : this.getLegOrg().equals(other.getLegOrg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        result = prime * result + ((getRolename() == null) ? 0 : getRolename().hashCode());
        result = prime * result + ((getRoletype() == null) ? 0 : getRoletype().hashCode());
        result = prime * result + ((getRoledesc() == null) ? 0 : getRoledesc().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getInitflag() == null) ? 0 : getInitflag().hashCode());
        result = prime * result + ((getLegOrg() == null) ? 0 : getLegOrg().hashCode());
        return result;
    }
}