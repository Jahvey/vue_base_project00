package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TB_BIZ_PJXX_APPLY:票据申请表,无主键和索引
 * @author Administrator
 *
 */
public class CrtTbBizPjxxApply {
	
    private String applyDetailId;			//业务明细的唯一标识(非空)

    private Date createTime;				//创建时间

    private Date updateTime;				//更新时间

    private String amountDetailId;			//额度申请明细ID(非空)

    private String cprqc;					//出票人全称

    private String cprzh;					//出票人帐号

    private String skrqc;					//收款人全称

    private String skrzh;					//收款人账户

    private String skrkhh;					//收款人开户行-无效

    private String pjhm;					//票据号码

    private String currencyCd;				//币种(:CD000001)

    private BigDecimal hpje;				//汇票金额

    private String hpxs;					//汇票形式(:XD_SXCD1123)

    private Date hpcprq;					//汇票出票日期

    private Date hpdqrq;					//汇票到期日期

    private String dfdz;					//兑付地址

    private String htbh;					//合同编号

    private String jlzt;					//记录状态(:XD_SXCD8003)

    private String remitterbankname;		//出票行行名

    private String remitterbankno;			//出票行行号

    private String payeebankname;			//收款人开户行行名

    private String payeebankno;				//收款人开户行行号

    private String acceptorbankname;		//承兑行行名

    private String acceptorbankno;			//承兑行行号

    private String billid;					//电票ID

    private String forbidflag;				//禁止背书标记

    private String contractId;				//合同ID

    private BigDecimal sortOrder;			//排序序号

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

    public String getCprqc() {
        return cprqc;
    }

    public void setCprqc(String cprqc) {
        this.cprqc = cprqc == null ? null : cprqc.trim();
    }

    public String getCprzh() {
        return cprzh;
    }

    public void setCprzh(String cprzh) {
        this.cprzh = cprzh == null ? null : cprzh.trim();
    }

    public String getSkrqc() {
        return skrqc;
    }

    public void setSkrqc(String skrqc) {
        this.skrqc = skrqc == null ? null : skrqc.trim();
    }

    public String getSkrzh() {
        return skrzh;
    }

    public void setSkrzh(String skrzh) {
        this.skrzh = skrzh == null ? null : skrzh.trim();
    }

    public String getSkrkhh() {
        return skrkhh;
    }

    public void setSkrkhh(String skrkhh) {
        this.skrkhh = skrkhh == null ? null : skrkhh.trim();
    }

    public String getPjhm() {
        return pjhm;
    }

    public void setPjhm(String pjhm) {
        this.pjhm = pjhm == null ? null : pjhm.trim();
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd == null ? null : currencyCd.trim();
    }

    public BigDecimal getHpje() {
        return hpje;
    }

    public void setHpje(BigDecimal hpje) {
        this.hpje = hpje;
    }

    public String getHpxs() {
        return hpxs;
    }

    public void setHpxs(String hpxs) {
        this.hpxs = hpxs == null ? null : hpxs.trim();
    }

    public Date getHpcprq() {
        return hpcprq;
    }

    public void setHpcprq(Date hpcprq) {
        this.hpcprq = hpcprq;
    }

    public Date getHpdqrq() {
        return hpdqrq;
    }

    public void setHpdqrq(Date hpdqrq) {
        this.hpdqrq = hpdqrq;
    }

    public String getDfdz() {
        return dfdz;
    }

    public void setDfdz(String dfdz) {
        this.dfdz = dfdz == null ? null : dfdz.trim();
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh == null ? null : htbh.trim();
    }

    public String getJlzt() {
        return jlzt;
    }

    public void setJlzt(String jlzt) {
        this.jlzt = jlzt == null ? null : jlzt.trim();
    }

    public String getRemitterbankname() {
        return remitterbankname;
    }

    public void setRemitterbankname(String remitterbankname) {
        this.remitterbankname = remitterbankname == null ? null : remitterbankname.trim();
    }

    public String getRemitterbankno() {
        return remitterbankno;
    }

    public void setRemitterbankno(String remitterbankno) {
        this.remitterbankno = remitterbankno == null ? null : remitterbankno.trim();
    }

    public String getPayeebankname() {
        return payeebankname;
    }

    public void setPayeebankname(String payeebankname) {
        this.payeebankname = payeebankname == null ? null : payeebankname.trim();
    }

    public String getPayeebankno() {
        return payeebankno;
    }

    public void setPayeebankno(String payeebankno) {
        this.payeebankno = payeebankno == null ? null : payeebankno.trim();
    }

    public String getAcceptorbankname() {
        return acceptorbankname;
    }

    public void setAcceptorbankname(String acceptorbankname) {
        this.acceptorbankname = acceptorbankname == null ? null : acceptorbankname.trim();
    }

    public String getAcceptorbankno() {
        return acceptorbankno;
    }

    public void setAcceptorbankno(String acceptorbankno) {
        this.acceptorbankno = acceptorbankno == null ? null : acceptorbankno.trim();
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid == null ? null : billid.trim();
    }

    public String getForbidflag() {
        return forbidflag;
    }

    public void setForbidflag(String forbidflag) {
        this.forbidflag = forbidflag == null ? null : forbidflag.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }
}