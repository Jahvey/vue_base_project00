package com.cdgit.loan.user.bean;

import java.util.Date;

public class TbCsmBankScale {
    private String ID;

    private String ORG_NUM;

    private String USER_NUM;

    private String PARTY_ID;

    private Date CREATE_TIME;

    private String COUNT_BORE_ENTER_SCALE;

    private String OLD_COUNT_BORE_ENTER_SCALE;

    private String BANK_SCALE1;

    private String BANK_SCALE2;

    private String BANK_SCALE3;

    private String BANK_SCALE4;

    private String BANK_SCALE5;

    private String BANK_SCALE6;

    private String BANK_SCALE7;

    private String BANK_SCALE8;

    private String BANK_SCALE9;

    private String BANK_SCALE10;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
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

    public String getPARTY_ID() {
        return PARTY_ID;
    }

    public void setPARTY_ID(String PARTY_ID) {
        this.PARTY_ID = PARTY_ID == null ? null : PARTY_ID.trim();
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getCOUNT_BORE_ENTER_SCALE() {
        return COUNT_BORE_ENTER_SCALE;
    }

    public void setCOUNT_BORE_ENTER_SCALE(String COUNT_BORE_ENTER_SCALE) {
        this.COUNT_BORE_ENTER_SCALE = COUNT_BORE_ENTER_SCALE == null ? null : COUNT_BORE_ENTER_SCALE.trim();
    }

    public String getOLD_COUNT_BORE_ENTER_SCALE() {
        return OLD_COUNT_BORE_ENTER_SCALE;
    }

    public void setOLD_COUNT_BORE_ENTER_SCALE(String OLD_COUNT_BORE_ENTER_SCALE) {
        this.OLD_COUNT_BORE_ENTER_SCALE = OLD_COUNT_BORE_ENTER_SCALE == null ? null : OLD_COUNT_BORE_ENTER_SCALE.trim();
    }

    public String getBANK_SCALE1() {
        return BANK_SCALE1;
    }

    public void setBANK_SCALE1(String BANK_SCALE1) {
        this.BANK_SCALE1 = BANK_SCALE1 == null ? null : BANK_SCALE1.trim();
    }

    public String getBANK_SCALE2() {
        return BANK_SCALE2;
    }

    public void setBANK_SCALE2(String BANK_SCALE2) {
        this.BANK_SCALE2 = BANK_SCALE2 == null ? null : BANK_SCALE2.trim();
    }

    public String getBANK_SCALE3() {
        return BANK_SCALE3;
    }

    public void setBANK_SCALE3(String BANK_SCALE3) {
        this.BANK_SCALE3 = BANK_SCALE3 == null ? null : BANK_SCALE3.trim();
    }

    public String getBANK_SCALE4() {
        return BANK_SCALE4;
    }

    public void setBANK_SCALE4(String BANK_SCALE4) {
        this.BANK_SCALE4 = BANK_SCALE4 == null ? null : BANK_SCALE4.trim();
    }

    public String getBANK_SCALE5() {
        return BANK_SCALE5;
    }

    public void setBANK_SCALE5(String BANK_SCALE5) {
        this.BANK_SCALE5 = BANK_SCALE5 == null ? null : BANK_SCALE5.trim();
    }

    public String getBANK_SCALE6() {
        return BANK_SCALE6;
    }

    public void setBANK_SCALE6(String BANK_SCALE6) {
        this.BANK_SCALE6 = BANK_SCALE6 == null ? null : BANK_SCALE6.trim();
    }

    public String getBANK_SCALE7() {
        return BANK_SCALE7;
    }

    public void setBANK_SCALE7(String BANK_SCALE7) {
        this.BANK_SCALE7 = BANK_SCALE7 == null ? null : BANK_SCALE7.trim();
    }

    public String getBANK_SCALE8() {
        return BANK_SCALE8;
    }

    public void setBANK_SCALE8(String BANK_SCALE8) {
        this.BANK_SCALE8 = BANK_SCALE8 == null ? null : BANK_SCALE8.trim();
    }

    public String getBANK_SCALE9() {
        return BANK_SCALE9;
    }

    public void setBANK_SCALE9(String BANK_SCALE9) {
        this.BANK_SCALE9 = BANK_SCALE9 == null ? null : BANK_SCALE9.trim();
    }

    public String getBANK_SCALE10() {
        return BANK_SCALE10;
    }

    public void setBANK_SCALE10(String BANK_SCALE10) {
        this.BANK_SCALE10 = BANK_SCALE10 == null ? null : BANK_SCALE10.trim();
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
        TbCsmBankScale other = (TbCsmBankScale) that;
        return (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getORG_NUM() == null ? other.getORG_NUM() == null : this.getORG_NUM().equals(other.getORG_NUM()))
            && (this.getUSER_NUM() == null ? other.getUSER_NUM() == null : this.getUSER_NUM().equals(other.getUSER_NUM()))
            && (this.getPARTY_ID() == null ? other.getPARTY_ID() == null : this.getPARTY_ID().equals(other.getPARTY_ID()))
            && (this.getCREATE_TIME() == null ? other.getCREATE_TIME() == null : this.getCREATE_TIME().equals(other.getCREATE_TIME()))
            && (this.getCOUNT_BORE_ENTER_SCALE() == null ? other.getCOUNT_BORE_ENTER_SCALE() == null : this.getCOUNT_BORE_ENTER_SCALE().equals(other.getCOUNT_BORE_ENTER_SCALE()))
            && (this.getOLD_COUNT_BORE_ENTER_SCALE() == null ? other.getOLD_COUNT_BORE_ENTER_SCALE() == null : this.getOLD_COUNT_BORE_ENTER_SCALE().equals(other.getOLD_COUNT_BORE_ENTER_SCALE()))
            && (this.getBANK_SCALE1() == null ? other.getBANK_SCALE1() == null : this.getBANK_SCALE1().equals(other.getBANK_SCALE1()))
            && (this.getBANK_SCALE2() == null ? other.getBANK_SCALE2() == null : this.getBANK_SCALE2().equals(other.getBANK_SCALE2()))
            && (this.getBANK_SCALE3() == null ? other.getBANK_SCALE3() == null : this.getBANK_SCALE3().equals(other.getBANK_SCALE3()))
            && (this.getBANK_SCALE4() == null ? other.getBANK_SCALE4() == null : this.getBANK_SCALE4().equals(other.getBANK_SCALE4()))
            && (this.getBANK_SCALE5() == null ? other.getBANK_SCALE5() == null : this.getBANK_SCALE5().equals(other.getBANK_SCALE5()))
            && (this.getBANK_SCALE6() == null ? other.getBANK_SCALE6() == null : this.getBANK_SCALE6().equals(other.getBANK_SCALE6()))
            && (this.getBANK_SCALE7() == null ? other.getBANK_SCALE7() == null : this.getBANK_SCALE7().equals(other.getBANK_SCALE7()))
            && (this.getBANK_SCALE8() == null ? other.getBANK_SCALE8() == null : this.getBANK_SCALE8().equals(other.getBANK_SCALE8()))
            && (this.getBANK_SCALE9() == null ? other.getBANK_SCALE9() == null : this.getBANK_SCALE9().equals(other.getBANK_SCALE9()))
            && (this.getBANK_SCALE10() == null ? other.getBANK_SCALE10() == null : this.getBANK_SCALE10().equals(other.getBANK_SCALE10()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getORG_NUM() == null) ? 0 : getORG_NUM().hashCode());
        result = prime * result + ((getUSER_NUM() == null) ? 0 : getUSER_NUM().hashCode());
        result = prime * result + ((getPARTY_ID() == null) ? 0 : getPARTY_ID().hashCode());
        result = prime * result + ((getCREATE_TIME() == null) ? 0 : getCREATE_TIME().hashCode());
        result = prime * result + ((getCOUNT_BORE_ENTER_SCALE() == null) ? 0 : getCOUNT_BORE_ENTER_SCALE().hashCode());
        result = prime * result + ((getOLD_COUNT_BORE_ENTER_SCALE() == null) ? 0 : getOLD_COUNT_BORE_ENTER_SCALE().hashCode());
        result = prime * result + ((getBANK_SCALE1() == null) ? 0 : getBANK_SCALE1().hashCode());
        result = prime * result + ((getBANK_SCALE2() == null) ? 0 : getBANK_SCALE2().hashCode());
        result = prime * result + ((getBANK_SCALE3() == null) ? 0 : getBANK_SCALE3().hashCode());
        result = prime * result + ((getBANK_SCALE4() == null) ? 0 : getBANK_SCALE4().hashCode());
        result = prime * result + ((getBANK_SCALE5() == null) ? 0 : getBANK_SCALE5().hashCode());
        result = prime * result + ((getBANK_SCALE6() == null) ? 0 : getBANK_SCALE6().hashCode());
        result = prime * result + ((getBANK_SCALE7() == null) ? 0 : getBANK_SCALE7().hashCode());
        result = prime * result + ((getBANK_SCALE8() == null) ? 0 : getBANK_SCALE8().hashCode());
        result = prime * result + ((getBANK_SCALE9() == null) ? 0 : getBANK_SCALE9().hashCode());
        result = prime * result + ((getBANK_SCALE10() == null) ? 0 : getBANK_SCALE10().hashCode());
        return result;
    }
}