package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 国际信用证开证	tb_Con_Gjxyzkz
 * @author Administrator
 *
 */
public class CrtTbConGjxyzkz {
	
    private String applyDetailId;		//业务明细的唯一标识ID(主键)

    private Date createTime;			//创建时间

    private Date updateTime;			//更新时间

    private String amountDetailId;		//额度申请明细ID

    private String contractId;			//合同ID

    private String jyq;					//即期/远期(:XD_SXYW0208)

    private String yqts;				//逾期天数

    private Date dqrq;					//到期日期

    private BigDecimal yzbl;			//溢装比例

    private BigDecimal dzbl;			//短装比例

    private String bzjzh;				//保证金账户

    private BigDecimal bzjje;			//保证金金额

    private String bzjbz;				//保证金币种

    private BigDecimal bzjblbdy;		//保证金比例不低于

    private String myhth;				//贸易合同号

    private BigDecimal myhtje;			//贸易合同金额

    private String gngjz;				//国内/国际证

    private BigDecimal dkll;			//垫款利率(日利率、万分之)

    private String rzzh;				//入账账号

    private String ywhm;				//业务号码

    private String fph;					//发票号

    private BigDecimal kzje;			//信用证开证金额

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAmountDetailId() {
        return amountDetailId;
    }

    public void setAmountDetailId(String amountDetailId) {
        this.amountDetailId = amountDetailId == null ? null : amountDetailId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getJyq() {
        return jyq;
    }

    public void setJyq(String jyq) {
        this.jyq = jyq == null ? null : jyq.trim();
    }

    public String getYqts() {
        return yqts;
    }

    public void setYqts(String yqts) {
        this.yqts = yqts == null ? null : yqts.trim();
    }

    public Date getDqrq() {
        return dqrq;
    }

    public void setDqrq(Date dqrq) {
        this.dqrq = dqrq;
    }

    public BigDecimal getYzbl() {
        return yzbl;
    }

    public void setYzbl(BigDecimal yzbl) {
        this.yzbl = yzbl;
    }

    public BigDecimal getDzbl() {
        return dzbl;
    }

    public void setDzbl(BigDecimal dzbl) {
        this.dzbl = dzbl;
    }

    public String getBzjzh() {
        return bzjzh;
    }

    public void setBzjzh(String bzjzh) {
        this.bzjzh = bzjzh == null ? null : bzjzh.trim();
    }

    public BigDecimal getBzjje() {
        return bzjje;
    }

    public void setBzjje(BigDecimal bzjje) {
        this.bzjje = bzjje;
    }

    public String getBzjbz() {
        return bzjbz;
    }

    public void setBzjbz(String bzjbz) {
        this.bzjbz = bzjbz == null ? null : bzjbz.trim();
    }

    public BigDecimal getBzjblbdy() {
        return bzjblbdy;
    }

    public void setBzjblbdy(BigDecimal bzjblbdy) {
        this.bzjblbdy = bzjblbdy;
    }

    public String getMyhth() {
        return myhth;
    }

    public void setMyhth(String myhth) {
        this.myhth = myhth == null ? null : myhth.trim();
    }

    public BigDecimal getMyhtje() {
        return myhtje;
    }

    public void setMyhtje(BigDecimal myhtje) {
        this.myhtje = myhtje;
    }

    public String getGngjz() {
        return gngjz;
    }

    public void setGngjz(String gngjz) {
        this.gngjz = gngjz == null ? null : gngjz.trim();
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public String getRzzh() {
        return rzzh;
    }

    public void setRzzh(String rzzh) {
        this.rzzh = rzzh == null ? null : rzzh.trim();
    }

    public String getYwhm() {
        return ywhm;
    }

    public void setYwhm(String ywhm) {
        this.ywhm = ywhm == null ? null : ywhm.trim();
    }

    public String getFph() {
        return fph;
    }

    public void setFph(String fph) {
        this.fph = fph == null ? null : fph.trim();
    }

    public BigDecimal getKzje() {
        return kzje;
    }

    public void setKzje(BigDecimal kzje) {
        this.kzje = kzje;
    }
}