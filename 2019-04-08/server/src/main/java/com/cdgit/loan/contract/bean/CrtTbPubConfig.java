package com.cdgit.loan.contract.bean;
/**
 * 配置表
 * @author Administrator
 *
 */
public class CrtTbPubConfig {
	
    private String cfgValue;

    private String cfgStatus;

    private String cfgGroup;

    private String cfgKey;

    private String other1;

    private String other2;

    private String other3;
    
    public String getCfgGroup() {
        return cfgGroup;
    }

    public void setCfgGroup(String cfgGroup) {
        this.cfgGroup = cfgGroup == null ? null : cfgGroup.trim();
    }

    public String getCfgKey() {
        return cfgKey;
    }

    public void setCfgKey(String cfgKey) {
        this.cfgKey = cfgKey == null ? null : cfgKey.trim();
    }
    
    public String getCfgValue() {
        return cfgValue;
    }

    public void setCfgValue(String cfgValue) {
        this.cfgValue = cfgValue == null ? null : cfgValue.trim();
    }

    public String getCfgStatus() {
        return cfgStatus;
    }

    public void setCfgStatus(String cfgStatus) {
        this.cfgStatus = cfgStatus == null ? null : cfgStatus.trim();
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1 == null ? null : other1.trim();
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2 == null ? null : other2.trim();
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3 == null ? null : other3.trim();
    }
}