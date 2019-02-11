/**
 * 
 */
package com.cdgit.loan.csm.po;

/**
 * @author Administrator
 *
 */
public class TbBizSummaryPo {
    private String id;

    private String applyId;

    private String summaryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(String summaryId) {
        this.summaryId = summaryId == null ? null : summaryId.trim();
    }

}
