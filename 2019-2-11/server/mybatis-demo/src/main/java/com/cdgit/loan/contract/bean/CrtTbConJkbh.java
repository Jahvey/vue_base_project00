package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 22-进口保函批复		TB_CON_JKBH	
 * @author Administrator
 *
 */
public class CrtTbConJkbh {
	
    private String applyDetailId;				//业务明细的唯一标识（主键）

    private Date createTime;					//创建时间

    private Date updateTime;					//更新时间

    private String amountDetailId;				//额度申请明细ID

    private BigDecimal bzjblbdy;				//保证金比例不低于

    private String contractId;					//合同ID

    private Date bhyxq;							//保函有效期

    private String syrmc;						//受益人名称

    private String bdbrmc;						//被担保人名称

    private BigDecimal dkll;					//垫款利率(日利率、万分之)

    private String bhlx;						//保函类型(:XD_SXYW0235)

    private Date klrq;							//开立日期

    private Date dqrq;							//到期日期

    private BigDecimal myhtje;					//贸易合同金额

    private String myhth;						//贸易合同号

    private String syr;							//受益人

    private String bzjzh;						//保证金账户

    private BigDecimal bzjje;					//保证金金额

    private String bzjbz;						//保证金币种

    private String jyq;							//即期/远期(XD_SXYW0208)

    private String yqts;						//远期天数

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

    public BigDecimal getBzjblbdy() {
        return bzjblbdy;
    }

    public void setBzjblbdy(BigDecimal bzjblbdy) {
        this.bzjblbdy = bzjblbdy;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public Date getBhyxq() {
        return bhyxq;
    }

    public void setBhyxq(Date bhyxq) {
        this.bhyxq = bhyxq;
    }

    public String getSyrmc() {
        return syrmc;
    }

    public void setSyrmc(String syrmc) {
        this.syrmc = syrmc == null ? null : syrmc.trim();
    }

    public String getBdbrmc() {
        return bdbrmc;
    }

    public void setBdbrmc(String bdbrmc) {
        this.bdbrmc = bdbrmc == null ? null : bdbrmc.trim();
    }

    public BigDecimal getDkll() {
        return dkll;
    }

    public void setDkll(BigDecimal dkll) {
        this.dkll = dkll;
    }

    public String getBhlx() {
        return bhlx;
    }

    public void setBhlx(String bhlx) {
        this.bhlx = bhlx == null ? null : bhlx.trim();
    }

    public Date getKlrq() {
        return klrq;
    }

    public void setKlrq(Date klrq) {
        this.klrq = klrq;
    }

    public Date getDqrq() {
        return dqrq;
    }

    public void setDqrq(Date dqrq) {
        this.dqrq = dqrq;
    }

    public BigDecimal getMyhtje() {
        return myhtje;
    }

    public void setMyhtje(BigDecimal myhtje) {
        this.myhtje = myhtje;
    }

    public String getMyhth() {
        return myhth;
    }

    public void setMyhth(String myhth) {
        this.myhth = myhth == null ? null : myhth.trim();
    }

    public String getSyr() {
        return syr;
    }

    public void setSyr(String syr) {
        this.syr = syr == null ? null : syr.trim();
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
}