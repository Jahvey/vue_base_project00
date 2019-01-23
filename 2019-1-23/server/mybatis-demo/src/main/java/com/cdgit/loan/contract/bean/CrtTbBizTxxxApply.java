package com.cdgit.loan.contract.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 	TB_BIZ_TXXX_APPLY	:贴现票据信息
 * @author Administrator
 *
 */
public class CrtTbBizTxxxApply {
	
    private String applyDetailId;			//业务明细的唯一标识(主键)

    private String loanid;					//放款id

    private String contractId;				//合同ID

    private String billbatch;				//批次号

    private String billno;					//汇票号码

    private String currsign;				//币种

    private BigDecimal billamt;				//票面金额

    private Date billbegindate;				//出票日期

    private Date billenddate;				//到期日期

    private String billaddtype;				//票据签发地

    private String takeoutacname;			//出票人全称

    private String takeoutacbankno;			//出票人开户行行号

    private String takeoutacbankname;		//出票人开户行名称

    private String takeoutacno;				//出票人开户行账号

    private String benename;				//收款人名称

    private String benebankno;				//收款人开户行行号

    private String benebankname;			//收款人开户行名称

    private String beneno;					//收款人开户行账号

    private String billbanktype;			//承兑行类型

    private String billbankno;				//承兑行行号

    private String billbankname;			//承兑行名称

    private String direfrontname;			//直接前手全称

    private Long discbenum;					//被书次数

    private String contimageno;				//影像编号

    private String queryresult;				//查询查复结论

    private String reviewresult;			//审查结论

    private String reviewoption;			//审查意见说明

    private String reviewer;				//验票员

    private String reviewerorg;				//验票机构

    private String lastchanperson;			//最后修改人

    private String lastchanbankid;			//最后操作机构

    private Date lastchandate;				//最后修改时间

    private String billtype;				//汇票类型

    private String billmodel;				//汇票模式

    private Short adjustnum;				//调整天数

    private Date billtrueenddate;			//实际到期日期

    private BigDecimal interate;			//利率

    private String onlinemark;				//线上清算标识

    private String billacno;				//承兑人账号

    private String forbidflag;				//禁止背书标记

    private String billacname;				//承兑人全称

    private Date createTime;				//创建时间

    private Date updateTime;				//更新时间

    private String amountDetailId;			//额度申请明细ID

    private String ifSameCity;				//是否同城

    private BigDecimal sortOrder;			//排序序号

    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId == null ? null : applyDetailId.trim();
    }

    public String getLoanid() {
        return loanid;
    }

    public void setLoanid(String loanid) {
        this.loanid = loanid == null ? null : loanid.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getBillbatch() {
        return billbatch;
    }

    public void setBillbatch(String billbatch) {
        this.billbatch = billbatch == null ? null : billbatch.trim();
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public String getCurrsign() {
        return currsign;
    }

    public void setCurrsign(String currsign) {
        this.currsign = currsign == null ? null : currsign.trim();
    }

    public BigDecimal getBillamt() {
        return billamt;
    }

    public void setBillamt(BigDecimal billamt) {
        this.billamt = billamt;
    }

    public Date getBillbegindate() {
        return billbegindate;
    }

    public void setBillbegindate(Date billbegindate) {
        this.billbegindate = billbegindate;
    }

    public Date getBillenddate() {
        return billenddate;
    }

    public void setBillenddate(Date billenddate) {
        this.billenddate = billenddate;
    }

    public String getBilladdtype() {
        return billaddtype;
    }

    public void setBilladdtype(String billaddtype) {
        this.billaddtype = billaddtype == null ? null : billaddtype.trim();
    }

    public String getTakeoutacname() {
        return takeoutacname;
    }

    public void setTakeoutacname(String takeoutacname) {
        this.takeoutacname = takeoutacname == null ? null : takeoutacname.trim();
    }

    public String getTakeoutacbankno() {
        return takeoutacbankno;
    }

    public void setTakeoutacbankno(String takeoutacbankno) {
        this.takeoutacbankno = takeoutacbankno == null ? null : takeoutacbankno.trim();
    }

    public String getTakeoutacbankname() {
        return takeoutacbankname;
    }

    public void setTakeoutacbankname(String takeoutacbankname) {
        this.takeoutacbankname = takeoutacbankname == null ? null : takeoutacbankname.trim();
    }

    public String getTakeoutacno() {
        return takeoutacno;
    }

    public void setTakeoutacno(String takeoutacno) {
        this.takeoutacno = takeoutacno == null ? null : takeoutacno.trim();
    }

    public String getBenename() {
        return benename;
    }

    public void setBenename(String benename) {
        this.benename = benename == null ? null : benename.trim();
    }

    public String getBenebankno() {
        return benebankno;
    }

    public void setBenebankno(String benebankno) {
        this.benebankno = benebankno == null ? null : benebankno.trim();
    }

    public String getBenebankname() {
        return benebankname;
    }

    public void setBenebankname(String benebankname) {
        this.benebankname = benebankname == null ? null : benebankname.trim();
    }

    public String getBeneno() {
        return beneno;
    }

    public void setBeneno(String beneno) {
        this.beneno = beneno == null ? null : beneno.trim();
    }

    public String getBillbanktype() {
        return billbanktype;
    }

    public void setBillbanktype(String billbanktype) {
        this.billbanktype = billbanktype == null ? null : billbanktype.trim();
    }

    public String getBillbankno() {
        return billbankno;
    }

    public void setBillbankno(String billbankno) {
        this.billbankno = billbankno == null ? null : billbankno.trim();
    }

    public String getBillbankname() {
        return billbankname;
    }

    public void setBillbankname(String billbankname) {
        this.billbankname = billbankname == null ? null : billbankname.trim();
    }

    public String getDirefrontname() {
        return direfrontname;
    }

    public void setDirefrontname(String direfrontname) {
        this.direfrontname = direfrontname == null ? null : direfrontname.trim();
    }

    public Long getDiscbenum() {
        return discbenum;
    }

    public void setDiscbenum(Long discbenum) {
        this.discbenum = discbenum;
    }

    public String getContimageno() {
        return contimageno;
    }

    public void setContimageno(String contimageno) {
        this.contimageno = contimageno == null ? null : contimageno.trim();
    }

    public String getQueryresult() {
        return queryresult;
    }

    public void setQueryresult(String queryresult) {
        this.queryresult = queryresult == null ? null : queryresult.trim();
    }

    public String getReviewresult() {
        return reviewresult;
    }

    public void setReviewresult(String reviewresult) {
        this.reviewresult = reviewresult == null ? null : reviewresult.trim();
    }

    public String getReviewoption() {
        return reviewoption;
    }

    public void setReviewoption(String reviewoption) {
        this.reviewoption = reviewoption == null ? null : reviewoption.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public String getReviewerorg() {
        return reviewerorg;
    }

    public void setReviewerorg(String reviewerorg) {
        this.reviewerorg = reviewerorg == null ? null : reviewerorg.trim();
    }

    public String getLastchanperson() {
        return lastchanperson;
    }

    public void setLastchanperson(String lastchanperson) {
        this.lastchanperson = lastchanperson == null ? null : lastchanperson.trim();
    }

    public String getLastchanbankid() {
        return lastchanbankid;
    }

    public void setLastchanbankid(String lastchanbankid) {
        this.lastchanbankid = lastchanbankid == null ? null : lastchanbankid.trim();
    }

    public Date getLastchandate() {
        return lastchandate;
    }

    public void setLastchandate(Date lastchandate) {
        this.lastchandate = lastchandate;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype == null ? null : billtype.trim();
    }

    public String getBillmodel() {
        return billmodel;
    }

    public void setBillmodel(String billmodel) {
        this.billmodel = billmodel == null ? null : billmodel.trim();
    }

    public Short getAdjustnum() {
        return adjustnum;
    }

    public void setAdjustnum(Short adjustnum) {
        this.adjustnum = adjustnum;
    }

    public Date getBilltrueenddate() {
        return billtrueenddate;
    }

    public void setBilltrueenddate(Date billtrueenddate) {
        this.billtrueenddate = billtrueenddate;
    }

    public BigDecimal getInterate() {
        return interate;
    }

    public void setInterate(BigDecimal interate) {
        this.interate = interate;
    }

    public String getOnlinemark() {
        return onlinemark;
    }

    public void setOnlinemark(String onlinemark) {
        this.onlinemark = onlinemark == null ? null : onlinemark.trim();
    }

    public String getBillacno() {
        return billacno;
    }

    public void setBillacno(String billacno) {
        this.billacno = billacno == null ? null : billacno.trim();
    }

    public String getForbidflag() {
        return forbidflag;
    }

    public void setForbidflag(String forbidflag) {
        this.forbidflag = forbidflag == null ? null : forbidflag.trim();
    }

    public String getBillacname() {
        return billacname;
    }

    public void setBillacname(String billacname) {
        this.billacname = billacname == null ? null : billacname.trim();
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

    public String getIfSameCity() {
        return ifSameCity;
    }

    public void setIfSameCity(String ifSameCity) {
        this.ifSameCity = ifSameCity == null ? null : ifSameCity.trim();
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }
}