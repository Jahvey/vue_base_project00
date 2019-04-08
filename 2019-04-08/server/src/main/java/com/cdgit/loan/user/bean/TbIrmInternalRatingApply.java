package com.cdgit.loan.user.bean;

import java.util.Date;

public class TbIrmInternalRatingApply {
    private String IRA_APPLY_ID;

    private String RATING_MODEL_CD;

    private String RATING_MODEL_VER;

    private String RATING_STATE;

    private String PROJECT_ID;

    private Date APPLY_DATE;

    private String APPLY_NATURE_CD;

    private String TRIGGER_TYPE_CD;

    private String ORG_NUM;

    private String USER_NUM;

    private String ORIGINAL_IRA_APPLY_ID;

    private String IS_AUDIT;

    private Short ALLOW_TIMES;

    private String IS_GOVERNMENT_PLATFORM;

    private String GP_MODEL_VER;

    private String ALLOW_MODIFY_FLAG;

    private String GOVERNMENT_ADJUST_RATING_CD;

    private String GENERAL_ADJUST_RATING_CD;

    private String RATING_TYPE;
    
    private String RATING_TYPE_CD;
    
    private String LAST_CREDIT_RATING_CD;
    
    private Date LAST_EFFECTIVE_END_DT;
    
    private Date LAST_EFFECTIVE_START_DT;
    
    public String getLAST_CREDIT_RATING_CD() {
		return LAST_CREDIT_RATING_CD;
	}

	public void setLAST_CREDIT_RATING_CD(String lAST_CREDIT_RATING_CD) {
		LAST_CREDIT_RATING_CD = lAST_CREDIT_RATING_CD;
	}

	public Date getLAST_EFFECTIVE_END_DT() {
		return LAST_EFFECTIVE_END_DT;
	}

	public void setLAST_EFFECTIVE_END_DT(Date lAST_EFFECTIVE_END_DT) {
		LAST_EFFECTIVE_END_DT = lAST_EFFECTIVE_END_DT;
	}

	public Date getLAST_EFFECTIVE_START_DT() {
		return LAST_EFFECTIVE_START_DT;
	}

	public void setLAST_EFFECTIVE_START_DT(Date lAST_EFFECTIVE_START_DT) {
		LAST_EFFECTIVE_START_DT = lAST_EFFECTIVE_START_DT;
	}

	public String getRATING_TYPE_CD() {
		return RATING_TYPE_CD;
	}

	public void setRATING_TYPE_CD(String rATING_TYPE_CD) {
		RATING_TYPE_CD = rATING_TYPE_CD;
	}

	private String PARTY_ID;

    public String getIRA_APPLY_ID() {
        return IRA_APPLY_ID;
    }

    public void setIRA_APPLY_ID(String IRA_APPLY_ID) {
        this.IRA_APPLY_ID = IRA_APPLY_ID == null ? null : IRA_APPLY_ID.trim();
    }

    public String getRATING_MODEL_CD() {
        return RATING_MODEL_CD;
    }

    public void setRATING_MODEL_CD(String RATING_MODEL_CD) {
        this.RATING_MODEL_CD = RATING_MODEL_CD == null ? null : RATING_MODEL_CD.trim();
    }

    public String getRATING_MODEL_VER() {
        return RATING_MODEL_VER;
    }

    public void setRATING_MODEL_VER(String RATING_MODEL_VER) {
        this.RATING_MODEL_VER = RATING_MODEL_VER == null ? null : RATING_MODEL_VER.trim();
    }

    public String getRATING_STATE() {
        return RATING_STATE;
    }

    public void setRATING_STATE(String RATING_STATE) {
        this.RATING_STATE = RATING_STATE == null ? null : RATING_STATE.trim();
    }

    public String getPROJECT_ID() {
        return PROJECT_ID;
    }

    public void setPROJECT_ID(String PROJECT_ID) {
        this.PROJECT_ID = PROJECT_ID == null ? null : PROJECT_ID.trim();
    }

    public Date getAPPLY_DATE() {
        return APPLY_DATE;
    }

    public void setAPPLY_DATE(Date APPLY_DATE) {
        this.APPLY_DATE = APPLY_DATE;
    }

    public String getAPPLY_NATURE_CD() {
        return APPLY_NATURE_CD;
    }

    public void setAPPLY_NATURE_CD(String APPLY_NATURE_CD) {
        this.APPLY_NATURE_CD = APPLY_NATURE_CD == null ? null : APPLY_NATURE_CD.trim();
    }

    public String getTRIGGER_TYPE_CD() {
        return TRIGGER_TYPE_CD;
    }

    public void setTRIGGER_TYPE_CD(String TRIGGER_TYPE_CD) {
        this.TRIGGER_TYPE_CD = TRIGGER_TYPE_CD == null ? null : TRIGGER_TYPE_CD.trim();
    }

    public String getORG_NUM() {
        return ORG_NUM;
    }

    public void setORG_NUM(String ORG_NUM) {
        this.ORG_NUM = ORG_NUM == null ? null : ORG_NUM.trim();
    }

    public String getUSER_NUM() {
        return USER_NUM;
    }

    public void setUSER_NUM(String USER_NUM) {
        this.USER_NUM = USER_NUM == null ? null : USER_NUM.trim();
    }

    public String getORIGINAL_IRA_APPLY_ID() {
        return ORIGINAL_IRA_APPLY_ID;
    }

    public void setORIGINAL_IRA_APPLY_ID(String ORIGINAL_IRA_APPLY_ID) {
        this.ORIGINAL_IRA_APPLY_ID = ORIGINAL_IRA_APPLY_ID == null ? null : ORIGINAL_IRA_APPLY_ID.trim();
    }

    public String getIS_AUDIT() {
        return IS_AUDIT;
    }

    public void setIS_AUDIT(String IS_AUDIT) {
        this.IS_AUDIT = IS_AUDIT == null ? null : IS_AUDIT.trim();
    }

    public Short getALLOW_TIMES() {
        return ALLOW_TIMES;
    }

    public void setALLOW_TIMES(Short ALLOW_TIMES) {
        this.ALLOW_TIMES = ALLOW_TIMES;
    }

    public String getIS_GOVERNMENT_PLATFORM() {
        return IS_GOVERNMENT_PLATFORM;
    }

    public void setIS_GOVERNMENT_PLATFORM(String IS_GOVERNMENT_PLATFORM) {
        this.IS_GOVERNMENT_PLATFORM = IS_GOVERNMENT_PLATFORM == null ? null : IS_GOVERNMENT_PLATFORM.trim();
    }

    public String getGP_MODEL_VER() {
        return GP_MODEL_VER;
    }

    public void setGP_MODEL_VER(String GP_MODEL_VER) {
        this.GP_MODEL_VER = GP_MODEL_VER == null ? null : GP_MODEL_VER.trim();
    }

    public String getALLOW_MODIFY_FLAG() {
        return ALLOW_MODIFY_FLAG;
    }

    public void setALLOW_MODIFY_FLAG(String ALLOW_MODIFY_FLAG) {
        this.ALLOW_MODIFY_FLAG = ALLOW_MODIFY_FLAG == null ? null : ALLOW_MODIFY_FLAG.trim();
    }

    public String getGOVERNMENT_ADJUST_RATING_CD() {
        return GOVERNMENT_ADJUST_RATING_CD;
    }

    public void setGOVERNMENT_ADJUST_RATING_CD(String GOVERNMENT_ADJUST_RATING_CD) {
        this.GOVERNMENT_ADJUST_RATING_CD = GOVERNMENT_ADJUST_RATING_CD == null ? null : GOVERNMENT_ADJUST_RATING_CD.trim();
    }

    public String getGENERAL_ADJUST_RATING_CD() {
        return GENERAL_ADJUST_RATING_CD;
    }

    public void setGENERAL_ADJUST_RATING_CD(String GENERAL_ADJUST_RATING_CD) {
        this.GENERAL_ADJUST_RATING_CD = GENERAL_ADJUST_RATING_CD == null ? null : GENERAL_ADJUST_RATING_CD.trim();
    }

    public String getRATING_TYPE() {
        return RATING_TYPE;
    }

    public void setRATING_TYPE(String RATING_TYPE) {
        this.RATING_TYPE = RATING_TYPE == null ? null : RATING_TYPE.trim();
    }

    public String getPARTY_ID() {
        return PARTY_ID;
    }

    public void setPARTY_ID(String PARTY_ID) {
        this.PARTY_ID = PARTY_ID == null ? null : PARTY_ID.trim();
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
        TbIrmInternalRatingApply other = (TbIrmInternalRatingApply) that;
        return (this.getIRA_APPLY_ID() == null ? other.getIRA_APPLY_ID() == null : this.getIRA_APPLY_ID().equals(other.getIRA_APPLY_ID()))
            && (this.getRATING_MODEL_CD() == null ? other.getRATING_MODEL_CD() == null : this.getRATING_MODEL_CD().equals(other.getRATING_MODEL_CD()))
            && (this.getRATING_MODEL_VER() == null ? other.getRATING_MODEL_VER() == null : this.getRATING_MODEL_VER().equals(other.getRATING_MODEL_VER()))
            && (this.getRATING_STATE() == null ? other.getRATING_STATE() == null : this.getRATING_STATE().equals(other.getRATING_STATE()))
            && (this.getPROJECT_ID() == null ? other.getPROJECT_ID() == null : this.getPROJECT_ID().equals(other.getPROJECT_ID()))
            && (this.getAPPLY_DATE() == null ? other.getAPPLY_DATE() == null : this.getAPPLY_DATE().equals(other.getAPPLY_DATE()))
            && (this.getAPPLY_NATURE_CD() == null ? other.getAPPLY_NATURE_CD() == null : this.getAPPLY_NATURE_CD().equals(other.getAPPLY_NATURE_CD()))
            && (this.getTRIGGER_TYPE_CD() == null ? other.getTRIGGER_TYPE_CD() == null : this.getTRIGGER_TYPE_CD().equals(other.getTRIGGER_TYPE_CD()))
            && (this.getORG_NUM() == null ? other.getORG_NUM() == null : this.getORG_NUM().equals(other.getORG_NUM()))
            && (this.getUSER_NUM() == null ? other.getUSER_NUM() == null : this.getUSER_NUM().equals(other.getUSER_NUM()))
            && (this.getORIGINAL_IRA_APPLY_ID() == null ? other.getORIGINAL_IRA_APPLY_ID() == null : this.getORIGINAL_IRA_APPLY_ID().equals(other.getORIGINAL_IRA_APPLY_ID()))
            && (this.getIS_AUDIT() == null ? other.getIS_AUDIT() == null : this.getIS_AUDIT().equals(other.getIS_AUDIT()))
            && (this.getALLOW_TIMES() == null ? other.getALLOW_TIMES() == null : this.getALLOW_TIMES().equals(other.getALLOW_TIMES()))
            && (this.getIS_GOVERNMENT_PLATFORM() == null ? other.getIS_GOVERNMENT_PLATFORM() == null : this.getIS_GOVERNMENT_PLATFORM().equals(other.getIS_GOVERNMENT_PLATFORM()))
            && (this.getGP_MODEL_VER() == null ? other.getGP_MODEL_VER() == null : this.getGP_MODEL_VER().equals(other.getGP_MODEL_VER()))
            && (this.getALLOW_MODIFY_FLAG() == null ? other.getALLOW_MODIFY_FLAG() == null : this.getALLOW_MODIFY_FLAG().equals(other.getALLOW_MODIFY_FLAG()))
            && (this.getGOVERNMENT_ADJUST_RATING_CD() == null ? other.getGOVERNMENT_ADJUST_RATING_CD() == null : this.getGOVERNMENT_ADJUST_RATING_CD().equals(other.getGOVERNMENT_ADJUST_RATING_CD()))
            && (this.getGENERAL_ADJUST_RATING_CD() == null ? other.getGENERAL_ADJUST_RATING_CD() == null : this.getGENERAL_ADJUST_RATING_CD().equals(other.getGENERAL_ADJUST_RATING_CD()))
            && (this.getRATING_TYPE() == null ? other.getRATING_TYPE() == null : this.getRATING_TYPE().equals(other.getRATING_TYPE()))
            && (this.getPARTY_ID() == null ? other.getPARTY_ID() == null : this.getPARTY_ID().equals(other.getPARTY_ID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIRA_APPLY_ID() == null) ? 0 : getIRA_APPLY_ID().hashCode());
        result = prime * result + ((getRATING_MODEL_CD() == null) ? 0 : getRATING_MODEL_CD().hashCode());
        result = prime * result + ((getRATING_MODEL_VER() == null) ? 0 : getRATING_MODEL_VER().hashCode());
        result = prime * result + ((getRATING_STATE() == null) ? 0 : getRATING_STATE().hashCode());
        result = prime * result + ((getPROJECT_ID() == null) ? 0 : getPROJECT_ID().hashCode());
        result = prime * result + ((getAPPLY_DATE() == null) ? 0 : getAPPLY_DATE().hashCode());
        result = prime * result + ((getAPPLY_NATURE_CD() == null) ? 0 : getAPPLY_NATURE_CD().hashCode());
        result = prime * result + ((getTRIGGER_TYPE_CD() == null) ? 0 : getTRIGGER_TYPE_CD().hashCode());
        result = prime * result + ((getORG_NUM() == null) ? 0 : getORG_NUM().hashCode());
        result = prime * result + ((getUSER_NUM() == null) ? 0 : getUSER_NUM().hashCode());
        result = prime * result + ((getORIGINAL_IRA_APPLY_ID() == null) ? 0 : getORIGINAL_IRA_APPLY_ID().hashCode());
        result = prime * result + ((getIS_AUDIT() == null) ? 0 : getIS_AUDIT().hashCode());
        result = prime * result + ((getALLOW_TIMES() == null) ? 0 : getALLOW_TIMES().hashCode());
        result = prime * result + ((getIS_GOVERNMENT_PLATFORM() == null) ? 0 : getIS_GOVERNMENT_PLATFORM().hashCode());
        result = prime * result + ((getGP_MODEL_VER() == null) ? 0 : getGP_MODEL_VER().hashCode());
        result = prime * result + ((getALLOW_MODIFY_FLAG() == null) ? 0 : getALLOW_MODIFY_FLAG().hashCode());
        result = prime * result + ((getGOVERNMENT_ADJUST_RATING_CD() == null) ? 0 : getGOVERNMENT_ADJUST_RATING_CD().hashCode());
        result = prime * result + ((getGENERAL_ADJUST_RATING_CD() == null) ? 0 : getGENERAL_ADJUST_RATING_CD().hashCode());
        result = prime * result + ((getRATING_TYPE() == null) ? 0 : getRATING_TYPE().hashCode());
        result = prime * result + ((getPARTY_ID() == null) ? 0 : getPARTY_ID().hashCode());
        return result;
    }
}