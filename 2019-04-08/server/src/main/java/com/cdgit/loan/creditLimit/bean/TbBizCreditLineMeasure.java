package com.cdgit.loan.creditLimit.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TbBizCreditLineMeasure {
    private String id;

    private Date meaDate;

    private String userNum;

    private String orgNum;

    private BigDecimal b1;

    private BigDecimal b2;

    private BigDecimal b3;

    private BigDecimal b4;

    private BigDecimal b5;

    private BigDecimal b6;

    private BigDecimal b7;

    private BigDecimal b8;

    private BigDecimal b9;

    private BigDecimal b10;

    private BigDecimal b11;

    private BigDecimal b12;

    private BigDecimal b13;

    private String b14;

    private BigDecimal b15;

    private BigDecimal b16;

    private BigDecimal b17;

    private BigDecimal b18;

    private BigDecimal b19;

    private BigDecimal b20;

    private BigDecimal b21;

    private BigDecimal b22;

    private BigDecimal b23;

    private BigDecimal b24;

    private BigDecimal b25;

    private BigDecimal b11x;

    private BigDecimal b26;

    private String crdId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getMeaDate() {
        return meaDate;
    }

    public void setMeaDate(Date meaDate) {
        this.meaDate = meaDate;
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

    public BigDecimal getB1() {
        return b1;
    }

    public void setB1(BigDecimal b1) {
        this.b1 = b1;
    }

    public BigDecimal getB2() {
        return b2;
    }

    public void setB2(BigDecimal b2) {
        this.b2 = b2;
    }

    public BigDecimal getB3() {
        return b3;
    }

    public void setB3(BigDecimal b3) {
        this.b3 = b3;
    }

    public BigDecimal getB4() {
        return b4;
    }

    public void setB4(BigDecimal b4) {
        this.b4 = b4;
    }

    public BigDecimal getB5() {
        return b5;
    }

    public void setB5(BigDecimal b5) {
        this.b5 = b5;
    }

    public BigDecimal getB6() {
        return b6;
    }

    public void setB6(BigDecimal b6) {
        this.b6 = b6;
    }

    public BigDecimal getB7() {
        return b7;
    }

    public void setB7(BigDecimal b7) {
        this.b7 = b7;
    }

    public BigDecimal getB8() {
        return b8;
    }

    public void setB8(BigDecimal b8) {
        this.b8 = b8;
    }

    public BigDecimal getB9() {
        return b9;
    }

    public void setB9(BigDecimal b9) {
        this.b9 = b9;
    }

    public BigDecimal getB10() {
        return b10;
    }

    public void setB10(BigDecimal b10) {
        this.b10 = b10;
    }

    public BigDecimal getB11() {
        return b11;
    }

    public void setB11(BigDecimal b11) {
        this.b11 = b11;
    }

    public BigDecimal getB12() {
        return b12;
    }

    public void setB12(BigDecimal b12) {
        this.b12 = b12;
    }

    public BigDecimal getB13() {
        return b13;
    }

    public void setB13(BigDecimal b13) {
        this.b13 = b13;
    }

    public String getB14() {
        return b14;
    }

    public void setB14(String b14) {
        this.b14 = b14 == null ? null : b14.trim();
    }

    public BigDecimal getB15() {
        return b15;
    }

    public void setB15(BigDecimal b15) {
        this.b15 = b15;
    }

    public BigDecimal getB16() {
        return b16;
    }

    public void setB16(BigDecimal b16) {
        this.b16 = b16;
    }

    public BigDecimal getB17() {
        return b17;
    }

    public void setB17(BigDecimal b17) {
        this.b17 = b17;
    }

    public BigDecimal getB18() {
        return b18;
    }

    public void setB18(BigDecimal b18) {
        this.b18 = b18;
    }

    public BigDecimal getB19() {
        return b19;
    }

    public void setB19(BigDecimal b19) {
        this.b19 = b19;
    }

    public BigDecimal getB20() {
        return b20;
    }

    public void setB20(BigDecimal b20) {
        this.b20 = b20;
    }

    public BigDecimal getB21() {
        return b21;
    }

    public void setB21(BigDecimal b21) {
        this.b21 = b21;
    }

    public BigDecimal getB22() {
        return b22;
    }

    public void setB22(BigDecimal b22) {
        this.b22 = b22;
    }

    public BigDecimal getB23() {
        return b23;
    }

    public void setB23(BigDecimal b23) {
        this.b23 = b23;
    }

    public BigDecimal getB24() {
        return b24;
    }

    public void setB24(BigDecimal b24) {
        this.b24 = b24;
    }

    public BigDecimal getB25() {
        return b25;
    }

    public void setB25(BigDecimal b25) {
        this.b25 = b25;
    }

    public BigDecimal getB11x() {
        return b11x;
    }

    public void setB11x(BigDecimal b11x) {
        this.b11x = b11x;
    }

    public BigDecimal getB26() {
        return b26;
    }

    public void setB26(BigDecimal b26) {
        this.b26 = b26;
    }

    public String getCrdId() {
        return crdId;
    }

    public void setCrdId(String crdId) {
        this.crdId = crdId == null ? null : crdId.trim();
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
        TbBizCreditLineMeasure other = (TbBizCreditLineMeasure) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMeaDate() == null ? other.getMeaDate() == null : this.getMeaDate().equals(other.getMeaDate()))
            && (this.getUserNum() == null ? other.getUserNum() == null : this.getUserNum().equals(other.getUserNum()))
            && (this.getOrgNum() == null ? other.getOrgNum() == null : this.getOrgNum().equals(other.getOrgNum()))
            && (this.getB1() == null ? other.getB1() == null : this.getB1().equals(other.getB1()))
            && (this.getB2() == null ? other.getB2() == null : this.getB2().equals(other.getB2()))
            && (this.getB3() == null ? other.getB3() == null : this.getB3().equals(other.getB3()))
            && (this.getB4() == null ? other.getB4() == null : this.getB4().equals(other.getB4()))
            && (this.getB5() == null ? other.getB5() == null : this.getB5().equals(other.getB5()))
            && (this.getB6() == null ? other.getB6() == null : this.getB6().equals(other.getB6()))
            && (this.getB7() == null ? other.getB7() == null : this.getB7().equals(other.getB7()))
            && (this.getB8() == null ? other.getB8() == null : this.getB8().equals(other.getB8()))
            && (this.getB9() == null ? other.getB9() == null : this.getB9().equals(other.getB9()))
            && (this.getB10() == null ? other.getB10() == null : this.getB10().equals(other.getB10()))
            && (this.getB11() == null ? other.getB11() == null : this.getB11().equals(other.getB11()))
            && (this.getB12() == null ? other.getB12() == null : this.getB12().equals(other.getB12()))
            && (this.getB13() == null ? other.getB13() == null : this.getB13().equals(other.getB13()))
            && (this.getB14() == null ? other.getB14() == null : this.getB14().equals(other.getB14()))
            && (this.getB15() == null ? other.getB15() == null : this.getB15().equals(other.getB15()))
            && (this.getB16() == null ? other.getB16() == null : this.getB16().equals(other.getB16()))
            && (this.getB17() == null ? other.getB17() == null : this.getB17().equals(other.getB17()))
            && (this.getB18() == null ? other.getB18() == null : this.getB18().equals(other.getB18()))
            && (this.getB19() == null ? other.getB19() == null : this.getB19().equals(other.getB19()))
            && (this.getB20() == null ? other.getB20() == null : this.getB20().equals(other.getB20()))
            && (this.getB21() == null ? other.getB21() == null : this.getB21().equals(other.getB21()))
            && (this.getB22() == null ? other.getB22() == null : this.getB22().equals(other.getB22()))
            && (this.getB23() == null ? other.getB23() == null : this.getB23().equals(other.getB23()))
            && (this.getB24() == null ? other.getB24() == null : this.getB24().equals(other.getB24()))
            && (this.getB25() == null ? other.getB25() == null : this.getB25().equals(other.getB25()))
            && (this.getB11x() == null ? other.getB11x() == null : this.getB11x().equals(other.getB11x()))
            && (this.getB26() == null ? other.getB26() == null : this.getB26().equals(other.getB26()))
            && (this.getCrdId() == null ? other.getCrdId() == null : this.getCrdId().equals(other.getCrdId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMeaDate() == null) ? 0 : getMeaDate().hashCode());
        result = prime * result + ((getUserNum() == null) ? 0 : getUserNum().hashCode());
        result = prime * result + ((getOrgNum() == null) ? 0 : getOrgNum().hashCode());
        result = prime * result + ((getB1() == null) ? 0 : getB1().hashCode());
        result = prime * result + ((getB2() == null) ? 0 : getB2().hashCode());
        result = prime * result + ((getB3() == null) ? 0 : getB3().hashCode());
        result = prime * result + ((getB4() == null) ? 0 : getB4().hashCode());
        result = prime * result + ((getB5() == null) ? 0 : getB5().hashCode());
        result = prime * result + ((getB6() == null) ? 0 : getB6().hashCode());
        result = prime * result + ((getB7() == null) ? 0 : getB7().hashCode());
        result = prime * result + ((getB8() == null) ? 0 : getB8().hashCode());
        result = prime * result + ((getB9() == null) ? 0 : getB9().hashCode());
        result = prime * result + ((getB10() == null) ? 0 : getB10().hashCode());
        result = prime * result + ((getB11() == null) ? 0 : getB11().hashCode());
        result = prime * result + ((getB12() == null) ? 0 : getB12().hashCode());
        result = prime * result + ((getB13() == null) ? 0 : getB13().hashCode());
        result = prime * result + ((getB14() == null) ? 0 : getB14().hashCode());
        result = prime * result + ((getB15() == null) ? 0 : getB15().hashCode());
        result = prime * result + ((getB16() == null) ? 0 : getB16().hashCode());
        result = prime * result + ((getB17() == null) ? 0 : getB17().hashCode());
        result = prime * result + ((getB18() == null) ? 0 : getB18().hashCode());
        result = prime * result + ((getB19() == null) ? 0 : getB19().hashCode());
        result = prime * result + ((getB20() == null) ? 0 : getB20().hashCode());
        result = prime * result + ((getB21() == null) ? 0 : getB21().hashCode());
        result = prime * result + ((getB22() == null) ? 0 : getB22().hashCode());
        result = prime * result + ((getB23() == null) ? 0 : getB23().hashCode());
        result = prime * result + ((getB24() == null) ? 0 : getB24().hashCode());
        result = prime * result + ((getB25() == null) ? 0 : getB25().hashCode());
        result = prime * result + ((getB11x() == null) ? 0 : getB11x().hashCode());
        result = prime * result + ((getB26() == null) ? 0 : getB26().hashCode());
        result = prime * result + ((getCrdId() == null) ? 0 : getCrdId().hashCode());
        return result;
    }
}