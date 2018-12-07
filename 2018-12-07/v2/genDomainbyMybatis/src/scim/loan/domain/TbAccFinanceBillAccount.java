package scim.loan.domain;

public class TbAccFinanceBillAccount {
    private String billAccountId;

    private String financeId;

    private String billKhh;

    private String billZhmc;

    private String billZh;

    public String getBillAccountId() {
        return billAccountId;
    }

    public void setBillAccountId(String billAccountId) {
        this.billAccountId = billAccountId == null ? null : billAccountId.trim();
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId == null ? null : financeId.trim();
    }

    public String getBillKhh() {
        return billKhh;
    }

    public void setBillKhh(String billKhh) {
        this.billKhh = billKhh == null ? null : billKhh.trim();
    }

    public String getBillZhmc() {
        return billZhmc;
    }

    public void setBillZhmc(String billZhmc) {
        this.billZhmc = billZhmc == null ? null : billZhmc.trim();
    }

    public String getBillZh() {
        return billZh;
    }

    public void setBillZh(String billZh) {
        this.billZh = billZh == null ? null : billZh.trim();
    }
}