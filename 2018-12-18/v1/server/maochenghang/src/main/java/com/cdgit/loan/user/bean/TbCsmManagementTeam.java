package com.cdgit.loan.user.bean;

import java.util.Date;

public class TbCsmManagementTeam {
    private String MANAGEMENT_TEAM_ID;

    private String USER_NUM;

    private String USER_PLACING_CD;

    private String STATUS;

    private String PARTY_ID;

    private Date UPDATE_TIME;

    private String ORG_NUM;

    private Date CREATE_TIME;

    private String PARTY_TYPE;

    public String getMANAGEMENT_TEAM_ID() {
        return MANAGEMENT_TEAM_ID;
    }

    public void setMANAGEMENT_TEAM_ID(String MANAGEMENT_TEAM_ID) {
        this.MANAGEMENT_TEAM_ID = MANAGEMENT_TEAM_ID == null ? null : MANAGEMENT_TEAM_ID.trim();
    }

    public String getUSER_NUM() {
        return USER_NUM;
    }

    public void setUSER_NUM(String USER_NUM) {
        this.USER_NUM = USER_NUM == null ? null : USER_NUM.trim();
    }

    public String getUSER_PLACING_CD() {
        return USER_PLACING_CD;
    }

    public void setUSER_PLACING_CD(String USER_PLACING_CD) {
        this.USER_PLACING_CD = USER_PLACING_CD == null ? null : USER_PLACING_CD.trim();
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS == null ? null : STATUS.trim();
    }

    public String getPARTY_ID() {
        return PARTY_ID;
    }

    public void setPARTY_ID(String PARTY_ID) {
        this.PARTY_ID = PARTY_ID == null ? null : PARTY_ID.trim();
    }

    public Date getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(Date UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getORG_NUM() {
        return ORG_NUM;
    }

    public void setORG_NUM(String ORG_NUM) {
        this.ORG_NUM = ORG_NUM == null ? null : ORG_NUM.trim();
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getPARTY_TYPE() {
        return PARTY_TYPE;
    }

    public void setPARTY_TYPE(String PARTY_TYPE) {
        this.PARTY_TYPE = PARTY_TYPE == null ? null : PARTY_TYPE.trim();
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
        TbCsmManagementTeam other = (TbCsmManagementTeam) that;
        return (this.getMANAGEMENT_TEAM_ID() == null ? other.getMANAGEMENT_TEAM_ID() == null : this.getMANAGEMENT_TEAM_ID().equals(other.getMANAGEMENT_TEAM_ID()))
            && (this.getUSER_NUM() == null ? other.getUSER_NUM() == null : this.getUSER_NUM().equals(other.getUSER_NUM()))
            && (this.getUSER_PLACING_CD() == null ? other.getUSER_PLACING_CD() == null : this.getUSER_PLACING_CD().equals(other.getUSER_PLACING_CD()))
            && (this.getSTATUS() == null ? other.getSTATUS() == null : this.getSTATUS().equals(other.getSTATUS()))
            && (this.getPARTY_ID() == null ? other.getPARTY_ID() == null : this.getPARTY_ID().equals(other.getPARTY_ID()))
            && (this.getUPDATE_TIME() == null ? other.getUPDATE_TIME() == null : this.getUPDATE_TIME().equals(other.getUPDATE_TIME()))
            && (this.getORG_NUM() == null ? other.getORG_NUM() == null : this.getORG_NUM().equals(other.getORG_NUM()))
            && (this.getCREATE_TIME() == null ? other.getCREATE_TIME() == null : this.getCREATE_TIME().equals(other.getCREATE_TIME()))
            && (this.getPARTY_TYPE() == null ? other.getPARTY_TYPE() == null : this.getPARTY_TYPE().equals(other.getPARTY_TYPE()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMANAGEMENT_TEAM_ID() == null) ? 0 : getMANAGEMENT_TEAM_ID().hashCode());
        result = prime * result + ((getUSER_NUM() == null) ? 0 : getUSER_NUM().hashCode());
        result = prime * result + ((getUSER_PLACING_CD() == null) ? 0 : getUSER_PLACING_CD().hashCode());
        result = prime * result + ((getSTATUS() == null) ? 0 : getSTATUS().hashCode());
        result = prime * result + ((getPARTY_ID() == null) ? 0 : getPARTY_ID().hashCode());
        result = prime * result + ((getUPDATE_TIME() == null) ? 0 : getUPDATE_TIME().hashCode());
        result = prime * result + ((getORG_NUM() == null) ? 0 : getORG_NUM().hashCode());
        result = prime * result + ((getCREATE_TIME() == null) ? 0 : getCREATE_TIME().hashCode());
        result = prime * result + ((getPARTY_TYPE() == null) ? 0 : getPARTY_TYPE().hashCode());
        return result;
    }
}