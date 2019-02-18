package com.cdgit.loan.securitymanagement.bean;
/**
 * 基金bean
 * @author wuyong
 * @date 2019.1.10
 *
 */
public class GrtFund {
    private String guarantyId;

    private String fundCd;

    private String fundCorpName;

    private String fundTypeCd;

    private String stockHolderCd;

    private String seatCd;

    public String getGuarantyId() {
        return guarantyId;
    }

    public void setGuarantyId(String guarantyId) {
        this.guarantyId = guarantyId == null ? null : guarantyId.trim();
    }

    public String getFundCd() {
        return fundCd;
    }

    public void setFundCd(String fundCd) {
        this.fundCd = fundCd == null ? null : fundCd.trim();
    }

    public String getFundCorpName() {
        return fundCorpName;
    }

    public void setFundCorpName(String fundCorpName) {
        this.fundCorpName = fundCorpName == null ? null : fundCorpName.trim();
    }

    public String getFundTypeCd() {
        return fundTypeCd;
    }

    public void setFundTypeCd(String fundTypeCd) {
        this.fundTypeCd = fundTypeCd == null ? null : fundTypeCd.trim();
    }

    public String getStockHolderCd() {
        return stockHolderCd;
    }

    public void setStockHolderCd(String stockHolderCd) {
        this.stockHolderCd = stockHolderCd == null ? null : stockHolderCd.trim();
    }

    public String getSeatCd() {
        return seatCd;
    }

    public void setSeatCd(String seatCd) {
        this.seatCd = seatCd == null ? null : seatCd.trim();
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
        GrtFund other = (GrtFund) that;
        return (this.getGuarantyId() == null ? other.getGuarantyId() == null : this.getGuarantyId().equals(other.getGuarantyId()))
            && (this.getFundCd() == null ? other.getFundCd() == null : this.getFundCd().equals(other.getFundCd()))
            && (this.getFundCorpName() == null ? other.getFundCorpName() == null : this.getFundCorpName().equals(other.getFundCorpName()))
            && (this.getFundTypeCd() == null ? other.getFundTypeCd() == null : this.getFundTypeCd().equals(other.getFundTypeCd()))
            && (this.getStockHolderCd() == null ? other.getStockHolderCd() == null : this.getStockHolderCd().equals(other.getStockHolderCd()))
            && (this.getSeatCd() == null ? other.getSeatCd() == null : this.getSeatCd().equals(other.getSeatCd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuarantyId() == null) ? 0 : getGuarantyId().hashCode());
        result = prime * result + ((getFundCd() == null) ? 0 : getFundCd().hashCode());
        result = prime * result + ((getFundCorpName() == null) ? 0 : getFundCorpName().hashCode());
        result = prime * result + ((getFundTypeCd() == null) ? 0 : getFundTypeCd().hashCode());
        result = prime * result + ((getStockHolderCd() == null) ? 0 : getStockHolderCd().hashCode());
        result = prime * result + ((getSeatCd() == null) ? 0 : getSeatCd().hashCode());
        return result;
    }
}