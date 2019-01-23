package com.cdgit.loan.customerManage.illegalRecord.bean;

public class IllegalRecordKey {
    private String summaryNum;

    private String currPeri;

    public String getSummaryNum() {
        return summaryNum;
    }

    public void setSummaryNum(String summaryNum) {
        this.summaryNum = summaryNum == null ? null : summaryNum.trim();
    }

    public String getCurrPeri() {
        return currPeri;
    }

    public void setCurrPeri(String currPeri) {
        this.currPeri = currPeri == null ? null : currPeri.trim();
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
        IllegalRecordKey other = (IllegalRecordKey) that;
        return (this.getSummaryNum() == null ? other.getSummaryNum() == null : this.getSummaryNum().equals(other.getSummaryNum()))
            && (this.getCurrPeri() == null ? other.getCurrPeri() == null : this.getCurrPeri().equals(other.getCurrPeri()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSummaryNum() == null) ? 0 : getSummaryNum().hashCode());
        result = prime * result + ((getCurrPeri() == null) ? 0 : getCurrPeri().hashCode());
        return result;
    }
}