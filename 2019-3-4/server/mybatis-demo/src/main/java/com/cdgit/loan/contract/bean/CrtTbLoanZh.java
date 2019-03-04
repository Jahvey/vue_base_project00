package com.cdgit.loan.contract.bean;

/**
 * 	Tb_Loan_Zh 放款账户信息表
 * @author Administrator
 *
 */
public class CrtTbLoanZh {
	
    private String id;					//主键

    private String zhbs;				//账户标识(:XD_SXYW0219)

    private String zhlx;				//账户类型(:XD_ZHLX10001)

    private String kzbs;				//卡折标识(:XD_SXYW0220)

    private String zh;					//账号

    private String zhkhjg;				//账号开户机构

    private String zhmc;				//账户名称

    private String loanId;				//放款ID

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
}