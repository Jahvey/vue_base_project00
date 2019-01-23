package com.cdgit.ledger.pubquery.bean ;

public class ChTbLoanZh {
    private String id;

    private String zhbs;

    private String zhlx;

    private String kzbs;

    private String zh;

    private String zhkhjg;

    private String zhmc;

    private String loanId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getZhbs() {
        return zhbs;
    }

    public void setZhbs(String zhbs) {
        this.zhbs = zhbs == null ? null : zhbs.trim();
    }

    public String getZhlx() {
        return zhlx;
    }

    public void setZhlx(String zhlx) {
        this.zhlx = zhlx == null ? null : zhlx.trim();
    }

    public String getKzbs() {
        return kzbs;
    }

    public void setKzbs(String kzbs) {
        this.kzbs = kzbs == null ? null : kzbs.trim();
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh == null ? null : zh.trim();
    }

    public String getZhkhjg() {
        return zhkhjg;
    }

    public void setZhkhjg(String zhkhjg) {
        this.zhkhjg = zhkhjg == null ? null : zhkhjg.trim();
    }

    public String getZhmc() {
        return zhmc;
    }

    public void setZhmc(String zhmc) {
        this.zhmc = zhmc == null ? null : zhmc.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
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
        ChTbLoanZh other = (ChTbLoanZh) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getZhbs() == null ? other.getZhbs() == null : this.getZhbs().equals(other.getZhbs()))
            && (this.getZhlx() == null ? other.getZhlx() == null : this.getZhlx().equals(other.getZhlx()))
            && (this.getKzbs() == null ? other.getKzbs() == null : this.getKzbs().equals(other.getKzbs()))
            && (this.getZh() == null ? other.getZh() == null : this.getZh().equals(other.getZh()))
            && (this.getZhkhjg() == null ? other.getZhkhjg() == null : this.getZhkhjg().equals(other.getZhkhjg()))
            && (this.getZhmc() == null ? other.getZhmc() == null : this.getZhmc().equals(other.getZhmc()))
            && (this.getLoanId() == null ? other.getLoanId() == null : this.getLoanId().equals(other.getLoanId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getZhbs() == null) ? 0 : getZhbs().hashCode());
        result = prime * result + ((getZhlx() == null) ? 0 : getZhlx().hashCode());
        result = prime * result + ((getKzbs() == null) ? 0 : getKzbs().hashCode());
        result = prime * result + ((getZh() == null) ? 0 : getZh().hashCode());
        result = prime * result + ((getZhkhjg() == null) ? 0 : getZhkhjg().hashCode());
        result = prime * result + ((getZhmc() == null) ? 0 : getZhmc().hashCode());
        result = prime * result + ((getLoanId() == null) ? 0 : getLoanId().hashCode());
        return result;
    }
}